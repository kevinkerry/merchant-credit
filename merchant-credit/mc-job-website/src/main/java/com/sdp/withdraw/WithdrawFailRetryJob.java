package com.sdp.withdraw;

import org.slf4j.Logger;import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.sdp.mc.common.job.CronTriggerJob;
import com.sdp.withdraw.service.WithdrawRetryService;
import com.shengpay.logback.mdc.trace.utils.TraceNoUtils;

@CronTriggerJob(cronExpression = "${cron.expression.withdraw.fail.retry}", jobName = "出款失败重试任务")
//@CronTriggerJob(cronExpression = "0 * * * * ?", jobName = "出款失败重试任务")
public class WithdrawFailRetryJob {

	private Logger logger = LoggerFactory.getLogger(WithdrawFailRetryJob.class);

	@Autowired
	private WithdrawRetryService withdrawRetryService = null;

	public void execute() {
		try {
			TraceNoUtils.newTraceNo();
			logger.info("WithdrawFailRetryJob execute begin");
			withdrawRetryService.executeRetryJob();
			logger.info("WithdrawFailRetryJob execute final");
		} catch (Exception e) {
			logger.error("WithdrawFailRetryJob execute error", e);
		}finally{
			TraceNoUtils.clearTraceNo();
		}
	}

}
