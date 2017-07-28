package com.shengpay.debit.common.enums;
public enum WithholdOrderStatusEnum {
	INIT("0","初始"),
	C_SUCESS("C","成功"),
	F_FAILL("F","失败"),
	P_MANAGE("P","处理中")
	;
	public final String code;
	public final String desc;

	public String getCode() {
		return code;
	}

	public String getDesc() {
		return desc;
	}

	WithholdOrderStatusEnum(String code,String desc){
		this.code = code;
		this.desc = desc;
	}

	public static WithholdOrderStatusEnum parse(String code) {
		for (WithholdOrderStatusEnum temp : WithholdOrderStatusEnum.values()) {
			if (temp.getCode().equals(code)) {
				return temp;
			}
		}
		return null;
	}
}
