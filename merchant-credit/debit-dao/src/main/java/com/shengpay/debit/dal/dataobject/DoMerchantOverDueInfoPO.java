package com.shengpay.debit.dal.dataobject;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class DoMerchantOverDueInfoPO implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * DECIMAL(18) 必填<br>
     * 
     */
    private Long id;

    /**
     * DECIMAL(18)<br>
     * 借款订单号
     */
    private Long borrowOrderId;

    /**
     * TIMESTAMP(7)<br>
     * 计算日期
     */
    private Date calDate;

    /**
     * DECIMAL(18,2)<br>
     * 逾期金额
     */
    private BigDecimal overDueAmount;

    /**
     * TIMESTAMP(11,6) 必填<br>
     * 创建时间
     */
    private Date createTime;

    /**
     * TIMESTAMP(11,6) 必填<br>
     * 更新时间
     */
    private Date updateTime;

    /**
     * VARCHAR(5) 必填<br>
     * 状态
     */
    private String status;

    /**
     * DECIMAL(18) 必填<br>
     */
    public Long getId() {
        return id;
    }

    /**
     * DECIMAL(18) 必填<br>
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * DECIMAL(18)<br>
     * 获得 借款订单号
     */
    public Long getBorrowOrderId() {
        return borrowOrderId;
    }

    /**
     * DECIMAL(18)<br>
     * 设置 借款订单号
     */
    public void setBorrowOrderId(Long borrowOrderId) {
        this.borrowOrderId = borrowOrderId;
    }

    /**
     * TIMESTAMP(7)<br>
     * 获得 计算日期
     */
    public Date getCalDate() {
        return calDate;
    }

    /**
     * TIMESTAMP(7)<br>
     * 设置 计算日期
     */
    public void setCalDate(Date calDate) {
        this.calDate = calDate;
    }

    /**
     * DECIMAL(18,2)<br>
     * 获得 逾期金额
     */
    public BigDecimal getOverDueAmount() {
        return overDueAmount;
    }

    /**
     * DECIMAL(18,2)<br>
     * 设置 逾期金额
     */
    public void setOverDueAmount(BigDecimal overDueAmount) {
        this.overDueAmount = overDueAmount;
    }

    /**
     * TIMESTAMP(11,6) 必填<br>
     * 获得 创建时间
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * TIMESTAMP(11,6) 必填<br>
     * 设置 创建时间
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * TIMESTAMP(11,6) 必填<br>
     * 获得 更新时间
     */
    public Date getUpdateTime() {
        return updateTime;
    }

    /**
     * TIMESTAMP(11,6) 必填<br>
     * 设置 更新时间
     */
    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    /**
     * VARCHAR(5) 必填<br>
     * 获得 状态
     */
    public String getStatus() {
        return status;
    }

    /**
     * VARCHAR(5) 必填<br>
     * 设置 状态
     */
    public void setStatus(String status) {
        this.status = status == null ? null : status.trim();
    }
}