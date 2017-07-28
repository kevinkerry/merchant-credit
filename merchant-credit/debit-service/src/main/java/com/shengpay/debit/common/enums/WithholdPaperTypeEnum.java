package com.shengpay.debit.common.enums;
public enum WithholdPaperTypeEnum {
	ID_CARD("IC", "身份证"),
	TEMP_ID_CARD("TIC","临时身份证"),
	PASSPORT("PP", "护照"),
	SOLDIER_CARD("SC", "士兵证"),
	ARMY_OFFICER_CARD("AOC","军官证"),
	ARMY_CIVILIAN_CADRE("ACC","军人文职干部证"),
	POLICE_OFFICER_CARD("POC","警官证"),
	ARMED_POLICE_CARD("APC", "武警证"),
	HK_MC_PASS("HMP", "港澳居民来往内地通行证"),
	RESIDENCE_BOOKLET("RB", "户口簿"),
	TW_PASS("TWP", "台湾居民来往大陆通行证/台胞证"),
	TW_RETURN("TWR","台湾回乡证"),
	FOREIGN_PASSPORT("FPP","外国护照"),
	FOREIGNER_RESIDENCE("FR", "外国人永久居留证")
	;
	public final String code;
	public final String desc;

	public String getCode() {
		return code;
	}

	public String getDesc() {
		return desc;
	}

	WithholdPaperTypeEnum(String code,String desc){
		this.code = code;
		this.desc = desc;
	}

	public static WithholdPaperTypeEnum parse(String code) {
		for (WithholdPaperTypeEnum temp : WithholdPaperTypeEnum.values()) {
			if (temp.getCode().equals(code)) {
				return temp;
			}
		}
		return null;
	}


	public static String toStr() {
		StringBuffer sb=new StringBuffer();
		for (WithholdPaperTypeEnum temp : WithholdPaperTypeEnum.values()) {
			sb.append(temp.code).append("-").append(temp.desc).append(" ");
		}
		return sb.toString();
	}
}
