package com.haoyukeji.tms.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * @author 
 */
public class TicketInStock implements Serializable {

    private Integer id;
    /**
     * 入库人ID
     */
    private Integer inStockId;

    /**
     * 入库人姓名
     */
    private String  inStockName;

    /**
     * 入库数量
     */
    private Integer inStockNum;

    /**
     * 总数量
     */
    private Integer inStockSum;

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

    /**
     * 入库记录
     */
    private String inStockContent;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getInStockId() {
        return inStockId;
    }

    public void setInStockId(Integer inStockId) {
        this.inStockId = inStockId;
    }

    public String getInStockName() {
        return inStockName;
    }

    public void setInStockName(String inStockName) {
        this.inStockName = inStockName;
    }

    public Integer getInStockNum() {
        return inStockNum;
    }

    public void setInStockNum(Integer inStockNum) {
        this.inStockNum = inStockNum;
    }

    public Integer getInStockSum() {
        return inStockSum;
    }

    public void setInStockSum(int inStockSum) {
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

    public String getInStockContent() {
        return inStockContent;
    }

    public void setInStockContent(String inStockContent) {
        this.inStockContent = inStockContent;
    }

    @Override
    public String toString() {
        return "TicketInStock{" +
                "id=" + id +
                ", inStockId=" + inStockId +
                ", inStockName='" + inStockName + '\'' +
                ", inStockNum=" + inStockNum +
                ", inStockSum=" + inStockSum +
                ", inStockStart='" + inStockStart + '\'' +
                ", inStockEnd='" + inStockEnd + '\'' +
                ", createTime=" + createTime +
                ", updateTime=" + updateTime +
                ", ticketInStockState='" + ticketInStockState + '\'' +
                ", inStockContent='" + inStockContent + '\'' +
                '}';
    }
}
