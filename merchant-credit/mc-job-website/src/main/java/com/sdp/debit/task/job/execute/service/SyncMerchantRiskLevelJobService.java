package com.sdp.debit.task.job.execute.service;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.slf4j.Logger;import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sdp.debit.batch.util.TaskExpressionTimeUtil;
import com.sdp.debit.task.model.TaskResult;
import com.shengpay.debit.common.service.CreditLinesApplyService;
import com.shengpay.debit.dal.dataobject.DbThreadBatchPO;
import com.shengpay.debit.dal.dataobject.DbThreadConfigPO;

/**
 * 同步获取商户评级结果job
 * @author wangjingao.william
 * **/
@Service
public class SyncMerchantRiskLevelJobService extends ExecuteBaseService{
	private static final Logger log = LoggerFactory.getLogger(SyncMerchantRiskLevelJobService.class);
	@Autowired
	private CreditLinesApplyService creditLinesApplyService;

	protected String getSerilizeCode(DbThreadConfigPO po) {
		String expression = po.getExecuteExpression();
        Date date = TaskExpressionTimeUtil.nextDate(expression, new Date());
        return new SimpleDateFormat("yyyyMMddHH").format(date);
	}

	protected TaskResult execute(DbThreadConfigPO config, DbThreadBatchPO po) {
		TaskResult taskResult = new TaskResult();
		try {
			log.info("SyncMerchantRiskLevelJobService.job.starting");
			creditLinesApplyService.syncCreditRiskResult4Job();
			log.info("SyncMerchantRiskLevelJobService.job.finished");
			taskResult.setStatus(1);
			taskResult.setResult(true);
		} catch (Exception e) {
			log.error("SyncMerchantRiskLevelJobService.error", e);
			taskResult.setStatus(2);
			taskResult.setResult(false);
		}
		return taskResult;
	}

	protected boolean canRun(DbThreadConfigPO config, DbThreadBatchPO po) {
		return true;
	}

}
