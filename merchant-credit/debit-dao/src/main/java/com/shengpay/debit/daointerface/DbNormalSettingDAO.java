package com.shengpay.debit.daointerface;

import com.shengpay.debit.dal.dataobject.DbNormalSettingExample;
import com.shengpay.debit.dal.dataobject.DbNormalSettingPO;
import java.util.List;

public interface DbNormalSettingDAO {
    int countByExample(DbNormalSettingExample example);

    int deleteByExample(DbNormalSettingExample example);

    int deleteByPrimaryKey(Long id);

    Long insert(DbNormalSettingPO record);

    Long insertSelective(DbNormalSettingPO record);

    List<DbNormalSettingPO> selectByExample(DbNormalSettingExample example);

    DbNormalSettingPO selectByPrimaryKey(Long id);

    int updateByExampleSelective(DbNormalSettingPO record, DbNormalSettingExample example);

    int updateByExample(DbNormalSettingPO record, DbNormalSettingExample example);

    int updateByPrimaryKeySelective(DbNormalSettingPO record);

    int updateByPrimaryKey(DbNormalSettingPO record);
}