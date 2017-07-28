package com.shengpay.debit.ext.daointerface;

import java.math.BigDecimal;

import com.shengpay.debit.dal.dataobject.DmMerchantDebitInfoPO;
import com.shengpay.debit.daointerface.DmMerchantDebitInfoDAO;

public interface ExtDmMerchantDebitInfoDAO extends DmMerchantDebitInfoDAO {

	public DmMerchantDebitInfoPO selectByMerchantId(String merchantNo);

	public int freezeMerchantDebit(String merchantNo, String status, BigDecimal amount);

	public int freezeMerchantDebitSuccess(String merchantNo, String status, BigDecimal amount);

	public int freezeMerchantDebitFail(String merchantNo, String status, BigDecimal amount);

	public int recoverBorrowMoney(String merchantNo, String status, String orgCode, BigDecimal amount, BigDecimal overdueInterest);

	/**
	 * 正常还款增加可用余额
	 * 
	 * @param merchantNo
	 * @param orgCode
	 * @param amount
	 * @return
	 */
	public int repaymentMoney(String merchantNo, String orgCode, BigDecimal amount);

	/**
	 * 累加逾期利息
	 * 
	 * @param merchantNo
	 *            商户号
	 * @param overdueInterest
	 *            每日的逾期利息
	 * **/
	public int addOverdueInterest(String merchantNo, BigDecimal overdueInterest);

}
