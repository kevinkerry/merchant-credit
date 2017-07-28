package com.sdp.mc.batch.redeemed;

import org.slf4j.Logger;import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.shengpay.logback.mdc.trace.utils.TraceNoUtils;
/**
 * 手动放款
 * @author wangmindong
 *
 */
//@CronTriggerJob(jobName = "处理退款到基本户", cronExpression = "0 0 0/2 * * ?")
//@CronTriggerJob(cronExpression = "0/30 * * * * ?", jobName = "处理退款到基本户")
public class RedeemedJob {

	private Logger logger = LoggerFactory.getLogger(RedeemedJob.class);

	@Autowired
	private RedeemedHandler redeemedHandler;

	public void execute() {
		try {
			TraceNoUtils.newTraceNo();
			logger.info("RedeemedJob execute begin");
			this.redeemedHandler.execute();
			logger.info("RedeemedJob execute final");
		} catch (Exception e) {
			logger.error("RedeemedJob execute error", e);
		}finally{
			TraceNoUtils.clearTraceNo();
		}
	}
}
