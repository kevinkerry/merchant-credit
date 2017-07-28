package com.shengpay.debit.common.enums;

public enum AutoPaymentFileTypeEnum {
	REQUESTFILE("1","请求文件"),
	REPONSEFILE("2","响应文件");
	AutoPaymentFileTypeEnum(String code, String desc) {
		this.code = code;
		this.desc = desc;
	}

	public final String code;
	public final String desc;
}
