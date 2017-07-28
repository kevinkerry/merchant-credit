package com.sdp.withdraw.vo;

import java.io.Serializable;
import java.math.BigDecimal;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

import com.sdp.withdraw.util.SignUtil;

public class WithdrawT0ServiceRequest implements Serializable{
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
	 * 会员ID
	 */
	private String memberId;
	/**
	 * 商户号
	 */
	private String merchantNo;
	/**
	 * 商户类型
	 */
	private String mcType;
	/**
	 * 出款类型
	 */
	private String withdrawType;
	/**
	 * 发起出款金额
	 */
	private BigDecimal withdrawAmount;
	/**
	 * 原始额度
	 */
	private BigDecimal originalAmount;
	/**
	 * 申请时间
	 */
	private Date applyTime;
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
	 */
	private Map<String, Object> extention;

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

	public String getMemberId() {
		return memberId;
	}

	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}

	public String getMerchantNo() {
		return merchantNo;
	}

	public void setMerchantNo(String merchantNo) {
		this.merchantNo = merchantNo;
	}

	public String getMcType() {
		return mcType;
	}

	public void setMcType(String mcType) {
		this.mcType = mcType;
	}

	public String getWithdrawType() {
		return withdrawType;
	}

	public void setWithdrawType(String withdrawType) {
		this.withdrawType = withdrawType;
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

	public Date getApplyTime() {
		return applyTime;
	}

	public void setApplyTime(Date applyTime) {
		this.applyTime = applyTime;
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

	public Map<String, Object> getExtention() {
		return extention;
	}

	public void setExtention(Map<String, Object> extention) {
		this.extention = extention;
	}

	public String getSignStr(String MD5Key) {
		StringBuffer sb = new StringBuffer("");
		if(null!=this.getAppId()){
			sb.append(this.getAppId());
			sb.append("|");
		}else{
			sb.append("|");
		}
		if(null!=this.getOrderNo()){
			sb.append(this.getOrderNo());
			sb.append("|");
		}else{
			sb.append("|");
		}
		if(null!=this.getMemberId()){
			sb.append(this.getMemberId());
			sb.append("|");
		}else{
			sb.append("|");
		}
		if(null!=this.getMerchantNo()){
			sb.append(this.getMerchantNo());
			sb.append("|");
		}else{
			sb.append("|");
		}
		if(null!=this.getMcType()){
			sb.append(this.getMcType());
			sb.append("|");
		}else{
			sb.append("|");
		}
		if(null!=this.getWithdrawType()){
			sb.append(this.getWithdrawType());
			sb.append("|");
		}else{
			sb.append("|");
		}

		if(null!=this.getWithdrawAmount()){
			sb.append(this.getWithdrawAmount());
			sb.append("|");
		}else{
			sb.append("|");
		}

		if(null!=this.getOriginalAmount()){
			sb.append(this.getOriginalAmount());
			sb.append("|");
		}else{
			sb.append("|");
		}
		SimpleDateFormat dateFormat2 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		if(null!=this.getApplyTime()){
			sb.append(dateFormat2.format(this.getApplyTime()));
			sb.append("|");
		}else{
			sb.append("|");
		}
		if(null!=this.getCallbackAddress()){
			sb.append(this.getCallbackAddress());
			sb.append("|");
		}else{
			sb.append("|");
		}
		sb.append(MD5Key);
		return SignUtil.signOrderQueryRequest(sb.toString().getBytes());
	}
}
