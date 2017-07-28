package com.shengpay.debit.dal.ext.dataobject;

import com.sdp.emall.common.dao.QueryBase;
public class ExtTbWithholdingFileInfoExample extends QueryBase {
	private static final long serialVersionUID = 1L;
	private String merchantNo;
	private String batchNo;
	private String status;
	public String getMerchantNo() {
		return merchantNo;
	}
	public void setMerchantNo(String merchantNo) {
		this.merchantNo = merchantNo;
	}
	public String getBatchNo() {
		return batchNo;
	}
	public void setBatchNo(String batchNo) {
		this.batchNo = batchNo;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}

}