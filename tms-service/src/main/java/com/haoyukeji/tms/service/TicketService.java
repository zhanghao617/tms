package com.haoyukeji.tms.service;

import com.haoyukeji.tms.entity.TicketInStock;
import com.haoyukeji.tms.entity.TicketOutStore;
import com.haoyukeji.tms.exception.ServiceException;

import java.util.List;
import java.util.Map;

public interface TicketService {

    /**
     * 新增入库
     * @param ticketInStock
     */
    void saveTicketInStore(TicketInStock ticketInStock);

    /**
     * 查询所有入库记录
     * @return
     */
    List<TicketInStock> findAllTicketInStore();

    /**
     * 删除入库记录
     * @param id
     */
    void delInStoreById(Integer id);

    /**
     * 保存年票下发记录
     * @param ticketOutStore
     */
    void saveTicketOutStore(TicketOutStore ticketOutStore) throws ServiceException;

    /**
     * 查询全部下发记录
     * @return
     */
    List<TicketOutStore> findAllTicketOutStore();

    /**
     * 根据逐渐删除下发记录
     * @param id
     */
    void delOutStoreById(Integer id);

    /**
     * 年票统计
     * @return
     */
    Map<String,Long> countTicketByState();

}
