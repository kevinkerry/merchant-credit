package com.sdp.mc.common.enums;

public enum FundOutReceiptSubmitResultCodeEnums {

	FAIL("F", "失败"),
	SUCCESS("S", "成功"),
	EXCEPTION("E", "异常");

	public final String code;
	public final String desc;

	FundOutReceiptSubmitResultCodeEnums(String code, String desc) {
		
		this.code = code;
		this.desc = desc;
	}

}
