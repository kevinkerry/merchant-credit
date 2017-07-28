package com.sdp.mc.service.test.facade;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.sdp.mc.service.test.MCServiceBaseTest;
import com.shengpay.facade.fos.FOSFacade;

public class TestFOSFacade extends MCServiceBaseTest {

	@Autowired
	private FOSFacade facade;

	@Test
	public void test() {
		System.out.println(facade);
	}
}
