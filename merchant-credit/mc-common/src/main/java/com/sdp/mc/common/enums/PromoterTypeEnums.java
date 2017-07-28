package com.sdp.mc.common.enums;

public enum PromoterTypeEnums {
//	mcType=='0003' 普通POS商户
//	mcType=='0007' mPOS商户
	POS("0003","普通POS商户"),
	MPOS("0007","普通POS商户"),
	;
	private final String code;
	private final String name;
	
	PromoterTypeEnums(String code,String name){
		this.code = code;
		this.name = name;
	}

	public String getCode() {
		return code;
	}

	public String getName() {
		return name;
	}
	
	
}
