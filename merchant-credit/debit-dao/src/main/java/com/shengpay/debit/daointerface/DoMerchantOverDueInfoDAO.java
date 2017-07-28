package com.shengpay.debit.daointerface;

import com.shengpay.debit.dal.dataobject.DoMerchantOverDueInfoExample;
import com.shengpay.debit.dal.dataobject.DoMerchantOverDueInfoPO;
import java.util.List;

public interface DoMerchantOverDueInfoDAO {
    int countByExample(DoMerchantOverDueInfoExample example);

    int deleteByExample(DoMerchantOverDueInfoExample example);

    int deleteByPrimaryKey(Long id);

    Long insert(DoMerchantOverDueInfoPO record);

    Long insertSelective(DoMerchantOverDueInfoPO record);

    List<DoMerchantOverDueInfoPO> selectByExample(DoMerchantOverDueInfoExample example);

    DoMerchantOverDueInfoPO selectByPrimaryKey(Long id);

    int updateByExampleSelective(DoMerchantOverDueInfoPO record, DoMerchantOverDueInfoExample example);

    int updateByExample(DoMerchantOverDueInfoPO record, DoMerchantOverDueInfoExample example);

    int updateByPrimaryKeySelective(DoMerchantOverDueInfoPO record);

    int updateByPrimaryKey(DoMerchantOverDueInfoPO record);
}