package com.shengpay.debit.daointerface;

import com.shengpay.debit.dal.dataobject.DoTransferLogExample;
import com.shengpay.debit.dal.dataobject.DoTransferLogPO;
import java.util.List;

public interface DoTransferLogDAO {
    int countByExample(DoTransferLogExample example);

    int deleteByExample(DoTransferLogExample example);

    int deleteByPrimaryKey(Long id);

    Long insert(DoTransferLogPO record);

    Long insertSelective(DoTransferLogPO record);

    List<DoTransferLogPO> selectByExample(DoTransferLogExample example);

    DoTransferLogPO selectByPrimaryKey(Long id);

    int updateByExampleSelective(DoTransferLogPO record, DoTransferLogExample example);

    int updateByExample(DoTransferLogPO record, DoTransferLogExample example);

    int updateByPrimaryKeySelective(DoTransferLogPO record);

    int updateByPrimaryKey(DoTransferLogPO record);
}