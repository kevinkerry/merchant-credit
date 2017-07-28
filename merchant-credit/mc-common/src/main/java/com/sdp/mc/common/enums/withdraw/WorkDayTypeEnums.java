package com.sdp.mc.common.enums.withdraw;

/**
 * 节假日
 * @author wangmindong
 *
 */
public enum WorkDayTypeEnums {

	/**
	 * 工作日 ： 0
	 */
	UN_HOLIDAY(0,"工作日"),
	/**
	 * 非工作日 : 1
	 */
	HOLIDAY(1, "节假日");

	public final int code;
	public final String desc;

	WorkDayTypeEnums(int code, String desc) {
		this.code = code;
		this.desc = desc;
	}
}
