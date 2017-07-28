package com.sdp.mc.common.settle;

import com.sdp.mc.common.util.MCAppVarPropsUtil;

public class SettleApiConstants {


	public final static String expireTime = "2999-12-31";
	public final static String firstOpenDefalutTime = "1970-01-01 00:00:00";

	/**
	 * hession接口地址前缀
	 */
	private final static String HESSIAN_URL_PREFIX = MCAppVarPropsUtil.getStringProp("base.settle.hession.url.prefix", "");

	/**
	 * /splittingRuleInfoAPI
		/groupingInfoManagerAPI
		/merchantGroupManagerAPI
		/scUnderPromoterRuleInfoAPI
		/scStairAwardConfigAPI
		/settleMerchantInfoAPI
		/settleOrderServiceAPI
		/downloadsTaskAPI
		/promoterProfitsInfoAPI
		/calculateProfitServic
		/mccInfoManagerAPI
	 */

	/**
	 * 代理商分润
	 */
	public final static String PROMOTER_PROFITS_INFO_API_HESSIAN_URL = HESSIAN_URL_PREFIX + "promoterProfitsInfoAPI";
	/*
	 * 分组信息接口
	 */
	public final static String GROUP_INFO_HESSIAN_URL = HESSIAN_URL_PREFIX + "groupingInfoManagerAPI";

	/*
	 * 商户分组
	 */
	public final static String MERCHANT_GROUP_INFO_HESSIAN_URL = HESSIAN_URL_PREFIX + "merchantGroupManagerAPI";
	/**
	 * 分润比例
	 */
	public final static String SPLTTING_RULE_HESSIAN_URL = HESSIAN_URL_PREFIX + "splittingRuleInfoAPI";
	/**
	 * 周期阶梯奖惩
	 */
	public final static String SC_STAIR_WAWRD_CONFIG_HESSIAN_URL = HESSIAN_URL_PREFIX + "scStairAwardConfigAPI";

	/**
	 * 结算单管理API
	 */
	public final static String SC_SETTLE_ORDER_SERVICE_API = HESSIAN_URL_PREFIX + "settleOrderServiceAPI";
	/**
	 * 计算记录
	 */
	public final static String SC_SPLITTING_COMPUTE_LOG_API = HESSIAN_URL_PREFIX + "splittingComputeLogAPI";
	/**
	 * 结算单管理API
	 */
	public final static String CALCULATE_PROFIT_API = HESSIAN_URL_PREFIX + "calculateProfitServicAPI";

	/**
	 * mcc信息查询
	 */
	public final static String MCC_INFO_HESSIAN_URL = HESSIAN_URL_PREFIX + "mccInfoManagerAPI";

	/**
	 * 结算分润比例设置
	 */
	public final static String SC_UNDER_PROMOTER_RULE_INFO_API_HESSIAN_URL = HESSIAN_URL_PREFIX + "scUnderPromoterRuleInfoAPI";

	public final static String DOWNLOADS_FACADE_HESSIAN_URL = HESSIAN_URL_PREFIX + "downloadsTaskAPI";


	public final static String SETTLE_MERCHANT_DPL_RUL = HESSIAN_URL_PREFIX + "settleMerchantInfoAPI";

	public final static String PARTNER_PROMFIT_QUERY_API_RUL = HESSIAN_URL_PREFIX + "partnerPromfitQueryAPI";

	/**
	 * 清算日常报表
	 */
	public final static String PROMOTER_DAILY_REPORT_API_RUL = HESSIAN_URL_PREFIX + "promoterDailyReportAPI";
	
	public static final String PARTNER_PROMFIT_CONFIG_API_RUL = HESSIAN_URL_PREFIX + "partnerPromfitConfigAPI";
	
	public static final String PROMOTER_DAILY_PROFITS_API_RUL = HESSIAN_URL_PREFIX + "promoterDailyProfitsAPI";



}
