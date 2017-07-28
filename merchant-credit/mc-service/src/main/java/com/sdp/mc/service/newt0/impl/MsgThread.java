package com.sdp.mc.service.newt0.impl;

import org.slf4j.Logger;import org.slf4j.LoggerFactory;

import com.sdp.mc.common.enums.AlertMessageSendTypeEnum;
import com.shengpay.service.alert.factory.AlertMessageSenderFactory;
import com.shengpay.service.mail.AlertMessageSender;
/**
 * 发送邮件线程
 * @author zhangyulong
 *
 */
public class MsgThread extends Thread{
	
	private static Logger logger = LoggerFactory.getLogger(MsgThread.class);
	
	private AlertMessageSenderFactory alertMessageSenderFactory;
	/**
	 * 主题
	 */
	private String title;
	/**
	 * 内容
	 */
	private String content; 
	
	/**
	 * 邮箱
	 */
	private String mailList;
	
	
	public MsgThread(AlertMessageSenderFactory alertMessageSenderFactory, String title, String content,String mailList){
		this.alertMessageSenderFactory = alertMessageSenderFactory;
		this.title = title;
		this.content = content;
		this.mailList = mailList;
	}
	
	public void run() {
		try {
			final AlertMessageSender sender = alertMessageSenderFactory.getAlertMessageSender(AlertMessageSendTypeEnum.MAIL_ALERT);
//			sender.sendMessage(title, content, mailList);
			sender.sendHtmlMessage(title, content, mailList);
		} catch (Exception e) {
			logger.error("MsgThread.run.error", e);
		}
	}
}
