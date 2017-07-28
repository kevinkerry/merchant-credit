package com.sdp.mc.service.newt0;

import com.sdp.mc.newt0.dao.Newt0PromoterDO;
import com.sdp.mc.newt0.dao.Newt0PromoterDOExample;

/**
 * 垫资信息
 * 
 * @author zhangyulong
 * 
 */
public interface Newt0PromoterService {
	/**
	 * 根据商户编码查询垫资方信息
	 * 
	 * @param merchantId
	 * @return
	 */
	public Newt0PromoterDO getPromoterByMerchantId(Long merchantId);

	int updateByExampleSelective(Newt0PromoterDO record, Newt0PromoterDOExample example);

	Long insertSelective(Newt0PromoterDO record);

	/**
	 * 根据代理商id获取垫资方
	 * 
	 * @param promoterId
	 * @return
	 */
	Integer getLoaningTypeByPromoterId(Long promoterId);

	int deleteByExample(Newt0PromoterDOExample example);

	int deleteByPromoterId(Long promoterId);

}
