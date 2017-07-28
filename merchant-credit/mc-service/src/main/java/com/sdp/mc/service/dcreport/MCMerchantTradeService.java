package com.sdp.mc.service.dcreport;

import java.math.BigDecimal;
import java.util.Date;

public interface MCMerchantTradeService {
	// /**
	// *
	// * @param MerchantNo 商户号
	// * @param month 月份
	// * @return 商户上月日均交易金额
	// */
	// public String getGMVOfLastMonth(String MerchantNo, int month);

	// /**
	// *
	// * @param MerchantNo 商户号
	// * @param month 月份
	// * @return 商户每自然月交易总额
	// */
	// public String getGMVOfLastThreeMonth(String MerchantNo, int month);

	/**
	 * 根据商户号查询季度每月（前三个月）是否大于指定交易额 查询结果为当前日期的前三个月,如:2015-09-xx,返回结果是 2015-06 ~
	 * 2015-08月是否满足的结果
	 * 
	 * @param merchantNo
	 * @return boolean
	 * @throws Exception
	 */
	public boolean monthTradeAmount(String merchantNo) throws Exception;

	/**
	 * 根据商户号查询季度每月（前三个月）是否大于指定交易额
	 * 
	 * @param merchantNo
	 *            商户号
	 * @param date
	 *            日期（查询结果为传入日期的前三个月,如:2015-09-xx,返回结果是 2015-06 ~
	 *            2015-08月是否满足的结果）
	 * @return boolean
	 * @throws Exception
	 */
	public boolean monthTradeAmount(String merchantNo, Date date) throws Exception;

	/**
	 * 根据商户号获取商户上月日均交易额
	 * 
	 * @return
	 */

	public BigDecimal getDayOfAmount(String merchantNo) throws Exception;

	public BigDecimal getDayOfAmount(String merchantNo, Date date) throws Exception;

	/**
	 * 根据商户号查询上个月的支付获取天数
	 * @param merchantNo 商户号
	 * @return
	 * @throws Exception
	 */
	int getActiveDaysOfLastMonth(String merchantNo) throws Exception;
	
	/**
	 * 根据商户号查询上个月的支付获取天数
	 * @param merchantNo 商户号
	 * @param date 指定日期
	 * @return
	 * @throws Exception
	 */
	int getActiveDaysOfLastMonth(String merchantNo,Date date) throws Exception;
	
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

}
