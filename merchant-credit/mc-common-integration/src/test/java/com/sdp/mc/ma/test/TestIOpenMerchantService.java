package com.sdp.mc.ma.test;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.cxf.jaxws.JaxWsProxyFactoryBean;
import org.junit.Before;
import org.junit.Test;

import com.sdp.mc.crm.impl.OpenMerchantWrapperImpl;
import com.shengpay.poss.merchant.crm.ws.openmerchant.service.OpenMerchant;
import com.shengpay.poss.merchant.crm.ws.openmerchant.service.bean.QueryPosMerchantInfoResponse;

public class TestIOpenMerchantService {
	private OpenMerchant openMerchant;
	@Before
	public void init() {
		String url = "http://10.132.97.78:8081/merchant-crm/ws/openmerchant?wsdl";
		org.apache.cxf.jaxws.JaxWsProxyFactoryBean factory = new JaxWsProxyFactoryBean();
		factory.setAddress(url);
		factory.setServiceClass(OpenMerchant.class);
		openMerchant = (OpenMerchant) factory.create();
	}

	@Test
	public void testQuery() {
		OpenMerchantWrapperImpl service = new OpenMerchantWrapperImpl();
		service.setOpenMerchant(openMerchant);
		service.setAppid("ZF910");
		service.setKey("CRMPosMD5Key");
		QueryPosMerchantInfoResponse res=service.QueryPosMerchantInfo("709329");
		System.out.println(ToStringBuilder.reflectionToString(res));
	}
}
