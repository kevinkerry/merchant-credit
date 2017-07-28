package com.shengpay.debit.dal.dataobject;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class DmMerchantDebitInfoPO implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * DECIMAL(18) 必填<br>
     * 
     */
    private Long id;

    /**
     * VARCHAR(32) 必填<br>
     * 商户账户
     */
    private String merchantNo;

    /**
     * VARCHAR(400)<br>
     * 商户名称
     */
    private String merchantName;

    /**
     * VARCHAR(32) 必填<br>
     * 账户状态
     */
    private String status;

    /**
     * VARCHAR(32)<br>
     * 担保代理商
     */
    private String promoterNo;

    /**
     * VARCHAR(400)<br>
     * 代理商名称
     */
    private String promoterName;

    /**
     * DECIMAL(18,2)<br>
     * 信用总额度
     */
    private BigDecimal totalAmount;

    /**
     * VARCHAR(32)<br>
     * 放款机构
     */
    private String organizationCode;

    /**
     * VARCHAR(32)<br>
     * 信用级别
     */
    private String riskLevel;

    /**
     * DECIMAL(18,2)<br>
     * 当前可用总额度
     */
    private BigDecimal canUseAmount;

    /**
     * DECIMAL(18,2)<br>
     * 当前贷款总额
     */
    private BigDecimal usedAmount;

    /**
     * DECIMAL(18,2)<br>
     * 逾期利息
     */
    private BigDecimal overDueAmount;

    /**
     * DECIMAL(18,2)<br>
     * 当前冻结资金总额
     */
    private BigDecimal frozenAmount;

    /**
     * TIMESTAMP(11,6)<br>
     * 配资生效开始日
     */
    private Date effectiveStartTime;

    /**
     * TIMESTAMP(11,6)<br>
     * 配资生效结束日
     */
    private Date effectiveEndTime;

    /**
     * VARCHAR(32)<br>
     * 放款MEMBER_ID
     */
    private String lendMemberId;

    /**
     * VARCHAR(32)<br>
     * 放款钱包账户
     */
    private String lendWalletAccount;

    /**
     * VARCHAR(64)<br>
     * 个人授信账户
     */
    private String creditAccount;

    /**
     * VARCHAR(64)<br>
     * 个人利息账户
     */
    private String interestAccount;

    /**
     * VARCHAR(256)<br>
     * 放款账户名
     */
    private String lendLoginName;

    /**
     * VARCHAR(64)<br>
     * 商户memberId
     */
    private String merchantMemberId;

    /**
     * VARCHAR(64)<br>
     * 商户钱包账户
     */
    private String merchantWallerAccount;

    /**
     * TIMESTAMP(11,6) 必填<br>
     * 创建时间
     */
    private Date createTime;

    /**
     * TIMESTAMP(11,6) 必填<br>
     * 更新时间
     */
    private Date endTime;

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
     * 获得 商户账户
     */
    public String getMerchantNo() {
        return merchantNo;
    }

    /**
     * VARCHAR(32) 必填<br>
     * 设置 商户账户
     */
    public void setMerchantNo(String merchantNo) {
        this.merchantNo = merchantNo == null ? null : merchantNo.trim();
    }

    /**
     * VARCHAR(400)<br>
     * 获得 商户名称
     */
    public String getMerchantName() {
        return merchantName;
    }

    /**
     * VARCHAR(400)<br>
     * 设置 商户名称
     */
    public void setMerchantName(String merchantName) {
        this.merchantName = merchantName == null ? null : merchantName.trim();
    }

    /**
     * VARCHAR(32) 必填<br>
     * 获得 账户状态
     */
    public String getStatus() {
        return status;
    }

    /**
     * VARCHAR(32) 必填<br>
     * 设置 账户状态
     */
    public void setStatus(String status) {
        this.status = status == null ? null : status.trim();
    }

    /**
     * VARCHAR(32)<br>
     * 获得 担保代理商
     */
    public String getPromoterNo() {
        return promoterNo;
    }

    /**
     * VARCHAR(32)<br>
     * 设置 担保代理商
     */
    public void setPromoterNo(String promoterNo) {
        this.promoterNo = promoterNo == null ? null : promoterNo.trim();
    }

    /**
     * VARCHAR(400)<br>
     * 获得 代理商名称
     */
    public String getPromoterName() {
        return promoterName;
    }

    /**
     * VARCHAR(400)<br>
     * 设置 代理商名称
     */
    public void setPromoterName(String promoterName) {
        this.promoterName = promoterName == null ? null : promoterName.trim();
    }

    /**
     * DECIMAL(18,2)<br>
     * 获得 信用总额度
     */
    public BigDecimal getTotalAmount() {
        return totalAmount;
    }

    /**
     * DECIMAL(18,2)<br>
     * 设置 信用总额度
     */
    public void setTotalAmount(BigDecimal totalAmount) {
        this.totalAmount = totalAmount;
    }

    /**
     * VARCHAR(32)<br>
     * 获得 放款机构
     */
    public String getOrganizationCode() {
        return organizationCode;
    }

    /**
     * VARCHAR(32)<br>
     * 设置 放款机构
     */
    public void setOrganizationCode(String organizationCode) {
        this.organizationCode = organizationCode == null ? null : organizationCode.trim();
    }

    /**
     * VARCHAR(32)<br>
     * 获得 信用级别
     */
    public String getRiskLevel() {
        return riskLevel;
    }

    /**
     * VARCHAR(32)<br>
     * 设置 信用级别
     */
    public void setRiskLevel(String riskLevel) {
        this.riskLevel = riskLevel == null ? null : riskLevel.trim();
    }

    /**
     * DECIMAL(18,2)<br>
     * 获得 当前可用总额度
     */
    public BigDecimal getCanUseAmount() {
        return canUseAmount;
    }

    /**
     * DECIMAL(18,2)<br>
     * 设置 当前可用总额度
     */
    public void setCanUseAmount(BigDecimal canUseAmount) {
        this.canUseAmount = canUseAmount;
    }

    /**
     * DECIMAL(18,2)<br>
     * 获得 当前贷款总额
     */
    public BigDecimal getUsedAmount() {
        return usedAmount;
    }

    /**
     * DECIMAL(18,2)<br>
     * 设置 当前贷款总额
     */
    public void setUsedAmount(BigDecimal usedAmount) {
        this.usedAmount = usedAmount;
    }

    /**
     * DECIMAL(18,2)<br>
     * 获得 逾期利息
     */
    public BigDecimal getOverDueAmount() {
        return overDueAmount;
    }

    /**
     * DECIMAL(18,2)<br>
     * 设置 逾期利息
     */
    public void setOverDueAmount(BigDecimal overDueAmount) {
        this.overDueAmount = overDueAmount;
    }

    /**
     * DECIMAL(18,2)<br>
     * 获得 当前冻结资金总额
     */
    public BigDecimal getFrozenAmount() {
        return frozenAmount;
    }

    /**
     * DECIMAL(18,2)<br>
     * 设置 当前冻结资金总额
     */
    public void setFrozenAmount(BigDecimal frozenAmount) {
        this.frozenAmount = frozenAmount;
    }

    /**
     * TIMESTAMP(11,6)<br>
     * 获得 配资生效开始日
     */
    public Date getEffectiveStartTime() {
        return effectiveStartTime;
    }

    /**
     * TIMESTAMP(11,6)<br>
     * 设置 配资生效开始日
     */
    public void setEffectiveStartTime(Date effectiveStartTime) {
        this.effectiveStartTime = effectiveStartTime;
    }

    /**
     * TIMESTAMP(11,6)<br>
     * 获得 配资生效结束日
     */
    public Date getEffectiveEndTime() {
        return effectiveEndTime;
    }

    /**
     * TIMESTAMP(11,6)<br>
     * 设置 配资生效结束日
     */
    public void setEffectiveEndTime(Date effectiveEndTime) {
        this.effectiveEndTime = effectiveEndTime;
    }

    /**
     * VARCHAR(32)<br>
     * 获得 放款MEMBER_ID
     */
    public String getLendMemberId() {
        return lendMemberId;
    }

    /**
     * VARCHAR(32)<br>
     * 设置 放款MEMBER_ID
     */
    public void setLendMemberId(String lendMemberId) {
        this.lendMemberId = lendMemberId == null ? null : lendMemberId.trim();
    }

    /**
     * VARCHAR(32)<br>
     * 获得 放款钱包账户
     */
    public String getLendWalletAccount() {
        return lendWalletAccount;
    }

    /**
     * VARCHAR(32)<br>
     * 设置 放款钱包账户
     */
    public void setLendWalletAccount(String lendWalletAccount) {
        this.lendWalletAccount = lendWalletAccount == null ? null : lendWalletAccount.trim();
    }

    /**
     * VARCHAR(64)<br>
     * 获得 个人授信账户
     */
    public String getCreditAccount() {
        return creditAccount;
    }

    /**
     * VARCHAR(64)<br>
     * 设置 个人授信账户
     */
    public void setCreditAccount(String creditAccount) {
        this.creditAccount = creditAccount == null ? null : creditAccount.trim();
    }

    /**
     * VARCHAR(64)<br>
     * 获得 个人利息账户
     */
    public String getInterestAccount() {
        return interestAccount;
    }

    /**
     * VARCHAR(64)<br>
     * 设置 个人利息账户
     */
    public void setInterestAccount(String interestAccount) {
        this.interestAccount = interestAccount == null ? null : interestAccount.trim();
    }

    /**
     * VARCHAR(256)<br>
     * 获得 放款账户名
     */
    public String getLendLoginName() {
        return lendLoginName;
    }

    /**
     * VARCHAR(256)<br>
     * 设置 放款账户名
     */
    public void setLendLoginName(String lendLoginName) {
        this.lendLoginName = lendLoginName == null ? null : lendLoginName.trim();
    }

    /**
     * VARCHAR(64)<br>
     * 获得 商户memberId
     */
    public String getMerchantMemberId() {
        return merchantMemberId;
    }

    /**
     * VARCHAR(64)<br>
     * 设置 商户memberId
     */
    public void setMerchantMemberId(String merchantMemberId) {
        this.merchantMemberId = merchantMemberId == null ? null : merchantMemberId.trim();
    }

    /**
     * VARCHAR(64)<br>
     * 获得 商户钱包账户
     */
    public String getMerchantWallerAccount() {
        return merchantWallerAccount;
    }

    /**
     * VARCHAR(64)<br>
     * 设置 商户钱包账户
     */
    public void setMerchantWallerAccount(String merchantWallerAccount) {
        this.merchantWallerAccount = merchantWallerAccount == null ? null : merchantWallerAccount.trim();
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
    public Date getEndTime() {
        return endTime;
    }

    /**
     * TIMESTAMP(11,6) 必填<br>
     * 设置 更新时间
     */
    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }
}