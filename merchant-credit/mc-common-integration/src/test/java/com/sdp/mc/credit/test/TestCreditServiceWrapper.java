package com.sdp.mc.credit.test;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

import net.sf.json.JSONObject;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.sdp.mc.credit.wrapper.CreditServiceWrapper;
import com.sdp.mc.test.MCIntegrationBaseTest;

public class TestCreditServiceWrapper extends MCIntegrationBaseTest{
	@Autowired
	private CreditServiceWrapper creditServiceWrapper;
	
	//@Test
	public void getCreditDataModel() {
		JSONObject request = new JSONObject();
		request.put("policy", "tiantiandai");
		request.put("owner", "Merchant");
		try {
			String response = creditServiceWrapper.getCreditModel(request.toString());
			System.out.println(response);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 测试征信评估数据提交接口
	 * **/
	//@Test
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
			String response = creditServiceWrapper.submitCredit(sb.toString());
			System.out.println(response);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void testGetCreditScore() {
		JSONObject request = new JSONObject();
		request.put("policy", "tiantiandai");
		request.put("code", "706539");
		try {
			String responseText = creditServiceWrapper.getCreditScore(request.toString());
			System.out.println(responseText);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
