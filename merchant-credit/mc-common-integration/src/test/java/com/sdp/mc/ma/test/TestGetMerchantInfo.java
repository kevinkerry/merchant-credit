package com.sdp.mc.ma.test;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.sdp.mc.ma.wrapper.MaOnlineWrapper;
import com.sdp.mc.test.MCIntegrationBaseTest;

public class TestGetMerchantInfo extends MCIntegrationBaseTest {

	@Autowired
	private MaOnlineWrapper maOnlineWrapper;
	@Test
	public void testCreateAccount() {
		String ip ="127.0.0.1";// IPUtils.getLocalIp();
		String merchantNo = this.maOnlineWrapper.queryMerchantNoByUserMemberId("203100000000000111939930", ip);
		System.out.println("merchantNo===" + merchantNo);
	}
}
