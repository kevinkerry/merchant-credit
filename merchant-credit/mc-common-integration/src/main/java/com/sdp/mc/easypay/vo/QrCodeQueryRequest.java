package com.sdp.mc.easypay.vo;

import com.sdp.mc.common.util.StringUtil;

public class QrCodeQueryRequest {

	private String childMerchantNo ;
	
	private String childMerchantName;
	
	private String parentMerchantNo;
	
	/**
     * 每页记录数
     */
    private Integer pageSize=10;

    /**
     * 当前页码
     */
    private Integer pageNo;
    
    
    
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



	public Integer getPageSize() {
		return pageSize;
	}



	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}



	public Integer getPageNo() {
		return pageNo;
	}



	public void setPageNo(Integer pageNo) {
		this.pageNo = pageNo;
	}



	@Override
	public String toString(){
		return StringUtil.joinUrlParams(this);
	}
}
