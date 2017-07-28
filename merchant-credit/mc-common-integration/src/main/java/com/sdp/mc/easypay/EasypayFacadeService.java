package com.sdp.mc.easypay;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.alibaba.fastjson.JSON;
import com.sdp.mc.easypay.vo.BussinessChildrensListVo;
import com.sdp.mc.easypay.vo.BussinessChildrensVo;
import com.sdp.mc.easypay.vo.BussinessKeyVo;
import com.sdp.mc.easypay.vo.BussinessTypeUtil;
import com.sdp.mc.easypay.vo.EnterpriseAccountQueryRequest;
import com.sdp.mc.easypay.vo.EnterpriseAccountQueryResponse;
import com.sdp.mc.easypay.vo.EnterpriseAccountVo;
import com.sdp.mc.easypay.vo.EnterpriseRegisterReq;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

@Service("easypayFacadeService")
public class EasypayFacadeService {

	private static Logger logger = LoggerFactory.getLogger(EasypayFacadeService.class);

	@Value("${easypay.api.url}")
	private String easyPayApiUrl;

	private final static RestTemplate template = new RestTemplate();

	public EnterpriseAccountQueryResponse enterpriseAccountQuery(EnterpriseAccountQueryRequest requestParam) {
		EnterpriseAccountQueryResponse resp = null;
		Map<String, Class> classMap = new HashMap<String, Class>();
		try {
			HttpHeaders headers = new HttpHeaders();
			headers.add("Content-Type", "application/json;charset=UTF-8");
			HttpEntity<String> entity = new HttpEntity<String>(JSON.toJSONString(requestParam), headers);
			logger.info("enterpriseAccountQuery entity {}", entity);
			String result = template.postForObject(easyPayApiUrl + "/enterprise/queryListRecord", entity, String.class);
			logger.info("enterpriseAccountQuery result {}", result);
			JSONObject obj = JSONObject.fromObject(result);
			JSONObject respJson = obj.getJSONObject("resultObject");
			classMap.put("list", EnterpriseAccountVo.class);
			resp = (EnterpriseAccountQueryResponse) JSONObject.toBean(respJson, EnterpriseAccountQueryResponse.class,
					classMap);
		} catch (Exception e) {
			logger.error("enterpriseAccountQuery {} {}", e.getMessage(), e);
		}
		return resp;
	}

	public String queryIndustryCategory() {
		String strRequest = "";
		try {
			HttpHeaders headers = new HttpHeaders();
			headers.add("Content-Type", "application/json;charset=UTF-8");
			HttpEntity<String> entity = new HttpEntity<String>(headers);
			logger.info("enterpriseAccountQuery entity {}", entity);
			String result = template.postForObject(easyPayApiUrl + "/enterprise/queryIndustryCategory", entity,
					String.class);
			logger.info("enterpriseAccountQuery result {}", result);
			JSONObject obj = JSONObject.fromObject(result);
			obj.getJSONArray("resultObject");
			JSONArray respJson = obj.getJSONArray("resultObject");
			strRequest = respJson.toString();
		} catch (Exception e) {
			logger.error("enterpriseAccountQuery {} {}", e.getMessage(), e);
		}
		return strRequest;
	}

	public EnterpriseRegisterReq queryRecord(String id) {
		EnterpriseRegisterReq registerReq = null;
		try {
			HttpHeaders headers = new HttpHeaders();
			headers.add("Content-Type", "application/json;charset=UTF-8");
			HttpEntity<String> entity = new HttpEntity<String>(headers);
			logger.info("queryRecord entity {}", entity);
			String result = template.postForObject(easyPayApiUrl + "/enterprise/queryRecord/" + id, entity,
					String.class);
			logger.info("queryRecord result {}", result);
			JSONObject obj = JSONObject.fromObject(result);
			JSONObject respJson = obj.getJSONObject("resultObject");
			registerReq = (EnterpriseRegisterReq) JSONObject.toBean(respJson, EnterpriseRegisterReq.class);
		} catch (Exception e) {
			logger.error("queryRecord {} {}", e.getMessage(), e);
		}
		return registerReq;
	}

	public String register(EnterpriseRegisterReq enterpriseRegisterReq) {
		String result = "";
		try {
			HttpHeaders headers = new HttpHeaders();
			headers.add("Content-Type", "application/json;charset=UTF-8");
			HttpEntity<String> entity = new HttpEntity<String>(JSON.toJSONString(enterpriseRegisterReq), headers);
			logger.info("register entity {}", entity);
			result = template.postForObject(easyPayApiUrl + "/enterprise/register", entity, String.class);
			logger.info("register result {}", result);
		} catch (Exception e) {
			logger.error("register {} {}", e.getMessage(), e);
		}
		return result;
	}
	
	public String updateRecord(EnterpriseRegisterReq enterpriseRegisterReq) {
		String result = "";
		try {
			HttpHeaders headers = new HttpHeaders();
			headers.add("Content-Type", "application/json;charset=UTF-8");
			HttpEntity<String> entity = new HttpEntity<String>(JSON.toJSONString(enterpriseRegisterReq), headers);
			logger.info("register entity {}", entity);
			result = template.postForObject(easyPayApiUrl + "/enterprise/updateRecord", entity, String.class);
			logger.info("register result {}", result);
		} catch (Exception e) {
			logger.error("updateRecord {} {}", e.getMessage(), e);
		}
		return result;
	}
	
	@SuppressWarnings("unchecked")
	public BussinessTypeUtil getBussinessName(String bussinessTypeList, String key) {
		BussinessKeyVo bussinessKeyVo = new BussinessKeyVo();
		BussinessChildrensVo bussinessChildrensVo = new BussinessChildrensVo();
		BussinessChildrensListVo bussinessChildrensListVo = new BussinessChildrensListVo();
		BussinessTypeUtil bussinessTypeUtil = new BussinessTypeUtil();
		try {
			JSONArray bussinessTypeArray = JSONArray.fromObject(bussinessTypeList);
			for (Object object : bussinessTypeArray) {
				JSONObject obj = JSONObject.fromObject(object);
				bussinessChildrensListVo = (BussinessChildrensListVo) JSONObject.toBean(obj,BussinessChildrensListVo.class);
				JSONArray bussinessChildrensArray = obj.getJSONArray("childrens");
				for (Object object2 : bussinessChildrensArray) {
					JSONObject obj2 = JSONObject.fromObject(object2);
					bussinessChildrensVo = (BussinessChildrensVo) JSONObject.toBean(obj2,BussinessChildrensVo.class);
					JSONArray bussinessKeyArray = obj2.getJSONArray("childrens");
					for (Object object3 : bussinessKeyArray) {
						JSONObject obj3 = JSONObject.fromObject(object3);
						bussinessKeyVo = (BussinessKeyVo) JSONObject.toBean(obj3,BussinessKeyVo.class);
						if(key.equals(bussinessKeyVo.getIndustryKey())){
							if(StringUtils.isBlank(bussinessChildrensVo.getIndustryName())){
								bussinessChildrensVo.setIndustryName(bussinessChildrensListVo.getIndustryName());
							}
							if(StringUtils.isBlank(bussinessKeyVo.getIndustryName())){
								bussinessKeyVo.setIndustryName(bussinessChildrensVo.getIndustryName());
							}
							bussinessTypeUtil.setFirstColumn(bussinessChildrensListVo.getIndustryName());
							bussinessTypeUtil.setSecondColumn(bussinessChildrensVo.getIndustryName());
							bussinessTypeUtil.setThirdColumn(bussinessKeyVo.getIndustryName());
						}
					}
				}
			}
		} catch (Exception e) {
			logger.error("getBussinessName {} {}", e.getMessage(), e);
		}
		return bussinessTypeUtil;
	}
}
