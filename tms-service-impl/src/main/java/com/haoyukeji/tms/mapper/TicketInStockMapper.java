package com.haoyukeji.tms.mapper;

import com.haoyukeji.tms.entity.TicketInStock;
import com.haoyukeji.tms.entity.TicketInStockExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TicketInStockMapper {
    long countByExample(TicketInStockExample example);

    int deleteByExample(TicketInStockExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(TicketInStock record);

    int insertSelective(TicketInStock record);

    List<TicketInStock> selectByExample(TicketInStockExample example);

    TicketInStock selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") TicketInStock record, @Param("example") TicketInStockExample example);

    int updateByExample(@Param("record") TicketInStock record, @Param("example") TicketInStockExample example);

    int updateByPrimaryKeySelective(TicketInStock record);

    int updateByPrimaryKey(TicketInStock record);
}