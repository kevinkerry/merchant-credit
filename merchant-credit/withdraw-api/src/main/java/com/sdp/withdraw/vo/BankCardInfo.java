package com.sdp.withdraw.vo;

import java.io.Serializable;

public class BankCardInfo implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String bankCode  ;//开户行  32  不可空     
	private String bankName ;// 开户行名称  128  可空    
	private String bankBranch ;// 支行名称  128  可空    
	private String bankLineNo ;// 支行编码(联行号)  32  可空    
	private String bankProvince ;// 银行所属省份  64  可空    
	private String bankCity  ;//银行所属城市  64  可空    
	private String name ;// 收款人姓名  50  不可空    
	private String cardNo  ;//收款人卡号  30  不可空    
	private String cardType  ;//卡类型  3  可空     DC  
	private String companyOrPersonal  ;//账户类型  3  可空    "B":对公 ， "C"：对私
	
	public String getBankCode() {
		return bankCode;
	}
	public void setBankCode(String bankCode) {
		this.bankCode = bankCode;
	}
	public String getBankName() {
		return bankName;
	}
	public void setBankName(String bankName) {
		this.bankName = bankName;
	}
	public String getBankBranch() {
		return bankBranch;
	}
	public void setBankBranch(String bankBranch) {
		this.bankBranch = bankBranch;
	}
	public String getBankLineNo() {
		return bankLineNo;
	}
	public void setBankLineNo(String bankLineNo) {
		this.bankLineNo = bankLineNo;
	}
	public String getBankProvince() {
		return bankProvince;
	}
	public void setBankProvince(String bankProvince) {
		this.bankProvince = bankProvince;
	}
	public String getBankCity() {
		return bankCity;
	}
	public void setBankCity(String bankCity) {
		this.bankCity = bankCity;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCardNo() {
		return cardNo;
	}
	public void setCardNo(String cardNo) {
		this.cardNo = cardNo;
	}
	public String getCardType() {
		return cardType;
	}
	public void setCardType(String cardType) {
		this.cardType = cardType;
	}
	public String getCompanyOrPersonal() {
		return companyOrPersonal;
	}
	public void setCompanyOrPersonal(String companyOrPersonal) {
		this.companyOrPersonal = companyOrPersonal;
	}
	public BankCardInfo(String bankCode, String bankName, String bankBranch, String bankLineNo, String bankProvince, String bankCity, String name,
			String cardNo, String cardType, String companyOrPersonal) {
		super();
		this.bankCode = bankCode;
		this.bankName = bankName;
		this.bankBranch = bankBranch;
		this.bankLineNo = bankLineNo;
		this.bankProvince = bankProvince;
		this.bankCity = bankCity;
		this.name = name;
		this.cardNo = cardNo;
		this.cardType = cardType;
		this.companyOrPersonal = companyOrPersonal;
	}
	public BankCardInfo() {
		super();
	}
	
	
	
	                

}
