package com.sdp.mc.dao.readonly.promoter;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

/**
 * @author zhangguoliang.burt 拓展商持久化操作
 */
@Repository("promoterDAO")
@Deprecated
public class PromoterDAOImpl extends PromoterDAOImplAbstract {

	// <select id="queryPromoterInfoByMerchantNoAndMcType"
	// parameterClass="java.util.Map"
	// resultMap="PromoterDAOAbstract.promoterResult">
	// select * from CM_PROMOTER prom inner join
	// CM_MERCHANT_CONTRACT cmc
	// ON prom.pmt_id_n = cmc.mc_id_n and cmc.mc_merchant_no_v = #merchantNo#
	// and cmc.MC_TYPE_C = #mcType#
	// </select>

	/**
	 * 根据POS代理商的商户号和MC_TYPE 查询唯一的 PromoterEO
	 *
	 * @param merchantNO
	 * @param mcType
	 * @return
	 */
	@SuppressWarnings("unchecked")
	@Deprecated
	public PromoterEO queryPromoterInfoByMerchantNoAndMcType(Long merchantNo, String mcType) {
		HashMap<String, Object> map = new HashMap<String, Object>();
		String merchantNoStr="";
		if(merchantNo!=null){
			merchantNoStr=merchantNo.toString().trim();
		}
		map.put("merchantNo", merchantNoStr);
		map.put("mcType", mcType);
		List<PromoterEO> promoterEOs = ibatisTemplete.queryForList("PromoterDAO.queryPromoterInfoByMerchantNoAndMcType", map);
		if (promoterEOs == null || promoterEOs.isEmpty()) return null;
		return promoterEOs.get(0);
	}

	/**
	 * 根据条件查询拓展商数量
	 *
	 * @param cond
	 * @return
	 */
	public int queryCountPromoters(PromoterCond cond) {
		return (Integer) ibatisTemplete.queryForObject("PromoterDAO.queryCountPromoters", cond);
	}

	/**
	 * 根据条件查询拓展商
	 *
	 * @param cond
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public List<PromoterEO> queryPromoters(PromoterCond cond) {
		return ibatisTemplete.queryForList("PromoterDAO.queryPromoters", cond, (cond.getPageNo() - 1) * cond.getPageSize(), cond.getPageSize());
	}

	/**
	 * 根据条件查询拓展商(no page)
	 *
	 * @author zhangmeng.michael
	 * @param cond
	 * @return
	 */
	@Override
	@SuppressWarnings("unchecked")
	public List<PromoterEO> queryAllPromoters(PromoterCond cond) {
		return ibatisTemplete.queryForList("PromoterDAO.queryPromoters", cond);
	}

	/**
	 * 根据拓展商Id查询拓展商信息 select * from cm_merchant_contract mc ,
	 * cm_promoter pmt where mc.mc_id_n = pmt.pmt_id_n and
	 * pmt.pmt_id_n=#mcId:NUMBERIC#
	 */
	public PromoterEO queryPromoterByMcId(Long mcId) {
		return (PromoterEO) ibatisTemplete.queryForObject("PromoterDAO.queryPromoterByMcId", mcId);
	}

	/**
	 * 根据商户号查询拓展商信息 0001 - 合同类型:POS商户 0006 - 合同类型:POS商户 select cp.* from
	 * cm_merchant_contract cmc, cm_promoter cp,
	 * cm_pos_merchant posm where cmc.mc_id_n = posm.posm_id_n and
	 * posm.posm_promoter_id_n = cp.pmt_id_n and (cmc.mc_type_c='0001' or
	 * cmc.mc_type_c='0006') and cmc.mc_merchant_no_v = #value#
	 *
	 * @param merchantNo
	 * @return
	 */
	@SuppressWarnings("unchecked")
	@Deprecated
	public PromoterEO queryPromoterInfoByMerchantNo(String merchantNo) {
		List<PromoterEO> list = ibatisTemplete.queryForList("PromoterDAO.queryPromoterInfoByMerchantNo", merchantNo);
		return list != null ? list.get(0) : null;
	}
	@SuppressWarnings("unchecked")
	@Deprecated
	public List<PromoterEO> queryPromoterListByMerchantNo(String merchantNo) {
		List<PromoterEO> list = ibatisTemplete.queryForList("PromoterDAO.queryPromoterInfoByMerchantNo", merchantNo);
		return list;
	}

	/**
	 * T0出款调用    (代理商)总额度
	 */
	@SuppressWarnings("unchecked")
	@Deprecated
	public List<PromoterEO> queryLimitByMerchantNo(String merchantNo,String mcType) {
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("merchantNo", merchantNo);
		map.put("mcType", mcType);
		return ibatisTemplete.queryForList("PromoterDAO.queryMerchantByMerchantNo", map);
	}
	/**
	 * 出款调用    查代理商信息
	 * @param pmtMerchantNo 代理商 商户号
	 * @param pmtType       代理商类型
	 * @return
	 */
	@SuppressWarnings("unchecked")
	@Override
	@Deprecated
	public List<PromoterEO> queryByMerchantNo(String pmtMerchantNo, String pmtType) {
		// TODO Auto-generated method stub
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("merchantNo", pmtMerchantNo);
		map.put("mcType", pmtType);
		return ibatisTemplete.queryForList("PromoterDAO.queryByMerchantNo", map);
	}
	/**
	 * 查代理商信息
	 */
	@SuppressWarnings("unchecked")
	@Override
	@Deprecated
	public List<PromoterEO> queryPromoterInfoByMerchantInfo(String merchantNo, String mcType) {
		// TODO Auto-generated method stub
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("merchantNo", merchantNo);
		map.put("mcType", mcType);
		return ibatisTemplete.queryForList("PromoterDAO.queryPromoterInfoByMerchantInfo", map);
	}
	/**
	 * 查代理商信息
	 */
	@SuppressWarnings("unchecked")
	@Override
	@Deprecated
	public List<PromoterEO> queryPromoterFastSettleInfo(String merchantNo, String mcType) {
		// TODO Auto-generated method stub
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("merchantNo", merchantNo);
		map.put("mcType", mcType);
		return ibatisTemplete.queryForList("PromoterDAO.queryPromoterFastSettleInfo", map);
	}
	/**
	 * 出款调用    (查询商户信息)
	 */
	@Deprecated
	public PromoterEO queryPromoterById(Long posmPromoterId) {
		return (PromoterEO) ibatisTemplete.queryForObject("PromoterDAO.queryPromoterById", posmPromoterId);
	}

	/**
	 * 根据拓展商号查询拓展商ID mc_type_c='0007 mPOS拓展商
	 */
	@Deprecated
	public Long queryPromoterByMcMerchantNo(String promoterNo) {
		return (Long) ibatisTemplete.queryForObject("PromoterDAO.queryPromoterByMcMerchantNo", promoterNo);
	}

	//根据代理商商户号查询代理商信息
	@SuppressWarnings("unchecked")
	@Deprecated
	public PromoterEO queryPromoterByPromoterNo(String merchantNo) {
		HashMap<String, Object> map = new HashMap<String, Object>();
		String merchantNoStr="";
		if(merchantNo!=null){
			merchantNoStr=merchantNo.toString().trim();
		}
		map.put("merchantNo", Integer.valueOf(merchantNoStr));
		List<PromoterEO> promoterEOs = ibatisTemplete.queryForList("PromoterDAO.queryPromoterByPromoterNo", map);
		if (promoterEOs==null || promoterEOs.isEmpty()) return null;
		return promoterEOs.get(0);
	}

	@Override
	@Deprecated
	public Map<String, String> selectPosPromoterInfo(List<String> list) {
		return this.selectPromoterInfo(list, false);
	}

	@Override
	@Deprecated
	public Map<String, String> selectMposPromoterInfo(List<String> list) {
		return this.selectPromoterInfo(list, true);
	}

	/**
	 * 数据大于1000, 分割查询
	 *
	 * @param list
	 * @param isMpos
	 * @return
	 */
	@Deprecated
	private Map<String, String> selectPromoterInfo(List<String> list, boolean isMpos) {
		Map<String, String> result = new HashMap<String, String>();
		int size = list.size();
		int max = 10;
		if (size <= max) {
			result = this.doSelectPromoterInfo(list, isMpos);
		} else {
			int mod = size % max;
			int count = 0;
			if (mod == 0) {
				count = size / max;
			} else {
				count = size / max + 1;
			}
			List<String> tmp;
			for (int i = 0; i < count; i++) {
				int s = (i) * max;
				int e = (i + 1) * max;
				if (e > size) {
					e = size;
				}
				tmp = list.subList(s, e);
				result.putAll(this.doSelectPromoterInfo(tmp, isMpos));
			}
		}
		return result;
	}

	/**
	 * 查询,参数小于1000
	 *
	 * @param list
	 * @param isMpos
	 * @return
	 */
	@SuppressWarnings("unchecked")
	private Map<String, String> doSelectPromoterInfo(List<String> list, boolean isMpos) {
		Map<String, String> map = new HashMap<String, String>();
		List<Map<String, String>> tmp = null;
		if (isMpos) {
			tmp = ibatisTemplete.queryForList("PromoterDAO.selectMposPromoterInfo", list);
		} else {
			tmp = ibatisTemplete.queryForList("PromoterDAO.selectPosPromoterInfo", list);
		}
		if (tmp != null && tmp.size() > 0) {
			for (Map<String, String> m : tmp) {
				map.put(m.get("no"), m.get("name"));
			}
		}
		return map;
	}
	@Deprecated
	public String queryPromoterNoByMerchantNo(String merchantNo, String mcType) {
		HashMap<String, Object> map = new HashMap<String, Object>();
		String merchantNoStr="";
		if(merchantNo!=null){
			merchantNoStr=merchantNo.toString().trim();
		}
		map.put("merchantNo", merchantNoStr);
		map.put("mcType", mcType);
		Object o = ibatisTemplete.queryForObject("PromoterDAO.queryPromoterNoByMerchantNo", map);
		return o==null?"":o.toString();
	}

	@Override
	public List<PromoterEO> queryPromoterAll() {
		return ibatisTemplete.queryForList("PromoterDAO.queryPromoterAll", new HashMap<String, Object>());
	}

	@Override
	public List<PromoterEO> queryPromoterInfo(List<String> merchantNoList) {
		return ibatisTemplete.queryForList("PromoterDAO.queryPromoterInfo", merchantNoList);
	}
}
