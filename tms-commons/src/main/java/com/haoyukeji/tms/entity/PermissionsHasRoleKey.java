package com.haoyukeji.tms.entity;

import java.io.Serializable;

/**
 * @author 
 */
public class PermissionsHasRoleKey implements Serializable {

    private Integer permissionsId;

    private Integer roleId;

    private static final long serialVersionUID = 1L;

    public Integer getPermissionsId() {
        return permissionsId;
    }

    public void setPermissionsId(Integer permissionsId) {
        this.permissionsId = permissionsId;
    }

    public Integer getRoleId() {
        return roleId;
    }

    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }
}