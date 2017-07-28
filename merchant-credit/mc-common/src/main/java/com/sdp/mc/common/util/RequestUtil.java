package com.sdp.mc.common.util;

import java.util.Enumeration;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.StringUtils;

public class RequestUtil {

	/**
	 * 打印请求信息
	 *
	 * @param req
	 * @return
	 */
	@SuppressWarnings("rawtypes")
	public static String getRequestInfo(HttpServletRequest req) {
		StringBuilder sb = new StringBuilder();
		sb.append("RequestURL:");
		sb.append(req.getRequestURL());
		String queryString = req.getQueryString();
		if (!StringUtils.isEmpty(queryString)) {
			sb.append("?");
			sb.append(queryString);
		}
		sb.append("\t");
		sb.append("Method:");
		sb.append(req.getMethod());
		sb.append("\n");
		sb.append("Parameters[");
		Enumeration params = req.getParameterNames();
		for (; params.hasMoreElements();) {
			sb.append("[");
			String param = (String) params.nextElement();
			sb.append(param);
			sb.append(":");
			sb.append(req.getParameter(param));
			sb.append("]");
		}
		return sb.toString();
	}

	/**
	 * 打印详细请求信息
	 *
	 * @param req
	 * @return
	 */
	@SuppressWarnings("rawtypes")
	public static String getFullRequestInfo(HttpServletRequest req) {
		StringBuilder sb = new StringBuilder();
		sb.append("HttpHeaders:\n");
		Enumeration headerNames = req.getHeaderNames();
		for (; headerNames.hasMoreElements();) {
			String headerName = (String) headerNames.nextElement();
			sb.append("\t");
			sb.append(headerName);
			sb.append(":");
			sb.append(req.getHeader(headerName));
			sb.append("\n");
		}
		sb.append(getRequestInfo(req));
		return sb.toString();
	}

}
