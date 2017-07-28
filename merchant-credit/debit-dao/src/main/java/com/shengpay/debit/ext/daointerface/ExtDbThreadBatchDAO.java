package com.shengpay.debit.ext.daointerface;

import java.util.Date;
import java.util.List;
import java.util.Map;

import com.shengpay.debit.dal.dataobject.DbThreadBatchPO;
import com.shengpay.debit.dal.ext.dataobject.DbThreadBatchDTO;
import com.shengpay.debit.daointerface.DbThreadBatchDAO;

public interface ExtDbThreadBatchDAO extends DbThreadBatchDAO{

	 public DbThreadBatchPO queryNextBatchExecute(String serilizeCode);

	 public DbThreadBatchPO queryRepeatBatchExecute(Date nextDate, String batchCode);

	 public void lockBatchExecute(Long id);

	 public int updateBatchRunningStatus(Map<String, Object> params);

	 public boolean isBenifitYesterdayComplete();

	 public List<DbThreadBatchPO> queryCanRunnableExecute();

	 public void selectByQuery(DbThreadBatchDTO query);
}
