package com.sdp.withdraw;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.sdp.mc.common.job.CronTriggerJob;
import com.shengpay.logback.mdc.trace.utils.TraceNoUtils;
import com.shengpay.service.withdraw.wallet.WalletWithdrawService;

@CronTriggerJob(cronExpression = "${cron.expression.easypay.wallet.withdraw.fail.retry}", jobName = "云收银钱包出款失败重试任务")
//@CronTriggerJob(cronExpression = "0 * * * * ?", jobName = "出款失败重试任务")
public class EasypayWalletWithdrawFailRetryJob {

	private Logger logger = LoggerFactory.getLogger(EasypayWalletWithdrawFailRetryJob.class);

	@Autowired
	private WalletWithdrawService walletWithdrawService;

	public void execute() {
		try {
			TraceNoUtils.newTraceNo();
			logger.info("EasypayWalletWithdrawFailRetryJob execute begin");
			walletWithdrawService.easypayWalletWithdrawFailRetry();
			logger.info("EasypayWalletWithdrawFailRetryJob execute final");
		} catch (Exception e) {
			logger.error("EasypayWalletWithdrawFailRetryJob execute error", e);
		}finally{
			TraceNoUtils.clearTraceNo();
		}
	}

}
