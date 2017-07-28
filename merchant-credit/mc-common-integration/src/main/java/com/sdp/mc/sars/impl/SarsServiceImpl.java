package com.sdp.mc.sars.impl;

import java.util.Map;

import org.slf4j.Logger;import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.sdp.mc.sars.SarsService;
import com.shengpay.sars.client.api.SarsClientService;
import com.shengpay.sars.client.api.VerifyResult;

/**
 * sars服务封装
 *
 * @author liuxi.xiliu
 */
@Service("sarsService")
public class SarsServiceImpl implements SarsService {

	private Logger logger = LoggerFactory.getLogger(this.getClass());
	public static String SARS_RESULT_PASS = "000";
	public static String SARS_RESULT_REJECT = "001";
	public static String SARS_RESULT_DETENTION = "002";
	public static String SARS_RESULT_WARNING = "003";
	public static String SARS_RESULT_EXCEPTION = "999";

	@Autowired
	SarsClientService sarsClientService;

	/**
	 * T+0 风控接入
	 *
	 * @param json
	 * @return
	 * @throws RuntimeException
	 * @author ganquan
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public boolean sarsClientVerify(String json) throws RuntimeException {
		logger.info("sarsClientVerify init json:"+ json);
		JSONObject data = JSON.parseObject(json);
		Map event = (Map) data;
		try {
			VerifyResult r = sarsClientService.verify(event);
			/**
			 * 吴亦乐.Jack [14:53]: 001 002 打断交易 003 004 预警和监控和你们无关 000通过 999 异常
			 * 你们也放过
			 */
			if (r != null){
				logger.info("sars result:\n" + "return:" + r.getResult() + ";msg:" + r.getMsg());
			if (SARS_RESULT_REJECT.equalsIgnoreCase(r.getResult()) || SARS_RESULT_DETENTION.equalsIgnoreCase(r.getResult()))
				return false;
			else return true;
			}

		} catch (Exception e) {
			logger.error("sendSarsClientError" + json, e);
		}
		return false;
	}

	/**
	 * 根据查询条件查找限额限次记录
	 *
	 * @param sarsQuotaPosRequest
	 *            查询条件
	 * @return response
	 */
	// @WebMethod(operationName = "QuerySarsQuotaPos")
	// @WebResult(name = "result")
	// public SarsQuotaPosResponse querySarsQuotaPos(@WebParam(name =
	// "sarsQuotaPosRequest") SarsQuotaPosRequest sarsQuotaPosRequest){
	//
	//
	// }
}
