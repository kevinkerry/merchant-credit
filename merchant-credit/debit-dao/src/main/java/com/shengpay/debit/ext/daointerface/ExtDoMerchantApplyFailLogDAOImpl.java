package com.shengpay.debit.ext.daointerface;

import com.shengpay.debit.dal.dataobject.DoMerchantApplyFailLogPO;
import com.shengpay.debit.daointerface.DoMerchantApplyFailLogDAOImpl;

public class ExtDoMerchantApplyFailLogDAOImpl extends DoMerchantApplyFailLogDAOImpl implements ExtDoMerchantApplyFailLogDAO {

	@Override
	public DoMerchantApplyFailLogPO getLastFailLog(Long applyId) {
		return (DoMerchantApplyFailLogPO) this.getSqlMapClientTemplate().queryForObject("DO_MERCHANT_APPLY_FAIL_LOG.getLastFailLog", applyId);
	}

}
