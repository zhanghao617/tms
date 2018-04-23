package com.haoyukeji.tms.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * @author 
 */
public class AccountLoginLog implements Serializable {
    private Integer id;

    private String loginIp;

    private Date createTime;

    private Date updateTime;

    private String accountLoginLogcol;

    private Integer accountAccountId;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getLoginIp() {
        return loginIp;
    }

    public void setLoginIp(String loginIp) {
        this.loginIp = loginIp;
    }

    public Date getCreateTime(Date date) {
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

    public String getAccountLoginLogcol() {
        return accountLoginLogcol;
    }

    public void setAccountLoginLogcol(String accountLoginLogcol) {
        this.accountLoginLogcol = accountLoginLogcol;
    }

    public Integer getAccountAccountId() {
        return accountAccountId;
    }

    public void setAccountAccountId(Integer accountAccountId) {
        this.accountAccountId = accountAccountId;
    }
}