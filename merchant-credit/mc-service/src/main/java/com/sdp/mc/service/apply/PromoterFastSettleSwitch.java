package com.sdp.mc.service.apply;

import com.sdp.mc.common.enums.OpOpenAndCloseEnums;
import com.sdp.mc.common.vo.ErrorMessageVO;
import com.sdp.mc.common.web.MCMerchantUser;
import com.sdp.mc.promoter.dao.PromoterFastSettleSwitchDO;
import com.sdp.mc.service.op.state.OpContext;

public interface PromoterFastSettleSwitch {

	/**
	 * 校验申请开通条件
	 *
	 * @param pfrId
	 *            代理商快速结算 开通/关闭id
	 * **/
	public ErrorMessageVO validateApplyOpen(Long pfrId, Long promoterId);

	/**
	 * 校验申请开通条件
	 *
	 * @param pfrId
	 *            代理商快速结算 开通/关闭id
	 * **/
	public ErrorMessageVO validateApplyClose(Long pfrId, Long promoterId);

	/**
	 * 修改状态
	 * **/
	public boolean updateStatus(Long pfrId, OpOpenAndCloseEnums originalStatus, OpOpenAndCloseEnums targetStatus);

	/**
	 * 新增代理商开通、关闭记录
	 * ***/
	public long open(OpContext context);

	/**
	 * 再次开通
	 * **/
	public boolean reopen(Long pfrId);

	/**
	 * 修改代理商开通、关闭记录[状态、储值帐号id,开户记录id]
	 *
	 * @param pfrId
	 * @param targetStatus
	 *            目标状态
	 * @param accountId储值帐号id
	 * @param marginAccountId
	 *            开户记录表id
	 * ***/
	public boolean updateMarginAccount(Long pfrId, OpOpenAndCloseEnums originalStatus, OpOpenAndCloseEnums targetStatus, String accountId, Long marginAccountId);

	/**
	 * 代理商快速结算配置更新完毕之后,其id回写到【代理商开通、关闭记录】上
	 *
	 * @param pfrId
	 * @param changeId
	 *            代理商快速结算配置id
	 * **/
	public boolean updateFcmIdAfterMarginConfigurationChanged(Long pfrId, Long changeId, OpOpenAndCloseEnums originalStatus, OpOpenAndCloseEnums status);

	/**
	 * 新增代理商开通、关闭记录
	 * ***/
	public boolean close(Long pfrId);

	/**
	 * 根据msp系统的代理商id查询
	 * **/
	public PromoterFastSettleSwitchDO queryPromoterFastSettleSwitchByPromoterId(Long promoterId);

	/**
	 * 根据代理商商户memberId
	 * **/
	public PromoterFastSettleSwitchDO queryPromoterFastSettleSwitchByMemberId(String memberId);

	/**
	 * 根据id查询
	 * **/
	public PromoterFastSettleSwitchDO queryPromoterFastSettleSwitchById(Long pfrId);

}
