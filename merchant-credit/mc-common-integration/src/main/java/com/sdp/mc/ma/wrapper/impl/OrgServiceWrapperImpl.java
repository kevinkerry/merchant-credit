package com.sdp.mc.ma.wrapper.impl;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.slf4j.Logger;import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sdo.ma.ws.api.request.osr.CheckMerchantOrgNodeRequest;
import com.sdo.ma.ws.api.response.osr.CheckMerchantOrgNodeResponse;
import com.sdo.ma.ws.api.service.osr.IOrgWS;
import com.sdp.mc.ma.wrapper.OrgServiceWrapper;
import com.sdp.mc.ma.wrapper.utils.OrgServiceUtil;

@Service("OrgServiceWrapper")
public class OrgServiceWrapperImpl implements OrgServiceWrapper {
	private static final Logger log = LoggerFactory.getLogger(OrgServiceWrapperImpl.class);
	@Autowired
	private IOrgWS orgWS;

	public void setOrgWS(IOrgWS orgWS) {
		this.orgWS = orgWS;
	}

	/**
	 * 子商户是否是集团商户 ,调用方：专业版
	 * 
	 * @param merchantNo
	 * **/
	public boolean belongs2Group(final String merchantNo) {
		CheckMerchantOrgNodeRequest request = OrgServiceUtil.buildCheckMerchantOrgNodeRequest(merchantNo);
		log.info("OrgServiceWrapperImpl.belongs2Group.request=" + ToStringBuilder.reflectionToString(request));
		CheckMerchantOrgNodeResponse response = this.orgWS.checkMerchantOrgNode(request);
		log.info("OrgServiceWrapperImpl.belongs2Group.response=" + ToStringBuilder.reflectionToString(response));
		if ("0".equals(response.getHeader().getResponseCode())) {
			return response.isCheckResult();
		}
		throw new RuntimeException("request IOrgWS remote service failed...");
	}
}
