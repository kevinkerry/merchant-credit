package com.sdp.withdraw.dao;

import com.sdp.emall.common.dao.BaseDO;
import java.math.BigDecimal;
import java.util.Date;

public class WithdrawReqFosDetailDO extends BaseDO {
    /**
     * This field corresponds to the database column FW_WITHDRAW_REQ_FOS_DETAIL.DETAIL_ID
     * column comments 主键
     *
     * @mbggenerated Fri Mar 11 19:55:35 CST 2016
     */
    private Long detailId;

    /**
     * This field corresponds to the database column FW_WITHDRAW_REQ_FOS_DETAIL.REQ_ID
     * column comments 业务请求的ID
     *
     * @mbggenerated Fri Mar 11 19:55:35 CST 2016
     */
    private Long reqId;

    /**
     * This field corresponds to the database column FW_WITHDRAW_REQ_FOS_DETAIL.PRODUCT_CODE
     * column comments 产品编码
     *
     * @mbggenerated Fri Mar 11 19:55:35 CST 2016
     */
    private String productCode;

    /**
     * This field corresponds to the database column FW_WITHDRAW_REQ_FOS_DETAIL.PAYMENT_CODE
     * column comments 支付编码
     *
     * @mbggenerated Fri Mar 11 19:55:35 CST 2016
     */
    private String paymentCode;

    /**
     * This field corresponds to the database column FW_WITHDRAW_REQ_FOS_DETAIL.REMIT_VOUCHER_NO
     * column comments 请求的业务订单号
     *
     * @mbggenerated Fri Mar 11 19:55:35 CST 2016
     */
    private String remitVoucherNo;

    /**
     * This field corresponds to the database column FW_WITHDRAW_REQ_FOS_DETAIL.PAYER_MEMBER_ID
     * column comments 会员ID
     *
     * @mbggenerated Fri Mar 11 19:55:35 CST 2016
     */
    private String payerMemberId;

    /**
     * This field corresponds to the database column FW_WITHDRAW_REQ_FOS_DETAIL.IS_NEED_COUNT_FEE
     * column comments 是否需要计费 1：计费；0：不计费  
     *
     * @mbggenerated Fri Mar 11 19:55:35 CST 2016
     */
    private Integer isNeedCountFee;

    /**
     * This field corresponds to the database column FW_WITHDRAW_REQ_FOS_DETAIL.PAYER_FEE
     * column comments 付款人费用
     *
     * @mbggenerated Fri Mar 11 19:55:35 CST 2016
     */
    private BigDecimal payerFee;

    /**
     * This field corresponds to the database column FW_WITHDRAW_REQ_FOS_DETAIL.PAYEE_FEE
     * column comments 收款人费用
     *
     * @mbggenerated Fri Mar 11 19:55:35 CST 2016
     */
    private BigDecimal payeeFee;

    /**
     * This field corresponds to the database column FW_WITHDRAW_REQ_FOS_DETAIL.IS_PERMIT_PRICING_ERR
     * column comments 是否允许计费异常
     *
     * @mbggenerated Fri Mar 11 19:55:35 CST 2016
     */
    private Integer isPermitPricingErr;

    /**
     * This field corresponds to the database column FW_WITHDRAW_REQ_FOS_DETAIL.PAYER_ACCOUNT_NO
     * column comments 付款人储值账户ID 
     *
     * @mbggenerated Fri Mar 11 19:55:35 CST 2016
     */
    private String payerAccountNo;

    /**
     * This field corresponds to the database column FW_WITHDRAW_REQ_FOS_DETAIL.BANK_CODE
     * column comments 开户行 
     *
     * @mbggenerated Fri Mar 11 19:55:35 CST 2016
     */
    private String bankCode;

    /**
     * This field corresponds to the database column FW_WITHDRAW_REQ_FOS_DETAIL.BANK_NAME
     * column comments 开户行名称 
     *
     * @mbggenerated Fri Mar 11 19:55:35 CST 2016
     */
    private String bankName;

    /**
     * This field corresponds to the database column FW_WITHDRAW_REQ_FOS_DETAIL.BANK_BRANCH
     * column comments 支行名称
     *
     * @mbggenerated Fri Mar 11 19:55:35 CST 2016
     */
    private String bankBranch;

    /**
     * This field corresponds to the database column FW_WITHDRAW_REQ_FOS_DETAIL.BANK_LINENO
     * column comments 支行编码(联行号)
     *
     * @mbggenerated Fri Mar 11 19:55:35 CST 2016
     */
    private String bankLineno;

    /**
     * This field corresponds to the database column FW_WITHDRAW_REQ_FOS_DETAIL.BANK_PROVINCE
     * column comments 银行所属省份 
     *
     * @mbggenerated Fri Mar 11 19:55:35 CST 2016
     */
    private String bankProvince;

    /**
     * This field corresponds to the database column FW_WITHDRAW_REQ_FOS_DETAIL.BANK_CITY
     * column comments 银行所属城市
     *
     * @mbggenerated Fri Mar 11 19:55:35 CST 2016
     */
    private String bankCity;

    /**
     * This field corresponds to the database column FW_WITHDRAW_REQ_FOS_DETAIL.PAYEE_NAME
     * column comments 收款人姓名
     *
     * @mbggenerated Fri Mar 11 19:55:35 CST 2016
     */
    private String payeeName;

    /**
     * This field corresponds to the database column FW_WITHDRAW_REQ_FOS_DETAIL.PAYEE_CARD_NO
     * column comments 收款人卡号
     *
     * @mbggenerated Fri Mar 11 19:55:35 CST 2016
     */
    private String payeeCardNo;

    /**
     * This field corresponds to the database column FW_WITHDRAW_REQ_FOS_DETAIL.PAYEE_PURPOSE
     * column comments 用途
     *
     * @mbggenerated Fri Mar 11 19:55:35 CST 2016
     */
    private String payeePurpose;

    /**
     * This field corresponds to the database column FW_WITHDRAW_REQ_FOS_DETAIL.CARD_TYPE
     * column comments 卡类型
     *
     * @mbggenerated Fri Mar 11 19:55:35 CST 2016
     */
    private String cardType;

    /**
     * This field corresponds to the database column FW_WITHDRAW_REQ_FOS_DETAIL.COMPANY_OR_PERSONAL
     * column comments 账户类型
     *
     * @mbggenerated Fri Mar 11 19:55:35 CST 2016
     */
    private String companyOrPersonal;

    /**
     * This field corresponds to the database column FW_WITHDRAW_REQ_FOS_DETAIL.GMT_BIZ_INITIATE
     * column comments 业务发起时间
     *
     * @mbggenerated Fri Mar 11 19:55:35 CST 2016
     */
    private Date gmtBizInitiate;

    /**
     * This field corresponds to the database column FW_WITHDRAW_REQ_FOS_DETAIL.GMT_PAYMENT_INITIATE
     * column comments 支付发起时间
     *
     * @mbggenerated Fri Mar 11 19:55:35 CST 2016
     */
    private Date gmtPaymentInitiate;

    /**
     * This field corresponds to the database column FW_WITHDRAW_REQ_FOS_DETAIL.REMIT_AMOUNT
     * column comments 出款金额 
     *
     * @mbggenerated Fri Mar 11 19:55:35 CST 2016
     */
    private BigDecimal remitAmount;

    /**
     * This field corresponds to the database column FW_WITHDRAW_REQ_FOS_DETAIL.CALLBACK_ADDRESS
     * column comments 回掉地址
     *
     * @mbggenerated Fri Mar 11 19:55:35 CST 2016
     */
    private String callbackAddress;

    /**
     * This field corresponds to the database column FW_WITHDRAW_REQ_FOS_DETAIL.MEMO
     * column comments 备注信息
     *
     * @mbggenerated Fri Mar 11 19:55:35 CST 2016
     */
    private String memo;

    /**
     * This field corresponds to the database column FW_WITHDRAW_REQ_FOS_DETAIL.CURRENCY
     * column comments 币种不传默认为CNY
     *
     * @mbggenerated Fri Mar 11 19:55:35 CST 2016
     */
    private String currency;

    /**
     * This field corresponds to the database column FW_WITHDRAW_REQ_FOS_DETAIL.REQ_EXTENTION
     * column comments 扩展信息
     *
     * @mbggenerated Fri Mar 11 19:55:35 CST 2016
     */
    private String reqExtention;

    /**
     * This field corresponds to the database column FW_WITHDRAW_REQ_FOS_DETAIL.WITHDRAW_STATUS
     * column comments 批次处理状态
     *
     * @mbggenerated Fri Mar 11 19:55:35 CST 2016
     */
    private String withdrawStatus;

    /**
     * This field corresponds to the database column FW_WITHDRAW_REQ_FOS_DETAIL.RETURN_CODE
     * column comments 返回错误码 
     *
     * @mbggenerated Fri Mar 11 19:55:35 CST 2016
     */
    private String returnCode;

    /**
     * This field corresponds to the database column FW_WITHDRAW_REQ_FOS_DETAIL.RETURN_MSG
     * column comments 返回错误信息
     *
     * @mbggenerated Fri Mar 11 19:55:35 CST 2016
     */
    private String returnMsg;

    /**
     * This field corresponds to the database column FW_WITHDRAW_REQ_FOS_DETAIL.EXTENTION
     * column comments 返回扩展信息
     *
     * @mbggenerated Fri Mar 11 19:55:35 CST 2016
     */
    private String extention;

    /**
     * This field corresponds to the database column FW_WITHDRAW_REQ_FOS_DETAIL.CREATE_TIME
     * column comments 创建时间
     *
     * @mbggenerated Fri Mar 11 19:55:35 CST 2016
     */
    private Date createTime;

    /**
     * This field corresponds to the database column FW_WITHDRAW_REQ_FOS_DETAIL.UPDATE_TIME
     * column comments 最后修改时间
     *
     * @mbggenerated Fri Mar 11 19:55:35 CST 2016
     */
    private Date updateTime;

    /**
     * This method returns the value of the database column FW_WITHDRAW_REQ_FOS_DETAIL.DETAIL_ID
     *
     * @return the value of FW_WITHDRAW_REQ_FOS_DETAIL.DETAIL_ID
     * column comments 主键
     *
     * @mbggenerated Fri Mar 11 19:55:35 CST 2016
     */
    public Long getDetailId() {
        return detailId;
    }

    /**
     * This method sets the value of the database column FW_WITHDRAW_REQ_FOS_DETAIL.DETAIL_ID
     *
     * @param detailId the value for FW_WITHDRAW_REQ_FOS_DETAIL.DETAIL_ID
     * column comments 主键
     *
     * @mbggenerated Fri Mar 11 19:55:35 CST 2016
     */
    public void setDetailId(Long detailId) {
        this.detailId = detailId;
    }

    /**
     * This method returns the value of the database column FW_WITHDRAW_REQ_FOS_DETAIL.REQ_ID
     *
     * @return the value of FW_WITHDRAW_REQ_FOS_DETAIL.REQ_ID
     * column comments 业务请求的ID
     *
     * @mbggenerated Fri Mar 11 19:55:35 CST 2016
     */
    public Long getReqId() {
        return reqId;
    }

    /**
     * This method sets the value of the database column FW_WITHDRAW_REQ_FOS_DETAIL.REQ_ID
     *
     * @param reqId the value for FW_WITHDRAW_REQ_FOS_DETAIL.REQ_ID
     * column comments 业务请求的ID
     *
     * @mbggenerated Fri Mar 11 19:55:35 CST 2016
     */
    public void setReqId(Long reqId) {
        this.reqId = reqId;
    }

    /**
     * This method returns the value of the database column FW_WITHDRAW_REQ_FOS_DETAIL.PRODUCT_CODE
     *
     * @return the value of FW_WITHDRAW_REQ_FOS_DETAIL.PRODUCT_CODE
     * column comments 产品编码
     *
     * @mbggenerated Fri Mar 11 19:55:35 CST 2016
     */
    public String getProductCode() {
        return productCode;
    }

    /**
     * This method sets the value of the database column FW_WITHDRAW_REQ_FOS_DETAIL.PRODUCT_CODE
     *
     * @param productCode the value for FW_WITHDRAW_REQ_FOS_DETAIL.PRODUCT_CODE
     * column comments 产品编码
     *
     * @mbggenerated Fri Mar 11 19:55:35 CST 2016
     */
    public void setProductCode(String productCode) {
        this.productCode = productCode == null ? null : productCode.trim();
    }

    /**
     * This method returns the value of the database column FW_WITHDRAW_REQ_FOS_DETAIL.PAYMENT_CODE
     *
     * @return the value of FW_WITHDRAW_REQ_FOS_DETAIL.PAYMENT_CODE
     * column comments 支付编码
     *
     * @mbggenerated Fri Mar 11 19:55:35 CST 2016
     */
    public String getPaymentCode() {
        return paymentCode;
    }

    /**
     * This method sets the value of the database column FW_WITHDRAW_REQ_FOS_DETAIL.PAYMENT_CODE
     *
     * @param paymentCode the value for FW_WITHDRAW_REQ_FOS_DETAIL.PAYMENT_CODE
     * column comments 支付编码
     *
     * @mbggenerated Fri Mar 11 19:55:35 CST 2016
     */
    public void setPaymentCode(String paymentCode) {
        this.paymentCode = paymentCode == null ? null : paymentCode.trim();
    }

    /**
     * This method returns the value of the database column FW_WITHDRAW_REQ_FOS_DETAIL.REMIT_VOUCHER_NO
     *
     * @return the value of FW_WITHDRAW_REQ_FOS_DETAIL.REMIT_VOUCHER_NO
     * column comments 请求的业务订单号
     *
     * @mbggenerated Fri Mar 11 19:55:35 CST 2016
     */
    public String getRemitVoucherNo() {
        return remitVoucherNo;
    }

    /**
     * This method sets the value of the database column FW_WITHDRAW_REQ_FOS_DETAIL.REMIT_VOUCHER_NO
     *
     * @param remitVoucherNo the value for FW_WITHDRAW_REQ_FOS_DETAIL.REMIT_VOUCHER_NO
     * column comments 请求的业务订单号
     *
     * @mbggenerated Fri Mar 11 19:55:35 CST 2016
     */
    public void setRemitVoucherNo(String remitVoucherNo) {
        this.remitVoucherNo = remitVoucherNo == null ? null : remitVoucherNo.trim();
    }

    /**
     * This method returns the value of the database column FW_WITHDRAW_REQ_FOS_DETAIL.PAYER_MEMBER_ID
     *
     * @return the value of FW_WITHDRAW_REQ_FOS_DETAIL.PAYER_MEMBER_ID
     * column comments 会员ID
     *
     * @mbggenerated Fri Mar 11 19:55:35 CST 2016
     */
    public String getPayerMemberId() {
        return payerMemberId;
    }

    /**
     * This method sets the value of the database column FW_WITHDRAW_REQ_FOS_DETAIL.PAYER_MEMBER_ID
     *
     * @param payerMemberId the value for FW_WITHDRAW_REQ_FOS_DETAIL.PAYER_MEMBER_ID
     * column comments 会员ID
     *
     * @mbggenerated Fri Mar 11 19:55:35 CST 2016
     */
    public void setPayerMemberId(String payerMemberId) {
        this.payerMemberId = payerMemberId == null ? null : payerMemberId.trim();
    }

    /**
     * This method returns the value of the database column FW_WITHDRAW_REQ_FOS_DETAIL.IS_NEED_COUNT_FEE
     *
     * @return the value of FW_WITHDRAW_REQ_FOS_DETAIL.IS_NEED_COUNT_FEE
     * column comments 是否需要计费 1：计费；0：不计费  
     *
     * @mbggenerated Fri Mar 11 19:55:35 CST 2016
     */
    public Integer getIsNeedCountFee() {
        return isNeedCountFee;
    }

    /**
     * This method sets the value of the database column FW_WITHDRAW_REQ_FOS_DETAIL.IS_NEED_COUNT_FEE
     *
     * @param isNeedCountFee the value for FW_WITHDRAW_REQ_FOS_DETAIL.IS_NEED_COUNT_FEE
     * column comments 是否需要计费 1：计费；0：不计费  
     *
     * @mbggenerated Fri Mar 11 19:55:35 CST 2016
     */
    public void setIsNeedCountFee(Integer isNeedCountFee) {
        this.isNeedCountFee = isNeedCountFee;
    }

    /**
     * This method returns the value of the database column FW_WITHDRAW_REQ_FOS_DETAIL.PAYER_FEE
     *
     * @return the value of FW_WITHDRAW_REQ_FOS_DETAIL.PAYER_FEE
     * column comments 付款人费用
     *
     * @mbggenerated Fri Mar 11 19:55:35 CST 2016
     */
    public BigDecimal getPayerFee() {
        return payerFee;
    }

    /**
     * This method sets the value of the database column FW_WITHDRAW_REQ_FOS_DETAIL.PAYER_FEE
     *
     * @param payerFee the value for FW_WITHDRAW_REQ_FOS_DETAIL.PAYER_FEE
     * column comments 付款人费用
     *
     * @mbggenerated Fri Mar 11 19:55:35 CST 2016
     */
    public void setPayerFee(BigDecimal payerFee) {
        this.payerFee = payerFee;
    }

    /**
     * This method returns the value of the database column FW_WITHDRAW_REQ_FOS_DETAIL.PAYEE_FEE
     *
     * @return the value of FW_WITHDRAW_REQ_FOS_DETAIL.PAYEE_FEE
     * column comments 收款人费用
     *
     * @mbggenerated Fri Mar 11 19:55:35 CST 2016
     */
    public BigDecimal getPayeeFee() {
        return payeeFee;
    }

    /**
     * This method sets the value of the database column FW_WITHDRAW_REQ_FOS_DETAIL.PAYEE_FEE
     *
     * @param payeeFee the value for FW_WITHDRAW_REQ_FOS_DETAIL.PAYEE_FEE
     * column comments 收款人费用
     *
     * @mbggenerated Fri Mar 11 19:55:35 CST 2016
     */
    public void setPayeeFee(BigDecimal payeeFee) {
        this.payeeFee = payeeFee;
    }

    /**
     * This method returns the value of the database column FW_WITHDRAW_REQ_FOS_DETAIL.IS_PERMIT_PRICING_ERR
     *
     * @return the value of FW_WITHDRAW_REQ_FOS_DETAIL.IS_PERMIT_PRICING_ERR
     * column comments 是否允许计费异常
     *
     * @mbggenerated Fri Mar 11 19:55:35 CST 2016
     */
    public Integer getIsPermitPricingErr() {
        return isPermitPricingErr;
    }

    /**
     * This method sets the value of the database column FW_WITHDRAW_REQ_FOS_DETAIL.IS_PERMIT_PRICING_ERR
     *
     * @param isPermitPricingErr the value for FW_WITHDRAW_REQ_FOS_DETAIL.IS_PERMIT_PRICING_ERR
     * column comments 是否允许计费异常
     *
     * @mbggenerated Fri Mar 11 19:55:35 CST 2016
     */
    public void setIsPermitPricingErr(Integer isPermitPricingErr) {
        this.isPermitPricingErr = isPermitPricingErr;
    }

    /**
     * This method returns the value of the database column FW_WITHDRAW_REQ_FOS_DETAIL.PAYER_ACCOUNT_NO
     *
     * @return the value of FW_WITHDRAW_REQ_FOS_DETAIL.PAYER_ACCOUNT_NO
     * column comments 付款人储值账户ID 
     *
     * @mbggenerated Fri Mar 11 19:55:35 CST 2016
     */
    public String getPayerAccountNo() {
        return payerAccountNo;
    }

    /**
     * This method sets the value of the database column FW_WITHDRAW_REQ_FOS_DETAIL.PAYER_ACCOUNT_NO
     *
     * @param payerAccountNo the value for FW_WITHDRAW_REQ_FOS_DETAIL.PAYER_ACCOUNT_NO
     * column comments 付款人储值账户ID 
     *
     * @mbggenerated Fri Mar 11 19:55:35 CST 2016
     */
    public void setPayerAccountNo(String payerAccountNo) {
        this.payerAccountNo = payerAccountNo == null ? null : payerAccountNo.trim();
    }

    /**
     * This method returns the value of the database column FW_WITHDRAW_REQ_FOS_DETAIL.BANK_CODE
     *
     * @return the value of FW_WITHDRAW_REQ_FOS_DETAIL.BANK_CODE
     * column comments 开户行 
     *
     * @mbggenerated Fri Mar 11 19:55:35 CST 2016
     */
    public String getBankCode() {
        return bankCode;
    }

    /**
     * This method sets the value of the database column FW_WITHDRAW_REQ_FOS_DETAIL.BANK_CODE
     *
     * @param bankCode the value for FW_WITHDRAW_REQ_FOS_DETAIL.BANK_CODE
     * column comments 开户行 
     *
     * @mbggenerated Fri Mar 11 19:55:35 CST 2016
     */
    public void setBankCode(String bankCode) {
        this.bankCode = bankCode == null ? null : bankCode.trim();
    }

    /**
     * This method returns the value of the database column FW_WITHDRAW_REQ_FOS_DETAIL.BANK_NAME
     *
     * @return the value of FW_WITHDRAW_REQ_FOS_DETAIL.BANK_NAME
     * column comments 开户行名称 
     *
     * @mbggenerated Fri Mar 11 19:55:35 CST 2016
     */
    public String getBankName() {
        return bankName;
    }

    /**
     * This method sets the value of the database column FW_WITHDRAW_REQ_FOS_DETAIL.BANK_NAME
     *
     * @param bankName the value for FW_WITHDRAW_REQ_FOS_DETAIL.BANK_NAME
     * column comments 开户行名称 
     *
     * @mbggenerated Fri Mar 11 19:55:35 CST 2016
     */
    public void setBankName(String bankName) {
        this.bankName = bankName == null ? null : bankName.trim();
    }

    /**
     * This method returns the value of the database column FW_WITHDRAW_REQ_FOS_DETAIL.BANK_BRANCH
     *
     * @return the value of FW_WITHDRAW_REQ_FOS_DETAIL.BANK_BRANCH
     * column comments 支行名称
     *
     * @mbggenerated Fri Mar 11 19:55:35 CST 2016
     */
    public String getBankBranch() {
        return bankBranch;
    }

    /**
     * This method sets the value of the database column FW_WITHDRAW_REQ_FOS_DETAIL.BANK_BRANCH
     *
     * @param bankBranch the value for FW_WITHDRAW_REQ_FOS_DETAIL.BANK_BRANCH
     * column comments 支行名称
     *
     * @mbggenerated Fri Mar 11 19:55:35 CST 2016
     */
    public void setBankBranch(String bankBranch) {
        this.bankBranch = bankBranch == null ? null : bankBranch.trim();
    }

    /**
     * This method returns the value of the database column FW_WITHDRAW_REQ_FOS_DETAIL.BANK_LINENO
     *
     * @return the value of FW_WITHDRAW_REQ_FOS_DETAIL.BANK_LINENO
     * column comments 支行编码(联行号)
     *
     * @mbggenerated Fri Mar 11 19:55:35 CST 2016
     */
    public String getBankLineno() {
        return bankLineno;
    }

    /**
     * This method sets the value of the database column FW_WITHDRAW_REQ_FOS_DETAIL.BANK_LINENO
     *
     * @param bankLineno the value for FW_WITHDRAW_REQ_FOS_DETAIL.BANK_LINENO
     * column comments 支行编码(联行号)
     *
     * @mbggenerated Fri Mar 11 19:55:35 CST 2016
     */
    public void setBankLineno(String bankLineno) {
        this.bankLineno = bankLineno == null ? null : bankLineno.trim();
    }

    /**
     * This method returns the value of the database column FW_WITHDRAW_REQ_FOS_DETAIL.BANK_PROVINCE
     *
     * @return the value of FW_WITHDRAW_REQ_FOS_DETAIL.BANK_PROVINCE
     * column comments 银行所属省份 
     *
     * @mbggenerated Fri Mar 11 19:55:35 CST 2016
     */
    public String getBankProvince() {
        return bankProvince;
    }

    /**
     * This method sets the value of the database column FW_WITHDRAW_REQ_FOS_DETAIL.BANK_PROVINCE
     *
     * @param bankProvince the value for FW_WITHDRAW_REQ_FOS_DETAIL.BANK_PROVINCE
     * column comments 银行所属省份 
     *
     * @mbggenerated Fri Mar 11 19:55:35 CST 2016
     */
    public void setBankProvince(String bankProvince) {
        this.bankProvince = bankProvince == null ? null : bankProvince.trim();
    }

    /**
     * This method returns the value of the database column FW_WITHDRAW_REQ_FOS_DETAIL.BANK_CITY
     *
     * @return the value of FW_WITHDRAW_REQ_FOS_DETAIL.BANK_CITY
     * column comments 银行所属城市
     *
     * @mbggenerated Fri Mar 11 19:55:35 CST 2016
     */
    public String getBankCity() {
        return bankCity;
    }

    /**
     * This method sets the value of the database column FW_WITHDRAW_REQ_FOS_DETAIL.BANK_CITY
     *
     * @param bankCity the value for FW_WITHDRAW_REQ_FOS_DETAIL.BANK_CITY
     * column comments 银行所属城市
     *
     * @mbggenerated Fri Mar 11 19:55:35 CST 2016
     */
    public void setBankCity(String bankCity) {
        this.bankCity = bankCity == null ? null : bankCity.trim();
    }

    /**
     * This method returns the value of the database column FW_WITHDRAW_REQ_FOS_DETAIL.PAYEE_NAME
     *
     * @return the value of FW_WITHDRAW_REQ_FOS_DETAIL.PAYEE_NAME
     * column comments 收款人姓名
     *
     * @mbggenerated Fri Mar 11 19:55:35 CST 2016
     */
    public String getPayeeName() {
        return payeeName;
    }

    /**
     * This method sets the value of the database column FW_WITHDRAW_REQ_FOS_DETAIL.PAYEE_NAME
     *
     * @param payeeName the value for FW_WITHDRAW_REQ_FOS_DETAIL.PAYEE_NAME
     * column comments 收款人姓名
     *
     * @mbggenerated Fri Mar 11 19:55:35 CST 2016
     */
    public void setPayeeName(String payeeName) {
        this.payeeName = payeeName == null ? null : payeeName.trim();
    }

    /**
     * This method returns the value of the database column FW_WITHDRAW_REQ_FOS_DETAIL.PAYEE_CARD_NO
     *
     * @return the value of FW_WITHDRAW_REQ_FOS_DETAIL.PAYEE_CARD_NO
     * column comments 收款人卡号
     *
     * @mbggenerated Fri Mar 11 19:55:35 CST 2016
     */
    public String getPayeeCardNo() {
        return payeeCardNo;
    }

    /**
     * This method sets the value of the database column FW_WITHDRAW_REQ_FOS_DETAIL.PAYEE_CARD_NO
     *
     * @param payeeCardNo the value for FW_WITHDRAW_REQ_FOS_DETAIL.PAYEE_CARD_NO
     * column comments 收款人卡号
     *
     * @mbggenerated Fri Mar 11 19:55:35 CST 2016
     */
    public void setPayeeCardNo(String payeeCardNo) {
        this.payeeCardNo = payeeCardNo == null ? null : payeeCardNo.trim();
    }

    /**
     * This method returns the value of the database column FW_WITHDRAW_REQ_FOS_DETAIL.PAYEE_PURPOSE
     *
     * @return the value of FW_WITHDRAW_REQ_FOS_DETAIL.PAYEE_PURPOSE
     * column comments 用途
     *
     * @mbggenerated Fri Mar 11 19:55:35 CST 2016
     */
    public String getPayeePurpose() {
        return payeePurpose;
    }

    /**
     * This method sets the value of the database column FW_WITHDRAW_REQ_FOS_DETAIL.PAYEE_PURPOSE
     *
     * @param payeePurpose the value for FW_WITHDRAW_REQ_FOS_DETAIL.PAYEE_PURPOSE
     * column comments 用途
     *
     * @mbggenerated Fri Mar 11 19:55:35 CST 2016
     */
    public void setPayeePurpose(String payeePurpose) {
        this.payeePurpose = payeePurpose == null ? null : payeePurpose.trim();
    }

    /**
     * This method returns the value of the database column FW_WITHDRAW_REQ_FOS_DETAIL.CARD_TYPE
     *
     * @return the value of FW_WITHDRAW_REQ_FOS_DETAIL.CARD_TYPE
     * column comments 卡类型
     *
     * @mbggenerated Fri Mar 11 19:55:35 CST 2016
     */
    public String getCardType() {
        return cardType;
    }

    /**
     * This method sets the value of the database column FW_WITHDRAW_REQ_FOS_DETAIL.CARD_TYPE
     *
     * @param cardType the value for FW_WITHDRAW_REQ_FOS_DETAIL.CARD_TYPE
     * column comments 卡类型
     *
     * @mbggenerated Fri Mar 11 19:55:35 CST 2016
     */
    public void setCardType(String cardType) {
        this.cardType = cardType == null ? null : cardType.trim();
    }

    /**
     * This method returns the value of the database column FW_WITHDRAW_REQ_FOS_DETAIL.COMPANY_OR_PERSONAL
     *
     * @return the value of FW_WITHDRAW_REQ_FOS_DETAIL.COMPANY_OR_PERSONAL
     * column comments 账户类型
     *
     * @mbggenerated Fri Mar 11 19:55:35 CST 2016
     */
    public String getCompanyOrPersonal() {
        return companyOrPersonal;
    }

    /**
     * This method sets the value of the database column FW_WITHDRAW_REQ_FOS_DETAIL.COMPANY_OR_PERSONAL
     *
     * @param companyOrPersonal the value for FW_WITHDRAW_REQ_FOS_DETAIL.COMPANY_OR_PERSONAL
     * column comments 账户类型
     *
     * @mbggenerated Fri Mar 11 19:55:35 CST 2016
     */
    public void setCompanyOrPersonal(String companyOrPersonal) {
        this.companyOrPersonal = companyOrPersonal == null ? null : companyOrPersonal.trim();
    }

    /**
     * This method returns the value of the database column FW_WITHDRAW_REQ_FOS_DETAIL.GMT_BIZ_INITIATE
     *
     * @return the value of FW_WITHDRAW_REQ_FOS_DETAIL.GMT_BIZ_INITIATE
     * column comments 业务发起时间
     *
     * @mbggenerated Fri Mar 11 19:55:35 CST 2016
     */
    public Date getGmtBizInitiate() {
        return gmtBizInitiate;
    }

    /**
     * This method sets the value of the database column FW_WITHDRAW_REQ_FOS_DETAIL.GMT_BIZ_INITIATE
     *
     * @param gmtBizInitiate the value for FW_WITHDRAW_REQ_FOS_DETAIL.GMT_BIZ_INITIATE
     * column comments 业务发起时间
     *
     * @mbggenerated Fri Mar 11 19:55:35 CST 2016
     */
    public void setGmtBizInitiate(Date gmtBizInitiate) {
        this.gmtBizInitiate = gmtBizInitiate;
    }

    /**
     * This method returns the value of the database column FW_WITHDRAW_REQ_FOS_DETAIL.GMT_PAYMENT_INITIATE
     *
     * @return the value of FW_WITHDRAW_REQ_FOS_DETAIL.GMT_PAYMENT_INITIATE
     * column comments 支付发起时间
     *
     * @mbggenerated Fri Mar 11 19:55:35 CST 2016
     */
    public Date getGmtPaymentInitiate() {
        return gmtPaymentInitiate;
    }

    /**
     * This method sets the value of the database column FW_WITHDRAW_REQ_FOS_DETAIL.GMT_PAYMENT_INITIATE
     *
     * @param gmtPaymentInitiate the value for FW_WITHDRAW_REQ_FOS_DETAIL.GMT_PAYMENT_INITIATE
     * column comments 支付发起时间
     *
     * @mbggenerated Fri Mar 11 19:55:35 CST 2016
     */
    public void setGmtPaymentInitiate(Date gmtPaymentInitiate) {
        this.gmtPaymentInitiate = gmtPaymentInitiate;
    }

    /**
     * This method returns the value of the database column FW_WITHDRAW_REQ_FOS_DETAIL.REMIT_AMOUNT
     *
     * @return the value of FW_WITHDRAW_REQ_FOS_DETAIL.REMIT_AMOUNT
     * column comments 出款金额 
     *
     * @mbggenerated Fri Mar 11 19:55:35 CST 2016
     */
    public BigDecimal getRemitAmount() {
        return remitAmount;
    }

    /**
     * This method sets the value of the database column FW_WITHDRAW_REQ_FOS_DETAIL.REMIT_AMOUNT
     *
     * @param remitAmount the value for FW_WITHDRAW_REQ_FOS_DETAIL.REMIT_AMOUNT
     * column comments 出款金额 
     *
     * @mbggenerated Fri Mar 11 19:55:35 CST 2016
     */
    public void setRemitAmount(BigDecimal remitAmount) {
        this.remitAmount = remitAmount;
    }

    /**
     * This method returns the value of the database column FW_WITHDRAW_REQ_FOS_DETAIL.CALLBACK_ADDRESS
     *
     * @return the value of FW_WITHDRAW_REQ_FOS_DETAIL.CALLBACK_ADDRESS
     * column comments 回掉地址
     *
     * @mbggenerated Fri Mar 11 19:55:35 CST 2016
     */
    public String getCallbackAddress() {
        return callbackAddress;
    }

    /**
     * This method sets the value of the database column FW_WITHDRAW_REQ_FOS_DETAIL.CALLBACK_ADDRESS
     *
     * @param callbackAddress the value for FW_WITHDRAW_REQ_FOS_DETAIL.CALLBACK_ADDRESS
     * column comments 回掉地址
     *
     * @mbggenerated Fri Mar 11 19:55:35 CST 2016
     */
    public void setCallbackAddress(String callbackAddress) {
        this.callbackAddress = callbackAddress == null ? null : callbackAddress.trim();
    }

    /**
     * This method returns the value of the database column FW_WITHDRAW_REQ_FOS_DETAIL.MEMO
     *
     * @return the value of FW_WITHDRAW_REQ_FOS_DETAIL.MEMO
     * column comments 备注信息
     *
     * @mbggenerated Fri Mar 11 19:55:35 CST 2016
     */
    public String getMemo() {
        return memo;
    }

    /**
     * This method sets the value of the database column FW_WITHDRAW_REQ_FOS_DETAIL.MEMO
     *
     * @param memo the value for FW_WITHDRAW_REQ_FOS_DETAIL.MEMO
     * column comments 备注信息
     *
     * @mbggenerated Fri Mar 11 19:55:35 CST 2016
     */
    public void setMemo(String memo) {
        this.memo = memo == null ? null : memo.trim();
    }

    /**
     * This method returns the value of the database column FW_WITHDRAW_REQ_FOS_DETAIL.CURRENCY
     *
     * @return the value of FW_WITHDRAW_REQ_FOS_DETAIL.CURRENCY
     * column comments 币种不传默认为CNY
     *
     * @mbggenerated Fri Mar 11 19:55:35 CST 2016
     */
    public String getCurrency() {
        return currency;
    }

    /**
     * This method sets the value of the database column FW_WITHDRAW_REQ_FOS_DETAIL.CURRENCY
     *
     * @param currency the value for FW_WITHDRAW_REQ_FOS_DETAIL.CURRENCY
     * column comments 币种不传默认为CNY
     *
     * @mbggenerated Fri Mar 11 19:55:35 CST 2016
     */
    public void setCurrency(String currency) {
        this.currency = currency == null ? null : currency.trim();
    }

    /**
     * This method returns the value of the database column FW_WITHDRAW_REQ_FOS_DETAIL.REQ_EXTENTION
     *
     * @return the value of FW_WITHDRAW_REQ_FOS_DETAIL.REQ_EXTENTION
     * column comments 扩展信息
     *
     * @mbggenerated Fri Mar 11 19:55:35 CST 2016
     */
    public String getReqExtention() {
        return reqExtention;
    }

    /**
     * This method sets the value of the database column FW_WITHDRAW_REQ_FOS_DETAIL.REQ_EXTENTION
     *
     * @param reqExtention the value for FW_WITHDRAW_REQ_FOS_DETAIL.REQ_EXTENTION
     * column comments 扩展信息
     *
     * @mbggenerated Fri Mar 11 19:55:35 CST 2016
     */
    public void setReqExtention(String reqExtention) {
        this.reqExtention = reqExtention == null ? null : reqExtention.trim();
    }

    /**
     * This method returns the value of the database column FW_WITHDRAW_REQ_FOS_DETAIL.WITHDRAW_STATUS
     *
     * @return the value of FW_WITHDRAW_REQ_FOS_DETAIL.WITHDRAW_STATUS
     * column comments 批次处理状态
     *
     * @mbggenerated Fri Mar 11 19:55:35 CST 2016
     */
    public String getWithdrawStatus() {
        return withdrawStatus;
    }

    /**
     * This method sets the value of the database column FW_WITHDRAW_REQ_FOS_DETAIL.WITHDRAW_STATUS
     *
     * @param withdrawStatus the value for FW_WITHDRAW_REQ_FOS_DETAIL.WITHDRAW_STATUS
     * column comments 批次处理状态
     *
     * @mbggenerated Fri Mar 11 19:55:35 CST 2016
     */
    public void setWithdrawStatus(String withdrawStatus) {
        this.withdrawStatus = withdrawStatus == null ? null : withdrawStatus.trim();
    }

    /**
     * This method returns the value of the database column FW_WITHDRAW_REQ_FOS_DETAIL.RETURN_CODE
     *
     * @return the value of FW_WITHDRAW_REQ_FOS_DETAIL.RETURN_CODE
     * column comments 返回错误码 
     *
     * @mbggenerated Fri Mar 11 19:55:35 CST 2016
     */
    public String getReturnCode() {
        return returnCode;
    }

    /**
     * This method sets the value of the database column FW_WITHDRAW_REQ_FOS_DETAIL.RETURN_CODE
     *
     * @param returnCode the value for FW_WITHDRAW_REQ_FOS_DETAIL.RETURN_CODE
     * column comments 返回错误码 
     *
     * @mbggenerated Fri Mar 11 19:55:35 CST 2016
     */
    public void setReturnCode(String returnCode) {
        this.returnCode = returnCode == null ? null : returnCode.trim();
    }

    /**
     * This method returns the value of the database column FW_WITHDRAW_REQ_FOS_DETAIL.RETURN_MSG
     *
     * @return the value of FW_WITHDRAW_REQ_FOS_DETAIL.RETURN_MSG
     * column comments 返回错误信息
     *
     * @mbggenerated Fri Mar 11 19:55:35 CST 2016
     */
    public String getReturnMsg() {
        return returnMsg;
    }

    /**
     * This method sets the value of the database column FW_WITHDRAW_REQ_FOS_DETAIL.RETURN_MSG
     *
     * @param returnMsg the value for FW_WITHDRAW_REQ_FOS_DETAIL.RETURN_MSG
     * column comments 返回错误信息
     *
     * @mbggenerated Fri Mar 11 19:55:35 CST 2016
     */
    public void setReturnMsg(String returnMsg) {
        this.returnMsg = returnMsg == null ? null : returnMsg.trim();
    }

    /**
     * This method returns the value of the database column FW_WITHDRAW_REQ_FOS_DETAIL.EXTENTION
     *
     * @return the value of FW_WITHDRAW_REQ_FOS_DETAIL.EXTENTION
     * column comments 返回扩展信息
     *
     * @mbggenerated Fri Mar 11 19:55:35 CST 2016
     */
    public String getExtention() {
        return extention;
    }

    /**
     * This method sets the value of the database column FW_WITHDRAW_REQ_FOS_DETAIL.EXTENTION
     *
     * @param extention the value for FW_WITHDRAW_REQ_FOS_DETAIL.EXTENTION
     * column comments 返回扩展信息
     *
     * @mbggenerated Fri Mar 11 19:55:35 CST 2016
     */
    public void setExtention(String extention) {
        this.extention = extention == null ? null : extention.trim();
    }

    /**
     * This method returns the value of the database column FW_WITHDRAW_REQ_FOS_DETAIL.CREATE_TIME
     *
     * @return the value of FW_WITHDRAW_REQ_FOS_DETAIL.CREATE_TIME
     * column comments 创建时间
     *
     * @mbggenerated Fri Mar 11 19:55:35 CST 2016
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * This method sets the value of the database column FW_WITHDRAW_REQ_FOS_DETAIL.CREATE_TIME
     *
     * @param createTime the value for FW_WITHDRAW_REQ_FOS_DETAIL.CREATE_TIME
     * column comments 创建时间
     *
     * @mbggenerated Fri Mar 11 19:55:35 CST 2016
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * This method returns the value of the database column FW_WITHDRAW_REQ_FOS_DETAIL.UPDATE_TIME
     *
     * @return the value of FW_WITHDRAW_REQ_FOS_DETAIL.UPDATE_TIME
     * column comments 最后修改时间
     *
     * @mbggenerated Fri Mar 11 19:55:35 CST 2016
     */
    public Date getUpdateTime() {
        return updateTime;
    }

    /**
     * This method sets the value of the database column FW_WITHDRAW_REQ_FOS_DETAIL.UPDATE_TIME
     *
     * @param updateTime the value for FW_WITHDRAW_REQ_FOS_DETAIL.UPDATE_TIME
     * column comments 最后修改时间
     *
     * @mbggenerated Fri Mar 11 19:55:35 CST 2016
     */
    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }
}