package com.sdp.mc.integration.crm.dto.request;

import java.util.Date;
import java.util.UUID;

import com.sdp.mc.common.constant.MerchantCreditConstant;
import com.sdp.mc.common.util.DateUtil;
import com.sdp.mc.common.util.MD5Digest;

public class CRMMerchantContactInfoRequest {

	/**
	 * 配管分配给每个系统的ZF号
	 */
	private String appId;
	/**
	 * 请求流水号.每个系统发起的请求流水号建议不要重复
	 */
	private String requestId;
	/**
	 * 格式：yyyyMMddHHmmss
	 */
	private String requestTime;
	/**
	 * [RequestID]+[RequestTime]+[MD5Key]）对以上字符串做MD5加密
	 */
	private String mac;
	/**
	 * 6位的商户号
	 */
	private String tzMerchantId;

	public CRMMerchantContactInfoRequest(String tzMerchantId, String appId, String requestId, String requestTime, String mac) {
		this.tzMerchantId = tzMerchantId;
		this.appId = appId;
		this.requestId = requestId;
		this.requestTime = requestTime;
		this.mac = mac;
	}

	public String getAppId() {
		return appId;
	}

	public void setAppId(String appId) {
		this.appId = appId;
	}

	public String getRequestId() {
		return requestId;
	}

	public void setRequestId(String requestId) {
		this.requestId = requestId;
	}

	public String getRequestTime() {
		return requestTime;
	}

	public void setRequestTime(String requestTime) {
		this.requestTime = requestTime;
	}

	public String getMac() {
		return mac;
	}

	public void setMac(String mac) {
		this.mac = mac;
	}

	public String getTzMerchantId() {
		return tzMerchantId;
	}

	public void setTzMerchantId(String tzMerchantId) {
		this.tzMerchantId = tzMerchantId;
	}

	public static CRMMerchantContactInfoRequest genrateMerchantContactInfoRequest(String merchantNo, String appId, String md5Key) {
		UUID uuid = UUID.randomUUID();
		String requestId = uuid.toString();
		String requestTime = DateUtil.date2Str(new Date(), DateUtil.forOrderFormat);
		String mac = MD5Digest.getDigestString(appId + requestId + requestTime + md5Key, MerchantCreditConstant.MC_GLOBAL_ENCODEING);
		return new CRMMerchantContactInfoRequest(merchantNo, appId, requestId, requestTime, mac);
	}

}
