package com.sdp.mc.common.util;

import java.util.HashMap;
import java.util.Map;

import org.apache.commons.lang.StringUtils;

/**
 * MapUtil
 * 
 * @author liuxi.xiliu
 */
public class MapUtil {

	/**
	 * 传入一组key和value，返回map
	 */
	public static Map<String, String> forSimpleMap(String[] keys, String[] values) {
		Map<String, String> map = new HashMap<String, String>();
		for (int i = 0; i < keys.length; i++) {
			map.put(keys[i], values[i]);
		}
		return map;
	}

	/**
	 * 简单取值，返回指定的类型。不存在的话返null 支持常用简单数据类型
	 */
	@SuppressWarnings("unchecked")
	public static <T> T getValue(Map<Object, Object> map, Object key, Class<T> clazz) {
		Object v = map.get(key);
		if (v == null) {
			return null;
		}
		String vs = String.valueOf(v).trim();
		if (String.class.equals(clazz)) {
			return (T) vs;
		} else if (Integer.class.equals(clazz)) {
			try {
				return (T) new Integer(vs);
			} catch (Exception e) {
				return null;
			}
		} else if (Long.class.equals(clazz)) {
			try {
				return (T) new Long(vs);
			} catch (Exception e) {
				return null;
			}
		}

		return null;
	}

	/**
	 * 将字符串分隔，作为key和value放入map
	 */
	public static Map<String, String> splitStrForMap(String str, String splitor) {
		Map<String, String> map = new HashMap<String, String>();
		if (StringUtils.isNotBlank(str)) {
			String[] strs = str.split(splitor);
			for (String s : strs) {
				String x = s.trim();
				if (StringUtils.isNotBlank(x)) {
					map.put(x, x);
				}
			}
		}
		return map;
	}

	/**
	 * 取得Map的所有key，以指定的字符串连接起来
	 */
	public static String getKeysForString(Map<String, String> map, String joiner) {
		if (map != null) {
			StringBuffer strb = new StringBuffer();
			for (Object k : map.keySet()) {
				strb.append(k).append(joiner);
			}
			if (strb.length() >= joiner.length()) {
				return strb.substring(0, strb.length() - joiner.length());
			}
			return strb.toString();
		} else {
			return "null";
		}
	}
}
