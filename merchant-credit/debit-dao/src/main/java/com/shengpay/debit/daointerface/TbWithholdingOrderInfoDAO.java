package com.shengpay.debit.daointerface;

import com.shengpay.debit.dal.dataobject.TbWithholdingOrderInfoExample;
import com.shengpay.debit.dal.dataobject.TbWithholdingOrderInfoPO;
import java.util.List;

public interface TbWithholdingOrderInfoDAO {
    int countByExample(TbWithholdingOrderInfoExample example);

    int deleteByExample(TbWithholdingOrderInfoExample example);

    int deleteByPrimaryKey(Long id);

    Long insert(TbWithholdingOrderInfoPO record);

    Long insertSelective(TbWithholdingOrderInfoPO record);

    List<TbWithholdingOrderInfoPO> selectByExample(TbWithholdingOrderInfoExample example);

    TbWithholdingOrderInfoPO selectByPrimaryKey(Long id);

    int updateByExampleSelective(TbWithholdingOrderInfoPO record, TbWithholdingOrderInfoExample example);

    int updateByExample(TbWithholdingOrderInfoPO record, TbWithholdingOrderInfoExample example);

    int updateByPrimaryKeySelective(TbWithholdingOrderInfoPO record);

    int updateByPrimaryKey(TbWithholdingOrderInfoPO record);
}