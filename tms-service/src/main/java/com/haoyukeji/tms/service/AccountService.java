package com.haoyukeji.tms.service;

import com.haoyukeji.tms.entity.Account;
import com.haoyukeji.tms.entity.Role;
import com.haoyukeji.tms.exception.ServiceException;

import java.util.List;

/**
 * 实体类的业务接口
 * @author Administrator
 */
public interface AccountService {

    /**
     * 系统登陆
     * @param accountMobile
     * @param accountPassword
     * @param requestIP
     * @return
     */
    Account login(String accountMobile, String accountPassword, String requestIP) throws ServiceException;

    /**
     * 新增账号
     * @param account
     * @param roleId
     */
    void saveAccount(Account account, Integer[] roleId);

    /**
     * 查询所有账号以及账号所拥有的权限
     * @return
     */
    List<Account> findAllAccountWithRole();

    /**
     * 根据账号ID查询对应角色
     * @return
     */
    Account findAccountWithRoleById(Integer id);

    /**
     * 查询所有的角色
     * @return
     */
    List<Role> findAllRole();

    /**
     * 根据ID查询对象
     * @param id
     * @return
     */
    Account findAccountById(Integer id);

    /**
     * 修改账号内容
     * @param account
     * @param roleId
     */
    void updateAccount(Account account, Integer[] roleId);

    /**
     * 根据accountId删除账号
     * @param id
     */
    void delAccountById(Integer id) throws ServiceException;
}
