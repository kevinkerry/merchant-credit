package com.sdp.mc.integration.fos.dto.request;

import java.io.Serializable;
import java.math.BigDecimal;

import com.sdp.mc.common.constant.MerchantCreditConstant;
import com.sdp.mc.integration.fos.enums.FOSPaymentCodeEnum;
import com.sdp.mc.integration.fos.enums.FOSProductCodeEnum;

public class RemitTransferRequestDTO implements Serializable {

	private static final long serialVersionUID = 1L;
	private Long marginTransId;
	/**
	 * appId
	 */
	private String appId;
	/** 转账订单号 **/
	private String remitVoucherNo;
	/** 付款人id **/
	private String payerMemberId;
	/** 收款人id **/
	private String payeeMemberId;
	/** 付款人储值账户ID **/
	private String payerAccountNo;
	@SuppressWarnings("unused")
	private String memo;

	/**
	 * 付款人储值账户 类型 MerchantCreditConstant.ACCOUNT_TYPE_4_PUBLIC
	 * MerchantCreditConstant.ACCOUNT_TYPE_4_MARGIN
	 */
	private Long payerAccountType;
	/** 收款人储值账户ID **/
	private String payeeAccountNo;
	/**
	 * 收款人储值账户类型 MerchantCreditConstant.ACCOUNT_TYPE_4_PUBLIC
	 * MerchantCreditConstant.ACCOUNT_TYPE_4_MARGIN
	 */
	private Long payeeAccountType;
	/** 转账金额 **/
	private BigDecimal remitAmount;
	/** 产品编码 **/
	private FOSProductCodeEnum productCode;
	/** 支付编码 **/
	private FOSPaymentCodeEnum paymentCode;

	/** 业务订单号 **/
	private String bizId;
	/** 业务类型 **/
	private String bizType;

	/**
	 * productCode+ paymentCode+ remitVoucherNo
	 * 
	 * @return
	 */
	public String getRemitVoucherNo() {
		// productCode+ paymentCode+ remitVoucherNo
		return paymentCode.code + paymentCode.code + remitVoucherNo;
	}

	public Long getMarginTransId() {
		return marginTransId;
	}

	public void setMarginTransId(Long marginTransId) {
		this.marginTransId = marginTransId;
	}

	/**
	 * 付款人储值账户 类型 MerchantCreditConstant.ACCOUNT_TYPE_4_PUBLIC
	 * MerchantCreditConstant.ACCOUNT_TYPE_4_MARGIN
	 */
	public Long getPayerAccountType() {
		return payerAccountType;
	}

	/**
	 * 付款人储值账户 类型 MerchantCreditConstant.ACCOUNT_TYPE_4_PUBLIC
	 * MerchantCreditConstant.ACCOUNT_TYPE_4_MARGIN
	 */
	public void setPayerAccountType(Long payerAccountType) {
		this.payerAccountType = payerAccountType;
	}

	/**
	 * 收款人储值账户类型 MerchantCreditConstant.ACCOUNT_TYPE_4_PUBLIC
	 * MerchantCreditConstant.ACCOUNT_TYPE_4_MARGIN
	 */
	public Long getPayeeAccountType() {
		return payeeAccountType;
	}

	/**
	 * 收款人储值账户类型 MerchantCreditConstant.ACCOUNT_TYPE_4_PUBLIC
	 * MerchantCreditConstant.ACCOUNT_TYPE_4_MARGIN
	 */
	public void setPayeeAccountType(Long payeeAccountType) {
		this.payeeAccountType = payeeAccountType;
	}

	public void setRemitVoucherNo(String remitVoucherNo) {
		this.remitVoucherNo = remitVoucherNo;
	}

	// public void setMemo(String memo) {
	// this.memo = memo;
	// }

	public String getPayerMemberId() {
		return payerMemberId;
	}

	public void setPayerMemberId(String payerMemberId) {
		this.payerMemberId = payerMemberId;
	}

	public String getPayeeMemberId() {
		return payeeMemberId;
	}

	public void setPayeeMemberId(String payeeMemberId) {
		this.payeeMemberId = payeeMemberId;
	}

	public String getPayerAccountNo() {
		return payerAccountNo;
	}

	public void setPayerAccountNo(String payerAccountNo) {
		this.payerAccountNo = payerAccountNo;
	}

	public String getPayeeAccountNo() {
		return payeeAccountNo;
	}

	public void setPayeeAccountNo(String payeeAccountNo) {
		this.payeeAccountNo = payeeAccountNo;
	}

	public BigDecimal getRemitAmount() {
		return remitAmount;
	}

	public void setRemitAmount(BigDecimal remitAmount) {
		this.remitAmount = remitAmount;
	}

	public FOSProductCodeEnum getProductCode() {
		return productCode;
	}

	public void setProductCode(FOSProductCodeEnum productCode) {
		this.productCode = productCode;
	}

	public FOSPaymentCodeEnum getPaymentCode() {
		return paymentCode;
	}

	public void setPaymentCode(FOSPaymentCodeEnum paymentCode) {
		this.paymentCode = paymentCode;
	}

	public void setMemo(String memo) {
		this.memo = memo;
	}

	public String getMemo() {
		return MerchantCreditConstant.REMIT_TRANSFER_REQUEST_MEMO;
	}

	public String getAppId() {
		return appId;
	}

	public void setAppId(String appId) {
		this.appId = appId;
	}

	public String getBizId() {
		return bizId;
	}

	public void setBizId(String bizId) {
		this.bizId = bizId;
	}

	public String getBizType() {
		return bizType;
	}

	public void setBizType(String bizType) {
		this.bizType = bizType;
	}

	public String toString() {
		return "RemitTransferRequestDTO [" + (remitVoucherNo != null ? "remitVoucherNo=" + remitVoucherNo + ", " : "")
				+ (payerMemberId != null ? "payerMemberId=" + payerMemberId + ", " : "") + (payeeMemberId != null ? "payeeMemberId=" + payeeMemberId + ", " : "")
				+ (payerAccountNo != null ? "payerAccountNo=" + payerAccountNo + ", " : "") + (payerAccountType != null ? "payerAccountType=" + payerAccountType + ", " : "")
				+ (payeeAccountNo != null ? "payeeAccountNo=" + payeeAccountNo + ", " : "") + (payeeAccountType != null ? "payeeAccountType=" + payeeAccountType + ", " : "")
				+ (remitAmount != null ? "remitAmount=" + remitAmount + ", " : "") + (paymentCode != null ? "paymentCode=" + paymentCode : "")
				+ (bizId != null ? "bizId=" + bizId : "") + (bizType != null ? "bizType=" + bizType : "") + "]";
	}

}
