package com.shengpay.debit.dal.ext.dataobject;

import com.sdp.emall.common.dao.QueryBase;

public class ExtDoMerchantCreditLinesApplyExample extends QueryBase {

	private static final long serialVersionUID = 1L;

	/* 代理商号 */
	private String promoterNo;
	/*
	 * 代理商名称
	 */
	private String promoterName;
	/* 商户号 */
	private String merchantNo;
	/* 商户名称 */
	private String merchantName;
	/* 贷款额度申请时间 */
	private String applyStartTime;
	/*是否需要代理商承诺担保*/
	private String isNeedAgentGuarantee;
	/*申请起止时间*/
	private String startTimeStr;
	private String endTimeStr;
	/*状态*/
	private String applyStatus;
	/*是否承诺*/
	private String isAgnetGuarantee;
	public String getIsAgnetGuarantee() {
		return isAgnetGuarantee;
	}

	public void setIsAgnetGuarantee(String isAgnetGuarantee) {
		this.isAgnetGuarantee = isAgnetGuarantee;
	}

	public String getApplyStatus() {
		return applyStatus;
	}

	public void setApplyStatus(String applyStatus) {
		this.applyStatus = applyStatus;
	}

	public String getPromoterNo() {
		return promoterNo;
	}

	public void setPromoterNo(String promoterNo) {
		this.promoterNo = promoterNo;
	}

	public String getPromoterName() {
		return promoterName;
	}

	public void setPromoterName(String promoterName) {
		this.promoterName = promoterName;
	}

	public String getMerchantNo() {
		return merchantNo;
	}

	public void setMerchantNo(String merchantNo) {
		this.merchantNo = merchantNo;
	}

	public String getMerchantName() {
		return merchantName;
	}

	public void setMerchantName(String merchantName) {
		this.merchantName = merchantName;
	}

	public String getApplyStartTime() {
		return applyStartTime;
	}

	public void setApplyStartTime(String applyStartTime) {
		this.applyStartTime = applyStartTime;
	}

	public String getIsNeedAgentGuarantee() {
		return isNeedAgentGuarantee;
	}

	public void setIsNeedAgentGuarantee(String isNeedAgentGuarantee) {
		this.isNeedAgentGuarantee = isNeedAgentGuarantee;
	}

	public String getStartTimeStr() {
		return startTimeStr;
	}

	public void setStartTimeStr(String startTimeStr) {
		this.startTimeStr = startTimeStr;
	}

	public String getEndTimeStr() {
		return endTimeStr;
	}

	public void setEndTimeStr(String endTimeStr) {
		this.endTimeStr = endTimeStr;
	}

}
