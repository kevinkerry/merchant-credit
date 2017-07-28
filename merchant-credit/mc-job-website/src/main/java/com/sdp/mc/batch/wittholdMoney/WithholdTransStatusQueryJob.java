package com.sdp.mc.batch.wittholdMoney;

import org.slf4j.Logger;import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.sdp.mc.common.job.CronTriggerJob;
import com.shengpay.autorepayment.service.WithholdFileService;
import com.shengpay.logback.mdc.trace.utils.TraceNoUtils;


@CronTriggerJob(cronExpression = "${withhold.trans.status.query.job}", jobName = "代扣-查询")
//@CronTriggerJob(cronExpression = "0 0/3 * * * ?", jobName = "代扣查询-状态查询")
public class WithholdTransStatusQueryJob {
	private static final Logger log = LoggerFactory.getLogger(WithholdTransStatusQueryJob.class);
	@Autowired
	public WithholdFileService withholdService;
	public void execute() {
		try {
			TraceNoUtils.newTraceNo();
			log.info("query withhold order status start...");
			withholdService.transStautsQueryExecute();
			log.info("query withhold order status end...");
		} catch (Exception e) {
			log.error("代扣支付状态查询异常..."+e);
		}finally{
			TraceNoUtils.clearTraceNo();
		}
	}
}
