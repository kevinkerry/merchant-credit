package com.shengpay.debit.daointerface;

import com.shengpay.debit.dal.dataobject.DbThreadBatchExample;
import com.shengpay.debit.dal.dataobject.DbThreadBatchPO;
import java.util.List;

public interface DbThreadBatchDAO {
    int countByExample(DbThreadBatchExample example);

    int deleteByExample(DbThreadBatchExample example);

    int deleteByPrimaryKey(Long id);

    Long insert(DbThreadBatchPO record);

    Long insertSelective(DbThreadBatchPO record);

    List<DbThreadBatchPO> selectByExample(DbThreadBatchExample example);

    DbThreadBatchPO selectByPrimaryKey(Long id);

    int updateByExampleSelective(DbThreadBatchPO record, DbThreadBatchExample example);

    int updateByExample(DbThreadBatchPO record, DbThreadBatchExample example);

    int updateByPrimaryKeySelective(DbThreadBatchPO record);

    int updateByPrimaryKey(DbThreadBatchPO record);
}