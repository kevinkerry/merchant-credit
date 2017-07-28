package com.sdp.withdraw.enums;

public enum WithdrawPromptEnums {
	T0_PROMPT("T0","快速提现，预计30分钟到账"),
	T1_PROMPT("T1","普通提现，明日到账"),
	D1_PROMPT("D1","普通提现，明日到账"),
	T0_MPOS_PROMPT("T0","即时到账"),
	T1_MPOS_PROMPT("T1","明日到账"),
	D1_MPOS_PROMPT("D1","明日到账");

	public final String code;
	public final String msg;


	private WithdrawPromptEnums(String code,String msg) {
		this.msg = msg;
		this.code=code;
	}
}
