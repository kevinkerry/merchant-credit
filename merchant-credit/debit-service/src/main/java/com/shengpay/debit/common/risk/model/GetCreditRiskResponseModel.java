package com.shengpay.debit.common.risk.model;

import java.util.List;

/**
 * 征信应答结果
 * @author heyi.alex
 *
 */
public class GetCreditRiskResponseModel {

	/**
	 * 风控大类集合
	 */
	private List<CreditRiskTypes> types;

	public List<CreditRiskTypes> getTypes() {
		return types;
	}

	public void setTypes(List<CreditRiskTypes> types) {
		this.types = types;
	}

	@Override
	public String toString() {
		return "GetCreditRiskResponseModel [types=" + types + "]";
	}




}
