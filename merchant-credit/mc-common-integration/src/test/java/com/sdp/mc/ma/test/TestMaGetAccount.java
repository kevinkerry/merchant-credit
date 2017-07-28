package com.sdp.mc.ma.test;

import org.apache.cxf.jaxws.JaxWsProxyFactoryBean;
import org.junit.Test;

import com.sdo.ma.ws.api.service.online.IMaOnlineWS;
import com.sdp.mc.common.util.IPUtils;
import com.sdp.mc.ma.wrapper.impl.MaOnlineWrapperImpl;

/**
 * 查询帐号信息
 * **/
public class TestMaGetAccount {
	@Test
	public void testCreateAccount() {
		String url = "http://10.132.97.29:9091/ma-online/OnlineService?wsdl";
		org.apache.cxf.jaxws.JaxWsProxyFactoryBean factory = new JaxWsProxyFactoryBean();
		factory.setAddress(url);
		factory.setServiceClass(IMaOnlineWS.class);
		IMaOnlineWS service = (IMaOnlineWS) factory.create();

		MaOnlineWrapperImpl m = new MaOnlineWrapperImpl();
		m.setMaOnline(service);
		long accountType = m.queryAccountType("203100000000000112047572", "022001011007216001150048896472", IPUtils.getLocalIp());
		System.out.println(accountType);
	}
}
