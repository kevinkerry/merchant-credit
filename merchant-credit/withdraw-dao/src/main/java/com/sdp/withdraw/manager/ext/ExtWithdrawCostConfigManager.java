package com.sdp.withdraw.manager.ext;

import com.sdp.withdraw.dao.WithdrawCostConfigDO;
import com.sdp.withdraw.dao.WithdrawCostConfigDOExample;


public interface ExtWithdrawCostConfigManager {

	int updateByExample(WithdrawCostConfigDO record, WithdrawCostConfigDOExample example);

	int updateByExampleSelective(WithdrawCostConfigDO record, WithdrawCostConfigDOExample example);

}