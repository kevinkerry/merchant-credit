package com.shengpay.debit.merchant.account.enums;

/**
 * POS商户负债变更流水操作类型
 * **/
public enum MerchantDebitLogOperateTypeEnum {
	BORROWING("101","借款"),
	NORMAL_PAYBACK("102","正常还款"),
	OVERDUE_PAYBACK("103","逾期还款"),
	;
	MerchantDebitLogOperateTypeEnum(String code, String desc) {
		this.code = code;
		this.desc = desc;
	}

	public final String code;
	public final String desc;
}
