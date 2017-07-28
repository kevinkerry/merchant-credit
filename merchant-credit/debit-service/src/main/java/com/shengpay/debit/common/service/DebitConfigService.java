package com.shengpay.debit.common.service;

import com.shengpay.debit.common.enums.ConfigEnums;
import com.shengpay.debit.dal.dataobject.DbNormalSettingPO;
import com.shengpay.debit.dal.ext.dataobject.DbNormalSettingDTO;

public interface DebitConfigService {

	public String getByKey(ConfigEnums enums);

	public void selectByQuery(DbNormalSettingDTO query);

	public DbNormalSettingPO selectByPrimaryKey(Long id);

	public int updateByPrimaryKeySelective(DbNormalSettingPO config);

	public Long insert(DbNormalSettingPO config);
}
