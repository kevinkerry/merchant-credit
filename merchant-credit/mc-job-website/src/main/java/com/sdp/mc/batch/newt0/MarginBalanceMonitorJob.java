package com.sdp.mc.batch.newt0;

import org.slf4j.Logger;import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.sdp.debit.task.common.service.WaringService;
import com.sdp.mc.common.job.CronTriggerJob;
import com.shengpay.logback.mdc.trace.utils.TraceNoUtils;

/**
 * 
 * @author liyantao01
 *停用保证金账户余额监控
 */
@CronTriggerJob(cronExpression = "${margin.balance.monitor.job}", jobName = "保证金余额监控")
public class MarginBalanceMonitorJob {
	private static final Logger log = LoggerFactory.getLogger(MarginBalanceMonitorJob.class);

	@Autowired
	private WaringService warService;

	public void execute() {
		try {
			TraceNoUtils.newTraceNo();
			log.info("MarginBalanceMonitorJob.start...");
			this.warService.run();
			log.info("MarginBalanceMonitorJob.finished...");
		} catch (Exception e) {
//			e.printStackTrace();
			log.error("MarginBalanceMonitorJob.error", e);
		}finally{
			TraceNoUtils.clearTraceNo();
		}
	}
}
