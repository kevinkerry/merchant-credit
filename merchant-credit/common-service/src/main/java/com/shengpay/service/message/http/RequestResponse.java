package com.shengpay.service.message.http;

import org.apache.commons.httpclient.Header;

public interface RequestResponse {

	public Header getResponseHeader(String name);

	public String getContent();

	public Object getParameter(String param);

	public int getResponseCode();
}
