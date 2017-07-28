package com.sdp.mc.service.lockoperator;

import com.sdp.mc.dao.lockoperator.LockOperatorEO;

/**
 * 锁定的操作员
 * @author liuxi.xiliu
 */
public interface LockOperatorService {
	
	/**
	 * 取得操作员的锁定状态
	 */
	public Integer getLockStatusByOperatorId( String operatorId );
	
	/**
	 * 插入锁定记录
	 */
	public void addLockOperator( ADDLockOperatorPO po );
	
	/**
	 * 获取操作者最后一次锁定记录
	 * @param operatorId
	 * @return
	 */
	public LockOperatorEO getLockOperatorLast(String operatorId);
}
