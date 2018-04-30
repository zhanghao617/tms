package com.haoyukeji.tms.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * @author 
 */
public class Ticket implements Serializable {

    public static final String TICKET_IN_STORE = "已入库";
    public static final String TICKET_ISSUED = "已下发";
    public static final String TICKET_SOLD = "已销售";
    public static final String TICKET_LOST = "已挂失";
    public static final String TICKET_INVALID = "已作废";
    public static final String TICKET_OVERDUE = "已逾期";

    private Integer id;

    private String state;

    /**
     * 票号
     */
    private String ticketNum;

    /**
     * 年票总数
     */
    private String ticketSum;

    /**
     * 年票入库时间
     */
    private Date ticketInTime;

    /**
     * 年票状态
     */
    private String ticketState;

    private Date createTime;

    private Date updateTime;

    /**
     * 下发时间
     */
    private Date ticketOnTime;

    /**
     * 年票办理时间
     */
    private Date ticketStartTime;

    /**
     * 年票到期时间
     */
    private Date ticketEndTime;

    private Integer storeAccountId;

    private Integer ticketInStockId;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getTicketNum() {
        return ticketNum;
    }

    public void setTicketNum(String ticketNum) {
        this.ticketNum = ticketNum;
    }

    public String getTicketSum() {
        return ticketSum;
    }

    public void setTicketSum(String ticketSum) {
        this.ticketSum = ticketSum;
    }

    public Date getTicketInTime() {
        return ticketInTime;
    }

    public void setTicketInTime(Date ticketInTime) {
        this.ticketInTime = ticketInTime;
    }

    public String getTicketState() {
        return ticketState;
    }

    public void setTicketState(String ticketState) {
        this.ticketState = ticketState;
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

    public Date getTicketOnTime() {
        return ticketOnTime;
    }

    public void setTicketOnTime(Date ticketOnTime) {
        this.ticketOnTime = ticketOnTime;
    }

    public Date getTicketStartTime() {
        return ticketStartTime;
    }

    public void setTicketStartTime(Date ticketStartTime) {
        this.ticketStartTime = ticketStartTime;
    }

    public Date getTicketEndTime() {
        return ticketEndTime;
    }

    public void setTicketEndTime(Date ticketEndTime) {
        this.ticketEndTime = ticketEndTime;
    }

    public Integer getStoreAccountId() {
        return storeAccountId;
    }

    public void setStoreAccountId(Integer storeAccountId) {
        this.storeAccountId = storeAccountId;
    }

    public Integer getTicketInStockId() {
        return ticketInStockId;
    }

    public void setTicketInStockId(Integer ticketInStockId) {
        this.ticketInStockId = ticketInStockId;
    }
}