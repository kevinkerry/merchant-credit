package com.sdp.mc.dao.lockoperator;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Repository;

import com.shengpay.commons.springtools.base.IbatisBaseDAOImpl;

/**
 * 锁定操作员
 * @author liuxi.xiliu
 */
@Repository("lockOperatorDAO")
public class LockOperatorDAOImpl implements LockOperatorDAO{
	/**
	 * IBatis模板在spring配置文件中的beanId
	 */
	@Resource(name="ibatisTemplate_mc")
	protected IbatisBaseDAOImpl ibatisTemplete;
	
	/**
	 * 取得操作员的锁定状态
	 */
	public Integer getLockStatusByOperatorId( String operatorId ){
		List<Integer> list = ibatisTemplete.queryForList( "LockOperatorDAO.getLockStatusByOperatorId", operatorId );
		return list.size() > 0? list.get( 0 ) : null;
	}
	
	/**
	 * 插入锁定记录
	 */
	public void insert( LockOperatorEO eo ){
		ibatisTemplete.insert( "LockOperatorDAO.insert", eo );
	}
	
	@SuppressWarnings("unchecked")
	public LockOperatorEO getLockOperatorLast( String operatorId){
		List<LockOperatorEO> lockEOS = ibatisTemplete.queryForList("LockOperatorDAO.getLockOperatorLast",operatorId);
		return lockEOS.size() > 0? lockEOS.get( 0 ) : null;
	}
}
