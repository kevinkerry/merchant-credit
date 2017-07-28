package com.sdp.mc.view.dao;

import com.sdp.emall.common.dao.BaseDO;

import java.math.BigDecimal;
import java.util.Date;

public class ViewMerchantInfoDTO extends BaseDO {
	/**
     * This field corresponds to the database column VIEW_MERCHANT_INFO.MERCHANT_ID
     * column comments null
     *
     * @mbggenerated Wed Aug 17 13:43:49 CST 2016
     */
    private Long merchantId;

    /**
     * This field corresponds to the database column VIEW_MERCHANT_INFO.MERCHANT_NO
     * column comments null
     *
     * @mbggenerated Wed Aug 17 13:43:49 CST 2016
     */
    private String merchantNo;

    /**
     * This field corresponds to the database column VIEW_MERCHANT_INFO.MC_TYPE
     * column comments null
     *
     * @mbggenerated Wed Aug 17 13:43:49 CST 2016
     */
    private String mcType;

    /**
     * This field corresponds to the database column VIEW_MERCHANT_INFO.MERCHANT_NAME
     * column comments null
     *
     * @mbggenerated Wed Aug 17 13:43:49 CST 2016
     */
    private String merchantName;

    /**
     * This field corresponds to the database column VIEW_MERCHANT_INFO.MERCHANT_FS_FLAG
     * column comments null
     *
     * @mbggenerated Wed Aug 17 13:43:49 CST 2016
     */
    private Integer merchantFsFlag;

    /**
     * This field corresponds to the database column VIEW_MERCHANT_INFO.MERCHANT_FS_LIMIT
     * column comments null
     *
     * @mbggenerated Wed Aug 17 13:43:49 CST 2016
     */
    private BigDecimal merchantFsLimit;

    /**
     * This field corresponds to the database column VIEW_MERCHANT_INFO.MERCHANT_FS_MIN_LIMIT
     * column comments null
     *
     * @mbggenerated Wed Aug 17 13:43:49 CST 2016
     */
    private BigDecimal merchantFsMinLimit;

    /**
     * This field corresponds to the database column VIEW_MERCHANT_INFO.MERCHANT_PHONE_NO
     * column comments null
     *
     * @mbggenerated Wed Aug 17 13:43:49 CST 2016
     */
    private String merchantPhoneNo;

    /**
     * This field corresponds to the database column VIEW_MERCHANT_INFO.AUTO_FAST_SETTLE_FLAG
     * column comments null
     *
     * @mbggenerated Wed Aug 17 13:43:49 CST 2016
     */
    private Integer autoFastSettleFlag;

    /**
     * This field corresponds to the database column VIEW_MERCHANT_INFO.MERCHANT_MCC
     * column comments null
     *
     * @mbggenerated Wed Aug 17 13:43:49 CST 2016
     */
    private String merchantMcc;

    /**
     * This field corresponds to the database column VIEW_MERCHANT_INFO.MERCHANT_BIZ_ID
     * column comments null
     *
     * @mbggenerated Wed Aug 17 13:43:49 CST 2016
     */
    private Long merchantBizId;

    /**
     * This field corresponds to the database column VIEW_MERCHANT_INFO.LAST_LEVEL_PROMOTER_ID
     * column comments null
     *
     * @mbggenerated Wed Aug 17 13:43:49 CST 2016
     */
    private Long lastLevelPromoterId;

    /**
     * This field corresponds to the database column VIEW_MERCHANT_INFO.PROMOTER_ID
     * column comments null
     *
     * @mbggenerated Wed Aug 17 13:43:49 CST 2016
     */
    private Long promoterId;

    /**
     * This field corresponds to the database column VIEW_MERCHANT_INFO.PROMOTER_MERCHANT_NO
     * column comments null
     *
     * @mbggenerated Wed Aug 17 13:43:49 CST 2016
     */
    private String promoterMerchantNo;

    /**
     * This field corresponds to the database column VIEW_MERCHANT_INFO.PROMOTER_NAME
     * column comments null
     *
     * @mbggenerated Wed Aug 17 13:43:49 CST 2016
     */
    private String promoterName;

    /**
     * This field corresponds to the database column VIEW_MERCHANT_INFO.PROMOTER_TYPE
     * column comments null
     *
     * @mbggenerated Wed Aug 17 13:43:49 CST 2016
     */
    private String promoterType;

    /**
     * This field corresponds to the database column VIEW_MERCHANT_INFO.PROMOTER_FS_FLAG
     * column comments null
     *
     * @mbggenerated Wed Aug 17 13:43:49 CST 2016
     */
    private Integer promoterFsFlag;

    /**
     * This field corresponds to the database column VIEW_MERCHANT_INFO.PROMOTER_FS_LIMIT
     * column comments null
     *
     * @mbggenerated Wed Aug 17 13:43:49 CST 2016
     */
    private BigDecimal promoterFsLimit;

    /**
     * This field corresponds to the database column VIEW_MERCHANT_INFO.PROMOTER_FS_MARGIN
     * column comments null
     *
     * @mbggenerated Wed Aug 17 13:43:49 CST 2016
     */
    private BigDecimal promoterFsMargin;

    /**
     * This field corresponds to the database column VIEW_MERCHANT_INFO.PMT_BIND_OPERATOR_ID
     * column comments null
     *
     * @mbggenerated Wed Aug 17 13:43:49 CST 2016
     */
    private String pmtBindOperatorId;

    /**
     * This field corresponds to the database column VIEW_MERCHANT_INFO.PMT_BIND_OPERATOR_NAME
     * column comments null
     *
     * @mbggenerated Wed Aug 17 13:43:49 CST 2016
     */
    private String pmtBindOperatorName;

    /**
     * This field corresponds to the database column VIEW_MERCHANT_INFO.LOANING_TYPE
     * column comments null
     *
     * @mbggenerated Wed Aug 17 13:43:49 CST 2016
     */
    private Integer loaningType;

    /**
     * This field corresponds to the database column VIEW_MERCHANT_INFO.PROMOTER_BIZ_ID
     * column comments null
     *
     * @mbggenerated Wed Aug 17 13:43:49 CST 2016
     */
    private Long promoterBizId;

    /**
     * This field corresponds to the database column VIEW_MERCHANT_INFO.CREATE_TIME
     * column comments null
     *
     * @mbggenerated Wed Aug 17 13:43:49 CST 2016
     */
    private Date createTime;

    /**
     * This field corresponds to the database column VIEW_MERCHANT_INFO.UPDATE_TIME
     * column comments null
     *
     * @mbggenerated Wed Aug 17 13:43:49 CST 2016
     */
    private Date updateTime;

    /**
     * This method returns the value of the database column VIEW_MERCHANT_INFO.MERCHANT_ID
     *
     * @return the value of VIEW_MERCHANT_INFO.MERCHANT_ID
     * column comments null
     *
     * @mbggenerated Wed Aug 17 13:43:49 CST 2016
     */
    public Long getMerchantId() {
        return merchantId;
    }

    /**
     * This method sets the value of the database column VIEW_MERCHANT_INFO.MERCHANT_ID
     *
     * @param merchantId the value for VIEW_MERCHANT_INFO.MERCHANT_ID
     * column comments null
     *
     * @mbggenerated Wed Aug 17 13:43:49 CST 2016
     */
    public void setMerchantId(Long merchantId) {
        this.merchantId = merchantId;
    }

    /**
     * This method returns the value of the database column VIEW_MERCHANT_INFO.MERCHANT_NO
     *
     * @return the value of VIEW_MERCHANT_INFO.MERCHANT_NO
     * column comments null
     *
     * @mbggenerated Wed Aug 17 13:43:49 CST 2016
     */
    public String getMerchantNo() {
        return merchantNo;
    }

    /**
     * This method sets the value of the database column VIEW_MERCHANT_INFO.MERCHANT_NO
     *
     * @param merchantNo the value for VIEW_MERCHANT_INFO.MERCHANT_NO
     * column comments null
     *
     * @mbggenerated Wed Aug 17 13:43:49 CST 2016
     */
    public void setMerchantNo(String merchantNo) {
        this.merchantNo = merchantNo == null ? null : merchantNo.trim();
    }

    /**
     * This method returns the value of the database column VIEW_MERCHANT_INFO.MC_TYPE
     *
     * @return the value of VIEW_MERCHANT_INFO.MC_TYPE
     * column comments null
     *
     * @mbggenerated Wed Aug 17 13:43:49 CST 2016
     */
    public String getMcType() {
        return mcType;
    }

    /**
     * This method sets the value of the database column VIEW_MERCHANT_INFO.MC_TYPE
     *
     * @param mcType the value for VIEW_MERCHANT_INFO.MC_TYPE
     * column comments null
     *
     * @mbggenerated Wed Aug 17 13:43:49 CST 2016
     */
    public void setMcType(String mcType) {
        this.mcType = mcType == null ? null : mcType.trim();
    }

    /**
     * This method returns the value of the database column VIEW_MERCHANT_INFO.MERCHANT_NAME
     *
     * @return the value of VIEW_MERCHANT_INFO.MERCHANT_NAME
     * column comments null
     *
     * @mbggenerated Wed Aug 17 13:43:49 CST 2016
     */
    public String getMerchantName() {
        return merchantName;
    }

    /**
     * This method sets the value of the database column VIEW_MERCHANT_INFO.MERCHANT_NAME
     *
     * @param merchantName the value for VIEW_MERCHANT_INFO.MERCHANT_NAME
     * column comments null
     *
     * @mbggenerated Wed Aug 17 13:43:49 CST 2016
     */
    public void setMerchantName(String merchantName) {
        this.merchantName = merchantName == null ? null : merchantName.trim();
    }

    /**
     * This method returns the value of the database column VIEW_MERCHANT_INFO.MERCHANT_FS_FLAG
     *
     * @return the value of VIEW_MERCHANT_INFO.MERCHANT_FS_FLAG
     * column comments null
     *
     * @mbggenerated Wed Aug 17 13:43:49 CST 2016
     */
    public Integer getMerchantFsFlag() {
        return merchantFsFlag;
    }

    /**
     * This method sets the value of the database column VIEW_MERCHANT_INFO.MERCHANT_FS_FLAG
     *
     * @param merchantFsFlag the value for VIEW_MERCHANT_INFO.MERCHANT_FS_FLAG
     * column comments null
     *
     * @mbggenerated Wed Aug 17 13:43:49 CST 2016
     */
    public void setMerchantFsFlag(Integer merchantFsFlag) {
        this.merchantFsFlag = merchantFsFlag;
    }

    /**
     * This method returns the value of the database column VIEW_MERCHANT_INFO.MERCHANT_FS_LIMIT
     *
     * @return the value of VIEW_MERCHANT_INFO.MERCHANT_FS_LIMIT
     * column comments null
     *
     * @mbggenerated Wed Aug 17 13:43:49 CST 2016
     */
    public BigDecimal getMerchantFsLimit() {
        return merchantFsLimit;
    }

    /**
     * This method sets the value of the database column VIEW_MERCHANT_INFO.MERCHANT_FS_LIMIT
     *
     * @param merchantFsLimit the value for VIEW_MERCHANT_INFO.MERCHANT_FS_LIMIT
     * column comments null
     *
     * @mbggenerated Wed Aug 17 13:43:49 CST 2016
     */
    public void setMerchantFsLimit(BigDecimal merchantFsLimit) {
        this.merchantFsLimit = merchantFsLimit;
    }

    /**
     * This method returns the value of the database column VIEW_MERCHANT_INFO.MERCHANT_FS_MIN_LIMIT
     *
     * @return the value of VIEW_MERCHANT_INFO.MERCHANT_FS_MIN_LIMIT
     * column comments null
     *
     * @mbggenerated Wed Aug 17 13:43:49 CST 2016
     */
    public BigDecimal getMerchantFsMinLimit() {
        return merchantFsMinLimit;
    }

    /**
     * This method sets the value of the database column VIEW_MERCHANT_INFO.MERCHANT_FS_MIN_LIMIT
     *
     * @param merchantFsMinLimit the value for VIEW_MERCHANT_INFO.MERCHANT_FS_MIN_LIMIT
     * column comments null
     *
     * @mbggenerated Wed Aug 17 13:43:49 CST 2016
     */
    public void setMerchantFsMinLimit(BigDecimal merchantFsMinLimit) {
        this.merchantFsMinLimit = merchantFsMinLimit;
    }

    /**
     * This method returns the value of the database column VIEW_MERCHANT_INFO.MERCHANT_PHONE_NO
     *
     * @return the value of VIEW_MERCHANT_INFO.MERCHANT_PHONE_NO
     * column comments null
     *
     * @mbggenerated Wed Aug 17 13:43:49 CST 2016
     */
    public String getMerchantPhoneNo() {
        return merchantPhoneNo;
    }

    /**
     * This method sets the value of the database column VIEW_MERCHANT_INFO.MERCHANT_PHONE_NO
     *
     * @param merchantPhoneNo the value for VIEW_MERCHANT_INFO.MERCHANT_PHONE_NO
     * column comments null
     *
     * @mbggenerated Wed Aug 17 13:43:49 CST 2016
     */
    public void setMerchantPhoneNo(String merchantPhoneNo) {
        this.merchantPhoneNo = merchantPhoneNo == null ? null : merchantPhoneNo.trim();
    }

    /**
     * This method returns the value of the database column VIEW_MERCHANT_INFO.AUTO_FAST_SETTLE_FLAG
     *
     * @return the value of VIEW_MERCHANT_INFO.AUTO_FAST_SETTLE_FLAG
     * column comments null
     *
     * @mbggenerated Wed Aug 17 13:43:49 CST 2016
     */
    public Integer getAutoFastSettleFlag() {
        return autoFastSettleFlag;
    }

    /**
     * This method sets the value of the database column VIEW_MERCHANT_INFO.AUTO_FAST_SETTLE_FLAG
     *
     * @param autoFastSettleFlag the value for VIEW_MERCHANT_INFO.AUTO_FAST_SETTLE_FLAG
     * column comments null
     *
     * @mbggenerated Wed Aug 17 13:43:49 CST 2016
     */
    public void setAutoFastSettleFlag(Integer autoFastSettleFlag) {
        this.autoFastSettleFlag = autoFastSettleFlag;
    }

    /**
     * This method returns the value of the database column VIEW_MERCHANT_INFO.MERCHANT_MCC
     *
     * @return the value of VIEW_MERCHANT_INFO.MERCHANT_MCC
     * column comments null
     *
     * @mbggenerated Wed Aug 17 13:43:49 CST 2016
     */
    public String getMerchantMcc() {
        return merchantMcc;
    }

    /**
     * This method sets the value of the database column VIEW_MERCHANT_INFO.MERCHANT_MCC
     *
     * @param merchantMcc the value for VIEW_MERCHANT_INFO.MERCHANT_MCC
     * column comments null
     *
     * @mbggenerated Wed Aug 17 13:43:49 CST 2016
     */
    public void setMerchantMcc(String merchantMcc) {
        this.merchantMcc = merchantMcc == null ? null : merchantMcc.trim();
    }

    /**
     * This method returns the value of the database column VIEW_MERCHANT_INFO.MERCHANT_BIZ_ID
     *
     * @return the value of VIEW_MERCHANT_INFO.MERCHANT_BIZ_ID
     * column comments null
     *
     * @mbggenerated Wed Aug 17 13:43:49 CST 2016
     */
    public Long getMerchantBizId() {
        return merchantBizId;
    }

    /**
     * This method sets the value of the database column VIEW_MERCHANT_INFO.MERCHANT_BIZ_ID
     *
     * @param merchantBizId the value for VIEW_MERCHANT_INFO.MERCHANT_BIZ_ID
     * column comments null
     *
     * @mbggenerated Wed Aug 17 13:43:49 CST 2016
     */
    public void setMerchantBizId(Long merchantBizId) {
        this.merchantBizId = merchantBizId;
    }

    /**
     * This method returns the value of the database column VIEW_MERCHANT_INFO.LAST_LEVEL_PROMOTER_ID
     *
     * @return the value of VIEW_MERCHANT_INFO.LAST_LEVEL_PROMOTER_ID
     * column comments null
     *
     * @mbggenerated Wed Aug 17 13:43:49 CST 2016
     */
    public Long getLastLevelPromoterId() {
        return lastLevelPromoterId;
    }

    /**
     * This method sets the value of the database column VIEW_MERCHANT_INFO.LAST_LEVEL_PROMOTER_ID
     *
     * @param lastLevelPromoterId the value for VIEW_MERCHANT_INFO.LAST_LEVEL_PROMOTER_ID
     * column comments null
     *
     * @mbggenerated Wed Aug 17 13:43:49 CST 2016
     */
    public void setLastLevelPromoterId(Long lastLevelPromoterId) {
        this.lastLevelPromoterId = lastLevelPromoterId;
    }

    /**
     * This method returns the value of the database column VIEW_MERCHANT_INFO.PROMOTER_ID
     *
     * @return the value of VIEW_MERCHANT_INFO.PROMOTER_ID
     * column comments null
     *
     * @mbggenerated Wed Aug 17 13:43:49 CST 2016
     */
    public Long getPromoterId() {
        return promoterId;
    }

    /**
     * This method sets the value of the database column VIEW_MERCHANT_INFO.PROMOTER_ID
     *
     * @param promoterId the value for VIEW_MERCHANT_INFO.PROMOTER_ID
     * column comments null
     *
     * @mbggenerated Wed Aug 17 13:43:49 CST 2016
     */
    public void setPromoterId(Long promoterId) {
        this.promoterId = promoterId;
    }

    /**
     * This method returns the value of the database column VIEW_MERCHANT_INFO.PROMOTER_MERCHANT_NO
     *
     * @return the value of VIEW_MERCHANT_INFO.PROMOTER_MERCHANT_NO
     * column comments null
     *
     * @mbggenerated Wed Aug 17 13:43:49 CST 2016
     */
    public String getPromoterMerchantNo() {
        return promoterMerchantNo;
    }

    /**
     * This method sets the value of the database column VIEW_MERCHANT_INFO.PROMOTER_MERCHANT_NO
     *
     * @param promoterMerchantNo the value for VIEW_MERCHANT_INFO.PROMOTER_MERCHANT_NO
     * column comments null
     *
     * @mbggenerated Wed Aug 17 13:43:49 CST 2016
     */
    public void setPromoterMerchantNo(String promoterMerchantNo) {
        this.promoterMerchantNo = promoterMerchantNo == null ? null : promoterMerchantNo.trim();
    }

    /**
     * This method returns the value of the database column VIEW_MERCHANT_INFO.PROMOTER_NAME
     *
     * @return the value of VIEW_MERCHANT_INFO.PROMOTER_NAME
     * column comments null
     *
     * @mbggenerated Wed Aug 17 13:43:49 CST 2016
     */
    public String getPromoterName() {
        return promoterName;
    }

    /**
     * This method sets the value of the database column VIEW_MERCHANT_INFO.PROMOTER_NAME
     *
     * @param promoterName the value for VIEW_MERCHANT_INFO.PROMOTER_NAME
     * column comments null
     *
     * @mbggenerated Wed Aug 17 13:43:49 CST 2016
     */
    public void setPromoterName(String promoterName) {
        this.promoterName = promoterName == null ? null : promoterName.trim();
    }

    /**
     * This method returns the value of the database column VIEW_MERCHANT_INFO.PROMOTER_TYPE
     *
     * @return the value of VIEW_MERCHANT_INFO.PROMOTER_TYPE
     * column comments null
     *
     * @mbggenerated Wed Aug 17 13:43:49 CST 2016
     */
    public String getPromoterType() {
        return promoterType;
    }

    /**
     * This method sets the value of the database column VIEW_MERCHANT_INFO.PROMOTER_TYPE
     *
     * @param promoterType the value for VIEW_MERCHANT_INFO.PROMOTER_TYPE
     * column comments null
     *
     * @mbggenerated Wed Aug 17 13:43:49 CST 2016
     */
    public void setPromoterType(String promoterType) {
        this.promoterType = promoterType == null ? null : promoterType.trim();
    }

    /**
     * This method returns the value of the database column VIEW_MERCHANT_INFO.PROMOTER_FS_FLAG
     *
     * @return the value of VIEW_MERCHANT_INFO.PROMOTER_FS_FLAG
     * column comments null
     *
     * @mbggenerated Wed Aug 17 13:43:49 CST 2016
     */
    public Integer getPromoterFsFlag() {
        return promoterFsFlag;
    }

    /**
     * This method sets the value of the database column VIEW_MERCHANT_INFO.PROMOTER_FS_FLAG
     *
     * @param promoterFsFlag the value for VIEW_MERCHANT_INFO.PROMOTER_FS_FLAG
     * column comments null
     *
     * @mbggenerated Wed Aug 17 13:43:49 CST 2016
     */
    public void setPromoterFsFlag(Integer promoterFsFlag) {
        this.promoterFsFlag = promoterFsFlag;
    }

    /**
     * This method returns the value of the database column VIEW_MERCHANT_INFO.PROMOTER_FS_LIMIT
     *
     * @return the value of VIEW_MERCHANT_INFO.PROMOTER_FS_LIMIT
     * column comments null
     *
     * @mbggenerated Wed Aug 17 13:43:49 CST 2016
     */
    public BigDecimal getPromoterFsLimit() {
        return promoterFsLimit;
    }

    /**
     * This method sets the value of the database column VIEW_MERCHANT_INFO.PROMOTER_FS_LIMIT
     *
     * @param promoterFsLimit the value for VIEW_MERCHANT_INFO.PROMOTER_FS_LIMIT
     * column comments null
     *
     * @mbggenerated Wed Aug 17 13:43:49 CST 2016
     */
    public void setPromoterFsLimit(BigDecimal promoterFsLimit) {
        this.promoterFsLimit = promoterFsLimit;
    }

    /**
     * This method returns the value of the database column VIEW_MERCHANT_INFO.PROMOTER_FS_MARGIN
     *
     * @return the value of VIEW_MERCHANT_INFO.PROMOTER_FS_MARGIN
     * column comments null
     *
     * @mbggenerated Wed Aug 17 13:43:49 CST 2016
     */
    public BigDecimal getPromoterFsMargin() {
        return promoterFsMargin;
    }

    /**
     * This method sets the value of the database column VIEW_MERCHANT_INFO.PROMOTER_FS_MARGIN
     *
     * @param promoterFsMargin the value for VIEW_MERCHANT_INFO.PROMOTER_FS_MARGIN
     * column comments null
     *
     * @mbggenerated Wed Aug 17 13:43:49 CST 2016
     */
    public void setPromoterFsMargin(BigDecimal promoterFsMargin) {
        this.promoterFsMargin = promoterFsMargin;
    }

    /**
     * This method returns the value of the database column VIEW_MERCHANT_INFO.PMT_BIND_OPERATOR_ID
     *
     * @return the value of VIEW_MERCHANT_INFO.PMT_BIND_OPERATOR_ID
     * column comments null
     *
     * @mbggenerated Wed Aug 17 13:43:49 CST 2016
     */
    public String getPmtBindOperatorId() {
        return pmtBindOperatorId;
    }

    /**
     * This method sets the value of the database column VIEW_MERCHANT_INFO.PMT_BIND_OPERATOR_ID
     *
     * @param pmtBindOperatorId the value for VIEW_MERCHANT_INFO.PMT_BIND_OPERATOR_ID
     * column comments null
     *
     * @mbggenerated Wed Aug 17 13:43:49 CST 2016
     */
    public void setPmtBindOperatorId(String pmtBindOperatorId) {
        this.pmtBindOperatorId = pmtBindOperatorId == null ? null : pmtBindOperatorId.trim();
    }

    /**
     * This method returns the value of the database column VIEW_MERCHANT_INFO.PMT_BIND_OPERATOR_NAME
     *
     * @return the value of VIEW_MERCHANT_INFO.PMT_BIND_OPERATOR_NAME
     * column comments null
     *
     * @mbggenerated Wed Aug 17 13:43:49 CST 2016
     */
    public String getPmtBindOperatorName() {
        return pmtBindOperatorName;
    }

    /**
     * This method sets the value of the database column VIEW_MERCHANT_INFO.PMT_BIND_OPERATOR_NAME
     *
     * @param pmtBindOperatorName the value for VIEW_MERCHANT_INFO.PMT_BIND_OPERATOR_NAME
     * column comments null
     *
     * @mbggenerated Wed Aug 17 13:43:49 CST 2016
     */
    public void setPmtBindOperatorName(String pmtBindOperatorName) {
        this.pmtBindOperatorName = pmtBindOperatorName == null ? null : pmtBindOperatorName.trim();
    }

    /**
     * This method returns the value of the database column VIEW_MERCHANT_INFO.LOANING_TYPE
     *
     * @return the value of VIEW_MERCHANT_INFO.LOANING_TYPE
     * column comments null
     *
     * @mbggenerated Wed Aug 17 13:43:49 CST 2016
     */
    public Integer getLoaningType() {
        return loaningType;
    }

    /**
     * This method sets the value of the database column VIEW_MERCHANT_INFO.LOANING_TYPE
     *
     * @param loaningType the value for VIEW_MERCHANT_INFO.LOANING_TYPE
     * column comments null
     *
     * @mbggenerated Wed Aug 17 13:43:49 CST 2016
     */
    public void setLoaningType(Integer loaningType) {
        this.loaningType = loaningType;
    }

    /**
     * This method returns the value of the database column VIEW_MERCHANT_INFO.PROMOTER_BIZ_ID
     *
     * @return the value of VIEW_MERCHANT_INFO.PROMOTER_BIZ_ID
     * column comments null
     *
     * @mbggenerated Wed Aug 17 13:43:49 CST 2016
     */
    public Long getPromoterBizId() {
        return promoterBizId;
    }

    /**
     * This method sets the value of the database column VIEW_MERCHANT_INFO.PROMOTER_BIZ_ID
     *
     * @param promoterBizId the value for VIEW_MERCHANT_INFO.PROMOTER_BIZ_ID
     * column comments null
     *
     * @mbggenerated Wed Aug 17 13:43:49 CST 2016
     */
    public void setPromoterBizId(Long promoterBizId) {
        this.promoterBizId = promoterBizId;
    }

    /**
     * This method returns the value of the database column VIEW_MERCHANT_INFO.CREATE_TIME
     *
     * @return the value of VIEW_MERCHANT_INFO.CREATE_TIME
     * column comments null
     *
     * @mbggenerated Wed Aug 17 13:43:49 CST 2016
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * This method sets the value of the database column VIEW_MERCHANT_INFO.CREATE_TIME
     *
     * @param createTime the value for VIEW_MERCHANT_INFO.CREATE_TIME
     * column comments null
     *
     * @mbggenerated Wed Aug 17 13:43:49 CST 2016
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * This method returns the value of the database column VIEW_MERCHANT_INFO.UPDATE_TIME
     *
     * @return the value of VIEW_MERCHANT_INFO.UPDATE_TIME
     * column comments null
     *
     * @mbggenerated Wed Aug 17 13:43:49 CST 2016
     */
    public Date getUpdateTime() {
        return updateTime;
    }

    /**
     * This method sets the value of the database column VIEW_MERCHANT_INFO.UPDATE_TIME
     *
     * @param updateTime the value for VIEW_MERCHANT_INFO.UPDATE_TIME
     * column comments null
     *
     * @mbggenerated Wed Aug 17 13:43:49 CST 2016
     */
    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }
}