package com.sdp.mc.service.credit4promoter.impl;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sdp.mc.common.constant.MerchantContractCst;
import com.sdp.mc.common.enums.AccountType;
import com.sdp.mc.common.enums.FsConfigChangeStatusEnum;
import com.sdp.mc.common.enums.OpObjTypeEnums;
import com.sdp.mc.common.enums.OpTypeEnums;
import com.sdp.mc.common.enums.WithCapitalEnums;
import com.sdp.mc.common.exception.FastSettleLimitException;
import com.sdp.mc.common.util.DateUtil;
import com.sdp.mc.common.vo.ErrorMessageVO;
import com.sdp.mc.facade.msp.MspFacade;
import com.sdp.mc.integration.fos.dto.request.ReversalTransferRequestDTO;
import com.sdp.mc.integration.fos.dto.response.RemitTransferResponseDTO;
import com.sdp.mc.integration.msp.PromoterInfoDTO;
import com.sdp.mc.integration.msp.request.MspModifyRequest;
import com.sdp.mc.mcbizaccount.dao.BizApplyOpenAccountDO;
import com.sdp.mc.mcbizaccount.manager.BizApplyOpenAccountManager;
import com.sdp.mc.mcwithfunding.dao.WithCapital4PromoterDO;
import com.sdp.mc.mcwithfunding.dao.WithCapital4PromoterDOExample;
import com.sdp.mc.mcwithfunding.manager.WithCapital4PromoterManager;
import com.sdp.mc.msp.dao.FsConfigChangeDO;
import com.sdp.mc.msp.manager.FsConfigChangeManager;
import com.sdp.mc.service.credit4promoter.MCWithCapital4PromoterService;
import com.shengpay.facade.fos.FOSFacade;

@Service("MCWithCapital4PromoterService")
public class MCWithCapital4PromoterServiceImpl implements MCWithCapital4PromoterService {

	private static final Logger logger = LoggerFactory.getLogger(MCWithCapital4PromoterServiceImpl.class);

	@Autowired
	private MspFacade mspFacade;
	@Autowired
	private FOSFacade fosFacade;
	@Autowired
	private WithCapital4PromoterManager withCapital4PromoterManager;
	@Autowired
	private FsConfigChangeManager fsConfigChangeManager;
	@Autowired
	private BizApplyOpenAccountManager bizApplyOpenAccountManager;

	/**
	 * 恢复配资额度job,只恢复状态是4的
	 * **/
	public void resetCreditLimit4Job() {
		Date now = new Date();
		WithCapital4PromoterDOExample example = new WithCapital4PromoterDOExample();
		WithCapital4PromoterDOExample.Criteria c = example.createCriteria();
		c.andStatusEqualTo(WithCapitalEnums.MSP_FAST_SETTLE_LIMIT_ADD_SUCCESS.code);
		c.andRecoveryDateBetween(DateUtil.generateDawnTimeStamp(now), DateUtil.generateMidnightTimeStamp(now));
		while (true) {
			// 分页查询待恢复配资的申请记录
			List<WithCapital4PromoterDO> withCapitalList = this.withCapital4PromoterManager.selectByQuery(example);
			if (withCapitalList != null && withCapitalList.size() > 0) {
				for (WithCapital4PromoterDO withCapital4PromoterDO : withCapitalList) {
					try {
						ErrorMessageVO errorMsg = this.resetCreditLimit(withCapital4PromoterDO,MerchantContractCst.SYSTEM_DEFAULT_USER);
						logger.info("MCWithCapital4PromoterServiceImpl.resetCreditLimit4Job,withCapitalId=" + withCapital4PromoterDO.getId() + ",errorMsg="
								+ ToStringBuilder.reflectionToString(errorMsg));
					} catch (Exception e) {
						logger.error("MCWithCapital4PromoterServiceImpl.resetCreditLimit4Job.error,withCapitalId=" + withCapital4PromoterDO.getId(), e);
					}
				}
			} else {
				return;
			}
		}
	}
	/**
	 * msp配资恢复额度修改失败补单job，只有3次机会，8点之前完成，否则与快速结算追加保证金时间重叠,只重试状态是7的
	 * 
	 * **/
	public void retryRecoveryMspFastSettleLimit4Job() {
		Date now = new Date();
		WithCapital4PromoterDOExample example = new WithCapital4PromoterDOExample();
		WithCapital4PromoterDOExample.Criteria c = example.createCriteria();
		c.andStatusEqualTo(WithCapitalEnums.MSP_FAST_SETTLE_LIMIT_RESET_FAILURE.code);
		c.andRetryTimes4mspLessThan(3);
		c.andRecoveryDateBetween(DateUtil.generateDawnTimeStamp(now), DateUtil.generateMidnightTimeStamp(now));
		while (true) {
			// 分页查询待恢复配资的申请记录
			List<WithCapital4PromoterDO> withCapitalList = this.withCapital4PromoterManager.selectByQuery(example);
			if (withCapitalList != null && withCapitalList.size() > 0) {
				for (WithCapital4PromoterDO withCapital4PromoterDO : withCapitalList) {
					try {
						ErrorMessageVO errorMsg = this.resetCreditLimit(withCapital4PromoterDO,MerchantContractCst.SYSTEM_DEFAULT_USER);
						logger.info("MCWithCapital4PromoterServiceImpl.retryRecoveryMspFastSettleLimit4Job,withCapitalId=" + withCapital4PromoterDO.getId() + ",errorMsg="
								+ ToStringBuilder.reflectionToString(errorMsg));
					} catch (Exception e) {
						logger.error("MCWithCapital4PromoterServiceImpl.retryRecoveryMspFastSettleLimit4Job.error,withCapitalId=" + withCapital4PromoterDO.getId(), e);
					}
				}
			} else {
				return;
			}
		}
	}

	/**
	 * 恢复配资
	 * **/
	public ErrorMessageVO resetCreditLimit(WithCapital4PromoterDO record, String operatorId) {
		if (record == null) {
			return new ErrorMessageVO(false, "-1", "配资申请不存在");
		}
		// 只有配资成功和msp额度修改失败的才可以处理
		if (record.getStatus().intValue() != WithCapitalEnums.MSP_FAST_SETTLE_LIMIT_ADD_SUCCESS.code
				&& record.getStatus().intValue() != WithCapitalEnums.MSP_FAST_SETTLE_LIMIT_RESET_FAILURE.code) {
			return new ErrorMessageVO(false, "-1", "只有代理商快速结算额度未恢复的情况下才能使用此功能");
		}
		// 原始状态
		WithCapitalEnums originalStatus = WithCapitalEnums.parse(record.getStatus());
		PromoterInfoDTO promoterInfo = this.mspFacade.findPromoterInfoByPromoterId(record.getPromoterId());
		BigDecimal originalFastSettleLimit = new BigDecimal(StringUtils.isNotBlank(promoterInfo.getFastSettleLimit()) ? promoterInfo.getFastSettleLimit() : "0");
		BigDecimal totalFastSettleLimit = originalFastSettleLimit.subtract(record.getAmount());
		MspModifyRequest mspModifyRequest = new MspModifyRequest();
		mspModifyRequest.setOpType(OpTypeEnums.PROMOTER_WITHCAPITAL_RESUME.code);
		mspModifyRequest.setFastSettleLimit(totalFastSettleLimit.setScale(2, BigDecimal.ROUND_HALF_UP).toString());
		mspModifyRequest.setObjType(OpObjTypeEnums.PROMOTER.code);
		mspModifyRequest.setObjId(record.getPromoterId());
		mspModifyRequest.setPromoterId(record.getPromoterId());
		mspModifyRequest.setPromoterNo(record.getMerchantNo());
		mspModifyRequest.setPromoterType(record.getMcType());
		// 记录变更
		long fcmId=0l;
		try {
			fcmId = mspFacade.createFsconfigChange(mspModifyRequest,operatorId);
		} catch (FastSettleLimitException e) {
			return new ErrorMessageVO(false, "-1", e.getMessage());
		}
		record.setReversalChangeId(fcmId);
		this.withCapital4PromoterManager.updateByPrimaryKeySelective(record);
		logger.info("MCWithCapital4PromoterServiceImpl.resetCreditLimit.withCapitalId=" + record.getId() + ",fcmId=" + fcmId);
		logger.info("MCWithCapital4PromoterServiceImpl.resetCreditLimit.mspModifyRequest=" + ToStringBuilder.reflectionToString(mspModifyRequest));
		ErrorMessageVO responseDTO = mspFacade.modifyFastSettleConfig2Msp(mspModifyRequest, fcmId);
		logger.info("MCWithCapital4PromoterServiceImpl.resetCreditLimit.mspModifyRequest=" + ToStringBuilder.reflectionToString(mspModifyRequest) + ",responseDTO="
				+ ToStringBuilder.reflectionToString(responseDTO));
		if (responseDTO.isSuccess()) {
			FsConfigChangeDO fsConfigChangeDO = fsConfigChangeManager.selectByPrimaryKey(fcmId);
			fsConfigChangeDO.setUpdateTime(new Date());
			fsConfigChangeDO.setStatus(FsConfigChangeStatusEnum.SUCCESS.code);
			int rows = this.fsConfigChangeManager.updateByPrimaryKeySelective(fsConfigChangeDO);
			logger.info("MCWithCapital4PromoterServiceImpl.resetCreditLimit.updateFsConfigChange2Success.fcmId=" + fcmId + ",withCapitalId=" + record.getId() + ",rows=" + rows);
			// 同步msp数据状态
			int retryTimes = record.getRetryTimes4msp() + 1;
			rows = this.syncMspStatus4Success(record.getId(), originalStatus, WithCapitalEnums.MSP_FAST_SETTLE_LIMIT_RESET_SUCCESS, fcmId, retryTimes);
			logger.info("MCWithCapital4PromoterServiceImpl.resetCreditLimit.updateWithCapital4Promoter2Success,withCapitalId=" + record.getId() + ",rows=" + rows);
			if (rows == 1) {
				// fos恢复代理商授信
				logger.info("MCWithCapital4PromoterServiceImpl.resetCreditLimit.fosResetCreditLimit,withCapitalId=" + record.getId() + ",promoterId=" + record.getPromoterId()
						+ ",amount=" + record.getAmount());
				RemitTransferResponseDTO response = this.fosResetCreditLimit(record.getPromoterId(), record.getAmount());
				logger.info("MCWithCapital4PromoterServiceImpl.resetCreditLimit.fosResetCreditLimit,withCapitalId=" + record.getId() + ",promoterId=" + record.getPromoterId()
						+ ",response=" + ToStringBuilder.reflectionToString(response));
				if (response.isSuccess()) {
					rows = this.syncFOSStatus(record.getId(), WithCapitalEnums.MSP_FAST_SETTLE_LIMIT_RESET_SUCCESS, WithCapitalEnums.FOS_REFUND_SUCCESS,
							response.getMarginTransId());
					logger.info("MCWithCapital4PromoterServiceImpl.resetCreditLimit.syncFOSStatus2Success,withCapitalId=" + record.getId() + ",rows=" + rows);
					if (rows == 1) {
						return new ErrorMessageVO(true, "0", "配资额度恢复成功");
					} else {
						return new ErrorMessageVO(false, "-1", "配资额度恢复fos成功,状态修改失败");
					}
				} else {
					rows = this.syncFOSStatus(record.getId(), WithCapitalEnums.MSP_FAST_SETTLE_LIMIT_RESET_SUCCESS, WithCapitalEnums.FOS_REFUND_FAIL, response.getMarginTransId());
					logger.info("MCWithCapital4PromoterServiceImpl.resetCreditLimit.syncFOSStatus2Fail,withCapitalId=" + record.getId() + ",rows=" + rows);
					if (rows == 1) {
						return new ErrorMessageVO(false, "-1", "配资额度恢复失败");
					} else {
						return new ErrorMessageVO(false, "-1", "配资额度恢复fos失败,状态修改失败");
					}
				}
			} else {
				return new ErrorMessageVO(false, "-1", "配资额度恢复msp接口成功,状态修改失败");
			}
		} else {
			FsConfigChangeDO fsConfigChangeDO = fsConfigChangeManager.selectByPrimaryKey(fcmId);
			fsConfigChangeDO.setUpdateTime(new Date());
			fsConfigChangeDO.setStatus(FsConfigChangeStatusEnum.FAILUE.code);
			int rows = fsConfigChangeManager.updateByPrimaryKeySelective(fsConfigChangeDO);
			int retryTimes = record.getRetryTimes4msp() + 1;
			logger.info("MCWithCapital4PromoterServiceImpl.resetCreditLimit.updateFsConfigChange2Fail.fcmId=" + fcmId + ",withCapitalId=" + record.getId() + ",retryTimes="
					+ retryTimes + ",rows=" + rows);
			rows = this.syncMspStatus4Fail(record.getId(), originalStatus, WithCapitalEnums.MSP_FAST_SETTLE_LIMIT_RESET_FAILURE, fcmId, retryTimes);
			logger.info("MCWithCapital4PromoterServiceImpl.resetCreditLimit.updateWithCapital4Promoter2Fail,withCapitalId=" + record.getId() + ",rows=" + rows);
			if (rows == 1) {
				return new ErrorMessageVO(false, "-1", "配资额度恢复msp接口失败");
			} else {
				return new ErrorMessageVO(false, "-1", "配资额度恢复msp接口失败,状态修改失败");
			}
		}
	}
	/**
	 * 同步msp状态
	 * **/
	private int syncMspStatus4Success(Long id, WithCapitalEnums originalStatus, WithCapitalEnums targetStatus, Long reversalChangeId, int retryTimes) {
		WithCapital4PromoterDOExample example = new WithCapital4PromoterDOExample();
		WithCapital4PromoterDOExample.Criteria c = example.createCriteria();
		c.andIdEqualTo(id);
		c.andStatusEqualTo(originalStatus.code);
		WithCapital4PromoterDO record = new WithCapital4PromoterDO();
		record.setReversalChangeId(reversalChangeId);
		record.setStatus(targetStatus.code);
		record.setUpdateTime(new Date());
		record.setRetryTimes4msp(retryTimes);
		return this.withCapital4PromoterManager.updateByExampleSelective(record, example);
	}

	/**
	 * 同步msp状态至失败
	 * **/
	private int syncMspStatus4Fail(Long id, WithCapitalEnums originalStatus, WithCapitalEnums targetStatus, Long reversalChangeId, int retryTimes) {
		WithCapital4PromoterDOExample example = new WithCapital4PromoterDOExample();
		WithCapital4PromoterDOExample.Criteria c = example.createCriteria();
		c.andIdEqualTo(id);
		c.andStatusEqualTo(originalStatus.code);
		WithCapital4PromoterDO record = new WithCapital4PromoterDO();
		record.setReversalChangeId(reversalChangeId);
		record.setStatus(targetStatus.code);
		record.setUpdateTime(new Date());
		record.setRetryTimes4msp(retryTimes);
		return this.withCapital4PromoterManager.updateByExampleSelective(record, example);
	}
	/**
	 * 同步fos状态
	 * **/
	private int syncFOSStatus(Long id, WithCapitalEnums originalStatus, WithCapitalEnums targetStatus, Long fosTransId) {
		WithCapital4PromoterDOExample example = new WithCapital4PromoterDOExample();
		WithCapital4PromoterDOExample.Criteria c = example.createCriteria();
		c.andIdEqualTo(id);
		c.andStatusEqualTo(originalStatus.code);
		WithCapital4PromoterDO record = new WithCapital4PromoterDO();
		record.setReversalFosId(fosTransId);
		record.setStatus(targetStatus.code);
		record.setUpdateTime(new Date());
		return this.withCapital4PromoterManager.updateByExampleSelective(record, example);
	}

	private RemitTransferResponseDTO fosResetCreditLimit(Long promoterId, BigDecimal amount) {
		BizApplyOpenAccountDO account = this.bizApplyOpenAccountManager.getByPromoterIdAndAccountType(promoterId, AccountType.CREDIT_ACCOUNT);
		ReversalTransferRequestDTO request = new ReversalTransferRequestDTO();
		request.setPromoterMemberId(account.getMemberId());
		request.setPromoterAccountId(account.getAccountId());
		request.setReversalAmount(amount);
		return this.fosFacade.transfer4Reversal(request);
	}

	/**
	 * 根据id查询配资申请记录
	 * 
	 * **/
	public WithCapital4PromoterDO queryWithCapital4PromoterById(Long id) {
		return this.withCapital4PromoterManager.selectByPrimaryKey(id);
	}

}
