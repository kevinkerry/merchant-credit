package com.shengpay.debit.ext.daointerface;

import java.util.ArrayList;
import java.util.List;
import com.shengpay.debit.dal.dataobject.TbWithholdingFileInfoPO;
import com.shengpay.debit.dal.ext.dataobject.ExtTbWithholdingFileInfoExample;
import com.shengpay.debit.daointerface.TbWithholdingFileInfoDAOImpl;

public class ExtTbWithholdingFileInfoDAOImpl  extends TbWithholdingFileInfoDAOImpl implements ExtTbWithholdingFileInfoDAO {
	@Override
	public List<TbWithholdingFileInfoPO> pageQueryInfoList(
			ExtTbWithholdingFileInfoExample queryParam) throws Exception {
		Integer totalItem = (Integer) getSqlMapClientTemplate().queryForObject("TB_WITHHOLDING_FILE_INFO.countWithholdingCount", queryParam);
		queryParam.setTotalItem(totalItem);
		if (queryParam.isNeedQueryAll() && totalItem > 0) {
			queryParam.setPageSize(totalItem);
		}
		List<TbWithholdingFileInfoPO> returnList = new ArrayList<TbWithholdingFileInfoPO>();
		if (queryParam.getPageFristItem() <= queryParam.getTotalItem()) {
			List<TbWithholdingFileInfoPO> list = getSqlMapClientTemplate().queryForList("TB_WITHHOLDING_FILE_INFO.pageQueryWithholdingList", queryParam);
			returnList.addAll(list);
		}
		return returnList;
	}
}
