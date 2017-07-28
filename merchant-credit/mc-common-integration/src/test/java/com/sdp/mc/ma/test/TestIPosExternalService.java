package com.sdp.mc.ma.test;

import org.junit.Before;
import org.junit.Test;

import com.caucho.hessian.client.HessianProxyFactory;
import com.sdp.withdraw.api.merchant.SynMerchantInfoServiceAPI;
import com.sdp.withdraw.vo.merchant.SynMerchantRequest;
import com.sdp.withdraw.vo.merchant.SynPromoterRequest;
import com.shengpay.pos.external.api.PosExternalApi;
import com.shengpay.pos.impl.PosExternalServiceImpl;

public class TestIPosExternalService {
	private PosExternalApi posExternalApi;
	@Before
	public void init() {
		try {
			String url = "http://10.132.97.133:8085/pos-external-facade/hessian/posExternalApi";
			HessianProxyFactory factory = new HessianProxyFactory();  
			//调用的服务接口，url为hessian服务url  
			posExternalApi = (PosExternalApi)factory.create(PosExternalApi.class, url);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}  
	}

	@Test
	public void testQuery() {
		PosExternalServiceImpl service = new PosExternalServiceImpl();
		service.setZfCode("zf910");
		service.setKey("ODAwNjU1YmMtNjIzMi00M2JiLWI1ZmItN2RmZTRiZWY1NTYx");
		service.setPosExternalApi(posExternalApi);
//		int num=service.queryCreditAuthentication("93618597");
		int num=service.queryCreditAuthentication("93618583");
		System.out.println(num);
		
		  
		
	}
}
