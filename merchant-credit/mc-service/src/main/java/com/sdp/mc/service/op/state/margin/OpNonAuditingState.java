package com.sdp.mc.service.op.state.margin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sdp.mc.common.enums.MarginOpAddEnums;
import com.sdp.mc.common.enums.OpObjTypeEnums;
import com.sdp.mc.common.enums.OpTypeEnums;
import com.sdp.mc.common.model.AuditInfoRequestLog;
import com.sdp.mc.common.vo.ErrorMessageVO;
import com.sdp.mc.service.AuditInfoService;
import com.sdp.mc.service.op.state.BaseOpState;
import com.sdp.mc.service.op.state.OpContext;
import com.sdp.mc.service.op.state.OpState;
import com.sdp.mc.service.op.state.OpStateResponse;

@Service("opNonAuditingState")
public class OpNonAuditingState extends BaseOpState implements OpState {

	@Autowired
	private AuditInfoService auditInfoService;

	@Override
	public int handlerOpState(OpContext context,String operatorId) {
		int opType = context.getOpType();
		AuditInfoRequestLog reqLog = new AuditInfoRequestLog();
		reqLog.setOpType(opType);
		reqLog.setFastSettleMargin(context.getAmount());
		reqLog.setLoaningType((context.getLoaningType() == null ? null : context.getLoaningType().getCode()));
		if (opType == OpTypeEnums.ADD.getCode()) {
			ErrorMessageVO message = auditInfoService.insertWaitAudit((context.getPromoterNo() + ""), context.getPromoterId(),
					OpObjTypeEnums.PROMOTER.code, opType, reqLog);
			if (message.isSuccess()) {
				context.setOpStateResponse(new OpStateResponse(true, null, "进入待审核成功"));
				return OpState.success;
			}
			context.setOpStateResponse(new OpStateResponse(false, null, "进入待审核失败"));
			return OpState.failure;
		}
		context.setOpStateResponse(new OpStateResponse(false, null, "操作类型错误"));
		return OpState.failure;
	}

	@Override
	public int changeState(OpContext context, int handlerOpStatus) {
		int opType = context.getOpType();
		if (opType == OpTypeEnums.ADD.getCode() && OpState.success == handlerOpStatus) return MarginOpAddEnums.AUDITING.getCode();
		return -1;
	}

}
