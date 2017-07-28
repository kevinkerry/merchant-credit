package com.shengpay.debit.common.service;

import java.math.BigDecimal;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.ui.ModelMap;

import com.sdp.mc.common.vo.ErrorMessageVO;
import com.sdp.mc.common.web.MCMerchantUser;
import com.shengpay.debit.dal.dataobject.DmMerchantDebitInfoPO;
import com.shengpay.debit.dal.dataobject.DoMerchantDebitOrderPO;
import com.shengpay.debit.dal.ext.dataobject.LoanDebitOrderDTO;

/**
 * 申请借款
 */
public interface MerchantDebitApplyService {

	public DmMerchantDebitInfoPO queryDebitMerchantDebitInfo(String merchantId);

	/**
	 * @param isAgentguarantee
	 *            代理商是否承诺担保
	 * **/
	public ErrorMessageVO debitApply(DoMerchantDebitOrderPO record, boolean isAgentGuarantee, MCMerchantUser user);

	public Long insert(DoMerchantDebitOrderPO record);

	public BigDecimal getInterestRateDay(String orgnizationCode, String riskLevel);

	public ErrorMessageVO loanOperation(Long id, String status, String operator, String operatorId);

	public ErrorMessageVO batchLoanOperation(String morIds, String status, String operator, String operatorId);

	public ErrorMessageVO doExcel(List<LoanDebitOrderDTO> dataList, HttpServletRequest request, HttpServletResponse response);

	public ErrorMessageVO applyResutl(Long id, ModelMap map);

}
