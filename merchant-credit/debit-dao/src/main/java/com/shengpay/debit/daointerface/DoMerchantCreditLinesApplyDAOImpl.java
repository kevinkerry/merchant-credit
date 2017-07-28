package com.shengpay.debit.daointerface;

import com.shengpay.debit.dal.dataobject.DoMerchantCreditLinesApplyExample;
import com.shengpay.debit.dal.dataobject.DoMerchantCreditLinesApplyPO;
import java.util.List;
import java.util.Map;

import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

public class DoMerchantCreditLinesApplyDAOImpl extends SqlMapClientDaoSupport implements DoMerchantCreditLinesApplyDAO {

    public DoMerchantCreditLinesApplyDAOImpl() {
        super();
    }

    public int countByExample(DoMerchantCreditLinesApplyExample example) {
        Integer count = (Integer)  getSqlMapClientTemplate().queryForObject("DO_MERCHANT_CREDIT_LINES_APPLY.countByExample", example);
        return count;
    }

    public int deleteByExample(DoMerchantCreditLinesApplyExample example) {
        int rows = getSqlMapClientTemplate().delete("DO_MERCHANT_CREDIT_LINES_APPLY.deleteByExample", example);
        return rows;
    }

    public int deleteByPrimaryKey(Long id) {
        DoMerchantCreditLinesApplyPO _key = new DoMerchantCreditLinesApplyPO();
        _key.setId(id);
        int rows = getSqlMapClientTemplate().delete("DO_MERCHANT_CREDIT_LINES_APPLY.deleteByPrimaryKey", _key);
        return rows;
    }

    public Long insert(DoMerchantCreditLinesApplyPO record) {
        Object newKey = getSqlMapClientTemplate().insert("DO_MERCHANT_CREDIT_LINES_APPLY.insert", record);
        return (Long) newKey;
    }

    public Long insertSelective(DoMerchantCreditLinesApplyPO record) {
        Object newKey = getSqlMapClientTemplate().insert("DO_MERCHANT_CREDIT_LINES_APPLY.insertSelective", record);
        return (Long) newKey;
    }

    @SuppressWarnings("unchecked")
    public List<DoMerchantCreditLinesApplyPO> selectByExample(DoMerchantCreditLinesApplyExample example) {
        List<DoMerchantCreditLinesApplyPO> list = getSqlMapClientTemplate().queryForList("DO_MERCHANT_CREDIT_LINES_APPLY.selectByExample", example);
        return list;
    }

    public DoMerchantCreditLinesApplyPO selectByPrimaryKey(Long id) {
        DoMerchantCreditLinesApplyPO _key = new DoMerchantCreditLinesApplyPO();
        _key.setId(id);
        DoMerchantCreditLinesApplyPO record = (DoMerchantCreditLinesApplyPO) getSqlMapClientTemplate().queryForObject("DO_MERCHANT_CREDIT_LINES_APPLY.selectByPrimaryKey", _key);
        return record;
    }

    public int updateByExampleSelective(DoMerchantCreditLinesApplyPO record, DoMerchantCreditLinesApplyExample example) {
        UpdateByExampleParms parms = new UpdateByExampleParms(record, example);
        int rows = getSqlMapClientTemplate().update("DO_MERCHANT_CREDIT_LINES_APPLY.updateByExampleSelective", parms);
        return rows;
    }

    public int updateByExample(DoMerchantCreditLinesApplyPO record, DoMerchantCreditLinesApplyExample example) {
        UpdateByExampleParms parms = new UpdateByExampleParms(record, example);
        int rows = getSqlMapClientTemplate().update("DO_MERCHANT_CREDIT_LINES_APPLY.updateByExample", parms);
        return rows;
    }

    public int updateByPrimaryKeySelective(DoMerchantCreditLinesApplyPO record) {
        int rows = getSqlMapClientTemplate().update("DO_MERCHANT_CREDIT_LINES_APPLY.updateByPrimaryKeySelective", record);
        return rows;
    }

    public int updateByPrimaryKey(DoMerchantCreditLinesApplyPO record) {
        int rows = getSqlMapClientTemplate().update("DO_MERCHANT_CREDIT_LINES_APPLY.updateByPrimaryKey", record);
        return rows;
    }

    protected static class UpdateByExampleParms extends DoMerchantCreditLinesApplyExample {
        private Object record;

        public UpdateByExampleParms(Object record, DoMerchantCreditLinesApplyExample example) {
            super(example);
            this.record = record;
        }

        public Object getRecord() {
            return record;
        }
    }

	@Override
	public void updateMerchantCreditLineStatusJob(Map<String, Object> map) {
		getSqlMapClientTemplate().update("DO_MERCHANT_CREDIT_LINES_APPLY.updateMerchantCreditLineStatusJob", map);

	}
}