package com.sdp.mc.easypay.vo;

import java.io.Serializable;


import com.sdp.mc.common.util.StringUtil;

/*
 * 二维码查询请求
 */
public class QrCodeRateQueryRequest implements Serializable {

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

	/**
	 * 每页记录数
	 */
	private Integer pageSize = 10;

	/**
	 * 当前页码
	 */
	private Integer pageNo = 1;

	public String getMerchantNo() {
		return merchantNo;
	}

	public void setMerchantNo(String merchantNo) {
		this.merchantNo = merchantNo;
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
		return StringUtil.joinUrlParams(this);
	}

}
