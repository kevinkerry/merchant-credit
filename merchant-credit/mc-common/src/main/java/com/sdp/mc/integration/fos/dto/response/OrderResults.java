package com.sdp.mc.integration.fos.dto.response;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Map;

import net.sf.json.JSONObject;

public class OrderResults implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 7603549365913985574L;
	private String paymentCode;
	private String remitVoucherNo;
	private String prodCode;
	private String payerMemberId;
	private BigDecimal payerFee;
	private BigDecimal payeeFee;
	private BigDecimal pocketAmount;
	private String paymentSeqNo;
	private String paymentState;
	private String callbackAddress;
	private String returnCode;
	private String returnMsg;
	private Map<String, Object> extension;

	public static OrderResults json2Bean(String json) {
		return (OrderResults) JSONObject.toBean(JSONObject.fromObject(json), OrderResults.class);
	}

	public static String bean2Json(OrderResults bean) {
		return JSONObject.fromObject(bean).toString();
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

	public String getProdCode() {
		return prodCode;
	}

	public void setProdCode(String prodCode) {
		this.prodCode = prodCode;
	}

	public String getPayerMemberId() {
		return payerMemberId;
	}

	public void setPayerMemberId(String payerMemberId) {
		this.payerMemberId = payerMemberId;
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

	public void setPocketAmount(BigDecimal pocketAmount) {
		this.pocketAmount = pocketAmount;
	}

	public BigDecimal getPocketAmount() {
		return pocketAmount;
	}

	public String getPaymentSeqNo() {
		return paymentSeqNo;
	}

	public void setPaymentSeqNo(String paymentSeqNo) {
		this.paymentSeqNo = paymentSeqNo;
	}

	public String getPaymentState() {
		return paymentState;
	}

	public void setPaymentState(String paymentState) {
		this.paymentState = paymentState;
	}

	public String getCallbackAddress() {
		return callbackAddress;
	}

	public void setCallbackAddress(String callbackAddress) {
		this.callbackAddress = callbackAddress;
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

	public Map<String, Object> getExtension() {
		return extension;
	}

	public void setExtension(Map<String, Object> extension) {
		this.extension = extension;
	}

}
