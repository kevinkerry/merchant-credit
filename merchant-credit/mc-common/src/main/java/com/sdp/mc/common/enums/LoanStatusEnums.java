package com.sdp.mc.common.enums;

/**
 * 放款状态
 * @author wangmindong
 *
 */
public enum LoanStatusEnums {
	/**
	 * 待放款
	 */
	LOAN_INIT(201, "待放款"),
	/**
	 * 放款成功
	 */
	LOAN_SUCCESS(202, "放款成功"),
	/**
	 * 放款失败
	 */
	LOAN_FAILURE(-202, "放款失败"),
	
	/**
	 * 拒绝放款
	 */
	LOAN_REFUSE(-300, "拒绝放款");
	
	public final int code;
	public final String desc;

	LoanStatusEnums(int code, String desc) {
		this.code = code;
		this.desc = desc;
	}

	public int getCode() {
		return code;
	}

	public String getDesc() {
		return desc;
	}
}
