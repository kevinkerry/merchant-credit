package com.sdp.mc.common.util;

import java.io.Writer;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;import org.slf4j.LoggerFactory;

import com.alibaba.fastjson.JSON;

/**
 * Request工具类
 *
 * @author xuhongbiao.darren
 * @date 2013-7-29 下午06:47:25
 *
 */
public class RequestUtils {

	private static final Logger log = LoggerFactory.getLogger(RequestUtils.class);

	/**
	 * 获取Request参数到Map对象，多个值以','分割
	 *
	 * @param request
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public static Map<String, String> getRequestParamMap(HttpServletRequest request) {

		Map<String, String> paramMap = new HashMap<String, String>();

		Set<Map.Entry<String, Object>> entrySet = request.getParameterMap().entrySet();

		for (Map.Entry<String, Object> entry : entrySet) {
			Object value = entry.getValue();
			String paramValue = null;
			if (value != null) {
				if (value instanceof String) {
					paramValue = value.toString();
				} else if (value instanceof String[]) {
					paramValue = StringUtils.join((String[]) value, ',');
				}
			}

			paramMap.put(entry.getKey(), paramValue);
		}
		return paramMap;
	}

	/**
	 * 获取Request参数转为Long类型
	 *
	 * @param request
	 * @param name
	 * @return
	 */
	public static Long getLongParameter(HttpServletRequest request, String name) {
		Long result = null;
		try {
			String value = request.getParameter(name);
			if (StringUtils.isNotEmpty(value)) {
				result = Long.parseLong(value);
			}
		} catch (NumberFormatException e) {
			log.error(e.getMessage(), e);
		}
		return result;
	}

	/**
	 * 获取Request参数转为Integer类型
	 *
	 * @param request
	 * @param name
	 * @return
	 */
	public static Integer getIntegerParameter(HttpServletRequest request, String name) {
		Integer result = null;
		try {
			String value = request.getParameter(name);
			if (StringUtils.isNotEmpty(value)) {
				result = Integer.parseInt(value);
			}
		} catch (NumberFormatException e) {
			log.error(e.getMessage(), e);
		}
		return result;
	}

	/**
	 * 向response里面写入返回的json
	 *
	 * @param response
	 * @param obj
	 */
	public static void writeJson(final HttpServletResponse response, final Object obj) {
		try {
			response.setCharacterEncoding("UTF-8");
			response.setContentType("application/json");
			Writer writer = response.getWriter();
			String json = JSON.toJSONString(obj);
			log.info("writer response json:" + json);
			writer.write(json);
			writer.flush();
			writer.close();
		} catch (Exception e) {
			log.error("RequestUtils.writeJson.error" + e.getMessage(), e);
		}
	}

}
