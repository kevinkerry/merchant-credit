package com.sdp.mc.service.fsconfig;

import com.sdp.mc.common.vo.ErrorMessageVO;
import com.sdp.mc.ffconfig.dao.FastSettleConfigDO;

public interface FastSettleConfigService {

	/**
	 * 修改商户自动快速结算设置
	 * 
	 * @param merchantId
	 *            msp系统商户表id
	 * @param autoFastSettle
	 *            开关标志
	 * @return ErrorMessageVO
	 * **/

	public ErrorMessageVO modifyMerchantAutoFastSettle(Long merchantId, Integer autoFastSettle);

	FastSettleConfigDO getFastSettleConfig(long merchantId);

	Long updateOrInsertFastSettleConfig(FastSettleConfigDO record);
}
