package com.shengpay.debit.common.risk.model;

/**
 * 枚举型
 * @author heyi.alex
 *
 */
public class CreditRiskTypesItemsEnums {

	/**
	 * code
	 */
	private String code;

	/**
	 * 描述
	 */
	private String desc;

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	@Override
	public String toString() {
		return "CreditRiskTypesItemsEnums [code=" + code + ", desc=" + desc
				+ "]";
	}


}
