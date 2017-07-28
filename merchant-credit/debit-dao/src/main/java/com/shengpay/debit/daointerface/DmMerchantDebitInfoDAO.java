package com.shengpay.debit.daointerface;

import com.shengpay.debit.dal.dataobject.DmMerchantDebitInfoExample;
import com.shengpay.debit.dal.dataobject.DmMerchantDebitInfoPO;
import java.util.List;

public interface DmMerchantDebitInfoDAO {
    int countByExample(DmMerchantDebitInfoExample example);

    int deleteByExample(DmMerchantDebitInfoExample example);

    int deleteByPrimaryKey(Long id);

    Long insert(DmMerchantDebitInfoPO record);

    Long insertSelective(DmMerchantDebitInfoPO record);

    List<DmMerchantDebitInfoPO> selectByExample(DmMerchantDebitInfoExample example);

    DmMerchantDebitInfoPO selectByPrimaryKey(Long id);

    int updateByExampleSelective(DmMerchantDebitInfoPO record, DmMerchantDebitInfoExample example);

    int updateByExample(DmMerchantDebitInfoPO record, DmMerchantDebitInfoExample example);

    int updateByPrimaryKeySelective(DmMerchantDebitInfoPO record);

    int updateByPrimaryKey(DmMerchantDebitInfoPO record);
}