package com.sdp.mc.integration.fos.dto.response;

import java.io.Serializable;
import java.math.BigDecimal;

public class RemitTransferResponseDTO implements Serializable {

	private static final long serialVersionUID = 1L;
	private boolean isSuccess;
	private boolean isFee;
	private Long marginTransId;
	private String productCode;
	private String paymentCode;
	private String remitVoucherNo;
	private String payerMemberId;
	private String payeeMemberId;
	private String paymentSeqNo;
	private BigDecimal pocketAmount;
	private BigDecimal payerFee;
	private BigDecimal payeeFee;
	private String paymentState;
	private String settlementTime; // yyyyMMddHHmmss
	private String returnCode;
	private String returnMsg;

	public RemitTransferResponseDTO(boolean isSuccess) {
		this.isSuccess = isSuccess;
	}

	public RemitTransferResponseDTO(boolean isSuccess, String returnCode, String returnMsg) {
		this.isSuccess = isSuccess;
		this.returnCode = returnCode;
		this.returnMsg = returnMsg;
	}

	public boolean isSuccess() {
		return isSuccess;
	}

	public void setSuccess(boolean isSuccess) {
		this.isSuccess = isSuccess;
	}

	public Long getMarginTransId() {
		return marginTransId;
	}

	public void setMarginTransId(Long marginTransId) {
		this.marginTransId = marginTransId;
	}

	public String getProductCode() {
		return productCode;
	}

	public void setProductCode(String productCode) {
		this.productCode = productCode;
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

	public String getPayeeMemberId() {
		return payeeMemberId;
	}

	public void setPayeeMemberId(String payeeMemberId) {
		this.payeeMemberId = payeeMemberId;
	}

	public String getPaymentSeqNo() {
		return paymentSeqNo;
	}

	public void setPaymentSeqNo(String paymentSeqNo) {
		this.paymentSeqNo = paymentSeqNo;
	}

	public BigDecimal getPocketAmount() {
		return pocketAmount;
	}

	public void setPocketAmount(BigDecimal pocketAmount) {
		this.pocketAmount = pocketAmount;
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

	public String getPaymentState() {
		return paymentState;
	}

	public void setPaymentState(String paymentState) {
		this.paymentState = paymentState;
	}

	public String getSettlementTime() {
		return settlementTime;
	}

	public void setSettlementTime(String settlementTime) {
		this.settlementTime = settlementTime;
	}

	public String getReturnCode() {
		return returnCode;
	}

	public void setReturnCode(String returnCode) {
		this.returnCode = returnCode;
	}

	public String getReturnMsg() {
		return returnMsg;
	}

	public void setReturnMsg(String returnMsg) {
		this.returnMsg = returnMsg;
	}

	public boolean isFee() {
		return isFee;
	}

	public void setFee(boolean isFee) {
		this.isFee = isFee;
	}

	@Override
	public String toString() {
		return "RemitTransferResponseDTO [isSuccess=" + isSuccess + ",isFee=" + isFee + ",marginTransId=" + marginTransId + ", "
				+ (productCode != null ? "productCode=" + productCode + ", " : "") + (paymentCode != null ? "paymentCode=" + paymentCode + ", " : "")
				+ (remitVoucherNo != null ? "remitVoucherNo=" + remitVoucherNo + ", " : "") + (payerMemberId != null ? "payerMemberId=" + payerMemberId + ", " : "")
				+ (payeeMemberId != null ? "payeeMemberId=" + payeeMemberId + ", " : "") + (paymentSeqNo != null ? "paymentSeqNo=" + paymentSeqNo + ", " : "")
				+ (pocketAmount != null ? "pocketAmount=" + pocketAmount + ", " : "") + (payerFee != null ? "payerFee=" + payerFee + ", " : "")
				+ (payeeFee != null ? "payeeFee=" + payeeFee + ", " : "") + (paymentState != null ? "paymentState=" + paymentState + ", " : "")
				+ (settlementTime != null ? "settlementTime=" + settlementTime + ", " : "") + (returnCode != null ? "returnCode=" + returnCode + ", " : "")
				+ (returnMsg != null ? "returnMsg=" + returnMsg : "") + "]";
	}

}
