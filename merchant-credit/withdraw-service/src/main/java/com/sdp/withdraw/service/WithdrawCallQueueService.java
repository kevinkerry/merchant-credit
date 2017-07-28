package com.sdp.withdraw.service;

import com.sdp.mc.common.dto.WithdrawCoreServiceDTO;

/**
 * 服务端接口（供客户端调用） POS单笔出款 t0WithdrawPos MPOS单笔余额出款 t0WithdrawBalance 单笔查询 queryT0Withdraw FOS核心出款接口 接口需要依赖 mc-common-integration
 *
 * @author liutao
 *
 */
public interface WithdrawCallQueueService {
	

	/**
	 * 添加到核心出款服务的调用队列
	 * 
	 * @param serviceDTO
	 * @return 成功，失败
	 */
	boolean addCallWithdrawCoreServiceDate(WithdrawCoreServiceDTO serviceDTO);

	
}
