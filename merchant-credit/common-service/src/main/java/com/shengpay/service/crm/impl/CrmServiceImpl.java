package com.shengpay.service.crm.impl;

import org.slf4j.Logger;import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.sdp.mc.crm.CrmServiceWrapper;
import com.sdp.mc.integration.crm.dto.MerchantContactInfoDTO;
import com.shengpay.service.crm.CrmService;

@Service
public class CrmServiceImpl implements CrmService {

	private static Logger logger = LoggerFactory.getLogger(CrmServiceImpl.class);

	@Autowired
	private CrmServiceWrapper crmServiceWrapper;
	@Value("${mc.merchantquery.appid}")
	private String appId;
	@Value("${mc.merchantquery.md5.key}")
	private String md5key;

	@Override
	public String getCRMMobilebyMerchantNo(String merchantNo) {
		MerchantContactInfoDTO merchantContactInfoDTO = crmServiceWrapper.queryMerchantContactInfo(merchantNo, appId, md5key);
		logger.info("CrmServiceImpl#getCRMMobilebyMerchantNo merchantContactInfoDTO:" + merchantContactInfoDTO.toString());
		return merchantContactInfoDTO.getbLinkPhone();
	}

}
