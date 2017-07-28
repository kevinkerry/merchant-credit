package com.shengpay.service.ma;

import java.util.Date;

import org.apache.commons.lang.StringUtils;

import com.sdp.mc.common.enums.MarginAccountEnum;
import com.sdp.mc.integration.ma.dto.request.MACreateAccountRequestDTO;
import com.sdp.mc.integration.ma.dto.response.MACreateAccountResponseDTO;
import com.sdp.mc.ma.dao.MarginAccountRequestDO;

public class MAServiceUtil {

	public static MarginAccountRequestDO buildMarginAccountRequestDO(MACreateAccountRequestDTO req, String merchantNo) {
		MarginAccountRequestDO record = new MarginAccountRequestDO();
		record.setSourceId(req.getSourceId());// 来源ID，系统分配,zf号
		record.setRequestNo(req.getRequestNo());// 请求序列号
		record.setRequestTime(req.getRequestTime());
		record.setUserIp(req.getUserIp());// 用户IP
		record.setAppIp(req.getAppIp());// 客户端IP
		record.setMemberId(req.getMemberId());
		record.setAccountId("-1");// 默认
		record.setMerchantNo(merchantNo);
		record.setRequestOperator(req.getRequestOperator());//操作员
		record.setStatus(MarginAccountEnum.INIT.code);
		record.setAccountType(req.getAccountType().code);
		return record;
	}

	public static MarginAccountRequestDO buildMarginAccountRequestDO(final Long id, MACreateAccountResponseDTO res) {
		String status = res.isSuccess() && StringUtils.isNotBlank(res.getAccountId()) ? MarginAccountEnum.SUCCESS.code : MarginAccountEnum.FAILUE.code;
		MarginAccountRequestDO record = new MarginAccountRequestDO();
		record.setId(id);
		record.setResponseCode(res.getResponseCode());
		// 数据库只能存80个汉字
		String msg = res.getResponseMessage() + "";
		if (StringUtils.isNotBlank(msg)) {
			msg = msg.substring(0, msg.length() > 40 ? 40 : msg.length());
		}
		record.setResponseMessage(msg);
		record.setResponseTime(new Date());
		record.setAccountId(res.getAccountId());
		record.setStatus(status);
		return record;
	}
}
