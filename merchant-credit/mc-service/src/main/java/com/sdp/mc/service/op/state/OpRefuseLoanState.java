package com.sdp.mc.service.op.state;

import java.util.Date;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.slf4j.Logger;import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.sdp.mc.common.enums.MarginOpRedeemEnums;
import com.sdp.mc.common.enums.OpTypeEnums;
import com.sdp.mc.margin.dao.MarginOpReqDO;
import com.sdp.mc.margin.dao.MarginOpReqDOExample;

/**
 * 拒绝放款
 * @author wangmindong
 *
 */
@Service("OpRefuseLoanState")
public class OpRefuseLoanState extends BaseOpState implements OpState {

	private static Logger logger = LoggerFactory.getLogger(OpRefuseLoanState.class);

	@Override
	public int handlerOpState(OpContext context,String operatorId) {
		// TODO Auto-generated method stub
		int opType = context.getOpType();
		if (opType == OpTypeEnums.REDEEMED.code) {
			long morId = context.getBizId();
			MarginOpReqDO marginOpReqDO = marginOpReqManager.selectByPrimaryKey(morId);
			int status = marginOpReqDO.getStatus();
			if (MarginOpRedeemEnums.CONFIGURE_SUCCESS.code != status) {
				logger.info("REDEEMED is handling." + ToStringBuilder.reflectionToString(marginOpReqDO));
				return OpState.handling;
			}
			//拒绝放款
			MarginOpReqDOExample example = new MarginOpReqDOExample();
			example.createCriteria().andMorIdEqualTo(morId).andStatusEqualTo(MarginOpRedeemEnums.CONFIGURE_SUCCESS.getCode());
			MarginOpReqDO record = new MarginOpReqDO();
			record.setUpdateTime(new Date());
			record.setStatus(MarginOpRedeemEnums.LOAIN_REFUSE.getCode());
			int value = marginOpReqManager.updateByExampleSelective(record, example);
			if (value > 0) {
				context.setOpStateResponse(new OpStateResponse(true, null,
						MarginOpRedeemEnums.LOAIN_REFUSE.getDesc()));
				return OpState.success;
			} else {
				context.setOpStateResponse(new OpStateResponse(false, null,
						MarginOpRedeemEnums.LOAIN_REFUSE.getDesc()));
				return OpState.failure;
			}

		}
		return OpState.failure;
	}

	@Override
	public int changeState(OpContext context, int handlerOpStatus) {
		int opType = context.getOpType();
		if (opType == OpTypeEnums.REDEEMED.getCode() && OpState.success == handlerOpStatus)
			return OpState.success;
		else
			return OpState.failure;
	}

}
