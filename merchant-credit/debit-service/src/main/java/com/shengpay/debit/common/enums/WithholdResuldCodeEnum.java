package com.shengpay.debit.common.enums;

public enum WithholdResuldCodeEnum {
	SUCESS_CODE("00","成功"),
	ERROR_PARAM_CODE("01","参数不正确"),
	ERROR_MERCHANTNO("02","商户号不合法"),
	ERROR_SIGN_FAIL("03","验签失败"),
	ERROR_NO_POWER_CODE("04","无权访问"),
	ERROR_NOTDEFIND_CODE("05","原交易不存在"),
	ERROR_REPEAT_CODE("06","重复请求"),
	ERROR_AMOUNT_CODE("07","超出可退金额"),
	NO_SUCESS_OTHER_CODE("99","其他错误")
	;
	public final String code;
	public final String desc;

	public String getCode() {
		return code;
	}

	public String getDesc() {
		return desc;
	}

	WithholdResuldCodeEnum(String code,String desc){
		this.code = code;
		this.desc = desc;
	}

	public static WithholdResuldCodeEnum parse(String code) {
		for (WithholdResuldCodeEnum temp : WithholdResuldCodeEnum.values()) {
			if (temp.getCode().equals(code)) {
				return temp;
			}
		}
		return null;
	}
}
