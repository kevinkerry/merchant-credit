package com.shengpay.debit.ext.daointerface;

import java.util.List;

import com.shengpay.debit.dal.dataobject.DbOrgCreditSettingExample;
import com.shengpay.debit.dal.dataobject.DbOrgCreditSettingPO;
import com.shengpay.debit.dal.ext.dataobject.DbOrgCreditSettingDTO;
import com.shengpay.debit.daointerface.DbOrgCreditSettingDAOImpl;

/**
 * 风控级别
 * 
 * @author heyi.alex
 * 
 */
public class ExtDbOrgCreditSettingDAOImpl extends DbOrgCreditSettingDAOImpl implements ExtDbOrgCreditSettingDAO {

	/**
	 * 根据机构和风控级别查询
	 */
	@Override
	public DbOrgCreditSettingPO selectByRiskLevel(String organization, String riskLevel) {
		DbOrgCreditSettingExample example = new DbOrgCreditSettingExample();
		DbOrgCreditSettingExample.Criteria criteria = example.createCriteria();
		criteria.andRiskLevelEqualTo(riskLevel);
		criteria.andOrgnizationCodeEqualTo(organization);
		List<DbOrgCreditSettingPO> list = this.selectByExample(example);
		if (list != null && list.size() > 0) { return list.get(0); }
		return null;
	}

	/**
	 * 分页查询
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void selectByQuery(DbOrgCreditSettingDTO query) {
		Integer totalItem = (Integer) getSqlMapClientTemplate().queryForObject("DB_ORG_CREDIT_SETTING.countByExample", query.getExample());
		query.setTotalItem(totalItem);
		if (query.isNeedQueryAll() && totalItem > 0) {
			query.setPageSize(totalItem);
		}
		if (query.getPageFristItem() <= query.getTotalItem()) {
			List<DbOrgCreditSettingPO> list = (List<DbOrgCreditSettingPO>) this.getSqlMapClientTemplate().queryForList("DB_ORG_CREDIT_SETTING.selectByQuery", query);
			query.setPageList(list);
		}
	}

}
