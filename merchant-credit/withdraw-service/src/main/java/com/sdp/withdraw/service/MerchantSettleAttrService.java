package com.sdp.withdraw.service;

import java.util.Date;

import com.sdp.withdraw.vo.ratio.WithdrawRatioRequest;
import com.sdp.withdraw.vo.ratio.WithdrawRatioResponse;

public interface MerchantSettleAttrService {

	Long createMerchantSettleInfo(Integer settleType, String merchantNo, String merchantType, Long bizId, Date openDate);
	
}
