package com.sdp.withdraw.manager.ext;

import java.util.List;

import com.sdp.withdraw.dao.WithdrawRatioInfoDO;
import com.sdp.withdraw.dao.WithdrawRatioInfoDOExample;

public interface ExtWithdrawRatioInfoManager {
	 List<WithdrawRatioInfoDO> selectRatioTypeInfo(Long bizId);

	int updateByExampleSelective(WithdrawRatioInfoDO record, WithdrawRatioInfoDOExample example);
}
