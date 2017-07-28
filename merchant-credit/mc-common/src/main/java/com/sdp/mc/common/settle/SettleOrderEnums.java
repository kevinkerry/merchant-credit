package com.sdp.mc.common.settle;

public enum SettleOrderEnums {

	/**
	 * 初始
	 */
	INIT("0", "初始"),
	/**
	 * 待审核
	 */
	UNREVIEW("1", "待审核"),
	/**
	 * 审核通过
	 */
	REVIEWED("2", "审核通过"), 
	/**
	 * 审核不通过
	 */
	NOTREVIEWED("3", "审核不通过"), ;

	public final String code;
	public final String msg;

	private SettleOrderEnums(String code, String msg) {
		this.code = code;
		this.msg = msg;
	}

	public String getCode() {
		return code;
	}

	public String getMsg() {
		return msg;
	}

	public static String valueOfCode(String code) {
		for (SettleOrderEnums orderEnums : values()) {
			if (orderEnums.getCode().equals(code)) return orderEnums.getMsg();
		}
		return code;
	}
}
