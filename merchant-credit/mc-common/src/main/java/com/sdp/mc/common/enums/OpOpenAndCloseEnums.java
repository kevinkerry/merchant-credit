package com.sdp.mc.common.enums;

public enum OpOpenAndCloseEnums {
	/**
	 * 初始化
	 */
	INIT(100, "初始化"),
	/**
	 * 保证金开户中
	 */
	ACCOUNT_OPENING(101, "保证金开户中"),
	/**
	 * 保证金开户成功
	 */
	ACCOUNT_SUCCESS(102, "保证金开户成功"),
	/**
	 * 保证金开户失败
	 */
	ACCOUNT_FAILURE(-102, "保证金开户失败"),
	/**
	 * MSP配置更改成功
	 */
	CONFIGURE_SUCCESS(103, "MSP配置更改成功"),
	/**
	 * MSP配置更改失败
	 */
	CONFIGURE_FAILURE(-103, "MSP配置更改失败"),

	/**
	 * 关闭-初始化
	 */
	CLOSE_INIT(200, "关闭-初始化"),
	/**
	 * 关闭-MSP配置更改成功
	 */
	CLOSE_CONFIGURE_SUCCESS(201, "关闭-MSP配置更改成功"),
	/**
	 * 关闭-MSP配置更改失败
	 */
	CLOSE_CONFIGURE_FAILURE(-201, "关闭-MSP配置更改失败"),
	;
	int code;
	String desc;

	OpOpenAndCloseEnums(int code, String desc) {
		this.code = code;
		this.desc = desc;
	}

	public int getCode() {
		return code;
	}

//	public void setCode(int code) {
//		this.code = code;
//	}

	public String getDesc() {
		return desc;
	}

//	public void setDesc(String desc) {
//		this.desc = desc;
//	}


	public static OpOpenAndCloseEnums parse(int code) {
		for (OpOpenAndCloseEnums op : OpOpenAndCloseEnums.values()) {
			if (op.code == code) {
				return op;
			}
		}
		return null;
	}

}
