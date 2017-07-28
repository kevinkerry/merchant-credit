package com.shengpay.debit.ext.daointerface;

import com.shengpay.debit.dal.dataobject.DmMerchantCreditBaseInfoPO;
import com.shengpay.debit.daointerface.DmMerchantCreditBaseInfoDAO;

public interface ExtDmMerchantCreditBaseInfoDAO extends DmMerchantCreditBaseInfoDAO{

	/**
	 * 根据商户号查询商户基础信息
	 * **/
	public DmMerchantCreditBaseInfoPO selectMerchantCreditBaseInfoByMerchantNo(String merchantNo);
}
