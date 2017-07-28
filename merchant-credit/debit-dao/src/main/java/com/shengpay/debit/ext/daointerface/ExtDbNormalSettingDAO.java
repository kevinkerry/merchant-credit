package com.shengpay.debit.ext.daointerface;

import com.shengpay.debit.dal.ext.dataobject.DbNormalSettingDTO;
import com.shengpay.debit.daointerface.DbNormalSettingDAO;

public interface ExtDbNormalSettingDAO extends DbNormalSettingDAO{

	void selectByQuery(DbNormalSettingDTO query);

}
