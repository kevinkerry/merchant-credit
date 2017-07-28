package com.shengpay.debit.daointerface;

import com.shengpay.debit.dal.dataobject.DbRiskRequestLogExample;
import com.shengpay.debit.dal.dataobject.DbRiskRequestLogPO;
import java.util.List;
import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

public class DbRiskRequestLogDAOImpl extends SqlMapClientDaoSupport implements DbRiskRequestLogDAO {

    public DbRiskRequestLogDAOImpl() {
        super();
    }

    public int countByExample(DbRiskRequestLogExample example) {
        Integer count = (Integer)  getSqlMapClientTemplate().queryForObject("DB_RISK_REQUEST_LOG.countByExample", example);
        return count;
    }

    public int deleteByExample(DbRiskRequestLogExample example) {
        int rows = getSqlMapClientTemplate().delete("DB_RISK_REQUEST_LOG.deleteByExample", example);
        return rows;
    }

    public int deleteByPrimaryKey(Long id) {
        DbRiskRequestLogPO _key = new DbRiskRequestLogPO();
        _key.setId(id);
        int rows = getSqlMapClientTemplate().delete("DB_RISK_REQUEST_LOG.deleteByPrimaryKey", _key);
        return rows;
    }

    public Long insert(DbRiskRequestLogPO record) {
        Object newKey = getSqlMapClientTemplate().insert("DB_RISK_REQUEST_LOG.insert", record);
        return (Long) newKey;
    }

    public Long insertSelective(DbRiskRequestLogPO record) {
        Object newKey = getSqlMapClientTemplate().insert("DB_RISK_REQUEST_LOG.insertSelective", record);
        return (Long) newKey;
    }

    @SuppressWarnings("unchecked")
    public List<DbRiskRequestLogPO> selectByExample(DbRiskRequestLogExample example) {
        List<DbRiskRequestLogPO> list = getSqlMapClientTemplate().queryForList("DB_RISK_REQUEST_LOG.selectByExample", example);
        return list;
    }

    public DbRiskRequestLogPO selectByPrimaryKey(Long id) {
        DbRiskRequestLogPO _key = new DbRiskRequestLogPO();
        _key.setId(id);
        DbRiskRequestLogPO record = (DbRiskRequestLogPO) getSqlMapClientTemplate().queryForObject("DB_RISK_REQUEST_LOG.selectByPrimaryKey", _key);
        return record;
    }

    public int updateByExampleSelective(DbRiskRequestLogPO record, DbRiskRequestLogExample example) {
        UpdateByExampleParms parms = new UpdateByExampleParms(record, example);
        int rows = getSqlMapClientTemplate().update("DB_RISK_REQUEST_LOG.updateByExampleSelective", parms);
        return rows;
    }

    public int updateByExample(DbRiskRequestLogPO record, DbRiskRequestLogExample example) {
        UpdateByExampleParms parms = new UpdateByExampleParms(record, example);
        int rows = getSqlMapClientTemplate().update("DB_RISK_REQUEST_LOG.updateByExample", parms);
        return rows;
    }

    public int updateByPrimaryKeySelective(DbRiskRequestLogPO record) {
        int rows = getSqlMapClientTemplate().update("DB_RISK_REQUEST_LOG.updateByPrimaryKeySelective", record);
        return rows;
    }

    public int updateByPrimaryKey(DbRiskRequestLogPO record) {
        int rows = getSqlMapClientTemplate().update("DB_RISK_REQUEST_LOG.updateByPrimaryKey", record);
        return rows;
    }

    protected static class UpdateByExampleParms extends DbRiskRequestLogExample {
        private Object record;

        public UpdateByExampleParms(Object record, DbRiskRequestLogExample example) {
            super(example);
            this.record = record;
        }

        public Object getRecord() {
            return record;
        }
    }
}