package com.sdp.mc.ma.test;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.junit.Before;
import org.junit.Test;

import com.caucho.hessian.client.HessianProxyFactory;
import com.sdp.withdraw.api.merchant.SynMerchantInfoServiceAPI;
import com.sdp.withdraw.vo.merchant.QueryMerchantRequest;
import com.sdp.withdraw.vo.merchant.QueryMerchantResponse;
import com.sdp.withdraw.vo.merchant.SynMerchantRequest;
import com.sdp.withdraw.vo.merchant.SynPromoterRequest;
import com.shengpay.pos.external.api.PosExternalApi;
import com.shengpay.pos.impl.PosExternalServiceImpl;

public class TestISynMerchantService {

	private SynMerchantInfoServiceAPI synMerchantInfoServiceAPI;

	@Before
	public void init() {
		try {
			// String url =
			// "http://10.132.97.12:8085/mc-t0-service-website/hessian/synMerchantInfoService";
			 String url = "http://127.0.0.1:8080/mc-t0-service-website/hessian/synMerchantInfoService";
//			String url = "http://api.mcreit.shengpay.com/mc-t0-service-website/hessian/synMerchantInfoService";
			HessianProxyFactory factory = new HessianProxyFactory();
			// 调用的服务接口，url为hessian服务url
			synMerchantInfoServiceAPI = (SynMerchantInfoServiceAPI) factory.create(SynMerchantInfoServiceAPI.class, url);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	
	public void testQueryMerchant() {
		QueryMerchantRequest request = new QueryMerchantRequest();
		request.setMerchantNo("10158824");
		request.setMerchantType("0006");
		QueryMerchantResponse res = synMerchantInfoServiceAPI.queryMerchantInfo(request);

		System.out.println(ToStringBuilder.reflectionToString(res));

	}
	@Test
	public void testSynMerchant() throws IOException {
		String[] arr = FileUtils.readLineFile(new File("E://syncMerchant.txt"), "utf-8");
		if (arr != null && arr.length > 0) for (String merchants : arr) {
			try {
				System.out.println(merchants);
				String[] merchantInfo=merchants.split("=");
				if(merchantInfo.length<6){continue;}
				SynMerchantRequest request = new SynMerchantRequest();
				request.setMerchantNo(merchantInfo[1]);
				request.setMerchantType(merchantInfo[2]);
				request.setMerchantName(merchantInfo[3]);
				request.setMcId(Long.parseLong(merchantInfo[4]));
				request.setPromoterId(Long.parseLong(merchantInfo[5]));
				request.setStatus("3");
				Map<String,Map<String,String>> extendInfo=new HashMap<String, Map<String,String>>();
				Map<String,String> m=new HashMap<String, String>();
				m.put("creditCTFCount", merchantInfo.length==6?"0":merchantInfo[6]);
				extendInfo.put("creditAuthentication", m);
				request.setExtendInfo(extendInfo);
				synMerchantInfoServiceAPI.createOrUpdateMerchant(request);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

	}

	// @Test
	public void testSynPromoter() {
		SynPromoterRequest request = new SynPromoterRequest();
		synMerchantInfoServiceAPI.createOrUpdatePromoter(request);

	}
}
