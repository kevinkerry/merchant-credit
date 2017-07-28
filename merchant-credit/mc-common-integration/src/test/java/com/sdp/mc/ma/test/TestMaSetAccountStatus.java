package com.sdp.mc.ma.test;

import org.apache.cxf.jaxws.JaxWsProxyFactoryBean;
import org.junit.Test;

import com.sdo.ma.ws.api.service.osr.IMaOsrFullWS;
import com.sdp.mc.common.enums.AccountType;
import com.sdp.mc.ma.wrapper.impl.MaOsrFullServiceWrapperImpl;

public class TestMaSetAccountStatus {
	@Test
	public void testCreateAccount() {
		String url = "http://10.132.97.29:9092/ma-osr/MaOsrFullService?wsdl";
		org.apache.cxf.jaxws.JaxWsProxyFactoryBean factory = new JaxWsProxyFactoryBean();
		factory.setAddress(url);
		factory.setServiceClass(IMaOsrFullWS.class);
		IMaOsrFullWS service = (IMaOsrFullWS) factory.create();

		MaOsrFullServiceWrapperImpl m = new MaOsrFullServiceWrapperImpl();
		m.setMaOsrFullService(service);
		//m.checkOut("103100000000000011092872", "0120010010010000003728", AccountType.C_BASE_ACCOUNT);
		//m.checkIn("103100000000000011092872", "0120010010010000003728", AccountType.C_BASE_ACCOUNT);
		//m.reset2Normal("103100000000000011092872", "0120010010010000003728", AccountType.C_BASE_ACCOUNT);
		m.reset2Normal("103100000000000111637783", "01200100100110100048859270", AccountType.C_BASE_ACCOUNT);
		
	}
}
