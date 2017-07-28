package com.shengpay.debit.dal.ext.dataobject;

public class ExtTbWithholdingInfoExample extends ExtTbWithholdingBrechInfoExample {
	private static final long serialVersionUID = 1L;
	// 银行名称 bank_name
	private String bankName;
	// 卡号 card_no
	private String cardNo;
	// 证件号 paper_no
	private String paperNo;
	// 姓名 ch_name
	private String chName;
	//代扣类型
	private String bizType;
	//钱包账号
	private String wallteNo;

	public String getWallteNo() {
		return wallteNo;
	}

	public void setWallteNo(String wallteNo) {
		this.wallteNo = wallteNo;
	}

	public String getBizType() {
		return bizType;
	}

	public void setBizType(String bizType) {
		this.bizType = bizType;
	}

	public String getBankName() {
		return bankName;
	}

	public void setBankName(String bankName) {
		this.bankName = bankName;
	}

	public String getCardNo() {
		return cardNo;
	}

	public void setCardNo(String cardNo) {
		this.cardNo = cardNo;
	}

	public String getPaperNo() {
		return paperNo;
	}

	public void setPaperNo(String paperNo) {
		this.paperNo = paperNo;
	}

	public String getChName() {
		return chName;
	}

	public void setChName(String chName) {
		this.chName = chName;
	}

}