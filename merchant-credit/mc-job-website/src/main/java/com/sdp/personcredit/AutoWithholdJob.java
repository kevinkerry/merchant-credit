package com.sdp.personcredit;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.sdp.mc.common.constant.PersonalCreditConstant;
import com.sdp.mc.common.job.CronTriggerJob;
import com.shengpay.logback.mdc.trace.utils.TraceNoUtils;
import com.shengpay.service.message.http.HttpClientUtil;

/**
 * 自动还款job
 */
@CronTriggerJob(cronExpression = "${auto.withhold.job}", jobName = "zf1036代扣")
//@CronTriggerJob(cronExpression = "0 0/3 * * * ?", jobName = "abc")
public class AutoWithholdJob {

	private static final Logger logger = LoggerFactory.getLogger(AutoWithholdJob.class);

	private static final String auto_withhold_result = PersonalCreditConstant.AUTO_WITHHOLD_RESULT;

	public synchronized void execute() {
		TraceNoUtils.newTraceNo();
		Long start = System.currentTimeMillis();
		try {
			logger.info("AutoWithholdJob start...");
			String values = HttpClientUtil.getMethod(auto_withhold_result, null);
			logger.info("AutoWithholdJob values {} ", values);
		} catch (Exception e) {
			logger.error("AutoWithholdJob error：{},{}", e.getMessage(), e);
		} finally {
			TraceNoUtils.clearTraceNo();
		}
		Long end = System.currentTimeMillis();
		logger.info("AutoWithholdJob end...耗时:[" + (end - start) + "]");
	}
}
