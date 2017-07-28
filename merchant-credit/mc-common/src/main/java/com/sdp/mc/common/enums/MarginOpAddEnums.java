package com.sdp.mc.common.enums;

/**
 * 
 * @author ganquan // 追加： 0：初始化 101：转账成功 -101：转账失败 102：配置更改成功（退款申请成功）
 *         -102：配置更改失败
 */
public enum MarginOpAddEnums {
	/**
	 * 0：初始化
	 */
	INIT(0, "初始化"),
	/**
	 * 1：转账成功
	 */
	TRANSFER_SUCCESS(101, "转账成功"),
	/**
	 * -1：转账失败
	 */
	TRANSFER_FAILURE(-101, "转账失败"),
	/**
	 * 2：配置更改成功（退款申请成功）
	 */
	CONFIGURE_SUCCESS(102, "配置更改成功"),
	/**
	 * -2：配置更改失败
	 */
	CONFIGURE_FAILURE(-102, "配置更改成功"),
	/**
	 * 3：审核中
	 */
	AUDITING(103, "审核中"),
	/**
	 * -3：非审核中
	 */
	NON_AUDITING(-103, "非审核中");

	public final int code;
	public final String desc;

	MarginOpAddEnums(int code, String desc) {
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
