package com.sdp.mc.dao.readonly.posmerchant;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.sdp.mc.common.constant.MerchantContractCst;
import com.sdp.mc.common.util.ListUtil;

/**
 * POS商户访问接口默认实现
 * 
 * @author wangyiyong@snda.com
 */
@Repository("posMerchantDAO")
@Deprecated
public class PosMerchantDAOImpl extends PosMerchantDAOImplAbstract {

	/**
	 * 查询pos商户Count
	 */
	public Integer queryMerchantCount(PosMerchantCond cond) {
		Object obj = ibatisTemplete.queryForObject("PosMerchantDAO.queryPosMerchantCount", cond);
		return Integer.parseInt(String.valueOf(obj));
	}

	/**
	 * 查询pos商户List
	 */
	@SuppressWarnings("unchecked")
	public List<PosMerchantEO> queryMerchantList(PosMerchantCond cond) {
		List<PosMerchantEO> list = ibatisTemplete.queryForList("PosMerchantDAO.queryPosMerchantList", cond,
				(cond.getPageNo() - 1) * cond.getPageSize(), cond.getPageSize());
		return list;
	}
	
	/**
	 * 查询pos商户快速结算 Count
	 */
	public Integer queryMerchantFastSettleCount(PosMerchantCond cond) {
		Object obj = ibatisTemplete.queryForObject("PosMerchantDAO.queryPosMerchantFastSettleCount", cond);
		return Integer.parseInt(String.valueOf(obj));
	}

	/**
	 * 查询pos商户快速结算 List
	 */
	@SuppressWarnings("unchecked")
	public List<PosMerchantEO> queryMerchantFastSettleList(PosMerchantCond cond) {
		List<PosMerchantEO> list = ibatisTemplete.queryForList("PosMerchantDAO.queryPosMerchantFastSettleList", cond,
				(cond.getPageNo() - 1) * cond.getPageSize(), cond.getPageSize());
		return list;
	}

	/**
	 * 未选择
	 */

	@SuppressWarnings("unchecked")
	@Override
	public List<PosMerchantEO> queryMerchantPromoterList(List<String> posMerchantNOList) {
		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("posMerchantNOList", posMerchantNOList);
		return ibatisTemplete.queryForList("PosMerchantDAO.queryMerchantPromoterList", paramMap);
	}

	/**
	 * 根据合同号查询非删除状态的合同(唯一)
	 */
	@SuppressWarnings("unchecked")
	public PosMerchantEO queryPosMerchantNotDeleted(String contractNO) {
		Map paramMap = new HashMap();
		paramMap.put("contractNO", contractNO);
		paramMap.put("status", MerchantContractCst.MC_STATUS_DELETE);
		List<PosMerchantEO> list = ibatisTemplete.queryForList("PosMerchantDAO.queryPosMerchantNotDeleted", paramMap);
		return list.size() == 0 ? null : list.get(0);
	}

	/**
	 * 根据pos商户编号查询合同id（审核通过或激活状态）
	 */
	@SuppressWarnings("unchecked")
	public Long queryPosMerchantIdByNo(String posMerchantNO) {
		Map paramMap = new HashMap();
		paramMap.put("posMerchantNO", posMerchantNO);
		paramMap.put("status", "'" + MerchantContractCst.MC_STATUS_ACTIVE + "','" + MerchantContractCst.MC_STATUS_CONFIRM + "'");
		Object obj = ibatisTemplete.queryForObject("PosMerchantDAO.queryPosMerchantIdByNo", paramMap);
		return obj == null ? null : (Long) obj;
	}

	/**
	 * getMerchantNoByMposPromoter
	 * 
	 * @param pmtMerchantNo
	 *            拓展商的商户号
	 * @return 所有mpos商户的商户号
	 */
	public List<String> getMerchantNoByMposPromoter(String pmtMerchantNo) {
		List<String> list = ibatisTemplete.queryForList("PosMerchantDAO.getMerchantNoByMposPromoter", pmtMerchantNo);
		return list;
	}

	/**
	 * 根据商户号查询(pos/mpos/minipos)商户信息
	 * 
	 * @param merchantType
	 *            商户类型pos/mpos/minipos
	 * @return 商户信息，最大5000
	 */
	public List<PosMerchantEO> queryMerchantListByType(String merchantType, int pageNo, int pageSize) {
		List<PosMerchantEO> list = ibatisTemplete.queryForList("PosMerchantDAO.queryMerchantListByType", merchantType, (pageNo - 1) * pageSize,
				pageSize);
		return list;
	}

	/**
	 * 根据终端号 查询商户信息
	 */
	@Override
	public PosMerchantEO queryPosMerchantByTerminalNO(String terminalNO) {
		Object obj = ibatisTemplete.queryForObject("PosMerchantDAO.queryPosMerchantIdByTerminalNo", terminalNO);
		return obj == null ? null : (PosMerchantEO) obj;
	}

	/**
	 * 根据商户号查询pos商户
	 */
	@Override
	public List<PosMerchantEO> queryMerchantByMerchantNO(String merchantNO, String[] mcType, String[] mcStatus) {
		HashMap<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("merchantNO", merchantNO);
		paramMap.put("status", ListUtil.join(mcStatus, "'", "'", ","));
		paramMap.put("mcType", ListUtil.join(mcType, "'", "'", ","));

		return ibatisTemplete.queryForList("PosMerchantDAO.queryPosMerchantByMerchantNO", paramMap);
	}

	/**
	 * 根据mcId更新mccId
	 */
	public void updateMccByPosmId(Long mcId, Long mccId, String mccName) {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("mcId", mcId);
		params.put("mccId", mccId);
		params.put("mccName", mccName);
		ibatisTemplete.update("PosMerchantDAO.updateMccByPosmId", params);
	}

	@Override
	public int updatePromoter(Long oldPromoterId, Long newPromoterId, String mcType, String newPromoterName) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("oldPromoterId", oldPromoterId);
		map.put("newPromoterId", newPromoterId);
		map.put("mcType", mcType);
		map.put("newPromoterName", newPromoterName);
		return ibatisTemplete.update("PosMerchantDAO.updatePromoter", map);
	}

	/**
	 * 根据终端号 查询商户信息(适配Mpos库存导入)
	 * 
	 * @return
	 */
	public PosMerchantEO queryPosMerchantEOByMposInfo(String terminalNo) {
		Object obj = ibatisTemplete.queryForObject("PosMerchantDAO.queryPosMerchantEOByMposInfo", terminalNo);
		return obj == null ? null : (PosMerchantEO) obj;
	}

	/**
	 * 获取商户拓展商下的所有商户
	 * 
	 * @param pmtMerchantNo
	 * @return
	 */
	public List<String> getPromoterChildByMerchantNo(String pmtMerchantNo) {
		List<String> list = ibatisTemplete.queryForList("PosMerchantDAO.getPromoterChildByMerchantNo", pmtMerchantNo);
		return list;
	}

	/**
	 * 根据盛付通商户号查询出POS商户号（15位）
	 * 
	 * @return
	 */
	public List<String> getPosMerchantNoByMerchantNo(String merchantNo) {
		return ibatisTemplete.queryForList("PosMerchantDAO.getPosMerchantNoByMerchantNo", merchantNo);
	}

	@Override
	public void updateMerchantPomoter(PosMerchantEO eo) {
		ibatisTemplete.update("PosMerchantDAO.updateMerchantPomoter", eo);

	}

	@Override
	public PosMerchantEO qryMerchantByMerchantNoAdMcType(String merchantNo, String mcType) {
		Map<String, String> map = new HashMap<String, String>();
		map.put("merchantNo", merchantNo);
		map.put("mcType", mcType);
		return (PosMerchantEO) ibatisTemplete.queryForObject("PosMerchantDAO.qryMerchantByMerchantNoAdMcType", map);
	}

	/**
	 * 查询商户信息根据商户编号
	 * 
	 * @param TermId
	 * @return
	 */
	public PosMerchantEO queryPosMerchantEOByTermId(Long termId) {
		Object obj = ibatisTemplete.queryForObject("PosMerchantDAO.queryPosMerchantEOByTermId", termId);
		return obj == null ? null : (PosMerchantEO) obj;
	}

	/**
	 * 根据MCCCode查询进件费率
	 * 
	 * @param mccCode
	 * @return
	 */
	public BigDecimal queryMccFeeByMccCode(String mccCode) {
		Object obj = ibatisTemplete.queryForObject("PosMerchantDAO.queryMccFeeByMccCode", mccCode);
		return obj == null ? null : (BigDecimal) obj;
	}
}
