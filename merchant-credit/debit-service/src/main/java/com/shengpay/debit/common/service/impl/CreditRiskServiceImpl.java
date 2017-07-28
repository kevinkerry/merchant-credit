package com.shengpay.debit.common.service.impl;

import java.util.HashMap;
import java.util.Map;

import net.sf.json.JSONObject;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSON;
import com.sdp.mc.common.vo.ErrorMessageVO;
import com.sdp.mc.credit.wrapper.CreditServiceWrapper;
import com.sdp.mc.ma.wrapper.impl.IOperatorServiceWrapperImpl;
import com.shengpay.commom.config.GlobalConfig;
import com.shengpay.debit.common.enums.ConfigEnums;
import com.shengpay.debit.common.risk.model.CreditRiskErrorMessageVO;
import com.shengpay.debit.common.risk.model.CreditRiskResult;
import com.shengpay.debit.common.risk.model.CreditRiskSubmitRootVO;
import com.shengpay.debit.common.risk.model.GetCreditRiskResponseModel;
import com.shengpay.debit.common.service.CreditRiskService;
import com.shengpay.debit.common.service.DebitConfigService;

/**
 * 风控交互服务类
 *
 * @author heyi.alex
 *
 */

@Service
public class CreditRiskServiceImpl implements CreditRiskService {

	private static final Logger log = LoggerFactory
			.getLogger(IOperatorServiceWrapperImpl.class);

	@Autowired
	private CreditServiceWrapper creditServiceWrapper;

	@Autowired
	private DebitConfigService debitConfigService;

	private static final String ignoreCodeStr = GlobalConfig
			.getString("ignore.risk.code","");

	private String getValue(ConfigEnums enums) {
		return debitConfigService.getByKey(enums);
	}

	/**
	 * 获取从风控用户需要输入的输入内容
	 */
	public GetCreditRiskResponseModel getCreditRiskModel() {
		Map<String, String> sendParam = new HashMap<String, String>();
		sendParam.put(getValue(ConfigEnums.RISK_POLICY_NAME),
				getValue(ConfigEnums.RISK_POLICY_VALUE));
		sendParam.put(getValue(ConfigEnums.RISK_OWNER_NAME),
				getValue(ConfigEnums.RISK_OWNER_VALUE));
		JSONObject sendParamJson = JSONObject.fromObject(sendParam);
		try {
			String response = creditServiceWrapper.getCreditModel(sendParamJson
					.toString());
			if (StringUtils.isNotEmpty(response)) {
				GetCreditRiskResponseModel resModel = RiskItemUtil.ignoreRisk(
						JSON.parseObject(response,
								GetCreditRiskResponseModel.class),
						ignoreCodeStr.split(","));
				return resModel;
			}
		} catch (Exception e) {
			log.error("getCreditRiskModel system error", e);
		}
		return null;
	}

	/***
	 * 提交商户评级请求
	 * **/
	public ErrorMessageVO submitCredit(
			CreditRiskSubmitRootVO creditRiskSubmitRoot) {
		JSONObject json = JSONObject.fromObject(creditRiskSubmitRoot);
		// 将json串更新到数据库
		try {
			String responseText = this.creditServiceWrapper.submitCredit(json
					.toString());
			if (StringUtils.isBlank(responseText)) {
				return new ErrorMessageVO(true, "0", "请求成功");
			}
			CreditRiskErrorMessageVO em = (CreditRiskErrorMessageVO) JSONObject
					.toBean(JSONObject.fromObject(responseText),
							CreditRiskErrorMessageVO.class);
			return em.toErrorMessageVO();
		} catch (Exception e) {
			log.error("CreditRiskServiceImpl.submitCredit.error", e);
			return new ErrorMessageVO(false, "-1", e.getMessage());
		}
	}

	/***
	 * 查询商户评级结果
	 * **/
	public CreditRiskResult getCreditScore(String merchantNo) {
		try {
			JSONObject json = new JSONObject();
			json.put("code", merchantNo);
			json.put(getValue(ConfigEnums.RISK_POLICY_NAME),
					getValue(ConfigEnums.RISK_POLICY_VALUE));
			String responseText = this.creditServiceWrapper.getCreditScore(json
					.toString());
			CreditRiskResult crr = (CreditRiskResult) JSONObject
					.toBean(JSONObject.fromObject(responseText),
							CreditRiskResult.class);
			return crr;
		} catch (Exception e) {
			log.error("CreditRiskServiceImpl.getCreditScore.error", e);
			return new CreditRiskResult("-1", "查询评级失败");
		}
	}
}
