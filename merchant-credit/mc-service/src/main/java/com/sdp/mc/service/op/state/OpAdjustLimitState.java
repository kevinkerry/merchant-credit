package com.sdp.mc.service.op.state;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sdp.mc.common.enums.MarginOpAddEnums;
import com.sdp.mc.common.enums.OpObjTypeEnums;
import com.sdp.mc.common.enums.OpTypeEnums;
import com.sdp.mc.common.model.AuditInfoRequestAdustLog;
import com.sdp.mc.common.vo.ErrorMessageVO;
import com.sdp.mc.service.AuditInfoService;
@Service("OpAdjustLimitState")
public class OpAdjustLimitState  extends BaseOpState implements OpState {

	@Autowired
	private AuditInfoService auditInfoService;

	@Override
	public int handlerOpState(OpContext context,String operatorId) {
		int opType = context.getOpType();
		AuditInfoRequestAdustLog reqLog = new AuditInfoRequestAdustLog();
		reqLog.setApplyLimit(context.getApplyLimit());
		reqLog.setApplyCause(context.getApplyCause());
		reqLog.setAttachment(context.getAttachment());
		reqLog.setFileName(context.getFileName());
		reqLog.setContentType(context.getContentType());
		if (opType == OpTypeEnums.SHENGPAY_PROMPTER_ADJUST_LIMIT.getCode()) {
			ErrorMessageVO message = auditInfoService.insertWaitAudit((context.getPromoterNo() + ""), context.getPromoterId(),
					OpObjTypeEnums.PROMOTER.code, opType, reqLog.convertToJsonString(),context.getMcType());
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
