package com.sdp.mc.web.vo;

import java.io.Serializable;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

public class NFCOrder4AppQueryRequest implements Serializable {

	private static final long serialVersionUID = 1L;

	private String token;

	// /* sdp用户登录名 */
	// private String loginName;
	// /* sdp用户memberId */
	// private String memeberId;
	// /* sdp用户手机号 */
	// private String userMobile;
	// /* 付款用户ip */
	// private String buyerIp;
	/* 签名类型 */
	private String signType;
	/* 签名串 */
	private String signMsg;

	// public String getMemeberId() {
	// return memeberId;
	// }
	//
	// public void setMemeberId(String memeberId) {
	// this.memeberId = memeberId;
	// }
	//
	// public String getUserMobile() {
	// return userMobile;
	// }
	//
	// public void setUserMobile(String userMobile) {
	// this.userMobile = userMobile;
	// }
	//
	// public String getBuyerIp() {
	// return buyerIp;
	// }
	//
	// public void setBuyerIp(String buyerIp) {
	// this.buyerIp = buyerIp;
	// }

	public String getSignType() {
		return signType;
	}

	public void setSignType(String signType) {
		this.signType = signType;
	}

	public String getSignMsg() {
		return signMsg;
	}

	public void setSignMsg(String signMsg) {
		this.signMsg = signMsg;
	}

	// public String getLoginName() {
	// return loginName;
	// }
	//
	// public void setLoginName(String loginName) {
	// this.loginName = loginName;
	// }

	public String toString() {
		return ToStringBuilder.reflectionToString(this, ToStringStyle.DEFAULT_STYLE);
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}
}
