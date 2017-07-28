package com.sdp.mc.common.enums.withdraw;

/**
 * 重试执行计划的执行状态
 *
 */
public enum WithdrawRetryPlanExecuteStatusEnums {
	EXECUTE_WAIT(0, "待执行"), 
	EXECUTE_ING(1, "执行中"), 
	EXECUTE_FINISH(2,"执行完成");

	public final Integer code;
	public final String desc;

	WithdrawRetryPlanExecuteStatusEnums(Integer code, String desc) {
		this.code = code;
		this.desc = desc;
	}
}
