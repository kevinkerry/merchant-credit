package com.sdp.mc.service.op.state;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sdp.mc.common.enums.AuditInfoStateEnum;
import com.sdp.mc.common.enums.MarginOpAddEnums;
import com.sdp.mc.common.enums.MarginOpRedeemEnums;
import com.sdp.mc.common.enums.OpOpenAndCloseEnums;
import com.sdp.mc.common.enums.OpTypeEnums;
import com.sdp.mc.service.op.state.margin.OpMarginInitState;
import com.sdp.mc.service.op.state.margin.OpNonAuditingState;
import com.sdp.mc.service.op.state.margin.OpTransferSuccessState;
import com.sdp.mc.service.op.state.openandclose.OpAccountSuccessState;
import com.sdp.mc.service.op.state.openandclose.OpenInitState;

@Service("OpStateFactory")
public class OpStateFactory {

	@Autowired
	private OpenInitState openInitState;
	@Autowired
	private OpAccountSuccessState accountSuccessState;
	@Autowired
	private OpConfigureSuccessState configureSuccessState;
	@Autowired
	private OpMarginInitState marginInitState;
	@Autowired
	private OpTransferSuccessState transferSuccessState;
	@Autowired
	private OpNonAuditingState opNonAuditingState;
	@Autowired
	private OpAuditingState opAuditingState;
	@Autowired
	private OpRefuseLoanState opRefuseLoanState;
	@Autowired
	private OpAdjustLimitState opAdjustLimitState;


	public OpState generate(OpContext context, int code) {
		int opType = context.getOpType();
		// int type = context.getType();
		if (opType == OpTypeEnums.OPEN.getCode() || opType == OpTypeEnums.CLOSE.getCode()) {
			// TODO:生成开通/关闭流程 State
			return generateOpState(code);
		} else if (opType == OpTypeEnums.ADD.getCode() || opType == OpTypeEnums.REDEEMED.getCode()|| opType == OpTypeEnums.MODIFY.getCode()) {
			// TODO:生成保证金追加/退回流程 State
			return generateMarginState(code);
		}else if(opType==OpTypeEnums.SHENGPAY_PROMPTER_ADJUST_LIMIT.code){
			//临时调额
			return generateAdjustLimitState(code);
		}

		return null;
	}
	protected OpState generateAdjustLimitState(int code){
		if(code==AuditInfoStateEnum.WAIT_AUDIT.getStatus()){
			return  opAdjustLimitState;
		}
		return null;
	}
	protected OpState generateOpState(int code) {
		if (code == OpOpenAndCloseEnums.INIT.getCode() || code == OpOpenAndCloseEnums.CONFIGURE_SUCCESS.getCode())
			return openInitState;
		else if (code == OpOpenAndCloseEnums.ACCOUNT_SUCCESS.getCode() || code == OpOpenAndCloseEnums.CLOSE_INIT.getCode())
			return accountSuccessState;
		else return null;
	}

	protected OpState generateMarginState(int code) {
		if (code == MarginOpAddEnums.INIT.getCode())
			return marginInitState;
		else if (code == MarginOpRedeemEnums.INIT.getCode())
			return marginInitState;
		else if (code == MarginOpRedeemEnums.CONFIGURE_SUCCESS.getCode()) //配置成功（审核)
			return opAuditingState;
		else if (code == MarginOpAddEnums.CONFIGURE_SUCCESS.getCode() || code == MarginOpRedeemEnums.AUDITING_SUCCESS.code)
			return configureSuccessState;
		else if (code == MarginOpAddEnums.TRANSFER_SUCCESS.getCode())
			return transferSuccessState;
		else if (code == MarginOpAddEnums.NON_AUDITING.getCode())
			return opNonAuditingState;
		else if (code == MarginOpRedeemEnums.LOAIN_REFUSE.getCode()){
			return opRefuseLoanState;
		}
		else return null;
	}
}
