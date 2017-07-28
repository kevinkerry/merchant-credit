package com.sdp.mc.common.enums;

/**
 * 放款操作状态
 * @author wangmindong
 *
 */
public enum LoanOpTypeEnums {

	/**
	 * 放款操作
	 */
	LOAN_OP_STATUS(0, "放款操作"),
	
	/**
	 * 
	 */
	LOAN_REFUSE_OP_STATUS(1, "拒绝放款");

	public final int code;
	public final String desc;

	LoanOpTypeEnums(int code, String desc) {
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
