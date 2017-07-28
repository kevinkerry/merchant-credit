package com.sdp.withdraw.manager.ext.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sdp.withdraw.dao.WithdrawCostConfigDO;
import com.sdp.withdraw.dao.WithdrawCostConfigDOExample;
import com.sdp.withdraw.dao.daointerface.WithdrawCostConfigDAO;
import com.sdp.withdraw.manager.ext.ExtWithdrawCostConfigManager;

@Service("ExtWithdrawCostConfigManager")
public class ExtWithdrawCostConfigManagerImpl  implements ExtWithdrawCostConfigManager{

	@Autowired
	private WithdrawCostConfigDAO withdrawCostConfigDAO;
	
	@Override
	public int updateByExample(WithdrawCostConfigDO record, WithdrawCostConfigDOExample example){
	   return withdrawCostConfigDAO.updateByExample(record, example);
	}
	@Override
	public int updateByExampleSelective(WithdrawCostConfigDO record, WithdrawCostConfigDOExample example){
		return withdrawCostConfigDAO.updateByExampleSelective(record, example);
	}


}
