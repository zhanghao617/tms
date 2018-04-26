package com.haoyukeji.tms.service;

import com.haoyukeji.tms.entity.Permissions;
import com.haoyukeji.tms.entity.Role;
import com.haoyukeji.tms.exception.ServiceException;

import java.util.List;

/**
 * 角色权限业务层
 * @author Administrator
 */
public interface RolePermissionService {

    /**
     * 添加权限
     * @param permissions
     */
    void savePermission(Permissions permissions);

    /**
     * 根据权限类型查询权限列表
     * @param permissionType 菜单 | 按钮
     * @return 权限列表
     */
    List<Permissions> findPermissionByType(String permissionType);

    /**
     * 查询所有的权限
     * @return
     */
    List<Permissions> findAllPermission();

    /**
     * 查询所有的角色以及角色拥有的权限
     * @return
     */
    List<Role> findAllRoleWithPermission();

    /**
     * 根据角色ID查询角色对象及其拥有的权限
     * @param id
     * @return
     */
    Role findRolesWithPermissionById(Integer id);

    /**
     * 添加角色
     * @param role  添加的角色对像
     * @param permissionId 角色所对应的权限ID
     */
    void saveRole(Role role, Integer[] permissionId);


    /**
     * 根据权限Id删除权限
     * @param id
     * @throws ServiceException 删除失败 抛出此异常
     */
    void delPermissionById(Integer id) throws ServiceException;

    /**
     * 查询所有角色
     * @return
     */
    List<Role> findAllRole();

    /**
     * 根据权限ID查询权限
     * @param id
     * @return
     */
    Permissions findPermissionById(Integer id);

    /**
     * 修改角色
     * @param role
     * @param permissionId
     */
    void updateRole(Role role, Integer[] permissionId);

    /**
     * 根据Account的id查询该账户所拥有的角色
     * @param id
     * @return
     */
    List<Role> findRoleByAccountId(Integer id);

    /**
     * 根据角色ID查询所有的对应的权限
     * @param roleId 角色ID
     * @return
     */
    List<Permissions> findAllPermissionsByRoleId(Integer roleId);
}
