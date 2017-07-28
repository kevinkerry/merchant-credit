package com.sdp.mc.integration.fos.enums;
/**
 * 转账日志表biztype对应到支付编码
 * **/
public enum DebitTransferLogBizTypeEnum {
	DEBIT_LIMIT_APPLY(FOSPaymentCodeEnum.POS_LOAN_PAYMENT_CODE_01.code,"贷款额度申请"),
	OVERDUE_INTEREST_ACCRUED(FOSPaymentCodeEnum.POS_LOAN_PAYMENT_CODE_05.code,"逾期利息计提"),
	PRINCIPAL_PAYBACK(FOSPaymentCodeEnum.POS_LOAN_PAYMENT_CODE_02.code,"还本金"),
	OVERDUE_PAYBACK(FOSPaymentCodeEnum.POS_LOAN_PAYMENT_CODE_06.code,"还逾期本金及滞纳金"),
	;
	public final String code;
	public final String name;

	DebitTransferLogBizTypeEnum(String code, String name) {
		this.code = code;
		this.name = name;
	}
}
