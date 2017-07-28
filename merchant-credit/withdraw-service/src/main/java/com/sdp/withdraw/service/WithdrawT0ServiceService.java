package com.sdp.withdraw.service;

import com.sdp.mc.common.dto.WithdrawCoreServiceDTO;
import com.sdp.mc.common.vo.ErrorMessageVO;
import com.sdp.withdraw.dao.WithdrawReqDO;

/**
 * 服务端接口（供客户端调用） POS单笔出款 t0WithdrawPos MPOS单笔余额出款 t0WithdrawBalance 单笔查询 queryT0Withdraw FOS核心出款接口 接口需要依赖 mc-common-integration
 *
 * @author liutao
 *
 */
public interface WithdrawT0ServiceService {
	/**
	 * T0出款服务核心服务
	 *
	 * @param serviceDTO
	 * @return
	 */
	public ErrorMessageVO<Object> withdrawCoreService(WithdrawCoreServiceDTO serviceDTO);
	/**
	 *拼装出款类
	 * @param reqDo
	 * @param dto
	 * @return
	 */
	public ErrorMessageVO<Object> bulidCoreData(WithdrawReqDO reqDo,WithdrawCoreServiceDTO dto);



}
