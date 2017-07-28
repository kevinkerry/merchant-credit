package com.shengpay.debit.ext.daointerface;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.shengpay.debit.dal.dataobject.DoMeCreditLinesApplyInfoPO;
import com.shengpay.debit.dal.dataobject.DoMerchantCreditLinesApplyPO;
import com.shengpay.debit.dal.ext.dataobject.ExtDoMerchantCreditLinesApplyExample;
import com.shengpay.debit.daointerface.DoMerchantCreditLinesApplyDAOImpl;

public class ExtDoMerchantCreditLinesApplyDAOImpl extends DoMerchantCreditLinesApplyDAOImpl implements ExtDoMerchantCreditLinesApplyDAO {

	@SuppressWarnings("unchecked")
	public DoMerchantCreditLinesApplyPO getLatestCreditLines(String merchantNo) {
		Map<String, Object> maps = new HashMap<String, Object>();
		maps.put("merchantNo", merchantNo);
		maps.put("endTime", new Date());
		List<DoMerchantCreditLinesApplyPO> list = this.getSqlMapClientTemplate().queryForList("DO_MERCHANT_CREDIT_LINES_APPLY.selectApplyIngOrder", maps);
		if (list != null && list.size() > 0) {
			return list.get(0);
		}
		return null;
	}

	/**
	 * 分页查询贷款申请记录
	 * **/
	@SuppressWarnings("unchecked")
	public List<DoMerchantCreditLinesApplyPO> pageQueryDebitApplyMerchants(ExtDoMerchantCreditLinesApplyExample example) {
		Integer totalItem = (Integer) getSqlMapClientTemplate().queryForObject("DO_MERCHANT_CREDIT_LINES_APPLY.countMerchantCreditLineApply", example);
		example.setTotalItem(totalItem);
		if (example.isNeedQueryAll() && totalItem > 0) {
			example.setPageSize(totalItem);
		}
		List<DoMerchantCreditLinesApplyPO> returnList = new ArrayList<DoMerchantCreditLinesApplyPO>();
		if (example.getPageFristItem() <= example.getTotalItem()) {
			List<DoMerchantCreditLinesApplyPO> list = getSqlMapClientTemplate().queryForList("DO_MERCHANT_CREDIT_LINES_APPLY.pageQueryMerchantCreditLineApply", example);
			returnList.addAll(list);
		}
		return returnList;
	}

	/**
	 * 根据时间获取额度申请记录
	 */
	@SuppressWarnings("unchecked")
	public List<DoMerchantCreditLinesApplyPO> getMerchantApply(Map <String, Object> mps) {
		List<DoMerchantCreditLinesApplyPO> list = this.getSqlMapClientTemplate().queryForList("DO_MERCHANT_CREDIT_LINES_APPLY.selectMerchantByMps", mps);
		return list;
	}
	/**
	 * 获取需要删除附件的数据记录
	 */
	@SuppressWarnings("unchecked")
	public List<DoMeCreditLinesApplyInfoPO> getCreditLinesApplyInfo(Map <String, Object> mps) {
		List<DoMeCreditLinesApplyInfoPO> list = this.getSqlMapClientTemplate().queryForList("DO_ME_CREDIT_LINES_APPLY_INFO.selectMerchantApplyInfoByMps", mps);
		return list;
	}
}
