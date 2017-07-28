package com.sdp.mc.credit.wrapper.impl;

import org.slf4j.Logger;import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sdp.mc.credit.wrapper.CreditServiceWrapper;
import com.shengpay.credit.itf.CreditDataService;
import com.shengpay.credit.itf.CreditModelService;

@Service("CreditServiceWrapperImpl")
public class CreditServiceWrapperImpl implements CreditServiceWrapper {
	private static final Logger log = LoggerFactory.getLogger(CreditServiceWrapperImpl.class);
	@Autowired
	private CreditDataService creditDataService;

	@Autowired
	private CreditModelService creditModelService;

	/**
	 * 根据策略、所有人获取征信模型
	 *
	 * @param request
	 * **/
	public String getCreditModel(String request) throws Exception{
		try {
			log.info("CreditServiceWrapperImpl.getCreditModel.request=" + request);
			String response = this.creditModelService.getCreditModel(request);
			log.info("CreditServiceWrapperImpl.getCreditModel.response=" + response);
			return response;
		} catch (Exception e) {
			log.error("CreditServiceWrapperImpl.getCreditModel.error,request=" + request, e);
			throw e;
		}
	}
	/**
	 * 征信评估数据提交接口
	 * **/
	public String submitCredit(String request) throws Exception{
		try {
			log.info("CreditServiceWrapperImpl.submitCredit.request=" + request);
			String response = this.creditDataService.submitCredit(request);
			log.info("CreditServiceWrapperImpl.submitCredit.response=" + response);
			return response;
		} catch (Exception e) {
			log.error("CreditServiceWrapperImpl.submitCredit.error,request=" + request, e);
			throw e;
		}
	}
	/**
	 * 信用评估结果查询接口
	 * **/
	public String getCreditScore(String request) throws Exception{
		try {
			log.info("CreditServiceWrapperImpl.getCreditScore.request=" + request);
			String response = this.creditDataService.getCreditScore(request);
			log.info("CreditServiceWrapperImpl.getCreditScore.response=" + response);
			return response;
		} catch (Exception e) {
			log.error("CreditServiceWrapperImpl.getCreditScore.error,request=" + request, e);
			throw e;
		}
	}
}
