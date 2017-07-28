package com.sdp.withdraw.dao;

import com.sdp.emall.common.dao.QueryBase;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class WithdrawReqFosDetailDOExample extends QueryBase {
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
     * This field corresponds to the database table FW_WITHDRAW_REQ_FOS_DETAIL
     * table comments 出款业务调用FOS详细表
     *
     * @mbggenerated Fri Mar 11 19:55:35 CST 2016
     */
    protected String orderByClause;

    /**
     * This field corresponds to the database table FW_WITHDRAW_REQ_FOS_DETAIL
     * table comments 出款业务调用FOS详细表
     *
     * @mbggenerated Fri Mar 11 19:55:35 CST 2016
     */
    protected boolean distinct;

    /**
     * This field corresponds to the database table FW_WITHDRAW_REQ_FOS_DETAIL
     * table comments 出款业务调用FOS详细表
     *
     * @mbggenerated Fri Mar 11 19:55:35 CST 2016
     */
    protected List<Criteria> oredCriteria;

    /**
     * This method corresponds to the database table FW_WITHDRAW_REQ_FOS_DETAIL
     *
     * @mbggenerated Fri Mar 11 19:55:35 CST 2016
     */
    public WithdrawReqFosDetailDOExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

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

    /**
     * This method corresponds to the database table FW_WITHDRAW_REQ_FOS_DETAIL
     *
     * @mbggenerated Fri Mar 11 19:55:35 CST 2016
     */
    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    /**
     * This method corresponds to the database table FW_WITHDRAW_REQ_FOS_DETAIL
     *
     * @mbggenerated Fri Mar 11 19:55:35 CST 2016
     */
    public String getOrderByClause() {
        return orderByClause;
    }

    /**
     * This method corresponds to the database table FW_WITHDRAW_REQ_FOS_DETAIL
     *
     * @mbggenerated Fri Mar 11 19:55:35 CST 2016
     */
    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    /**
     * This method corresponds to the database table FW_WITHDRAW_REQ_FOS_DETAIL
     *
     * @mbggenerated Fri Mar 11 19:55:35 CST 2016
     */
    public boolean isDistinct() {
        return distinct;
    }

    /**
     * This method corresponds to the database table FW_WITHDRAW_REQ_FOS_DETAIL
     *
     * @mbggenerated Fri Mar 11 19:55:35 CST 2016
     */
    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    /**
     * This method corresponds to the database table FW_WITHDRAW_REQ_FOS_DETAIL
     *
     * @mbggenerated Fri Mar 11 19:55:35 CST 2016
     */
    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    /**
     * This method corresponds to the database table FW_WITHDRAW_REQ_FOS_DETAIL
     *
     * @mbggenerated Fri Mar 11 19:55:35 CST 2016
     */
    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    /**
     * This method corresponds to the database table FW_WITHDRAW_REQ_FOS_DETAIL
     *
     * @mbggenerated Fri Mar 11 19:55:35 CST 2016
     */
    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    /**
     * This method corresponds to the database table FW_WITHDRAW_REQ_FOS_DETAIL
     *
     * @mbggenerated Fri Mar 11 19:55:35 CST 2016
     */
    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    /**
     * This method corresponds to the database table FW_WITHDRAW_REQ_FOS_DETAIL
     *
     * @mbggenerated Fri Mar 11 19:55:35 CST 2016
     */
    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table FW_WITHDRAW_REQ_FOS_DETAIL
     * table comment :出款业务调用FOS详细表
     *
     * @mbggenerated Fri Mar 11 19:55:35 CST 2016
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

        public Criteria andDetailIdIsNull() {
            addCriterion("DETAIL_ID is null");
            return (Criteria) this;
        }

        public Criteria andDetailIdIsNotNull() {
            addCriterion("DETAIL_ID is not null");
            return (Criteria) this;
        }

        public Criteria andDetailIdEqualTo(Long value) {
            addCriterion("DETAIL_ID =", value, "detailId");
            return (Criteria) this;
        }

        public Criteria andDetailIdNotEqualTo(Long value) {
            addCriterion("DETAIL_ID <>", value, "detailId");
            return (Criteria) this;
        }

        public Criteria andDetailIdGreaterThan(Long value) {
            addCriterion("DETAIL_ID >", value, "detailId");
            return (Criteria) this;
        }

        public Criteria andDetailIdGreaterThanOrEqualTo(Long value) {
            addCriterion("DETAIL_ID >=", value, "detailId");
            return (Criteria) this;
        }

        public Criteria andDetailIdLessThan(Long value) {
            addCriterion("DETAIL_ID <", value, "detailId");
            return (Criteria) this;
        }

        public Criteria andDetailIdLessThanOrEqualTo(Long value) {
            addCriterion("DETAIL_ID <=", value, "detailId");
            return (Criteria) this;
        }

        public Criteria andDetailIdIn(List<Long> values) {
            addCriterion("DETAIL_ID in", values, "detailId");
            return (Criteria) this;
        }

        public Criteria andDetailIdNotIn(List<Long> values) {
            addCriterion("DETAIL_ID not in", values, "detailId");
            return (Criteria) this;
        }

        public Criteria andDetailIdBetween(Long value1, Long value2) {
            addCriterion("DETAIL_ID between", value1, value2, "detailId");
            return (Criteria) this;
        }

        public Criteria andDetailIdNotBetween(Long value1, Long value2) {
            addCriterion("DETAIL_ID not between", value1, value2, "detailId");
            return (Criteria) this;
        }

        public Criteria andReqIdIsNull() {
            addCriterion("REQ_ID is null");
            return (Criteria) this;
        }

        public Criteria andReqIdIsNotNull() {
            addCriterion("REQ_ID is not null");
            return (Criteria) this;
        }

        public Criteria andReqIdEqualTo(Long value) {
            addCriterion("REQ_ID =", value, "reqId");
            return (Criteria) this;
        }

        public Criteria andReqIdNotEqualTo(Long value) {
            addCriterion("REQ_ID <>", value, "reqId");
            return (Criteria) this;
        }

        public Criteria andReqIdGreaterThan(Long value) {
            addCriterion("REQ_ID >", value, "reqId");
            return (Criteria) this;
        }

        public Criteria andReqIdGreaterThanOrEqualTo(Long value) {
            addCriterion("REQ_ID >=", value, "reqId");
            return (Criteria) this;
        }

        public Criteria andReqIdLessThan(Long value) {
            addCriterion("REQ_ID <", value, "reqId");
            return (Criteria) this;
        }

        public Criteria andReqIdLessThanOrEqualTo(Long value) {
            addCriterion("REQ_ID <=", value, "reqId");
            return (Criteria) this;
        }

        public Criteria andReqIdIn(List<Long> values) {
            addCriterion("REQ_ID in", values, "reqId");
            return (Criteria) this;
        }

        public Criteria andReqIdNotIn(List<Long> values) {
            addCriterion("REQ_ID not in", values, "reqId");
            return (Criteria) this;
        }

        public Criteria andReqIdBetween(Long value1, Long value2) {
            addCriterion("REQ_ID between", value1, value2, "reqId");
            return (Criteria) this;
        }

        public Criteria andReqIdNotBetween(Long value1, Long value2) {
            addCriterion("REQ_ID not between", value1, value2, "reqId");
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

        public Criteria andIsNeedCountFeeIsNull() {
            addCriterion("IS_NEED_COUNT_FEE is null");
            return (Criteria) this;
        }

        public Criteria andIsNeedCountFeeIsNotNull() {
            addCriterion("IS_NEED_COUNT_FEE is not null");
            return (Criteria) this;
        }

        public Criteria andIsNeedCountFeeEqualTo(Integer value) {
            addCriterion("IS_NEED_COUNT_FEE =", value, "isNeedCountFee");
            return (Criteria) this;
        }

        public Criteria andIsNeedCountFeeNotEqualTo(Integer value) {
            addCriterion("IS_NEED_COUNT_FEE <>", value, "isNeedCountFee");
            return (Criteria) this;
        }

        public Criteria andIsNeedCountFeeGreaterThan(Integer value) {
            addCriterion("IS_NEED_COUNT_FEE >", value, "isNeedCountFee");
            return (Criteria) this;
        }

        public Criteria andIsNeedCountFeeGreaterThanOrEqualTo(Integer value) {
            addCriterion("IS_NEED_COUNT_FEE >=", value, "isNeedCountFee");
            return (Criteria) this;
        }

        public Criteria andIsNeedCountFeeLessThan(Integer value) {
            addCriterion("IS_NEED_COUNT_FEE <", value, "isNeedCountFee");
            return (Criteria) this;
        }

        public Criteria andIsNeedCountFeeLessThanOrEqualTo(Integer value) {
            addCriterion("IS_NEED_COUNT_FEE <=", value, "isNeedCountFee");
            return (Criteria) this;
        }

        public Criteria andIsNeedCountFeeIn(List<Integer> values) {
            addCriterion("IS_NEED_COUNT_FEE in", values, "isNeedCountFee");
            return (Criteria) this;
        }

        public Criteria andIsNeedCountFeeNotIn(List<Integer> values) {
            addCriterion("IS_NEED_COUNT_FEE not in", values, "isNeedCountFee");
            return (Criteria) this;
        }

        public Criteria andIsNeedCountFeeBetween(Integer value1, Integer value2) {
            addCriterion("IS_NEED_COUNT_FEE between", value1, value2, "isNeedCountFee");
            return (Criteria) this;
        }

        public Criteria andIsNeedCountFeeNotBetween(Integer value1, Integer value2) {
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

        public Criteria andPayerFeeEqualTo(BigDecimal value) {
            addCriterion("PAYER_FEE =", value, "payerFee");
            return (Criteria) this;
        }

        public Criteria andPayerFeeNotEqualTo(BigDecimal value) {
            addCriterion("PAYER_FEE <>", value, "payerFee");
            return (Criteria) this;
        }

        public Criteria andPayerFeeGreaterThan(BigDecimal value) {
            addCriterion("PAYER_FEE >", value, "payerFee");
            return (Criteria) this;
        }

        public Criteria andPayerFeeGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("PAYER_FEE >=", value, "payerFee");
            return (Criteria) this;
        }

        public Criteria andPayerFeeLessThan(BigDecimal value) {
            addCriterion("PAYER_FEE <", value, "payerFee");
            return (Criteria) this;
        }

        public Criteria andPayerFeeLessThanOrEqualTo(BigDecimal value) {
            addCriterion("PAYER_FEE <=", value, "payerFee");
            return (Criteria) this;
        }

        public Criteria andPayerFeeIn(List<BigDecimal> values) {
            addCriterion("PAYER_FEE in", values, "payerFee");
            return (Criteria) this;
        }

        public Criteria andPayerFeeNotIn(List<BigDecimal> values) {
            addCriterion("PAYER_FEE not in", values, "payerFee");
            return (Criteria) this;
        }

        public Criteria andPayerFeeBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("PAYER_FEE between", value1, value2, "payerFee");
            return (Criteria) this;
        }

        public Criteria andPayerFeeNotBetween(BigDecimal value1, BigDecimal value2) {
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

        public Criteria andPayeeFeeEqualTo(BigDecimal value) {
            addCriterion("PAYEE_FEE =", value, "payeeFee");
            return (Criteria) this;
        }

        public Criteria andPayeeFeeNotEqualTo(BigDecimal value) {
            addCriterion("PAYEE_FEE <>", value, "payeeFee");
            return (Criteria) this;
        }

        public Criteria andPayeeFeeGreaterThan(BigDecimal value) {
            addCriterion("PAYEE_FEE >", value, "payeeFee");
            return (Criteria) this;
        }

        public Criteria andPayeeFeeGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("PAYEE_FEE >=", value, "payeeFee");
            return (Criteria) this;
        }

        public Criteria andPayeeFeeLessThan(BigDecimal value) {
            addCriterion("PAYEE_FEE <", value, "payeeFee");
            return (Criteria) this;
        }

        public Criteria andPayeeFeeLessThanOrEqualTo(BigDecimal value) {
            addCriterion("PAYEE_FEE <=", value, "payeeFee");
            return (Criteria) this;
        }

        public Criteria andPayeeFeeIn(List<BigDecimal> values) {
            addCriterion("PAYEE_FEE in", values, "payeeFee");
            return (Criteria) this;
        }

        public Criteria andPayeeFeeNotIn(List<BigDecimal> values) {
            addCriterion("PAYEE_FEE not in", values, "payeeFee");
            return (Criteria) this;
        }

        public Criteria andPayeeFeeBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("PAYEE_FEE between", value1, value2, "payeeFee");
            return (Criteria) this;
        }

        public Criteria andPayeeFeeNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("PAYEE_FEE not between", value1, value2, "payeeFee");
            return (Criteria) this;
        }

        public Criteria andIsPermitPricingErrIsNull() {
            addCriterion("IS_PERMIT_PRICING_ERR is null");
            return (Criteria) this;
        }

        public Criteria andIsPermitPricingErrIsNotNull() {
            addCriterion("IS_PERMIT_PRICING_ERR is not null");
            return (Criteria) this;
        }

        public Criteria andIsPermitPricingErrEqualTo(Integer value) {
            addCriterion("IS_PERMIT_PRICING_ERR =", value, "isPermitPricingErr");
            return (Criteria) this;
        }

        public Criteria andIsPermitPricingErrNotEqualTo(Integer value) {
            addCriterion("IS_PERMIT_PRICING_ERR <>", value, "isPermitPricingErr");
            return (Criteria) this;
        }

        public Criteria andIsPermitPricingErrGreaterThan(Integer value) {
            addCriterion("IS_PERMIT_PRICING_ERR >", value, "isPermitPricingErr");
            return (Criteria) this;
        }

        public Criteria andIsPermitPricingErrGreaterThanOrEqualTo(Integer value) {
            addCriterion("IS_PERMIT_PRICING_ERR >=", value, "isPermitPricingErr");
            return (Criteria) this;
        }

        public Criteria andIsPermitPricingErrLessThan(Integer value) {
            addCriterion("IS_PERMIT_PRICING_ERR <", value, "isPermitPricingErr");
            return (Criteria) this;
        }

        public Criteria andIsPermitPricingErrLessThanOrEqualTo(Integer value) {
            addCriterion("IS_PERMIT_PRICING_ERR <=", value, "isPermitPricingErr");
            return (Criteria) this;
        }

        public Criteria andIsPermitPricingErrIn(List<Integer> values) {
            addCriterion("IS_PERMIT_PRICING_ERR in", values, "isPermitPricingErr");
            return (Criteria) this;
        }

        public Criteria andIsPermitPricingErrNotIn(List<Integer> values) {
            addCriterion("IS_PERMIT_PRICING_ERR not in", values, "isPermitPricingErr");
            return (Criteria) this;
        }

        public Criteria andIsPermitPricingErrBetween(Integer value1, Integer value2) {
            addCriterion("IS_PERMIT_PRICING_ERR between", value1, value2, "isPermitPricingErr");
            return (Criteria) this;
        }

        public Criteria andIsPermitPricingErrNotBetween(Integer value1, Integer value2) {
            addCriterion("IS_PERMIT_PRICING_ERR not between", value1, value2, "isPermitPricingErr");
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

        public Criteria andBankCodeIsNull() {
            addCriterion("BANK_CODE is null");
            return (Criteria) this;
        }

        public Criteria andBankCodeIsNotNull() {
            addCriterion("BANK_CODE is not null");
            return (Criteria) this;
        }

        public Criteria andBankCodeEqualTo(String value) {
            addCriterion("BANK_CODE =", value, "bankCode");
            return (Criteria) this;
        }

        public Criteria andBankCodeNotEqualTo(String value) {
            addCriterion("BANK_CODE <>", value, "bankCode");
            return (Criteria) this;
        }

        public Criteria andBankCodeGreaterThan(String value) {
            addCriterion("BANK_CODE >", value, "bankCode");
            return (Criteria) this;
        }

        public Criteria andBankCodeGreaterThanOrEqualTo(String value) {
            addCriterion("BANK_CODE >=", value, "bankCode");
            return (Criteria) this;
        }

        public Criteria andBankCodeLessThan(String value) {
            addCriterion("BANK_CODE <", value, "bankCode");
            return (Criteria) this;
        }

        public Criteria andBankCodeLessThanOrEqualTo(String value) {
            addCriterion("BANK_CODE <=", value, "bankCode");
            return (Criteria) this;
        }

        public Criteria andBankCodeLike(String value) {
            addCriterion("BANK_CODE like", value, "bankCode");
            return (Criteria) this;
        }

        public Criteria andBankCodeNotLike(String value) {
            addCriterion("BANK_CODE not like", value, "bankCode");
            return (Criteria) this;
        }

        public Criteria andBankCodeIn(List<String> values) {
            addCriterion("BANK_CODE in", values, "bankCode");
            return (Criteria) this;
        }

        public Criteria andBankCodeNotIn(List<String> values) {
            addCriterion("BANK_CODE not in", values, "bankCode");
            return (Criteria) this;
        }

        public Criteria andBankCodeBetween(String value1, String value2) {
            addCriterion("BANK_CODE between", value1, value2, "bankCode");
            return (Criteria) this;
        }

        public Criteria andBankCodeNotBetween(String value1, String value2) {
            addCriterion("BANK_CODE not between", value1, value2, "bankCode");
            return (Criteria) this;
        }

        public Criteria andBankNameIsNull() {
            addCriterion("BANK_NAME is null");
            return (Criteria) this;
        }

        public Criteria andBankNameIsNotNull() {
            addCriterion("BANK_NAME is not null");
            return (Criteria) this;
        }

        public Criteria andBankNameEqualTo(String value) {
            addCriterion("BANK_NAME =", value, "bankName");
            return (Criteria) this;
        }

        public Criteria andBankNameNotEqualTo(String value) {
            addCriterion("BANK_NAME <>", value, "bankName");
            return (Criteria) this;
        }

        public Criteria andBankNameGreaterThan(String value) {
            addCriterion("BANK_NAME >", value, "bankName");
            return (Criteria) this;
        }

        public Criteria andBankNameGreaterThanOrEqualTo(String value) {
            addCriterion("BANK_NAME >=", value, "bankName");
            return (Criteria) this;
        }

        public Criteria andBankNameLessThan(String value) {
            addCriterion("BANK_NAME <", value, "bankName");
            return (Criteria) this;
        }

        public Criteria andBankNameLessThanOrEqualTo(String value) {
            addCriterion("BANK_NAME <=", value, "bankName");
            return (Criteria) this;
        }

        public Criteria andBankNameLike(String value) {
            addCriterion("BANK_NAME like", value, "bankName");
            return (Criteria) this;
        }

        public Criteria andBankNameNotLike(String value) {
            addCriterion("BANK_NAME not like", value, "bankName");
            return (Criteria) this;
        }

        public Criteria andBankNameIn(List<String> values) {
            addCriterion("BANK_NAME in", values, "bankName");
            return (Criteria) this;
        }

        public Criteria andBankNameNotIn(List<String> values) {
            addCriterion("BANK_NAME not in", values, "bankName");
            return (Criteria) this;
        }

        public Criteria andBankNameBetween(String value1, String value2) {
            addCriterion("BANK_NAME between", value1, value2, "bankName");
            return (Criteria) this;
        }

        public Criteria andBankNameNotBetween(String value1, String value2) {
            addCriterion("BANK_NAME not between", value1, value2, "bankName");
            return (Criteria) this;
        }

        public Criteria andBankBranchIsNull() {
            addCriterion("BANK_BRANCH is null");
            return (Criteria) this;
        }

        public Criteria andBankBranchIsNotNull() {
            addCriterion("BANK_BRANCH is not null");
            return (Criteria) this;
        }

        public Criteria andBankBranchEqualTo(String value) {
            addCriterion("BANK_BRANCH =", value, "bankBranch");
            return (Criteria) this;
        }

        public Criteria andBankBranchNotEqualTo(String value) {
            addCriterion("BANK_BRANCH <>", value, "bankBranch");
            return (Criteria) this;
        }

        public Criteria andBankBranchGreaterThan(String value) {
            addCriterion("BANK_BRANCH >", value, "bankBranch");
            return (Criteria) this;
        }

        public Criteria andBankBranchGreaterThanOrEqualTo(String value) {
            addCriterion("BANK_BRANCH >=", value, "bankBranch");
            return (Criteria) this;
        }

        public Criteria andBankBranchLessThan(String value) {
            addCriterion("BANK_BRANCH <", value, "bankBranch");
            return (Criteria) this;
        }

        public Criteria andBankBranchLessThanOrEqualTo(String value) {
            addCriterion("BANK_BRANCH <=", value, "bankBranch");
            return (Criteria) this;
        }

        public Criteria andBankBranchLike(String value) {
            addCriterion("BANK_BRANCH like", value, "bankBranch");
            return (Criteria) this;
        }

        public Criteria andBankBranchNotLike(String value) {
            addCriterion("BANK_BRANCH not like", value, "bankBranch");
            return (Criteria) this;
        }

        public Criteria andBankBranchIn(List<String> values) {
            addCriterion("BANK_BRANCH in", values, "bankBranch");
            return (Criteria) this;
        }

        public Criteria andBankBranchNotIn(List<String> values) {
            addCriterion("BANK_BRANCH not in", values, "bankBranch");
            return (Criteria) this;
        }

        public Criteria andBankBranchBetween(String value1, String value2) {
            addCriterion("BANK_BRANCH between", value1, value2, "bankBranch");
            return (Criteria) this;
        }

        public Criteria andBankBranchNotBetween(String value1, String value2) {
            addCriterion("BANK_BRANCH not between", value1, value2, "bankBranch");
            return (Criteria) this;
        }

        public Criteria andBankLinenoIsNull() {
            addCriterion("BANK_LINENO is null");
            return (Criteria) this;
        }

        public Criteria andBankLinenoIsNotNull() {
            addCriterion("BANK_LINENO is not null");
            return (Criteria) this;
        }

        public Criteria andBankLinenoEqualTo(String value) {
            addCriterion("BANK_LINENO =", value, "bankLineno");
            return (Criteria) this;
        }

        public Criteria andBankLinenoNotEqualTo(String value) {
            addCriterion("BANK_LINENO <>", value, "bankLineno");
            return (Criteria) this;
        }

        public Criteria andBankLinenoGreaterThan(String value) {
            addCriterion("BANK_LINENO >", value, "bankLineno");
            return (Criteria) this;
        }

        public Criteria andBankLinenoGreaterThanOrEqualTo(String value) {
            addCriterion("BANK_LINENO >=", value, "bankLineno");
            return (Criteria) this;
        }

        public Criteria andBankLinenoLessThan(String value) {
            addCriterion("BANK_LINENO <", value, "bankLineno");
            return (Criteria) this;
        }

        public Criteria andBankLinenoLessThanOrEqualTo(String value) {
            addCriterion("BANK_LINENO <=", value, "bankLineno");
            return (Criteria) this;
        }

        public Criteria andBankLinenoLike(String value) {
            addCriterion("BANK_LINENO like", value, "bankLineno");
            return (Criteria) this;
        }

        public Criteria andBankLinenoNotLike(String value) {
            addCriterion("BANK_LINENO not like", value, "bankLineno");
            return (Criteria) this;
        }

        public Criteria andBankLinenoIn(List<String> values) {
            addCriterion("BANK_LINENO in", values, "bankLineno");
            return (Criteria) this;
        }

        public Criteria andBankLinenoNotIn(List<String> values) {
            addCriterion("BANK_LINENO not in", values, "bankLineno");
            return (Criteria) this;
        }

        public Criteria andBankLinenoBetween(String value1, String value2) {
            addCriterion("BANK_LINENO between", value1, value2, "bankLineno");
            return (Criteria) this;
        }

        public Criteria andBankLinenoNotBetween(String value1, String value2) {
            addCriterion("BANK_LINENO not between", value1, value2, "bankLineno");
            return (Criteria) this;
        }

        public Criteria andBankProvinceIsNull() {
            addCriterion("BANK_PROVINCE is null");
            return (Criteria) this;
        }

        public Criteria andBankProvinceIsNotNull() {
            addCriterion("BANK_PROVINCE is not null");
            return (Criteria) this;
        }

        public Criteria andBankProvinceEqualTo(String value) {
            addCriterion("BANK_PROVINCE =", value, "bankProvince");
            return (Criteria) this;
        }

        public Criteria andBankProvinceNotEqualTo(String value) {
            addCriterion("BANK_PROVINCE <>", value, "bankProvince");
            return (Criteria) this;
        }

        public Criteria andBankProvinceGreaterThan(String value) {
            addCriterion("BANK_PROVINCE >", value, "bankProvince");
            return (Criteria) this;
        }

        public Criteria andBankProvinceGreaterThanOrEqualTo(String value) {
            addCriterion("BANK_PROVINCE >=", value, "bankProvince");
            return (Criteria) this;
        }

        public Criteria andBankProvinceLessThan(String value) {
            addCriterion("BANK_PROVINCE <", value, "bankProvince");
            return (Criteria) this;
        }

        public Criteria andBankProvinceLessThanOrEqualTo(String value) {
            addCriterion("BANK_PROVINCE <=", value, "bankProvince");
            return (Criteria) this;
        }

        public Criteria andBankProvinceLike(String value) {
            addCriterion("BANK_PROVINCE like", value, "bankProvince");
            return (Criteria) this;
        }

        public Criteria andBankProvinceNotLike(String value) {
            addCriterion("BANK_PROVINCE not like", value, "bankProvince");
            return (Criteria) this;
        }

        public Criteria andBankProvinceIn(List<String> values) {
            addCriterion("BANK_PROVINCE in", values, "bankProvince");
            return (Criteria) this;
        }

        public Criteria andBankProvinceNotIn(List<String> values) {
            addCriterion("BANK_PROVINCE not in", values, "bankProvince");
            return (Criteria) this;
        }

        public Criteria andBankProvinceBetween(String value1, String value2) {
            addCriterion("BANK_PROVINCE between", value1, value2, "bankProvince");
            return (Criteria) this;
        }

        public Criteria andBankProvinceNotBetween(String value1, String value2) {
            addCriterion("BANK_PROVINCE not between", value1, value2, "bankProvince");
            return (Criteria) this;
        }

        public Criteria andBankCityIsNull() {
            addCriterion("BANK_CITY is null");
            return (Criteria) this;
        }

        public Criteria andBankCityIsNotNull() {
            addCriterion("BANK_CITY is not null");
            return (Criteria) this;
        }

        public Criteria andBankCityEqualTo(String value) {
            addCriterion("BANK_CITY =", value, "bankCity");
            return (Criteria) this;
        }

        public Criteria andBankCityNotEqualTo(String value) {
            addCriterion("BANK_CITY <>", value, "bankCity");
            return (Criteria) this;
        }

        public Criteria andBankCityGreaterThan(String value) {
            addCriterion("BANK_CITY >", value, "bankCity");
            return (Criteria) this;
        }

        public Criteria andBankCityGreaterThanOrEqualTo(String value) {
            addCriterion("BANK_CITY >=", value, "bankCity");
            return (Criteria) this;
        }

        public Criteria andBankCityLessThan(String value) {
            addCriterion("BANK_CITY <", value, "bankCity");
            return (Criteria) this;
        }

        public Criteria andBankCityLessThanOrEqualTo(String value) {
            addCriterion("BANK_CITY <=", value, "bankCity");
            return (Criteria) this;
        }

        public Criteria andBankCityLike(String value) {
            addCriterion("BANK_CITY like", value, "bankCity");
            return (Criteria) this;
        }

        public Criteria andBankCityNotLike(String value) {
            addCriterion("BANK_CITY not like", value, "bankCity");
            return (Criteria) this;
        }

        public Criteria andBankCityIn(List<String> values) {
            addCriterion("BANK_CITY in", values, "bankCity");
            return (Criteria) this;
        }

        public Criteria andBankCityNotIn(List<String> values) {
            addCriterion("BANK_CITY not in", values, "bankCity");
            return (Criteria) this;
        }

        public Criteria andBankCityBetween(String value1, String value2) {
            addCriterion("BANK_CITY between", value1, value2, "bankCity");
            return (Criteria) this;
        }

        public Criteria andBankCityNotBetween(String value1, String value2) {
            addCriterion("BANK_CITY not between", value1, value2, "bankCity");
            return (Criteria) this;
        }

        public Criteria andPayeeNameIsNull() {
            addCriterion("PAYEE_NAME is null");
            return (Criteria) this;
        }

        public Criteria andPayeeNameIsNotNull() {
            addCriterion("PAYEE_NAME is not null");
            return (Criteria) this;
        }

        public Criteria andPayeeNameEqualTo(String value) {
            addCriterion("PAYEE_NAME =", value, "payeeName");
            return (Criteria) this;
        }

        public Criteria andPayeeNameNotEqualTo(String value) {
            addCriterion("PAYEE_NAME <>", value, "payeeName");
            return (Criteria) this;
        }

        public Criteria andPayeeNameGreaterThan(String value) {
            addCriterion("PAYEE_NAME >", value, "payeeName");
            return (Criteria) this;
        }

        public Criteria andPayeeNameGreaterThanOrEqualTo(String value) {
            addCriterion("PAYEE_NAME >=", value, "payeeName");
            return (Criteria) this;
        }

        public Criteria andPayeeNameLessThan(String value) {
            addCriterion("PAYEE_NAME <", value, "payeeName");
            return (Criteria) this;
        }

        public Criteria andPayeeNameLessThanOrEqualTo(String value) {
            addCriterion("PAYEE_NAME <=", value, "payeeName");
            return (Criteria) this;
        }

        public Criteria andPayeeNameLike(String value) {
            addCriterion("PAYEE_NAME like", value, "payeeName");
            return (Criteria) this;
        }

        public Criteria andPayeeNameNotLike(String value) {
            addCriterion("PAYEE_NAME not like", value, "payeeName");
            return (Criteria) this;
        }

        public Criteria andPayeeNameIn(List<String> values) {
            addCriterion("PAYEE_NAME in", values, "payeeName");
            return (Criteria) this;
        }

        public Criteria andPayeeNameNotIn(List<String> values) {
            addCriterion("PAYEE_NAME not in", values, "payeeName");
            return (Criteria) this;
        }

        public Criteria andPayeeNameBetween(String value1, String value2) {
            addCriterion("PAYEE_NAME between", value1, value2, "payeeName");
            return (Criteria) this;
        }

        public Criteria andPayeeNameNotBetween(String value1, String value2) {
            addCriterion("PAYEE_NAME not between", value1, value2, "payeeName");
            return (Criteria) this;
        }

        public Criteria andPayeeCardNoIsNull() {
            addCriterion("PAYEE_CARD_NO is null");
            return (Criteria) this;
        }

        public Criteria andPayeeCardNoIsNotNull() {
            addCriterion("PAYEE_CARD_NO is not null");
            return (Criteria) this;
        }

        public Criteria andPayeeCardNoEqualTo(String value) {
            addCriterion("PAYEE_CARD_NO =", value, "payeeCardNo");
            return (Criteria) this;
        }

        public Criteria andPayeeCardNoNotEqualTo(String value) {
            addCriterion("PAYEE_CARD_NO <>", value, "payeeCardNo");
            return (Criteria) this;
        }

        public Criteria andPayeeCardNoGreaterThan(String value) {
            addCriterion("PAYEE_CARD_NO >", value, "payeeCardNo");
            return (Criteria) this;
        }

        public Criteria andPayeeCardNoGreaterThanOrEqualTo(String value) {
            addCriterion("PAYEE_CARD_NO >=", value, "payeeCardNo");
            return (Criteria) this;
        }

        public Criteria andPayeeCardNoLessThan(String value) {
            addCriterion("PAYEE_CARD_NO <", value, "payeeCardNo");
            return (Criteria) this;
        }

        public Criteria andPayeeCardNoLessThanOrEqualTo(String value) {
            addCriterion("PAYEE_CARD_NO <=", value, "payeeCardNo");
            return (Criteria) this;
        }

        public Criteria andPayeeCardNoLike(String value) {
            addCriterion("PAYEE_CARD_NO like", value, "payeeCardNo");
            return (Criteria) this;
        }

        public Criteria andPayeeCardNoNotLike(String value) {
            addCriterion("PAYEE_CARD_NO not like", value, "payeeCardNo");
            return (Criteria) this;
        }

        public Criteria andPayeeCardNoIn(List<String> values) {
            addCriterion("PAYEE_CARD_NO in", values, "payeeCardNo");
            return (Criteria) this;
        }

        public Criteria andPayeeCardNoNotIn(List<String> values) {
            addCriterion("PAYEE_CARD_NO not in", values, "payeeCardNo");
            return (Criteria) this;
        }

        public Criteria andPayeeCardNoBetween(String value1, String value2) {
            addCriterion("PAYEE_CARD_NO between", value1, value2, "payeeCardNo");
            return (Criteria) this;
        }

        public Criteria andPayeeCardNoNotBetween(String value1, String value2) {
            addCriterion("PAYEE_CARD_NO not between", value1, value2, "payeeCardNo");
            return (Criteria) this;
        }

        public Criteria andPayeePurposeIsNull() {
            addCriterion("PAYEE_PURPOSE is null");
            return (Criteria) this;
        }

        public Criteria andPayeePurposeIsNotNull() {
            addCriterion("PAYEE_PURPOSE is not null");
            return (Criteria) this;
        }

        public Criteria andPayeePurposeEqualTo(String value) {
            addCriterion("PAYEE_PURPOSE =", value, "payeePurpose");
            return (Criteria) this;
        }

        public Criteria andPayeePurposeNotEqualTo(String value) {
            addCriterion("PAYEE_PURPOSE <>", value, "payeePurpose");
            return (Criteria) this;
        }

        public Criteria andPayeePurposeGreaterThan(String value) {
            addCriterion("PAYEE_PURPOSE >", value, "payeePurpose");
            return (Criteria) this;
        }

        public Criteria andPayeePurposeGreaterThanOrEqualTo(String value) {
            addCriterion("PAYEE_PURPOSE >=", value, "payeePurpose");
            return (Criteria) this;
        }

        public Criteria andPayeePurposeLessThan(String value) {
            addCriterion("PAYEE_PURPOSE <", value, "payeePurpose");
            return (Criteria) this;
        }

        public Criteria andPayeePurposeLessThanOrEqualTo(String value) {
            addCriterion("PAYEE_PURPOSE <=", value, "payeePurpose");
            return (Criteria) this;
        }

        public Criteria andPayeePurposeLike(String value) {
            addCriterion("PAYEE_PURPOSE like", value, "payeePurpose");
            return (Criteria) this;
        }

        public Criteria andPayeePurposeNotLike(String value) {
            addCriterion("PAYEE_PURPOSE not like", value, "payeePurpose");
            return (Criteria) this;
        }

        public Criteria andPayeePurposeIn(List<String> values) {
            addCriterion("PAYEE_PURPOSE in", values, "payeePurpose");
            return (Criteria) this;
        }

        public Criteria andPayeePurposeNotIn(List<String> values) {
            addCriterion("PAYEE_PURPOSE not in", values, "payeePurpose");
            return (Criteria) this;
        }

        public Criteria andPayeePurposeBetween(String value1, String value2) {
            addCriterion("PAYEE_PURPOSE between", value1, value2, "payeePurpose");
            return (Criteria) this;
        }

        public Criteria andPayeePurposeNotBetween(String value1, String value2) {
            addCriterion("PAYEE_PURPOSE not between", value1, value2, "payeePurpose");
            return (Criteria) this;
        }

        public Criteria andCardTypeIsNull() {
            addCriterion("CARD_TYPE is null");
            return (Criteria) this;
        }

        public Criteria andCardTypeIsNotNull() {
            addCriterion("CARD_TYPE is not null");
            return (Criteria) this;
        }

        public Criteria andCardTypeEqualTo(String value) {
            addCriterion("CARD_TYPE =", value, "cardType");
            return (Criteria) this;
        }

        public Criteria andCardTypeNotEqualTo(String value) {
            addCriterion("CARD_TYPE <>", value, "cardType");
            return (Criteria) this;
        }

        public Criteria andCardTypeGreaterThan(String value) {
            addCriterion("CARD_TYPE >", value, "cardType");
            return (Criteria) this;
        }

        public Criteria andCardTypeGreaterThanOrEqualTo(String value) {
            addCriterion("CARD_TYPE >=", value, "cardType");
            return (Criteria) this;
        }

        public Criteria andCardTypeLessThan(String value) {
            addCriterion("CARD_TYPE <", value, "cardType");
            return (Criteria) this;
        }

        public Criteria andCardTypeLessThanOrEqualTo(String value) {
            addCriterion("CARD_TYPE <=", value, "cardType");
            return (Criteria) this;
        }

        public Criteria andCardTypeLike(String value) {
            addCriterion("CARD_TYPE like", value, "cardType");
            return (Criteria) this;
        }

        public Criteria andCardTypeNotLike(String value) {
            addCriterion("CARD_TYPE not like", value, "cardType");
            return (Criteria) this;
        }

        public Criteria andCardTypeIn(List<String> values) {
            addCriterion("CARD_TYPE in", values, "cardType");
            return (Criteria) this;
        }

        public Criteria andCardTypeNotIn(List<String> values) {
            addCriterion("CARD_TYPE not in", values, "cardType");
            return (Criteria) this;
        }

        public Criteria andCardTypeBetween(String value1, String value2) {
            addCriterion("CARD_TYPE between", value1, value2, "cardType");
            return (Criteria) this;
        }

        public Criteria andCardTypeNotBetween(String value1, String value2) {
            addCriterion("CARD_TYPE not between", value1, value2, "cardType");
            return (Criteria) this;
        }

        public Criteria andCompanyOrPersonalIsNull() {
            addCriterion("COMPANY_OR_PERSONAL is null");
            return (Criteria) this;
        }

        public Criteria andCompanyOrPersonalIsNotNull() {
            addCriterion("COMPANY_OR_PERSONAL is not null");
            return (Criteria) this;
        }

        public Criteria andCompanyOrPersonalEqualTo(String value) {
            addCriterion("COMPANY_OR_PERSONAL =", value, "companyOrPersonal");
            return (Criteria) this;
        }

        public Criteria andCompanyOrPersonalNotEqualTo(String value) {
            addCriterion("COMPANY_OR_PERSONAL <>", value, "companyOrPersonal");
            return (Criteria) this;
        }

        public Criteria andCompanyOrPersonalGreaterThan(String value) {
            addCriterion("COMPANY_OR_PERSONAL >", value, "companyOrPersonal");
            return (Criteria) this;
        }

        public Criteria andCompanyOrPersonalGreaterThanOrEqualTo(String value) {
            addCriterion("COMPANY_OR_PERSONAL >=", value, "companyOrPersonal");
            return (Criteria) this;
        }

        public Criteria andCompanyOrPersonalLessThan(String value) {
            addCriterion("COMPANY_OR_PERSONAL <", value, "companyOrPersonal");
            return (Criteria) this;
        }

        public Criteria andCompanyOrPersonalLessThanOrEqualTo(String value) {
            addCriterion("COMPANY_OR_PERSONAL <=", value, "companyOrPersonal");
            return (Criteria) this;
        }

        public Criteria andCompanyOrPersonalLike(String value) {
            addCriterion("COMPANY_OR_PERSONAL like", value, "companyOrPersonal");
            return (Criteria) this;
        }

        public Criteria andCompanyOrPersonalNotLike(String value) {
            addCriterion("COMPANY_OR_PERSONAL not like", value, "companyOrPersonal");
            return (Criteria) this;
        }

        public Criteria andCompanyOrPersonalIn(List<String> values) {
            addCriterion("COMPANY_OR_PERSONAL in", values, "companyOrPersonal");
            return (Criteria) this;
        }

        public Criteria andCompanyOrPersonalNotIn(List<String> values) {
            addCriterion("COMPANY_OR_PERSONAL not in", values, "companyOrPersonal");
            return (Criteria) this;
        }

        public Criteria andCompanyOrPersonalBetween(String value1, String value2) {
            addCriterion("COMPANY_OR_PERSONAL between", value1, value2, "companyOrPersonal");
            return (Criteria) this;
        }

        public Criteria andCompanyOrPersonalNotBetween(String value1, String value2) {
            addCriterion("COMPANY_OR_PERSONAL not between", value1, value2, "companyOrPersonal");
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

        public Criteria andGmtBizInitiateEqualTo(Date value) {
            addCriterion("GMT_BIZ_INITIATE =", value, "gmtBizInitiate");
            return (Criteria) this;
        }

        public Criteria andGmtBizInitiateNotEqualTo(Date value) {
            addCriterion("GMT_BIZ_INITIATE <>", value, "gmtBizInitiate");
            return (Criteria) this;
        }

        public Criteria andGmtBizInitiateGreaterThan(Date value) {
            addCriterion("GMT_BIZ_INITIATE >", value, "gmtBizInitiate");
            return (Criteria) this;
        }

        public Criteria andGmtBizInitiateGreaterThanOrEqualTo(Date value) {
            addCriterion("GMT_BIZ_INITIATE >=", value, "gmtBizInitiate");
            return (Criteria) this;
        }

        public Criteria andGmtBizInitiateLessThan(Date value) {
            addCriterion("GMT_BIZ_INITIATE <", value, "gmtBizInitiate");
            return (Criteria) this;
        }

        public Criteria andGmtBizInitiateLessThanOrEqualTo(Date value) {
            addCriterion("GMT_BIZ_INITIATE <=", value, "gmtBizInitiate");
            return (Criteria) this;
        }

        public Criteria andGmtBizInitiateIn(List<Date> values) {
            addCriterion("GMT_BIZ_INITIATE in", values, "gmtBizInitiate");
            return (Criteria) this;
        }

        public Criteria andGmtBizInitiateNotIn(List<Date> values) {
            addCriterion("GMT_BIZ_INITIATE not in", values, "gmtBizInitiate");
            return (Criteria) this;
        }

        public Criteria andGmtBizInitiateBetween(Date value1, Date value2) {
            addCriterion("GMT_BIZ_INITIATE between", value1, value2, "gmtBizInitiate");
            return (Criteria) this;
        }

        public Criteria andGmtBizInitiateNotBetween(Date value1, Date value2) {
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

        public Criteria andGmtPaymentInitiateEqualTo(Date value) {
            addCriterion("GMT_PAYMENT_INITIATE =", value, "gmtPaymentInitiate");
            return (Criteria) this;
        }

        public Criteria andGmtPaymentInitiateNotEqualTo(Date value) {
            addCriterion("GMT_PAYMENT_INITIATE <>", value, "gmtPaymentInitiate");
            return (Criteria) this;
        }

        public Criteria andGmtPaymentInitiateGreaterThan(Date value) {
            addCriterion("GMT_PAYMENT_INITIATE >", value, "gmtPaymentInitiate");
            return (Criteria) this;
        }

        public Criteria andGmtPaymentInitiateGreaterThanOrEqualTo(Date value) {
            addCriterion("GMT_PAYMENT_INITIATE >=", value, "gmtPaymentInitiate");
            return (Criteria) this;
        }

        public Criteria andGmtPaymentInitiateLessThan(Date value) {
            addCriterion("GMT_PAYMENT_INITIATE <", value, "gmtPaymentInitiate");
            return (Criteria) this;
        }

        public Criteria andGmtPaymentInitiateLessThanOrEqualTo(Date value) {
            addCriterion("GMT_PAYMENT_INITIATE <=", value, "gmtPaymentInitiate");
            return (Criteria) this;
        }

        public Criteria andGmtPaymentInitiateIn(List<Date> values) {
            addCriterion("GMT_PAYMENT_INITIATE in", values, "gmtPaymentInitiate");
            return (Criteria) this;
        }

        public Criteria andGmtPaymentInitiateNotIn(List<Date> values) {
            addCriterion("GMT_PAYMENT_INITIATE not in", values, "gmtPaymentInitiate");
            return (Criteria) this;
        }

        public Criteria andGmtPaymentInitiateBetween(Date value1, Date value2) {
            addCriterion("GMT_PAYMENT_INITIATE between", value1, value2, "gmtPaymentInitiate");
            return (Criteria) this;
        }

        public Criteria andGmtPaymentInitiateNotBetween(Date value1, Date value2) {
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

        public Criteria andRemitAmountEqualTo(BigDecimal value) {
            addCriterion("REMIT_AMOUNT =", value, "remitAmount");
            return (Criteria) this;
        }

        public Criteria andRemitAmountNotEqualTo(BigDecimal value) {
            addCriterion("REMIT_AMOUNT <>", value, "remitAmount");
            return (Criteria) this;
        }

        public Criteria andRemitAmountGreaterThan(BigDecimal value) {
            addCriterion("REMIT_AMOUNT >", value, "remitAmount");
            return (Criteria) this;
        }

        public Criteria andRemitAmountGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("REMIT_AMOUNT >=", value, "remitAmount");
            return (Criteria) this;
        }

        public Criteria andRemitAmountLessThan(BigDecimal value) {
            addCriterion("REMIT_AMOUNT <", value, "remitAmount");
            return (Criteria) this;
        }

        public Criteria andRemitAmountLessThanOrEqualTo(BigDecimal value) {
            addCriterion("REMIT_AMOUNT <=", value, "remitAmount");
            return (Criteria) this;
        }

        public Criteria andRemitAmountIn(List<BigDecimal> values) {
            addCriterion("REMIT_AMOUNT in", values, "remitAmount");
            return (Criteria) this;
        }

        public Criteria andRemitAmountNotIn(List<BigDecimal> values) {
            addCriterion("REMIT_AMOUNT not in", values, "remitAmount");
            return (Criteria) this;
        }

        public Criteria andRemitAmountBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("REMIT_AMOUNT between", value1, value2, "remitAmount");
            return (Criteria) this;
        }

        public Criteria andRemitAmountNotBetween(BigDecimal value1, BigDecimal value2) {
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

        public Criteria andReqExtentionIsNull() {
            addCriterion("REQ_EXTENTION is null");
            return (Criteria) this;
        }

        public Criteria andReqExtentionIsNotNull() {
            addCriterion("REQ_EXTENTION is not null");
            return (Criteria) this;
        }

        public Criteria andReqExtentionEqualTo(String value) {
            addCriterion("REQ_EXTENTION =", value, "reqExtention");
            return (Criteria) this;
        }

        public Criteria andReqExtentionNotEqualTo(String value) {
            addCriterion("REQ_EXTENTION <>", value, "reqExtention");
            return (Criteria) this;
        }

        public Criteria andReqExtentionGreaterThan(String value) {
            addCriterion("REQ_EXTENTION >", value, "reqExtention");
            return (Criteria) this;
        }

        public Criteria andReqExtentionGreaterThanOrEqualTo(String value) {
            addCriterion("REQ_EXTENTION >=", value, "reqExtention");
            return (Criteria) this;
        }

        public Criteria andReqExtentionLessThan(String value) {
            addCriterion("REQ_EXTENTION <", value, "reqExtention");
            return (Criteria) this;
        }

        public Criteria andReqExtentionLessThanOrEqualTo(String value) {
            addCriterion("REQ_EXTENTION <=", value, "reqExtention");
            return (Criteria) this;
        }

        public Criteria andReqExtentionLike(String value) {
            addCriterion("REQ_EXTENTION like", value, "reqExtention");
            return (Criteria) this;
        }

        public Criteria andReqExtentionNotLike(String value) {
            addCriterion("REQ_EXTENTION not like", value, "reqExtention");
            return (Criteria) this;
        }

        public Criteria andReqExtentionIn(List<String> values) {
            addCriterion("REQ_EXTENTION in", values, "reqExtention");
            return (Criteria) this;
        }

        public Criteria andReqExtentionNotIn(List<String> values) {
            addCriterion("REQ_EXTENTION not in", values, "reqExtention");
            return (Criteria) this;
        }

        public Criteria andReqExtentionBetween(String value1, String value2) {
            addCriterion("REQ_EXTENTION between", value1, value2, "reqExtention");
            return (Criteria) this;
        }

        public Criteria andReqExtentionNotBetween(String value1, String value2) {
            addCriterion("REQ_EXTENTION not between", value1, value2, "reqExtention");
            return (Criteria) this;
        }

        public Criteria andWithdrawStatusIsNull() {
            addCriterion("WITHDRAW_STATUS is null");
            return (Criteria) this;
        }

        public Criteria andWithdrawStatusIsNotNull() {
            addCriterion("WITHDRAW_STATUS is not null");
            return (Criteria) this;
        }

        public Criteria andWithdrawStatusEqualTo(String value) {
            addCriterion("WITHDRAW_STATUS =", value, "withdrawStatus");
            return (Criteria) this;
        }

        public Criteria andWithdrawStatusNotEqualTo(String value) {
            addCriterion("WITHDRAW_STATUS <>", value, "withdrawStatus");
            return (Criteria) this;
        }

        public Criteria andWithdrawStatusGreaterThan(String value) {
            addCriterion("WITHDRAW_STATUS >", value, "withdrawStatus");
            return (Criteria) this;
        }

        public Criteria andWithdrawStatusGreaterThanOrEqualTo(String value) {
            addCriterion("WITHDRAW_STATUS >=", value, "withdrawStatus");
            return (Criteria) this;
        }

        public Criteria andWithdrawStatusLessThan(String value) {
            addCriterion("WITHDRAW_STATUS <", value, "withdrawStatus");
            return (Criteria) this;
        }

        public Criteria andWithdrawStatusLessThanOrEqualTo(String value) {
            addCriterion("WITHDRAW_STATUS <=", value, "withdrawStatus");
            return (Criteria) this;
        }

        public Criteria andWithdrawStatusLike(String value) {
            addCriterion("WITHDRAW_STATUS like", value, "withdrawStatus");
            return (Criteria) this;
        }

        public Criteria andWithdrawStatusNotLike(String value) {
            addCriterion("WITHDRAW_STATUS not like", value, "withdrawStatus");
            return (Criteria) this;
        }

        public Criteria andWithdrawStatusIn(List<String> values) {
            addCriterion("WITHDRAW_STATUS in", values, "withdrawStatus");
            return (Criteria) this;
        }

        public Criteria andWithdrawStatusNotIn(List<String> values) {
            addCriterion("WITHDRAW_STATUS not in", values, "withdrawStatus");
            return (Criteria) this;
        }

        public Criteria andWithdrawStatusBetween(String value1, String value2) {
            addCriterion("WITHDRAW_STATUS between", value1, value2, "withdrawStatus");
            return (Criteria) this;
        }

        public Criteria andWithdrawStatusNotBetween(String value1, String value2) {
            addCriterion("WITHDRAW_STATUS not between", value1, value2, "withdrawStatus");
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
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table FW_WITHDRAW_REQ_FOS_DETAIL
     *
     * @mbggenerated do_not_delete_during_merge Fri Mar 11 19:55:35 CST 2016
     */
    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table FW_WITHDRAW_REQ_FOS_DETAIL
     * table comment :出款业务调用FOS详细表
     *
     * @mbggenerated Fri Mar 11 19:55:35 CST 2016
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