package com.shengpay.debit.daointerface;

import com.shengpay.debit.dal.dataobject.DmMerchantCreditBaseInfoExample;
import com.shengpay.debit.dal.dataobject.DmMerchantCreditBaseInfoPO;
import java.util.List;

public interface DmMerchantCreditBaseInfoDAO {
    int countByExample(DmMerchantCreditBaseInfoExample example);

    int deleteByExample(DmMerchantCreditBaseInfoExample example);

    int deleteByPrimaryKey(Long id);

    Long insert(DmMerchantCreditBaseInfoPO record);

    Long insertSelective(DmMerchantCreditBaseInfoPO record);

    List<DmMerchantCreditBaseInfoPO> selectByExample(DmMerchantCreditBaseInfoExample example);

    DmMerchantCreditBaseInfoPO selectByPrimaryKey(Long id);

    int updateByExampleSelective(DmMerchantCreditBaseInfoPO record, DmMerchantCreditBaseInfoExample example);

    int updateByExample(DmMerchantCreditBaseInfoPO record, DmMerchantCreditBaseInfoExample example);

    int updateByPrimaryKeySelective(DmMerchantCreditBaseInfoPO record);

    int updateByPrimaryKey(DmMerchantCreditBaseInfoPO record);
}