package com.sdp.debit.task.service;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.shengpay.debit.dal.dataobject.DbThreadBatchPO;
import com.shengpay.debit.ext.daointerface.ExtDbThreadBatchDAO;

@Service
public class BatchExecuteService {

	@Autowired
	private ExtDbThreadBatchDAO dbThreadBatchDAO;

	private static Integer READY_RUNNING = 0;

	private static Integer IS_RUNNING = 1;

	/**
	 * 查询是否已经存在下一个线程
	 *
	 * @param serilizeCode
	 * @return
	 */
	public DbThreadBatchPO queryNextBatchExecute(String serilizeCode) {
		return dbThreadBatchDAO.queryNextBatchExecute(serilizeCode);
	}

	/**
	 *
	 * @param nextDate
	 * @param batchCode
	 * @return
	 */
	public DbThreadBatchPO queryRepeatBatchExecute(Date nextDate,
			String batchCode) {
		return dbThreadBatchDAO.queryRepeatBatchExecute(nextDate, batchCode);
	}

	public Long insert(DbThreadBatchPO record) {
		return dbThreadBatchDAO.insert(record);
	}

	public List<DbThreadBatchPO> queryCanRunnableExecute() {
		return dbThreadBatchDAO.queryCanRunnableExecute();
	}

	@Transactional("fundTransactionManager")
	public void lockCanExecute(Long id) {
		dbThreadBatchDAO.lockBatchExecute(id);
	}

	public void updateStatus(DbThreadBatchPO po) {
		dbThreadBatchDAO.updateByPrimaryKey(po);
	}

	public boolean canRun(DbThreadBatchPO po) {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("id", po.getId());
		params.put("runningStatus", READY_RUNNING);
		params.put("setRunningStatus", IS_RUNNING);
		int row = dbThreadBatchDAO.updateBatchRunningStatus(params);
		if (row > 0) {
			return true;
		} else {
			return false;
		}
	}
}
