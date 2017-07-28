package com.sdp.mc.crm;

import com.shengpay.boss.service.crm.query.api.model.BankAccountInfo;

public interface MerchantBankCardWrapper {

	/**
	 * 调用 CRM 接口,根据商户号查询商户提现银行卡，如果多张卡，去第一张卡
	 *
	 * @param merchantNo
	 *            6位商户号
	 */
	public BankAccountInfo queryMerchantBankByMerchantId(String merchantNo);
}
