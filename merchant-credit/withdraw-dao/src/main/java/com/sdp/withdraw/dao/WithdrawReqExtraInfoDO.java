package com.sdp.withdraw.dao;

import com.sdp.emall.common.dao.BaseDO;
import java.math.BigDecimal;

public class WithdrawReqExtraInfoDO extends BaseDO {
    /**
     * This field corresponds to the database column FW_WITHDRAW_REQ_EXTRA_INFO.ID
     * column comments 主键
     *
     * @mbggenerated Tue Aug 30 09:37:59 CST 2016
     */
    private Long id;

    /**
     * This field corresponds to the database column FW_WITHDRAW_REQ_EXTRA_INFO.REQ_ID
     * column comments 出款请求的ID
     *
     * @mbggenerated Tue Aug 30 09:37:59 CST 2016
     */
    private Long reqId;

    /**
     * This field corresponds to the database column FW_WITHDRAW_REQ_EXTRA_INFO.POST_PAID_FLAG
     * column comments 后付费标示 1：后付费，0：非后付费
     *
     * @mbggenerated Tue Aug 30 09:37:59 CST 2016
     */
    private Integer postPaidFlag;

    /**
     * This field corresponds to the database column FW_WITHDRAW_REQ_EXTRA_INFO.INIT_WITHDRAW_AMOUNT
     * column comments 初始的请求的出款金额
     *
     * @mbggenerated Tue Aug 30 09:37:59 CST 2016
     */
    private BigDecimal initWithdrawAmount;

    /**
     * This field corresponds to the database column FW_WITHDRAW_REQ_EXTRA_INFO.EXTRA_VALUE1
     * column comments 扩展字段1
     *
     * @mbggenerated Tue Aug 30 09:37:59 CST 2016
     */
    private String extraValue1;

    /**
     * This field corresponds to the database column FW_WITHDRAW_REQ_EXTRA_INFO.EXTRA_VALUE2
     * column comments 扩展字段2
     *
     * @mbggenerated Tue Aug 30 09:37:59 CST 2016
     */
    private String extraValue2;

    /**
     * This field corresponds to the database column FW_WITHDRAW_REQ_EXTRA_INFO.EXTRA_VALUE3
     * column comments 扩展字段3
     *
     * @mbggenerated Tue Aug 30 09:37:59 CST 2016
     */
    private String extraValue3;

    /**
     * This method returns the value of the database column FW_WITHDRAW_REQ_EXTRA_INFO.ID
     *
     * @return the value of FW_WITHDRAW_REQ_EXTRA_INFO.ID
     * column comments 主键
     *
     * @mbggenerated Tue Aug 30 09:37:59 CST 2016
     */
    public Long getId() {
        return id;
    }

    /**
     * This method sets the value of the database column FW_WITHDRAW_REQ_EXTRA_INFO.ID
     *
     * @param id the value for FW_WITHDRAW_REQ_EXTRA_INFO.ID
     * column comments 主键
     *
     * @mbggenerated Tue Aug 30 09:37:59 CST 2016
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * This method returns the value of the database column FW_WITHDRAW_REQ_EXTRA_INFO.REQ_ID
     *
     * @return the value of FW_WITHDRAW_REQ_EXTRA_INFO.REQ_ID
     * column comments 出款请求的ID
     *
     * @mbggenerated Tue Aug 30 09:37:59 CST 2016
     */
    public Long getReqId() {
        return reqId;
    }

    /**
     * This method sets the value of the database column FW_WITHDRAW_REQ_EXTRA_INFO.REQ_ID
     *
     * @param reqId the value for FW_WITHDRAW_REQ_EXTRA_INFO.REQ_ID
     * column comments 出款请求的ID
     *
     * @mbggenerated Tue Aug 30 09:37:59 CST 2016
     */
    public void setReqId(Long reqId) {
        this.reqId = reqId;
    }

    /**
     * This method returns the value of the database column FW_WITHDRAW_REQ_EXTRA_INFO.POST_PAID_FLAG
     *
     * @return the value of FW_WITHDRAW_REQ_EXTRA_INFO.POST_PAID_FLAG
     * column comments 后付费标示 1：后付费，0：非后付费
     *
     * @mbggenerated Tue Aug 30 09:37:59 CST 2016
     */
    public Integer getPostPaidFlag() {
        return postPaidFlag;
    }

    /**
     * This method sets the value of the database column FW_WITHDRAW_REQ_EXTRA_INFO.POST_PAID_FLAG
     *
     * @param postPaidFlag the value for FW_WITHDRAW_REQ_EXTRA_INFO.POST_PAID_FLAG
     * column comments 后付费标示 1：后付费，0：非后付费
     *
     * @mbggenerated Tue Aug 30 09:37:59 CST 2016
     */
    public void setPostPaidFlag(Integer postPaidFlag) {
        this.postPaidFlag = postPaidFlag;
    }

    /**
     * This method returns the value of the database column FW_WITHDRAW_REQ_EXTRA_INFO.INIT_WITHDRAW_AMOUNT
     *
     * @return the value of FW_WITHDRAW_REQ_EXTRA_INFO.INIT_WITHDRAW_AMOUNT
     * column comments 初始的请求的出款金额
     *
     * @mbggenerated Tue Aug 30 09:37:59 CST 2016
     */
    public BigDecimal getInitWithdrawAmount() {
        return initWithdrawAmount;
    }

    /**
     * This method sets the value of the database column FW_WITHDRAW_REQ_EXTRA_INFO.INIT_WITHDRAW_AMOUNT
     *
     * @param initWithdrawAmount the value for FW_WITHDRAW_REQ_EXTRA_INFO.INIT_WITHDRAW_AMOUNT
     * column comments 初始的请求的出款金额
     *
     * @mbggenerated Tue Aug 30 09:37:59 CST 2016
     */
    public void setInitWithdrawAmount(BigDecimal initWithdrawAmount) {
        this.initWithdrawAmount = initWithdrawAmount;
    }

    /**
     * This method returns the value of the database column FW_WITHDRAW_REQ_EXTRA_INFO.EXTRA_VALUE1
     *
     * @return the value of FW_WITHDRAW_REQ_EXTRA_INFO.EXTRA_VALUE1
     * column comments 扩展字段1
     *
     * @mbggenerated Tue Aug 30 09:37:59 CST 2016
     */
    public String getExtraValue1() {
        return extraValue1;
    }

    /**
     * This method sets the value of the database column FW_WITHDRAW_REQ_EXTRA_INFO.EXTRA_VALUE1
     *
     * @param extraValue1 the value for FW_WITHDRAW_REQ_EXTRA_INFO.EXTRA_VALUE1
     * column comments 扩展字段1
     *
     * @mbggenerated Tue Aug 30 09:37:59 CST 2016
     */
    public void setExtraValue1(String extraValue1) {
        this.extraValue1 = extraValue1 == null ? null : extraValue1.trim();
    }

    /**
     * This method returns the value of the database column FW_WITHDRAW_REQ_EXTRA_INFO.EXTRA_VALUE2
     *
     * @return the value of FW_WITHDRAW_REQ_EXTRA_INFO.EXTRA_VALUE2
     * column comments 扩展字段2
     *
     * @mbggenerated Tue Aug 30 09:37:59 CST 2016
     */
    public String getExtraValue2() {
        return extraValue2;
    }

    /**
     * This method sets the value of the database column FW_WITHDRAW_REQ_EXTRA_INFO.EXTRA_VALUE2
     *
     * @param extraValue2 the value for FW_WITHDRAW_REQ_EXTRA_INFO.EXTRA_VALUE2
     * column comments 扩展字段2
     *
     * @mbggenerated Tue Aug 30 09:37:59 CST 2016
     */
    public void setExtraValue2(String extraValue2) {
        this.extraValue2 = extraValue2 == null ? null : extraValue2.trim();
    }

    /**
     * This method returns the value of the database column FW_WITHDRAW_REQ_EXTRA_INFO.EXTRA_VALUE3
     *
     * @return the value of FW_WITHDRAW_REQ_EXTRA_INFO.EXTRA_VALUE3
     * column comments 扩展字段3
     *
     * @mbggenerated Tue Aug 30 09:37:59 CST 2016
     */
    public String getExtraValue3() {
        return extraValue3;
    }

    /**
     * This method sets the value of the database column FW_WITHDRAW_REQ_EXTRA_INFO.EXTRA_VALUE3
     *
     * @param extraValue3 the value for FW_WITHDRAW_REQ_EXTRA_INFO.EXTRA_VALUE3
     * column comments 扩展字段3
     *
     * @mbggenerated Tue Aug 30 09:37:59 CST 2016
     */
    public void setExtraValue3(String extraValue3) {
        this.extraValue3 = extraValue3 == null ? null : extraValue3.trim();
    }
}