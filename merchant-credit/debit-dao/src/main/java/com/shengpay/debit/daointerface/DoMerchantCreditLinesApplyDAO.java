package com.shengpay.debit.daointerface;

import com.shengpay.debit.dal.dataobject.DoMerchantCreditLinesApplyExample;
import com.shengpay.debit.dal.dataobject.DoMerchantCreditLinesApplyPO;
import java.util.List;
import java.util.Map;

public interface DoMerchantCreditLinesApplyDAO {
    int countByExample(DoMerchantCreditLinesApplyExample example);

    int deleteByExample(DoMerchantCreditLinesApplyExample example);

    int deleteByPrimaryKey(Long id);

    Long insert(DoMerchantCreditLinesApplyPO record);

    Long insertSelective(DoMerchantCreditLinesApplyPO record);

    List<DoMerchantCreditLinesApplyPO> selectByExample(DoMerchantCreditLinesApplyExample example);

    DoMerchantCreditLinesApplyPO selectByPrimaryKey(Long id);

    int updateByExampleSelective(DoMerchantCreditLinesApplyPO record, DoMerchantCreditLinesApplyExample example);

    int updateByExample(DoMerchantCreditLinesApplyPO record, DoMerchantCreditLinesApplyExample example);

    int updateByPrimaryKeySelective(DoMerchantCreditLinesApplyPO record);

    int updateByPrimaryKey(DoMerchantCreditLinesApplyPO record);
    void updateMerchantCreditLineStatusJob(Map<String,Object> map);
}