package com.shengpay.service.message.http;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import org.apache.commons.httpclient.Header;
import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpConnectionManager;
import org.apache.commons.httpclient.HttpMethod;
import org.apache.commons.httpclient.MultiThreadedHttpConnectionManager;
import org.apache.commons.httpclient.methods.GetMethod;
import org.apache.commons.httpclient.methods.PostMethod;
import org.apache.commons.httpclient.util.IdleConnectionTimeoutThread;
import org.slf4j.Logger;import org.slf4j.LoggerFactory;

/**
 * 功能：HttpClient方式访问 详细：获取远程HTTP数据 说明：
 * 
 * @author jiang.wei
 */

public class HttpHelper {
	private static final Logger logger = LoggerFactory.getLogger(HttpHelper.class);
	private static String DEFAULT_CHARSET = "UTF-8";

	/** 连接超时时间，由bean factory设置，缺省为15秒钟 */
	private final int defaultConnectionTimeout = 15000;

	/** 回应超时时间, 由bean factory设置，缺省为90秒钟 */
	private final int defaultSoTimeout = 90000;

	/** 闲置连接超时时间, 由bean factory设置，缺省为90秒钟 */
	private final int defaultIdleConnTimeout = 90000;

	private final int defaultMaxConnPerHost = 30;

	private final int defaultMaxTotalConn = 80;

	/** 默认等待HttpConnectionManager返回连接超时（只有在达到最大连接数时起作用）：1秒 */
	private static final long defaultHttpConnectionManagerTimeout = 3000;

	/**
	 * HTTP连接管理器，该连接管理器必须是线程安全的.
	 */
	private final HttpConnectionManager connectionManager;

	private static HttpHelper httpHelper = new HttpHelper();

	public static enum RequestType {
		POST, GET
	}

	public static class RequestParam {
		private String name;
		private String value;

		public RequestParam(String name, Object value) {
			this.name = name;
			this.value = String.valueOf(value);
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public String getValue() {
			return value;
		}

		public void setValue(String value) {
			this.value = value;
		}
	}

	/*
	 * @return
	 */
	public static HttpHelper getInstance() {
		return httpHelper;
	}

	/**
	 * 私有的构造方法
	 */
	private HttpHelper() {
		// 创建一个线程安全的HTTP连接池
		connectionManager = new MultiThreadedHttpConnectionManager();
		connectionManager.getParams().setDefaultMaxConnectionsPerHost(
				defaultMaxConnPerHost);
		connectionManager.getParams().setMaxTotalConnections(
				defaultMaxTotalConn);

		IdleConnectionTimeoutThread ict = new IdleConnectionTimeoutThread();
		ict.addConnectionManager(connectionManager);
		ict.setConnectionTimeout(defaultIdleConnTimeout);

		ict.start();
	}

	public RequestResponse execute(String url, RequestType type,
			RequestParam... params) {
		return execute(url, type, DEFAULT_CHARSET, params);
	}

	/**
	 * 执行Http请求
	 * 
	 * @param request
	 * @return
	 */
	public RequestResponse execute(String url, RequestType type,
			String encoding, RequestParam... params) {

		if (params != null) {
			for (RequestParam param : params) {
				if (param == null)
					continue;
				if (url.indexOf('?') != -1) {
					url += "&" + param.getName() + "=" + param.getValue();
				} else {
					url += "?" + param.getName() + "=" + param.getValue();
				}
			}
		}
		logger.info("HttpHelper >> access - " + url);
		

		HttpClient httpclient = new HttpClient(connectionManager);

		// 设置连接超时
		httpclient.getHttpConnectionManager().getParams()
				.setConnectionTimeout(defaultConnectionTimeout);
		// 回应超时时间
		httpclient.getHttpConnectionManager().getParams()
				.setSoTimeout(defaultSoTimeout);

		// 设置等待ConnectionManager释放connection的时间
		httpclient.getParams().setConnectionManagerTimeout(
				defaultHttpConnectionManagerTimeout);
		HttpMethod method = null;

		if (type == RequestType.POST) {
			method = new PostMethod(url);
		} else {
			method = new GetMethod(url);
		}

		try {
			method.getParams().setCredentialCharset(encoding);
			method.addRequestHeader("User-Agent", "Mozilla/4.0");
			httpclient.executeMethod(method);
			return new DefaultRequestResponse(method);
		} catch (Exception error) {
			logger.error("HttpHelper >> access - " + url, error);
		} finally {
			method.releaseConnection();
		}
		return null;
	}
}

class DefaultRequestResponse implements RequestResponse {
	private HttpMethod method;
	private String content;
	private int responseCode;

	public DefaultRequestResponse(HttpMethod method) throws IOException {
		InputStream inputStream = null;
		try {
			inputStream = method.getResponseBodyAsStream();
			BufferedReader br = new BufferedReader(new InputStreamReader(
					inputStream));
			StringBuffer stringBuffer = new StringBuffer();
			String str = "";
			while ((str = br.readLine()) != null) {
				stringBuffer.append(str);
			}
			content = stringBuffer.toString();
			responseCode = method.getStatusCode();
		} finally {
			if (inputStream != null) {
				inputStream.close();
			}
		}
	}

	public int getResponseCode() {
		return responseCode;
	}

	@Override
	public Header getResponseHeader(String name) {
		return method.getResponseHeader(name);
	}

	@Override
	public String getContent() {
		return content;
	}

	public Object getParameter(String param) {
		try {
			return method.getParams().getParameter(param);
		} catch (Exception e) {
			return null;
		}
	}

	public HttpMethod getHttpMethod() {
		return this.method;
	}
}
