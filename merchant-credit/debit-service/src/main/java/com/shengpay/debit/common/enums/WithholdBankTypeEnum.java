package com.shengpay.debit.common.enums;
/**
 * 银行类型
 * @author wangmindong
 * 2015年12月3日 16:11:17
 */
public enum WithholdBankTypeEnum {
	BANK_ICBC("ICBC","工商银行"),
	BANK_BOC("BOC","中国银行"),
	BANK_CCB("CCB","建设银行"),
	BANK_CMB("CMB","招商银行"),
	BANK_CEB("CEB","光大银行"),
	BANK_CMBC("CMBC","民生银行"),
	BANK_SZPAB("SZPAB","平安银行"),
	BANK_PSBC("PSBC","中国邮储银行"),
	BANK_ABC("ABC","农业银行")
	;
	public final String code;
	public final String desc;

	public String getCode() {
		return code;
	}

	public String getDesc() {
		return desc;
	}

	WithholdBankTypeEnum(String code,String desc){
		this.code = code;
		this.desc = desc;
	}

	public static WithholdBankTypeEnum parse(String code) {
		for (WithholdBankTypeEnum temp : WithholdBankTypeEnum.values()) {
			if (temp.getCode().equals(code)) {
				return temp;
			}
		}
		return null;
	}

	public static String toStr() {
		StringBuffer sb=new StringBuffer();
		for (WithholdBankTypeEnum temp : WithholdBankTypeEnum.values()) {
			sb.append(temp.code).append("-").append(temp.desc).append(" ");
		}
		return sb.toString();
	}
}
