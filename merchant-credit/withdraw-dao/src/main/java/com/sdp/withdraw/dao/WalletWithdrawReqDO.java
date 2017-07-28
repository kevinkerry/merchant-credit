package com.sdp.withdraw.dao;

import com.sdp.emall.common.dao.BaseDO;
import java.math.BigDecimal;
import java.util.Date;

public class WalletWithdrawReqDO extends BaseDO {
    /**
     * This field corresponds to the database column FW_WALLET_WITHDRAW_REQ.REQ_ID
     * column comments 请求ID
     *
     * @mbggenerated Wed Nov 23 10:26:15 CST 2016
     */
    private Long reqId;

    /**
     * This field corresponds to the database column FW_WALLET_WITHDRAW_REQ.APP_ID
     * column comments 数据来源的应用ID
     *
     * @mbggenerated Wed Nov 23 10:26:15 CST 2016
     */
    private String appId;

    /**
     * This field corresponds to the database column FW_WALLET_WITHDRAW_REQ.ORDER_NO
     * column comments 订单号
     *
     * @mbggenerated Wed Nov 23 10:26:15 CST 2016
     */
    private String orderNo;

    /**
     * This field corresponds to the database column FW_WALLET_WITHDRAW_REQ.MEMBER_ID
     * column comments 会员ID
     *
     * @mbggenerated Wed Nov 23 10:26:15 CST 2016
     */
    private String memberId;

    /**
     * This field corresponds to the database column FW_WALLET_WITHDRAW_REQ.MEMBER_NO
     * column comments 出款的会员号，如果是线下出款是商户号
     *
     * @mbggenerated Wed Nov 23 10:26:15 CST 2016
     */
    private String memberNo;

    /**
     * This field corresponds to the database column FW_WALLET_WITHDRAW_REQ.MEMBER_TYPE
     * column comments 出款会员的类型，POS商户：0001； mPOS商户：0006；
     *
     * @mbggenerated Wed Nov 23 10:26:15 CST 2016
     */
    private String memberType;

    /**
     * This field corresponds to the database column FW_WALLET_WITHDRAW_REQ.WITHDRAW_AMOUNT
     * column comments 可出款金额
     *
     * @mbggenerated Wed Nov 23 10:26:15 CST 2016
     */
    private BigDecimal withdrawAmount;

    /**
     * This field corresponds to the database column FW_WALLET_WITHDRAW_REQ.ORIGINAL_AMOUNT
     * column comments 原始收单金额
     *
     * @mbggenerated Wed Nov 23 10:26:15 CST 2016
     */
    private BigDecimal originalAmount;

    /**
     * This field corresponds to the database column FW_WALLET_WITHDRAW_REQ.TRACE_NO
     * column comments 出款的请求的跟踪号
     *
     * @mbggenerated Wed Nov 23 10:26:15 CST 2016
     */
    private Long traceNo;

    /**
     * This field corresponds to the database column FW_WALLET_WITHDRAW_REQ.EXTENTION
     * column comments 扩展信息
     *
     * @mbggenerated Wed Nov 23 10:26:15 CST 2016
     */
    private String extention;

    /**
     * This field corresponds to the database column FW_WALLET_WITHDRAW_REQ.STATUS
     * column comments 状态，0：出款成功，1：待出款 2：出款中  9：出款失败
     *
     * @mbggenerated Wed Nov 23 10:26:15 CST 2016
     */
    private Integer status;

    /**
     * This field corresponds to the database column FW_WALLET_WITHDRAW_REQ.CALLBACK_ADDRESS
     * column comments 回掉地址
     *
     * @mbggenerated Wed Nov 23 10:26:15 CST 2016
     */
    private String callbackAddress;

    /**
     * This field corresponds to the database column FW_WALLET_WITHDRAW_REQ.CREATE_TIME
     * column comments 创建时间
     *
     * @mbggenerated Wed Nov 23 10:26:15 CST 2016
     */
    private Date createTime;

    /**
     * This field corresponds to the database column FW_WALLET_WITHDRAW_REQ.UPDATE_TIME
     * column comments 最后修改时间
     *
     * @mbggenerated Wed Nov 23 10:26:15 CST 2016
     */
    private Date updateTime;

    /**
     * This method returns the value of the database column FW_WALLET_WITHDRAW_REQ.REQ_ID
     *
     * @return the value of FW_WALLET_WITHDRAW_REQ.REQ_ID
     * column comments 请求ID
     *
     * @mbggenerated Wed Nov 23 10:26:15 CST 2016
     */
    public Long getReqId() {
        return reqId;
    }

    /**
     * This method sets the value of the database column FW_WALLET_WITHDRAW_REQ.REQ_ID
     *
     * @param reqId the value for FW_WALLET_WITHDRAW_REQ.REQ_ID
     * column comments 请求ID
     *
     * @mbggenerated Wed Nov 23 10:26:15 CST 2016
     */
    public void setReqId(Long reqId) {
        this.reqId = reqId;
    }

    /**
     * This method returns the value of the database column FW_WALLET_WITHDRAW_REQ.APP_ID
     *
     * @return the value of FW_WALLET_WITHDRAW_REQ.APP_ID
     * column comments 数据来源的应用ID
     *
     * @mbggenerated Wed Nov 23 10:26:15 CST 2016
     */
    public String getAppId() {
        return appId;
    }

    /**
     * This method sets the value of the database column FW_WALLET_WITHDRAW_REQ.APP_ID
     *
     * @param appId the value for FW_WALLET_WITHDRAW_REQ.APP_ID
     * column comments 数据来源的应用ID
     *
     * @mbggenerated Wed Nov 23 10:26:15 CST 2016
     */
    public void setAppId(String appId) {
        this.appId = appId == null ? null : appId.trim();
    }

    /**
     * This method returns the value of the database column FW_WALLET_WITHDRAW_REQ.ORDER_NO
     *
     * @return the value of FW_WALLET_WITHDRAW_REQ.ORDER_NO
     * column comments 订单号
     *
     * @mbggenerated Wed Nov 23 10:26:15 CST 2016
     */
    public String getOrderNo() {
        return orderNo;
    }

    /**
     * This method sets the value of the database column FW_WALLET_WITHDRAW_REQ.ORDER_NO
     *
     * @param orderNo the value for FW_WALLET_WITHDRAW_REQ.ORDER_NO
     * column comments 订单号
     *
     * @mbggenerated Wed Nov 23 10:26:15 CST 2016
     */
    public void setOrderNo(String orderNo) {
        this.orderNo = orderNo == null ? null : orderNo.trim();
    }

    /**
     * This method returns the value of the database column FW_WALLET_WITHDRAW_REQ.MEMBER_ID
     *
     * @return the value of FW_WALLET_WITHDRAW_REQ.MEMBER_ID
     * column comments 会员ID
     *
     * @mbggenerated Wed Nov 23 10:26:15 CST 2016
     */
    public String getMemberId() {
        return memberId;
    }

    /**
     * This method sets the value of the database column FW_WALLET_WITHDRAW_REQ.MEMBER_ID
     *
     * @param memberId the value for FW_WALLET_WITHDRAW_REQ.MEMBER_ID
     * column comments 会员ID
     *
     * @mbggenerated Wed Nov 23 10:26:15 CST 2016
     */
    public void setMemberId(String memberId) {
        this.memberId = memberId == null ? null : memberId.trim();
    }

    /**
     * This method returns the value of the database column FW_WALLET_WITHDRAW_REQ.MEMBER_NO
     *
     * @return the value of FW_WALLET_WITHDRAW_REQ.MEMBER_NO
     * column comments 出款的会员号，如果是线下出款是商户号
     *
     * @mbggenerated Wed Nov 23 10:26:15 CST 2016
     */
    public String getMemberNo() {
        return memberNo;
    }

    /**
     * This method sets the value of the database column FW_WALLET_WITHDRAW_REQ.MEMBER_NO
     *
     * @param memberNo the value for FW_WALLET_WITHDRAW_REQ.MEMBER_NO
     * column comments 出款的会员号，如果是线下出款是商户号
     *
     * @mbggenerated Wed Nov 23 10:26:15 CST 2016
     */
    public void setMemberNo(String memberNo) {
        this.memberNo = memberNo == null ? null : memberNo.trim();
    }

    /**
     * This method returns the value of the database column FW_WALLET_WITHDRAW_REQ.MEMBER_TYPE
     *
     * @return the value of FW_WALLET_WITHDRAW_REQ.MEMBER_TYPE
     * column comments 出款会员的类型，POS商户：0001； mPOS商户：0006；
     *
     * @mbggenerated Wed Nov 23 10:26:15 CST 2016
     */
    public String getMemberType() {
        return memberType;
    }

    /**
     * This method sets the value of the database column FW_WALLET_WITHDRAW_REQ.MEMBER_TYPE
     *
     * @param memberType the value for FW_WALLET_WITHDRAW_REQ.MEMBER_TYPE
     * column comments 出款会员的类型，POS商户：0001； mPOS商户：0006；
     *
     * @mbggenerated Wed Nov 23 10:26:15 CST 2016
     */
    public void setMemberType(String memberType) {
        this.memberType = memberType == null ? null : memberType.trim();
    }

    /**
     * This method returns the value of the database column FW_WALLET_WITHDRAW_REQ.WITHDRAW_AMOUNT
     *
     * @return the value of FW_WALLET_WITHDRAW_REQ.WITHDRAW_AMOUNT
     * column comments 可出款金额
     *
     * @mbggenerated Wed Nov 23 10:26:15 CST 2016
     */
    public BigDecimal getWithdrawAmount() {
        return withdrawAmount;
    }

    /**
     * This method sets the value of the database column FW_WALLET_WITHDRAW_REQ.WITHDRAW_AMOUNT
     *
     * @param withdrawAmount the value for FW_WALLET_WITHDRAW_REQ.WITHDRAW_AMOUNT
     * column comments 可出款金额
     *
     * @mbggenerated Wed Nov 23 10:26:15 CST 2016
     */
    public void setWithdrawAmount(BigDecimal withdrawAmount) {
        this.withdrawAmount = withdrawAmount;
    }

    /**
     * This method returns the value of the database column FW_WALLET_WITHDRAW_REQ.ORIGINAL_AMOUNT
     *
     * @return the value of FW_WALLET_WITHDRAW_REQ.ORIGINAL_AMOUNT
     * column comments 原始收单金额
     *
     * @mbggenerated Wed Nov 23 10:26:15 CST 2016
     */
    public BigDecimal getOriginalAmount() {
        return originalAmount;
    }

    /**
     * This method sets the value of the database column FW_WALLET_WITHDRAW_REQ.ORIGINAL_AMOUNT
     *
     * @param originalAmount the value for FW_WALLET_WITHDRAW_REQ.ORIGINAL_AMOUNT
     * column comments 原始收单金额
     *
     * @mbggenerated Wed Nov 23 10:26:15 CST 2016
     */
    public void setOriginalAmount(BigDecimal originalAmount) {
        this.originalAmount = originalAmount;
    }

    /**
     * This method returns the value of the database column FW_WALLET_WITHDRAW_REQ.TRACE_NO
     *
     * @return the value of FW_WALLET_WITHDRAW_REQ.TRACE_NO
     * column comments 出款的请求的跟踪号
     *
     * @mbggenerated Wed Nov 23 10:26:15 CST 2016
     */
    public Long getTraceNo() {
        return traceNo;
    }

    /**
     * This method sets the value of the database column FW_WALLET_WITHDRAW_REQ.TRACE_NO
     *
     * @param traceNo the value for FW_WALLET_WITHDRAW_REQ.TRACE_NO
     * column comments 出款的请求的跟踪号
     *
     * @mbggenerated Wed Nov 23 10:26:15 CST 2016
     */
    public void setTraceNo(Long traceNo) {
        this.traceNo = traceNo;
    }

    /**
     * This method returns the value of the database column FW_WALLET_WITHDRAW_REQ.EXTENTION
     *
     * @return the value of FW_WALLET_WITHDRAW_REQ.EXTENTION
     * column comments 扩展信息
     *
     * @mbggenerated Wed Nov 23 10:26:15 CST 2016
     */
    public String getExtention() {
        return extention;
    }

    /**
     * This method sets the value of the database column FW_WALLET_WITHDRAW_REQ.EXTENTION
     *
     * @param extention the value for FW_WALLET_WITHDRAW_REQ.EXTENTION
     * column comments 扩展信息
     *
     * @mbggenerated Wed Nov 23 10:26:15 CST 2016
     */
    public void setExtention(String extention) {
        this.extention = extention == null ? null : extention.trim();
    }

    /**
     * This method returns the value of the database column FW_WALLET_WITHDRAW_REQ.STATUS
     *
     * @return the value of FW_WALLET_WITHDRAW_REQ.STATUS
     * column comments 状态，0：出款成功，1：待出款 2：出款中  9：出款失败
     *
     * @mbggenerated Wed Nov 23 10:26:15 CST 2016
     */
    public Integer getStatus() {
        return status;
    }

    /**
     * This method sets the value of the database column FW_WALLET_WITHDRAW_REQ.STATUS
     *
     * @param status the value for FW_WALLET_WITHDRAW_REQ.STATUS
     * column comments 状态，0：出款成功，1：待出款 2：出款中  9：出款失败
     *
     * @mbggenerated Wed Nov 23 10:26:15 CST 2016
     */
    public void setStatus(Integer status) {
        this.status = status;
    }

    /**
     * This method returns the value of the database column FW_WALLET_WITHDRAW_REQ.CALLBACK_ADDRESS
     *
     * @return the value of FW_WALLET_WITHDRAW_REQ.CALLBACK_ADDRESS
     * column comments 回掉地址
     *
     * @mbggenerated Wed Nov 23 10:26:15 CST 2016
     */
    public String getCallbackAddress() {
        return callbackAddress;
    }

    /**
     * This method sets the value of the database column FW_WALLET_WITHDRAW_REQ.CALLBACK_ADDRESS
     *
     * @param callbackAddress the value for FW_WALLET_WITHDRAW_REQ.CALLBACK_ADDRESS
     * column comments 回掉地址
     *
     * @mbggenerated Wed Nov 23 10:26:15 CST 2016
     */
    public void setCallbackAddress(String callbackAddress) {
        this.callbackAddress = callbackAddress == null ? null : callbackAddress.trim();
    }

    /**
     * This method returns the value of the database column FW_WALLET_WITHDRAW_REQ.CREATE_TIME
     *
     * @return the value of FW_WALLET_WITHDRAW_REQ.CREATE_TIME
     * column comments 创建时间
     *
     * @mbggenerated Wed Nov 23 10:26:15 CST 2016
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * This method sets the value of the database column FW_WALLET_WITHDRAW_REQ.CREATE_TIME
     *
     * @param createTime the value for FW_WALLET_WITHDRAW_REQ.CREATE_TIME
     * column comments 创建时间
     *
     * @mbggenerated Wed Nov 23 10:26:15 CST 2016
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * This method returns the value of the database column FW_WALLET_WITHDRAW_REQ.UPDATE_TIME
     *
     * @return the value of FW_WALLET_WITHDRAW_REQ.UPDATE_TIME
     * column comments 最后修改时间
     *
     * @mbggenerated Wed Nov 23 10:26:15 CST 2016
     */
    public Date getUpdateTime() {
        return updateTime;
    }

    /**
     * This method sets the value of the database column FW_WALLET_WITHDRAW_REQ.UPDATE_TIME
     *
     * @param updateTime the value for FW_WALLET_WITHDRAW_REQ.UPDATE_TIME
     * column comments 最后修改时间
     *
     * @mbggenerated Wed Nov 23 10:26:15 CST 2016
     */
    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }
}