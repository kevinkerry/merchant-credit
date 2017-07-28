package com.shengpay.debit.daointerface;

import com.shengpay.debit.dal.dataobject.DoMeCreditLinesApplyInfoExample;
import com.shengpay.debit.dal.dataobject.DoMeCreditLinesApplyInfoPO;
import java.util.List;
import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

public class DoMeCreditLinesApplyInfoDAOImpl extends SqlMapClientDaoSupport implements DoMeCreditLinesApplyInfoDAO {

    public DoMeCreditLinesApplyInfoDAOImpl() {
        super();
    }

    public int countByExample(DoMeCreditLinesApplyInfoExample example) {
        Integer count = (Integer)  getSqlMapClientTemplate().queryForObject("DO_ME_CREDIT_LINES_APPLY_INFO.countByExample", example);
        return count;
    }

    public int deleteByExample(DoMeCreditLinesApplyInfoExample example) {
        int rows = getSqlMapClientTemplate().delete("DO_ME_CREDIT_LINES_APPLY_INFO.deleteByExample", example);
        return rows;
    }

    public int deleteByPrimaryKey(Long id) {
        DoMeCreditLinesApplyInfoPO _key = new DoMeCreditLinesApplyInfoPO();
        _key.setId(id);
        int rows = getSqlMapClientTemplate().delete("DO_ME_CREDIT_LINES_APPLY_INFO.deleteByPrimaryKey", _key);
        return rows;
    }

    public Long insert(DoMeCreditLinesApplyInfoPO record) {
        Object newKey = getSqlMapClientTemplate().insert("DO_ME_CREDIT_LINES_APPLY_INFO.insert", record);
        return (Long) newKey;
    }

    public Long insertSelective(DoMeCreditLinesApplyInfoPO record) {
        Object newKey = getSqlMapClientTemplate().insert("DO_ME_CREDIT_LINES_APPLY_INFO.insertSelective", record);
        return (Long) newKey;
    }

    @SuppressWarnings("unchecked")
    public List<DoMeCreditLinesApplyInfoPO> selectByExample(DoMeCreditLinesApplyInfoExample example) {
        List<DoMeCreditLinesApplyInfoPO> list = getSqlMapClientTemplate().queryForList("DO_ME_CREDIT_LINES_APPLY_INFO.selectByExample", example);
        return list;
    }

    public DoMeCreditLinesApplyInfoPO selectByPrimaryKey(Long id) {
        DoMeCreditLinesApplyInfoPO _key = new DoMeCreditLinesApplyInfoPO();
        _key.setId(id);
        DoMeCreditLinesApplyInfoPO record = (DoMeCreditLinesApplyInfoPO) getSqlMapClientTemplate().queryForObject("DO_ME_CREDIT_LINES_APPLY_INFO.selectByPrimaryKey", _key);
        return record;
    }

    public int updateByExampleSelective(DoMeCreditLinesApplyInfoPO record, DoMeCreditLinesApplyInfoExample example) {
        UpdateByExampleParms parms = new UpdateByExampleParms(record, example);
        int rows = getSqlMapClientTemplate().update("DO_ME_CREDIT_LINES_APPLY_INFO.updateByExampleSelective", parms);
        return rows;
    }

    public int updateByExample(DoMeCreditLinesApplyInfoPO record, DoMeCreditLinesApplyInfoExample example) {
        UpdateByExampleParms parms = new UpdateByExampleParms(record, example);
        int rows = getSqlMapClientTemplate().update("DO_ME_CREDIT_LINES_APPLY_INFO.updateByExample", parms);
        return rows;
    }

    public int updateByPrimaryKeySelective(DoMeCreditLinesApplyInfoPO record) {
        int rows = getSqlMapClientTemplate().update("DO_ME_CREDIT_LINES_APPLY_INFO.updateByPrimaryKeySelective", record);
        return rows;
    }

    public int updateByPrimaryKey(DoMeCreditLinesApplyInfoPO record) {
        int rows = getSqlMapClientTemplate().update("DO_ME_CREDIT_LINES_APPLY_INFO.updateByPrimaryKey", record);
        return rows;
    }

    protected static class UpdateByExampleParms extends DoMeCreditLinesApplyInfoExample {
        private Object record;

        public UpdateByExampleParms(Object record, DoMeCreditLinesApplyInfoExample example) {
            super(example);
            this.record = record;
        }

        public Object getRecord() {
            return record;
        }
    }
}