package com.sdp.withdraw;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.sdp.mc.ScSettleBaseService;
import com.sdp.mc.common.job.CronTriggerJob;
import com.shengpay.logback.mdc.trace.utils.TraceNoUtils;

@CronTriggerJob(cronExpression = "${cron.expression.withdraw.splitting.month}", jobName = "出款分润月任务")
//@CronTriggerJob(cronExpression = "0 * * * * ?", jobName = "出款失败重试任务")
public class WithdrawSplittingMonthJob {

	private Logger logger = LoggerFactory.getLogger(WithdrawSplittingMonthJob.class);

	@Autowired
	private ScSettleBaseService settleBaseService = null;

	public void execute() {
		try {
			TraceNoUtils.newTraceNo();
			logger.info("WithdrawSplittingMonthJob execute begin");
			settleBaseService.getSettleOrderService().createSettleOrder();
			logger.info("WithdrawSplittingMonthJob execute final");
		} catch (Exception e) {
			logger.error("WithdrawSplittingMonthJob execute error", e);
		}finally{
			TraceNoUtils.clearTraceNo();
		}
	}

}
