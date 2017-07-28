package com.sdp.mc.batch.task;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.sdp.mc.common.job.CronTriggerJob;
import com.shengpay.logback.mdc.trace.utils.TraceNoUtils;

/**
 * @author: wushiyu
 * @date:2017年5月3日 上午11:09:05
 * @version 1.0
 * @description:定制任务执行JOB,目前还是参数配置每天定时任务时间，至于重试时间的间隔，改为取数据表里的值走线程的睡眠来控制。
 */

@CronTriggerJob(cronExpression = "${execute.timed.task.expression}", jobName = "定时任务")
// @CronTriggerJob(cronExpression = "0 0 2 * * ?",jobName = "定时任务")
public class TimeTaskJob {

	private Logger LOG = LoggerFactory.getLogger(TimeTaskJob.class);

	@Autowired
	private TimeTaskHandler timeTaskHandler;

	public void execute() {
		try {
			TraceNoUtils.newTraceNo();
			LOG.info("start execute======");
			timeTaskHandler.excuteJob();
			LOG.info("end execute========");
		} catch (Exception e) {
			LOG.error("TimeTaskJob.error", e);
		} finally {
			TraceNoUtils.clearTraceNo();
		}
	}
}
