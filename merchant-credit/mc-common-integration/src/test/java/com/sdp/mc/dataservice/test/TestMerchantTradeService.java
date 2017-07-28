package com.sdp.mc.dataservice.test;

import java.net.MalformedURLException;
import java.util.Date;
import org.junit.Before;
import org.junit.Test;
import com.caucho.hessian.client.HessianProxyFactory;
import com.sdp.mc.dataservice.MerchantTradeService;

public class TestMerchantTradeService {
	
	private MerchantTradeService merchantTradeService;
	private HessianProxyFactory factory;
	private String merchantNo;
	private Date date;
	
	@Before
	public void init() {
		String url = "http://10.132.97.62:8083/dc-report/hessian/merchantTrade";
		factory = new HessianProxyFactory();
		try {
			merchantTradeService = (MerchantTradeService) factory.create(MerchantTradeService.class, url);
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
		
		merchantNo = "710666";
		date = new Date();
		
	}

	@Test
	public void testGetGMVOfLastMonth() {
		String result = merchantTradeService.getGMVOfLastMonth(merchantNo, date);
		System.out.println(result);
	}
	
	@Test
	public void testGetGMVOfLastThreeMonth() {
		String result = merchantTradeService.getGMVOfLastThreeMonth(merchantNo, date);
		System.out.println(result);
	}
	
}
