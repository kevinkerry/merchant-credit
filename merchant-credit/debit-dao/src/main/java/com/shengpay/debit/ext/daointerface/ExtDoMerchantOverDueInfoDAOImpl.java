package com.shengpay.debit.ext.daointerface;

import com.shengpay.debit.dal.dataobject.DoMerchantOverDueInfoExample;
import com.shengpay.debit.dal.dataobject.DoMerchantOverDueInfoPO;
import com.shengpay.debit.daointerface.DoMerchantOverDueInfoDAOImpl;

public class ExtDoMerchantOverDueInfoDAOImpl extends DoMerchantOverDueInfoDAOImpl implements ExtDoMerchantOverDueInfoDAO {

	public boolean update2TargetStatus(Long id, String originalStatus, String targetStatus) {
		DoMerchantOverDueInfoPO record = new DoMerchantOverDueInfoPO();
		record.setStatus(targetStatus);
		DoMerchantOverDueInfoExample example = new DoMerchantOverDueInfoExample();
		example.createCriteria().andIdEqualTo(id).andStatusEqualTo(originalStatus);
		int rows = this.updateByExampleSelective(record, example);
		return rows == 1;
	}
}
