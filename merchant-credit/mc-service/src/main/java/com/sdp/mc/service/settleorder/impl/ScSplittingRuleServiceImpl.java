package com.sdp.mc.service.settleorder.impl;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.sdp.mc.ScSettleBaseService;
import com.sdp.mc.common.settle.SettleReturnCodeEnums;
import com.sdp.mc.common.vo.ErrorMessageVO;
import com.sdp.mc.service.settle.threads.DownloadEasypayOrderDetailThread;
import com.sdp.mc.service.settle.threads.DownloadOrderCollectThread;
import com.sdp.mc.service.settle.threads.DownloadOrderDetailThread;
import com.sdp.mc.service.settleorder.ScSplittingRuleService;
import com.sdp.mc.settle.api.dto.PromoterSettleOrderDTO;
import com.sdp.mc.settle.api.po.SplittingRuleInfoPO;
import com.shengpay.commons.core.utils.NumberUtils;
import com.shengpay.logback.mdc.trace.wrapper.InheritTraceNoRunableWrapper;

@Service("scSplittingRuleService")
public class ScSplittingRuleServiceImpl implements ScSplittingRuleService {

	@Autowired
	private ScSettleBaseService scSettleBaseService;

	private Logger logger = LoggerFactory.getLogger(ScSplittingRuleServiceImpl.class);

	private static ExecutorService executorService = Executors.newFixedThreadPool(5);

	@Override
	public ErrorMessageVO<Object> buildBatchAddSplittingRule(List<String[]> ruleInfoList) {
		ErrorMessageVO<Object> message = new ErrorMessageVO<Object>(false);
		if (ruleInfoList == null) {
			message.setErrorCode(SettleReturnCodeEnums.SYSTEM_PROCESS.code);
			message.setErrorMessage(SettleReturnCodeEnums.SYSTEM_PROCESS.msg);
			return message;
		}
		try {
			Map<String, Object> params = new HashMap<String, Object>();
			params.put("batchRule", createSplittingRuleInfoPO(ruleInfoList));
			message.setParams(params);
			message.setSuccess(true);
			message.setErrorCode(SettleReturnCodeEnums.SUCESS.code);
			message.setErrorMessage(SettleReturnCodeEnums.SUCESS.msg);
			return message;
		} catch (Exception e) {
			message.setErrorCode(SettleReturnCodeEnums.SYSTEM_PROCESS.code);
			message.setErrorMessage(SettleReturnCodeEnums.SYSTEM_PROCESS.msg);
		}
		return message;
	}

	private List<SplittingRuleInfoPO> createSplittingRuleInfoPO(List<String[]> ruleInfoList) {
		List<SplittingRuleInfoPO> ruleList = new ArrayList<SplittingRuleInfoPO>();
		for (String[] arr : ruleInfoList) {
			if (arr != null && arr.length >= 12) {
				String merchantNo = arr[0];// 分润方
				if (!NumberUtils.isLong(merchantNo)) {
					continue;
				}
				String groupId = arr[1];// 分组
				String splitProfitRoleType = arr[2];// 分润角色
				String withdrawType = arr[3];// 结算类型
				String firstOpenTime = arr[4];// 首次开通时间
				String loaningDayFlag = arr[5];// 是否按照天数
				String loaningType = arr[6];// 垫资方
				BigDecimal costingRate = arr[7] == null ? BigDecimal.ZERO : new BigDecimal(arr[7]);// 成本费用
				BigDecimal splittingScale = arr[8] == null ? BigDecimal.ZERO : new BigDecimal(arr[8]);// 分润比例
				BigDecimal wdSplittingScale = arr[9] == null ? BigDecimal.ZERO : new BigDecimal(arr[9]);// 提现手续费分润比例
				String effectiveTime = arr[10];// 生效时间
				String expireTime = arr[11];// 失效时间
				if (StringUtils.isBlank(merchantNo) || StringUtils.isBlank(groupId) || StringUtils.isBlank(splitProfitRoleType)
						|| StringUtils.isBlank(withdrawType) || StringUtils.isBlank(firstOpenTime) || StringUtils.isBlank(loaningType)) {
					continue;
				}
				SplittingRuleInfoPO ruleInfo = new SplittingRuleInfoPO();
				ruleInfo.setMerchantNo(merchantNo);
				ruleInfo.setGroupId(Long.parseLong(groupId));
				ruleInfo.setSplitProfitRoleType(splitProfitRoleType);
				ruleInfo.setWithdrawType(withdrawType);
				ruleInfo.setWdSplittingScale(wdSplittingScale);
				ruleInfo.setFirstOpenTime(firstOpenTime);
				if (StringUtils.isNotBlank(loaningDayFlag)) {
					ruleInfo.setLoaningDayFlag(Long.parseLong(loaningDayFlag));
				}
				ruleInfo.setLoaningType(Long.parseLong(loaningType));
				ruleInfo.setCostingRate(costingRate);
				ruleInfo.setSplittingScale(splittingScale);
				ruleInfo.setWdSplittingScale(wdSplittingScale);
				if (effectiveTime != null) {
					ruleInfo.setEffectiveTime(effectiveTime);
				}
				if (expireTime != null) {
					ruleInfo.setExpireTime(expireTime);
				}
				ruleInfo.setCreateTime(new Date());
				ruleInfo.setUpdateTime(new Date());
				ruleList.add(ruleInfo);
			}
		}
		return ruleList;
	}

	/**
	 * 下载单条结算单
	 */
	public void simpleExportOrderData(String orderId, String operatorId, String operatorName) {
		logger.info("operatorName,orderId {},operatorId {},operatorName {}", new Object[] { orderId, operatorId, operatorName });
		DownloadOrderDetailThread thread = new DownloadOrderDetailThread(orderId, operatorId, operatorName, scSettleBaseService);
		executorService.execute(new InheritTraceNoRunableWrapper(thread));
	}
	
	/**
	 * 下载云收银单条结算单
	 */
	public void simpleEasypayExportOrderData(String orderId, String operatorId, String operatorName) {
		logger.info("operatorName,orderId {},operatorId {},operatorName {}", new Object[] { orderId, operatorId, operatorName });
		DownloadEasypayOrderDetailThread thread = new DownloadEasypayOrderDetailThread(orderId, operatorId, operatorName, scSettleBaseService);
		executorService.execute(new InheritTraceNoRunableWrapper(thread));
	}

	/**
	 * 导出结算单（导出汇总）
	 * 
	 * @param configInfo
	 * @param request
	 * @param response
	 * @param model
	 * @return
	 */
	public void collectExportOrderData(PromoterSettleOrderDTO info, String operatorId, String operatorName) {
		logger.info("operatorName,PromoterSettleOrderDTO {},operatorId {},operatorName {}",
				new Object[] { ToStringBuilder.reflectionToString(info, ToStringStyle.SHORT_PREFIX_STYLE), operatorId, operatorName });
		DownloadOrderCollectThread thread = new DownloadOrderCollectThread(info, operatorId, operatorName, scSettleBaseService);
		executorService.execute(new InheritTraceNoRunableWrapper(thread));
	}

}
