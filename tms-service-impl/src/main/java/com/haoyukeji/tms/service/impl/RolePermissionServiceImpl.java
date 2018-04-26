package com.haoyukeji.tms.service.impl;

import com.google.common.collect.Collections2;
import com.google.common.collect.Lists;
import com.haoyukeji.tms.entity.*;
import com.haoyukeji.tms.exception.ServiceException;
import com.haoyukeji.tms.mapper.PermissionsHasRoleMapper;
import com.haoyukeji.tms.mapper.PermissionsMapper;
import com.haoyukeji.tms.mapper.RoleMapper;
import com.haoyukeji.tms.service.RolePermissionService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class RolePermissionServiceImpl implements RolePermissionService {

    private static final Logger logger = LoggerFactory.getLogger(RolePermissionServiceImpl.class);

    @Autowired
    private PermissionsMapper permissionsMapper;
    @Autowired
    private RoleMapper roleMapper;
    @Autowired
    private PermissionsHasRoleMapper permissionsHasRoleMapper;
    /**
     * 添加权限
     * @param permissions
     */
    @Override
    public void savePermission(Permissions permissions) {
       permissions.setCreateTime(new Date());
       permissionsMapper.insertSelective(permissions);
       logger.info("添加权限 {} ",permissions);
    }

    /**
     * 根据权限类型查询权限列表
     * @param permissionType 菜单 | 按钮
     * @return 权限列表
     */
    @Override
    public List<Permissions> findPermissionByType(String permissionType) {

        PermissionsExample permissionsExample = new PermissionsExample();
        permissionsExample.createCriteria().andPermissionsTypeEqualTo(permissionType);
        return permissionsMapper.selectByExample(permissionsExample);
    }

    /**
     * 查询所有的权限
     * @return
     */
    @Override
    public List<Permissions> findAllPermission() {
        PermissionsExample permissionsExample = new PermissionsExample();
        List<Permissions> permissionList = permissionsMapper.selectByExample(permissionsExample);
        List<Permissions> list = new ArrayList<>();
        treeList(permissionList,list,0);
        return list;
    }

    /**
     * 查询所有的角色以及角色拥有的权限
     * @return
     */
    @Override
    public List<Role> findAllRoleWithPermission() {
        return roleMapper.findAllPermission();
    }

    /**
     * 根据角色ID查询角色对象及其拥有的权限
     *
     * @param id
     * @return
     */
    @Override
    public Role findRolesWithPermissionById(Integer id) {
        return roleMapper.findByIdWithPermission(id);
    }

    /**
     * 新增角色
     * @param role  新增角色
     * @param permissionId 所拥有的权限ID
     */
    @Override
    @Transactional(rollbackFor = RuntimeException.class)
    public void saveRole(Role role, Integer[] permissionId) {
        //保存角色
        role.setCreateTime(new Date());
        roleMapper.insertSelective(role);
        //保存角色和权限的关系
        if (permissionId != null) {
            for (Integer perId : permissionId) {
                PermissionsHasRoleKey permissionsHasRoleKey = new PermissionsHasRoleKey();
                permissionsHasRoleKey.setPermissionsId(perId);
                permissionsHasRoleKey.setRoleId(role.getId());

                permissionsHasRoleMapper.insertSelective(permissionsHasRoleKey);
            }
        }
        logger.info("新增角色成功 {}",role);
    }

    /**
     *删除权限
     * @param id 权限ID
     * @throws ServiceException 删除失败抛出失败原因
     */
    @Override
    public void delPermissionById(Integer id) throws ServiceException {
        //查询该节点是否拥有子节点
        PermissionsExample permissionsExample = new PermissionsExample();
        permissionsExample.createCriteria().andParentIdEqualTo(id);

        List<Permissions> permissionsList = permissionsMapper.selectByExample(permissionsExample);
        if (permissionsList != null && !permissionsList.isEmpty()) {
            throw new ServiceException("该节点存在子节点，删除失败");
        }
        //查询权限是否被使用
        PermissionsHasRoleExample permissionsHasRoleExample = new PermissionsHasRoleExample();
        permissionsHasRoleExample.createCriteria().andPermissionsIdEqualTo(id);

        List<PermissionsHasRoleKey> permissionsHasRoleKeyList = permissionsHasRoleMapper.selectByExample(permissionsHasRoleExample);
        if(permissionsHasRoleKeyList != null && !permissionsHasRoleKeyList.isEmpty()) {
            throw new ServiceException("该权限被引用，删除失败");
        }
        //没有被引用 直接删除
        Permissions permissions = permissionsMapper.selectByPrimaryKey(id);
        permissionsMapper.deleteByPrimaryKey(id);
        logger.info("删除权限 {}",permissions);
    }

    /**
     * 查询所有角色
     * @return
     */
    @Override
    public List<Role> findAllRole() {
        RoleExample roleExample = new RoleExample();
        return roleMapper.selectByExample(roleExample);
    }

    /**
     * 根据权限ID查询权限
     * @param id
     * @return
     */
    @Override
    public Permissions findPermissionById(Integer id) {
        return permissionsMapper.selectByPrimaryKey(id);
    }

    /**
     * 修改角色
     * @param role
     * @param permissionId
     */
    @Override
    public void updateRole(Role role, Integer[] permissionId) {
       PermissionsHasRoleExample permissionsHasRoleExample = new PermissionsHasRoleExample();
       permissionsHasRoleExample.createCriteria().andPermissionsIdEqualTo(role.getId());

       permissionsHasRoleMapper.deleteByExample(permissionsHasRoleExample);
        for (Integer perId : permissionId) {
            PermissionsHasRoleKey permissionsHasRoleKey = new PermissionsHasRoleKey();
            permissionsHasRoleKey.setRoleId(role.getId());
            permissionsHasRoleKey.setPermissionsId(perId);

            permissionsHasRoleMapper.insertSelective(permissionsHasRoleKey);
        }
        role.setUpdateTime(new Date());
       roleMapper.updateByPrimaryKeySelective(role);

       logger.info("修改角色 {} ",role);

    }

    /**
     * 根据Account的id查询该账户所拥有的角色
     *
     * @param id
     * @return
     */
    @Override
    public List<Role> findRoleByAccountId(Integer id) {
        return roleMapper.findRoleByAccountId(id);
    }

    /**
     * 根据角色ID查询所有的对应的权限
     * @param roleId 角色ID
     * @return
     */
    @Override
    public List<Permissions> findAllPermissionsByRoleId(Integer roleId) {
        return permissionsMapper.findAllByRoleId(roleId);
    }

    /**
     * 将查询到的权限列表分类
     * @param permissionList 查询到的集合
     * @param list  处理后的集合
     * @param parentId 父ID
     */
    private void treeList(List<Permissions> permissionList, List<Permissions> list, int parentId) {
        List<Permissions> temspList = Lists.newArrayList(Collections2.filter(permissionList, permissions -> permissions.getParentId().equals(parentId)));
        for (Permissions permissions : temspList) {
            list.add(permissions);
            treeList(permissionList,list,permissions.getId());
        }
    }

}
