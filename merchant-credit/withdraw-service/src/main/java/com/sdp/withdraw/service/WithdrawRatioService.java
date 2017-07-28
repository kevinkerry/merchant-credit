package com.sdp.withdraw.service;

import com.sdp.withdraw.vo.ratio.WithdrawRatioRequest;
import com.sdp.withdraw.vo.ratio.WithdrawRatioResponse;

public interface WithdrawRatioService {
	/**
	 * 构件费率配合信息内部使用接口
	 * @param withdrawRatioRequest
	 * @param bizId 必填
	 * @return
	 */
	
	WithdrawRatioResponse buildWithrawRatio(WithdrawRatioRequest withdrawRatioRequest, Long bizId);
    
	Integer getServiceTypeByRatioType(int code);
}
