package com.sdp.mc.web.vo;

import java.io.Serializable;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

public class NFCOrder4AppResponse extends BaseResponse implements Serializable {

	private static final long serialVersionUID = 1L;

	private String token;
	// 完整token:SD01（固定头）+"|"+TOKEN+"|"+缩略登录名
	private String fullToken;

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public String getFullToken() {
		return fullToken;
	}

	public void setFullToken(String fullToken) {
		this.fullToken = fullToken;
	}

	public static NFCOrder4AppResponse buildFail(String msg) {
		NFCOrder4AppResponse response = new NFCOrder4AppResponse();
		response.setSuccess(false);
		response.setErrorCode("-1");
		response.setErrorMsg(msg);
		return response;
	}

	public static NFCOrder4AppResponse buildSuccess() {
		NFCOrder4AppResponse response = new NFCOrder4AppResponse();
		response.setSuccess(true);
		response.setErrorCode("0");
		response.setErrorMsg("下单成功");
		return response;
	}

	public String toString() {
		return ToStringBuilder.reflectionToString(this, ToStringStyle.DEFAULT_STYLE);
	}
}
