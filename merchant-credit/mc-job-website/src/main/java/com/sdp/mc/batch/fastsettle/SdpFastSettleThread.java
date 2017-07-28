//package com.sdp.mc.batch.fastsettle;
//
//
//import org.slf4j.Logger;import org.slf4j.LoggerFactory;
//
//import com.sdp.mc.fastsettle.thread.model.FastSettleModel;
//import com.sdp.mc.fastsettle.thread.service.FastSettleSessionThreadUtil;
//import com.sdp.mc.fastsettle.thread.service.SdpFastSettleService;
//
///**
// * 盛付通快速结算消费线程
// * @author heyi.alex
// *
// */
//public class SdpFastSettleThread implements Runnable{
//
//
//	private Logger logger = LoggerFactory.getLogger(SdpFastSettleThread.class);
//
//
//	/**
//	 * 快速结算服务
//	 */
//	private SdpFastSettleService sDPFastSettleService;
//
//	/**
//	 * 存放session工具类
//	 */
//	private FastSettleSessionThreadUtil fastSettleSessionThreadUtil;
//
//	private String threadName;
//
//	/**
//	 * 是否正在运行的状态
//	 */
//	private volatile boolean isRun = true;
//
//	public void destory(){
//		stopRunning();
//	}
//
//	/**
//	 * 停止运行
//	 */
//	public void stopRunning(){
//		isRun = false;
//	}
//
//	@SuppressWarnings("unused")
//	private SdpFastSettleThread(){}
//
//	public SdpFastSettleThread(String threadName, FastSettleSessionThreadUtil util){
//		this.threadName = threadName;
//		this.fastSettleSessionThreadUtil = util;
//		this.sDPFastSettleService = fastSettleSessionThreadUtil.getsDPFastSettleService();
//		logger.info("SdpFastSettleThread:"+ this.threadName +" init--------------");
//	}
//
//	@Override
//	public void run() {
//		logger.info("SdpFastSettleThread:" + this.threadName + " start----------");
//		while (isRun){
//			try {
//				logger.info("SdpFastSettleThread:" + this.threadName + " ready consume----------");
//				FastSettleModel fastSettleModel = fastSettleSessionThreadUtil.consumeFastSettle();
//				logger.info("SdpFastSettleThread:" + this.threadName + " get one fastSettleModel----------");
//				sDPFastSettleService.sdpStraightlySettle(fastSettleModel);
//				logger.info("SdpFastSettleThread:" + this.threadName + " process fastSettleModel end ----------");
//			} catch (InterruptedException e) {
//				e.printStackTrace();
//				logger.error("InterruptedException:", e);
//			} catch (Exception e){
//				e.printStackTrace();
//				logger.error("exception:", e);
//			}
//		}
//	}
//
//}
