package com.shengpay.debit.common.enums;

public enum AgentProfitStatusEnum {
	INIT("01","放款成功"),
	WAIT_PROFITING("02","待分润");
	AgentProfitStatusEnum(String code, String desc) {
		this.code = code;
		this.desc = desc;
	}

	public final String code;
	public final String desc;
}
