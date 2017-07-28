package com.sdp.mc.ma.test;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.junit.Before;
import org.junit.Test;

import com.caucho.hessian.client.HessianProxyFactory;
import com.sdp.mc.settle.api.business.PartnerPromfitQueryAPI;
import com.sdp.mc.settle.api.dto.req.PartnerPromfitCollectRequest;
import com.sdp.mc.settle.api.dto.resp.PartnerPromfitCollectResponse;

public class TestIPartnerPromoterProfitsQuery {

	private PartnerPromfitQueryAPI partnerPromfitQueryAPI;

	@Before
	public void init() {
		try {
			// String url =
			// "http://10.132.97.12:8085/mc-t0-service-website/hessian/synMerchantInfoService";
//			 String url = "http://127.0.0.1:8080/pfs/hessian/partnerPromfitQueryAPI";
			 String url = "http://10.132.97.104:8084/merchant-settle-pfs/hessian/partnerPromfitQueryAPI";
//			 String url = "http://127.0.0.1:8080/pfs/hessian/partnerPromfitQueryAPI";
//			String url = "http://api.mcreit.shengpay.com/mc-t0-service-website/hessian/synMerchantInfoService";
			HessianProxyFactory factory = new HessianProxyFactory();
			// 调用的服务接口，url为hessian服务url
			partnerPromfitQueryAPI = (PartnerPromfitQueryAPI) factory.create(PartnerPromfitQueryAPI.class, url);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}


	@Test
	public void testunderclerkPromoterProfitsCollectToQuery() {
		PartnerPromfitCollectRequest request=new PartnerPromfitCollectRequest();
		request.setPromoterNo("93618348");
		request.setPromoterType("0007");
		request.setUnderPromoterNo("");
		List<String> reusltFilterPromoterNos=new ArrayList<String>();
		reusltFilterPromoterNos.add("93618349");
		reusltFilterPromoterNos.add("93743485");
		reusltFilterPromoterNos.add("93618606");
		reusltFilterPromoterNos.add("93618432");
		reusltFilterPromoterNos.add("93618431");
		reusltFilterPromoterNos.add("93618351");
		reusltFilterPromoterNos.add("93618342");
		request.setStartSettleTime(new Date(1496246400000l));
		request.setEndSettleTime(new Date(1497888000000l));
		request.setReusltFilterPromoterNos(reusltFilterPromoterNos);
		PartnerPromfitCollectResponse res=partnerPromfitQueryAPI.underclerkPromoterProfitsCollectToQuery(request);
		System.out.println(ToStringBuilder.reflectionToString(res));
				

	}
	@Test
	public void testunderclerkPromoterProfitsCollectToSummary() {
		
		PartnerPromfitCollectRequest request=new PartnerPromfitCollectRequest();
		request.setPromoterNo("93618348");
		request.setPromoterType("0007");
		PartnerPromfitCollectResponse res=partnerPromfitQueryAPI.underclerkPromoterProfitsCollectToSummary(request);
		System.out.println(ToStringBuilder.reflectionToString(res));
		
	}
}
