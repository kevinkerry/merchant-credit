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

import com.sdp.withdraw.dao.WithdrawRetryPlanDO;
import com.sdp.withdraw.dao.WithdrawRetryPlanDOExample.Criteria;
import com.sdp.withdraw.dao.WithdrawRetryPlanDOExample.Criterion;
import com.sdp.withdraw.dao.WithdrawRetryPlanDOExample;
import java.util.List;
import java.util.Map;

public class WithdrawRetryPlanSqlProvider {

    /**
     * 根据Example对象取得出款服务重试计划表【WithdrawRetryPlanDO】对象count信息
     *
     * @mbggenerated Fri Mar 11 19:55:47 CST 2016
     */
    public String countByExample(WithdrawRetryPlanDOExample example) {
        BEGIN();
        SELECT("count(*)");
        FROM("FW_WITHDRAW_RETRY_PLAN");
        applyWhere(example, false);
        return SQL();
    }

    /**
     * 根据Example对象删除出款服务重试计划表【WithdrawRetryPlanDO】对象信息
     *
     * @mbggenerated Fri Mar 11 19:55:47 CST 2016
     */
    public String deleteByExample(WithdrawRetryPlanDOExample example) {
        BEGIN();
        DELETE_FROM("FW_WITHDRAW_RETRY_PLAN");
        applyWhere(example, false);
        return SQL();
    }

    /**
     * 添加出款服务重试计划表【WithdrawRetryPlanDO】对象信息,空值字段不插入
     *
     * @mbggenerated Fri Mar 11 19:55:47 CST 2016
     */
    public String insertSelective(WithdrawRetryPlanDO record) {
        BEGIN();
        INSERT_INTO("FW_WITHDRAW_RETRY_PLAN");
        
        VALUES("PLAN_ID", "#{planId,jdbcType=DECIMAL}");
        
        if (record.getReqId() != null) {
            VALUES("REQ_ID", "#{reqId,jdbcType=DECIMAL}");
        }
        
        if (record.getCurrentRemitVoucherNo() != null) {
            VALUES("CURRENT_REMIT_VOUCHER_NO", "#{currentRemitVoucherNo,jdbcType=VARCHAR}");
        }
        
        if (record.getExecuteRemitVoucherNo() != null) {
            VALUES("EXECUTE_REMIT_VOUCHER_NO", "#{executeRemitVoucherNo,jdbcType=VARCHAR}");
        }
        
        if (record.getRetryRule() != null) {
            VALUES("RETRY_RULE", "#{retryRule,jdbcType=VARCHAR}");
        }
        
        if (record.getRetryExecuteTimes() != null) {
            VALUES("RETRY_EXECUTE_TIMES", "#{retryExecuteTimes,jdbcType=DECIMAL}");
        }
        
        if (record.getExecuteStartTime() != null) {
            VALUES("EXECUTE_START_TIME", "#{executeStartTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getExecuteStatus() != null) {
            VALUES("EXECUTE_STATUS", "#{executeStatus,jdbcType=DECIMAL}");
        }
        
        if (record.getExecuteTime() != null) {
            VALUES("EXECUTE_TIME", "#{executeTime,jdbcType=TIMESTAMP}");
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
     * 根据Example对象查询得到出款服务重试计划表【WithdrawRetryPlanDO】对象列表信息
     *
     * @mbggenerated Fri Mar 11 19:55:47 CST 2016
     */
    public String selectByExample(WithdrawRetryPlanDOExample example) {
        BEGIN();
        if (example != null && example.isDistinct()) {
            SELECT_DISTINCT("PLAN_ID");
        } else {
            SELECT("PLAN_ID");
        }
        SELECT("REQ_ID");
        SELECT("CURRENT_REMIT_VOUCHER_NO");
        SELECT("EXECUTE_REMIT_VOUCHER_NO");
        SELECT("RETRY_RULE");
        SELECT("RETRY_EXECUTE_TIMES");
        SELECT("EXECUTE_START_TIME");
        SELECT("EXECUTE_STATUS");
        SELECT("EXECUTE_TIME");
        SELECT("CREATE_TIME");
        SELECT("UPDATE_TIME");
        FROM("FW_WITHDRAW_RETRY_PLAN");
        applyWhere(example, false);
        
        if (example != null && example.getOrderByClause() != null) {
            ORDER_BY(example.getOrderByClause());
        }
        
        return SQL();
    }

    /**
     * 根据Query对象分页查询出款服务重试计划表【WithdrawRetryPlanDO】对象列表信息
     *
     * @mbggenerated Fri Mar 11 19:55:47 CST 2016
     */
    public String selectByQuery(WithdrawRetryPlanDOExample example) {
        BEGIN();
        if (example != null && example.isDistinct()) {
            SELECT_DISTINCT("PLAN_ID");
        } else {
            SELECT("PLAN_ID");
        }
        SELECT("REQ_ID");
        SELECT("CURRENT_REMIT_VOUCHER_NO");
        SELECT("EXECUTE_REMIT_VOUCHER_NO");
        SELECT("RETRY_RULE");
        SELECT("RETRY_EXECUTE_TIMES");
        SELECT("EXECUTE_START_TIME");
        SELECT("EXECUTE_STATUS");
        SELECT("EXECUTE_TIME");
        SELECT("CREATE_TIME");
        SELECT("UPDATE_TIME");
        FROM("FW_WITHDRAW_RETRY_PLAN");
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
     * 根据Example对象更新出款服务重试计划表【WithdrawRetryPlanDO】对象信息，仅更新非空字段
     *
     * @mbggenerated Fri Mar 11 19:55:47 CST 2016
     */
    public String updateByExampleSelective(Map<String, Object> parameter) {
        WithdrawRetryPlanDO record = (WithdrawRetryPlanDO) parameter.get("record");
        WithdrawRetryPlanDOExample example = (WithdrawRetryPlanDOExample) parameter.get("example");
        
        BEGIN();
        UPDATE("FW_WITHDRAW_RETRY_PLAN");
        
        if (record.getPlanId() != null) {
            SET("PLAN_ID = #{record.planId,jdbcType=DECIMAL}");
        }
        
        if (record.getReqId() != null) {
            SET("REQ_ID = #{record.reqId,jdbcType=DECIMAL}");
        }
        
        if (record.getCurrentRemitVoucherNo() != null) {
            SET("CURRENT_REMIT_VOUCHER_NO = #{record.currentRemitVoucherNo,jdbcType=VARCHAR}");
        }
        
        if (record.getExecuteRemitVoucherNo() != null) {
            SET("EXECUTE_REMIT_VOUCHER_NO = #{record.executeRemitVoucherNo,jdbcType=VARCHAR}");
        }
        
        if (record.getRetryRule() != null) {
            SET("RETRY_RULE = #{record.retryRule,jdbcType=VARCHAR}");
        }
        
        if (record.getRetryExecuteTimes() != null) {
            SET("RETRY_EXECUTE_TIMES = #{record.retryExecuteTimes,jdbcType=DECIMAL}");
        }
        
        if (record.getExecuteStartTime() != null) {
            SET("EXECUTE_START_TIME = #{record.executeStartTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getExecuteStatus() != null) {
            SET("EXECUTE_STATUS = #{record.executeStatus,jdbcType=DECIMAL}");
        }
        
        if (record.getExecuteTime() != null) {
            SET("EXECUTE_TIME = #{record.executeTime,jdbcType=TIMESTAMP}");
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
     * 根据Example对象更新出款服务重试计划表【WithdrawRetryPlanDO】对象信息
     *
     * @mbggenerated Fri Mar 11 19:55:47 CST 2016
     */
    public String updateByExample(Map<String, Object> parameter) {
        BEGIN();
        UPDATE("FW_WITHDRAW_RETRY_PLAN");
        
        SET("PLAN_ID = #{record.planId,jdbcType=DECIMAL}");
        SET("REQ_ID = #{record.reqId,jdbcType=DECIMAL}");
        SET("CURRENT_REMIT_VOUCHER_NO = #{record.currentRemitVoucherNo,jdbcType=VARCHAR}");
        SET("EXECUTE_REMIT_VOUCHER_NO = #{record.executeRemitVoucherNo,jdbcType=VARCHAR}");
        SET("RETRY_RULE = #{record.retryRule,jdbcType=VARCHAR}");
        SET("RETRY_EXECUTE_TIMES = #{record.retryExecuteTimes,jdbcType=DECIMAL}");
        SET("EXECUTE_START_TIME = #{record.executeStartTime,jdbcType=TIMESTAMP}");
        SET("EXECUTE_STATUS = #{record.executeStatus,jdbcType=DECIMAL}");
        SET("EXECUTE_TIME = #{record.executeTime,jdbcType=TIMESTAMP}");
        SET("CREATE_TIME = #{record.createTime,jdbcType=TIMESTAMP}");
        SET("UPDATE_TIME = #{record.updateTime,jdbcType=TIMESTAMP}");
        
        WithdrawRetryPlanDOExample example = (WithdrawRetryPlanDOExample) parameter.get("example");
        applyWhere(example, true);
        return SQL();
    }

    /**
     * 根据主键更新出款服务重试计划表【WithdrawRetryPlanDO】对象信息，仅更新非空对象
     *
     * @mbggenerated Fri Mar 11 19:55:47 CST 2016
     */
    public String updateByPrimaryKeySelective(WithdrawRetryPlanDO record) {
        BEGIN();
        UPDATE("FW_WITHDRAW_RETRY_PLAN");
        
        if (record.getReqId() != null) {
            SET("REQ_ID = #{reqId,jdbcType=DECIMAL}");
        }
        
        if (record.getCurrentRemitVoucherNo() != null) {
            SET("CURRENT_REMIT_VOUCHER_NO = #{currentRemitVoucherNo,jdbcType=VARCHAR}");
        }
        
        if (record.getExecuteRemitVoucherNo() != null) {
            SET("EXECUTE_REMIT_VOUCHER_NO = #{executeRemitVoucherNo,jdbcType=VARCHAR}");
        }
        
        if (record.getRetryRule() != null) {
            SET("RETRY_RULE = #{retryRule,jdbcType=VARCHAR}");
        }
        
        if (record.getRetryExecuteTimes() != null) {
            SET("RETRY_EXECUTE_TIMES = #{retryExecuteTimes,jdbcType=DECIMAL}");
        }
        
        if (record.getExecuteStartTime() != null) {
            SET("EXECUTE_START_TIME = #{executeStartTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getExecuteStatus() != null) {
            SET("EXECUTE_STATUS = #{executeStatus,jdbcType=DECIMAL}");
        }
        
        if (record.getExecuteTime() != null) {
            SET("EXECUTE_TIME = #{executeTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getCreateTime() != null) {
            SET("CREATE_TIME = #{createTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getUpdateTime() != null) {
            SET("UPDATE_TIME = #{updateTime,jdbcType=TIMESTAMP}");
        }
        
        WHERE("PLAN_ID = #{planId,jdbcType=DECIMAL}");
        
        return SQL();
    }

    /**
     * This method corresponds to the database table FW_WITHDRAW_RETRY_PLAN
     *
     * @mbggenerated Fri Mar 11 19:55:47 CST 2016
     */
    protected void applyWhere(WithdrawRetryPlanDOExample example, boolean includeExamplePhrase) {
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
        
        if (example.getPlanId() != null) {
            sb.append(" and  PLAN_ID = #{planId,jdbcType=DECIMAL} ");
        }
        
        if (example.getReqId() != null) {
            sb.append(" and  REQ_ID = #{reqId,jdbcType=DECIMAL} ");
        }
        
        if (example.getCurrentRemitVoucherNo() != null && !example.getCurrentRemitVoucherNo().equals("") ) {
            sb.append(" and  CURRENT_REMIT_VOUCHER_NO = #{currentRemitVoucherNo,jdbcType=VARCHAR} ");
        }
        
        if (example.getExecuteRemitVoucherNo() != null && !example.getExecuteRemitVoucherNo().equals("") ) {
            sb.append(" and  EXECUTE_REMIT_VOUCHER_NO = #{executeRemitVoucherNo,jdbcType=VARCHAR} ");
        }
        
        if (example.getRetryRule() != null && !example.getRetryRule().equals("") ) {
            sb.append(" and  RETRY_RULE = #{retryRule,jdbcType=VARCHAR} ");
        }
        
        if (example.getRetryExecuteTimes() != null) {
            sb.append(" and  RETRY_EXECUTE_TIMES = #{retryExecuteTimes,jdbcType=DECIMAL} ");
        }
        
        if (example.getExecuteStartTime() != null) {
            sb.append(" and  EXECUTE_START_TIME = #{executeStartTime,jdbcType=TIMESTAMP} ");
        }
        
        if (example.getExecuteStatus() != null) {
            sb.append(" and  EXECUTE_STATUS = #{executeStatus,jdbcType=DECIMAL} ");
        }
        
        if (example.getExecuteTime() != null) {
            sb.append(" and  EXECUTE_TIME = #{executeTime,jdbcType=TIMESTAMP} ");
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