package com.sdp.mc.dao.readonly.merchantsettle;

import java.util.List;

@Deprecated
public interface MerchantSettleDAO {

	/**
	 * 新建商户的结算信息
	 * @param eo
	 * @return
	 */
	public Long insert(MerchantSettleEO eo);

	/**
	 * 根据商户号查询商户结算信息
	 * @param merchantNo
	 * @return
	 */
	public MerchantSettleEO selectEOByMerchantNo(String merchantNo);

	/**
	 * 更新商户的结算信息
	 * @param eo
	 * @return
	 */
	public int updateByEO(MerchantSettleEO eo);

	/**
	 * 前一天所创建的快速结算
	 * @return
	 */
	public List<MerchantSettleEO> queryMerchantSettleListByCreateYesterday();


	/**
	 * T0出款调用--根据商户号查询商户出款额度
	 * @param merchantNo 商户的商户号
	 * @return
	 */
	public List<MerchantSettleEO> selectByMerchantNo(String merchantNo);
}
