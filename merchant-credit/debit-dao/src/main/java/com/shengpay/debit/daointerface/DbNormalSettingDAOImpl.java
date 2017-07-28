package com.shengpay.debit.daointerface;

import com.shengpay.debit.dal.dataobject.DbNormalSettingExample;
import com.shengpay.debit.dal.dataobject.DbNormalSettingPO;
import java.util.List;
import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

public class DbNormalSettingDAOImpl extends SqlMapClientDaoSupport implements DbNormalSettingDAO {

    public DbNormalSettingDAOImpl() {
        super();
    }

    public int countByExample(DbNormalSettingExample example) {
        Integer count = (Integer)  getSqlMapClientTemplate().queryForObject("DB_NORMAL_SETTING.countByExample", example);
        return count;
    }

    public int deleteByExample(DbNormalSettingExample example) {
        int rows = getSqlMapClientTemplate().delete("DB_NORMAL_SETTING.deleteByExample", example);
        return rows;
    }

    public int deleteByPrimaryKey(Long id) {
        DbNormalSettingPO _key = new DbNormalSettingPO();
        _key.setId(id);
        int rows = getSqlMapClientTemplate().delete("DB_NORMAL_SETTING.deleteByPrimaryKey", _key);
        return rows;
    }

    public Long insert(DbNormalSettingPO record) {
        Object newKey = getSqlMapClientTemplate().insert("DB_NORMAL_SETTING.insert", record);
        return (Long) newKey;
    }

    public Long insertSelective(DbNormalSettingPO record) {
        Object newKey = getSqlMapClientTemplate().insert("DB_NORMAL_SETTING.insertSelective", record);
        return (Long) newKey;
    }

    @SuppressWarnings("unchecked")
    public List<DbNormalSettingPO> selectByExample(DbNormalSettingExample example) {
        List<DbNormalSettingPO> list = getSqlMapClientTemplate().queryForList("DB_NORMAL_SETTING.selectByExample", example);
        return list;
    }

    public DbNormalSettingPO selectByPrimaryKey(Long id) {
        DbNormalSettingPO _key = new DbNormalSettingPO();
        _key.setId(id);
        DbNormalSettingPO record = (DbNormalSettingPO) getSqlMapClientTemplate().queryForObject("DB_NORMAL_SETTING.selectByPrimaryKey", _key);
        return record;
    }

    public int updateByExampleSelective(DbNormalSettingPO record, DbNormalSettingExample example) {
        UpdateByExampleParms parms = new UpdateByExampleParms(record, example);
        int rows = getSqlMapClientTemplate().update("DB_NORMAL_SETTING.updateByExampleSelective", parms);
        return rows;
    }

    public int updateByExample(DbNormalSettingPO record, DbNormalSettingExample example) {
        UpdateByExampleParms parms = new UpdateByExampleParms(record, example);
        int rows = getSqlMapClientTemplate().update("DB_NORMAL_SETTING.updateByExample", parms);
        return rows;
    }

    public int updateByPrimaryKeySelective(DbNormalSettingPO record) {
        int rows = getSqlMapClientTemplate().update("DB_NORMAL_SETTING.updateByPrimaryKeySelective", record);
        return rows;
    }

    public int updateByPrimaryKey(DbNormalSettingPO record) {
        int rows = getSqlMapClientTemplate().update("DB_NORMAL_SETTING.updateByPrimaryKey", record);
        return rows;
    }

    protected static class UpdateByExampleParms extends DbNormalSettingExample {
        private Object record;

        public UpdateByExampleParms(Object record, DbNormalSettingExample example) {
            super(example);
            this.record = record;
        }

        public Object getRecord() {
            return record;
        }
    }
}