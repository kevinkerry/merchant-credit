package com.sdp.mc.service.msp.posmerchant;

import org.springframework.beans.BeanUtils;

import com.sdp.mc.dao.readonly.msp.mspposmerchant.MspPosMerchantEO;
import com.sdp.mc.service.msp.dictionary.DictionaryHelper;

/**
 * (msp)POS商户信息
 * @author liuxi.xiliu
 */
public class MspPosMerchantRO extends MspPosMerchantEO{
	/**
	 * 商户状态-名称
	 */
	private String statusName;
	
	/**
	 * mpos特定的商户类型名称(对应mcc)
	 */
	private String merchantMposMerchantKindName;
	
	public MspPosMerchantRO(){
		
	}
	
	public MspPosMerchantRO( MspPosMerchantEO eo ){
		if( eo != null ){
			BeanUtils.copyProperties( eo, this );
			this.statusName = DictionaryHelper.getValue(  DictionaryHelper.LABEL_MERCHANT_STATUS, this.getStatus() );
			this.merchantMposMerchantKindName = DictionaryHelper.getValue(  DictionaryHelper.LABEL_MERCHANT_MPOS_MERCHANT_KIND_NAME, this.getMcc() );
		}
	}

	public String getStatusName() {
		return statusName;
	}

	public void setStatusName(String statusName) {
		this.statusName = statusName;
	}

	public String getMerchantMposMerchantKindName() {
		return merchantMposMerchantKindName;
	}

	public void setMerchantMposMerchantKindName(String merchantMposMerchantKindName) {
		this.merchantMposMerchantKindName = merchantMposMerchantKindName;
	}
}
