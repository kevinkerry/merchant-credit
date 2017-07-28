package com.sdp.mc.ma.test;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;
import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.sdp.mc.crm.MerchantBankCardWrapper;
import com.shengpay.boss.service.crm.query.api.model.BankAccountInfo;

//@RunWith(SpringJUnit4ClassRunner.class)
//@ContextConfiguration({ "classpath*:/mc_property.xml,/ac_mpos_sdk_service_dubbo.xml" })
public class TestMerchantBankInfo {

	private Logger logger = LoggerFactory.getLogger(TestMerchantBankInfo.class);

	protected MerchantBankCardWrapper merchantBankCardWrapper;
	
	@Before
	public void init() {
		try {
			@SuppressWarnings("resource")
			ApplicationContext wac = new ClassPathXmlApplicationContext("mc_property.xml");
			merchantBankCardWrapper=(MerchantBankCardWrapper) wac.getBean("MerchantBankCardWrapper");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test
	public void testunderclerkPromoterProfitsCollectToQuery() {
		BankAccountInfo info=merchantBankCardWrapper.queryMerchantBankByMerchantId("93744962");
		System.out.println("==========="+ToStringBuilder.reflectionToString(info,ToStringStyle.SIMPLE_STYLE));
				

	}
	

}
