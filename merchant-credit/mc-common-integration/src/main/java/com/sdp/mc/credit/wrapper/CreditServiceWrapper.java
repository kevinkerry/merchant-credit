package com.sdp.mc.credit.wrapper;


public interface CreditServiceWrapper {

	/**
	 * 根据策略、所有人获取征信模型
	 *
	 * @param request
	 * **/
	public String getCreditModel(String request) throws Exception;
	/**
	 * 征信评估数据提交接口
	 * **/
	public String submitCredit(String request) throws Exception;

	/**
	 * 信用评估结果查询接口
	 * **/
	public String getCreditScore(String request) throws Exception;
}
