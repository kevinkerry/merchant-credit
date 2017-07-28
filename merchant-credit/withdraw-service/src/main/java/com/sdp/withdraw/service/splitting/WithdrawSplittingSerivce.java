package com.sdp.withdraw.service.splitting;

import java.math.BigDecimal;

import com.sdp.withdraw.dao.WithdrawReqDO;
import com.sdp.withdraw.dao.WithdrawSplittingDO;

public interface WithdrawSplittingSerivce {
	/**
	 * 创建出款初始的出款分润信息
	 * @param reqId 请求的ID
	 * @param wdCostPromoterSplittingScale 提现费用的代理商分润比例
	 * @return
	 */
    public Long createInitWithdrawSplittingInfo(Long reqId,BigDecimal wdCostPromoterSplittingScale);
    /**
     * 计算出款的分润信息
     * @param withdrawReqDO
     */
	public void computeWithdrawSplitting(WithdrawReqDO withdrawReqDO);
	
	WithdrawSplittingDO queryWithdrawSplittingInfoByReqId(Long reqId); 
}
