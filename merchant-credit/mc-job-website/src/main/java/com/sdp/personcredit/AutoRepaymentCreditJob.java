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
 @CronTriggerJob(cronExpression = "${auto.repayment.credit}", jobName = "自动还款")
//@CronTriggerJob(cronExpression = "0 0/1 * * * ?", jobName = "自动还款")
public class AutoRepaymentCreditJob {

	private static final Logger logger = LoggerFactory.getLogger(AutoRepaymentCreditJob.class);

	private static final String auto_repayment_result = PersonalCreditConstant.AUTO_REPAYMENT_RESULT;

	public synchronized void execute() {
		TraceNoUtils.newTraceNo();
		Long start = System.currentTimeMillis();
		try {
			logger.info("auto.repayment.credit start...");
			String values = HttpClientUtil.getMethod(auto_repayment_result, null);
			logger.info("auto.repayment.credit values {} ", values);
		} catch (Exception e) {
			logger.error("auto.repayment.credit is error：{},{}", e.getMessage(), e);
		} finally {
			TraceNoUtils.clearTraceNo();
		}
		Long end = System.currentTimeMillis();
		logger.info("auto.repayment.credit end...耗时:[" + (end - start) + "]");
	}
}
