package com.sdp.mc.dao.readonly.merchant;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Repository;

import com.shengpay.commons.springtools.base.IbatisBaseDAOImpl;

/**
 * (cm)POS商户
 *
 * @author liuxi.xiliu
 */
@Repository("cmPosMerchantDAO")
@Deprecated
public class CmPosMerchantDAOImpl implements CmPosMerchantDAO {

	/**
	 * IBatis模板在spring配置文件中的beanId
	 */
	@Resource(name = "ibatisTemplate_mc")
	protected IbatisBaseDAOImpl ibatisTemplete;

	/**
	 * o 根据最后更新时间段，查询POS商户
	 */
	public List<CmPosMerchantEO> selectByLastUpdateTimeRange(Date startLastUpdateTime, Date endLastUpdateTime) {
		Map<String, Date> params = new HashMap<String, Date>();
		params.put("startLastUpdateTime", startLastUpdateTime);
		params.put("endLastUpdateTime", endLastUpdateTime);
		List<CmPosMerchantEO> list = ibatisTemplete.queryForList("CmPosMerchantDAO.selectByLastUpdateTimeRange", params);
		return list;
	}

	/**
	 * 根据最后更新时间段，查询POS商户
	 */
	public CmPosMerchantEO selectById(Long posmId) {
		List<CmPosMerchantEO> list = ibatisTemplete.queryForList("CmPosMerchantDAO.selectById", posmId);
		return list.size() > 0 ? list.get(0) : null;
	}

	/**
	 * 根据商户号取得POS商户号
	 */
	public String queryPosMerchantNoByMerchantNo(String merchantNo) {
		List<String> list = ibatisTemplete.queryForList("CmPosMerchantDAO.queryPosMerchantNoByMerchantNo", merchantNo);
		return list.size() > 0 ? list.get(0) : null;
	}


	/**
	 * 根据最后更新时间段，分页查询POS商户
	 */
	public List<CmPosMerchantEO> selectByLastUpdateTimeRangeAndPage(Date startLastUpdateTime, Date endLastUpdateTime, int skipResults, int maxResults) {
		Map<String, Date> params = new HashMap<String, Date>();
		params.put("startLastUpdateTime", startLastUpdateTime);
		params.put("endLastUpdateTime", endLastUpdateTime);
		List<CmPosMerchantEO> list = ibatisTemplete.queryForList("CmPosMerchantDAO.selectByLastUpdateTimeRange", params, skipResults, maxResults);
		return list;
	}

	/**
	 * 根据商户号(POS)拉取 法人名称
	 *
	 * @param merchantNo
	 * @return
	 */
	public String querylegalPersonByMerchantNo(String merchantNo) {
		Object o = ibatisTemplete.queryForObject("CmPosMerchantDAO.queryCmPosMerchantEOByMerchantNo", merchantNo);
		return o == null ? null : (String) o;
	}

	@Override
	public int queryCountByOriginalMerchantNo(String merchantNo) {
		return (Integer) ibatisTemplete.queryForObject("CmPosMerchantDAO.queryCountByOriginalMerchantNo", merchantNo);
	}

	/**
	 * 根据pos商户编号查询
	 */
	@Override
	public CmPosMerchantEO queryPosMerchantByNo(String posMerchantNO) {
		Object o = ibatisTemplete.queryForObject("CmPosMerchantDAO.queryPosMerchantByNo", posMerchantNO);
		return o == null ? null : (CmPosMerchantEO) o;
	}

	@Override
	public String queryPosMerchantPolicyIdByMcId(Long posmId) {
		List<String> list = ibatisTemplete.queryForList("CmPosMerchantDAO.queryPosMerchantPolicyIdByMcId", posmId);
		return list.size() > 0 ? list.get(0) : null;
	}

}
