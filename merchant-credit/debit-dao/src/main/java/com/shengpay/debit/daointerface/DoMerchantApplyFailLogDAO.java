package com.shengpay.debit.daointerface;

import com.shengpay.debit.dal.dataobject.DoMerchantApplyFailLogExample;
import com.shengpay.debit.dal.dataobject.DoMerchantApplyFailLogPO;
import java.util.List;

public interface DoMerchantApplyFailLogDAO {
    int countByExample(DoMerchantApplyFailLogExample example);

    int deleteByExample(DoMerchantApplyFailLogExample example);

    int deleteByPrimaryKey(Long id);

    Long insert(DoMerchantApplyFailLogPO record);

    Long insertSelective(DoMerchantApplyFailLogPO record);

    List<DoMerchantApplyFailLogPO> selectByExample(DoMerchantApplyFailLogExample example);

    DoMerchantApplyFailLogPO selectByPrimaryKey(Long id);

    int updateByExampleSelective(DoMerchantApplyFailLogPO record, DoMerchantApplyFailLogExample example);

    int updateByExample(DoMerchantApplyFailLogPO record, DoMerchantApplyFailLogExample example);

    int updateByPrimaryKeySelective(DoMerchantApplyFailLogPO record);

    int updateByPrimaryKey(DoMerchantApplyFailLogPO record);
}