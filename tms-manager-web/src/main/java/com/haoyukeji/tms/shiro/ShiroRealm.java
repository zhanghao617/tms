package com.haoyukeji.tms.shiro;

import com.haoyukeji.tms.entity.Account;
import com.haoyukeji.tms.entity.AccountLoginLog;
import com.haoyukeji.tms.entity.Permissions;
import com.haoyukeji.tms.entity.Role;
import com.haoyukeji.tms.service.AccountService;
import com.haoyukeji.tms.service.RolePermissionService;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
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
    private RolePermissionService rolePermissionService;

    /**
     * 角色和权限
     * @param principalCollection
     * @return
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        //获取当前登录的对象
        Account account = (Account) principalCollection.getPrimaryPrincipal();
        //获取当前登录对象拥有的角色
        List<Role> rolesList = rolePermissionService.findRoleByAccountId(account.getId());
        //获取当前登录对象拥有的权限
        List<Permissions> permissionList = new ArrayList<>();
        for(Role role : rolesList) {
            List<Permissions> rolesPermissionList = rolePermissionService.findAllPermissionsByRoleId(role.getId());
            permissionList.addAll(rolesPermissionList);
        }

        Set<String> rolesNameSet = new HashSet<>();
        for(Role roles : rolesList) {
            rolesNameSet.add(roles.getRoleCode());
        }

        Set<String> permissionNameSet = new HashSet<>();
        for(Permissions permission : permissionList) {
            permissionNameSet.add(permission.getPermissionsCode());
        }

        SimpleAuthorizationInfo simpleAuthorizationInfo = new SimpleAuthorizationInfo();
        //当前用户拥有的角色（code）
        simpleAuthorizationInfo.setRoles(rolesNameSet);
        //当前用户拥有的权限(code)
        simpleAuthorizationInfo.setStringPermissions(permissionNameSet);
        return simpleAuthorizationInfo;
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
