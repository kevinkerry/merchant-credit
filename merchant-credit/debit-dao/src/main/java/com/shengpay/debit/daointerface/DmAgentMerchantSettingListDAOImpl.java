package com.shengpay.debit.daointerface;

import com.shengpay.debit.dal.dataobject.DmAgentMerchantSettingListExample;
import com.shengpay.debit.dal.dataobject.DmAgentMerchantSettingListPO;
import java.util.List;
import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

public class DmAgentMerchantSettingListDAOImpl extends SqlMapClientDaoSupport implements DmAgentMerchantSettingListDAO {

    public DmAgentMerchantSettingListDAOImpl() {
        super();
    }

    public int countByExample(DmAgentMerchantSettingListExample example) {
        Integer count = (Integer)  getSqlMapClientTemplate().queryForObject("DM_AGENT_MERCHANT_SETTING_LIST.countByExample", example);
        return count;
    }

    public int deleteByExample(DmAgentMerchantSettingListExample example) {
        int rows = getSqlMapClientTemplate().delete("DM_AGENT_MERCHANT_SETTING_LIST.deleteByExample", example);
        return rows;
    }

    public int deleteByPrimaryKey(Long id) {
        DmAgentMerchantSettingListPO _key = new DmAgentMerchantSettingListPO();
        _key.setId(id);
        int rows = getSqlMapClientTemplate().delete("DM_AGENT_MERCHANT_SETTING_LIST.deleteByPrimaryKey", _key);
        return rows;
    }

    public Long insert(DmAgentMerchantSettingListPO record) {
        Object newKey = getSqlMapClientTemplate().insert("DM_AGENT_MERCHANT_SETTING_LIST.insert", record);
        return (Long) newKey;
    }

    public Long insertSelective(DmAgentMerchantSettingListPO record) {
        Object newKey = getSqlMapClientTemplate().insert("DM_AGENT_MERCHANT_SETTING_LIST.insertSelective", record);
        return (Long) newKey;
    }

    @SuppressWarnings("unchecked")
    public List<DmAgentMerchantSettingListPO> selectByExample(DmAgentMerchantSettingListExample example) {
        List<DmAgentMerchantSettingListPO> list = getSqlMapClientTemplate().queryForList("DM_AGENT_MERCHANT_SETTING_LIST.selectByExample", example);
        return list;
    }

    public DmAgentMerchantSettingListPO selectByPrimaryKey(Long id) {
        DmAgentMerchantSettingListPO _key = new DmAgentMerchantSettingListPO();
        _key.setId(id);
        DmAgentMerchantSettingListPO record = (DmAgentMerchantSettingListPO) getSqlMapClientTemplate().queryForObject("DM_AGENT_MERCHANT_SETTING_LIST.selectByPrimaryKey", _key);
        return record;
    }

    public int updateByExampleSelective(DmAgentMerchantSettingListPO record, DmAgentMerchantSettingListExample example) {
        UpdateByExampleParms parms = new UpdateByExampleParms(record, example);
        int rows = getSqlMapClientTemplate().update("DM_AGENT_MERCHANT_SETTING_LIST.updateByExampleSelective", parms);
        return rows;
    }

    public int updateByExample(DmAgentMerchantSettingListPO record, DmAgentMerchantSettingListExample example) {
        UpdateByExampleParms parms = new UpdateByExampleParms(record, example);
        int rows = getSqlMapClientTemplate().update("DM_AGENT_MERCHANT_SETTING_LIST.updateByExample", parms);
        return rows;
    }

    public int updateByPrimaryKeySelective(DmAgentMerchantSettingListPO record) {
        int rows = getSqlMapClientTemplate().update("DM_AGENT_MERCHANT_SETTING_LIST.updateByPrimaryKeySelective", record);
        return rows;
    }

    public int updateByPrimaryKey(DmAgentMerchantSettingListPO record) {
        int rows = getSqlMapClientTemplate().update("DM_AGENT_MERCHANT_SETTING_LIST.updateByPrimaryKey", record);
        return rows;
    }

    protected static class UpdateByExampleParms extends DmAgentMerchantSettingListExample {
        private Object record;

        public UpdateByExampleParms(Object record, DmAgentMerchantSettingListExample example) {
            super(example);
            this.record = record;
        }

        public Object getRecord() {
            return record;
        }
    }
}