package com.haoyukeji.tms.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.github.pagehelper.util.StringUtil;
import com.haoyukeji.tms.entity.*;
import com.haoyukeji.tms.exception.ServiceException;
import com.haoyukeji.tms.mapper.StoreMapper;
import com.haoyukeji.tms.mapper.TicketInStockMapper;
import com.haoyukeji.tms.mapper.TicketMapper;
import com.haoyukeji.tms.mapper.TicketOutStoreMapper;
import com.haoyukeji.tms.service.TicketService;
import com.haoyukeji.tms.util.ShiroUtil;
import org.joda.time.DateTime;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

@Service
public class TicketServiceImpl implements TicketService {

    private Logger logger = LoggerFactory.getLogger(TicketServiceImpl.class);

    @Autowired
    private TicketInStockMapper ticketInStockMapper;
    @Autowired
    private ShiroUtil shiroUtil;
    @Autowired
    private TicketMapper ticketMapper;
    @Autowired
    private StoreMapper storeMapper;
    @Autowired
    private TicketOutStoreMapper ticketOutStoreMapper;


    /**
     * 新增入库
     * @param ticketInStock
     */
    @Override
    @Transactional(rollbackFor = RuntimeException.class)
    public void saveTicketInStore(TicketInStock ticketInStock) throws ServiceException{
        BigInteger start = new BigInteger(ticketInStock.getInStockStart());
        BigInteger end = new BigInteger(ticketInStock.getInStockEnd());

        if (start.compareTo(end) >= 0) {
            throw new ServiceException("票号输入有误，截至票号大于等于起始票号");
        }
        //判断区间是否重复
        TicketInStockExample ticketInStockExample = new TicketInStockExample();
        List<TicketInStock> ticketInStockList = ticketInStockMapper.selectByExample(ticketInStockExample);
        for (TicketInStock inStock : ticketInStockList) {
            BigInteger storeStart = new BigInteger(inStock.getInStockStart());
            BigInteger storeEnd = new BigInteger(inStock.getInStockEnd());
            if ((storeStart.compareTo(start) <= 0 && storeEnd.compareTo(start) >=0) || (storeStart.compareTo(end) <= 0 && storeEnd.compareTo(end) >= 0)) {
                throw new ServiceException("区间重复，添加失败");
            }
        }

        //入库时间
        ticketInStock.setCreateTime(new Date());
        //入库总数量
        BigInteger totalSum = end.subtract(start).add(new BigInteger(String.valueOf(1)));
        ticketInStock.setInStockSum(totalSum.intValue());

        Account account = shiroUtil.getAccount();
        ticketInStock.setInStockId(account.getId());
        ticketInStock.setInStockName(account.getAccountName());
        ticketInStock.setInStockContent(start + "--" + end);

        ticketInStockMapper.insertSelective(ticketInStock);

        logger.info("新增年票: {} 入库人: {}", ticketInStock, account);

        //批量插入年票
        List<Ticket> ticketList = new ArrayList<>();
        for (int i = 0; i < totalSum.intValue(); i++) {
            Ticket ticket = new Ticket();
            ticket.setCreateTime(new Date());
            ticket.setTicketInTime(new Date());
            //票号
            ticket.setTicketNum(start.add(new BigInteger(String.valueOf(i))).toString());
            ticket.setTicketState(Ticket.TICKET_IN_STORE);
            ticketList.add(ticket);
        }
        //批量保存年票记录
        ticketMapper.batchInsert(ticketList);

    }

    /**
     * 查询所有入库记录
     * @return
     */
    @Override
    public List<TicketInStock> findAllTicketInStore() {
        List<TicketInStock> ticketList = ticketInStockMapper.selectByExample(new TicketInStockExample());
        return ticketList;
    }

    /**
     * 删除入库记录
     * @param id
     */
    @Override
    @Transactional(rollbackFor = RuntimeException.class)
    public void delInStoreById(Integer id) {

        TicketInStock ticketInStock = ticketInStockMapper.selectByPrimaryKey(id);
        if (ticketInStock != null) {
            TicketExample ticketExample = new TicketExample();
            ticketExample.createCriteria().andTicketNumGreaterThanOrEqualTo(ticketInStock.getInStockStart()).andTicketNumLessThanOrEqualTo(ticketInStock.getInStockEnd()).andTicketStateEqualTo(Ticket.TICKET_IN_STORE);
            List<Ticket> ticketList = ticketMapper.selectByExample(ticketExample);

            if (!ticketInStock.getInStockSum().equals(ticketList.size())) {
                throw new ServiceException("该批次年票的状态已改变，无法删除");
            }
            ticketMapper.deleteByExample(ticketExample);

            ticketInStockMapper.deleteByPrimaryKey(id);
        }



    }

    /**
     * 保存年票下发记录
     * @param ticketOutStore
     */
    @Override
    public void saveTicketOutStore(TicketOutStore ticketOutStore) throws ServiceException {
        //查询判断当前票段是否有！[已入库]的状态，有则禁止下发
        List<Ticket> ticketList = ticketMapper.findByBeginNumAndEndNum(ticketOutStore.getBeginTicketNum(),ticketOutStore.getEndTicketNum());

        for (Ticket ticket : ticketList) {
            if (!Ticket.TICKET_IN_STORE.equals(ticket.getTicketState())) {
                throw new ServiceException("该票段有票下发，请重新选择");
            }
        }
        //获取当前下发售票点的对象
        Store store = storeMapper.selectByPrimaryKey(ticketOutStore.getStoreAccountId());
        ticketOutStore.setStoreAccountName(store.getStoreName());

        //选择下发的总数量
        int totalSize = ticketList.size();
        //计算总价格
        BigDecimal totalPrice = ticketOutStore.getPrice().multiply(new BigDecimal(totalSize));
        //获取当前登陆对象
        Account account = shiroUtil.getAccount();

        ticketOutStore.setCreateTime(new Date());
        ticketOutStore.setContent(ticketOutStore.getBeginTicketNum()  + "-" + ticketOutStore.getEndTicketNum());
        ticketOutStore.setOutAccountId(account.getId());
        ticketOutStore.setOutAccountName(account.getAccountName());
        ticketOutStore.setTotalNum(totalSize);
        ticketOutStore.setState(TicketOutStore.STATE_NO_PAY);
        ticketOutStore.setTotalPrice(totalPrice);

        ticketOutStoreMapper.insertSelective(ticketOutStore);

        logger.info("新增年票下发记录 {} ",ticketOutStore);
    }

    /**
     * 查询全部下发记录
     * @return
     */
    @Override
    public List<TicketOutStore> findAllTicketOutStore() {
        return ticketOutStoreMapper.selectByExample(new TicketOutStoreExample());
    }

    /**
     * 根据逐渐删除下发记录
     *
     * @param id
     */
    @Override
    public void delOutStoreById(Integer id) {
        TicketOutStore ticketOutStore = ticketOutStoreMapper.selectByPrimaryKey(id);
        if (ticketOutStore != null) {
            if (TicketOutStore.STATE_NO_PAY.equals(ticketOutStore.getState())) {
                ticketOutStoreMapper.deleteByPrimaryKey(id);
            }
        }
    }

    /**
     * 年票统计
     *
     * @return
     */
    @Override
    public Map<String, Long> countTicketByState() {
        return ticketMapper.countByState();
    }

    /**
     * 根据下发售票点ID查询出库对象
     * @param id
     * @return
     */
    @Override
    public TicketOutStore findTicketOutStoreById(Integer id) {
        return ticketOutStoreMapper.selectByPrimaryKey(id);
    }

    /**
     * @param pageNo
     * @param queryParam
     * @return
     */
    @Override
    public PageInfo<TicketOutStore> findTicketOutStoreByPageNoAndQueryParam(Integer pageNo, Map<String, Object> queryParam) {
        PageHelper.startPage(pageNo,15);

        TicketOutStoreExample ticketOutStoreExample = new TicketOutStoreExample();
        TicketOutStoreExample.Criteria criteria = ticketOutStoreExample.createCriteria();

        String state = (String) queryParam.get("state");
        if (StringUtil.isNotEmpty(state)) {
            criteria.andStateEqualTo(state);
        }
        ticketOutStoreExample.setOrderByClause("id DESC");

        List<TicketOutStore> ticketOutStores = ticketOutStoreMapper.selectByExample(ticketOutStoreExample);
        return new PageInfo<>(ticketOutStores);

    }

    /**
     * 完成支付
     * @param id
     * @param payType
     */
    @Override
    @Transactional(rollbackFor = RuntimeException.class)
    public void saveTicketFinance(Integer id, String payType) {
        TicketOutStore ticketOutStore = ticketOutStoreMapper.selectByPrimaryKey(id);
        if (ticketOutStore != null && TicketOutStore.STATE_NO_PAY.equals(ticketOutStore.getState())) {
            ticketOutStore.setPayType(payType);
            //获取当前登录对象
            Account account = shiroUtil.getAccount();
            ticketOutStore.setFinanceAccountId(account.getId());
            ticketOutStore.setFinanceAccountName(account.getAccountName());
            ticketOutStore.setState(TicketOutStore.STATE_PAY);

            //修改下发记录
            ticketOutStoreMapper.updateByPrimaryKeySelective(ticketOutStore);
            //修改年票状态
            List<Ticket> ticketList = ticketMapper.findByBeginNumAndEndNum(ticketOutStore.getBeginTicketNum(),ticketOutStore.getEndTicketNum());
            for (Ticket ticket : ticketList) {
                ticket.setTicketState(Ticket.TICKET_ISSUED);
                ticket.setStoreAccountId(ticketOutStore.getStoreAccountId());
                ticket.setTicketOnTime(DateTime.now().toString("YYYY-MM-dd"));
                ticket.setUpdateTime(new Date());

                ticketMapper.updateByPrimaryKeySelective(ticket);
            }
        }
    }


}
