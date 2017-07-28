package com.sdp.mc.service.contract;

import org.springframework.beans.BeanUtils;

import com.sdp.mc.dao.readonly.merchantcontract.CmMerchantContractEO;

/**
 * 商户对象
 * @author liuxi.xiliu
 */
public class MerchantContractRO extends CmMerchantContractEO{
	
	public MerchantContractRO(){
		
	}
	
	public MerchantContractRO( CmMerchantContractEO eo ){
		BeanUtils.copyProperties( eo, this );
	}
}