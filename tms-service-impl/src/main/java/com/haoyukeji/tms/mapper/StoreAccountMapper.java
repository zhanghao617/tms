package com.haoyukeji.tms.mapper;

import com.haoyukeji.tms.entity.StoreAccount;
import com.haoyukeji.tms.entity.StoreAccountExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface StoreAccountMapper {
    long countByExample(StoreAccountExample example);

    int deleteByExample(StoreAccountExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(StoreAccount record);

    int insertSelective(StoreAccount record);

    List<StoreAccount> selectByExample(StoreAccountExample example);

    StoreAccount selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") StoreAccount record, @Param("example") StoreAccountExample example);

    int updateByExample(@Param("record") StoreAccount record, @Param("example") StoreAccountExample example);

    int updateByPrimaryKeySelective(StoreAccount record);

    int updateByPrimaryKey(StoreAccount record);
}