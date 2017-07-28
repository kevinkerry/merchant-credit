package com.shengpay.debit.daointerface;

import com.shengpay.debit.dal.dataobject.DbRiskRequestLogExample;
import com.shengpay.debit.dal.dataobject.DbRiskRequestLogPO;
import java.util.List;

public interface DbRiskRequestLogDAO {
    int countByExample(DbRiskRequestLogExample example);

    int deleteByExample(DbRiskRequestLogExample example);

    int deleteByPrimaryKey(Long id);

    Long insert(DbRiskRequestLogPO record);

    Long insertSelective(DbRiskRequestLogPO record);

    List<DbRiskRequestLogPO> selectByExample(DbRiskRequestLogExample example);

    DbRiskRequestLogPO selectByPrimaryKey(Long id);

    int updateByExampleSelective(DbRiskRequestLogPO record, DbRiskRequestLogExample example);

    int updateByExample(DbRiskRequestLogPO record, DbRiskRequestLogExample example);

    int updateByPrimaryKeySelective(DbRiskRequestLogPO record);

    int updateByPrimaryKey(DbRiskRequestLogPO record);
}