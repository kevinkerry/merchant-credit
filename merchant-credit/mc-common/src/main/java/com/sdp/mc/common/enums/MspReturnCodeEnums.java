package com.sdp.mc.common.enums;

public enum MspReturnCodeEnums {
	SUCCESS("0", "成功"), FAILUE("1", "失败");
	public final String code;
	public final String name;

	MspReturnCodeEnums(String code, String name) {
		this.code = code;
		this.name = name;
	}
}
