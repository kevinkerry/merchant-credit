package com.shengpay.debit.ext.daointerface;

import com.shengpay.debit.dal.dataobject.DoMerchantApplyFailLogPO;
import com.shengpay.debit.daointerface.DoMerchantApplyFailLogDAO;

public interface ExtDoMerchantApplyFailLogDAO extends DoMerchantApplyFailLogDAO {

	DoMerchantApplyFailLogPO getLastFailLog(Long applyId);

}
