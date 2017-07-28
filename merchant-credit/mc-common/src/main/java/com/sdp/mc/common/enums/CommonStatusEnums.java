package com.sdp.mc.common.enums;

/**
       白名单状态
 *
 */
public enum CommonStatusEnums {
	LOSE_EFFICACY(0, "失效"),
	TAKE_EFFECT(1, "生效");
	public final Integer code;
	public final String desc;

	CommonStatusEnums(Integer code, String desc) {
		this.code = code;
		this.desc = desc;
	}

}
