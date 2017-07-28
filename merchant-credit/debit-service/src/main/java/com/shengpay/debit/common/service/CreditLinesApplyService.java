package com.shengpay.debit.common.service;

import java.util.Map;

import com.sdp.mc.common.vo.ErrorMessageVO;
import com.shengpay.debit.common.risk.model.CreditRiskResult;
import com.shengpay.debit.credit.lines.apply.enums.CreditLinesApplyStatusEnums;
import com.shengpay.debit.dal.dataobject.DoMerchantCreditLinesApplyExample;
import com.shengpay.debit.dal.dataobject.DoMerchantCreditLinesApplyPO;
import com.shengpay.service.fileManager.FileManagerService;

public interface CreditLinesApplyService {
	/**
	 * 后台运营审核失败退回让用户修改提交资料[e.g.图片不清晰、证件号输入错误]
	 *
	 * @param 商户贷款额度申请id
	 * **/
	public ErrorMessageVO auditFail(Long id, String failReason);

	/**
	 * 后台运营审核将商户资料提交风控计算评级
	 *
	 * @param 商户贷款额度申请id
	 * **/
	public ErrorMessageVO submitCredit(Long id, FileManagerService fileService);

	/**
	 * 同步风控评级job服务
	 * **/
	public void syncCreditRiskResult4Job();

	/**
	 * 同步商户信用评级结果
	 *
	 * @param merchantCreditLinesApply
	 *            贷款额度申请对象
	 * @param crr
	 *            风控评级结果对象
	 * **/
	public boolean syncCreditRiskResult(DoMerchantCreditLinesApplyPO merchantCreditLinesApply, CreditRiskResult crr);

	/**
	 * 通过job修改数据状态
	 *
	 * @param id
	 * @param originalStatus
	 * @param targetStatus
	 * @return
	 */
	public boolean updateMerchantCreditLineStatusJob(Long id, CreditLinesApplyStatusEnums originalStatus, CreditLinesApplyStatusEnums targetStatus);

	public void updateMerchantCreditLineStatusJob(Map<String, Object> maps);
	/**
	 * 更新额度申请
	 * @param record
	 */
	public void updateByPrimaryKeySelective(DoMerchantCreditLinesApplyPO record);

}
