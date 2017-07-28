package com.sdp.mc.sars.bean;

import java.util.Date;


public class SarsCP261Bean extends SarsParentBean {

	private static final String checkPoint = "CP261";


	/**
	 * 商户号
	 */
	private String merchantNo;
	/**
	 * 申请时间
	 */
	private String orderTime;
	/**
	 * terminalType（终端类型POS/MPOS）, 
	 */
	private String terminalType;
	
	/**
	 * certificationCardCount(认证卡数)，
	 */
	private int certificationCardCount;
	/**
	 * isBindCard（绑定提现银行卡：0（未绑卡），1（已绑定））
	 */
	private String isBindCard;

	/**
	 * 商户号
	 */
	public String getMerchantNo() {
		return merchantNo;
	}

	/**
	 * 商户号
	 */
	public void setMerchantNo(String merchantNo) {
		this.merchantNo = merchantNo;
	}

	/**
	 * 申请时间
	 */
	public String getOrderTime() {
		return orderTime;
	}

	/**
	 * 申请时间
	 */
	public void setOrderTime(String orderTime) {
		this.orderTime = orderTime;
	}

	public String getTerminalType() {
		return terminalType;
	}

	public void setTerminalType(String terminalType) {
		this.terminalType = terminalType;
	}

	public int getCertificationCardCount() {
		return certificationCardCount;
	}

	public void setCertificationCardCount(int certificationCardCount) {
		this.certificationCardCount = certificationCardCount;
	}

	

	public String getIsBindCard() {
		return isBindCard;
	}

	public void setIsBindCard(String isBindCard) {
		this.isBindCard = isBindCard;
	}

	public static String getCheckpoint() {
		return checkPoint;
	}

	public SarsCP261Bean(String merchantNo, Date date, String terminalType, int certificationCardCount, String isBindCard) {
		super(checkPoint);
		this.merchantNo = merchantNo;
		this.orderTime = date2Str(date);
		this.terminalType = terminalType;
		this.certificationCardCount = certificationCardCount;
		this.isBindCard = isBindCard;
	}
	
	

}
