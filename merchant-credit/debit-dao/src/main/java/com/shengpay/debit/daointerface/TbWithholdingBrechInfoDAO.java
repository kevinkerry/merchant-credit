package com.shengpay.debit.daointerface;

import com.shengpay.debit.dal.dataobject.TbWithholdingBrechInfoExample;
import com.shengpay.debit.dal.dataobject.TbWithholdingBrechInfoPO;
import java.util.List;

public interface TbWithholdingBrechInfoDAO {
    int countByExample(TbWithholdingBrechInfoExample example);

    int deleteByExample(TbWithholdingBrechInfoExample example);

    int deleteByPrimaryKey(Long id);

    Long insert(TbWithholdingBrechInfoPO record);

    Long insertSelective(TbWithholdingBrechInfoPO record);

    List<TbWithholdingBrechInfoPO> selectByExample(TbWithholdingBrechInfoExample example);

    TbWithholdingBrechInfoPO selectByPrimaryKey(Long id);

    int updateByExampleSelective(TbWithholdingBrechInfoPO record, TbWithholdingBrechInfoExample example);

    int updateByExample(TbWithholdingBrechInfoPO record, TbWithholdingBrechInfoExample example);

    int updateByPrimaryKeySelective(TbWithholdingBrechInfoPO record);

    int updateByPrimaryKey(TbWithholdingBrechInfoPO record);
}