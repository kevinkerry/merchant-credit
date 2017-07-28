package com.shengpay.debit.daointerface;

import com.shengpay.debit.dal.dataobject.TbWithholdingFileInfoExample;
import com.shengpay.debit.dal.dataobject.TbWithholdingFileInfoPO;
import java.util.List;

public interface TbWithholdingFileInfoDAO {
    int countByExample(TbWithholdingFileInfoExample example);

    int deleteByExample(TbWithholdingFileInfoExample example);

    int deleteByPrimaryKey(Long id);

    Long insert(TbWithholdingFileInfoPO record);

    Long insertSelective(TbWithholdingFileInfoPO record);

    List<TbWithholdingFileInfoPO> selectByExample(TbWithholdingFileInfoExample example);

    TbWithholdingFileInfoPO selectByPrimaryKey(Long id);

    int updateByExampleSelective(TbWithholdingFileInfoPO record, TbWithholdingFileInfoExample example);

    int updateByExample(TbWithholdingFileInfoPO record, TbWithholdingFileInfoExample example);

    int updateByPrimaryKeySelective(TbWithholdingFileInfoPO record);

    int updateByPrimaryKey(TbWithholdingFileInfoPO record);
}