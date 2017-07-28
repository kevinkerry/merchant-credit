package com.shengpay.debit.daointerface;

import com.shengpay.debit.dal.dataobject.DbOrganizationInfoExample;
import com.shengpay.debit.dal.dataobject.DbOrganizationInfoPO;
import java.util.List;

public interface DbOrganizationInfoDAO {
    int countByExample(DbOrganizationInfoExample example);

    int deleteByExample(DbOrganizationInfoExample example);

    int deleteByPrimaryKey(Long id);

    Long insert(DbOrganizationInfoPO record);

    Long insertSelective(DbOrganizationInfoPO record);

    List<DbOrganizationInfoPO> selectByExample(DbOrganizationInfoExample example);

    DbOrganizationInfoPO selectByPrimaryKey(Long id);

    int updateByExampleSelective(DbOrganizationInfoPO record, DbOrganizationInfoExample example);

    int updateByExample(DbOrganizationInfoPO record, DbOrganizationInfoExample example);

    int updateByPrimaryKeySelective(DbOrganizationInfoPO record);

    int updateByPrimaryKey(DbOrganizationInfoPO record);
}