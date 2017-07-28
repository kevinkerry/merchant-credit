package com.shengpay.debit.daointerface;

import com.shengpay.debit.dal.dataobject.DmMerchantDebitLogInfoExample;
import com.shengpay.debit.dal.dataobject.DmMerchantDebitLogInfoPO;
import java.util.List;
import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

public class DmMerchantDebitLogInfoDAOImpl extends SqlMapClientDaoSupport implements DmMerchantDebitLogInfoDAO {

    public DmMerchantDebitLogInfoDAOImpl() {
        super();
    }

    public int countByExample(DmMerchantDebitLogInfoExample example) {
        Integer count = (Integer)  getSqlMapClientTemplate().queryForObject("DM_MERCHANT_DEBIT_LOG_INFO.countByExample", example);
        return count;
    }

    public int deleteByExample(DmMerchantDebitLogInfoExample example) {
        int rows = getSqlMapClientTemplate().delete("DM_MERCHANT_DEBIT_LOG_INFO.deleteByExample", example);
        return rows;
    }

    public int deleteByPrimaryKey(Long id) {
        DmMerchantDebitLogInfoPO _key = new DmMerchantDebitLogInfoPO();
        _key.setId(id);
        int rows = getSqlMapClientTemplate().delete("DM_MERCHANT_DEBIT_LOG_INFO.deleteByPrimaryKey", _key);
        return rows;
    }

    public Long insert(DmMerchantDebitLogInfoPO record) {
        Object newKey = getSqlMapClientTemplate().insert("DM_MERCHANT_DEBIT_LOG_INFO.insert", record);
        return (Long) newKey;
    }

    public Long insertSelective(DmMerchantDebitLogInfoPO record) {
        Object newKey = getSqlMapClientTemplate().insert("DM_MERCHANT_DEBIT_LOG_INFO.insertSelective", record);
        return (Long) newKey;
    }

    @SuppressWarnings("unchecked")
    public List<DmMerchantDebitLogInfoPO> selectByExample(DmMerchantDebitLogInfoExample example) {
        List<DmMerchantDebitLogInfoPO> list = getSqlMapClientTemplate().queryForList("DM_MERCHANT_DEBIT_LOG_INFO.selectByExample", example);
        return list;
    }

    public DmMerchantDebitLogInfoPO selectByPrimaryKey(Long id) {
        DmMerchantDebitLogInfoPO _key = new DmMerchantDebitLogInfoPO();
        _key.setId(id);
        DmMerchantDebitLogInfoPO record = (DmMerchantDebitLogInfoPO) getSqlMapClientTemplate().queryForObject("DM_MERCHANT_DEBIT_LOG_INFO.selectByPrimaryKey", _key);
        return record;
    }

    public int updateByExampleSelective(DmMerchantDebitLogInfoPO record, DmMerchantDebitLogInfoExample example) {
        UpdateByExampleParms parms = new UpdateByExampleParms(record, example);
        int rows = getSqlMapClientTemplate().update("DM_MERCHANT_DEBIT_LOG_INFO.updateByExampleSelective", parms);
        return rows;
    }

    public int updateByExample(DmMerchantDebitLogInfoPO record, DmMerchantDebitLogInfoExample example) {
        UpdateByExampleParms parms = new UpdateByExampleParms(record, example);
        int rows = getSqlMapClientTemplate().update("DM_MERCHANT_DEBIT_LOG_INFO.updateByExample", parms);
        return rows;
    }

    public int updateByPrimaryKeySelective(DmMerchantDebitLogInfoPO record) {
        int rows = getSqlMapClientTemplate().update("DM_MERCHANT_DEBIT_LOG_INFO.updateByPrimaryKeySelective", record);
        return rows;
    }

    public int updateByPrimaryKey(DmMerchantDebitLogInfoPO record) {
        int rows = getSqlMapClientTemplate().update("DM_MERCHANT_DEBIT_LOG_INFO.updateByPrimaryKey", record);
        return rows;
    }

    protected static class UpdateByExampleParms extends DmMerchantDebitLogInfoExample {
        private Object record;

        public UpdateByExampleParms(Object record, DmMerchantDebitLogInfoExample example) {
            super(example);
            this.record = record;
        }

        public Object getRecord() {
            return record;
        }
    }
}