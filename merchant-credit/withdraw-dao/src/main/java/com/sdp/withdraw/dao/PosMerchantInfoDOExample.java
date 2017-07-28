package com.sdp.withdraw.dao;

import com.sdp.emall.common.dao.QueryBase;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class PosMerchantInfoDOExample extends QueryBase {
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
     * This field corresponds to the database table FW_POS_MERCHANT_INFO
     * table comments POS商户信息
     *
     * @mbggenerated Wed Aug 10 08:42:07 CST 2016
     */
    protected String orderByClause;

    /**
     * This field corresponds to the database table FW_POS_MERCHANT_INFO
     * table comments POS商户信息
     *
     * @mbggenerated Wed Aug 10 08:42:07 CST 2016
     */
    protected boolean distinct;

    /**
     * This field corresponds to the database table FW_POS_MERCHANT_INFO
     * table comments POS商户信息
     *
     * @mbggenerated Wed Aug 10 08:42:07 CST 2016
     */
    protected List<Criteria> oredCriteria;

    /**
     * This method corresponds to the database table FW_POS_MERCHANT_INFO
     *
     * @mbggenerated Wed Aug 10 08:42:07 CST 2016
     */
    public PosMerchantInfoDOExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

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

    /**
     * This method corresponds to the database table FW_POS_MERCHANT_INFO
     *
     * @mbggenerated Wed Aug 10 08:42:07 CST 2016
     */
    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    /**
     * This method corresponds to the database table FW_POS_MERCHANT_INFO
     *
     * @mbggenerated Wed Aug 10 08:42:07 CST 2016
     */
    public String getOrderByClause() {
        return orderByClause;
    }

    /**
     * This method corresponds to the database table FW_POS_MERCHANT_INFO
     *
     * @mbggenerated Wed Aug 10 08:42:07 CST 2016
     */
    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    /**
     * This method corresponds to the database table FW_POS_MERCHANT_INFO
     *
     * @mbggenerated Wed Aug 10 08:42:07 CST 2016
     */
    public boolean isDistinct() {
        return distinct;
    }

    /**
     * This method corresponds to the database table FW_POS_MERCHANT_INFO
     *
     * @mbggenerated Wed Aug 10 08:42:07 CST 2016
     */
    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    /**
     * This method corresponds to the database table FW_POS_MERCHANT_INFO
     *
     * @mbggenerated Wed Aug 10 08:42:07 CST 2016
     */
    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    /**
     * This method corresponds to the database table FW_POS_MERCHANT_INFO
     *
     * @mbggenerated Wed Aug 10 08:42:07 CST 2016
     */
    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    /**
     * This method corresponds to the database table FW_POS_MERCHANT_INFO
     *
     * @mbggenerated Wed Aug 10 08:42:07 CST 2016
     */
    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    /**
     * This method corresponds to the database table FW_POS_MERCHANT_INFO
     *
     * @mbggenerated Wed Aug 10 08:42:07 CST 2016
     */
    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    /**
     * This method corresponds to the database table FW_POS_MERCHANT_INFO
     *
     * @mbggenerated Wed Aug 10 08:42:07 CST 2016
     */
    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table FW_POS_MERCHANT_INFO
     * table comment :POS商户信息
     *
     * @mbggenerated Wed Aug 10 08:42:07 CST 2016
     */
    protected abstract static class GeneratedCriteria {
        protected List<Criterion> criteria;

        protected GeneratedCriteria() {
            super();
            criteria = new ArrayList<Criterion>();
        }

        public boolean isValid() {
            return criteria.size() > 0;
        }

        public List<Criterion> getAllCriteria() {
            return criteria;
        }

        public List<Criterion> getCriteria() {
            return criteria;
        }

        protected void addCriterion(String condition) {
            if (condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            }
            criteria.add(new Criterion(condition));
        }

        protected void addCriterion(String condition, Object value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value));
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value1, value2));
        }

        public Criteria andIdIsNull() {
            addCriterion("ID is null");
            return (Criteria) this;
        }

        public Criteria andIdIsNotNull() {
            addCriterion("ID is not null");
            return (Criteria) this;
        }

        public Criteria andIdEqualTo(Long value) {
            addCriterion("ID =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(Long value) {
            addCriterion("ID <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(Long value) {
            addCriterion("ID >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Long value) {
            addCriterion("ID >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(Long value) {
            addCriterion("ID <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(Long value) {
            addCriterion("ID <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<Long> values) {
            addCriterion("ID in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<Long> values) {
            addCriterion("ID not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(Long value1, Long value2) {
            addCriterion("ID between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(Long value1, Long value2) {
            addCriterion("ID not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andMerchantNoIsNull() {
            addCriterion("MERCHANT_NO is null");
            return (Criteria) this;
        }

        public Criteria andMerchantNoIsNotNull() {
            addCriterion("MERCHANT_NO is not null");
            return (Criteria) this;
        }

        public Criteria andMerchantNoEqualTo(String value) {
            addCriterion("MERCHANT_NO =", value, "merchantNo");
            return (Criteria) this;
        }

        public Criteria andMerchantNoNotEqualTo(String value) {
            addCriterion("MERCHANT_NO <>", value, "merchantNo");
            return (Criteria) this;
        }

        public Criteria andMerchantNoGreaterThan(String value) {
            addCriterion("MERCHANT_NO >", value, "merchantNo");
            return (Criteria) this;
        }

        public Criteria andMerchantNoGreaterThanOrEqualTo(String value) {
            addCriterion("MERCHANT_NO >=", value, "merchantNo");
            return (Criteria) this;
        }

        public Criteria andMerchantNoLessThan(String value) {
            addCriterion("MERCHANT_NO <", value, "merchantNo");
            return (Criteria) this;
        }

        public Criteria andMerchantNoLessThanOrEqualTo(String value) {
            addCriterion("MERCHANT_NO <=", value, "merchantNo");
            return (Criteria) this;
        }

        public Criteria andMerchantNoLike(String value) {
            addCriterion("MERCHANT_NO like", value, "merchantNo");
            return (Criteria) this;
        }

        public Criteria andMerchantNoNotLike(String value) {
            addCriterion("MERCHANT_NO not like", value, "merchantNo");
            return (Criteria) this;
        }

        public Criteria andMerchantNoIn(List<String> values) {
            addCriterion("MERCHANT_NO in", values, "merchantNo");
            return (Criteria) this;
        }

        public Criteria andMerchantNoNotIn(List<String> values) {
            addCriterion("MERCHANT_NO not in", values, "merchantNo");
            return (Criteria) this;
        }

        public Criteria andMerchantNoBetween(String value1, String value2) {
            addCriterion("MERCHANT_NO between", value1, value2, "merchantNo");
            return (Criteria) this;
        }

        public Criteria andMerchantNoNotBetween(String value1, String value2) {
            addCriterion("MERCHANT_NO not between", value1, value2, "merchantNo");
            return (Criteria) this;
        }

        public Criteria andPosMerchantIdIsNull() {
            addCriterion("POS_MERCHANT_ID is null");
            return (Criteria) this;
        }

        public Criteria andPosMerchantIdIsNotNull() {
            addCriterion("POS_MERCHANT_ID is not null");
            return (Criteria) this;
        }

        public Criteria andPosMerchantIdEqualTo(Long value) {
            addCriterion("POS_MERCHANT_ID =", value, "posMerchantId");
            return (Criteria) this;
        }

        public Criteria andPosMerchantIdNotEqualTo(Long value) {
            addCriterion("POS_MERCHANT_ID <>", value, "posMerchantId");
            return (Criteria) this;
        }

        public Criteria andPosMerchantIdGreaterThan(Long value) {
            addCriterion("POS_MERCHANT_ID >", value, "posMerchantId");
            return (Criteria) this;
        }

        public Criteria andPosMerchantIdGreaterThanOrEqualTo(Long value) {
            addCriterion("POS_MERCHANT_ID >=", value, "posMerchantId");
            return (Criteria) this;
        }

        public Criteria andPosMerchantIdLessThan(Long value) {
            addCriterion("POS_MERCHANT_ID <", value, "posMerchantId");
            return (Criteria) this;
        }

        public Criteria andPosMerchantIdLessThanOrEqualTo(Long value) {
            addCriterion("POS_MERCHANT_ID <=", value, "posMerchantId");
            return (Criteria) this;
        }

        public Criteria andPosMerchantIdIn(List<Long> values) {
            addCriterion("POS_MERCHANT_ID in", values, "posMerchantId");
            return (Criteria) this;
        }

        public Criteria andPosMerchantIdNotIn(List<Long> values) {
            addCriterion("POS_MERCHANT_ID not in", values, "posMerchantId");
            return (Criteria) this;
        }

        public Criteria andPosMerchantIdBetween(Long value1, Long value2) {
            addCriterion("POS_MERCHANT_ID between", value1, value2, "posMerchantId");
            return (Criteria) this;
        }

        public Criteria andPosMerchantIdNotBetween(Long value1, Long value2) {
            addCriterion("POS_MERCHANT_ID not between", value1, value2, "posMerchantId");
            return (Criteria) this;
        }

        public Criteria andMerchantTypeIsNull() {
            addCriterion("MERCHANT_TYPE is null");
            return (Criteria) this;
        }

        public Criteria andMerchantTypeIsNotNull() {
            addCriterion("MERCHANT_TYPE is not null");
            return (Criteria) this;
        }

        public Criteria andMerchantTypeEqualTo(String value) {
            addCriterion("MERCHANT_TYPE =", value, "merchantType");
            return (Criteria) this;
        }

        public Criteria andMerchantTypeNotEqualTo(String value) {
            addCriterion("MERCHANT_TYPE <>", value, "merchantType");
            return (Criteria) this;
        }

        public Criteria andMerchantTypeGreaterThan(String value) {
            addCriterion("MERCHANT_TYPE >", value, "merchantType");
            return (Criteria) this;
        }

        public Criteria andMerchantTypeGreaterThanOrEqualTo(String value) {
            addCriterion("MERCHANT_TYPE >=", value, "merchantType");
            return (Criteria) this;
        }

        public Criteria andMerchantTypeLessThan(String value) {
            addCriterion("MERCHANT_TYPE <", value, "merchantType");
            return (Criteria) this;
        }

        public Criteria andMerchantTypeLessThanOrEqualTo(String value) {
            addCriterion("MERCHANT_TYPE <=", value, "merchantType");
            return (Criteria) this;
        }

        public Criteria andMerchantTypeLike(String value) {
            addCriterion("MERCHANT_TYPE like", value, "merchantType");
            return (Criteria) this;
        }

        public Criteria andMerchantTypeNotLike(String value) {
            addCriterion("MERCHANT_TYPE not like", value, "merchantType");
            return (Criteria) this;
        }

        public Criteria andMerchantTypeIn(List<String> values) {
            addCriterion("MERCHANT_TYPE in", values, "merchantType");
            return (Criteria) this;
        }

        public Criteria andMerchantTypeNotIn(List<String> values) {
            addCriterion("MERCHANT_TYPE not in", values, "merchantType");
            return (Criteria) this;
        }

        public Criteria andMerchantTypeBetween(String value1, String value2) {
            addCriterion("MERCHANT_TYPE between", value1, value2, "merchantType");
            return (Criteria) this;
        }

        public Criteria andMerchantTypeNotBetween(String value1, String value2) {
            addCriterion("MERCHANT_TYPE not between", value1, value2, "merchantType");
            return (Criteria) this;
        }

        public Criteria andParentPromoterIdIsNull() {
            addCriterion("PARENT_PROMOTER_ID is null");
            return (Criteria) this;
        }

        public Criteria andParentPromoterIdIsNotNull() {
            addCriterion("PARENT_PROMOTER_ID is not null");
            return (Criteria) this;
        }

        public Criteria andParentPromoterIdEqualTo(Long value) {
            addCriterion("PARENT_PROMOTER_ID =", value, "parentPromoterId");
            return (Criteria) this;
        }

        public Criteria andParentPromoterIdNotEqualTo(Long value) {
            addCriterion("PARENT_PROMOTER_ID <>", value, "parentPromoterId");
            return (Criteria) this;
        }

        public Criteria andParentPromoterIdGreaterThan(Long value) {
            addCriterion("PARENT_PROMOTER_ID >", value, "parentPromoterId");
            return (Criteria) this;
        }

        public Criteria andParentPromoterIdGreaterThanOrEqualTo(Long value) {
            addCriterion("PARENT_PROMOTER_ID >=", value, "parentPromoterId");
            return (Criteria) this;
        }

        public Criteria andParentPromoterIdLessThan(Long value) {
            addCriterion("PARENT_PROMOTER_ID <", value, "parentPromoterId");
            return (Criteria) this;
        }

        public Criteria andParentPromoterIdLessThanOrEqualTo(Long value) {
            addCriterion("PARENT_PROMOTER_ID <=", value, "parentPromoterId");
            return (Criteria) this;
        }

        public Criteria andParentPromoterIdIn(List<Long> values) {
            addCriterion("PARENT_PROMOTER_ID in", values, "parentPromoterId");
            return (Criteria) this;
        }

        public Criteria andParentPromoterIdNotIn(List<Long> values) {
            addCriterion("PARENT_PROMOTER_ID not in", values, "parentPromoterId");
            return (Criteria) this;
        }

        public Criteria andParentPromoterIdBetween(Long value1, Long value2) {
            addCriterion("PARENT_PROMOTER_ID between", value1, value2, "parentPromoterId");
            return (Criteria) this;
        }

        public Criteria andParentPromoterIdNotBetween(Long value1, Long value2) {
            addCriterion("PARENT_PROMOTER_ID not between", value1, value2, "parentPromoterId");
            return (Criteria) this;
        }

        public Criteria andMerchantMemberIdIsNull() {
            addCriterion("MERCHANT_MEMBER_ID is null");
            return (Criteria) this;
        }

        public Criteria andMerchantMemberIdIsNotNull() {
            addCriterion("MERCHANT_MEMBER_ID is not null");
            return (Criteria) this;
        }

        public Criteria andMerchantMemberIdEqualTo(String value) {
            addCriterion("MERCHANT_MEMBER_ID =", value, "merchantMemberId");
            return (Criteria) this;
        }

        public Criteria andMerchantMemberIdNotEqualTo(String value) {
            addCriterion("MERCHANT_MEMBER_ID <>", value, "merchantMemberId");
            return (Criteria) this;
        }

        public Criteria andMerchantMemberIdGreaterThan(String value) {
            addCriterion("MERCHANT_MEMBER_ID >", value, "merchantMemberId");
            return (Criteria) this;
        }

        public Criteria andMerchantMemberIdGreaterThanOrEqualTo(String value) {
            addCriterion("MERCHANT_MEMBER_ID >=", value, "merchantMemberId");
            return (Criteria) this;
        }

        public Criteria andMerchantMemberIdLessThan(String value) {
            addCriterion("MERCHANT_MEMBER_ID <", value, "merchantMemberId");
            return (Criteria) this;
        }

        public Criteria andMerchantMemberIdLessThanOrEqualTo(String value) {
            addCriterion("MERCHANT_MEMBER_ID <=", value, "merchantMemberId");
            return (Criteria) this;
        }

        public Criteria andMerchantMemberIdLike(String value) {
            addCriterion("MERCHANT_MEMBER_ID like", value, "merchantMemberId");
            return (Criteria) this;
        }

        public Criteria andMerchantMemberIdNotLike(String value) {
            addCriterion("MERCHANT_MEMBER_ID not like", value, "merchantMemberId");
            return (Criteria) this;
        }

        public Criteria andMerchantMemberIdIn(List<String> values) {
            addCriterion("MERCHANT_MEMBER_ID in", values, "merchantMemberId");
            return (Criteria) this;
        }

        public Criteria andMerchantMemberIdNotIn(List<String> values) {
            addCriterion("MERCHANT_MEMBER_ID not in", values, "merchantMemberId");
            return (Criteria) this;
        }

        public Criteria andMerchantMemberIdBetween(String value1, String value2) {
            addCriterion("MERCHANT_MEMBER_ID between", value1, value2, "merchantMemberId");
            return (Criteria) this;
        }

        public Criteria andMerchantMemberIdNotBetween(String value1, String value2) {
            addCriterion("MERCHANT_MEMBER_ID not between", value1, value2, "merchantMemberId");
            return (Criteria) this;
        }

        public Criteria andAccountTypeIsNull() {
            addCriterion("ACCOUNT_TYPE is null");
            return (Criteria) this;
        }

        public Criteria andAccountTypeIsNotNull() {
            addCriterion("ACCOUNT_TYPE is not null");
            return (Criteria) this;
        }

        public Criteria andAccountTypeEqualTo(String value) {
            addCriterion("ACCOUNT_TYPE =", value, "accountType");
            return (Criteria) this;
        }

        public Criteria andAccountTypeNotEqualTo(String value) {
            addCriterion("ACCOUNT_TYPE <>", value, "accountType");
            return (Criteria) this;
        }

        public Criteria andAccountTypeGreaterThan(String value) {
            addCriterion("ACCOUNT_TYPE >", value, "accountType");
            return (Criteria) this;
        }

        public Criteria andAccountTypeGreaterThanOrEqualTo(String value) {
            addCriterion("ACCOUNT_TYPE >=", value, "accountType");
            return (Criteria) this;
        }

        public Criteria andAccountTypeLessThan(String value) {
            addCriterion("ACCOUNT_TYPE <", value, "accountType");
            return (Criteria) this;
        }

        public Criteria andAccountTypeLessThanOrEqualTo(String value) {
            addCriterion("ACCOUNT_TYPE <=", value, "accountType");
            return (Criteria) this;
        }

        public Criteria andAccountTypeLike(String value) {
            addCriterion("ACCOUNT_TYPE like", value, "accountType");
            return (Criteria) this;
        }

        public Criteria andAccountTypeNotLike(String value) {
            addCriterion("ACCOUNT_TYPE not like", value, "accountType");
            return (Criteria) this;
        }

        public Criteria andAccountTypeIn(List<String> values) {
            addCriterion("ACCOUNT_TYPE in", values, "accountType");
            return (Criteria) this;
        }

        public Criteria andAccountTypeNotIn(List<String> values) {
            addCriterion("ACCOUNT_TYPE not in", values, "accountType");
            return (Criteria) this;
        }

        public Criteria andAccountTypeBetween(String value1, String value2) {
            addCriterion("ACCOUNT_TYPE between", value1, value2, "accountType");
            return (Criteria) this;
        }

        public Criteria andAccountTypeNotBetween(String value1, String value2) {
            addCriterion("ACCOUNT_TYPE not between", value1, value2, "accountType");
            return (Criteria) this;
        }

        public Criteria andBaseAccountIdIsNull() {
            addCriterion("BASE_ACCOUNT_ID is null");
            return (Criteria) this;
        }

        public Criteria andBaseAccountIdIsNotNull() {
            addCriterion("BASE_ACCOUNT_ID is not null");
            return (Criteria) this;
        }

        public Criteria andBaseAccountIdEqualTo(String value) {
            addCriterion("BASE_ACCOUNT_ID =", value, "baseAccountId");
            return (Criteria) this;
        }

        public Criteria andBaseAccountIdNotEqualTo(String value) {
            addCriterion("BASE_ACCOUNT_ID <>", value, "baseAccountId");
            return (Criteria) this;
        }

        public Criteria andBaseAccountIdGreaterThan(String value) {
            addCriterion("BASE_ACCOUNT_ID >", value, "baseAccountId");
            return (Criteria) this;
        }

        public Criteria andBaseAccountIdGreaterThanOrEqualTo(String value) {
            addCriterion("BASE_ACCOUNT_ID >=", value, "baseAccountId");
            return (Criteria) this;
        }

        public Criteria andBaseAccountIdLessThan(String value) {
            addCriterion("BASE_ACCOUNT_ID <", value, "baseAccountId");
            return (Criteria) this;
        }

        public Criteria andBaseAccountIdLessThanOrEqualTo(String value) {
            addCriterion("BASE_ACCOUNT_ID <=", value, "baseAccountId");
            return (Criteria) this;
        }

        public Criteria andBaseAccountIdLike(String value) {
            addCriterion("BASE_ACCOUNT_ID like", value, "baseAccountId");
            return (Criteria) this;
        }

        public Criteria andBaseAccountIdNotLike(String value) {
            addCriterion("BASE_ACCOUNT_ID not like", value, "baseAccountId");
            return (Criteria) this;
        }

        public Criteria andBaseAccountIdIn(List<String> values) {
            addCriterion("BASE_ACCOUNT_ID in", values, "baseAccountId");
            return (Criteria) this;
        }

        public Criteria andBaseAccountIdNotIn(List<String> values) {
            addCriterion("BASE_ACCOUNT_ID not in", values, "baseAccountId");
            return (Criteria) this;
        }

        public Criteria andBaseAccountIdBetween(String value1, String value2) {
            addCriterion("BASE_ACCOUNT_ID between", value1, value2, "baseAccountId");
            return (Criteria) this;
        }

        public Criteria andBaseAccountIdNotBetween(String value1, String value2) {
            addCriterion("BASE_ACCOUNT_ID not between", value1, value2, "baseAccountId");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIsNull() {
            addCriterion("CREATE_TIME is null");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIsNotNull() {
            addCriterion("CREATE_TIME is not null");
            return (Criteria) this;
        }

        public Criteria andCreateTimeEqualTo(Date value) {
            addCriterion("CREATE_TIME =", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotEqualTo(Date value) {
            addCriterion("CREATE_TIME <>", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThan(Date value) {
            addCriterion("CREATE_TIME >", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("CREATE_TIME >=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThan(Date value) {
            addCriterion("CREATE_TIME <", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThanOrEqualTo(Date value) {
            addCriterion("CREATE_TIME <=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIn(List<Date> values) {
            addCriterion("CREATE_TIME in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotIn(List<Date> values) {
            addCriterion("CREATE_TIME not in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeBetween(Date value1, Date value2) {
            addCriterion("CREATE_TIME between", value1, value2, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotBetween(Date value1, Date value2) {
            addCriterion("CREATE_TIME not between", value1, value2, "createTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeIsNull() {
            addCriterion("UPDATE_TIME is null");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeIsNotNull() {
            addCriterion("UPDATE_TIME is not null");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeEqualTo(Date value) {
            addCriterion("UPDATE_TIME =", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotEqualTo(Date value) {
            addCriterion("UPDATE_TIME <>", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeGreaterThan(Date value) {
            addCriterion("UPDATE_TIME >", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("UPDATE_TIME >=", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeLessThan(Date value) {
            addCriterion("UPDATE_TIME <", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeLessThanOrEqualTo(Date value) {
            addCriterion("UPDATE_TIME <=", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeIn(List<Date> values) {
            addCriterion("UPDATE_TIME in", values, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotIn(List<Date> values) {
            addCriterion("UPDATE_TIME not in", values, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeBetween(Date value1, Date value2) {
            addCriterion("UPDATE_TIME between", value1, value2, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotBetween(Date value1, Date value2) {
            addCriterion("UPDATE_TIME not between", value1, value2, "updateTime");
            return (Criteria) this;
        }

        public Criteria andFastSettleLimitIsNull() {
            addCriterion("FAST_SETTLE_LIMIT is null");
            return (Criteria) this;
        }

        public Criteria andFastSettleLimitIsNotNull() {
            addCriterion("FAST_SETTLE_LIMIT is not null");
            return (Criteria) this;
        }

        public Criteria andFastSettleLimitEqualTo(BigDecimal value) {
            addCriterion("FAST_SETTLE_LIMIT =", value, "fastSettleLimit");
            return (Criteria) this;
        }

        public Criteria andFastSettleLimitNotEqualTo(BigDecimal value) {
            addCriterion("FAST_SETTLE_LIMIT <>", value, "fastSettleLimit");
            return (Criteria) this;
        }

        public Criteria andFastSettleLimitGreaterThan(BigDecimal value) {
            addCriterion("FAST_SETTLE_LIMIT >", value, "fastSettleLimit");
            return (Criteria) this;
        }

        public Criteria andFastSettleLimitGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("FAST_SETTLE_LIMIT >=", value, "fastSettleLimit");
            return (Criteria) this;
        }

        public Criteria andFastSettleLimitLessThan(BigDecimal value) {
            addCriterion("FAST_SETTLE_LIMIT <", value, "fastSettleLimit");
            return (Criteria) this;
        }

        public Criteria andFastSettleLimitLessThanOrEqualTo(BigDecimal value) {
            addCriterion("FAST_SETTLE_LIMIT <=", value, "fastSettleLimit");
            return (Criteria) this;
        }

        public Criteria andFastSettleLimitIn(List<BigDecimal> values) {
            addCriterion("FAST_SETTLE_LIMIT in", values, "fastSettleLimit");
            return (Criteria) this;
        }

        public Criteria andFastSettleLimitNotIn(List<BigDecimal> values) {
            addCriterion("FAST_SETTLE_LIMIT not in", values, "fastSettleLimit");
            return (Criteria) this;
        }

        public Criteria andFastSettleLimitBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("FAST_SETTLE_LIMIT between", value1, value2, "fastSettleLimit");
            return (Criteria) this;
        }

        public Criteria andFastSettleLimitNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("FAST_SETTLE_LIMIT not between", value1, value2, "fastSettleLimit");
            return (Criteria) this;
        }

        public Criteria andFastSettleFlagIsNull() {
            addCriterion("FAST_SETTLE_FLAG is null");
            return (Criteria) this;
        }

        public Criteria andFastSettleFlagIsNotNull() {
            addCriterion("FAST_SETTLE_FLAG is not null");
            return (Criteria) this;
        }

        public Criteria andFastSettleFlagEqualTo(Integer value) {
            addCriterion("FAST_SETTLE_FLAG =", value, "fastSettleFlag");
            return (Criteria) this;
        }

        public Criteria andFastSettleFlagNotEqualTo(Integer value) {
            addCriterion("FAST_SETTLE_FLAG <>", value, "fastSettleFlag");
            return (Criteria) this;
        }

        public Criteria andFastSettleFlagGreaterThan(Integer value) {
            addCriterion("FAST_SETTLE_FLAG >", value, "fastSettleFlag");
            return (Criteria) this;
        }

        public Criteria andFastSettleFlagGreaterThanOrEqualTo(Integer value) {
            addCriterion("FAST_SETTLE_FLAG >=", value, "fastSettleFlag");
            return (Criteria) this;
        }

        public Criteria andFastSettleFlagLessThan(Integer value) {
            addCriterion("FAST_SETTLE_FLAG <", value, "fastSettleFlag");
            return (Criteria) this;
        }

        public Criteria andFastSettleFlagLessThanOrEqualTo(Integer value) {
            addCriterion("FAST_SETTLE_FLAG <=", value, "fastSettleFlag");
            return (Criteria) this;
        }

        public Criteria andFastSettleFlagIn(List<Integer> values) {
            addCriterion("FAST_SETTLE_FLAG in", values, "fastSettleFlag");
            return (Criteria) this;
        }

        public Criteria andFastSettleFlagNotIn(List<Integer> values) {
            addCriterion("FAST_SETTLE_FLAG not in", values, "fastSettleFlag");
            return (Criteria) this;
        }

        public Criteria andFastSettleFlagBetween(Integer value1, Integer value2) {
            addCriterion("FAST_SETTLE_FLAG between", value1, value2, "fastSettleFlag");
            return (Criteria) this;
        }

        public Criteria andFastSettleFlagNotBetween(Integer value1, Integer value2) {
            addCriterion("FAST_SETTLE_FLAG not between", value1, value2, "fastSettleFlag");
            return (Criteria) this;
        }

        public Criteria andAutoFastSettleFlagIsNull() {
            addCriterion("AUTO_FAST_SETTLE_FLAG is null");
            return (Criteria) this;
        }

        public Criteria andAutoFastSettleFlagIsNotNull() {
            addCriterion("AUTO_FAST_SETTLE_FLAG is not null");
            return (Criteria) this;
        }

        public Criteria andAutoFastSettleFlagEqualTo(Integer value) {
            addCriterion("AUTO_FAST_SETTLE_FLAG =", value, "autoFastSettleFlag");
            return (Criteria) this;
        }

        public Criteria andAutoFastSettleFlagNotEqualTo(Integer value) {
            addCriterion("AUTO_FAST_SETTLE_FLAG <>", value, "autoFastSettleFlag");
            return (Criteria) this;
        }

        public Criteria andAutoFastSettleFlagGreaterThan(Integer value) {
            addCriterion("AUTO_FAST_SETTLE_FLAG >", value, "autoFastSettleFlag");
            return (Criteria) this;
        }

        public Criteria andAutoFastSettleFlagGreaterThanOrEqualTo(Integer value) {
            addCriterion("AUTO_FAST_SETTLE_FLAG >=", value, "autoFastSettleFlag");
            return (Criteria) this;
        }

        public Criteria andAutoFastSettleFlagLessThan(Integer value) {
            addCriterion("AUTO_FAST_SETTLE_FLAG <", value, "autoFastSettleFlag");
            return (Criteria) this;
        }

        public Criteria andAutoFastSettleFlagLessThanOrEqualTo(Integer value) {
            addCriterion("AUTO_FAST_SETTLE_FLAG <=", value, "autoFastSettleFlag");
            return (Criteria) this;
        }

        public Criteria andAutoFastSettleFlagIn(List<Integer> values) {
            addCriterion("AUTO_FAST_SETTLE_FLAG in", values, "autoFastSettleFlag");
            return (Criteria) this;
        }

        public Criteria andAutoFastSettleFlagNotIn(List<Integer> values) {
            addCriterion("AUTO_FAST_SETTLE_FLAG not in", values, "autoFastSettleFlag");
            return (Criteria) this;
        }

        public Criteria andAutoFastSettleFlagBetween(Integer value1, Integer value2) {
            addCriterion("AUTO_FAST_SETTLE_FLAG between", value1, value2, "autoFastSettleFlag");
            return (Criteria) this;
        }

        public Criteria andAutoFastSettleFlagNotBetween(Integer value1, Integer value2) {
            addCriterion("AUTO_FAST_SETTLE_FLAG not between", value1, value2, "autoFastSettleFlag");
            return (Criteria) this;
        }

        public Criteria andMerchantPhoneIsNull() {
            addCriterion("MERCHANT_PHONE is null");
            return (Criteria) this;
        }

        public Criteria andMerchantPhoneIsNotNull() {
            addCriterion("MERCHANT_PHONE is not null");
            return (Criteria) this;
        }

        public Criteria andMerchantPhoneEqualTo(String value) {
            addCriterion("MERCHANT_PHONE =", value, "merchantPhone");
            return (Criteria) this;
        }

        public Criteria andMerchantPhoneNotEqualTo(String value) {
            addCriterion("MERCHANT_PHONE <>", value, "merchantPhone");
            return (Criteria) this;
        }

        public Criteria andMerchantPhoneGreaterThan(String value) {
            addCriterion("MERCHANT_PHONE >", value, "merchantPhone");
            return (Criteria) this;
        }

        public Criteria andMerchantPhoneGreaterThanOrEqualTo(String value) {
            addCriterion("MERCHANT_PHONE >=", value, "merchantPhone");
            return (Criteria) this;
        }

        public Criteria andMerchantPhoneLessThan(String value) {
            addCriterion("MERCHANT_PHONE <", value, "merchantPhone");
            return (Criteria) this;
        }

        public Criteria andMerchantPhoneLessThanOrEqualTo(String value) {
            addCriterion("MERCHANT_PHONE <=", value, "merchantPhone");
            return (Criteria) this;
        }

        public Criteria andMerchantPhoneLike(String value) {
            addCriterion("MERCHANT_PHONE like", value, "merchantPhone");
            return (Criteria) this;
        }

        public Criteria andMerchantPhoneNotLike(String value) {
            addCriterion("MERCHANT_PHONE not like", value, "merchantPhone");
            return (Criteria) this;
        }

        public Criteria andMerchantPhoneIn(List<String> values) {
            addCriterion("MERCHANT_PHONE in", values, "merchantPhone");
            return (Criteria) this;
        }

        public Criteria andMerchantPhoneNotIn(List<String> values) {
            addCriterion("MERCHANT_PHONE not in", values, "merchantPhone");
            return (Criteria) this;
        }

        public Criteria andMerchantPhoneBetween(String value1, String value2) {
            addCriterion("MERCHANT_PHONE between", value1, value2, "merchantPhone");
            return (Criteria) this;
        }

        public Criteria andMerchantPhoneNotBetween(String value1, String value2) {
            addCriterion("MERCHANT_PHONE not between", value1, value2, "merchantPhone");
            return (Criteria) this;
        }

        public Criteria andFastSettleMarginIsNull() {
            addCriterion("FAST_SETTLE_MARGIN is null");
            return (Criteria) this;
        }

        public Criteria andFastSettleMarginIsNotNull() {
            addCriterion("FAST_SETTLE_MARGIN is not null");
            return (Criteria) this;
        }

        public Criteria andFastSettleMarginEqualTo(BigDecimal value) {
            addCriterion("FAST_SETTLE_MARGIN =", value, "fastSettleMargin");
            return (Criteria) this;
        }

        public Criteria andFastSettleMarginNotEqualTo(BigDecimal value) {
            addCriterion("FAST_SETTLE_MARGIN <>", value, "fastSettleMargin");
            return (Criteria) this;
        }

        public Criteria andFastSettleMarginGreaterThan(BigDecimal value) {
            addCriterion("FAST_SETTLE_MARGIN >", value, "fastSettleMargin");
            return (Criteria) this;
        }

        public Criteria andFastSettleMarginGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("FAST_SETTLE_MARGIN >=", value, "fastSettleMargin");
            return (Criteria) this;
        }

        public Criteria andFastSettleMarginLessThan(BigDecimal value) {
            addCriterion("FAST_SETTLE_MARGIN <", value, "fastSettleMargin");
            return (Criteria) this;
        }

        public Criteria andFastSettleMarginLessThanOrEqualTo(BigDecimal value) {
            addCriterion("FAST_SETTLE_MARGIN <=", value, "fastSettleMargin");
            return (Criteria) this;
        }

        public Criteria andFastSettleMarginIn(List<BigDecimal> values) {
            addCriterion("FAST_SETTLE_MARGIN in", values, "fastSettleMargin");
            return (Criteria) this;
        }

        public Criteria andFastSettleMarginNotIn(List<BigDecimal> values) {
            addCriterion("FAST_SETTLE_MARGIN not in", values, "fastSettleMargin");
            return (Criteria) this;
        }

        public Criteria andFastSettleMarginBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("FAST_SETTLE_MARGIN between", value1, value2, "fastSettleMargin");
            return (Criteria) this;
        }

        public Criteria andFastSettleMarginNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("FAST_SETTLE_MARGIN not between", value1, value2, "fastSettleMargin");
            return (Criteria) this;
        }

        public Criteria andFastSettleMinLimitIsNull() {
            addCriterion("FAST_SETTLE_MIN_LIMIT is null");
            return (Criteria) this;
        }

        public Criteria andFastSettleMinLimitIsNotNull() {
            addCriterion("FAST_SETTLE_MIN_LIMIT is not null");
            return (Criteria) this;
        }

        public Criteria andFastSettleMinLimitEqualTo(BigDecimal value) {
            addCriterion("FAST_SETTLE_MIN_LIMIT =", value, "fastSettleMinLimit");
            return (Criteria) this;
        }

        public Criteria andFastSettleMinLimitNotEqualTo(BigDecimal value) {
            addCriterion("FAST_SETTLE_MIN_LIMIT <>", value, "fastSettleMinLimit");
            return (Criteria) this;
        }

        public Criteria andFastSettleMinLimitGreaterThan(BigDecimal value) {
            addCriterion("FAST_SETTLE_MIN_LIMIT >", value, "fastSettleMinLimit");
            return (Criteria) this;
        }

        public Criteria andFastSettleMinLimitGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("FAST_SETTLE_MIN_LIMIT >=", value, "fastSettleMinLimit");
            return (Criteria) this;
        }

        public Criteria andFastSettleMinLimitLessThan(BigDecimal value) {
            addCriterion("FAST_SETTLE_MIN_LIMIT <", value, "fastSettleMinLimit");
            return (Criteria) this;
        }

        public Criteria andFastSettleMinLimitLessThanOrEqualTo(BigDecimal value) {
            addCriterion("FAST_SETTLE_MIN_LIMIT <=", value, "fastSettleMinLimit");
            return (Criteria) this;
        }

        public Criteria andFastSettleMinLimitIn(List<BigDecimal> values) {
            addCriterion("FAST_SETTLE_MIN_LIMIT in", values, "fastSettleMinLimit");
            return (Criteria) this;
        }

        public Criteria andFastSettleMinLimitNotIn(List<BigDecimal> values) {
            addCriterion("FAST_SETTLE_MIN_LIMIT not in", values, "fastSettleMinLimit");
            return (Criteria) this;
        }

        public Criteria andFastSettleMinLimitBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("FAST_SETTLE_MIN_LIMIT between", value1, value2, "fastSettleMinLimit");
            return (Criteria) this;
        }

        public Criteria andFastSettleMinLimitNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("FAST_SETTLE_MIN_LIMIT not between", value1, value2, "fastSettleMinLimit");
            return (Criteria) this;
        }

        public Criteria andPmtBindOperatorIdIsNull() {
            addCriterion("PMT_BIND_OPERATOR_ID is null");
            return (Criteria) this;
        }

        public Criteria andPmtBindOperatorIdIsNotNull() {
            addCriterion("PMT_BIND_OPERATOR_ID is not null");
            return (Criteria) this;
        }

        public Criteria andPmtBindOperatorIdEqualTo(String value) {
            addCriterion("PMT_BIND_OPERATOR_ID =", value, "pmtBindOperatorId");
            return (Criteria) this;
        }

        public Criteria andPmtBindOperatorIdNotEqualTo(String value) {
            addCriterion("PMT_BIND_OPERATOR_ID <>", value, "pmtBindOperatorId");
            return (Criteria) this;
        }

        public Criteria andPmtBindOperatorIdGreaterThan(String value) {
            addCriterion("PMT_BIND_OPERATOR_ID >", value, "pmtBindOperatorId");
            return (Criteria) this;
        }

        public Criteria andPmtBindOperatorIdGreaterThanOrEqualTo(String value) {
            addCriterion("PMT_BIND_OPERATOR_ID >=", value, "pmtBindOperatorId");
            return (Criteria) this;
        }

        public Criteria andPmtBindOperatorIdLessThan(String value) {
            addCriterion("PMT_BIND_OPERATOR_ID <", value, "pmtBindOperatorId");
            return (Criteria) this;
        }

        public Criteria andPmtBindOperatorIdLessThanOrEqualTo(String value) {
            addCriterion("PMT_BIND_OPERATOR_ID <=", value, "pmtBindOperatorId");
            return (Criteria) this;
        }

        public Criteria andPmtBindOperatorIdLike(String value) {
            addCriterion("PMT_BIND_OPERATOR_ID like", value, "pmtBindOperatorId");
            return (Criteria) this;
        }

        public Criteria andPmtBindOperatorIdNotLike(String value) {
            addCriterion("PMT_BIND_OPERATOR_ID not like", value, "pmtBindOperatorId");
            return (Criteria) this;
        }

        public Criteria andPmtBindOperatorIdIn(List<String> values) {
            addCriterion("PMT_BIND_OPERATOR_ID in", values, "pmtBindOperatorId");
            return (Criteria) this;
        }

        public Criteria andPmtBindOperatorIdNotIn(List<String> values) {
            addCriterion("PMT_BIND_OPERATOR_ID not in", values, "pmtBindOperatorId");
            return (Criteria) this;
        }

        public Criteria andPmtBindOperatorIdBetween(String value1, String value2) {
            addCriterion("PMT_BIND_OPERATOR_ID between", value1, value2, "pmtBindOperatorId");
            return (Criteria) this;
        }

        public Criteria andPmtBindOperatorIdNotBetween(String value1, String value2) {
            addCriterion("PMT_BIND_OPERATOR_ID not between", value1, value2, "pmtBindOperatorId");
            return (Criteria) this;
        }

        public Criteria andPmtBindOperatorNameIsNull() {
            addCriterion("PMT_BIND_OPERATOR_NAME is null");
            return (Criteria) this;
        }

        public Criteria andPmtBindOperatorNameIsNotNull() {
            addCriterion("PMT_BIND_OPERATOR_NAME is not null");
            return (Criteria) this;
        }

        public Criteria andPmtBindOperatorNameEqualTo(String value) {
            addCriterion("PMT_BIND_OPERATOR_NAME =", value, "pmtBindOperatorName");
            return (Criteria) this;
        }

        public Criteria andPmtBindOperatorNameNotEqualTo(String value) {
            addCriterion("PMT_BIND_OPERATOR_NAME <>", value, "pmtBindOperatorName");
            return (Criteria) this;
        }

        public Criteria andPmtBindOperatorNameGreaterThan(String value) {
            addCriterion("PMT_BIND_OPERATOR_NAME >", value, "pmtBindOperatorName");
            return (Criteria) this;
        }

        public Criteria andPmtBindOperatorNameGreaterThanOrEqualTo(String value) {
            addCriterion("PMT_BIND_OPERATOR_NAME >=", value, "pmtBindOperatorName");
            return (Criteria) this;
        }

        public Criteria andPmtBindOperatorNameLessThan(String value) {
            addCriterion("PMT_BIND_OPERATOR_NAME <", value, "pmtBindOperatorName");
            return (Criteria) this;
        }

        public Criteria andPmtBindOperatorNameLessThanOrEqualTo(String value) {
            addCriterion("PMT_BIND_OPERATOR_NAME <=", value, "pmtBindOperatorName");
            return (Criteria) this;
        }

        public Criteria andPmtBindOperatorNameLike(String value) {
            addCriterion("PMT_BIND_OPERATOR_NAME like", value, "pmtBindOperatorName");
            return (Criteria) this;
        }

        public Criteria andPmtBindOperatorNameNotLike(String value) {
            addCriterion("PMT_BIND_OPERATOR_NAME not like", value, "pmtBindOperatorName");
            return (Criteria) this;
        }

        public Criteria andPmtBindOperatorNameIn(List<String> values) {
            addCriterion("PMT_BIND_OPERATOR_NAME in", values, "pmtBindOperatorName");
            return (Criteria) this;
        }

        public Criteria andPmtBindOperatorNameNotIn(List<String> values) {
            addCriterion("PMT_BIND_OPERATOR_NAME not in", values, "pmtBindOperatorName");
            return (Criteria) this;
        }

        public Criteria andPmtBindOperatorNameBetween(String value1, String value2) {
            addCriterion("PMT_BIND_OPERATOR_NAME between", value1, value2, "pmtBindOperatorName");
            return (Criteria) this;
        }

        public Criteria andPmtBindOperatorNameNotBetween(String value1, String value2) {
            addCriterion("PMT_BIND_OPERATOR_NAME not between", value1, value2, "pmtBindOperatorName");
            return (Criteria) this;
        }

        public Criteria andLoaningTypeIsNull() {
            addCriterion("LOANING_TYPE is null");
            return (Criteria) this;
        }

        public Criteria andLoaningTypeIsNotNull() {
            addCriterion("LOANING_TYPE is not null");
            return (Criteria) this;
        }

        public Criteria andLoaningTypeEqualTo(Integer value) {
            addCriterion("LOANING_TYPE =", value, "loaningType");
            return (Criteria) this;
        }

        public Criteria andLoaningTypeNotEqualTo(Integer value) {
            addCriterion("LOANING_TYPE <>", value, "loaningType");
            return (Criteria) this;
        }

        public Criteria andLoaningTypeGreaterThan(Integer value) {
            addCriterion("LOANING_TYPE >", value, "loaningType");
            return (Criteria) this;
        }

        public Criteria andLoaningTypeGreaterThanOrEqualTo(Integer value) {
            addCriterion("LOANING_TYPE >=", value, "loaningType");
            return (Criteria) this;
        }

        public Criteria andLoaningTypeLessThan(Integer value) {
            addCriterion("LOANING_TYPE <", value, "loaningType");
            return (Criteria) this;
        }

        public Criteria andLoaningTypeLessThanOrEqualTo(Integer value) {
            addCriterion("LOANING_TYPE <=", value, "loaningType");
            return (Criteria) this;
        }

        public Criteria andLoaningTypeIn(List<Integer> values) {
            addCriterion("LOANING_TYPE in", values, "loaningType");
            return (Criteria) this;
        }

        public Criteria andLoaningTypeNotIn(List<Integer> values) {
            addCriterion("LOANING_TYPE not in", values, "loaningType");
            return (Criteria) this;
        }

        public Criteria andLoaningTypeBetween(Integer value1, Integer value2) {
            addCriterion("LOANING_TYPE between", value1, value2, "loaningType");
            return (Criteria) this;
        }

        public Criteria andLoaningTypeNotBetween(Integer value1, Integer value2) {
            addCriterion("LOANING_TYPE not between", value1, value2, "loaningType");
            return (Criteria) this;
        }

        public Criteria andStatusIsNull() {
            addCriterion("STATUS is null");
            return (Criteria) this;
        }

        public Criteria andStatusIsNotNull() {
            addCriterion("STATUS is not null");
            return (Criteria) this;
        }

        public Criteria andStatusEqualTo(String value) {
            addCriterion("STATUS =", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotEqualTo(String value) {
            addCriterion("STATUS <>", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThan(String value) {
            addCriterion("STATUS >", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThanOrEqualTo(String value) {
            addCriterion("STATUS >=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThan(String value) {
            addCriterion("STATUS <", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThanOrEqualTo(String value) {
            addCriterion("STATUS <=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLike(String value) {
            addCriterion("STATUS like", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotLike(String value) {
            addCriterion("STATUS not like", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusIn(List<String> values) {
            addCriterion("STATUS in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotIn(List<String> values) {
            addCriterion("STATUS not in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusBetween(String value1, String value2) {
            addCriterion("STATUS between", value1, value2, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotBetween(String value1, String value2) {
            addCriterion("STATUS not between", value1, value2, "status");
            return (Criteria) this;
        }

        public Criteria andMerchantNameIsNull() {
            addCriterion("MERCHANT_NAME is null");
            return (Criteria) this;
        }

        public Criteria andMerchantNameIsNotNull() {
            addCriterion("MERCHANT_NAME is not null");
            return (Criteria) this;
        }

        public Criteria andMerchantNameEqualTo(String value) {
            addCriterion("MERCHANT_NAME =", value, "merchantName");
            return (Criteria) this;
        }

        public Criteria andMerchantNameNotEqualTo(String value) {
            addCriterion("MERCHANT_NAME <>", value, "merchantName");
            return (Criteria) this;
        }

        public Criteria andMerchantNameGreaterThan(String value) {
            addCriterion("MERCHANT_NAME >", value, "merchantName");
            return (Criteria) this;
        }

        public Criteria andMerchantNameGreaterThanOrEqualTo(String value) {
            addCriterion("MERCHANT_NAME >=", value, "merchantName");
            return (Criteria) this;
        }

        public Criteria andMerchantNameLessThan(String value) {
            addCriterion("MERCHANT_NAME <", value, "merchantName");
            return (Criteria) this;
        }

        public Criteria andMerchantNameLessThanOrEqualTo(String value) {
            addCriterion("MERCHANT_NAME <=", value, "merchantName");
            return (Criteria) this;
        }

        public Criteria andMerchantNameLike(String value) {
            addCriterion("MERCHANT_NAME like", value, "merchantName");
            return (Criteria) this;
        }

        public Criteria andMerchantNameNotLike(String value) {
            addCriterion("MERCHANT_NAME not like", value, "merchantName");
            return (Criteria) this;
        }

        public Criteria andMerchantNameIn(List<String> values) {
            addCriterion("MERCHANT_NAME in", values, "merchantName");
            return (Criteria) this;
        }

        public Criteria andMerchantNameNotIn(List<String> values) {
            addCriterion("MERCHANT_NAME not in", values, "merchantName");
            return (Criteria) this;
        }

        public Criteria andMerchantNameBetween(String value1, String value2) {
            addCriterion("MERCHANT_NAME between", value1, value2, "merchantName");
            return (Criteria) this;
        }

        public Criteria andMerchantNameNotBetween(String value1, String value2) {
            addCriterion("MERCHANT_NAME not between", value1, value2, "merchantName");
            return (Criteria) this;
        }

        public Criteria andMccIsNull() {
            addCriterion("MCC is null");
            return (Criteria) this;
        }

        public Criteria andMccIsNotNull() {
            addCriterion("MCC is not null");
            return (Criteria) this;
        }

        public Criteria andMccEqualTo(String value) {
            addCriterion("MCC =", value, "mcc");
            return (Criteria) this;
        }

        public Criteria andMccNotEqualTo(String value) {
            addCriterion("MCC <>", value, "mcc");
            return (Criteria) this;
        }

        public Criteria andMccGreaterThan(String value) {
            addCriterion("MCC >", value, "mcc");
            return (Criteria) this;
        }

        public Criteria andMccGreaterThanOrEqualTo(String value) {
            addCriterion("MCC >=", value, "mcc");
            return (Criteria) this;
        }

        public Criteria andMccLessThan(String value) {
            addCriterion("MCC <", value, "mcc");
            return (Criteria) this;
        }

        public Criteria andMccLessThanOrEqualTo(String value) {
            addCriterion("MCC <=", value, "mcc");
            return (Criteria) this;
        }

        public Criteria andMccLike(String value) {
            addCriterion("MCC like", value, "mcc");
            return (Criteria) this;
        }

        public Criteria andMccNotLike(String value) {
            addCriterion("MCC not like", value, "mcc");
            return (Criteria) this;
        }

        public Criteria andMccIn(List<String> values) {
            addCriterion("MCC in", values, "mcc");
            return (Criteria) this;
        }

        public Criteria andMccNotIn(List<String> values) {
            addCriterion("MCC not in", values, "mcc");
            return (Criteria) this;
        }

        public Criteria andMccBetween(String value1, String value2) {
            addCriterion("MCC between", value1, value2, "mcc");
            return (Criteria) this;
        }

        public Criteria andMccNotBetween(String value1, String value2) {
            addCriterion("MCC not between", value1, value2, "mcc");
            return (Criteria) this;
        }

        public Criteria andLastLevelPromoterIdIsNull() {
            addCriterion("LAST_LEVEL_PROMOTER_ID is null");
            return (Criteria) this;
        }

        public Criteria andLastLevelPromoterIdIsNotNull() {
            addCriterion("LAST_LEVEL_PROMOTER_ID is not null");
            return (Criteria) this;
        }

        public Criteria andLastLevelPromoterIdEqualTo(Long value) {
            addCriterion("LAST_LEVEL_PROMOTER_ID =", value, "lastLevelPromoterId");
            return (Criteria) this;
        }

        public Criteria andLastLevelPromoterIdNotEqualTo(Long value) {
            addCriterion("LAST_LEVEL_PROMOTER_ID <>", value, "lastLevelPromoterId");
            return (Criteria) this;
        }

        public Criteria andLastLevelPromoterIdGreaterThan(Long value) {
            addCriterion("LAST_LEVEL_PROMOTER_ID >", value, "lastLevelPromoterId");
            return (Criteria) this;
        }

        public Criteria andLastLevelPromoterIdGreaterThanOrEqualTo(Long value) {
            addCriterion("LAST_LEVEL_PROMOTER_ID >=", value, "lastLevelPromoterId");
            return (Criteria) this;
        }

        public Criteria andLastLevelPromoterIdLessThan(Long value) {
            addCriterion("LAST_LEVEL_PROMOTER_ID <", value, "lastLevelPromoterId");
            return (Criteria) this;
        }

        public Criteria andLastLevelPromoterIdLessThanOrEqualTo(Long value) {
            addCriterion("LAST_LEVEL_PROMOTER_ID <=", value, "lastLevelPromoterId");
            return (Criteria) this;
        }

        public Criteria andLastLevelPromoterIdIn(List<Long> values) {
            addCriterion("LAST_LEVEL_PROMOTER_ID in", values, "lastLevelPromoterId");
            return (Criteria) this;
        }

        public Criteria andLastLevelPromoterIdNotIn(List<Long> values) {
            addCriterion("LAST_LEVEL_PROMOTER_ID not in", values, "lastLevelPromoterId");
            return (Criteria) this;
        }

        public Criteria andLastLevelPromoterIdBetween(Long value1, Long value2) {
            addCriterion("LAST_LEVEL_PROMOTER_ID between", value1, value2, "lastLevelPromoterId");
            return (Criteria) this;
        }

        public Criteria andLastLevelPromoterIdNotBetween(Long value1, Long value2) {
            addCriterion("LAST_LEVEL_PROMOTER_ID not between", value1, value2, "lastLevelPromoterId");
            return (Criteria) this;
        }

        public Criteria andPmtLevelIsNull() {
            addCriterion("PMT_LEVEL is null");
            return (Criteria) this;
        }

        public Criteria andPmtLevelIsNotNull() {
            addCriterion("PMT_LEVEL is not null");
            return (Criteria) this;
        }

        public Criteria andPmtLevelEqualTo(Integer value) {
            addCriterion("PMT_LEVEL =", value, "pmtLevel");
            return (Criteria) this;
        }

        public Criteria andPmtLevelNotEqualTo(Integer value) {
            addCriterion("PMT_LEVEL <>", value, "pmtLevel");
            return (Criteria) this;
        }

        public Criteria andPmtLevelGreaterThan(Integer value) {
            addCriterion("PMT_LEVEL >", value, "pmtLevel");
            return (Criteria) this;
        }

        public Criteria andPmtLevelGreaterThanOrEqualTo(Integer value) {
            addCriterion("PMT_LEVEL >=", value, "pmtLevel");
            return (Criteria) this;
        }

        public Criteria andPmtLevelLessThan(Integer value) {
            addCriterion("PMT_LEVEL <", value, "pmtLevel");
            return (Criteria) this;
        }

        public Criteria andPmtLevelLessThanOrEqualTo(Integer value) {
            addCriterion("PMT_LEVEL <=", value, "pmtLevel");
            return (Criteria) this;
        }

        public Criteria andPmtLevelIn(List<Integer> values) {
            addCriterion("PMT_LEVEL in", values, "pmtLevel");
            return (Criteria) this;
        }

        public Criteria andPmtLevelNotIn(List<Integer> values) {
            addCriterion("PMT_LEVEL not in", values, "pmtLevel");
            return (Criteria) this;
        }

        public Criteria andPmtLevelBetween(Integer value1, Integer value2) {
            addCriterion("PMT_LEVEL between", value1, value2, "pmtLevel");
            return (Criteria) this;
        }

        public Criteria andPmtLevelNotBetween(Integer value1, Integer value2) {
            addCriterion("PMT_LEVEL not between", value1, value2, "pmtLevel");
            return (Criteria) this;
        }

        public Criteria andCertTypeIsNull() {
            addCriterion("CERT_TYPE is null");
            return (Criteria) this;
        }

        public Criteria andCertTypeIsNotNull() {
            addCriterion("CERT_TYPE is not null");
            return (Criteria) this;
        }

        public Criteria andCertTypeEqualTo(String value) {
            addCriterion("CERT_TYPE =", value, "certType");
            return (Criteria) this;
        }

        public Criteria andCertTypeNotEqualTo(String value) {
            addCriterion("CERT_TYPE <>", value, "certType");
            return (Criteria) this;
        }

        public Criteria andCertTypeGreaterThan(String value) {
            addCriterion("CERT_TYPE >", value, "certType");
            return (Criteria) this;
        }

        public Criteria andCertTypeGreaterThanOrEqualTo(String value) {
            addCriterion("CERT_TYPE >=", value, "certType");
            return (Criteria) this;
        }

        public Criteria andCertTypeLessThan(String value) {
            addCriterion("CERT_TYPE <", value, "certType");
            return (Criteria) this;
        }

        public Criteria andCertTypeLessThanOrEqualTo(String value) {
            addCriterion("CERT_TYPE <=", value, "certType");
            return (Criteria) this;
        }

        public Criteria andCertTypeLike(String value) {
            addCriterion("CERT_TYPE like", value, "certType");
            return (Criteria) this;
        }

        public Criteria andCertTypeNotLike(String value) {
            addCriterion("CERT_TYPE not like", value, "certType");
            return (Criteria) this;
        }

        public Criteria andCertTypeIn(List<String> values) {
            addCriterion("CERT_TYPE in", values, "certType");
            return (Criteria) this;
        }

        public Criteria andCertTypeNotIn(List<String> values) {
            addCriterion("CERT_TYPE not in", values, "certType");
            return (Criteria) this;
        }

        public Criteria andCertTypeBetween(String value1, String value2) {
            addCriterion("CERT_TYPE between", value1, value2, "certType");
            return (Criteria) this;
        }

        public Criteria andCertTypeNotBetween(String value1, String value2) {
            addCriterion("CERT_TYPE not between", value1, value2, "certType");
            return (Criteria) this;
        }

        public Criteria andCertNoIsNull() {
            addCriterion("CERT_NO is null");
            return (Criteria) this;
        }

        public Criteria andCertNoIsNotNull() {
            addCriterion("CERT_NO is not null");
            return (Criteria) this;
        }

        public Criteria andCertNoEqualTo(String value) {
            addCriterion("CERT_NO =", value, "certNo");
            return (Criteria) this;
        }

        public Criteria andCertNoNotEqualTo(String value) {
            addCriterion("CERT_NO <>", value, "certNo");
            return (Criteria) this;
        }

        public Criteria andCertNoGreaterThan(String value) {
            addCriterion("CERT_NO >", value, "certNo");
            return (Criteria) this;
        }

        public Criteria andCertNoGreaterThanOrEqualTo(String value) {
            addCriterion("CERT_NO >=", value, "certNo");
            return (Criteria) this;
        }

        public Criteria andCertNoLessThan(String value) {
            addCriterion("CERT_NO <", value, "certNo");
            return (Criteria) this;
        }

        public Criteria andCertNoLessThanOrEqualTo(String value) {
            addCriterion("CERT_NO <=", value, "certNo");
            return (Criteria) this;
        }

        public Criteria andCertNoLike(String value) {
            addCriterion("CERT_NO like", value, "certNo");
            return (Criteria) this;
        }

        public Criteria andCertNoNotLike(String value) {
            addCriterion("CERT_NO not like", value, "certNo");
            return (Criteria) this;
        }

        public Criteria andCertNoIn(List<String> values) {
            addCriterion("CERT_NO in", values, "certNo");
            return (Criteria) this;
        }

        public Criteria andCertNoNotIn(List<String> values) {
            addCriterion("CERT_NO not in", values, "certNo");
            return (Criteria) this;
        }

        public Criteria andCertNoBetween(String value1, String value2) {
            addCriterion("CERT_NO between", value1, value2, "certNo");
            return (Criteria) this;
        }

        public Criteria andCertNoNotBetween(String value1, String value2) {
            addCriterion("CERT_NO not between", value1, value2, "certNo");
            return (Criteria) this;
        }
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table FW_POS_MERCHANT_INFO
     *
     * @mbggenerated do_not_delete_during_merge Wed Aug 10 08:42:07 CST 2016
     */
    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table FW_POS_MERCHANT_INFO
     * table comment :POS商户信息
     *
     * @mbggenerated Wed Aug 10 08:42:07 CST 2016
     */
    public static class Criterion {
        private String condition;

        private Object value;

        private Object secondValue;

        private boolean noValue;

        private boolean singleValue;

        private boolean betweenValue;

        private boolean listValue;

        private String typeHandler;

        public String getCondition() {
            return condition;
        }

        public Object getValue() {
            return value;
        }

        public Object getSecondValue() {
            return secondValue;
        }

        public boolean isNoValue() {
            return noValue;
        }

        public boolean isSingleValue() {
            return singleValue;
        }

        public boolean isBetweenValue() {
            return betweenValue;
        }

        public boolean isListValue() {
            return listValue;
        }

        public String getTypeHandler() {
            return typeHandler;
        }

        protected Criterion(String condition) {
            super();
            this.condition = condition;
            this.typeHandler = null;
            this.noValue = true;
        }

        protected Criterion(String condition, Object value, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.typeHandler = typeHandler;
            if (value instanceof List<?>) {
                this.listValue = true;
            } else {
                this.singleValue = true;
            }
        }

        protected Criterion(String condition, Object value) {
            this(condition, value, null);
        }

        protected Criterion(String condition, Object value, Object secondValue, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.secondValue = secondValue;
            this.typeHandler = typeHandler;
            this.betweenValue = true;
        }

        protected Criterion(String condition, Object value, Object secondValue) {
            this(condition, value, secondValue, null);
        }
    }
}