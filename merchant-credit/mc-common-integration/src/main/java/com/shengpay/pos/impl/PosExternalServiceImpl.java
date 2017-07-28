package com.shengpay.pos.impl;

import java.util.HashMap;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.sdp.mc.common.hessian.RemotingCallUtil;
import com.sdp.mc.common.hessian.RemotingModuleEnum;
import com.shengpay.commom.config.GlobalConfig;
import com.shengpay.pos.PosExternalService;
import com.shengpay.pos.external.api.PosExternalApi;
import com.shengpay.pos.external.api.request.PosExternalRequest;
import com.shengpay.pos.external.api.response.PosExternalResponse;
@Service("PosExternalService")
public class PosExternalServiceImpl implements PosExternalService {
	private final String SERVICEID_QUERY_CREDIT_AUTHENTICATION="10001";
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	private PosExternalApi posExternalApi;
	public PosExternalApi getPosExternalApi() {
		if (posExternalApi == null) {
			posExternalApi = RemotingCallUtil.getHessianServiceByModuleWithoutCanonicalName(RemotingModuleEnum.POS_EXTERNAL_API_HESSION_URL,
					PosExternalApi.class);
		}
		return posExternalApi;
	}
	
	public void setPosExternalApi(PosExternalApi posExternalApi) {
		this.posExternalApi = posExternalApi;
	}
	
	private String zfCode;
	
	private String key;
	
    @Override
	public int queryCreditAuthentication(String merchantNo){
		logger.info("queryCreditAuthentication init,merchantNo:" + merchantNo);
		PosExternalRequest externalRequest=new PosExternalRequest();
		try {
			 if(StringUtils.isBlank(zfCode)){
				 zfCode = GlobalConfig.getString("pos.external.api.zfcode");
	         }
	         if(StringUtils.isBlank(key)){
	        	 key= GlobalConfig.getString("pos.external.api.key");
	         }
			externalRequest.setAppId(zfCode);
			externalRequest.setServiceId(SERVICEID_QUERY_CREDIT_AUTHENTICATION);
			Map<String,Object> reqMap=new HashMap<String,Object>();
			reqMap.put("merchantId", merchantNo);
			externalRequest.setReqMap(reqMap);
//			externalRequest.setMac(key);
			String mac=externalRequest.sign(key);
			externalRequest.setMac(mac);
			
			logger.info("queryCreditAuthentication PosExternalRequest:" + ToStringBuilder.reflectionToString(externalRequest, ToStringStyle.SHORT_PREFIX_STYLE));
			PosExternalResponse response= getPosExternalApi().processRequest(externalRequest);
			logger.info("queryCreditAuthentication processRequest PosExternalResponse:" + ToStringBuilder.reflectionToString(response, ToStringStyle.SHORT_PREFIX_STYLE));
			if(response!=null&&response.getRespMap()!=null&&response.getRespMap().get("creditCTFCount")!=null){
				return (Integer) response.getRespMap().get("creditCTFCount");
			}
		} catch (Exception e) {
			logger.error("queryCreditAuthentication Exception,merchantNo:" + merchantNo,e);
		}
		return -1;
		
	}

	public String getZfCode() {
		return zfCode;
	}

	public void setZfCode(String zfCode) {
		this.zfCode = zfCode;
	}

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}
	
	
	
}
