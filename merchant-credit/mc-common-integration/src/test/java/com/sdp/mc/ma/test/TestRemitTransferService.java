package com.sdp.mc.ma.test;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.cxf.jaxws.JaxWsProxyFactoryBean;
import org.junit.Before;
import org.junit.Test;

import com.sdp.fos.model.RemitTransferResponse;
import com.sdp.fos.service.RemitTransferService;

public class TestRemitTransferService {

	private RemitTransferService remitTransferService;
	
	@Before
	public void init(){
		String url = "http://10.132.97.67:8081/fos/services/remitTransferService?wsdl";
		org.apache.cxf.jaxws.JaxWsProxyFactoryBean factory = new JaxWsProxyFactoryBean();
		factory.setAddress(url);
		factory.setServiceClass(RemitTransferService.class);
		remitTransferService = (RemitTransferService) factory.create();
	}
	
	@Test
	public void testTransfer(){
		RemitTransferResponse response = this.remitTransferService.transfer(null);
		System.out.println(ToStringBuilder.reflectionToString(response));
	}
}
