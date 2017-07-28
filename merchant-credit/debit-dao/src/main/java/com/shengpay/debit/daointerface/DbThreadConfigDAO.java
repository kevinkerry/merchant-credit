package com.shengpay.debit.daointerface;

import com.shengpay.debit.dal.dataobject.DbThreadConfigExample;
import com.shengpay.debit.dal.dataobject.DbThreadConfigPO;
import java.util.List;

public interface DbThreadConfigDAO {
    int countByExample(DbThreadConfigExample example);

    int deleteByExample(DbThreadConfigExample example);

    int deleteByPrimaryKey(Long id);

    Long insert(DbThreadConfigPO record);

    Long insertSelective(DbThreadConfigPO record);

    List<DbThreadConfigPO> selectByExample(DbThreadConfigExample example);

    DbThreadConfigPO selectByPrimaryKey(Long id);

    int updateByExampleSelective(DbThreadConfigPO record, DbThreadConfigExample example);

    int updateByExample(DbThreadConfigPO record, DbThreadConfigExample example);

    int updateByPrimaryKeySelective(DbThreadConfigPO record);

    int updateByPrimaryKey(DbThreadConfigPO record);
}