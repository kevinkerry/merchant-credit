package com.sdp.mc.ues;

import com.shengpay.ues.model.UesResult;

public interface UESClient {
	public static final String PAYPWD_PREFIX = "EncryptMaPwdByUes|";

	public String encrypt(String cardNo);

	public String decrypt(String ticket);

	public String encryptPassword(String password);

	public UesResult getCert();

	public String getCtrlPassword(String enKey, String str, String certNo);
}
