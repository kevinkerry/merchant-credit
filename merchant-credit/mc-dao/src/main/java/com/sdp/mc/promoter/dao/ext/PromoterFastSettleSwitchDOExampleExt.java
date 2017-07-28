package com.sdp.mc.promoter.dao.ext;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import com.sdp.mc.promoter.dao.PromoterFastSettleSwitchDOExample;

public class PromoterFastSettleSwitchDOExampleExt extends PromoterFastSettleSwitchDOExample {

	private static final long serialVersionUID = 1L;
	/**
	 * 拓展商类型
	 */
	private String promoterType;

	/**
	 * 拓展商名称
	 */
	private String promoterName;

	/**
	 * 拓展商商户号
	 */
	private String promoterNo;

	/**
	 * 拓展商状态
	 */
	private String promoterStatus;
	/**
	 * 申请开通快速结算时间
	 */
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private Date createTimeStart;

	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private Date createTimeEnd;
	
	/**
	 * 审核：1存在待审核或者审核中纪录 0不存在待审核或者审核中纪录
	 */
	public Integer auditStatus;

	public String getPromoterType() {
		return promoterType;
	}

	public void setPromoterType(String promoterType) {
		this.promoterType = promoterType;
	}

	public String getPromoterName() {
		return promoterName;
	}

	public void setPromoterName(String promoterName) {
		this.promoterName = promoterName;
	}

	public String getPromoterNo() {
		return promoterNo;
	}

	public void setPromoterNo(String promoterNo) {
		this.promoterNo = promoterNo;
	}

	public String getPromoterStatus() {
		return promoterStatus;
	}

	public void setPromoterStatus(String promoterStatus) {
		this.promoterStatus = promoterStatus;
	}

	public Date getCreateTimeStart() {
		return createTimeStart;
	}

	public void setCreateTimeStart(Date createTimeStart) {
		this.createTimeStart = createTimeStart;
	}

	public Date getCreateTimeEnd() {
		return createTimeEnd;
	}

	public void setCreateTimeEnd(Date createTimeEnd) {
		this.createTimeEnd = createTimeEnd;
	}

	public Integer getAuditStatus() {
		return auditStatus;
	}

	public void setAuditStatus(Integer auditStatus) {
		this.auditStatus = auditStatus;
	}

}
