package com.haoyukeji.tms.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * @author 
 */
public class TicketInStock implements Serializable {
    private Integer id;

    /**
     * 入库人
     */
    private String inStockName;

    /**
     * 入库数量
     */
    private String inStockNum;

    /**
     * 总数量
     */
    private String inStockSum;

    /**
     * 入库开始票号
     */
    private String inStockStart;

    /**
     * 入库最终票号
     */
    private String inStockEnd;

    private Date createTime;

    private Date updateTime;

    /**
     * 现在的状态
     */
    private String ticketInStockState;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getInStockName() {
        return inStockName;
    }

    public void setInStockName(String inStockName) {
        this.inStockName = inStockName;
    }

    public String getInStockNum() {
        return inStockNum;
    }

    public void setInStockNum(String inStockNum) {
        this.inStockNum = inStockNum;
    }

    public String getInStockSum() {
        return inStockSum;
    }

    public void setInStockSum(String inStockSum) {
        this.inStockSum = inStockSum;
    }

    public String getInStockStart() {
        return inStockStart;
    }

    public void setInStockStart(String inStockStart) {
        this.inStockStart = inStockStart;
    }

    public String getInStockEnd() {
        return inStockEnd;
    }

    public void setInStockEnd(String inStockEnd) {
        this.inStockEnd = inStockEnd;
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

    public String getTicketInStockState() {
        return ticketInStockState;
    }

    public void setTicketInStockState(String ticketInStockState) {
        this.ticketInStockState = ticketInStockState;
    }
}