package com.shengpay.service.withdraw.impl;

import java.math.BigDecimal;
import java.util.Date;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.context.ContextLoader;
import org.springframework.web.context.WebApplicationContext;

import com.sdp.mc.common.hessian.RemotingCallUtil;
import com.sdp.mc.common.hessian.RemotingModuleEnum;
import com.sdp.withdraw.api.WithdrawT0ServiceAPI;
import com.sdp.withdraw.api.ratio.MerchantWithdrawRatioAPI;
import com.sdp.withdraw.enums.PosMerchantTypeEnums;
import com.sdp.withdraw.enums.WithdrawRatioStatusEnums;
import com.sdp.withdraw.enums.WithdrawRatioTypeEnums;
import com.sdp.withdraw.vo.ratio.WithdrawRatioQueryRequest;
import com.sdp.withdraw.vo.ratio.WithdrawRatioQueryResponse;
import com.sdp.withdraw.vo.ratio.WithdrawRatioRequest;
import com.sdp.withdraw.vo.ratio.WithdrawRatioResponse;
import com.shengpay.service.withdraw.T0WithdrawService;

@Service
public class T0WithdrawServiceImpl implements T0WithdrawService {
	
	private static Logger logger = LoggerFactory.getLogger(T0WithdrawServiceImpl.class);

	private MerchantWithdrawRatioAPI withdrawRatioServie;

	@Override
	public MerchantWithdrawRatioAPI getWithdrawRatioService() {
		try {//先从容器中获取对象
			if (withdrawRatioServie == null){
				WebApplicationContext wac = ContextLoader.getCurrentWebApplicationContext();
				withdrawRatioServie=(MerchantWithdrawRatioAPI) wac.getBean("withdrawRatioService4Hessian");
			}
		} catch (Exception e) {
		}
		//容器中没有，调用接口获取
		if (withdrawRatioServie == null) {
			withdrawRatioServie = RemotingCallUtil.getHessianServiceByModuleWithoutCanonicalName(RemotingModuleEnum.WITHDRAW_RATIO_SERVICE_URL,
					MerchantWithdrawRatioAPI.class);
		}
		return withdrawRatioServie;
	}
	private WithdrawT0ServiceAPI withdrawT0ServiceAPI;

	public WithdrawT0ServiceAPI getWithdrawT0ServiceAPI() {
		try {//先从容器中获取对象
			if (withdrawT0ServiceAPI == null){
				WebApplicationContext wac = ContextLoader.getCurrentWebApplicationContext();
				withdrawT0ServiceAPI=(WithdrawT0ServiceAPI) wac.getBean("withdrawServiceHessian");
			}
		} catch (Exception e) {
		}
		if (withdrawT0ServiceAPI == null) {
			withdrawT0ServiceAPI = RemotingCallUtil
					.getHessianServiceByModuleWithoutCanonicalName(
							RemotingModuleEnum.T0_WITHDRAW_SERVICE_URL,
							WithdrawT0ServiceAPI.class);
		}
		return withdrawT0ServiceAPI;
	}

	@Override
	public WithdrawRatioResponse merchantT0Ratio(String merchantNo, String merchantType, Integer withDrawRatioType, BigDecimal workDayWithDrawRatio,
			BigDecimal holidayWithDrawRatio,int ratioStatus) {
		WithdrawRatioRequest request = new WithdrawRatioRequest(merchantNo, merchantType, withDrawRatioType, workDayWithDrawRatio,
				holidayWithDrawRatio);
		request.setWithDrawRatioStatus(ratioStatus);
		logger.info("T0WithdrawServiceImpl #merchantT0Ratio request:"+ToStringBuilder.reflectionToString(request));
		return getWithdrawRatioService().createAndUpdateWithrawRatio(request);
	}

	@Override
	public WithdrawRatioQueryResponse queryMerchantT0Ratio(String merchantNo, String merchantType, Integer withdrawRatioType) {
		WithdrawRatioQueryRequest request = new WithdrawRatioQueryRequest(merchantNo, merchantType, withdrawRatioType);
		logger.info("T0WithdrawServiceImpl #queryMerchantT0Ratio request:"+ToStringBuilder.reflectionToString(request));
		return getWithdrawRatioService().queryWithrawRatioResult(request);
	}
	@Override
	public WithdrawRatioQueryResponse queryMerchantT0Ratio(String merchantNo, String merchantType, Integer withdrawRatioType,Date effectiveTime) {
		WithdrawRatioQueryRequest request = new WithdrawRatioQueryRequest(merchantNo, merchantType, withdrawRatioType,effectiveTime);
		logger.info("T0WithdrawServiceImpl #queryMerchantT0Ratio request:"+ToStringBuilder.reflectionToString(request));
		return getWithdrawRatioService().queryWithrawRatioResult(request);
	}

	@Override
	public WithdrawRatioResponse merchantT0Ratio(String merchantNo, String merchantType, BigDecimal workDayWithDrawRatio,
			BigDecimal holidayWithDrawRatio) {
		WithdrawRatioRequest request = new WithdrawRatioRequest(merchantNo, merchantType, PosMerchantTypeEnums.MPOS_MERCHANT.code.equals(merchantType)?WithdrawRatioTypeEnums.MPOS_T0_SETTLE_RATIO.code:WithdrawRatioTypeEnums.POS_T0_SETTLE_RATIO.code,
				workDayWithDrawRatio, holidayWithDrawRatio);
		request.setWithDrawRatioStatus(WithdrawRatioStatusEnums.active.code);
		logger.info("T0WithdrawServiceImpl #merchantT0Ratio request:"+ToStringBuilder.reflectionToString(request));
		return getWithdrawRatioService().createOrUpdateWithrawRatio(request);
	}

	@Override
	public WithdrawRatioQueryResponse queryMerchantT0Ratio(String merchantNo, String merchantType) {
		WithdrawRatioQueryRequest request = new WithdrawRatioQueryRequest(merchantNo, merchantType, WithdrawRatioTypeEnums.POS_T0_SETTLE_RATIO.code);
		logger.info("T0WithdrawServiceImpl #queryMerchantT0Ratio request:"+ToStringBuilder.reflectionToString(request));
		return getWithdrawRatioService().queryWithrawRatioResult(request);
	}
	
	public WithdrawRatioQueryResponse getMerchantCurrentAvaliableWithdrawRatio(String merchantNo, String merchantType, Integer withdrawRatioType){
		WithdrawRatioQueryRequest request = new WithdrawRatioQueryRequest(merchantNo, merchantType, withdrawRatioType);
		logger.info("T0WithdrawServiceImpl #getMerchantCurrentAvaliableWithdrawRatio request:"+ToStringBuilder.reflectionToString(request));
		return getWithdrawRatioService().getMerchantCurrentAvaliableWithdrawRatio(request);
	}


}
