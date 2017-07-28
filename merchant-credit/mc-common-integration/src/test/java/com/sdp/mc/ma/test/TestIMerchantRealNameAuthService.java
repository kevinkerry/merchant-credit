package com.sdp.mc.ma.test;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.cxf.jaxws.JaxWsProxyFactoryBean;
import org.junit.Before;
import org.junit.Test;

import com.shengpay.mpos.realname.MerchantRealNameAuthImpl;
import com.shengpay.poss.service.realname.remote.IMerchantRealNameAuth;

public class TestIMerchantRealNameAuthService {
	private IMerchantRealNameAuth merchantRealNameAuth;
	@Before
	public void init() {
		String url = "http://10.132.97.78:8082/realname-website/ws/1.0/MerchantRealNameAuth?wsdl";
		org.apache.cxf.jaxws.JaxWsProxyFactoryBean factory = new JaxWsProxyFactoryBean();
		factory.setAddress(url);
		factory.setServiceClass(IMerchantRealNameAuth.class);
		merchantRealNameAuth = (IMerchantRealNameAuth) factory.create();
	}

	@Test
	public void testQuery() {
		MerchantRealNameAuthImpl service = new MerchantRealNameAuthImpl();
		service.setMerchantRealNameAuth(merchantRealNameAuth);
		service.setRealNameMD5Key("CRMPosMD5Key");
		String str=service.getAuthQueryCertNo("714798");
		System.out.println(ToStringBuilder.reflectionToString(str));
	}
}
