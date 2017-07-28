package com.sdp.debit.task.job.execute.service;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;import org.slf4j.LoggerFactory;

import com.sdp.debit.task.model.TaskResult;
import com.shengpay.debit.dal.dataobject.DbThreadBatchPO;
import com.shengpay.debit.dal.dataobject.DbThreadConfigPO;

public abstract class ExecuteBaseService {

	private Logger logger = LoggerFactory.getLogger(ExecuteBaseService.class);

    protected abstract String getSerilizeCode(DbThreadConfigPO po);

    protected abstract TaskResult execute(DbThreadConfigPO config, DbThreadBatchPO po);

    protected abstract boolean canRun( DbThreadConfigPO config, DbThreadBatchPO po);

    public TaskResult running(DbThreadConfigPO config,DbThreadBatchPO po) {
        if (canRun(config,po)) {
            return execute(config,po);
        } else{
            TaskResult result = new TaskResult();
            result.setMessage("pre count success");
            result.setResult(true);
            result.setStatus(500);
            return result;
        }
    }

    public String generateSerilzeCode(DbThreadConfigPO po) {
        String serilizeCode = getSerilizeCode(po);
        if (StringUtils.isEmpty(serilizeCode)) {
            logger.error("class not generate serlizeCode");
            return null;
        }
        return po.getBatchCode() + serilizeCode;
    }

}
