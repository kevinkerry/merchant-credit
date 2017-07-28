package com.shengpay.debit.daointerface;

import com.shengpay.debit.dal.dataobject.DoMerchantApplyFailLogExample;
import com.shengpay.debit.dal.dataobject.DoMerchantApplyFailLogPO;
import java.util.List;
import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

public class DoMerchantApplyFailLogDAOImpl extends SqlMapClientDaoSupport implements DoMerchantApplyFailLogDAO {

    public DoMerchantApplyFailLogDAOImpl() {
        super();
    }

    public int countByExample(DoMerchantApplyFailLogExample example) {
        Integer count = (Integer)  getSqlMapClientTemplate().queryForObject("DO_MERCHANT_APPLY_FAIL_LOG.countByExample", example);
        return count;
    }

    public int deleteByExample(DoMerchantApplyFailLogExample example) {
        int rows = getSqlMapClientTemplate().delete("DO_MERCHANT_APPLY_FAIL_LOG.deleteByExample", example);
        return rows;
    }

    public int deleteByPrimaryKey(Long id) {
        DoMerchantApplyFailLogPO _key = new DoMerchantApplyFailLogPO();
        _key.setId(id);
        int rows = getSqlMapClientTemplate().delete("DO_MERCHANT_APPLY_FAIL_LOG.deleteByPrimaryKey", _key);
        return rows;
    }

    public Long insert(DoMerchantApplyFailLogPO record) {
        Object newKey = getSqlMapClientTemplate().insert("DO_MERCHANT_APPLY_FAIL_LOG.insert", record);
        return (Long) newKey;
    }

    public Long insertSelective(DoMerchantApplyFailLogPO record) {
        Object newKey = getSqlMapClientTemplate().insert("DO_MERCHANT_APPLY_FAIL_LOG.insertSelective", record);
        return (Long) newKey;
    }

    @SuppressWarnings("unchecked")
    public List<DoMerchantApplyFailLogPO> selectByExample(DoMerchantApplyFailLogExample example) {
        List<DoMerchantApplyFailLogPO> list = getSqlMapClientTemplate().queryForList("DO_MERCHANT_APPLY_FAIL_LOG.selectByExample", example);
        return list;
    }

    public DoMerchantApplyFailLogPO selectByPrimaryKey(Long id) {
        DoMerchantApplyFailLogPO _key = new DoMerchantApplyFailLogPO();
        _key.setId(id);
        DoMerchantApplyFailLogPO record = (DoMerchantApplyFailLogPO) getSqlMapClientTemplate().queryForObject("DO_MERCHANT_APPLY_FAIL_LOG.selectByPrimaryKey", _key);
        return record;
    }

    public int updateByExampleSelective(DoMerchantApplyFailLogPO record, DoMerchantApplyFailLogExample example) {
        UpdateByExampleParms parms = new UpdateByExampleParms(record, example);
        int rows = getSqlMapClientTemplate().update("DO_MERCHANT_APPLY_FAIL_LOG.updateByExampleSelective", parms);
        return rows;
    }

    public int updateByExample(DoMerchantApplyFailLogPO record, DoMerchantApplyFailLogExample example) {
        UpdateByExampleParms parms = new UpdateByExampleParms(record, example);
        int rows = getSqlMapClientTemplate().update("DO_MERCHANT_APPLY_FAIL_LOG.updateByExample", parms);
        return rows;
    }

    public int updateByPrimaryKeySelective(DoMerchantApplyFailLogPO record) {
        int rows = getSqlMapClientTemplate().update("DO_MERCHANT_APPLY_FAIL_LOG.updateByPrimaryKeySelective", record);
        return rows;
    }

    public int updateByPrimaryKey(DoMerchantApplyFailLogPO record) {
        int rows = getSqlMapClientTemplate().update("DO_MERCHANT_APPLY_FAIL_LOG.updateByPrimaryKey", record);
        return rows;
    }

    protected static class UpdateByExampleParms extends DoMerchantApplyFailLogExample {
        private Object record;

        public UpdateByExampleParms(Object record, DoMerchantApplyFailLogExample example) {
            super(example);
            this.record = record;
        }

        public Object getRecord() {
            return record;
        }
    }
}