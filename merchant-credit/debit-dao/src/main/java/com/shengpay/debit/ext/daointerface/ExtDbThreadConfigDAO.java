package com.shengpay.debit.ext.daointerface;

import java.util.List;

import com.shengpay.debit.dal.dataobject.DbThreadConfigPO;
import com.shengpay.debit.dal.ext.dataobject.DbThreadConfigDTO;
import com.shengpay.debit.daointerface.DbThreadConfigDAO;

public interface ExtDbThreadConfigDAO extends DbThreadConfigDAO{

	 public List<DbThreadConfigPO> selectConfigByStatus(int status);

	 public DbThreadConfigPO findByBatchCode(String batchCode);

	 public void selectByQuery(DbThreadConfigDTO query);
}
