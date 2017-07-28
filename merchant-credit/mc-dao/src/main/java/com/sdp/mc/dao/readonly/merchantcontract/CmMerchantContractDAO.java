package com.sdp.mc.dao.readonly.merchantcontract;

import java.util.List;
import java.util.Map;

/**
 * 商户合同
 * @author liuxi.xiliu
 */
@Deprecated
public interface CmMerchantContractDAO {
	/**
	 * 查询商户类型
	 */
	public List<Map<String, Object>> selectMerchantTypesByNo( String merchantNo );
	
	/**
	 * 根据id查询
	 */
	public CmMerchantContractEO selectById( Long id );
	
	/**
	 * 根据商户号取得pos拓展商
	 */
	public CmMerchantContractEO queryPosPromoterByMerchantNo( String merchantNo );
	
	/**
	 * 根据商户号获取mpos商户
	 * @param merchantNo
	 * @return
	 */
	public CmMerchantContractEO queryMposByMerchantNo( String merchantNo );
	
	/**
	 * 根据登录号及状态查询商户合同
	 * @param loginAccount
	 * @param mcStatus
	 * @return
	 */
	public CmMerchantContractEO queryByLogAccountAdType(String loginAccount,String mcType);
}
