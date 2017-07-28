package com.shengpay.debit.common.service;

import com.sdp.mc.common.vo.ErrorMessageVO;
import com.shengpay.debit.common.risk.model.CreditRiskResult;
import com.shengpay.debit.common.risk.model.CreditRiskSubmitRootVO;
import com.shengpay.debit.common.risk.model.GetCreditRiskResponseModel;

public interface CreditRiskService {

	public GetCreditRiskResponseModel getCreditRiskModel();
	
	public ErrorMessageVO submitCredit(CreditRiskSubmitRootVO creditRiskSubmitRoot);
	
	public CreditRiskResult getCreditScore(String merchantNo);
}
