package com.sdp.mc.web.vo;


import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;
import org.apache.commons.lang3.StringUtils;

import com.sdp.emall.common.dao.QueryBase;

public class EasyPayMerchantRequest extends QueryBase {

    private String merchantNo ;
	
	private String merchantName;
	
	private String createStartTime;
	
	private String createEndTime;
	
	private String parentMerchantNo;

	
	private String qrCodeStart;
	
	private String qrCodeEnd;
	
	private String channelStatus;
	
	private String secondProxy;
	
	public String getMerchantNo() {
		return merchantNo;
	}

	public void setMerchantNo(String merchantNo) {
		this.merchantNo = merchantNo;
	}


	public String getCreateStartTime() {
		return createStartTime;
	}

	public void setCreateStartTime(String createStartTime) {
		this.createStartTime =StringUtils.remove(createStartTime, "-");
		
	}

	public String getCreateEndTime() {
		return createEndTime;
	}

	public void setCreateEndTime(String createEndTime) {
		this.createEndTime =StringUtils.remove(createEndTime, "-");
	}


	public String getMerchantName() {
		return merchantName;
	}

	public void setMerchantName(String merchantName) {
		this.merchantName = merchantName;
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
		return  ToStringBuilder.reflectionToString(this, ToStringStyle.SHORT_PREFIX_STYLE);
	}
}
