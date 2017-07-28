package com.sdp.withdraw.vo;

import java.io.Serializable;
import java.util.Date;

public class WithdrawT0ServiceResponse extends BaseResponse implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -695362533212736995L;
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
	 * 状态
	 */
	private String orderStatus;
	/**
	 * 跟踪单号
	 */
	private String traceNo;
	/**
	 * 跟踪单生成时间
	 */
	private Date traceDate;

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

	public String getOrderStatus() {
		return orderStatus;
	}

	public void setOrderStatus(String orderStatus) {
		this.orderStatus = orderStatus;
	}

	public String getTraceNo() {
		return traceNo;
	}

	public void setTraceNo(String traceNo) {
		this.traceNo = traceNo;
	}

	public Date getTraceDate() {
		return traceDate;
	}

	public void setTraceDate(Date traceDate) {
		this.traceDate = traceDate;
	}

}
