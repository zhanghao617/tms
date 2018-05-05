package com.haoyukeji.tms.shiro;

import com.haoyukeji.tms.entity.*;
import com.haoyukeji.tms.service.AccountService;
import com.haoyukeji.tms.service.StoreService;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.*;

public class ShiroRealm extends AuthorizingRealm {

    private Logger logger = LoggerFactory.getLogger(ShiroRealm.class);

    @Autowired
    private AccountService accountService;
    @Autowired
    private StoreService storeService;

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
            StoreAccount storeAccount = storeService.findStoreAccountByName(userMobile);
            if (storeAccount == null) {
                throw new UnknownAccountException("找不到该账号:" + userMobile);
            }else {
                if (StoreAccount.ACCOUNT_STATE_NORMAL.equals(storeAccount.getStoreAccountState())) {

                    logger.info("{} 登录成功 {}",storeAccount,usernamePasswordToken.getHost());

                    Store store =   storeService.findAStoreById(storeAccount.getId());

                    StoreAccountLog storeAccountLog = new StoreAccountLog();
                    storeAccountLog.setCreateTime(new Date());
                    storeAccountLog.setStoreAccountId(storeAccount.getId());
                    storeAccountLog.setStoreAccountIp(usernamePasswordToken.getHost());

                    storeService.saveAccountLoginLog(storeAccountLog);

                    return new SimpleAuthenticationInfo(storeAccount,storeAccount.getStoreAccountPassword(),getName());
                }else {
                    throw new LockedAccountException("账号禁用或锁定:" + storeAccount.getStoreAccountState());
                }
            }
        }
        return null;
    }
}
