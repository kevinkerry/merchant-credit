package com.shengpay.debit.daointerface;

import com.shengpay.debit.dal.dataobject.DmMerchantCreditBaseInfoExample;
import com.shengpay.debit.dal.dataobject.DmMerchantCreditBaseInfoPO;
import java.util.List;
import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

public class DmMerchantCreditBaseInfoDAOImpl extends SqlMapClientDaoSupport implements DmMerchantCreditBaseInfoDAO {

    public DmMerchantCreditBaseInfoDAOImpl() {
        super();
    }

    public int countByExample(DmMerchantCreditBaseInfoExample example) {
        Integer count = (Integer)  getSqlMapClientTemplate().queryForObject("DM_MERCHANT_CREDIT_BASE_INFO.countByExample", example);
        return count;
    }

    public int deleteByExample(DmMerchantCreditBaseInfoExample example) {
        int rows = getSqlMapClientTemplate().delete("DM_MERCHANT_CREDIT_BASE_INFO.deleteByExample", example);
        return rows;
    }

    public int deleteByPrimaryKey(Long id) {
        DmMerchantCreditBaseInfoPO _key = new DmMerchantCreditBaseInfoPO();
        _key.setId(id);
        int rows = getSqlMapClientTemplate().delete("DM_MERCHANT_CREDIT_BASE_INFO.deleteByPrimaryKey", _key);
        return rows;
    }

    public Long insert(DmMerchantCreditBaseInfoPO record) {
        Object newKey = getSqlMapClientTemplate().insert("DM_MERCHANT_CREDIT_BASE_INFO.insert", record);
        return (Long) newKey;
    }

    public Long insertSelective(DmMerchantCreditBaseInfoPO record) {
        Object newKey = getSqlMapClientTemplate().insert("DM_MERCHANT_CREDIT_BASE_INFO.insertSelective", record);
        return (Long) newKey;
    }

    @SuppressWarnings("unchecked")
    public List<DmMerchantCreditBaseInfoPO> selectByExample(DmMerchantCreditBaseInfoExample example) {
        List<DmMerchantCreditBaseInfoPO> list = getSqlMapClientTemplate().queryForList("DM_MERCHANT_CREDIT_BASE_INFO.selectByExample", example);
        return list;
    }

    public DmMerchantCreditBaseInfoPO selectByPrimaryKey(Long id) {
        DmMerchantCreditBaseInfoPO _key = new DmMerchantCreditBaseInfoPO();
        _key.setId(id);
        DmMerchantCreditBaseInfoPO record = (DmMerchantCreditBaseInfoPO) getSqlMapClientTemplate().queryForObject("DM_MERCHANT_CREDIT_BASE_INFO.selectByPrimaryKey", _key);
        return record;
    }

    public int updateByExampleSelective(DmMerchantCreditBaseInfoPO record, DmMerchantCreditBaseInfoExample example) {
        UpdateByExampleParms parms = new UpdateByExampleParms(record, example);
        int rows = getSqlMapClientTemplate().update("DM_MERCHANT_CREDIT_BASE_INFO.updateByExampleSelective", parms);
        return rows;
    }

    public int updateByExample(DmMerchantCreditBaseInfoPO record, DmMerchantCreditBaseInfoExample example) {
        UpdateByExampleParms parms = new UpdateByExampleParms(record, example);
        int rows = getSqlMapClientTemplate().update("DM_MERCHANT_CREDIT_BASE_INFO.updateByExample", parms);
        return rows;
    }

    public int updateByPrimaryKeySelective(DmMerchantCreditBaseInfoPO record) {
        int rows = getSqlMapClientTemplate().update("DM_MERCHANT_CREDIT_BASE_INFO.updateByPrimaryKeySelective", record);
        return rows;
    }

    public int updateByPrimaryKey(DmMerchantCreditBaseInfoPO record) {
        int rows = getSqlMapClientTemplate().update("DM_MERCHANT_CREDIT_BASE_INFO.updateByPrimaryKey", record);
        return rows;
    }

    protected static class UpdateByExampleParms extends DmMerchantCreditBaseInfoExample {
        private Object record;

        public UpdateByExampleParms(Object record, DmMerchantCreditBaseInfoExample example) {
            super(example);
            this.record = record;
        }

        public Object getRecord() {
            return record;
        }
    }
}