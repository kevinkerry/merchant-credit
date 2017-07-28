package com.shengpay.debit.daointerface;

import com.shengpay.debit.dal.dataobject.DoMerchantDebitOrderExample;
import com.shengpay.debit.dal.dataobject.DoMerchantDebitOrderPO;
import java.util.List;
import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

public class DoMerchantDebitOrderDAOImpl extends SqlMapClientDaoSupport implements DoMerchantDebitOrderDAO {

    public DoMerchantDebitOrderDAOImpl() {
        super();
    }

    public int countByExample(DoMerchantDebitOrderExample example) {
        Integer count = (Integer)  getSqlMapClientTemplate().queryForObject("DO_MERCHANT_DEBIT_ORDER.countByExample", example);
        return count;
    }

    public int deleteByExample(DoMerchantDebitOrderExample example) {
        int rows = getSqlMapClientTemplate().delete("DO_MERCHANT_DEBIT_ORDER.deleteByExample", example);
        return rows;
    }

    public int deleteByPrimaryKey(Long id) {
        DoMerchantDebitOrderPO _key = new DoMerchantDebitOrderPO();
        _key.setId(id);
        int rows = getSqlMapClientTemplate().delete("DO_MERCHANT_DEBIT_ORDER.deleteByPrimaryKey", _key);
        return rows;
    }

    public Long insert(DoMerchantDebitOrderPO record) {
        Object newKey = getSqlMapClientTemplate().insert("DO_MERCHANT_DEBIT_ORDER.insert", record);
        return (Long) newKey;
    }

    public Long insertSelective(DoMerchantDebitOrderPO record) {
        Object newKey = getSqlMapClientTemplate().insert("DO_MERCHANT_DEBIT_ORDER.insertSelective", record);
        return (Long) newKey;
    }

    @SuppressWarnings("unchecked")
    public List<DoMerchantDebitOrderPO> selectByExample(DoMerchantDebitOrderExample example) {
        List<DoMerchantDebitOrderPO> list = getSqlMapClientTemplate().queryForList("DO_MERCHANT_DEBIT_ORDER.selectByExample", example);
        return list;
    }

    public DoMerchantDebitOrderPO selectByPrimaryKey(Long id) {
        DoMerchantDebitOrderPO _key = new DoMerchantDebitOrderPO();
        _key.setId(id);
        DoMerchantDebitOrderPO record = (DoMerchantDebitOrderPO) getSqlMapClientTemplate().queryForObject("DO_MERCHANT_DEBIT_ORDER.selectByPrimaryKey", _key);
        return record;
    }

    public int updateByExampleSelective(DoMerchantDebitOrderPO record, DoMerchantDebitOrderExample example) {
        UpdateByExampleParms parms = new UpdateByExampleParms(record, example);
        int rows = getSqlMapClientTemplate().update("DO_MERCHANT_DEBIT_ORDER.updateByExampleSelective", parms);
        return rows;
    }

    public int updateByExample(DoMerchantDebitOrderPO record, DoMerchantDebitOrderExample example) {
        UpdateByExampleParms parms = new UpdateByExampleParms(record, example);
        int rows = getSqlMapClientTemplate().update("DO_MERCHANT_DEBIT_ORDER.updateByExample", parms);
        return rows;
    }

    public int updateByPrimaryKeySelective(DoMerchantDebitOrderPO record) {
        int rows = getSqlMapClientTemplate().update("DO_MERCHANT_DEBIT_ORDER.updateByPrimaryKeySelective", record);
        return rows;
    }

    public int updateByPrimaryKey(DoMerchantDebitOrderPO record) {
        int rows = getSqlMapClientTemplate().update("DO_MERCHANT_DEBIT_ORDER.updateByPrimaryKey", record);
        return rows;
    }

    protected static class UpdateByExampleParms extends DoMerchantDebitOrderExample {
        private Object record;

        public UpdateByExampleParms(Object record, DoMerchantDebitOrderExample example) {
            super(example);
            this.record = record;
        }

        public Object getRecord() {
            return record;
        }
    }
}