package com.sdp.mc.common.util;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Timer;
import java.util.TimerTask;

import org.springframework.web.context.ContextLoader;
import org.springframework.web.context.WebApplicationContext;

import com.sdo.common.lang.StringUtil;
import com.sdp.mc.common.vo.ConfigOptionVO;

/**
 * 系统配置表工具类
 * 
 * **/
public class ConfigOptionHelper {

	private static Map<String, ConfigOptionVO> allKeyValues = new HashMap<String, ConfigOptionVO>();;

	public static void init(List<ConfigOptionVO> list) {
		if (list.isEmpty()) {
			return;
		}
		for (ConfigOptionVO eo : list) {
			allKeyValues.put(eo.getOptionKey(), eo);
		}
	}

	/**
	 * 根据分类码，建，取值
	 */
	public static Integer getInt(String key) {
		ConfigOptionVO vo = allKeyValues.get(key);
		if (vo == null) {
			return null;
		} else if (vo.getOptionValue() != null) {
			return Integer.parseInt(vo.getOptionValue());
		} else {
			return Integer.parseInt(vo.getOptionDefValue());
		}
	}

	public static  String getValue(String key) {
		ConfigOptionVO vo = allKeyValues.get(key);
		if (vo == null) {
			return null;
		} else if (vo.getOptionValue() != null) {
			return vo.getOptionValue();
		} else {
			return vo.getOptionDefValue();
		}
	}
	
	public static  String getConfigByKey(String key) {
		return getValue(key);
	}
	
	public static  BigDecimal getBigDecimalByKey(String key,BigDecimal defValue) {
		String value = getValue(key);
		if (value != null) {
			return new BigDecimal(value);
		}
		return defValue;
	}
	public static  Long getLongByKey(String key) {
		String value = getValue(key);
		if (value != null) {
			return Long.valueOf(value);
		}
		return null;
	}

	public static  boolean getBooleanByKey(String key) {
		String cfg = getValue(key);
		if ("".equals(cfg) || cfg == null) {
			return false;
		}
		return Boolean.valueOf(cfg);
	}
	
	public static BigDecimal getHasOATxnWithdrawCost(BigDecimal defaultValue) {
		String cost=getValue(HAS_OA_TXN_WITHDRAW_COST);
		if(StringUtil.isNotBlank(cost)){
			return new BigDecimal(cost);
		}
		return defaultValue;
	}

	public static String OPERATOR_ACCESS_LOCK_TIME = "operatorAccessLockTime";// 操作者访问锁定时间
	
	public static String HAS_OA_TXN_WITHDRAW_COST = "HAS.OA.TXN.WITHDRAW.COST";// 操作者访问锁定时间
	/**
	 * 允许的最大累计刷功能次数，达到后操作员就被锁定
	 */
	public static Integer MAX_FAST_OPEATER_TIMES = 20;

	/** 初次上线代理商白名单 **/
	public static String FAST_SETTLE_PROMOTER_WHITE_LIST = "FAST_SETTLE_PROMOTER_WHITE_LIST";

	
}
