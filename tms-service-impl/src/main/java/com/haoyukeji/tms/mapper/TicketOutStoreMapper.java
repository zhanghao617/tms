package com.haoyukeji.tms.mapper;

import com.haoyukeji.tms.entity.TicketOutStore;
import com.haoyukeji.tms.entity.TicketOutStoreExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TicketOutStoreMapper {
    long countByExample(TicketOutStoreExample example);

    int deleteByExample(TicketOutStoreExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(TicketOutStore record);

    int insertSelective(TicketOutStore record);

    List<TicketOutStore> selectByExample(TicketOutStoreExample example);

    TicketOutStore selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") TicketOutStore record, @Param("example") TicketOutStoreExample example);

    int updateByExample(@Param("record") TicketOutStore record, @Param("example") TicketOutStoreExample example);

    int updateByPrimaryKeySelective(TicketOutStore record);

    int updateByPrimaryKey(TicketOutStore record);
}