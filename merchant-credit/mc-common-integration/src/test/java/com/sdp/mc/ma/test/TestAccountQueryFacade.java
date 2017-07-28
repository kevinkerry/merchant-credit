package com.sdp.mc.ma.test;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.cxf.jaxws.JaxWsProxyFactoryBean;
import org.slf4j.Logger;import org.slf4j.LoggerFactory;
import org.junit.Before;
import org.junit.Test;

import com.sdp.mc.common.enums.AccountType;
import com.sdp.mc.integration.ma.dto.MerchantBaseBalanceDTO;
import com.sdp.mc.ma.wrapper.impl.AccountQueryFacadeWrapperImpl;
import com.shengpay.deposit.facade.account.AccountQueryFacade;

public class TestAccountQueryFacade {
	private static final Logger log = LoggerFactory.getLogger(AccountQueryFacadeWrapperImpl.class);
	private AccountQueryFacade accountQueryFacade;

	@Before
	public void init() {
		String url = "http://10.132.97.195:8082/deposit-web-account/service/accountQueryFacade?wsdl";
		org.apache.cxf.jaxws.JaxWsProxyFactoryBean factory = new JaxWsProxyFactoryBean();
		factory.setAddress(url);
		factory.setServiceClass(AccountQueryFacade.class);
		accountQueryFacade = (AccountQueryFacade) factory.create();
	}

	@Test
	public void testQuery() {
		try {
			AccountQueryFacadeWrapperImpl accountQueryFacadeImpl = new AccountQueryFacadeWrapperImpl();
			accountQueryFacadeImpl.setAccountQueryFacade(accountQueryFacade);
			MerchantBaseBalanceDTO mb = accountQueryFacadeImpl.queryAccountBalanceByAccountType("103100000000000011202154", AccountType.C_BASE_ACCOUNT);
			log.info("mb==============" + ToStringBuilder.reflectionToString(mb));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
