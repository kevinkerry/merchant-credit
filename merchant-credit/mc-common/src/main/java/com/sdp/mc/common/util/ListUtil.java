package com.sdp.mc.common.util;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang.StringUtils;

/**
 * ListUtil
 * 
 * @author liuxi.xiliu
 */
public class ListUtil {

	/**
	 * 组装成list
	 */
	public static List<Object> forList(Object... objs) {
		List<Object> list = new ArrayList<Object>();
		for (Object o : objs) {
			list.add(o);
		}
		return list;
	}

	/**
	 * 将字符串数组连接起来，组成字符串
	 * 
	 * @param array
	 *            原字符串数组
	 * @param leftStr
	 *            元素左边的字符
	 * @param rightStr
	 *            元素右边的字符
	 * @param joinStr
	 *            连接字符串 例如：join( [ "1", "2", "3" ], "a", "b", "," ) -->
	 *            "a1b,a2b,a3b"
	 */
	public static String join(String[] array, String leftStr, String rightStr, String joinStr) {
		if (array == null) {
			return "";
		}
		StringBuffer strb = new StringBuffer();
		int i = 1;
		for (String s : array) {
			String x = s.trim();
			if (StringUtils.isNotBlank(x)) {
				strb.append(leftStr).append(x).append(rightStr);
				if (i < array.length) {
					strb.append(joinStr);
				}
			}
			i += 1;
		}
		return strb.toString();
	}

	/**
	 * 将字符串分隔，每个前后加上字符，组成新字符串
	 */
	public static String reCompStr(String str, String splitor, String prefix, String suffix, String newSplitor) {
		if (StringUtils.isBlank(str)) {
			return null;
		}
		String[] ss = str.split(splitor);
		return join(ss, prefix, suffix, newSplitor);
	}

	/**
	 * 将字符串分隔，每个前后加上字符，组成新字符串，每个是Long类型
	 */
	public static String reCompLong(String str, String splitor, String prefix, String suffix, String newSplitor) {
		if (StringUtils.isBlank(str)) {
			return null;
		}
		String[] ss = str.split(splitor);

		StringBuffer strb = new StringBuffer();
		for (String s : ss) {
			String x = s.trim();
			if (StringUtils.isNotBlank(x)) {
				try {
					long l = Long.parseLong(x);
					if (strb.length() > 0) {
						strb.append(newSplitor);
					}
					strb.append(prefix).append(l).append(suffix);
				} catch (Exception e) {

				}
			}
		}
		return strb.toString();
	}

	/**
	 * 将字符串分隔，组成List
	 */
	public static List<String> forListString(String str, String splitor) {
		List<String> list = new ArrayList<String>();
		if (StringUtils.isNotBlank(str)) {
			String[] ss = str.split(splitor);
			for (String s : ss) {
				String x = s.trim();
				if (StringUtils.isNotBlank(x)) {
					list.add(x);
				}
			}
		}
		return list;
	}

	/**
	 * 将字符串分隔，组成List
	 */
	public static List<Long> forListLong(String str, String splitor) {
		List<Long> list = new ArrayList<Long>();
		if (StringUtils.isNotBlank(str)) {
			String[] ss = str.split(splitor);
			for (String s : ss) {
				String x = s.trim();
				if (StringUtils.isNotBlank(x)) {
					try {
						list.add(new Long(x));
					} catch (Exception e) {

					}
				}
			}
		}
		return list;
	}

	/**
	 * 将list转换成javascript的数组，仅支持StringS数组、int/float数组 如：List<String> ->
	 * ["1","2","3"]
	 * 
	 * @param list
	 * @param ps
	 *            : 加在每个元素前后的字符串。如果是String数组，ps就是"(双引号)
	 */
	public static String castListToJsArray(List<String> list, String ps) {
		if (list == null || list.size() == 0) {
			return "[]";
		}

		StringBuffer jsSb = new StringBuffer("[");
		for (int i = 0; i < list.size(); i++) {
			jsSb.append(ps).append(list.get(i)).append(ps);
			if (i != list.size() - 1) {
				jsSb.append(",");
			}
		}
		jsSb.append("]");
		return jsSb.toString();
	}

	/**
	 * 数组中是否包含这个元素
	 */
	public static boolean contains(String[] ss, String s) {
		for (String x : ss) {
			if (x.equals(s)) {
				return true;
			}
		}
		return false;
	}

}
