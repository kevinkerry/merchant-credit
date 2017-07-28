package com.shengpay.service.alert.factory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sdp.mc.common.enums.AlertMessageSendTypeEnum;
import com.shengpay.service.mail.AlertMessageSender;
import com.shengpay.service.mail.impl.MailAlertMessageSender;

@Service("alertMessageSenderFactory")
public class AlertMessageSenderFactory {

	@Autowired
	private MailAlertMessageSender mailAlertMessageSender;

	public AlertMessageSender getAlertMessageSender(AlertMessageSendTypeEnum messageSendType) {
		if (messageSendType == AlertMessageSendTypeEnum.MAIL_ALERT) {
			return mailAlertMessageSender;
		} else {
			return null;
		}
	}

}
