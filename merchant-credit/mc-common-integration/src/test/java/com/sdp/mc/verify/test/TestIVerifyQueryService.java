package com.sdp.mc.verify.test;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.cxf.jaxws.JaxWsProxyFactoryBean;
import org.junit.Before;
import org.junit.Test;

import com.sdp.mc.verify.impl.VerifyQueryServiceClientImpl;
import com.shengpay.mpos.realname.MerchantRealNameAuthImpl;
import com.shengpay.poss.service.realname.remote.IMerchantRealNameAuth;
import com.shengpay.verify.common.facade.VerifyQueryService;

public class TestIVerifyQueryService {
	private VerifyQueryService verifyQueryService;
	private IMerchantRealNameAuth merchantRealNameAuth;
	private String certNo;
	@Before
	public void init() {
		initAuth();
		testgetAuthQueryCertNo("93618635");
		String url = "http://10.132.97.70:8080/verify/cxf-service/verifyQueryService?wsdl";
		org.apache.cxf.jaxws.JaxWsProxyFactoryBean factory = new JaxWsProxyFactoryBean();
		factory.setAddress(url);
		factory.setServiceClass(VerifyQueryService.class);
		verifyQueryService = (VerifyQueryService) factory.create();
		
		
	}
	public void initAuth() {
		String url = "http://10.132.97.78:8082/realname-website/ws/1.0/MerchantRealNameAuth?wsdl";
		org.apache.cxf.jaxws.JaxWsProxyFactoryBean factory = new JaxWsProxyFactoryBean();
		factory.setAddress(url);
		factory.setServiceClass(IMerchantRealNameAuth.class);
		merchantRealNameAuth = (IMerchantRealNameAuth) factory.create();
	}

	public void testgetAuthQueryCertNo(String merchantNo) {
		MerchantRealNameAuthImpl service = new MerchantRealNameAuthImpl();
		service.setMerchantRealNameAuth(merchantRealNameAuth);
		service.setRealNameMD5Key("CRMPosMD5Key");
		certNo=service.getAuthQueryCertNo(merchantNo);
		System.out.println(ToStringBuilder.reflectionToString(certNo));
	}

	@Test
	public void testQuery() {
		VerifyQueryServiceClientImpl service =new VerifyQueryServiceClientImpl();
		service.setVerifyQueryService(verifyQueryService);
		service.getMemberIdsByIdcardNoNew(certNo);
	}
}
