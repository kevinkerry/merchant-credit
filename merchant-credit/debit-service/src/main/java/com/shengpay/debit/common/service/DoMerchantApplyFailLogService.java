package com.shengpay.debit.common.service;

import com.shengpay.debit.dal.dataobject.DoMerchantApplyFailLogPO;

public interface DoMerchantApplyFailLogService {

	DoMerchantApplyFailLogPO getLastFailLog(Long applyId);
}
