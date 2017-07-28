package com.sdp.mc.service.op.state;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.slf4j.Logger;import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.sdp.mc.common.enums.MarginOpRedeemEnums;
import com.sdp.mc.common.enums.OpTypeEnums;
import com.sdp.mc.margin.dao.MarginOpReqDO;
import com.sdp.mc.margin.dao.MarginOpReqDOExample;

/**
 * 审核操作
 * 
 * @author wangmindong 2015年9月24日09:15:00
 */
@Service("OpAuditingState")
public class OpAuditingState extends BaseOpState implements OpState {

	private static Logger logger = LoggerFactory.getLogger(OpAuditingState.class);

	@Override
	public int handlerOpState(OpContext context,String operatorId) {
		// TODO Auto-generated method stub
		int opType = context.getOpType();
		if (opType == OpTypeEnums.REDEEMED.code) {
			// TODO:判断是否到审核时间
			long morId = context.getBizId();
			MarginOpReqDO marginOpReqDO = marginOpReqManager
					.selectByPrimaryKey(morId);
			// Date redeemedDate = marginOpReqDO.getRedeemedTime();
			// Date currentDate = DateUtil.generateMidnightTimeStamp(new
			// Date());
			// 审核出款日期在下一天的记录
			// Date nextDay =
			// DateUtil.generateMidnightTimeStamp(DateUtil.increaseDate(new
			// Date(), 1));
			// if (redeemedDate.compareTo(DateUtil.generateMidnightTimeStamp(new
			// Date())) <= 0 ||
			// redeemedDate.compareTo(nextDay) > 0) {
			// logger.error("RedeemedDate:" + DateUtil.date2Str(redeemedDate,
			// DateUtil.dateFormat4) + " greater than Date:"
			// + DateUtil.date2Str(currentDate, DateUtil.dateFormat4));
			// return OpState.handling;
			// }
			// TODO:防止并发 1.状态不为 201(配置成功) 2.当前 MT 不是最终状态的 成功或者失败 220审核成功
			int status = marginOpReqDO.getStatus();
			if (MarginOpRedeemEnums.CONFIGURE_SUCCESS.code != status) {
				logger.info("REDEEMED is handling."
						+ ToStringBuilder.reflectionToString(marginOpReqDO));
				return OpState.handling;
			}

			// 审核
			//marginOpReqDO.setUpdateTime(new Date());
			//marginOpReqDO.setStatus(MarginOpRedeemEnums.AUDITING_SUCCESS.getCode());
			//int value = marginOpReqManager.updateByPrimaryKey(marginOpReqDO);

			MarginOpReqDOExample example = new MarginOpReqDOExample();
			List<Integer> list = new ArrayList<Integer>();
			list.add(MarginOpRedeemEnums.AUDITING_SUCCESS.getCode());
			list.add(MarginOpRedeemEnums.AUDITING_ERROR.getCode());
			example.createCriteria().andMorIdEqualTo(morId).andStatusNotIn(list);
			MarginOpReqDO record = new MarginOpReqDO();
			record.setUpdateTime(new Date());
			record.setStatus(MarginOpRedeemEnums.AUDITING_SUCCESS.getCode());
			int value = marginOpReqManager.updateByExampleSelective(record, example);
			if (value > 0) {
				context.setOpStateResponse(new OpStateResponse(true, null,
						MarginOpRedeemEnums.AUDITING_SUCCESS.getDesc()));
				return OpState.success;
			} else {
				context.setOpStateResponse(new OpStateResponse(false, null,
						MarginOpRedeemEnums.AUDITING_ERROR.getDesc()));
				return OpState.failure;
			}

		}
		return OpState.failure;
	}

	@Override
	public int changeState(OpContext context, int handlerOpStatus) {
		int opType = context.getOpType();

		if (opType == OpTypeEnums.REDEEMED.getCode()
				&& OpState.success == handlerOpStatus)
			return MarginOpRedeemEnums.AUDITING_SUCCESS.code;
		else
			return MarginOpRedeemEnums.AUDITING_ERROR.getCode();
	}

}
