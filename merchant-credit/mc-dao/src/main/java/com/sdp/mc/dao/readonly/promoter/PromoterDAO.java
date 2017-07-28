package com.sdp.mc.dao.readonly.promoter;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

import com.shengpay.commons.core.base.BaseDAO2;

/**
 *
 * @author zhangguoliang.burt 拓展商持久化操作接口
 */
@Deprecated
public interface PromoterDAO extends BaseDAO2<PromoterEO> {

	/**
	 * 根据条件查询拓展商数量
	 *
	 * @param cond
	 * @return
	 */
	public int queryCountPromoters(PromoterCond cond);

	/**
	 * 根据条件查询拓展商
	 *
	 * @param cond
	 * @return
	 */
	public List<PromoterEO> queryPromoters(PromoterCond cond);

	/**
	 * 根据拓展商Id查询拓展商信息 select * from cm_merchant_contract mc ,
	 * cm_promoter pmt where mc.mc_id_n = pmt.pmt_id_n and
	 * pmt.pmt_id_n=#mcId:NUMBERIC#
	 */
	public PromoterEO queryPromoterByMcId(Long mcId);

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
	public PromoterEO queryPromoterInfoByMerchantNo(String merchantNo);

	/**
	 * 根据拓展商号查询拓展商ID mc_type_c='0007 mPOS拓展商
	 */
	public Long queryPromoterByMcMerchantNo(String mcMerchantNo);

	/**
	 * 根据posmPromoterId查询代理商信息
	 * 出款调用
	 */
	public List<PromoterEO> queryPromoterListByMerchantNo(String merchantNo);

	/**
	 * query all, no pageing
	 *
	 * @author zhangmeng.michael
	 * @param cond
	 * @return
	 */
	List<PromoterEO> queryAllPromoters(PromoterCond cond);

	/**
	 *
	 * @param list
	 * @return
	 */
	Map<String, String> selectPosPromoterInfo(List<String> list);

	/**
	 *
	 * @param list
	 * @return
	 */
	Map<String, String> selectMposPromoterInfo(List<String> list);

	/**
	 * 根据POS代理商的商户号和MC_TYPE 查询唯一的 PromoterEO
	 *
	 * @param merchantNO
	 * @param mcType
	 * @return
	 */
	public PromoterEO queryPromoterInfoByMerchantNoAndMcType(Long merchantNO, String mcType);

	/**
	 * 根据商户号获取代理商号
	 * @param merchantNo
	 * @param mcType
	 * @return
	 */
	public String queryPromoterNoByMerchantNo(String merchantNo, String mcType);

	public PromoterEO queryPromoterByPromoterNo(String merchantNo);


	/**
	 * 出款调用   (代理商)总额度
	 */
	public List<PromoterEO> queryLimitByMerchantNo(String merchantNo,String mcType);

	/**
	 * 出款调用    查代理商信息
	 * @param pmtMerchantNo 代理商 商户号
	 * @param pmtType       代理商类型
	 * @return
	 */
	public List<PromoterEO> queryByMerchantNo(String pmtMerchantNo,String pmtType);
	/**
	 * 出款调用 -查代理商信息
	 * @param posmPromoterId 代理商ID
	 * @return
	 */
	public PromoterEO queryPromoterById(Long posmPromoterId);

    /**
     * 查询代理信息  通过过商户  的商户号
     * @param merchantNo 商户号
     * @param mcType 商户类型
     * @return
     */
	List<PromoterEO> queryPromoterInfoByMerchantInfo(String merchantNo, String mcType);
	/**
	 * 查询代理商信息，关联fw_pos_merchant_info
	 * @param merchantNo
	 * @param mcType
	 * @return
	 */
	List<PromoterEO> queryPromoterFastSettleInfo (String merchantNo, String mcType);

	public List<PromoterEO> queryPromoterAll();

	public List<PromoterEO> queryPromoterInfo(List<String> merchantNoList);

}
