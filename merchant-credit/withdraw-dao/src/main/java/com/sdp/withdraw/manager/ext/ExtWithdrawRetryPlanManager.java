package com.sdp.withdraw.manager.ext;

import com.sdp.withdraw.dao.WithdrawRetryPlanDO;
import com.sdp.withdraw.dao.WithdrawRetryPlanDOExample;

/**
 * 出款重试扩展Manager
 * @author zhangyulong
 *
 */
public interface ExtWithdrawRetryPlanManager{

	int updateByExample(WithdrawRetryPlanDO record, WithdrawRetryPlanDOExample example);

	int updateByExampleSelective(WithdrawRetryPlanDO record, WithdrawRetryPlanDOExample example);

	
}
