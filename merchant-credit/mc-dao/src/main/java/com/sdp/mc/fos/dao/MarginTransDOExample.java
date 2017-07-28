package com.sdp.mc.fos.dao;

import com.sdp.emall.common.dao.QueryBase;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class MarginTransDOExample extends QueryBase {
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
     * This field corresponds to the database table TB_MARGIN_TRANS
     * table comments 保证金转账记录
     *
     * @mbggenerated Wed Jun 03 18:04:23 CST 2015
     */
    protected String orderByClause;

    /**
     * This field corresponds to the database table TB_MARGIN_TRANS
     * table comments 保证金转账记录
     *
     * @mbggenerated Wed Jun 03 18:04:23 CST 2015
     */
    protected boolean distinct;

    /**
     * This field corresponds to the database table TB_MARGIN_TRANS
     * table comments 保证金转账记录
     *
     * @mbggenerated Wed Jun 03 18:04:23 CST 2015
     */
    protected List<Criteria> oredCriteria;

    /**
     * This method corresponds to the database table TB_MARGIN_TRANS
     *
     * @mbggenerated Wed Jun 03 18:04:23 CST 2015
     */
    public MarginTransDOExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

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

    /**
     * This method corresponds to the database table TB_MARGIN_TRANS
     *
     * @mbggenerated Wed Jun 03 18:04:23 CST 2015
     */
    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    /**
     * This method corresponds to the database table TB_MARGIN_TRANS
     *
     * @mbggenerated Wed Jun 03 18:04:23 CST 2015
     */
    public String getOrderByClause() {
        return orderByClause;
    }

    /**
     * This method corresponds to the database table TB_MARGIN_TRANS
     *
     * @mbggenerated Wed Jun 03 18:04:23 CST 2015
     */
    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    /**
     * This method corresponds to the database table TB_MARGIN_TRANS
     *
     * @mbggenerated Wed Jun 03 18:04:23 CST 2015
     */
    public boolean isDistinct() {
        return distinct;
    }

    /**
     * This method corresponds to the database table TB_MARGIN_TRANS
     *
     * @mbggenerated Wed Jun 03 18:04:23 CST 2015
     */
    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    /**
     * This method corresponds to the database table TB_MARGIN_TRANS
     *
     * @mbggenerated Wed Jun 03 18:04:23 CST 2015
     */
    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    /**
     * This method corresponds to the database table TB_MARGIN_TRANS
     *
     * @mbggenerated Wed Jun 03 18:04:23 CST 2015
     */
    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    /**
     * This method corresponds to the database table TB_MARGIN_TRANS
     *
     * @mbggenerated Wed Jun 03 18:04:23 CST 2015
     */
    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    /**
     * This method corresponds to the database table TB_MARGIN_TRANS
     *
     * @mbggenerated Wed Jun 03 18:04:23 CST 2015
     */
    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    /**
     * This method corresponds to the database table TB_MARGIN_TRANS
     *
     * @mbggenerated Wed Jun 03 18:04:23 CST 2015
     */
    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table TB_MARGIN_TRANS
     * table comment :保证金转账记录
     *
     * @mbggenerated Wed Jun 03 18:04:23 CST 2015
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

        public Criteria andMtIdIsNull() {
            addCriterion("MT_ID is null");
            return (Criteria) this;
        }

        public Criteria andMtIdIsNotNull() {
            addCriterion("MT_ID is not null");
            return (Criteria) this;
        }

        public Criteria andMtIdEqualTo(Long value) {
            addCriterion("MT_ID =", value, "mtId");
            return (Criteria) this;
        }

        public Criteria andMtIdNotEqualTo(Long value) {
            addCriterion("MT_ID <>", value, "mtId");
            return (Criteria) this;
        }

        public Criteria andMtIdGreaterThan(Long value) {
            addCriterion("MT_ID >", value, "mtId");
            return (Criteria) this;
        }

        public Criteria andMtIdGreaterThanOrEqualTo(Long value) {
            addCriterion("MT_ID >=", value, "mtId");
            return (Criteria) this;
        }

        public Criteria andMtIdLessThan(Long value) {
            addCriterion("MT_ID <", value, "mtId");
            return (Criteria) this;
        }

        public Criteria andMtIdLessThanOrEqualTo(Long value) {
            addCriterion("MT_ID <=", value, "mtId");
            return (Criteria) this;
        }

        public Criteria andMtIdIn(List<Long> values) {
            addCriterion("MT_ID in", values, "mtId");
            return (Criteria) this;
        }

        public Criteria andMtIdNotIn(List<Long> values) {
            addCriterion("MT_ID not in", values, "mtId");
            return (Criteria) this;
        }

        public Criteria andMtIdBetween(Long value1, Long value2) {
            addCriterion("MT_ID between", value1, value2, "mtId");
            return (Criteria) this;
        }

        public Criteria andMtIdNotBetween(Long value1, Long value2) {
            addCriterion("MT_ID not between", value1, value2, "mtId");
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

        public Criteria andStatusEqualTo(Integer value) {
            addCriterion("STATUS =", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotEqualTo(Integer value) {
            addCriterion("STATUS <>", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThan(Integer value) {
            addCriterion("STATUS >", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThanOrEqualTo(Integer value) {
            addCriterion("STATUS >=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThan(Integer value) {
            addCriterion("STATUS <", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThanOrEqualTo(Integer value) {
            addCriterion("STATUS <=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusIn(List<Integer> values) {
            addCriterion("STATUS in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotIn(List<Integer> values) {
            addCriterion("STATUS not in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusBetween(Integer value1, Integer value2) {
            addCriterion("STATUS between", value1, value2, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotBetween(Integer value1, Integer value2) {
            addCriterion("STATUS not between", value1, value2, "status");
            return (Criteria) this;
        }

        public Criteria andProductCodeIsNull() {
            addCriterion("PRODUCT_CODE is null");
            return (Criteria) this;
        }

        public Criteria andProductCodeIsNotNull() {
            addCriterion("PRODUCT_CODE is not null");
            return (Criteria) this;
        }

        public Criteria andProductCodeEqualTo(String value) {
            addCriterion("PRODUCT_CODE =", value, "productCode");
            return (Criteria) this;
        }

        public Criteria andProductCodeNotEqualTo(String value) {
            addCriterion("PRODUCT_CODE <>", value, "productCode");
            return (Criteria) this;
        }

        public Criteria andProductCodeGreaterThan(String value) {
            addCriterion("PRODUCT_CODE >", value, "productCode");
            return (Criteria) this;
        }

        public Criteria andProductCodeGreaterThanOrEqualTo(String value) {
            addCriterion("PRODUCT_CODE >=", value, "productCode");
            return (Criteria) this;
        }

        public Criteria andProductCodeLessThan(String value) {
            addCriterion("PRODUCT_CODE <", value, "productCode");
            return (Criteria) this;
        }

        public Criteria andProductCodeLessThanOrEqualTo(String value) {
            addCriterion("PRODUCT_CODE <=", value, "productCode");
            return (Criteria) this;
        }

        public Criteria andProductCodeLike(String value) {
            addCriterion("PRODUCT_CODE like", value, "productCode");
            return (Criteria) this;
        }

        public Criteria andProductCodeNotLike(String value) {
            addCriterion("PRODUCT_CODE not like", value, "productCode");
            return (Criteria) this;
        }

        public Criteria andProductCodeIn(List<String> values) {
            addCriterion("PRODUCT_CODE in", values, "productCode");
            return (Criteria) this;
        }

        public Criteria andProductCodeNotIn(List<String> values) {
            addCriterion("PRODUCT_CODE not in", values, "productCode");
            return (Criteria) this;
        }

        public Criteria andProductCodeBetween(String value1, String value2) {
            addCriterion("PRODUCT_CODE between", value1, value2, "productCode");
            return (Criteria) this;
        }

        public Criteria andProductCodeNotBetween(String value1, String value2) {
            addCriterion("PRODUCT_CODE not between", value1, value2, "productCode");
            return (Criteria) this;
        }

        public Criteria andAppIdIsNull() {
            addCriterion("APP_ID is null");
            return (Criteria) this;
        }

        public Criteria andAppIdIsNotNull() {
            addCriterion("APP_ID is not null");
            return (Criteria) this;
        }

        public Criteria andAppIdEqualTo(String value) {
            addCriterion("APP_ID =", value, "appId");
            return (Criteria) this;
        }

        public Criteria andAppIdNotEqualTo(String value) {
            addCriterion("APP_ID <>", value, "appId");
            return (Criteria) this;
        }

        public Criteria andAppIdGreaterThan(String value) {
            addCriterion("APP_ID >", value, "appId");
            return (Criteria) this;
        }

        public Criteria andAppIdGreaterThanOrEqualTo(String value) {
            addCriterion("APP_ID >=", value, "appId");
            return (Criteria) this;
        }

        public Criteria andAppIdLessThan(String value) {
            addCriterion("APP_ID <", value, "appId");
            return (Criteria) this;
        }

        public Criteria andAppIdLessThanOrEqualTo(String value) {
            addCriterion("APP_ID <=", value, "appId");
            return (Criteria) this;
        }

        public Criteria andAppIdLike(String value) {
            addCriterion("APP_ID like", value, "appId");
            return (Criteria) this;
        }

        public Criteria andAppIdNotLike(String value) {
            addCriterion("APP_ID not like", value, "appId");
            return (Criteria) this;
        }

        public Criteria andAppIdIn(List<String> values) {
            addCriterion("APP_ID in", values, "appId");
            return (Criteria) this;
        }

        public Criteria andAppIdNotIn(List<String> values) {
            addCriterion("APP_ID not in", values, "appId");
            return (Criteria) this;
        }

        public Criteria andAppIdBetween(String value1, String value2) {
            addCriterion("APP_ID between", value1, value2, "appId");
            return (Criteria) this;
        }

        public Criteria andAppIdNotBetween(String value1, String value2) {
            addCriterion("APP_ID not between", value1, value2, "appId");
            return (Criteria) this;
        }

        public Criteria andPaymentCodeIsNull() {
            addCriterion("PAYMENT_CODE is null");
            return (Criteria) this;
        }

        public Criteria andPaymentCodeIsNotNull() {
            addCriterion("PAYMENT_CODE is not null");
            return (Criteria) this;
        }

        public Criteria andPaymentCodeEqualTo(String value) {
            addCriterion("PAYMENT_CODE =", value, "paymentCode");
            return (Criteria) this;
        }

        public Criteria andPaymentCodeNotEqualTo(String value) {
            addCriterion("PAYMENT_CODE <>", value, "paymentCode");
            return (Criteria) this;
        }

        public Criteria andPaymentCodeGreaterThan(String value) {
            addCriterion("PAYMENT_CODE >", value, "paymentCode");
            return (Criteria) this;
        }

        public Criteria andPaymentCodeGreaterThanOrEqualTo(String value) {
            addCriterion("PAYMENT_CODE >=", value, "paymentCode");
            return (Criteria) this;
        }

        public Criteria andPaymentCodeLessThan(String value) {
            addCriterion("PAYMENT_CODE <", value, "paymentCode");
            return (Criteria) this;
        }

        public Criteria andPaymentCodeLessThanOrEqualTo(String value) {
            addCriterion("PAYMENT_CODE <=", value, "paymentCode");
            return (Criteria) this;
        }

        public Criteria andPaymentCodeLike(String value) {
            addCriterion("PAYMENT_CODE like", value, "paymentCode");
            return (Criteria) this;
        }

        public Criteria andPaymentCodeNotLike(String value) {
            addCriterion("PAYMENT_CODE not like", value, "paymentCode");
            return (Criteria) this;
        }

        public Criteria andPaymentCodeIn(List<String> values) {
            addCriterion("PAYMENT_CODE in", values, "paymentCode");
            return (Criteria) this;
        }

        public Criteria andPaymentCodeNotIn(List<String> values) {
            addCriterion("PAYMENT_CODE not in", values, "paymentCode");
            return (Criteria) this;
        }

        public Criteria andPaymentCodeBetween(String value1, String value2) {
            addCriterion("PAYMENT_CODE between", value1, value2, "paymentCode");
            return (Criteria) this;
        }

        public Criteria andPaymentCodeNotBetween(String value1, String value2) {
            addCriterion("PAYMENT_CODE not between", value1, value2, "paymentCode");
            return (Criteria) this;
        }

        public Criteria andRemitVoucherNoIsNull() {
            addCriterion("REMIT_VOUCHER_NO is null");
            return (Criteria) this;
        }

        public Criteria andRemitVoucherNoIsNotNull() {
            addCriterion("REMIT_VOUCHER_NO is not null");
            return (Criteria) this;
        }

        public Criteria andRemitVoucherNoEqualTo(String value) {
            addCriterion("REMIT_VOUCHER_NO =", value, "remitVoucherNo");
            return (Criteria) this;
        }

        public Criteria andRemitVoucherNoNotEqualTo(String value) {
            addCriterion("REMIT_VOUCHER_NO <>", value, "remitVoucherNo");
            return (Criteria) this;
        }

        public Criteria andRemitVoucherNoGreaterThan(String value) {
            addCriterion("REMIT_VOUCHER_NO >", value, "remitVoucherNo");
            return (Criteria) this;
        }

        public Criteria andRemitVoucherNoGreaterThanOrEqualTo(String value) {
            addCriterion("REMIT_VOUCHER_NO >=", value, "remitVoucherNo");
            return (Criteria) this;
        }

        public Criteria andRemitVoucherNoLessThan(String value) {
            addCriterion("REMIT_VOUCHER_NO <", value, "remitVoucherNo");
            return (Criteria) this;
        }

        public Criteria andRemitVoucherNoLessThanOrEqualTo(String value) {
            addCriterion("REMIT_VOUCHER_NO <=", value, "remitVoucherNo");
            return (Criteria) this;
        }

        public Criteria andRemitVoucherNoLike(String value) {
            addCriterion("REMIT_VOUCHER_NO like", value, "remitVoucherNo");
            return (Criteria) this;
        }

        public Criteria andRemitVoucherNoNotLike(String value) {
            addCriterion("REMIT_VOUCHER_NO not like", value, "remitVoucherNo");
            return (Criteria) this;
        }

        public Criteria andRemitVoucherNoIn(List<String> values) {
            addCriterion("REMIT_VOUCHER_NO in", values, "remitVoucherNo");
            return (Criteria) this;
        }

        public Criteria andRemitVoucherNoNotIn(List<String> values) {
            addCriterion("REMIT_VOUCHER_NO not in", values, "remitVoucherNo");
            return (Criteria) this;
        }

        public Criteria andRemitVoucherNoBetween(String value1, String value2) {
            addCriterion("REMIT_VOUCHER_NO between", value1, value2, "remitVoucherNo");
            return (Criteria) this;
        }

        public Criteria andRemitVoucherNoNotBetween(String value1, String value2) {
            addCriterion("REMIT_VOUCHER_NO not between", value1, value2, "remitVoucherNo");
            return (Criteria) this;
        }

        public Criteria andPaymentStateIsNull() {
            addCriterion("PAYMENT_STATE is null");
            return (Criteria) this;
        }

        public Criteria andPaymentStateIsNotNull() {
            addCriterion("PAYMENT_STATE is not null");
            return (Criteria) this;
        }

        public Criteria andPaymentStateEqualTo(String value) {
            addCriterion("PAYMENT_STATE =", value, "paymentState");
            return (Criteria) this;
        }

        public Criteria andPaymentStateNotEqualTo(String value) {
            addCriterion("PAYMENT_STATE <>", value, "paymentState");
            return (Criteria) this;
        }

        public Criteria andPaymentStateGreaterThan(String value) {
            addCriterion("PAYMENT_STATE >", value, "paymentState");
            return (Criteria) this;
        }

        public Criteria andPaymentStateGreaterThanOrEqualTo(String value) {
            addCriterion("PAYMENT_STATE >=", value, "paymentState");
            return (Criteria) this;
        }

        public Criteria andPaymentStateLessThan(String value) {
            addCriterion("PAYMENT_STATE <", value, "paymentState");
            return (Criteria) this;
        }

        public Criteria andPaymentStateLessThanOrEqualTo(String value) {
            addCriterion("PAYMENT_STATE <=", value, "paymentState");
            return (Criteria) this;
        }

        public Criteria andPaymentStateLike(String value) {
            addCriterion("PAYMENT_STATE like", value, "paymentState");
            return (Criteria) this;
        }

        public Criteria andPaymentStateNotLike(String value) {
            addCriterion("PAYMENT_STATE not like", value, "paymentState");
            return (Criteria) this;
        }

        public Criteria andPaymentStateIn(List<String> values) {
            addCriterion("PAYMENT_STATE in", values, "paymentState");
            return (Criteria) this;
        }

        public Criteria andPaymentStateNotIn(List<String> values) {
            addCriterion("PAYMENT_STATE not in", values, "paymentState");
            return (Criteria) this;
        }

        public Criteria andPaymentStateBetween(String value1, String value2) {
            addCriterion("PAYMENT_STATE between", value1, value2, "paymentState");
            return (Criteria) this;
        }

        public Criteria andPaymentStateNotBetween(String value1, String value2) {
            addCriterion("PAYMENT_STATE not between", value1, value2, "paymentState");
            return (Criteria) this;
        }

        public Criteria andPayerMemberIdIsNull() {
            addCriterion("PAYER_MEMBER_ID is null");
            return (Criteria) this;
        }

        public Criteria andPayerMemberIdIsNotNull() {
            addCriterion("PAYER_MEMBER_ID is not null");
            return (Criteria) this;
        }

        public Criteria andPayerMemberIdEqualTo(String value) {
            addCriterion("PAYER_MEMBER_ID =", value, "payerMemberId");
            return (Criteria) this;
        }

        public Criteria andPayerMemberIdNotEqualTo(String value) {
            addCriterion("PAYER_MEMBER_ID <>", value, "payerMemberId");
            return (Criteria) this;
        }

        public Criteria andPayerMemberIdGreaterThan(String value) {
            addCriterion("PAYER_MEMBER_ID >", value, "payerMemberId");
            return (Criteria) this;
        }

        public Criteria andPayerMemberIdGreaterThanOrEqualTo(String value) {
            addCriterion("PAYER_MEMBER_ID >=", value, "payerMemberId");
            return (Criteria) this;
        }

        public Criteria andPayerMemberIdLessThan(String value) {
            addCriterion("PAYER_MEMBER_ID <", value, "payerMemberId");
            return (Criteria) this;
        }

        public Criteria andPayerMemberIdLessThanOrEqualTo(String value) {
            addCriterion("PAYER_MEMBER_ID <=", value, "payerMemberId");
            return (Criteria) this;
        }

        public Criteria andPayerMemberIdLike(String value) {
            addCriterion("PAYER_MEMBER_ID like", value, "payerMemberId");
            return (Criteria) this;
        }

        public Criteria andPayerMemberIdNotLike(String value) {
            addCriterion("PAYER_MEMBER_ID not like", value, "payerMemberId");
            return (Criteria) this;
        }

        public Criteria andPayerMemberIdIn(List<String> values) {
            addCriterion("PAYER_MEMBER_ID in", values, "payerMemberId");
            return (Criteria) this;
        }

        public Criteria andPayerMemberIdNotIn(List<String> values) {
            addCriterion("PAYER_MEMBER_ID not in", values, "payerMemberId");
            return (Criteria) this;
        }

        public Criteria andPayerMemberIdBetween(String value1, String value2) {
            addCriterion("PAYER_MEMBER_ID between", value1, value2, "payerMemberId");
            return (Criteria) this;
        }

        public Criteria andPayerMemberIdNotBetween(String value1, String value2) {
            addCriterion("PAYER_MEMBER_ID not between", value1, value2, "payerMemberId");
            return (Criteria) this;
        }

        public Criteria andPayeeMemberIdIsNull() {
            addCriterion("PAYEE_MEMBER_ID is null");
            return (Criteria) this;
        }

        public Criteria andPayeeMemberIdIsNotNull() {
            addCriterion("PAYEE_MEMBER_ID is not null");
            return (Criteria) this;
        }

        public Criteria andPayeeMemberIdEqualTo(String value) {
            addCriterion("PAYEE_MEMBER_ID =", value, "payeeMemberId");
            return (Criteria) this;
        }

        public Criteria andPayeeMemberIdNotEqualTo(String value) {
            addCriterion("PAYEE_MEMBER_ID <>", value, "payeeMemberId");
            return (Criteria) this;
        }

        public Criteria andPayeeMemberIdGreaterThan(String value) {
            addCriterion("PAYEE_MEMBER_ID >", value, "payeeMemberId");
            return (Criteria) this;
        }

        public Criteria andPayeeMemberIdGreaterThanOrEqualTo(String value) {
            addCriterion("PAYEE_MEMBER_ID >=", value, "payeeMemberId");
            return (Criteria) this;
        }

        public Criteria andPayeeMemberIdLessThan(String value) {
            addCriterion("PAYEE_MEMBER_ID <", value, "payeeMemberId");
            return (Criteria) this;
        }

        public Criteria andPayeeMemberIdLessThanOrEqualTo(String value) {
            addCriterion("PAYEE_MEMBER_ID <=", value, "payeeMemberId");
            return (Criteria) this;
        }

        public Criteria andPayeeMemberIdLike(String value) {
            addCriterion("PAYEE_MEMBER_ID like", value, "payeeMemberId");
            return (Criteria) this;
        }

        public Criteria andPayeeMemberIdNotLike(String value) {
            addCriterion("PAYEE_MEMBER_ID not like", value, "payeeMemberId");
            return (Criteria) this;
        }

        public Criteria andPayeeMemberIdIn(List<String> values) {
            addCriterion("PAYEE_MEMBER_ID in", values, "payeeMemberId");
            return (Criteria) this;
        }

        public Criteria andPayeeMemberIdNotIn(List<String> values) {
            addCriterion("PAYEE_MEMBER_ID not in", values, "payeeMemberId");
            return (Criteria) this;
        }

        public Criteria andPayeeMemberIdBetween(String value1, String value2) {
            addCriterion("PAYEE_MEMBER_ID between", value1, value2, "payeeMemberId");
            return (Criteria) this;
        }

        public Criteria andPayeeMemberIdNotBetween(String value1, String value2) {
            addCriterion("PAYEE_MEMBER_ID not between", value1, value2, "payeeMemberId");
            return (Criteria) this;
        }

        public Criteria andIsNeedCountFeeIsNull() {
            addCriterion("IS_NEED_COUNT_FEE is null");
            return (Criteria) this;
        }

        public Criteria andIsNeedCountFeeIsNotNull() {
            addCriterion("IS_NEED_COUNT_FEE is not null");
            return (Criteria) this;
        }

        public Criteria andIsNeedCountFeeEqualTo(String value) {
            addCriterion("IS_NEED_COUNT_FEE =", value, "isNeedCountFee");
            return (Criteria) this;
        }

        public Criteria andIsNeedCountFeeNotEqualTo(String value) {
            addCriterion("IS_NEED_COUNT_FEE <>", value, "isNeedCountFee");
            return (Criteria) this;
        }

        public Criteria andIsNeedCountFeeGreaterThan(String value) {
            addCriterion("IS_NEED_COUNT_FEE >", value, "isNeedCountFee");
            return (Criteria) this;
        }

        public Criteria andIsNeedCountFeeGreaterThanOrEqualTo(String value) {
            addCriterion("IS_NEED_COUNT_FEE >=", value, "isNeedCountFee");
            return (Criteria) this;
        }

        public Criteria andIsNeedCountFeeLessThan(String value) {
            addCriterion("IS_NEED_COUNT_FEE <", value, "isNeedCountFee");
            return (Criteria) this;
        }

        public Criteria andIsNeedCountFeeLessThanOrEqualTo(String value) {
            addCriterion("IS_NEED_COUNT_FEE <=", value, "isNeedCountFee");
            return (Criteria) this;
        }

        public Criteria andIsNeedCountFeeLike(String value) {
            addCriterion("IS_NEED_COUNT_FEE like", value, "isNeedCountFee");
            return (Criteria) this;
        }

        public Criteria andIsNeedCountFeeNotLike(String value) {
            addCriterion("IS_NEED_COUNT_FEE not like", value, "isNeedCountFee");
            return (Criteria) this;
        }

        public Criteria andIsNeedCountFeeIn(List<String> values) {
            addCriterion("IS_NEED_COUNT_FEE in", values, "isNeedCountFee");
            return (Criteria) this;
        }

        public Criteria andIsNeedCountFeeNotIn(List<String> values) {
            addCriterion("IS_NEED_COUNT_FEE not in", values, "isNeedCountFee");
            return (Criteria) this;
        }

        public Criteria andIsNeedCountFeeBetween(String value1, String value2) {
            addCriterion("IS_NEED_COUNT_FEE between", value1, value2, "isNeedCountFee");
            return (Criteria) this;
        }

        public Criteria andIsNeedCountFeeNotBetween(String value1, String value2) {
            addCriterion("IS_NEED_COUNT_FEE not between", value1, value2, "isNeedCountFee");
            return (Criteria) this;
        }

        public Criteria andPayerFeeIsNull() {
            addCriterion("PAYER_FEE is null");
            return (Criteria) this;
        }

        public Criteria andPayerFeeIsNotNull() {
            addCriterion("PAYER_FEE is not null");
            return (Criteria) this;
        }

        public Criteria andPayerFeeEqualTo(String value) {
            addCriterion("PAYER_FEE =", value, "payerFee");
            return (Criteria) this;
        }

        public Criteria andPayerFeeNotEqualTo(String value) {
            addCriterion("PAYER_FEE <>", value, "payerFee");
            return (Criteria) this;
        }

        public Criteria andPayerFeeGreaterThan(String value) {
            addCriterion("PAYER_FEE >", value, "payerFee");
            return (Criteria) this;
        }

        public Criteria andPayerFeeGreaterThanOrEqualTo(String value) {
            addCriterion("PAYER_FEE >=", value, "payerFee");
            return (Criteria) this;
        }

        public Criteria andPayerFeeLessThan(String value) {
            addCriterion("PAYER_FEE <", value, "payerFee");
            return (Criteria) this;
        }

        public Criteria andPayerFeeLessThanOrEqualTo(String value) {
            addCriterion("PAYER_FEE <=", value, "payerFee");
            return (Criteria) this;
        }

        public Criteria andPayerFeeLike(String value) {
            addCriterion("PAYER_FEE like", value, "payerFee");
            return (Criteria) this;
        }

        public Criteria andPayerFeeNotLike(String value) {
            addCriterion("PAYER_FEE not like", value, "payerFee");
            return (Criteria) this;
        }

        public Criteria andPayerFeeIn(List<String> values) {
            addCriterion("PAYER_FEE in", values, "payerFee");
            return (Criteria) this;
        }

        public Criteria andPayerFeeNotIn(List<String> values) {
            addCriterion("PAYER_FEE not in", values, "payerFee");
            return (Criteria) this;
        }

        public Criteria andPayerFeeBetween(String value1, String value2) {
            addCriterion("PAYER_FEE between", value1, value2, "payerFee");
            return (Criteria) this;
        }

        public Criteria andPayerFeeNotBetween(String value1, String value2) {
            addCriterion("PAYER_FEE not between", value1, value2, "payerFee");
            return (Criteria) this;
        }

        public Criteria andPayeeFeeIsNull() {
            addCriterion("PAYEE_FEE is null");
            return (Criteria) this;
        }

        public Criteria andPayeeFeeIsNotNull() {
            addCriterion("PAYEE_FEE is not null");
            return (Criteria) this;
        }

        public Criteria andPayeeFeeEqualTo(String value) {
            addCriterion("PAYEE_FEE =", value, "payeeFee");
            return (Criteria) this;
        }

        public Criteria andPayeeFeeNotEqualTo(String value) {
            addCriterion("PAYEE_FEE <>", value, "payeeFee");
            return (Criteria) this;
        }

        public Criteria andPayeeFeeGreaterThan(String value) {
            addCriterion("PAYEE_FEE >", value, "payeeFee");
            return (Criteria) this;
        }

        public Criteria andPayeeFeeGreaterThanOrEqualTo(String value) {
            addCriterion("PAYEE_FEE >=", value, "payeeFee");
            return (Criteria) this;
        }

        public Criteria andPayeeFeeLessThan(String value) {
            addCriterion("PAYEE_FEE <", value, "payeeFee");
            return (Criteria) this;
        }

        public Criteria andPayeeFeeLessThanOrEqualTo(String value) {
            addCriterion("PAYEE_FEE <=", value, "payeeFee");
            return (Criteria) this;
        }

        public Criteria andPayeeFeeLike(String value) {
            addCriterion("PAYEE_FEE like", value, "payeeFee");
            return (Criteria) this;
        }

        public Criteria andPayeeFeeNotLike(String value) {
            addCriterion("PAYEE_FEE not like", value, "payeeFee");
            return (Criteria) this;
        }

        public Criteria andPayeeFeeIn(List<String> values) {
            addCriterion("PAYEE_FEE in", values, "payeeFee");
            return (Criteria) this;
        }

        public Criteria andPayeeFeeNotIn(List<String> values) {
            addCriterion("PAYEE_FEE not in", values, "payeeFee");
            return (Criteria) this;
        }

        public Criteria andPayeeFeeBetween(String value1, String value2) {
            addCriterion("PAYEE_FEE between", value1, value2, "payeeFee");
            return (Criteria) this;
        }

        public Criteria andPayeeFeeNotBetween(String value1, String value2) {
            addCriterion("PAYEE_FEE not between", value1, value2, "payeeFee");
            return (Criteria) this;
        }

        public Criteria andPayerAccountTypeIsNull() {
            addCriterion("PAYER_ACCOUNT_TYPE is null");
            return (Criteria) this;
        }

        public Criteria andPayerAccountTypeIsNotNull() {
            addCriterion("PAYER_ACCOUNT_TYPE is not null");
            return (Criteria) this;
        }

        public Criteria andPayerAccountTypeEqualTo(String value) {
            addCriterion("PAYER_ACCOUNT_TYPE =", value, "payerAccountType");
            return (Criteria) this;
        }

        public Criteria andPayerAccountTypeNotEqualTo(String value) {
            addCriterion("PAYER_ACCOUNT_TYPE <>", value, "payerAccountType");
            return (Criteria) this;
        }

        public Criteria andPayerAccountTypeGreaterThan(String value) {
            addCriterion("PAYER_ACCOUNT_TYPE >", value, "payerAccountType");
            return (Criteria) this;
        }

        public Criteria andPayerAccountTypeGreaterThanOrEqualTo(String value) {
            addCriterion("PAYER_ACCOUNT_TYPE >=", value, "payerAccountType");
            return (Criteria) this;
        }

        public Criteria andPayerAccountTypeLessThan(String value) {
            addCriterion("PAYER_ACCOUNT_TYPE <", value, "payerAccountType");
            return (Criteria) this;
        }

        public Criteria andPayerAccountTypeLessThanOrEqualTo(String value) {
            addCriterion("PAYER_ACCOUNT_TYPE <=", value, "payerAccountType");
            return (Criteria) this;
        }

        public Criteria andPayerAccountTypeLike(String value) {
            addCriterion("PAYER_ACCOUNT_TYPE like", value, "payerAccountType");
            return (Criteria) this;
        }

        public Criteria andPayerAccountTypeNotLike(String value) {
            addCriterion("PAYER_ACCOUNT_TYPE not like", value, "payerAccountType");
            return (Criteria) this;
        }

        public Criteria andPayerAccountTypeIn(List<String> values) {
            addCriterion("PAYER_ACCOUNT_TYPE in", values, "payerAccountType");
            return (Criteria) this;
        }

        public Criteria andPayerAccountTypeNotIn(List<String> values) {
            addCriterion("PAYER_ACCOUNT_TYPE not in", values, "payerAccountType");
            return (Criteria) this;
        }

        public Criteria andPayerAccountTypeBetween(String value1, String value2) {
            addCriterion("PAYER_ACCOUNT_TYPE between", value1, value2, "payerAccountType");
            return (Criteria) this;
        }

        public Criteria andPayerAccountTypeNotBetween(String value1, String value2) {
            addCriterion("PAYER_ACCOUNT_TYPE not between", value1, value2, "payerAccountType");
            return (Criteria) this;
        }

        public Criteria andPayerAccountNoIsNull() {
            addCriterion("PAYER_ACCOUNT_NO is null");
            return (Criteria) this;
        }

        public Criteria andPayerAccountNoIsNotNull() {
            addCriterion("PAYER_ACCOUNT_NO is not null");
            return (Criteria) this;
        }

        public Criteria andPayerAccountNoEqualTo(String value) {
            addCriterion("PAYER_ACCOUNT_NO =", value, "payerAccountNo");
            return (Criteria) this;
        }

        public Criteria andPayerAccountNoNotEqualTo(String value) {
            addCriterion("PAYER_ACCOUNT_NO <>", value, "payerAccountNo");
            return (Criteria) this;
        }

        public Criteria andPayerAccountNoGreaterThan(String value) {
            addCriterion("PAYER_ACCOUNT_NO >", value, "payerAccountNo");
            return (Criteria) this;
        }

        public Criteria andPayerAccountNoGreaterThanOrEqualTo(String value) {
            addCriterion("PAYER_ACCOUNT_NO >=", value, "payerAccountNo");
            return (Criteria) this;
        }

        public Criteria andPayerAccountNoLessThan(String value) {
            addCriterion("PAYER_ACCOUNT_NO <", value, "payerAccountNo");
            return (Criteria) this;
        }

        public Criteria andPayerAccountNoLessThanOrEqualTo(String value) {
            addCriterion("PAYER_ACCOUNT_NO <=", value, "payerAccountNo");
            return (Criteria) this;
        }

        public Criteria andPayerAccountNoLike(String value) {
            addCriterion("PAYER_ACCOUNT_NO like", value, "payerAccountNo");
            return (Criteria) this;
        }

        public Criteria andPayerAccountNoNotLike(String value) {
            addCriterion("PAYER_ACCOUNT_NO not like", value, "payerAccountNo");
            return (Criteria) this;
        }

        public Criteria andPayerAccountNoIn(List<String> values) {
            addCriterion("PAYER_ACCOUNT_NO in", values, "payerAccountNo");
            return (Criteria) this;
        }

        public Criteria andPayerAccountNoNotIn(List<String> values) {
            addCriterion("PAYER_ACCOUNT_NO not in", values, "payerAccountNo");
            return (Criteria) this;
        }

        public Criteria andPayerAccountNoBetween(String value1, String value2) {
            addCriterion("PAYER_ACCOUNT_NO between", value1, value2, "payerAccountNo");
            return (Criteria) this;
        }

        public Criteria andPayerAccountNoNotBetween(String value1, String value2) {
            addCriterion("PAYER_ACCOUNT_NO not between", value1, value2, "payerAccountNo");
            return (Criteria) this;
        }

        public Criteria andPayeeAccountNoIsNull() {
            addCriterion("PAYEE_ACCOUNT_NO is null");
            return (Criteria) this;
        }

        public Criteria andPayeeAccountNoIsNotNull() {
            addCriterion("PAYEE_ACCOUNT_NO is not null");
            return (Criteria) this;
        }

        public Criteria andPayeeAccountNoEqualTo(String value) {
            addCriterion("PAYEE_ACCOUNT_NO =", value, "payeeAccountNo");
            return (Criteria) this;
        }

        public Criteria andPayeeAccountNoNotEqualTo(String value) {
            addCriterion("PAYEE_ACCOUNT_NO <>", value, "payeeAccountNo");
            return (Criteria) this;
        }

        public Criteria andPayeeAccountNoGreaterThan(String value) {
            addCriterion("PAYEE_ACCOUNT_NO >", value, "payeeAccountNo");
            return (Criteria) this;
        }

        public Criteria andPayeeAccountNoGreaterThanOrEqualTo(String value) {
            addCriterion("PAYEE_ACCOUNT_NO >=", value, "payeeAccountNo");
            return (Criteria) this;
        }

        public Criteria andPayeeAccountNoLessThan(String value) {
            addCriterion("PAYEE_ACCOUNT_NO <", value, "payeeAccountNo");
            return (Criteria) this;
        }

        public Criteria andPayeeAccountNoLessThanOrEqualTo(String value) {
            addCriterion("PAYEE_ACCOUNT_NO <=", value, "payeeAccountNo");
            return (Criteria) this;
        }

        public Criteria andPayeeAccountNoLike(String value) {
            addCriterion("PAYEE_ACCOUNT_NO like", value, "payeeAccountNo");
            return (Criteria) this;
        }

        public Criteria andPayeeAccountNoNotLike(String value) {
            addCriterion("PAYEE_ACCOUNT_NO not like", value, "payeeAccountNo");
            return (Criteria) this;
        }

        public Criteria andPayeeAccountNoIn(List<String> values) {
            addCriterion("PAYEE_ACCOUNT_NO in", values, "payeeAccountNo");
            return (Criteria) this;
        }

        public Criteria andPayeeAccountNoNotIn(List<String> values) {
            addCriterion("PAYEE_ACCOUNT_NO not in", values, "payeeAccountNo");
            return (Criteria) this;
        }

        public Criteria andPayeeAccountNoBetween(String value1, String value2) {
            addCriterion("PAYEE_ACCOUNT_NO between", value1, value2, "payeeAccountNo");
            return (Criteria) this;
        }

        public Criteria andPayeeAccountNoNotBetween(String value1, String value2) {
            addCriterion("PAYEE_ACCOUNT_NO not between", value1, value2, "payeeAccountNo");
            return (Criteria) this;
        }

        public Criteria andGmtBizInitiateIsNull() {
            addCriterion("GMT_BIZ_INITIATE is null");
            return (Criteria) this;
        }

        public Criteria andGmtBizInitiateIsNotNull() {
            addCriterion("GMT_BIZ_INITIATE is not null");
            return (Criteria) this;
        }

        public Criteria andGmtBizInitiateEqualTo(String value) {
            addCriterion("GMT_BIZ_INITIATE =", value, "gmtBizInitiate");
            return (Criteria) this;
        }

        public Criteria andGmtBizInitiateNotEqualTo(String value) {
            addCriterion("GMT_BIZ_INITIATE <>", value, "gmtBizInitiate");
            return (Criteria) this;
        }

        public Criteria andGmtBizInitiateGreaterThan(String value) {
            addCriterion("GMT_BIZ_INITIATE >", value, "gmtBizInitiate");
            return (Criteria) this;
        }

        public Criteria andGmtBizInitiateGreaterThanOrEqualTo(String value) {
            addCriterion("GMT_BIZ_INITIATE >=", value, "gmtBizInitiate");
            return (Criteria) this;
        }

        public Criteria andGmtBizInitiateLessThan(String value) {
            addCriterion("GMT_BIZ_INITIATE <", value, "gmtBizInitiate");
            return (Criteria) this;
        }

        public Criteria andGmtBizInitiateLessThanOrEqualTo(String value) {
            addCriterion("GMT_BIZ_INITIATE <=", value, "gmtBizInitiate");
            return (Criteria) this;
        }

        public Criteria andGmtBizInitiateLike(String value) {
            addCriterion("GMT_BIZ_INITIATE like", value, "gmtBizInitiate");
            return (Criteria) this;
        }

        public Criteria andGmtBizInitiateNotLike(String value) {
            addCriterion("GMT_BIZ_INITIATE not like", value, "gmtBizInitiate");
            return (Criteria) this;
        }

        public Criteria andGmtBizInitiateIn(List<String> values) {
            addCriterion("GMT_BIZ_INITIATE in", values, "gmtBizInitiate");
            return (Criteria) this;
        }

        public Criteria andGmtBizInitiateNotIn(List<String> values) {
            addCriterion("GMT_BIZ_INITIATE not in", values, "gmtBizInitiate");
            return (Criteria) this;
        }

        public Criteria andGmtBizInitiateBetween(String value1, String value2) {
            addCriterion("GMT_BIZ_INITIATE between", value1, value2, "gmtBizInitiate");
            return (Criteria) this;
        }

        public Criteria andGmtBizInitiateNotBetween(String value1, String value2) {
            addCriterion("GMT_BIZ_INITIATE not between", value1, value2, "gmtBizInitiate");
            return (Criteria) this;
        }

        public Criteria andGmtPaymentInitiateIsNull() {
            addCriterion("GMT_PAYMENT_INITIATE is null");
            return (Criteria) this;
        }

        public Criteria andGmtPaymentInitiateIsNotNull() {
            addCriterion("GMT_PAYMENT_INITIATE is not null");
            return (Criteria) this;
        }

        public Criteria andGmtPaymentInitiateEqualTo(String value) {
            addCriterion("GMT_PAYMENT_INITIATE =", value, "gmtPaymentInitiate");
            return (Criteria) this;
        }

        public Criteria andGmtPaymentInitiateNotEqualTo(String value) {
            addCriterion("GMT_PAYMENT_INITIATE <>", value, "gmtPaymentInitiate");
            return (Criteria) this;
        }

        public Criteria andGmtPaymentInitiateGreaterThan(String value) {
            addCriterion("GMT_PAYMENT_INITIATE >", value, "gmtPaymentInitiate");
            return (Criteria) this;
        }

        public Criteria andGmtPaymentInitiateGreaterThanOrEqualTo(String value) {
            addCriterion("GMT_PAYMENT_INITIATE >=", value, "gmtPaymentInitiate");
            return (Criteria) this;
        }

        public Criteria andGmtPaymentInitiateLessThan(String value) {
            addCriterion("GMT_PAYMENT_INITIATE <", value, "gmtPaymentInitiate");
            return (Criteria) this;
        }

        public Criteria andGmtPaymentInitiateLessThanOrEqualTo(String value) {
            addCriterion("GMT_PAYMENT_INITIATE <=", value, "gmtPaymentInitiate");
            return (Criteria) this;
        }

        public Criteria andGmtPaymentInitiateLike(String value) {
            addCriterion("GMT_PAYMENT_INITIATE like", value, "gmtPaymentInitiate");
            return (Criteria) this;
        }

        public Criteria andGmtPaymentInitiateNotLike(String value) {
            addCriterion("GMT_PAYMENT_INITIATE not like", value, "gmtPaymentInitiate");
            return (Criteria) this;
        }

        public Criteria andGmtPaymentInitiateIn(List<String> values) {
            addCriterion("GMT_PAYMENT_INITIATE in", values, "gmtPaymentInitiate");
            return (Criteria) this;
        }

        public Criteria andGmtPaymentInitiateNotIn(List<String> values) {
            addCriterion("GMT_PAYMENT_INITIATE not in", values, "gmtPaymentInitiate");
            return (Criteria) this;
        }

        public Criteria andGmtPaymentInitiateBetween(String value1, String value2) {
            addCriterion("GMT_PAYMENT_INITIATE between", value1, value2, "gmtPaymentInitiate");
            return (Criteria) this;
        }

        public Criteria andGmtPaymentInitiateNotBetween(String value1, String value2) {
            addCriterion("GMT_PAYMENT_INITIATE not between", value1, value2, "gmtPaymentInitiate");
            return (Criteria) this;
        }

        public Criteria andRemitAmountIsNull() {
            addCriterion("REMIT_AMOUNT is null");
            return (Criteria) this;
        }

        public Criteria andRemitAmountIsNotNull() {
            addCriterion("REMIT_AMOUNT is not null");
            return (Criteria) this;
        }

        public Criteria andRemitAmountEqualTo(String value) {
            addCriterion("REMIT_AMOUNT =", value, "remitAmount");
            return (Criteria) this;
        }

        public Criteria andRemitAmountNotEqualTo(String value) {
            addCriterion("REMIT_AMOUNT <>", value, "remitAmount");
            return (Criteria) this;
        }

        public Criteria andRemitAmountGreaterThan(String value) {
            addCriterion("REMIT_AMOUNT >", value, "remitAmount");
            return (Criteria) this;
        }

        public Criteria andRemitAmountGreaterThanOrEqualTo(String value) {
            addCriterion("REMIT_AMOUNT >=", value, "remitAmount");
            return (Criteria) this;
        }

        public Criteria andRemitAmountLessThan(String value) {
            addCriterion("REMIT_AMOUNT <", value, "remitAmount");
            return (Criteria) this;
        }

        public Criteria andRemitAmountLessThanOrEqualTo(String value) {
            addCriterion("REMIT_AMOUNT <=", value, "remitAmount");
            return (Criteria) this;
        }

        public Criteria andRemitAmountLike(String value) {
            addCriterion("REMIT_AMOUNT like", value, "remitAmount");
            return (Criteria) this;
        }

        public Criteria andRemitAmountNotLike(String value) {
            addCriterion("REMIT_AMOUNT not like", value, "remitAmount");
            return (Criteria) this;
        }

        public Criteria andRemitAmountIn(List<String> values) {
            addCriterion("REMIT_AMOUNT in", values, "remitAmount");
            return (Criteria) this;
        }

        public Criteria andRemitAmountNotIn(List<String> values) {
            addCriterion("REMIT_AMOUNT not in", values, "remitAmount");
            return (Criteria) this;
        }

        public Criteria andRemitAmountBetween(String value1, String value2) {
            addCriterion("REMIT_AMOUNT between", value1, value2, "remitAmount");
            return (Criteria) this;
        }

        public Criteria andRemitAmountNotBetween(String value1, String value2) {
            addCriterion("REMIT_AMOUNT not between", value1, value2, "remitAmount");
            return (Criteria) this;
        }

        public Criteria andCallbackAddressIsNull() {
            addCriterion("CALLBACK_ADDRESS is null");
            return (Criteria) this;
        }

        public Criteria andCallbackAddressIsNotNull() {
            addCriterion("CALLBACK_ADDRESS is not null");
            return (Criteria) this;
        }

        public Criteria andCallbackAddressEqualTo(String value) {
            addCriterion("CALLBACK_ADDRESS =", value, "callbackAddress");
            return (Criteria) this;
        }

        public Criteria andCallbackAddressNotEqualTo(String value) {
            addCriterion("CALLBACK_ADDRESS <>", value, "callbackAddress");
            return (Criteria) this;
        }

        public Criteria andCallbackAddressGreaterThan(String value) {
            addCriterion("CALLBACK_ADDRESS >", value, "callbackAddress");
            return (Criteria) this;
        }

        public Criteria andCallbackAddressGreaterThanOrEqualTo(String value) {
            addCriterion("CALLBACK_ADDRESS >=", value, "callbackAddress");
            return (Criteria) this;
        }

        public Criteria andCallbackAddressLessThan(String value) {
            addCriterion("CALLBACK_ADDRESS <", value, "callbackAddress");
            return (Criteria) this;
        }

        public Criteria andCallbackAddressLessThanOrEqualTo(String value) {
            addCriterion("CALLBACK_ADDRESS <=", value, "callbackAddress");
            return (Criteria) this;
        }

        public Criteria andCallbackAddressLike(String value) {
            addCriterion("CALLBACK_ADDRESS like", value, "callbackAddress");
            return (Criteria) this;
        }

        public Criteria andCallbackAddressNotLike(String value) {
            addCriterion("CALLBACK_ADDRESS not like", value, "callbackAddress");
            return (Criteria) this;
        }

        public Criteria andCallbackAddressIn(List<String> values) {
            addCriterion("CALLBACK_ADDRESS in", values, "callbackAddress");
            return (Criteria) this;
        }

        public Criteria andCallbackAddressNotIn(List<String> values) {
            addCriterion("CALLBACK_ADDRESS not in", values, "callbackAddress");
            return (Criteria) this;
        }

        public Criteria andCallbackAddressBetween(String value1, String value2) {
            addCriterion("CALLBACK_ADDRESS between", value1, value2, "callbackAddress");
            return (Criteria) this;
        }

        public Criteria andCallbackAddressNotBetween(String value1, String value2) {
            addCriterion("CALLBACK_ADDRESS not between", value1, value2, "callbackAddress");
            return (Criteria) this;
        }

        public Criteria andMemoIsNull() {
            addCriterion("MEMO is null");
            return (Criteria) this;
        }

        public Criteria andMemoIsNotNull() {
            addCriterion("MEMO is not null");
            return (Criteria) this;
        }

        public Criteria andMemoEqualTo(String value) {
            addCriterion("MEMO =", value, "memo");
            return (Criteria) this;
        }

        public Criteria andMemoNotEqualTo(String value) {
            addCriterion("MEMO <>", value, "memo");
            return (Criteria) this;
        }

        public Criteria andMemoGreaterThan(String value) {
            addCriterion("MEMO >", value, "memo");
            return (Criteria) this;
        }

        public Criteria andMemoGreaterThanOrEqualTo(String value) {
            addCriterion("MEMO >=", value, "memo");
            return (Criteria) this;
        }

        public Criteria andMemoLessThan(String value) {
            addCriterion("MEMO <", value, "memo");
            return (Criteria) this;
        }

        public Criteria andMemoLessThanOrEqualTo(String value) {
            addCriterion("MEMO <=", value, "memo");
            return (Criteria) this;
        }

        public Criteria andMemoLike(String value) {
            addCriterion("MEMO like", value, "memo");
            return (Criteria) this;
        }

        public Criteria andMemoNotLike(String value) {
            addCriterion("MEMO not like", value, "memo");
            return (Criteria) this;
        }

        public Criteria andMemoIn(List<String> values) {
            addCriterion("MEMO in", values, "memo");
            return (Criteria) this;
        }

        public Criteria andMemoNotIn(List<String> values) {
            addCriterion("MEMO not in", values, "memo");
            return (Criteria) this;
        }

        public Criteria andMemoBetween(String value1, String value2) {
            addCriterion("MEMO between", value1, value2, "memo");
            return (Criteria) this;
        }

        public Criteria andMemoNotBetween(String value1, String value2) {
            addCriterion("MEMO not between", value1, value2, "memo");
            return (Criteria) this;
        }

        public Criteria andIsPemitPricingErrIsNull() {
            addCriterion("IS_PEMIT_PRICING_ERR is null");
            return (Criteria) this;
        }

        public Criteria andIsPemitPricingErrIsNotNull() {
            addCriterion("IS_PEMIT_PRICING_ERR is not null");
            return (Criteria) this;
        }

        public Criteria andIsPemitPricingErrEqualTo(String value) {
            addCriterion("IS_PEMIT_PRICING_ERR =", value, "isPemitPricingErr");
            return (Criteria) this;
        }

        public Criteria andIsPemitPricingErrNotEqualTo(String value) {
            addCriterion("IS_PEMIT_PRICING_ERR <>", value, "isPemitPricingErr");
            return (Criteria) this;
        }

        public Criteria andIsPemitPricingErrGreaterThan(String value) {
            addCriterion("IS_PEMIT_PRICING_ERR >", value, "isPemitPricingErr");
            return (Criteria) this;
        }

        public Criteria andIsPemitPricingErrGreaterThanOrEqualTo(String value) {
            addCriterion("IS_PEMIT_PRICING_ERR >=", value, "isPemitPricingErr");
            return (Criteria) this;
        }

        public Criteria andIsPemitPricingErrLessThan(String value) {
            addCriterion("IS_PEMIT_PRICING_ERR <", value, "isPemitPricingErr");
            return (Criteria) this;
        }

        public Criteria andIsPemitPricingErrLessThanOrEqualTo(String value) {
            addCriterion("IS_PEMIT_PRICING_ERR <=", value, "isPemitPricingErr");
            return (Criteria) this;
        }

        public Criteria andIsPemitPricingErrLike(String value) {
            addCriterion("IS_PEMIT_PRICING_ERR like", value, "isPemitPricingErr");
            return (Criteria) this;
        }

        public Criteria andIsPemitPricingErrNotLike(String value) {
            addCriterion("IS_PEMIT_PRICING_ERR not like", value, "isPemitPricingErr");
            return (Criteria) this;
        }

        public Criteria andIsPemitPricingErrIn(List<String> values) {
            addCriterion("IS_PEMIT_PRICING_ERR in", values, "isPemitPricingErr");
            return (Criteria) this;
        }

        public Criteria andIsPemitPricingErrNotIn(List<String> values) {
            addCriterion("IS_PEMIT_PRICING_ERR not in", values, "isPemitPricingErr");
            return (Criteria) this;
        }

        public Criteria andIsPemitPricingErrBetween(String value1, String value2) {
            addCriterion("IS_PEMIT_PRICING_ERR between", value1, value2, "isPemitPricingErr");
            return (Criteria) this;
        }

        public Criteria andIsPemitPricingErrNotBetween(String value1, String value2) {
            addCriterion("IS_PEMIT_PRICING_ERR not between", value1, value2, "isPemitPricingErr");
            return (Criteria) this;
        }

        public Criteria andCurrencyIsNull() {
            addCriterion("CURRENCY is null");
            return (Criteria) this;
        }

        public Criteria andCurrencyIsNotNull() {
            addCriterion("CURRENCY is not null");
            return (Criteria) this;
        }

        public Criteria andCurrencyEqualTo(String value) {
            addCriterion("CURRENCY =", value, "currency");
            return (Criteria) this;
        }

        public Criteria andCurrencyNotEqualTo(String value) {
            addCriterion("CURRENCY <>", value, "currency");
            return (Criteria) this;
        }

        public Criteria andCurrencyGreaterThan(String value) {
            addCriterion("CURRENCY >", value, "currency");
            return (Criteria) this;
        }

        public Criteria andCurrencyGreaterThanOrEqualTo(String value) {
            addCriterion("CURRENCY >=", value, "currency");
            return (Criteria) this;
        }

        public Criteria andCurrencyLessThan(String value) {
            addCriterion("CURRENCY <", value, "currency");
            return (Criteria) this;
        }

        public Criteria andCurrencyLessThanOrEqualTo(String value) {
            addCriterion("CURRENCY <=", value, "currency");
            return (Criteria) this;
        }

        public Criteria andCurrencyLike(String value) {
            addCriterion("CURRENCY like", value, "currency");
            return (Criteria) this;
        }

        public Criteria andCurrencyNotLike(String value) {
            addCriterion("CURRENCY not like", value, "currency");
            return (Criteria) this;
        }

        public Criteria andCurrencyIn(List<String> values) {
            addCriterion("CURRENCY in", values, "currency");
            return (Criteria) this;
        }

        public Criteria andCurrencyNotIn(List<String> values) {
            addCriterion("CURRENCY not in", values, "currency");
            return (Criteria) this;
        }

        public Criteria andCurrencyBetween(String value1, String value2) {
            addCriterion("CURRENCY between", value1, value2, "currency");
            return (Criteria) this;
        }

        public Criteria andCurrencyNotBetween(String value1, String value2) {
            addCriterion("CURRENCY not between", value1, value2, "currency");
            return (Criteria) this;
        }

        public Criteria andPaymentSeqNoIsNull() {
            addCriterion("PAYMENT_SEQ_NO is null");
            return (Criteria) this;
        }

        public Criteria andPaymentSeqNoIsNotNull() {
            addCriterion("PAYMENT_SEQ_NO is not null");
            return (Criteria) this;
        }

        public Criteria andPaymentSeqNoEqualTo(String value) {
            addCriterion("PAYMENT_SEQ_NO =", value, "paymentSeqNo");
            return (Criteria) this;
        }

        public Criteria andPaymentSeqNoNotEqualTo(String value) {
            addCriterion("PAYMENT_SEQ_NO <>", value, "paymentSeqNo");
            return (Criteria) this;
        }

        public Criteria andPaymentSeqNoGreaterThan(String value) {
            addCriterion("PAYMENT_SEQ_NO >", value, "paymentSeqNo");
            return (Criteria) this;
        }

        public Criteria andPaymentSeqNoGreaterThanOrEqualTo(String value) {
            addCriterion("PAYMENT_SEQ_NO >=", value, "paymentSeqNo");
            return (Criteria) this;
        }

        public Criteria andPaymentSeqNoLessThan(String value) {
            addCriterion("PAYMENT_SEQ_NO <", value, "paymentSeqNo");
            return (Criteria) this;
        }

        public Criteria andPaymentSeqNoLessThanOrEqualTo(String value) {
            addCriterion("PAYMENT_SEQ_NO <=", value, "paymentSeqNo");
            return (Criteria) this;
        }

        public Criteria andPaymentSeqNoLike(String value) {
            addCriterion("PAYMENT_SEQ_NO like", value, "paymentSeqNo");
            return (Criteria) this;
        }

        public Criteria andPaymentSeqNoNotLike(String value) {
            addCriterion("PAYMENT_SEQ_NO not like", value, "paymentSeqNo");
            return (Criteria) this;
        }

        public Criteria andPaymentSeqNoIn(List<String> values) {
            addCriterion("PAYMENT_SEQ_NO in", values, "paymentSeqNo");
            return (Criteria) this;
        }

        public Criteria andPaymentSeqNoNotIn(List<String> values) {
            addCriterion("PAYMENT_SEQ_NO not in", values, "paymentSeqNo");
            return (Criteria) this;
        }

        public Criteria andPaymentSeqNoBetween(String value1, String value2) {
            addCriterion("PAYMENT_SEQ_NO between", value1, value2, "paymentSeqNo");
            return (Criteria) this;
        }

        public Criteria andPaymentSeqNoNotBetween(String value1, String value2) {
            addCriterion("PAYMENT_SEQ_NO not between", value1, value2, "paymentSeqNo");
            return (Criteria) this;
        }

        public Criteria andPocketAmountIsNull() {
            addCriterion("POCKET_AMOUNT is null");
            return (Criteria) this;
        }

        public Criteria andPocketAmountIsNotNull() {
            addCriterion("POCKET_AMOUNT is not null");
            return (Criteria) this;
        }

        public Criteria andPocketAmountEqualTo(String value) {
            addCriterion("POCKET_AMOUNT =", value, "pocketAmount");
            return (Criteria) this;
        }

        public Criteria andPocketAmountNotEqualTo(String value) {
            addCriterion("POCKET_AMOUNT <>", value, "pocketAmount");
            return (Criteria) this;
        }

        public Criteria andPocketAmountGreaterThan(String value) {
            addCriterion("POCKET_AMOUNT >", value, "pocketAmount");
            return (Criteria) this;
        }

        public Criteria andPocketAmountGreaterThanOrEqualTo(String value) {
            addCriterion("POCKET_AMOUNT >=", value, "pocketAmount");
            return (Criteria) this;
        }

        public Criteria andPocketAmountLessThan(String value) {
            addCriterion("POCKET_AMOUNT <", value, "pocketAmount");
            return (Criteria) this;
        }

        public Criteria andPocketAmountLessThanOrEqualTo(String value) {
            addCriterion("POCKET_AMOUNT <=", value, "pocketAmount");
            return (Criteria) this;
        }

        public Criteria andPocketAmountLike(String value) {
            addCriterion("POCKET_AMOUNT like", value, "pocketAmount");
            return (Criteria) this;
        }

        public Criteria andPocketAmountNotLike(String value) {
            addCriterion("POCKET_AMOUNT not like", value, "pocketAmount");
            return (Criteria) this;
        }

        public Criteria andPocketAmountIn(List<String> values) {
            addCriterion("POCKET_AMOUNT in", values, "pocketAmount");
            return (Criteria) this;
        }

        public Criteria andPocketAmountNotIn(List<String> values) {
            addCriterion("POCKET_AMOUNT not in", values, "pocketAmount");
            return (Criteria) this;
        }

        public Criteria andPocketAmountBetween(String value1, String value2) {
            addCriterion("POCKET_AMOUNT between", value1, value2, "pocketAmount");
            return (Criteria) this;
        }

        public Criteria andPocketAmountNotBetween(String value1, String value2) {
            addCriterion("POCKET_AMOUNT not between", value1, value2, "pocketAmount");
            return (Criteria) this;
        }

        public Criteria andSettlementTimeIsNull() {
            addCriterion("SETTLEMENT_TIME is null");
            return (Criteria) this;
        }

        public Criteria andSettlementTimeIsNotNull() {
            addCriterion("SETTLEMENT_TIME is not null");
            return (Criteria) this;
        }

        public Criteria andSettlementTimeEqualTo(String value) {
            addCriterion("SETTLEMENT_TIME =", value, "settlementTime");
            return (Criteria) this;
        }

        public Criteria andSettlementTimeNotEqualTo(String value) {
            addCriterion("SETTLEMENT_TIME <>", value, "settlementTime");
            return (Criteria) this;
        }

        public Criteria andSettlementTimeGreaterThan(String value) {
            addCriterion("SETTLEMENT_TIME >", value, "settlementTime");
            return (Criteria) this;
        }

        public Criteria andSettlementTimeGreaterThanOrEqualTo(String value) {
            addCriterion("SETTLEMENT_TIME >=", value, "settlementTime");
            return (Criteria) this;
        }

        public Criteria andSettlementTimeLessThan(String value) {
            addCriterion("SETTLEMENT_TIME <", value, "settlementTime");
            return (Criteria) this;
        }

        public Criteria andSettlementTimeLessThanOrEqualTo(String value) {
            addCriterion("SETTLEMENT_TIME <=", value, "settlementTime");
            return (Criteria) this;
        }

        public Criteria andSettlementTimeLike(String value) {
            addCriterion("SETTLEMENT_TIME like", value, "settlementTime");
            return (Criteria) this;
        }

        public Criteria andSettlementTimeNotLike(String value) {
            addCriterion("SETTLEMENT_TIME not like", value, "settlementTime");
            return (Criteria) this;
        }

        public Criteria andSettlementTimeIn(List<String> values) {
            addCriterion("SETTLEMENT_TIME in", values, "settlementTime");
            return (Criteria) this;
        }

        public Criteria andSettlementTimeNotIn(List<String> values) {
            addCriterion("SETTLEMENT_TIME not in", values, "settlementTime");
            return (Criteria) this;
        }

        public Criteria andSettlementTimeBetween(String value1, String value2) {
            addCriterion("SETTLEMENT_TIME between", value1, value2, "settlementTime");
            return (Criteria) this;
        }

        public Criteria andSettlementTimeNotBetween(String value1, String value2) {
            addCriterion("SETTLEMENT_TIME not between", value1, value2, "settlementTime");
            return (Criteria) this;
        }

        public Criteria andReturnCodeIsNull() {
            addCriterion("RETURN_CODE is null");
            return (Criteria) this;
        }

        public Criteria andReturnCodeIsNotNull() {
            addCriterion("RETURN_CODE is not null");
            return (Criteria) this;
        }

        public Criteria andReturnCodeEqualTo(String value) {
            addCriterion("RETURN_CODE =", value, "returnCode");
            return (Criteria) this;
        }

        public Criteria andReturnCodeNotEqualTo(String value) {
            addCriterion("RETURN_CODE <>", value, "returnCode");
            return (Criteria) this;
        }

        public Criteria andReturnCodeGreaterThan(String value) {
            addCriterion("RETURN_CODE >", value, "returnCode");
            return (Criteria) this;
        }

        public Criteria andReturnCodeGreaterThanOrEqualTo(String value) {
            addCriterion("RETURN_CODE >=", value, "returnCode");
            return (Criteria) this;
        }

        public Criteria andReturnCodeLessThan(String value) {
            addCriterion("RETURN_CODE <", value, "returnCode");
            return (Criteria) this;
        }

        public Criteria andReturnCodeLessThanOrEqualTo(String value) {
            addCriterion("RETURN_CODE <=", value, "returnCode");
            return (Criteria) this;
        }

        public Criteria andReturnCodeLike(String value) {
            addCriterion("RETURN_CODE like", value, "returnCode");
            return (Criteria) this;
        }

        public Criteria andReturnCodeNotLike(String value) {
            addCriterion("RETURN_CODE not like", value, "returnCode");
            return (Criteria) this;
        }

        public Criteria andReturnCodeIn(List<String> values) {
            addCriterion("RETURN_CODE in", values, "returnCode");
            return (Criteria) this;
        }

        public Criteria andReturnCodeNotIn(List<String> values) {
            addCriterion("RETURN_CODE not in", values, "returnCode");
            return (Criteria) this;
        }

        public Criteria andReturnCodeBetween(String value1, String value2) {
            addCriterion("RETURN_CODE between", value1, value2, "returnCode");
            return (Criteria) this;
        }

        public Criteria andReturnCodeNotBetween(String value1, String value2) {
            addCriterion("RETURN_CODE not between", value1, value2, "returnCode");
            return (Criteria) this;
        }

        public Criteria andReturnMsgIsNull() {
            addCriterion("RETURN_MSG is null");
            return (Criteria) this;
        }

        public Criteria andReturnMsgIsNotNull() {
            addCriterion("RETURN_MSG is not null");
            return (Criteria) this;
        }

        public Criteria andReturnMsgEqualTo(String value) {
            addCriterion("RETURN_MSG =", value, "returnMsg");
            return (Criteria) this;
        }

        public Criteria andReturnMsgNotEqualTo(String value) {
            addCriterion("RETURN_MSG <>", value, "returnMsg");
            return (Criteria) this;
        }

        public Criteria andReturnMsgGreaterThan(String value) {
            addCriterion("RETURN_MSG >", value, "returnMsg");
            return (Criteria) this;
        }

        public Criteria andReturnMsgGreaterThanOrEqualTo(String value) {
            addCriterion("RETURN_MSG >=", value, "returnMsg");
            return (Criteria) this;
        }

        public Criteria andReturnMsgLessThan(String value) {
            addCriterion("RETURN_MSG <", value, "returnMsg");
            return (Criteria) this;
        }

        public Criteria andReturnMsgLessThanOrEqualTo(String value) {
            addCriterion("RETURN_MSG <=", value, "returnMsg");
            return (Criteria) this;
        }

        public Criteria andReturnMsgLike(String value) {
            addCriterion("RETURN_MSG like", value, "returnMsg");
            return (Criteria) this;
        }

        public Criteria andReturnMsgNotLike(String value) {
            addCriterion("RETURN_MSG not like", value, "returnMsg");
            return (Criteria) this;
        }

        public Criteria andReturnMsgIn(List<String> values) {
            addCriterion("RETURN_MSG in", values, "returnMsg");
            return (Criteria) this;
        }

        public Criteria andReturnMsgNotIn(List<String> values) {
            addCriterion("RETURN_MSG not in", values, "returnMsg");
            return (Criteria) this;
        }

        public Criteria andReturnMsgBetween(String value1, String value2) {
            addCriterion("RETURN_MSG between", value1, value2, "returnMsg");
            return (Criteria) this;
        }

        public Criteria andReturnMsgNotBetween(String value1, String value2) {
            addCriterion("RETURN_MSG not between", value1, value2, "returnMsg");
            return (Criteria) this;
        }

        public Criteria andExtentionIsNull() {
            addCriterion("EXTENTION is null");
            return (Criteria) this;
        }

        public Criteria andExtentionIsNotNull() {
            addCriterion("EXTENTION is not null");
            return (Criteria) this;
        }

        public Criteria andExtentionEqualTo(String value) {
            addCriterion("EXTENTION =", value, "extention");
            return (Criteria) this;
        }

        public Criteria andExtentionNotEqualTo(String value) {
            addCriterion("EXTENTION <>", value, "extention");
            return (Criteria) this;
        }

        public Criteria andExtentionGreaterThan(String value) {
            addCriterion("EXTENTION >", value, "extention");
            return (Criteria) this;
        }

        public Criteria andExtentionGreaterThanOrEqualTo(String value) {
            addCriterion("EXTENTION >=", value, "extention");
            return (Criteria) this;
        }

        public Criteria andExtentionLessThan(String value) {
            addCriterion("EXTENTION <", value, "extention");
            return (Criteria) this;
        }

        public Criteria andExtentionLessThanOrEqualTo(String value) {
            addCriterion("EXTENTION <=", value, "extention");
            return (Criteria) this;
        }

        public Criteria andExtentionLike(String value) {
            addCriterion("EXTENTION like", value, "extention");
            return (Criteria) this;
        }

        public Criteria andExtentionNotLike(String value) {
            addCriterion("EXTENTION not like", value, "extention");
            return (Criteria) this;
        }

        public Criteria andExtentionIn(List<String> values) {
            addCriterion("EXTENTION in", values, "extention");
            return (Criteria) this;
        }

        public Criteria andExtentionNotIn(List<String> values) {
            addCriterion("EXTENTION not in", values, "extention");
            return (Criteria) this;
        }

        public Criteria andExtentionBetween(String value1, String value2) {
            addCriterion("EXTENTION between", value1, value2, "extention");
            return (Criteria) this;
        }

        public Criteria andExtentionNotBetween(String value1, String value2) {
            addCriterion("EXTENTION not between", value1, value2, "extention");
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

        public Criteria andBatchNoIsNull() {
            addCriterion("BATCH_NO is null");
            return (Criteria) this;
        }

        public Criteria andBatchNoIsNotNull() {
            addCriterion("BATCH_NO is not null");
            return (Criteria) this;
        }

        public Criteria andBatchNoEqualTo(String value) {
            addCriterion("BATCH_NO =", value, "batchNo");
            return (Criteria) this;
        }

        public Criteria andBatchNoNotEqualTo(String value) {
            addCriterion("BATCH_NO <>", value, "batchNo");
            return (Criteria) this;
        }

        public Criteria andBatchNoGreaterThan(String value) {
            addCriterion("BATCH_NO >", value, "batchNo");
            return (Criteria) this;
        }

        public Criteria andBatchNoGreaterThanOrEqualTo(String value) {
            addCriterion("BATCH_NO >=", value, "batchNo");
            return (Criteria) this;
        }

        public Criteria andBatchNoLessThan(String value) {
            addCriterion("BATCH_NO <", value, "batchNo");
            return (Criteria) this;
        }

        public Criteria andBatchNoLessThanOrEqualTo(String value) {
            addCriterion("BATCH_NO <=", value, "batchNo");
            return (Criteria) this;
        }

        public Criteria andBatchNoLike(String value) {
            addCriterion("BATCH_NO like", value, "batchNo");
            return (Criteria) this;
        }

        public Criteria andBatchNoNotLike(String value) {
            addCriterion("BATCH_NO not like", value, "batchNo");
            return (Criteria) this;
        }

        public Criteria andBatchNoIn(List<String> values) {
            addCriterion("BATCH_NO in", values, "batchNo");
            return (Criteria) this;
        }

        public Criteria andBatchNoNotIn(List<String> values) {
            addCriterion("BATCH_NO not in", values, "batchNo");
            return (Criteria) this;
        }

        public Criteria andBatchNoBetween(String value1, String value2) {
            addCriterion("BATCH_NO between", value1, value2, "batchNo");
            return (Criteria) this;
        }

        public Criteria andBatchNoNotBetween(String value1, String value2) {
            addCriterion("BATCH_NO not between", value1, value2, "batchNo");
            return (Criteria) this;
        }

        public Criteria andPayeeAccountTypeIsNull() {
            addCriterion("PAYEE_ACCOUNT_TYPE is null");
            return (Criteria) this;
        }

        public Criteria andPayeeAccountTypeIsNotNull() {
            addCriterion("PAYEE_ACCOUNT_TYPE is not null");
            return (Criteria) this;
        }

        public Criteria andPayeeAccountTypeEqualTo(String value) {
            addCriterion("PAYEE_ACCOUNT_TYPE =", value, "payeeAccountType");
            return (Criteria) this;
        }

        public Criteria andPayeeAccountTypeNotEqualTo(String value) {
            addCriterion("PAYEE_ACCOUNT_TYPE <>", value, "payeeAccountType");
            return (Criteria) this;
        }

        public Criteria andPayeeAccountTypeGreaterThan(String value) {
            addCriterion("PAYEE_ACCOUNT_TYPE >", value, "payeeAccountType");
            return (Criteria) this;
        }

        public Criteria andPayeeAccountTypeGreaterThanOrEqualTo(String value) {
            addCriterion("PAYEE_ACCOUNT_TYPE >=", value, "payeeAccountType");
            return (Criteria) this;
        }

        public Criteria andPayeeAccountTypeLessThan(String value) {
            addCriterion("PAYEE_ACCOUNT_TYPE <", value, "payeeAccountType");
            return (Criteria) this;
        }

        public Criteria andPayeeAccountTypeLessThanOrEqualTo(String value) {
            addCriterion("PAYEE_ACCOUNT_TYPE <=", value, "payeeAccountType");
            return (Criteria) this;
        }

        public Criteria andPayeeAccountTypeLike(String value) {
            addCriterion("PAYEE_ACCOUNT_TYPE like", value, "payeeAccountType");
            return (Criteria) this;
        }

        public Criteria andPayeeAccountTypeNotLike(String value) {
            addCriterion("PAYEE_ACCOUNT_TYPE not like", value, "payeeAccountType");
            return (Criteria) this;
        }

        public Criteria andPayeeAccountTypeIn(List<String> values) {
            addCriterion("PAYEE_ACCOUNT_TYPE in", values, "payeeAccountType");
            return (Criteria) this;
        }

        public Criteria andPayeeAccountTypeNotIn(List<String> values) {
            addCriterion("PAYEE_ACCOUNT_TYPE not in", values, "payeeAccountType");
            return (Criteria) this;
        }

        public Criteria andPayeeAccountTypeBetween(String value1, String value2) {
            addCriterion("PAYEE_ACCOUNT_TYPE between", value1, value2, "payeeAccountType");
            return (Criteria) this;
        }

        public Criteria andPayeeAccountTypeNotBetween(String value1, String value2) {
            addCriterion("PAYEE_ACCOUNT_TYPE not between", value1, value2, "payeeAccountType");
            return (Criteria) this;
        }
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table TB_MARGIN_TRANS
     *
     * @mbggenerated do_not_delete_during_merge Wed Jun 03 18:04:23 CST 2015
     */
    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table TB_MARGIN_TRANS
     * table comment :保证金转账记录
     *
     * @mbggenerated Wed Jun 03 18:04:23 CST 2015
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