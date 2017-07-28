package com.sdp.mc.easypay.vo;


import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import com.sdp.mc.common.util.StringUtil;


public class MerchantQueryRequest  {

	private String parentMerchantNo;

	private String merchantNo;
	
	private String merchantName;
	
	
	private String createStartTime;
	
	private String createEndTime;
	
	
	private String qrCodeStart;
	
	private String qrCodeEnd;
	
	private String channelStatus;
	
	private String secondProxy;
	
	/**
     * 每页记录数
     */
    private Integer pageSize;

    /**
     * 当前页码
     */
    private Integer pageNo;
    
    
    
    

	public String getMerchantNo() {
		return merchantNo;
	}

	public void setMerchantNo(String merchantNo) {
		this.merchantNo = merchantNo;
	}

	
	public String getMerchantName() {
		return merchantName;
	}

	public void setMerchantName(String merchantName) {
		this.merchantName = merchantName;
	}

	public String getCreateStartTime() {
		return createStartTime;
	}

	public void setCreateStartTime(String createStartTime) {
		this.createStartTime = createStartTime;
	}

	public String getCreateEndTime() {
		return createEndTime;
	}

	public void setCreateEndTime(String createEndTime) {
		this.createEndTime = createEndTime;
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
	public String getParentMerchantNo() {
		return parentMerchantNo;
	}

	public void setParentMerchantNo(String parentMerchantNo) {
		this.parentMerchantNo = parentMerchantNo;
	}

	public String getQrCodeStart() {
		return qrCodeStart;
	}

	public void setQrCodeStart(String qrCodeStart) {
		this.qrCodeStart = qrCodeStart;
	}

	public String getQrCodeEnd() {
		return qrCodeEnd;
	}

	public void setQrCodeEnd(String qrCodeEnd) {
		this.qrCodeEnd = qrCodeEnd;
	}

	public String getChannelStatus() {
		return channelStatus;
	}

	public void setChannelStatus(String channelStatus) {
		this.channelStatus = channelStatus;
	}
	

	public String getSecondProxy() {
		return secondProxy;
	}

	public void setSecondProxy(String secondProxy) {
		this.secondProxy = secondProxy;
	}

	@Override
	public String toString(){
		return StringUtil.joinUrlParams(this);
//		return  ToStringBuilder.reflectionToString(this,new UrlToStringStyle());
	}
    /*class UrlToStringStyle extends ToStringStyle{
		private static final long serialVersionUID = 1L;

		public UrlToStringStyle(){
			super();
    		this.setUseClassName(false);
    		this.setUseIdentityHashCode(false);
    		this.setContentStart("");
    		this.setContentEnd("");
    		this.setNullText("");
    		this.setFieldSeparator("&");
    	}
    }*/
}
