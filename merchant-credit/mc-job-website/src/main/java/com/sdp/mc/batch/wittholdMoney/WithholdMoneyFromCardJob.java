package com.sdp.mc.batch.wittholdMoney;

import org.slf4j.Logger;import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.sdp.mc.common.job.CronTriggerJob;
import com.shengpay.autorepayment.service.WithholdFileService;
import com.shengpay.logback.mdc.trace.utils.TraceNoUtils;


@CronTriggerJob(cronExpression = "${withhold.money.card.query.job}", jobName = "代扣-扣款")
public class WithholdMoneyFromCardJob {
	private static final Logger log = LoggerFactory.getLogger(WithholdMoneyFromCardJob.class);
	@Autowired
	public WithholdFileService withholdService;
	public void execute() {
		try {
			TraceNoUtils.newTraceNo();
			log.info("WithholdMoneyFromCardJob.start...");
			withholdService.run();
			log.info("WithholdMoneyFromCardJob.finished...");
		} catch (Exception e) {
			log.error("WithholdMoneyFromCardJob.error" + e.getMessage(), e);
		}finally{
			TraceNoUtils.clearTraceNo();
		}
	}
}
