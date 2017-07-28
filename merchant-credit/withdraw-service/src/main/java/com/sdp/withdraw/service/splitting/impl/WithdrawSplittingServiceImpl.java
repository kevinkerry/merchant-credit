package com.sdp.withdraw.service.splitting.impl;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sdp.mc.common.enums.withdraw.WithdrawReqStatusEnums;
import com.sdp.withdraw.dao.WithdrawReqDO;
import com.sdp.withdraw.dao.WithdrawSplittingDO;
import com.sdp.withdraw.dao.WithdrawSplittingDOExample;
import com.sdp.withdraw.manager.WithdrawSplittingManager;
import com.sdp.withdraw.service.splitting.WithdrawSplittingComputeHandler;
import com.sdp.withdraw.service.splitting.WithdrawSplittingSerivce;

@Service("WithdrawSplittingSerivce")
public class WithdrawSplittingServiceImpl implements WithdrawSplittingSerivce {
	private Logger logger = LoggerFactory.getLogger(WithdrawSplittingServiceImpl.class);
	@Autowired
	private WithdrawSplittingManager withdrawSplittingManager;
	@Autowired
	private WithdrawSplittingComputeHandler withdrawSplittingComputeHandler;

	@Override
	public Long createInitWithdrawSplittingInfo(Long reqId, BigDecimal wdCostPromoterSplittingScale) {
		WithdrawSplittingDO record = new WithdrawSplittingDO();
		record.setReqId(reqId);
		record.setWdCostSplittingScale(wdCostPromoterSplittingScale);
		record.setCreateTime(new Date());
		return this.withdrawSplittingManager.insert(record);
	}

	@Override
	public void computeWithdrawSplitting(WithdrawReqDO withdrawReqDO) {
		logger.info("computeWithdrawSplitting withdrawReqDO:" + ToStringBuilder.reflectionToString(withdrawReqDO));
		if (withdrawReqDO == null) { return; }
		if (WithdrawReqStatusEnums.SUCCESS.code.equals(withdrawReqDO.getStatus())){
			withdrawSplittingComputeHandler.execute(withdrawReqDO.getReqId());
		}
		/*if (WithdrawReqStatusEnums.SUCCESS.code.equals(withdrawReqDO.getStatus())
				&&wdCost!=null&&BigDecimal.ZERO.compareTo(wdCost) < 0) {
			if (WithdrawServiceTypeEnums.T0_MPOS_Withdraw.code.equals(withdrawReqDO.getServiceType())) {// 目前仅处理mpos的出款提现分润信息
				WithdrawSplittingDO record = queryWithdrawSplittingInfoByReqId(withdrawReqDO.getReqId());
				if (record != null && record.getWdCostSplittingScale() != null 
						&& BigDecimal.ZERO.compareTo(record.getWdCostSplittingScale()) < 0
						&& record.getBaseCostPromoterSplitting()==null) {
					record.setWdCost(wdCost);
					BigDecimal splittingScale=record.getWdCostSplittingScale();
					record.setWdCostPromoterSplitting(wdCost.multiply(splittingScale).setScale(6, BigDecimal.ROUND_DOWN));
					record.setWdCostShengpaySplitting(wdCost.subtract(wdCost.multiply(splittingScale)).setScale(6, BigDecimal.ROUND_UP));
					record.setUpdateTime(new Date());
					this.withdrawSplittingManager.updateByPrimaryKeySelective(record);
				}
			}
		}*/

	}

	@Override
	public WithdrawSplittingDO queryWithdrawSplittingInfoByReqId(Long reqId) {
		WithdrawSplittingDOExample example = new WithdrawSplittingDOExample();
		example.setReqId(reqId);
		List<WithdrawSplittingDO> list = this.withdrawSplittingManager.selectByExample(example);
		if (list != null && !list.isEmpty()) { return list.get(0); }
		return null;
	}
}
