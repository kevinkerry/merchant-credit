package com.sdp.mc.common.constant;

import com.shengpay.commom.config.GlobalConfig;

public class PersonalCreditConstant {

	public static final String AUTO_REPAYMENT_RESULT =GlobalConfig.getString("auto.repayment.result") ;
	//自动代扣配置
	public static final String AUTO_WITHHOLD_RESULT =GlobalConfig.getString("auto.withhold.result") ;
	//自动查询配置
	public static final String AUTO_WITHHOLD_QUERY_RESULT =GlobalConfig.getString("auto.withhold.query.result") ;
}
