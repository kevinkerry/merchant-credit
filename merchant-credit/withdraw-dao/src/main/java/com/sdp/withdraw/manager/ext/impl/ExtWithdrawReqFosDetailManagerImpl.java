package com.sdp.withdraw.manager.ext.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sdp.withdraw.dao.WithdrawReqFosDetailDO;
import com.sdp.withdraw.dao.WithdrawReqFosDetailDOExample;
import com.sdp.withdraw.dao.daointerface.WithdrawReqFosDetailDAO;
import com.sdp.withdraw.dao.daointerface.ext.ExtWithdrawReqFosDetailDAO;
import com.sdp.withdraw.manager.ext.ExtWithdrawReqFosDetailManager;

@Service("extWithdrawReqFosDetailManager")
public class ExtWithdrawReqFosDetailManagerImpl implements ExtWithdrawReqFosDetailManager{

	@Autowired
    private WithdrawReqFosDetailDAO withdrawReqFosDetailDAO;
	@Autowired
	private ExtWithdrawReqFosDetailDAO extWithdrawReqFosDetailDAO;

	@Override
	public int updateByExample(WithdrawReqFosDetailDO record,WithdrawReqFosDetailDOExample example) {
		// TODO Auto-generated method stub

		return withdrawReqFosDetailDAO.updateByExampleSelective(record, example);
	}
	@Override
	public List<WithdrawReqFosDetailDO> queryCallbackTimeoutData(int callbackTimeoutMinute) {
		return extWithdrawReqFosDetailDAO.queryCallbackTimeoutData(callbackTimeoutMinute);
	}

}
