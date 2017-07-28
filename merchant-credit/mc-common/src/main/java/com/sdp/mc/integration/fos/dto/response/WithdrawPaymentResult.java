package com.sdp.mc.integration.fos.dto.response;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

public class WithdrawPaymentResult {

	/**产品编码**/
	private String productCode;
	/** 支付编码 **/
	private String paymentCode;
	/** 产品订单号 **/
	private String remitVoucherNo;
	/** 付款方会员ID **/
	private String payerMemberId;
	/** PE的支付流水号 **/
	private String paymentSeqNo;
	/**实际金额**/
	private BigDecimal pocketAmount;
	/**付款方费用**/
	private BigDecimal payerFee;
	/** 收款方费用 **/
	private BigDecimal payeeFee;
	/** 支付状态 **/
	private String paymentState;
	/** 结算时间 **/
	private String settlementTime; // yyyyMMddHHmmss
	/** 支付返回码 **/
	private String returnCode;
	/** 支付返回描述 **/
	private String returnMsg;
	/** 扩展信息 **/
	private Map<String, String> extension = new HashMap<String, String>();
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
	public Map<String, String> getExtension() {
		return extension;
	}
	public void setExtension(Map<String, String> extension) {
		this.extension = extension;
	}
}
