package com.sdp.mc.common.enums;

public enum OpObjTypeEnums {
	
	// 0：代理商
	// 1：商户
	/**
	 * 代理商
	 */
	PROMOTER(0, "代理商"),
	/**
	 * 商户
	 */
	MERCHANT(1, "商户"), ;
	public final int code;
	public final String desc;

	OpObjTypeEnums(int code, String desc) {
		this.code = code;
		this.desc = desc;
	}

	public int getCode() {
		return code;
	}

	public String getDesc() {
		return desc;
	}

}
