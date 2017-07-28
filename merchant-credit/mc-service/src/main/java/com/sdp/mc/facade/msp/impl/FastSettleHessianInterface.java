package com.sdp.mc.facade.msp.impl;

import java.util.List;

public interface FastSettleHessianInterface {

	/**
	 * 手动发起结算
	 * 
	 * @param merchantId
	 *            商户编号
	 * @param posMerchantId
	 *            POS商户编号
	 * @param ids
	 *            订单号集
	 * @return
	 */
	public abstract <T> T straightlySettle(String merchantId, String posMerchantId, List<Long> ids);

	/**
	 * 查询可发起快速结算的订单编号
	 * 
	 * @param merchantId
	 *            商户编号
	 * @param posMerchantId
	 *            POS商户编号
	 * @return
	 */
	public abstract <T> List<T> queryValidOrderList(String merchantId, String posMerchantId);

	/**
	 * 获取快速结算配置
	 * 
	 * @param merchantId
	 *            商户编号
	 * @param posMerchantId
	 *            POS商户编号
	 * @return
	 */
	public abstract <T> T getStraightlyCfg(String merchantId, String posMerchantId);

	/**
	 * 获取代理商快速结算配置
	 * 
	 * @param promoterId
	 * @return
	 */
	public abstract <T> T getPromoterStraightlyCfg(Long promoterId);

}