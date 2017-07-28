package com.shengpay.service.hessian.merchant;

import java.util.Map;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mc.service.api.bean.BaseCustomizedTimedTask;
import com.mc.service.api.exception.TimedTaskException;
import com.sdp.mc.common.enums.CommonStatusEnums;
import com.sdp.mc.common.exception.OpenFastSettleException;
import com.sdp.withdraw.dao.PolicyConfigInfoDO;
import com.sdp.withdraw.dao.PosMerchantInfoDO;
import com.sdp.withdraw.enums.PosMerchantTypeEnums;
import com.shengpay.service.withdraw.FwPosMerchantInfoService;
import com.shengpay.service.withdraw.PolicyConfigInfoService;

@Service("posPolicyUpdateTask")
public class PosPolicyUpdateTask extends BaseCustomizedTimedTask {
	private Logger logger = LoggerFactory.getLogger(PosPolicyUpdateTask.class);

	@Autowired
	private FwPosMerchantInfoService fwPosMerchantInfoService;
	@Autowired
	private PolicyConfigInfoService policyConfigInfoService;

	@Override
	@Transactional
	public void execute(Map<String, String> param) {
		logger.info("execute init:param:{}", param);
		String merchantNo = param.get("merchantNo");
		String merchantType = param.get("merchantType");
		String newValue = param.get("newValue");
		try {
			if (!PosMerchantTypeEnums.POS_MERCHANT.code.equals(merchantType)) {
				throw new TimedTaskException("-1", "错误的商户类型");
			}
			
			PosMerchantInfoDO merchentInfo = fwPosMerchantInfoService.getPosMerchantInfoByMerchantInfo(merchantNo, merchantType);
			if (merchentInfo == null) {
				throw new TimedTaskException("-1", "商户信息不存在");
			}
			
			PolicyConfigInfoDO policyInfo = policyConfigInfoService.queryPolicyConfigInfo(newValue);
			logger.info("#run,queryPolicyConfigInfo:{}", ToStringBuilder.reflectionToString(policyInfo));
			if (policyInfo == null || !CommonStatusEnums.TAKE_EFFECT.code.equals(policyInfo.getStatus())) {
				throw new TimedTaskException("-1", "无对应的政策信息");
			}
			try {
				fwPosMerchantInfoService.posAutoOpenFastSettleAndUpdateLimit(merchentInfo.getMerchantNo(), merchentInfo.getMerchantType(),
						policyInfo.getWorkdayRatio().toString(), policyInfo.getHolidayRatio().toString(), policyInfo.getFastSettleLimit(),
						policyInfo.getFastSettleFlag().toString(), policyInfo.getAutoFastSettleFlag().toString());
			} catch (OpenFastSettleException e) {
				throw new TimedTaskException("-1", e.getMessage());
			}
		} catch (Exception e) {
			throw new TimedTaskException("-1", "修改发生异常："+e.getMessage());
		}
	}

}
