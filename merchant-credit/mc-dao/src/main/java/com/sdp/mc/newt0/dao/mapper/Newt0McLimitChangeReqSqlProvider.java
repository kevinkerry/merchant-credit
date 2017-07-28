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

import com.sdp.mc.newt0.dao.Newt0McLimitChangeReqDO;
import com.sdp.mc.newt0.dao.Newt0McLimitChangeReqDOExample.Criteria;
import com.sdp.mc.newt0.dao.Newt0McLimitChangeReqDOExample.Criterion;
import com.sdp.mc.newt0.dao.Newt0McLimitChangeReqDOExample;
import java.util.List;
import java.util.Map;

public class Newt0McLimitChangeReqSqlProvider {

    /**
     * 根据Example对象取得商户额度变更请求信息表【Newt0McLimitChangeReqDO】对象count信息
     *
     * @mbggenerated Mon Jan 11 11:09:30 CST 2016
     */
    public String countByExample(Newt0McLimitChangeReqDOExample example) {
        BEGIN();
        SELECT("count(*)");
        FROM("NEWT0_MC_LIMIT_CHANGE_REQ");
        applyWhere(example, false);
        return SQL();
    }

    /**
     * 根据Example对象删除商户额度变更请求信息表【Newt0McLimitChangeReqDO】对象信息
     *
     * @mbggenerated Mon Jan 11 11:09:30 CST 2016
     */
    public String deleteByExample(Newt0McLimitChangeReqDOExample example) {
        BEGIN();
        DELETE_FROM("NEWT0_MC_LIMIT_CHANGE_REQ");
        applyWhere(example, false);
        return SQL();
    }

    /**
     * 添加商户额度变更请求信息表【Newt0McLimitChangeReqDO】对象信息,空值字段不插入
     *
     * @mbggenerated Mon Jan 11 11:09:30 CST 2016
     */
    public String insertSelective(Newt0McLimitChangeReqDO record) {
        BEGIN();
        INSERT_INTO("NEWT0_MC_LIMIT_CHANGE_REQ");
        
        VALUES("REQ_ID", "#{reqId,jdbcType=DECIMAL}");
        
        if (record.getReqTime() != null) {
            VALUES("REQ_TIME", "#{reqTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getCreateTime() != null) {
            VALUES("CREATE_TIME", "#{createTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getReqNum() != null) {
            VALUES("REQ_NUM", "#{reqNum,jdbcType=DECIMAL}");
        }
        
        if (record.getSuccessNum() != null) {
            VALUES("SUCCESS_NUM", "#{successNum,jdbcType=DECIMAL}");
        }
        
        if (record.getFailNum() != null) {
            VALUES("FAIL_NUM", "#{failNum,jdbcType=DECIMAL}");
        }
        
        if (record.getStatus() != null) {
            VALUES("STATUS", "#{status,jdbcType=DECIMAL}");
        }
        
        if (record.getReqFileName() != null) {
            VALUES("REQ_FILE_NAME", "#{reqFileName,jdbcType=VARCHAR}");
        }
        
        if (record.getUpdateTime() != null) {
            VALUES("UPDATE_TIME", "#{updateTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getReqType() != null) {
            VALUES("REQ_TYPE", "#{reqType,jdbcType=DECIMAL}");
        }
        
        return SQL();
    }

    /**
     * 根据Example对象查询得到商户额度变更请求信息表【Newt0McLimitChangeReqDO】对象列表信息
     *
     * @mbggenerated Mon Jan 11 11:09:30 CST 2016
     */
    public String selectByExample(Newt0McLimitChangeReqDOExample example) {
        BEGIN();
        if (example != null && example.isDistinct()) {
            SELECT_DISTINCT("REQ_ID");
        } else {
            SELECT("REQ_ID");
        }
        SELECT("REQ_TIME");
        SELECT("CREATE_TIME");
        SELECT("REQ_NUM");
        SELECT("SUCCESS_NUM");
        SELECT("FAIL_NUM");
        SELECT("STATUS");
        SELECT("REQ_FILE_NAME");
        SELECT("UPDATE_TIME");
        SELECT("REQ_TYPE");
        FROM("NEWT0_MC_LIMIT_CHANGE_REQ");
        applyWhere(example, false);
        
        if (example != null && example.getOrderByClause() != null) {
            ORDER_BY(example.getOrderByClause());
        }
        
        return SQL();
    }

    /**
     * 根据Query对象分页查询商户额度变更请求信息表【Newt0McLimitChangeReqDO】对象列表信息
     *
     * @mbggenerated Mon Jan 11 11:09:30 CST 2016
     */
    public String selectByQuery(Newt0McLimitChangeReqDOExample example) {
        BEGIN();
        if (example != null && example.isDistinct()) {
            SELECT_DISTINCT("REQ_ID");
        } else {
            SELECT("REQ_ID");
        }
        SELECT("REQ_TIME");
        SELECT("CREATE_TIME");
        SELECT("REQ_NUM");
        SELECT("SUCCESS_NUM");
        SELECT("FAIL_NUM");
        SELECT("STATUS");
        SELECT("REQ_FILE_NAME");
        SELECT("UPDATE_TIME");
        SELECT("REQ_TYPE");
        FROM("NEWT0_MC_LIMIT_CHANGE_REQ");
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
     * 根据Example对象更新商户额度变更请求信息表【Newt0McLimitChangeReqDO】对象信息，仅更新非空字段
     *
     * @mbggenerated Mon Jan 11 11:09:30 CST 2016
     */
    public String updateByExampleSelective(Map<String, Object> parameter) {
        Newt0McLimitChangeReqDO record = (Newt0McLimitChangeReqDO) parameter.get("record");
        Newt0McLimitChangeReqDOExample example = (Newt0McLimitChangeReqDOExample) parameter.get("example");
        
        BEGIN();
        UPDATE("NEWT0_MC_LIMIT_CHANGE_REQ");
        
        if (record.getReqId() != null) {
            SET("REQ_ID = #{record.reqId,jdbcType=DECIMAL}");
        }
        
        if (record.getReqTime() != null) {
            SET("REQ_TIME = #{record.reqTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getCreateTime() != null) {
            SET("CREATE_TIME = #{record.createTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getReqNum() != null) {
            SET("REQ_NUM = #{record.reqNum,jdbcType=DECIMAL}");
        }
        
        if (record.getSuccessNum() != null) {
            SET("SUCCESS_NUM = #{record.successNum,jdbcType=DECIMAL}");
        }
        
        if (record.getFailNum() != null) {
            SET("FAIL_NUM = #{record.failNum,jdbcType=DECIMAL}");
        }
        
        if (record.getStatus() != null) {
            SET("STATUS = #{record.status,jdbcType=DECIMAL}");
        }
        
        if (record.getReqFileName() != null) {
            SET("REQ_FILE_NAME = #{record.reqFileName,jdbcType=VARCHAR}");
        }
        
        if (record.getUpdateTime() != null) {
            SET("UPDATE_TIME = #{record.updateTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getReqType() != null) {
            SET("REQ_TYPE = #{record.reqType,jdbcType=DECIMAL}");
        }
        
        applyWhere(example, true);
        return SQL();
    }

    /**
     * 根据Example对象更新商户额度变更请求信息表【Newt0McLimitChangeReqDO】对象信息
     *
     * @mbggenerated Mon Jan 11 11:09:30 CST 2016
     */
    public String updateByExample(Map<String, Object> parameter) {
        BEGIN();
        UPDATE("NEWT0_MC_LIMIT_CHANGE_REQ");
        
        SET("REQ_ID = #{record.reqId,jdbcType=DECIMAL}");
        SET("REQ_TIME = #{record.reqTime,jdbcType=TIMESTAMP}");
        SET("CREATE_TIME = #{record.createTime,jdbcType=TIMESTAMP}");
        SET("REQ_NUM = #{record.reqNum,jdbcType=DECIMAL}");
        SET("SUCCESS_NUM = #{record.successNum,jdbcType=DECIMAL}");
        SET("FAIL_NUM = #{record.failNum,jdbcType=DECIMAL}");
        SET("STATUS = #{record.status,jdbcType=DECIMAL}");
        SET("REQ_FILE_NAME = #{record.reqFileName,jdbcType=VARCHAR}");
        SET("UPDATE_TIME = #{record.updateTime,jdbcType=TIMESTAMP}");
        SET("REQ_TYPE = #{record.reqType,jdbcType=DECIMAL}");
        
        Newt0McLimitChangeReqDOExample example = (Newt0McLimitChangeReqDOExample) parameter.get("example");
        applyWhere(example, true);
        return SQL();
    }

    /**
     * 根据主键更新商户额度变更请求信息表【Newt0McLimitChangeReqDO】对象信息，仅更新非空对象
     *
     * @mbggenerated Mon Jan 11 11:09:30 CST 2016
     */
    public String updateByPrimaryKeySelective(Newt0McLimitChangeReqDO record) {
        BEGIN();
        UPDATE("NEWT0_MC_LIMIT_CHANGE_REQ");
        
        if (record.getReqTime() != null) {
            SET("REQ_TIME = #{reqTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getCreateTime() != null) {
            SET("CREATE_TIME = #{createTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getReqNum() != null) {
            SET("REQ_NUM = #{reqNum,jdbcType=DECIMAL}");
        }
        
        if (record.getSuccessNum() != null) {
            SET("SUCCESS_NUM = #{successNum,jdbcType=DECIMAL}");
        }
        
        if (record.getFailNum() != null) {
            SET("FAIL_NUM = #{failNum,jdbcType=DECIMAL}");
        }
        
        if (record.getStatus() != null) {
            SET("STATUS = #{status,jdbcType=DECIMAL}");
        }
        
        if (record.getReqFileName() != null) {
            SET("REQ_FILE_NAME = #{reqFileName,jdbcType=VARCHAR}");
        }
        
        if (record.getUpdateTime() != null) {
            SET("UPDATE_TIME = #{updateTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getReqType() != null) {
            SET("REQ_TYPE = #{reqType,jdbcType=DECIMAL}");
        }
        
        WHERE("REQ_ID = #{reqId,jdbcType=DECIMAL}");
        
        return SQL();
    }

    /**
     * This method corresponds to the database table NEWT0_MC_LIMIT_CHANGE_REQ
     *
     * @mbggenerated Mon Jan 11 11:09:30 CST 2016
     */
    protected void applyWhere(Newt0McLimitChangeReqDOExample example, boolean includeExamplePhrase) {
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
        
        if (example.getReqId() != null) {
            sb.append(" and  REQ_ID = #{reqId,jdbcType=DECIMAL} ");
        }
        
        if (example.getReqTime() != null) {
            sb.append(" and  REQ_TIME = #{reqTime,jdbcType=TIMESTAMP} ");
        }
        
        if (example.getCreateTime() != null) {
            sb.append(" and  CREATE_TIME = #{createTime,jdbcType=TIMESTAMP} ");
        }
        
        if (example.getReqNum() != null) {
            sb.append(" and  REQ_NUM = #{reqNum,jdbcType=DECIMAL} ");
        }
        
        if (example.getSuccessNum() != null) {
            sb.append(" and  SUCCESS_NUM = #{successNum,jdbcType=DECIMAL} ");
        }
        
        if (example.getFailNum() != null) {
            sb.append(" and  FAIL_NUM = #{failNum,jdbcType=DECIMAL} ");
        }
        
        if (example.getStatus() != null) {
            sb.append(" and  STATUS = #{status,jdbcType=DECIMAL} ");
        }
        
        if (example.getReqFileName() != null && !example.getReqFileName().equals("") ) {
            sb.append(" and  REQ_FILE_NAME = #{reqFileName,jdbcType=VARCHAR} ");
        }
        
        if (example.getUpdateTime() != null) {
            sb.append(" and  UPDATE_TIME = #{updateTime,jdbcType=TIMESTAMP} ");
        }
        
        if (example.getReqType() != null) {
            sb.append(" and  REQ_TYPE = #{reqType,jdbcType=DECIMAL} ");
        }
        WHERE(sb.toString());
    }
}