package com.sdp.mc.dao.readonly.msp.mspposmerchant;

import java.math.BigDecimal;
import java.util.List;

/**
 * (msp)POS商户表
 * @author liuxi.xiliu
 */
@Deprecated
public interface MspPosMerchantDAO {
	/**
	 * 代理商查询POS商户条数
	 */
	public Integer pmtQueryPosMerchantCount( PmtQueryPosMerchantCond cond );

	/**
	 * 代理商查询POS商户结果集
	 */
	public List<MspPosMerchantEO> pmtQueryPosMerchant( PmtQueryPosMerchantCond cond );
	/**
	 * 代理商查询POS商户结果集全部，不分页20130314
	 * @param cond
	 * @return
	 */
	public List<MspPosMerchantEO> pmtQueryAllPosMerchant( PmtQueryPosMerchantCond cond );
	/**
	 * 根据id查询
	 */
	public MspPosMerchantEO selectById( Long id );
	/**
	 * 根据merchantNo查询(pos商户)
	 */
	public MspPosMerchantEO selectByMerchantNo( String merchantNo );

	/**
	 * 根据merchantNo查询(pos商户,mpos商户)
	 */
	public MspPosMerchantEO selectMcByMerchantNo( String merchantNo );

	/**
	 * 插入
	 */
	public void insert( MspPosMerchantEO eo );

	/**
	 * 更新
	 */
	public int update( MspPosMerchantEO eo );

	/**
	 * 更新绑定操作员
	 */
	public int updatePmtBindOperator( MspPosMerchantEO eo );

	/**
	 * 根据POS商户号、类型、代理商商户号查询
	 */
	public MspPosMerchantEO queryByPosmNoTypePmtNo( String posMerchantNo, String merchantType, String pmtMerchantNo );

	/**
	 * 修改商户的快速结算信息
	 */
	public int updateSettFast( Long settFastId, Long fastSettleFlag, Long fastSettleLimit );

	/**
	 * 查询代理商已使用的快速结算额度
	 */
	public BigDecimal queryPmtUsedFastSettleLimit(String pmtMerchantNo,String merchantType,String currMerchantNo);

	/**
	 * 根据merchantNo查询商户费率
	 */
	public MspPosMerchantEO selectPosMerchantInfoByMerchantNo( String merchantNo );
	/**
	 * 查询mpos商户信息
	 */
	public MspPosMerchantEO selectByMerchantNoForMpos(String merchantNo,String mcType);

	/**
	 * 出款调用-查商户信息
	 * @param merchantNo 商户号
	 * @param mcType 商户类型
	 * @return
	 */
	public List<MspPosMerchantEO> selectByMerchantNoAndType(String merchantNo,String mcType);

	/**
	 * 出款调用-查询所有商户信息
	 * @return
	 */
	public List<MspPosMerchantEO> queryAllMspMerchant();
    /**
     * 查询商户或者代理商的信息
     * @param merchantNo 代理商/商户号
     * @param mcType
     * @return
     */
	public List<MspPosMerchantEO> selectPromoterOrMerchantInfoByMerchantNoAndType(String merchantNo, String mcType);

	public List<MspPosMerchantEO> querySyncPosMerchantInfo(PmtQueryPosMerchantCond cond);
}