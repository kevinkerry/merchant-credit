package com.sdp.mc.common.util;

/**
 * ArrayUtil
 * 
 * @author liuxi.xiliu
 */
public class ArrayUtil {

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
		StringBuffer strb = new StringBuffer();
		int i = 1;
		for (String s : array) {
			strb.append(leftStr).append(s).append(rightStr);
			if (i < array.length) {
				strb.append(joinStr);
			}
			i += 1;
		}
		return strb.toString();
	}

}
