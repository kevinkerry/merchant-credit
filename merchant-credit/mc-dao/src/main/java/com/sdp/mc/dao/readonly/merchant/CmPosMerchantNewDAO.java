package com.sdp.mc.dao.readonly.merchant;

import java.util.List;

import com.sdp.mc.dao.readonly.merchantcontract.CmMerchantContractEO;

/**
 * (cm)POS商户
 * @author liutao
 */
@Deprecated
public interface CmPosMerchantNewDAO {

	public String selectPromoterNoByPromoterId(Long promoterId);

	/**
	 * 根据商户号获取商户合信息
	 * 进网时间=合同签订日期=mcCreateTime
	 * @param merchantNo
	 * @return
	 */
	public CmMerchantContractEO selectContractInfo(String merchantNo);
	/**
	 * 连续收单六个月
	 * @param merchantNo
	 * @param monthCount 默认-6  6个月之前为-6， 6个月之后为6
	 * @return
	 */
	public boolean selectOPenContract(String merchantNo,int monthCount);

	/**
	 * 根据代理商id查询代理商信息
	 * @param promoterId
	 */
	public CmMerchantContractEO selecMerchantInfo(String promoterId);
	/**
	 * 获取即使mpos代理商又是pos代理商的数据
	 * @return
	 */
	/**
	 * 获取所有参与取回保证金的代理商信息
	 */
	public List<CmPosMerchantFastEOExt> selectFastAmount();

}

