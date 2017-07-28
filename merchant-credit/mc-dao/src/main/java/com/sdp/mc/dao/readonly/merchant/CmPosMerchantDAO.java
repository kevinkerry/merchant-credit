package com.sdp.mc.dao.readonly.merchant;

import java.util.Date;
import java.util.List;

/**
 * (cm)POS商户
 * @author liuxi.xiliu
 */
@Deprecated
public interface CmPosMerchantDAO {
	/**
	 * 根据最后更新时间段，查询POS商户
	 */
	public List<CmPosMerchantEO> selectByLastUpdateTimeRange( Date startLastUpdateTime, Date endLastUpdateTime );

	/**
	 * 根据最后更新时间段，查询POS商户
	 */
	public CmPosMerchantEO selectById( Long posmId );

	/**
	 * 根据商户号取得POS商户号
	 */
	public String queryPosMerchantNoByMerchantNo( String merchantNo );
	/**
	 * 根据ID取得POS商户号政策ID
	 */
	public String queryPosMerchantPolicyIdByMcId( Long posmId );

	/**
	 * 根据最后更新时间段，分页查询POS商户
	 */
	public List<CmPosMerchantEO> selectByLastUpdateTimeRangeAndPage( Date startLastUpdateTime,
			Date endLastUpdateTime ,int skipResults, int maxResults);

	/**
	 * 根据商户号(POS)拉取 法人名称
	 * @param merchantNo
	 * @return
	 */
	public String querylegalPersonByMerchantNo(String merchantNo);

	/**
	 * 查询商户号是否已经进件
	 * @param merchantNo
	 * @return
	 */
	public int queryCountByOriginalMerchantNo(String merchantNo);

    /**
     * 根据pos商户编号查询
     */
    public CmPosMerchantEO queryPosMerchantByNo(String posMerchantNO);

}

