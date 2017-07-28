package com.shengpay.debit.ext.daointerface;

import java.util.ArrayList;
import java.util.List;

import com.shengpay.debit.dal.dataobject.TbWithholdingTransLogPO;
import com.shengpay.debit.dal.ext.dataobject.ExtTbWithholdingTransLogExample;
import com.shengpay.debit.daointerface.TbWithholdingTransLogDAOImpl;
public class ExtTbWithholdingTransLogDAOImpl extends TbWithholdingTransLogDAOImpl implements
		ExtTbWithholdingTransLogDAO {

	@Override
	public List<TbWithholdingTransLogPO> pageQueryInfoList(
			ExtTbWithholdingTransLogExample queryParam) throws Exception {
		Integer totalItem = (Integer) getSqlMapClientTemplate().queryForObject("TB_WITHHOLDING_TRANS_INFO.countWithholdingCount", queryParam);
		queryParam.setTotalItem(totalItem);
		if (queryParam.isNeedQueryAll() && totalItem > 0) {
			queryParam.setPageSize(totalItem);
		}
		List<TbWithholdingTransLogPO> returnList = new ArrayList<TbWithholdingTransLogPO>();
		if (queryParam.getPageFristItem() <= queryParam.getTotalItem()) {
			List<TbWithholdingTransLogPO> list = getSqlMapClientTemplate().queryForList("TB_WITHHOLDING_TRANS_INFO.pageQueryWithholdingList", queryParam);
			returnList.addAll(list);
		}
		return returnList;
	}


}
