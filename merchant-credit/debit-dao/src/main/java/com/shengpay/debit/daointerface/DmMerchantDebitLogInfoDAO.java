package com.shengpay.debit.daointerface;

import com.shengpay.debit.dal.dataobject.DmMerchantDebitLogInfoExample;
import com.shengpay.debit.dal.dataobject.DmMerchantDebitLogInfoPO;
import java.util.List;

public interface DmMerchantDebitLogInfoDAO {
    int countByExample(DmMerchantDebitLogInfoExample example);

    int deleteByExample(DmMerchantDebitLogInfoExample example);

    int deleteByPrimaryKey(Long id);

    Long insert(DmMerchantDebitLogInfoPO record);

    Long insertSelective(DmMerchantDebitLogInfoPO record);

    List<DmMerchantDebitLogInfoPO> selectByExample(DmMerchantDebitLogInfoExample example);

    DmMerchantDebitLogInfoPO selectByPrimaryKey(Long id);

    int updateByExampleSelective(DmMerchantDebitLogInfoPO record, DmMerchantDebitLogInfoExample example);

    int updateByExample(DmMerchantDebitLogInfoPO record, DmMerchantDebitLogInfoExample example);

    int updateByPrimaryKeySelective(DmMerchantDebitLogInfoPO record);

    int updateByPrimaryKey(DmMerchantDebitLogInfoPO record);
}