package com.sdp.mc.service.op.state.openandclose;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.slf4j.Logger;import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sdp.mc.common.enums.FsConfigChangeStatusEnum;
import com.sdp.mc.common.enums.OpOpenAndCloseEnums;
import com.sdp.mc.common.enums.OpTypeEnums;
import com.sdp.mc.common.exception.FastSettleLimitException;
import com.sdp.mc.common.vo.ErrorMessageVO;
import com.sdp.mc.facade.msp.MspFacade;
import com.sdp.mc.promoter.dao.PromoterFastSettleSwitchDO;
import com.sdp.mc.service.apply.PromoterFastSettleSwitch;
import com.sdp.mc.service.op.state.BaseOpState;
import com.sdp.mc.service.op.state.OpContext;
import com.sdp.mc.service.op.state.OpState;
import com.sdp.mc.service.op.state.OpStateResponse;

@Service("OpAccountSuccessState")
public class OpAccountSuccessState extends BaseOpState implements OpState {
	private static final Logger log = LoggerFactory.getLogger(OpAccountSuccessState.class);
	@Autowired
	private PromoterFastSettleSwitch promoterFastSettleSwitch;
	@Autowired
	private MspFacade mspFacade;

	public int handlerOpState(OpContext context,String operatorId) {
		int opType = context.getOpType();
		PromoterFastSettleSwitchDO pswitch = this.promoterFastSettleSwitch.queryPromoterFastSettleSwitchByPromoterId(context.getPromoterId());
		if (opType == OpTypeEnums.OPEN.getCode()) {
			// 只有首次开户和配置更改失败会走入此分支
			OpOpenAndCloseEnums originalStatus = pswitch != null ? OpOpenAndCloseEnums.parse(pswitch.getStatus()) : OpOpenAndCloseEnums.ACCOUNT_SUCCESS;
			try {
				// 更改配置流水记录
				long fcmId=0l;
				try {
					fcmId = mspFacade.createFsconfigChange(context.getMspModifyRequest(),operatorId);
				} catch (FastSettleLimitException e) {
					context.setOpStateResponse(OpStateResponse.genFailureResponse("-1", e.getMessage()));
					return OpState.failure;
				}
				log.info("OpAccountSuccessState.handlerOpState.open.pfrid=" + context.getBizId() + ",fcmId=" + fcmId);
				ErrorMessageVO errorMessage = this.mspFacade.modifyFastSettleConfig2Msp(context.getMspModifyRequest(),fcmId);
				log.info("OpAccountSuccessState.handlerOpState.open.pfrid=" + context.getBizId() + ",fcmId=" + fcmId + ",msp.result="
						+ ToStringBuilder.reflectionToString(errorMessage));
				OpOpenAndCloseEnums targetStatus = errorMessage.isSuccess() ? OpOpenAndCloseEnums.CONFIGURE_SUCCESS : OpOpenAndCloseEnums.CONFIGURE_FAILURE;
				boolean isOk = this.promoterFastSettleSwitch.updateFcmIdAfterMarginConfigurationChanged(context.getBizId(), fcmId, originalStatus, targetStatus);
				if (!errorMessage.isSuccess() || !isOk) {
					// 修改变更记录表状态-失败
					mspFacade.modifyFsConfigChangeStatus(fcmId, FsConfigChangeStatusEnum.FAILUE.code);
					context.setOpStateResponse(OpStateResponse.genFailureResponse("-1", "很抱歉，系统繁忙，请稍后再试，或致电盛付通客服400-720-8888"));
				} else {
					// 修改变更记录表状态--成功
					mspFacade.modifyFsConfigChangeStatus(fcmId, FsConfigChangeStatusEnum.SUCCESS.code);
					context.setOpStateResponse(OpStateResponse.genSuccessResponse("恭喜您审核通过，快速结算已开通，请尽快完成保证金追加"));
				}
				return errorMessage.isSuccess() && isOk ? OpState.success : OpState.failure;
			} catch (Exception e) {
				log.error("OpAccountSuccessState.handlerOpState.open.error,pfrid=" + context.getBizId(), e);
				this.promoterFastSettleSwitch.updateFcmIdAfterMarginConfigurationChanged(context.getBizId(), null, originalStatus, OpOpenAndCloseEnums.CONFIGURE_FAILURE);
				context.setOpStateResponse(OpStateResponse.genFailureResponse("-1", "很抱歉，系统繁忙，请稍后再试，或致电盛付通客服400-720-8888"));
			}
		} else if (opType == OpTypeEnums.CLOSE.getCode()) {
			// 关闭初始化和关闭失败会走入此分支
			OpOpenAndCloseEnums originalStatus = pswitch != null ? OpOpenAndCloseEnums.parse(pswitch.getStatus()) : OpOpenAndCloseEnums.CLOSE_INIT;
			try {
				// 更配置流水记录
				long fcmId=0l;
				try {
					fcmId = mspFacade.createFsconfigChange(context.getMspModifyRequest(),operatorId);
				} catch (FastSettleLimitException e) {
					context.setOpStateResponse(OpStateResponse.genFailureResponse("-1", e.getMessage()));
					return OpState.failure;
				}
				log.info("OpAccountSuccessState.handlerOpState.close.pfrid=" + context.getBizId() + ",fcmId=" + fcmId);
				ErrorMessageVO errorMessage = this.mspFacade.modifyFastSettleConfig2Msp(context.getMspModifyRequest(),fcmId);
				log.info("OpAccountSuccessState.handlerOpState.close.pfrid=" + context.getBizId() + ",fcmId=" + fcmId + ",msp.result="
						+ ToStringBuilder.reflectionToString(errorMessage));
				OpOpenAndCloseEnums targetStatus = errorMessage.isSuccess() ? OpOpenAndCloseEnums.CLOSE_CONFIGURE_SUCCESS : OpOpenAndCloseEnums.CLOSE_CONFIGURE_FAILURE;
				boolean isOk = this.promoterFastSettleSwitch.updateFcmIdAfterMarginConfigurationChanged(context.getBizId(), fcmId, originalStatus, targetStatus);
				if (!errorMessage.isSuccess() || !isOk) {
					// 修改变更记录表状态-失败
					mspFacade.modifyFsConfigChangeStatus(fcmId, FsConfigChangeStatusEnum.FAILUE.code);
					context.setOpStateResponse(OpStateResponse.genFailureResponse("-1", "系统繁忙，关闭失败，请稍后再试或联系盛付通客服400-720-8888"));
				} else {
					// 修改变更记录表状态--成功
					mspFacade.modifyFsConfigChangeStatus(fcmId, FsConfigChangeStatusEnum.SUCCESS.code);
					context.setOpStateResponse(OpStateResponse.genSuccessResponse("操作成功，您的快速结算服务已关闭"));
				}
				return errorMessage.isSuccess() && isOk ? OpState.success : OpState.failure;
			} catch (Exception e) {
				log.error("OpAccountSuccessState.handlerOpState.close.error,pfrid=" + context.getBizId(), e);
				this.promoterFastSettleSwitch.updateFcmIdAfterMarginConfigurationChanged(context.getBizId(), null, originalStatus, OpOpenAndCloseEnums.CLOSE_CONFIGURE_FAILURE);
				context.setOpStateResponse(OpStateResponse.genFailureResponse("-1", "系统繁忙，关闭失败，请稍后再试或联系盛付通客服400-720-8888"));
			}
		}
		return OpState.failure;
	}

	public int changeState(OpContext context, int handlerOpStatus) {
		return 0;
	}

}
