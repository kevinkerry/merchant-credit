package com.sdp.mc.service.fastsettle;

import com.sdp.mc.common.vo.ErrorMessageVO;
import com.sdp.mc.common.vo.MerchantFastSettleVO;
import com.sdp.mc.ffconfig.dao.FastSettleConfigDO;
import com.sdp.withdraw.vo.ratio.WithdrawRatioResult;

public interface FastSettle {

	public abstract ErrorMessageVO<Object> setMerchantFastSettleConfig(MerchantFastSettleVO fastSettleVO, String operatorId);

	public ErrorMessageVO<Object> setMerchantAutoSettle(MerchantFastSettleVO fastSettleVO,String operatorId);

	public FastSettleConfigDO getFastSettleConfig(Long objId, Integer objType);

	public abstract WithdrawRatioResult getTomorrowEffectiveRatio(String merchantNo, String mcType);

	WithdrawRatioResult getCurrentEffectiveRatio(String merchantNo, String mcType);
}