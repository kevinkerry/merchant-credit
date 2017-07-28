package com.shengpay.debit.daointerface;

import com.shengpay.debit.dal.dataobject.TbWithholdingTransLogExample;
import com.shengpay.debit.dal.dataobject.TbWithholdingTransLogPO;
import java.util.List;
import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

public class TbWithholdingTransLogDAOImpl extends SqlMapClientDaoSupport implements TbWithholdingTransLogDAO {

    public TbWithholdingTransLogDAOImpl() {
        super();
    }

    public int countByExample(TbWithholdingTransLogExample example) {
        Integer count = (Integer)  getSqlMapClientTemplate().queryForObject("TB_WITHHOLDING_TRANS_LOG.countByExample", example);
        return count;
    }

    public int deleteByExample(TbWithholdingTransLogExample example) {
        int rows = getSqlMapClientTemplate().delete("TB_WITHHOLDING_TRANS_LOG.deleteByExample", example);
        return rows;
    }

    public int deleteByPrimaryKey(Long id) {
        TbWithholdingTransLogPO _key = new TbWithholdingTransLogPO();
        _key.setId(id);
        int rows = getSqlMapClientTemplate().delete("TB_WITHHOLDING_TRANS_LOG.deleteByPrimaryKey", _key);
        return rows;
    }

    public Long insert(TbWithholdingTransLogPO record) {
        Object newKey = getSqlMapClientTemplate().insert("TB_WITHHOLDING_TRANS_LOG.insert", record);
        return (Long) newKey;
    }

    public Long insertSelective(TbWithholdingTransLogPO record) {
        Object newKey = getSqlMapClientTemplate().insert("TB_WITHHOLDING_TRANS_LOG.insertSelective", record);
        return (Long) newKey;
    }

    @SuppressWarnings("unchecked")
    public List<TbWithholdingTransLogPO> selectByExample(TbWithholdingTransLogExample example) {
        List<TbWithholdingTransLogPO> list = getSqlMapClientTemplate().queryForList("TB_WITHHOLDING_TRANS_LOG.selectByExample", example);
        return list;
    }

    public TbWithholdingTransLogPO selectByPrimaryKey(Long id) {
        TbWithholdingTransLogPO _key = new TbWithholdingTransLogPO();
        _key.setId(id);
        TbWithholdingTransLogPO record = (TbWithholdingTransLogPO) getSqlMapClientTemplate().queryForObject("TB_WITHHOLDING_TRANS_LOG.selectByPrimaryKey", _key);
        return record;
    }

    public int updateByExampleSelective(TbWithholdingTransLogPO record, TbWithholdingTransLogExample example) {
        UpdateByExampleParms parms = new UpdateByExampleParms(record, example);
        int rows = getSqlMapClientTemplate().update("TB_WITHHOLDING_TRANS_LOG.updateByExampleSelective", parms);
        return rows;
    }

    public int updateByExample(TbWithholdingTransLogPO record, TbWithholdingTransLogExample example) {
        UpdateByExampleParms parms = new UpdateByExampleParms(record, example);
        int rows = getSqlMapClientTemplate().update("TB_WITHHOLDING_TRANS_LOG.updateByExample", parms);
        return rows;
    }

    public int updateByPrimaryKeySelective(TbWithholdingTransLogPO record) {
        int rows = getSqlMapClientTemplate().update("TB_WITHHOLDING_TRANS_LOG.updateByPrimaryKeySelective", record);
        return rows;
    }

    public int updateByPrimaryKey(TbWithholdingTransLogPO record) {
        int rows = getSqlMapClientTemplate().update("TB_WITHHOLDING_TRANS_LOG.updateByPrimaryKey", record);
        return rows;
    }

    protected static class UpdateByExampleParms extends TbWithholdingTransLogExample {
        private Object record;

        public UpdateByExampleParms(Object record, TbWithholdingTransLogExample example) {
            super(example);
            this.record = record;
        }

        public Object getRecord() {
            return record;
        }
    }
}