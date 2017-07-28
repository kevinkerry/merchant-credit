package com.sdp.mc.common.enums;


/**
 * 业务层通用开户记录表状态
 * **/
public enum BizApplyOpenAccountStatusEnum {

	INIT(0, "初始化"), 
	OPEN_ACCOUNT_SUCCESS(1, "开通配资"), 
	OPEN_ACCOUNT_FAILURE(2, "配资开通失败"),
	CLOSED(3, "关闭配资");
	
	public final int code;
	public final String name;
	
	BizApplyOpenAccountStatusEnum(int code, String name) {
		this.code = code;
		this.name = name;
	}
	
	public static BizApplyOpenAccountStatusEnum getByCode(int code) {
		for (BizApplyOpenAccountStatusEnum temp : BizApplyOpenAccountStatusEnum.values()) {
			if (temp.code == code) {
				return temp;
			}
		}
		return null;
	}
}
