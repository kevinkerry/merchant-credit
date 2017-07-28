package com.sdp.mc.integration.receipt.dto.request;

import com.sdp.mc.common.constant.MerchantCreditConstant;

public class FundOutReceiptSubmitZF946RequestDTO extends FundOutReceiptSubmitRequestDTO{
	private static final String appCode = MerchantCreditConstant.MC_T0_SERVICE_ZF_NO;
//	private static final String appCode = MerchantCreditConstant.MC_WEBSITE_ZF_NO;
	private static final String appOrderNoRef = "remitVoucherNo";
	
	public FundOutReceiptSubmitZF946RequestDTO() {
		super(appCode,appOrderNoRef);
	}
}
