package com.sdp.mc.crm;

import com.shengpay.poss.merchant.crm.ws.openmerchant.service.bean.QueryPosMerchantInfoResponse;

public interface OpenMerchantWrapper {

	/**
	 * 单条商户信息查询
	 * 
	 * @param merchantNo
	 * @return
	 */
	public QueryPosMerchantInfoResponse QueryPosMerchantInfo(String merchantNo);
}
