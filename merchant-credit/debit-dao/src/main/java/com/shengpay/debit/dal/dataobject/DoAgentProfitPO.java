package com.shengpay.debit.dal.dataobject;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class DoAgentProfitPO implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * DECIMAL(18) 必填<br>
     * 
     */
    private Long id;

    /**
     * VARCHAR(32)<br>
     * 代理商商户号
     */
    private String promoterNo;

    /**
     * VARCHAR(32)<br>
     * 
     */
    private String borrowOrderId;

    /**
     * DECIMAL(18,2)<br>
     * 
     */
    private BigDecimal amount;

    /**
     * VARCHAR(32)<br>
     * 状态
     */
    private String status;

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
     * VARCHAR(32)<br>
     * 获得 代理商商户号
     */
    public String getPromoterNo() {
        return promoterNo;
    }

    /**
     * VARCHAR(32)<br>
     * 设置 代理商商户号
     */
    public void setPromoterNo(String promoterNo) {
        this.promoterNo = promoterNo == null ? null : promoterNo.trim();
    }

    /**
     * VARCHAR(32)<br>
     */
    public String getBorrowOrderId() {
        return borrowOrderId;
    }

    /**
     * VARCHAR(32)<br>
     */
    public void setBorrowOrderId(String borrowOrderId) {
        this.borrowOrderId = borrowOrderId == null ? null : borrowOrderId.trim();
    }

    /**
     * DECIMAL(18,2)<br>
     */
    public BigDecimal getAmount() {
        return amount;
    }

    /**
     * DECIMAL(18,2)<br>
     */
    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    /**
     * VARCHAR(32)<br>
     * 获得 状态
     */
    public String getStatus() {
        return status;
    }

    /**
     * VARCHAR(32)<br>
     * 设置 状态
     */
    public void setStatus(String status) {
        this.status = status == null ? null : status.trim();
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
}