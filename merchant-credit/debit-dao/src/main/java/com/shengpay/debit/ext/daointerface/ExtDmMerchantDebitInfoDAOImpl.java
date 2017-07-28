package com.shengpay.debit.ext.daointerface;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.shengpay.debit.dal.dataobject.DmMerchantDebitInfoExample;
import com.shengpay.debit.dal.dataobject.DmMerchantDebitInfoPO;
import com.shengpay.debit.daointerface.DmMerchantDebitInfoDAOImpl;

public class ExtDmMerchantDebitInfoDAOImpl extends DmMerchantDebitInfoDAOImpl implements ExtDmMerchantDebitInfoDAO {

	@Override
	public DmMerchantDebitInfoPO selectByMerchantId(String merchantNo) {
		DmMerchantDebitInfoExample example = new DmMerchantDebitInfoExample();
		DmMerchantDebitInfoExample.Criteria criteria = example.createCriteria();
		criteria.andMerchantNoEqualTo(merchantNo);
		List<DmMerchantDebitInfoPO> list = selectByExample(example);
		if (list != null && list.size() > 0) {
			return list.get(0);
		}
		return null;
	}

	/**
	 * 冻结商户申请额度
	 *
	 * @param merchantNo
	 * @param status
	 * @param amount
	 * @return
	 */
	@Override
	public int freezeMerchantDebit(String merchantNo, String status, BigDecimal amount) {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("status", status);
		params.put("merchantNo", merchantNo);
		params.put("amount", amount);
		return getSqlMapClientTemplate().update("DM_MERCHANT_DEBIT_INFO.freezeMerchantDebit", params);
	}

	/**
	 * 成功解冻
	 *
	 * @param merchantNo
	 * @param status
	 * @param amount
	 * @return
	 */
	@Override
	public int freezeMerchantDebitSuccess(String merchantNo, String status, BigDecimal amount) {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("status", status);
		params.put("merchantNo", merchantNo);
		params.put("amount", amount);
		return getSqlMapClientTemplate().update("DM_MERCHANT_DEBIT_INFO.freezeMerchantDebitSuccess", params);
	}

	/**
	 * 失败解冻
	 *
	 * @param merchantNo
	 * @param status
	 * @param amount
	 * @return
	 */
	@Override
	public int freezeMerchantDebitFail(String merchantNo, String status, BigDecimal amount) {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("status", status);
		params.put("merchantNo", merchantNo);
		params.put("amount", amount);
		return getSqlMapClientTemplate().update("DM_MERCHANT_DEBIT_INFO.freezeMerchantDebitFail", params);
	}

	public int recoverBorrowMoney(String merchantNo, String status, String orgCode, BigDecimal amount, BigDecimal overdueInterest) {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("merchantNo", merchantNo);
		params.put("status", status);
		params.put("orgCode", orgCode);
		params.put("amount", amount);
		params.put("overdueInterest", overdueInterest);
		return getSqlMapClientTemplate().update("DM_MERCHANT_DEBIT_INFO.recoverBorrowMoney", params);
	}


	public int repaymentMoney(String merchantNo, String orgCode, BigDecimal amount){
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("merchantNo", merchantNo);
		params.put("orgCode", orgCode);
		params.put("amount", amount);
		return getSqlMapClientTemplate().update("DM_MERCHANT_DEBIT_INFO.repaymentMoney", params);
	}

	public int addOverdueInterest(String merchantNo, BigDecimal overdueInterest) {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("merchantNo", merchantNo);
		params.put("overdueInterest", overdueInterest);
		return getSqlMapClientTemplate().update("DM_MERCHANT_DEBIT_INFO.addOverdueInterest", params);
	}

}
