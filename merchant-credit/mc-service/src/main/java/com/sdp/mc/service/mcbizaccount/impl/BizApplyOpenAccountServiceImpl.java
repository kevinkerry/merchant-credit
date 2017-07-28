package com.sdp.mc.service.mcbizaccount.impl;

import java.util.Date;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.slf4j.Logger;import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sdp.mc.common.enums.AccountType;
import com.sdp.mc.common.enums.BizApplyOpenAccountStatusEnum;
import com.sdp.mc.common.enums.OpTypeEnums;
import com.sdp.mc.common.util.IPUtils;
import com.sdp.mc.common.vo.ErrorMessageVO;
import com.sdp.mc.integration.ma.dto.Promoter4MADTO;
import com.sdp.mc.integration.msp.PromoterInfoDTO;
import com.sdp.mc.ma.wrapper.MaOnlineWrapper;
import com.sdp.mc.mcbizaccount.dao.BizApplyOpenAccountDO;
import com.sdp.mc.mcbizaccount.dao.BizApplyOpenAccountDOExample;
import com.sdp.mc.mcbizaccount.manager.BizApplyOpenAccountManager;
import com.sdp.mc.promoter.dao.PromoterFastSettleSwitchDO;
import com.sdp.mc.service.apply.PromoterFastSettleSwitch;
import com.sdp.mc.service.mcbizaccount.BizApplyOpenAccountService;
import com.shengpay.facade.ma.MACreateAccountVO;
import com.shengpay.facade.ma.MAFacade;

@Service("BizApplyOpenAccountService")
public class BizApplyOpenAccountServiceImpl implements BizApplyOpenAccountService {
	private static final Logger log = LoggerFactory.getLogger(BizApplyOpenAccountServiceImpl.class);
	@Autowired
	private MaOnlineWrapper maOnlineWrapper;

	@Autowired
	private BizApplyOpenAccountManager bizApplyOpenAccountManager;

	@Autowired
	private PromoterFastSettleSwitch promoterFastSettleSwitch;

	@Autowired
	private MAFacade maFacade;

	/**
	 * 代理商申请开通账户通用方法
	 * 
	 * @param promoterDTO
	 *            代理商信息
	 * @param accountType
	 *            账户类型
	 * **/
	public ErrorMessageVO applyOpenAccount(PromoterInfoDTO promoterDTO, AccountType accountType) {
		try {
			log.info("BizApplyOpenAccountServiceImpl.applyOpenCreditAccount4Intra.promoterDTO=" + ToStringBuilder.reflectionToString(promoterDTO));
			// 是否保证金已开户
			PromoterFastSettleSwitchDO pfss = this.promoterFastSettleSwitch.queryPromoterFastSettleSwitchByPromoterId(promoterDTO.getPromoterId());
			if (pfss == null || ( OpTypeEnums.CLOSE.code == pfss.getType())) {
				return new ErrorMessageVO(false, "-1", "该代理商未开通快速结算服务");
			}
			Promoter4MADTO promoterInfo = this.maOnlineWrapper.queryPromoterInfoByMerchantNo(promoterDTO.getPromoterNo() + "");
			if (promoterInfo == null) {
				return new ErrorMessageVO(false, "-1", "查询代理商会员信息失败");
			}
			// 查询通用开户业务表是否存在记录
			BizApplyOpenAccountDO bizApplyOpenAccount = this.bizApplyOpenAccountManager.getByPromoterIdAndAccountType(promoterDTO.getPromoterId(), accountType);
			if (bizApplyOpenAccount != null) {
				// 开户失败的可以补单
				if (BizApplyOpenAccountStatusEnum.OPEN_ACCOUNT_FAILURE.code == bizApplyOpenAccount.getStatus()) {
					MACreateAccountVO maCreateAccountVO = this.maFacade.createAccount(promoterDTO.getPromoterNo() + "", promoterInfo.getMemberId(),
							promoterInfo.getDefaultOperatorId(), accountType, IPUtils.getLocalIp());
					log.info("BizApplyOpenAccountServiceImpl.applyOpenCreditAccount4Intra.promoterId=" + promoterDTO.getPromoterId() + ",maCreateAccountVO="
							+ ToStringBuilder.reflectionToString(maCreateAccountVO));
					BizApplyOpenAccountStatusEnum newStatus = maCreateAccountVO.isSuccess()
							? BizApplyOpenAccountStatusEnum.OPEN_ACCOUNT_SUCCESS
							: BizApplyOpenAccountStatusEnum.OPEN_ACCOUNT_FAILURE;
					boolean flag = this.updateStatusAndAccountId(bizApplyOpenAccount.getId(), BizApplyOpenAccountStatusEnum.OPEN_ACCOUNT_FAILURE,
							maCreateAccountVO.getBizAccountId(), newStatus, maCreateAccountVO.getAccountId());
					if (flag && maCreateAccountVO.isSuccess()) {
						return new ErrorMessageVO(true, "0", "给代理商开通" + accountType.name + "账户成功");
					} else {
						return new ErrorMessageVO(false, "-1", "给代理商开通" + accountType.name + "账户失败");
					}
				} else if (BizApplyOpenAccountStatusEnum.CLOSED.code == bizApplyOpenAccount.getStatus()) {
					boolean flag = this.updateStatusAndAccountId(bizApplyOpenAccount.getId(), BizApplyOpenAccountStatusEnum.CLOSED, bizApplyOpenAccount.getBizId(),
							BizApplyOpenAccountStatusEnum.OPEN_ACCOUNT_SUCCESS, bizApplyOpenAccount.getAccountId());
					return new ErrorMessageVO(flag, "0", "开通" + accountType.name + (flag ? "成功" : "失败"));
				} else {
					return new ErrorMessageVO(false, "-1", "不能重试开户");
				}
			} else {
				BizApplyOpenAccountDO record = this.buildBizApplyOpenAccountDO(promoterInfo, promoterDTO, accountType);
				Long id = this.bizApplyOpenAccountManager.insert(record);

				MACreateAccountVO maCreateAccountVO = this.maFacade.createAccount(promoterDTO.getPromoterNo() + "", promoterInfo.getMemberId(),
						promoterInfo.getDefaultOperatorId(), accountType, IPUtils.getLocalIp());
				log.info("BizApplyOpenAccountServiceImpl.applyOpenCreditAccount4Intra.promoterId=" + promoterDTO.getPromoterId() + ",maCreateAccountVO="
						+ ToStringBuilder.reflectionToString(maCreateAccountVO));
				BizApplyOpenAccountStatusEnum newStatus = maCreateAccountVO.isSuccess()
						? BizApplyOpenAccountStatusEnum.OPEN_ACCOUNT_SUCCESS
						: BizApplyOpenAccountStatusEnum.OPEN_ACCOUNT_FAILURE;
				boolean flag = this.updateStatusAndAccountId(id, BizApplyOpenAccountStatusEnum.INIT, maCreateAccountVO.getBizAccountId(), newStatus,
						maCreateAccountVO.getAccountId());
				if (flag && maCreateAccountVO.isSuccess()) {
					return new ErrorMessageVO(true, "0", "给代理商开通" + accountType.name + "账户成功");
				} else {
					return new ErrorMessageVO(false, "-1", "给代理商开通" + accountType.name + "账户失败");
				}
			}
		} catch (Exception e) {
			log.error("BizApplyOpenAccountServiceImpl.applyOpenCreditAccount4Intra.error,promoterDTO=" + ToStringBuilder.reflectionToString(promoterDTO), e);
		}
		return new ErrorMessageVO(false, "-1", "系统繁忙");
	}

	private BizApplyOpenAccountDO buildBizApplyOpenAccountDO(Promoter4MADTO promoterInfo, PromoterInfoDTO promoterDTO, AccountType accountType) {
		BizApplyOpenAccountDO record = new BizApplyOpenAccountDO();
		record.setAccountType(accountType.code);
		record.setPromoterId(promoterDTO.getPromoterId());
		record.setMerchantNo(promoterDTO.getPromoterNo() + "");
		record.setPromoterName(promoterDTO.getName());
		record.setMemberId(promoterInfo.getMemberId());
		record.setStatus(BizApplyOpenAccountStatusEnum.INIT.code);
		record.setCreateTime(new Date());
		record.setUpdateTime(new Date());
		return record;
	}

	private boolean updateStatusAndAccountId(Long id, BizApplyOpenAccountStatusEnum originalStatus, Long bizId, BizApplyOpenAccountStatusEnum newStatus, String accountId) {
		BizApplyOpenAccountDO record = new BizApplyOpenAccountDO();
		record.setId(id);
		record.setStatus(newStatus.code);
		record.setBizId(bizId);
		record.setAccountId(accountId);
		record.setUpdateTime(new Date());

		BizApplyOpenAccountDOExample example = new BizApplyOpenAccountDOExample();
		BizApplyOpenAccountDOExample.Criteria criteria = example.createCriteria();
		criteria.andIdEqualTo(id);
		criteria.andStatusEqualTo(originalStatus.code);
		int rows = this.bizApplyOpenAccountManager.updateByExampleSelective(record, example);
		log.info("BizApplyOpenAccountServiceImpl.updateStatusAndAccountId.id=" + id + ",rows=" + rows);
		return rows == 1;
	}

	/**
	 * 代理商申请关闭账户通用方法
	 * 
	 * @param promoterDTO
	 *            代理商信息
	 * @param accountType
	 *            账户类型
	 * **/
	public ErrorMessageVO applyCloseAccount(PromoterInfoDTO promoterDTO, AccountType accountType) {
		// 查询通用开户业务表是否存在记录
		BizApplyOpenAccountDO bizApplyOpenAccount = this.bizApplyOpenAccountManager.getByPromoterIdAndAccountType(promoterDTO.getPromoterId(), accountType);
		if (bizApplyOpenAccount != null) {
			if (BizApplyOpenAccountStatusEnum.OPEN_ACCOUNT_SUCCESS.code == bizApplyOpenAccount.getStatus()) {
				boolean flag = this.updateStatusAndAccountId(bizApplyOpenAccount.getId(), BizApplyOpenAccountStatusEnum.OPEN_ACCOUNT_SUCCESS, bizApplyOpenAccount.getBizId(),
						BizApplyOpenAccountStatusEnum.CLOSED, bizApplyOpenAccount.getAccountId());
				return new ErrorMessageVO(flag, "0", "关闭" + accountType.name + (flag ? "成功" : "失败"));
			} else {
				return new ErrorMessageVO(false, "-1", "状态不正确");
			}
		} else {
			return new ErrorMessageVO(false, "-1", "该代理商还未开通" + accountType.name);
		}
	}
}
