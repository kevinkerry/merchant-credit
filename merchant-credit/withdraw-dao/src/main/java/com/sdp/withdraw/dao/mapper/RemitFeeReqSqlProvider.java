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

import com.sdp.withdraw.dao.RemitFeeReqDo;
import com.sdp.withdraw.dao.RemitFeeReqDoExample.Criteria;
import com.sdp.withdraw.dao.RemitFeeReqDoExample.Criterion;
import com.sdp.withdraw.dao.RemitFeeReqDoExample;
import java.util.List;
import java.util.Map;

public class RemitFeeReqSqlProvider {

    /**
     * 根据Example对象取得退款记录【RemitFeeReqDo】对象count信息
     *
     * @mbggenerated Mon Apr 25 15:42:27 CST 2016
     */
    public String countByExample(RemitFeeReqDoExample example) {
        BEGIN();
        SELECT("count(*)");
        FROM("FW_REMIT_WITHDRAWFEE_REQ");
        applyWhere(example, false);
        return SQL();
    }

    /**
     * 根据Example对象删除退款记录【RemitFeeReqDo】对象信息
     *
     * @mbggenerated Mon Apr 25 15:42:27 CST 2016
     */
    public String deleteByExample(RemitFeeReqDoExample example) {
        BEGIN();
        DELETE_FROM("FW_REMIT_WITHDRAWFEE_REQ");
        applyWhere(example, false);
        return SQL();
    }

    /**
     * 添加退款记录【RemitFeeReqDo】对象信息,空值字段不插入
     *
     * @mbggenerated Mon Apr 25 15:42:27 CST 2016
     */
    public String insertSelective(RemitFeeReqDo record) {
        BEGIN();
        INSERT_INTO("FW_REMIT_WITHDRAWFEE_REQ");
        
        VALUES("REMIT_ID", "#{remitId,jdbcType=DECIMAL}");
        
        if (record.getReqId() != null) {
            VALUES("REQ_ID", "#{reqId,jdbcType=DECIMAL}");
        }
        
        if (record.getMtId() != null) {
            VALUES("MT_ID", "#{mtId,jdbcType=DECIMAL}");
        }
        
        if (record.getRemitamount() != null) {
            VALUES("REMITAMOUNT", "#{remitamount,jdbcType=DECIMAL}");
        }
        
        if (record.getStatus() != null) {
            VALUES("STATUS", "#{status,jdbcType=VARCHAR}");
        }
        
        if (record.getOpertator() != null) {
            VALUES("OPERTATOR", "#{opertator,jdbcType=VARCHAR}");
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
     * 根据Example对象查询得到退款记录【RemitFeeReqDo】对象列表信息
     *
     * @mbggenerated Mon Apr 25 15:42:27 CST 2016
     */
    public String selectByExample(RemitFeeReqDoExample example) {
        BEGIN();
        if (example != null && example.isDistinct()) {
            SELECT_DISTINCT("REMIT_ID");
        } else {
            SELECT("REMIT_ID");
        }
        SELECT("REQ_ID");
        SELECT("MT_ID");
        SELECT("REMITAMOUNT");
        SELECT("STATUS");
        SELECT("OPERTATOR");
        SELECT("CREATE_TIME");
        SELECT("UPDATE_TIME");
        FROM("FW_REMIT_WITHDRAWFEE_REQ");
        applyWhere(example, false);
        
        if (example != null && example.getOrderByClause() != null) {
            ORDER_BY(example.getOrderByClause());
        }
        
        return SQL();
    }

    /**
     * 根据Query对象分页查询退款记录【RemitFeeReqDo】对象列表信息
     *
     * @mbggenerated Mon Apr 25 15:42:27 CST 2016
     */
    public String selectByQuery(RemitFeeReqDoExample example) {
        BEGIN();
        if (example != null && example.isDistinct()) {
            SELECT_DISTINCT("REMIT_ID");
        } else {
            SELECT("REMIT_ID");
        }
        SELECT("REQ_ID");
        SELECT("MT_ID");
        SELECT("REMITAMOUNT");
        SELECT("STATUS");
        SELECT("OPERTATOR");
        SELECT("CREATE_TIME");
        SELECT("UPDATE_TIME");
        FROM("FW_REMIT_WITHDRAWFEE_REQ");
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
     * 根据Example对象更新退款记录【RemitFeeReqDo】对象信息，仅更新非空字段
     *
     * @mbggenerated Mon Apr 25 15:42:27 CST 2016
     */
    public String updateByExampleSelective(Map<String, Object> parameter) {
        RemitFeeReqDo record = (RemitFeeReqDo) parameter.get("record");
        RemitFeeReqDoExample example = (RemitFeeReqDoExample) parameter.get("example");
        
        BEGIN();
        UPDATE("FW_REMIT_WITHDRAWFEE_REQ");
        
        if (record.getRemitId() != null) {
            SET("REMIT_ID = #{record.remitId,jdbcType=DECIMAL}");
        }
        
        if (record.getReqId() != null) {
            SET("REQ_ID = #{record.reqId,jdbcType=DECIMAL}");
        }
        
        if (record.getMtId() != null) {
            SET("MT_ID = #{record.mtId,jdbcType=DECIMAL}");
        }
        
        if (record.getRemitamount() != null) {
            SET("REMITAMOUNT = #{record.remitamount,jdbcType=DECIMAL}");
        }
        
        if (record.getStatus() != null) {
            SET("STATUS = #{record.status,jdbcType=VARCHAR}");
        }
        
        if (record.getOpertator() != null) {
            SET("OPERTATOR = #{record.opertator,jdbcType=VARCHAR}");
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
     * 根据Example对象更新退款记录【RemitFeeReqDo】对象信息
     *
     * @mbggenerated Mon Apr 25 15:42:27 CST 2016
     */
    public String updateByExample(Map<String, Object> parameter) {
        BEGIN();
        UPDATE("FW_REMIT_WITHDRAWFEE_REQ");
        
        SET("REMIT_ID = #{record.remitId,jdbcType=DECIMAL}");
        SET("REQ_ID = #{record.reqId,jdbcType=DECIMAL}");
        SET("MT_ID = #{record.mtId,jdbcType=DECIMAL}");
        SET("REMITAMOUNT = #{record.remitamount,jdbcType=DECIMAL}");
        SET("STATUS = #{record.status,jdbcType=VARCHAR}");
        SET("OPERTATOR = #{record.opertator,jdbcType=VARCHAR}");
        SET("CREATE_TIME = #{record.createTime,jdbcType=TIMESTAMP}");
        SET("UPDATE_TIME = #{record.updateTime,jdbcType=TIMESTAMP}");
        
        RemitFeeReqDoExample example = (RemitFeeReqDoExample) parameter.get("example");
        applyWhere(example, true);
        return SQL();
    }

    /**
     * 根据主键更新退款记录【RemitFeeReqDo】对象信息，仅更新非空对象
     *
     * @mbggenerated Mon Apr 25 15:42:27 CST 2016
     */
    public String updateByPrimaryKeySelective(RemitFeeReqDo record) {
        BEGIN();
        UPDATE("FW_REMIT_WITHDRAWFEE_REQ");
        
        if (record.getReqId() != null) {
            SET("REQ_ID = #{reqId,jdbcType=DECIMAL}");
        }
        
        if (record.getMtId() != null) {
            SET("MT_ID = #{mtId,jdbcType=DECIMAL}");
        }
        
        if (record.getRemitamount() != null) {
            SET("REMITAMOUNT = #{remitamount,jdbcType=DECIMAL}");
        }
        
        if (record.getStatus() != null) {
            SET("STATUS = #{status,jdbcType=VARCHAR}");
        }
        
        if (record.getOpertator() != null) {
            SET("OPERTATOR = #{opertator,jdbcType=VARCHAR}");
        }
        
        if (record.getCreateTime() != null) {
            SET("CREATE_TIME = #{createTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getUpdateTime() != null) {
            SET("UPDATE_TIME = #{updateTime,jdbcType=TIMESTAMP}");
        }
        
        WHERE("REMIT_ID = #{remitId,jdbcType=DECIMAL}");
        
        return SQL();
    }

    /**
     * This method corresponds to the database table FW_REMIT_WITHDRAWFEE_REQ
     *
     * @mbggenerated Mon Apr 25 15:42:27 CST 2016
     */
    protected void applyWhere(RemitFeeReqDoExample example, boolean includeExamplePhrase) {
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
        
        if (example.getRemitId() != null) {
            sb.append(" and  REMIT_ID = #{remitId,jdbcType=DECIMAL} ");
        }
        
        if (example.getReqId() != null) {
            sb.append(" and  REQ_ID = #{reqId,jdbcType=DECIMAL} ");
        }
        
        if (example.getMtId() != null) {
            sb.append(" and  MT_ID = #{mtId,jdbcType=DECIMAL} ");
        }
        
        if (example.getRemitamount() != null) {
            sb.append(" and  REMITAMOUNT = #{remitamount,jdbcType=DECIMAL} ");
        }
        
        if (example.getStatus() != null && !example.getStatus().equals("") ) {
            sb.append(" and  STATUS = #{status,jdbcType=VARCHAR} ");
        }
        
        if (example.getOpertator() != null && !example.getOpertator().equals("") ) {
            sb.append(" and  OPERTATOR = #{opertator,jdbcType=VARCHAR} ");
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