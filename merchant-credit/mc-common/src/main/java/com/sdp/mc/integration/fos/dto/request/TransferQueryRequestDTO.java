package com.sdp.mc.integration.fos.dto.request;

import java.io.Serializable;

import com.sdp.mc.integration.fos.enums.FOSPaymentCodeEnum;

public class TransferQueryRequestDTO implements Serializable {

	private static final long serialVersionUID = 1L;
	/** 支付编码 **/
	private FOSPaymentCodeEnum paymentCode;
	/** 转账订单号 **/
	private String remitVoucherNo;

	public FOSPaymentCodeEnum getPaymentCode() {
		return paymentCode;
	}

	public void setPaymentCode(FOSPaymentCodeEnum paymentCode) {
		this.paymentCode = paymentCode;
	}

	public String getRemitVoucherNo() {
		return remitVoucherNo;
	}

	public void setRemitVoucherNo(String remitVoucherNo) {
		this.remitVoucherNo = remitVoucherNo;
	}
}
