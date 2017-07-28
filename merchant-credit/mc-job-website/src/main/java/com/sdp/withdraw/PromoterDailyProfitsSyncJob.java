package com.sdp.withdraw;

import java.util.Date;

import org.slf4j.Logger;import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.sdp.mc.ScSettleBaseService;
import com.sdp.mc.common.job.CronTriggerJob;
import com.sdp.mc.common.util.DateUtil;
import com.sdp.withdraw.service.WithdrawRetryService;
import com.shengpay.logback.mdc.trace.utils.TraceNoUtils;

@CronTriggerJob(cronExpression = "${cron.expression.promoter.daily.profits.sync}", jobName = "代理商日分润数据推送任务")
//@CronTriggerJob(cronExpression = "0 * * * * ?", jobName = "出款失败重试任务")
public class PromoterDailyProfitsSyncJob {

	private Logger logger = LoggerFactory.getLogger(PromoterDailyProfitsSyncJob.class);

	@Autowired
	private ScSettleBaseService settleBaseService = null;

	public void execute() {
		try {
			TraceNoUtils.newTraceNo();
			logger.info("PromoterDailyProfitsSyncJob execute begin");
			String date=DateUtil.date2DateStr(DateUtil.increaseDate(new Date(),-1));
			logger.info("PromoterDailyProfitsSyncJob date:{}",date);
			settleBaseService.getPromoterDailyProfitsAPI().sendPromoterDailyProfits(date);
			logger.info("PromoterDailyProfitsSyncJob execute final");
		} catch (Exception e) {
			logger.error("PromoterDailyProfitsSyncJob execute error", e);
		}finally{
			TraceNoUtils.clearTraceNo();
		}
	}

}
