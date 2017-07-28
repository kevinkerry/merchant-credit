package com.shengpay.debit.common.service;

import com.shengpay.debit.common.risk.model.CreditLineApplyRequest;
import com.shengpay.debit.dal.dataobject.DoMerchantCreditLinesApplyPO;

public interface DebitApplyService {
	public DoMerchantCreditLinesApplyPO  selectApplyById(Long id);
	public CreditLineApplyRequest getCreditLineApplyRequest(DoMerchantCreditLinesApplyPO applyPO);
}
