package com.shengpay.debit.daointerface;

import com.shengpay.debit.dal.dataobject.DbOrgCreditSettingExample;
import com.shengpay.debit.dal.dataobject.DbOrgCreditSettingPO;
import java.util.List;

public interface DbOrgCreditSettingDAO {
    int countByExample(DbOrgCreditSettingExample example);

    int deleteByExample(DbOrgCreditSettingExample example);

    int deleteByPrimaryKey(Long id);

    Long insert(DbOrgCreditSettingPO record);

    Long insertSelective(DbOrgCreditSettingPO record);

    List<DbOrgCreditSettingPO> selectByExample(DbOrgCreditSettingExample example);

    DbOrgCreditSettingPO selectByPrimaryKey(Long id);

    int updateByExampleSelective(DbOrgCreditSettingPO record, DbOrgCreditSettingExample example);

    int updateByExample(DbOrgCreditSettingPO record, DbOrgCreditSettingExample example);

    int updateByPrimaryKeySelective(DbOrgCreditSettingPO record);

    int updateByPrimaryKey(DbOrgCreditSettingPO record);
}