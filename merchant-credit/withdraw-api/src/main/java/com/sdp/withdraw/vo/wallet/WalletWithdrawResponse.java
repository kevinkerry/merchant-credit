package com.sdp.withdraw.vo.wallet;

import java.io.Serializable;
import java.util.Date;

import com.sdp.withdraw.vo.BaseResponse;

public class WalletWithdrawResponse extends BaseResponse implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -695362533212736995L;
	/**
	 * 业务订单号
	 */
	private String orderNo;
	/**
	 * 状态
	 */
	private String status;

	
	public WalletWithdrawResponse(String errorCode, String errorMsg, String orderNo, String status) {
		super(errorCode, errorMsg);
		this.orderNo = orderNo;
		this.status = status;
	}

	public WalletWithdrawResponse(String orderNo, String status) {
		super();
		this.orderNo = orderNo;
		this.status = status;
	}
	

	public WalletWithdrawResponse(String status) {
		super();
		this.status = status;
	}

	public WalletWithdrawResponse() {
		super();
	}

	public String getOrderNo() {
		return orderNo;
	}

	public void setOrderNo(String orderNo) {
		this.orderNo = orderNo;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
	
	



}
