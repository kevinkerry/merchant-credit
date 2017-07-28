package com.shengpay.service.mail;

public interface AlertMessageSender {

	/**
	 * 发送报警信息
	 * 
	 * @param alertMessage
	 * @param messageReceiver以分号分割
	 * @return
	 */
	boolean sendMessage(String messageTitle, String messageConetent, String messageReceiver);
	/**
	 * 发送报警信息
	 * 
	 * @param alertMessage
	 * @param messageReceiver以分号分割
	 * @return
	 */
	boolean sendHtmlMessage(String messageTitle, String messageConetent, String messageReceiver);

}
