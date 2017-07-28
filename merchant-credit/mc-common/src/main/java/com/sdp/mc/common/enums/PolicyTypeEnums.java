package com.sdp.mc.common.enums;

public enum PolicyTypeEnums {
	POLICY(1, "政策类"),
	MCC(2, "MCC类"),
	EASYPAY(3, "云收银类"),
	;

	public final int type;
	public final String desc;

	private PolicyTypeEnums(int type, String desc) {
		this.type = type;
		this.desc = desc;
	}

	public int getType() {
		return type;
	}

	public String getDesc() {
		return desc;
	}
}
