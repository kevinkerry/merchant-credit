package com.sdp.mc.crm.impl;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.slf4j.Logger;import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sdp.mc.common.constant.MerchantCreditConstant;
import com.sdp.mc.crm.CrmServiceWrapper;
import com.sdp.mc.integration.crm.dto.MerchantContactInfoDTO;
import com.sdp.mc.integration.crm.dto.request.CRMMerchantContactInfoRequest;
import com.shengpay.boss.service.crm.query.api.MerchantBankService;
import com.shengpay.boss.service.crm.query.api.MerchantQueryService;
import com.shengpay.boss.service.crm.query.api.model.merchant.MerchantContactInfoQueryRequest;
import com.shengpay.boss.service.crm.query.api.model.merchant.MerchantContactInfoQueryResponse;
@Service
public class CrmServiceWrapperImpl implements CrmServiceWrapper {

	private static Logger logger = LoggerFactory.getLogger(CrmServiceWrapperImpl.class);
	@Autowired
	MerchantQueryService merchantQueryService;
	@Autowired
	MerchantBankService merchantBankService;

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
	public MerchantContactInfoDTO queryMerchantContactInfo(String merchantNo, String appId, String md5Key) {
		CRMMerchantContactInfoRequest crmMerchantContactInfoRequest = CRMMerchantContactInfoRequest.genrateMerchantContactInfoRequest(merchantNo,
				appId, md5Key);
		String mac = crmMerchantContactInfoRequest.getMac();
		logger.info("CRM #queryMerchantContactInfo request:" + ToStringBuilder.reflectionToString(crmMerchantContactInfoRequest));
		MerchantContactInfoQueryResponse merchantContactInfoQueryResponse = merchantQueryService
				.queryMerchantContactInfo(bulidMerchantContactInfo(crmMerchantContactInfoRequest));
		logger.info("CRM #queryMerchantContactInfo response:" + ToStringBuilder.reflectionToString(merchantContactInfoQueryResponse));
		if (merchantContactInfoQueryResponse.getHeader() == null) {
			logger.error("CRM #queryMerchantContactInfo response header is null.");
			return null;
		}
		int retCode = merchantContactInfoQueryResponse.getHeader().getRetCode();
		String retMsg = merchantContactInfoQueryResponse.getHeader().getRetMsg();
		if (MerchantCreditConstant.MC_CRM_QUERYMERCHANTCONTACTINFO_RETURN_CODE_SUCCESS != retCode) {
			logger.error("CRM #queryMerchantContactInfo response is exception,code:" + retCode + ",msg" + retMsg);
			return null;
		}
		String resMac = merchantContactInfoQueryResponse.getHeader().getMac();
		if (!mac.equalsIgnoreCase(resMac))
			logger.error("CRM #queryMerchantContactInfo response mac is not equals request mac,request_mac:" + mac + ",response_mac" + resMac);
		if (merchantContactInfoQueryResponse.getMerchantContactInfo() == null) {
			logger.info("CRM #queryMerchantContactInfo response MerchantContactInfo is null.");
			return null;
		}

		String bLinkMan = merchantContactInfoQueryResponse.getMerchantContactInfo().getBLinkMan();
		String address = merchantContactInfoQueryResponse.getMerchantContactInfo().getAddress();
		String bLinkPhone = merchantContactInfoQueryResponse.getMerchantContactInfo().getBLinkPhone();
		String bLinkEmail = merchantContactInfoQueryResponse.getMerchantContactInfo().getBLinkEmail();
		if (StringUtils.isBlank(bLinkEmail)) logger.error("CRM #queryMerchantContactInfo response bLinkEmail is null.");
		return new MerchantContactInfoDTO(bLinkMan, address, bLinkPhone, bLinkEmail);
	}
	

	private MerchantContactInfoQueryRequest bulidMerchantContactInfo(CRMMerchantContactInfoRequest crmMerchantContactInfoRequest) {
		MerchantContactInfoQueryRequest request = new MerchantContactInfoQueryRequest();
		request.setAppId(crmMerchantContactInfoRequest.getAppId());
		request.setRequestId(crmMerchantContactInfoRequest.getRequestId());
		request.setRequestTime(crmMerchantContactInfoRequest.getRequestTime());
		request.setTZMerchantID(crmMerchantContactInfoRequest.getTzMerchantId());
		request.setMac(crmMerchantContactInfoRequest.getMac());
		return request;
	}

}
