package com.shengpay.debit.daointerface;

import com.shengpay.debit.dal.dataobject.DmAgentMerchantSettingListExample;
import com.shengpay.debit.dal.dataobject.DmAgentMerchantSettingListPO;
import java.util.List;

public interface DmAgentMerchantSettingListDAO {
    int countByExample(DmAgentMerchantSettingListExample example);

    int deleteByExample(DmAgentMerchantSettingListExample example);

    int deleteByPrimaryKey(Long id);

    Long insert(DmAgentMerchantSettingListPO record);

    Long insertSelective(DmAgentMerchantSettingListPO record);

    List<DmAgentMerchantSettingListPO> selectByExample(DmAgentMerchantSettingListExample example);

    DmAgentMerchantSettingListPO selectByPrimaryKey(Long id);

    int updateByExampleSelective(DmAgentMerchantSettingListPO record, DmAgentMerchantSettingListExample example);

    int updateByExample(DmAgentMerchantSettingListPO record, DmAgentMerchantSettingListExample example);

    int updateByPrimaryKeySelective(DmAgentMerchantSettingListPO record);

    int updateByPrimaryKey(DmAgentMerchantSettingListPO record);
}