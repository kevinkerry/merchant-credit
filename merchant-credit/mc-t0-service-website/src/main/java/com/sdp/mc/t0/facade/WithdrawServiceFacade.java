package com.sdp.mc.t0.facade;

import java.math.BigDecimal;

import com.sdp.withdraw.vo.BankCardInfo;

public interface WithdrawServiceFacade {

	public String applyPosWithdraw(String merchantNo, String appId,
			String withdrawAmount,String originalAmount, String mcType, String withdrawType, String orderNo);
	public String queryWithdrawList(String merchantNo, String traceNo, String orderNo, String startTime, String endTime, String withdrawType, String pageSize, String pageNo);

	public String applyMPosWithdraw(String merchantNo, String appId,
			String withdrawAmount,String withdrawType, String mcType, String orderNo);
	public String checkPosWithdraw(String merchantNo, String appId,
			String mcType,String originalAmount) ;

	public String productWithdraw(String merchantNo,String mcType);


	public BigDecimal findCanUseQuota(String merchantNo,String mcType);

	public BigDecimal findTotalAmount(String merchantNo,String mcType);
	
	public String queryPromoterInfo(String merchantNo, String mcType);
	public String queryMerchantInfo(String merchantNo, String mcType);
	public String syncMerchantInfo(String merchantNo, String mcType, String mcId, String merchantName, String status, String promoterId,
			String mcc, String lastLevelPromoterNo, String lastLevelPromoterType);
	public String syncPromoterInfo(String merchantNo, String mcType, String mcId, String merchantName, String status, String pmtLevel, String parentMerchantNo, String parentMerchantType);
	public String syncMerchantInfoAll() throws InterruptedException;
	
	public String syncEasypayMerchantInfo(String merchantNo, String mcType, String merchantName, String status, String certType, String certNo,
			String promoterType, String promoterNo, String mcc);
	public String applyEasypayWithdraw(String merchantNo, String string, String withdrawAmount, String withdrawType, String mcType, String orderNo,
			BankCardInfo bankCardInfo);
	
	public String modifyMerchantMcc(String merchantNo, String mcType, String mcc);
}