package com.sdp.mc.common.enums;

public enum LoaningTypeEnum {

	/**
	 * 盛付通全资
	 */
	SHENGPAY(1, "盛付通全资"),
	/**
	 * 代理商全资
	 */
	PROMOTER(0, "代理商全资"), ;
	
	public final int code;
	public final String desc;

	LoaningTypeEnum(int code, String desc) {
		this.code = code;
		this.desc = desc;
	}

	public int getCode() {
		return code;
	}

	public String getDesc() {
		return desc;
	}

	public static LoaningTypeEnum getLoaningTypeEnum(Integer value) {
		if (value == null) {// 改用integer类型，在此判断，业务共同调用
			return null;
		}
		LoaningTypeEnum loaningTypeEnum[] = LoaningTypeEnum.values();
		for (LoaningTypeEnum loanigEnum : loaningTypeEnum) {
			if (loanigEnum.getCode() == value) {// code是int的不用equals
				return loanigEnum;
			}
		}
		return null;
	}
}
