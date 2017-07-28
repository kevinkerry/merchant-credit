package com.sdp.debit.task.job;

import java.util.Date;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sdp.debit.batch.util.ExecuteServiceMapSetting;
import com.sdp.debit.batch.util.TaskExpressionTimeUtil;
import com.sdp.debit.task.job.execute.service.ExecuteBaseService;
import com.sdp.debit.task.service.BatchExecuteService;
import com.sdp.debit.task.service.JobBatchConfigService;
import com.shengpay.debit.dal.dataobject.DbThreadBatchPO;
import com.shengpay.debit.dal.dataobject.DbThreadConfigPO;


@Service("batchExecuteConfigJob")
public class BatchExecuteConfigJob {

    @Autowired
    private JobBatchConfigService  jobBatchConfigService;

    @Autowired
    private BatchExecuteService batchExecuteService;

    /**
     * 日志
     */
	private Logger logger = LoggerFactory.getLogger(BatchExecuteConfigJob.class);

    public void execute() {
        logger.info("execute batch task start");
        try {
        	List<DbThreadConfigPO> list = jobBatchConfigService.selectAllValid();
            for (int i = 0; i < list.size(); i++) {
            	DbThreadConfigPO po = list.get(i);
                String batchCode = po.getBatchCode();
                if (!StringUtils.isEmpty(batchCode)) {
                    ExecuteBaseService executeBaseService = ExecuteServiceMapSetting.getExecuteMap(batchCode);
                    if (executeBaseService != null) {
                        // 批次号
                        String serilizeCode = executeBaseService.generateSerilzeCode(po);
                        DbThreadBatchPO batchExcutePO = batchExecuteService.queryNextBatchExecute(serilizeCode);

                        if (batchExcutePO == null) {
                        	DbThreadBatchPO ftBatchExecutePO = generateBatchExecute(po, serilizeCode);
                        	DbThreadBatchPO executePo = batchExecuteService.queryRepeatBatchExecute(ftBatchExecutePO.getStartTime(), batchCode);
                            if (executePo == null) {
                                batchExecuteService.insert(ftBatchExecutePO);
                            }
                        } else {
                            logger.info("next batch has existed, skip");
                        }
                    }
                } else {
                    logger.error("wrong setting config! id is:" + po.getId());
                }
            }
        } catch (Exception e) {
            logger.error("task batch Execute job error", e);
        }
        logger.info("execute batch task end");
    }

    /**
     * 产生一个预处理任务
     * @param po
     * @param serilizeCode
     * @return
     */
    private DbThreadBatchPO generateBatchExecute(DbThreadConfigPO po, String serilizeCode) {
    	DbThreadBatchPO dbThreadBatchPO = new DbThreadBatchPO();
        dbThreadBatchPO.setBatchCode(po.getBatchCode());
        dbThreadBatchPO.setCreateTime(new Date());
        dbThreadBatchPO.setExecuteResult(0); // 初始状态
        dbThreadBatchPO.setRecordCount(0l);
        dbThreadBatchPO.setRetryCount(0);
        dbThreadBatchPO.setSerilizeCode(serilizeCode);
        dbThreadBatchPO.setUpdateTime(new Date());
        dbThreadBatchPO.setRunningStatus(0);
        dbThreadBatchPO.setStartTime(TaskExpressionTimeUtil.nextDate(po.getExecuteExpression(),
            new Date()));
        return dbThreadBatchPO;
    }

}
