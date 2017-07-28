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

import com.sdp.mc.newt0.dao.NewT0AuditInfoDO;
import com.sdp.mc.newt0.dao.NewT0AuditInfoDOExample.Criteria;
import com.sdp.mc.newt0.dao.NewT0AuditInfoDOExample.Criterion;
import com.sdp.mc.newt0.dao.NewT0AuditInfoDOExample;
import java.util.List;
import java.util.Map;

public class NewT0AuditInfoSqlProvider {

    /**
     * 根据Example对象取得审核表【NewT0AuditInfoDO】对象count信息
     *
     * @mbggenerated Mon Jun 06 17:21:26 CST 2016
     */
    public String countByExample(NewT0AuditInfoDOExample example) {
        BEGIN();
        SELECT("count(*)");
        FROM("NEWT0_AUDIT_INFO");
        applyWhere(example, false);
        return SQL();
    }

    /**
     * 根据Example对象删除审核表【NewT0AuditInfoDO】对象信息
     *
     * @mbggenerated Mon Jun 06 17:21:26 CST 2016
     */
    public String deleteByExample(NewT0AuditInfoDOExample example) {
        BEGIN();
        DELETE_FROM("NEWT0_AUDIT_INFO");
        applyWhere(example, false);
        return SQL();
    }

    /**
     * 添加审核表【NewT0AuditInfoDO】对象信息,空值字段不插入
     *
     * @mbggenerated Mon Jun 06 17:21:26 CST 2016
     */
    public String insertSelective(NewT0AuditInfoDO record) {
        BEGIN();
        INSERT_INTO("NEWT0_AUDIT_INFO");
        
        VALUES("ID", "#{id,jdbcType=DECIMAL}");
        
        if (record.getObjNo() != null) {
            VALUES("OBJ_NO", "#{objNo,jdbcType=VARCHAR}");
        }
        
        if (record.getObjId() != null) {
            VALUES("OBJ_ID", "#{objId,jdbcType=DECIMAL}");
        }
        
        if (record.getObjType() != null) {
            VALUES("OBJ_TYPE", "#{objType,jdbcType=DECIMAL}");
        }
        
        if (record.getOpType() != null) {
            VALUES("OP_TYPE", "#{opType,jdbcType=DECIMAL}");
        }
        
        if (record.getRequestLog() != null) {
            VALUES("REQUEST_LOG", "#{requestLog,jdbcType=VARCHAR}");
        }
        
        if (record.getStatus() != null) {
            VALUES("STATUS", "#{status,jdbcType=DECIMAL}");
        }
        
        if (record.getCreateTime() != null) {
            VALUES("CREATE_TIME", "#{createTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getUpdateTime() != null) {
            VALUES("UPDATE_TIME", "#{updateTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getOperator() != null) {
            VALUES("OPERATOR", "#{operator,jdbcType=VARCHAR}");
        }
        
        if (record.getOperatorId() != null) {
            VALUES("OPERATOR_ID", "#{operatorId,jdbcType=VARCHAR}");
        }
        
        if (record.getExpireTime() != null) {
            VALUES("EXPIRE_TIME", "#{expireTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getMcType() != null) {
            VALUES("MCTYPE", "#{mcType,jdbcType=VARCHAR}");
        }
        
        if (record.getAuditTime() != null) {
            VALUES("AUDIT_TIME", "#{auditTime,jdbcType=TIMESTAMP}");
        }
        
        return SQL();
    }

    /**
     * 根据Example对象查询得到审核表【NewT0AuditInfoDO】对象列表信息
     *
     * @mbggenerated Mon Jun 06 17:21:26 CST 2016
     */
    public String selectByExample(NewT0AuditInfoDOExample example) {
        BEGIN();
        if (example != null && example.isDistinct()) {
            SELECT_DISTINCT("ID");
        } else {
            SELECT("ID");
        }
        SELECT("OBJ_NO");
        SELECT("OBJ_ID");
        SELECT("OBJ_TYPE");
        SELECT("OP_TYPE");
        SELECT("REQUEST_LOG");
        SELECT("STATUS");
        SELECT("CREATE_TIME");
        SELECT("UPDATE_TIME");
        SELECT("OPERATOR");
        SELECT("OPERATOR_ID");
        SELECT("EXPIRE_TIME");
        SELECT("MCTYPE");
        SELECT("AUDIT_TIME");
        FROM("NEWT0_AUDIT_INFO");
        applyWhere(example, false);
        
        if (example != null && example.getOrderByClause() != null) {
            ORDER_BY(example.getOrderByClause());
        }
        
        return SQL();
    }

    /**
     * 根据Query对象分页查询审核表【NewT0AuditInfoDO】对象列表信息
     *
     * @mbggenerated Mon Jun 06 17:21:26 CST 2016
     */
    public String selectByQuery(NewT0AuditInfoDOExample example) {
        BEGIN();
        if (example != null && example.isDistinct()) {
            SELECT_DISTINCT("ID");
        } else {
            SELECT("ID");
        }
        SELECT("OBJ_NO");
        SELECT("OBJ_ID");
        SELECT("OBJ_TYPE");
        SELECT("OP_TYPE");
        SELECT("REQUEST_LOG");
        SELECT("STATUS");
        SELECT("CREATE_TIME");
        SELECT("UPDATE_TIME");
        SELECT("OPERATOR");
        SELECT("OPERATOR_ID");
        SELECT("EXPIRE_TIME");
        SELECT("MCTYPE");
        SELECT("AUDIT_TIME");
        FROM("NEWT0_AUDIT_INFO");
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
     * 根据Example对象更新审核表【NewT0AuditInfoDO】对象信息，仅更新非空字段
     *
     * @mbggenerated Mon Jun 06 17:21:26 CST 2016
     */
    public String updateByExampleSelective(Map<String, Object> parameter) {
        NewT0AuditInfoDO record = (NewT0AuditInfoDO) parameter.get("record");
        NewT0AuditInfoDOExample example = (NewT0AuditInfoDOExample) parameter.get("example");
        
        BEGIN();
        UPDATE("NEWT0_AUDIT_INFO");
        
        if (record.getId() != null) {
            SET("ID = #{record.id,jdbcType=DECIMAL}");
        }
        
        if (record.getObjNo() != null) {
            SET("OBJ_NO = #{record.objNo,jdbcType=VARCHAR}");
        }
        
        if (record.getObjId() != null) {
            SET("OBJ_ID = #{record.objId,jdbcType=DECIMAL}");
        }
        
        if (record.getObjType() != null) {
            SET("OBJ_TYPE = #{record.objType,jdbcType=DECIMAL}");
        }
        
        if (record.getOpType() != null) {
            SET("OP_TYPE = #{record.opType,jdbcType=DECIMAL}");
        }
        
        if (record.getRequestLog() != null) {
            SET("REQUEST_LOG = #{record.requestLog,jdbcType=VARCHAR}");
        }
        
        if (record.getStatus() != null) {
            SET("STATUS = #{record.status,jdbcType=DECIMAL}");
        }
        
        if (record.getCreateTime() != null) {
            SET("CREATE_TIME = #{record.createTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getUpdateTime() != null) {
            SET("UPDATE_TIME = #{record.updateTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getOperator() != null) {
            SET("OPERATOR = #{record.operator,jdbcType=VARCHAR}");
        }
        
        if (record.getOperatorId() != null) {
            SET("OPERATOR_ID = #{record.operatorId,jdbcType=VARCHAR}");
        }
        
        if (record.getExpireTime() != null) {
            SET("EXPIRE_TIME = #{record.expireTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getMcType() != null) {
            SET("MCTYPE = #{record.mcType,jdbcType=VARCHAR}");
        }
        
        if (record.getAuditTime() != null) {
            SET("AUDIT_TIME = #{record.auditTime,jdbcType=TIMESTAMP}");
        }
        
        applyWhere(example, true);
        return SQL();
    }

    /**
     * 根据Example对象更新审核表【NewT0AuditInfoDO】对象信息
     *
     * @mbggenerated Mon Jun 06 17:21:26 CST 2016
     */
    public String updateByExample(Map<String, Object> parameter) {
        BEGIN();
        UPDATE("NEWT0_AUDIT_INFO");
        
        SET("ID = #{record.id,jdbcType=DECIMAL}");
        SET("OBJ_NO = #{record.objNo,jdbcType=VARCHAR}");
        SET("OBJ_ID = #{record.objId,jdbcType=DECIMAL}");
        SET("OBJ_TYPE = #{record.objType,jdbcType=DECIMAL}");
        SET("OP_TYPE = #{record.opType,jdbcType=DECIMAL}");
        SET("REQUEST_LOG = #{record.requestLog,jdbcType=VARCHAR}");
        SET("STATUS = #{record.status,jdbcType=DECIMAL}");
        SET("CREATE_TIME = #{record.createTime,jdbcType=TIMESTAMP}");
        SET("UPDATE_TIME = #{record.updateTime,jdbcType=TIMESTAMP}");
        SET("OPERATOR = #{record.operator,jdbcType=VARCHAR}");
        SET("OPERATOR_ID = #{record.operatorId,jdbcType=VARCHAR}");
        SET("EXPIRE_TIME = #{record.expireTime,jdbcType=TIMESTAMP}");
        SET("MCTYPE = #{record.mcType,jdbcType=VARCHAR}");
        SET("AUDIT_TIME = #{record.auditTime,jdbcType=TIMESTAMP}");
        
        NewT0AuditInfoDOExample example = (NewT0AuditInfoDOExample) parameter.get("example");
        applyWhere(example, true);
        return SQL();
    }

    /**
     * 根据主键更新审核表【NewT0AuditInfoDO】对象信息，仅更新非空对象
     *
     * @mbggenerated Mon Jun 06 17:21:26 CST 2016
     */
    public String updateByPrimaryKeySelective(NewT0AuditInfoDO record) {
        BEGIN();
        UPDATE("NEWT0_AUDIT_INFO");
        
        if (record.getObjNo() != null) {
            SET("OBJ_NO = #{objNo,jdbcType=VARCHAR}");
        }
        
        if (record.getObjId() != null) {
            SET("OBJ_ID = #{objId,jdbcType=DECIMAL}");
        }
        
        if (record.getObjType() != null) {
            SET("OBJ_TYPE = #{objType,jdbcType=DECIMAL}");
        }
        
        if (record.getOpType() != null) {
            SET("OP_TYPE = #{opType,jdbcType=DECIMAL}");
        }
        
        if (record.getRequestLog() != null) {
            SET("REQUEST_LOG = #{requestLog,jdbcType=VARCHAR}");
        }
        
        if (record.getStatus() != null) {
            SET("STATUS = #{status,jdbcType=DECIMAL}");
        }
        
        if (record.getCreateTime() != null) {
            SET("CREATE_TIME = #{createTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getUpdateTime() != null) {
            SET("UPDATE_TIME = #{updateTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getOperator() != null) {
            SET("OPERATOR = #{operator,jdbcType=VARCHAR}");
        }
        
        if (record.getOperatorId() != null) {
            SET("OPERATOR_ID = #{operatorId,jdbcType=VARCHAR}");
        }
        
        if (record.getExpireTime() != null) {
            SET("EXPIRE_TIME = #{expireTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getMcType() != null) {
            SET("MCTYPE = #{mcType,jdbcType=VARCHAR}");
        }
        
        if (record.getAuditTime() != null) {
            SET("AUDIT_TIME = #{auditTime,jdbcType=TIMESTAMP}");
        }
        
        WHERE("ID = #{id,jdbcType=DECIMAL}");
        
        return SQL();
    }

    /**
     * This method corresponds to the database table NEWT0_AUDIT_INFO
     *
     * @mbggenerated Mon Jun 06 17:21:26 CST 2016
     */
    protected void applyWhere(NewT0AuditInfoDOExample example, boolean includeExamplePhrase) {
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
        
        if (example.getObjNo() != null && !example.getObjNo().equals("") ) {
            sb.append(" and  OBJ_NO = #{objNo,jdbcType=VARCHAR} ");
        }
        
        if (example.getObjId() != null) {
            sb.append(" and  OBJ_ID = #{objId,jdbcType=DECIMAL} ");
        }
        
        if (example.getObjType() != null) {
            sb.append(" and  OBJ_TYPE = #{objType,jdbcType=DECIMAL} ");
        }
        
        if (example.getOpType() != null) {
            sb.append(" and  OP_TYPE = #{opType,jdbcType=DECIMAL} ");
        }
        
        if (example.getRequestLog() != null && !example.getRequestLog().equals("") ) {
            sb.append(" and  REQUEST_LOG = #{requestLog,jdbcType=VARCHAR} ");
        }
        
        if (example.getStatus() != null) {
            sb.append(" and  STATUS = #{status,jdbcType=DECIMAL} ");
        }
        
        if (example.getCreateTime() != null) {
            sb.append(" and  CREATE_TIME = #{createTime,jdbcType=TIMESTAMP} ");
        }
        
        if (example.getUpdateTime() != null) {
            sb.append(" and  UPDATE_TIME = #{updateTime,jdbcType=TIMESTAMP} ");
        }
        
        if (example.getOperator() != null && !example.getOperator().equals("") ) {
            sb.append(" and  OPERATOR = #{operator,jdbcType=VARCHAR} ");
        }
        
        if (example.getOperatorId() != null && !example.getOperatorId().equals("") ) {
            sb.append(" and  OPERATOR_ID = #{operatorId,jdbcType=VARCHAR} ");
        }
        
        if (example.getExpireTime() != null) {
            sb.append(" and  EXPIRE_TIME = #{expireTime,jdbcType=TIMESTAMP} ");
        }
        
        if (example.getMcType() != null && !example.getMcType().equals("") ) {
            sb.append(" and  MCTYPE = #{mcType,jdbcType=VARCHAR} ");
        }
        
        if (example.getAuditTime() != null) {
            sb.append(" and  AUDIT_TIME = #{auditTime,jdbcType=TIMESTAMP} ");
        }
        WHERE(sb.toString());
    }
}