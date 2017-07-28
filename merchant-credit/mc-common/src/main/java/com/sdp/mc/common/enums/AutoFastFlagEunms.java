package com.sdp.mc.common.enums;

public enum AutoFastFlagEunms {
	PROMOTER_AUTOFLAG_TRUE("0", "代理商全资 并且自动快速结算已经开通"),
	SHENGPAY_AUTOFLAG_TRUE("1", "盛付通全资 并且自动快速结算已经开通"),
	PROMOTER_AUTOFLAG_FALSE("2", "代理商全资 并且自动快速结算已经关闭"),
	DEFAULt_VALUE("99", "默认返回：表示没有对应的枚举"),
	SHENGPAY_AUTOFLAG_FALSE("3", "盛付通全资 并且自动快速结算已经关闭");
	private String code;
	private String desc;

	AutoFastFlagEunms(String code, String desc) {
		this.code = code;
		this.desc = desc;
	}

	public String getCode() {
		return code;
	}

	public String getDesc() {
		return desc;
	}

	public static AutoFastFlagEunms getLoaningTypeEnum(String value) {
		if (value == null) {// 改用integer类型，在此判断，业务共同调用
			return DEFAULt_VALUE;
		}
		AutoFastFlagEunms AutoFastFlagEunm[] = AutoFastFlagEunms.values();
		for (AutoFastFlagEunms autoFastFlagEunms : AutoFastFlagEunm) {
			if (autoFastFlagEunms.getCode() == value) {// code是int的不用equals
				return autoFastFlagEunms;
			}
		}
		return DEFAULt_VALUE;
	}
}
