package com.sdp.mc.service.op.state.openandclose;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.slf4j.Logger;import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sdp.mc.common.enums.AccountType;
import com.sdp.mc.common.enums.OpOpenAndCloseEnums;
import com.sdp.mc.common.enums.OpTypeEnums;
import com.sdp.mc.ma.dao.MarginAccountRequestDO;
import com.sdp.mc.promoter.dao.PromoterFastSettleSwitchDO;
import com.sdp.mc.service.apply.FastSettleApply;
import com.sdp.mc.service.apply.PromoterFastSettleSwitch;
import com.sdp.mc.service.op.state.BaseOpState;
import com.sdp.mc.service.op.state.OpContext;
import com.sdp.mc.service.op.state.OpState;
import com.sdp.mc.service.op.state.OpStateResponse;
import com.sdp.withdraw.enums.PosMerchantTypeEnums;
import com.shengpay.facade.ma.MACreateAccountVO;
import com.shengpay.facade.ma.MAFacade;

@Service("OpenInitState")
public class OpenInitState extends BaseOpState implements OpState {
	private static final Logger log = LoggerFactory.getLogger(OpenInitState.class);

	@Autowired
	private PromoterFastSettleSwitch promoterFastSettleSwitch;

	@Autowired 
	private MAFacade maFacade;
	@Autowired 
	private FastSettleApply fastSettleApply;

	public int handlerOpState(OpContext context,String operatorId) {
		int opType = context.getOpType();
		if (opType == OpTypeEnums.OPEN.getCode()) {
			return this.open(context);
		} else if (opType == OpTypeEnums.CLOSE.getCode()) {
			return this.close(context);
		}
		return OpState.failure;
	}

	public int changeState(OpContext context, int handlerOpStatus) {
		int opType = context.getOpType();
		if (opType == OpTypeEnums.OPEN.getCode() && handlerOpStatus == OpState.success) {
			return OpOpenAndCloseEnums.ACCOUNT_SUCCESS.getCode();
		} else if (opType == OpTypeEnums.CLOSE.getCode() && handlerOpStatus == OpState.success) {
			return OpOpenAndCloseEnums.CLOSE_INIT.getCode();
		}
		return -1;
	}

	/**
	 * 开通操作
	 * **/
	private int open(OpContext context) {
		PromoterFastSettleSwitchDO pswitch = this.promoterFastSettleSwitch.queryPromoterFastSettleSwitchByPromoterId(context.getPromoterId());
		AccountType accountType=PosMerchantTypeEnums.EASYPAY_PROMOTER.code.equals(context.getPromoterType())?
				                AccountType.MARGIN_ACCOUNT_EASYPAY:PosMerchantTypeEnums.MPOS_PROMOTER.code.equals(context.getPromoterType())?
				        		AccountType.MARGIN_ACCOUNT_MPOS:AccountType.MARGIN_ACCOUNT;
		if ((pswitch != null && pswitch.getStatus() == OpOpenAndCloseEnums.ACCOUNT_FAILURE.getCode()) || pswitch == null) {
			log.info("OpenInitState.open.only,ACCOUNT_FAILURE or first invoke this method can access");
		} else {
			MarginAccountRequestDO reqDo=fastSettleApply.getSuccessAccountRequestDO(pswitch.getMarginMemberId(),accountType.code);
			if(reqDo!=null){
			    throw new IllegalArgumentException("OpenInitState.open incorrect status 状态不正确,只有开户失败或者首次开户才能走此流程。。");
			}
		}
		log.info("OpenInitState.open.begin,context=" + ToStringBuilder.reflectionToString(context));
		final Long pfrId = pswitch != null ? pswitch.getPfrId() : this.promoterFastSettleSwitch.open(context);
		// 一定要设置
		context.setBizId(pfrId);
		// 落地开户记录并请求开户
		MACreateAccountVO errorMessage = this.maFacade.createAccount(context.getPromoterNo() + "", context.getMerchantMemberId(), context.getOperatorId(),accountType, context.getUserIp());
		log.info("OpenInitState.open.ma.createAccount,errorMessage=" + ToStringBuilder.reflectionToString(errorMessage));
		OpOpenAndCloseEnums targetStatus = errorMessage.isSuccess() ? OpOpenAndCloseEnums.ACCOUNT_SUCCESS : OpOpenAndCloseEnums.ACCOUNT_FAILURE;
		OpOpenAndCloseEnums originalStatus = pswitch == null ? OpOpenAndCloseEnums.ACCOUNT_OPENING :OpOpenAndCloseEnums.parse(pswitch.getStatus());
		boolean isOk = this.promoterFastSettleSwitch.updateMarginAccount(pfrId, originalStatus, targetStatus, errorMessage.getAccountId(), errorMessage.getBizAccountId());
		if (errorMessage.isSuccess()) {
			context.setOpStateResponse(OpStateResponse.genSuccessResponse(errorMessage.getErrorMessage()));
		} else {
			context.setOpStateResponse(OpStateResponse.genFailureResponse(errorMessage.getErrorCode(), "很抱歉，系统繁忙，请稍后再试，或致电盛付通客服400-720-8888"));
		}
		log.info("OpenInitState.open.finished.pfrId=" + pfrId + ",isOk=" + isOk);
		return errorMessage.isSuccess() ? OpState.success : OpState.failure;
	}

	/**
	 * 关闭操作
	 * **/
	private int close(OpContext context) {
		boolean isOk = this.promoterFastSettleSwitch.close(context.getBizId());
		if (!isOk) {
			context.setOpStateResponse(OpStateResponse.genFailureResponse("-1", "系统繁忙，关闭失败，请稍后再试或联系盛付通客服400-720-8888"));
		}
		return isOk ? OpState.success : OpState.failure;
	}
}
