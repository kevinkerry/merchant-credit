package com.sdp.mc.batch.withcapital;

import org.slf4j.Logger;import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.sdp.mc.common.job.CronTriggerJob;
import com.sdp.mc.service.credit4promoter.MCWithCapital4PromoterService;
import com.shengpay.logback.mdc.trace.utils.TraceNoUtils;

@CronTriggerJob(cronExpression = "${reset.fast.settle.limit.4withcapital.cron}", jobName = "重置代理商快速结算额度")
public class ResetFastSettleLimit4WithCapitalJob {
	private static final Logger log = LoggerFactory.getLogger(ResetFastSettleLimit4WithCapitalJob.class);

	@Autowired
	private MCWithCapital4PromoterService mcWithCapital4PromoterService;

	public void execute() {
		try {
			TraceNoUtils.newTraceNo();
			log.info("ResetFastSettleLimit4WithCapitalJob.start...");
			this.mcWithCapital4PromoterService.resetCreditLimit4Job();
			log.info("ResetFastSettleLimit4WithCapitalJob.finished...");
		} catch (Exception e) {
			log.error("ResetFastSettleLimit4WithCapitalJob.error", e);
		}finally{
			TraceNoUtils.clearTraceNo();
		}
	}

}
