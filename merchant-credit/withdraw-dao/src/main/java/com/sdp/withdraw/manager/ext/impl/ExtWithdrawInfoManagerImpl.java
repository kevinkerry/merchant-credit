package com.sdp.withdraw.manager.ext.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sdp.withdraw.dao.WithdrawInfoDO;
import com.sdp.withdraw.dao.WithdrawInfoDOExample;
import com.sdp.withdraw.dao.daointerface.WithdrawInfoDAO;
import com.sdp.withdraw.dao.daointerface.ext.ExtWithdrawInfoDAO;
import com.sdp.withdraw.manager.ext.ExtWithdrawInfoManager;

@Service("extWithdrawInfoManager")
public class ExtWithdrawInfoManagerImpl implements ExtWithdrawInfoManager{

	@Autowired
    private WithdrawInfoDAO withdrawInfoDAO;
	@Autowired
	private ExtWithdrawInfoDAO extWithdrawInfoDAO;

	@Override
	public int updateByExampleSelective(WithdrawInfoDO record,WithdrawInfoDOExample example) {
		// TODO Auto-generated method stub
		return withdrawInfoDAO.updateByExampleSelective(record, example);
	}
	@Override
	public int repairWithdrawData(){
		// TODO Auto-generated method stub
		return extWithdrawInfoDAO.repairWithdrawData();
	}

	/**
	 * 加数据库锁 查询
	 * @param example
	 * @return
	 */
	@Override
	public List<WithdrawInfoDO> findWithdrawInfoByExampleForUpdate(WithdrawInfoDOExample example, boolean isForUpdate) {
		// TODO Auto-generated method stub
		if(isForUpdate){
			return extWithdrawInfoDAO.selectWithdrawInfoDOForUpdate(example);
		}else{
			return extWithdrawInfoDAO.selectWithdrawInfoByExample(example);
		}
		
	}

	@Override
	public List<WithdrawInfoDO> findWithdrawInfoByMemberIds(List<Long> bizIds, boolean isForUpdate) {
		WithdrawInfoDOExample example=new WithdrawInfoDOExample();
		example.createCriteria().andBizIdIn(bizIds);
		if(isForUpdate){
			return extWithdrawInfoDAO.selectWithdrawInfoDOForUpdate(example);
		}else{
			return extWithdrawInfoDAO.selectWithdrawInfoByExample(example);
		}
	}
}
