package com.sdp.mc.service.mcbizaccount;

import com.sdp.mc.common.enums.AccountType;
import com.sdp.mc.common.vo.ErrorMessageVO;
import com.sdp.mc.integration.msp.PromoterInfoDTO;

public interface BizApplyOpenAccountService {
	/**
	 * 代理商申请开通账户通用方法
	 *
	 * @param promoterDTO
	 *            代理商信息
	 * @param accountType
	 *            账户类型
	 * **/
	public ErrorMessageVO<Object> applyOpenAccount(PromoterInfoDTO promoterDTO, AccountType accountType);

	/**
	 * 代理商申请关闭账户通用方法
	 *
	 * @param promoterDTO
	 *            代理商信息
	 * @param accountType
	 *            账户类型
	 * **/
	public ErrorMessageVO<Object> applyCloseAccount(PromoterInfoDTO promoterDTO, AccountType accountType);
}
