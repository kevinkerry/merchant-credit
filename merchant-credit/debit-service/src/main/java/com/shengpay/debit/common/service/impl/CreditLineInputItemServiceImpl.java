package com.shengpay.debit.common.service.impl;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.alibaba.fastjson.JSONObject;
import com.sdp.debit.web.creditLine.inputitem.ItemGetter;
import com.shengpay.debit.common.enums.InputItemEnums;
import com.shengpay.debit.common.service.CreditLineInputItemService;
import com.shengpay.debit.dal.dataobject.DoMeCreditLinesApplyInfoPO;
import com.shengpay.debit.dal.dataobject.DoMerchantCreditLinesApplyPO;
import com.shengpay.debit.ext.daointerface.ExtDoMeCreditLinesApplyInfoDAO;

@Service
public class CreditLineInputItemServiceImpl implements  CreditLineInputItemService{

	@Autowired
	private ExtDoMeCreditLinesApplyInfoDAO doMeCreditLinesApplyInfoDAO;

	@Override
	public void insertItems(
			DoMerchantCreditLinesApplyPO merchantCreditLinesApply) {
		String jsonStr = merchantCreditLinesApply.getApplyMerchantInfo();
		JSONObject jobject = JSONObject.parseObject(jsonStr);
		Date now = new Date();
		for (InputItemEnums item: InputItemEnums.values()){
			ItemGetter itemGetter = item.itemGetter;
			DoMeCreditLinesApplyInfoPO applyInfoPO = new DoMeCreditLinesApplyInfoPO();
			applyInfoPO.setMerchantNo(merchantCreditLinesApply.getMerchantNo());
			applyInfoPO.setCreateTime(now);
			applyInfoPO.setUpdateTime(now);
			applyInfoPO.setOrgnizationCode("shengpay");
			applyInfoPO.setLineApplyOrderId(merchantCreditLinesApply.getId());
			applyInfoPO.setInputKind(item.inputKind);
			applyInfoPO.setInputCode(item.inputCode);
			applyInfoPO.setInputValue(itemGetter.getUserInputVal(jobject));
			applyInfoPO.setExtInfo(itemGetter.getExtInfo(jobject));
			applyInfoPO.setInputType(itemGetter.getInputType());
			doMeCreditLinesApplyInfoDAO.insert(applyInfoPO);
		}


	}

	@Override
	public void updateDb(DoMerchantCreditLinesApplyPO merchantCreditLinesApply) {
		doMeCreditLinesApplyInfoDAO.deleteByLineApplyOrderId(merchantCreditLinesApply.getId());
		insertItems(merchantCreditLinesApply);
	}

}
