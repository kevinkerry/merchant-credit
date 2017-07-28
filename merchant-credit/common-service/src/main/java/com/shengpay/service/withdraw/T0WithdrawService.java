package com.shengpay.service.withdraw;

import java.math.BigDecimal;
import java.util.Date;

import com.sdp.withdraw.api.WithdrawT0ServiceAPI;
import com.sdp.withdraw.api.ratio.MerchantWithdrawRatioAPI;
import com.sdp.withdraw.vo.ratio.WithdrawRatioQueryResponse;
import com.sdp.withdraw.vo.ratio.WithdrawRatioResponse;

public interface T0WithdrawService {

	public abstract WithdrawRatioResponse merchantT0Ratio(String merchantNo, String merchantType, Integer withDrawRatioType,
			BigDecimal workDayWithDrawRatio, BigDecimal holidayWithDrawRatio, int ratioStatus);

	public abstract WithdrawRatioQueryResponse queryMerchantT0Ratio(String merchantNo, String merchantType, Integer withdrawRatioType);

	public abstract WithdrawRatioResponse merchantT0Ratio(String merchantNo, String merchantType, BigDecimal workDayWithDrawRatio,
			BigDecimal holidayWithDrawRatio);

	public abstract WithdrawRatioQueryResponse queryMerchantT0Ratio(String merchantNo, String merchantType);

	public WithdrawRatioQueryResponse getMerchantCurrentAvaliableWithdrawRatio(String merchantNo, String merchantType, Integer withdrawRatioType);

	WithdrawRatioQueryResponse queryMerchantT0Ratio(String merchantNo, String merchantType, Integer withdrawRatioType, Date effectiveTime);

	public WithdrawT0ServiceAPI getWithdrawT0ServiceAPI();

	MerchantWithdrawRatioAPI getWithdrawRatioService();

}