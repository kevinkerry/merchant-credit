package com.sdp.mc.common.enums.withdraw;

public enum LogOPTypeEnums {

	CREATE("C", "CREATE"), UPDATE("U", "UPDATE"), DELETE("D", "DELETE"), ;
	public final String code;
	public final String desc;

	LogOPTypeEnums(String code, String desc) {
		this.code = code;
		this.desc = desc;
	}

}
