package com.haoyukeji.tms.service;

import com.haoyukeji.tms.entity.Ticket;
import com.haoyukeji.tms.entity.TicketInStock;
import com.haoyukeji.tms.entity.TicketOutStore;
import com.haoyukeji.tms.exception.ServiceException;

import java.util.List;

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
}
