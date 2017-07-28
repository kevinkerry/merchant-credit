package com.sdp.mc.mcwithfunding.dao.mapper;

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

import com.sdp.mc.mcwithfunding.dao.WithCapital4PromoterDO;
import com.sdp.mc.mcwithfunding.dao.WithCapital4PromoterDOExample.Criteria;
import com.sdp.mc.mcwithfunding.dao.WithCapital4PromoterDOExample.Criterion;
import com.sdp.mc.mcwithfunding.dao.WithCapital4PromoterDOExample;
import java.util.List;
import java.util.Map;

public class WithCapital4PromoterSqlProvider {

    /**
     * 根据Example对象取得代理商配资记录表【WithCapital4PromoterDO】对象count信息
     *
     * @mbggenerated Mon Jun 08 14:31:48 CST 2015
     */
    public String countByExample(WithCapital4PromoterDOExample example) {
        BEGIN();
        SELECT("count(*)");
        FROM("MC_WITH_CAPITAL_4PROMOTER");
        applyWhere(example, false);
        return SQL();
    }

    /**
     * 根据Example对象删除代理商配资记录表【WithCapital4PromoterDO】对象信息
     *
     * @mbggenerated Mon Jun 08 14:31:48 CST 2015
     */
    public String deleteByExample(WithCapital4PromoterDOExample example) {
        BEGIN();
        DELETE_FROM("MC_WITH_CAPITAL_4PROMOTER");
        applyWhere(example, false);
        return SQL();
    }

    /**
     * 添加代理商配资记录表【WithCapital4PromoterDO】对象信息,空值字段不插入
     *
     * @mbggenerated Mon Jun 08 14:31:48 CST 2015
     */
    public String insertSelective(WithCapital4PromoterDO record) {
        BEGIN();
        INSERT_INTO("MC_WITH_CAPITAL_4PROMOTER");
        
        VALUES("ID", "#{id,jdbcType=DECIMAL}");
        
        if (record.getMcType() != null) {
            VALUES("MC_TYPE", "#{mcType,jdbcType=VARCHAR}");
        }
        
        if (record.getPromoterId() != null) {
            VALUES("PROMOTER_ID", "#{promoterId,jdbcType=DECIMAL}");
        }
        
        if (record.getMerchantNo() != null) {
            VALUES("MERCHANT_NO", "#{merchantNo,jdbcType=VARCHAR}");
        }
        
        if (record.getPromoterName() != null) {
            VALUES("PROMOTER_NAME", "#{promoterName,jdbcType=VARCHAR}");
        }
        
        if (record.getApplyDatetime() != null) {
            VALUES("APPLY_DATETIME", "#{applyDatetime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getAmount() != null) {
            VALUES("AMOUNT", "#{amount,jdbcType=DECIMAL}");
        }
        
        if (record.getFeeRatio() != null) {
            VALUES("FEE_RATIO", "#{feeRatio,jdbcType=VARCHAR}");
        }
        
        if (record.getFee() != null) {
            VALUES("FEE", "#{fee,jdbcType=DECIMAL}");
        }
        
        if (record.getCreditFosId() != null) {
            VALUES("CREDIT_FOS_ID", "#{creditFosId,jdbcType=DECIMAL}");
        }
        
        if (record.getCreditChangeId() != null) {
            VALUES("CREDIT_CHANGE_ID", "#{creditChangeId,jdbcType=DECIMAL}");
        }
        
        if (record.getReversalFosId() != null) {
            VALUES("REVERSAL_FOS_ID", "#{reversalFosId,jdbcType=DECIMAL}");
        }
        
        if (record.getReversalChangeId() != null) {
            VALUES("REVERSAL_CHANGE_ID", "#{reversalChangeId,jdbcType=DECIMAL}");
        }
        
        if (record.getStatus() != null) {
            VALUES("STATUS", "#{status,jdbcType=DECIMAL}");
        }
        
        if (record.getUpdateTime() != null) {
            VALUES("UPDATE_TIME", "#{updateTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getBatchNo() != null) {
            VALUES("BATCH_NO", "#{batchNo,jdbcType=VARCHAR}");
        }
        
        if (record.getFeeFosId() != null) {
            VALUES("FEE_FOS_ID", "#{feeFosId,jdbcType=DECIMAL}");
        }
        
        if (record.getRecoveryDate() != null) {
            VALUES("RECOVERY_DATE", "#{recoveryDate,jdbcType=TIMESTAMP}");
        }
        
        if (record.getRetryTimes4msp() != null) {
            VALUES("RETRY_TIMES_4MSP", "#{retryTimes4msp,jdbcType=DECIMAL}");
        }
        
        return SQL();
    }

    /**
     * 根据Example对象查询得到代理商配资记录表【WithCapital4PromoterDO】对象列表信息
     *
     * @mbggenerated Mon Jun 08 14:31:48 CST 2015
     */
    public String selectByExample(WithCapital4PromoterDOExample example) {
        BEGIN();
        if (example != null && example.isDistinct()) {
            SELECT_DISTINCT("ID");
        } else {
            SELECT("ID");
        }
        SELECT("MC_TYPE");
        SELECT("PROMOTER_ID");
        SELECT("MERCHANT_NO");
        SELECT("PROMOTER_NAME");
        SELECT("APPLY_DATETIME");
        SELECT("AMOUNT");
        SELECT("FEE_RATIO");
        SELECT("FEE");
        SELECT("CREDIT_FOS_ID");
        SELECT("CREDIT_CHANGE_ID");
        SELECT("REVERSAL_FOS_ID");
        SELECT("REVERSAL_CHANGE_ID");
        SELECT("STATUS");
        SELECT("UPDATE_TIME");
        SELECT("BATCH_NO");
        SELECT("FEE_FOS_ID");
        SELECT("RECOVERY_DATE");
        SELECT("RETRY_TIMES_4MSP");
        FROM("MC_WITH_CAPITAL_4PROMOTER");
        applyWhere(example, false);
        
        if (example != null && example.getOrderByClause() != null) {
            ORDER_BY(example.getOrderByClause());
        }
        
        return SQL();
    }

    /**
     * 根据Query对象分页查询代理商配资记录表【WithCapital4PromoterDO】对象列表信息
     *
     * @mbggenerated Mon Jun 08 14:31:48 CST 2015
     */
    public String selectByQuery(WithCapital4PromoterDOExample example) {
        BEGIN();
        if (example != null && example.isDistinct()) {
            SELECT_DISTINCT("ID");
        } else {
            SELECT("ID");
        }
        SELECT("MC_TYPE");
        SELECT("PROMOTER_ID");
        SELECT("MERCHANT_NO");
        SELECT("PROMOTER_NAME");
        SELECT("APPLY_DATETIME");
        SELECT("AMOUNT");
        SELECT("FEE_RATIO");
        SELECT("FEE");
        SELECT("CREDIT_FOS_ID");
        SELECT("CREDIT_CHANGE_ID");
        SELECT("REVERSAL_FOS_ID");
        SELECT("REVERSAL_CHANGE_ID");
        SELECT("STATUS");
        SELECT("UPDATE_TIME");
        SELECT("BATCH_NO");
        SELECT("FEE_FOS_ID");
        SELECT("RECOVERY_DATE");
        SELECT("RETRY_TIMES_4MSP");
        FROM("MC_WITH_CAPITAL_4PROMOTER");
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
     * 根据Example对象更新代理商配资记录表【WithCapital4PromoterDO】对象信息，仅更新非空字段
     *
     * @mbggenerated Mon Jun 08 14:31:48 CST 2015
     */
    public String updateByExampleSelective(Map<String, Object> parameter) {
        WithCapital4PromoterDO record = (WithCapital4PromoterDO) parameter.get("record");
        WithCapital4PromoterDOExample example = (WithCapital4PromoterDOExample) parameter.get("example");
        
        BEGIN();
        UPDATE("MC_WITH_CAPITAL_4PROMOTER");
        
        if (record.getId() != null) {
            SET("ID = #{record.id,jdbcType=DECIMAL}");
        }
        
        if (record.getMcType() != null) {
            SET("MC_TYPE = #{record.mcType,jdbcType=VARCHAR}");
        }
        
        if (record.getPromoterId() != null) {
            SET("PROMOTER_ID = #{record.promoterId,jdbcType=DECIMAL}");
        }
        
        if (record.getMerchantNo() != null) {
            SET("MERCHANT_NO = #{record.merchantNo,jdbcType=VARCHAR}");
        }
        
        if (record.getPromoterName() != null) {
            SET("PROMOTER_NAME = #{record.promoterName,jdbcType=VARCHAR}");
        }
        
        if (record.getApplyDatetime() != null) {
            SET("APPLY_DATETIME = #{record.applyDatetime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getAmount() != null) {
            SET("AMOUNT = #{record.amount,jdbcType=DECIMAL}");
        }
        
        if (record.getFeeRatio() != null) {
            SET("FEE_RATIO = #{record.feeRatio,jdbcType=VARCHAR}");
        }
        
        if (record.getFee() != null) {
            SET("FEE = #{record.fee,jdbcType=DECIMAL}");
        }
        
        if (record.getCreditFosId() != null) {
            SET("CREDIT_FOS_ID = #{record.creditFosId,jdbcType=DECIMAL}");
        }
        
        if (record.getCreditChangeId() != null) {
            SET("CREDIT_CHANGE_ID = #{record.creditChangeId,jdbcType=DECIMAL}");
        }
        
        if (record.getReversalFosId() != null) {
            SET("REVERSAL_FOS_ID = #{record.reversalFosId,jdbcType=DECIMAL}");
        }
        
        if (record.getReversalChangeId() != null) {
            SET("REVERSAL_CHANGE_ID = #{record.reversalChangeId,jdbcType=DECIMAL}");
        }
        
        if (record.getStatus() != null) {
            SET("STATUS = #{record.status,jdbcType=DECIMAL}");
        }
        
        if (record.getUpdateTime() != null) {
            SET("UPDATE_TIME = #{record.updateTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getBatchNo() != null) {
            SET("BATCH_NO = #{record.batchNo,jdbcType=VARCHAR}");
        }
        
        if (record.getFeeFosId() != null) {
            SET("FEE_FOS_ID = #{record.feeFosId,jdbcType=DECIMAL}");
        }
        
        if (record.getRecoveryDate() != null) {
            SET("RECOVERY_DATE = #{record.recoveryDate,jdbcType=TIMESTAMP}");
        }
        
        if (record.getRetryTimes4msp() != null) {
            SET("RETRY_TIMES_4MSP = #{record.retryTimes4msp,jdbcType=DECIMAL}");
        }
        
        applyWhere(example, true);
        return SQL();
    }

    /**
     * 根据Example对象更新代理商配资记录表【WithCapital4PromoterDO】对象信息
     *
     * @mbggenerated Mon Jun 08 14:31:48 CST 2015
     */
    public String updateByExample(Map<String, Object> parameter) {
        BEGIN();
        UPDATE("MC_WITH_CAPITAL_4PROMOTER");
        
        SET("ID = #{record.id,jdbcType=DECIMAL}");
        SET("MC_TYPE = #{record.mcType,jdbcType=VARCHAR}");
        SET("PROMOTER_ID = #{record.promoterId,jdbcType=DECIMAL}");
        SET("MERCHANT_NO = #{record.merchantNo,jdbcType=VARCHAR}");
        SET("PROMOTER_NAME = #{record.promoterName,jdbcType=VARCHAR}");
        SET("APPLY_DATETIME = #{record.applyDatetime,jdbcType=TIMESTAMP}");
        SET("AMOUNT = #{record.amount,jdbcType=DECIMAL}");
        SET("FEE_RATIO = #{record.feeRatio,jdbcType=VARCHAR}");
        SET("FEE = #{record.fee,jdbcType=DECIMAL}");
        SET("CREDIT_FOS_ID = #{record.creditFosId,jdbcType=DECIMAL}");
        SET("CREDIT_CHANGE_ID = #{record.creditChangeId,jdbcType=DECIMAL}");
        SET("REVERSAL_FOS_ID = #{record.reversalFosId,jdbcType=DECIMAL}");
        SET("REVERSAL_CHANGE_ID = #{record.reversalChangeId,jdbcType=DECIMAL}");
        SET("STATUS = #{record.status,jdbcType=DECIMAL}");
        SET("UPDATE_TIME = #{record.updateTime,jdbcType=TIMESTAMP}");
        SET("BATCH_NO = #{record.batchNo,jdbcType=VARCHAR}");
        SET("FEE_FOS_ID = #{record.feeFosId,jdbcType=DECIMAL}");
        SET("RECOVERY_DATE = #{record.recoveryDate,jdbcType=TIMESTAMP}");
        SET("RETRY_TIMES_4MSP = #{record.retryTimes4msp,jdbcType=DECIMAL}");
        
        WithCapital4PromoterDOExample example = (WithCapital4PromoterDOExample) parameter.get("example");
        applyWhere(example, true);
        return SQL();
    }

    /**
     * 根据主键更新代理商配资记录表【WithCapital4PromoterDO】对象信息，仅更新非空对象
     *
     * @mbggenerated Mon Jun 08 14:31:48 CST 2015
     */
    public String updateByPrimaryKeySelective(WithCapital4PromoterDO record) {
        BEGIN();
        UPDATE("MC_WITH_CAPITAL_4PROMOTER");
        
        if (record.getMcType() != null) {
            SET("MC_TYPE = #{mcType,jdbcType=VARCHAR}");
        }
        
        if (record.getPromoterId() != null) {
            SET("PROMOTER_ID = #{promoterId,jdbcType=DECIMAL}");
        }
        
        if (record.getMerchantNo() != null) {
            SET("MERCHANT_NO = #{merchantNo,jdbcType=VARCHAR}");
        }
        
        if (record.getPromoterName() != null) {
            SET("PROMOTER_NAME = #{promoterName,jdbcType=VARCHAR}");
        }
        
        if (record.getApplyDatetime() != null) {
            SET("APPLY_DATETIME = #{applyDatetime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getAmount() != null) {
            SET("AMOUNT = #{amount,jdbcType=DECIMAL}");
        }
        
        if (record.getFeeRatio() != null) {
            SET("FEE_RATIO = #{feeRatio,jdbcType=VARCHAR}");
        }
        
        if (record.getFee() != null) {
            SET("FEE = #{fee,jdbcType=DECIMAL}");
        }
        
        if (record.getCreditFosId() != null) {
            SET("CREDIT_FOS_ID = #{creditFosId,jdbcType=DECIMAL}");
        }
        
        if (record.getCreditChangeId() != null) {
            SET("CREDIT_CHANGE_ID = #{creditChangeId,jdbcType=DECIMAL}");
        }
        
        if (record.getReversalFosId() != null) {
            SET("REVERSAL_FOS_ID = #{reversalFosId,jdbcType=DECIMAL}");
        }
        
        if (record.getReversalChangeId() != null) {
            SET("REVERSAL_CHANGE_ID = #{reversalChangeId,jdbcType=DECIMAL}");
        }
        
        if (record.getStatus() != null) {
            SET("STATUS = #{status,jdbcType=DECIMAL}");
        }
        
        if (record.getUpdateTime() != null) {
            SET("UPDATE_TIME = #{updateTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getBatchNo() != null) {
            SET("BATCH_NO = #{batchNo,jdbcType=VARCHAR}");
        }
        
        if (record.getFeeFosId() != null) {
            SET("FEE_FOS_ID = #{feeFosId,jdbcType=DECIMAL}");
        }
        
        if (record.getRecoveryDate() != null) {
            SET("RECOVERY_DATE = #{recoveryDate,jdbcType=TIMESTAMP}");
        }
        
        if (record.getRetryTimes4msp() != null) {
            SET("RETRY_TIMES_4MSP = #{retryTimes4msp,jdbcType=DECIMAL}");
        }
        
        WHERE("ID = #{id,jdbcType=DECIMAL}");
        
        return SQL();
    }

    /**
     * This method corresponds to the database table MC_WITH_CAPITAL_4PROMOTER
     *
     * @mbggenerated Mon Jun 08 14:31:48 CST 2015
     */
    protected void applyWhere(WithCapital4PromoterDOExample example, boolean includeExamplePhrase) {
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
        
        if (example.getMcType() != null && !example.getMcType().equals("") ) {
            sb.append(" and  MC_TYPE = #{mcType,jdbcType=VARCHAR} ");
        }
        
        if (example.getPromoterId() != null) {
            sb.append(" and  PROMOTER_ID = #{promoterId,jdbcType=DECIMAL} ");
        }
        
        if (example.getMerchantNo() != null && !example.getMerchantNo().equals("") ) {
            sb.append(" and  MERCHANT_NO = #{merchantNo,jdbcType=VARCHAR} ");
        }
        
        if (example.getPromoterName() != null && !example.getPromoterName().equals("") ) {
            sb.append(" and  PROMOTER_NAME = #{promoterName,jdbcType=VARCHAR} ");
        }
        
        if (example.getApplyDatetime() != null) {
            sb.append(" and  APPLY_DATETIME = #{applyDatetime,jdbcType=TIMESTAMP} ");
        }
        
        if (example.getAmount() != null) {
            sb.append(" and  AMOUNT = #{amount,jdbcType=DECIMAL} ");
        }
        
        if (example.getFeeRatio() != null && !example.getFeeRatio().equals("") ) {
            sb.append(" and  FEE_RATIO = #{feeRatio,jdbcType=VARCHAR} ");
        }
        
        if (example.getFee() != null) {
            sb.append(" and  FEE = #{fee,jdbcType=DECIMAL} ");
        }
        
        if (example.getCreditFosId() != null) {
            sb.append(" and  CREDIT_FOS_ID = #{creditFosId,jdbcType=DECIMAL} ");
        }
        
        if (example.getCreditChangeId() != null) {
            sb.append(" and  CREDIT_CHANGE_ID = #{creditChangeId,jdbcType=DECIMAL} ");
        }
        
        if (example.getReversalFosId() != null) {
            sb.append(" and  REVERSAL_FOS_ID = #{reversalFosId,jdbcType=DECIMAL} ");
        }
        
        if (example.getReversalChangeId() != null) {
            sb.append(" and  REVERSAL_CHANGE_ID = #{reversalChangeId,jdbcType=DECIMAL} ");
        }
        
        if (example.getStatus() != null) {
            sb.append(" and  STATUS = #{status,jdbcType=DECIMAL} ");
        }
        
        if (example.getUpdateTime() != null) {
            sb.append(" and  UPDATE_TIME = #{updateTime,jdbcType=TIMESTAMP} ");
        }
        
        if (example.getBatchNo() != null && !example.getBatchNo().equals("") ) {
            sb.append(" and  BATCH_NO = #{batchNo,jdbcType=VARCHAR} ");
        }
        
        if (example.getFeeFosId() != null) {
            sb.append(" and  FEE_FOS_ID = #{feeFosId,jdbcType=DECIMAL} ");
        }
        
        if (example.getRecoveryDate() != null) {
            sb.append(" and  RECOVERY_DATE = #{recoveryDate,jdbcType=TIMESTAMP} ");
        }
        
        if (example.getRetryTimes4msp() != null) {
            sb.append(" and  RETRY_TIMES_4MSP = #{retryTimes4msp,jdbcType=DECIMAL} ");
        }
        WHERE(sb.toString());
    }
}