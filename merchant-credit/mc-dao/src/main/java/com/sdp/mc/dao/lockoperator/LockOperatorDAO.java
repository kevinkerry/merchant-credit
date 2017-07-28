package com.sdp.mc.dao.lockoperator;

/**
 * 锁定操作员
 * @author liuxi.xiliu
 */
public interface LockOperatorDAO {
	/**
	 * 取得操作员的锁定状态
	 */
	public Integer getLockStatusByOperatorId( String operatorId );
	
	/**
	 * 插入锁定记录
	 */
	public void insert( LockOperatorEO eo );
	
	/**
	 * 获取操作者最后的一次的锁定记录
	 * @param operatorId
	 * @return
	 */
	public LockOperatorEO getLockOperatorLast( String operatorId);
}