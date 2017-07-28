package com.shengpay.mpos.realname.vo;
public class MCMerchantRealNameAuthQueryReq {
	//商户号
	private String merchantNO;
	//请求iD 建议使用UUID
	private String requestID;
	//请求任务号
	private String zfCode="zf910";
	private String md5key="CRMPosMD5Key";
	public String getMd5key() {
		return md5key;
	}

	public String getMerchantNO() {
		return merchantNO;
	}
	public void setMerchantNO(String merchantNO) {
		this.merchantNO = merchantNO;
	}
	public String getRequestID() {
		return requestID;
	}
	public void setRequestID(String requestID) {
		this.requestID = requestID;
	}
	public String getZfCode() {
		return zfCode;
	}
	public void setZfCode(String zfCode) {
		this.zfCode = zfCode;
	}
}
