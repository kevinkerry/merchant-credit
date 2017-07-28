package com.sdp.mc.web.action.withfunding;

import java.io.IOException;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import com.sdp.mc.common.constant.MerchantCreditConstant;
import com.sdp.mc.common.enums.AccountStatus;
import com.sdp.mc.common.enums.AccountType;
import com.sdp.mc.common.enums.BizApplyOpenAccountStatusEnum;
import com.sdp.mc.common.enums.FsConfigChangeStatusEnum;
import com.sdp.mc.common.enums.OpObjTypeEnums;
import com.sdp.mc.common.enums.OpTypeEnums;
import com.sdp.mc.common.enums.Result;
import com.sdp.mc.common.enums.WithCapitalEnums;
import com.sdp.mc.common.exception.FastSettleLimitException;
import com.sdp.mc.common.util.DateUtil;
import com.sdp.mc.common.util.RequestUtils;
import com.sdp.mc.common.vo.ErrorMessageVO;
import com.sdp.mc.common.vo.ReturnObj;
import com.sdp.mc.common.web.MCMerchantUser;
import com.sdp.mc.facade.msp.MspFacade;
import com.sdp.mc.integration.fos.dto.request.CreditTransferRequestDTO;
import com.sdp.mc.integration.fos.dto.response.RemitTransferResponseDTO;
import com.sdp.mc.integration.ma.dto.MerchantBalanceDTO;
import com.sdp.mc.integration.msp.PromoterInfoDTO;
import com.sdp.mc.integration.msp.request.MspModifyRequest;
import com.sdp.mc.ma.wrapper.AccountQueryFacadeWrapper;
import com.sdp.mc.mcbizaccount.dao.BizApplyOpenAccountDO;
import com.sdp.mc.mcbizaccount.manager.BizApplyOpenAccountManager;
import com.sdp.mc.mcwithfunding.dao.WithCapital4PromoterDO;
import com.sdp.mc.msp.dao.FsConfigChangeDO;
import com.sdp.mc.msp.manager.FsConfigChangeManager;
import com.sdp.mc.service.mcwithfunding.WithCapital4PromoterService;
import com.sdp.mc.web.action.BaseAction;
import com.sdp.mc.web.dto.ApplyWithFundingReqDTO;
import com.shengpay.facade.fos.FOSFacade;

/**
 * 代理商申请配资
 */
@Controller
@RequestMapping(value = { "/posPromoter", "/mposPromoter" })
public class ApplyWithFundingAction extends BaseAction {

	private static Logger log = LoggerFactory.getLogger(ApplyWithFundingAction.class);
	private static final String MESSAGE = "message";

	@Value("${com.sdp.mc.apply.startTime}")
	private int applyStartTime;
	@Value("${com.sdp.mc.apply.endTime}")
	private int applyEndTime;

	@Autowired
	private WithCapital4PromoterService withCapital4PromoterService;
	@Autowired
	private AccountQueryFacadeWrapper AccountQueryFacadeWrapper;
	@Autowired
	private BizApplyOpenAccountManager bizApplyOpenAccountManager;
	@Autowired
	private MspFacade mspFacade;
	@Autowired
	protected FOSFacade FOSFacade;
	@Autowired
	private FsConfigChangeManager fsConfigChangeManager;

	//@RequestMapping(value = { "/funding/index" })
	public String applyWithFundingIndex(ModelMap model, HttpServletRequest request, HttpServletResponse response) throws IOException {
		try {
			// 代理商在线申请配资的时间为：每日8:00AM～15:00PM，其余时间不可申请配资；T日申请的额度，在T+1日的8:00AM恢复（即可再次申请）
			Date now = new Date();
			Date startTime = DateUtil.getSpecialDate(now, applyStartTime, 0, 0);
			Date endTime = DateUtil.getSpecialDate(now, applyEndTime, 0, 0);
			boolean bl = DateUtil.isValidate(new Date(), startTime, endTime);
			if (!bl) {
				model.put(MESSAGE, "配资申请时段为：8：00-15：00");
				return "/main/withfunding/index";
			}
			MCMerchantUser user = MCMerchantUser.getMCMerchantUser(request.getSession());
			if (user == null || user.getPromoterId() == null) {
				model.put(MESSAGE, "您尚未登录！");
				return "/main/withfunding/index";
			}
			// 查询代理商信息
			PromoterInfoDTO promoterInfoDTO = mspFacade.findPromoterInfoByPromoterId(user.getPromoterId());
			if (promoterInfoDTO == null) {
				model.put(MESSAGE, "代理商不存在！");
				return "/main/withfunding/index";
			}
			// 查询通用开户 状态
			BizApplyOpenAccountDO bizApplyOpenAccount = bizApplyOpenAccountManager.getByPromoterIdAndAccountType(user.getPromoterId(),
					AccountType.CREDIT_ACCOUNT);
			if (bizApplyOpenAccount == null
					|| (BizApplyOpenAccountStatusEnum.OPEN_ACCOUNT_SUCCESS.code != bizApplyOpenAccount.getStatus())) {
				model.put(MESSAGE, "代理商未开通配资功能，请联系客服开通配资功能");
				return "/main/withfunding/index";
			}
			// 验证商户基本户状态、余额
			MerchantBalanceDTO account = AccountQueryFacadeWrapper.queryMerchantBalance(user.getMemberId(),promoterInfoDTO.getPromoterType());
			if (account == null || account.getPublicAccountStatus() != AccountStatus.AccountStatusActive.getCode()) {
				model.put(MESSAGE, "对不起，您的钱包状态异常，无法完成本次配资操作，请联系客服查询钱包状态");
				return "/main/withfunding/index";
			}
			// 保证金账户状态
			if (account.getMarginAccountStatus() != AccountStatus.AccountStatusActive.getCode()) {
				model.put(MESSAGE, "对不起，您的保证金账户状态异常，无法完成本次配资操作，请联系客服查询保证金账户状态");
				return "/main/withfunding/index";
			}
			// 配资授信账户状态
			if (account.getCreditAccountStatus() != AccountStatus.AccountStatusActive.getCode()) {
				model.put(MESSAGE, "对不起，您的配资授信账户状态异常，无法完成本次配资操作，请联系客服查询配资授信账户状态");
				return "/main/withfunding/index";
			}
			// TODO:配置配资总额度
			// 保证金金额
			String fastSettleMargin = promoterInfoDTO.getFastSettleMargin();
			BigDecimal marginAmount = new BigDecimal(fastSettleMargin);
			// 最高配资不超过50万
			BigDecimal maxMarginAmount = new BigDecimal("500000");
			if (marginAmount.compareTo(maxMarginAmount) > 0) {
				marginAmount = maxMarginAmount;
			}

			BigDecimal usedAmount = withCapital4PromoterService.queryWithCapital4Promoter(user.getPromoterId());
			// 已申请配资金额
			BigDecimal amount = usedAmount == null ? BigDecimal.ZERO : usedAmount;
			// 剩余额度
			BigDecimal validCredit = marginAmount.subtract(amount);

			model.put("fastSettleMargin", marginAmount); // 总额度
			model.put("validCredit", validCredit); // 剩余额度

			// 查询当天是否是工作日
			String isWorkDay = withCapital4PromoterService.isWorkDay(new Date());
			int week = DateUtil.getToday2Week(new Date());
			// 手续费率
			BigDecimal withFundingFeeRate = BigDecimal.ZERO;
			if ("1".equals(isWorkDay)) {
				withFundingFeeRate = MerchantCreditConstant.WITH_FUNDING_WORKDAY_FEE;
			} else if ("0".equals(isWorkDay)) {
				withFundingFeeRate = MerchantCreditConstant.WITH_FUNDING_RESTDAY_FEE;
			} else {
				if (week == 6 || week == 7) {
					withFundingFeeRate = MerchantCreditConstant.WITH_FUNDING_RESTDAY_FEE;
				} else {
					withFundingFeeRate = MerchantCreditConstant.WITH_FUNDING_WORKDAY_FEE;
				}
			}
			model.put("withFundingFeeRate", withFundingFeeRate);
			// 初始化密码
			payPwdInit(model);
		} catch (Exception e) {
			log.error(e.getMessage(), e);
		}
		return "/main/withfunding/index";
	}

	//@RequestMapping(value = { "/funding/apply" })
	public String applyWithFunding(ApplyWithFundingReqDTO dto, HttpServletRequest request, HttpServletResponse response) throws IOException {
		Map<String, Object> maps = new HashMap<String, Object>();
		try {
			MCMerchantUser user = MCMerchantUser.getMCMerchantUser(request.getSession());
			// 代理商在线申请配资的时间为：每日8:00AM～15:00PM，其余时间不可申请配资；T日申请的额度，在T+1日的8:00AM恢复（即可再次申请）
			Date now = new Date();
			Date startTime = DateUtil.getSpecialDate(now, applyStartTime, 0, 0);
			Date endTime = DateUtil.getSpecialDate(now, applyEndTime, 0, 0);
			boolean bl = DateUtil.isValidate(new Date(), startTime, endTime);
			if (!bl) {
				maps.put(MESSAGE, "配资申请时段为：8：00-15：00");
				billReturnObject(response, Result.FAILURE.getState(), maps);
				return null;
			}
			// 查询代理商信息
			PromoterInfoDTO promoterInfoDTO = mspFacade.findPromoterInfoByPromoterId(user.getPromoterId());
			if (promoterInfoDTO == null) {
				maps.put(MESSAGE, "代理商不存在");
				billReturnObject(response, Result.FAILURE.getState(), maps);
				return null;
			}
			// 查询通用开户 状态
			BizApplyOpenAccountDO bizApplyOpenAccount = bizApplyOpenAccountManager.getByPromoterIdAndAccountType(user.getPromoterId(),
					AccountType.CREDIT_ACCOUNT);
			if (bizApplyOpenAccount == null
					|| (bizApplyOpenAccount != null && BizApplyOpenAccountStatusEnum.OPEN_ACCOUNT_SUCCESS.code != bizApplyOpenAccount.getStatus())) {
				maps.put(MESSAGE, "代理商未开通配资功能，请联系客服开通配资功能");
				billReturnObject(response, Result.FAILURE.getState(), maps);
				return null;
			}
			// 验证支付密码
			ErrorMessageVO errorMessage = checkSecPwd(user.getMemberId(), user.getDisplayUserName(), user.getOperatorId(), dto.getPassword(),
					dto.getEncryptedKey(), dto.getCertSerialNo(), AccountType.B_BASE_ACCOUNT, request);

			if (!errorMessage.isSuccess()) {
				maps.put(MESSAGE, errorMessage.getErrorMessage());
				billReturnObject(response, Result.FAILURE.getState(), maps);
				return null;
			}
			// 保证金金额
			String fastSettleMargin = promoterInfoDTO.getFastSettleMargin();
			BigDecimal marginAmount = new BigDecimal(fastSettleMargin);
			// 最高配资不超过50万
			BigDecimal maxMarginAmount = new BigDecimal("500000");
			if (marginAmount.compareTo(maxMarginAmount) > 0) {
				marginAmount = maxMarginAmount;
			}
			BigDecimal usedAmount = withCapital4PromoterService.queryWithCapital4Promoter(user.getPromoterId());
			// 已申请配资金额
			BigDecimal amount = usedAmount == null ? BigDecimal.ZERO : usedAmount;
			// 剩余额度
			BigDecimal validCredit = marginAmount.subtract(amount);
			// 申请配资金额
			BigDecimal fundingAmount = new BigDecimal(dto.getFundingAmount());
			if (fundingAmount.compareTo(BigDecimal.ZERO) <= 0) {
				maps.put(MESSAGE, "配资额度填写金额需大于0");
				billReturnObject(response, Result.FAILURE.getState(), maps);
				return null;
			}
			if (fundingAmount.compareTo(validCredit) > 0) {
				maps.put(MESSAGE, "配资额度金额需不高于当日剩余可用额度");
				billReturnObject(response, Result.FAILURE.getState(), maps);
				return null;
			}
			// 计算手续费
			BigDecimal fee = BigDecimal.ZERO;

			// 查询当天是否是工作日
			String isWorkDay = withCapital4PromoterService.isWorkDay(new Date());
			int week = DateUtil.getToday2Week(new Date());
			// 手续费率
			BigDecimal withFundingFeeRate = BigDecimal.ZERO;
			if ("1".equals(isWorkDay)) {
				withFundingFeeRate = MerchantCreditConstant.WITH_FUNDING_WORKDAY_FEE;
			} else if ("0".equals(isWorkDay)) {
				withFundingFeeRate = MerchantCreditConstant.WITH_FUNDING_RESTDAY_FEE;
			} else {
				if (week == 6 || week == 7) {
					withFundingFeeRate = MerchantCreditConstant.WITH_FUNDING_RESTDAY_FEE;
				} else {
					withFundingFeeRate = MerchantCreditConstant.WITH_FUNDING_WORKDAY_FEE;
				}
			}

			fee = fundingAmount.multiply(withFundingFeeRate).divide(new BigDecimal("100")).setScale(2, RoundingMode.FLOOR);
			// 验证商户基本户状态、余额
			MerchantBalanceDTO account = AccountQueryFacadeWrapper.queryMerchantBalance(user.getMemberId(),promoterInfoDTO.getPromoterType());
			if (account == null || account.getPublicAccountStatus() != AccountStatus.AccountStatusActive.getCode()) {
				maps.put(MESSAGE, "对不起，您的钱包状态异常，无法完成本次配资操作，请联系客服查询钱包状态");
				billReturnObject(response, Result.FAILURE.getState(), maps);
				return null;
			} else if (account.getPublicAccountBalance().compareTo(fee) <= 0) {
				maps.put(MESSAGE, "对不起，您钱包余额不足，无法完成本次配资操作。请先充值或调整本次配资额度。");
				billReturnObject(response, Result.FAILURE.getState(), maps);
				return null;
			}
			// 保证金账户状态
			if (account == null || account.getMarginAccountStatus() != AccountStatus.AccountStatusActive.getCode()) {
				maps.put(MESSAGE, "对不起，您的保证金账户状态异常，无法完成本次配资操作，请联系客服查询保证金账户状态");
				billReturnObject(response, Result.FAILURE.getState(), maps);
				return null;
			}
			// 配资授信账户状态
			if (account == null || account.getCreditAccountStatus() != AccountStatus.AccountStatusActive.getCode()) {
				maps.put(MESSAGE, "对不起，您的配资授信账户状态异常，无法完成本次配资操作，请联系客服查询配资授信账户状态");
				billReturnObject(response, Result.FAILURE.getState(), maps);
				return null;
			}
			// 记录配资信息
			String batchNo = UUID.randomUUID().toString().replaceAll("-", "");
			Long id = withCapital4PromoterService.insert(toWithCapital4PromoterDO(user, dto, batchNo));
			if (id != null) {
				// 发起转账
				CreditTransferRequestDTO transferDTO = new CreditTransferRequestDTO();
				transferDTO.setBatchNo(batchNo);
				transferDTO.setPromoterMemberId(user.getMemberId());
				transferDTO.setPromoterCreditAccountId(account.getCreditAccountId());
				transferDTO.setPromoterPublicAccountId(account.getPublicAccountId());
				transferDTO.setCreditAmount(fundingAmount);
				transferDTO.setFee(fee);

				List<RemitTransferResponseDTO> transferList = FOSFacade.transfer4Credit(transferDTO);
				if (transferList != null && !transferList.isEmpty()) {
					Long creditFosId = null;// fos授信转账id
					Long feeFosId = null;// fos手续费转账id
					for (RemitTransferResponseDTO remitTransferResponseDTO : transferList) {
						if (remitTransferResponseDTO.isFee()) {
							feeFosId = remitTransferResponseDTO.getMarginTransId();
						} else {
							creditFosId = remitTransferResponseDTO.getMarginTransId();
						}
					}
					if (transferList.get(0).isSuccess() && transferList.get(1).isSuccess()) {
						// 调msp更新代理商配置信息（保证金额度、快速结算可用额度）
						MspModifyRequest mspModifyRequest = new MspModifyRequest();
						BigDecimal fastSettleLimit = new BigDecimal(promoterInfoDTO.getFastSettleLimit()).add(fundingAmount);
						mspModifyRequest.setFastSettleLimit(fastSettleLimit.toString());
						mspModifyRequest.setObjType(OpObjTypeEnums.PROMOTER.code);
						mspModifyRequest.setObjId(user.getPromoterId());
						mspModifyRequest.setPromoterId(user.getPromoterId());
						mspModifyRequest.setPromoterNo(user.getMerchantNo());
						mspModifyRequest.setPromoterType(promoterInfoDTO.getPromoterType());
						mspModifyRequest.setOpType(OpTypeEnums.PROMOTER_WITHCAPITAL_APPLY.code);
						// 记录变更
						long fcmId=0l;
						try {
							String operatorId = user.getAdminLoginName();
							fcmId = mspFacade.createFsconfigChange(mspModifyRequest,operatorId);
						} catch (FastSettleLimitException e) {
							maps.put(MESSAGE, e.getMessage());
							billReturnObject(response, Result.ERROR.getState(), maps);
							return null;
						}
						ErrorMessageVO error = mspFacade.modifyFastSettleConfig2Msp(mspModifyRequest, fcmId);
						Integer status = error.isSuccess() ? WithCapitalEnums.MSP_FAST_SETTLE_LIMIT_ADD_SUCCESS.getCode()
								: WithCapitalEnums.MSP_FAST_SETTLE_LIMIT_ADD_FAILURE.getCode();

						FsConfigChangeDO fsConfigChangeDO = fsConfigChangeManager.selectByPrimaryKey(fcmId);
						// 更新申请配资记录信息
						withCapital4PromoterService.updateByPrimaryKeySelective(id, creditFosId, feeFosId, batchNo, fcmId, status);
						if (error.isSuccess()) {
							fsConfigChangeDO.setUpdateTime(new Date());
							fsConfigChangeDO.setStatus(FsConfigChangeStatusEnum.SUCCESS.code);
							int rows = this.fsConfigChangeManager.updateByPrimaryKeySelective(fsConfigChangeDO);
							log.info("ApplyWithFundingAction.applyWithFunding.fcmId=" + fcmId + ",rows=" + rows);
							billReturnObject(response, Result.OK.getState(), maps);
							return null;
						} else {
							fsConfigChangeDO.setUpdateTime(new Date());
							fsConfigChangeDO.setStatus(FsConfigChangeStatusEnum.FAILUE.code);
							int rows = this.fsConfigChangeManager.updateByPrimaryKeySelective(fsConfigChangeDO);
							log.info("ApplyWithFundingAction.applyWithFunding.fcmId=" + fcmId + ",rows=" + rows);
							maps.put(MESSAGE, "系统异常，您可联系客服电话021-0989-99反馈问题，我们将第一时间为您处理。");
							billReturnObject(response, Result.ERROR.getState(), maps);
							return null;
						}
					} else {
						// 更新申请配资记录信息
						withCapital4PromoterService.updateByPrimaryKeySelective(id, creditFosId, feeFosId, batchNo, null,
								WithCapitalEnums.FOS_TRANSFER_FAIL.getCode());
						maps.put(MESSAGE, "配资申请失败");
						billReturnObject(response, Result.ERROR.getState(), maps);
						return null;
					}
				} else {
					withCapital4PromoterService.updateByPrimaryKeySelective(id, null, null, batchNo, null,
							WithCapitalEnums.FOS_TRANSFER_FAIL.getCode());
					maps.put(MESSAGE, "网络繁忙，多次尝试后请联系客服");
					billReturnObject(response, Result.ERROR.getState(), maps);
					return null;
				}
			}
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			maps.put(MESSAGE, "网络繁忙，多次尝试后请联系客服");
			billReturnObject(response, Result.ERROR.getState(), maps);
		}
		billReturnObject(response, Result.OK.getState(), maps);
		return null;
	}

	@RequestMapping(value = { "/funding/agree" })
	public String agree(ModelMap model, HttpServletRequest request, HttpServletResponse response) throws IOException {
		return "/main/withfunding/agree";
	}

	private void billReturnObject(HttpServletResponse response, int code, Map<String, Object> obj) {
		ReturnObj returnObj = new ReturnObj();
		returnObj.setCode(code);
		returnObj.setResult(obj);
		RequestUtils.writeJson(response, returnObj);
	}

	private WithCapital4PromoterDO toWithCapital4PromoterDO(MCMerchantUser user, ApplyWithFundingReqDTO dto, String batchNo) {
		WithCapital4PromoterDO record = new WithCapital4PromoterDO();
		record.setMcType(user.getCurrentMcType());
		record.setBatchNo(batchNo);
		record.setPromoterId(user.getPromoterId());
		record.setMerchantNo(user.getMerchantNo());
		if (user.getIsMposPromoterType()) {
			record.setPromoterName(user.getMposPromoterMerchantName());
		} else if (user.getIsPosPromoterType()) {
			record.setPromoterName(user.getPosPromoterMerchantName());
		}

		record.setApplyDatetime(new Date());
		record.setUpdateTime(new Date());
		record.setAmount(new BigDecimal(dto.getFundingAmount()));
		record.setFeeRatio(dto.getWithFundingFeeRate());
		record.setFee(new BigDecimal(dto.getFundingFee()));
		record.setStatus(WithCapitalEnums.INIT.getCode());
		record.setRecoveryDate(getRecoveryDate(new Date()));
		record.setRetryTimes4msp(0);
		return record;
	}

	// 恢复配资额度日期=下一个工作日。节假日的定义：法定节假日，及周5，周6。（依据pos收单的节假日标准）
	private Date getRecoveryDate(Date time) {
		// 先加一天
		Date nextDay = DateUtil.increaseDate(time, 1);
		// 这一天是星期几
		int week = DateUtil.getToday2Week(nextDay);
		// 是否可以查到结果
		String isWorkDay = withCapital4PromoterService.isWorkDay(nextDay);
		// 查到记录并且0非工作日
		if (isWorkDay != null && "0".equals(isWorkDay)) {
			return getRecoveryDate(nextDay);

		}
		// 查到记录并且1工作日
		else if (isWorkDay != null && "1".equals(isWorkDay)) {
			return nextDay;
		}
		// 没有查询到结果
		else {
			if (week == 6 || week == 7) {
				return getRecoveryDate(nextDay);
			} else {
				return nextDay;
			}
		}
	}
}
