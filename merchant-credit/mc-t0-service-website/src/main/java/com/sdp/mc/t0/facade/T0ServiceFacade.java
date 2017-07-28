package com.sdp.mc.t0.facade;

public interface T0ServiceFacade {

	public abstract String applyMposFastSettle(String merchantNo, String posMerchantNo, String txnIdStr);

	public abstract String getMerchantFastSettleCfg(String merchantNo, String posMerchantNo);

	public abstract String getMposFastSettleInfo(String merchantNo, String posMerchantNo);

	public abstract String queryValidOrderList(String merchantNo, String posMerchantNo);

}