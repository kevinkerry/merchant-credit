package com.sdp.mc.service.lockoperator;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sdp.mc.dao.lockoperator.LockOperatorDAO;
import com.sdp.mc.dao.lockoperator.LockOperatorEO;

/**
 * 锁定的操作员
 * @author liuxi.xiliu
 */
@Service("lockOperatorService")
public class LockOperatorServiceImpl implements LockOperatorService{
	
	@Autowired
	private LockOperatorDAO lockOperatorDAO;
	
	/**
	 * 取得操作员的锁定状态
	 */
	public Integer getLockStatusByOperatorId( String operatorId ){
		return lockOperatorDAO.getLockStatusByOperatorId( operatorId );
	}
	
	/**
	 * 插入锁定记录
	 */
	public void addLockOperator( ADDLockOperatorPO po ){
		LockOperatorEO eo = new LockOperatorEO();
		BeanUtils.copyProperties( po, eo );
		lockOperatorDAO.insert( eo );
	}
	
	public LockOperatorEO getLockOperatorLast(String operatorId){
		return lockOperatorDAO.getLockOperatorLast(operatorId);
	}
}
