package com.sdp.mc.fos.dao;

import com.sdp.emall.common.dao.BaseDO;
import java.util.Date;

public class MarginTransDO extends BaseDO {
    /**
     * This field corresponds to the database column TB_MARGIN_TRANS.MT_ID
     * column comments null
     *
     * @mbggenerated Wed Jun 03 18:04:23 CST 2015
     */
    private Long mtId;

    /**
     * This field corresponds to the database column TB_MARGIN_TRANS.STATUS
     * column comments 0:初始
1：成功
-1：失败
     *
     * @mbggenerated Wed Jun 03 18:04:23 CST 2015
     */
    private Integer status;

    /**
     * This field corresponds to the database column TB_MARGIN_TRANS.PRODUCT_CODE
     * column comments 产品编码
     *
     * @mbggenerated Wed Jun 03 18:04:23 CST 2015
     */
    private String productCode;

    /**
     * This field corresponds to the database column TB_MARGIN_TRANS.APP_ID
     * column comments 应用ID
     *
     * @mbggenerated Wed Jun 03 18:04:23 CST 2015
     */
    private String appId;

    /**
     * This field corresponds to the database column TB_MARGIN_TRANS.PAYMENT_CODE
     * column comments 支付编码
     *
     * @mbggenerated Wed Jun 03 18:04:23 CST 2015
     */
    private String paymentCode;

    /**
     * This field corresponds to the database column TB_MARGIN_TRANS.REMIT_VOUCHER_NO
     * column comments 转账订单号
productCode+ paymentCode+ remitVoucherNo
:要求唯一
     *
     * @mbggenerated Wed Jun 03 18:04:23 CST 2015
     */
    private String remitVoucherNo;

    /**
     * This field corresponds to the database column TB_MARGIN_TRANS.PAYMENT_STATE
     * column comments 支付状态
C-批量付款失败需退款 
S-成功 
P-处理中
F-处理失败
     *
     * @mbggenerated Wed Jun 03 18:04:23 CST 2015
     */
    private String paymentState;

    /**
     * This field corresponds to the database column TB_MARGIN_TRANS.PAYER_MEMBER_ID
     * column comments 付款方memberId
     *
     * @mbggenerated Wed Jun 03 18:04:23 CST 2015
     */
    private String payerMemberId;

    /**
     * This field corresponds to the database column TB_MARGIN_TRANS.PAYEE_MEMBER_ID
     * column comments 收款方memberId
     *
     * @mbggenerated Wed Jun 03 18:04:23 CST 2015
     */
    private String payeeMemberId;

    /**
     * This field corresponds to the database column TB_MARGIN_TRANS.IS_NEED_COUNT_FEE
     * column comments 1：计费；0：不计费
     *
     * @mbggenerated Wed Jun 03 18:04:23 CST 2015
     */
    private String isNeedCountFee;

    /**
     * This field corresponds to the database column TB_MARGIN_TRANS.PAYER_FEE
     * column comments 付款人费用
如10.01元 精确度到分
     *
     * @mbggenerated Wed Jun 03 18:04:23 CST 2015
     */
    private String payerFee;

    /**
     * This field corresponds to the database column TB_MARGIN_TRANS.PAYEE_FEE
     * column comments 收款人费用
如10.01元 精确度到分
     *
     * @mbggenerated Wed Jun 03 18:04:23 CST 2015
     */
    private String payeeFee;

    /**
     * This field corresponds to the database column TB_MARGIN_TRANS.PAYER_ACCOUNT_TYPE
     * column comments 付款方账户类型
0表示所有账户类型
     *
     * @mbggenerated Wed Jun 03 18:04:23 CST 2015
     */
    private String payerAccountType;

    /**
     * This field corresponds to the database column TB_MARGIN_TRANS.PAYER_ACCOUNT_NO
     * column comments 付款人储值账户ID
     *
     * @mbggenerated Wed Jun 03 18:04:23 CST 2015
     */
    private String payerAccountNo;

    /**
     * This field corresponds to the database column TB_MARGIN_TRANS.PAYEE_ACCOUNT_NO
     * column comments 收款人储值账户ID
     *
     * @mbggenerated Wed Jun 03 18:04:23 CST 2015
     */
    private String payeeAccountNo;

    /**
     * This field corresponds to the database column TB_MARGIN_TRANS.GMT_BIZ_INITIATE
     * column comments 业务发起时间
数字串，一共14位
格式为：年[4位]月[2位]日[2位]时[2位]分[2位]秒[2位]
例如：20071117020101

     *
     * @mbggenerated Wed Jun 03 18:04:23 CST 2015
     */
    private String gmtBizInitiate;

    /**
     * This field corresponds to the database column TB_MARGIN_TRANS.GMT_PAYMENT_INITIATE
     * column comments 支付发起时间
     *
     * @mbggenerated Wed Jun 03 18:04:23 CST 2015
     */
    private String gmtPaymentInitiate;

    /**
     * This field corresponds to the database column TB_MARGIN_TRANS.REMIT_AMOUNT
     * column comments 转账金额
     *
     * @mbggenerated Wed Jun 03 18:04:23 CST 2015
     */
    private String remitAmount;

    /**
     * This field corresponds to the database column TB_MARGIN_TRANS.CALLBACK_ADDRESS
     * column comments fos回调地址
     *
     * @mbggenerated Wed Jun 03 18:04:23 CST 2015
     */
    private String callbackAddress;

    /**
     * This field corresponds to the database column TB_MARGIN_TRANS.MEMO
     * column comments 备注信息，储值系统要求不能为空
     *
     * @mbggenerated Wed Jun 03 18:04:23 CST 2015
     */
    private String memo;

    /**
     * This field corresponds to the database column TB_MARGIN_TRANS.IS_PEMIT_PRICING_ERR
     * column comments null
     *
     * @mbggenerated Wed Jun 03 18:04:23 CST 2015
     */
    private String isPemitPricingErr;

    /**
     * This field corresponds to the database column TB_MARGIN_TRANS.CURRENCY
     * column comments 不传默认为CNY
     *
     * @mbggenerated Wed Jun 03 18:04:23 CST 2015
     */
    private String currency;

    /**
     * This field corresponds to the database column TB_MARGIN_TRANS.PAYMENT_SEQ_NO
     * column comments null
     *
     * @mbggenerated Wed Jun 03 18:04:23 CST 2015
     */
    private String paymentSeqNo;

    /**
     * This field corresponds to the database column TB_MARGIN_TRANS.POCKET_AMOUNT
     * column comments null
     *
     * @mbggenerated Wed Jun 03 18:04:23 CST 2015
     */
    private String pocketAmount;

    /**
     * This field corresponds to the database column TB_MARGIN_TRANS.SETTLEMENT_TIME
     * column comments null
     *
     * @mbggenerated Wed Jun 03 18:04:23 CST 2015
     */
    private String settlementTime;

    /**
     * This field corresponds to the database column TB_MARGIN_TRANS.RETURN_CODE
     * column comments 错误码
     *
     * @mbggenerated Wed Jun 03 18:04:23 CST 2015
     */
    private String returnCode;

    /**
     * This field corresponds to the database column TB_MARGIN_TRANS.RETURN_MSG
     * column comments null
     *
     * @mbggenerated Wed Jun 03 18:04:23 CST 2015
     */
    private String returnMsg;

    /**
     * This field corresponds to the database column TB_MARGIN_TRANS.EXTENTION
     * column comments null
     *
     * @mbggenerated Wed Jun 03 18:04:23 CST 2015
     */
    private String extention;

    /**
     * This field corresponds to the database column TB_MARGIN_TRANS.CREATE_TIME
     * column comments null
     *
     * @mbggenerated Wed Jun 03 18:04:23 CST 2015
     */
    private Date createTime;

    /**
     * This field corresponds to the database column TB_MARGIN_TRANS.UPDATE_TIME
     * column comments null
     *
     * @mbggenerated Wed Jun 03 18:04:23 CST 2015
     */
    private Date updateTime;

    /**
     * This field corresponds to the database column TB_MARGIN_TRANS.BATCH_NO
     * column comments 批量转账批次号
     *
     * @mbggenerated Wed Jun 03 18:04:23 CST 2015
     */
    private String batchNo;

    /**
     * This field corresponds to the database column TB_MARGIN_TRANS.PAYEE_ACCOUNT_TYPE
     * column comments 收款方款方账户类型0表示所有账户类型
     *
     * @mbggenerated Wed Jun 03 18:04:23 CST 2015
     */
    private String payeeAccountType;

    /**
     * This method returns the value of the database column TB_MARGIN_TRANS.MT_ID
     *
     * @return the value of TB_MARGIN_TRANS.MT_ID
     * column comments null
     *
     * @mbggenerated Wed Jun 03 18:04:23 CST 2015
     */
    public Long getMtId() {
        return mtId;
    }

    /**
     * This method sets the value of the database column TB_MARGIN_TRANS.MT_ID
     *
     * @param mtId the value for TB_MARGIN_TRANS.MT_ID
     * column comments null
     *
     * @mbggenerated Wed Jun 03 18:04:23 CST 2015
     */
    public void setMtId(Long mtId) {
        this.mtId = mtId;
    }

    /**
     * This method returns the value of the database column TB_MARGIN_TRANS.STATUS
     *
     * @return the value of TB_MARGIN_TRANS.STATUS
     * column comments 0:初始
1：成功
-1：失败
     *
     * @mbggenerated Wed Jun 03 18:04:23 CST 2015
     */
    public Integer getStatus() {
        return status;
    }

    /**
     * This method sets the value of the database column TB_MARGIN_TRANS.STATUS
     *
     * @param status the value for TB_MARGIN_TRANS.STATUS
     * column comments 0:初始
1：成功
-1：失败
     *
     * @mbggenerated Wed Jun 03 18:04:23 CST 2015
     */
    public void setStatus(Integer status) {
        this.status = status;
    }

    /**
     * This method returns the value of the database column TB_MARGIN_TRANS.PRODUCT_CODE
     *
     * @return the value of TB_MARGIN_TRANS.PRODUCT_CODE
     * column comments 产品编码
     *
     * @mbggenerated Wed Jun 03 18:04:23 CST 2015
     */
    public String getProductCode() {
        return productCode;
    }

    /**
     * This method sets the value of the database column TB_MARGIN_TRANS.PRODUCT_CODE
     *
     * @param productCode the value for TB_MARGIN_TRANS.PRODUCT_CODE
     * column comments 产品编码
     *
     * @mbggenerated Wed Jun 03 18:04:23 CST 2015
     */
    public void setProductCode(String productCode) {
        this.productCode = productCode == null ? null : productCode.trim();
    }

    /**
     * This method returns the value of the database column TB_MARGIN_TRANS.APP_ID
     *
     * @return the value of TB_MARGIN_TRANS.APP_ID
     * column comments 应用ID
     *
     * @mbggenerated Wed Jun 03 18:04:23 CST 2015
     */
    public String getAppId() {
        return appId;
    }

    /**
     * This method sets the value of the database column TB_MARGIN_TRANS.APP_ID
     *
     * @param appId the value for TB_MARGIN_TRANS.APP_ID
     * column comments 应用ID
     *
     * @mbggenerated Wed Jun 03 18:04:23 CST 2015
     */
    public void setAppId(String appId) {
        this.appId = appId == null ? null : appId.trim();
    }

    /**
     * This method returns the value of the database column TB_MARGIN_TRANS.PAYMENT_CODE
     *
     * @return the value of TB_MARGIN_TRANS.PAYMENT_CODE
     * column comments 支付编码
     *
     * @mbggenerated Wed Jun 03 18:04:23 CST 2015
     */
    public String getPaymentCode() {
        return paymentCode;
    }

    /**
     * This method sets the value of the database column TB_MARGIN_TRANS.PAYMENT_CODE
     *
     * @param paymentCode the value for TB_MARGIN_TRANS.PAYMENT_CODE
     * column comments 支付编码
     *
     * @mbggenerated Wed Jun 03 18:04:23 CST 2015
     */
    public void setPaymentCode(String paymentCode) {
        this.paymentCode = paymentCode == null ? null : paymentCode.trim();
    }

    /**
     * This method returns the value of the database column TB_MARGIN_TRANS.REMIT_VOUCHER_NO
     *
     * @return the value of TB_MARGIN_TRANS.REMIT_VOUCHER_NO
     * column comments 转账订单号
productCode+ paymentCode+ remitVoucherNo
:要求唯一
     *
     * @mbggenerated Wed Jun 03 18:04:23 CST 2015
     */
    public String getRemitVoucherNo() {
        return remitVoucherNo;
    }

    /**
     * This method sets the value of the database column TB_MARGIN_TRANS.REMIT_VOUCHER_NO
     *
     * @param remitVoucherNo the value for TB_MARGIN_TRANS.REMIT_VOUCHER_NO
     * column comments 转账订单号
productCode+ paymentCode+ remitVoucherNo
:要求唯一
     *
     * @mbggenerated Wed Jun 03 18:04:23 CST 2015
     */
    public void setRemitVoucherNo(String remitVoucherNo) {
        this.remitVoucherNo = remitVoucherNo == null ? null : remitVoucherNo.trim();
    }

    /**
     * This method returns the value of the database column TB_MARGIN_TRANS.PAYMENT_STATE
     *
     * @return the value of TB_MARGIN_TRANS.PAYMENT_STATE
     * column comments 支付状态
C-批量付款失败需退款 
S-成功 
P-处理中
F-处理失败
     *
     * @mbggenerated Wed Jun 03 18:04:23 CST 2015
     */
    public String getPaymentState() {
        return paymentState;
    }

    /**
     * This method sets the value of the database column TB_MARGIN_TRANS.PAYMENT_STATE
     *
     * @param paymentState the value for TB_MARGIN_TRANS.PAYMENT_STATE
     * column comments 支付状态
C-批量付款失败需退款 
S-成功 
P-处理中
F-处理失败
     *
     * @mbggenerated Wed Jun 03 18:04:23 CST 2015
     */
    public void setPaymentState(String paymentState) {
        this.paymentState = paymentState == null ? null : paymentState.trim();
    }

    /**
     * This method returns the value of the database column TB_MARGIN_TRANS.PAYER_MEMBER_ID
     *
     * @return the value of TB_MARGIN_TRANS.PAYER_MEMBER_ID
     * column comments 付款方memberId
     *
     * @mbggenerated Wed Jun 03 18:04:23 CST 2015
     */
    public String getPayerMemberId() {
        return payerMemberId;
    }

    /**
     * This method sets the value of the database column TB_MARGIN_TRANS.PAYER_MEMBER_ID
     *
     * @param payerMemberId the value for TB_MARGIN_TRANS.PAYER_MEMBER_ID
     * column comments 付款方memberId
     *
     * @mbggenerated Wed Jun 03 18:04:23 CST 2015
     */
    public void setPayerMemberId(String payerMemberId) {
        this.payerMemberId = payerMemberId == null ? null : payerMemberId.trim();
    }

    /**
     * This method returns the value of the database column TB_MARGIN_TRANS.PAYEE_MEMBER_ID
     *
     * @return the value of TB_MARGIN_TRANS.PAYEE_MEMBER_ID
     * column comments 收款方memberId
     *
     * @mbggenerated Wed Jun 03 18:04:23 CST 2015
     */
    public String getPayeeMemberId() {
        return payeeMemberId;
    }

    /**
     * This method sets the value of the database column TB_MARGIN_TRANS.PAYEE_MEMBER_ID
     *
     * @param payeeMemberId the value for TB_MARGIN_TRANS.PAYEE_MEMBER_ID
     * column comments 收款方memberId
     *
     * @mbggenerated Wed Jun 03 18:04:23 CST 2015
     */
    public void setPayeeMemberId(String payeeMemberId) {
        this.payeeMemberId = payeeMemberId == null ? null : payeeMemberId.trim();
    }

    /**
     * This method returns the value of the database column TB_MARGIN_TRANS.IS_NEED_COUNT_FEE
     *
     * @return the value of TB_MARGIN_TRANS.IS_NEED_COUNT_FEE
     * column comments 1：计费；0：不计费
     *
     * @mbggenerated Wed Jun 03 18:04:23 CST 2015
     */
    public String getIsNeedCountFee() {
        return isNeedCountFee;
    }

    /**
     * This method sets the value of the database column TB_MARGIN_TRANS.IS_NEED_COUNT_FEE
     *
     * @param isNeedCountFee the value for TB_MARGIN_TRANS.IS_NEED_COUNT_FEE
     * column comments 1：计费；0：不计费
     *
     * @mbggenerated Wed Jun 03 18:04:23 CST 2015
     */
    public void setIsNeedCountFee(String isNeedCountFee) {
        this.isNeedCountFee = isNeedCountFee == null ? null : isNeedCountFee.trim();
    }

    /**
     * This method returns the value of the database column TB_MARGIN_TRANS.PAYER_FEE
     *
     * @return the value of TB_MARGIN_TRANS.PAYER_FEE
     * column comments 付款人费用
如10.01元 精确度到分
     *
     * @mbggenerated Wed Jun 03 18:04:23 CST 2015
     */
    public String getPayerFee() {
        return payerFee;
    }

    /**
     * This method sets the value of the database column TB_MARGIN_TRANS.PAYER_FEE
     *
     * @param payerFee the value for TB_MARGIN_TRANS.PAYER_FEE
     * column comments 付款人费用
如10.01元 精确度到分
     *
     * @mbggenerated Wed Jun 03 18:04:23 CST 2015
     */
    public void setPayerFee(String payerFee) {
        this.payerFee = payerFee == null ? null : payerFee.trim();
    }

    /**
     * This method returns the value of the database column TB_MARGIN_TRANS.PAYEE_FEE
     *
     * @return the value of TB_MARGIN_TRANS.PAYEE_FEE
     * column comments 收款人费用
如10.01元 精确度到分
     *
     * @mbggenerated Wed Jun 03 18:04:23 CST 2015
     */
    public String getPayeeFee() {
        return payeeFee;
    }

    /**
     * This method sets the value of the database column TB_MARGIN_TRANS.PAYEE_FEE
     *
     * @param payeeFee the value for TB_MARGIN_TRANS.PAYEE_FEE
     * column comments 收款人费用
如10.01元 精确度到分
     *
     * @mbggenerated Wed Jun 03 18:04:23 CST 2015
     */
    public void setPayeeFee(String payeeFee) {
        this.payeeFee = payeeFee == null ? null : payeeFee.trim();
    }

    /**
     * This method returns the value of the database column TB_MARGIN_TRANS.PAYER_ACCOUNT_TYPE
     *
     * @return the value of TB_MARGIN_TRANS.PAYER_ACCOUNT_TYPE
     * column comments 付款方账户类型
0表示所有账户类型
     *
     * @mbggenerated Wed Jun 03 18:04:23 CST 2015
     */
    public String getPayerAccountType() {
        return payerAccountType;
    }

    /**
     * This method sets the value of the database column TB_MARGIN_TRANS.PAYER_ACCOUNT_TYPE
     *
     * @param payerAccountType the value for TB_MARGIN_TRANS.PAYER_ACCOUNT_TYPE
     * column comments 付款方账户类型
0表示所有账户类型
     *
     * @mbggenerated Wed Jun 03 18:04:23 CST 2015
     */
    public void setPayerAccountType(String payerAccountType) {
        this.payerAccountType = payerAccountType == null ? null : payerAccountType.trim();
    }

    /**
     * This method returns the value of the database column TB_MARGIN_TRANS.PAYER_ACCOUNT_NO
     *
     * @return the value of TB_MARGIN_TRANS.PAYER_ACCOUNT_NO
     * column comments 付款人储值账户ID
     *
     * @mbggenerated Wed Jun 03 18:04:23 CST 2015
     */
    public String getPayerAccountNo() {
        return payerAccountNo;
    }

    /**
     * This method sets the value of the database column TB_MARGIN_TRANS.PAYER_ACCOUNT_NO
     *
     * @param payerAccountNo the value for TB_MARGIN_TRANS.PAYER_ACCOUNT_NO
     * column comments 付款人储值账户ID
     *
     * @mbggenerated Wed Jun 03 18:04:23 CST 2015
     */
    public void setPayerAccountNo(String payerAccountNo) {
        this.payerAccountNo = payerAccountNo == null ? null : payerAccountNo.trim();
    }

    /**
     * This method returns the value of the database column TB_MARGIN_TRANS.PAYEE_ACCOUNT_NO
     *
     * @return the value of TB_MARGIN_TRANS.PAYEE_ACCOUNT_NO
     * column comments 收款人储值账户ID
     *
     * @mbggenerated Wed Jun 03 18:04:23 CST 2015
     */
    public String getPayeeAccountNo() {
        return payeeAccountNo;
    }

    /**
     * This method sets the value of the database column TB_MARGIN_TRANS.PAYEE_ACCOUNT_NO
     *
     * @param payeeAccountNo the value for TB_MARGIN_TRANS.PAYEE_ACCOUNT_NO
     * column comments 收款人储值账户ID
     *
     * @mbggenerated Wed Jun 03 18:04:23 CST 2015
     */
    public void setPayeeAccountNo(String payeeAccountNo) {
        this.payeeAccountNo = payeeAccountNo == null ? null : payeeAccountNo.trim();
    }

    /**
     * This method returns the value of the database column TB_MARGIN_TRANS.GMT_BIZ_INITIATE
     *
     * @return the value of TB_MARGIN_TRANS.GMT_BIZ_INITIATE
     * column comments 业务发起时间
数字串，一共14位
格式为：年[4位]月[2位]日[2位]时[2位]分[2位]秒[2位]
例如：20071117020101

     *
     * @mbggenerated Wed Jun 03 18:04:23 CST 2015
     */
    public String getGmtBizInitiate() {
        return gmtBizInitiate;
    }

    /**
     * This method sets the value of the database column TB_MARGIN_TRANS.GMT_BIZ_INITIATE
     *
     * @param gmtBizInitiate the value for TB_MARGIN_TRANS.GMT_BIZ_INITIATE
     * column comments 业务发起时间
数字串，一共14位
格式为：年[4位]月[2位]日[2位]时[2位]分[2位]秒[2位]
例如：20071117020101

     *
     * @mbggenerated Wed Jun 03 18:04:23 CST 2015
     */
    public void setGmtBizInitiate(String gmtBizInitiate) {
        this.gmtBizInitiate = gmtBizInitiate == null ? null : gmtBizInitiate.trim();
    }

    /**
     * This method returns the value of the database column TB_MARGIN_TRANS.GMT_PAYMENT_INITIATE
     *
     * @return the value of TB_MARGIN_TRANS.GMT_PAYMENT_INITIATE
     * column comments 支付发起时间
     *
     * @mbggenerated Wed Jun 03 18:04:23 CST 2015
     */
    public String getGmtPaymentInitiate() {
        return gmtPaymentInitiate;
    }

    /**
     * This method sets the value of the database column TB_MARGIN_TRANS.GMT_PAYMENT_INITIATE
     *
     * @param gmtPaymentInitiate the value for TB_MARGIN_TRANS.GMT_PAYMENT_INITIATE
     * column comments 支付发起时间
     *
     * @mbggenerated Wed Jun 03 18:04:23 CST 2015
     */
    public void setGmtPaymentInitiate(String gmtPaymentInitiate) {
        this.gmtPaymentInitiate = gmtPaymentInitiate == null ? null : gmtPaymentInitiate.trim();
    }

    /**
     * This method returns the value of the database column TB_MARGIN_TRANS.REMIT_AMOUNT
     *
     * @return the value of TB_MARGIN_TRANS.REMIT_AMOUNT
     * column comments 转账金额
     *
     * @mbggenerated Wed Jun 03 18:04:23 CST 2015
     */
    public String getRemitAmount() {
        return remitAmount;
    }

    /**
     * This method sets the value of the database column TB_MARGIN_TRANS.REMIT_AMOUNT
     *
     * @param remitAmount the value for TB_MARGIN_TRANS.REMIT_AMOUNT
     * column comments 转账金额
     *
     * @mbggenerated Wed Jun 03 18:04:23 CST 2015
     */
    public void setRemitAmount(String remitAmount) {
        this.remitAmount = remitAmount == null ? null : remitAmount.trim();
    }

    /**
     * This method returns the value of the database column TB_MARGIN_TRANS.CALLBACK_ADDRESS
     *
     * @return the value of TB_MARGIN_TRANS.CALLBACK_ADDRESS
     * column comments fos回调地址
     *
     * @mbggenerated Wed Jun 03 18:04:23 CST 2015
     */
    public String getCallbackAddress() {
        return callbackAddress;
    }

    /**
     * This method sets the value of the database column TB_MARGIN_TRANS.CALLBACK_ADDRESS
     *
     * @param callbackAddress the value for TB_MARGIN_TRANS.CALLBACK_ADDRESS
     * column comments fos回调地址
     *
     * @mbggenerated Wed Jun 03 18:04:23 CST 2015
     */
    public void setCallbackAddress(String callbackAddress) {
        this.callbackAddress = callbackAddress == null ? null : callbackAddress.trim();
    }

    /**
     * This method returns the value of the database column TB_MARGIN_TRANS.MEMO
     *
     * @return the value of TB_MARGIN_TRANS.MEMO
     * column comments 备注信息，储值系统要求不能为空
     *
     * @mbggenerated Wed Jun 03 18:04:23 CST 2015
     */
    public String getMemo() {
        return memo;
    }

    /**
     * This method sets the value of the database column TB_MARGIN_TRANS.MEMO
     *
     * @param memo the value for TB_MARGIN_TRANS.MEMO
     * column comments 备注信息，储值系统要求不能为空
     *
     * @mbggenerated Wed Jun 03 18:04:23 CST 2015
     */
    public void setMemo(String memo) {
        this.memo = memo == null ? null : memo.trim();
    }

    /**
     * This method returns the value of the database column TB_MARGIN_TRANS.IS_PEMIT_PRICING_ERR
     *
     * @return the value of TB_MARGIN_TRANS.IS_PEMIT_PRICING_ERR
     * column comments null
     *
     * @mbggenerated Wed Jun 03 18:04:23 CST 2015
     */
    public String getIsPemitPricingErr() {
        return isPemitPricingErr;
    }

    /**
     * This method sets the value of the database column TB_MARGIN_TRANS.IS_PEMIT_PRICING_ERR
     *
     * @param isPemitPricingErr the value for TB_MARGIN_TRANS.IS_PEMIT_PRICING_ERR
     * column comments null
     *
     * @mbggenerated Wed Jun 03 18:04:23 CST 2015
     */
    public void setIsPemitPricingErr(String isPemitPricingErr) {
        this.isPemitPricingErr = isPemitPricingErr == null ? null : isPemitPricingErr.trim();
    }

    /**
     * This method returns the value of the database column TB_MARGIN_TRANS.CURRENCY
     *
     * @return the value of TB_MARGIN_TRANS.CURRENCY
     * column comments 不传默认为CNY
     *
     * @mbggenerated Wed Jun 03 18:04:23 CST 2015
     */
    public String getCurrency() {
        return currency;
    }

    /**
     * This method sets the value of the database column TB_MARGIN_TRANS.CURRENCY
     *
     * @param currency the value for TB_MARGIN_TRANS.CURRENCY
     * column comments 不传默认为CNY
     *
     * @mbggenerated Wed Jun 03 18:04:23 CST 2015
     */
    public void setCurrency(String currency) {
        this.currency = currency == null ? null : currency.trim();
    }

    /**
     * This method returns the value of the database column TB_MARGIN_TRANS.PAYMENT_SEQ_NO
     *
     * @return the value of TB_MARGIN_TRANS.PAYMENT_SEQ_NO
     * column comments null
     *
     * @mbggenerated Wed Jun 03 18:04:23 CST 2015
     */
    public String getPaymentSeqNo() {
        return paymentSeqNo;
    }

    /**
     * This method sets the value of the database column TB_MARGIN_TRANS.PAYMENT_SEQ_NO
     *
     * @param paymentSeqNo the value for TB_MARGIN_TRANS.PAYMENT_SEQ_NO
     * column comments null
     *
     * @mbggenerated Wed Jun 03 18:04:23 CST 2015
     */
    public void setPaymentSeqNo(String paymentSeqNo) {
        this.paymentSeqNo = paymentSeqNo == null ? null : paymentSeqNo.trim();
    }

    /**
     * This method returns the value of the database column TB_MARGIN_TRANS.POCKET_AMOUNT
     *
     * @return the value of TB_MARGIN_TRANS.POCKET_AMOUNT
     * column comments null
     *
     * @mbggenerated Wed Jun 03 18:04:23 CST 2015
     */
    public String getPocketAmount() {
        return pocketAmount;
    }

    /**
     * This method sets the value of the database column TB_MARGIN_TRANS.POCKET_AMOUNT
     *
     * @param pocketAmount the value for TB_MARGIN_TRANS.POCKET_AMOUNT
     * column comments null
     *
     * @mbggenerated Wed Jun 03 18:04:23 CST 2015
     */
    public void setPocketAmount(String pocketAmount) {
        this.pocketAmount = pocketAmount == null ? null : pocketAmount.trim();
    }

    /**
     * This method returns the value of the database column TB_MARGIN_TRANS.SETTLEMENT_TIME
     *
     * @return the value of TB_MARGIN_TRANS.SETTLEMENT_TIME
     * column comments null
     *
     * @mbggenerated Wed Jun 03 18:04:23 CST 2015
     */
    public String getSettlementTime() {
        return settlementTime;
    }

    /**
     * This method sets the value of the database column TB_MARGIN_TRANS.SETTLEMENT_TIME
     *
     * @param settlementTime the value for TB_MARGIN_TRANS.SETTLEMENT_TIME
     * column comments null
     *
     * @mbggenerated Wed Jun 03 18:04:23 CST 2015
     */
    public void setSettlementTime(String settlementTime) {
        this.settlementTime = settlementTime == null ? null : settlementTime.trim();
    }

    /**
     * This method returns the value of the database column TB_MARGIN_TRANS.RETURN_CODE
     *
     * @return the value of TB_MARGIN_TRANS.RETURN_CODE
     * column comments 错误码
     *
     * @mbggenerated Wed Jun 03 18:04:23 CST 2015
     */
    public String getReturnCode() {
        return returnCode;
    }

    /**
     * This method sets the value of the database column TB_MARGIN_TRANS.RETURN_CODE
     *
     * @param returnCode the value for TB_MARGIN_TRANS.RETURN_CODE
     * column comments 错误码
     *
     * @mbggenerated Wed Jun 03 18:04:23 CST 2015
     */
    public void setReturnCode(String returnCode) {
        this.returnCode = returnCode == null ? null : returnCode.trim();
    }

    /**
     * This method returns the value of the database column TB_MARGIN_TRANS.RETURN_MSG
     *
     * @return the value of TB_MARGIN_TRANS.RETURN_MSG
     * column comments null
     *
     * @mbggenerated Wed Jun 03 18:04:23 CST 2015
     */
    public String getReturnMsg() {
        return returnMsg;
    }

    /**
     * This method sets the value of the database column TB_MARGIN_TRANS.RETURN_MSG
     *
     * @param returnMsg the value for TB_MARGIN_TRANS.RETURN_MSG
     * column comments null
     *
     * @mbggenerated Wed Jun 03 18:04:23 CST 2015
     */
    public void setReturnMsg(String returnMsg) {
        this.returnMsg = returnMsg == null ? null : returnMsg.trim();
    }

    /**
     * This method returns the value of the database column TB_MARGIN_TRANS.EXTENTION
     *
     * @return the value of TB_MARGIN_TRANS.EXTENTION
     * column comments null
     *
     * @mbggenerated Wed Jun 03 18:04:23 CST 2015
     */
    public String getExtention() {
        return extention;
    }

    /**
     * This method sets the value of the database column TB_MARGIN_TRANS.EXTENTION
     *
     * @param extention the value for TB_MARGIN_TRANS.EXTENTION
     * column comments null
     *
     * @mbggenerated Wed Jun 03 18:04:23 CST 2015
     */
    public void setExtention(String extention) {
        this.extention = extention == null ? null : extention.trim();
    }

    /**
     * This method returns the value of the database column TB_MARGIN_TRANS.CREATE_TIME
     *
     * @return the value of TB_MARGIN_TRANS.CREATE_TIME
     * column comments null
     *
     * @mbggenerated Wed Jun 03 18:04:23 CST 2015
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * This method sets the value of the database column TB_MARGIN_TRANS.CREATE_TIME
     *
     * @param createTime the value for TB_MARGIN_TRANS.CREATE_TIME
     * column comments null
     *
     * @mbggenerated Wed Jun 03 18:04:23 CST 2015
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * This method returns the value of the database column TB_MARGIN_TRANS.UPDATE_TIME
     *
     * @return the value of TB_MARGIN_TRANS.UPDATE_TIME
     * column comments null
     *
     * @mbggenerated Wed Jun 03 18:04:23 CST 2015
     */
    public Date getUpdateTime() {
        return updateTime;
    }

    /**
     * This method sets the value of the database column TB_MARGIN_TRANS.UPDATE_TIME
     *
     * @param updateTime the value for TB_MARGIN_TRANS.UPDATE_TIME
     * column comments null
     *
     * @mbggenerated Wed Jun 03 18:04:23 CST 2015
     */
    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    /**
     * This method returns the value of the database column TB_MARGIN_TRANS.BATCH_NO
     *
     * @return the value of TB_MARGIN_TRANS.BATCH_NO
     * column comments 批量转账批次号
     *
     * @mbggenerated Wed Jun 03 18:04:23 CST 2015
     */
    public String getBatchNo() {
        return batchNo;
    }

    /**
     * This method sets the value of the database column TB_MARGIN_TRANS.BATCH_NO
     *
     * @param batchNo the value for TB_MARGIN_TRANS.BATCH_NO
     * column comments 批量转账批次号
     *
     * @mbggenerated Wed Jun 03 18:04:23 CST 2015
     */
    public void setBatchNo(String batchNo) {
        this.batchNo = batchNo == null ? null : batchNo.trim();
    }

    /**
     * This method returns the value of the database column TB_MARGIN_TRANS.PAYEE_ACCOUNT_TYPE
     *
     * @return the value of TB_MARGIN_TRANS.PAYEE_ACCOUNT_TYPE
     * column comments 收款方款方账户类型0表示所有账户类型
     *
     * @mbggenerated Wed Jun 03 18:04:23 CST 2015
     */
    public String getPayeeAccountType() {
        return payeeAccountType;
    }

    /**
     * This method sets the value of the database column TB_MARGIN_TRANS.PAYEE_ACCOUNT_TYPE
     *
     * @param payeeAccountType the value for TB_MARGIN_TRANS.PAYEE_ACCOUNT_TYPE
     * column comments 收款方款方账户类型0表示所有账户类型
     *
     * @mbggenerated Wed Jun 03 18:04:23 CST 2015
     */
    public void setPayeeAccountType(String payeeAccountType) {
        this.payeeAccountType = payeeAccountType == null ? null : payeeAccountType.trim();
    }
}