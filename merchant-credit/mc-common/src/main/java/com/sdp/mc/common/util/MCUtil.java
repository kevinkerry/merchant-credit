package com.sdp.mc.common.util;

import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import com.sdp.mc.common.web.MCMerchantUser;

/**
 * 本项目的专用util
 * 
 * @author liuxi.xiliu
 */
public class MCUtil {

	/**
	 * 取得functionName
	 */
	public static String getFunctionName(HttpServletRequest request) {
		String contextPath = request.getContextPath();
		contextPath = contextPath.replaceAll("/+", "/");
		String requestURI = request.getRequestURI();
		requestURI = requestURI.replaceAll("/+", "/");

		String functionName = requestURI.substring(contextPath.length(), requestURI.indexOf("."));
		if (functionName.startsWith("/")) {
			functionName = functionName.substring(1);
		}

		return functionName;
	}

	/**
	 * 取得商户的userPtId
	 */
	public static String getUserPtId(String merchantNo) {
		return merchantNo + "@sfb.mer";
	}

	// -------------------------------------------------------------------------------
	/**
	 * 格式化mcc
	 */
	public static String fmtMcc(Object mcc) {
		if (mcc == null) {
			return null;
		}

		String m = String.valueOf(mcc);
		if (m.length() == 3) {
			return "0" + m;
		} else {
			return m;
		}
	}

	/**
	 * 取得class所在的目录
	 */
	public static String getClassPath() {
		URL url = MCUtil.class.getResource("/");
		String p = String.valueOf(url);
		if (p.startsWith("file:/")) {
			p = p.substring(6);
		}
		p = p.replaceAll("//+", "/");
		return p;
	}

	public static boolean canAccessMenu(String code, HttpServletRequest request) {
		// ----session中没有权限信息，即开发模式下，允许-----------
		MCMerchantUser u = MCMerchantUser.getMCMerchantUser(request.getSession());
		if (u == null) {
			return false;
		}

		// ----如果是管理员，允许-----------
		if (u.getAdminFlag()) {
			return true;
		}

		// ----如果有权限，允许-----------
		if (u.getRules().containsKey(code)) {
			return true;
		}
		return false;
	}

	/**
	 * 计算目标日期与当前时间之间的天数
	 * @param endDate 还款日
	 * @param dueRepaymentTime 逾期还款日
	 * **/
	public static int daysBetween(Date endDate,Date dueRepaymentTime) {
		try {
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			endDate = sdf.parse(sdf.format(endDate));
			long time1 = endDate.getTime();
			Date date2 = dueRepaymentTime == null ? new Date() : dueRepaymentTime;
			Date currentDate = sdf.parse(sdf.format(date2));
			long time2 = currentDate.getTime();
			long between_days = (time2 - time1) / 1000 / 60 / 60 / 24;
			return (int) between_days;
		} catch (Exception e) {
			return 0;
		}
	}
}
