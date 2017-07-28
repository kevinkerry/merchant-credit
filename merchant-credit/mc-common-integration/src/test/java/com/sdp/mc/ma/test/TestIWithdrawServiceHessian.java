package com.sdp.mc.ma.test;

import java.math.BigDecimal;

import org.junit.Before;
import org.junit.Test;

import com.caucho.hessian.client.HessianProxyFactory;
import com.sdp.mc.service.fastsettle.FastSettle;
import com.sdp.withdraw.api.WithdrawT0ServiceAPI;
import com.sdp.withdraw.api.merchant.SynMerchantInfoServiceAPI;
import com.sdp.withdraw.vo.merchant.SynMerchantRequest;
import com.sdp.withdraw.vo.merchant.SynPromoterRequest;
import com.shengpay.pos.external.api.PosExternalApi;
import com.shengpay.pos.impl.PosExternalServiceImpl;

public class TestIWithdrawServiceHessian {
	
	
	private WithdrawT0ServiceAPI withdrawT0ServiceAPI;
	@Before
	public void init() {
		try {
//			String url = "http://10.132.97.12:8085/mc-t0-service-website/hessian/synMerchantInfoService";
			String url = "http://10.132.97.12:8085/mc-t0-service-website/hessian/withdrawServiceHessian";
			HessianProxyFactory factory = new HessianProxyFactory();  
			factory.setOverloadEnabled(true); 
			//调用的服务接口，url为hessian服务url  
			withdrawT0ServiceAPI = (WithdrawT0ServiceAPI)factory.create(WithdrawT0ServiceAPI.class, url);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}  
	}

	@Test
	public void test() {
		try {
			BigDecimal b=withdrawT0ServiceAPI.findTotalAmount("93618682", "0006");
			System.out.println(b);
			System.out.println("========================");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		  
		
	}
	
}
