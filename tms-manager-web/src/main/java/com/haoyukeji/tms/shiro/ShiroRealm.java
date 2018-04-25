package com.haoyukeji.tms.shiro;

import com.haoyukeji.tms.entity.Account;
import com.haoyukeji.tms.entity.AccountLoginLog;
import com.haoyukeji.tms.service.AccountService;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;

public class ShiroRealm extends AuthorizingRealm {

    private Logger logger = LoggerFactory.getLogger(ShiroRealm.class);

    @Autowired
    private AccountService accountService;

    /**
     * 角色和权限
     * @param principalCollection
     * @return
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        return null;
    }

    /**
     * 登录
     * @param authenticationToken
     * @return
     * @throws AuthenticationException
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        UsernamePasswordToken usernamePasswordToken = (UsernamePasswordToken) authenticationToken;
        String userMobile = usernamePasswordToken.getUsername();
        if (userMobile != null) {
            Account account = accountService.findByMobile(userMobile);
            if (account == null) {
                throw new UnknownAccountException("找不到该账号:" + userMobile);
            }else {
                if (Account.STATE_NORMAL.equals(account.getAccountState())) {

                    logger.info("{} 登录成功 {}",account,usernamePasswordToken.getHost());
                    AccountLoginLog accountLoginLog = new AccountLoginLog();
                    accountLoginLog.setAccountAccountId(account.getId());
                    accountLoginLog.setLoginIp(usernamePasswordToken.getHost());
                    accountLoginLog.setUpdateTime(new Date());

                    accountService.saveAccountLoginLog(accountLoginLog);

                    return new SimpleAuthenticationInfo(account,account.getAccountPassword(),getName());
                }else {
                    throw new LockedAccountException("账号禁用或锁定:" + account.getAccountState());
                }
            }
        }
        return null;
    }
}
