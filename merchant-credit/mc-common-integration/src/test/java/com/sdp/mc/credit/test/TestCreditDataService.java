package com.sdp.mc.credit.test;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

import net.sf.json.JSONObject;

import org.apache.cxf.jaxws.JaxWsProxyFactoryBean;
import org.junit.Before;
import org.junit.Test;

import com.shengpay.credit.itf.CreditDataService;

public class TestCreditDataService {
	private CreditDataService creditDataService;

	@Before
	public void init() {
		String url = "http://10.132.97.197:8085/credit-admin/cxf-service/creditDataService?wsdl";
		org.apache.cxf.jaxws.JaxWsProxyFactoryBean factory = new JaxWsProxyFactoryBean();
		factory.setAddress(url);
		factory.setServiceClass(CreditDataService.class);
		creditDataService = (CreditDataService) factory.create();
	}

	/**
	 * 测试征信评估数据提交接口
	 * **/
	@Test
	public void testSubmitCreditDataModel() {
		InputStream is = TestCreditDataService.class.getResourceAsStream("testSubmitData.json");
		BufferedReader br = new BufferedReader(new InputStreamReader(is));
		StringBuilder sb = new StringBuilder();
		String s = null;
		try {
			while ((s = br.readLine()) != null) {
				sb.append(s);
			}
			// 关闭流
			br.close();
			// 请求提交接口
			String response = creditDataService.submitCredit(sb.toString());
			System.out.println(response);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void testGetCreditScore() {
		JSONObject request = new JSONObject();
		request.put("policy", "tiantiandai");
		request.put("owner", "Merchant");
		try {
			String response = creditDataService.getCreditScore(request.toString());
			System.out.println(response);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
}
