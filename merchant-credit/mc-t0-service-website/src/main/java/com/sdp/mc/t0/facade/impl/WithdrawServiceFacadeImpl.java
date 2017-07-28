package com.sdp.mc.t0.facade.impl;

import java.math.BigDecimal;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import net.sf.json.JSONObject;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.dozer.Mapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.context.ContextLoader;
import org.springframework.web.context.WebApplicationContext;

import com.caucho.hessian.client.HessianProxyFactory;
import com.sdp.mc.common.constant.MerchantCreditConstant;
import com.sdp.mc.common.constant.WithdrawConstant;
import com.sdp.mc.common.hessian.RemotingCallUtil;
import com.sdp.mc.common.hessian.RemotingModuleEnum;
import com.sdp.mc.common.util.ConfigOptionHelper;
import com.sdp.mc.common.util.DateUtil;
import com.sdp.mc.config.manager.ConfigOptionManager;
import com.sdp.mc.dao.readonly.msp.mspposmerchant.MspPosMerchantEO;
import com.sdp.mc.dao.readonly.msp.mspposmerchant.PmtQueryPosMerchantPO;
import com.sdp.mc.dao.readonly.promoter.PromoterEO;
import com.sdp.mc.service.msp.posmerchant.PosMerchantService;
import com.sdp.mc.service.msp.promoter.PromoterService;
import com.sdp.mc.t0.Constants;
import com.sdp.mc.t0.facade.WithdrawServiceFacade;
import com.sdp.withdraw.api.WithdrawT0ServiceAPI;
import com.sdp.withdraw.api.merchant.SynMerchantInfoServiceAPI;
import com.sdp.withdraw.dao.PosMerchantInfoDO;
import com.sdp.withdraw.dao.PosMerchantInfoDOExample;
import com.sdp.withdraw.vo.BankCardInfo;
import com.sdp.withdraw.vo.WithdrawCheckRequest;
import com.sdp.withdraw.vo.WithdrawCheckResponse;
import com.sdp.withdraw.vo.WithdrawProductRequest;
import com.sdp.withdraw.vo.WithdrawProductResponse;
import com.sdp.withdraw.vo.WithdrawQueryRequest;
import com.sdp.withdraw.vo.WithdrawQueryResponse;
import com.sdp.withdraw.vo.WithdrawT0ServiceRequest;
import com.sdp.withdraw.vo.WithdrawT0ServiceResponse;
import com.sdp.withdraw.vo.merchant.MerchantInfoRequest;
import com.sdp.withdraw.vo.merchant.QueryMerchantRequest;
import com.sdp.withdraw.vo.merchant.QueryMerchantResponse;
import com.sdp.withdraw.vo.merchant.QueryPromoterRequest;
import com.sdp.withdraw.vo.merchant.QueryPromoterResponse;
import com.sdp.withdraw.vo.merchant.SynMerchantRequest;
import com.sdp.withdraw.vo.merchant.SynPromoterRequest;
import com.sdp.withdraw.vo.merchant.SynResponse;
import com.shengpay.service.BaseCommonService;
import com.shengpay.service.withdraw.FwPosMerchantInfoService;
import com.snda.toolkit.common.util.StringUtil;

@Service
public class WithdrawServiceFacadeImpl implements WithdrawServiceFacade {

	private Logger logger = LoggerFactory.getLogger(WithdrawServiceFacadeImpl.class);

	// @Autowired
	private WithdrawT0ServiceAPI withdrawT0ServiceAPI;

	private SynMerchantInfoServiceAPI synMerchantInfoServiceAPI;

	@Autowired
	private FwPosMerchantInfoService fwPosMerchantInfoService;
	@Autowired
	private PromoterService promoterService;
	@Autowired
	private PosMerchantService posMerchantService;

	@Autowired
	protected Mapper beanMapper;
	@Autowired
	protected SyncMerchantHandler syncMerchantHandler;

	@Autowired
	private ConfigOptionManager configOptionManager;

	private WithdrawT0ServiceAPI getWithdrawT0ServiceAPI() {
		if (withdrawT0ServiceAPI == null) {
			withdrawT0ServiceAPI = RemotingCallUtil.getHessianServiceByModuleWithoutCanonicalName(RemotingModuleEnum.T0_WITHDRAW_SERVICE_URL,
					WithdrawT0ServiceAPI.class);
		}
		return withdrawT0ServiceAPI;
	}

	public SynMerchantInfoServiceAPI getSynMerchantInfoServiceAPI() {
		try {// 先从容器中获取对象
			if (synMerchantInfoServiceAPI == null) {
				WebApplicationContext wac = ContextLoader.getCurrentWebApplicationContext();
				synMerchantInfoServiceAPI = (SynMerchantInfoServiceAPI) wac.getBean("synMerchantInfoService");
			}
		} catch (Exception e) {
		}
		/*
		 * if (synMerchantInfoServiceAPI == null) { synMerchantInfoServiceAPI =
		 * RemotingCallUtil
		 * .getHessianServiceByModuleWithoutCanonicalName(RemotingModuleEnum
		 * .T0_WITHDRAW_SERVICE_URL, WithdrawT0ServiceAPI.class); }
		 */
		return synMerchantInfoServiceAPI;
	}

	protected String result2Json(Object result) {
		String resultJson = JSONObject.fromObject(result).toString();
		logger.info("T0ServiceFacadeImpl #result2Json:" + resultJson);
		return resultJson;
	}

	@Override
	public String applyPosWithdraw(String merchantNo, String appId, String withdrawAmount, String originalAmount, String mcType, String withdrawType,
			String orderNo) {
		// Assert.notNull(merchantNo);
		// Assert.notNull(withdrawAmount);
		// Assert.notNull(originalAmount);
		// Assert.notNull(appId);
		// String url =
		// "http://10.132.97.12:8085/mc-t0-service-website/hessian/withdrawServiceHessian";
		// String url =
		// "http://127.0.0.1:8080/mc-t0-service-website/hessian/withdrawServiceHessian";
		HessianProxyFactory factory = new HessianProxyFactory();
		factory.setOverloadEnabled(true);
		WithdrawT0ServiceAPI service;
		try {
			service = getWithdrawT0ServiceAPI();
			WithdrawT0ServiceRequest request = new WithdrawT0ServiceRequest();
			request.setAppId(appId);
			request.setApplyTime(new Date());
			request.setMerchantNo(merchantNo);
			request.setMcType(mcType);
			request.setWithdrawType(withdrawType);

			if (StringUtils.isBlank(originalAmount)) {
				request.setWithdrawAmount(null);
			} else {
				request.setWithdrawAmount(new BigDecimal(withdrawAmount));
			}
			if (StringUtils.isBlank(originalAmount)) {
				request.setOriginalAmount(null);
			} else {
				request.setOriginalAmount(new BigDecimal(originalAmount));
			}

			if (StringUtils.isEmpty(orderNo)) {
				request.setOrderNo(BaseCommonService.generatorSeq());
			} else {
				request.setOrderNo(orderNo);
			}
			request.setCallbackAddress(WithdrawConstant.WITHDRAW_CALLBACK_ADDRESS);
			request.setSignature(request.getSignStr(WithdrawConstant.MD5key));
			WithdrawT0ServiceResponse response = service.t0WithdrawPos(request);
			return result2Json(response);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			logger.error("WithdrawServiceFacadeImpl.applyPosWithdraw.error" + e.getMessage(), e);
			return result2Json("" + e.getMessage());
		}

	}

	@Override
	public String checkPosWithdraw(String merchantNo, String appId, String mcType, String originalAmount) {
		// Assert.notNull(merchantNo);
		// Assert.notNull(withdrawAmount);
		// Assert.notNull(originalAmount);
		// Assert.notNull(appId);
		// String url =
		// "http://10.132.97.12:8085/mc-t0-service-website/hessian/withdrawServiceHessian";
		// String url =
		// "http://127.0.0.1:8080/mc-t0-service-website/hessian/withdrawServiceHessian";
		HessianProxyFactory factory = new HessianProxyFactory();
		factory.setOverloadEnabled(true);
		WithdrawT0ServiceAPI service;
		try {
			service = getWithdrawT0ServiceAPI();
			WithdrawCheckRequest request = new WithdrawCheckRequest();
			request.setMerchantNo(merchantNo);
			if (StringUtils.isBlank(originalAmount)) {
				request.setOriginalAmount(null);
			} else {
				request.setOriginalAmount(new BigDecimal(originalAmount));
			}

			request.setMcType(mcType);
			WithdrawCheckResponse response = service.checkWithdraw(request);

			return result2Json(response);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			logger.error("WithdrawServiceFacadeImpl.checkPosWithdraw.error" + e.getMessage(), e);
			return result2Json("" + e.getMessage());
		}

	}

	@Override
	public String applyMPosWithdraw(String merchantNo, String appId, String withdrawAmount, String withdrawType, String mcType, String orderNo) {
		// Assert.notNull(merchantNo);
		// // Assert.notNull(withdrawAmount);
		// Assert.notNull(withdrawType);
		// Assert.notNull(appId);
		// String url =
		// "http://10.132.97.12:8085/mc-t0-service-website/hessian/withdrawServiceHessian";
		// String url =
		// "http://127.0.0.1:8080/mc-t0-service-website/hessian/withdrawServiceHessian";
		HessianProxyFactory factory = new HessianProxyFactory();
		factory.setOverloadEnabled(true);
		WithdrawT0ServiceAPI service;
		try {
			service = getWithdrawT0ServiceAPI();
			WithdrawT0ServiceRequest request = new WithdrawT0ServiceRequest();
			request.setAppId(appId);
			request.setApplyTime(new Date());
			request.setMerchantNo(merchantNo);
			request.setMcType(mcType);
			request.setWithdrawAmount(withdrawAmount == null ? new BigDecimal(0) : new BigDecimal(withdrawAmount));
			request.setWithdrawType(withdrawType);
			if (StringUtils.isEmpty(orderNo)) {
				request.setOrderNo(BaseCommonService.generatorSeq());
			} else {
				request.setOrderNo(orderNo);
			}
			request.setCallbackAddress(WithdrawConstant.WITHDRAW_CALLBACK_ADDRESS);
			request.setSignature(request.getSignStr(WithdrawConstant.MD5key));
			WithdrawT0ServiceResponse response = service.t0WithdrawBalance(request);
			return result2Json(response);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			logger.error("WithdrawServiceFacadeImpl.applyMPosWithdraw.error" + e.getMessage(), e);
			return result2Json("" + e.getMessage());
		}

	}

	@Override
	public String productWithdraw(String merchantNo, String mcType) {
		WithdrawProductRequest request = new WithdrawProductRequest();
		request.setMerchantNo(merchantNo);
		request.setMcType(mcType);
		WithdrawProductResponse response;
		try {
			response = getWithdrawT0ServiceAPI().withdrawProduct(request);
			return result2Json(response);
		} catch (Exception e) {
			return "";
		}
	}

	@Override
	public String queryWithdrawList(String merchantNo, String traceNo, String orderNo, String startTime, String endTime, String withdrawType,
			String pageSize, String pageNo) {
		WithdrawQueryRequest request = new WithdrawQueryRequest();
		request.setMerchantNo(merchantNo);
		request.setTraceNo(traceNo);
		request.setOrderNo(orderNo);

		request.setOrderNo(orderNo);
		request.setWithdrawType(withdrawType);
		if (!StringUtil.isEmpty(startTime)) {
			Date date = DateUtil.str2Date(startTime);
			request.setStartTime(date);
		}
		if (!StringUtil.isEmpty(endTime)) {
			Date date = DateUtil.str2Date(endTime);
			request.setEndTime(date);
		}

		WithdrawQueryResponse response;
		try {
			if (StringUtils.isNotBlank(pageNo)) {
				request.setPageNo(Integer.parseInt(pageNo));
			}
			if (StringUtils.isNotBlank(pageSize)) {
				request.setPageSize(Integer.parseInt(pageSize));
			}
			request.setSignature(request.getSignStr(WithdrawConstant.MD5key));
			response = getWithdrawT0ServiceAPI().queryT0Withdraw(request);
			return result2Json(response);
		} catch (Exception e) {
			return "";
		}
	}

	@Override
	public BigDecimal findCanUseQuota(String merchantNo, String mcType) {
		// TODO Auto-generated method stub
		return getWithdrawT0ServiceAPI().findCanUseQuota(merchantNo, mcType);
	}

	@Override
	public BigDecimal findTotalAmount(String merchantNo, String mcType) {
		// TODO Auto-generated method stub
		return getWithdrawT0ServiceAPI().findTotalAmount(merchantNo, mcType);
	}

	@Override
	public String queryPromoterInfo(String merchantNo, String mcType) {
		HessianProxyFactory factory = new HessianProxyFactory();
		factory.setOverloadEnabled(true);
		try {
			QueryPromoterRequest request = new QueryPromoterRequest();
			request.setMerchantNo(merchantNo);
			request.setMerchantType(mcType);

			QueryPromoterResponse response = getSynMerchantInfoServiceAPI().queryPromoterInfo(request);
			return result2Json(response);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			logger.error("WithdrawServiceFacadeImpl.queryPromoterInfo.error" + e.getMessage(), e);
			return result2Json("" + e.getMessage());
		}
	}

	@Override
	public String queryMerchantInfo(String merchantNo, String mcType) {
		HessianProxyFactory factory = new HessianProxyFactory();
		factory.setOverloadEnabled(true);
		try {
			QueryMerchantRequest request = new QueryMerchantRequest();
			request.setMerchantNo(merchantNo);
			request.setMerchantType(mcType);

			QueryMerchantResponse response = getSynMerchantInfoServiceAPI().queryMerchantInfo(request);
			return result2Json(response);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			logger.error("WithdrawServiceFacadeImpl.queryMerchantInfo.error" + e.getMessage(), e);
			return result2Json("" + e.getMessage());
		}
	}

	@Override
	public String syncMerchantInfo(String merchantNo, String mcType, String mcId, String merchantName, String status, String promoterId, String mcc,
			String lastLevelPromoterNo, String lastLevelPromoterType) {
		HessianProxyFactory factory = new HessianProxyFactory();
		factory.setOverloadEnabled(true);
		try {
			SynMerchantRequest request = new SynMerchantRequest();
			request.setMerchantNo(merchantNo);
			request.setMerchantType(mcType);
			if (mcId != null) {
				request.setMcId(Long.valueOf(mcId));
			}
			request.setStatus(status);
			request.setMerchantName(merchantName);
			request.setPromoterId(Long.valueOf(promoterId));
			request.setMcc(mcc);
			request.setLastLevelPromoterNo(lastLevelPromoterNo);
			request.setLastLevelPromoterType(lastLevelPromoterType);
			SynResponse response = getSynMerchantInfoServiceAPI().createOrUpdateMerchant(request);
			return result2Json(response);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			logger.error("WithdrawServiceFacadeImpl.syncMerchantInfo.error" + e.getMessage(), e);
			return result2Json("" + e.getMessage());
		}
	}

	@Override
	public String syncPromoterInfo(String merchantNo, String mcType, String mcId, String merchantName, String status, String pmtLevel,
			String parentMerchantNo, String parentMerchantType) {
		HessianProxyFactory factory = new HessianProxyFactory();
		factory.setOverloadEnabled(true);
		try {
			SynPromoterRequest request = new SynPromoterRequest();
			request.setMerchantNo(merchantNo);
			request.setMerchantType(mcType);
			request.setMcId(Long.valueOf(mcId));
			request.setStatus(status);
			request.setMerchantName(merchantName);
			request.setLevel(pmtLevel);
			request.setParentMerchantNo(parentMerchantNo);
			request.setParentMerchantType(parentMerchantType);
			SynResponse response = getSynMerchantInfoServiceAPI().createOrUpdatePromoter(request);
			return result2Json(response);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			logger.error("WithdrawServiceFacadeImpl.syncPromoterInfo.error" + e.getMessage(), e);
			return result2Json("" + e.getMessage());
		}
	}

	@Override
	public String syncMerchantInfoAll() throws InterruptedException {
		if (Constants.handleMap.size() > 0) { return "当前有任务执行！"; }
		List<PromoterEO> list = promoterService.queryPromoterAll();
		StringBuffer buffer = new StringBuffer();
		long time = System.currentTimeMillis();
		if (list != null && !list.isEmpty()) {
			buffer.append("Promoter size:" + list.size());
			logger.info("Promoter size:" + list.size());
			int mSize = 0;
			BigDecimal wT1 = new BigDecimal(ConfigOptionHelper.getConfigByKey(MerchantCreditConstant.MPOS_T1_WORKDAY_WITHDRAW_RATIO));
			BigDecimal hT1 = new BigDecimal(ConfigOptionHelper.getConfigByKey(MerchantCreditConstant.MPOS_T1_HOLDAY_WITHDRAW_RATIO));
			BigDecimal wD1 = new BigDecimal(ConfigOptionHelper.getConfigByKey(MerchantCreditConstant.MPOS_D1_WORKDAY_WITHDRAW_RATIO));
			BigDecimal hD1 = new BigDecimal(ConfigOptionHelper.getConfigByKey(MerchantCreditConstant.MPOS_D1_HOLDAY_WITHDRAW_RATIO));
			String configDateStr = ConfigOptionHelper.getConfigByKey(MerchantCreditConstant.T0_COST_DATE);
			Date effectiveTime = DateUtil.str2Date(configDateStr);
			for (PromoterEO promoter : list) {
				Constants.handleMap.put(promoter.getPromoterId(), new Date());
				syncMerchantHandler.execute(promoter, wT1, hT1, wD1, hD1, effectiveTime);

			}
			// buffer.append("\n merchants size:"+mSize);
		}
		boolean flag = true;
		while (flag) {
			if (Constants.handleMap.size() < 1) {
				break;
			}
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				logger.error("syncMerchantInfoAll InterruptedException :" ,e);
				throw e;
			}
		}
		buffer.append("\n 用时:" + (System.currentTimeMillis() - time) / 1000);
		logger.info("syncMerchantInfoAll end :" + buffer.toString());
		return buffer.toString();
	}

	@Override
	public String syncEasypayMerchantInfo(String merchantNo, String mcType, String merchantName, String status, String certType, String certNo,
			String promoterType, String promoterNo,String mcc) {
		try {
			MerchantInfoRequest request = new MerchantInfoRequest();
			request.setMerchantNo(merchantNo);
			request.setMerchantType(mcType);
			request.setStatus(status);
			request.setMerchantName(merchantName);
			request.setCertType(certType);
			request.setCertNo(certNo);
			request.setPromoterType(promoterType);
			request.setPromoterNo(promoterNo);
			request.setMcc(mcc);
			SynResponse response = getSynMerchantInfoServiceAPI().synchMerchantInfo(request);
			return result2Json(response);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			logger.error("WithdrawServiceFacadeImpl.syncEasypayMerchantInfo.error" + e.getMessage(), e);
			return result2Json("" + e.getMessage());
		}
	}

	@Override
	public String applyEasypayWithdraw(String merchantNo, String appId, String withdrawAmount, String withdrawType, String mcType, String orderNo,
			BankCardInfo bankCardInfo) {
		HessianProxyFactory factory = new HessianProxyFactory();
		factory.setOverloadEnabled(true);
		WithdrawT0ServiceAPI service;
		try {
			service = getWithdrawT0ServiceAPI();
			WithdrawT0ServiceRequest request = new WithdrawT0ServiceRequest();
			request.setAppId(appId);
			request.setApplyTime(new Date());
			request.setMerchantNo(merchantNo);
			request.setMcType(mcType);
			request.setWithdrawAmount(withdrawAmount == null ? new BigDecimal(0) : new BigDecimal(withdrawAmount));
			request.setWithdrawType(withdrawType);
			if (StringUtils.isEmpty(orderNo)) {
				request.setOrderNo(BaseCommonService.generatorSeq());
			} else {
				request.setOrderNo(orderNo);
			}
			Map<String,Object> extention=new HashMap<String, Object>();
			extention.put("bankCardInfo", bankCardInfo);
			request.setExtention(extention);
			request.setCallbackAddress(WithdrawConstant.WITHDRAW_CALLBACK_ADDRESS);
			request.setSignature(request.getSignStr(WithdrawConstant.MD5key));
			WithdrawT0ServiceResponse response = service.t0WithdrawBalance(request);
			return result2Json(response);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			logger.error("WithdrawServiceFacadeImpl.applyEasypayWithdraw.error" + e.getMessage(), e);
			return result2Json("" + e.getMessage());
		}
	}

	@Override
	public String modifyMerchantMcc(String merchantNo, String mcType, String mcc) {
		HessianProxyFactory factory = new HessianProxyFactory();
		factory.setOverloadEnabled(true);
		try {
			SynMerchantRequest request = new SynMerchantRequest();
			request.setMerchantNo(merchantNo);
			request.setMerchantType(mcType);
			Map<String,Map<String,String>> extendInfo=new HashMap<String, Map<String,String>>();
			Map<String,String> extendMap=new HashMap<String, String>();
			extendMap.put("attrName", "mcc");
			extendMap.put("attrValue", mcc);
			extendMap.put("effectiveTime", DateUtil.formatDate(new Date(), "yyyy-MM-dd HH:mm:ss"));
			extendInfo.put("updateMerchantAttr", extendMap);
			request.setExtendInfo(extendInfo);
			SynResponse response = getSynMerchantInfoServiceAPI().createOrUpdateMerchant(request);
			return result2Json(response);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			logger.error("WithdrawServiceFacadeImpl.modifyMerchantMcc.error" + e.getMessage(), e);
			return result2Json("" + e.getMessage());
		}
	}

}
