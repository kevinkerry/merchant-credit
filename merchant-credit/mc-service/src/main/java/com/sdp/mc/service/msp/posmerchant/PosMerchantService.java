package com.sdp.mc.service.msp.posmerchant;

import java.util.List;

import com.sdp.mc.dao.readonly.msp.mspposmerchant.MspPosMerchantEO;
import com.sdp.mc.dao.readonly.msp.mspposmerchant.PmtQueryPosMerchantCond;
import com.sdp.mc.dao.readonly.msp.mspposmerchant.PmtQueryPosMerchantPO;
import com.shengpay.commons.core.base.PaginationBaseObject;

public interface PosMerchantService {
	/**
	 * (分页)代理商查询POS商户
	 */
	public PaginationBaseObject<MspPosMerchantRO> pagingPmtQueryPosMerchant(PmtQueryPosMerchantPO po);
	public List<MspPosMerchantEO> pmtQueryAllPosMerchant(PmtQueryPosMerchantCond cond);
	
	public List<MspPosMerchantEO> querySyncPosMerchantInfo(PmtQueryPosMerchantPO po);
}
