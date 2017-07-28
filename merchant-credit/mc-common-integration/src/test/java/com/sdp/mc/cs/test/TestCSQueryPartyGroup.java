package com.sdp.mc.cs.test;

import org.apache.cxf.jaxws.JaxWsProxyFactoryBean;
import org.junit.Before;
import org.junit.Test;

import com.sdp.mc.cs.request.CSQueryPartyGroupRequest;
import com.shengpay.cs.facade.PartyGroupFacade;

public class TestCSQueryPartyGroup {
	PartyGroupFacade partyGroupFacade;
	
	@Before
	public void init(){
		String url = "http://10.132.19.11:8082/cs/service/partyGroupFacade";
		org.apache.cxf.jaxws.JaxWsProxyFactoryBean factory = new JaxWsProxyFactoryBean();
		factory.setAddress(url);
		factory.setServiceClass(PartyGroupFacade.class);
		partyGroupFacade = (PartyGroupFacade) factory.create();
	}
	
	@Test
	public void testQuery(){
		CSQueryPartyGroupRequest request = new CSQueryPartyGroupRequest();
		request.setPartyGroupFacade(partyGroupFacade);
		request.queryPartyGroupByMemberId("203100000000000011201210");
	}
}
