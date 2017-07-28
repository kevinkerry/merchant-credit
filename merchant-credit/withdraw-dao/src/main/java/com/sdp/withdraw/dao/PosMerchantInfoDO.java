package com.sdp.withdraw.dao;

import com.sdp.emall.common.dao.BaseDO;
import java.math.BigDecimal;
import java.util.Date;

public class PosMerchantInfoDO extends BaseDO {
    /**
     * This field corresponds to the database column FW_POS_MERCHANT_INFO.ID
     * column comments null
     *
     * @mbggenerated Wed Aug 10 08:42:07 CST 2016
     */
    private Long id;

    /**
     * This field corresponds to the database column FW_POS_MERCHANT_INFO.MERCHANT_NO
     * column comments 商户号
     *
     * @mbggenerated Wed Aug 10 08:42:07 CST 2016
     */
    private String merchantNo;

    /**
     * This field corresponds to the database column FW_POS_MERCHANT_INFO.POS_MERCHANT_ID
     * column comments POS维护的ID
     *
     * @mbggenerated Wed Aug 10 08:42:07 CST 2016
     */
    private Long posMerchantId;

    /**
     * This field corresponds to the database column FW_POS_MERCHANT_INFO.MERCHANT_TYPE
     * column comments 商户类型
POS商户：0001；机具方：0002；转接方：0004；miniPOS商户：0005；mPOS商户：0006；
POS拓展商：0003；mPOS拓展商：0007；miniPOS拓展商：0008；SDK拓展商：0009；机具厂商：0010；
     *
     * @mbggenerated Wed Aug 10 08:42:07 CST 2016
     */
    private String merchantType;

    /**
     * This field corresponds to the database column FW_POS_MERCHANT_INFO.PARENT_PROMOTER_ID
     * column comments 商户关联的代理商ID（资管的业务关联ID）
     *
     * @mbggenerated Wed Aug 10 08:42:07 CST 2016
     */
    private Long parentPromoterId;

    /**
     * This field corresponds to the database column FW_POS_MERCHANT_INFO.MERCHANT_MEMBER_ID
     * column comments 商户会员ID
     *
     * @mbggenerated Wed Aug 10 08:42:07 CST 2016
     */
    private String merchantMemberId;

    /**
     * This field corresponds to the database column FW_POS_MERCHANT_INFO.ACCOUNT_TYPE
     * column comments 商户类型
     *
     * @mbggenerated Wed Aug 10 08:42:07 CST 2016
     */
    private String accountType;

    /**
     * This field corresponds to the database column FW_POS_MERCHANT_INFO.BASE_ACCOUNT_ID
     * column comments 基本户账户
     *
     * @mbggenerated Wed Aug 10 08:42:07 CST 2016
     */
    private String baseAccountId;

    /**
     * This field corresponds to the database column FW_POS_MERCHANT_INFO.CREATE_TIME
     * column comments null
     *
     * @mbggenerated Wed Aug 10 08:42:07 CST 2016
     */
    private Date createTime;

    /**
     * This field corresponds to the database column FW_POS_MERCHANT_INFO.UPDATE_TIME
     * column comments null
     *
     * @mbggenerated Wed Aug 10 08:42:07 CST 2016
     */
    private Date updateTime;

    /**
     * This field corresponds to the database column FW_POS_MERCHANT_INFO.FAST_SETTLE_LIMIT
     * column comments 快速结算额度
     *
     * @mbggenerated Wed Aug 10 08:42:07 CST 2016
     */
    private BigDecimal fastSettleLimit;

    /**
     * This field corresponds to the database column FW_POS_MERCHANT_INFO.FAST_SETTLE_FLAG
     * column comments 快速结算标示
     *
     * @mbggenerated Wed Aug 10 08:42:07 CST 2016
     */
    private Integer fastSettleFlag;

    /**
     * This field corresponds to the database column FW_POS_MERCHANT_INFO.AUTO_FAST_SETTLE_FLAG
     * column comments 自动快速结算标示
     *
     * @mbggenerated Wed Aug 10 08:42:07 CST 2016
     */
    private Integer autoFastSettleFlag;

    /**
     * This field corresponds to the database column FW_POS_MERCHANT_INFO.MERCHANT_PHONE
     * column comments 商户对应的手机号
     *
     * @mbggenerated Wed Aug 10 08:42:07 CST 2016
     */
    private String merchantPhone;

    /**
     * This field corresponds to the database column FW_POS_MERCHANT_INFO.FAST_SETTLE_MARGIN
     * column comments 快速结算保证金
     *
     * @mbggenerated Wed Aug 10 08:42:07 CST 2016
     */
    private BigDecimal fastSettleMargin;

    /**
     * This field corresponds to the database column FW_POS_MERCHANT_INFO.FAST_SETTLE_MIN_LIMIT
     * column comments 快速结算最低金额
     *
     * @mbggenerated Wed Aug 10 08:42:07 CST 2016
     */
    private BigDecimal fastSettleMinLimit;

    /**
     * This field corresponds to the database column FW_POS_MERCHANT_INFO.PMT_BIND_OPERATOR_ID
     * column comments 商户对应的操作员ID
     *
     * @mbggenerated Wed Aug 10 08:42:07 CST 2016
     */
    private String pmtBindOperatorId;

    /**
     * This field corresponds to the database column FW_POS_MERCHANT_INFO.PMT_BIND_OPERATOR_NAME
     * column comments 商户对应的操作员名称
     *
     * @mbggenerated Wed Aug 10 08:42:07 CST 2016
     */
    private String pmtBindOperatorName;

    /**
     * This field corresponds to the database column FW_POS_MERCHANT_INFO.LOANING_TYPE
     * column comments 垫资方类型
     *
     * @mbggenerated Wed Aug 10 08:42:07 CST 2016
     */
    private Integer loaningType;

    /**
     * This field corresponds to the database column FW_POS_MERCHANT_INFO.STATUS
     * column comments 数据状态
     *
     * @mbggenerated Wed Aug 10 08:42:07 CST 2016
     */
    private String status;

    /**
     * This field corresponds to the database column FW_POS_MERCHANT_INFO.MERCHANT_NAME
     * column comments 商户名称
     *
     * @mbggenerated Wed Aug 10 08:42:07 CST 2016
     */
    private String merchantName;

    /**
     * This field corresponds to the database column FW_POS_MERCHANT_INFO.MCC
     * column comments 商户的mcc
     *
     * @mbggenerated Wed Aug 10 08:42:07 CST 2016
     */
    private String mcc;

    /**
     * This field corresponds to the database column FW_POS_MERCHANT_INFO.LAST_LEVEL_PROMOTER_ID
     * column comments 商户的二级代理商ID
     *
     * @mbggenerated Wed Aug 10 08:42:07 CST 2016
     */
    private Long lastLevelPromoterId;

    /**
     * This field corresponds to the database column FW_POS_MERCHANT_INFO.PMT_LEVEL
     * column comments 代理商等级
     *
     * @mbggenerated Wed Aug 10 08:42:07 CST 2016
     */
    private Integer pmtLevel;

    /**
     * This field corresponds to the database column FW_POS_MERCHANT_INFO.CERT_TYPE
     * column comments 证件类型
     *
     * @mbggenerated Wed Aug 10 08:42:07 CST 2016
     */
    private String certType;

    /**
     * This field corresponds to the database column FW_POS_MERCHANT_INFO.CERT_NO
     * column comments 证件号码
     *
     * @mbggenerated Wed Aug 10 08:42:07 CST 2016
     */
    private String certNo;

    /**
     * This method returns the value of the database column FW_POS_MERCHANT_INFO.ID
     *
     * @return the value of FW_POS_MERCHANT_INFO.ID
     * column comments null
     *
     * @mbggenerated Wed Aug 10 08:42:07 CST 2016
     */
    public Long getId() {
        return id;
    }

    /**
     * This method sets the value of the database column FW_POS_MERCHANT_INFO.ID
     *
     * @param id the value for FW_POS_MERCHANT_INFO.ID
     * column comments null
     *
     * @mbggenerated Wed Aug 10 08:42:07 CST 2016
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * This method returns the value of the database column FW_POS_MERCHANT_INFO.MERCHANT_NO
     *
     * @return the value of FW_POS_MERCHANT_INFO.MERCHANT_NO
     * column comments 商户号
     *
     * @mbggenerated Wed Aug 10 08:42:07 CST 2016
     */
    public String getMerchantNo() {
        return merchantNo;
    }

    /**
     * This method sets the value of the database column FW_POS_MERCHANT_INFO.MERCHANT_NO
     *
     * @param merchantNo the value for FW_POS_MERCHANT_INFO.MERCHANT_NO
     * column comments 商户号
     *
     * @mbggenerated Wed Aug 10 08:42:07 CST 2016
     */
    public void setMerchantNo(String merchantNo) {
        this.merchantNo = merchantNo == null ? null : merchantNo.trim();
    }

    /**
     * This method returns the value of the database column FW_POS_MERCHANT_INFO.POS_MERCHANT_ID
     *
     * @return the value of FW_POS_MERCHANT_INFO.POS_MERCHANT_ID
     * column comments POS维护的ID
     *
     * @mbggenerated Wed Aug 10 08:42:07 CST 2016
     */
    public Long getPosMerchantId() {
        return posMerchantId;
    }

    /**
     * This method sets the value of the database column FW_POS_MERCHANT_INFO.POS_MERCHANT_ID
     *
     * @param posMerchantId the value for FW_POS_MERCHANT_INFO.POS_MERCHANT_ID
     * column comments POS维护的ID
     *
     * @mbggenerated Wed Aug 10 08:42:07 CST 2016
     */
    public void setPosMerchantId(Long posMerchantId) {
        this.posMerchantId = posMerchantId;
    }

    /**
     * This method returns the value of the database column FW_POS_MERCHANT_INFO.MERCHANT_TYPE
     *
     * @return the value of FW_POS_MERCHANT_INFO.MERCHANT_TYPE
     * column comments 商户类型
POS商户：0001；机具方：0002；转接方：0004；miniPOS商户：0005；mPOS商户：0006；
POS拓展商：0003；mPOS拓展商：0007；miniPOS拓展商：0008；SDK拓展商：0009；机具厂商：0010；
     *
     * @mbggenerated Wed Aug 10 08:42:07 CST 2016
     */
    public String getMerchantType() {
        return merchantType;
    }

    /**
     * This method sets the value of the database column FW_POS_MERCHANT_INFO.MERCHANT_TYPE
     *
     * @param merchantType the value for FW_POS_MERCHANT_INFO.MERCHANT_TYPE
     * column comments 商户类型
POS商户：0001；机具方：0002；转接方：0004；miniPOS商户：0005；mPOS商户：0006；
POS拓展商：0003；mPOS拓展商：0007；miniPOS拓展商：0008；SDK拓展商：0009；机具厂商：0010；
     *
     * @mbggenerated Wed Aug 10 08:42:07 CST 2016
     */
    public void setMerchantType(String merchantType) {
        this.merchantType = merchantType == null ? null : merchantType.trim();
    }

    /**
     * This method returns the value of the database column FW_POS_MERCHANT_INFO.PARENT_PROMOTER_ID
     *
     * @return the value of FW_POS_MERCHANT_INFO.PARENT_PROMOTER_ID
     * column comments 商户关联的代理商ID（资管的业务关联ID）
     *
     * @mbggenerated Wed Aug 10 08:42:07 CST 2016
     */
    public Long getParentPromoterId() {
        return parentPromoterId;
    }

    /**
     * This method sets the value of the database column FW_POS_MERCHANT_INFO.PARENT_PROMOTER_ID
     *
     * @param parentPromoterId the value for FW_POS_MERCHANT_INFO.PARENT_PROMOTER_ID
     * column comments 商户关联的代理商ID（资管的业务关联ID）
     *
     * @mbggenerated Wed Aug 10 08:42:07 CST 2016
     */
    public void setParentPromoterId(Long parentPromoterId) {
        this.parentPromoterId = parentPromoterId;
    }

    /**
     * This method returns the value of the database column FW_POS_MERCHANT_INFO.MERCHANT_MEMBER_ID
     *
     * @return the value of FW_POS_MERCHANT_INFO.MERCHANT_MEMBER_ID
     * column comments 商户会员ID
     *
     * @mbggenerated Wed Aug 10 08:42:07 CST 2016
     */
    public String getMerchantMemberId() {
        return merchantMemberId;
    }

    /**
     * This method sets the value of the database column FW_POS_MERCHANT_INFO.MERCHANT_MEMBER_ID
     *
     * @param merchantMemberId the value for FW_POS_MERCHANT_INFO.MERCHANT_MEMBER_ID
     * column comments 商户会员ID
     *
     * @mbggenerated Wed Aug 10 08:42:07 CST 2016
     */
    public void setMerchantMemberId(String merchantMemberId) {
        this.merchantMemberId = merchantMemberId == null ? null : merchantMemberId.trim();
    }

    /**
     * This method returns the value of the database column FW_POS_MERCHANT_INFO.ACCOUNT_TYPE
     *
     * @return the value of FW_POS_MERCHANT_INFO.ACCOUNT_TYPE
     * column comments 商户类型
     *
     * @mbggenerated Wed Aug 10 08:42:07 CST 2016
     */
    public String getAccountType() {
        return accountType;
    }

    /**
     * This method sets the value of the database column FW_POS_MERCHANT_INFO.ACCOUNT_TYPE
     *
     * @param accountType the value for FW_POS_MERCHANT_INFO.ACCOUNT_TYPE
     * column comments 商户类型
     *
     * @mbggenerated Wed Aug 10 08:42:07 CST 2016
     */
    public void setAccountType(String accountType) {
        this.accountType = accountType == null ? null : accountType.trim();
    }

    /**
     * This method returns the value of the database column FW_POS_MERCHANT_INFO.BASE_ACCOUNT_ID
     *
     * @return the value of FW_POS_MERCHANT_INFO.BASE_ACCOUNT_ID
     * column comments 基本户账户
     *
     * @mbggenerated Wed Aug 10 08:42:07 CST 2016
     */
    public String getBaseAccountId() {
        return baseAccountId;
    }

    /**
     * This method sets the value of the database column FW_POS_MERCHANT_INFO.BASE_ACCOUNT_ID
     *
     * @param baseAccountId the value for FW_POS_MERCHANT_INFO.BASE_ACCOUNT_ID
     * column comments 基本户账户
     *
     * @mbggenerated Wed Aug 10 08:42:07 CST 2016
     */
    public void setBaseAccountId(String baseAccountId) {
        this.baseAccountId = baseAccountId == null ? null : baseAccountId.trim();
    }

    /**
     * This method returns the value of the database column FW_POS_MERCHANT_INFO.CREATE_TIME
     *
     * @return the value of FW_POS_MERCHANT_INFO.CREATE_TIME
     * column comments null
     *
     * @mbggenerated Wed Aug 10 08:42:07 CST 2016
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * This method sets the value of the database column FW_POS_MERCHANT_INFO.CREATE_TIME
     *
     * @param createTime the value for FW_POS_MERCHANT_INFO.CREATE_TIME
     * column comments null
     *
     * @mbggenerated Wed Aug 10 08:42:07 CST 2016
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * This method returns the value of the database column FW_POS_MERCHANT_INFO.UPDATE_TIME
     *
     * @return the value of FW_POS_MERCHANT_INFO.UPDATE_TIME
     * column comments null
     *
     * @mbggenerated Wed Aug 10 08:42:07 CST 2016
     */
    public Date getUpdateTime() {
        return updateTime;
    }

    /**
     * This method sets the value of the database column FW_POS_MERCHANT_INFO.UPDATE_TIME
     *
     * @param updateTime the value for FW_POS_MERCHANT_INFO.UPDATE_TIME
     * column comments null
     *
     * @mbggenerated Wed Aug 10 08:42:07 CST 2016
     */
    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    /**
     * This method returns the value of the database column FW_POS_MERCHANT_INFO.FAST_SETTLE_LIMIT
     *
     * @return the value of FW_POS_MERCHANT_INFO.FAST_SETTLE_LIMIT
     * column comments 快速结算额度
     *
     * @mbggenerated Wed Aug 10 08:42:07 CST 2016
     */
    public BigDecimal getFastSettleLimit() {
        return fastSettleLimit;
    }

    /**
     * This method sets the value of the database column FW_POS_MERCHANT_INFO.FAST_SETTLE_LIMIT
     *
     * @param fastSettleLimit the value for FW_POS_MERCHANT_INFO.FAST_SETTLE_LIMIT
     * column comments 快速结算额度
     *
     * @mbggenerated Wed Aug 10 08:42:07 CST 2016
     */
    public void setFastSettleLimit(BigDecimal fastSettleLimit) {
        this.fastSettleLimit = fastSettleLimit;
    }

    /**
     * This method returns the value of the database column FW_POS_MERCHANT_INFO.FAST_SETTLE_FLAG
     *
     * @return the value of FW_POS_MERCHANT_INFO.FAST_SETTLE_FLAG
     * column comments 快速结算标示
     *
     * @mbggenerated Wed Aug 10 08:42:07 CST 2016
     */
    public Integer getFastSettleFlag() {
        return fastSettleFlag;
    }

    /**
     * This method sets the value of the database column FW_POS_MERCHANT_INFO.FAST_SETTLE_FLAG
     *
     * @param fastSettleFlag the value for FW_POS_MERCHANT_INFO.FAST_SETTLE_FLAG
     * column comments 快速结算标示
     *
     * @mbggenerated Wed Aug 10 08:42:07 CST 2016
     */
    public void setFastSettleFlag(Integer fastSettleFlag) {
        this.fastSettleFlag = fastSettleFlag;
    }

    /**
     * This method returns the value of the database column FW_POS_MERCHANT_INFO.AUTO_FAST_SETTLE_FLAG
     *
     * @return the value of FW_POS_MERCHANT_INFO.AUTO_FAST_SETTLE_FLAG
     * column comments 自动快速结算标示
     *
     * @mbggenerated Wed Aug 10 08:42:07 CST 2016
     */
    public Integer getAutoFastSettleFlag() {
        return autoFastSettleFlag;
    }

    /**
     * This method sets the value of the database column FW_POS_MERCHANT_INFO.AUTO_FAST_SETTLE_FLAG
     *
     * @param autoFastSettleFlag the value for FW_POS_MERCHANT_INFO.AUTO_FAST_SETTLE_FLAG
     * column comments 自动快速结算标示
     *
     * @mbggenerated Wed Aug 10 08:42:07 CST 2016
     */
    public void setAutoFastSettleFlag(Integer autoFastSettleFlag) {
        this.autoFastSettleFlag = autoFastSettleFlag;
    }

    /**
     * This method returns the value of the database column FW_POS_MERCHANT_INFO.MERCHANT_PHONE
     *
     * @return the value of FW_POS_MERCHANT_INFO.MERCHANT_PHONE
     * column comments 商户对应的手机号
     *
     * @mbggenerated Wed Aug 10 08:42:07 CST 2016
     */
    public String getMerchantPhone() {
        return merchantPhone;
    }

    /**
     * This method sets the value of the database column FW_POS_MERCHANT_INFO.MERCHANT_PHONE
     *
     * @param merchantPhone the value for FW_POS_MERCHANT_INFO.MERCHANT_PHONE
     * column comments 商户对应的手机号
     *
     * @mbggenerated Wed Aug 10 08:42:07 CST 2016
     */
    public void setMerchantPhone(String merchantPhone) {
        this.merchantPhone = merchantPhone == null ? null : merchantPhone.trim();
    }

    /**
     * This method returns the value of the database column FW_POS_MERCHANT_INFO.FAST_SETTLE_MARGIN
     *
     * @return the value of FW_POS_MERCHANT_INFO.FAST_SETTLE_MARGIN
     * column comments 快速结算保证金
     *
     * @mbggenerated Wed Aug 10 08:42:07 CST 2016
     */
    public BigDecimal getFastSettleMargin() {
        return fastSettleMargin;
    }

    /**
     * This method sets the value of the database column FW_POS_MERCHANT_INFO.FAST_SETTLE_MARGIN
     *
     * @param fastSettleMargin the value for FW_POS_MERCHANT_INFO.FAST_SETTLE_MARGIN
     * column comments 快速结算保证金
     *
     * @mbggenerated Wed Aug 10 08:42:07 CST 2016
     */
    public void setFastSettleMargin(BigDecimal fastSettleMargin) {
        this.fastSettleMargin = fastSettleMargin;
    }

    /**
     * This method returns the value of the database column FW_POS_MERCHANT_INFO.FAST_SETTLE_MIN_LIMIT
     *
     * @return the value of FW_POS_MERCHANT_INFO.FAST_SETTLE_MIN_LIMIT
     * column comments 快速结算最低金额
     *
     * @mbggenerated Wed Aug 10 08:42:07 CST 2016
     */
    public BigDecimal getFastSettleMinLimit() {
        return fastSettleMinLimit;
    }

    /**
     * This method sets the value of the database column FW_POS_MERCHANT_INFO.FAST_SETTLE_MIN_LIMIT
     *
     * @param fastSettleMinLimit the value for FW_POS_MERCHANT_INFO.FAST_SETTLE_MIN_LIMIT
     * column comments 快速结算最低金额
     *
     * @mbggenerated Wed Aug 10 08:42:07 CST 2016
     */
    public void setFastSettleMinLimit(BigDecimal fastSettleMinLimit) {
        this.fastSettleMinLimit = fastSettleMinLimit;
    }

    /**
     * This method returns the value of the database column FW_POS_MERCHANT_INFO.PMT_BIND_OPERATOR_ID
     *
     * @return the value of FW_POS_MERCHANT_INFO.PMT_BIND_OPERATOR_ID
     * column comments 商户对应的操作员ID
     *
     * @mbggenerated Wed Aug 10 08:42:07 CST 2016
     */
    public String getPmtBindOperatorId() {
        return pmtBindOperatorId;
    }

    /**
     * This method sets the value of the database column FW_POS_MERCHANT_INFO.PMT_BIND_OPERATOR_ID
     *
     * @param pmtBindOperatorId the value for FW_POS_MERCHANT_INFO.PMT_BIND_OPERATOR_ID
     * column comments 商户对应的操作员ID
     *
     * @mbggenerated Wed Aug 10 08:42:07 CST 2016
     */
    public void setPmtBindOperatorId(String pmtBindOperatorId) {
        this.pmtBindOperatorId = pmtBindOperatorId == null ? null : pmtBindOperatorId.trim();
    }

    /**
     * This method returns the value of the database column FW_POS_MERCHANT_INFO.PMT_BIND_OPERATOR_NAME
     *
     * @return the value of FW_POS_MERCHANT_INFO.PMT_BIND_OPERATOR_NAME
     * column comments 商户对应的操作员名称
     *
     * @mbggenerated Wed Aug 10 08:42:07 CST 2016
     */
    public String getPmtBindOperatorName() {
        return pmtBindOperatorName;
    }

    /**
     * This method sets the value of the database column FW_POS_MERCHANT_INFO.PMT_BIND_OPERATOR_NAME
     *
     * @param pmtBindOperatorName the value for FW_POS_MERCHANT_INFO.PMT_BIND_OPERATOR_NAME
     * column comments 商户对应的操作员名称
     *
     * @mbggenerated Wed Aug 10 08:42:07 CST 2016
     */
    public void setPmtBindOperatorName(String pmtBindOperatorName) {
        this.pmtBindOperatorName = pmtBindOperatorName == null ? null : pmtBindOperatorName.trim();
    }

    /**
     * This method returns the value of the database column FW_POS_MERCHANT_INFO.LOANING_TYPE
     *
     * @return the value of FW_POS_MERCHANT_INFO.LOANING_TYPE
     * column comments 垫资方类型
     *
     * @mbggenerated Wed Aug 10 08:42:07 CST 2016
     */
    public Integer getLoaningType() {
        return loaningType;
    }

    /**
     * This method sets the value of the database column FW_POS_MERCHANT_INFO.LOANING_TYPE
     *
     * @param loaningType the value for FW_POS_MERCHANT_INFO.LOANING_TYPE
     * column comments 垫资方类型
     *
     * @mbggenerated Wed Aug 10 08:42:07 CST 2016
     */
    public void setLoaningType(Integer loaningType) {
        this.loaningType = loaningType;
    }

    /**
     * This method returns the value of the database column FW_POS_MERCHANT_INFO.STATUS
     *
     * @return the value of FW_POS_MERCHANT_INFO.STATUS
     * column comments 数据状态
     *
     * @mbggenerated Wed Aug 10 08:42:07 CST 2016
     */
    public String getStatus() {
        return status;
    }

    /**
     * This method sets the value of the database column FW_POS_MERCHANT_INFO.STATUS
     *
     * @param status the value for FW_POS_MERCHANT_INFO.STATUS
     * column comments 数据状态
     *
     * @mbggenerated Wed Aug 10 08:42:07 CST 2016
     */
    public void setStatus(String status) {
        this.status = status == null ? null : status.trim();
    }

    /**
     * This method returns the value of the database column FW_POS_MERCHANT_INFO.MERCHANT_NAME
     *
     * @return the value of FW_POS_MERCHANT_INFO.MERCHANT_NAME
     * column comments 商户名称
     *
     * @mbggenerated Wed Aug 10 08:42:07 CST 2016
     */
    public String getMerchantName() {
        return merchantName;
    }

    /**
     * This method sets the value of the database column FW_POS_MERCHANT_INFO.MERCHANT_NAME
     *
     * @param merchantName the value for FW_POS_MERCHANT_INFO.MERCHANT_NAME
     * column comments 商户名称
     *
     * @mbggenerated Wed Aug 10 08:42:07 CST 2016
     */
    public void setMerchantName(String merchantName) {
        this.merchantName = merchantName == null ? null : merchantName.trim();
    }

    /**
     * This method returns the value of the database column FW_POS_MERCHANT_INFO.MCC
     *
     * @return the value of FW_POS_MERCHANT_INFO.MCC
     * column comments 商户的mcc
     *
     * @mbggenerated Wed Aug 10 08:42:07 CST 2016
     */
    public String getMcc() {
        return mcc;
    }

    /**
     * This method sets the value of the database column FW_POS_MERCHANT_INFO.MCC
     *
     * @param mcc the value for FW_POS_MERCHANT_INFO.MCC
     * column comments 商户的mcc
     *
     * @mbggenerated Wed Aug 10 08:42:07 CST 2016
     */
    public void setMcc(String mcc) {
        this.mcc = mcc == null ? null : mcc.trim();
    }

    /**
     * This method returns the value of the database column FW_POS_MERCHANT_INFO.LAST_LEVEL_PROMOTER_ID
     *
     * @return the value of FW_POS_MERCHANT_INFO.LAST_LEVEL_PROMOTER_ID
     * column comments 商户的二级代理商ID
     *
     * @mbggenerated Wed Aug 10 08:42:07 CST 2016
     */
    public Long getLastLevelPromoterId() {
        return lastLevelPromoterId;
    }

    /**
     * This method sets the value of the database column FW_POS_MERCHANT_INFO.LAST_LEVEL_PROMOTER_ID
     *
     * @param lastLevelPromoterId the value for FW_POS_MERCHANT_INFO.LAST_LEVEL_PROMOTER_ID
     * column comments 商户的二级代理商ID
     *
     * @mbggenerated Wed Aug 10 08:42:07 CST 2016
     */
    public void setLastLevelPromoterId(Long lastLevelPromoterId) {
        this.lastLevelPromoterId = lastLevelPromoterId;
    }

    /**
     * This method returns the value of the database column FW_POS_MERCHANT_INFO.PMT_LEVEL
     *
     * @return the value of FW_POS_MERCHANT_INFO.PMT_LEVEL
     * column comments 代理商等级
     *
     * @mbggenerated Wed Aug 10 08:42:07 CST 2016
     */
    public Integer getPmtLevel() {
        return pmtLevel;
    }

    /**
     * This method sets the value of the database column FW_POS_MERCHANT_INFO.PMT_LEVEL
     *
     * @param pmtLevel the value for FW_POS_MERCHANT_INFO.PMT_LEVEL
     * column comments 代理商等级
     *
     * @mbggenerated Wed Aug 10 08:42:07 CST 2016
     */
    public void setPmtLevel(Integer pmtLevel) {
        this.pmtLevel = pmtLevel;
    }

    /**
     * This method returns the value of the database column FW_POS_MERCHANT_INFO.CERT_TYPE
     *
     * @return the value of FW_POS_MERCHANT_INFO.CERT_TYPE
     * column comments 证件类型
     *
     * @mbggenerated Wed Aug 10 08:42:07 CST 2016
     */
    public String getCertType() {
        return certType;
    }

    /**
     * This method sets the value of the database column FW_POS_MERCHANT_INFO.CERT_TYPE
     *
     * @param certType the value for FW_POS_MERCHANT_INFO.CERT_TYPE
     * column comments 证件类型
     *
     * @mbggenerated Wed Aug 10 08:42:07 CST 2016
     */
    public void setCertType(String certType) {
        this.certType = certType == null ? null : certType.trim();
    }

    /**
     * This method returns the value of the database column FW_POS_MERCHANT_INFO.CERT_NO
     *
     * @return the value of FW_POS_MERCHANT_INFO.CERT_NO
     * column comments 证件号码
     *
     * @mbggenerated Wed Aug 10 08:42:07 CST 2016
     */
    public String getCertNo() {
        return certNo;
    }

    /**
     * This method sets the value of the database column FW_POS_MERCHANT_INFO.CERT_NO
     *
     * @param certNo the value for FW_POS_MERCHANT_INFO.CERT_NO
     * column comments 证件号码
     *
     * @mbggenerated Wed Aug 10 08:42:07 CST 2016
     */
    public void setCertNo(String certNo) {
        this.certNo = certNo == null ? null : certNo.trim();
    }
}