//package com.sdp.mc.fastsettle.thread.service;
//
//import java.math.BigDecimal;
//import java.util.ArrayList;
//import java.util.Calendar;
//import java.util.Date;
//import java.util.HashMap;
//import java.util.List;
//import java.util.Map;
//
//import org.apache.commons.lang.builder.ToStringBuilder;
//import org.apache.cxf.common.util.StringUtils;
//import org.slf4j.Logger;import org.slf4j.LoggerFactory;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import com.sdo.common.lang.StringUtil;
//import com.sdp.mc.common.bean.newt0.LoaningConfigBean;
//import com.sdp.mc.common.constant.MerchantCreditConstant;
//import com.sdp.mc.common.enums.LoaningTypeEnum;
//import com.sdp.mc.common.enums.StraightlySettleResultEnums;
//import com.sdp.mc.common.vo.ErrorMessageVO;
//import com.sdp.mc.dao.readonly.msptxn.McSettFastTxnRO;
//import com.sdp.mc.facade.msp.FastSettleHessianInterface;
//import com.sdp.mc.facade.msp.MspFacade;
//import com.sdp.mc.facade.msp.enums.MerchantFastSettleSubStatusEnum;
//import com.sdp.mc.fastsettle.thread.model.FastSettleModel;
//import com.sdp.mc.fastsettle.thread.model.PrometerMerchantCalModel;
//import com.sdp.mc.ffconfig.dao.FastSettleConfigDO;
//import com.sdp.mc.ffconfig.dao.FastSettleConfigDOExample;
//import com.sdp.mc.ffconfig.manager.FastSettleConfigManager;
//import com.sdp.mc.integration.msp.MerchantInfoDTO;
//import com.sdp.mc.integration.msp.PromoterInfoDTO;
//import com.sdp.mc.merchant.dao.MerchantFsReq;
//import com.sdp.mc.merchant.dao.MerchantFsReqExample;
//import com.sdp.mc.merchant.dao.MerchantFsTradeDO;
//import com.sdp.mc.merchant.manager.MerchantFsRManager;
//import com.sdp.mc.merchant.manager.MerchantFsTradeManager;
//import com.sdp.mc.newt0.dao.Newt0PromoterDO;
//import com.sdp.mc.newt0.dao.Newt0SdpRemainBalanceDO;
//import com.sdp.mc.newt0.dao.Newt0SdpRemainBalanceDOExample;
//import com.sdp.mc.newt0.manager.ExtNewt0SdpRemainBalanceManager;
//import com.sdp.mc.newt0.manager.Newt0PromoterManager;
//import com.sdp.mc.service.newt0.loaning.config.LoaningCongfigService;
//import com.sdp.util.cache.CacheEntity;
//import com.sdp.util.cache.CacheTimerHandler;
//import com.shengpay.commom.config.GlobalConfig;
//import com.shengpay.pos.pcs.api.settle.StraightlyCfg;
//import com.shengpay.pos.pcs.api.settle.StraightlySettleResult;
//import com.shengpay.pos.pcs_t0.api.fastsettle.FastSettleFundOutInfo;
//
///**
// *
// * @author heyi.alex
// *
// */
//@Service
//public class SdpFastSettleService {
//
//	/**
//	 * 代理商分组缓存
//	 */
//	public static final String TempPrometerCache = "TempPrometerCache";
//
//	/**
//	 * 配置分组
//	 */
//	public static final String TempConfigSettingCache = "TempConfigSettingCache";
//
//	/**
//	 * 缓存有效时间:默认300s
//	 */
//	protected Integer sessionTime = GlobalConfig.getInteger("com.sdp.fastSettleTask.interval", 30);
//
//	@Autowired
//	protected FastSettleConfigManager fastSettleConfigManager;
//
//	@Autowired
//	protected ExtNewt0SdpRemainBalanceManager extNewt0SdpRemainBalanceManager;
//
//	@Autowired
//	protected MspFacade mspFacade;
//
//	@Autowired
//	private MerchantFsRManager merchantFsRManager;
//
//	@Autowired
//	private MerchantFsTradeManager tradeManager;
//
//	@Autowired
//	private FastSettleHessianInterface fastSettleHessianInterface;
//
//	@Autowired
//	private LoaningCongfigService loaningCongfigService;
//
//	@Autowired
//	private FastSettleHessianInterface fastSettleHessianInterfaceProxy;
//
//	@Autowired
//	private Newt0PromoterManager newt0PromoterManager;
//
//	private Logger logger = LoggerFactory.getLogger(SdpFastSettleService.class);
//
//	public List<FastSettleFundOutInfo> queryFastSettleFundOutInfo(List<String> list) {
//		return fastSettleHessianInterface.queryFastSettleFundOutInfo(list);
//	}
//
//	/**
//	 * 检索出未过期的订单
//	 */
//	public List<MerchantFsReq> selectNeedCheckMerchantFsReq() {
//		Calendar cal = Calendar.getInstance();
//		cal.add(Calendar.DATE, -7);
//		MerchantFsReqExample example = new MerchantFsReqExample();
//		MerchantFsReqExample.Criteria criteria = example.createCriteria();
//		criteria.andTypeEqualTo(MerchantCreditConstant.SDP_MERCHANT_FASTSETTLE_TYPE_AUTO);
//		criteria.andStatusEqualTo(Integer.parseInt(StraightlySettleResultEnums.INIT.code));
//		criteria.andUpdateTimeGreaterThanOrEqualTo(cal.getTime());
//		return merchantFsRManager.selectByExample(example);
//	}
//
//	/**
//	 * 检索出已过期的订单
//	 *
//	 * @return
//	 */
//	public List<MerchantFsReq> selectOverTimeMerchantFsReq() {
//		Calendar cal = Calendar.getInstance();
//		cal.add(Calendar.DATE, -7);
//		MerchantFsReqExample example = new MerchantFsReqExample();
//		MerchantFsReqExample.Criteria criteria = example.createCriteria();
//		criteria.andTypeEqualTo(MerchantCreditConstant.SDP_MERCHANT_FASTSETTLE_TYPE_AUTO);
//		criteria.andStatusEqualTo(Integer.parseInt(StraightlySettleResultEnums.INIT.code));
//		criteria.andUpdateTimeLessThanOrEqualTo(cal.getTime());
//		return merchantFsRManager.selectByExample(example);
//	}
//
//	/**
//	 * 获取状态为2开通盛付通出资的账户
//	 *
//	 * @return
//	 */
//	public List<FastSettleConfigDO> selectAutoFastSettle() {
//		FastSettleConfigDOExample example = new FastSettleConfigDOExample();
//		example.createCriteria().andAutoFastSettleEqualTo(MerchantCreditConstant.MERCHANT_AUTO_FASTSETTLE_ON_LOANING_SHENGPAY);
//		List<FastSettleConfigDO> fastSettleConfigDOs = fastSettleConfigManager.selectByExample(example);
//		return fastSettleConfigDOs;
//	}
//
//	/**
//	 * 获取最新当前有余额的记录
//	 *
//	 * @return
//	 */
//	public Newt0SdpRemainBalanceDO getNowRemainBalance() {
//		Date now = new Date();
//		CacheEntity<LoaningConfigBean> cache = CacheTimerHandler.getCache(TempConfigSettingCache);
//		Date startTime = null;
//		Date endTime = new Date();
//		if (cache == null) {
//			LoaningConfigBean loaningConfigBean = loaningCongfigService.getLoaningConfigBeanByLoaningType(LoaningTypeEnum.SHENGPAY);
//			CacheTimerHandler.addCache(TempConfigSettingCache, new CacheEntity<LoaningConfigBean>(loaningConfigBean));
//			startTime = loaningConfigBean.findFsBeginDate();
//			endTime = loaningConfigBean.findFsEndDate();
//		} else {
//			startTime = cache.getCacheContext().findFsBeginDate();
//			endTime = cache.getCacheContext().findFsEndDate();
//		}
//		if (now.getTime() > startTime.getTime() && now.getTime() < endTime.getTime()) {
//			Newt0SdpRemainBalanceDOExample example = new Newt0SdpRemainBalanceDOExample();
//			Newt0SdpRemainBalanceDOExample.Criteria criteria = example.createCriteria();
//			criteria.andStartTimeLessThanOrEqualTo(now);
//			criteria.andEndTimeGreaterThan(now);
//			criteria.andCanUseQuotaGreaterThan(new BigDecimal(0));
//			List<Newt0SdpRemainBalanceDO> list = extNewt0SdpRemainBalanceManager.selectByExample(example);
//			if (list != null && list.size() > 0) { return list.get(0); }
//		}
//		return null;
//	}
//
//	/**
//	 * 根据商户No获取快速结算订单
//	 *
//	 * @param merchantNo
//	 * @return
//	 */
//	public List<McSettFastTxnRO> queryTxnByMerchantNo(String merchantNo) {
//		return mspFacade.queryMerchantValidFsOrders(merchantNo);
//	}
//
//	public List<McSettFastTxnRO> queryMPOSTxnByMerchantNo(String merchantNo, String type) {
//		return mspFacade.queryMerchantValidFsOrdersForMpos(merchantNo, type);
//	}
//
//	/**
//	 * 根据merchantId获取商户当前可用额度
//	 *
//	 * @param merchantId
//	 * @return
//	 */
//	public StraightlyCfg queryMerchantCreditByMerchantId(String merchantId) {
//		if (StringUtils.isEmpty(merchantId)) { return null; }
//		return mspFacade.queryStraightlyCfg(Long.valueOf(merchantId));
//	}
//
//	/**
//	 * 根据代理商id获取代理商信用额度
//	 *
//	 * @param promoterId
//	 * @return
//	 */
//	public StraightlyCfg queryPromoterCreditByPrometerId(Long promoterId) {
//		return mspFacade.getPromoterCredit(promoterId);
//	}
//
//	/**
//	 * 将商户和代理商关联起来
//	 *
//	 * @param prometerMerchantMap
//	 * @param prometer
//	 * @param merchantInfoDTO
//	 */
//	private void putIntoPrometerMerchantMap(Map<Long, PrometerMerchantCalModel> prometerMerchantMap, PromoterInfoDTO prometer,
//			MerchantInfoDTO merchantInfoDTO) {
//		PrometerMerchantCalModel colModel = prometerMerchantMap.get(prometer.getPromoterId());
//		if (colModel == null) {
//			colModel = new PrometerMerchantCalModel(prometer);
//		}
//		colModel.add(merchantInfoDTO);
//		prometerMerchantMap.put(prometer.getPromoterId(), colModel);
//	}
//
//	/**
//	 * 根据每个代理商整理出下面开通盛付通配资的商户
//	 *
//	 * @return
//	 */
//	public Map<Long, PrometerMerchantCalModel> groupByPrometer() {
//		CacheEntity<Map<Long, PrometerMerchantCalModel>> cache = CacheTimerHandler.getCache(TempPrometerCache);
//		if (cache == null) {
//			Map<Long, PrometerMerchantCalModel> prometerMerchantMap = new HashMap<Long, PrometerMerchantCalModel>();
//			List<FastSettleConfigDO> configList = selectAutoFastSettle();
//			// 没有任务检索数据的时候
//			if (configList == null || configList.size() == 0) { return null; }
//			Map<Long, PromoterInfoDTO> prometerTempMap = new HashMap<Long, PromoterInfoDTO>();
//			for (int i = 0; i < configList.size(); i++) {
//				FastSettleConfigDO fastSettleConfigDO = configList.get(i);
//				MerchantInfoDTO merchantInfoDTO = mspFacade.findMerchantInfoByMerchantId(fastSettleConfigDO.getObjId());
//				// 缓存中没有再去获取一遍
//				PromoterInfoDTO prometer = prometerTempMap.get(merchantInfoDTO.getPromoterId());
//				if (prometer == null) {
//					prometer = mspFacade.findPromoterInfoByPromoterId(merchantInfoDTO.getPromoterId());
//					// 放入缓存中
//					prometerTempMap.put(merchantInfoDTO.getPromoterId(), prometer);
//				}
//				putIntoPrometerMerchantMap(prometerMerchantMap, prometer, merchantInfoDTO);
//			}
//			CacheTimerHandler.addCache(TempPrometerCache, new CacheEntity<Map<Long, PrometerMerchantCalModel>>(prometerMerchantMap), sessionTime);
//			return prometerMerchantMap;
//		} else {
//			return cache.getCacheContext();
//		}
//	}
//
//	/**
//	 * 将可用额度冻结掉
//	 *
//	 * @param id
//	 * @param amount
//	 * @return
//	 */
//	public boolean updateFrozen(Long id, BigDecimal amount) {
//		Map<String, Object> updateMap = new HashMap<String, Object>();
//		updateMap.put("id", id);
//		updateMap.put("amount", amount);
//		return extNewt0SdpRemainBalanceManager.updateSdpFrozenAmount(updateMap);
//	}
//
//	/**
//	 * 成功将冻结额度扣除
//	 *
//	 * @param startTime
//	 * @param amount
//	 * @return
//	 */
//	public boolean updateFrozenSuccess(Date startTime, BigDecimal amount) {
//		Map<String, Object> updateMap = new HashMap<String, Object>();
//		updateMap.put("startTime", startTime);
//		updateMap.put("amount", amount);
//		return extNewt0SdpRemainBalanceManager.frozenAmountSuccess(updateMap);
//	}
//
//	/**
//	 * 失败将冻结额度回滚
//	 *
//	 * @param startTime
//	 * @param amount
//	 * @return
//	 */
//	public boolean updateFrozenFail(Date startTime, BigDecimal amount) {
//		Map<String, Object> updateMap = new HashMap<String, Object>();
//		updateMap.put("startTime", startTime);
//		updateMap.put("amount", amount);
//		return extNewt0SdpRemainBalanceManager.frozenAmountFail(updateMap);
//	}
//
//	/**
//	 * sdp的快速结算
//	 *
//	 * @param fastSettleModel
//	 * @return
//	 */
//	public String sdpStraightlySettle(FastSettleModel fastSettleModel) {
//		List<McSettFastTxnRO> list = fastSettleModel.getMcSettFastTxnROs();
//		BigDecimal totalAmount = fastSettleModel.getTotalAmount();
//		Integer type = fastSettleModel.getType();
//		Long merchantId = fastSettleModel.getMerchantId();
//		List<Long> orderIds = fastSettleModel.getIds();
//		BigDecimal settleFee = fastSettleModel.getSettleFee();
//		String merchantNo = fastSettleModel.getMerchantNo();
//		String posMerchantNo = fastSettleModel.getPosMerchantNo();
//		List<Long> ids = fastSettleModel.getIds();
//
//		MerchantFsReq fsReq = new MerchantFsReq();
//		fsReq.setMerchantId(merchantId);
//		fsReq.setType(type);
//		fsReq.setTradeCnt(orderIds.size() + 0l);
//		fsReq.setSettleFee(settleFee);
//		fsReq.setAmount(totalAmount.toString());
//		// fsReq.setCreateTime(fastSettleModel.getCreateTime());
//		fsReq.setCreateTime(new Date());
//		fsReq.setStatus(Integer.parseInt(StraightlySettleResultEnums.INIT.code));
//		fsReq.setSubStatus(MerchantFastSettleSubStatusEnum.SUBMITTED.getCode());
//		fsReq.setMerchantNo(fastSettleModel.getMerchantNo());
//		fsReq.setMcType(fastSettleModel.getMerchantType());
//		fsReq.setMerchantName(fastSettleModel.getMerchantName());
//		fsReq.setPromoterNo(fastSettleModel.getPromoterNo());
//		fsReq.setPromoterName(fastSettleModel.getPromoterName());
//		fsReq.setPromoterId(fastSettleModel.getPromoterId());
//		// 申请时间
//		fsReq.setApplyTime(new Date());
//		Long mfqId = merchantFsRManager.insert(fsReq);
//		fsReq.setMfqId(mfqId);
//		// 垫资方
//		fsReq.setLoaningType(LoaningTypeEnum.SHENGPAY.getCode());
//		for (McSettFastTxnRO mcSettFastTxnRO : list) {
//			MerchantFsTradeDO tradeDO = McSettFastTxnRO2MerchantFsTradeDO(mcSettFastTxnRO, mfqId);
//			tradeDO.setMfqId(mfqId);
//			tradeManager.insert(tradeDO);
//		}
//		try {
//			Newt0PromoterDO newt0PromoterDO = this.newt0PromoterManager.getPromoterByMerchantId(fastSettleModel.getPromoterId());
//			ErrorMessageVO straightlySettleResult = fastSettleHessianInterfaceProxy.straightlySettle(merchantNo, posMerchantNo, ids,
//					mfqId.toString(), newt0PromoterDO.getLoaningType());
//			logger.info("SdpFastSettleService#sdpStraightlySettle,merchantNo:" + merchantNo + ", posMerchantNo:" + posMerchantNo + ", ids:" + ids
//					+ ",mfqId=" + mfqId + ",code:" + straightlySettleResult.getErrorCode() + ",msg:" + straightlySettleResult.getErrorMessage());
//
//			fsReq.setStatus(Integer.parseInt(straightlySettleResult.getErrorCode()));
//			if (!straightlySettleResult.getErrorCode().equals(StraightlySettleResult.SUCESS.getCode())) {
//				// 如果失败了，拿到结算单号
//				List<String> orderIdList = new ArrayList<String>();
//				orderIdList.add(mfqId.toString());
//				List<FastSettleFundOutInfo> listFastSettleInfo = fastSettleHessianInterfaceProxy.queryFastSettleFundOutInfo(orderIdList);
//				logger.info("SdpFastSettleService#sdpStraightlySettle listFastSettleInfo:" + ToStringBuilder.reflectionToString(listFastSettleInfo));
//				String settleBillNo = "";
//				if (listFastSettleInfo != null) {
//					for (FastSettleFundOutInfo fastInfo : listFastSettleInfo) {
//						if (StringUtil.isBlank(settleBillNo)) {
//							settleBillNo = fastInfo.getSettleBillNo();
//						} else {
//							break;
//						}
//					}
//				}
//				fsReq.setSettleBillNo(settleBillNo);
//				fsReq.setUpdateTime(new Date());
//				merchantFsRManager.updateByPrimaryKeySelective(fsReq);
//				return straightlySettleResult.getErrorMessage();
//			}
//			fsReq.setUpdateTime(new Date());
//			fsReq.setSubStatus(MerchantFastSettleSubStatusEnum.SUBMITTED.getCode());
//
//			MerchantInfoDTO merchant = mspFacade.findMerchantInfoByMerchantId(Long.valueOf(merchantId));
//			PromoterInfoDTO promoter = mspFacade.findPromoterInfoByPromoterId(merchant.getPromoterId());
//			fsReq.setMcType(merchant.getMcType());
//			fsReq.setMerchantName(merchant.getName());
//			fsReq.setMerchantNo(merchant.getMerchantNo());
//			fsReq.setPromoterId(promoter.getPromoterId());
//			fsReq.setPromoterNo(promoter.getPromoterNo() + "");
//			fsReq.setPromoterName(promoter.getName());
//
//			merchantFsRManager.updateByPrimaryKeySelective(fsReq);
//		} catch (Exception e) {
//			logger.error("SdpFastSettleService #straightlySettle:invoke straightlySettle system exception." + e, e);
//			fsReq.setStatus(Integer.parseInt(StraightlySettleResultEnums.RESULT_ERROR.code));
//			fsReq.setUpdateTime(new Date());
//			merchantFsRManager.updateByPrimaryKeySelective(fsReq);
//			return "invoke straightlySettle system exception." + e;
//		}
//		return null;
//
//	}
//
//	private MerchantFsTradeDO McSettFastTxnRO2MerchantFsTradeDO(McSettFastTxnRO settFastTxnRO, Long mfqId) {
//		MerchantFsTradeDO tradeDO = new MerchantFsTradeDO();
//		tradeDO.setMfqId(mfqId);
//		tradeDO.setTradeTime(settFastTxnRO.getTxnTime());
//		tradeDO.setTxnNo(settFastTxnRO.getTxnNo().toString());
//		tradeDO.setTradeType(settFastTxnRO.getTxnTypeName());
//		tradeDO.setTxnType(settFastTxnRO.getTxnType());
//		tradeDO.setTradeStatus(settFastTxnRO.getTxnStatusName());
//		tradeDO.setTxnStatus(settFastTxnRO.getTxnStatus());
//		tradeDO.setOrderNo(settFastTxnRO.getTxnOrderNo().toString());
//		tradeDO.setTradeAmount(settFastTxnRO.getAmt());
//		tradeDO.setTradeFee(settFastTxnRO.getFee());
//		tradeDO.setSettleAmount(settFastTxnRO.getStlAmt());
//		tradeDO.setCardType(settFastTxnRO.getCardTypeName());
//		tradeDO.setTxnCardType(settFastTxnRO.getCardType());
//		tradeDO.setShortPan(settFastTxnRO.getShortPanAsterisk());
//		tradeDO.setIssuerId(settFastTxnRO.getIssuerName());
//		tradeDO.setTxnIssuerId(settFastTxnRO.getIssuerId());
//		tradeDO.setTerminalNo(settFastTxnRO.getTerminalNo());
//		tradeDO.setTxnShortPan(settFastTxnRO.getShortPan());
//		tradeDO.setCreateTime(new Date());
//		return tradeDO;
//	}
//
//}
