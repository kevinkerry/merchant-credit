package com.sdp.debit.batch.util;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sdp.debit.task.job.execute.service.AgnetGuaranteeJobService;
import com.sdp.debit.task.job.execute.service.ExecuteBaseService;
import com.sdp.debit.task.job.execute.service.OverDueCalJobService;
import com.sdp.debit.task.job.execute.service.RepaymentJobService;
import com.sdp.debit.task.job.execute.service.SyncMerchantRiskLevelJobService;

@Service
public class ExecuteServiceMapSetting {

	private static Map<String, ExecuteBaseService> executeMap = new HashMap<String, ExecuteBaseService>();

	@Autowired
	private RepaymentJobService repaymentJobService;

	@Autowired
	private OverDueCalJobService overDueCalJobService;

	@Autowired
	private SyncMerchantRiskLevelJobService syncMerchantRiskLevelJobService;

	@Autowired
	private  AgnetGuaranteeJobService agnetGuaranteeJobService;


	public static synchronized ExecuteBaseService getExecuteMap(String key) {
		return executeMap.get(key);
	}

	@PostConstruct
	public synchronized void init() {
		executeMap.put("autoRepayment", repaymentJobService);
		executeMap.put("overDueCalJobService", overDueCalJobService);
		executeMap.put("syncMerchantRiskLevel", syncMerchantRiskLevelJobService);
		//代理商超过2天未处理的额度申请请求自动以不承诺状态提交风控
		executeMap.put("agentOperateTimeOut", agnetGuaranteeJobService);



	}


}
