package com.sdp.mc.ma.wrapper.utils;

import java.util.Date;
import java.util.UUID;

import com.sdo.ma.ws.api.request.RequestHeader;
import com.sdo.ma.ws.api.request.osr.CheckMerchantOrgNodeRequest;
import com.sdp.mc.common.constant.MerchantCreditConstant;
import com.sdp.mc.common.util.IPUtils;

public class OrgServiceUtil {

	public static CheckMerchantOrgNodeRequest buildCheckMerchantOrgNodeRequest(String merchantNo) {
		CheckMerchantOrgNodeRequest request = new CheckMerchantOrgNodeRequest();
		RequestHeader requestHeader = new RequestHeader();
		requestHeader.setVersion("10");
		requestHeader.setSourceId(MerchantCreditConstant.MC_WEBSITE_ZF_NO);
		requestHeader.setRequestTime(new Date());
		requestHeader.setRequestNo(UUID.randomUUID().toString());
		requestHeader.setAppIp(IPUtils.getLocalIp());
		request.setHeader(requestHeader);
		request.setMerchantId(merchantNo);
		return request;
	}
}
