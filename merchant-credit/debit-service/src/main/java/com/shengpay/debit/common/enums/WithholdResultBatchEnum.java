package com.shengpay.debit.common.enums;

public enum WithholdResultBatchEnum {
	CODE_0000("0000","处理完成"),
	CODE_0001("0001","处理中"),
	CODE_1001("1001","文件不存在"),
	CODE_1002("1002","文件摘要不匹配"),
	CODE_1003("1003","文件格式不正确"),
	CODE_1004("1004","总笔数与明细总笔数不匹配"),
	CODE_1005("1005","总金额与明细总金额不匹配"),
	CODE_1006("1006","解析文件错误"),
	CODE_1007("1007","文件记录条数超限")
	;
	public final String code;
	public final String desc;

	public String getCode() {
		return code;
	}

	public String getDesc() {
		return desc;
	}

	WithholdResultBatchEnum(String code,String desc){
		this.code = code;
		this.desc = desc;
	}

	public static WithholdResultBatchEnum parse(String code) {
		for (WithholdResultBatchEnum temp : WithholdResultBatchEnum.values()) {
			if (temp.getCode().equals(code)) {
				return temp;
			}
		}
		return null;
	}
}
