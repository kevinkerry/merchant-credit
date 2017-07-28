package com.sdp.debit.task.common.service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sdp.debit.batch.util.TaskExpressionTimeUtil;
import com.sdp.debit.task.model.TaskResult;
import com.sdp.mc.common.util.DateUtil;
import com.shengpay.debit.common.enums.ConfigEnums;
import com.shengpay.debit.common.service.CreditLinesApplyService;
import com.shengpay.debit.common.service.DebitConfigService;
import com.shengpay.debit.common.service.MerchantCreditLinesApplyService;
import com.shengpay.debit.credit.lines.apply.enums.CreditLinesApplyStatusEnums;
import com.shengpay.debit.dal.dataobject.DbThreadConfigPO;
import com.shengpay.debit.dal.dataobject.DoMerchantCreditLinesApplyPO;

/**
 * 如果商户提交额度申请数据代理商超过两天没有操作，统一按照不承诺处理，推送到风控job
**/
@Service
public class AgentGuaranteeService{
	private static final Logger log = LoggerFactory.getLogger(AgentGuaranteeService.class);
	@Autowired
	private CreditLinesApplyService creditLinesApplyService;
	@Autowired
	private DebitConfigService debitConfigService;
	private String getValue(ConfigEnums enums) {
		return debitConfigService.getByKey(enums);
	}
	protected String getSerilizeCode(DbThreadConfigPO po) {
		String expression = po.getExecuteExpression();
        Date date = TaskExpressionTimeUtil.nextDate(expression, new Date());
        return new SimpleDateFormat("yyyyMMddHH").format(date);
	}

	public void run() {
		log.info("AgnetGuaranteeService.job.starting");
		TaskResult taskResult = new TaskResult();
		try {
			//通过配置获取超时天数
			int overDays=Integer.valueOf(getValue(ConfigEnums.OVER_DAYS));
			//商户申请时间=传入时间=当前时间-超时天数
			Date date=DateUtil.increaseDate(new Date(), -overDays);
			//查询所有符合条件的数据  状态为1 是否需要代理商承诺1    数据状态由1变为2   是否承诺0
			Map <String, Object> mps=new HashMap<String, Object>();
			mps.put("applyStatus", "1");
			mps.put("isNeedAgnetGuarantee", "1");
			mps.put("applyStartTime", DateUtil.date2DateStr(date));
			creditLinesApplyService.updateMerchantCreditLineStatusJob(mps);
			taskResult.setStatus(1);
			taskResult.setResult(true);
		} catch (Exception e) {
			log.error("AgnetGuaranteeJobService.error", e);
			taskResult.setStatus(2);
			taskResult.setResult(false);
		}
		log.info("AgnetGuaranteeJobService.job.finished");
	}

}
