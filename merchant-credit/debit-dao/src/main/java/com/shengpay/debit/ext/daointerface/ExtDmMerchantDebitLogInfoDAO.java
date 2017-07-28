package com.shengpay.debit.ext.daointerface;

import java.math.BigDecimal;

import com.shengpay.debit.dal.dataobject.DoMerchantDebitOrderPO;
import com.shengpay.debit.daointerface.DmMerchantDebitLogInfoDAO;

public interface ExtDmMerchantDebitLogInfoDAO extends DmMerchantDebitLogInfoDAO{

	/**
	 * 插入还款日至
	 * @param beforeAmount
	 * @param afterAmount
	 * @param order
	 */
	public void insertLog(BigDecimal beforeAmount, BigDecimal afterAmount,String operateType, DoMerchantDebitOrderPO order);
}
