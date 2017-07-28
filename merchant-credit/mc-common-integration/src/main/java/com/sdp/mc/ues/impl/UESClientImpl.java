package com.sdp.mc.ues.impl;

import java.security.cert.X509Certificate;

import javax.annotation.Resource;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Service;

import com.sdp.mc.ues.UESClient;
import com.shengpay.ues.crypto.model.EncryptType;
import com.shengpay.ues.model.UesResult;
import com.shengpay.ues.services.UesRemoteService;
import com.shengpay.ues.util.UesUtils;

@Service
public class UESClientImpl implements UESClient {

	private static final Log logger = LogFactory.getLog(UESClientImpl.class);
	public static final String CODE_SUCCESS = "000";
	@Resource
	private UesRemoteService uesRemoteService;

	@Override
	public String encryptPassword(String password) {
		try {
			String randomKey = UesUtils.generateRandomKey(24);
			String encryptedData = UesUtils.encryptDESede(password, randomKey);

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

			if (CODE_SUCCESS.equals(result.getResultCode())) { return PAYPWD_PREFIX + result.getData(); }

		} catch (Exception e) {
			logger.warn("can't fetch the ues encrypt ", e);
		}
		return null;
	}

	@Override
	public String encrypt(String cardNo) {
		try {
			String randomKey = UesUtils.generateRandomKey(24);
			String encryptedData = UesUtils.encryptDESede(cardNo, randomKey);

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
			if (cardNo.length() >= 4) {
				logger.error("UES encrypt error: cardNo=*************" + cardNo.substring(cardNo.length() - 4, cardNo.length()) + " result="
						+ result.getResultCode() + result.getResultMsg());
			}
		} catch (Exception e) {
			logger.warn("can't fetch the ues encrypt ", e);
		}
		return null;
	}

	@Override
	public String decrypt(String ticket) {
		try {
			UesResult result = uesRemoteService.getDataByTicket(ticket);
			if (CODE_SUCCESS.equals(result.getResultCode()) || "101".equals(result.getResultCode())) { return result.getData().trim(); }
			logger.error("UES decrypt error: ticket=" + ticket + " result=" + result.getResultCode() + result.getResultMsg());
		} catch (Exception e) {
			logger.warn("can't fetch the ues decrypt ", e);
		}
		return null;
	}

	@Override
	public UesResult getCert() {
		return uesRemoteService.getCert();
	}

	@Override
	public String getCtrlPassword(String enKey, String str, String certNo) {
		try {
			UesResult result = uesRemoteService.saveTempData(enKey, str, certNo, EncryptType.CMS, 3600, 1);
			if ("000".equals(result.getResultCode())) {
				String uesTicket = result.getData();
				return uesTicket;
			}
		} catch (Exception e) {
			logger.warn("can't fetch the ues encrypt ", e);
		}
		return null;
	}
}
