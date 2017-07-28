package com.sdp.mc.dataservice;

import java.util.Date;

public interface MerchantTradeService {
	
	
	/**
	 * 连续收单六个月
	 * 
	 * @param merchantNo
	 * @param monthCount
	 *            默认-6 6个月之前为-6， 6个月之后为6
	 * @return
	 */
	public boolean selectOPenContract(String merchantNo);

	public boolean selectOPenContract(String merchantNo, int monthCount);
	
	/**
	 * 
	 * @param MerchantNo
	 *            商户号
	 * @param month
	 *            月份
	 * @return 商户上月有过交易的天数
	 */
	public String getActiveDaysOfLastMonth(String merchantNo, Date date);
	/**
	 * 
	 * @param MerchantNo
	 *            商户号
	 * @param month
	 *            月份
	 * @return 商户上月日均交易金额
	 */
	public String getGMVOfLastMonth(String merchantNo, Date date);

	/**
	 * 
	 * @param MerchantNo
	 *            商户号
	 * @param month
	 *            月份
	 * @return 商户每自然月交易总额
	 */
	public String getGMVOfLastThreeMonth(String merchantNo, Date date);
	
	
	
}
