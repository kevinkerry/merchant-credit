package com.shengpay.debit.daointerface;

import com.shengpay.debit.dal.dataobject.TbWithholdingTransLogExample;
import com.shengpay.debit.dal.dataobject.TbWithholdingTransLogPO;
import java.util.List;

public interface TbWithholdingTransLogDAO {
    int countByExample(TbWithholdingTransLogExample example);

    int deleteByExample(TbWithholdingTransLogExample example);

    int deleteByPrimaryKey(Long id);

    Long insert(TbWithholdingTransLogPO record);

    Long insertSelective(TbWithholdingTransLogPO record);

    List<TbWithholdingTransLogPO> selectByExample(TbWithholdingTransLogExample example);

    TbWithholdingTransLogPO selectByPrimaryKey(Long id);

    int updateByExampleSelective(TbWithholdingTransLogPO record, TbWithholdingTransLogExample example);

    int updateByExample(TbWithholdingTransLogPO record, TbWithholdingTransLogExample example);

    int updateByPrimaryKeySelective(TbWithholdingTransLogPO record);

    int updateByPrimaryKey(TbWithholdingTransLogPO record);
}