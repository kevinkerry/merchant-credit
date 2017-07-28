package com.sdp.withdraw.vo;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.sdp.withdraw.util.SignUtil;

public class WithdrawQueryRequest implements Serializable{
	/**
	 *
	 */
	private static final long serialVersionUID = 9192248145130478867L;
	/**
	 * 业务编码
	 */
	private String appId;
	/**
	 * 业务订单号
	 */
	private String orderNo;
	/**
	 * 追踪单号
	 */
	private String traceNo;
	/**
	 * 会员ID
	 */
	private String memberId;
	/**
	 * 商户号
	 */
	private String merchantNo;
	/**
	 * 开始时间
	 */
	private Date startTime;
	/**
	 * 结束时间
	 */
	private Date endTime;
	/**
	 * 出款类型 1：实时出款 2：普通出款
	 */
	private String withdrawType;
	/**
	 * 每頁默認10條
	 */
	private Integer pageSize;
	/**
	 * 当前页
	 */
	private Integer pageNo;
	/**
	 * 验签
	 */
	private String signature;

	public Integer getPageSize() {
		return pageSize;
	}

	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}

	public Integer getPageNo() {
		return pageNo;
	}

	public void setPageNo(Integer pageNo) {
		this.pageNo = pageNo;
	}

	public String getSignature() {
		return signature;
	}

	public void setSignature(String signature) {
		this.signature = signature;
	}

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

	public String getTraceNo() {
		return traceNo;
	}

	public void setTraceNo(String traceNo) {
		this.traceNo = traceNo;
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

	public Date getStartTime() {
		return startTime;
	}

	public void setStartTime(Date startTime) {
		this.startTime = startTime;
	}

	public Date getEndTime() {
		return endTime;
	}

	public void setEndTime(Date endTime) {
		this.endTime = endTime;
	}

	public String getWithdrawType() {
		return withdrawType;
	}

	public void setWithdrawType(String withdrawType) {
		this.withdrawType = withdrawType;
	}


	public String getSignStr(String MD5Key) {
		SimpleDateFormat dateFormat2 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
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

		if(null!=this.getTraceNo()){
			sb.append(this.getTraceNo());
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

		if(null!=this.getStartTime()){
			sb.append(dateFormat2.format(this.getStartTime()));
			sb.append("|");
		}else{
			sb.append("|");
		}

		if(null!=this.getEndTime()){
			sb.append(dateFormat2.format(this.getEndTime()));
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
		if(null!=this.getPageSize()){
			sb.append(this.getPageSize());
			sb.append("|");
		}else{
			sb.append("|");
		}
		if(null!=this.getPageNo()){
			sb.append(this.getPageNo());
			sb.append("|");
		}else{
			sb.append("|");
		}
		sb.append(MD5Key);
		return SignUtil.signOrderQueryRequest(sb.toString().getBytes());
	}


}
