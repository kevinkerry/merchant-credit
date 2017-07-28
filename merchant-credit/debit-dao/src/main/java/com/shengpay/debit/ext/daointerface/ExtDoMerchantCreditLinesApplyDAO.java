package com.shengpay.debit.ext.daointerface;

import java.util.List;
import java.util.Map;

import com.shengpay.debit.dal.dataobject.DoMeCreditLinesApplyInfoPO;
import com.shengpay.debit.dal.dataobject.DoMerchantCreditLinesApplyPO;
import com.shengpay.debit.dal.ext.dataobject.ExtDoMerchantCreditLinesApplyExample;
import com.shengpay.debit.daointerface.DoMerchantCreditLinesApplyDAO;

public interface ExtDoMerchantCreditLinesApplyDAO extends DoMerchantCreditLinesApplyDAO{

	public DoMerchantCreditLinesApplyPO getLatestCreditLines(String merchantId);

	public List<DoMerchantCreditLinesApplyPO> pageQueryDebitApplyMerchants(ExtDoMerchantCreditLinesApplyExample query);
	/**
	 * 根据时间获取额度申请记录
	 * @param date
	 * @return
	 */
	public List<DoMerchantCreditLinesApplyPO> getMerchantApply(Map <String, Object> mps);

	/**
	 * 删除附件前查询出需要删除的附件记录
	 * @return
	 */
	public List<DoMeCreditLinesApplyInfoPO> getCreditLinesApplyInfo(Map <String, Object> mps);


}
