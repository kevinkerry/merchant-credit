package com.sdp.mc.service.op.state.margin;

import org.springframework.stereotype.Service;

import com.sdp.mc.common.enums.FosPaymentStateEnums;
import com.sdp.mc.common.enums.FsConfigChangeStatusEnum;
import com.sdp.mc.common.enums.LoaningTypeEnum;
import com.sdp.mc.common.enums.MarginOpAddEnums;
import com.sdp.mc.common.enums.MarginOpRedeemEnums;
import com.sdp.mc.common.enums.OpTypeEnums;
import com.sdp.mc.common.exception.FastSettleLimitException;
import com.sdp.mc.common.vo.ErrorMessageVO;
import com.sdp.mc.fos.dao.MarginTransDO;
import com.sdp.mc.integration.fos.dto.response.RemitTransferResponseDTO;
import com.sdp.mc.margin.dao.MarginOpReqDO;
import com.sdp.mc.service.op.state.BaseOpState;
import com.sdp.mc.service.op.state.OpContext;
import com.sdp.mc.service.op.state.OpState;
import com.sdp.mc.service.op.state.OpStateResponse;

@Service("OpMarginInitState")
public class OpMarginInitState extends BaseOpState implements OpState {

	@Override
	public int handlerOpState(OpContext context,String operatorId) {
		int opType = context.getOpType();
		if(context.getLoaningType()!=null){
			context.getMspModifyRequest().setLoaningType(context.getLoaningType().getCode());
		}
		if (opType == OpTypeEnums.ADD.getCode()) {
			// TODO:insert 追加操作申请记录
			MarginOpReqDO marginOpReqDO = createMarginOpReq(context, MarginOpAddEnums.INIT.code);
			context.setBizId(marginOpReqDO.getMorId());
			// TODO:insert 转接口记录
			MarginTransDO marginTransDO = createMarginTransDO(context);
			long mtId = marginTransDO.getMtId();
			modifyMarginOpReqMtIdHis(marginOpReqDO.getMorId(), mtId);
			// TODO:调用转账接口
			RemitTransferResponseDTO transferResponseDTO = fosFacade.transfer(mtId, context.getRemitTransferRequest());
			String paymentState = transferResponseDTO.getPaymentState();
			if (FosPaymentStateEnums.P.code.equalsIgnoreCase(paymentState)) {
				// TODO:处理中
				return OpState.handling;
			} else if (transferResponseDTO.isSuccess() || FosPaymentStateEnums.S.code.equalsIgnoreCase(paymentState)) {
				// TODO:成功
				// TODO:更新转账记录
				context.setOpStateResponse(new OpStateResponse(true, null, transferResponseDTO.getReturnMsg()));
				modifyMarginOpReqStatus(marginOpReqDO.getMorId(), MarginOpAddEnums.TRANSFER_SUCCESS.code, MarginOpAddEnums.INIT.code);
				return OpState.success;
			} else {
				// TODO:更新转账记录
				context.setOpStateResponse(new OpStateResponse(false, transferResponseDTO.getReturnCode(), transferResponseDTO.getReturnMsg()));
				modifyMarginOpReqStatus(marginOpReqDO.getMorId(), MarginOpAddEnums.TRANSFER_FAILURE.code, MarginOpAddEnums.INIT.code);
				return OpState.failure;
			}
		} else if (opType == OpTypeEnums.REDEEMED.code) {
			// TODO:insert 追加操作申请记录
			MarginOpReqDO marginOpReqDO = createMarginOpReq(context, MarginOpRedeemEnums.INIT.code);
			createNewT0UserOperaRecord(marginOpReqDO,context, MarginOpRedeemEnums.INIT.code);//添加操作记录
			context.setBizId(marginOpReqDO.getMorId());
			// TODO:修改MSP配置
			long fcmId=0;
			try {
				fcmId = mspFacade.createFsconfigChange(context.getMspModifyRequest(),operatorId);
			} catch (FastSettleLimitException e) {
				modifyMarginOpReqStatus(marginOpReqDO.getMorId(), MarginOpRedeemEnums.CONFIGURE_FAILURE.code, MarginOpRedeemEnums.INIT.code);
				return OpState.failure;
			}
			modifyMarginOpReqFcmIdHis(marginOpReqDO.getMorId(), fcmId);
			
			ErrorMessageVO mspResponseDTO = mspFacade.modifyFastSettleConfig2Msp(context.getMspModifyRequest(), fcmId);
			context.setOpStateResponse(new OpStateResponse(mspResponseDTO.isSuccess(), mspResponseDTO.getErrorCode(), mspResponseDTO.getErrorMessage()));
			if (mspResponseDTO.isSuccess()) {
				mspFacade.modifyFsConfigChangeStatus(fcmId, FsConfigChangeStatusEnum.SUCCESS.code);
				modifyMarginOpReqStatus(marginOpReqDO.getMorId(), MarginOpRedeemEnums.CONFIGURE_SUCCESS.code, MarginOpRedeemEnums.INIT.code);
				return OpState.success;
			} else {
				mspFacade.modifyFsConfigChangeStatus(fcmId, FsConfigChangeStatusEnum.FAILUE.code);
				modifyMarginOpReqStatus(marginOpReqDO.getMorId(), MarginOpRedeemEnums.CONFIGURE_FAILURE.code, MarginOpRedeemEnums.INIT.code);
				return OpState.failure;
			}
		}else if (opType == OpTypeEnums.MODIFY.code) {
			// TODO:修改MSP配置
			long fcmId=0;
			try {
				fcmId = mspFacade.createFsconfigChange(context.getMspModifyRequest(),operatorId);
			} catch (FastSettleLimitException e) {
				return OpState.failure;
			}
			if(context.getLoaningType()!=null){
				context.getMspModifyRequest().setLoaningType(context.getLoaningType().getCode());
			}
			ErrorMessageVO mspResponseDTO = mspFacade.modifyFastSettleConfig2Msp(context.getMspModifyRequest(), fcmId);
			context.setOpStateResponse(new OpStateResponse(mspResponseDTO.isSuccess(), mspResponseDTO.getErrorCode(), mspResponseDTO.getErrorMessage()));
			if (mspResponseDTO.isSuccess()) {
				mspFacade.modifyFsConfigChangeStatus(fcmId, FsConfigChangeStatusEnum.SUCCESS.code);
				return OpState.success;
			} else {
				mspFacade.modifyFsConfigChangeStatus(fcmId, FsConfigChangeStatusEnum.FAILUE.code);
				return OpState.failure;
			}
		}
		return OpState.failure;
	}

	@Override
	public int changeState(OpContext context, int handlerOpStatus) {
		int opType = context.getOpType();

		if (opType == OpTypeEnums.ADD.getCode() && OpState.success == handlerOpStatus) {
			if (context.getLoaningType() == null || LoaningTypeEnum.SHENGPAY == context.getLoaningType()) {
				return MarginOpAddEnums.NON_AUDITING.getCode();
			} else if (LoaningTypeEnum.PROMOTER == context.getLoaningType()) {
				return MarginOpAddEnums.TRANSFER_SUCCESS.getCode();
			} else {
				return -1;
			}
		}
		if (opType == OpTypeEnums.ADD.getCode() && OpState.handling == handlerOpStatus)
			return -1;
		else if (opType == OpTypeEnums.REDEEMED.getCode() && OpState.success == handlerOpStatus)
			//return MarginOpRedeemEnums.CONFIGURE_SUCCESS.code;
			return OpState.success;
		else return MarginOpAddEnums.TRANSFER_FAILURE.getCode();
	}

}
