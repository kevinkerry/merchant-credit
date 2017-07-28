package com.sdp.mc.easypay.vo;

import java.io.Serializable;

public class BussinessKeyVo implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5570446933883667216L;

	private String industryKey;
	private String industryCode;
	private String industryName;

	public String getIndustryKey() {
		return industryKey;
	}

	public void setIndustryKey(String industryKey) {
		this.industryKey = industryKey;
	}

	public String getIndustryCode() {
		return industryCode;
	}

	public void setIndustryCode(String industryCode) {
		this.industryCode = industryCode;
	}

	public String getIndustryName() {
		return industryName;
	}

	public void setIndustryName(String industryName) {
		this.industryName = industryName;
	}

}
