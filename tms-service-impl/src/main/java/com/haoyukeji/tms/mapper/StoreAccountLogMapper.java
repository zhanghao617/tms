package com.haoyukeji.tms.mapper;

import com.haoyukeji.tms.entity.StoreAccountLog;
import com.haoyukeji.tms.entity.StoreAccountLogExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface StoreAccountLogMapper {
    long countByExample(StoreAccountLogExample example);

    int deleteByExample(StoreAccountLogExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(StoreAccountLog record);

    int insertSelective(StoreAccountLog record);

    List<StoreAccountLog> selectByExample(StoreAccountLogExample example);

    StoreAccountLog selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") StoreAccountLog record, @Param("example") StoreAccountLogExample example);

    int updateByExample(@Param("record") StoreAccountLog record, @Param("example") StoreAccountLogExample example);

    int updateByPrimaryKeySelective(StoreAccountLog record);

    int updateByPrimaryKey(StoreAccountLog record);
}