package com.sdp.withdraw.dao;

import com.sdp.emall.common.dao.BaseDO;
import java.util.Date;

public class MerchantSettleAttrDO extends BaseDO {
    /**
     * This field corresponds to the database column FW_MERCHANT_SETTLE_ATTR.ID
     * column comments null
     *
     * @mbggenerated Wed Aug 17 13:25:50 CST 2016
     */
    private Long id;

    /**
     * This field corresponds to the database column FW_MERCHANT_SETTLE_ATTR.BIZ_TYPE
     * column comments 结算类型T0/T1/D1
     *
     * @mbggenerated Wed Aug 17 13:25:50 CST 2016
     */
    private Integer bizType;

    /**
     * This field corresponds to the database column FW_MERCHANT_SETTLE_ATTR.FIRST_OPEN_TIME
     * column comments 首次开通时间
     *
     * @mbggenerated Wed Aug 17 13:25:50 CST 2016
     */
    private Date firstOpenTime;

    /**
     * This field corresponds to the database column FW_MERCHANT_SETTLE_ATTR.MERCHANT_NO
     * column comments 扩展字段1
     *
     * @mbggenerated Wed Aug 17 13:25:50 CST 2016
     */
    private String merchantNo;

    /**
     * This field corresponds to the database column FW_MERCHANT_SETTLE_ATTR.MERCHANT_TYPE
     * column comments 扩展字段2
     *
     * @mbggenerated Wed Aug 17 13:25:50 CST 2016
     */
    private String merchantType;

    /**
     * This field corresponds to the database column FW_MERCHANT_SETTLE_ATTR.CREATE_TIME
     * column comments 创建时间
     *
     * @mbggenerated Wed Aug 17 13:25:50 CST 2016
     */
    private Date createTime;

    /**
     * This field corresponds to the database column FW_MERCHANT_SETTLE_ATTR.UPDATE_TIME
     * column comments 修改时间
     *
     * @mbggenerated Wed Aug 17 13:25:50 CST 2016
     */
    private Date updateTime;

    /**
     * This field corresponds to the database column FW_MERCHANT_SETTLE_ATTR.BIZ_ID
     * column comments 商户的业务ID
     *
     * @mbggenerated Wed Aug 17 13:25:50 CST 2016
     */
    private Long bizId;

    /**
     * This field corresponds to the database column FW_MERCHANT_SETTLE_ATTR.EXT1
     * column comments null
     *
     * @mbggenerated Wed Aug 17 13:25:50 CST 2016
     */
    private String ext1;

    /**
     * This field corresponds to the database column FW_MERCHANT_SETTLE_ATTR.EXT2
     * column comments null
     *
     * @mbggenerated Wed Aug 17 13:25:50 CST 2016
     */
    private String ext2;

    /**
     * This method returns the value of the database column FW_MERCHANT_SETTLE_ATTR.ID
     *
     * @return the value of FW_MERCHANT_SETTLE_ATTR.ID
     * column comments null
     *
     * @mbggenerated Wed Aug 17 13:25:50 CST 2016
     */
    public Long getId() {
        return id;
    }

    /**
     * This method sets the value of the database column FW_MERCHANT_SETTLE_ATTR.ID
     *
     * @param id the value for FW_MERCHANT_SETTLE_ATTR.ID
     * column comments null
     *
     * @mbggenerated Wed Aug 17 13:25:50 CST 2016
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * This method returns the value of the database column FW_MERCHANT_SETTLE_ATTR.BIZ_TYPE
     *
     * @return the value of FW_MERCHANT_SETTLE_ATTR.BIZ_TYPE
     * column comments 结算类型T0/T1/D1
     *
     * @mbggenerated Wed Aug 17 13:25:50 CST 2016
     */
    public Integer getBizType() {
        return bizType;
    }

    /**
     * This method sets the value of the database column FW_MERCHANT_SETTLE_ATTR.BIZ_TYPE
     *
     * @param bizType the value for FW_MERCHANT_SETTLE_ATTR.BIZ_TYPE
     * column comments 结算类型T0/T1/D1
     *
     * @mbggenerated Wed Aug 17 13:25:50 CST 2016
     */
    public void setBizType(Integer bizType) {
        this.bizType = bizType;
    }

    /**
     * This method returns the value of the database column FW_MERCHANT_SETTLE_ATTR.FIRST_OPEN_TIME
     *
     * @return the value of FW_MERCHANT_SETTLE_ATTR.FIRST_OPEN_TIME
     * column comments 首次开通时间
     *
     * @mbggenerated Wed Aug 17 13:25:50 CST 2016
     */
    public Date getFirstOpenTime() {
        return firstOpenTime;
    }

    /**
     * This method sets the value of the database column FW_MERCHANT_SETTLE_ATTR.FIRST_OPEN_TIME
     *
     * @param firstOpenTime the value for FW_MERCHANT_SETTLE_ATTR.FIRST_OPEN_TIME
     * column comments 首次开通时间
     *
     * @mbggenerated Wed Aug 17 13:25:50 CST 2016
     */
    public void setFirstOpenTime(Date firstOpenTime) {
        this.firstOpenTime = firstOpenTime;
    }

    /**
     * This method returns the value of the database column FW_MERCHANT_SETTLE_ATTR.MERCHANT_NO
     *
     * @return the value of FW_MERCHANT_SETTLE_ATTR.MERCHANT_NO
     * column comments 扩展字段1
     *
     * @mbggenerated Wed Aug 17 13:25:50 CST 2016
     */
    public String getMerchantNo() {
        return merchantNo;
    }

    /**
     * This method sets the value of the database column FW_MERCHANT_SETTLE_ATTR.MERCHANT_NO
     *
     * @param merchantNo the value for FW_MERCHANT_SETTLE_ATTR.MERCHANT_NO
     * column comments 扩展字段1
     *
     * @mbggenerated Wed Aug 17 13:25:50 CST 2016
     */
    public void setMerchantNo(String merchantNo) {
        this.merchantNo = merchantNo == null ? null : merchantNo.trim();
    }

    /**
     * This method returns the value of the database column FW_MERCHANT_SETTLE_ATTR.MERCHANT_TYPE
     *
     * @return the value of FW_MERCHANT_SETTLE_ATTR.MERCHANT_TYPE
     * column comments 扩展字段2
     *
     * @mbggenerated Wed Aug 17 13:25:50 CST 2016
     */
    public String getMerchantType() {
        return merchantType;
    }

    /**
     * This method sets the value of the database column FW_MERCHANT_SETTLE_ATTR.MERCHANT_TYPE
     *
     * @param merchantType the value for FW_MERCHANT_SETTLE_ATTR.MERCHANT_TYPE
     * column comments 扩展字段2
     *
     * @mbggenerated Wed Aug 17 13:25:50 CST 2016
     */
    public void setMerchantType(String merchantType) {
        this.merchantType = merchantType == null ? null : merchantType.trim();
    }

    /**
     * This method returns the value of the database column FW_MERCHANT_SETTLE_ATTR.CREATE_TIME
     *
     * @return the value of FW_MERCHANT_SETTLE_ATTR.CREATE_TIME
     * column comments 创建时间
     *
     * @mbggenerated Wed Aug 17 13:25:50 CST 2016
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * This method sets the value of the database column FW_MERCHANT_SETTLE_ATTR.CREATE_TIME
     *
     * @param createTime the value for FW_MERCHANT_SETTLE_ATTR.CREATE_TIME
     * column comments 创建时间
     *
     * @mbggenerated Wed Aug 17 13:25:50 CST 2016
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * This method returns the value of the database column FW_MERCHANT_SETTLE_ATTR.UPDATE_TIME
     *
     * @return the value of FW_MERCHANT_SETTLE_ATTR.UPDATE_TIME
     * column comments 修改时间
     *
     * @mbggenerated Wed Aug 17 13:25:50 CST 2016
     */
    public Date getUpdateTime() {
        return updateTime;
    }

    /**
     * This method sets the value of the database column FW_MERCHANT_SETTLE_ATTR.UPDATE_TIME
     *
     * @param updateTime the value for FW_MERCHANT_SETTLE_ATTR.UPDATE_TIME
     * column comments 修改时间
     *
     * @mbggenerated Wed Aug 17 13:25:50 CST 2016
     */
    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    /**
     * This method returns the value of the database column FW_MERCHANT_SETTLE_ATTR.BIZ_ID
     *
     * @return the value of FW_MERCHANT_SETTLE_ATTR.BIZ_ID
     * column comments 商户的业务ID
     *
     * @mbggenerated Wed Aug 17 13:25:50 CST 2016
     */
    public Long getBizId() {
        return bizId;
    }

    /**
     * This method sets the value of the database column FW_MERCHANT_SETTLE_ATTR.BIZ_ID
     *
     * @param bizId the value for FW_MERCHANT_SETTLE_ATTR.BIZ_ID
     * column comments 商户的业务ID
     *
     * @mbggenerated Wed Aug 17 13:25:50 CST 2016
     */
    public void setBizId(Long bizId) {
        this.bizId = bizId;
    }

    /**
     * This method returns the value of the database column FW_MERCHANT_SETTLE_ATTR.EXT1
     *
     * @return the value of FW_MERCHANT_SETTLE_ATTR.EXT1
     * column comments null
     *
     * @mbggenerated Wed Aug 17 13:25:50 CST 2016
     */
    public String getExt1() {
        return ext1;
    }

    /**
     * This method sets the value of the database column FW_MERCHANT_SETTLE_ATTR.EXT1
     *
     * @param ext1 the value for FW_MERCHANT_SETTLE_ATTR.EXT1
     * column comments null
     *
     * @mbggenerated Wed Aug 17 13:25:50 CST 2016
     */
    public void setExt1(String ext1) {
        this.ext1 = ext1 == null ? null : ext1.trim();
    }

    /**
     * This method returns the value of the database column FW_MERCHANT_SETTLE_ATTR.EXT2
     *
     * @return the value of FW_MERCHANT_SETTLE_ATTR.EXT2
     * column comments null
     *
     * @mbggenerated Wed Aug 17 13:25:50 CST 2016
     */
    public String getExt2() {
        return ext2;
    }

    /**
     * This method sets the value of the database column FW_MERCHANT_SETTLE_ATTR.EXT2
     *
     * @param ext2 the value for FW_MERCHANT_SETTLE_ATTR.EXT2
     * column comments null
     *
     * @mbggenerated Wed Aug 17 13:25:50 CST 2016
     */
    public void setExt2(String ext2) {
        this.ext2 = ext2 == null ? null : ext2.trim();
    }
}