package com.shengpay.debit.common.enums;

public enum LoanOperaTypeEnum {
	AGREE("0","同意放款"),
	REFUSE("1","拒绝放款");
	public final String code;
	public final String desc;
	LoanOperaTypeEnum(String code,String desc){
		this.code = code;
		this.desc = desc;
	}
}
