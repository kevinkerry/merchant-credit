package com.shengpay.debit.ext.daointerface;

import com.shengpay.debit.dal.dataobject.DbOrgCreditSettingPO;
import com.shengpay.debit.dal.ext.dataobject.DbOrgCreditSettingDTO;
import com.shengpay.debit.daointerface.DbOrgCreditSettingDAO;

public interface ExtDbOrgCreditSettingDAO extends DbOrgCreditSettingDAO{

	public DbOrgCreditSettingPO selectByRiskLevel(String organization, String riskLevel);

	public void selectByQuery(DbOrgCreditSettingDTO query);

}
