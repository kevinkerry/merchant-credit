package com.sdp.mc.common.enums;

public enum MarginTransEnum {
	/**
	 * 0,"初始化"
	 */
	INIT(0,"初始化"),
	/**
	 * 1,"成功"
	 */
	SUCCESS(1,"成功"),
	/**
	 * -1,"失败"
	 */
	FAILUE(-1,"失败"),
	/**
	 * 2,"转账处理中",T+0及配资业务使用"初始化状态"
	 */
	PROCESSING(2,"转账处理中")
	;
	public final int code;
	public final String name;

	MarginTransEnum(int code, String name) {
		this.code = code;
		this.name = name;
	}
}
