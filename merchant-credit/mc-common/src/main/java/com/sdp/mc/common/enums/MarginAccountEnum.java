package com.sdp.mc.common.enums;

public enum MarginAccountEnum {
	INIT("0","初始化"),
	SUCCESS("1","成功"),
	FAILUE("-1","失败");
	public final String code;
	public final String name;

	MarginAccountEnum(String code, String name) {
		this.code = code;
		this.name = name;
	}
}
