package com.shengpay.debit.daointerface;

import com.shengpay.debit.dal.dataobject.DoAgentProfitExample;
import com.shengpay.debit.dal.dataobject.DoAgentProfitPO;
import java.util.List;

public interface DoAgentProfitDAO {
    int countByExample(DoAgentProfitExample example);

    int deleteByExample(DoAgentProfitExample example);

    int deleteByPrimaryKey(Long id);

    Long insert(DoAgentProfitPO record);

    Long insertSelective(DoAgentProfitPO record);

    List<DoAgentProfitPO> selectByExample(DoAgentProfitExample example);

    DoAgentProfitPO selectByPrimaryKey(Long id);

    int updateByExampleSelective(DoAgentProfitPO record, DoAgentProfitExample example);

    int updateByExample(DoAgentProfitPO record, DoAgentProfitExample example);

    int updateByPrimaryKeySelective(DoAgentProfitPO record);

    int updateByPrimaryKey(DoAgentProfitPO record);
}