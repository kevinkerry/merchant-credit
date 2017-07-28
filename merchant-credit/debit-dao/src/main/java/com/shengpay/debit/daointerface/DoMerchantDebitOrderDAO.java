package com.shengpay.debit.daointerface;

import com.shengpay.debit.dal.dataobject.DoMerchantDebitOrderExample;
import com.shengpay.debit.dal.dataobject.DoMerchantDebitOrderPO;
import java.util.List;

public interface DoMerchantDebitOrderDAO {
    int countByExample(DoMerchantDebitOrderExample example);

    int deleteByExample(DoMerchantDebitOrderExample example);

    int deleteByPrimaryKey(Long id);

    Long insert(DoMerchantDebitOrderPO record);

    Long insertSelective(DoMerchantDebitOrderPO record);

    List<DoMerchantDebitOrderPO> selectByExample(DoMerchantDebitOrderExample example);

    DoMerchantDebitOrderPO selectByPrimaryKey(Long id);

    int updateByExampleSelective(DoMerchantDebitOrderPO record, DoMerchantDebitOrderExample example);

    int updateByExample(DoMerchantDebitOrderPO record, DoMerchantDebitOrderExample example);

    int updateByPrimaryKeySelective(DoMerchantDebitOrderPO record);

    int updateByPrimaryKey(DoMerchantDebitOrderPO record);
}