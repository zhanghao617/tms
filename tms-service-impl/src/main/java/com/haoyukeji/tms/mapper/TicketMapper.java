package com.haoyukeji.tms.mapper;

import com.haoyukeji.tms.entity.Ticket;
import com.haoyukeji.tms.entity.TicketExample;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

public interface TicketMapper {
    long countByExample(TicketExample example);

    int deleteByExample(TicketExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Ticket record);

    int insertSelective(Ticket record);

    List<Ticket> selectByExample(TicketExample example);

    Ticket selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Ticket record, @Param("example") TicketExample example);

    int updateByExample(@Param("record") Ticket record, @Param("example") TicketExample example);

    int updateByPrimaryKeySelective(Ticket record);

    int updateByPrimaryKey(Ticket record);

    void batchInsert(@Param("ticketList") List<Ticket> ticketList);

    Map<String,Long> countByState();

    Map<String,Long> countByStateAndStoreAccountId(Integer storeAccountId);

    List<Ticket> findByBeginNumAndEndNum(@Param("beginNum") String beginNum,@Param("endNum") String endNum);
    List<Ticket> findByBeginNumAndEndNumAndState(@Param("beginNum") String beginNum,
                                                 @Param("endNum") String endNum,
                                                 @Param("state") String state);
    void batchDeleteById(@Param("idList") List<Long> idList);
}
