package com.sdp.mc.sars.bean;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.alibaba.fastjson.JSON;


public class SarsParentBean {

	private String checkPoint;
	private final String version = "1.0";

	private final static DateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

	public SarsParentBean(String checkPoint) {
		this.checkPoint = checkPoint;
	}

	public String getCheckPoint() {
		return checkPoint;
	}

	// public void setCheckPoint(String checkPoint) {
	// this.checkPoint = checkPoint;
	// }

	public String getVersion() {
		return version;
	}

	// public void setVersion(String version) {
	// this.version = version;
	// }

	public static String SarsBean2Json(SarsParentBean bean) {
		String data = JSON.toJSONString(bean);
		return data;
	}

	public static String date2Str(Date date) {
		return format.format(date);
	}
}
