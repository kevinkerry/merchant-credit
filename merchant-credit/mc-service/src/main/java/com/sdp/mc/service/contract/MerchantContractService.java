package com.sdp.mc.service.contract;

import java.util.List;
import java.util.Map;

/**
 * 商户合同
 * @author liuxi.xiliu
 */
public interface MerchantContractService {

	/**
	 * 查询商户类型
	 */
	public List<Map<String, Object>> selectMerchantTypes( String merchantNo );

	/**
	 * 根据商户号取得pos拓展商
	 */
	public MerchantContractRO queryPosPromoterByMerchantNo( String merchantNo );

	/**
	 * 根据商户号获取mpos商户
	 * @param merchantNo
	 * @return
	 */
	public MerchantContractRO queryMposByMerchantNo( String merchantNo);

	/**
	 * 根据登录账号及商户类型查询记录
	 * @param loginAccount
	 * @param mcType
	 * @return
	 */
	public MerchantContractRO queryMerchantByLoginAccountAdType(String loginAccount,String mcType);

	/**
	 * 根据商户号查询是否已经进件
	 * @param merchantNo
	 * @return
	 */
	public int queryCountByOriginalMerchantNo(String merchantNo);
	/**
	 * 根据代理商查询代理商商户号
	 * @param promoterId
	 * @return
	 */
	public String selectPromoterNoByPromoterId(Long promoterId);
}
