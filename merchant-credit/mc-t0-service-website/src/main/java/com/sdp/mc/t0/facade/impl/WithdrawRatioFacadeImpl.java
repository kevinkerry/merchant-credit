package com.sdp.mc.t0.facade.impl;

import java.math.BigDecimal;

import net.sf.json.JSONObject;

import org.slf4j.Logger;import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import com.caucho.hessian.client.HessianProxyFactory;
import com.sdp.mc.common.hessian.RemotingCallUtil;
import com.sdp.mc.common.hessian.RemotingModuleEnum;
import com.sdp.mc.common.util.DateUtil;
import com.sdp.mc.t0.facade.WithdrawRatioFacade;
import com.sdp.withdraw.api.WithdrawT0ServiceAPI;
import com.sdp.withdraw.api.ratio.MerchantWithdrawRatioAPI;
import com.sdp.withdraw.vo.ratio.WithdrawRatioQueryRequest;
import com.sdp.withdraw.vo.ratio.WithdrawRatioQueryResponse;
import com.sdp.withdraw.vo.ratio.WithdrawRatioRequest;
import com.sdp.withdraw.vo.ratio.WithdrawRatioResponse;
import com.snda.toolkit.common.util.StringUtil;

@Service
public class WithdrawRatioFacadeImpl implements WithdrawRatioFacade {

	private Logger logger = LoggerFactory.getLogger(WithdrawRatioFacadeImpl.class);

//	@Autowired
	private MerchantWithdrawRatioAPI merchantWithdrawRatioAPI;

	private MerchantWithdrawRatioAPI getMerchantWithdrawRatioAPI() {
		if (merchantWithdrawRatioAPI == null) {
			merchantWithdrawRatioAPI = RemotingCallUtil
					.getHessianServiceByModuleWithoutCanonicalName(
							RemotingModuleEnum.WITHDRAW_RATIO_SERVICE_URL,
							MerchantWithdrawRatioAPI.class);
		}
		return merchantWithdrawRatioAPI;
	}

	protected String result2Json(Object result) {
		String resultJson = JSONObject.fromObject(result).toString();
		logger.info("T0ServiceFacadeImpl #result2Json:" + resultJson);
		return resultJson;
	}

	@Override
	public String createOrUpdateWithrawRatio(String merchantNo, String merchantType, String effectiveTime, String expireTime,
			String holidayWithDrawRatio, String withDrawRatioStatus, String withDrawRatioType, String workDayWithDrawRatio,String ratioId) {
		Assert.notNull(merchantNo);
//		 String url =
//		 "http://10.132.97.12:8085/mc-t0-service-website/hessian/withdrawServiceHessian";
		//String url =
		//"http://127.0.0.1:8080/mc-t0-service-website/hessian/withdrawServiceHessian";
		HessianProxyFactory factory = new HessianProxyFactory();
		factory.setOverloadEnabled(true);
		try {
			WithdrawRatioRequest request = new WithdrawRatioRequest();
			request.setMerchantNo(merchantNo);
			request.setMerchantType(merchantType);
			if (!StringUtil.isEmpty(ratioId)) {
				request.setRatioId(Integer.parseInt(ratioId));
			}
			if (!StringUtil.isEmpty(effectiveTime)) {
				request.setEffectiveTime(DateUtil.str2Date(effectiveTime));
			}
			if (!StringUtil.isEmpty(expireTime)) {
				request.setExpireTime(DateUtil.str2Date(expireTime));
			}
			request.setHolidayWithDrawRatio(new BigDecimal(holidayWithDrawRatio));
			request.setWithDrawRatioStatus(Integer.parseInt(withDrawRatioStatus));
			request.setWithDrawRatioType(Integer.parseInt(withDrawRatioType));
			if (!StringUtil.isEmpty(workDayWithDrawRatio)) {
				request.setWorkDayWithDrawRatio(new BigDecimal(workDayWithDrawRatio));
			}

			WithdrawRatioResponse response = getMerchantWithdrawRatioAPI().createOrUpdateWithrawRatio(request);
			return result2Json(response);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			logger.error("WithdrawRatioFacadeImpl.createOrUpdateWithrawRatio.error" + e.getMessage(), e);
			return result2Json("" + e.getMessage());
		}

	}

	@Override
	public String queryWithdrawRatio(String merchantNo, String merchantType) {
		Assert.notNull(merchantNo);
		WithdrawRatioQueryRequest request = new WithdrawRatioQueryRequest();
		request.setMerchantNo(merchantNo);
		request.setMerchantType(merchantType);
		WithdrawRatioQueryResponse response;
		try {
			response = getMerchantWithdrawRatioAPI().queryWithrawRatioResult(request);
			return result2Json(response);
		} catch (Exception e) {
			logger.error("WithdrawRatioFacadeImpl.queryWithdrawRatio.error" + e.getMessage(), e);
			return result2Json("" + e.getMessage());
		}

	}
	@Override
	public String createOrUpdateT1andD1Ratio(String merchantNo, String merchantType) {
		Assert.notNull(merchantNo);
		HessianProxyFactory factory = new HessianProxyFactory();
		factory.setOverloadEnabled(true);
		try {

			WithdrawRatioResponse response = getMerchantWithdrawRatioAPI().createT1andD1Ratio(merchantNo,merchantType);
			return result2Json(response);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			logger.error("WithdrawRatioFacadeImpl.createOrUpdateT1andD1Ratio.error" + e.getMessage(), e);
			return result2Json("" + e.getMessage());
		}

	}
}
