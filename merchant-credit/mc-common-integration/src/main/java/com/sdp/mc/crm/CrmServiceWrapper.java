package com.sdp.mc.crm;

import com.sdp.mc.integration.crm.dto.MerchantContactInfoDTO;

public interface CrmServiceWrapper {

	/**
	 * 调用 CRM 接口,根据商户号查询商户联系方式
	 * 
	 * @param merchantNo
	 *            6位商户号
	 * @param appId
	 *            与CRM约定zf号
	 * @param md5Key
	 *            md5 key
	 * @return MerchantContactInfoDTO
	 */
	public MerchantContactInfoDTO queryMerchantContactInfo(String merchantNo, String appId, String md5Key);
}
