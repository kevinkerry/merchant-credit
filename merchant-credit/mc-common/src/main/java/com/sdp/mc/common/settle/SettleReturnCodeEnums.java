package com.sdp.mc.common.settle;

public enum SettleReturnCodeEnums {

	/**
	 * success,0
	 */
	SUCESS("0", "success"),
	/**
	 * 失敗
	 */
	FAILL("9", "失败"),
	/**
	 * 参数验证失败
	 */
	PARAM_IS_NULL("10001", "参数验证失败"),
	/**
	 * 查询结果不唯一
	 */
	QUERY_RESULT_NOT_UNIQUE("10002", "查询结果不唯一"),
	/**
	 * 查询结果为空
	 */
	QUERY_RESULT_IS_NULL("10003", "查询结果为空"),
	/**
	 * 任务状态不匹配造成的处理中
	 */
	SYSTEM_PROCESS("1003", "系统繁忙."),;

	public final String code;
	public final String msg;

	private SettleReturnCodeEnums(String code, String errmsg) {
		this.code = code;
		this.msg = errmsg;
	}

	public static SettleReturnCodeEnums getEnumsByCode(String code) {
		SettleReturnCodeEnums returnCodeEnums[] = SettleReturnCodeEnums.values();
		for (SettleReturnCodeEnums enums : returnCodeEnums) {
			if (enums.code.equalsIgnoreCase(code)) return enums;
		}
		return null;
	}
}
