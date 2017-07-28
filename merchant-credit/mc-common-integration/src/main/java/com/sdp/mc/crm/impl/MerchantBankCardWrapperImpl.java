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
import com.sdp.mc.crm.MerchantBankCardWrapper;
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

@Service("MerchantBankCardWrapper")
public class MerchantBankCardWrapperImpl implements MerchantBankCardWrapper {

	private static Logger logger = LoggerFactory.getLogger(MerchantBankCardWrapperImpl.class);
	@Autowired
	MerchantBankService merchantBankService;

	private String appid = null;

	private String key = null;

	

	/**
	 * 调用 CRM 接口,根据商户号查询商户提现银行卡，如果多张卡，去第一张卡
	 *
	 * @param merchantNo
	 *            6位商户号
	 */
	public BankAccountInfo queryMerchantBankByMerchantId(String merchantNo) {
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
		MerchantBankQueryRequest request = new MerchantBankQueryRequest();
		request.setAppId(appid);
		request.setMerchantId(merchantNo);
		request.setRequestId(requestId);
		request.setRequestTime(requestTime);
		request.setMac(MD5Digest.getDigestString(request.getSignText(key), MerchantCreditConstant.MC_GLOBAL_ENCODEING));
		logger.info("queryMerchantBankByMerchantId MerchantBankQueryRequest"
				+ ToStringBuilder.reflectionToString(request, ToStringStyle.SIMPLE_STYLE));
		MerchantBankQueryResponse response = merchantBankService.queryMerchantBankByMerchantId(request);
		logger.info("queryMerchantBankByMerchantId MerchantBankQueryResponse"
				+ ToStringBuilder.reflectionToString(response, ToStringStyle.SIMPLE_STYLE));
		if (response != null) {
			BankAccountInfo[] bankInfos = response.getInfos();
			if (bankInfos != null && bankInfos.length > 0) { return bankInfos[0]; }
		}
		return null;
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



	public MerchantBankService getMerchantBankService() {
		return merchantBankService;
	}



	public void setMerchantBankService(MerchantBankService merchantBankService) {
		this.merchantBankService = merchantBankService;
	}
	
	

}
