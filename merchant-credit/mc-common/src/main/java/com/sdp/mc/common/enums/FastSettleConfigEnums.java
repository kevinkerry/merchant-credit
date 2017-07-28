package com.sdp.mc.common.enums;

public enum FastSettleConfigEnums {

	MERCHANT(1,"商户"),
	AGENT(0,"代理商")
	;
	private int code;
	private String desc ;

	FastSettleConfigEnums(int code,String desc){
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
