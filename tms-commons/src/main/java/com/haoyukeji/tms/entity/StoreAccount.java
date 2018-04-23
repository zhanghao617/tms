package com.haoyukeji.tms.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * @author 
 */
public class StoreAccount implements Serializable {

    public static final String ACCOUNT_STATE_NORMAL= "正常";
    public static final String ACCOUNT_STATE_LOCK= "锁定";
    public static final String ACCOUNT_STATE_DISABLED= "禁用";

    private Integer id;

    private String storeAccountName;

    private String storeAccountMobile;

    private String storeAccountPassword;

    /**
     * 售票点账号创建时间
     */
    private Date storeAccountCreateTime;

    /**
     * 售票点账号修改时间
     */
    private Date storeAccountUpdateTime;

    private String storeAccountState;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getStoreAccountName() {
        return storeAccountName;
    }

    public void setStoreAccountName(String storeAccountName) {
        this.storeAccountName = storeAccountName;
    }

    public String getStoreAccountMobile() {
        return storeAccountMobile;
    }

    public void setStoreAccountMobile(String storeAccountMobile) {
        this.storeAccountMobile = storeAccountMobile;
    }

    public String getStoreAccountPassword() {
        return storeAccountPassword;
    }

    public void setStoreAccountPassword(String storeAccountPassword) {
        this.storeAccountPassword = storeAccountPassword;
    }

    public Date getStoreAccountCreateTime() {
        return storeAccountCreateTime;
    }

    public void setStoreAccountCreateTime(Date storeAccountCreateTime) {
        this.storeAccountCreateTime = storeAccountCreateTime;
    }

    public Date getStoreAccountUpdateTime() {
        return storeAccountUpdateTime;
    }

    public void setStoreAccountUpdateTime(Date storeAccountUpdateTime) {
        this.storeAccountUpdateTime = storeAccountUpdateTime;
    }

    public String getStoreAccountState() {
        return storeAccountState;
    }

    public void setStoreAccountState(String storeAccountState) {
        this.storeAccountState = storeAccountState;
    }
}