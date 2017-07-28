package com.sdp.debit.task.job;

import java.util.Date;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.slf4j.Logger;import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sdp.debit.batch.util.ExecuteServiceMapSetting;
import com.sdp.debit.task.job.execute.service.ExecuteBaseService;
import com.sdp.debit.task.model.TaskResult;
import com.sdp.debit.task.service.JobBatchConfigService;
import com.sdp.debit.task.service.BatchExecuteService;
import com.shengpay.debit.dal.dataobject.DbThreadBatchPO;
import com.shengpay.debit.dal.dataobject.DbThreadConfigPO;


@Service("batchExecuteJob")
public class BatchExecuteJob {

	private Logger logger = LoggerFactory.getLogger(BatchExecuteJob.class);

    private static ExecutorService pool        = Executors.newCachedThreadPool();

    @Autowired
    private BatchExecuteService    batchExecuteService;

    @Autowired
    private JobBatchConfigService     jobBatchConfigService;

    private static Integer         NOT_RUNNING = 0;

    /**
     * 执行入口
     */
    public synchronized void execute() {
        List<DbThreadBatchPO> list = batchExecuteService.queryCanRunnableExecute();
		logger.info("BatchExecuteJob.execute,list=" + ToStringBuilder.reflectionToString(list));
        for (int i = 0; i < list.size(); i++) {
        	DbThreadBatchPO po = list.get(i);
            String batchCode = po.getBatchCode();
            ExecutorThread runnable = new ExecutorThread(batchCode, po);
            pool.execute(runnable);
        }
    }

    private class ExecutorThread implements Runnable {

        private String           threadName = "";

        private DbThreadBatchPO po         = null;

        public ExecutorThread(final String threadName, final DbThreadBatchPO po) {
            this.threadName = threadName;
            this.po = po;
            logger.info("init thread is:" + threadName);
        }

        @Override
        public void run() {
            logger.info(threadName + " thread start");
            // 将running 设置成 1;没有更新到忽略
            if (!batchExecuteService.canRun(po)) {
                logger.info(threadName + " pre thread is running");
                return;
            }
            ExecuteBaseService executeService = ExecuteServiceMapSetting.getExecuteMap(po
                .getBatchCode());
            DbThreadConfigPO config = jobBatchConfigService.findByBatchCode(po.getBatchCode());
            Long startTime = po.getStartTime().getTime();
            Date now = new Date();
            try {
                // 1.线程是否到时间开启。2.线程是否已经执行完成。
                if (now.getTime() - startTime >= 0 && po.getEndTime() == null) {
                    //  batchExecuteService.lockCanExecute(po.getId());

                    TaskResult result = executeService.running(config, po);

                    Integer status = result.getStatus();
                    if (status == 500){
                        logger.info("cant't run,thread is " + threadName);
                        return;
                    }

                    logger.info("thread name" + threadName + "status is:" + status);
                    po.setExecuteResult(status);
                    // 成功的话
                    if (result.isResult()) {
                        po.setEndTime(new Date());
                    } else {
                        po.setRetryCount(po.getRetryCount() + 1); // 失败次数加1
                        if (po.getRetryCount() >= config.getRetryCount()) {
                            po.setEndTime(new Date());
                        } else {
                            Date nextStartTime = new Date(new Date().getTime()
                                                          + config.getRetryInterval() * 1000);
                            po.setStartTime(nextStartTime);
                        }
                    }
                }
                logger.info(threadName + " thread end");
            } catch (Exception e) {
                logger.error("thread error: name is " + threadName, e);
                po.setRetryCount(po.getRetryCount() + 1); // 失败次数加1
                if (po.getRetryCount() >= config.getRetryCount()) {
                    po.setEndTime(new Date());
                } else {
                    Date nextStartTime = new Date(new Date().getTime() + config.getRetryInterval()
                                                  * 1000);
                    po.setStartTime(nextStartTime);
                }
            } finally {
                po.setRunningStatus(NOT_RUNNING);
                po.setUpdateTime(new Date());
                batchExecuteService.updateStatus(po);
            }
        }
    }
}
