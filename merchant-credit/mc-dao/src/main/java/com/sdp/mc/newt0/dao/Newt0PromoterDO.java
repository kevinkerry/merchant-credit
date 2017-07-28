package com.sdp.mc.newt0.dao;

import com.sdp.emall.common.dao.BaseDO;
import java.math.BigDecimal;
import java.util.Date;

public class Newt0PromoterDO extends BaseDO {
    /**
     * This field corresponds to the database column NEWT0_PROMOTER.ID
     * column comments null
     *
     * @mbggenerated Thu Sep 17 20:00:09 CST 2015
     */
    private Long id;

    /**
     * This field corresponds to the database column NEWT0_PROMOTER.PROMOTER_ID
     * column comments 代理商编号
     *
     * @mbggenerated Thu Sep 17 20:00:09 CST 2015
     */
    private Long promoterId;

    /**
     * This field corresponds to the database column NEWT0_PROMOTER.PROMOTER_MERCHANT_NO
     * column comments 代理商商户号
     *
     * @mbggenerated Thu Sep 17 20:00:09 CST 2015
     */
    private Long promoterMerchantNo;

    /**
     * This field corresponds to the database column NEWT0_PROMOTER.LOANING_TYPE
     * column comments 垫资方
     *
     * @mbggenerated Thu Sep 17 20:00:09 CST 2015
     */
    private Integer loaningType;

    /**
     * This field corresponds to the database column NEWT0_PROMOTER.VALID_CREDIT
     * column comments 剩余可用额度
     *
     * @mbggenerated Thu Sep 17 20:00:09 CST 2015
     */
    private BigDecimal validCredit;

    /**
     * This field corresponds to the database column NEWT0_PROMOTER.CREATE_TIME
     * column comments null
     *
     * @mbggenerated Thu Sep 17 20:00:09 CST 2015
     */
    private Date createTime;

    /**
     * This field corresponds to the database column NEWT0_PROMOTER.UPDATE_TIME
     * column comments null
     *
     * @mbggenerated Thu Sep 17 20:00:09 CST 2015
     */
    private Date updateTime;

    /**
     * This method returns the value of the database column NEWT0_PROMOTER.ID
     *
     * @return the value of NEWT0_PROMOTER.ID
     * column comments null
     *
     * @mbggenerated Thu Sep 17 20:00:09 CST 2015
     */
    public Long getId() {
        return id;
    }

    /**
     * This method sets the value of the database column NEWT0_PROMOTER.ID
     *
     * @param id the value for NEWT0_PROMOTER.ID
     * column comments null
     *
     * @mbggenerated Thu Sep 17 20:00:09 CST 2015
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * This method returns the value of the database column NEWT0_PROMOTER.PROMOTER_ID
     *
     * @return the value of NEWT0_PROMOTER.PROMOTER_ID
     * column comments 代理商编号
     *
     * @mbggenerated Thu Sep 17 20:00:09 CST 2015
     */
    public Long getPromoterId() {
        return promoterId;
    }

    /**
     * This method sets the value of the database column NEWT0_PROMOTER.PROMOTER_ID
     *
     * @param promoterId the value for NEWT0_PROMOTER.PROMOTER_ID
     * column comments 代理商编号
     *
     * @mbggenerated Thu Sep 17 20:00:09 CST 2015
     */
    public void setPromoterId(Long promoterId) {
        this.promoterId = promoterId;
    }

    /**
     * This method returns the value of the database column NEWT0_PROMOTER.PROMOTER_MERCHANT_NO
     *
     * @return the value of NEWT0_PROMOTER.PROMOTER_MERCHANT_NO
     * column comments 代理商商户号
     *
     * @mbggenerated Thu Sep 17 20:00:09 CST 2015
     */
    public Long getPromoterMerchantNo() {
        return promoterMerchantNo;
    }

    /**
     * This method sets the value of the database column NEWT0_PROMOTER.PROMOTER_MERCHANT_NO
     *
     * @param promoterMerchantNo the value for NEWT0_PROMOTER.PROMOTER_MERCHANT_NO
     * column comments 代理商商户号
     *
     * @mbggenerated Thu Sep 17 20:00:09 CST 2015
     */
    public void setPromoterMerchantNo(Long promoterMerchantNo) {
        this.promoterMerchantNo = promoterMerchantNo;
    }

    /**
     * This method returns the value of the database column NEWT0_PROMOTER.LOANING_TYPE
     *
     * @return the value of NEWT0_PROMOTER.LOANING_TYPE
     * column comments 垫资方
     *
     * @mbggenerated Thu Sep 17 20:00:09 CST 2015
     */
    public Integer getLoaningType() {
        return loaningType;
    }

    /**
     * This method sets the value of the database column NEWT0_PROMOTER.LOANING_TYPE
     *
     * @param loaningType the value for NEWT0_PROMOTER.LOANING_TYPE
     * column comments 垫资方
     *
     * @mbggenerated Thu Sep 17 20:00:09 CST 2015
     */
    public void setLoaningType(Integer loaningType) {
        this.loaningType = loaningType;
    }

    /**
     * This method returns the value of the database column NEWT0_PROMOTER.VALID_CREDIT
     *
     * @return the value of NEWT0_PROMOTER.VALID_CREDIT
     * column comments 剩余可用额度
     *
     * @mbggenerated Thu Sep 17 20:00:09 CST 2015
     */
    public BigDecimal getValidCredit() {
        return validCredit;
    }

    /**
     * This method sets the value of the database column NEWT0_PROMOTER.VALID_CREDIT
     *
     * @param validCredit the value for NEWT0_PROMOTER.VALID_CREDIT
     * column comments 剩余可用额度
     *
     * @mbggenerated Thu Sep 17 20:00:09 CST 2015
     */
    public void setValidCredit(BigDecimal validCredit) {
        this.validCredit = validCredit;
    }

    /**
     * This method returns the value of the database column NEWT0_PROMOTER.CREATE_TIME
     *
     * @return the value of NEWT0_PROMOTER.CREATE_TIME
     * column comments null
     *
     * @mbggenerated Thu Sep 17 20:00:09 CST 2015
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * This method sets the value of the database column NEWT0_PROMOTER.CREATE_TIME
     *
     * @param createTime the value for NEWT0_PROMOTER.CREATE_TIME
     * column comments null
     *
     * @mbggenerated Thu Sep 17 20:00:09 CST 2015
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * This method returns the value of the database column NEWT0_PROMOTER.UPDATE_TIME
     *
     * @return the value of NEWT0_PROMOTER.UPDATE_TIME
     * column comments null
     *
     * @mbggenerated Thu Sep 17 20:00:09 CST 2015
     */
    public Date getUpdateTime() {
        return updateTime;
    }

    /**
     * This method sets the value of the database column NEWT0_PROMOTER.UPDATE_TIME
     *
     * @param updateTime the value for NEWT0_PROMOTER.UPDATE_TIME
     * column comments null
     *
     * @mbggenerated Thu Sep 17 20:00:09 CST 2015
     */
    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }
}