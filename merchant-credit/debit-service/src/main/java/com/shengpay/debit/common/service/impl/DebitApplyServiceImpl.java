package com.shengpay.debit.common.service.impl;

import net.sf.json.JSONObject;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shengpay.debit.common.risk.model.CreditLineApplyRequest;
import com.shengpay.debit.common.service.DebitApplyService;
import com.shengpay.debit.common.service.MerchantCreditLinesApplyService;
import com.shengpay.debit.dal.dataobject.DoMerchantCreditLinesApplyPO;
@Service
public class DebitApplyServiceImpl implements DebitApplyService {
	@Autowired
	protected MerchantCreditLinesApplyService merchantCreditLinesApplyService;
	@Override
	public DoMerchantCreditLinesApplyPO selectApplyById(Long id) {

		return merchantCreditLinesApplyService.selectById(id);
	}
	@Override
	public CreditLineApplyRequest getCreditLineApplyRequest(DoMerchantCreditLinesApplyPO applyPO) {
		CreditLineApplyRequest creditLineApplyRequest = null;
		if(applyPO != null && StringUtils.isNotBlank(applyPO.getApplyMerchantInfo())){
			JSONObject applyInfo = JSONObject.fromObject(applyPO.getApplyMerchantInfo());
			JSONObject jsonObject = JSONObject.fromObject(applyInfo.toString());
			creditLineApplyRequest = (CreditLineApplyRequest) JSONObject.toBean(jsonObject, CreditLineApplyRequest.class);
		}
		return creditLineApplyRequest;
	}

}
