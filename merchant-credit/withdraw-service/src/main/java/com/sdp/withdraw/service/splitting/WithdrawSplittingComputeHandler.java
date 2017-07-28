package com.sdp.withdraw.service.splitting;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sdp.mc.ScSettleBaseService;
import com.sdp.mc.settle.api.dto.SimpleOperateResponse;
import com.shengpay.logback.mdc.trace.wrapper.InheritTraceNoRunableWrapper;

/**
 * 出款成功之后调用出款分润计算
 *
 * @author liyantao01
 *
 */
@Service("WithdrawSplittingComputeHandler")
public class WithdrawSplittingComputeHandler {

	protected final ExecutorService pool = Executors.newFixedThreadPool(5);
	@Autowired
	private ScSettleBaseService settleBaseService = null;

	private Logger logger = LoggerFactory.getLogger(WithdrawSplittingComputeHandler.class);

	public void execute(Long reqId) {
		logger.info("WithdrawSplittingComputeHandler #execute.");
		WithdrawSplittingComputeTask transferIngTask = new WithdrawSplittingComputeTask(reqId);
		pool.execute(new InheritTraceNoRunableWrapper(transferIngTask));
	}

	class WithdrawSplittingComputeTask implements Runnable {

		private Logger logger = LoggerFactory.getLogger(WithdrawSplittingComputeTask.class);
        
		private Long reqId;
		
		public WithdrawSplittingComputeTask(Long reqId) {
			super();
			this.reqId=reqId;
			
		}

		public void run() {
			logger.info("WithdrawSplittingComputeTask #run,reqId:" + reqId );
			SimpleOperateResponse response=settleBaseService.getCalculateProfitAPIService().wdCalcSplitting(reqId);
			logger.info("WithdrawSplittingComputeTask response:" + ToStringBuilder.reflectionToString(response) );
		}

	}

	
}
