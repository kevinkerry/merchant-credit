package com.sdp.mc.ma.test;

import org.apache.cxf.jaxws.JaxWsProxyFactoryBean;
import org.junit.Before;
import org.junit.Test;

import com.sdp.mc.ma.service.IOperatorService;
import com.sdp.mc.ma.wrapper.impl.IOperatorServiceWrapperImpl;

public class TestIOperatorService {
	private IOperatorService operatorService;
	@Before
	public void init() {
		String url = "http://10.132.97.30:8080/auth/IOperatorService?wsdl";
		org.apache.cxf.jaxws.JaxWsProxyFactoryBean factory = new JaxWsProxyFactoryBean();
		factory.setAddress(url);
		factory.setServiceClass(IOperatorService.class);
		operatorService = (IOperatorService) factory.create();
	}

	@Test
	public void testQuery() {
		IOperatorServiceWrapperImpl service = new IOperatorServiceWrapperImpl();
		service.setOperatorService(operatorService);
		service.queryMerchantNoByOperatorId("7000003742112");
	}
}
