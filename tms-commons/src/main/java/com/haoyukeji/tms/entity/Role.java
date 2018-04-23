package com.haoyukeji.tms.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * @author 
 */
public class Role implements Serializable {
    private Integer id;

    private String roleName;

    private Date createTime;

    private Date updateTime;

    /**
     * 角色代号
     */
    private String roleCode;

    private List<Permissions> permissionList;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public String getRoleCode() {
        return roleCode;
    }

    public void setRoleCode(String roleCode) {
        this.roleCode = roleCode;
    }

    public List<Permissions> getPermissionList() {
        return permissionList;
    }

    public void setPermissionList(List<Permissions> permissionList) {
        this.permissionList = permissionList;
    }

    @Override
    public String toString() {
        return "Role{" +
                "id=" + id +
                ", roleName='" + roleName + '\'' +
                ", createTime=" + createTime +
                ", updateTime=" + updateTime +
                ", roleCode='" + roleCode + '\'' +
                '}';
    }
}