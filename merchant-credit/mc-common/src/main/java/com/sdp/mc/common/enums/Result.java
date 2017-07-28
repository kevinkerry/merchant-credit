package com.sdp.mc.common.enums;

public enum Result {
	OK(666, "成功"),
	FAILURE(-1, "失败"),
	ERROR(-2, "异常");

	private int state;
	private String desc;

	private Result(int state, String desc) {
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
