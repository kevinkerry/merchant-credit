package com.sdp.mc.service.apply.impl;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import org.slf4j.Logger;import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sdp.mc.common.enums.LoaningTypeEnum;
import com.sdp.mc.common.enums.OpOpenAndCloseEnums;
import com.sdp.mc.common.enums.OpTypeEnums;
import com.sdp.mc.common.vo.ErrorMessageVO;
import com.sdp.mc.common.web.MCMerchantUser;
import com.sdp.mc.facade.msp.MspFacade;
import com.sdp.mc.integration.msp.PromoterInfoDTO;
import com.sdp.mc.promoter.dao.PromoterFastSettleSwitchDO;
import com.sdp.mc.promoter.dao.PromoterFastSettleSwitchDOExample;
import com.sdp.mc.promoter.manager.PromoterFastSettleSwitchManager;
import com.sdp.mc.service.AuditInfoService;
import com.sdp.mc.service.apply.PromoterFastSettleSwitch;
import com.sdp.mc.service.newt0.Newt0PromoterService;
import com.sdp.mc.service.op.state.OpContext;
import com.sdp.mc.service.op.state.openandclose.OpenInitState;

@Service("PromoterFastSettleSwitch")
public class PromoterFastSettleSwitchImpl implements PromoterFastSettleSwitch {
	private static final Logger log = LoggerFactory.getLogger(OpenInitState.class);

	@Autowired
	private PromoterFastSettleSwitchManager promoterFastSettleSwitchManager;

	@Autowired
	private Newt0PromoterService newt0PromoterService;

	@Autowired
	private AuditInfoService auditInfoService;

	//@Autowired
	//private AccountQueryFacadeWrapper accountQueryFacadeWrapper;

	@Autowired
	private MspFacade mspFacade;

	/**
	 * 1.验证 user 是否空 2.user是否后代理商编号
	 *
	 * @param error
	 * @param user
	 * @return
	 */
	private boolean validateUser(ErrorMessageVO error, Long promoterId) {
		if (promoterId == null) {
			error.setErrorMessage("promoterId不能为空！");
		}
		return error.getErrorMessage() == null;
	}

	/**
	 * 开通 关闭申请未结束
	 *
	 * @param error
	 * @param isOpen
	 * @param pfrId
	 * @return
	 */
	private boolean validatePfss(ErrorMessageVO error, boolean isOpen, Long pfrId) {
		PromoterFastSettleSwitchDO pfss = this.promoterFastSettleSwitchManager.selectByPrimaryKey(pfrId);
		if (isOpen) {
			if (pfss != null && pfss.getStatus() != OpOpenAndCloseEnums.CLOSE_CONFIGURE_SUCCESS.getCode()) {
				error.setErrorMessage("快速结算服务未关闭！");
			}
		} else {
			if (pfss == null) {
				error.setErrorMessage("参数错误！");
				return false;
			}
			if (pfss.getStatus() != OpOpenAndCloseEnums.CONFIGURE_SUCCESS.getCode()) {
				error.setErrorMessage("快速结算服务未开通！");
			}
		}
		return error.getErrorMessage() == null;
	}

	private boolean validateBalance(ErrorMessageVO error, Long promoterId) {
		try {
			// 为了区分mpos和pos，需要去查询msp表上的保证金金额，不能查询216储值账户余额
			PromoterInfoDTO promoterDTO = this.mspFacade.findPromoterInfoByPromoterId(promoterId);
			BigDecimal margin =new BigDecimal(promoterDTO.getFastSettleMargin());
			if (margin.compareTo(BigDecimal.ZERO)> 0) {
				error.setErrorMessage("对不起您的保证金余额不为0，请先取回保证金");
			}
			return margin.compareTo(BigDecimal.ZERO)==0;
			//线上没有代理商是pos和mpos并存的情况
			/***
			MerchantBalanceDTO merchantBalance = this.accountQueryFacadeWrapper.queryMerchantBalance(user.getMemberId());
			if (merchantBalance.getMarginAccountBalance().doubleValue() > 0) {
				error.setErrorMessage("对不起您的保证金余额不为0，请先取回保证金");
			}
			return merchantBalance.getMarginAccountBalance().doubleValue() == 0;
			***/
		} catch (Exception e) {
			log.error("PromoterFastSettleSwitchImpl.validateBalance.merchantMemberId=" + promoterId, e);
			error.setErrorMessage("很抱歉，系统繁忙，请致电盛付通客服400-720-8888");
			return false;
		}
	}

	private boolean validatePfss(ErrorMessageVO error, Long promoterId) {
		PromoterFastSettleSwitchDO pfss = this.queryPromoterFastSettleSwitchByPromoterId(promoterId);
		if (pfss != null && pfss.getStatus() == OpOpenAndCloseEnums.ACCOUNT_FAILURE.getCode()) {
			error.setErrorMessage("很抱歉，保证金账户开户失败，请致电盛付通客服400-720-8888");
		}
		if (pfss != null && pfss.getStatus() == OpOpenAndCloseEnums.ACCOUNT_SUCCESS.getCode()) {
			error.setErrorMessage("很抱歉，保证金账户开户成功还未生效，请致电盛付通客服400-720-8888");
		}
		if (pfss != null && pfss.getStatus() == OpOpenAndCloseEnums.CONFIGURE_SUCCESS.getCode()) {
			error.setErrorMessage("快速结算服务已开通成功");
		}
		if (pfss != null && pfss.getStatus() == OpOpenAndCloseEnums.CONFIGURE_FAILURE.getCode()) {
			error.setErrorMessage("很抱歉，快速结算服务还未生效，请致电盛付通客服400-720-8888");
		}
		return error.getErrorMessage() == null;
	}

	private boolean validateAuditInfo(ErrorMessageVO error, Long promoterId) {
		LoaningTypeEnum loaningType = LoaningTypeEnum.getLoaningTypeEnum(newt0PromoterService.getLoaningTypeByPromoterId(promoterId));
		if (loaningType==null||LoaningTypeEnum.SHENGPAY == loaningType) {
			boolean b = auditInfoService.hasNonAudited(null, promoterId, OpTypeEnums.ADD.getCode());// 追加通过追加状态判断
			if (b) {// 存在审核中的
				error.setErrorMessage("正在审核中，暂不能关闭快速结算。");
			}
		}
		return error.getErrorMessage() == null;
	}

	/**
	 * 校验申请开通条件
	 *
	 * @param pfrId
	 *            代理商快速结算 开通/关闭id
	 * **/
	public ErrorMessageVO validateApplyOpen(Long pfrId, Long promoterId) {
		ErrorMessageVO error = new ErrorMessageVO(false);
		boolean bValid = this.validateUser(error, promoterId);
		bValid = bValid && this.validatePfss(error, true, pfrId);
		bValid = bValid && this.validatePfss(error, promoterId);
		error.setSuccess(bValid);
		return error;
	}

	/**
	 * 校验申请开通条件
	 *
	 * @param pfrId
	 *            代理商快速结算 开通/关闭id
	 * **/
	public ErrorMessageVO validateApplyClose(Long pfrId, Long promoterId) {
		ErrorMessageVO error = new ErrorMessageVO(false);
		boolean bValid = this.validateUser(error, promoterId);
		bValid = bValid && this.validatePfss(error, false, pfrId);
		bValid = bValid && this.validateAuditInfo(error, promoterId);
		bValid = bValid && this.validateBalance(error, promoterId);
		error.setSuccess(bValid);
		return error;
	}

	public boolean updateStatus(Long pfrId, OpOpenAndCloseEnums originalStatus, OpOpenAndCloseEnums targetStatus) {
		PromoterFastSettleSwitchDOExample example = new PromoterFastSettleSwitchDOExample();
		example.createCriteria().andPfrIdEqualTo(pfrId).andStatusEqualTo(originalStatus.getCode());

		PromoterFastSettleSwitchDO record = new PromoterFastSettleSwitchDO();
		record.setStatus(targetStatus.getCode());
		// 代理商配置更改记录id
		int rows = this.promoterFastSettleSwitchManager.updateByExampleSelective(record, example);
		log.info("PromoterFastSettleSwitchImpl.updateStatus.pfrId=" + pfrId + ",rows=" + rows);
		return rows == 1;
	}

	public long open(OpContext context) {
		PromoterFastSettleSwitchDO record = new PromoterFastSettleSwitchDO();
		record.setType(OpTypeEnums.OPEN.code);
		record.setPromoterId(context.getPromoterId());
		record.setMarginMemberId(context.getMerchantMemberId());
		record.setStatus(OpOpenAndCloseEnums.ACCOUNT_OPENING.getCode());
		record.setCreateTime(new Date());
		record.setUpdateTime(new Date());
		return this.promoterFastSettleSwitchManager.insert(record);
	}

	/**
	 * 如果已经开通过的，再次开通则修改状态关闭->开通
	 * **/
	public boolean reopen(Long pfrId) {
		PromoterFastSettleSwitchDOExample example = new PromoterFastSettleSwitchDOExample();
		example.createCriteria().andPfrIdEqualTo(pfrId).andStatusEqualTo(OpOpenAndCloseEnums.CLOSE_CONFIGURE_SUCCESS.getCode());

		PromoterFastSettleSwitchDO record = new PromoterFastSettleSwitchDO();
		record.setStatus(OpOpenAndCloseEnums.CONFIGURE_SUCCESS.getCode());
		record.setType(OpTypeEnums.OPEN.code);
		// 代理商配置更改记录id
		int rows = this.promoterFastSettleSwitchManager.updateByExampleSelective(record, example);
		log.info("PromoterFastSettleSwitchImpl.reopen.pfrId=" + pfrId + ",rows=" + rows);
		return rows == 1;
	}

	/**
	 * 修改代理商开通、关闭记录[状态、储值帐号id,开户记录id]
	 *
	 * @param pfrId
	 * @param originalStatus
	 *            原有状态
	 * @param targetStatus
	 *            目标状态
	 * @param accountId储值帐号id
	 * @param marginAccountId
	 *            开户记录表id
	 * ***/
	public boolean updateMarginAccount(Long pfrId, OpOpenAndCloseEnums originalStatus, OpOpenAndCloseEnums targetStatus, String accountId, Long marginAccountId) {
		PromoterFastSettleSwitchDOExample example = new PromoterFastSettleSwitchDOExample();
		PromoterFastSettleSwitchDOExample.Criteria criteria = example.createCriteria();
		criteria.andPfrIdEqualTo(pfrId).andStatusEqualTo(originalStatus.getCode());
		PromoterFastSettleSwitchDO record = new PromoterFastSettleSwitchDO();
		if (targetStatus == OpOpenAndCloseEnums.ACCOUNT_SUCCESS) {
			record.setMarginAccount(accountId);
		}
		record.setMaqId(marginAccountId);
		// 代理商配置更改记录id
		record.setFcmId(null);
		record.setUpdateTime(new Date());
		record.setStatus(targetStatus.getCode());
		int rows = this.promoterFastSettleSwitchManager.updateByExampleSelective(record, example);
		log.info("PromoterFastSettleSwitchImpl.updateMarginAccount.pfrId=" + pfrId + ",rows=" + rows);
		return rows == 1;
	}

	/**
	 * 代理商快速结算配置更新完毕之后,其id回写到【代理商开通、关闭记录】上
	 *
	 * @param pfrId
	 * @param changeId
	 *            代理商快速结算配置id
	 * @param status
	 * **/
	public boolean updateFcmIdAfterMarginConfigurationChanged(Long pfrId, Long changeId, OpOpenAndCloseEnums originalStatus, OpOpenAndCloseEnums status) {
		PromoterFastSettleSwitchDO record = new PromoterFastSettleSwitchDO();
		record.setPfrId(pfrId);
		record.setStatus(status.getCode());
		// 代理商配置更改记录id
		record.setFcmId(changeId);
		if (status == OpOpenAndCloseEnums.CLOSE_CONFIGURE_SUCCESS || status == OpOpenAndCloseEnums.CLOSE_CONFIGURE_FAILURE) {
			record.setType(OpTypeEnums.CLOSE.code);
		} else if (status == OpOpenAndCloseEnums.CONFIGURE_SUCCESS || status == OpOpenAndCloseEnums.CONFIGURE_FAILURE) {
			record.setType(OpTypeEnums.OPEN.code);
		} else {
			log.error("PromoterFastSettleSwitchImpl.updateFcmIdAfterMarginConfigurationChanged.status.is.not.correct,pfrId=" + pfrId);
		}
		PromoterFastSettleSwitchDOExample example = new PromoterFastSettleSwitchDOExample();
		example.createCriteria().andPfrIdEqualTo(pfrId).andStatusEqualTo(originalStatus.getCode());
		int rows = this.promoterFastSettleSwitchManager.updateByExampleSelective(record, example);
		log.info("PromoterFastSettleSwitchImpl.updateFcmIdAfterMarginConfigurationChanged.pfrId=" + pfrId + ",changeId=" + changeId + ",rows=" + rows);
		return rows == 1;
	}

	public boolean close(Long pfrId) {
		PromoterFastSettleSwitchDOExample example = new PromoterFastSettleSwitchDOExample();
		example.createCriteria().andPfrIdEqualTo(pfrId).andStatusEqualTo(OpOpenAndCloseEnums.CONFIGURE_SUCCESS.getCode());

		PromoterFastSettleSwitchDO record = new PromoterFastSettleSwitchDO();
		record.setStatus(OpOpenAndCloseEnums.CLOSE_INIT.getCode());
		record.setType(OpTypeEnums.CLOSE.code);
		// 代理商配置更改记录id
		int rows = this.promoterFastSettleSwitchManager.updateByExampleSelective(record, example);
		log.info("PromoterFastSettleSwitchImpl.close.pfrId=" + pfrId + ",rows=" + rows);
		return rows == 1;
	}

	public PromoterFastSettleSwitchDO queryPromoterFastSettleSwitchByPromoterId(Long promoterId) {
		PromoterFastSettleSwitchDOExample example = new PromoterFastSettleSwitchDOExample();
		example.setPromoterId(promoterId);
		List<PromoterFastSettleSwitchDO> list = this.promoterFastSettleSwitchManager.selectByExample(example);
		if (list == null || list.isEmpty())
			return null;
		return list.get(0);
	}

	public PromoterFastSettleSwitchDO queryPromoterFastSettleSwitchByMemberId(String memberId) {
		PromoterFastSettleSwitchDOExample example = new PromoterFastSettleSwitchDOExample();
		example.setMarginMemberId(memberId);
		List<PromoterFastSettleSwitchDO> list = this.promoterFastSettleSwitchManager.selectByExample(example);
		if (list != null && list.size() == 1) {
			return list.get(0);
		}
		return null;
	}

	public PromoterFastSettleSwitchDO queryPromoterFastSettleSwitchById(Long pfrId) {
		return this.promoterFastSettleSwitchManager.selectByPrimaryKey(pfrId);
	}
}
