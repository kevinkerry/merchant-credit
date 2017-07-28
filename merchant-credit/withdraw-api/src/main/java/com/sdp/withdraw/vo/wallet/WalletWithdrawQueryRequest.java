package com.sdp.withdraw.vo.wallet;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.sdp.withdraw.util.SignUtil;

public class WalletWithdrawQueryRequest implements Serializable{
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
	 * 商户号
	 */
	private String memberNo;
	/**
	 * 开始时间
	 */
	private String startTime;
	/**
	 * 结束时间
	 */
	private String endTime;
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

	public String getStartTime() {
		return startTime;
	}

	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}

	public String getEndTime() {
		return endTime;
	}

	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}

	public String getMemberNo() {
		return memberNo;
	}

	public void setMemberNo(String memberNo) {
		this.memberNo = memberNo;
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


		if(null!=this.getMemberNo()){
			sb.append(this.getMemberNo());
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
