package com.sdp.withdraw;

import java.util.Date;

import org.slf4j.Logger;import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.sdp.mc.ScSettleBaseService;
import com.sdp.mc.common.job.CronTriggerJob;
import com.sdp.withdraw.service.WithdrawRetryService;
import com.shengpay.logback.mdc.trace.utils.TraceNoUtils;

@CronTriggerJob(cronExpression = "${cron.expression.withdraw.splitting.day}", jobName = "出款分润每天任务")
//@CronTriggerJob(cronExpression = "0 * * * * ?", jobName = "出款失败重试任务")
public class WithdrawSplittingDayJob {

	private Logger logger = LoggerFactory.getLogger(WithdrawSplittingDayJob.class);

	@Autowired
	private ScSettleBaseService settleBaseService = null;

	public void execute() {
		try {
			TraceNoUtils.newTraceNo();
			logger.info("WithdrawSplittingDayJob execute begin");
			settleBaseService.getCalculateProfitAPIService().calcYesterdayStairAward();
			logger.info("WithdrawSplittingDayJob execute final");
		} catch (Exception e) {
			logger.error("WithdrawSplittingDayJob execute error", e);
		}finally{
			TraceNoUtils.clearTraceNo();
		}
	}

}
