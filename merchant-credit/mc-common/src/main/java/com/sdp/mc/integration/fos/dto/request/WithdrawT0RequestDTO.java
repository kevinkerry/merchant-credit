package com.sdp.mc.integration.fos.dto.request;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * 出款请求
 * @author wangmindong
 *
 */
public class WithdrawT0RequestDTO implements Serializable{

	private static final long serialVersionUID = -4818216705927202588L;

	/** 支付产品码 **/
	private String productCode;
	/** 4位监控ID **/
	private String appId;
	/** 支付编码 **/
	private String paymentCode;
	/** 出款订单号 **/
	private String remitVoucherNo;
	/** 付款人会员ID **/
	private String payerMemberId;
	/** 是否需要计费 **/
	private Boolean isNeedCountFee;
	/** 付款人费用 **/
	private BigDecimal payerFee;
	/** 收款人费用 **/
	private BigDecimal payeeFee;
	/** **/
	private boolean isPermitPricingErr;
	/** 是否允许计费异常 **/
	private String payerAccountNo;
	/** 付款人储值账户ID **/
	private String bankCode;
	/** 开户行名称 **/
	private String bankName;
	/** 支行编码 **/
	private String bankBranch;
	/**支行编码      (联行号)  32  可空 **/
	private String bankLineNo;
	/** 银行所属省份 **/
	private String bankProvince;
	/**银行所属城市 **/
	private String bankCity;
	/** 收款人姓名**/
	private String payeeName;
	/**收款人卡号 **/
	private String payeeCardNo;
	/**用途  **/
	private String payeePurpose;
	/**卡类型  **/
	private String cardType;
	/**账户类型**/
	private String companyOrPersonal;
	/** 业务发起时间 **/
	private Date gmtBizInitiate;
	/**支付发起时间  **/
	private Date gmtPaymentInitiate;
	/** 出款金额 **/
	private BigDecimal remitAmount;
	/**支付结果回调地址 **/
	private String callbackAddress;
	/** 备注信息 **/
	private String memo;
	/**币种 **/
	private String currency;
	/**扩展信息  **/
	private String extention;
	public String getProductCode() {
		return productCode;
	}
	public void setProductCode(String productCode) {
		this.productCode = productCode;
	}
	public String getAppId() {
		return appId;
	}
	public void setAppId(String appId) {
		this.appId = appId;
	}
	public String getPaymentCode() {
		return paymentCode;
	}
	public void setPaymentCode(String paymentCode) {
		this.paymentCode = paymentCode;
	}
	public String getRemitVoucherNo() {
		return remitVoucherNo;
	}
	public void setRemitVoucherNo(String remitVoucherNo) {
		this.remitVoucherNo = remitVoucherNo;
	}
	public String getPayerMemberId() {
		return payerMemberId;
	}
	public void setPayerMemberId(String payerMemberId) {
		this.payerMemberId = payerMemberId;
	}
	public Boolean getIsNeedCountFee() {
		return isNeedCountFee;
	}
	public void setIsNeedCountFee(Boolean isNeedCountFee) {
		this.isNeedCountFee = isNeedCountFee;
	}
	public BigDecimal getPayerFee() {
		return payerFee;
	}
	public void setPayerFee(BigDecimal payerFee) {
		this.payerFee = payerFee;
	}
	public BigDecimal getPayeeFee() {
		return payeeFee;
	}
	public void setPayeeFee(BigDecimal payeeFee) {
		this.payeeFee = payeeFee;
	}
	public boolean isPermitPricingErr() {
		return isPermitPricingErr;
	}
	public void setPermitPricingErr(boolean isPermitPricingErr) {
		this.isPermitPricingErr = isPermitPricingErr;
	}
	public String getPayerAccountNo() {
		return payerAccountNo;
	}
	public void setPayerAccountNo(String payerAccountNo) {
		this.payerAccountNo = payerAccountNo;
	}
	public String getBankCode() {
		return bankCode;
	}
	public void setBankCode(String bankCode) {
		this.bankCode = bankCode;
	}
	public String getBankName() {
		return bankName;
	}
	public void setBankName(String bankName) {
		this.bankName = bankName;
	}
	public String getBankBranch() {
		return bankBranch;
	}
	public void setBankBranch(String bankBranch) {
		this.bankBranch = bankBranch;
	}
	public String getBankLineNo() {
		return bankLineNo;
	}
	public void setBankLineNo(String bankLineNo) {
		this.bankLineNo = bankLineNo;
	}
	public String getBankProvince() {
		return bankProvince;
	}
	public void setBankProvince(String bankProvince) {
		this.bankProvince = bankProvince;
	}
	public String getBankCity() {
		return bankCity;
	}
	public void setBankCity(String bankCity) {
		this.bankCity = bankCity;
	}
	public String getPayeeName() {
		return payeeName;
	}
	public void setPayeeName(String payeeName) {
		this.payeeName = payeeName;
	}
	public String getPayeeCardNo() {
		return payeeCardNo;
	}
	public void setPayeeCardNo(String payeeCardNo) {
		this.payeeCardNo = payeeCardNo;
	}
	public String getPayeePurpose() {
		return payeePurpose;
	}
	public void setPayeePurpose(String payeePurpose) {
		this.payeePurpose = payeePurpose;
	}
	public String getCardType() {
		return cardType;
	}
	public void setCardType(String cardType) {
		this.cardType = cardType;
	}
	public String getCompanyOrPersonal() {
		return companyOrPersonal;
	}
	public void setCompanyOrPersonal(String companyOrPersonal) {
		this.companyOrPersonal = companyOrPersonal;
	}
	public Date getGmtBizInitiate() {
		return gmtBizInitiate;
	}
	public void setGmtBizInitiate(Date gmtBizInitiate) {
		this.gmtBizInitiate = gmtBizInitiate;
	}
	public Date getGmtPaymentInitiate() {
		return gmtPaymentInitiate;
	}
	public void setGmtPaymentInitiate(Date gmtPaymentInitiate) {
		this.gmtPaymentInitiate = gmtPaymentInitiate;
	}

	public BigDecimal getRemitAmount() {
		return remitAmount;
	}
	public void setRemitAmount(BigDecimal remitAmount) {
		this.remitAmount = remitAmount;
	}
	public String getCallbackAddress() {
		return callbackAddress;
	}
	public void setCallbackAddress(String callbackAddress) {
		this.callbackAddress = callbackAddress;
	}
	public String getMemo() {
		return memo;
	}
	public void setMemo(String memo) {
		this.memo = memo;
	}
	public String getCurrency() {
		return currency;
	}
	public void setCurrency(String currency) {
		this.currency = currency;
	}
	public String getExtention() {
		return extention;
	}
	public void setExtention(String extention) {
		this.extention = extention;
	}

}
