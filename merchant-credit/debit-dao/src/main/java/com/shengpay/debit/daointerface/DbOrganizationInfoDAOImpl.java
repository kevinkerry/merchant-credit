package com.shengpay.debit.daointerface;

import com.shengpay.debit.dal.dataobject.DbOrganizationInfoExample;
import com.shengpay.debit.dal.dataobject.DbOrganizationInfoPO;
import java.util.List;
import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

public class DbOrganizationInfoDAOImpl extends SqlMapClientDaoSupport implements DbOrganizationInfoDAO {

    public DbOrganizationInfoDAOImpl() {
        super();
    }

    public int countByExample(DbOrganizationInfoExample example) {
        Integer count = (Integer)  getSqlMapClientTemplate().queryForObject("DB_ORGANIZATION_INFO.countByExample", example);
        return count;
    }

    public int deleteByExample(DbOrganizationInfoExample example) {
        int rows = getSqlMapClientTemplate().delete("DB_ORGANIZATION_INFO.deleteByExample", example);
        return rows;
    }

    public int deleteByPrimaryKey(Long id) {
        DbOrganizationInfoPO _key = new DbOrganizationInfoPO();
        _key.setId(id);
        int rows = getSqlMapClientTemplate().delete("DB_ORGANIZATION_INFO.deleteByPrimaryKey", _key);
        return rows;
    }

    public Long insert(DbOrganizationInfoPO record) {
        Object newKey = getSqlMapClientTemplate().insert("DB_ORGANIZATION_INFO.insert", record);
        return (Long) newKey;
    }

    public Long insertSelective(DbOrganizationInfoPO record) {
        Object newKey = getSqlMapClientTemplate().insert("DB_ORGANIZATION_INFO.insertSelective", record);
        return (Long) newKey;
    }

    @SuppressWarnings("unchecked")
    public List<DbOrganizationInfoPO> selectByExample(DbOrganizationInfoExample example) {
        List<DbOrganizationInfoPO> list = getSqlMapClientTemplate().queryForList("DB_ORGANIZATION_INFO.selectByExample", example);
        return list;
    }

    public DbOrganizationInfoPO selectByPrimaryKey(Long id) {
        DbOrganizationInfoPO _key = new DbOrganizationInfoPO();
        _key.setId(id);
        DbOrganizationInfoPO record = (DbOrganizationInfoPO) getSqlMapClientTemplate().queryForObject("DB_ORGANIZATION_INFO.selectByPrimaryKey", _key);
        return record;
    }

    public int updateByExampleSelective(DbOrganizationInfoPO record, DbOrganizationInfoExample example) {
        UpdateByExampleParms parms = new UpdateByExampleParms(record, example);
        int rows = getSqlMapClientTemplate().update("DB_ORGANIZATION_INFO.updateByExampleSelective", parms);
        return rows;
    }

    public int updateByExample(DbOrganizationInfoPO record, DbOrganizationInfoExample example) {
        UpdateByExampleParms parms = new UpdateByExampleParms(record, example);
        int rows = getSqlMapClientTemplate().update("DB_ORGANIZATION_INFO.updateByExample", parms);
        return rows;
    }

    public int updateByPrimaryKeySelective(DbOrganizationInfoPO record) {
        int rows = getSqlMapClientTemplate().update("DB_ORGANIZATION_INFO.updateByPrimaryKeySelective", record);
        return rows;
    }

    public int updateByPrimaryKey(DbOrganizationInfoPO record) {
        int rows = getSqlMapClientTemplate().update("DB_ORGANIZATION_INFO.updateByPrimaryKey", record);
        return rows;
    }

    protected static class UpdateByExampleParms extends DbOrganizationInfoExample {
        private Object record;

        public UpdateByExampleParms(Object record, DbOrganizationInfoExample example) {
            super(example);
            this.record = record;
        }

        public Object getRecord() {
            return record;
        }
    }
}