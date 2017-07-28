package com.sdp.mc.web.vo;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import com.sdp.emall.common.dao.QueryBase;

public class EasyPayQrCodeRateQueryRequest extends QueryBase {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String merchantNo;

	private String qrCodeStart;

	private String qrCodeEnd;

	private String childMerchantNo;

	private String qrCodeStatus;

	private String allowStatus;

	public String getMerchantNo() {
		return merchantNo;
	}

	public void setMerchantNo(String merchantNo) {
		this.merchantNo = merchantNo;
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

	public String getChildMerchantNo() {
		return childMerchantNo;
	}

	public void setChildMerchantNo(String childMerchantNo) {
		this.childMerchantNo = childMerchantNo;
	}

	public String getQrCodeStatus() {
		return qrCodeStatus;
	}

	public void setQrCodeStatus(String qrCodeStatus) {
		this.qrCodeStatus = qrCodeStatus;
	}

	public String getAllowStatus() {
		return allowStatus;
	}

	public void setAllowStatus(String allowStatus) {
		this.allowStatus = allowStatus;
	}

	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this, ToStringStyle.SHORT_PREFIX_STYLE);
	}
}
