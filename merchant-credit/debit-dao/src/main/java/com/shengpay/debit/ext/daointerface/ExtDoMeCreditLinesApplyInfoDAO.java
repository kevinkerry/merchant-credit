package com.shengpay.debit.ext.daointerface;

import com.shengpay.debit.daointerface.DoMeCreditLinesApplyInfoDAO;

public interface ExtDoMeCreditLinesApplyInfoDAO extends DoMeCreditLinesApplyInfoDAO{

	/**
	 * 根据申请ID删除输入项
	 * @param orderId
	 */
	public void deleteByLineApplyOrderId(Long orderId);
	
	public int updateCreditLinesApplyInfoByID(Long id);
}
