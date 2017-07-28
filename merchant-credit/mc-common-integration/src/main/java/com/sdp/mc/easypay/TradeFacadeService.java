package com.sdp.mc.easypay;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.lang.Validate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.sdp.mc.easypay.vo.MerchantDetailVO;
import com.sdp.mc.easypay.vo.MerchantQueryRequest;
import com.sdp.mc.easypay.vo.MerchantQueryResponse;
import com.sdp.mc.easypay.vo.QrCodeAllot;
import com.sdp.mc.easypay.vo.QrCodeQueryRequest;
import com.sdp.mc.easypay.vo.QrCodeQueryResponse;
import com.sdp.mc.easypay.vo.QrCodeRateQueryRequest;
import com.sdp.mc.easypay.vo.QrCodeRateQueryResponse;
import com.sdp.mc.easypay.vo.QrCodeRateVO;
import com.sdp.mc.easypay.vo.TradeItemVO;
import com.sdp.mc.easypay.vo.TradeRequest;
import com.sdp.mc.easypay.vo.TradeResponse;


@Service("tradeFacadeService")
public class TradeFacadeService {

	private static Logger logger = LoggerFactory.getLogger(TradeFacadeService.class);

	@Value("${easypay.rest.url}")
	private String easypayRestUrl;

	@Value("${easypay.api.url}")
	private String easypayApiUrl;

	private final static RestTemplate template = new RestTemplate();

	public TradeResponse query(TradeRequest request) {
		Map<String, Class> classMap = new HashMap<String, Class>();
		classMap.put("list", TradeItemVO.class);
		return postApiForObject(easypayApiUrl + "/msp/trans/query", JSON.toJSONString(request), TradeResponse.class);
	}

	public MerchantQueryResponse merchantQuery(MerchantQueryRequest request) {
		return postApiForObject(easypayApiUrl + "/msp/merchantInfo/query", JSON.toJSONString(request),
				MerchantQueryResponse.class);
	}

	public MerchantDetailVO merchantDetailQuery(String merchantNo) {
		Validate.notEmpty(merchantNo);
		String result = template.getForObject(easypayRestUrl + "/merchantInfo/detail/" + merchantNo, String.class);
		logger.info("easypay-services merchant detail :{}", result);

		JSONObject obj=JSON.parseObject(result);
		JSONObject respJson=obj.getJSONObject("resultObject");
		MerchantDetailVO vo=JSON.parseObject(respJson.toJSONString(), MerchantDetailVO.class);
		return vo;
	}

	public QrCodeQueryResponse qrcodeAllotQuery(QrCodeQueryRequest request) {
		return postForObject(easypayRestUrl + "/qrcode/allot/query", request.toString(), QrCodeQueryResponse.class);
	}

	public String qrcodeAllot(QrCodeAllot allot) {
		HttpHeaders headers = new HttpHeaders();
		headers.add("Content-Type", "application/x-www-form-urlencoded;charset=UTF-8");
		HttpEntity<String> entity = new HttpEntity<String>(allot.toString(), headers);
		String result = template.postForObject(easypayRestUrl + "/qrcode/allot/save", entity, String.class);
		logger.info("easypay-services QrCode Allot :{}", result);
		return result;
	}

	public String channelSwitch(String channel, String channelAction, String merchantNoArray) {
		HttpHeaders headers = new HttpHeaders();
		headers.add("Content-Type", "application/x-www-form-urlencoded;charset=UTF-8");
		HttpEntity<String> entity = new HttpEntity<String>(
				"channel=" + channel + "&channelAction=" + channelAction + "&merchantNoArray=" + merchantNoArray,
				headers);
		String result = template.postForObject(easypayRestUrl + "/merchantInfo/channel/switch", entity, String.class);
		logger.info("easypay-services channel switch :{}", result);
		return result;
	}

	public String deleteQrcode(String merchantNo, String id) {
		HttpHeaders headers = new HttpHeaders();
		headers.add("Content-Type", "application/json;charset=UTF-8");
		String result = template.getForObject(easypayApiUrl + "/msp/cancelChildMerchant/" + merchantNo + "/" + id,
				String.class);
		logger.info("easypay-services delete qrcode :{}", result);
		return result;
	}

	public QrCodeRateQueryResponse qrCodeRateQuery(QrCodeRateQueryRequest request) {
		Map<String, Class> classMap = new HashMap<String, Class>();
		classMap.put("list", QrCodeRateVO.class);
		return postForObject(easypayRestUrl + "/qrcode/rate/query", request.toString(), QrCodeRateQueryResponse.class);
	}

	public String qrCodeRateUpdate(String qrcodes, BigDecimal rate) {
		HttpHeaders headers = new HttpHeaders();
		headers.add("Content-Type", "application/x-www-form-urlencoded;charset=UTF-8");
		HttpEntity<String> entity = new HttpEntity<String>("qrcodes=" + qrcodes + "&rate=" + rate, headers);
		String result = template.postForObject(easypayRestUrl + "/qrcode/rate/update", entity, String.class);
		logger.info("easypay-services qrCodeRateUpdate  :{}", result);
		return result;
	}

	public String allowStatus(String qrcodes, String allowStatus) {
		HttpHeaders headers = new HttpHeaders();
		headers.add("Content-Type", "application/x-www-form-urlencoded;charset=UTF-8");
		HttpEntity<String> entity = new HttpEntity<String>("qrcodes=" + qrcodes + "&allowStatus=" + allowStatus,
				headers);
		String result = template.postForObject(easypayRestUrl + "/qrcode/allowstatus/update", entity, String.class);
		logger.info("easypay-services allowStatus  :{}", result);
		return result;
	}



	@SuppressWarnings("unchecked")
	private <T> T postForObject(String url, String requestParam, Class<T> clazz) {
		T resp = null;
		try {
			HttpHeaders headers = new HttpHeaders();
			headers.add("Content-Type", "application/x-www-form-urlencoded;charset=UTF-8");
			HttpEntity<String> entity = new HttpEntity<String>(requestParam, headers);
			logger.info("easypay-services {} :{}", clazz.getSimpleName(), entity);
			String result = template.postForObject(url, entity, String.class);
			logger.info("easypay-services {} :{}", clazz.getSimpleName(), result);

			JSONObject obj=JSON.parseObject(result);
			JSONObject respJson=obj.getJSONObject("resultObject");
			resp=JSON.parseObject(respJson.toJSONString(), clazz);
		} catch (Exception e) {
			logger.error("easypay-services {} exception", clazz.getSimpleName(), e);
		}
		return resp;
	}

	@SuppressWarnings("unchecked")
	private <T> T postApiForObject(String url, String requestParam, Class<T> clazz) {
		T resp = null;
		try {
			HttpHeaders headers = new HttpHeaders();
			headers.add("Content-Type", "application/json;charset=UTF-8");
			HttpEntity<String> entity = new HttpEntity<String>(requestParam, headers);
			logger.info("easypay-services {} :{}", clazz.getSimpleName(), entity);
			String result = template.postForObject(url, entity, String.class);
			logger.info("easypay-services {} :{}", clazz.getSimpleName(), result);
			JSONObject obj=JSON.parseObject(result);
			JSONObject respJson=obj.getJSONObject("resultObject");
			resp=JSON.parseObject(respJson.toJSONString(), clazz);
		} catch (Exception e) {
			logger.error("easypay-services {} exception", clazz.getSimpleName(), e);
		}
		return resp;
	}

}
