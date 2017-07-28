package com.sdp.mc.integration.fos.enums;

public enum FOSPaymentCodeEnum {

	/**T+0保证金支付编码**/
	BASE2SUB(FOSProductCodeEnum.MC_FOS_MARGIN_PRODUCT_CODE, "2001", "基本户到子账户"),
	SUB2BASE(FOSProductCodeEnum.MC_FOS_MARGIN_PRODUCT_CODE, "2101", "子账户到基本户"),
	/**T+0配资支付编码**/
	CREDIT_PAYMENT_CODE_01(FOSProductCodeEnum.MC_FOS_CREDIT_PRODUCT_CODE, "2001", "中转-快速结算配资->281专户"),
    CREDIT_PAYMENT_CODE_02(FOSProductCodeEnum.MC_FOS_CREDIT_PRODUCT_CODE, "2002", "配资手续费支付编码"),
	CREDIT_PAYMENT_CODE_03(FOSProductCodeEnum.MC_FOS_CREDIT_PRODUCT_CODE, "2101", "281专户->中转-快速结算配资,冲正"),
	/**pos贷款支付编码**/
	/**
	 * 2001	放款本金
	 */
	POS_LOAN_PAYMENT_CODE_01(FOSProductCodeEnum.MC_FOS_LOAN_PRODUCT_CODE, "2001", "放款本金"),
	/**
	 * 2002	正常还款-还本金
	 */
	POS_LOAN_PAYMENT_CODE_02(FOSProductCodeEnum.MC_FOS_LOAN_PRODUCT_CODE, "2002", "正常还款-还本金"),
	/**
	 * 2003	应收利息-计息
	 */
	POS_LOAN_PAYMENT_CODE_03(FOSProductCodeEnum.MC_FOS_LOAN_PRODUCT_CODE, "2003", "应收利息-计息"),
	/**
	 * 2004	还应收利息
	 */
	POS_LOAN_PAYMENT_CODE_04(FOSProductCodeEnum.MC_FOS_LOAN_PRODUCT_CODE, "2004", "还利应收息"),
	/**
	 * 2005	逾期利息计提
	 */
	POS_LOAN_PAYMENT_CODE_05(FOSProductCodeEnum.MC_FOS_LOAN_PRODUCT_CODE, "2005", "逾期利息计提"),
	/**
	 * 2006	逾期还款-滞纳金
	 */
	POS_LOAN_PAYMENT_CODE_06(FOSProductCodeEnum.MC_FOS_LOAN_PRODUCT_CODE, "2006", "逾期还款-滞纳金"),
	/**
	 * 2007	逾期还款-还本金
	 */
	POS_LOAN_PAYMENT_CODE_07(FOSProductCodeEnum.MC_FOS_LOAN_PRODUCT_CODE, "2007", "逾期还款-还本金"),
	/**新T0**/
	MC_FOS_NEWT0_REMIT_FEE_PAYMENT_CODE(FOSProductCodeEnum.MC_FOS_NEWT0_REMIT_FEE_PRODUCT_CODE, "2001", "新T0超时退结算手续费"),
	;

	public final String code;
	public final String name;
	public final FOSProductCodeEnum productCode;
	
	FOSPaymentCodeEnum(final FOSProductCodeEnum productCode, final String code, final String name) {
		this.productCode = productCode;
		this.code = code;
		this.name = name;
	}

	public static FOSPaymentCodeEnum parse(final FOSProductCodeEnum productCode, String code) {
		for (FOSPaymentCodeEnum temp : FOSPaymentCodeEnum.values()) {
			if (productCode == temp.productCode && temp.code.equals(code)) {
				return temp;
			}
		}
		return null;
	}
}
