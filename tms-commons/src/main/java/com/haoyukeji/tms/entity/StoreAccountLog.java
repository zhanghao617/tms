package com.haoyukeji.tms.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * @author 
 */
public class StoreAccountLog implements Serializable {
    private Integer id;

    /**
     * 登陆ip
     */
    private String storeAccountIp;

    private Date createTime;

    private Integer storeAccountId;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getStoreAccountIp() {
        return storeAccountIp;
    }

    public void setStoreAccountIp(String storeAccountIp) {
        this.storeAccountIp = storeAccountIp;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Integer getStoreAccountId() {
        return storeAccountId;
    }

    public void setStoreAccountId(Integer storeAccountId) {
        this.storeAccountId = storeAccountId;
    }
}