package com.sdp.mc.t0.facade.impl;

import java.net.MalformedURLException;

import net.sf.json.JSONObject;

import org.slf4j.Logger;import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import com.caucho.hessian.client.HessianProxyFactory;
import com.sdp.mc.common.hessian.RemotingCallUtil;
import com.sdp.mc.common.hessian.RemotingModuleEnum;
import com.sdp.mc.msp.api.MposHessianApi;
import com.sdp.mc.msp.api.vo.ApplyResult;
import com.sdp.mc.msp.api.vo.MCFastSettleCfg;
import com.sdp.mc.msp.api.vo.MposFastSettleInfo;
import com.sdp.mc.msp.api.vo.ValidOrderResult;
import com.sdp.mc.t0.facade.T0ServiceFacade;

@Service
public class T0ServiceFacadeImpl implements T0ServiceFacade {

	private Logger logger = LoggerFactory.getLogger(T0ServiceFacadeImpl.class);

	private MposHessianApi hessianImpl;

	private MposHessianApi getHessianImpl() {
		if (hessianImpl == null) {
			hessianImpl = RemotingCallUtil.getHessianServiceByModuleWithoutCanonicalName(RemotingModuleEnum.NEWT0_MPOS_FAST_SETTLE,
					MposHessianApi.class);
		}
		return hessianImpl;
	}

	// @Autowired
	// private MposHessianApi t0Service4Hessian;
	protected String result2Json(Object result) {
		String resultJson = JSONObject.fromObject(result).toString();
		// logger.info("T0ServiceFacadeImpl #result2Json:" + resultJson);
		return resultJson;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.sdp.mc.t0.facade.T0ServiceFacade#applyMposFastSettle(java.lang.String
	 * , java.lang.String, java.lang.String)
	 */
	@Override
	public String applyMposFastSettle(String merchantNo, String posMerchantNo, String txnIdStr) {
		Assert.notNull(merchantNo);
		Assert.notNull(posMerchantNo);
		Assert.notNull(txnIdStr);
		String[] txnIds = txnIdStr.split(",");
		String url = "http://10.132.97.12:8085/mc-t0-service-website/hessian/mcMposHessian";
		// String url =
		// "http://127.0.0.1:8080/mc-t0-service-website/hessian/mcMposHessian";
		HessianProxyFactory factory = new HessianProxyFactory();
		factory.setOverloadEnabled(true);
		MposHessianApi service;
		try {
			service = (MposHessianApi) factory.create(MposHessianApi.class, url);
			ApplyResult applyResult = service.applyMposFastSettle(merchantNo, posMerchantNo, txnIds);
			return result2Json(applyResult);
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			logger.error("T0ServiceFacadeImpl.applyMposFastSettle.error" + e.getMessage(), e);
			return result2Json("" + e.getMessage());
		}

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.sdp.mc.t0.facade.T0ServiceFacade#getMerchantFastSettleCfg(java.lang
	 * .String, java.lang.String)
	 */
	@Override
	public String getMerchantFastSettleCfg(String merchantNo, String posMerchantNo) {
		Assert.notNull(merchantNo);
		Assert.notNull(posMerchantNo);
		// MCFastSettleCfg fastSettleCfg =
		// t0Service4Hessian.getMerchantFastSettleCfg(merchantNo,
		// posMerchantNo);
		MCFastSettleCfg fastSettleCfg = getHessianImpl().getMerchantFastSettleCfg(merchantNo, posMerchantNo);
		return result2Json(fastSettleCfg);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.sdp.mc.t0.facade.T0ServiceFacade#getMposFastSettleInfo(java.lang.
	 * String, java.lang.String)
	 */
	@Override
	public String getMposFastSettleInfo(String merchantNo, String posMerchantNo) {
		Assert.notNull(merchantNo);
		Assert.notNull(posMerchantNo);
		// MposFastSettleInfo mposFastSettleInfo =
		// t0Service4Hessian.getMposFastSettleInfo(merchantNo, posMerchantNo);
		MposFastSettleInfo mposFastSettleInfo = getHessianImpl().getMposFastSettleInfo(merchantNo, posMerchantNo);
		return result2Json(mposFastSettleInfo);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.sdp.mc.t0.facade.T0ServiceFacade#queryValidOrderList(java.lang.String
	 * , java.lang.String)
	 */
	@Override
	public String queryValidOrderList(String merchantNo, String posMerchantNo) {
		Assert.notNull(merchantNo);
		Assert.notNull(posMerchantNo);
		ValidOrderResult validOrderResult = getHessianImpl().queryValidOrderList(merchantNo, posMerchantNo);
		return result2Json(validOrderResult);
	}

}
