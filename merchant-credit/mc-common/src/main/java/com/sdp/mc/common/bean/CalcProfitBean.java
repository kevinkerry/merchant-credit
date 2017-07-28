package com.sdp.mc.common.bean;

import java.io.Serializable;
import java.util.Date;

import com.sdo.common.util.DateUtil;

public class CalcProfitBean implements Serializable{

	/**
	 *
	 */
	private static final long serialVersionUID = 1L;
	private String promoterNo;
	private String partnerPromoterNo;
	private Date exectueStatTime;
	private Date exectueEndTime;
	private String exectueStatTimeStr;
	private String exectueEndTimeStr;

	public String getPromoterNo() {
		return promoterNo;
	}

	public void setPromoterNo(String promoterNo) {
		this.promoterNo = promoterNo;
	}

	public Date getExectueStatTime() {
		return DateUtil.parseDateNewFormat(exectueStatTimeStr);
	}

	public void setExectueStatTime(Date exectueStatTime) {
		this.exectueStatTime = exectueStatTime;
	}

	public Date getExectueEndTime() {
		return DateUtil.parseDateNewFormat(exectueEndTimeStr);
	}

	public void setExectueEndTime(Date exectueEndTime) {
		this.exectueEndTime = exectueEndTime;
	}

	public String getExectueStatTimeStr() {
		return exectueStatTimeStr;
	}

	public void setExectueStatTimeStr(String exectueStatTimeStr) {
		this.exectueStatTimeStr = exectueStatTimeStr;
	}

	public String getExectueEndTimeStr() {
		return exectueEndTimeStr;
	}

	public void setExectueEndTimeStr(String exectueEndTimeStr) {
		this.exectueEndTimeStr = exectueEndTimeStr;
	}

	public String getPartnerPromoterNo() {
		return partnerPromoterNo;
	}

	public void setPartnerPromoterNo(String partnerPromoterNo) {
		this.partnerPromoterNo = partnerPromoterNo;
	}
	

}
