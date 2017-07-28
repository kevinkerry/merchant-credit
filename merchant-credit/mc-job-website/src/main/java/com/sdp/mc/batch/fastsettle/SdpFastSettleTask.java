//package com.sdp.mc.batch.fastsettle;
//
//import java.math.BigDecimal;
//import java.util.Map;
//
//import javax.annotation.PostConstruct;
//import javax.annotation.PreDestroy;
//
//import org.slf4j.Logger;import org.slf4j.LoggerFactory;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import com.sdp.mc.batch.BaseHandler;
//import com.sdp.mc.fastsettle.thread.model.PrometerMerchantCalModel;
//import com.sdp.mc.fastsettle.thread.service.FastSettleSessionThreadUtil;
//import com.sdp.mc.fastsettle.thread.service.SdpFastSettleService;
//import com.sdp.mc.newt0.dao.Newt0SdpRemainBalanceDO;
//import com.shengpay.commom.config.GlobalConfig;
//
///**
// * 
// * 启动一个线程用户生产快速结算的队列
// * 
// * @author heyi.alex
// * 
// */
//// @Service
//public class SdpFastSettleTask extends BaseHandler {
//
//	private Logger logger = LoggerFactory.getLogger(SdpFastSettleTask.class);
//
//	@Autowired
//	private SdpFastSettleService sDPFastSettleService;
//
//	@Autowired
//	private FastSettleSessionThreadUtil fastSettleSessionThreadPool;
//
//	/**
//	 * 是否正在运行的状态
//	 */
//	private volatile boolean isRun = true;
//
//	@PostConstruct
//	public void init() {
//		// start
//		Thread a = new Thread(new SDPFastSettleThread("sdp fast settle thread"));
//		a.start();
//		logger.info("init started");
//	}
//
//	@PreDestroy
//	public void destory() {
//		stopRunning();
//	}
//
//	/**
//	 * 停止运行
//	 */
//	public void stopRunning() {
//		isRun = false;
//	}
//
//	/**
//	 * 初始化的时候， 1.加载所有开通自动结算的代理商 2.获取这些代理商下所有的商户(通过接口) 3.漏选出开通盛付通自动结算的商户
//	 * 
//	 * @author heyi.alex
//	 * 
//	 */
//	private class SDPFastSettleThread implements Runnable {
//
//		private String threadName;
//
//		/**
//		 * 线程间隔
//		 */
//		protected Long interval = GlobalConfig.getLong("com.sdp.fastSettleTask.interval", 60l);
//
//		public SDPFastSettleThread(final String threadName) {
//			this.threadName = threadName;
//			logger.info("init thread is:" + threadName + " init-------------------------------");
//		}
//
//		@Override
//		public void run() {
//			logger.info("init thread is:" + threadName + " init-------------------------------");
//			while (isRun) {
//				try {
//					long startTime = System.currentTimeMillis();
//					// 队列是否太多，来不及处理
//					if (fastSettleSessionThreadPool.isEnoughMemory()) {
//						// 当前是否到时间点以及余额
//						Newt0SdpRemainBalanceDO balance = sDPFastSettleService.getNowRemainBalance();
//						// 可运行时间，有余额
//						if (balance != null && balance.getCanUseQuota().compareTo(new BigDecimal(0)) > 0) {
//							Map<Long, PrometerMerchantCalModel> modelMap = sDPFastSettleService.groupByPrometer();
//							if (modelMap != null) {
//								// 计算分发任务
//								fastSettleSessionThreadPool.produceCalBalance(modelMap);
//							}
//						}
//					}
//					long endTime = System.currentTimeMillis();
//					Long sleepTime = (interval * 1000) - (endTime - startTime);
//					if (sleepTime > 0) {
//						// start sleep
//						logger.info(threadName + "start sleeping");
//						Thread.sleep(sleepTime);
//						logger.info(threadName + "end sleeping");
//					}
//				} catch (InterruptedException e) {
//					e.printStackTrace();
//					logger.error("InterruptedException:", e);
//				} catch (Exception e) {
//					e.printStackTrace();
//					logger.error("exception:", e);
//				}
//			}
//		}
//	}
//
//}
