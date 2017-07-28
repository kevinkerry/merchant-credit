package com.sdp.withdraw.dao.mapper;

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

import com.sdp.withdraw.dao.OpLogRecordDO;
import com.sdp.withdraw.dao.OpLogRecordDOExample.Criteria;
import com.sdp.withdraw.dao.OpLogRecordDOExample.Criterion;
import com.sdp.withdraw.dao.OpLogRecordDOExample;
import java.util.List;
import java.util.Map;

public class OpLogRecordSqlProvider {

    /**
     * 根据Example对象取得操作历史记录【OpLogRecordDO】对象count信息
     *
     * @mbggenerated Fri Mar 11 19:55:57 CST 2016
     */
    public String countByExample(OpLogRecordDOExample example) {
        BEGIN();
        SELECT("count(*)");
        FROM("OP_LOG_RECORD");
        applyWhere(example, false);
        return SQL();
    }

    /**
     * 根据Example对象删除操作历史记录【OpLogRecordDO】对象信息
     *
     * @mbggenerated Fri Mar 11 19:55:57 CST 2016
     */
    public String deleteByExample(OpLogRecordDOExample example) {
        BEGIN();
        DELETE_FROM("OP_LOG_RECORD");
        applyWhere(example, false);
        return SQL();
    }

    /**
     * 添加操作历史记录【OpLogRecordDO】对象信息,空值字段不插入
     *
     * @mbggenerated Fri Mar 11 19:55:57 CST 2016
     */
    public String insertSelective(OpLogRecordDO record) {
        BEGIN();
        INSERT_INTO("OP_LOG_RECORD");
        
        VALUES("ID", "#{id,jdbcType=DECIMAL}");
        
        if (record.getRecordType() != null) {
            VALUES("RECORD_TYPE", "#{recordType,jdbcType=VARCHAR}");
        }
        
        if (record.getOpType() != null) {
            VALUES("OP_TYPE", "#{opType,jdbcType=VARCHAR}");
        }
        
        if (record.getOpRecord() != null) {
            VALUES("OP_RECORD", "#{opRecord,jdbcType=VARCHAR}");
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
     * 根据Example对象查询得到操作历史记录【OpLogRecordDO】对象列表信息
     *
     * @mbggenerated Fri Mar 11 19:55:57 CST 2016
     */
    public String selectByExample(OpLogRecordDOExample example) {
        BEGIN();
        if (example != null && example.isDistinct()) {
            SELECT_DISTINCT("ID");
        } else {
            SELECT("ID");
        }
        SELECT("RECORD_TYPE");
        SELECT("OP_TYPE");
        SELECT("OP_RECORD");
        SELECT("CREATE_TIME");
        SELECT("UPDATE_TIME");
        FROM("OP_LOG_RECORD");
        applyWhere(example, false);
        
        if (example != null && example.getOrderByClause() != null) {
            ORDER_BY(example.getOrderByClause());
        }
        
        return SQL();
    }

    /**
     * 根据Query对象分页查询操作历史记录【OpLogRecordDO】对象列表信息
     *
     * @mbggenerated Fri Mar 11 19:55:57 CST 2016
     */
    public String selectByQuery(OpLogRecordDOExample example) {
        BEGIN();
        if (example != null && example.isDistinct()) {
            SELECT_DISTINCT("ID");
        } else {
            SELECT("ID");
        }
        SELECT("RECORD_TYPE");
        SELECT("OP_TYPE");
        SELECT("OP_RECORD");
        SELECT("CREATE_TIME");
        SELECT("UPDATE_TIME");
        FROM("OP_LOG_RECORD");
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
     * 根据Example对象更新操作历史记录【OpLogRecordDO】对象信息，仅更新非空字段
     *
     * @mbggenerated Fri Mar 11 19:55:57 CST 2016
     */
    public String updateByExampleSelective(Map<String, Object> parameter) {
        OpLogRecordDO record = (OpLogRecordDO) parameter.get("record");
        OpLogRecordDOExample example = (OpLogRecordDOExample) parameter.get("example");
        
        BEGIN();
        UPDATE("OP_LOG_RECORD");
        
        if (record.getId() != null) {
            SET("ID = #{record.id,jdbcType=DECIMAL}");
        }
        
        if (record.getRecordType() != null) {
            SET("RECORD_TYPE = #{record.recordType,jdbcType=VARCHAR}");
        }
        
        if (record.getOpType() != null) {
            SET("OP_TYPE = #{record.opType,jdbcType=VARCHAR}");
        }
        
        if (record.getOpRecord() != null) {
            SET("OP_RECORD = #{record.opRecord,jdbcType=VARCHAR}");
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
     * 根据Example对象更新操作历史记录【OpLogRecordDO】对象信息
     *
     * @mbggenerated Fri Mar 11 19:55:57 CST 2016
     */
    public String updateByExample(Map<String, Object> parameter) {
        BEGIN();
        UPDATE("OP_LOG_RECORD");
        
        SET("ID = #{record.id,jdbcType=DECIMAL}");
        SET("RECORD_TYPE = #{record.recordType,jdbcType=VARCHAR}");
        SET("OP_TYPE = #{record.opType,jdbcType=VARCHAR}");
        SET("OP_RECORD = #{record.opRecord,jdbcType=VARCHAR}");
        SET("CREATE_TIME = #{record.createTime,jdbcType=TIMESTAMP}");
        SET("UPDATE_TIME = #{record.updateTime,jdbcType=TIMESTAMP}");
        
        OpLogRecordDOExample example = (OpLogRecordDOExample) parameter.get("example");
        applyWhere(example, true);
        return SQL();
    }

    /**
     * 根据主键更新操作历史记录【OpLogRecordDO】对象信息，仅更新非空对象
     *
     * @mbggenerated Fri Mar 11 19:55:57 CST 2016
     */
    public String updateByPrimaryKeySelective(OpLogRecordDO record) {
        BEGIN();
        UPDATE("OP_LOG_RECORD");
        
        if (record.getRecordType() != null) {
            SET("RECORD_TYPE = #{recordType,jdbcType=VARCHAR}");
        }
        
        if (record.getOpType() != null) {
            SET("OP_TYPE = #{opType,jdbcType=VARCHAR}");
        }
        
        if (record.getOpRecord() != null) {
            SET("OP_RECORD = #{opRecord,jdbcType=VARCHAR}");
        }
        
        if (record.getCreateTime() != null) {
            SET("CREATE_TIME = #{createTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getUpdateTime() != null) {
            SET("UPDATE_TIME = #{updateTime,jdbcType=TIMESTAMP}");
        }
        
        WHERE("ID = #{id,jdbcType=DECIMAL}");
        
        return SQL();
    }

    /**
     * This method corresponds to the database table OP_LOG_RECORD
     *
     * @mbggenerated Fri Mar 11 19:55:57 CST 2016
     */
    protected void applyWhere(OpLogRecordDOExample example, boolean includeExamplePhrase) {
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
        
        if (example.getRecordType() != null && !example.getRecordType().equals("") ) {
            sb.append(" and  RECORD_TYPE = #{recordType,jdbcType=VARCHAR} ");
        }
        
        if (example.getOpType() != null && !example.getOpType().equals("") ) {
            sb.append(" and  OP_TYPE = #{opType,jdbcType=VARCHAR} ");
        }
        
        if (example.getOpRecord() != null && !example.getOpRecord().equals("") ) {
            sb.append(" and  OP_RECORD = #{opRecord,jdbcType=VARCHAR} ");
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