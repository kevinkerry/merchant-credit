package com.sdp.mc.service.msp.promoter;

import java.util.List;

import com.sdp.mc.dao.readonly.promoter.PromoterEO;
import com.shengpay.commons.core.base.PaginationBaseObject;


/**
 * @author zhangguoliang.burt
 * 拓展商
 */
@Deprecated
public interface PromoterService {
	
	/**
	 * 查询拓展商记录
	 * @param po
	 * @return
	 */
	public PaginationBaseObject<PromoterRO> queryPromoter(PromoterPO po);
	
	
	/**
	 * 根据拓展商Id查询相关信息
	 */
	public PromoterRO queryPromoterInfoById(Long mcId);
	
	
	/**
	 * 获取拓展商McId
	 * @param promoterNo
	 */
	public Long queryPromoterInfoByMcMerchantNo(String promoterNo);


	public List<PromoterEO> queryPromoterListByMerchantNo(String merchantNo);


	public List<PromoterEO> queryPromoterAll();


	public List<PromoterEO> queryPromoterInfo(List<String> merchantNoList);
}
