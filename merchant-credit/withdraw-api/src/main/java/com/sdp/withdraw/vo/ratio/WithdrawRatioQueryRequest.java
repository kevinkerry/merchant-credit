package com.sdp.withdraw.vo.ratio;

import java.io.Serializable;
import java.util.Date;

public class WithdrawRatioQueryRequest implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 5810837931237234357L;
	/**
	 * 商户号
	 */
	private String merchantNo;
	// /**
	// * 查询时间
	// */
	// private Date queryTime;
	/**
	 * 商户类型
	 */
	private String merchantType;

	private Integer withdrawRatioType;
	
	/**
	 * 生效时间
	 */
	private Date effectiveTime;

	public WithdrawRatioQueryRequest() {
	}

	public WithdrawRatioQueryRequest(String merchantNo) {
		super();
		this.merchantNo = merchantNo;
	}

	// public WithdrawRatioQueryRequest(String merchantNo, Date queryTime) {
	// super();
	// this.merchantNo = merchantNo;
	// this.queryTime = queryTime;
	// }

	public WithdrawRatioQueryRequest(String merchantNo, String merchantType) {
		super();
		this.merchantNo = merchantNo;
		this.merchantType = merchantType;
	}

	// public WithdrawRatioQueryRequest(String merchantNo, String merchantType,
	// Date queryTime) {
	// super();
	// this.merchantNo = merchantNo;
	// this.queryTime = queryTime;
	// this.merchantType = merchantType;
	// }

	public WithdrawRatioQueryRequest(String merchantNo, String merchantType, Integer withdrawRatioType) {
		super();
		this.merchantNo = merchantNo;
		this.merchantType = merchantType;
		this.withdrawRatioType = withdrawRatioType;
	}

	// public WithdrawRatioQueryRequest(String merchantNo, Date queryTime,
	// String merchantType, Integer withdrawRatioType) {
	// super();
	// this.merchantNo = merchantNo;
	// this.queryTime = queryTime;
	// this.merchantType = merchantType;
	// this.withdrawRatioType = withdrawRatioType;
	// }

	public Integer getWithdrawRatioType() {
		return withdrawRatioType;
	}

	public void setWithdrawRatioType(Integer withdrawRatioType) {
		this.withdrawRatioType = withdrawRatioType;
	}

	public String getMerchantType() {
		return merchantType;
	}

	public void setMerchantType(String merchantType) {
		this.merchantType = merchantType;
	}

	// public Date getQueryTime() {
	// return queryTime;
	// }
	//
	// public void setQueryTime(Date queryTime) {
	// this.queryTime = queryTime;
	// }
	
	

	public String getMerchantNo() {
		return merchantNo;
	}

	public WithdrawRatioQueryRequest(String merchantNo, String merchantType, Integer withdrawRatioType, Date effectiveTime) {
		super();
		this.merchantNo = merchantNo;
		this.merchantType = merchantType;
		this.withdrawRatioType = withdrawRatioType;
		this.effectiveTime = effectiveTime;
	}

	public void setMerchantNo(String merchantNo) {
		this.merchantNo = merchantNo;
	}

	public Date getEffectiveTime() {
		return effectiveTime;
	}

	public void setEffectiveTime(Date effectiveTime) {
		this.effectiveTime = effectiveTime;
	}
	
	

}
