package com.sdp.mc.service.op.state;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.slf4j.Logger;import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.sdp.mc.common.enums.FosPaymentStateEnums;
import com.sdp.mc.common.enums.MarginOpAddEnums;
import com.sdp.mc.common.enums.MarginOpRedeemEnums;
import com.sdp.mc.common.enums.MarginTransEnum;
import com.sdp.mc.common.enums.OpTypeEnums;
import com.sdp.mc.fos.dao.MarginTransDO;
import com.sdp.mc.integration.fos.dto.response.RemitTransferResponseDTO;
import com.sdp.mc.margin.dao.MarginOpReqDO;

@Service("OpConfigureSuccessState")
public class OpConfigureSuccessState extends BaseOpState implements OpState {

	private static Logger logger = LoggerFactory.getLogger(OpConfigureSuccessState.class);

	@Override
	public int handlerOpState(OpContext context,String operatorId) {
		int opType = context.getOpType();
		if (opType == OpTypeEnums.REDEEMED.code) {
			// TODO:判断是否到退款时间
			long morId = context.getBizId();
			MarginOpReqDO marginOpReqDO = marginOpReqManager.selectByPrimaryKey(morId);
			// TODO:防止并发 1.状态不为 201(配置成功) 2.当前 MT 不是最终状态的 成功或者失败  220审核成功
			int status = marginOpReqDO.getStatus();
//			if (MarginOpRedeemEnums.CONFIGURE_SUCCESS.code != status) {
			if (MarginOpRedeemEnums.AUDITING_SUCCESS.code != status) {
				logger.info("REDEEMED is handling." + ToStringBuilder.reflectionToString(marginOpReqDO));
				return OpState.handling;
			}
			String preMtId = marginOpReqDO.getMtId();
			if (StringUtils.isNotBlank(preMtId)) {
				MarginTransDO marginTransDO = marginTransManager.selectByPrimaryKey(Long.parseLong(preMtId));
				int fosStatus = marginTransDO.getStatus();
				if (MarginTransEnum.SUCCESS.code == fosStatus || MarginTransEnum.FAILUE.code == fosStatus) {
					logger.info("REDEEMED has handled." + ToStringBuilder.reflectionToString(marginOpReqDO));
					logger.info("REDEEMED fos transfer has handled." + ToStringBuilder.reflectionToString(marginTransDO));
					return OpState.handling;
				}else if (MarginTransEnum.INIT.code == fosStatus) {
					logger.info("REDEEMED is handling." + ToStringBuilder.reflectionToString(marginOpReqDO));
					logger.info("REDEEMED fos transfer is handling." + ToStringBuilder.reflectionToString(marginTransDO));
					return OpState.handling;
				}
			}

			// TODO:insert 转接口记录
			MarginTransDO marginTransDO = createMarginTransDO(context);
			long mtId = marginTransDO.getMtId();
			modifyMarginOpReqMtIdHis(morId, mtId);
			// TODO:调用转账接口
			RemitTransferResponseDTO transferResponseDTO = fosFacade.transfer(mtId, context.getRemitTransferRequest());
			String paymentState = transferResponseDTO.getPaymentState();
			if (FosPaymentStateEnums.P.code.equalsIgnoreCase(paymentState)) {
				// TODO:处理中
				context.setOpStateResponse(new OpStateResponse(true, transferResponseDTO.getPaymentState(), "转账处理中."));
				return OpState.handling;
			} else if (transferResponseDTO.isSuccess() || FosPaymentStateEnums.S.code.equalsIgnoreCase(paymentState)) {
				// TODO:成功
				// TODO:更新转账记录
//				modifyMarginOpReqStatus(morId, MarginOpRedeemEnums.TRANSFER_SUCCESS.code, MarginOpRedeemEnums.CONFIGURE_SUCCESS.code);
				modifyMarginOpReqStatus(morId, MarginOpRedeemEnums.TRANSFER_SUCCESS.code, MarginOpRedeemEnums.AUDITING_SUCCESS.code);
				context.setOpStateResponse(new OpStateResponse(true, transferResponseDTO.getPaymentState(), "转账成功."));
				return OpState.success;
			} else {
				// TODO:更新转账记录
//				modifyMarginOpReqStatus(morId, MarginOpRedeemEnums.TRANSFER_FAILURE.code, MarginOpRedeemEnums.CONFIGURE_SUCCESS.code);
				modifyMarginOpReqStatus(morId, MarginOpRedeemEnums.TRANSFER_FAILURE.code, MarginOpRedeemEnums.AUDITING_SUCCESS.code);
				context.setOpStateResponse(new OpStateResponse(true, transferResponseDTO.getPaymentState(), transferResponseDTO.getReturnMsg()));
				return OpState.failure;
			}
		}
		return OpState.failure;
	}

	@Override
	public int changeState(OpContext context, int handlerOpStatus) {
		int opType = context.getOpType();

		if (opType == OpTypeEnums.REDEEMED.getCode() && OpState.success == handlerOpStatus)
			//return MarginOpRedeemEnums.AUDITING_SUCCESS.code;
			return OpState.success;
		else return MarginOpAddEnums.TRANSFER_FAILURE.getCode();
	}

}
