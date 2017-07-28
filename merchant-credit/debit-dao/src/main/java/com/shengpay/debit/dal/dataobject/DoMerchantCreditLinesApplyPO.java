package com.shengpay.debit.dal.dataobject;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class DoMerchantCreditLinesApplyPO implements Serializable {
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
     * 
     */
    private String merchantName;

    /**
     * VARCHAR(8) 必填<br>
     * 申请状态
     */
    private String applyStatus;

    /**
     * VARCHAR(32)<br>
     * 代理商ID
     */
    private String promoterNo;

    /**
     * VARCHAR(400)<br>
     * 代理商名称
     */
    private String promoterName;

    /**
     * VARCHAR(4000)<br>
     * 申请人信息资料
     */
    private String applyMerchantInfo;

    /**
     * TIMESTAMP(11,6)<br>
     * 商户提交代理商时间
     */
    private Date merchantApplyAgentTime;

    /**
     * VARCHAR(32)<br>
     * 是否需要代理商担保
     */
    private String isAgnetGuarantee;

    /**
     * VARCHAR(32)<br>
     * 
     */
    private String isNeedAgnetGuarantee;

    /**
     * TIMESTAMP(11,6)<br>
     * 商户申请提交时间
     */
    private Date applyStartTime;

    /**
     * TIMESTAMP(11,6)<br>
     * 后台提交到风控时间
     */
    private Date applyRiskTime;

    /**
     * TIMESTAMP(11,6)<br>
     * 风控返回确认时间
     */
    private Date riskAnswerTime;

    /**
     * TIMESTAMP(11,6)<br>
     * 用户提交资料确认时间
     */
    private Date merchantSendDataTime;

    /**
     * TIMESTAMP(11,6)<br>
     * 资金发放时间
     */
    private Date borrowTime;

    /**
     * TIMESTAMP(11,6) 必填<br>
     * 
     */
    private Date createTime;

    /**
     * TIMESTAMP(11,6)<br>
     * 最近更新时间
     */
    private Date updateTime;

    /**
     * VARCHAR(32)<br>
     * 审批返回级别
     */
    private String riskLevel;

    /**
     * DECIMAL(18,2)<br>
     * 放款额度
     */
    private BigDecimal lendAmount;

    /**
     * TIMESTAMP(11,6)<br>
     * 额度生效开始日
     */
    private Date policyStartTime;

    /**
     * TIMESTAMP(11,6)<br>
     * 额度生效结束日
     */
    private Date policyEndTime;

    /**
     * VARCHAR(32)<br>
     * 放款机构
     */
    private String organizationCode;

    /**
     * VARCHAR(32)<br>
     * 放款钱包账户
     */
    private String lendWallerAccount;

    /**
     * VARCHAR(32)<br>
     * 放款MemberId
     */
    private String lendMemberId;

    /**
     * VARCHAR(128)<br>
     * 放款账户登录名
     */
    private String lendLoginName;

    /**
     * VARCHAR(128)<br>
     * 
     */
    private String auditorName;

    /**
     * VARCHAR(64)<br>
     * 商户MemberId
     */
    private String merchantMemberid;

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
     */
    public String getMerchantName() {
        return merchantName;
    }

    /**
     * VARCHAR(400)<br>
     */
    public void setMerchantName(String merchantName) {
        this.merchantName = merchantName == null ? null : merchantName.trim();
    }

    /**
     * VARCHAR(8) 必填<br>
     * 获得 申请状态
     */
    public String getApplyStatus() {
        return applyStatus;
    }

    /**
     * VARCHAR(8) 必填<br>
     * 设置 申请状态
     */
    public void setApplyStatus(String applyStatus) {
        this.applyStatus = applyStatus == null ? null : applyStatus.trim();
    }

    /**
     * VARCHAR(32)<br>
     * 获得 代理商ID
     */
    public String getPromoterNo() {
        return promoterNo;
    }

    /**
     * VARCHAR(32)<br>
     * 设置 代理商ID
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
     * VARCHAR(4000)<br>
     * 获得 申请人信息资料
     */
    public String getApplyMerchantInfo() {
        return applyMerchantInfo;
    }

    /**
     * VARCHAR(4000)<br>
     * 设置 申请人信息资料
     */
    public void setApplyMerchantInfo(String applyMerchantInfo) {
        this.applyMerchantInfo = applyMerchantInfo == null ? null : applyMerchantInfo.trim();
    }

    /**
     * TIMESTAMP(11,6)<br>
     * 获得 商户提交代理商时间
     */
    public Date getMerchantApplyAgentTime() {
        return merchantApplyAgentTime;
    }

    /**
     * TIMESTAMP(11,6)<br>
     * 设置 商户提交代理商时间
     */
    public void setMerchantApplyAgentTime(Date merchantApplyAgentTime) {
        this.merchantApplyAgentTime = merchantApplyAgentTime;
    }

    /**
     * VARCHAR(32)<br>
     * 获得 是否需要代理商担保
     */
    public String getIsAgnetGuarantee() {
        return isAgnetGuarantee;
    }

    /**
     * VARCHAR(32)<br>
     * 设置 是否需要代理商担保
     */
    public void setIsAgnetGuarantee(String isAgnetGuarantee) {
        this.isAgnetGuarantee = isAgnetGuarantee == null ? null : isAgnetGuarantee.trim();
    }

    /**
     * VARCHAR(32)<br>
     */
    public String getIsNeedAgnetGuarantee() {
        return isNeedAgnetGuarantee;
    }

    /**
     * VARCHAR(32)<br>
     */
    public void setIsNeedAgnetGuarantee(String isNeedAgnetGuarantee) {
        this.isNeedAgnetGuarantee = isNeedAgnetGuarantee == null ? null : isNeedAgnetGuarantee.trim();
    }

    /**
     * TIMESTAMP(11,6)<br>
     * 获得 商户申请提交时间
     */
    public Date getApplyStartTime() {
        return applyStartTime;
    }

    /**
     * TIMESTAMP(11,6)<br>
     * 设置 商户申请提交时间
     */
    public void setApplyStartTime(Date applyStartTime) {
        this.applyStartTime = applyStartTime;
    }

    /**
     * TIMESTAMP(11,6)<br>
     * 获得 后台提交到风控时间
     */
    public Date getApplyRiskTime() {
        return applyRiskTime;
    }

    /**
     * TIMESTAMP(11,6)<br>
     * 设置 后台提交到风控时间
     */
    public void setApplyRiskTime(Date applyRiskTime) {
        this.applyRiskTime = applyRiskTime;
    }

    /**
     * TIMESTAMP(11,6)<br>
     * 获得 风控返回确认时间
     */
    public Date getRiskAnswerTime() {
        return riskAnswerTime;
    }

    /**
     * TIMESTAMP(11,6)<br>
     * 设置 风控返回确认时间
     */
    public void setRiskAnswerTime(Date riskAnswerTime) {
        this.riskAnswerTime = riskAnswerTime;
    }

    /**
     * TIMESTAMP(11,6)<br>
     * 获得 用户提交资料确认时间
     */
    public Date getMerchantSendDataTime() {
        return merchantSendDataTime;
    }

    /**
     * TIMESTAMP(11,6)<br>
     * 设置 用户提交资料确认时间
     */
    public void setMerchantSendDataTime(Date merchantSendDataTime) {
        this.merchantSendDataTime = merchantSendDataTime;
    }

    /**
     * TIMESTAMP(11,6)<br>
     * 获得 资金发放时间
     */
    public Date getBorrowTime() {
        return borrowTime;
    }

    /**
     * TIMESTAMP(11,6)<br>
     * 设置 资金发放时间
     */
    public void setBorrowTime(Date borrowTime) {
        this.borrowTime = borrowTime;
    }

    /**
     * TIMESTAMP(11,6) 必填<br>
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * TIMESTAMP(11,6) 必填<br>
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * TIMESTAMP(11,6)<br>
     * 获得 最近更新时间
     */
    public Date getUpdateTime() {
        return updateTime;
    }

    /**
     * TIMESTAMP(11,6)<br>
     * 设置 最近更新时间
     */
    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    /**
     * VARCHAR(32)<br>
     * 获得 审批返回级别
     */
    public String getRiskLevel() {
        return riskLevel;
    }

    /**
     * VARCHAR(32)<br>
     * 设置 审批返回级别
     */
    public void setRiskLevel(String riskLevel) {
        this.riskLevel = riskLevel == null ? null : riskLevel.trim();
    }

    /**
     * DECIMAL(18,2)<br>
     * 获得 放款额度
     */
    public BigDecimal getLendAmount() {
        return lendAmount;
    }

    /**
     * DECIMAL(18,2)<br>
     * 设置 放款额度
     */
    public void setLendAmount(BigDecimal lendAmount) {
        this.lendAmount = lendAmount;
    }

    /**
     * TIMESTAMP(11,6)<br>
     * 获得 额度生效开始日
     */
    public Date getPolicyStartTime() {
        return policyStartTime;
    }

    /**
     * TIMESTAMP(11,6)<br>
     * 设置 额度生效开始日
     */
    public void setPolicyStartTime(Date policyStartTime) {
        this.policyStartTime = policyStartTime;
    }

    /**
     * TIMESTAMP(11,6)<br>
     * 获得 额度生效结束日
     */
    public Date getPolicyEndTime() {
        return policyEndTime;
    }

    /**
     * TIMESTAMP(11,6)<br>
     * 设置 额度生效结束日
     */
    public void setPolicyEndTime(Date policyEndTime) {
        this.policyEndTime = policyEndTime;
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
     * 获得 放款钱包账户
     */
    public String getLendWallerAccount() {
        return lendWallerAccount;
    }

    /**
     * VARCHAR(32)<br>
     * 设置 放款钱包账户
     */
    public void setLendWallerAccount(String lendWallerAccount) {
        this.lendWallerAccount = lendWallerAccount == null ? null : lendWallerAccount.trim();
    }

    /**
     * VARCHAR(32)<br>
     * 获得 放款MemberId
     */
    public String getLendMemberId() {
        return lendMemberId;
    }

    /**
     * VARCHAR(32)<br>
     * 设置 放款MemberId
     */
    public void setLendMemberId(String lendMemberId) {
        this.lendMemberId = lendMemberId == null ? null : lendMemberId.trim();
    }

    /**
     * VARCHAR(128)<br>
     * 获得 放款账户登录名
     */
    public String getLendLoginName() {
        return lendLoginName;
    }

    /**
     * VARCHAR(128)<br>
     * 设置 放款账户登录名
     */
    public void setLendLoginName(String lendLoginName) {
        this.lendLoginName = lendLoginName == null ? null : lendLoginName.trim();
    }

    /**
     * VARCHAR(128)<br>
     */
    public String getAuditorName() {
        return auditorName;
    }

    /**
     * VARCHAR(128)<br>
     */
    public void setAuditorName(String auditorName) {
        this.auditorName = auditorName == null ? null : auditorName.trim();
    }

    /**
     * VARCHAR(64)<br>
     * 获得 商户MemberId
     */
    public String getMerchantMemberid() {
        return merchantMemberid;
    }

    /**
     * VARCHAR(64)<br>
     * 设置 商户MemberId
     */
    public void setMerchantMemberid(String merchantMemberid) {
        this.merchantMemberid = merchantMemberid == null ? null : merchantMemberid.trim();
    }
}