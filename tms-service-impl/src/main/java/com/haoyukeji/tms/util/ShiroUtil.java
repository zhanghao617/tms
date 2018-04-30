package com.haoyukeji.tms.util;

import com.haoyukeji.tms.entity.Account;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Component;

@Component
public class ShiroUtil {

    public Account getAccount() {
        Subject subject = SecurityUtils.getSubject();
        return (Account) subject.getPrincipal();
    }
}
