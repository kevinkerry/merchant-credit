package com.shengpay.debit.common.enums;

public enum WithholdNoticeCodeEnum {
	SUCESS_CODE("00","通知成功"),
	ERROR_PARAM_CODE("01","参数不正确"),
	ERROR_MERCHANTNO("02","验签失败"),
	ERROR_OTHER_CODE("99","其他错误")
	;
	public final String code;
	public final String desc;

	public String getCode() {
		return code;
	}

	public String getDesc() {
		return desc;
	}

	WithholdNoticeCodeEnum(String code,String desc){
		this.code = code;
		this.desc = desc;
	}

	public static WithholdNoticeCodeEnum parse(String code) {
		for (WithholdNoticeCodeEnum temp : WithholdNoticeCodeEnum.values()) {
			if (temp.getCode().equals(code)) {
				return temp;
			}
		}
		return null;
	}
}
