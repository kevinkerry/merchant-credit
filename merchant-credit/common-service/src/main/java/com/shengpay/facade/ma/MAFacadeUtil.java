package com.shengpay.facade.ma;

import java.util.Date;
import java.util.UUID;

import com.sdp.mc.common.constant.MerchantCreditConstant;
import com.sdp.mc.common.enums.AccountType;
import com.sdp.mc.common.util.IPUtils;
import com.sdp.mc.integration.ma.dto.request.MACreateAccountRequestDTO;

public class MAFacadeUtil {
	public static MACreateAccountRequestDTO buildMACreateAccountRequestDTO(final String memberId, final String requestOperator, AccountType accountType, final String userIp) {
		MACreateAccountRequestDTO req = new MACreateAccountRequestDTO();
		req.setSourceId(MerchantCreditConstant.MC_WEBSITE_ZF_NO);// 来源ID，系统分配,zf号
		req.setRequestNo(UUID.randomUUID().toString());// 请求序列号
		req.setRequestTime(new Date());
		req.setUserIp(userIp);// 用户IP
		req.setAppIp(IPUtils.getLocalIp());// 客户端IP
		req.setMemberId(memberId);
		// requestOperator，不是必填项
		req.setRequestOperator(requestOperator);
		req.setAccountType(accountType);
		return req;
	}
}
