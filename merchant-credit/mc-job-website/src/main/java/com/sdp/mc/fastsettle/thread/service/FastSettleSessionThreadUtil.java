//package com.sdp.mc.fastsettle.thread.service;
//
//import java.util.List;
//import java.util.Map;
//import java.util.concurrent.ArrayBlockingQueue;
//import java.util.concurrent.BlockingQueue;
//import java.util.concurrent.ConcurrentHashMap;
//import java.util.concurrent.ExecutorService;
//import java.util.concurrent.Executors;
//
//import javax.annotation.PostConstruct;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import com.sdp.mc.batch.fastsettle.CalBalanceThread;
//import com.sdp.mc.batch.fastsettle.SdpFastSettleThread;
//import com.sdp.mc.facade.msp.MspFacade;
//import com.sdp.mc.fastsettle.thread.model.FastSettleModel;
//import com.sdp.mc.fastsettle.thread.model.PrometerMerchantCalModel;
//import com.shengpay.commom.config.GlobalConfig;
//
////@Service
//public class FastSettleSessionThreadUtil {
//
//	/**
//	 * 计算收益线程池
//	 */
//	private final ExecutorService calpool = Executors.newFixedThreadPool(GlobalConfig.getInteger("com.sdp.fastSettleTask.calpool.threadNum", 10));
//	/**
//	 * 快速结算线程池
//	 */
//	private final ExecutorService fastSettlepool = Executors.newFixedThreadPool(GlobalConfig.getInteger(
//			"com.sdp.fastSettleTask.fastSettlepool.threadNum", 10));
//
//	/**
//	 * 快速结算的service
//	 */
//	@Autowired
//	private SdpFastSettleService sDPFastSettleService;
//
//	@Autowired
//	private MspFacade mspFacade;
//
//	public SdpFastSettleService getsDPFastSettleService() {
//		return sDPFastSettleService;
//	}
//
//	public MspFacade getMspFacade() {
//		return mspFacade;
//	}
//
//	public void setMspFacade(MspFacade mspFacade) {
//		this.mspFacade = mspFacade;
//	}
//
//	private static Map<Long, PrometerMerchantCalModel> modelMap = new ConcurrentHashMap<Long, PrometerMerchantCalModel>();
//
//	/**
//	 * 快速结算队列
//	 */
//	private final BlockingQueue<FastSettleModel> fastSettleblockingQ = new ArrayBlockingQueue<FastSettleModel>(50000);
//
//	/**
//	 * 代理商的计算余额队列
//	 */
//	private final BlockingQueue<PrometerMerchantCalModel> prometerBlockingQ = new ArrayBlockingQueue<PrometerMerchantCalModel>(5000);
//
//	/**
//	 * 查询剩余余额任务
//	 */
//	@PostConstruct
//	public void calJob() {
//		for (int i = 0; i < GlobalConfig.getInteger("com.sdp.fastSettleTask.calpool.threadNum", 10); i++) {
//			calpool.execute(new CalBalanceThread("cal-thread-" + i, this));
//		}
//	}
//
//	/**
//	 * 快速结算队列
//	 */
//	// @PostConstruct
//	public void initFastSettleJob() {
//		for (int i = 0; i < GlobalConfig.getInteger("com.sdp.fastSettleTask.fastSettlePool.threadNum", 10); i++) {
//			fastSettlepool.execute(new SdpFastSettleThread("fast-settle-" + i, this));
//		}
//	}
//
//	/**
//	 * 内存保护
//	 * 
//	 * @return
//	 */
//	public boolean isEnoughMemory() {
//		synchronized (fastSettleblockingQ) {
//			if (fastSettleblockingQ.size() >= 50000) { return false; }
//		}
//		synchronized (prometerBlockingQ) {
//			if (prometerBlockingQ.size() >= 5000) { return false; }
//		}
//		return true;
//	}
//
//	/**
//	 * 将代理商分组放入队列
//	 * 
//	 * @param modelMap
//	 */
//	public void produceCalBalance(Map<Long, PrometerMerchantCalModel> intoMap) throws InterruptedException {
//		synchronized (modelMap) {
//			// 去除重复的
//			modelMap.putAll(intoMap);
//		}
//		for (Map.Entry<Long, PrometerMerchantCalModel> entry : modelMap.entrySet()) {
//			prometerBlockingQ.put(entry.getValue());
//		}
//	}
//
//	/**
//	 * 将代理商分组移出队列
//	 * 
//	 * @return
//	 * @throws InterruptedException
//	 */
//	public PrometerMerchantCalModel consumeCalBalance() throws InterruptedException {
//		PrometerMerchantCalModel calModel = prometerBlockingQ.take();
//		synchronized (modelMap) {
//			modelMap.remove(calModel.getPrometerInfoDTO().getPromoterId());
//			return calModel;
//		}
//	}
//
//	/**
//	 * 将确定结果放入到发送队列
//	 * 
//	 * @param fastSettleModel
//	 * @throws InterruptedException
//	 */
//	public void produceFastSettle(List<FastSettleModel> fastSettleModelList) throws InterruptedException {
//		for (int i = 0; i < fastSettleModelList.size(); i++) {
//			fastSettleblockingQ.put(fastSettleModelList.get(i));
//		}
//	}
//
//	/**
//	 * 将确定结果放入到发送队列
//	 * 
//	 * @param fastSettleModel
//	 * @throws InterruptedException
//	 */
//	public FastSettleModel consumeFastSettle() throws InterruptedException {
//		return fastSettleblockingQ.take();
//	}
//
//}
