package com.sdp.mc.service.apply.impl;

import java.math.BigDecimal;
import java.util.List;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sdp.mc.common.enums.AccountType;
import com.sdp.mc.common.enums.LoaningTypeEnum;
import com.sdp.mc.common.enums.MACreateAccountCodeEnums;
import com.sdp.mc.common.enums.OpObjTypeEnums;
import com.sdp.mc.common.enums.OpOpenAndCloseEnums;
import com.sdp.mc.common.enums.OpTypeEnums;
import com.sdp.mc.common.util.IPUtils;
import com.sdp.mc.common.vo.ErrorMessageVO;
import com.sdp.mc.common.web.MCMerchantUser;
import com.sdp.mc.integration.ma.dto.Promoter4MADTO;
import com.sdp.mc.integration.msp.PromoterInfoDTO;
import com.sdp.mc.integration.msp.request.MspModifyRequest;
import com.sdp.mc.ma.dao.MarginAccountRequestDO;
import com.sdp.mc.ma.dao.MarginAccountRequestDOExample;
import com.sdp.mc.ma.manager.MarginAccountRequestManager;
import com.sdp.mc.ma.wrapper.MaOnlineWrapper;
import com.sdp.mc.promoter.dao.PromoterFastSettleSwitchDO;
import com.sdp.mc.service.AuditInfoService;
import com.sdp.mc.service.apply.FastSettleApply;
import com.sdp.mc.service.apply.PromoterFastSettleSwitch;
import com.sdp.mc.service.newt0.Newt0PromoterService;
import com.sdp.mc.service.op.OpService;
import com.sdp.mc.service.op.state.OpContext;
import com.sdp.mc.service.op.state.OpStateResponse;
import com.sdp.withdraw.enums.PosMerchantTypeEnums;

@Service("FastSettleApply")
public class FastSettleApplyImpl implements FastSettleApply {
	private static final Logger log = LoggerFactory.getLogger(FastSettleApplyImpl.class);

	@Autowired
	private OpService opService;

	@Autowired
	private PromoterFastSettleSwitch promoterFastSettleSwitch;

	@Autowired
	private MaOnlineWrapper maOnlineWrapper;

	@Autowired
	private AuditInfoService auditInfoService;

	@Autowired
	private Newt0PromoterService newt0PromoterService;
	@Autowired
	private MarginAccountRequestManager marginAccountRequestManager;

	/**
	 * 代理商申请开通快速结算
	 *
	 * @param user
	 * @param pfrId
	 *            代理商快速结算 开通/关闭id
	 * @param userIp
	 * **/
	public OpStateResponse applyOpen(MCMerchantUser user, Long pfrId, String userIp, String operatorId, String promoterType, Long promoterId) {
		MspModifyRequest request = new MspModifyRequest();

		request.setObjId(promoterId);
		request.setObjType(OpObjTypeEnums.PROMOTER.code);
		request.setOpType(OpTypeEnums.OPEN.code);
		request.setPromoterId(promoterId);
		request.setPromoterNo(user.getMerchantNo());
		// 开通MerchantCreditConstant.FAST_SETTLE_FLAG_OPEN
		request.setPromoterType(promoterType);
		request.setFastSettleFlag(1);
		OpContext context = new OpContext();
		context.setOpType(OpTypeEnums.OPEN.code);
		context.setPromoterId(promoterId);
		context.setPromoterNo(user.getMerchantNo());
		context.setMerchantMemberId(user.getMemberId());
		context.setOperatorId(user.getOperatorId());
		context.setPromoterType(promoterType);
		// pfrId不是null表示再次开通
		context.setBizId(pfrId);
		context.setUserIp(userIp);
		context.setMspModifyRequest(request);
		log.info("FastSettleApplyImpl.applyOpen.request=" + ToStringBuilder.reflectionToString(request));

		PromoterFastSettleSwitchDO pswitch = this.promoterFastSettleSwitch.queryPromoterFastSettleSwitchByPromoterId(promoterId);
		OpStateResponse response = null;
		if (pswitch != null) {
			context.setBizId(pswitch.getPfrId());
			if (pswitch.getStatus() == OpOpenAndCloseEnums.ACCOUNT_FAILURE.getCode()) {
				// 开户失败走OpenInitState--reopen操作
				response = this.opService.handler(context, OpOpenAndCloseEnums.INIT.getCode(), operatorId);
				log.info("FastSettleApplyImpl.account.failure.reopen.applyOpen.response=" + ToStringBuilder.reflectionToString(response));
			} else if (pswitch.getStatus() == OpOpenAndCloseEnums.CONFIGURE_FAILURE.getCode()) {
				// 配置失败和成功重新走OpAccountSuccessState流程，reopen操作
				response = this.opService.handler(context, OpOpenAndCloseEnums.ACCOUNT_SUCCESS.getCode(), operatorId);
				log.info("FastSettleApplyImpl.configuration.failue.reopen.applyOpen.response=" + ToStringBuilder.reflectionToString(response));
			} else if (pswitch.getStatus() == OpOpenAndCloseEnums.CLOSE_CONFIGURE_SUCCESS.getCode()) {
				// 重新开通重新走OpAccountSuccessState流程，reopen操作
				response = this.opService.handler(context, OpOpenAndCloseEnums.ACCOUNT_SUCCESS.getCode(), operatorId);
				log.info("FastSettleApplyImpl.close_configure_success.reopen.applyOpen.response=" + ToStringBuilder.reflectionToString(response));
			} else {
				response = new OpStateResponse();
				response.setErrorCode("-1");
				response.setSuccess(false);
				response.setMessage("状态不正确");
				log.info("FastSettleApplyImpl.reopen.status.is.incorrect.applyOpen.response=" + ToStringBuilder.reflectionToString(response));
			}
		} else {
			// 首次开户操作
			log.info("FastSettleApplyImpl.first.applyOpen.response=" + ToStringBuilder.reflectionToString(response));
			response = this.opService.handler(context, OpOpenAndCloseEnums.INIT.getCode(), operatorId);
		}
		if (response != null && MACreateAccountCodeEnums.error_295.code.equalsIgnoreCase(response.getErrorCode())) {
			response.setMessage(MACreateAccountCodeEnums.error_295.desc);
		}
		return response;
	}

	/**
	 * 代理商申请关闭快速结算
	 *
	 * @param user
	 * @param pfrId
	 *            代理商快速结算 开通/关闭id
	 * @param userIp
	 * **/
	public OpStateResponse applyClose(MCMerchantUser user, Long pfrId, String userIp, String operatorId, String promoterType, Long promoterId) {
		MspModifyRequest request = new MspModifyRequest();
		request.setObjId(promoterId);
		request.setObjType(OpObjTypeEnums.PROMOTER.code);
		request.setOpType(OpTypeEnums.CLOSE.code);
		request.setPromoterId(promoterId);
		request.setPromoterNo(user.getMerchantNo());
		request.setPromoterType(promoterType);
		// 关闭
		request.setFastSettleFlag(0);
		request.setFastSettleLimit("0"); // 关闭快速结算 将额度修改0
		OpContext context = new OpContext();
		context.setOpType(OpTypeEnums.CLOSE.code);
		context.setPromoterId(promoterId);
		context.setPromoterNo(user.getMerchantNo());
		context.setMerchantMemberId(user.getMemberId());
		context.setOperatorId(user.getOperatorId());
		// pfrId不是null表示关闭
		context.setBizId(pfrId);
		context.setUserIp(userIp);
		context.setMspModifyRequest(request);
		context.setPromoterType(promoterType);
		PromoterFastSettleSwitchDO pswitch = this.promoterFastSettleSwitch.queryPromoterFastSettleSwitchById(pfrId);
		OpStateResponse response = new OpStateResponse();
		if (pswitch != null) {
			log.info("FastSettleApplyImpl.applyClose.request=" + ToStringBuilder.reflectionToString(request));
			if (pswitch.getStatus() == OpOpenAndCloseEnums.CONFIGURE_SUCCESS.getCode()) {
				// 首次调用关闭
				response = this.opService.handler(context, OpOpenAndCloseEnums.CONFIGURE_SUCCESS.getCode(), operatorId);
				log.info("FastSettleApplyImpl.first.close.applyClose.response=" + ToStringBuilder.reflectionToString(response));
			} else if (pswitch.getStatus() == OpOpenAndCloseEnums.CLOSE_INIT.getCode()) {
				// 关闭失败，运营人员再次关闭时走OpAccountSuccessState流程，reclose操作
				response = this.opService.handler(context, OpOpenAndCloseEnums.CLOSE_INIT.getCode(), operatorId);
				log.info("FastSettleApplyImpl.closeFailure.reclose.applyClose.response=" + ToStringBuilder.reflectionToString(response));
			} else {
				response.setErrorCode("-1");
				response.setSuccess(false);
				response.setMessage("状态不正确");
				log.info("FastSettleApplyImpl.close.status.is.incorrect.applyClose1.response=" + ToStringBuilder.reflectionToString(response));
			}
		} else {
			response.setErrorCode("-1");
			response.setSuccess(false);
			response.setMessage("状态不正确");
			log.info("FastSettleApplyImpl.close.status.is.incorrect.applyClose2.response=" + ToStringBuilder.reflectionToString(response));
		}
		// 关闭删除垫资方
		if (response.isSuccess()) {
			int rows = newt0PromoterService.deleteByPromoterId(promoterId);
			log.info("FastSettleApplyImpl.close.status.is.incorrect.applyClose2.deleteByPromoterId.promoterId=" + promoterId + ",rows=" + rows);
		}
		return response;
	}

	public ErrorMessageVO applyOpen4Intra(String promoterNo, long promoterId, String promoterType, String operatorId) {
		log.info("applyOpen4Intra init,promoterNo:{},promoterId:{},promoterType:{}, operatorId:{}", new Object[] { promoterNo, promoterId,
				promoterType, operatorId });
		try {
			Promoter4MADTO promoterInfo = this.maOnlineWrapper.queryPromoterInfoByMerchantNo(promoterNo);
			if (promoterInfo == null) { return new ErrorMessageVO(false, "-1", "查询代理商会员信息失败"); }
			PromoterFastSettleSwitchDO pswitch = this.promoterFastSettleSwitch.queryPromoterFastSettleSwitchByPromoterId(promoterId);

			MspModifyRequest request = new MspModifyRequest();
			request.setObjId(promoterId);
			request.setObjType(OpObjTypeEnums.PROMOTER.code);
			request.setOpType(OpTypeEnums.OPEN.code);
			request.setPromoterId(promoterId);
			request.setPromoterNo(promoterNo);
			// 开通MerchantCreditConstant.FAST_SETTLE_FLAG_OPEN
			request.setPromoterType(promoterType);
			request.setFastSettleFlag(1);
			OpContext context = new OpContext();
			context.setOpType(OpTypeEnums.OPEN.code);
			context.setPromoterId(promoterId);
			context.setPromoterNo(promoterNo);
			context.setMerchantMemberId(promoterInfo.getMemberId());
			context.setOperatorId(promoterInfo.getDefaultOperatorId());
			context.setPromoterType(promoterType);
			// pfrId不是null表示再次开通
			context.setBizId(pswitch != null ? pswitch.getPfrId() : null);
			context.setUserIp(IPUtils.getLocalIp());
			context.setMspModifyRequest(request);
			log.info("FastSettleApplyImpl.applyOpen4Intra.request=" + ToStringBuilder.reflectionToString(request));
			OpStateResponse response = null;
			if (pswitch != null) {
				context.setBizId(pswitch.getPfrId());
				if (pswitch.getStatus() == OpOpenAndCloseEnums.ACCOUNT_FAILURE.getCode()) {
					// 开户失败走OpenInitState--reopen操作
					response = this.opService.handler(context, OpOpenAndCloseEnums.INIT.getCode(), operatorId);
					log.info("FastSettleApplyImpl.applyOpen4Intra.failure.reopen.applyOpen.response=" + ToStringBuilder.reflectionToString(response));
				} else if (pswitch.getStatus() == OpOpenAndCloseEnums.CONFIGURE_FAILURE.getCode()) {
					// 配置失败和成功重新走OpAccountSuccessState流程，reopen操作
					response = this.opService.handler(context, OpOpenAndCloseEnums.ACCOUNT_SUCCESS.getCode(), operatorId);
					log.info("FastSettleApplyImpl.applyOpen4Intra.configuration.failue.reopen.applyOpen.response="
							+ ToStringBuilder.reflectionToString(response));
				} else if (pswitch.getStatus() == OpOpenAndCloseEnums.CLOSE_CONFIGURE_SUCCESS.getCode()) {
					// 重新开通重新走OpAccountSuccessState流程，reopen操作
					response = this.opService.handler(context, OpOpenAndCloseEnums.ACCOUNT_SUCCESS.getCode(), operatorId);
					log.info("FastSettleApplyImpl.applyOpen4Intra.close_configure_success.reopen.applyOpen.response="
							+ ToStringBuilder.reflectionToString(response));
				} else {
					MarginAccountRequestDO reqDo = getSuccessAccountRequestDO(pswitch.getMarginMemberId(),promoterType);
					if (reqDo != null) {
						response = new OpStateResponse();
						response.setErrorCode("-1");
						response.setSuccess(false);
						response.setMessage("状态不正确");
						log.info("FastSettleApplyImpl.applyOpen4Intra.reopen.status.is.incorrect.applyOpen.response="
								+ ToStringBuilder.reflectionToString(response));
					}else{//重新开户
						response = this.opService.handler(context, OpOpenAndCloseEnums.INIT.getCode(), operatorId);
					}
				}
			} else {
				// 首次开户操作
				log.info("FastSettleApplyImpl.applyOpen4Intra.first.applyOpen.response=" + ToStringBuilder.reflectionToString(response));
				response = this.opService.handler(context, OpOpenAndCloseEnums.INIT.getCode(), operatorId);
			}
			if (response != null) {
				if (MACreateAccountCodeEnums.error_295.code.equalsIgnoreCase(response.getErrorCode())) {
					response.setMessage("很抱歉，该账户为个人商户，不能开通快速结算账户");
				}
				return new ErrorMessageVO(response.isSuccess(), response.getErrorCode(), response.getMessage());
			}
		} catch (Exception e) {
			log.error("FastSettleApplyImpl.applyOpen4Intra.error,promoterNo=" + promoterNo, e);
		}
		return new ErrorMessageVO(false, "-1", "系统繁忙");
	}

	@Override
	public MarginAccountRequestDO getSuccessAccountRequestDO(String memberId, long accountType) {
		MarginAccountRequestDOExample example = new MarginAccountRequestDOExample();
		example.createCriteria().andMemberIdEqualTo(memberId).andAccountTypeEqualTo(accountType).andResponseCodeEqualTo("0");
		List<MarginAccountRequestDO> list = marginAccountRequestManager.selectByExample(example);
		if (list != null && list.size() > 0) { return list.get(0); }
		return null;
	}

	@Override
	public MarginAccountRequestDO getSuccessAccountRequestDO(String memberId, String promoterType) {
		AccountType accountType = PosMerchantTypeEnums.EASYPAY_PROMOTER.code.equals(promoterType) ? AccountType.MARGIN_ACCOUNT_EASYPAY
				: PosMerchantTypeEnums.MPOS_PROMOTER.code.equals(promoterType) ? AccountType.MARGIN_ACCOUNT_MPOS : AccountType.MARGIN_ACCOUNT;
		return getSuccessAccountRequestDO(memberId, accountType.code);
	}

	public ErrorMessageVO applyClose4Intra(PromoterInfoDTO promoterDTO, String operatorId) {
		try {
			LoaningTypeEnum loaningType = LoaningTypeEnum.getLoaningTypeEnum(newt0PromoterService.getLoaningTypeByPromoterId(promoterDTO
					.getPromoterId()));
			if (loaningType == null || LoaningTypeEnum.SHENGPAY == loaningType) {
				boolean b = auditInfoService.hasNonAudited(null, promoterDTO.getPromoterId(), OpTypeEnums.ADD.getCode());// 追加通过追加状态判断
				if (b) {// 存在审核中的
					return new ErrorMessageVO(false, "-1", "正在审核中，暂不能关闭快速结算。");
				}
			}
			// BigDecimal margin = new
			// BigDecimal(promoterDTO.getFastSettleMargin());
			// if (margin.compareTo(new BigDecimal(0)) != 0) {
			// return new ErrorMessageVO(false, "-1",
			// "保证金余额不为0，请先取回保证金再进行关闭操作");
			// }
			Promoter4MADTO promoterInfo = this.maOnlineWrapper.queryPromoterInfoByMerchantNo(promoterDTO.getPromoterNo() + "");
			if (promoterInfo == null) { return new ErrorMessageVO(false, "-1", "查询代理商会员信息失败"); }
			PromoterFastSettleSwitchDO pswitch = this.promoterFastSettleSwitch.queryPromoterFastSettleSwitchByPromoterId(promoterDTO.getPromoterId());

			MspModifyRequest request = new MspModifyRequest();
			request.setObjId(promoterDTO.getPromoterId());
			request.setObjType(OpObjTypeEnums.PROMOTER.code);
			request.setOpType(OpTypeEnums.CLOSE.code);
			request.setPromoterId(promoterDTO.getPromoterId());
			request.setPromoterNo(promoterDTO.getPromoterNo());
			// 关闭
			request.setFastSettleFlag(0);
			request.setFastSettleLimit("0");// 关闭快速结算 额度归 0
			OpContext context = new OpContext();
			context.setOpType(OpTypeEnums.CLOSE.code);
			context.setPromoterId(promoterDTO.getPromoterId());
			context.setPromoterNo(promoterDTO.getPromoterNo());
			context.setPromoterType(promoterDTO.getPromoterType());

			context.setMerchantMemberId(promoterInfo.getMemberId());
			context.setOperatorId(promoterInfo.getDefaultOperatorId());
			// pfrId不是null表示关闭
			context.setBizId(pswitch != null ? pswitch.getPfrId() : null);
			context.setUserIp(IPUtils.getLocalIp());
			context.setMspModifyRequest(request);

			OpStateResponse response = null;
			if (pswitch != null) {
				log.info("FastSettleApplyImpl.applyClose4Intra.request=" + ToStringBuilder.reflectionToString(request));
				if (pswitch.getStatus() == OpOpenAndCloseEnums.CONFIGURE_SUCCESS.getCode()) {
					// 首次调用关闭
					response = this.opService.handler(context, OpOpenAndCloseEnums.CONFIGURE_SUCCESS.getCode(), operatorId);
					log.info("FastSettleApplyImpl.applyClose4Intra.first.close.applyClose.response=" + ToStringBuilder.reflectionToString(response));
				} else if (pswitch.getStatus() == OpOpenAndCloseEnums.CLOSE_INIT.getCode()) {
					// 关闭失败，运营人员再次关闭时走OpAccountSuccessState流程，reclose操作
					response = this.opService.handler(context, OpOpenAndCloseEnums.CLOSE_INIT.getCode(), operatorId);
					log.info("FastSettleApplyImpl.applyClose4Intra.closeFailure.reclose.applyClose.response="
							+ ToStringBuilder.reflectionToString(response));
				} else if (pswitch.getStatus() == OpOpenAndCloseEnums.CLOSE_CONFIGURE_FAILURE.getCode()) {
					// 关闭失败，运营人员再次关闭时走OpAccountSuccessState流程，reclose操作
					response = this.opService.handler(context, OpOpenAndCloseEnums.CLOSE_INIT.getCode(), operatorId);
					log.info("FastSettleApplyImpl.applyClose4Intra.closeFailure.reclose.applyClose.response="
							+ ToStringBuilder.reflectionToString(response));
				} else {

					response = new OpStateResponse();
					response.setErrorCode("-1");
					response.setSuccess(false);
					response.setMessage("状态不正确");
					log.info("FastSettleApplyImpl.applyClose4Intra.status.is.incorrect.applyClose1.response="
							+ ToStringBuilder.reflectionToString(response));
				}
			} else {
				response = new OpStateResponse();
				response.setErrorCode("-1");
				response.setSuccess(false);
				response.setMessage("状态不正确");
				log.info("FastSettleApplyImpl.applyClose4Intra.status.is.incorrect.applyClose2.response="
						+ ToStringBuilder.reflectionToString(response));
			}
			// 关闭删除垫资方
			if (response.isSuccess()) {
				int rows = newt0PromoterService.deleteByPromoterId(promoterDTO.getPromoterId());
				log.info("FastSettleApplyImpl.applyClose4Intra.status.is.incorrect.applyClose2.deleteByPromoterId.promoterId="
						+ promoterDTO.getPromoterId() + ",rows=" + rows);
			}
			return new ErrorMessageVO(response.isSuccess(), response.getErrorCode(), response.getMessage());
		} catch (Exception e) {
			log.error("FastSettleApplyImpl.applyClose4Intra.error,promoterDTO=" + ToStringBuilder.reflectionToString(promoterDTO), e);
		}
		return new ErrorMessageVO(false, "-1", "系统繁忙");
	}
}
