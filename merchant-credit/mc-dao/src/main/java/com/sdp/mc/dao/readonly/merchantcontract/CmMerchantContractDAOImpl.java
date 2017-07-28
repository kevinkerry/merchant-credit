package com.sdp.mc.dao.readonly.merchantcontract;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Repository;

import com.shengpay.commons.springtools.base.IbatisBaseDAOImpl;


/**
 * 商户合同
 * @author liuxi.xiliu
 */
@Repository("cmMerchantContractDAO")
@Deprecated
public class CmMerchantContractDAOImpl implements CmMerchantContractDAO{
	
	/**
	 * IBatis模板在spring配置文件中的beanId
	 */
	@Resource(name="ibatisTemplate_mc")
	protected IbatisBaseDAOImpl ibatisTemplete;
	
	/**
	 * 查询商户类型
	 */
	public List<Map<String, Object>> selectMerchantTypesByNo( String merchantNo ){
		List<Map<String, Object>> list = ibatisTemplete.queryForList( "CmMerchantContractDAO.selectMerchantTypesByNo", merchantNo );
		return list;
	}
	
	/**
	 * 根据id查询
	 */
	public CmMerchantContractEO selectById( Long id ){
		if( id != null ){
			List<CmMerchantContractEO> list = ibatisTemplete.queryForList( "CmMerchantContractDAO.selectById", id );
			return list.size() > 0? list.get( 0 ) : null;
		}
		return null;
	}
	
	
	/**
	 * 根据商户号取得pos拓展商
	 */
	public CmMerchantContractEO queryPosPromoterByMerchantNo( String merchantNo ){
		List<CmMerchantContractEO> list = ibatisTemplete.queryForList( "CmMerchantContractDAO.queryPosPromoterByMerchantNo", merchantNo );
		return list.size() > 0? list.get( 0 ) : null;
	}

	/**
	 * 根据商户号取得mpos商户
	 */
	@Override
	public CmMerchantContractEO queryMposByMerchantNo(String merchantNo) {
		List<CmMerchantContractEO> list = ibatisTemplete.queryForList( "CmMerchantContractDAO.queryMposByMerchantNo", merchantNo );
		return list.size() > 0? list.get( 0 ) : null;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public CmMerchantContractEO queryByLogAccountAdType(String loginAccount,String mcType) {
		Map<String ,String> paramMap = new HashMap<String,String>();
		paramMap.put("loginAccount", loginAccount);
		paramMap.put("mcType", mcType);
		List<CmMerchantContractEO> list = ibatisTemplete.queryForList( "CmMerchantContractDAO.queryByLogAccountAdType", paramMap );
		return list.size() > 0? list.get( 0 ) : null;
	}
}
