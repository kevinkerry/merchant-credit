package com.sdp.mc.sars.bean;

import java.math.BigDecimal;


public class SarsCP160Bean extends SarsParentBean {
	
	private static final String checkPoint = "CP160";
	
	private String merchantNo;
	private String terminalType;
	private String settlementType;
	private String amount;
	private String remitVoucherNo;
	
	public SarsCP160Bean() {
		super(checkPoint);
	}
	
	

	public SarsCP160Bean(String merchantNo, String terminalType, String settlementType, String amount,String remitVoucherNo) {
		super(checkPoint);
		this.merchantNo = merchantNo;
		this.terminalType = terminalType;
		this.settlementType = settlementType;
		this.amount = amount;
		this.remitVoucherNo = remitVoucherNo;
	}



	public String getMerchantNo() {
		return merchantNo;
	}

	public void setMerchantNo(String merchantNo) {
		this.merchantNo = merchantNo;
	}

	public String getTerminalType() {
		return terminalType;
	}

	public void setTerminalType(String terminalType) {
		this.terminalType = terminalType;
	}

	public String getSettlementType() {
		return settlementType;
	}

	public void setSettlementType(String settlementType) {
		this.settlementType = settlementType;
	}

	public String getAmount() {
		return amount;
	}

	public void setAmount(String amount) {
		this.amount = amount;
	}



	public String getRemitVoucherNo() {
		return remitVoucherNo;
	}



	public void setRemitVoucherNo(String remitVoucherNo) {
		this.remitVoucherNo = remitVoucherNo;
	}
	
	
	

}
