package com.shengpay.debit.common.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shengpay.debit.common.service.DoMerchantApplyFailLogService;
import com.shengpay.debit.dal.dataobject.DoMerchantApplyFailLogPO;
import com.shengpay.debit.ext.daointerface.ExtDoMerchantApplyFailLogDAO;

@Service
public class DoMerchantApplyFailLogServiceImpl implements DoMerchantApplyFailLogService {

	@Autowired
	ExtDoMerchantApplyFailLogDAO doMerchantApplyFailLogDAO;

	@Override
	public DoMerchantApplyFailLogPO getLastFailLog(Long applyId) {
		return doMerchantApplyFailLogDAO.getLastFailLog(applyId);
	}
}
