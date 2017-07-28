package com.sdp.mc.ma.wrapper.impl;

import java.security.cert.X509Certificate;

import org.slf4j.Logger;import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sdp.mc.ma.wrapper.UesRemoteServiceClient;
import com.shengpay.ues.crypto.model.EncryptType;
import com.shengpay.ues.model.UesResult;
import com.shengpay.ues.services.UesRemoteService;
import com.shengpay.ues.util.UesUtils;

@Service("UesRemoteServiceClient")
public class UesRemoteServiceClientImpl implements UesRemoteServiceClient {

	private static final Logger log = LoggerFactory.getLogger(UesRemoteServiceClientImpl.class);

	public static final String CODE_SUCCESS = "000";

	@Autowired
	private UesRemoteService uesRemoteService;

	/**
	 * ues加密
	 * 
	 * @param data
	 *            待加密的数据
	 * @return ticket
	 * **/
	public String encryptData(final String data) {
		try {
			String randomKey = UesUtils.generateRandomKey(24);
			String encryptedData = UesUtils.encryptDESede(data, randomKey);

			UesResult result = uesRemoteService.getCert();
			String base64Cert = "";
			if (CODE_SUCCESS.equals(result.getResultCode())) {
				base64Cert = result.getData();
			} else {
				throw new Exception(result.getResultCode() + result.getData() + result.getResultMsg());
			}
			X509Certificate cert = UesUtils.getX509CertFromBase64Cert(base64Cert);

			// 这里使用的编码格式必须是utf-16le，为了使用公司所有的业务统一。
			String encryptedKey = UesUtils.encryptRSA(randomKey.getBytes("utf-16le"), cert);

			String certSerialNo = UesUtils.getSerialNoFromBase64Cert(base64Cert);
			// Java客户端使用RSA加密
			result = uesRemoteService.saveData(encryptedKey, encryptedData, certSerialNo, EncryptType.RSA);

			if (CODE_SUCCESS.equals(result.getResultCode())) { return result.getData(); }

		} catch (Exception e) {
			log.error("UesRemoteServiceClientImpl.encryptData.error", e);
		}
		return null;
	}

	/**
	 * ues解密
	 * 
	 * @param ticket
	 * @param data
	 *            解密后的数据
	 * **/
	public String decryptData(final String ticket) {
		UesResult result = uesRemoteService.getDataByTicket(ticket);
		if (CODE_SUCCESS.equals(result.getResultCode())) { return result.getData(); }
		return null;
	}

	public UesResult getCert() {
		return uesRemoteService.getCert();
	}

	public String getCtrlPassword(String enKey, String str, String certNo) {
		try {
			UesResult result = uesRemoteService.saveTempData(enKey, str, certNo, EncryptType.CMS, 3600, 1);
			if ("000".equals(result.getResultCode())) {
				String uesTicket = result.getData();
				return uesTicket;
			}
		} catch (Exception e) {
			log.warn("can't fetch the ues encrypt ", e);
		}
		return null;
	}
}
