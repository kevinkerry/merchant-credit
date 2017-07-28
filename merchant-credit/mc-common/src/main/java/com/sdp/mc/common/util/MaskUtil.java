package com.sdp.mc.common.util;

import java.security.SecureRandom;
import java.util.Date;

import org.apache.commons.lang.StringUtils;

import com.sdo.common.util.DateUtil;

public class MaskUtil {
	public static final String MASK_STRING = "****";

	/**
	 * 屏蔽登录名
	 * **/
	public static String getLoginName(String str) {
		if (StringUtils.isNotBlank(str)) {
			// 账号不足3位，全部显示
			if (str.length() <= 3) {
				// return str.charAt(0) + "**";
				return str;
			}
			int pos = str.indexOf("@");
			// 邮箱账号
			if (pos >= 0) {
				return str.charAt(0) + MASK_STRING + str.substring(pos);
			}
			// 账号含有有后缀，则显示完整的后缀（包括点）
			pos = str.indexOf('.');
			if (pos >= 0) {
				return str.substring(0, 3) + MASK_STRING + str.substring(pos);
			}
			// 如果是手机号则显示前三后四
			if (str.length() == 11) {
				return str.substring(0, 3) + MASK_STRING + str.substring(str.length() - 4);
			}
			// 显示前3位和最后一位字符
			return str.substring(0, 3) + MASK_STRING + str.substring(str.length() - 1);
		}
		return null;
	}
	
	public static void main(String[] args) {
		String mail = "v.wangjingao.william@google.com";
		System.out.println(getLoginName(mail));
		System.out.println(getLoginName("15921433900"));
		System.out.println(DateUtil.format(new Date(), "ddhhyyssMMmm"));
		SecureRandom sr = new SecureRandom();
		System.out.println(sr.nextInt(1000000));
	}
}
