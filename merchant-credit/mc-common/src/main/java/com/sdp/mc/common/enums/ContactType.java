package com.sdp.mc.common.enums;

public enum ContactType {

	/**
	 * 0L, "会员联系信息"
	 */
	MEMBER(0L, "会员联系信息"),
	/**
	 * 1L, "操作员联系信息"
	 */
	OPERATOR(1L, "操作员联系信息");

	public final long code;
	public final String desc;

	ContactType(long code, String desc) {
		this.code = code;
		this.desc = desc;
	}

}
