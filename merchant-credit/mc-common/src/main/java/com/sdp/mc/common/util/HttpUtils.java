package com.sdp.mc.common.util;

import java.beans.PropertyDescriptor;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import net.sf.json.JSONObject;

import org.apache.commons.beanutils.PropertyUtilsBean;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.ParseException;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.params.HttpParams;
import org.apache.http.protocol.HTTP;
import org.apache.http.util.EntityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class HttpUtils {
	
	private static final Logger logger = LoggerFactory.getLogger(HttpUtils.class);
	public static Map<String, String> beanToMap(Object obj) {
		Map<String, String> params = new HashMap<String, String>();
		try {
			PropertyUtilsBean propertyUtilsBean = new PropertyUtilsBean();
			PropertyDescriptor[] descriptors = propertyUtilsBean.getPropertyDescriptors(obj);
			for (int i = 0; i < descriptors.length; i++) {
				String name = descriptors[i].getName();
				if (!"class".equals(name)) {
					Object objAttrValue=propertyUtilsBean.getNestedProperty(obj, name);
					params.put(name, objAttrValue!=null?objAttrValue.toString():"");
				}
			}
		} catch (Exception e) {
			logger.error("beanToMap  error",e);
		}
		return params;
	}

	public static String post(String url, Map<String, String> params) {
		HttpClient httpclient = new DefaultHttpClient();
		String body = null;
		logger.info("WithdrawServiceCallbackTask #post create httppost url:"+url+",params:"+params);
		HttpPost post = postForm(url, params);

		body = invoke(httpclient, post);

		httpclient.getConnectionManager().shutdown();

		return body;
	}
	public static String get(String url) {
		HttpClient httpclient = new DefaultHttpClient();
		String body = null;
		logger.info("#get create httpget url:"+url);
		HttpGet get = new HttpGet(url);
		
		body = invoke(httpclient, get);
		
		httpclient.getConnectionManager().shutdown();
		
		return body;
	}
	
	public static Map<String,Object> get2Map(String url) {
		return parserToMap(get(url));
	}



	private static String invoke(HttpClient httpclient, HttpUriRequest httpost) {

		HttpResponse response = sendRequest(httpclient, httpost);
		String body = paseResponse(response);

		return body;
	}

	private static String paseResponse(HttpResponse response) {
		logger.info("get response from http server..");
		HttpEntity entity = response.getEntity();

		logger.info("response status: " + response.getStatusLine());
		if(response.getStatusLine().getStatusCode()!=200){
			return null;
		}
		String charset = EntityUtils.getContentCharSet(entity);
		logger.info(charset);

		String body = null;
		try {
			body = EntityUtils.toString(entity);
			logger.info(body);
		} catch (ParseException e) {
			logger.error(e.getMessage(), e);
		} catch (IOException e) {
			logger.error(e.getMessage(), e);
		}

		return body;
	}

	private static HttpResponse sendRequest(HttpClient httpclient, HttpUriRequest httpost) {
		logger.info("execute post...");
		HttpResponse response = null;

		try {
			response = httpclient.execute(httpost);
		} catch (ClientProtocolException e) {
			logger.error(e.getMessage(), e);
		} catch (IOException e) {
			logger.error(e.getMessage(), e);
		}
		return response;
	}
	

	private static HttpPost postForm(String url, Map<String, String> params) {
		HttpPost httpost = new HttpPost(url);
		List<NameValuePair> nvps = new ArrayList<NameValuePair>();
		
		Set<String> keySet = params.keySet();
		for (String key : keySet) {
			nvps.add(new BasicNameValuePair(key, params.get(key)));
		}
		try {
			logger.info("set utf-8 form entity to httppost");
			httpost.setEntity(new UrlEncodedFormEntity(nvps, HTTP.UTF_8));
		} catch (UnsupportedEncodingException e) {
			logger.error(e.getMessage(), e);
		}

		return httpost;
	}
	
	public static Map<String,Object> parserToMap(String s){  
		if(s==null){
			return null;
		}
	    Map<String,Object> map=new HashMap<String,Object>();  
	    JSONObject json=JSONObject.fromObject(s);  
	    Iterator<String> keys=json.keys();  
	    while(keys.hasNext()){  
	        String key=(String) keys.next();  
	        String value=json.get(key).toString();  
	        if(value.startsWith("{")&&value.endsWith("}")){  
	            map.put(key, parserToMap(value));  
	        }else{  
	            map.put(key, value);  
	        }  
	  
	    }  
	    return map;  
	} 
	
	public static void main(String[] args) {
		Map<String,Object> res=get2Map("http://10.132.97.151:8087/easypay-services/rest/v1/merchant/credit/auth/93618348");
		System.out.println(res);
		System.out.println(res.get("success"));
		System.out.println(new Boolean(res.get("success").toString())==false);
		System.out.println(new Boolean(null));
	}
}
