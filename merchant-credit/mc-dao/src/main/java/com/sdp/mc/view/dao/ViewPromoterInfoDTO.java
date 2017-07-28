package com.sdp.mc.view.dao;

import com.sdp.emall.common.dao.BaseDO;

import java.math.BigDecimal;
import java.util.Date;

public class ViewPromoterInfoDTO extends BaseDO {
	/**
     * This field corresponds to the database column VIEW_PROMOTER_INFO.PROMOTER_ID
     * column comments null
     *
     * @mbggenerated Wed Aug 17 13:50:23 CST 2016
     */
    private Long promoterId;

    /**
     * This field corresponds to the database column VIEW_PROMOTER_INFO.PROMOTER_MERCHANT_NO
     * column comments null
     *
     * @mbggenerated Wed Aug 17 13:50:23 CST 2016
     */
    private String promoterMerchantNo;

    /**
     * This field corresponds to the database column VIEW_PROMOTER_INFO.PROMOTER_NAME
     * column comments null
     *
     * @mbggenerated Wed Aug 17 13:50:23 CST 2016
     */
    private String promoterName;

    /**
     * This field corresponds to the database column VIEW_PROMOTER_INFO.PROMOTER_TYPE
     * column comments null
     *
     * @mbggenerated Wed Aug 17 13:50:23 CST 2016
     */
    private String promoterType;

    /**
     * This field corresponds to the database column VIEW_PROMOTER_INFO.PROMOTER_FS_FLAG
     * column comments null
     *
     * @mbggenerated Wed Aug 17 13:50:23 CST 2016
     */
    private Integer promoterFsFlag;

    /**
     * This field corresponds to the database column VIEW_PROMOTER_INFO.PROMOTER_FS_LIMIT
     * column comments null
     *
     * @mbggenerated Wed Aug 17 13:50:23 CST 2016
     */
    private BigDecimal promoterFsLimit;

    /**
     * This field corresponds to the database column VIEW_PROMOTER_INFO.PROMOTER_FS_MARGIN
     * column comments null
     *
     * @mbggenerated Wed Aug 17 13:50:23 CST 2016
     */
    private BigDecimal promoterFsMargin;

    /**
     * This field corresponds to the database column VIEW_PROMOTER_INFO.CREATE_TIME
     * column comments null
     *
     * @mbggenerated Wed Aug 17 13:50:23 CST 2016
     */
    private Date createTime;

    /**
     * This field corresponds to the database column VIEW_PROMOTER_INFO.UPDATE_TIME
     * column comments null
     *
     * @mbggenerated Wed Aug 17 13:50:23 CST 2016
     */
    private Date updateTime;

    /**
     * This field corresponds to the database column VIEW_PROMOTER_INFO.LOANING_TYPE
     * column comments null
     *
     * @mbggenerated Wed Aug 17 13:50:23 CST 2016
     */
    private Integer loaningType;

    /**
     * This field corresponds to the database column VIEW_PROMOTER_INFO.PROMOTER_BIZ_ID
     * column comments null
     *
     * @mbggenerated Wed Aug 17 13:50:23 CST 2016
     */
    private Long promoterBizId;

    /**
     * This method returns the value of the database column VIEW_PROMOTER_INFO.PROMOTER_ID
     *
     * @return the value of VIEW_PROMOTER_INFO.PROMOTER_ID
     * column comments null
     *
     * @mbggenerated Wed Aug 17 13:50:23 CST 2016
     */
    public Long getPromoterId() {
        return promoterId;
    }

    /**
     * This method sets the value of the database column VIEW_PROMOTER_INFO.PROMOTER_ID
     *
     * @param promoterId the value for VIEW_PROMOTER_INFO.PROMOTER_ID
     * column comments null
     *
     * @mbggenerated Wed Aug 17 13:50:23 CST 2016
     */
    public void setPromoterId(Long promoterId) {
        this.promoterId = promoterId;
    }

    /**
     * This method returns the value of the database column VIEW_PROMOTER_INFO.PROMOTER_MERCHANT_NO
     *
     * @return the value of VIEW_PROMOTER_INFO.PROMOTER_MERCHANT_NO
     * column comments null
     *
     * @mbggenerated Wed Aug 17 13:50:23 CST 2016
     */
    public String getPromoterMerchantNo() {
        return promoterMerchantNo;
    }

    /**
     * This method sets the value of the database column VIEW_PROMOTER_INFO.PROMOTER_MERCHANT_NO
     *
     * @param promoterMerchantNo the value for VIEW_PROMOTER_INFO.PROMOTER_MERCHANT_NO
     * column comments null
     *
     * @mbggenerated Wed Aug 17 13:50:23 CST 2016
     */
    public void setPromoterMerchantNo(String promoterMerchantNo) {
        this.promoterMerchantNo = promoterMerchantNo == null ? null : promoterMerchantNo.trim();
    }

    /**
     * This method returns the value of the database column VIEW_PROMOTER_INFO.PROMOTER_NAME
     *
     * @return the value of VIEW_PROMOTER_INFO.PROMOTER_NAME
     * column comments null
     *
     * @mbggenerated Wed Aug 17 13:50:23 CST 2016
     */
    public String getPromoterName() {
        return promoterName;
    }

    /**
     * This method sets the value of the database column VIEW_PROMOTER_INFO.PROMOTER_NAME
     *
     * @param promoterName the value for VIEW_PROMOTER_INFO.PROMOTER_NAME
     * column comments null
     *
     * @mbggenerated Wed Aug 17 13:50:23 CST 2016
     */
    public void setPromoterName(String promoterName) {
        this.promoterName = promoterName == null ? null : promoterName.trim();
    }

    /**
     * This method returns the value of the database column VIEW_PROMOTER_INFO.PROMOTER_TYPE
     *
     * @return the value of VIEW_PROMOTER_INFO.PROMOTER_TYPE
     * column comments null
     *
     * @mbggenerated Wed Aug 17 13:50:23 CST 2016
     */
    public String getPromoterType() {
        return promoterType;
    }

    /**
     * This method sets the value of the database column VIEW_PROMOTER_INFO.PROMOTER_TYPE
     *
     * @param promoterType the value for VIEW_PROMOTER_INFO.PROMOTER_TYPE
     * column comments null
     *
     * @mbggenerated Wed Aug 17 13:50:23 CST 2016
     */
    public void setPromoterType(String promoterType) {
        this.promoterType = promoterType == null ? null : promoterType.trim();
    }

    /**
     * This method returns the value of the database column VIEW_PROMOTER_INFO.PROMOTER_FS_FLAG
     *
     * @return the value of VIEW_PROMOTER_INFO.PROMOTER_FS_FLAG
     * column comments null
     *
     * @mbggenerated Wed Aug 17 13:50:23 CST 2016
     */
    public Integer getPromoterFsFlag() {
        return promoterFsFlag;
    }

    /**
     * This method sets the value of the database column VIEW_PROMOTER_INFO.PROMOTER_FS_FLAG
     *
     * @param promoterFsFlag the value for VIEW_PROMOTER_INFO.PROMOTER_FS_FLAG
     * column comments null
     *
     * @mbggenerated Wed Aug 17 13:50:23 CST 2016
     */
    public void setPromoterFsFlag(Integer promoterFsFlag) {
        this.promoterFsFlag = promoterFsFlag;
    }

    /**
     * This method returns the value of the database column VIEW_PROMOTER_INFO.PROMOTER_FS_LIMIT
     *
     * @return the value of VIEW_PROMOTER_INFO.PROMOTER_FS_LIMIT
     * column comments null
     *
     * @mbggenerated Wed Aug 17 13:50:23 CST 2016
     */
    public BigDecimal getPromoterFsLimit() {
        return promoterFsLimit;
    }

    /**
     * This method sets the value of the database column VIEW_PROMOTER_INFO.PROMOTER_FS_LIMIT
     *
     * @param promoterFsLimit the value for VIEW_PROMOTER_INFO.PROMOTER_FS_LIMIT
     * column comments null
     *
     * @mbggenerated Wed Aug 17 13:50:23 CST 2016
     */
    public void setPromoterFsLimit(BigDecimal promoterFsLimit) {
        this.promoterFsLimit = promoterFsLimit;
    }

    /**
     * This method returns the value of the database column VIEW_PROMOTER_INFO.PROMOTER_FS_MARGIN
     *
     * @return the value of VIEW_PROMOTER_INFO.PROMOTER_FS_MARGIN
     * column comments null
     *
     * @mbggenerated Wed Aug 17 13:50:23 CST 2016
     */
    public BigDecimal getPromoterFsMargin() {
        return promoterFsMargin;
    }

    /**
     * This method sets the value of the database column VIEW_PROMOTER_INFO.PROMOTER_FS_MARGIN
     *
     * @param promoterFsMargin the value for VIEW_PROMOTER_INFO.PROMOTER_FS_MARGIN
     * column comments null
     *
     * @mbggenerated Wed Aug 17 13:50:23 CST 2016
     */
    public void setPromoterFsMargin(BigDecimal promoterFsMargin) {
        this.promoterFsMargin = promoterFsMargin;
    }

    /**
     * This method returns the value of the database column VIEW_PROMOTER_INFO.CREATE_TIME
     *
     * @return the value of VIEW_PROMOTER_INFO.CREATE_TIME
     * column comments null
     *
     * @mbggenerated Wed Aug 17 13:50:23 CST 2016
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * This method sets the value of the database column VIEW_PROMOTER_INFO.CREATE_TIME
     *
     * @param createTime the value for VIEW_PROMOTER_INFO.CREATE_TIME
     * column comments null
     *
     * @mbggenerated Wed Aug 17 13:50:23 CST 2016
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * This method returns the value of the database column VIEW_PROMOTER_INFO.UPDATE_TIME
     *
     * @return the value of VIEW_PROMOTER_INFO.UPDATE_TIME
     * column comments null
     *
     * @mbggenerated Wed Aug 17 13:50:23 CST 2016
     */
    public Date getUpdateTime() {
        return updateTime;
    }

    /**
     * This method sets the value of the database column VIEW_PROMOTER_INFO.UPDATE_TIME
     *
     * @param updateTime the value for VIEW_PROMOTER_INFO.UPDATE_TIME
     * column comments null
     *
     * @mbggenerated Wed Aug 17 13:50:23 CST 2016
     */
    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    /**
     * This method returns the value of the database column VIEW_PROMOTER_INFO.LOANING_TYPE
     *
     * @return the value of VIEW_PROMOTER_INFO.LOANING_TYPE
     * column comments null
     *
     * @mbggenerated Wed Aug 17 13:50:23 CST 2016
     */
    public Integer getLoaningType() {
        return loaningType;
    }

    /**
     * This method sets the value of the database column VIEW_PROMOTER_INFO.LOANING_TYPE
     *
     * @param loaningType the value for VIEW_PROMOTER_INFO.LOANING_TYPE
     * column comments null
     *
     * @mbggenerated Wed Aug 17 13:50:23 CST 2016
     */
    public void setLoaningType(Integer loaningType) {
        this.loaningType = loaningType;
    }

    /**
     * This method returns the value of the database column VIEW_PROMOTER_INFO.PROMOTER_BIZ_ID
     *
     * @return the value of VIEW_PROMOTER_INFO.PROMOTER_BIZ_ID
     * column comments null
     *
     * @mbggenerated Wed Aug 17 13:50:23 CST 2016
     */
    public Long getPromoterBizId() {
        return promoterBizId;
    }

    /**
     * This method sets the value of the database column VIEW_PROMOTER_INFO.PROMOTER_BIZ_ID
     *
     * @param promoterBizId the value for VIEW_PROMOTER_INFO.PROMOTER_BIZ_ID
     * column comments null
     *
     * @mbggenerated Wed Aug 17 13:50:23 CST 2016
     */
    public void setPromoterBizId(Long promoterBizId) {
        this.promoterBizId = promoterBizId;
    }
}