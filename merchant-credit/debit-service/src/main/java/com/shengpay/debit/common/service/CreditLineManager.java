package com.shengpay.debit.common.service;

import java.util.List;
import java.util.Map;

import com.shengpay.debit.dal.dataobject.DoMeCreditLinesApplyInfoPO;
import com.shengpay.debit.dal.dataobject.DoMerchantCreditLinesApplyPO;

public interface CreditLineManager {

	/**
	 * 存储
	 *
	 * @param applyPO
	 * @param applyPOItems
	 */
	public void saveDb(DoMerchantCreditLinesApplyPO applyPO,
			List<DoMeCreditLinesApplyInfoPO> applyPOItems);

	/**
	 * 获取merchant
	 *
	 * @param po
	 * @return
	 */
	public Map<String, DoMeCreditLinesApplyInfoPO> selectByDoApplyPO(DoMerchantCreditLinesApplyPO po);

	/**
	 * 更新
	 * @param applyPO
	 * @param applyPOItems
	 */
	public void updateDb(DoMerchantCreditLinesApplyPO dbApplyPO, DoMerchantCreditLinesApplyPO applyPO,
			List<DoMeCreditLinesApplyInfoPO> applyPOItems);


	public String selectOtherInputByInputCode(String merchantNo, String inputCode);
	
	/**
	 * 信息更新或保存
	 */
	public void saveOrUpdateDb(DoMerchantCreditLinesApplyPO applyPO,String saveOrUpdateFlag);
	

}
