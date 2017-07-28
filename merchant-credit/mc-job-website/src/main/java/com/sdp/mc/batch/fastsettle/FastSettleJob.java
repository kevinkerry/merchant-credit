//package com.sdp.mc.batch.fastsettle;
//
//import org.slf4j.Logger;import org.slf4j.LoggerFactory;
//import org.springframework.beans.factory.annotation.Autowired;
//
//import com.sdp.mc.common.job.CronTriggerJob;
////@CronTriggerJob(cronExpression = "${auto.t0.fast.settle}", jobName = "自动快速结算")
////@CronTriggerJob(jobName = "自动快速结算", cronExpression = "0 0 11,13,15 * * ?")
////@CronTriggerJob(cronExpression = "0/30 * * * * ?", jobName = "自动快速结算")
//public class FastSettleJob {
//
//	private Logger logger = LoggerFactory.getLogger(FastSettleJob.class);
//
//	@Autowired
//	private FastSettleHandler fastSettleHandler;
//
//	public void execute() {
//		try {
//			logger.info("FastSettleJob execute begin");
//			this.fastSettleHandler.execute();
//			logger.info("FastSettleJob execute final");
//		} catch (Exception e) {
//			logger.error("FastSettleJob execute error", e);
//		}
//	}
//}
