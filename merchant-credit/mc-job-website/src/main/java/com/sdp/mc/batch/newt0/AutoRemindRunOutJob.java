package com.sdp.mc.batch.newt0;

import org.slf4j.Logger;import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.sdp.mc.common.job.CronTriggerJob;
import com.sdp.mc.service.newt0.NewT0MerchantFastSettleService;
import com.shengpay.logback.mdc.trace.utils.TraceNoUtils;
//0 /30 8-21 * * ?
@CronTriggerJob(cronExpression = "${aoto.remaind.runout}", jobName = "系统提醒额度耗尽")

public class AutoRemindRunOutJob {
	private static final Logger log = LoggerFactory.getLogger(AutoRemindRunOutJob.class);
	@Autowired
	private NewT0MerchantFastSettleService newT0MerchantFastSettleService;
	public void execute() {
		try {
			TraceNoUtils.newTraceNo();
			log.info("AutoRemindRunOutJob.start...");
			this.newT0MerchantFastSettleService.remindRunOut();
			log.info("AutoRemindRunOutJob.finished...");
		} catch (Exception e) {
			log.error("AutoRemindRunOutJob.error", e);
		}finally{
			TraceNoUtils.clearTraceNo();
		}
	}
}
