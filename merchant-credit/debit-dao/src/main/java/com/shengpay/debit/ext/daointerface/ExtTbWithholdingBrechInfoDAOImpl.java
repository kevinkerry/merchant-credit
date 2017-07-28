package com.shengpay.debit.ext.daointerface;

import java.util.ArrayList;
import java.util.List;
import com.shengpay.debit.dal.dataobject.TbWithholdingBrechInfoPO;
import com.shengpay.debit.dal.ext.dataobject.ExtTbWithholdingBrechInfoExample;
import com.shengpay.debit.dal.ext.dataobject.ExtTbWithholdingInfoExample;
import com.shengpay.debit.daointerface.TbWithholdingBrechInfoDAOImpl;

public class ExtTbWithholdingBrechInfoDAOImpl extends TbWithholdingBrechInfoDAOImpl implements ExtTbWithholdingBrechInfoDAO {
	// TB_WITHHOLDING_INFO.xml

	@Override
	@Deprecated
	public List<TbWithholdingBrechInfoPO> pageQueryInfoList(ExtTbWithholdingBrechInfoExample queryParam) throws Exception {
		Integer totalItem = (Integer) getSqlMapClientTemplate().queryForObject("TB_WITHHOLDING_BRECH_INFO.countWithholdingCount", queryParam);
		queryParam.setTotalItem(totalItem);
		if (queryParam.isNeedQueryAll() && totalItem > 0) {
			queryParam.setPageSize(totalItem);
		}
		List<TbWithholdingBrechInfoPO> returnList = new ArrayList<TbWithholdingBrechInfoPO>();
		if (queryParam.getPageFristItem() <= queryParam.getTotalItem()) {
			@SuppressWarnings("unchecked")
			List<TbWithholdingBrechInfoPO> list = getSqlMapClientTemplate().queryForList("TB_WITHHOLDING_BRECH_INFO.pageQueryWithholdingList",
					queryParam);
			returnList.addAll(list);
		}
		return returnList;
	}

	@SuppressWarnings("unchecked")
	/**
	 * 查询代扣批次,加入代扣订单查询信息
	 * @param param
	 * @return
	 * @throws Exception
	 */
	public List<TbWithholdingBrechInfoPO> queryByPage(ExtTbWithholdingInfoExample param) throws Exception {
		Integer totalItem = (Integer) getSqlMapClientTemplate().queryForObject("EXT_TB_WITHHOLDING_INFO.countWithholdingCount", param);
		param.setTotalItem(totalItem);
		if (param.isNeedQueryAll() && totalItem > 0) {
			param.setPageSize(totalItem);
		}
		List<TbWithholdingBrechInfoPO> returnList = new ArrayList<TbWithholdingBrechInfoPO>();
		if (param.getPageFristItem() <= param.getTotalItem()) {
			List<TbWithholdingBrechInfoPO> list = getSqlMapClientTemplate().queryForList("EXT_TB_WITHHOLDING_INFO.pageQueryWithholdingList", param);
			returnList.addAll(list);
		}
		return returnList;
	}

}
