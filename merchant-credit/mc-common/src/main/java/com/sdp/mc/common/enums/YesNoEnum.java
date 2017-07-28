package com.sdp.mc.common.enums;

public enum YesNoEnum {

	/**
	 * 是
	 */
	YES("1", "是"),
	/**
	 * 否
	 */
	NO("0", "否"), ;

	public final String code;
	public final String desc;

	YesNoEnum(String code, String desc) {
		this.code = code;
		this.desc = desc;
	}

	public String getCode() {
		return code;
	}

	public String getDesc() {
		return desc;
	}

	public static YesNoEnum getLoaningTypeFlagEnum(String value) {
		if (value == null) {// 改用integer类型，在此判断，业务共同调用
			return null;
		}
		YesNoEnum loaningTypeEnum[] = YesNoEnum.values();
		for (YesNoEnum loanigEnum : loaningTypeEnum) {
			if (loanigEnum.getCode().equals(value)) {// code是int的不用equals
				return loanigEnum;
			}
		}
		return null;
	}
}
