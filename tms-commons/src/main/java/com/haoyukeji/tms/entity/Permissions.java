package com.haoyukeji.tms.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * @author 
 */
public class Permissions implements Serializable {

    public static final String MENU_TYPE = "菜单";
    public static final String BUTTON_TYPE = "按钮";

    private Integer id;

    /**
     * 权限名称
     */
    private String permissionsName;

    /**
     * 权限类型
     */
    private String permissionsType;

    /**
     * 资源路径
     */
    private String url;

    /**
     * 权限代号
     */
    private String permissionsCode;

    /**
     * 父ID
     */
    private Integer parentId;

    private Date createTime;

    private Date updateTime;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPermissionsName() {
        return permissionsName;
    }

    public void setPermissionsName(String permissionsName) {
        this.permissionsName = permissionsName;
    }

    public String getPermissionsType() {
        return permissionsType;
    }

    public void setPermissionsType(String permissionsType) {
        this.permissionsType = permissionsType;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getPermissionsCode() {
        return permissionsCode;
    }

    public void setPermissionsCode(String permissionsCode) {
        this.permissionsCode = permissionsCode;
    }

    public Integer getParentId() {
        return parentId;
    }

    public void setParentId(Integer parentId) {
        this.parentId = parentId;
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

    @Override
    public String toString() {
        return "Permissions{" +
                "id=" + id +
                ", permissionsName='" + permissionsName + '\'' +
                ", permissionsType='" + permissionsType + '\'' +
                ", url='" + url + '\'' +
                ", permissionsCode='" + permissionsCode + '\'' +
                ", parentId=" + parentId +
                ", createTime=" + createTime +
                ", updateTime=" + updateTime +
                '}';
    }
}