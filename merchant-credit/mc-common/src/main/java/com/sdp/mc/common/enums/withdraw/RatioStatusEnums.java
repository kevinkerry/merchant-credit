package com.sdp.mc.common.enums.withdraw;

public enum RatioStatusEnums {
	/**
	 * 生效
	 */
	active(1, "生效"),
	/**
	 * 失效
	 */
	expire(0, "失效"), ;
	public final int code;
	public final String desc;

	RatioStatusEnums(int code, String desc) {
		this.code = code;
		this.desc = desc;
	}
}
