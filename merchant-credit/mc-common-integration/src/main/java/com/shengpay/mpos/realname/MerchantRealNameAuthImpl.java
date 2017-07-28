package com.shengpay.mpos.realname;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

import net.sf.json.JSONObject;

import org.antlr.grammar.v3.ANTLRv3Parser.exceptionGroup_return;
import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.sdp.mc.common.util.MD5Digest;
import com.sdp.mc.common.vo.ErrorMessageVO;
import com.shengpay.commom.config.GlobalConfig;
import com.shengpay.commons.core.utils.DateTimeUtils;
import com.shengpay.poss.service.realname.remote.IMerchantRealNameAuth;
import com.shengpay.poss.service.realname.remote.vo.MerchantRealNameAuthQueryReq;
import com.shengpay.poss.service.realname.remote.vo.MerchantRealNameAuthQueryResp;
import com.shengpay.poss.service.realname.remote.vo.RetHeader;

@Service
public class MerchantRealNameAuthImpl implements MerchantRealNameMPOS, MerchantRealNameAuth {
	// @Value("${mpos.realname.md5.key}")
	private String realNameMD5Key;
	@Resource(name = "merchantRealNameAuth")
	private IMerchantRealNameAuth merchantRealNameAuth;
	private static final Logger logger = LoggerFactory.getLogger(MerchantRealNameAuthImpl.class);

	public String getRealNameMD5Key() {
		return realNameMD5Key;
	}

	public void setRealNameMD5Key(String realNameMD5Key) {
		this.realNameMD5Key = realNameMD5Key;
	}

	public IMerchantRealNameAuth getMerchantRealNameAuth() {
		return merchantRealNameAuth;
	}

	public void setMerchantRealNameAuth(IMerchantRealNameAuth merchantRealNameAuth) {
		this.merchantRealNameAuth = merchantRealNameAuth;
	}

	/**
	 * 拼接request
	 * 
	 * @param merchantNo
	 * @param zfCode
	 * @return
	 */
	private MerchantRealNameAuthQueryReq getRequest(String merchantNo, String zfCode) {
		logger.info("MerchantRealNameAuthImpl#getRequest.merchantNo:" + merchantNo);
		SimpleDateFormat orderFormat = new SimpleDateFormat("yyyyMMddHHmmsss");
		String requestID = orderFormat.format(new Date());
		logger.info("MerchantRealNameAuthImpl#getRequest.requestID:" + requestID);
		MerchantRealNameAuthQueryReq request = new MerchantRealNameAuthQueryReq();
		if (StringUtils.isEmpty(zfCode)) {
			zfCode = GlobalConfig.getString("mc.merchantquery.appid");
		}
		request.setAppID(zfCode);
		request.setMerchantID(merchantNo);
		request.setRequestID(requestID);
		request.setRequestTime(DateTimeUtils.format2yyMMddHHmmss(new Date()));
		if (StringUtils.isEmpty(realNameMD5Key)) {
			realNameMD5Key = GlobalConfig.getString("mpos.realname.md5.key");
		}
		String macorg = zfCode + requestID + request.getRequestTime() + realNameMD5Key;
		logger.info("MerchantRealNameAuthImpl#authQuery.macorg:" + macorg);
		String macresutlt = MD5Digest.getDigestString(macorg);
		logger.info("MerchantRealNameAuthImpl#authQuery.macresutlt:" + macresutlt);
		request.setMac(macresutlt);
		return request;
	}

	/**
	 * 查找市民认证信息接口主方法
	 */
	public ErrorMessageVO<Object> authQuery(String merchantNo, String zfCode) {
		ErrorMessageVO<Object> vo = new ErrorMessageVO<Object>(false);
		logger.info("MerchantRealNameAuthImpl#authQuery.merchantNo:" + merchantNo);
		MerchantRealNameAuthQueryResp authQuery=null;
		try {
			authQuery = authQueryInfo(merchantNo, zfCode);
		} catch (Exception e) {
			logger.info("MerchantRealNameAuthImpl#authQueryInfo is Exception.merchantNo:" + merchantNo,e);
		}
		if (authQuery == null) {
			vo.setSuccess(false);
			vo.setErrorCode("-99");
			vo.setErrorMessage("查询商户提现银行卡信息失败.merchantRealNameAuth.authQuery.is null");
			return vo;
		}
		RetHeader header = authQuery.getHeader();
		if (header == null) {
			vo.setSuccess(false);
			vo.setErrorCode("-99");
			vo.setErrorMessage("查询商户提现银行卡信息失败.merchantRealNameAuth.authQuery.header.is null");
			return vo;
		}
		if (header.getRetCode() != 0) {
			logger.info("MerchantRealNameAuthImpl#authQuery is fail" + ToStringBuilder.reflectionToString(authQuery));
			vo.setSuccess(false);
			vo.setErrorCode(header.getRetCode() + "");
			vo.setErrorMessage("查询商户提现银行卡信息失败" + header.getRetMsg());
			return vo;
		} else {
			Map<String, Object> map = new HashMap<String, Object>();
			if (authQuery.getAuthInfo() != null) {
				JSONObject jsonAuthQuery = null;
				if (authQuery.getAuthInfo().getBankAccountInfo() != null)
					jsonAuthQuery = JSONObject.fromObject(authQuery.getAuthInfo().getBankAccountInfo());

				map.put("authQuery", jsonAuthQuery);
				map.put("authStatus", authQuery.getAuthInfo().getAuthStatus());
				if (authQuery.getAuthInfo().getBankAccountInfo() != null) {
					vo.setSuccess(true);
					vo.setErrorCode(header.getRetCode() + "");
					vo.setErrorMessage(header.getRetMsg());
					map.put("bankCode", authQuery.getAuthInfo().getBankAccountInfo().getBankCode());
					map.put("bankName", authQuery.getAuthInfo().getBankAccountInfo().getBankName());
					map.put("bankAccountQueryInfo", authQuery.getAuthInfo().getBankAccountInfo());
					map.put("personalAuthInfo", authQuery.getAuthInfo().getPersonalAuthInfo());
					vo.setParams(map);
				} else {
					vo.setSuccess(false);
					vo.setErrorCode(header.getRetCode() + "");
					vo.setErrorMessage("没有查询到商户提现银行卡信息");
				}
			} else {
				logger.info("MerchantRealNameAuthImpl#authQuery is result authQuery getAuthInfo is not null");
				vo.setSuccess(false);
				vo.setErrorCode(header.getRetCode() + "");
				vo.setErrorMessage(header.getRetMsg());
			}
			return vo;
		}

	}

	@Override
	public MerchantRealNameAuthQueryResp authQueryInfo(String merchantNo, String zfCode) throws Exception {
		logger.info("authQueryInfo.merchantNo:" + merchantNo);
		JSONObject jsonResponse;
		MerchantRealNameAuthQueryReq request = this.getRequest(merchantNo, zfCode);
		JSONObject jsonRequest = JSONObject.fromObject(request);
		logger.info("authQueryInfo.request.jsonObject=" + jsonRequest);
		MerchantRealNameAuthQueryResp authQuery = merchantRealNameAuth.authQuery(request);
		jsonResponse = JSONObject.fromObject(authQuery);
		logger.info("authQueryInfo.authQuery=" + jsonResponse);
		return authQuery;
	}

	@Override
	public String getAuthQueryCertNo(String merchantNo) {
		logger.info("getAuthQueryCertNo.merchantNo:" + merchantNo);
		String certNo = null;
		try {
			MerchantRealNameAuthQueryResp authQuery = authQueryInfo(merchantNo, "zf910");
			if (authQuery != null && authQuery.getAuthInfo() != null) { return authQuery.getAuthInfo().getCertiValue(); }
			return certNo;
		} catch (Exception e) {
			logger.info("getAuthQueryCertNo is Exception.merchantNo:" + merchantNo,e);
		}
		return null;
	}

}
