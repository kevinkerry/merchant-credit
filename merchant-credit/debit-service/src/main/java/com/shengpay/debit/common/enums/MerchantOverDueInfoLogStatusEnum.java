package com.shengpay.debit.common.enums;

/**
 * 逾期利息计提流水状态
 * @author wangjingao.william
 * **/
public enum MerchantOverDueInfoLogStatusEnum {
	INIT("INIT","初始化"),
	SUCCESS("S","成功"),
	FAILURE("F","失败"),
	PROCESSING("P","处理中"),
	;
	MerchantOverDueInfoLogStatusEnum(String code, String desc) {
		this.code = code;
		this.desc = desc;
	}

	public final String code;
	public final String desc;
}

