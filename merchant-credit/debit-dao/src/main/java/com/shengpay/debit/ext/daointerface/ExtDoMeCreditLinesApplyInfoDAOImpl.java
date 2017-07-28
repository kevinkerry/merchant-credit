package com.shengpay.debit.ext.daointerface;

import java.util.HashMap;
import java.util.Map;

import com.shengpay.debit.dal.dataobject.DoMeCreditLinesApplyInfoExample;
import com.shengpay.debit.daointerface.DoMeCreditLinesApplyInfoDAOImpl;

public class ExtDoMeCreditLinesApplyInfoDAOImpl extends DoMeCreditLinesApplyInfoDAOImpl implements ExtDoMeCreditLinesApplyInfoDAO{

	@Override
	public void deleteByLineApplyOrderId(Long orderId) {
		DoMeCreditLinesApplyInfoExample example = new DoMeCreditLinesApplyInfoExample();
		DoMeCreditLinesApplyInfoExample.Criteria criteria = example.createCriteria();
		criteria.andLineApplyOrderIdEqualTo(orderId);
		this.deleteByExample(example);
	}
	
	/**
	 * 删除额度申请附件信息
	 */
	public int updateCreditLinesApplyInfoByID(Long id) {
		Map<String,Object> map=new HashMap<String, Object>();
//		map.put("inputType", "Enum");
		map.put("extInfo", "");
		map.put("id", id);
		int rows = getSqlMapClientTemplate().update("DO_ME_CREDIT_LINES_APPLY_INFO.updateByPrimaryKeyById",map);
        return rows;
	}

}
