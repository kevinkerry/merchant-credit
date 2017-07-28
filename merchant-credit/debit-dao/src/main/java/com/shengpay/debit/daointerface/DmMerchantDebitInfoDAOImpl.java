package com.shengpay.debit.daointerface;

import com.shengpay.debit.dal.dataobject.DmMerchantDebitInfoExample;
import com.shengpay.debit.dal.dataobject.DmMerchantDebitInfoPO;
import java.util.List;
import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

public class DmMerchantDebitInfoDAOImpl extends SqlMapClientDaoSupport implements DmMerchantDebitInfoDAO {

    public DmMerchantDebitInfoDAOImpl() {
        super();
    }

    public int countByExample(DmMerchantDebitInfoExample example) {
        Integer count = (Integer)  getSqlMapClientTemplate().queryForObject("DM_MERCHANT_DEBIT_INFO.countByExample", example);
        return count;
    }

    public int deleteByExample(DmMerchantDebitInfoExample example) {
        int rows = getSqlMapClientTemplate().delete("DM_MERCHANT_DEBIT_INFO.deleteByExample", example);
        return rows;
    }

    public int deleteByPrimaryKey(Long id) {
        DmMerchantDebitInfoPO _key = new DmMerchantDebitInfoPO();
        _key.setId(id);
        int rows = getSqlMapClientTemplate().delete("DM_MERCHANT_DEBIT_INFO.deleteByPrimaryKey", _key);
        return rows;
    }

    public Long insert(DmMerchantDebitInfoPO record) {
        Object newKey = getSqlMapClientTemplate().insert("DM_MERCHANT_DEBIT_INFO.insert", record);
        return (Long) newKey;
    }

    public Long insertSelective(DmMerchantDebitInfoPO record) {
        Object newKey = getSqlMapClientTemplate().insert("DM_MERCHANT_DEBIT_INFO.insertSelective", record);
        return (Long) newKey;
    }

    @SuppressWarnings("unchecked")
    public List<DmMerchantDebitInfoPO> selectByExample(DmMerchantDebitInfoExample example) {
        List<DmMerchantDebitInfoPO> list = getSqlMapClientTemplate().queryForList("DM_MERCHANT_DEBIT_INFO.selectByExample", example);
        return list;
    }

    public DmMerchantDebitInfoPO selectByPrimaryKey(Long id) {
        DmMerchantDebitInfoPO _key = new DmMerchantDebitInfoPO();
        _key.setId(id);
        DmMerchantDebitInfoPO record = (DmMerchantDebitInfoPO) getSqlMapClientTemplate().queryForObject("DM_MERCHANT_DEBIT_INFO.selectByPrimaryKey", _key);
        return record;
    }

    public int updateByExampleSelective(DmMerchantDebitInfoPO record, DmMerchantDebitInfoExample example) {
        UpdateByExampleParms parms = new UpdateByExampleParms(record, example);
        int rows = getSqlMapClientTemplate().update("DM_MERCHANT_DEBIT_INFO.updateByExampleSelective", parms);
        return rows;
    }

    public int updateByExample(DmMerchantDebitInfoPO record, DmMerchantDebitInfoExample example) {
        UpdateByExampleParms parms = new UpdateByExampleParms(record, example);
        int rows = getSqlMapClientTemplate().update("DM_MERCHANT_DEBIT_INFO.updateByExample", parms);
        return rows;
    }

    public int updateByPrimaryKeySelective(DmMerchantDebitInfoPO record) {
        int rows = getSqlMapClientTemplate().update("DM_MERCHANT_DEBIT_INFO.updateByPrimaryKeySelective", record);
        return rows;
    }

    public int updateByPrimaryKey(DmMerchantDebitInfoPO record) {
        int rows = getSqlMapClientTemplate().update("DM_MERCHANT_DEBIT_INFO.updateByPrimaryKey", record);
        return rows;
    }

    protected static class UpdateByExampleParms extends DmMerchantDebitInfoExample {
        private Object record;

        public UpdateByExampleParms(Object record, DmMerchantDebitInfoExample example) {
            super(example);
            this.record = record;
        }

        public Object getRecord() {
            return record;
        }
    }
}