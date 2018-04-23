package com.haoyukeji.tms.mapper;

import com.haoyukeji.tms.entity.PermissionsHasRoleExample;
import com.haoyukeji.tms.entity.PermissionsHasRoleKey;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface PermissionsHasRoleMapper {
    long countByExample(PermissionsHasRoleExample example);

    int deleteByExample(PermissionsHasRoleExample example);

    int deleteByPrimaryKey(PermissionsHasRoleKey key);

    int insert(PermissionsHasRoleKey record);

    int insertSelective(PermissionsHasRoleKey record);

    List<PermissionsHasRoleKey> selectByExample(PermissionsHasRoleExample example);

    int updateByExampleSelective(@Param("record") PermissionsHasRoleKey record, @Param("example") PermissionsHasRoleExample example);

    int updateByExample(@Param("record") PermissionsHasRoleKey record, @Param("example") PermissionsHasRoleExample example);
}