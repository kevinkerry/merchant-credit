package com.sdp.mc.margin.dao.ext;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import com.sdp.mc.margin.dao.MarginOpReqDOExample;

public class MarginOpReqDOExampleExt extends MarginOpReqDOExample {

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

	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private Date createTimeStart;
	
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private Date createTimeEnd;

	/**
	 * 保证申请开始时间(CREATE_TIME)
	 */
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private Date redeemedTimeStr;
	/**
	 * 保证金申请结束时间(CREATE_TIME)
	 */
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private Date redeemedTimeEnd;
	
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

	public Date getRedeemedTimeStr() {
		return redeemedTimeStr;
	}

	public void setRedeemedTimeStr(Date redeemedTimeStr) {
		this.redeemedTimeStr = redeemedTimeStr;
	}

	public Date getRedeemedTimeEnd() {
		return redeemedTimeEnd;
	}

	public void setRedeemedTimeEnd(Date redeemedTimeEnd) {
		this.redeemedTimeEnd = redeemedTimeEnd;
	}

}
