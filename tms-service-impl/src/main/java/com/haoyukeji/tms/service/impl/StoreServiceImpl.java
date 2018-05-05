package com.haoyukeji.tms.service.impl;

import com.haoyukeji.tms.entity.*;
import com.haoyukeji.tms.exception.ServiceException;
import com.haoyukeji.tms.mapper.StoreAccountLogMapper;
import com.haoyukeji.tms.mapper.StoreAccountMapper;
import com.haoyukeji.tms.mapper.StoreMapper;
import com.haoyukeji.tms.service.StoreService;
import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

@Service
public class StoreServiceImpl implements StoreService {

    @Autowired
    private StoreMapper storeMapper;
    @Autowired
    private StoreAccountMapper storeAccountMapper;
    @Autowired
    private StoreAccountLogMapper storeAccountLogMapper;

    /**
     * 添加新的销售点
     * @param store
     */
    @Override
    @Transactional(rollbackFor = RuntimeException.class)
    public void saveNewStore(Store store) {
        store.setStoreCreateTime(new Date());
        storeMapper.insertSelective(store);

        //创建销售点账号
        StoreAccount storeAccount = new StoreAccount();
        storeAccount.setId(store.getId());
        storeAccount.setStoreAccountName(store.getStoreName());
        storeAccount.setStoreAccountMobile(store.getStoreMobile());
        //截取手机号后六位作为默认密码
        storeAccount.setStoreAccountPassword(DigestUtils.md5Hex(storeAccount.getStoreAccountMobile().substring(5)));
        //默认账号的状态为正常
        storeAccount.setStoreAccountState(StoreAccount.ACCOUNT_STATE_NORMAL);
        storeAccount.setStoreAccountCreateTime(new Date());

        storeAccountMapper.insertSelective(storeAccount);

        //更新关联的账号Id
        store.setStoreAccountId(storeAccount.getId());
        storeMapper.updateByPrimaryKeySelective(store);

    }

    /**
     * 查询所有的销售点
     */
    @Override
    public List<Store> findAllStore() {
        StoreExample storeExample = new StoreExample();
        return storeMapper.selectByExample(storeExample);
    }

    /**
     * 根据售票点id查询售票点信息
     * @param id
     */
    @Override
    public Store findStoreById(Integer id) {
        return storeMapper.selectByPrimaryKey(id);

    }

    /**
     * 修改售票点信息
     * @param store
     */
    @Override
    @Transactional(rollbackFor = RuntimeException.class)
    public void updateStore(Store store) {
        store.setStoreUpdateTime(new Date());

        //判断手机号是否更改
        StoreAccount storeAccount = storeAccountMapper.selectByPrimaryKey(store.getId());
        if (!store.getStoreMobile().equals(storeAccount.getStoreAccountMobile())) {
            storeAccount.setStoreAccountMobile(store.getStoreMobile());
            storeAccount.setStoreAccountPassword(DigestUtils.md5Hex(store.getStoreMobile().substring(5)));
            storeAccount.setStoreAccountUpdateTime(new Date());

            storeAccountMapper.updateByPrimaryKeySelective(storeAccount);
        }
        storeMapper.updateByPrimaryKeySelective(store);
    }

    /**
     * 删除售票点以及售票点账号
     * @param id
     * @throws ServiceException 删除失败时抛出异常
     */
    @Override
    public void delStoreWithAccountById(Integer id) throws ServiceException {
        StoreAccount storeAccount = storeAccountMapper.selectByPrimaryKey(id);
        if (storeAccount != null) {
            storeAccountMapper.deleteByPrimaryKey(id);
        }
        storeMapper.deleteByPrimaryKey(id);
    }

    /**
     * 根据手机号查询登陆对象
     *
     * @param userMobile
     * @return
     */
    @Override
    public StoreAccount findStoreAccountByName(String userMobile) {
        StoreAccountExample example = new StoreAccountExample();
        example.createCriteria().andStoreAccountMobileEqualTo(userMobile);

        List<StoreAccount> storeAccountList = storeAccountMapper.selectByExample(example);
        if(storeAccountList != null && !storeAccountList.isEmpty()) {
            return storeAccountList.get(0);
        }
        return null;
    }

    /**
     * 根据ID售票点账户Id查询售票点信息
     *
     * @param id
     * @return
     */
    @Override
    public Store findAStoreById(Integer id) {
        return storeMapper.selectByPrimaryKey(id);
    }

    /**
     * 登陆日志
     *
     * @param storeAccountLog
     */
    @Override
    public void saveAccountLoginLog(StoreAccountLog storeAccountLog) {
        storeAccountLogMapper.insertSelective(storeAccountLog);
    }
}
