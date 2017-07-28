package com.sdp.easypay;

import java.util.Date;

import org.apache.commons.lang.time.DateUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.sdp.mc.ScSettleBaseService;
import com.sdp.mc.common.job.CronTriggerJob;
import com.shengpay.logback.mdc.trace.utils.TraceNoUtils;

@CronTriggerJob(cronExpression = "${easypayPfsOrderMonthJob}", jobName = "云收银分润月任务")
public class EasypaySplittingMonthJob {
	
	private Logger logger = LoggerFactory.getLogger(EasypaySplittingMonthJob.class);
	
	@Autowired
	private ScSettleBaseService scSettleBaseService;
	
	public void execute() {
		try {
			TraceNoUtils.newTraceNo();
			logger.info("EasypaySplittingMonthJob execute begin");
			Date date = DateUtils.addMonths(new Date(), -1);
			scSettleBaseService.getCalculateProfitAPIService().retryEasypayCalcSplittingDate(date);
			logger.info("WithdrawSplittingMonthJob execute final");
		} catch (Exception e) {
			logger.error("EasypaySplittingMonthJob execute error", e);
		}finally{
			TraceNoUtils.clearTraceNo();
		}
	}
}
