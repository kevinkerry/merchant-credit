package com.sdp.mc.mail.test;

import java.util.Date;

import org.junit.Test;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSenderImpl;

public class TestSendMail {

	@Test
	public void sendMail(){
		SimpleMailMessage mailMessage = new SimpleMailMessage();
		mailMessage.setFrom("alert.mc@shengpay.com");
		mailMessage.setSubject("标题");
		mailMessage.setTo("wangjingao.william@snda.com");
		mailMessage.setText("内容");
		mailMessage.setSentDate(new Date());
		
		JavaMailSenderImpl sender = new JavaMailSenderImpl();
		sender.setHost("smtp.snda.com");
		sender.setUsername("wangjingao.william@snda.com");
		sender.setPassword("Welcome123w");
		sender.send(mailMessage);
	}
}
