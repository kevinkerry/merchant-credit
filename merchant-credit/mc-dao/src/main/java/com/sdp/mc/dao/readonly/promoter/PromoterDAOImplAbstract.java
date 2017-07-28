package com.sdp.mc.dao.readonly.promoter;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.dao.OptimisticLockingFailureException;

import com.shengpay.commons.springtools.base.IbatisBaseDAOImpl;


/**
 * @author zhangguoliang.burt
 *	拓展商操作
 */
@Deprecated
public abstract class PromoterDAOImplAbstract implements PromoterDAO{

	/**
	 * IBatis模板在spring配置文件中的beanId
	 */
	@Resource(name="ibatisTemplate_mc")
    protected IbatisBaseDAOImpl ibatisTemplete;
	
	@SuppressWarnings("unchecked")
	@Override
	public List<PromoterEO> selectListByIdList(List<Long> idList, boolean lockEO) {
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("idList", idList);
		map.put("isLock", lockEO);
		return ibatisTemplete.queryForList("PromoterDAOAbstract.selectListByIdList", map);
	}

	@Override
	public int countByEO(PromoterEO eo) {
		return (Integer) ibatisTemplete.queryForObject("PromoterDAOAbstract.countByEO", eo);
	}

	@Override
	public int delete(PromoterEO eo) {
		int delete = ibatisTemplete.delete("PromoterDAOAbstract.delete", eo);
		if (delete == 0) {
            throw new OptimisticLockingFailureException("删除纪录[" + eo + "]时发生乐观锁并发异常");
        }
		return delete;
	}

	@Override
	public Long insert(PromoterEO eo) {
		if (eo.getPromoterId() != null) {
            ibatisTemplete.insert("PromoterDAOAbstract.insertHasId", eo);
            return eo.getPromoterId();
        } else {
            Long ppId = (Long) ibatisTemplete.insert("PromoterDAOAbstract.insert", eo);
            eo.setPromoterId(ppId);
            return ppId;
        }
	}

	@Override
	public PromoterEO select(Long id) {
		return (PromoterEO)ibatisTemplete.queryForObject("PromoterDAOAbstract.select", id);
	}

	@Override
	public PromoterEO selectAndLock(Long id) {
		Map<String , Object> map = new HashMap<String,Object>();
		map.put("id", id);
		map.put("isLock", true);
		return (PromoterEO)ibatisTemplete.queryForObject("PromoterDAOAbstract.selectAndLock", map);
	}

	@Override
	public PromoterEO selectEOByEO(PromoterEO eo) {
		return (PromoterEO)ibatisTemplete.queryForObject("PromoterDAOAbstract.selectEOByEO", eo);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<PromoterEO> selectListByEO(PromoterEO eo, int pageNO,int pageSize) {
		return ibatisTemplete.queryForList("PromoterDAOAbstract.selectListByEO", eo,(pageNO-1)*pageSize,pageSize);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<PromoterEO> selectListByEO(PromoterEO eo) {
		return ibatisTemplete.queryForList("PromoterDAOAbstract.selectListByEO", eo);
	}

	@Override
	public int update(PromoterEO eo) {
		int update = ibatisTemplete.update("PromoterDAOAbstract.update", eo);
		if(update ==0){
			throw new OptimisticLockingFailureException("更新纪录[" + eo + "]时发生乐观锁并发异常");
		}
		eo.setPmtVersion(eo.getPmtVersion()+1);
		return update;
	}

	@Override
	public int updateByField(PromoterEO eo) {
		int update = ibatisTemplete.update("PromoterDAOAbstract.updateByField", eo);
		if(update ==0){
			throw new OptimisticLockingFailureException("更新纪录[" + eo + "]时发生乐观锁并发异常");
		}
		eo.setPmtVersion(eo.getPmtVersion()+1);
		return update;
	}

	
}
