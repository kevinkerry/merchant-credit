package com.sdp.mc.web.dto;

public class AddMarginReqDTO {

	String amount;
	String certSerialNo;
	String encryptedKey;
	String passwrod;
	String _ocx_password_str;
	/**
	 * 3:追加,4取回
	 * **/
	String opType;

	public String getAmount() {
		return amount;
	}

	public void setAmount(String amount) {
		this.amount = amount;
	}

	public String getCertSerialNo() {
		return certSerialNo;
	}

	public void setCertSerialNo(String certSerialNo) {
		this.certSerialNo = certSerialNo;
	}

	public String getEncryptedKey() {
		return encryptedKey;
	}

	public void setEncryptedKey(String encryptedKey) {
		this.encryptedKey = encryptedKey;
	}

	public String getPasswrod() {
		return passwrod;
	}

	public void setPasswrod(String passwrod) {
		this.passwrod = passwrod;
	}

	public String get_ocx_password_str() {
		return _ocx_password_str;
	}

	public void set_ocx_password_str(String _ocx_password_str) {
		this._ocx_password_str = _ocx_password_str;
	}

}
