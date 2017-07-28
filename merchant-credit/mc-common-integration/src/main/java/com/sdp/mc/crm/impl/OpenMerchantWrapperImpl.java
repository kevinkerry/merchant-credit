package com.sdp.mc.crm.impl;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sdp.mc.common.constant.MerchantCreditConstant;
import com.sdp.mc.common.util.MD5Digest;
import com.sdp.mc.crm.OpenMerchantWrapper;
import com.sdp.mc.integration.crm.dto.MerchantContactInfoDTO;
import com.sdp.mc.integration.crm.dto.request.CRMMerchantContactInfoRequest;
import com.shengpay.boss.service.crm.query.api.MerchantBankService;
import com.shengpay.boss.service.crm.query.api.model.BankAccountInfo;
import com.shengpay.boss.service.crm.query.api.model.MerchantBankQueryRequest;
import com.shengpay.boss.service.crm.query.api.model.MerchantBankQueryResponse;
import com.shengpay.boss.service.crm.query.api.model.merchant.MerchantContactInfoQueryResponse;
import com.shengpay.commom.config.GlobalConfig;
import com.shengpay.poss.merchant.crm.ws.openmerchant.service.OpenMerchant;
import com.shengpay.poss.merchant.crm.ws.openmerchant.service.bean.QueryPosMerchantInfoRequest;
import com.shengpay.poss.merchant.crm.ws.openmerchant.service.bean.QueryPosMerchantInfoResponse;

@Service("OpenMerchantWrapper")
public class OpenMerchantWrapperImpl implements OpenMerchantWrapper {

	private static Logger logger = LoggerFactory.getLogger(OpenMerchantWrapperImpl.class);

	@Autowired
	OpenMerchant openMerchant;

	private String appid = null;

	private String key = null;

	public QueryPosMerchantInfoResponse QueryPosMerchantInfo(String merchantNo) {
		if (StringUtils.isBlank(appid)) {
			appid = GlobalConfig.getString("mc.merchantquery.appid");
		}
		if (StringUtils.isBlank(key)) {
			key = GlobalConfig.getString("mpos.crm.md5.key");
		}

		String requestId = UUID.randomUUID().toString();
		Date now = new Date();
		SimpleDateFormat sf = new SimpleDateFormat("yyyyMMddHHmmss");
		String requestTime = sf.format(now);

		StringBuffer sb = new StringBuffer();
		sb.append(appid).append(requestId).append(requestTime).append(key);
		String mac = MD5Digest.getDigestString(sb.toString());
		QueryPosMerchantInfoRequest req = new QueryPosMerchantInfoRequest();
		req.setAppid(appid);
		req.setMerchantid(merchantNo);
		req.setMac(mac);
		req.setRequestid(requestId);
		req.setRequesttime(requestTime);
		try {
			logger.info("OpenMerchantWrapperImpl.QueryPosMerchantInfo QueryPosMerchantInfoRequest"
					+ ToStringBuilder.reflectionToString(req, ToStringStyle.SHORT_PREFIX_STYLE));
			QueryPosMerchantInfoResponse response = openMerchant.QueryPosMerchantInfo(req);
			logger.info("OpenMerchantWrapperImpl.QueryPosMerchantInfo QueryPosMerchantInfoResponse"
					+ ToStringBuilder.reflectionToString(response, ToStringStyle.SHORT_PREFIX_STYLE));
			return response;
		} catch (Exception e) {
			logger.error("OpenMerchantWrapperImpl.QueryPosMerchantInfo call error", e);
		}
		return null;
	}

	public OpenMerchant getOpenMerchant() {
		return openMerchant;
	}

	public void setOpenMerchant(OpenMerchant openMerchant) {
		this.openMerchant = openMerchant;
	}

	public String getAppid() {
		return appid;
	}

	public void setAppid(String appid) {
		this.appid = appid;
	}

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}

}
