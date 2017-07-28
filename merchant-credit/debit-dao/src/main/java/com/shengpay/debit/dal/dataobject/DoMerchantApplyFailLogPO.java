package com.shengpay.debit.dal.dataobject;

import java.io.Serializable;
import java.util.Date;

public class DoMerchantApplyFailLogPO implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * DECIMAL(18) 必填<br>
     * 
     */
    private Long id;

    /**
     * DECIMAL(18)<br>
     * 申请额度ID
     */
    private Long applyId;

    /**
     * VARCHAR(400)<br>
     * 失败原因
     */
    private String failReason;

    /**
     * TIMESTAMP(11,6)<br>
     * 创建时间
     */
    private Date createTime;

    /**
     * TIMESTAMP(11,6)<br>
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
     * DECIMAL(18)<br>
     * 获得 申请额度ID
     */
    public Long getApplyId() {
        return applyId;
    }

    /**
     * DECIMAL(18)<br>
     * 设置 申请额度ID
     */
    public void setApplyId(Long applyId) {
        this.applyId = applyId;
    }

    /**
     * VARCHAR(400)<br>
     * 获得 失败原因
     */
    public String getFailReason() {
        return failReason;
    }

    /**
     * VARCHAR(400)<br>
     * 设置 失败原因
     */
    public void setFailReason(String failReason) {
        this.failReason = failReason == null ? null : failReason.trim();
    }

    /**
     * TIMESTAMP(11,6)<br>
     * 获得 创建时间
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * TIMESTAMP(11,6)<br>
     * 设置 创建时间
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * TIMESTAMP(11,6)<br>
     * 获得 更新时间
     */
    public Date getUpdateTime() {
        return updateTime;
    }

    /**
     * TIMESTAMP(11,6)<br>
     * 设置 更新时间
     */
    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }
}