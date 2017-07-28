package com.sdp.mc.dao.readonly.msp.mspposmerchant;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Repository;

import com.shengpay.commons.springtools.base.IbatisBaseDAOImpl;

/**
 * (msp)POS商户表
 *
 * @author liuxi.xiliu
 */
@Repository("mspPosMerchantDAO")
@Deprecated
public class MspPosMerchantDAOImpl implements MspPosMerchantDAO {

	/**
	 * IBatis模板在spring配置文件中的beanId
	 */
	@Resource(name = "ibatisTemplate_mc")
	protected IbatisBaseDAOImpl ibatisTemplete;

	/**
	 * 代理商查询POS商户条数
	 */
	public Integer pmtQueryPosMerchantCount(PmtQueryPosMerchantCond cond) {
		Integer count = (Integer) ibatisTemplete.queryForObject("MspPosMerchantDAO.pmtQueryPosMerchantCount", cond);
		return count;
	}

	/**
	 * 代理商查询POS商户结果集
	 */
	@SuppressWarnings("unchecked")
	public List<MspPosMerchantEO> pmtQueryPosMerchant(PmtQueryPosMerchantCond cond) {
		List<MspPosMerchantEO> list = ibatisTemplete.queryForList("MspPosMerchantDAO.pmtQueryPosMerchant", cond,
				(cond.getPageNo() - 1) * cond.getPageSize(), cond.getPageSize());
		return list;
	}

	/**
	 * 代理商查询POS商户结果集全部，不分页20130314
	 */
	@SuppressWarnings("unchecked")
	public List<MspPosMerchantEO> pmtQueryAllPosMerchant(PmtQueryPosMerchantCond cond) {
		List<MspPosMerchantEO> list = ibatisTemplete.queryForList("MspPosMerchantDAO.pmtQueryPosMerchant", cond);
		return list;
	}
	public List<MspPosMerchantEO> querySyncPosMerchantInfo(PmtQueryPosMerchantCond cond) {
		List<MspPosMerchantEO> list = ibatisTemplete.queryForList("MspPosMerchantDAO.querySyncPosMerchantInfo", cond);
		return list;
	}

	/**
	 * 根据id查询
	 */
	public MspPosMerchantEO selectById(Long id) {
		Object o = ibatisTemplete.queryForObject("MspPosMerchantDAO.selectById", id);
		return o == null ? null : (MspPosMerchantEO) o;
	}

	/**
	 * 插入
	 */
	public void insert(MspPosMerchantEO eo) {
		ibatisTemplete.insert("MspPosMerchantDAO.insert", eo);
	}

	/**
	 * 更新
	 */
	public int update(MspPosMerchantEO eo) {
		int n = ibatisTemplete.update("MspPosMerchantDAO.update", eo);
		eo.setVersion(eo.getVersion() + 1);
		return n;
	}

	/**
	 * 更新绑定操作员
	 */
	public int updatePmtBindOperator(MspPosMerchantEO eo) {
		int n = ibatisTemplete.update("MspPosMerchantDAO.updatePmtBindOperator", eo);
		eo.setVersion(eo.getVersion() + 1);
		return n;
	}

	/**
	 * 根据POS商户号、类型、代理商商户号查询
	 */
	public MspPosMerchantEO queryByPosmNoTypePmtNo(String posMerchantNo, String merchantType, String pmtMerchantNo) {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("posMerchantNo", posMerchantNo);
		params.put("merchantType", merchantType);
		params.put("pmtMerchantNo", pmtMerchantNo);
		Object o = ibatisTemplete.queryForObject("MspPosMerchantDAO.queryByPosmNoTypePmtNo", params);
		return o == null ? null : (MspPosMerchantEO) o;
	}

	@Override
	public MspPosMerchantEO selectByMerchantNo(String merchantNo) {
		return (MspPosMerchantEO) ibatisTemplete.queryForObject("MspPosMerchantDAO.selectByMerchantNo", merchantNo);
	}

	// ?? 有问题 MPOS商户有重复
	@Override
	public MspPosMerchantEO selectByMerchantNoForMpos(String merchantNo, String myType) {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("posMerchantNo", merchantNo);
		params.put("merchantType", myType);
		Object o = ibatisTemplete.queryForObject("MspPosMerchantDAO.selectByMPOSMerchantNo", params);
		return o == null ? null : (MspPosMerchantEO) o;
	}

	/**
	 * 根据merchantNo查询(pos,mpos)
	 */
	@Override
	public MspPosMerchantEO selectMcByMerchantNo(String merchantNo) {
		return (MspPosMerchantEO) ibatisTemplete.queryForObject("MspPosMerchantDAO.selectMcByMerchantNo", merchantNo);
	}

	/**
	 * 修改商户的快速结算信息
	 */
	public int updateSettFast(Long settFastId, Long fastSettleFlag, Long fastSettleLimit) {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("settFastId", settFastId);
		params.put("fastSettleFlag", fastSettleFlag);
		params.put("fastSettleLimit", fastSettleLimit);
		return ibatisTemplete.update("MspPosMerchantDAO.updateSettFast", params);
	}

	/**
	 * 查询代理商已使用的快速结算额度
	 */
	public BigDecimal queryPmtUsedFastSettleLimit(String pmtMerchantNo, String merchantType, String currMerchantNo) {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("pmtMerchantNo", pmtMerchantNo);
		params.put("merchantType", merchantType);
		params.put("currMerchantNo", currMerchantNo);
		return (BigDecimal) ibatisTemplete.queryForObject("MspPosMerchantDAO.queryPmtUsedFastSettleLimit", params);
	}

	/**
	 * 根据merchantNo查询商户费率
	 */
	public MspPosMerchantEO selectPosMerchantInfoByMerchantNo(String merchantNo) {
		return (MspPosMerchantEO) ibatisTemplete.queryForObject("MspPosMerchantDAO.selectPosMerchantInfoByMerchantNo", merchantNo);
	}

	/**
	 * 根据商户号 商户类型查询商户信息
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<MspPosMerchantEO> selectByMerchantNoAndType(String merchantNo,String mcType) {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("merchantNo", merchantNo);
		params.put("mcType", mcType);
		return ibatisTemplete.queryForList("MspPosMerchantDAO.selectByMerchantNoAndType", params);
	}
	@Override
	public List<MspPosMerchantEO> selectPromoterOrMerchantInfoByMerchantNoAndType(String merchantNo,String mcType) {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("merchantNo", merchantNo);
		params.put("mcType", mcType);
		return ibatisTemplete.queryForList("MspPosMerchantDAO.selectPromoterOrMerchantInfoByMerchantNoAndType", params);
	}

	/**
	 * 查询所有的商户信息
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<MspPosMerchantEO> queryAllMspMerchant() {
		// TODO Auto-generated method stub
		return ibatisTemplete.queryForList("MspPosMerchantDAO.queryAllMspMerchant");
	}


}
