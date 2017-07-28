package com.sdp.mc.common.enums;

/**
     额度的类型
     ⊙临时，每月1号自动调整     ○永久，一经设置永远不变
 *
 */
public enum FastSettleOpenTypeEnums {
	PROMOTER_OPEN(1, "代理商开通"),
	SYSTEM_OPEN(0, "系统开通");
	public final int code;
	public final String desc;

	FastSettleOpenTypeEnums(int code, String desc) {
		this.code = code;
		this.desc = desc;
	}

}
