package com.sdp.withdraw.manager.ext.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sdp.withdraw.dao.WithdrawRatioInfoDO;
import com.sdp.withdraw.dao.WithdrawRatioInfoDOExample;
import com.sdp.withdraw.dao.daointerface.ext.ExtWithdrawRationInfoDAO;
import com.sdp.withdraw.manager.ext.ExtWithdrawRatioInfoManager;

@Service("extWithdrawRatioInfoManager")
public class ExtWithdrawRatioInfoManagerImpl implements ExtWithdrawRatioInfoManager{

	@Autowired
    private ExtWithdrawRationInfoDAO withdrawRatioInfoDAO;

	@Override
	public  List<WithdrawRatioInfoDO> selectRatioTypeInfo(Long bizId) {
		return withdrawRatioInfoDAO.selectRatioInfo(bizId);
	}
	@Override
	public int updateByExampleSelective(WithdrawRatioInfoDO record, WithdrawRatioInfoDOExample example){
		return withdrawRatioInfoDAO.updateByExampleSelective(record, example);
	}

}
