package com.sdp.mc.dao.readonly.merchantSettleItem;

import java.util.List;
@Deprecated
public interface MerchantSettleItemDAO {

	/**
	 * 新建商户结算规则
	 * @param eo
	 * @return
	 */
	public Long insert(MerchantSettleItemEO eo);

	/**
	 * 删除商户的结算规则
	 * @param merchantNo
	 * @return
	 */
	public int deleteByMerchantNo(String merchantNo,Long msiStatus);

	/**
	 * 根据商户号查询商户的结算规则
	 * @param merchantNo
	 * @return
	 */
	public List<MerchantSettleItemEO> queryEOByMerchantNo(String merchantNo);

	public void invalidByMsiId(Long msiId);

	public List<MerchantSettleItemEO> queryListByMerchantNoAdStatus(String merchantNo,Long status);

	public void updateSttleItemProirity(Long msiId, Long msiPriority);

	/**
	 * 根据商户号查询商户的快速结算规则
	 * @param merchantNo
	 * @return
	 */
	public MerchantSettleItemEO queryFastSettleItmeByMerchantNo(String merchantNo);

	public List<MerchantSettleItemEO> queryFastSettleItmeByMerchantList(String merchantNo);

}
