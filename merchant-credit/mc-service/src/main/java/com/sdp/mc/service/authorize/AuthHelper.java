package com.sdp.mc.service.authorize;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Timer;
import java.util.TimerTask;

import org.springframework.web.context.ContextLoader;
import org.springframework.web.context.WebApplicationContext;

import com.sdp.mc.dao.authorize.RuleEO;


/**
 * 
 * 权限缓存
 * 
 * @author zhangmeng.michael
 * 
 */
public class AuthHelper {

	/** 权限组标志，目前权限组与权限在同一张表 */
	public static final long GROUP_FLAG = -1;
	/** 权限类型 -pos */
	public static final String MERCHANT_TYPE_POS = "POS";
	/** 权限类型 -pos */
	public static final String MERCHANT_TYPE_MPOS = "MPOS";
	/** 权限类型 -pos */
	public static final String MERCHANT_TYPE_MPOSSDK = "MPOSSDK";
	/** 权限类型 -pos */
	public static final String MERCHANT_TYPE_POSMC = "POSMC";
	/** 权限类型 -pos */
	public static final String MERCHANT_TYPE_TRANSACTION_MANAGE = "事件管理";
	/** 所有权限分类*/
	private static List<String> RULE_TYPE_LIST = new ArrayList<String>();
	/** 存放所有权限组 */
	private static List<RuleEO> RULE_GROUP_LIST = new ArrayList<RuleEO>();
	/** 存放所有权限 */
	private static Map<String, RuleEO> CODE_RULE_MAP = new HashMap<String, RuleEO>();

	/** 存放所有权限信息 */
	private static Map<String, List<RuleEO>> RULE_MAP = new HashMap<String, List<RuleEO>>();
	/** 存放分类与权限对应关系 */
	private static Map<String, List<String>> RULE_TYPE_MAP = new HashMap<String, List<String>>();
	/** 存放rule 与 rule 的对应关系 */
	private static Map<String, Set<String>> RULE_URL_MAP = new HashMap<String, Set<String>>();

	/**
	 * 初始化权限分类
	 * @param list
	 */
	public static void initRuleType(List<String> list) {
		RULE_TYPE_LIST=list;
	}

	/**
	 * 初始化权限
	 * 
	 * @param list
	 */
	public static void initRule(List<RuleEO> list) {
		HashMap<Long, RuleEO> idRuleMap = new HashMap<Long, RuleEO>();
		HashMap<String, RuleEO> codeRuleMap = new HashMap<String, RuleEO>();
		Map<String, List<RuleEO>> ruleMap = new HashMap<String, List<RuleEO>>();
		Map<String, List<String>> ruleTypeMap = new HashMap<String, List<String>>();

		for (RuleEO eo : list) {
			idRuleMap.put(eo.getId(), eo);
			codeRuleMap.put(eo.getRuleCode(), eo);
			if (GROUP_FLAG == eo.getRuleGroup()) {
				ruleMap.put(eo.getRuleCode(), new ArrayList<RuleEO>());
				if(ruleTypeMap.get(eo.getRuleMerchantType())==null){
					ruleTypeMap.put(eo.getRuleMerchantType(), new ArrayList<String>());
				}
				ruleTypeMap.get(eo.getRuleMerchantType()).add(eo.getRuleCode());
			} else {
				ruleMap.get(idRuleMap.get(eo.getRuleGroup()).getRuleCode())
						.add(eo);
			}
		}
		CODE_RULE_MAP = codeRuleMap;
		RULE_MAP = ruleMap;
		RULE_TYPE_MAP=ruleTypeMap;
	}

	/**
	 * 初始化rule
	 * 
	 * @param rule_url关系
	 */
	public static void initRuleURL(Map<String, Set<String>> rule_url_map) {
		RULE_URL_MAP = rule_url_map;
	}

	/**
	 * 获取权限分组
	 * 
	 * @return
	 */
	public static List<RuleEO> getRuleGroup() {
		return RULE_GROUP_LIST;
	}
	/**
	 * 获取所有权限，含权限组,权限关系
	 * 
	 * @return key ruleGroup, value rules
	 */
	public static Map<String, List<RuleEO>> getAllRules() {
		return RULE_MAP;
	}

	/**
	 * 获取pos权限，含权限组,权限关系
	 * 
	 * @return key ruleGroup, value rules
	 */
	/**
	 * 获取所有权限
	 * 
	 * @return key code , value rule
	 */
	public static Map<String, RuleEO> getRuleMap() {
		return CODE_RULE_MAP;
	}

	/**
	 * 获取权限url对应关系
	 * 
	 * @return
	 */
	public static Map<String, Set<String>> getRuleUrl() {
		return RULE_URL_MAP;
	}
	/**
	 * 获取分类与权限对应关系
	 * @return
	 */
	public static Map<String, List<String>>getRuleType(){
		return RULE_TYPE_MAP;
	}
	/**
	 * 获取所有的权限分类
	 * @return
	 */
	public static List<String> getAllRuleType(){
		return RULE_TYPE_LIST;
	}

	public static void timerUpdate() {
		        Timer timer = new Timer();  
		        timer.schedule(new TimerTask() {  
		            public void run() {  
		            	WebApplicationContext wac = ContextLoader.getCurrentWebApplicationContext();
						((AuthService) wac.getBean("authService")).loadAuthInfo();
		            }  
		        }, 300000, 300000); 
		
	}
}
