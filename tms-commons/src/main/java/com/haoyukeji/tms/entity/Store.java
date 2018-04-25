package com.haoyukeji.tms.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * @author 
 */
public class Store implements Serializable {
    private Integer id;

    /**
     * 售票点名称
     */
    private String storeName;

    /**
     * 售票点电话
     */
    private String storeMobile;

    /**
     * 售票点法人
     */
    private String storeAdmin;

    /**
     * 售票点地址
     */
    private String storeAddress;

    /**
     * 营业执照
     */
    private String storeProof;

    /**
     * 法人身份证正面
     */
    private String storeIdcardFront;

    /**
     * 法人身份证反面
     */
    private String storeIdcardNegative;

    /**
     * 售票点经度
     */
    private String storeLongitude;

    /**
     * 售票点纬度
     */
    private String storeLatitude;

    /**
     * 售票点状态
     */
    private String storeState;

    /**
     * 售票点开业时间
     */
    private Date storeCreateTime;

    /**
     * 修改时间
     */
    private Date storeUpdateTime;

    private Integer storeAccountId;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getStoreName() {
        return storeName;
    }

    public void setStoreName(String storeName) {
        this.storeName = storeName;
    }

    public String getStoreMobile() {
        return storeMobile;
    }

    public void setStoreMobile(String storeMobile) {
        this.storeMobile = storeMobile;
    }

    public String getStoreAdmin() {
        return storeAdmin;
    }

    public void setStoreAdmin(String storeAdmin) {
        this.storeAdmin = storeAdmin;
    }

    public String getStoreAddress() {
        return storeAddress;
    }

    public void setStoreAddress(String storeAddress) {
        this.storeAddress = storeAddress;
    }

    public String getStoreProof() {
        return storeProof;
    }

    public void setStoreProof(String storeProof) {
        this.storeProof = storeProof;
    }

    public String getStoreIdcardFront() {
        return storeIdcardFront;
    }

    public void setStoreIdcardFront(String storeIdcardFront) {
        this.storeIdcardFront = storeIdcardFront;
    }

    public String getStoreIdcardNegative() {
        return storeIdcardNegative;
    }

    public void setStoreIdcardNegative(String storeIdcardNegative) {
        this.storeIdcardNegative = storeIdcardNegative;
    }

    public String getStoreLongitude() {
        return storeLongitude;
    }

    public void setStoreLongitude(String storeLongitude) {
        this.storeLongitude = storeLongitude;
    }

    public String getStoreLatitude() {
        return storeLatitude;
    }

    public void setStoreLatitude(String storeLatitude) {
        this.storeLatitude = storeLatitude;
    }

    public String getStoreState() {
        return storeState;
    }

    public void setStoreState(String storeState) {
        this.storeState = storeState;
    }

    public Date getStoreCreateTime() {
        return storeCreateTime;
    }

    public void setStoreCreateTime(Date storeCreateTime) {
        this.storeCreateTime = storeCreateTime;
    }

    public Integer getStoreAccountId() {
        return storeAccountId;
    }

    public void setStoreAccountId(Integer storeAccountId) {
        this.storeAccountId = storeAccountId;
    }

    public Date getStoreUpdateTime() {
        return storeUpdateTime;
    }

    public void setStoreUpdateTime(Date storeUpdateTime) {
        this.storeUpdateTime = storeUpdateTime;
    }
}