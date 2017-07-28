package com.sdp.mc.service.settleorder;

import java.util.List;

import com.sdp.mc.common.vo.ErrorMessageVO;
import com.sdp.mc.settle.api.dto.PromoterSettleOrderDTO;

public interface ScSplittingRuleService {

	/**
	 * 批量新增 结算分润比例设置
	 * 
	 * @param ruleInfoList
	 * @return
	 */
	ErrorMessageVO<Object> buildBatchAddSplittingRule(List<String[]> ruleInfoList);

	/**
	 * 下载单条结算单
	 */
	public void simpleExportOrderData(String orderId, String operatorId, String operatorName);
	
	/**
	 * 下载云收银单条结算单
	 */
	public void simpleEasypayExportOrderData(String orderId, String operatorId, String operatorName);

	/**
	 * 导出结算单（导出汇总）
	 * 
	 * @param configInfo
	 * @param request
	 * @param response
	 * @param model
	 * @return
	 */
	public void collectExportOrderData(PromoterSettleOrderDTO info, String operatorId, String operatorName);
}
