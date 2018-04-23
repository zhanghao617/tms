package com.haoyukeji.tms.entity;

import java.io.Serializable;

/**
 * @author 
 */
public class RoleHasAccountKey implements Serializable {
    private Integer roleId;

    private Integer accountAccountId;

    private static final long serialVersionUID = 1L;

    public Integer getRoleId() {
        return roleId;
    }

    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }

    public Integer getAccountAccountId() {
        return accountAccountId;
    }

    public void setAccountAccountId(Integer accountAccountId) {
        this.accountAccountId = accountAccountId;
    }
}