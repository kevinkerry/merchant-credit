package com.sdp.mc.web.vo;

import java.math.BigDecimal;


public class PaymentNotifyVO{

    /**
     * This field corresponds to the database column FUND_PAYMENT_RESPONSE.NAME
     * column comments 版本名称
     *
     * @mbggenerated Mon Oct 21 16:09:26 CST 2013
     */
    private String name;

    /**
     * This field corresponds to the database column FUND_PAYMENT_RESPONSE.VERSION
     * column comments 版本号
     *
     * @mbggenerated Mon Oct 21 16:09:26 CST 2013
     */
    private String version;

    /**
     * This field corresponds to the database column FUND_PAYMENT_RESPONSE.CHARSET
     * column comments 字符集
     *
     * @mbggenerated Mon Oct 21 16:09:26 CST 2013
     */
    private String charset;

    /**
     * This field corresponds to the database column FUND_PAYMENT_RESPONSE.TRACE_NO
     * column comments 请求序列号
     *
     * @mbggenerated Mon Oct 21 16:09:26 CST 2013
     */
    private String traceNo;

    /**
     * This field corresponds to the database column FUND_PAYMENT_RESPONSE.MSG_SENDER
     * column comments 发送方标识(盛付通标识)
     *
     * @mbggenerated Mon Oct 21 16:09:26 CST 2013
     */
    private String msgSender;

    /**
     * This field corresponds to the database column FUND_PAYMENT_RESPONSE.SEND_TIME
     * column comments 发送时间
     *
     * @mbggenerated Mon Oct 21 16:09:26 CST 2013
     */
    private String sendTime;

    /**
     * This field corresponds to the database column FUND_PAYMENT_RESPONSE.INST_CODE
     * column comments 银行编码
     *
     * @mbggenerated Mon Oct 21 16:09:26 CST 2013
     */
    private String instCode;

    /**
     * This field corresponds to the database column FUND_PAYMENT_RESPONSE.ORDER_NO
     * column comments 支付订单号
     *
     * @mbggenerated Mon Oct 21 16:09:26 CST 2013
     */
    private String orderNo;

    /**
     * This field corresponds to the database column FUND_PAYMENT_RESPONSE.ORDER_AMOUNT
     * column comments 订单金额 单位(分)
     *
     * @mbggenerated Mon Oct 21 16:09:26 CST 2013
     */
    private BigDecimal orderAmount;

    /**
     * This field corresponds to the database column FUND_PAYMENT_RESPONSE.TRANS_NO
     * column comments 盛付通网关交易号
     *
     * @mbggenerated Mon Oct 21 16:09:26 CST 2013
     */
    private String transNo;

    /**
     * This field corresponds to the database column FUND_PAYMENT_RESPONSE.TRANS_AMOUNT
     * column comments 实际支付金额 单位(分)
     *
     * @mbggenerated Mon Oct 21 16:09:26 CST 2013
     */
    private BigDecimal transAmount;

    /**
     * This field corresponds to the database column FUND_PAYMENT_RESPONSE.TRANS_STATUS
     * column comments 交易状态
00 等待付款中
01 付款成功
02 付款失败
03 过期
04 撤销成功
05 退款中
06 退款成功
07 退款失败
08 部分退款成功
     *
     * @mbggenerated Mon Oct 21 16:09:26 CST 2013
     */
    private String transStatus;

    /**
     * This field corresponds to the database column FUND_PAYMENT_RESPONSE.TRANS_TYPE
     * column comments 交易类型
     *
     * @mbggenerated Mon Oct 21 16:09:26 CST 2013
     */
    private String transType;

    /**
     * This field corresponds to the database column FUND_PAYMENT_RESPONSE.TRANS_TIME
     * column comments 交易时间
     *
     * @mbggenerated Mon Oct 21 16:09:26 CST 2013
     */
    private String transTime;

    /**
     * This field corresponds to the database column FUND_PAYMENT_RESPONSE.MERCHANT_NO
     * column comments 商户号
     *
     * @mbggenerated Mon Oct 21 16:09:26 CST 2013
     */
    private String merchantNo;

    /**
     * This field corresponds to the database column FUND_PAYMENT_RESPONSE.ERROR_CODE
     * column comments 错误代码
     *
     * @mbggenerated Mon Oct 21 16:09:26 CST 2013
     */
    private String errorCode;

    /**
     * This field corresponds to the database column FUND_PAYMENT_RESPONSE.ERROR_MSG
     * column comments 错误消息
     *
     * @mbggenerated Mon Oct 21 16:09:26 CST 2013
     */
    private String errorMsg;

    /**
     * This field corresponds to the database column FUND_PAYMENT_RESPONSE.SIGN_TYPE
     * column comments 签名类型
     *
     * @mbggenerated Mon Oct 21 16:09:26 CST 2013
     */
    private String signType;

    /**
     * This field corresponds to the database column FUND_PAYMENT_RESPONSE.SIGN_MSG
     * column comments 签名内容
     *
     * @mbggenerated Mon Oct 21 16:09:26 CST 2013
     */
    private String signMsg;

    /**
     * This field corresponds to the database column FUND_PAYMENT_RESPONSE.EXT1
     * column comments 扩展1
     *
     * @mbggenerated Mon Oct 21 16:09:26 CST 2013
     */
    private String ext1;

    /**
     * This field corresponds to the database column FUND_PAYMENT_RESPONSE.EXT2
     * column comments 扩展2
     *
     * @mbggenerated Mon Oct 21 16:09:26 CST 2013
     */
    private String ext2;


    /**
     * This method returns the value of the database column FUND_PAYMENT_RESPONSE.NAME
     *
     * @return the value of FUND_PAYMENT_RESPONSE.NAME
     * column comments 版本名称
     *
     * @mbggenerated Mon Oct 21 16:09:26 CST 2013
     */
    public String getName() {
        return name;
    }

    /**
     * This method sets the value of the database column FUND_PAYMENT_RESPONSE.NAME
     *
     * @param name the value for FUND_PAYMENT_RESPONSE.NAME
     * column comments 版本名称
     *
     * @mbggenerated Mon Oct 21 16:09:26 CST 2013
     */
    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    /**
     * This method returns the value of the database column FUND_PAYMENT_RESPONSE.VERSION
     *
     * @return the value of FUND_PAYMENT_RESPONSE.VERSION
     * column comments 版本号
     *
     * @mbggenerated Mon Oct 21 16:09:26 CST 2013
     */
    public String getVersion() {
        return version;
    }

    /**
     * This method sets the value of the database column FUND_PAYMENT_RESPONSE.VERSION
     *
     * @param version the value for FUND_PAYMENT_RESPONSE.VERSION
     * column comments 版本号
     *
     * @mbggenerated Mon Oct 21 16:09:26 CST 2013
     */
    public void setVersion(String version) {
        this.version = version == null ? null : version.trim();
    }

    /**
     * This method returns the value of the database column FUND_PAYMENT_RESPONSE.CHARSET
     *
     * @return the value of FUND_PAYMENT_RESPONSE.CHARSET
     * column comments 字符集
     *
     * @mbggenerated Mon Oct 21 16:09:26 CST 2013
     */
    public String getCharset() {
        return charset;
    }

    /**
     * This method sets the value of the database column FUND_PAYMENT_RESPONSE.CHARSET
     *
     * @param charset the value for FUND_PAYMENT_RESPONSE.CHARSET
     * column comments 字符集
     *
     * @mbggenerated Mon Oct 21 16:09:26 CST 2013
     */
    public void setCharset(String charset) {
        this.charset = charset == null ? null : charset.trim();
    }

    /**
     * This method returns the value of the database column FUND_PAYMENT_RESPONSE.TRACE_NO
     *
     * @return the value of FUND_PAYMENT_RESPONSE.TRACE_NO
     * column comments 请求序列号
     *
     * @mbggenerated Mon Oct 21 16:09:26 CST 2013
     */
    public String getTraceNo() {
        return traceNo;
    }

    /**
     * This method sets the value of the database column FUND_PAYMENT_RESPONSE.TRACE_NO
     *
     * @param traceNo the value for FUND_PAYMENT_RESPONSE.TRACE_NO
     * column comments 请求序列号
     *
     * @mbggenerated Mon Oct 21 16:09:26 CST 2013
     */
    public void setTraceNo(String traceNo) {
        this.traceNo = traceNo == null ? null : traceNo.trim();
    }

    /**
     * This method returns the value of the database column FUND_PAYMENT_RESPONSE.MSG_SENDER
     *
     * @return the value of FUND_PAYMENT_RESPONSE.MSG_SENDER
     * column comments 发送方标识(盛付通标识)
     *
     * @mbggenerated Mon Oct 21 16:09:26 CST 2013
     */
    public String getMsgSender() {
        return msgSender;
    }

    /**
     * This method sets the value of the database column FUND_PAYMENT_RESPONSE.MSG_SENDER
     *
     * @param msgSender the value for FUND_PAYMENT_RESPONSE.MSG_SENDER
     * column comments 发送方标识(盛付通标识)
     *
     * @mbggenerated Mon Oct 21 16:09:26 CST 2013
     */
    public void setMsgSender(String msgSender) {
        this.msgSender = msgSender == null ? null : msgSender.trim();
    }

    /**
     * This method returns the value of the database column FUND_PAYMENT_RESPONSE.SEND_TIME
     *
     * @return the value of FUND_PAYMENT_RESPONSE.SEND_TIME
     * column comments 发送时间
     *
     * @mbggenerated Mon Oct 21 16:09:26 CST 2013
     */
    public String getSendTime() {
        return sendTime;
    }

    /**
     * This method sets the value of the database column FUND_PAYMENT_RESPONSE.SEND_TIME
     *
     * @param sendTime the value for FUND_PAYMENT_RESPONSE.SEND_TIME
     * column comments 发送时间
     *
     * @mbggenerated Mon Oct 21 16:09:26 CST 2013
     */
    public void setSendTime(String sendTime) {
        this.sendTime = sendTime == null ? null : sendTime.trim();
    }

    /**
     * This method returns the value of the database column FUND_PAYMENT_RESPONSE.INST_CODE
     *
     * @return the value of FUND_PAYMENT_RESPONSE.INST_CODE
     * column comments 银行编码
     *
     * @mbggenerated Mon Oct 21 16:09:26 CST 2013
     */
    public String getInstCode() {
        return instCode;
    }

    /**
     * This method sets the value of the database column FUND_PAYMENT_RESPONSE.INST_CODE
     *
     * @param instCode the value for FUND_PAYMENT_RESPONSE.INST_CODE
     * column comments 银行编码
     *
     * @mbggenerated Mon Oct 21 16:09:26 CST 2013
     */
    public void setInstCode(String instCode) {
        this.instCode = instCode == null ? null : instCode.trim();
    }

    /**
     * This method returns the value of the database column FUND_PAYMENT_RESPONSE.ORDER_NO
     *
     * @return the value of FUND_PAYMENT_RESPONSE.ORDER_NO
     * column comments 支付订单号
     *
     * @mbggenerated Mon Oct 21 16:09:26 CST 2013
     */
    public String getOrderNo() {
        return orderNo;
    }

    /**
     * This method sets the value of the database column FUND_PAYMENT_RESPONSE.ORDER_NO
     *
     * @param orderNo the value for FUND_PAYMENT_RESPONSE.ORDER_NO
     * column comments 支付订单号
     *
     * @mbggenerated Mon Oct 21 16:09:26 CST 2013
     */
    public void setOrderNo(String orderNo) {
        this.orderNo = orderNo == null ? null : orderNo.trim();
    }

    /**
     * This method returns the value of the database column FUND_PAYMENT_RESPONSE.ORDER_AMOUNT
     *
     * @return the value of FUND_PAYMENT_RESPONSE.ORDER_AMOUNT
     * column comments 订单金额 单位(分)
     *
     * @mbggenerated Mon Oct 21 16:09:26 CST 2013
     */
    public BigDecimal getOrderAmount() {
        return orderAmount;
    }

    /**
     * This method sets the value of the database column FUND_PAYMENT_RESPONSE.ORDER_AMOUNT
     *
     * @param orderAmount the value for FUND_PAYMENT_RESPONSE.ORDER_AMOUNT
     * column comments 订单金额 单位(分)
     *
     * @mbggenerated Mon Oct 21 16:09:26 CST 2013
     */
    public void setOrderAmount(BigDecimal orderAmount) {
        this.orderAmount = orderAmount;
    }

    /**
     * This method returns the value of the database column FUND_PAYMENT_RESPONSE.TRANS_NO
     *
     * @return the value of FUND_PAYMENT_RESPONSE.TRANS_NO
     * column comments 盛付通网关交易号
     *
     * @mbggenerated Mon Oct 21 16:09:26 CST 2013
     */
    public String getTransNo() {
        return transNo;
    }

    /**
     * This method sets the value of the database column FUND_PAYMENT_RESPONSE.TRANS_NO
     *
     * @param transNo the value for FUND_PAYMENT_RESPONSE.TRANS_NO
     * column comments 盛付通网关交易号
     *
     * @mbggenerated Mon Oct 21 16:09:26 CST 2013
     */
    public void setTransNo(String transNo) {
        this.transNo = transNo == null ? null : transNo.trim();
    }

    /**
     * This method returns the value of the database column FUND_PAYMENT_RESPONSE.TRANS_AMOUNT
     *
     * @return the value of FUND_PAYMENT_RESPONSE.TRANS_AMOUNT
     * column comments 实际支付金额 单位(分)
     *
     * @mbggenerated Mon Oct 21 16:09:26 CST 2013
     */
    public BigDecimal getTransAmount() {
        return transAmount;
    }

    /**
     * This method sets the value of the database column FUND_PAYMENT_RESPONSE.TRANS_AMOUNT
     *
     * @param transAmount the value for FUND_PAYMENT_RESPONSE.TRANS_AMOUNT
     * column comments 实际支付金额 单位(分)
     *
     * @mbggenerated Mon Oct 21 16:09:26 CST 2013
     */
    public void setTransAmount(BigDecimal transAmount) {
        this.transAmount = transAmount;
    }

    /**
     * This method returns the value of the database column FUND_PAYMENT_RESPONSE.TRANS_STATUS
     *
     * @return the value of FUND_PAYMENT_RESPONSE.TRANS_STATUS
     * column comments 交易状态
00 等待付款中
01 付款成功
02 付款失败
03 过期
04 撤销成功
05 退款中
06 退款成功
07 退款失败
08 部分退款成功
     *
     * @mbggenerated Mon Oct 21 16:09:26 CST 2013
     */
    public String getTransStatus() {
        return transStatus;
    }

    /**
     * This method sets the value of the database column FUND_PAYMENT_RESPONSE.TRANS_STATUS
     *
     * @param transStatus the value for FUND_PAYMENT_RESPONSE.TRANS_STATUS
     * column comments 交易状态
00 等待付款中
01 付款成功
02 付款失败
03 过期
04 撤销成功
05 退款中
06 退款成功
07 退款失败
08 部分退款成功
     *
     * @mbggenerated Mon Oct 21 16:09:26 CST 2013
     */
    public void setTransStatus(String transStatus) {
        this.transStatus = transStatus == null ? null : transStatus.trim();
    }

    /**
     * This method returns the value of the database column FUND_PAYMENT_RESPONSE.TRANS_TYPE
     *
     * @return the value of FUND_PAYMENT_RESPONSE.TRANS_TYPE
     * column comments 交易类型
     *
     * @mbggenerated Mon Oct 21 16:09:26 CST 2013
     */
    public String getTransType() {
        return transType;
    }

    /**
     * This method sets the value of the database column FUND_PAYMENT_RESPONSE.TRANS_TYPE
     *
     * @param transType the value for FUND_PAYMENT_RESPONSE.TRANS_TYPE
     * column comments 交易类型
     *
     * @mbggenerated Mon Oct 21 16:09:26 CST 2013
     */
    public void setTransType(String transType) {
        this.transType = transType == null ? null : transType.trim();
    }

    /**
     * This method returns the value of the database column FUND_PAYMENT_RESPONSE.TRANS_TIME
     *
     * @return the value of FUND_PAYMENT_RESPONSE.TRANS_TIME
     * column comments 交易时间
     *
     * @mbggenerated Mon Oct 21 16:09:26 CST 2013
     */
    public String getTransTime() {
        return transTime;
    }

    /**
     * This method sets the value of the database column FUND_PAYMENT_RESPONSE.TRANS_TIME
     *
     * @param transTime the value for FUND_PAYMENT_RESPONSE.TRANS_TIME
     * column comments 交易时间
     *
     * @mbggenerated Mon Oct 21 16:09:26 CST 2013
     */
    public void setTransTime(String transTime) {
        this.transTime = transTime == null ? null : transTime.trim();
    }

    /**
     * This method returns the value of the database column FUND_PAYMENT_RESPONSE.MERCHANT_NO
     *
     * @return the value of FUND_PAYMENT_RESPONSE.MERCHANT_NO
     * column comments 商户号
     *
     * @mbggenerated Mon Oct 21 16:09:26 CST 2013
     */
    public String getMerchantNo() {
        return merchantNo;
    }

    /**
     * This method sets the value of the database column FUND_PAYMENT_RESPONSE.MERCHANT_NO
     *
     * @param merchantNo the value for FUND_PAYMENT_RESPONSE.MERCHANT_NO
     * column comments 商户号
     *
     * @mbggenerated Mon Oct 21 16:09:26 CST 2013
     */
    public void setMerchantNo(String merchantNo) {
        this.merchantNo = merchantNo == null ? null : merchantNo.trim();
    }

    /**
     * This method returns the value of the database column FUND_PAYMENT_RESPONSE.ERROR_CODE
     *
     * @return the value of FUND_PAYMENT_RESPONSE.ERROR_CODE
     * column comments 错误代码
     *
     * @mbggenerated Mon Oct 21 16:09:26 CST 2013
     */
    public String getErrorCode() {
        return errorCode;
    }

    /**
     * This method sets the value of the database column FUND_PAYMENT_RESPONSE.ERROR_CODE
     *
     * @param errorCode the value for FUND_PAYMENT_RESPONSE.ERROR_CODE
     * column comments 错误代码
     *
     * @mbggenerated Mon Oct 21 16:09:26 CST 2013
     */
    public void setErrorCode(String errorCode) {
        this.errorCode = errorCode == null ? null : errorCode.trim();
    }

    /**
     * This method returns the value of the database column FUND_PAYMENT_RESPONSE.ERROR_MSG
     *
     * @return the value of FUND_PAYMENT_RESPONSE.ERROR_MSG
     * column comments 错误消息
     *
     * @mbggenerated Mon Oct 21 16:09:26 CST 2013
     */
    public String getErrorMsg() {
        return errorMsg;
    }

    /**
     * This method sets the value of the database column FUND_PAYMENT_RESPONSE.ERROR_MSG
     *
     * @param errorMsg the value for FUND_PAYMENT_RESPONSE.ERROR_MSG
     * column comments 错误消息
     *
     * @mbggenerated Mon Oct 21 16:09:26 CST 2013
     */
    public void setErrorMsg(String errorMsg) {
        this.errorMsg = errorMsg == null ? null : errorMsg.trim();
    }

    /**
     * This method returns the value of the database column FUND_PAYMENT_RESPONSE.SIGN_TYPE
     *
     * @return the value of FUND_PAYMENT_RESPONSE.SIGN_TYPE
     * column comments 签名类型
     *
     * @mbggenerated Mon Oct 21 16:09:26 CST 2013
     */
    public String getSignType() {
        return signType;
    }

    /**
     * This method sets the value of the database column FUND_PAYMENT_RESPONSE.SIGN_TYPE
     *
     * @param signType the value for FUND_PAYMENT_RESPONSE.SIGN_TYPE
     * column comments 签名类型
     *
     * @mbggenerated Mon Oct 21 16:09:26 CST 2013
     */
    public void setSignType(String signType) {
        this.signType = signType == null ? null : signType.trim();
    }

    /**
     * This method returns the value of the database column FUND_PAYMENT_RESPONSE.SIGN_MSG
     *
     * @return the value of FUND_PAYMENT_RESPONSE.SIGN_MSG
     * column comments 签名内容
     *
     * @mbggenerated Mon Oct 21 16:09:26 CST 2013
     */
    public String getSignMsg() {
        return signMsg;
    }

    /**
     * This method sets the value of the database column FUND_PAYMENT_RESPONSE.SIGN_MSG
     *
     * @param signMsg the value for FUND_PAYMENT_RESPONSE.SIGN_MSG
     * column comments 签名内容
     *
     * @mbggenerated Mon Oct 21 16:09:26 CST 2013
     */
    public void setSignMsg(String signMsg) {
        this.signMsg = signMsg == null ? null : signMsg.trim();
    }

    /**
     * This method returns the value of the database column FUND_PAYMENT_RESPONSE.EXT1
     *
     * @return the value of FUND_PAYMENT_RESPONSE.EXT1
     * column comments 扩展1
     *
     * @mbggenerated Mon Oct 21 16:09:26 CST 2013
     */
    public String getExt1() {
        return ext1;
    }

    /**
     * This method sets the value of the database column FUND_PAYMENT_RESPONSE.EXT1
     *
     * @param ext1 the value for FUND_PAYMENT_RESPONSE.EXT1
     * column comments 扩展1
     *
     * @mbggenerated Mon Oct 21 16:09:26 CST 2013
     */
    public void setExt1(String ext1) {
        this.ext1 = ext1 == null ? null : ext1.trim();
    }

    /**
     * This method returns the value of the database column FUND_PAYMENT_RESPONSE.EXT2
     *
     * @return the value of FUND_PAYMENT_RESPONSE.EXT2
     * column comments 扩展2
     *
     * @mbggenerated Mon Oct 21 16:09:26 CST 2013
     */
    public String getExt2() {
        return ext2;
    }

    /**
     * This method sets the value of the database column FUND_PAYMENT_RESPONSE.EXT2
     *
     * @param ext2 the value for FUND_PAYMENT_RESPONSE.EXT2
     * column comments 扩展2
     *
     * @mbggenerated Mon Oct 21 16:09:26 CST 2013
     */
    public void setExt2(String ext2) {
        this.ext2 = ext2 == null ? null : ext2.trim();
    }

}