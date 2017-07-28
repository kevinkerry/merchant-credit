package com.sdp.mc.common.enums;

/**
     额度的类型
     ⊙临时，每月1号自动调整     ○永久，一经设置永远不变
 *
 */
public enum LimitTypeEnums {
	TEMPORARY("1", "临时"),
	PERMANENT("2", "永久");
	public final String code;
	public final String desc;

	LimitTypeEnums(String code, String desc) {
		this.code = code;
		this.desc = desc;
	}

}
