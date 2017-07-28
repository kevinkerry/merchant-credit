package com.sdp.mc.batch.fos;

import org.slf4j.Logger;import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.sdp.mc.common.job.CronTriggerJob;
import com.shengpay.logback.mdc.trace.utils.TraceNoUtils;

@CronTriggerJob(jobName = "转账中订单状态更新", cronExpression = "0 0/30 * * * ?")
//@CronTriggerJob(cronExpression = "0/30 * * * * ?", jobName = "转账中订单状态更新")
public class TransferIngJob {

	private Logger logger = LoggerFactory.getLogger(TransferIngJob.class);

	@Autowired
	private TransferIngHandler transferIngHandler;

	public void execute() {
		try {
			TraceNoUtils.newTraceNo();
			logger.info("TransferIngJob execute begin");
			this.transferIngHandler.execute();
			logger.info("TransferIngJob execute final");
		} catch (Exception e) {
			logger.error("TransferIngJob execute error", e);
		}finally{
			TraceNoUtils.clearTraceNo();
		}
	}
}
