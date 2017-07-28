package com.sdp.mc.common.enums;

/**
 * 取回保证金类型
 *
 */
public enum MarginBalanceType {
	DYNAMICAMOUNT(0, "浮动"),
	GUARANTEED(1, "保底");

	private int state;
	private String desc;

	private MarginBalanceType(int state, String desc) {
		this.state = state;
		this.desc = desc;
	}

	public int getState() {
		return state;
	}

	public String getDesc() {
		return desc;
	}
}
