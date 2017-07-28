package com.shengpay.debit.common.enums;

/**
 * 征信接口状态
 * 商户的评级状态，processing:处理中;failed:评审不通过;success:评审通过;expired:过期  
 * @author wangjingao.william
 * **/
public enum CreditLevelStatusEnum {
	PROCESSING("processing","处理中"),
	FAILED("failed","评审不通过"),
	SUCCESS("success","评审通过"),
	EXPIRED("expired","过期"),
	;
	public final String code;
	public final String desc;
	CreditLevelStatusEnum(String code,String desc){
		this.code = code;
		this.desc = desc;
	}
}
