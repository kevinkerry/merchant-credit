package com.sdp.mc.batch.withcapital;

import org.slf4j.Logger;import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.sdp.mc.common.job.CronTriggerJob;
import com.sdp.mc.service.credit4promoter.MCWithCapital4PromoterService;
import com.shengpay.logback.mdc.trace.utils.TraceNoUtils;

@CronTriggerJob(cronExpression = "${retry.modify.fast.settle.limit.4failure.modification.cron}", jobName = "重试修改msp失败的恢复配资")
public class RetryRecoveryMspFastSettleLimit4Job {
	private static final Logger log = LoggerFactory.getLogger(ResetFastSettleLimit4WithCapitalJob.class);
	@Autowired
	private MCWithCapital4PromoterService mcWithCapital4PromoterService;

	public void execute() {
		try {
			TraceNoUtils.newTraceNo();
			log.info("RetryRecoveryMspFastSettleLimit4Job.start...");
			this.mcWithCapital4PromoterService.retryRecoveryMspFastSettleLimit4Job();
			log.info("RetryRecoveryMspFastSettleLimit4Job.finished...");
		} catch (Exception e) {
			log.error("RetryRecoveryMspFastSettleLimit4Job.error.", e);
		}finally{
			TraceNoUtils.clearTraceNo();
		}
	}
}
