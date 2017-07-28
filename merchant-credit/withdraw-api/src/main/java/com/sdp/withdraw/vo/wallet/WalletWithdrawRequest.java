package com.sdp.withdraw.vo.wallet;

import java.io.Serializable;
import java.math.BigDecimal;

import com.sdp.withdraw.util.SignUtil;

public class WalletWithdrawRequest implements Serializable {
	/**
	 *
	 */
	private static final long serialVersionUID = 6235796954768530337L;
	/**
	 * 应用编码
	 */
	private String appId;
	/**
	 * 业务订单号
	 */
	private String orderNo;
	/**
	 * 商户号
	 */
	private String memberNo;
	/**
	 * 商户类型
	 */
	private String memberType;
	/**
	 * 发起出款金额
	 */
	private BigDecimal withdrawAmount;
	/**
	 * 原始额度
	 */
	private BigDecimal originalAmount;
	/**
	 * 支付结果回调地址
	 */
	private String callbackAddress;
	/**
	 * 签名
	 */
	private String signature;
	/**
	 * 扩展信息
	 * json  : key hasOATxn  1:包含扫码交易  非1 不包含扫码交易
	 */
	private String extention;

	public String getAppId() {
		return appId;
	}

	public void setAppId(String appId) {
		this.appId = appId;
	}

	public String getOrderNo() {
		return orderNo;
	}

	public void setOrderNo(String orderNo) {
		this.orderNo = orderNo;
	}

	public BigDecimal getWithdrawAmount() {
		return withdrawAmount;
	}

	public void setWithdrawAmount(BigDecimal withdrawAmount) {
		this.withdrawAmount = withdrawAmount;
	}

	public BigDecimal getOriginalAmount() {
		return originalAmount;
	}

	public void setOriginalAmount(BigDecimal originalAmount) {
		this.originalAmount = originalAmount;
	}

	public String getCallbackAddress() {
		return callbackAddress;
	}

	public void setCallbackAddress(String callbackAddress) {
		this.callbackAddress = callbackAddress;
	}

	public String getSignature() {
		return signature;
	}

	public void setSignature(String signature) {
		this.signature = signature;
	}

	public String getMemberNo() {
		return memberNo;
	}

	public void setMemberNo(String memberNo) {
		this.memberNo = memberNo;
	}

	public String getMemberType() {
		return memberType;
	}

	public void setMemberType(String memberType) {
		this.memberType = memberType;
	}

	public String getExtention() {
		return extention;
	}

	public void setExtention(String extention) {
		this.extention = extention;
	}

	public String getSignStr(String MD5Key) {
		StringBuffer sb = new StringBuffer("");
		sb.append(this.getAppId());
		sb.append("|");
		sb.append(this.getOrderNo());
		sb.append("|");
		sb.append(this.getMemberNo());
		sb.append("|");
		sb.append(this.getMemberType());
		sb.append("|");
		sb.append(this.getWithdrawAmount());
		sb.append("|");
		sb.append(this.getOriginalAmount());
		sb.append("|");
		sb.append(MD5Key);
		return SignUtil.signOrderQueryRequest(sb.toString().getBytes());
	}
}
