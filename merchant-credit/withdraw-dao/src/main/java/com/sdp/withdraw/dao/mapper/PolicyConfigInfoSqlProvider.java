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

import com.sdp.withdraw.dao.PolicyConfigInfoDO;
import com.sdp.withdraw.dao.PolicyConfigInfoDOExample.Criteria;
import com.sdp.withdraw.dao.PolicyConfigInfoDOExample.Criterion;
import com.sdp.withdraw.dao.PolicyConfigInfoDOExample;
import java.util.List;
import java.util.Map;

public class PolicyConfigInfoSqlProvider {

    /**
     * 根据Example对象取得政策配置信息【PolicyConfigInfoDO】对象count信息
     *
     * @mbggenerated Mon Jul 17 13:57:18 CST 2017
     */
    public String countByExample(PolicyConfigInfoDOExample example) {
        BEGIN();
        SELECT("count(*)");
        FROM("FW_POLICY_CONFIG_INFO");
        applyWhere(example, false);
        return SQL();
    }

    /**
     * 根据Example对象删除政策配置信息【PolicyConfigInfoDO】对象信息
     *
     * @mbggenerated Mon Jul 17 13:57:18 CST 2017
     */
    public String deleteByExample(PolicyConfigInfoDOExample example) {
        BEGIN();
        DELETE_FROM("FW_POLICY_CONFIG_INFO");
        applyWhere(example, false);
        return SQL();
    }

    /**
     * 添加政策配置信息【PolicyConfigInfoDO】对象信息,空值字段不插入
     *
     * @mbggenerated Mon Jul 17 13:57:18 CST 2017
     */
    public String insertSelective(PolicyConfigInfoDO record) {
        BEGIN();
        INSERT_INTO("FW_POLICY_CONFIG_INFO");
        
        VALUES("ID", "#{id,jdbcType=DECIMAL}");
        
        if (record.getPolicyId() != null) {
            VALUES("POLICY_ID", "#{policyId,jdbcType=VARCHAR}");
        }
        
        if (record.getFastSettleFlag() != null) {
            VALUES("FAST_SETTLE_FLAG", "#{fastSettleFlag,jdbcType=DECIMAL}");
        }
        
        if (record.getAutoFastSettleFlag() != null) {
            VALUES("AUTO_FAST_SETTLE_FLAG", "#{autoFastSettleFlag,jdbcType=DECIMAL}");
        }
        
        if (record.getFastSettleLimit() != null) {
            VALUES("FAST_SETTLE_LIMIT", "#{fastSettleLimit,jdbcType=DECIMAL}");
        }
        
        if (record.getHolidayRatio() != null) {
            VALUES("HOLIDAY_RATIO", "#{holidayRatio,jdbcType=DECIMAL}");
        }
        
        if (record.getWorkdayRatio() != null) {
            VALUES("WORKDAY_RATIO", "#{workdayRatio,jdbcType=DECIMAL}");
        }
        
        if (record.getPromoterModifyFlag() != null) {
            VALUES("POMOTER_MODIFY_FLAG", "#{promoterModifyFlag,jdbcType=DECIMAL}");
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
        
        if (record.getCreateOperator() != null) {
            VALUES("CREATE_OPERATOR", "#{createOperator,jdbcType=VARCHAR}");
        }
        
        if (record.getUpdateOperator() != null) {
            VALUES("UPDATE_OPERATOR", "#{updateOperator,jdbcType=VARCHAR}");
        }
        
        if (record.getPolicyName() != null) {
            VALUES("POLICY_NAME", "#{policyName,jdbcType=VARCHAR}");
        }
        
        if (record.getPolicyType() != null) {
            VALUES("POLICY_TYPE", "#{policyType,jdbcType=DECIMAL}");
        }
        
        if (record.getDependCreditAuthFlag() != null) {
            VALUES("DEPEND_CREDIT_AUTH_FLAG", "#{dependCreditAuthFlag,jdbcType=DECIMAL}");
        }
        
        if (record.getWithdrawCost() != null) {
            VALUES("WITHDRAW_COST", "#{withdrawCost,jdbcType=DECIMAL}");
        }
        
        if (record.getQuotaType() != null) {
            VALUES("QUOTA_TYPE", "#{quotaType,jdbcType=DECIMAL}");
        }
        
        if (record.getOaTxnWithdrawCost() != null) {
            VALUES("OA_TXN_WITHDRAW_COST", "#{oaTxnWithdrawCost,jdbcType=DECIMAL}");
        }
        
        return SQL();
    }

    /**
     * 根据Example对象查询得到政策配置信息【PolicyConfigInfoDO】对象列表信息
     *
     * @mbggenerated Mon Jul 17 13:57:18 CST 2017
     */
    public String selectByExample(PolicyConfigInfoDOExample example) {
        BEGIN();
        if (example != null && example.isDistinct()) {
            SELECT_DISTINCT("ID");
        } else {
            SELECT("ID");
        }
        SELECT("POLICY_ID");
        SELECT("FAST_SETTLE_FLAG");
        SELECT("AUTO_FAST_SETTLE_FLAG");
        SELECT("FAST_SETTLE_LIMIT");
        SELECT("HOLIDAY_RATIO");
        SELECT("WORKDAY_RATIO");
        SELECT("POMOTER_MODIFY_FLAG");
        SELECT("STATUS");
        SELECT("CREATE_TIME");
        SELECT("UPDATE_TIME");
        SELECT("CREATE_OPERATOR");
        SELECT("UPDATE_OPERATOR");
        SELECT("POLICY_NAME");
        SELECT("POLICY_TYPE");
        SELECT("DEPEND_CREDIT_AUTH_FLAG");
        SELECT("WITHDRAW_COST");
        SELECT("QUOTA_TYPE");
        SELECT("OA_TXN_WITHDRAW_COST");
        FROM("FW_POLICY_CONFIG_INFO");
        applyWhere(example, false);
        
        if (example != null && example.getOrderByClause() != null) {
            ORDER_BY(example.getOrderByClause());
        }
        
        return SQL();
    }

    /**
     * 根据Query对象分页查询政策配置信息【PolicyConfigInfoDO】对象列表信息
     *
     * @mbggenerated Mon Jul 17 13:57:18 CST 2017
     */
    public String selectByQuery(PolicyConfigInfoDOExample example) {
        BEGIN();
        if (example != null && example.isDistinct()) {
            SELECT_DISTINCT("ID");
        } else {
            SELECT("ID");
        }
        SELECT("POLICY_ID");
        SELECT("FAST_SETTLE_FLAG");
        SELECT("AUTO_FAST_SETTLE_FLAG");
        SELECT("FAST_SETTLE_LIMIT");
        SELECT("HOLIDAY_RATIO");
        SELECT("WORKDAY_RATIO");
        SELECT("POMOTER_MODIFY_FLAG");
        SELECT("STATUS");
        SELECT("CREATE_TIME");
        SELECT("UPDATE_TIME");
        SELECT("CREATE_OPERATOR");
        SELECT("UPDATE_OPERATOR");
        SELECT("POLICY_NAME");
        SELECT("POLICY_TYPE");
        SELECT("DEPEND_CREDIT_AUTH_FLAG");
        SELECT("WITHDRAW_COST");
        SELECT("QUOTA_TYPE");
        SELECT("OA_TXN_WITHDRAW_COST");
        FROM("FW_POLICY_CONFIG_INFO");
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
     * 根据Example对象更新政策配置信息【PolicyConfigInfoDO】对象信息，仅更新非空字段
     *
     * @mbggenerated Mon Jul 17 13:57:18 CST 2017
     */
    public String updateByExampleSelective(Map<String, Object> parameter) {
        PolicyConfigInfoDO record = (PolicyConfigInfoDO) parameter.get("record");
        PolicyConfigInfoDOExample example = (PolicyConfigInfoDOExample) parameter.get("example");
        
        BEGIN();
        UPDATE("FW_POLICY_CONFIG_INFO");
        
        if (record.getId() != null) {
            SET("ID = #{record.id,jdbcType=DECIMAL}");
        }
        
        if (record.getPolicyId() != null) {
            SET("POLICY_ID = #{record.policyId,jdbcType=VARCHAR}");
        }
        
        if (record.getFastSettleFlag() != null) {
            SET("FAST_SETTLE_FLAG = #{record.fastSettleFlag,jdbcType=DECIMAL}");
        }
        
        if (record.getAutoFastSettleFlag() != null) {
            SET("AUTO_FAST_SETTLE_FLAG = #{record.autoFastSettleFlag,jdbcType=DECIMAL}");
        }
        
        if (record.getFastSettleLimit() != null) {
            SET("FAST_SETTLE_LIMIT = #{record.fastSettleLimit,jdbcType=DECIMAL}");
        }
        
        if (record.getHolidayRatio() != null) {
            SET("HOLIDAY_RATIO = #{record.holidayRatio,jdbcType=DECIMAL}");
        }
        
        if (record.getWorkdayRatio() != null) {
            SET("WORKDAY_RATIO = #{record.workdayRatio,jdbcType=DECIMAL}");
        }
        
        if (record.getPromoterModifyFlag() != null) {
            SET("POMOTER_MODIFY_FLAG = #{record.promoterModifyFlag,jdbcType=DECIMAL}");
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
        
        if (record.getCreateOperator() != null) {
            SET("CREATE_OPERATOR = #{record.createOperator,jdbcType=VARCHAR}");
        }
        
        if (record.getUpdateOperator() != null) {
            SET("UPDATE_OPERATOR = #{record.updateOperator,jdbcType=VARCHAR}");
        }
        
        if (record.getPolicyName() != null) {
            SET("POLICY_NAME = #{record.policyName,jdbcType=VARCHAR}");
        }
        
        if (record.getPolicyType() != null) {
            SET("POLICY_TYPE = #{record.policyType,jdbcType=DECIMAL}");
        }
        
        if (record.getDependCreditAuthFlag() != null) {
            SET("DEPEND_CREDIT_AUTH_FLAG = #{record.dependCreditAuthFlag,jdbcType=DECIMAL}");
        }
        
        if (record.getWithdrawCost() != null) {
            SET("WITHDRAW_COST = #{record.withdrawCost,jdbcType=DECIMAL}");
        }
        
        if (record.getQuotaType() != null) {
            SET("QUOTA_TYPE = #{record.quotaType,jdbcType=DECIMAL}");
        }
        
        if (record.getOaTxnWithdrawCost() != null) {
            SET("OA_TXN_WITHDRAW_COST = #{record.oaTxnWithdrawCost,jdbcType=DECIMAL}");
        }
        
        applyWhere(example, true);
        return SQL();
    }

    /**
     * 根据Example对象更新政策配置信息【PolicyConfigInfoDO】对象信息
     *
     * @mbggenerated Mon Jul 17 13:57:18 CST 2017
     */
    public String updateByExample(Map<String, Object> parameter) {
        BEGIN();
        UPDATE("FW_POLICY_CONFIG_INFO");
        
        SET("ID = #{record.id,jdbcType=DECIMAL}");
        SET("POLICY_ID = #{record.policyId,jdbcType=VARCHAR}");
        SET("FAST_SETTLE_FLAG = #{record.fastSettleFlag,jdbcType=DECIMAL}");
        SET("AUTO_FAST_SETTLE_FLAG = #{record.autoFastSettleFlag,jdbcType=DECIMAL}");
        SET("FAST_SETTLE_LIMIT = #{record.fastSettleLimit,jdbcType=DECIMAL}");
        SET("HOLIDAY_RATIO = #{record.holidayRatio,jdbcType=DECIMAL}");
        SET("WORKDAY_RATIO = #{record.workdayRatio,jdbcType=DECIMAL}");
        SET("POMOTER_MODIFY_FLAG = #{record.promoterModifyFlag,jdbcType=DECIMAL}");
        SET("STATUS = #{record.status,jdbcType=DECIMAL}");
        SET("CREATE_TIME = #{record.createTime,jdbcType=TIMESTAMP}");
        SET("UPDATE_TIME = #{record.updateTime,jdbcType=TIMESTAMP}");
        SET("CREATE_OPERATOR = #{record.createOperator,jdbcType=VARCHAR}");
        SET("UPDATE_OPERATOR = #{record.updateOperator,jdbcType=VARCHAR}");
        SET("POLICY_NAME = #{record.policyName,jdbcType=VARCHAR}");
        SET("POLICY_TYPE = #{record.policyType,jdbcType=DECIMAL}");
        SET("DEPEND_CREDIT_AUTH_FLAG = #{record.dependCreditAuthFlag,jdbcType=DECIMAL}");
        SET("WITHDRAW_COST = #{record.withdrawCost,jdbcType=DECIMAL}");
        SET("QUOTA_TYPE = #{record.quotaType,jdbcType=DECIMAL}");
        SET("OA_TXN_WITHDRAW_COST = #{record.oaTxnWithdrawCost,jdbcType=DECIMAL}");
        
        PolicyConfigInfoDOExample example = (PolicyConfigInfoDOExample) parameter.get("example");
        applyWhere(example, true);
        return SQL();
    }

    /**
     * 根据主键更新政策配置信息【PolicyConfigInfoDO】对象信息，仅更新非空对象
     *
     * @mbggenerated Mon Jul 17 13:57:18 CST 2017
     */
    public String updateByPrimaryKeySelective(PolicyConfigInfoDO record) {
        BEGIN();
        UPDATE("FW_POLICY_CONFIG_INFO");
        
        if (record.getPolicyId() != null) {
            SET("POLICY_ID = #{policyId,jdbcType=VARCHAR}");
        }
        
        if (record.getFastSettleFlag() != null) {
            SET("FAST_SETTLE_FLAG = #{fastSettleFlag,jdbcType=DECIMAL}");
        }
        
        if (record.getAutoFastSettleFlag() != null) {
            SET("AUTO_FAST_SETTLE_FLAG = #{autoFastSettleFlag,jdbcType=DECIMAL}");
        }
        
        if (record.getFastSettleLimit() != null) {
            SET("FAST_SETTLE_LIMIT = #{fastSettleLimit,jdbcType=DECIMAL}");
        }
        
        if (record.getHolidayRatio() != null) {
            SET("HOLIDAY_RATIO = #{holidayRatio,jdbcType=DECIMAL}");
        }
        
        if (record.getWorkdayRatio() != null) {
            SET("WORKDAY_RATIO = #{workdayRatio,jdbcType=DECIMAL}");
        }
        
        if (record.getPromoterModifyFlag() != null) {
            SET("POMOTER_MODIFY_FLAG = #{promoterModifyFlag,jdbcType=DECIMAL}");
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
        
        if (record.getCreateOperator() != null) {
            SET("CREATE_OPERATOR = #{createOperator,jdbcType=VARCHAR}");
        }
        
        if (record.getUpdateOperator() != null) {
            SET("UPDATE_OPERATOR = #{updateOperator,jdbcType=VARCHAR}");
        }
        
        if (record.getPolicyName() != null) {
            SET("POLICY_NAME = #{policyName,jdbcType=VARCHAR}");
        }
        
        if (record.getPolicyType() != null) {
            SET("POLICY_TYPE = #{policyType,jdbcType=DECIMAL}");
        }
        
        if (record.getDependCreditAuthFlag() != null) {
            SET("DEPEND_CREDIT_AUTH_FLAG = #{dependCreditAuthFlag,jdbcType=DECIMAL}");
        }
        
        if (record.getWithdrawCost() != null) {
            SET("WITHDRAW_COST = #{withdrawCost,jdbcType=DECIMAL}");
        }
        
        if (record.getQuotaType() != null) {
            SET("QUOTA_TYPE = #{quotaType,jdbcType=DECIMAL}");
        }
        
        if (record.getOaTxnWithdrawCost() != null) {
            SET("OA_TXN_WITHDRAW_COST = #{oaTxnWithdrawCost,jdbcType=DECIMAL}");
        }
        
        WHERE("ID = #{id,jdbcType=DECIMAL}");
        
        return SQL();
    }

    /**
     * This method corresponds to the database table FW_POLICY_CONFIG_INFO
     *
     * @mbggenerated Mon Jul 17 13:57:18 CST 2017
     */
    protected void applyWhere(PolicyConfigInfoDOExample example, boolean includeExamplePhrase) {
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
        
        if (example.getPolicyId() != null && !example.getPolicyId().equals("") ) {
            sb.append(" and  POLICY_ID = #{policyId,jdbcType=VARCHAR} ");
        }
        
        if (example.getFastSettleFlag() != null) {
            sb.append(" and  FAST_SETTLE_FLAG = #{fastSettleFlag,jdbcType=DECIMAL} ");
        }
        
        if (example.getAutoFastSettleFlag() != null) {
            sb.append(" and  AUTO_FAST_SETTLE_FLAG = #{autoFastSettleFlag,jdbcType=DECIMAL} ");
        }
        
        if (example.getFastSettleLimit() != null) {
            sb.append(" and  FAST_SETTLE_LIMIT = #{fastSettleLimit,jdbcType=DECIMAL} ");
        }
        
        if (example.getHolidayRatio() != null) {
            sb.append(" and  HOLIDAY_RATIO = #{holidayRatio,jdbcType=DECIMAL} ");
        }
        
        if (example.getWorkdayRatio() != null) {
            sb.append(" and  WORKDAY_RATIO = #{workdayRatio,jdbcType=DECIMAL} ");
        }
        
        if (example.getPromoterModifyFlag() != null) {
            sb.append(" and  POMOTER_MODIFY_FLAG = #{promoterModifyFlag,jdbcType=DECIMAL} ");
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
        
        if (example.getCreateOperator() != null && !example.getCreateOperator().equals("") ) {
            sb.append(" and  CREATE_OPERATOR = #{createOperator,jdbcType=VARCHAR} ");
        }
        
        if (example.getUpdateOperator() != null && !example.getUpdateOperator().equals("") ) {
            sb.append(" and  UPDATE_OPERATOR = #{updateOperator,jdbcType=VARCHAR} ");
        }
        
        if (example.getPolicyName() != null && !example.getPolicyName().equals("") ) {
            sb.append(" and  POLICY_NAME = #{policyName,jdbcType=VARCHAR} ");
        }
        
        if (example.getPolicyType() != null) {
            sb.append(" and  POLICY_TYPE = #{policyType,jdbcType=DECIMAL} ");
        }
        
        if (example.getDependCreditAuthFlag() != null) {
            sb.append(" and  DEPEND_CREDIT_AUTH_FLAG = #{dependCreditAuthFlag,jdbcType=DECIMAL} ");
        }
        
        if (example.getWithdrawCost() != null) {
            sb.append(" and  WITHDRAW_COST = #{withdrawCost,jdbcType=DECIMAL} ");
        }
        
        if (example.getQuotaType() != null) {
            sb.append(" and  QUOTA_TYPE = #{quotaType,jdbcType=DECIMAL} ");
        }
        
        if (example.getOaTxnWithdrawCost() != null) {
            sb.append(" and  OA_TXN_WITHDRAW_COST = #{oaTxnWithdrawCost,jdbcType=DECIMAL} ");
        }
        WHERE(sb.toString());
    }
}