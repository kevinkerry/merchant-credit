package com.sdp.mc.easypay.vo;

import java.io.Serializable;
import java.util.List;

public class BussinessChildrensListVo implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6361309117643331044L;
	private String industryName;
	private String industryCode;
	private List<BussinessChildrensVo> childrens;

	public String getIndustryName() {
		return industryName;
	}

	public void setIndustryName(String industryName) {
		this.industryName = industryName;
	}

	public String getIndustryCode() {
		return industryCode;
	}

	public void setIndustryCode(String industryCode) {
		this.industryCode = industryCode;
	}

	public List<BussinessChildrensVo> getChildrens() {
		return childrens;
	}

	public void setChildrens(List<BussinessChildrensVo> childrens) {
		this.childrens = childrens;
	}

}
