package com.sdp.mc.mcwithfunding.dao.ext;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import com.sdp.mc.mcwithfunding.dao.WithCapital4PromoterDOExample;

public class WithCapitalReqDOExampleExt extends WithCapital4PromoterDOExample {

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

	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private Date createTimeStart;

	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private Date createTimeEnd;

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

}
