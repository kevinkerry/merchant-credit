package com.sdp.mc.integration.fos.dto.request;

import java.io.Serializable;

/**
 * 订单查询请求
 * @author wangmindong
 *
 */
public class WithdrawT0QueryRequestDTO implements Serializable{

	private static final long serialVersionUID = 8393474512616775962L;

	/** 监控ID **/
	private String sourceCode     ;
	/** 产品编码 **/
	private String productCode    ;
	/** 支付编码 **/
	private String paymentCode    ;
	/** 批次号 **/
	private String batchNo        ;
	/** 产品订单号 **/
	private String remitVoucherNo;



	public String getSourceCode() {
		return sourceCode;
	}
	public void setSourceCode(String sourceCode) {
		this.sourceCode = sourceCode;
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
	public String getBatchNo() {
		return batchNo;
	}
	public void setBatchNo(String batchNo) {
		this.batchNo = batchNo;
	}
	public String getRemitVoucherNo() {
		return remitVoucherNo;
	}
	public void setRemitVoucherNo(String remitVoucherNo) {
		this.remitVoucherNo = remitVoucherNo;
	}
}
