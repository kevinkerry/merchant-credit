package com.sdp.mc.batch.newt0;

import org.slf4j.Logger;import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.sdp.mc.common.job.CronTriggerJob;
import com.sdp.mc.service.newt0.NewT0MerchantFastSettleService;
import com.shengpay.logback.mdc.trace.utils.TraceNoUtils;
//0 0 7 1 * ?
@CronTriggerJob(cronExpression = "${aoto.change.merchant.limit}", jobName = "自动修改商户额度")
public class AutoChangeMerchantLimitJob {
	private static final Logger log = LoggerFactory.getLogger(AutoChangeMerchantLimitJob.class);
	@Autowired
	private NewT0MerchantFastSettleService newT0MerchantFastSettleService;
	public void execute() {
		try {
			TraceNoUtils.newTraceNo();
			log.info("AutoChangeMerchantLimitJob.start...");
			this.newT0MerchantFastSettleService.changeMerchantLimit();
			log.info("AutoChangeMerchantLimitJob.finished...");
		} catch (Exception e) {
			log.error("AutoChangeMerchantLimitJob.error", e);
		}finally{
			TraceNoUtils.clearTraceNo();
		}
	}
}
