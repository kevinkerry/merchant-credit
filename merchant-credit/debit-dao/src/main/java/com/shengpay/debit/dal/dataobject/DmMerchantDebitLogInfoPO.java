package com.shengpay.debit.dal.dataobject;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class DmMerchantDebitLogInfoPO implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * DECIMAL(18) 必填<br>
     * 
     */
    private Long id;

    /**
     * VARCHAR(32)<br>
     * 商户号
     */
    private String merchantNo;

    /**
     * VARCHAR(32)<br>
     * 机构号
     */
    private String organizationCode;

    /**
     * DECIMAL(18,2)<br>
     * 变更前额度
     */
    private BigDecimal beforeAmount;

    /**
     * DECIMAL(18,2)<br>
     * 变更后额度
     */
    private BigDecimal afterAmount;

    /**
     * DECIMAL(18,2)<br>
     * 变更金额
     */
    private BigDecimal amount;

    /**
     * VARCHAR(32)<br>
     * 操作类型
     */
    private String operateType;

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
     * VARCHAR(32)<br>
     * 获得 商户号
     */
    public String getMerchantNo() {
        return merchantNo;
    }

    /**
     * VARCHAR(32)<br>
     * 设置 商户号
     */
    public void setMerchantNo(String merchantNo) {
        this.merchantNo = merchantNo == null ? null : merchantNo.trim();
    }

    /**
     * VARCHAR(32)<br>
     * 获得 机构号
     */
    public String getOrganizationCode() {
        return organizationCode;
    }

    /**
     * VARCHAR(32)<br>
     * 设置 机构号
     */
    public void setOrganizationCode(String organizationCode) {
        this.organizationCode = organizationCode == null ? null : organizationCode.trim();
    }

    /**
     * DECIMAL(18,2)<br>
     * 获得 变更前额度
     */
    public BigDecimal getBeforeAmount() {
        return beforeAmount;
    }

    /**
     * DECIMAL(18,2)<br>
     * 设置 变更前额度
     */
    public void setBeforeAmount(BigDecimal beforeAmount) {
        this.beforeAmount = beforeAmount;
    }

    /**
     * DECIMAL(18,2)<br>
     * 获得 变更后额度
     */
    public BigDecimal getAfterAmount() {
        return afterAmount;
    }

    /**
     * DECIMAL(18,2)<br>
     * 设置 变更后额度
     */
    public void setAfterAmount(BigDecimal afterAmount) {
        this.afterAmount = afterAmount;
    }

    /**
     * DECIMAL(18,2)<br>
     * 获得 变更金额
     */
    public BigDecimal getAmount() {
        return amount;
    }

    /**
     * DECIMAL(18,2)<br>
     * 设置 变更金额
     */
    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    /**
     * VARCHAR(32)<br>
     * 获得 操作类型
     */
    public String getOperateType() {
        return operateType;
    }

    /**
     * VARCHAR(32)<br>
     * 设置 操作类型
     */
    public void setOperateType(String operateType) {
        this.operateType = operateType == null ? null : operateType.trim();
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