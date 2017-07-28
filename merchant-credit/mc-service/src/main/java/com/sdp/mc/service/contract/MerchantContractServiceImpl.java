package com.sdp.mc.service.contract;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sdp.mc.dao.readonly.merchant.CmPosMerchantDAO;
import com.sdp.mc.dao.readonly.merchant.CmPosMerchantNewDAO;
import com.sdp.mc.dao.readonly.merchantcontract.CmMerchantContractDAO;
import com.sdp.mc.dao.readonly.merchantcontract.CmMerchantContractEO;

/**
 * 商户合同
 * @author liuxi.xiliu
 */
@Service( "merchantContractService" )
public class MerchantContractServiceImpl implements MerchantContractService{

	@Autowired
	private CmMerchantContractDAO cmMerchantContractDAO;

	@Autowired
	private CmPosMerchantDAO cmPosMerchantDAO;

	@Autowired
	private CmPosMerchantNewDAO cmPosMerchantNewDAO;

	/**
	 * 查询商户类型
	 */
	public List<Map<String, Object>> selectMerchantTypes( String merchantNo ){
		List<Map<String, Object>> list = cmMerchantContractDAO.selectMerchantTypesByNo( merchantNo );
		List<Map<String, Object>> typeList = new ArrayList<Map<String, Object>>();
		for(Map<String, Object> map : list) {
			typeList.add(map);
		}
		return typeList;
	}

	/**
	 * 根据商户号取得pos拓展商
	 */
	public MerchantContractRO queryPosPromoterByMerchantNo( String merchantNo ){
		CmMerchantContractEO eo = cmMerchantContractDAO.queryPosPromoterByMerchantNo( merchantNo );
		return eo == null? null : new MerchantContractRO( eo );
	}

	@Override
	public MerchantContractRO queryMposByMerchantNo(String merchantNo) {
		CmMerchantContractEO eo = cmMerchantContractDAO.queryMposByMerchantNo(merchantNo);
		return eo == null? null : new MerchantContractRO( eo );
	}

	@Override
	public MerchantContractRO queryMerchantByLoginAccountAdType(String loginAccount, String mcType) {
		CmMerchantContractEO eo = cmMerchantContractDAO.queryByLogAccountAdType( loginAccount, mcType);
		return eo == null? null : new MerchantContractRO( eo );
	}

	@Override
	public int queryCountByOriginalMerchantNo(String merchantNo) {
		return cmPosMerchantDAO.queryCountByOriginalMerchantNo(merchantNo);
	}

	@Override
	public String selectPromoterNoByPromoterId(Long promoterId) {
		return cmPosMerchantNewDAO.selectPromoterNoByPromoterId(promoterId);
	}

}
