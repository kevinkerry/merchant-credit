package com.sdp.mc.integration.fos.dto.response;

import java.io.Serializable;
import java.math.BigDecimal;

public class TransferQueryResponseDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	private boolean isSuccess;
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

	public TransferQueryResponseDTO(boolean isSuccess){
		this.isSuccess = isSuccess;
	}
	
	public boolean isSuccess() {
		return isSuccess;
	}

	public void setSuccess(boolean isSuccess) {
		this.isSuccess = isSuccess;
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
}
