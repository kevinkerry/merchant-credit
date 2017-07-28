package com.shengpay.service.message.http;

import java.io.IOException;
import java.io.InputStreamReader;

import org.apache.commons.httpclient.DefaultHttpMethodRetryHandler;
import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpException;
import org.apache.commons.httpclient.HttpMethod;
import org.apache.commons.httpclient.HttpStatus;
import org.apache.commons.httpclient.MultiThreadedHttpConnectionManager;
import org.apache.commons.httpclient.URIException;
import org.apache.commons.httpclient.methods.GetMethod;
import org.apache.commons.httpclient.methods.PostMethod;
import org.apache.commons.httpclient.params.HttpClientParams;
import org.apache.commons.httpclient.params.HttpMethodParams;
import org.slf4j.Logger;import org.slf4j.LoggerFactory;

public class HttpClientUtil {

	private static HttpClient httpClient;

	private static HttpClientParams clientParams;

	private static final Logger log = LoggerFactory.getLogger(HttpClientUtil.class);

	static {
		// 多线程模式模式下使用httpclient
		MultiThreadedHttpConnectionManager manager = new MultiThreadedHttpConnectionManager();
		httpClient = new HttpClient(manager);
		clientParams = new HttpClientParams();
		// 设置读取内容时间超时
		clientParams.setSoTimeout(100000);
		// 自定义的重发策略，不重发
		clientParams.setParameter(HttpMethodParams.RETRY_HANDLER,
				new DefaultHttpMethodRetryHandler(0, false));
		httpClient.setParams(clientParams);
		// 设置连接超时
		httpClient.getHttpConnectionManager().getParams()
				.setConnectionTimeout(2000);
		httpClient.getHttpConnectionManager().getParams()
				.setDefaultMaxConnectionsPerHost(10000);
		// 设置最大连接数
		httpClient.getHttpConnectionManager().getParams()
				.setMaxTotalConnections(100);
	}

	private static void addParameter(PostMethod httpPost, String data) {
		httpPost.setRequestHeader("contentType", "text/html; charset=UTF-8");
		httpPost.setRequestHeader("pageEncoding", "UTF-8");
		httpPost.setRequestHeader("Connection", "close");
		// 设置请求和返回charset
		httpPost.getParams().setContentCharset("UTF-8");
		httpPost.addParameter("json", data);
	}

	public static String getMethod(String url, String queryString) {
		HttpMethod method = new GetMethod(url);
		 method.setRequestHeader("contentType", "text/html; charset=UTF-8");
		 method.setRequestHeader("Connection", "close");
		try {
			httpClient.executeMethod(method);
			if (method.getStatusCode() == HttpStatus.SC_OK) {
				String aa = InputStreamToByte(new InputStreamReader(
						method.getResponseBodyAsStream(), "UTF-8"));
				return new String(aa.getBytes(), "UTF-8");
			}
		} catch (URIException e) {
			log.error("执行HTTP Get请求时，编码查询字符串“" + queryString + "”发生异常！", e);
			return null;
		} catch (IOException e) {
			log.error("执行HTTP Get请求" + url + "时，发生异常！", e);
			return null;
		} finally {
			method.releaseConnection();
		}
		return null;
	}

	private static String InputStreamToByte(InputStreamReader inputStreamReader)
			throws IOException {
		// ByteArrayOutputStream bytestream = new ByteArrayOutputStream();
		int ch;
		char[] cbuf = new char[900];
		StringBuffer sb = new StringBuffer();
		try {
			while ((ch = inputStreamReader.read(cbuf)) > 0) {
				for (int i = 0; i < ch; i++) {
					sb.append(cbuf[i]);
				}
				// bytestream.write(ch);
			}
		} catch (IOException e) {
			log.info("bank can not read eof");
		} finally {
			// bytestream.close();
		}
		log.info("chance try char Utf-8"
				+ new String(sb.toString().getBytes(), "UTF-8"));
		log.info("chance try char gbk"
				+ new String(sb.toString().getBytes(), "gbk"));
		log.info("chance try char gb2312"
				+ new String(sb.toString().getBytes(), "gb2312"));

		// byte imgdata[] = bytestream.toByteArray();
		return sb.toString();
	}

	/**
	 *
	 * @param url
	 * @param json
	 * @return
	 */
	public static String postMethod(String url, String json) {
		PostMethod method = new PostMethod(url);
		addParameter(method, json);
		try {
			httpClient.executeMethod(method);
			return method.getResponseBodyAsString();
		} catch (HttpException e) {
		} catch (IOException e) {
		}
		return null;
	}

}
