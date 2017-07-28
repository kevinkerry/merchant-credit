package com.shengpay.debit.daointerface;

import com.shengpay.debit.dal.dataobject.DoMeCreditLinesApplyInfoExample;
import com.shengpay.debit.dal.dataobject.DoMeCreditLinesApplyInfoPO;
import java.util.List;

public interface DoMeCreditLinesApplyInfoDAO {
    int countByExample(DoMeCreditLinesApplyInfoExample example);

    int deleteByExample(DoMeCreditLinesApplyInfoExample example);

    int deleteByPrimaryKey(Long id);

    Long insert(DoMeCreditLinesApplyInfoPO record);

    Long insertSelective(DoMeCreditLinesApplyInfoPO record);

    List<DoMeCreditLinesApplyInfoPO> selectByExample(DoMeCreditLinesApplyInfoExample example);

    DoMeCreditLinesApplyInfoPO selectByPrimaryKey(Long id);

    int updateByExampleSelective(DoMeCreditLinesApplyInfoPO record, DoMeCreditLinesApplyInfoExample example);

    int updateByExample(DoMeCreditLinesApplyInfoPO record, DoMeCreditLinesApplyInfoExample example);

    int updateByPrimaryKeySelective(DoMeCreditLinesApplyInfoPO record);

    int updateByPrimaryKey(DoMeCreditLinesApplyInfoPO record);
}