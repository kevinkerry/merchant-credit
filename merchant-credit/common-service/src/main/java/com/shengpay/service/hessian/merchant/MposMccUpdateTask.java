package com.shengpay.service.hessian.merchant;

import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mc.service.api.bean.BaseCustomizedTimedTask;
import com.mc.service.api.exception.TimedTaskException;
import com.sdp.mc.common.exception.OpenFastSettleException;
import com.shengpay.pos.PosExternalService;
import com.shengpay.service.withdraw.FwPosMerchantInfoService;

@Service("mposMccUpdateTask")
public class MposMccUpdateTask extends BaseCustomizedTimedTask {
	private Logger logger = LoggerFactory.getLogger(MposMccUpdateTask.class);

	@Autowired
	private PosExternalService posExternalService;
	@Autowired
	private FwPosMerchantInfoService fwPosMerchantInfoService;

	@Override
	@Transactional
	public void execute(Map<String, String> param) {
		logger.info("execute init:param:{}", param);
		String merchantNo = param.get("merchantNo");
		String merchantType = param.get("merchantType");
		String newMccValue = param.get("newValue");
		// String effectiveTime=param.get("effectiveTime");
		// 修改mcc
		int rows = fwPosMerchantInfoService.updateMerchantMcc(merchantNo, merchantType, newMccValue);
		if (rows < 1) { throw new TimedTaskException(STATUS_FAILURE, "mcc更新异常"); }
		int creditCTFCount = posExternalService.queryCreditAuthentication(merchantNo);
		if (creditCTFCount == -1) { throw new TimedTaskException(STATUS_FAILURE, "查询信用认证信息异常"); }
		try {
			this.fwPosMerchantInfoService.mposAutoOpenFastSettleAndUpdateLimit(merchantNo, merchantType, creditCTFCount);
			// 是否考虑把所有异常都认为是任务失败？
		} catch (OpenFastSettleException e) {
			logger.error("mposAutoOpenFastSettleAndUpdateLimit OpenFastSettleException:{},merchantNo:{},merchantType:{}",
					new Object[] { e.getMessage(), merchantNo, merchantType }, e);
			throw new TimedTaskException(STATUS_FAILURE, e.getMessage());
		} catch (Exception e) {
			logger.error("mposAutoOpenFastSettleAndUpdateLimit Exception:{},merchantNo:{},merchantType:{}", new Object[] { e.getMessage(),
					merchantNo, merchantType }, e);
			throw new TimedTaskException(STATUS_FAILURE, e.getMessage());
		}
	}
}
