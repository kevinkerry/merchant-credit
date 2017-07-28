package com.sdp.mc.ma.wrapper;

import com.shengpay.ues.model.UesResult;

public interface UesRemoteServiceClient {

	public static final String PAYPWD_PREFIX = "EncryptMaPwdByUes|";

	/**
	 * ues加密
	 * 
	 * @param data
	 *            待加密的数据
	 * @return ticket
	 * **/
	public String encryptData(String data);

	/**
	 * ues解密
	 * 
	 * @param ticket
	 * @param data
	 *            解密后的数据
	 * **/
	public String decryptData(String ticket);

	/**
	 * 获得安全控件加密数据
	 * 
	 * @return
	 */
	public UesResult getCert();
}
