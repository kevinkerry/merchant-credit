package com.sdp.mc.credit.test;

import java.io.UnsupportedEncodingException;

import net.sf.json.JSONObject;

import org.apache.cxf.jaxws.JaxWsProxyFactoryBean;
import org.junit.Before;
import org.junit.Test;

import com.shengpay.credit.itf.CreditModelService;

public class TestCreditModelService {

	private CreditModelService creditModelService;

	@Before
	public void init() {
		String url = "http://10.132.97.197:8085/credit-admin/cxf-service/creditModelService?wsdl";
		org.apache.cxf.jaxws.JaxWsProxyFactoryBean factory = new JaxWsProxyFactoryBean();
		factory.setAddress(url);
		factory.setServiceClass(CreditModelService.class);
		creditModelService = (CreditModelService) factory.create();
	}

	/**
	 * 获取参与风控评级的参数列表
	 * **/
	@Test
	public void getCreditDataModel() {
		JSONObject request = new JSONObject();
		request.put("policy", "tiantiandai");
		request.put("owner", "Merchant");
		try {
			String response = creditModelService.getCreditModel(request.toString());
			System.out.println(response);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * 字节截取
	 * **/
	//@Test
	public void testSubstring() {
		String s = "a加bb等于c";
		try {
			int t = 6;
			byte[] b = s.getBytes("gbk");
			int count = 0, _count = 0;
			for (int i = 0; i < t; i++) {
				System.out.printf("b[%d]=%d\n", i, b[i]);
				if (b[i] < 0) {
					count++;
				} else {
					_count++;
				}
			}
			if (count % 2 != 0) {
				int totalCount = _count + (count - 1) / 2;
				System.out.println(s.substring(0, totalCount));
			} else {
				int totalCount = _count + count / 2;
				System.out.println(s.substring(0, totalCount));
			}
			System.out.println("\n\n\n====================" + s.getBytes("Unicode").length);
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
	}
}
