package com.shengpay.debit.ext.daointerface;

import java.util.List;

import com.shengpay.debit.dal.dataobject.DbNormalSettingPO;
import com.shengpay.debit.dal.ext.dataobject.DbNormalSettingDTO;
import com.shengpay.debit.daointerface.DbNormalSettingDAOImpl;

public class ExtDbNormalSettingDAOImpl extends DbNormalSettingDAOImpl implements ExtDbNormalSettingDAO {

	@SuppressWarnings("unchecked")
	@Override
	public void selectByQuery(DbNormalSettingDTO query) {
		Integer totalItem = (Integer) getSqlMapClientTemplate().queryForObject("DB_NORMAL_SETTING.countByExample", query.getExample());
		query.setTotalItem(totalItem);
		if (query.isNeedQueryAll() && totalItem > 0) {
			query.setPageSize(totalItem);
		}
		if (query.getPageFristItem() <= query.getTotalItem()) {
			List<DbNormalSettingPO> list = (List<DbNormalSettingPO>) this.getSqlMapClientTemplate().queryForList("DB_NORMAL_SETTING.selectByQuery", query);
			query.setPageList(list);
		}
	}

}
