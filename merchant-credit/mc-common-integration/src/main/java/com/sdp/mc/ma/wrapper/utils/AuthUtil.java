package com.sdp.mc.ma.wrapper.utils;

import java.util.Date;
import java.util.UUID;

import com.sdp.mc.ma.request.impl.QueryOperatorMemberScopeRequest;
import com.sdp.mc.ma.request.impl.RequestHeader;

public class AuthUtil {
	public static QueryOperatorMemberScopeRequest buildQueryOperatorMemberScopeRequest(final String operatorId) {
		RequestHeader header = new RequestHeader();
		header.setVersion("10");
		header.setSourceId("123456");
		header.setRequestTime(new Date());
		header.setRequestNo(UUID.randomUUID().toString());
		header.setIp("127.0.0.1");
		QueryOperatorMemberScopeRequest request = new QueryOperatorMemberScopeRequest();
		request.setHeader(header);
		request.setOperatorId(operatorId);
		return request;
	}
}
