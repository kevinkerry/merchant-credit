package com.shengpay.debit.ext.daointerface;

import java.math.BigDecimal;
import java.util.Date;

import com.shengpay.debit.dal.dataobject.DmMerchantDebitLogInfoPO;
import com.shengpay.debit.dal.dataobject.DoMerchantDebitOrderPO;
import com.shengpay.debit.daointerface.DmMerchantDebitLogInfoDAOImpl;

public class ExtDmMerchantDebitLogInfoDAOImpl extends
		DmMerchantDebitLogInfoDAOImpl implements ExtDmMerchantDebitLogInfoDAO {

	/**
	 * 插入还款日至
	 * @param beforeAmount
	 * @param afterAmount
	 * @param order
	 */
	public void insertLog(BigDecimal beforeAmount, BigDecimal afterAmount,String operateType, DoMerchantDebitOrderPO order) {
		DmMerchantDebitLogInfoPO logPO = new DmMerchantDebitLogInfoPO();
		logPO.setAmount(order.getDebitAmount());
		logPO.setBeforeAmount(beforeAmount);
		logPO.setAfterAmount(afterAmount);
		logPO.setCreateTime(new Date());
		logPO.setMerchantNo(order.getMerchantNo());
		logPO.setOperateType(operateType);
		logPO.setOrganizationCode(order.getOrganizationCode());
		logPO.setUpdateTime(new Date());
		this.insert(logPO);
	}

}
