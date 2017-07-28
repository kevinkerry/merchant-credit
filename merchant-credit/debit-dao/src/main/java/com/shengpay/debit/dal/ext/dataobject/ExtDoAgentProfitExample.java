package com.shengpay.debit.dal.ext.dataobject;

import com.sdp.emall.common.dao.QueryBase;

public class ExtDoAgentProfitExample extends QueryBase {

	private static final long serialVersionUID = 1L;
	private String promoterNo; // 代理商商户号
	private String merchantName; // 商户名称
	private String merchantNo; // 商户号
	private String profitStatus;// 分润状态
	private String startTime;//开始时间
	private String endTime;//结束时间


	public String getPromoterNo() {
		return promoterNo;
	}

	public void setPromoterNo(String promoterNo) {
		this.promoterNo = promoterNo;
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

	public String getMerchantName() {
		return merchantName;
	}

	public void setMerchantName(String merchantName) {
		this.merchantName = merchantName;
	}

	public String getMerchantNo() {
		return merchantNo;
	}

	public void setMerchantNo(String merchantNo) {
		this.merchantNo = merchantNo;
	}

	public String getProfitStatus() {
		return profitStatus;
	}

	public void setProfitStatus(String profitStatus) {
		this.profitStatus = profitStatus;
	}

}
