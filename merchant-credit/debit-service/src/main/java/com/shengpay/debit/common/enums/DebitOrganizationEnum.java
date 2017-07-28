package com.shengpay.debit.common.enums;

/**
 * 放款机构枚举
 * **/
public enum DebitOrganizationEnum {
	SFT("SFT","盛付通"),
	SHENGPAY("shengpay","盛付通");
	DebitOrganizationEnum(String code, String desc) {
		this.code = code;
		this.desc = desc;
	}

	public final String code;
	public final String desc;
}
