package com.shengpay.debit.daointerface;

import com.shengpay.debit.dal.dataobject.DbOrgCreditSettingExample;
import com.shengpay.debit.dal.dataobject.DbOrgCreditSettingPO;
import java.util.List;
import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

public class DbOrgCreditSettingDAOImpl extends SqlMapClientDaoSupport implements DbOrgCreditSettingDAO {

    public DbOrgCreditSettingDAOImpl() {
        super();
    }

    public int countByExample(DbOrgCreditSettingExample example) {
        Integer count = (Integer)  getSqlMapClientTemplate().queryForObject("DB_ORG_CREDIT_SETTING.countByExample", example);
        return count;
    }

    public int deleteByExample(DbOrgCreditSettingExample example) {
        int rows = getSqlMapClientTemplate().delete("DB_ORG_CREDIT_SETTING.deleteByExample", example);
        return rows;
    }

    public int deleteByPrimaryKey(Long id) {
        DbOrgCreditSettingPO _key = new DbOrgCreditSettingPO();
        _key.setId(id);
        int rows = getSqlMapClientTemplate().delete("DB_ORG_CREDIT_SETTING.deleteByPrimaryKey", _key);
        return rows;
    }

    public Long insert(DbOrgCreditSettingPO record) {
        Object newKey = getSqlMapClientTemplate().insert("DB_ORG_CREDIT_SETTING.insert", record);
        return (Long) newKey;
    }

    public Long insertSelective(DbOrgCreditSettingPO record) {
        Object newKey = getSqlMapClientTemplate().insert("DB_ORG_CREDIT_SETTING.insertSelective", record);
        return (Long) newKey;
    }

    @SuppressWarnings("unchecked")
    public List<DbOrgCreditSettingPO> selectByExample(DbOrgCreditSettingExample example) {
        List<DbOrgCreditSettingPO> list = getSqlMapClientTemplate().queryForList("DB_ORG_CREDIT_SETTING.selectByExample", example);
        return list;
    }

    public DbOrgCreditSettingPO selectByPrimaryKey(Long id) {
        DbOrgCreditSettingPO _key = new DbOrgCreditSettingPO();
        _key.setId(id);
        DbOrgCreditSettingPO record = (DbOrgCreditSettingPO) getSqlMapClientTemplate().queryForObject("DB_ORG_CREDIT_SETTING.selectByPrimaryKey", _key);
        return record;
    }

    public int updateByExampleSelective(DbOrgCreditSettingPO record, DbOrgCreditSettingExample example) {
        UpdateByExampleParms parms = new UpdateByExampleParms(record, example);
        int rows = getSqlMapClientTemplate().update("DB_ORG_CREDIT_SETTING.updateByExampleSelective", parms);
        return rows;
    }

    public int updateByExample(DbOrgCreditSettingPO record, DbOrgCreditSettingExample example) {
        UpdateByExampleParms parms = new UpdateByExampleParms(record, example);
        int rows = getSqlMapClientTemplate().update("DB_ORG_CREDIT_SETTING.updateByExample", parms);
        return rows;
    }

    public int updateByPrimaryKeySelective(DbOrgCreditSettingPO record) {
        int rows = getSqlMapClientTemplate().update("DB_ORG_CREDIT_SETTING.updateByPrimaryKeySelective", record);
        return rows;
    }

    public int updateByPrimaryKey(DbOrgCreditSettingPO record) {
        int rows = getSqlMapClientTemplate().update("DB_ORG_CREDIT_SETTING.updateByPrimaryKey", record);
        return rows;
    }

    protected static class UpdateByExampleParms extends DbOrgCreditSettingExample {
        private Object record;

        public UpdateByExampleParms(Object record, DbOrgCreditSettingExample example) {
            super(example);
            this.record = record;
        }

        public Object getRecord() {
            return record;
        }
    }
}