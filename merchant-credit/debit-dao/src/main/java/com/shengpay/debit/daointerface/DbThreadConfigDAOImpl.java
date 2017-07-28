package com.shengpay.debit.daointerface;

import com.shengpay.debit.dal.dataobject.DbThreadConfigExample;
import com.shengpay.debit.dal.dataobject.DbThreadConfigPO;
import java.util.List;
import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

public class DbThreadConfigDAOImpl extends SqlMapClientDaoSupport implements DbThreadConfigDAO {

    public DbThreadConfigDAOImpl() {
        super();
    }

    public int countByExample(DbThreadConfigExample example) {
        Integer count = (Integer)  getSqlMapClientTemplate().queryForObject("DB_THREAD_CONFIG.countByExample", example);
        return count;
    }

    public int deleteByExample(DbThreadConfigExample example) {
        int rows = getSqlMapClientTemplate().delete("DB_THREAD_CONFIG.deleteByExample", example);
        return rows;
    }

    public int deleteByPrimaryKey(Long id) {
        DbThreadConfigPO _key = new DbThreadConfigPO();
        _key.setId(id);
        int rows = getSqlMapClientTemplate().delete("DB_THREAD_CONFIG.deleteByPrimaryKey", _key);
        return rows;
    }

    public Long insert(DbThreadConfigPO record) {
        Object newKey = getSqlMapClientTemplate().insert("DB_THREAD_CONFIG.insert", record);
        return (Long) newKey;
    }

    public Long insertSelective(DbThreadConfigPO record) {
        Object newKey = getSqlMapClientTemplate().insert("DB_THREAD_CONFIG.insertSelective", record);
        return (Long) newKey;
    }

    @SuppressWarnings("unchecked")
    public List<DbThreadConfigPO> selectByExample(DbThreadConfigExample example) {
        List<DbThreadConfigPO> list = getSqlMapClientTemplate().queryForList("DB_THREAD_CONFIG.selectByExample", example);
        return list;
    }

    public DbThreadConfigPO selectByPrimaryKey(Long id) {
        DbThreadConfigPO _key = new DbThreadConfigPO();
        _key.setId(id);
        DbThreadConfigPO record = (DbThreadConfigPO) getSqlMapClientTemplate().queryForObject("DB_THREAD_CONFIG.selectByPrimaryKey", _key);
        return record;
    }

    public int updateByExampleSelective(DbThreadConfigPO record, DbThreadConfigExample example) {
        UpdateByExampleParms parms = new UpdateByExampleParms(record, example);
        int rows = getSqlMapClientTemplate().update("DB_THREAD_CONFIG.updateByExampleSelective", parms);
        return rows;
    }

    public int updateByExample(DbThreadConfigPO record, DbThreadConfigExample example) {
        UpdateByExampleParms parms = new UpdateByExampleParms(record, example);
        int rows = getSqlMapClientTemplate().update("DB_THREAD_CONFIG.updateByExample", parms);
        return rows;
    }

    public int updateByPrimaryKeySelective(DbThreadConfigPO record) {
        int rows = getSqlMapClientTemplate().update("DB_THREAD_CONFIG.updateByPrimaryKeySelective", record);
        return rows;
    }

    public int updateByPrimaryKey(DbThreadConfigPO record) {
        int rows = getSqlMapClientTemplate().update("DB_THREAD_CONFIG.updateByPrimaryKey", record);
        return rows;
    }

    protected static class UpdateByExampleParms extends DbThreadConfigExample {
        private Object record;

        public UpdateByExampleParms(Object record, DbThreadConfigExample example) {
            super(example);
            this.record = record;
        }

        public Object getRecord() {
            return record;
        }
    }
}