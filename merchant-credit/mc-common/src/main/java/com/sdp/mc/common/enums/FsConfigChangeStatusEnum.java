package com.sdp.mc.common.enums;

public enum FsConfigChangeStatusEnum {
	INIT(0,"初始化"),
	SUCCESS(1,"成功"),
	FAILUE(-1,"失败");
	public final int code;
	public final String name;

	FsConfigChangeStatusEnum(int code, String name) {
		this.code = code;
		this.name = name;
	}
}
