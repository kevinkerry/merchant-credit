package com.sdp.personcredit;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.sdp.mc.common.constant.PersonalCreditConstant;
import com.sdp.mc.common.job.CronTriggerJob;
import com.shengpay.logback.mdc.trace.utils.TraceNoUtils;
import com.shengpay.service.message.http.HttpClientUtil;

/**
 * 代扣任务查询
 */
 @CronTriggerJob(cronExpression = "${auto.withhold.query.job}", jobName = "zf1036代扣查询")
//@CronTriggerJob(cronExpression = "0 0/3 * * * ?", jobName = "efg")
public class AutoWithholdQueryJob {

	private static final Logger logger = LoggerFactory.getLogger(AutoWithholdQueryJob.class);

	private static final String auto_withhold_query_result = PersonalCreditConstant.AUTO_WITHHOLD_QUERY_RESULT;

	public synchronized void execute() {
		TraceNoUtils.newTraceNo();
		Long start = System.currentTimeMillis();
		try {
			logger.info("AutoWithholdQueryJob start...");
			String values = HttpClientUtil.getMethod(auto_withhold_query_result, null);
			logger.info("AutoWithholdQueryJob values {} ", values);
		} catch (Exception e) {
			logger.error("AutoWithholdQueryJob is error：{},{}", e.getMessage(), e);
		} finally {
			TraceNoUtils.clearTraceNo();
		}
		Long end = System.currentTimeMillis();
		logger.info("AutoWithholdQueryJob end...耗时:[" + (end - start) + "]");
	}
}
