package com.shengpay.debit.common.service;

import com.shengpay.debit.dal.dataobject.DbThreadConfigPO;
import com.shengpay.debit.dal.ext.dataobject.DbThreadConfigDTO;

public interface ThreadConfigService {

	void selectByQuery(DbThreadConfigDTO query);
	
	DbThreadConfigPO selectByPrimaryKey(Long id);

	int updateByPrimaryKeySelective(DbThreadConfigPO config);

	Long insert(DbThreadConfigPO config);

}
