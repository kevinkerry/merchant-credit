package com.sdp.withdraw.service;

import java.math.BigDecimal;

/**

 */
public interface WithdrawReqExtraInfoService {
    /**
     * 创建后付费的出款扩展信息
     * @param reqId 出款的请求ID
     * @param initWitdrawAmount 原始的出款金额
     * @return
     */
	Long createPostPaidExtraInfo(Long reqId, BigDecimal initWitdrawAmount);
	

	
}
