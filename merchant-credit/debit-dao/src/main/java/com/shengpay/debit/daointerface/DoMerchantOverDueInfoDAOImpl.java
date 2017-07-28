package com.shengpay.debit.daointerface;

import com.shengpay.debit.dal.dataobject.DoMerchantOverDueInfoExample;
import com.shengpay.debit.dal.dataobject.DoMerchantOverDueInfoPO;
import java.util.List;
import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

public class DoMerchantOverDueInfoDAOImpl extends SqlMapClientDaoSupport implements DoMerchantOverDueInfoDAO {

    public DoMerchantOverDueInfoDAOImpl() {
        super();
    }

    public int countByExample(DoMerchantOverDueInfoExample example) {
        Integer count = (Integer)  getSqlMapClientTemplate().queryForObject("DO_MERCHANT_OVER_DUE_INFO.countByExample", example);
        return count;
    }

    public int deleteByExample(DoMerchantOverDueInfoExample example) {
        int rows = getSqlMapClientTemplate().delete("DO_MERCHANT_OVER_DUE_INFO.deleteByExample", example);
        return rows;
    }

    public int deleteByPrimaryKey(Long id) {
        DoMerchantOverDueInfoPO _key = new DoMerchantOverDueInfoPO();
        _key.setId(id);
        int rows = getSqlMapClientTemplate().delete("DO_MERCHANT_OVER_DUE_INFO.deleteByPrimaryKey", _key);
        return rows;
    }

    public Long insert(DoMerchantOverDueInfoPO record) {
        Object newKey = getSqlMapClientTemplate().insert("DO_MERCHANT_OVER_DUE_INFO.insert", record);
        return (Long) newKey;
    }

    public Long insertSelective(DoMerchantOverDueInfoPO record) {
        Object newKey = getSqlMapClientTemplate().insert("DO_MERCHANT_OVER_DUE_INFO.insertSelective", record);
        return (Long) newKey;
    }

    @SuppressWarnings("unchecked")
    public List<DoMerchantOverDueInfoPO> selectByExample(DoMerchantOverDueInfoExample example) {
        List<DoMerchantOverDueInfoPO> list = getSqlMapClientTemplate().queryForList("DO_MERCHANT_OVER_DUE_INFO.selectByExample", example);
        return list;
    }

    public DoMerchantOverDueInfoPO selectByPrimaryKey(Long id) {
        DoMerchantOverDueInfoPO _key = new DoMerchantOverDueInfoPO();
        _key.setId(id);
        DoMerchantOverDueInfoPO record = (DoMerchantOverDueInfoPO) getSqlMapClientTemplate().queryForObject("DO_MERCHANT_OVER_DUE_INFO.selectByPrimaryKey", _key);
        return record;
    }

    public int updateByExampleSelective(DoMerchantOverDueInfoPO record, DoMerchantOverDueInfoExample example) {
        UpdateByExampleParms parms = new UpdateByExampleParms(record, example);
        int rows = getSqlMapClientTemplate().update("DO_MERCHANT_OVER_DUE_INFO.updateByExampleSelective", parms);
        return rows;
    }

    public int updateByExample(DoMerchantOverDueInfoPO record, DoMerchantOverDueInfoExample example) {
        UpdateByExampleParms parms = new UpdateByExampleParms(record, example);
        int rows = getSqlMapClientTemplate().update("DO_MERCHANT_OVER_DUE_INFO.updateByExample", parms);
        return rows;
    }

    public int updateByPrimaryKeySelective(DoMerchantOverDueInfoPO record) {
        int rows = getSqlMapClientTemplate().update("DO_MERCHANT_OVER_DUE_INFO.updateByPrimaryKeySelective", record);
        return rows;
    }

    public int updateByPrimaryKey(DoMerchantOverDueInfoPO record) {
        int rows = getSqlMapClientTemplate().update("DO_MERCHANT_OVER_DUE_INFO.updateByPrimaryKey", record);
        return rows;
    }

    protected static class UpdateByExampleParms extends DoMerchantOverDueInfoExample {
        private Object record;

        public UpdateByExampleParms(Object record, DoMerchantOverDueInfoExample example) {
            super(example);
            this.record = record;
        }

        public Object getRecord() {
            return record;
        }
    }
}