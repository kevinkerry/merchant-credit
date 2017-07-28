package com.sdp.withdraw.manager.ext.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sdp.withdraw.dao.WithdrawReqDO;
import com.sdp.withdraw.dao.WithdrawReqDOExample;
import com.sdp.withdraw.dao.WithdrawRetryPlanDO;
import com.sdp.withdraw.dao.WithdrawRetryPlanDOExample;
import com.sdp.withdraw.dao.daointerface.WithdrawRetryPlanDAO;
import com.sdp.withdraw.dao.daointerface.ext.ExtWithdrawReqDAO;
import com.sdp.withdraw.dao.ext.ExtWithdrawReqDOExample;
import com.sdp.withdraw.dao.ext.ExtWithdrawReqVO;
import com.sdp.withdraw.manager.ext.ExtWithdrawReqManager;
import com.sdp.withdraw.manager.ext.ExtWithdrawRetryPlanManager;
import com.sdp.withdraw.manager.impl.WithdrawReqManagerImpl;

@Service("ExtWithdrawRetryPlanManager")
public class ExtWithdrawRetryPlanManagerImpl  implements ExtWithdrawRetryPlanManager{

	@Autowired
	private WithdrawRetryPlanDAO withdrawRetryPlanDAO;
	
	@Override
	public int updateByExample(WithdrawRetryPlanDO record, WithdrawRetryPlanDOExample example){
	   return withdrawRetryPlanDAO.updateByExample(record, example);
	}
	@Override
	public int updateByExampleSelective(WithdrawRetryPlanDO record, WithdrawRetryPlanDOExample example){
		return withdrawRetryPlanDAO.updateByExampleSelective(record, example);
	}


}
