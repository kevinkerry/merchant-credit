package com.sdp.withdraw.api.ratio;

import com.sdp.withdraw.vo.ratio.WithdrawRatioQueryRequest;
import com.sdp.withdraw.vo.ratio.WithdrawRatioQueryResponse;
import com.sdp.withdraw.vo.ratio.WithdrawRatioRequest;
import com.sdp.withdraw.vo.ratio.WithdrawRatioResponse;

public interface MerchantWithdrawRatioAPI {
	/**
	 * 创建费率，新开商户在开通T1是默认开通D1费率
	 * @param merchantNo
	 * @param mcType
	 * @return
	 */
	public WithdrawRatioResponse createT1andD1Ratio(String merchantNo,String mcType);
	/**
	 * 新建/更新 商户提现费率
	 *
	 * merchantNo 商户号，必填 merchantType 商户类型，必填 withDrawRatioType 费率类型，必填
	 * effectiveTime 生效时间，非必填，默认当前系统时间 expireTime 失效时间，非必填 workDayWithDrawRatio
	 * holidayWithDrawRatio 工作日费率/非工作日费率，非必填，任意一值为NULL 将形成新的提现记录
	 */
	public WithdrawRatioResponse createOrUpdateWithrawRatio(WithdrawRatioRequest withdrawRatioRequest);

	/**
	 * 查询提现记录 merchantNo 商户号，必填 merchantType 商户类型，必填 withdrawRatioQuery
	 * 提现产品类型，非必填
	 */
	public WithdrawRatioQueryResponse queryWithrawRatioResult(WithdrawRatioQueryRequest withdrawRatioQueryRequest);

	public boolean withdrawD1Available(WithdrawRatioRequest withdrawRatioRequest) throws Exception;

	// public WithdrawRatioResult getMerchantWithdrawRatio(String merchantNo,
	// String merchantType, Integer withdrawRatioType);

	/**
	 * 获取商户当前可用的提现费率
	 *
	 * @param queryRequest
	 *            merchantNo 商户号，必填 merchantType 商户类型 必填 withdrawRatioType
	 *            提现费率类型，必填
	 * @return
	 */
	public WithdrawRatioQueryResponse getMerchantCurrentAvaliableWithdrawRatio(WithdrawRatioQueryRequest queryRequest);
	/**
	 * 新建/更新 商户提现费率  主要资管的商户管理页面使用
	 *
	 * merchantNo 商户号，必填 merchantType 商户类型，必填 withDrawRatioType 费率类型，必填
	 * effectiveTime 生效时间，非必填，默认当前系统时间 expireTime 失效时间，非必填 workDayWithDrawRatio
	 * holidayWithDrawRatio 工作日费率/非工作日费率，非必填，任意一值为NULL 将形成新的提现记录
	 */
	public WithdrawRatioResponse createAndUpdateWithrawRatio(WithdrawRatioRequest request);
}
