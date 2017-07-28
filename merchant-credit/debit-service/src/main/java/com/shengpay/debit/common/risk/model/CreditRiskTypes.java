package com.shengpay.debit.common.risk.model;

import java.util.List;

/**
 * 风控大类
 *
 * @author heyi.alex
 *
 */
public class CreditRiskTypes {

	/**
	 * 评分类型
	 */
	private String code;

	/**
	 * 评分内容
	 */
	private String desc;

	/**
	 * 评分小项
	 */
	private List<CreditRiskTypesItems> items;

	public String getCode() {
		if (code == null){return null;}
		return code.replaceAll(" ", "_");
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

	public List<CreditRiskTypesItems> getItems() {
		return items;
	}

	public void setItems(List<CreditRiskTypesItems> items) {
		this.items = items;
	}

	@Override
	public String toString() {
		return "CreditRiskTypes [code=" + code + ", desc=" + desc + ", items="
				+ items + "]";
	}

}
