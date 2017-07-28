package com.shengpay.debit.common.service;

import com.shengpay.debit.dal.dataobject.DoMerchantCreditLinesApplyPO;


public interface CreditLineInputItemService {


	/**
	 * 将征信记录插入
	 * @param merchantCreditLinesApply
	 */

	public void insertItems(DoMerchantCreditLinesApplyPO merchantCreditLinesApply);

	/**
	 * 更新用户输入信息
	 *
	 * @param applyPO
	 * @param applyPOItems
	 */
	public void updateDb(DoMerchantCreditLinesApplyPO merchantCreditLinesApply) ;

}
