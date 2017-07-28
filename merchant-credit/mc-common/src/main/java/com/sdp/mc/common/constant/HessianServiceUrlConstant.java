package com.sdp.mc.common.constant;

import com.shengpay.commom.config.GlobalConfig;

public class HessianServiceUrlConstant {
	public static final String MC_SERIVCE_WEBSITE_URL_PATH = "mc.serivce.website.url";
	public static final String MC_SERIVCE_WEBSITE_URL =GlobalConfig.getString(MC_SERIVCE_WEBSITE_URL_PATH) ;
	public static final String MC_SERIVCE_FAST_SETTLE =MC_SERIVCE_WEBSITE_URL+"/fastSettle" ;
	
	public static final String MC_SERIVCE_LOANING_CONGFIG_SERVICE =MC_SERIVCE_WEBSITE_URL+"/LoaningCongfigService" ;
	
	public static final String MC_SERIVCE_TIMED_TASK_API =MC_SERIVCE_WEBSITE_URL+"/timedTaskAPI" ;
	
	public static final String MC_SERIVCE_MANAGER_SERVICE =MC_SERIVCE_WEBSITE_URL+"/mcManagerService" ;
	
}
