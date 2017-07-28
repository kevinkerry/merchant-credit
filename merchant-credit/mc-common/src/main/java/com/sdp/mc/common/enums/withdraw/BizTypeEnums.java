package com.sdp.mc.common.enums.withdraw;

public enum BizTypeEnums {
	/**
	 * POS商户/POS代理商：1；
	 */
	POS_MERCHANT_TYPE(1, "POS商户/POS代理商");

	public final int code;
	public final String desc;

	BizTypeEnums(int code, String desc) {
		this.code = code;
		this.desc = desc;
	}
}
