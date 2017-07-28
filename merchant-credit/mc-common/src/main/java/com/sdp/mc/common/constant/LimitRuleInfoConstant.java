package com.sdp.mc.common.constant;

import java.util.HashMap;
import java.util.Map;


public class LimitRuleInfoConstant {
	/**
	 * 内存中试算规则前缀
	 */
	public static final String LIMIT_RULE_TRIAL_KEY_PREFIX = "LIMIT_RULE_TRIAL_KEY_";
	/**
	 * 内存中试算规则文件前缀
	 */
	public static final String LIMIT_RULE_TRIAL_FILE_PREFIX = "LIMIT_RULE_TRIAL_FILE";
	/**
	 * 试算文件存放路径配置文件的的KEY
	 */
	public static final String LIMIT_RULE_TRIAL_FILE_PATH = "limit.rule.trial.file.path";
	/**
	 * 老T0商户升级新T0（POS）
	 */
	public static final int POS_OLDT0_UPGRADE_NEWT0_LIMIT_RULE_ID = 1;
	/**
	 * 商户开通新T0（POS） 
	 */
	public static final int POS_OPEN_NEWT0_LIMIT_RULE_ID = 2;
	/**
	 * 新T0商户额度自动更新（POS）
	 */
	public static final int POS_NEWT0_UPDATE_LIMIT_RULE_ID = 3;
	/**
	 * 老T0商户升级新T0（MPOS）
	 */
    public static final int MPOS_OLDT0_UPGRADE_NEWT0_LIMIT_RULE_ID = 4;
	/**
	 *  商户开通新T0（MPOS） 
	 */
	public static final int MPOS_OPEN_NEWT0_LIMIT_RULE_ID = 5;
	/**
	 * 新T0商户额度自动更新（MPOS）
	 */
	public static final int MPOS_NEWT0_UPDATE_LIMIT_RULE_ID = 6; 
	
	/**
	 *  商户开通新T0（云收银） 
	 */
	public static final int EASYPAY_OPEN_NEWT0_LIMIT_RULE_ID = 7;
	/**
	 * 额度计算页面来源
	 */
	public static final int LIMIT_RULE_COMPUTE_SOURCE_PAGE=1;
	/**
	 * 额度计算自动更新来源
	 */
	public static final int LIMIT_RULE_COMPUTE_SOURCE_AOTU_UPDATE=2;
	
	/**
	 * 试算文件存放路径配置文件的的KEY
	 */
	public static final String AUTO_UPDATE_MERCHANT_LIMIT_MSG = "白名单内商户不自动变更额度";

	
	public static  Map<String,String> LIMIT_RULE_TRIAL_RUELT_MAP = new HashMap<String, String>();
	
	
	
	}
