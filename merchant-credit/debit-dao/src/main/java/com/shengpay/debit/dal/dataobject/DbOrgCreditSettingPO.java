package com.shengpay.debit.dal.dataobject;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class DbOrgCreditSettingPO implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * DECIMAL(18) 必填<br>
     * 
     */
    private Long id;

    /**
     * VARCHAR(32) 必填<br>
     * 机构号
     */
    private String orgnizationCode;

    /**
     * VARCHAR(32) 必填<br>
     * 风控级别
     */
    private String riskLevel;

    /**
     * DECIMAL(18,2) 必填<br>
     * 额度
     */
    private BigDecimal amountLimit;

    /**
     * DECIMAL(18,2) 必填<br>
     * 系数
     */
    private BigDecimal discount;

    /**
     * DECIMAL(18,2) 必填<br>
     * 日息利率
     */
    private BigDecimal interestRateDay;

    /**
     * TIMESTAMP(11,6) 默认值[sysdate
] 必填<br>
     * 创建时间
     */
    private Date createTime;

    /**
     * TIMESTAMP(11,6) 默认值[sysdate
] 必填<br>
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
     * VARCHAR(32) 必填<br>
     * 获得 机构号
     */
    public String getOrgnizationCode() {
        return orgnizationCode;
    }

    /**
     * VARCHAR(32) 必填<br>
     * 设置 机构号
     */
    public void setOrgnizationCode(String orgnizationCode) {
        this.orgnizationCode = orgnizationCode == null ? null : orgnizationCode.trim();
    }

    /**
     * VARCHAR(32) 必填<br>
     * 获得 风控级别
     */
    public String getRiskLevel() {
        return riskLevel;
    }

    /**
     * VARCHAR(32) 必填<br>
     * 设置 风控级别
     */
    public void setRiskLevel(String riskLevel) {
        this.riskLevel = riskLevel == null ? null : riskLevel.trim();
    }

    /**
     * DECIMAL(18,2) 必填<br>
     * 获得 额度
     */
    public BigDecimal getAmountLimit() {
        return amountLimit;
    }

    /**
     * DECIMAL(18,2) 必填<br>
     * 设置 额度
     */
    public void setAmountLimit(BigDecimal amountLimit) {
        this.amountLimit = amountLimit;
    }

    /**
     * DECIMAL(18,2) 必填<br>
     * 获得 系数
     */
    public BigDecimal getDiscount() {
        return discount;
    }

    /**
     * DECIMAL(18,2) 必填<br>
     * 设置 系数
     */
    public void setDiscount(BigDecimal discount) {
        this.discount = discount;
    }

    /**
     * DECIMAL(18,2) 必填<br>
     * 获得 日息利率
     */
    public BigDecimal getInterestRateDay() {
        return interestRateDay;
    }

    /**
     * DECIMAL(18,2) 必填<br>
     * 设置 日息利率
     */
    public void setInterestRateDay(BigDecimal interestRateDay) {
        this.interestRateDay = interestRateDay;
    }

    /**
     * TIMESTAMP(11,6) 默认值[sysdate
] 必填<br>
     * 获得 创建时间
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * TIMESTAMP(11,6) 默认值[sysdate
] 必填<br>
     * 设置 创建时间
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * TIMESTAMP(11,6) 默认值[sysdate
] 必填<br>
     * 获得 更新时间
     */
    public Date getUpdateTime() {
        return updateTime;
    }

    /**
     * TIMESTAMP(11,6) 默认值[sysdate
] 必填<br>
     * 设置 更新时间
     */
    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }
}