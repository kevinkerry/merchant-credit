package com.sdp.debit.task.job.execute.service;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.slf4j.Logger;import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sdp.debit.batch.util.TaskExpressionTimeUtil;
import com.sdp.debit.task.common.service.OverDueService;
import com.sdp.debit.task.model.TaskResult;
import com.shengpay.debit.dal.dataobject.DbThreadBatchPO;
import com.shengpay.debit.dal.dataobject.DbThreadConfigPO;

/**
 * 逾期计算的job
 * @author heyi.alex
 *
 */
@Service
public class OverDueCalJobService extends ExecuteBaseService{
	private static final Logger log = LoggerFactory.getLogger(OverDueCalJobService.class);
	@Autowired
	private OverDueService overDueService;

	@Override
	protected String getSerilizeCode(DbThreadConfigPO po) {
		String expression = po.getExecuteExpression();
        Date date = TaskExpressionTimeUtil.nextDate(expression, new Date());
        return new SimpleDateFormat("yyyyMMdd").format(date);
	}

	@Override
	protected TaskResult execute(DbThreadConfigPO config, DbThreadBatchPO po) {
		log.info("OverDueCalJobService.job.starting");
		overDueService.run();
		log.info("OverDueCalJobService.job.finished");
		TaskResult taskResult = new TaskResult();
		taskResult.setStatus(1);
		taskResult.setResult(true);
		return taskResult;
	}

	@Override
	protected boolean canRun(DbThreadConfigPO config, DbThreadBatchPO po) {
		return true;
	}

}
