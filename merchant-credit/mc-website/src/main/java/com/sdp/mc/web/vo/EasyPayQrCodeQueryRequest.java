package com.sdp.mc.web.vo;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import com.sdp.emall.common.dao.QueryBase;

public class EasyPayQrCodeQueryRequest  extends QueryBase {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String childMerchantNo ;
	
	private String childMerchantName;
	
	private String parentMerchantNo;

	public String getChildMerchantNo() {
		return childMerchantNo;
	}

	public void setChildMerchantNo(String childMerchantNo) {
		this.childMerchantNo = childMerchantNo;
	}

	public String getChildMerchantName() {
		return childMerchantName;
	}

	public void setChildMerchantName(String childMerchantName) {
		this.childMerchantName = childMerchantName;
	}

	public String getParentMerchantNo() {
		return parentMerchantNo;
	}

	public void setParentMerchantNo(String parentMerchantNo) {
		this.parentMerchantNo = parentMerchantNo;
	}
	
	@Override
	public String toString(){
		return  ToStringBuilder.reflectionToString(this, ToStringStyle.SHORT_PREFIX_STYLE);
	}
}
