package com.sdp.withdraw.manager.ext;

import java.util.List;

import com.sdp.withdraw.dao.WithdrawReqFosDetailDO;
import com.sdp.withdraw.dao.WithdrawReqFosDetailDOExample;

public interface ExtWithdrawReqFosDetailManager {

	public int updateByExample(WithdrawReqFosDetailDO record,WithdrawReqFosDetailDOExample example);

	List<WithdrawReqFosDetailDO> queryCallbackTimeoutData(int callbackTimeoutMinute);
}
