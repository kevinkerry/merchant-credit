package com.sdp.mc.ma.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.shengpay.ues.services.UesRemoteService;

public class TestSpring {

	public static void main(String[] args) {
		ApplicationContext cxt = new ClassPathXmlApplicationContext("mc_property.xml");
		UesRemoteService uesRemoteService = (UesRemoteService)cxt.getBean("uesRemoteService");
		System.out.println(uesRemoteService);
	}
}
