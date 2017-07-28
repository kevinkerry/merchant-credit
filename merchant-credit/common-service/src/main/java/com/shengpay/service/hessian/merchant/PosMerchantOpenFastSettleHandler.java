package com.shengpay.service.hessian.merchant;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sdp.mc.common.enums.CommonStatusEnums;
import com.sdp.mc.common.exception.OpenFastSettleException;
import com.sdp.mc.dao.readonly.merchant.CmPosMerchantDAO;
import com.sdp.withdraw.dao.PolicyConfigInfoDO;
import com.sdp.withdraw.dao.PosMerchantInfoDO;
import com.sdp.withdraw.enums.PosMerchantTypeEnums;
import com.shengpay.logback.mdc.trace.wrapper.InheritTraceNoRunableWrapper;
import com.shengpay.service.withdraw.FwPosMerchantInfoService;
import com.shengpay.service.withdraw.PolicyConfigInfoService;

/**
 * pos商户开通快速结算
 *
 * @author liyantao01
 *
 */
@Service("posMerchantOpenFastSettleHandler")
public class PosMerchantOpenFastSettleHandler {

	protected final ExecutorService pool = Executors.newFixedThreadPool(5);

	@Autowired
	private PolicyConfigInfoService policyConfigInfoService;
	@Autowired
	private FwPosMerchantInfoService fwPosMerchantInfoService;
	@Autowired
	private CmPosMerchantDAO cmPosMerchantDAO;
	
	private Logger logger = LoggerFactory.getLogger(PosMerchantOpenFastSettleHandler.class);

	public void execute(Long posMerchantId, String policyId) {
		logger.info("posMerchantOpenFastSettleHandler #execute.");
		PosMerchantOpenFastSettleTask transferIngTask = new PosMerchantOpenFastSettleTask(posMerchantId, policyId);
		pool.execute(new InheritTraceNoRunableWrapper(transferIngTask));
	}

	class PosMerchantOpenFastSettleTask implements Runnable {

		private Logger logger = LoggerFactory.getLogger(PosMerchantOpenFastSettleTask.class);

		private Long posMerchantId;
		private String policyId;

		public PosMerchantOpenFastSettleTask(Long posMerchantId, String policyId) {
			super();
			this.posMerchantId = posMerchantId;
			this.policyId = policyId;
		}

		public void run() {
			try {
				logger.info("PosMerchantOpenFastSettleTask #run,Callback reqId：" + posMerchantId + ",policyId:" + policyId);
				if (posMerchantId == null) {
					logger.info("#run,posMerchantId is null");
					return;
				}
				PosMerchantInfoDO merchentInfo = fwPosMerchantInfoService.getPosMerchantInfoByPosMerchantId(posMerchantId);
				if (merchentInfo == null) {
					logger.info("#run,merchentInfo is null");
					return;
				}
				if (!PosMerchantTypeEnums.POS_MERCHANT.code.equals(merchentInfo.getMerchantType())) {
					logger.info("#run,MerchantType is not POS");
					return;
				}
				if (StringUtils.isBlank(policyId)) {
					policyId = cmPosMerchantDAO.queryPosMerchantPolicyIdByMcId(posMerchantId);
					if (StringUtils.isBlank(policyId)) {
						logger.info("#run,policyId is null,posMerchantId:" + posMerchantId);
						return;
					}
				}
				PolicyConfigInfoDO policyInfo = policyConfigInfoService.queryPolicyConfigInfo(policyId);
				logger.info("#run,queryPolicyConfigInfo:{}", ToStringBuilder.reflectionToString(policyInfo));
				if (policyInfo == null || !CommonStatusEnums.TAKE_EFFECT.code.equals(policyInfo.getStatus())) {
					logger.info("#run,not can use policyConfigInfo.");
					return;
				}
				try {
					fwPosMerchantInfoService.posAutoOpenFastSettleAndUpdateLimit(merchentInfo.getMerchantNo(), merchentInfo.getMerchantType(),
							policyInfo.getWorkdayRatio().toString(), policyInfo.getHolidayRatio().toString(), policyInfo.getFastSettleLimit(),
							policyInfo.getFastSettleFlag().toString(), policyInfo.getAutoFastSettleFlag().toString());
				} catch (OpenFastSettleException e) {
					logger.error("posAutoOpenFastSettleAndUpdateLimit OpenFastSettleException", e);
				}
			} catch (Exception e) {
				logger.error("posAutoOpenFastSettleAndUpdateLimit Exception", e);
			}
			
		}

	}

	
}
