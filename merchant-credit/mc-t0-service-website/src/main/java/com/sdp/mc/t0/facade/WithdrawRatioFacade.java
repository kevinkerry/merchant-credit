package com.sdp.mc.t0.facade;


public interface WithdrawRatioFacade {

	String createOrUpdateWithrawRatio(String merchantNo, String merchantType, String effectiveTime, String expireTime, String holidayWithDrawRatio,
			String withDrawRatioStatus, String withDrawRatioType, String workDayWithDrawRatio, String ratioId);

	String queryWithdrawRatio(String merchantNo, String merchantType);

	String createOrUpdateT1andD1Ratio(String merchantNo, String merchantType);
}