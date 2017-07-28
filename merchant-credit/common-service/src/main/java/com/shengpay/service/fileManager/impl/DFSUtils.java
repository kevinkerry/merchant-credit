package com.shengpay.service.fileManager.impl;

import java.net.URI;

import org.apache.commons.lang.ArrayUtils;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;import org.slf4j.LoggerFactory;
import org.springframework.web.client.RestTemplate;

public class DFSUtils {

	private static final Logger logger = LoggerFactory.getLogger(DFSUtils.class);

	private static RestTemplate restTemplate = new RestTemplate();

	public static String postForLocation(String storeUrl, byte[] bytes) {
		if (ArrayUtils.isEmpty(bytes)) {
			throw new IllegalArgumentException("Never post empty bytes!!!");
		}
		long start = System.currentTimeMillis();
		URI uri;
		try {
			uri = restTemplate.postForLocation(storeUrl, bytes);
		} catch (Exception e) {
			logger.error("调用小文件存储异常[storeUrl=" + storeUrl + ",length=" + bytes.length + "]", e);
			throw new RuntimeException("调用小文件存储异常文件[storeUrl=" + storeUrl + ",length=" + bytes.length + "],异常:" + e.getMessage());
		}
//		String furl = storeUrl + "/key/" + uri;
		String furl =  "" + uri;
		long end = System.currentTimeMillis();
		logger.info("上传小文件存储成功[furl=" + furl + ",length=" + bytes.length + "],耗时：" + (end - start) + "毫秒");
		return furl;
	}

	public static byte[] getForObject(String fileUrl, String key) {
		if (StringUtils.isEmpty(fileUrl)) {
			return null;
		}
		if (StringUtils.isEmpty(key)) {
			return null;
		}
		long start = System.currentTimeMillis();
		byte[] fileBytes = restTemplate.getForObject(fileUrl +"/key/"+ key, byte[].class);
		long end = System.currentTimeMillis();
		logger.info("下载小文件成功[furl=" + fileUrl + ",length=" + fileBytes.length + "],耗时：" + (end - start) + "毫秒");
		return fileBytes;
	}

	public static void delete(String fileUrl, String key) {
		if (StringUtils.isEmpty(key)) {
			return;
		}
		long start = System.currentTimeMillis();
		restTemplate.delete(fileUrl + "/key/" + key);
		long end = System.currentTimeMillis();
		logger.info("删除小文件成功[key=" + key + "],耗时：" + (end - start) + "毫秒");
	}

}
