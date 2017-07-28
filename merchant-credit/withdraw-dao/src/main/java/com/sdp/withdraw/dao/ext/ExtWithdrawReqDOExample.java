package com.sdp.withdraw.dao.ext;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import com.sdp.withdraw.dao.WithdrawReqDOExample;

public class ExtWithdrawReqDOExample extends WithdrawReqDOExample {

	/**
	 * 序列化
	 */
	private static final long serialVersionUID = -1935254967522904158L;

	// private String promoterNo;
	private String promoterName;
	/**
	 * 申请开始时间
	 */
	private Date startApplyTime;
	/**
	 * 结束时间
	 */
	private Date endApplyTime;

	/**
	 * 查询条件提现开始时间
	 */
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private Date startCreateTime;
	/**
	 * 查询条件提现结束时间
	 */
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private Date endCreateTime;

	private String startCreateTimeStr;

	private String endCreateTimeStr;

	/**
	 * 查询条件提现成功开始时间
	 */
	private Date startWithdrawTime;
	/**
	 * 查询条件提现成功结束时间
	 */
	private Date endWithdrawTime;

	private String startWithdrawTimeStr;

	private String endWithdrawTimeStr;

	private String pmtType;

	private String remitStatus;

	private String promoterNo;

	private String merchantName;

	private Long promoterId;
	
	private Long detailId;

	// /**
	// * 出款类型 1：实时出款 2：普通出款
	// */
	// private Integer withdrawType;

	private long minutes;

	public long getMinutes() {
		return minutes;
	}

	public void setMinutes(long minutes) {
		this.minutes = minutes;
	}

	public String getRemitStatus() {
		return remitStatus;
	}

	// public String getPromoterNo() {
	// return promoterNo;
	// }
	//
	// public void setPromoterNo(String promoterNo) {
	// this.promoterNo = promoterNo;
	// }

	public String getPromoterName() {
		return promoterName;
	}

	public void setPromoterName(String promoterName) {
		this.promoterName = promoterName;
	}

	public void setRemitStatus(String remitStatus) {
		this.remitStatus = remitStatus;
	}

	public Date getStartApplyTime() {
		return startApplyTime;
	}

	public void setStartApplyTime(Date startApplyTime) {
		this.startApplyTime = startApplyTime;
	}

	public Date getEndApplyTime() {
		return endApplyTime;
	}

	public void setEndApplyTime(Date endApplyTime) {
		this.endApplyTime = endApplyTime;
	}

	public Date getStartCreateTime() {
		return startCreateTime;
	}

	public void setStartCreateTime(Date startCreateTime) {
		this.startCreateTime = startCreateTime;
	}

	public Date getEndCreateTime() {
		return endCreateTime;
	}

	public void setEndCreateTime(Date endCreateTime) {
		this.endCreateTime = endCreateTime;
	}

	public String getStartCreateTimeStr() {
		return startCreateTimeStr;
	}

	public void setStartCreateTimeStr(String startCreateTimeStr) {
		this.startCreateTimeStr = startCreateTimeStr;
	}

	public String getEndCreateTimeStr() {
		return endCreateTimeStr;
	}

	public void setEndCreateTimeStr(String endCreateTimeStr) {
		this.endCreateTimeStr = endCreateTimeStr;
	}

	public String getPmtType() {
		return pmtType;
	}

	public void setPmtType(String pmtType) {
		this.pmtType = pmtType;
	}

	public String getPromoterNo() {
		return promoterNo;
	}

	public void setPromoterNo(String promoterNo) {
		this.promoterNo = promoterNo;
	}

	public String getMerchantName() {
		return merchantName;
	}

	public void setMerchantName(String merchantName) {
		this.merchantName = merchantName;
	}

	public Long getPromoterId() {
		return promoterId;
	}

	public void setPromoterId(Long promoterId) {
		this.promoterId = promoterId;
	}

	public Date getStartWithdrawTime() {
		return startWithdrawTime;
	}

	public void setStartWithdrawTime(Date startWithdrawTime) {
		this.startWithdrawTime = startWithdrawTime;
	}

	public Date getEndWithdrawTime() {
		return endWithdrawTime;
	}

	public void setEndWithdrawTime(Date endWithdrawTime) {
		this.endWithdrawTime = endWithdrawTime;
	}

	public String getStartWithdrawTimeStr() {
		return startWithdrawTimeStr;
	}

	public void setStartWithdrawTimeStr(String startWithdrawTimeStr) {
		this.startWithdrawTimeStr = startWithdrawTimeStr;
	}

	public String getEndWithdrawTimeStr() {
		return endWithdrawTimeStr;
	}

	public void setEndWithdrawTimeStr(String endWithdrawTimeStr) {
		this.endWithdrawTimeStr = endWithdrawTimeStr;
	}

	public Long getDetailId() {
		return detailId;
	}

	public void setDetailId(Long detailId) {
		this.detailId = detailId;
	}
	
	

}
