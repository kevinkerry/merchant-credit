//package com.sdp.mc.batch.newt0;
//
//import org.slf4j.Logger;import org.slf4j.LoggerFactory;
//import org.springframework.beans.factory.annotation.Autowired;
//
//import com.sdp.mc.batch.newt0.service.NewT0MerchantFastSettleService4Job;
//import com.sdp.mc.batch.withcapital.ResetFastSettleLimit4WithCapitalJob;
//import com.sdp.mc.common.job.CronTriggerJob;
//import com.shengpay.logback.mdc.trace.utils.TraceNoUtils;
//
////@CronTriggerJob(cronExpression = "${sync.fast.settle.order.status.cron}", jobName = "同步已提交的交易结算订单状态")
//public class SyncPosFastSettleOrderJob {
//	private static final Logger log = LoggerFactory.getLogger(ResetFastSettleLimit4WithCapitalJob.class);
//
//	@Autowired
//	private NewT0MerchantFastSettleService4Job newT0MerchantFastSettleService4Job;
//	public void execute() {
//		try {
//			TraceNoUtils.newTraceNo();
//			log.info("SyncPosFastSettleOrderJob.start...");
//			this.newT0MerchantFastSettleService4Job.syncT0Status();
//			log.info("SyncPosFastSettleOrderJob.finished...");
//		} catch (Exception e) {
//			log.error("SyncPosFastSettleOrderJob.error", e);
//		}finally{
//			TraceNoUtils.clearTraceNo();
//		}
//	}
//}
