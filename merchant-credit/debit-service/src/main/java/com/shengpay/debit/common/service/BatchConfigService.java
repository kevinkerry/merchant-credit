package com.shengpay.debit.common.service;

import com.shengpay.debit.dal.ext.dataobject.DbThreadBatchDTO;

public interface BatchConfigService {

	void selectByQuery(DbThreadBatchDTO query);
}
