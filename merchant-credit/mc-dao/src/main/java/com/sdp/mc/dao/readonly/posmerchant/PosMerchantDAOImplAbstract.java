package com.sdp.mc.dao.readonly.posmerchant;

import com.shengpay.commons.springtools.base.IbatisBaseDAOImpl;

import org.springframework.dao.OptimisticLockingFailureException;

import javax.annotation.Resource;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * POS商户访问接口抽象实现
 * 
 * @author wangyiyong@snda.com
 */
@Deprecated
public abstract class PosMerchantDAOImplAbstract implements PosMerchantDAO {

	/**
	 * IBatis模板在spring配置文件中的beanId
	 */
	@Resource(name = "ibatisTemplate_mc")
	protected IbatisBaseDAOImpl ibatisTemplete;

	@Override
	public Long insert(PosMerchantEO eo) {
		if (eo.getPosmId() != null) {
			ibatisTemplete.insert("PosMerchantDAOAbstract.insertHasId", eo);
			return eo.getPosmId();
		} else {
			Long ppId = (Long) ibatisTemplete.insert("PosMerchantDAOAbstract.insert", eo);
			eo.setPosmId(ppId);
			return ppId;
		}
	}

	@Override
	public PosMerchantEO select(Long id) {
		return select(id, false);
	}

	@Override
	public PosMerchantEO selectAndLock(Long id) {
		return select(id, true);
	}

	public PosMerchantEO select(Long id, boolean isLock) {
		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("id", id);
		paramMap.put("isLock", isLock);
		return (PosMerchantEO) ibatisTemplete.queryForObject("PosMerchantDAOAbstract.select", paramMap);
	}

	@Override
	public PosMerchantEO selectEOByEO(PosMerchantEO eo) {
		return (PosMerchantEO) ibatisTemplete.queryForObject("PosMerchantDAOAbstract.selectEOByEO", eo);
	}

	@Override
	public int countByEO(PosMerchantEO eo) {
		Integer count = (Integer) ibatisTemplete.queryForObject("PosMerchantDAOAbstract.countByEO", eo);
		return count != null ? count : 0;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<PosMerchantEO> selectListByEO(PosMerchantEO eo) {
		return ibatisTemplete.queryForList("PosMerchantDAOAbstract.selectEOByEO", eo);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<PosMerchantEO> selectListByIdList(List<Long> idList, boolean isLock) {
		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("idList", idList);
		paramMap.put("isLock", isLock);
		return ibatisTemplete.queryForList("PosMerchantDAOAbstract.selectListByIdList", paramMap);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<PosMerchantEO> selectListByEO(PosMerchantEO eo, int pageNO, int pageSize) {
		return ibatisTemplete.queryForList("PosMerchantDAOAbstract.selectEOByEO", eo, (pageNO - 1) * pageSize, pageSize);
	}

	@Override
	public int update(PosMerchantEO eo) {
		int update = ibatisTemplete.update("PosMerchantDAOAbstract.update", eo);
		if (update == 0) { throw new OptimisticLockingFailureException("更新纪录[" + eo + "]时发生乐观锁并发异常"); }
		eo.setPosmVersion(eo.getPosmVersion() + 1);
		return update;
	}

	@Override
	public int updateByField(PosMerchantEO eo) {
		int update = ibatisTemplete.update("PosMerchantDAOAbstract.updateByField", eo);
		if (update == 0) { throw new OptimisticLockingFailureException("更新纪录[" + eo + "]时发生乐观锁并发异常"); }
		eo.setPosmVersion(eo.getPosmVersion() + 1);
		return update;
	}

	@Override
	public int delete(PosMerchantEO eo) {
		int delete = ibatisTemplete.delete("PosMerchantDAOAbstract.delete", eo);
		if (delete == 0) { throw new OptimisticLockingFailureException("删除纪录[" + eo + "]时发生乐观锁并发异常"); }
		return delete;
	}
}
