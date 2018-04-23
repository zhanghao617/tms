package com.haoyukeji.tms.service.impl;

import com.haoyukeji.tms.entity.*;
import com.haoyukeji.tms.exception.ServiceException;
import com.haoyukeji.tms.mapper.AccountLoginLogMapper;
import com.haoyukeji.tms.mapper.AccountMapper;
import com.haoyukeji.tms.mapper.RoleHasAccountMapper;
import com.haoyukeji.tms.mapper.RoleMapper;
import com.haoyukeji.tms.service.AccountService;
import org.apache.commons.codec.digest.DigestUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

/**
 * 实体类的业务接口
 * @author Administrator
 */
@Service
public class AccountServiceImpl implements AccountService {

    private static final Logger logger = LoggerFactory.getLogger(AccountServiceImpl.class);

    @Autowired
    private AccountMapper accountMapper;
    @Autowired
    private AccountLoginLogMapper accountLoginLogMapper;
    @Autowired
    private RoleHasAccountMapper roleHasAccountMapper;
    @Autowired
    private RoleMapper roleMapper;

    /**
     * 系统登录
     * @param accountMobile 手机号
     * @param accountPassword 密码
     * @param requestIP  IP地址
     * @return  如果登陆成功，则返回Account对象，失败返回null
     * @throws ServiceException   如果登录失败，则通过异常抛出具体的错误原因
     */
    @Override
    public Account login(String accountMobile, String accountPassword, String requestIP) throws ServiceException {

        //根据手机号查询对应账号
        AccountExample accountExample = new AccountExample();
        accountExample.createCriteria().andAccountMobileEqualTo(accountMobile);

        List<Account> accountList = accountMapper.selectByExample(accountExample);
        Account account = null;
        if (accountList != null && !accountList.isEmpty()) {
            account = accountList.get(0);
            //匹配密码
            if(account.getAccountPassword().equals(DigestUtils.md5Hex(accountPassword))) {
                //判断状态
                if (Account.STATE_NORMAL.equals(account.getAccountState())){
                    //添加日志
                    AccountLoginLog accountLoginLog = new AccountLoginLog();
                    accountLoginLog.setAccountAccountId(account.getId());
                    accountLoginLog.setLoginIp(requestIP);
                    accountLoginLog.getCreateTime(new Date());

                    accountLoginLogMapper.insertSelective(accountLoginLog);
                    logger.info("{} 系统登陆",account);
                    return account;

                }else if (Account.STATE_LOCKED.equals(account.getAccountState())){
                    throw new ServiceException("账号被锁定");
                }else {
                    throw new ServiceException("账号被禁用");
                }
            } else{
                throw new ServiceException("账号或密码错误");
            }
        } else {
            throw new ServiceException("账号或密码错误");
        }
    }

    /**
     * 新增账号
     * @param account
     * @param roleId
     */
    @Override
    @Transactional(value = "transactionManager")
    public void saveAccount(Account account, Integer[] roleId) {
        account.setCreateTime(new Date());
        //截取手机号后六位为默认密码并且使用md5加密
        String password;
        if (account.getAccountMobile().length() <= 6) {
            password = account.getAccountMobile();
        }else {
            password = account.getAccountMobile().substring(6);
        }
        password = DigestUtils.md5Hex(password);

        account.setAccountPassword(password);
        //添加账号的默认状态
        account.setAccountState(Account.STATE_NORMAL);
        accountMapper.insertSelective(account);

        AccountExample accountExample = new AccountExample();
        accountExample.createCriteria().andAccountMobileEqualTo(account.getAccountMobile());
        List<Account> accountList = accountMapper.selectByExample(accountExample);
        if (accountList != null && !accountList.isEmpty()) {
            //保存账号与角色之间的关系
            for (Integer rId : roleId) {
                RoleHasAccountKey roleHasAccountKey = new RoleHasAccountKey();
                roleHasAccountKey.setAccountAccountId(accountList.get(0).getId());
                roleHasAccountKey.setRoleId(rId);

                roleHasAccountMapper.insert(roleHasAccountKey);
            }
        }


        logger.info("保存账号 {}",account);

    }

    /**
     * 查询所有账号以及账号所拥有的权限
     * @return
     */
    @Override
    public List<Account> findAllAccountWithRole() {
        return accountMapper.findAllRole();
    }

    /**
     * 根据账号ID查询对应角色
     * @param id
     * @return
     */
    @Override
    public Account findAccountWithRoleById(Integer id) {
        return accountMapper.findAllRoleById(id);
    }

    /**
     * 查询所有的角色
     * @return
     */
    @Override
    public List<Role> findAllRole() {
        RoleExample roleExample = new RoleExample();
        return roleMapper.selectByExample(roleExample);
    }

    /**
     * 根据ID查询对象
     * @param id
     * @return
     */
    @Override
    public Account findAccountById(Integer id) {
        return accountMapper.selectByPrimaryKey(id);
    }

    /**
     * 修改账号内容
     * @param account
     * @param roleId
     */
    @Override
    public void updateAccount(Account account, Integer[] roleId) {

        //添加修改时间
        account.setUpdateTime(new Date());
        accountMapper.updateByPrimaryKeySelective(account);

        //删除原有的对应关系
        RoleHasAccountExample roleHasAccountExample = new RoleHasAccountExample();
        roleHasAccountExample.createCriteria().andAccountAccountIdEqualTo(account.getId());
        roleHasAccountMapper.deleteByExample(roleHasAccountExample);

        //重新建立账号与角色之间的关系
        if(roleId != null) {
            for (Integer rId : roleId) {
                RoleHasAccountKey roleHasAccountKey = new RoleHasAccountKey();
                roleHasAccountKey.setAccountAccountId(account.getId());
                roleHasAccountKey.setRoleId(rId);

                roleHasAccountMapper.insertSelective(roleHasAccountKey);
            }
            logger.info("编辑账号 {}", account);
        }

    }

    /**
     * 根据accountId删除账号
     * @param id
     */
    @Override
    public void delAccountById(Integer id) throws ServiceException {
        RoleHasAccountExample roleHasAccountExample = new RoleHasAccountExample();
        roleHasAccountExample.createCriteria().andAccountAccountIdEqualTo(id);

        List<RoleHasAccountKey> roleHasAccountKeyList = roleHasAccountMapper.selectByExample(roleHasAccountExample);
        if(roleHasAccountKeyList != null && !roleHasAccountKeyList.isEmpty()) {
            throw new ServiceException("该账号存在角色，删除失败");
        }

        Account account = new Account();
        accountMapper.deleteByPrimaryKey(id);
        logger.info("删除账号 {}" ,account);

    }

}
