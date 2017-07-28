package com.sdp.mc.service;

import java.math.BigDecimal;

import com.sdp.mc.common.exception.FastSettleLimitException;

/**
 * 代理商管理商户服务接口
 * @author zhangyulong
 *
 */
public interface McManagerService {

	/**
	 * 取得是否符合费率修改条件
	 * @param merchantNo
	 * @return
	 */
	public String getChangFeeFlag(String merchantNo);

	/**
	 * 商户日可用额度限额
	 * @param merchantNo
	 * @return
	 */
	@Deprecated
	public BigDecimal getDayOfAmount(String merchantNo);

	/**
	 * 当月变更费率是否超限
	 * @return
	 */
	public String getChangFeeLimitFlag(long merchantId);


	/**
	 * 获取商户快速交易的额度(页面修改商户额度)
	 * 是否满足实名认证
	 * @param merchantNo 商户号
	 * @param merchantType 商户类型
	 * @return
	 */
	public boolean isRealNameAuthentication(String merchantNo,
			String merchantType);
    /**
     * 是否满足注册时间
     * @param merchantNo 商户号
     * @param merchantType 商户类型
     * @return
     */
	public boolean isSatisfyRegistrationDate(String merchantNo,
			String merchantType);
	/**
	 * 获取商户快速交易的额度
	 * @param mcMerchantNo
	 * @param mcType
	 * @return
	 */
	public BigDecimal getPageDayOfAmount(String mcMerchantNo, String mcType);
	/**
	 * 获取商户快速交易的额度(后台自动更新)
	 * @param mcMerchantNo
	 * @param mcType
	 * @return
	 * @throws FastSettleLimitException
	 */
	public BigDecimal getAutoUpdateDayOfAmount(String merchantNo, String mcType) throws FastSettleLimitException;

	boolean isCreditAuthentication(String merchantNo);

	/**
	 * 云收银实名认证
	 * @param merchantNo
	 * @return
	 */
	public boolean isEasypayMerchantCreditAuthentication(String merchantNo);
}
