package com.sdp.mc.service.apply;

import com.sdp.mc.common.vo.ErrorMessageVO;
import com.sdp.mc.common.web.MCMerchantUser;
import com.sdp.mc.integration.msp.PromoterInfoDTO;
import com.sdp.mc.ma.dao.MarginAccountRequestDO;
import com.sdp.mc.service.op.state.OpStateResponse;

public interface FastSettleApply {
	/**
	 * 代理商申请开通快速结算
	 *
	 * @param user
	 * @param pfrId
	 *            代理商快速结算 开通/关闭id
	 * @param userIp
	 * **/
	public OpStateResponse applyOpen(MCMerchantUser user, Long pfrId, String userIp,String operatorId, String promoterType, Long promoterId);

	/**
	 * 代理商申请关闭快速结算
	 *
	 * @param user
	 * @param pfrId
	 *            代理商快速结算 开通/关闭id
	 * @param userIp
	 * @param promoterType
	 * **/
	public OpStateResponse applyClose(MCMerchantUser user, Long pfrId, String userIp,String operatorId, String promoterType, Long promoterId);


	/**
	 * 后台运营人员帮助代理商开通
	 *
	 * @param promoterId
	 *            msp系统代理商id
	 * **/
	public ErrorMessageVO applyOpen4Intra(String promoterNo,long promoterId,String promoterType,String operatorId);
	/**
	 * 后台运营人员帮助代理商关闭
	 *
	 * @param promoterId
	 *            msp系统代理商id
	 * **/
	public ErrorMessageVO applyClose4Intra(PromoterInfoDTO promoterDTO,String operatorId);

	MarginAccountRequestDO getSuccessAccountRequestDO(String memberId, long accountType);

	MarginAccountRequestDO getSuccessAccountRequestDO(String memberId, String promoterType);
}
