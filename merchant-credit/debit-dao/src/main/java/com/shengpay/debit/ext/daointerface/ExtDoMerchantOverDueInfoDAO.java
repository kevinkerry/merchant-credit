package com.shengpay.debit.ext.daointerface;

import com.shengpay.debit.daointerface.DoMerchantOverDueInfoDAO;

public interface ExtDoMerchantOverDueInfoDAO extends DoMerchantOverDueInfoDAO{
	
	public boolean update2TargetStatus(Long id,String originalStatus,String targetStatus);

}
