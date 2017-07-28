//package com.sdp.mc.batch.fastsettle;
//
//import java.math.BigDecimal;
//import java.util.ArrayList;
//import java.util.List;
//
//import javax.annotation.PreDestroy;
//
//import org.apache.commons.lang.builder.ToStringBuilder;
//import org.slf4j.Logger;import org.slf4j.LoggerFactory;
//
//import com.sdp.mc.common.constant.MerchantCreditConstant;
//import com.sdp.mc.dao.readonly.msptxn.McSettFastTxnRO;
//import com.sdp.mc.fastsettle.thread.model.FastSettleModel;
//import com.sdp.mc.fastsettle.thread.model.PrometerMerchantCalModel;
//import com.sdp.mc.fastsettle.thread.service.FastSettleSessionThreadUtil;
//import com.sdp.mc.integration.msp.MerchantInfoDTO;
//import com.sdp.mc.integration.msp.PromoterInfoDTO;
//import com.sdp.mc.newt0.dao.Newt0SdpRemainBalanceDO;
//import com.shengpay.pos.pcs.api.settle.StraightlyCfg;
//
///**
// * 计算每个代理商额度
// * 
// * @author heyi.alex
// * 
// */
//public class CalBalanceThread implements Runnable {
//
//	private String threadName;
//
//	// private SdpFastSettleService sDPFastSettleService;
//
//	private FastSettleSessionThreadUtil fastSettleSessionThreadUtil;
//
//	private Logger logger = LoggerFactory.getLogger(CalBalanceThread.class);
//
//	/**
//	 * 是否正在运行的状态
//	 */
//	private volatile boolean isRun = true;
//
//	/**
//	 * 屏蔽掉
//	 */
//	@SuppressWarnings("unused")
//	private CalBalanceThread() {
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
//	 * 初始化
//	 * 
//	 * @param threadName
//	 * @param util
//	 */
//	public CalBalanceThread(String threadName, FastSettleSessionThreadUtil util) {
//		this.fastSettleSessionThreadUtil = util;
//		this.threadName = threadName;
//		logger.info("cal thread:" + threadName + " init-------------");
//	}
//
//	@Override
//	public void run() {
//		logger.info("cal thread:" + threadName + " start-------------");
//		while (isRun) {
//			try {
//				logger.info(threadName + ":ready get a consume cal balance");
//				// 这里如果为空的话阻塞住
//				PrometerMerchantCalModel prometerMerchantColModel = fastSettleSessionThreadUtil.consumeCalBalance();
//				PromoterInfoDTO promoterInfoDTO = prometerMerchantColModel.getPrometerInfoDTO();
//				// 数据异常
//				if (promoterInfoDTO == null) {
//					logger.error("data error:prometer is null,system error");
//					continue;
//				}
//				logger.info(threadName + ":find a consume cal balance, promoterNo is:" + promoterInfoDTO.getPromoterNo());
//				Newt0SdpRemainBalanceDO remainTotalBalanceDO = fastSettleSessionThreadUtil.getsDPFastSettleService().getNowRemainBalance();
//				// 数据延迟异常
//				if (remainTotalBalanceDO == null) {
//					logger.error("time is out not found sdp balance");
//					continue;
//				}
//				// SDP当天剩余的额度
//				BigDecimal remainaSDPBalance = remainTotalBalanceDO.getCanUseQuota();
//				// 数据库配置错误
//				if (remainaSDPBalance == null) {
//					logger.error("remainSdp not set");
//					continue;
//				}
//				// 盛付通当前时间段余额不足
//				if (remainaSDPBalance.compareTo(new BigDecimal(0)) <= 0) {
//					logger.info("remain balance not enough is:" + remainaSDPBalance);
//					continue;
//				}
//				// 代理商剩余的额度
//				BigDecimal remainPromoterBalance = remainPromoterBalance(promoterInfoDTO);
//				// 代理商数据异常
//				if (remainPromoterBalance == null) {
//					logger.error("remain promoter not found");
//					continue;
//				}
//				// 剩余代理商额度
//				if (remainPromoterBalance.compareTo(new BigDecimal(0)) <= 0) {
//					logger.info("reamin promoter balance is not enough is:" + remainPromoterBalance);
//					continue;
//				}
//
//				List<FastSettleModel> list = makeFastSettleModelList(prometerMerchantColModel, remainTotalBalanceDO, remainPromoterBalance);
//				if (list != null && list.size() > 0) {
//					BigDecimal totalAmount = new BigDecimal(0);
//					for (int i = 0; i < list.size(); i++) {
//						totalAmount = totalAmount.add(list.get(i).getTotalAmount());
//					}
//					logger.info("totalAmount[" + totalAmount + "]");
//					// 如果冻结成功
//					if (fastSettleSessionThreadUtil.getsDPFastSettleService().updateFrozen(remainTotalBalanceDO.getId(), totalAmount)) {
//						fastSettleSessionThreadUtil.produceFastSettle(list);
//					} else {
//						logger.error("concurrent made not enought balance");
//					}
//				}
//
//			} catch (InterruptedException e1) {
//				logger.error("consume interuptedException");
//				e1.printStackTrace();
//			} catch (Exception e) {
//				logger.error("exception", e);
//				e.printStackTrace();
//			}
//		}
//	}
//
//	/**
//	 * 检查余额是否足够，如果满足条件则加入到队列中返回
//	 * 
//	 * @param mcSettFastTxnRO
//	 * @return
//	 */
//	protected List<FastSettleModel> makeFastSettleModelList(PrometerMerchantCalModel prometerMerchantColModel,
//			Newt0SdpRemainBalanceDO remainTotalBalanceDO, BigDecimal remainPromoterBalance) {
//		List<MerchantInfoDTO> merchantList = prometerMerchantColModel.getList();
//		// 计算SDP的总额度
//		BigDecimal calOrderTotalAmt = new BigDecimal(0l);
//		// 计算代理商总额度
//		BigDecimal calPrometerTotalAmt = new BigDecimal(0l);
//		// 请求快速结算的队列
//		List<FastSettleModel> fastSettleList = new ArrayList<FastSettleModel>();
//		if (merchantList != null && merchantList.size() > 0) {
//			for (int i = 0; i < merchantList.size(); i++) {
//				BigDecimal calMerchantTotalAmt = new BigDecimal(0l);
//				MerchantInfoDTO merchantInfoDTO = merchantList.get(i);
//				logger.info("process merchantNo is:" + merchantInfoDTO.getMerchantNo());
//				// TODO:根据 checkresultCode 判断是否进行下面流程
//				StraightlyCfg merchantStraightCfg = reaminMerchantBalance(merchantInfoDTO);
//				// 数据异常
//				if (merchantStraightCfg == null) {
//					logger.error("merchant info is null");
//					continue;
//				}
//				// 剩余余额
//				BigDecimal remainMerchantBalance = merchantStraightCfg.getValidCredit();
//				// 余额不够
//				if (remainMerchantBalance.compareTo(new BigDecimal(0)) <= 0) {
//					logger.error("remain merchant balance is not enough,balance is:" + remainMerchantBalance);
//					continue;
//				}
//				List<McSettFastTxnRO> txnROList = queryTxnsMPOS(merchantInfoDTO);
//				// 没有快速结算订单
//				if (txnROList == null || txnROList.size() == 0) {
//					logger.info("txn is null not found:" + merchantInfoDTO.getMerchantNo());
//					continue;
//				}
//				List<McSettFastTxnRO> txnROListData = new ArrayList<McSettFastTxnRO>();
//				// 满足余额条件的boolean
//				// Boolean isAddFg = true;
//				List<Long> ids = new ArrayList<Long>();
//				for (McSettFastTxnRO mcSettFastTxnRO : txnROList) {
//					BigDecimal orderAmount = mcSettFastTxnRO.getAmt();
//					// 盛付通的剩余额度
//					if (calOrderTotalAmt.add(orderAmount).compareTo(remainTotalBalanceDO.getCanUseQuota()) > 0) {
//						logger.info("sdp remain balance is not enough, remain is:" + remainTotalBalanceDO.getCanUseQuota());
//						logger.info("order amount is:" + orderAmount.toString());
//						// isAddFg = false;
//						continue;
//					}
//					// 代理商的剩余额度
//					if (calPrometerTotalAmt.add(orderAmount).compareTo(remainPromoterBalance) > 0) {
//						logger.info("prometer balance not enought,prometerId is:" + prometerMerchantColModel.getPrometerInfoDTO().getPromoterId()
//								+ ", remainBalance is:" + remainPromoterBalance + ", need amount is:" + calPrometerTotalAmt.add(orderAmount));
//						// isAddFg = false;
//						continue;
//					}
//					// 商户的剩余额度
//					if (calMerchantTotalAmt.add(orderAmount).compareTo(remainMerchantBalance) > 0) {
//						logger.info("merchant balance not enought,merchantNo is:" + merchantInfoDTO.getMerchantNo() + ", remainBalance is:"
//								+ remainMerchantBalance + ", need amount is:" + orderAmount);
//						// isAddFg = false;
//						continue;
//					}
//					// 计算总额度
//					calOrderTotalAmt = calOrderTotalAmt.add(orderAmount);
//					// 计算代理商额度
//					calPrometerTotalAmt = calPrometerTotalAmt.add(orderAmount);
//					// 计算商户额度
//					calMerchantTotalAmt = calMerchantTotalAmt.add(orderAmount);
//
//					ids.add(mcSettFastTxnRO.getTxnOrderNo());
//					txnROListData.add(mcSettFastTxnRO);
//				}
//				if (!ids.isEmpty()) {
//					StraightlyCfg straightlyCfg = fastSettleSessionThreadUtil.getMspFacade().queryStraightlyCfg(
//							Long.valueOf(merchantInfoDTO.getMerchantId()));
//					if (straightlyCfg == null || !straightlyCfg.isStraightFlag()) {
//						logger.info("CalBalanceThread.makeFastSettleModelList,StraightlyCfg:" + ToStringBuilder.reflectionToString(straightlyCfg));
//						continue;
//					}
//					// 商户最小结算额度
//					BigDecimal floorAmt = straightlyCfg.getFloorAmt();
//					if (calMerchantTotalAmt.compareTo(floorAmt) < 0) {
//						logger.info("CalBalanceThread.makeFastSettleModelList total less than floorAmt ,total:" + calOrderTotalAmt.toString()
//								+ ",floorAmt:" + floorAmt.toString() + ",merchantNo:" + merchantInfoDTO.getMerchantNo() + ",merchantId:"
//								+ merchantInfoDTO.getMerchantId());
//						continue;
//					}
//					fastSettleList.add(makeFastSettleModel(merchantStraightCfg, merchantInfoDTO, ids, calMerchantTotalAmt, remainTotalBalanceDO,
//							prometerMerchantColModel.getPrometerInfoDTO().getPromoterId(), prometerMerchantColModel.getPrometerInfoDTO().getName(),
//							prometerMerchantColModel.getPrometerInfoDTO().getPromoterNo(), txnROListData));
//				} else {
//					logger.info("CalBalanceThread.makeFastSettleModelList:ids is empty--merchantNo:" + merchantInfoDTO.getMerchantNo());
//				}
//			}
//		} else {
//			logger.error("not foud any merchantList,system error");
//		}
//		return fastSettleList;
//	}
//
//	/**
//	 * 构建发送对象
//	 * 
//	 * @param merchantStraightCfg
//	 * @param merchantInfoDTO
//	 * @param ids
//	 * @param calMerchantTotalAmt
//	 * @param remainTotalBalanceDO
//	 * @param promoterNo
//	 * @param txnROListData
//	 * @return
//	 */
//	protected FastSettleModel makeFastSettleModel(StraightlyCfg merchantStraightCfg, MerchantInfoDTO merchantInfoDTO, List<Long> ids,
//			BigDecimal calMerchantTotalAmt, Newt0SdpRemainBalanceDO remainTotalBalanceDO, Long promoterId, String promoterName, long promoterNo,
//			List<McSettFastTxnRO> txnROListData) {
//		FastSettleModel fastSettleModel = new FastSettleModel();
//		// 盛付通快速结算方式
//		fastSettleModel.setType(MerchantCreditConstant.SDP_MERCHANT_FASTSETTLE_TYPE_AUTO);
//		fastSettleModel.setMerchantId(Long.valueOf(merchantInfoDTO.getMerchantId()));
//		fastSettleModel.setMerchantNo(merchantInfoDTO.getMerchantNo());
//		fastSettleModel.setSettleFee(merchantStraightCfg.getFeeRate());
//		fastSettleModel.setPosMerchantNo(merchantInfoDTO.getPosMerchantNo());
//		fastSettleModel.setCreateTime(remainTotalBalanceDO.getStartTime());
//		fastSettleModel.setTotalAmount(calMerchantTotalAmt);
//		fastSettleModel.setIds(ids);
//		fastSettleModel.setPromoterId(promoterId);
//		fastSettleModel.setMerchantName(merchantInfoDTO.getName());
//		fastSettleModel.setMerchantType(merchantInfoDTO.getMcType());
//		fastSettleModel.setPromoterType(merchantInfoDTO.getPromoterType());
//		fastSettleModel.setPromoterNo(promoterNo + "");
//		fastSettleModel.setPromoterName(promoterName);
//		fastSettleModel.setMcSettFastTxnROs(txnROListData);
//
//		return fastSettleModel;
//	}
//
//	/**
//	 * 获取代理商剩余可用余额
//	 * 
//	 * @param promoterInfoDTO
//	 * @return
//	 */
//	private BigDecimal remainPromoterBalance(PromoterInfoDTO promoterInfoDTO) {
//		StraightlyCfg straightlyCfg = fastSettleSessionThreadUtil.getsDPFastSettleService().queryPromoterCreditByPrometerId(
//				promoterInfoDTO.getPromoterId());
//		if (straightlyCfg == null) {
//			return null;
//		} else {
//			return straightlyCfg.getValidCredit();
//		}
//	}
//
//	/**
//	 * 获取商户剩余可用余额
//	 * 
//	 * @param merchantInfoDTO
//	 * @return
//	 */
//	private StraightlyCfg reaminMerchantBalance(MerchantInfoDTO merchantInfoDTO) {
//		return fastSettleSessionThreadUtil.getsDPFastSettleService().queryMerchantCreditByMerchantId(merchantInfoDTO.getMerchantId());
//	}
//
//	/**
//	 * 查询到素有需要快速结算的订单号
//	 * 
//	 * @param merchantInfoDTO
//	 * @return
//	 */
//	private List<McSettFastTxnRO> queryTxns(MerchantInfoDTO merchantInfoDTO) {
//		return fastSettleSessionThreadUtil.getsDPFastSettleService().queryTxnByMerchantNo(merchantInfoDTO.getMerchantNo());
//	}
//
//	private List<McSettFastTxnRO> queryTxnsMPOS(MerchantInfoDTO merchantInfoDTO) {
//		return fastSettleSessionThreadUtil.getsDPFastSettleService().queryMPOSTxnByMerchantNo(merchantInfoDTO.getMerchantNo(),
//				merchantInfoDTO.getMcType());
//	}
//
//}
