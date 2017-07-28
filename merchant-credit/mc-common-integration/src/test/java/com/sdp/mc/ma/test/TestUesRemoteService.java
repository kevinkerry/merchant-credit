package com.sdp.mc.ma.test;

import java.io.UnsupportedEncodingException;
import java.security.cert.X509Certificate;

import org.junit.Before;
import org.junit.Test;

import com.shengpay.ues.crypto.model.EncryptType;
import com.shengpay.ues.model.UesResult;
import com.shengpay.ues.services.UesRemoteService;
import com.shengpay.ues.util.UesUtils;

public class TestUesRemoteService {
	public static final String CODE_SUCCESS = "000";
	private UesRemoteService uesRemoteService;

	private String data = "支付密码";

	@Before
	public void init() {
		String url = "http://10.132.97.33:8081/service/UesRemoteService?wsdl";
		com.sdp.mc.common.ws.WSApiProxyFactoryBean factory = new com.sdp.mc.common.ws.WSApiProxyFactoryBean();
		factory.setAddress(url);
		factory.setServiceClass(UesRemoteService.class);
		uesRemoteService = (UesRemoteService) factory.create();
	}

	@Test
	public void testEncrypt() {
		try {
			String randomKey = UesUtils.generateRandomKey(24);
			String encryptedData = UesUtils.encryptDESede(data, randomKey);
			UesResult result = uesRemoteService.getCert();
			String base64Cert = "";
			if (CODE_SUCCESS.equals(result.getResultCode())) {
				base64Cert = result.getData();
				X509Certificate cert = UesUtils.getX509CertFromBase64Cert(base64Cert);
				// 这里使用的编码格式必须是utf-16le，为了使用公司所有的业务统一。
				String encryptedKey;
				encryptedKey = UesUtils.encryptRSA(randomKey.getBytes("utf-16le"), cert);
				String certSerialNo = UesUtils.getSerialNoFromBase64Cert(base64Cert);
				// Java客户端使用RSA加密
				result = uesRemoteService.saveData(encryptedKey, encryptedData, certSerialNo, EncryptType.RSA);
				System.out.println("result==========" + result);
			}
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
	}
}
