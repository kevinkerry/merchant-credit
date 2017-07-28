package com.sdp.mc.easypay.vo;

import java.io.Serializable;
import java.util.List;

public class BussinessChildrensVo implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6191958490014046633L;

	private String industryName;
	private String industryCode;
	private List<BussinessKeyVo> childrens;

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

	public List<BussinessKeyVo> getChildrens() {
		return childrens;
	}

	public void setChildrens(List<BussinessKeyVo> childrens) {
		this.childrens = childrens;
	}

}
