package com.sdp.mc.newt0.dao.mapper;

import static org.apache.ibatis.jdbc.SqlBuilder.BEGIN;
import static org.apache.ibatis.jdbc.SqlBuilder.DELETE_FROM;
import static org.apache.ibatis.jdbc.SqlBuilder.FROM;
import static org.apache.ibatis.jdbc.SqlBuilder.INSERT_INTO;
import static org.apache.ibatis.jdbc.SqlBuilder.ORDER_BY;
import static org.apache.ibatis.jdbc.SqlBuilder.SELECT;
import static org.apache.ibatis.jdbc.SqlBuilder.SELECT_DISTINCT;
import static org.apache.ibatis.jdbc.SqlBuilder.SET;
import static org.apache.ibatis.jdbc.SqlBuilder.SQL;
import static org.apache.ibatis.jdbc.SqlBuilder.UPDATE;
import static org.apache.ibatis.jdbc.SqlBuilder.VALUES;
import static org.apache.ibatis.jdbc.SqlBuilder.WHERE;

import com.sdp.mc.newt0.dao.NewT0UserOperaRecordDO;
import com.sdp.mc.newt0.dao.NewT0UserOperaRecordDOExample.Criteria;
import com.sdp.mc.newt0.dao.NewT0UserOperaRecordDOExample.Criterion;
import com.sdp.mc.newt0.dao.NewT0UserOperaRecordDOExample;
import java.util.List;
import java.util.Map;

public class NewT0UserOperaRecordSqlProvider {

    /**
     * 根据Example对象取得保证金赎回放款操作表【NewT0UserOperaRecordDO】对象count信息
     *
     * @mbggenerated Fri Oct 09 09:50:32 CST 2015
     */
    public String countByExample(NewT0UserOperaRecordDOExample example) {
        BEGIN();
        SELECT("count(*)");
        FROM("NEWT0_USEROPERA_RECORD");
        applyWhere(example, false);
        return SQL();
    }

    /**
     * 根据Example对象删除保证金赎回放款操作表【NewT0UserOperaRecordDO】对象信息
     *
     * @mbggenerated Fri Oct 09 09:50:32 CST 2015
     */
    public String deleteByExample(NewT0UserOperaRecordDOExample example) {
        BEGIN();
        DELETE_FROM("NEWT0_USEROPERA_RECORD");
        applyWhere(example, false);
        return SQL();
    }

    /**
     * 添加保证金赎回放款操作表【NewT0UserOperaRecordDO】对象信息,空值字段不插入
     *
     * @mbggenerated Fri Oct 09 09:50:32 CST 2015
     */
    public String insertSelective(NewT0UserOperaRecordDO record) {
        BEGIN();
        INSERT_INTO("NEWT0_USEROPERA_RECORD");
        
        VALUES("ID", "#{id,jdbcType=DECIMAL}");
        
        if (record.getBizId() != null) {
            VALUES("BIZ_ID", "#{bizId,jdbcType=DECIMAL}");
        }
        
        if (record.getRealname() != null) {
            VALUES("REALNAME", "#{realname,jdbcType=VARCHAR}");
        }
        
        if (record.getUsername() != null) {
            VALUES("USERNAME", "#{username,jdbcType=VARCHAR}");
        }
        
        if (record.getBizType() != null) {
            VALUES("BIZ_TYPE", "#{bizType,jdbcType=DECIMAL}");
        }
        
        if (record.getOperaTime() != null) {
            VALUES("OPERA_TIME", "#{operaTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getCreateTime() != null) {
            VALUES("CREATE_TIME", "#{createTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getUpdateTime() != null) {
            VALUES("UPDATE_TIME", "#{updateTime,jdbcType=TIMESTAMP}");
        }
        
        return SQL();
    }

    /**
     * 根据Example对象查询得到保证金赎回放款操作表【NewT0UserOperaRecordDO】对象列表信息
     *
     * @mbggenerated Fri Oct 09 09:50:32 CST 2015
     */
    public String selectByExample(NewT0UserOperaRecordDOExample example) {
        BEGIN();
        if (example != null && example.isDistinct()) {
            SELECT_DISTINCT("ID");
        } else {
            SELECT("ID");
        }
        SELECT("BIZ_ID");
        SELECT("REALNAME");
        SELECT("USERNAME");
        SELECT("BIZ_TYPE");
        SELECT("OPERA_TIME");
        SELECT("CREATE_TIME");
        SELECT("UPDATE_TIME");
        FROM("NEWT0_USEROPERA_RECORD");
        applyWhere(example, false);
        
        if (example != null && example.getOrderByClause() != null) {
            ORDER_BY(example.getOrderByClause());
        }
        
        return SQL();
    }

    /**
     * 根据Query对象分页查询保证金赎回放款操作表【NewT0UserOperaRecordDO】对象列表信息
     *
     * @mbggenerated Fri Oct 09 09:50:32 CST 2015
     */
    public String selectByQuery(NewT0UserOperaRecordDOExample example) {
        BEGIN();
        if (example != null && example.isDistinct()) {
            SELECT_DISTINCT("ID");
        } else {
            SELECT("ID");
        }
        SELECT("BIZ_ID");
        SELECT("REALNAME");
        SELECT("USERNAME");
        SELECT("BIZ_TYPE");
        SELECT("OPERA_TIME");
        SELECT("CREATE_TIME");
        SELECT("UPDATE_TIME");
        FROM("NEWT0_USEROPERA_RECORD");
        applyWhere(example, false);
        
        if (example != null && example.getOrderByClause() != null) {
            ORDER_BY(example.getOrderByClause());
        }
        
        String srcSql = SQL();
        StringBuilder sqlStr = new StringBuilder();
        sqlStr.append("select t.* from (select tt.*, ROWNUM rnum from ( ");
        sqlStr.append(srcSql);
        sqlStr.append(") tt) t where   t.rnum <= #{pageLastItem,jdbcType=NUMERIC}  and t.rnum >= #{pageFristItem,jdbcType=NUMERIC}");
        
        
        return sqlStr.toString();
    }

    /**
     * 根据Example对象更新保证金赎回放款操作表【NewT0UserOperaRecordDO】对象信息，仅更新非空字段
     *
     * @mbggenerated Fri Oct 09 09:50:32 CST 2015
     */
    public String updateByExampleSelective(Map<String, Object> parameter) {
        NewT0UserOperaRecordDO record = (NewT0UserOperaRecordDO) parameter.get("record");
        NewT0UserOperaRecordDOExample example = (NewT0UserOperaRecordDOExample) parameter.get("example");
        
        BEGIN();
        UPDATE("NEWT0_USEROPERA_RECORD");
        
        if (record.getId() != null) {
            SET("ID = #{record.id,jdbcType=DECIMAL}");
        }
        
        if (record.getBizId() != null) {
            SET("BIZ_ID = #{record.bizId,jdbcType=DECIMAL}");
        }
        
        if (record.getRealname() != null) {
            SET("REALNAME = #{record.realname,jdbcType=VARCHAR}");
        }
        
        if (record.getUsername() != null) {
            SET("USERNAME = #{record.username,jdbcType=VARCHAR}");
        }
        
        if (record.getBizType() != null) {
            SET("BIZ_TYPE = #{record.bizType,jdbcType=DECIMAL}");
        }
        
        if (record.getOperaTime() != null) {
            SET("OPERA_TIME = #{record.operaTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getCreateTime() != null) {
            SET("CREATE_TIME = #{record.createTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getUpdateTime() != null) {
            SET("UPDATE_TIME = #{record.updateTime,jdbcType=TIMESTAMP}");
        }
        
        applyWhere(example, true);
        return SQL();
    }

    /**
     * 根据Example对象更新保证金赎回放款操作表【NewT0UserOperaRecordDO】对象信息
     *
     * @mbggenerated Fri Oct 09 09:50:32 CST 2015
     */
    public String updateByExample(Map<String, Object> parameter) {
        BEGIN();
        UPDATE("NEWT0_USEROPERA_RECORD");
        
        SET("ID = #{record.id,jdbcType=DECIMAL}");
        SET("BIZ_ID = #{record.bizId,jdbcType=DECIMAL}");
        SET("REALNAME = #{record.realname,jdbcType=VARCHAR}");
        SET("USERNAME = #{record.username,jdbcType=VARCHAR}");
        SET("BIZ_TYPE = #{record.bizType,jdbcType=DECIMAL}");
        SET("OPERA_TIME = #{record.operaTime,jdbcType=TIMESTAMP}");
        SET("CREATE_TIME = #{record.createTime,jdbcType=TIMESTAMP}");
        SET("UPDATE_TIME = #{record.updateTime,jdbcType=TIMESTAMP}");
        
        NewT0UserOperaRecordDOExample example = (NewT0UserOperaRecordDOExample) parameter.get("example");
        applyWhere(example, true);
        return SQL();
    }

    /**
     * This method corresponds to the database table NEWT0_USEROPERA_RECORD
     *
     * @mbggenerated Fri Oct 09 09:50:32 CST 2015
     */
    protected void applyWhere(NewT0UserOperaRecordDOExample example, boolean includeExamplePhrase) {
        if (example == null) {
            return;
        }
        
        String parmPhrase1;
        String parmPhrase1_th;
        String parmPhrase2;
        String parmPhrase2_th;
        String parmPhrase3;
        String parmPhrase3_th;
        if (includeExamplePhrase) {
            parmPhrase1 = "%s #{example.oredCriteria[%d].allCriteria[%d].value}";
            parmPhrase1_th = "%s #{example.oredCriteria[%d].allCriteria[%d].value,typeHandler=%s}";
            parmPhrase2 = "%s #{example.oredCriteria[%d].allCriteria[%d].value} and #{example.oredCriteria[%d].criteria[%d].secondValue}";
            parmPhrase2_th = "%s #{example.oredCriteria[%d].allCriteria[%d].value,typeHandler=%s} and #{example.oredCriteria[%d].criteria[%d].secondValue,typeHandler=%s}";
            parmPhrase3 = "#{example.oredCriteria[%d].allCriteria[%d].value[%d]}";
            parmPhrase3_th = "#{example.oredCriteria[%d].allCriteria[%d].value[%d],typeHandler=%s}";
        } else {
            parmPhrase1 = "%s #{oredCriteria[%d].allCriteria[%d].value}";
            parmPhrase1_th = "%s #{oredCriteria[%d].allCriteria[%d].value,typeHandler=%s}";
            parmPhrase2 = "%s #{oredCriteria[%d].allCriteria[%d].value} and #{oredCriteria[%d].criteria[%d].secondValue}";
            parmPhrase2_th = "%s #{oredCriteria[%d].allCriteria[%d].value,typeHandler=%s} and #{oredCriteria[%d].criteria[%d].secondValue,typeHandler=%s}";
            parmPhrase3 = "#{oredCriteria[%d].allCriteria[%d].value[%d]}";
            parmPhrase3_th = "#{oredCriteria[%d].allCriteria[%d].value[%d],typeHandler=%s}";
        }
        
        StringBuilder sb = new StringBuilder();
        List<Criteria> oredCriteria = example.getOredCriteria();
        boolean firstCriteria = true;
        for (int i = 0; i < oredCriteria.size(); i++) {
            Criteria criteria = oredCriteria.get(i);
            if (criteria.isValid()) {
                if (firstCriteria) {
                    firstCriteria = false;
                } else {
                    sb.append(" or ");
                }
                
                sb.append('(');
                List<Criterion> criterions = criteria.getAllCriteria();
                boolean firstCriterion = true;
                for (int j = 0; j < criterions.size(); j++) {
                    Criterion criterion = criterions.get(j);
                    if (firstCriterion) {
                        firstCriterion = false;
                    } else {
                        sb.append(" and ");
                    }
                    
                    if (criterion.isNoValue()) {
                        sb.append(criterion.getCondition());
                    } else if (criterion.isSingleValue()) {
                        if (criterion.getTypeHandler() == null) {
                            sb.append(String.format(parmPhrase1, criterion.getCondition(), i, j));
                        } else {
                            sb.append(String.format(parmPhrase1_th, criterion.getCondition(), i, j,criterion.getTypeHandler()));
                        }
                    } else if (criterion.isBetweenValue()) {
                        if (criterion.getTypeHandler() == null) {
                            sb.append(String.format(parmPhrase2, criterion.getCondition(), i, j, i, j));
                        } else {
                            sb.append(String.format(parmPhrase2_th, criterion.getCondition(), i, j, criterion.getTypeHandler(), i, j, criterion.getTypeHandler()));
                        }
                    } else if (criterion.isListValue()) {
                        sb.append(criterion.getCondition());
                        sb.append(" (");
                        List<?> listItems = (List<?>) criterion.getValue();
                        boolean comma = false;
                        for (int k = 0; k < listItems.size(); k++) {
                            if (comma) {
                                sb.append(", ");
                            } else {
                                comma = true;
                            }
                            if (criterion.getTypeHandler() == null) {
                                sb.append(String.format(parmPhrase3, i, j, k));
                            } else {
                                sb.append(String.format(parmPhrase3_th, i, j, k, criterion.getTypeHandler()));
                            }
                        }
                        sb.append(')');
                    }
                }
                sb.append(')');
            }
        }
        
        if (sb.length() == 0) {
            sb.append(" (1=1) ");
        }
        
        if (example.getId() != null) {
            sb.append(" and  ID = #{id,jdbcType=DECIMAL} ");
        }
        
        if (example.getBizId() != null) {
            sb.append(" and  BIZ_ID = #{bizId,jdbcType=DECIMAL} ");
        }
        
        if (example.getRealname() != null && !example.getRealname().equals("") ) {
            sb.append(" and  REALNAME = #{realname,jdbcType=VARCHAR} ");
        }
        
        if (example.getUsername() != null && !example.getUsername().equals("") ) {
            sb.append(" and  USERNAME = #{username,jdbcType=VARCHAR} ");
        }
        
        if (example.getBizType() != null) {
            sb.append(" and  BIZ_TYPE = #{bizType,jdbcType=DECIMAL} ");
        }
        
        if (example.getOperaTime() != null) {
            sb.append(" and  OPERA_TIME = #{operaTime,jdbcType=TIMESTAMP} ");
        }
        
        if (example.getCreateTime() != null) {
            sb.append(" and  CREATE_TIME = #{createTime,jdbcType=TIMESTAMP} ");
        }
        
        if (example.getUpdateTime() != null) {
            sb.append(" and  UPDATE_TIME = #{updateTime,jdbcType=TIMESTAMP} ");
        }
        WHERE(sb.toString());
    }
}