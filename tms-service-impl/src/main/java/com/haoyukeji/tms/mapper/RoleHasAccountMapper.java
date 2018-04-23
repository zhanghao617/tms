package com.haoyukeji.tms.mapper;

import com.haoyukeji.tms.entity.RoleHasAccountExample;
import com.haoyukeji.tms.entity.RoleHasAccountKey;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface RoleHasAccountMapper {
    long countByExample(RoleHasAccountExample example);

    int deleteByExample(RoleHasAccountExample example);

    int deleteByPrimaryKey(RoleHasAccountKey key);

    int insert(RoleHasAccountKey record);

    int insertSelective(RoleHasAccountKey record);

    List<RoleHasAccountKey> selectByExample(RoleHasAccountExample example);

    int updateByExampleSelective(@Param("record") RoleHasAccountKey record, @Param("example") RoleHasAccountExample example);

    int updateByExample(@Param("record") RoleHasAccountKey record, @Param("example") RoleHasAccountExample example);
}