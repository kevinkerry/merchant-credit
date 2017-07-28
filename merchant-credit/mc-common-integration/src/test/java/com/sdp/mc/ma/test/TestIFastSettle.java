package com.sdp.mc.ma.test;

import org.junit.Before;
import org.junit.Test;

import com.caucho.hessian.client.HessianProxyFactory;
import com.sdp.mc.service.fastsettle.FastSettle;
import com.sdp.withdraw.api.merchant.SynMerchantInfoServiceAPI;
import com.sdp.withdraw.vo.merchant.SynMerchantRequest;
import com.sdp.withdraw.vo.merchant.SynPromoterRequest;
import com.shengpay.pos.external.api.PosExternalApi;
import com.shengpay.pos.impl.PosExternalServiceImpl;

public class TestIFastSettle {
	
	
	private FastSettle fastSettle;
	@Before
	public void init() {
		try {
//			String url = "http://10.132.97.12:8085/mc-t0-service-website/hessian/synMerchantInfoService";
			String url = "http://10.132.97.12:8086/mc-service-website/hessian/fastSettle";
			HessianProxyFactory factory = new HessianProxyFactory();  
			//调用的服务接口，url为hessian服务url  
			fastSettle = (FastSettle)factory.create(FastSettle.class, url);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}  
	}

	@Test
	public void test() {
		fastSettle.getFastSettleConfig(123123l, 1);
		  
		
	}
	
}
