package com.shengpay.service.mail.impl;

import java.util.Date;

import javax.mail.Address;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.slf4j.Logger;import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import com.sdo.common.lang.StringUtil;
import com.shengpay.service.mail.AlertMessageSender;

@Service("mailMessageSender")
public class MailAlertMessageSender extends JavaMailSenderImpl implements AlertMessageSender {
	
	private Logger logger = LoggerFactory.getLogger(MailAlertMessageSender.class);

	@Value("${com.sdp.mc.common.alert.smtpServer}")
	private String hostName;
	@Value("${com.sdp.mc.common.alert.smtpUserName}")
	private String userName;
	@Value("${com.sdp.mc.common.alert.smtpPassword}")
	private String password;
	@Value("${com.sdp.mc.common.alert.smtpSenderMail}")
	private String mailFrom;

	public boolean sendMessage(String messageTitle,String messageConetent,String messageReceiver) {
		SimpleMailMessage mailMessage = new SimpleMailMessage();
		mailMessage.setFrom(mailFrom);
		mailMessage.setSubject(messageTitle);
		mailMessage.setTo(messageReceiver.split(";"));
		mailMessage.setText(messageConetent);
		mailMessage.setSentDate(new Date());
		initConfig();
		this.send(mailMessage);
		return true;
	}

	public boolean sendHtmlMessage(String messageTitle,String messageConetent,String messageReceiver) {
		try {
			initConfig();
			this.setDefaultEncoding("GBK");
			MimeMessage mail = this.createMimeMessage();
			MimeMessageHelper helper = new MimeMessageHelper(mail);
			helper.setTo(messageReceiver.split(";"));
			helper.setSubject(messageTitle);
			helper.setFrom(mailFrom);
			helper.setText(messageConetent, true);
			this.send(mail);
			logger.info("MailAlertMessageSender #sendHtmlMessage Success,messageTitle:" + messageTitle);
			return true;
		} catch (Exception e) {
			logger.error("MailAlertMessageSender #sendHtmlMessage Exception",e);
			
		}  
		return false;
	}
	
	
	private void initConfig(){
		if (StringUtil.isEmpty(this.getHost())){
			this.setHost(this.hostName);
			this.setUsername(this.userName);
			this.setPassword(this.password);
		}
	}

}
