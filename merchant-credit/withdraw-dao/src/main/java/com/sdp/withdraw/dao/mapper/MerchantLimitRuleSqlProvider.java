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

import com.sdp.withdraw.dao.MerchantLimitRuleDO;
import com.sdp.withdraw.dao.MerchantLimitRuleDOExample.Criteria;
import com.sdp.withdraw.dao.MerchantLimitRuleDOExample.Criterion;
import com.sdp.withdraw.dao.MerchantLimitRuleDOExample;
import java.util.List;
import java.util.Map;

public class MerchantLimitRuleSqlProvider {

    /**
     * 根据Example对象取得null【MerchantLimitRuleDO】对象count信息
     *
     * @mbggenerated Wed Jul 19 14:41:21 CST 2017
     */
    public String countByExample(MerchantLimitRuleDOExample example) {
        BEGIN();
        SELECT("count(*)");
        FROM("FW_MERCHANT_LIMIT_RULE");
        applyWhere(example, false);
        return SQL();
    }

    /**
     * 根据Example对象删除null【MerchantLimitRuleDO】对象信息
     *
     * @mbggenerated Wed Jul 19 14:41:21 CST 2017
     */
    public String deleteByExample(MerchantLimitRuleDOExample example) {
        BEGIN();
        DELETE_FROM("FW_MERCHANT_LIMIT_RULE");
        applyWhere(example, false);
        return SQL();
    }

    /**
     * 添加null【MerchantLimitRuleDO】对象信息,空值字段不插入
     *
     * @mbggenerated Wed Jul 19 14:41:21 CST 2017
     */
    public String insertSelective(MerchantLimitRuleDO record) {
        BEGIN();
        INSERT_INTO("FW_MERCHANT_LIMIT_RULE");
        
        VALUES("ID", "#{id,jdbcType=DECIMAL}");
        
        if (record.getType() != null) {
            VALUES("TYPE", "#{type,jdbcType=DECIMAL}");
        }
        
        if (record.getMerchantType() != null) {
            VALUES("MERCHANT_TYPE", "#{merchantType,jdbcType=VARCHAR}");
        }
        
        if (record.getMerchantNo() != null) {
            VALUES("MERCHANT_NO", "#{merchantNo,jdbcType=VARCHAR}");
        }
        
        if (record.getLimit() != null) {
            VALUES("LIMIT", "#{limit,jdbcType=DECIMAL}");
        }
        
        if (record.getStatus() != null) {
            VALUES("STATUS", "#{status,jdbcType=DECIMAL}");
        }
        
        if (record.getOperatorId() != null) {
            VALUES("OPERATOR_ID", "#{operatorId,jdbcType=VARCHAR}");
        }
        
        if (record.getOperatorName() != null) {
            VALUES("OPERATOR_NAME", "#{operatorName,jdbcType=VARCHAR}");
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
     * 根据Example对象查询得到null【MerchantLimitRuleDO】对象列表信息
     *
     * @mbggenerated Wed Jul 19 14:41:21 CST 2017
     */
    public String selectByExample(MerchantLimitRuleDOExample example) {
        BEGIN();
        if (example != null && example.isDistinct()) {
            SELECT_DISTINCT("ID");
        } else {
            SELECT("ID");
        }
        SELECT("TYPE");
        SELECT("MERCHANT_TYPE");
        SELECT("MERCHANT_NO");
        SELECT("LIMIT");
        SELECT("STATUS");
        SELECT("OPERATOR_ID");
        SELECT("OPERATOR_NAME");
        SELECT("CREATE_TIME");
        SELECT("UPDATE_TIME");
        FROM("FW_MERCHANT_LIMIT_RULE");
        applyWhere(example, false);
        
        if (example != null && example.getOrderByClause() != null) {
            ORDER_BY(example.getOrderByClause());
        }
        
        return SQL();
    }

    /**
     * 根据Query对象分页查询null【MerchantLimitRuleDO】对象列表信息
     *
     * @mbggenerated Wed Jul 19 14:41:21 CST 2017
     */
    public String selectByQuery(MerchantLimitRuleDOExample example) {
        BEGIN();
        if (example != null && example.isDistinct()) {
            SELECT_DISTINCT("ID");
        } else {
            SELECT("ID");
        }
        SELECT("TYPE");
        SELECT("MERCHANT_TYPE");
        SELECT("MERCHANT_NO");
        SELECT("LIMIT");
        SELECT("STATUS");
        SELECT("OPERATOR_ID");
        SELECT("OPERATOR_NAME");
        SELECT("CREATE_TIME");
        SELECT("UPDATE_TIME");
        FROM("FW_MERCHANT_LIMIT_RULE");
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
     * 根据Example对象更新null【MerchantLimitRuleDO】对象信息，仅更新非空字段
     *
     * @mbggenerated Wed Jul 19 14:41:21 CST 2017
     */
    public String updateByExampleSelective(Map<String, Object> parameter) {
        MerchantLimitRuleDO record = (MerchantLimitRuleDO) parameter.get("record");
        MerchantLimitRuleDOExample example = (MerchantLimitRuleDOExample) parameter.get("example");
        
        BEGIN();
        UPDATE("FW_MERCHANT_LIMIT_RULE");
        
        if (record.getId() != null) {
            SET("ID = #{record.id,jdbcType=DECIMAL}");
        }
        
        if (record.getType() != null) {
            SET("TYPE = #{record.type,jdbcType=DECIMAL}");
        }
        
        if (record.getMerchantType() != null) {
            SET("MERCHANT_TYPE = #{record.merchantType,jdbcType=VARCHAR}");
        }
        
        if (record.getMerchantNo() != null) {
            SET("MERCHANT_NO = #{record.merchantNo,jdbcType=VARCHAR}");
        }
        
        if (record.getLimit() != null) {
            SET("LIMIT = #{record.limit,jdbcType=DECIMAL}");
        }
        
        if (record.getStatus() != null) {
            SET("STATUS = #{record.status,jdbcType=DECIMAL}");
        }
        
        if (record.getOperatorId() != null) {
            SET("OPERATOR_ID = #{record.operatorId,jdbcType=VARCHAR}");
        }
        
        if (record.getOperatorName() != null) {
            SET("OPERATOR_NAME = #{record.operatorName,jdbcType=VARCHAR}");
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
     * 根据Example对象更新null【MerchantLimitRuleDO】对象信息
     *
     * @mbggenerated Wed Jul 19 14:41:21 CST 2017
     */
    public String updateByExample(Map<String, Object> parameter) {
        BEGIN();
        UPDATE("FW_MERCHANT_LIMIT_RULE");
        
        SET("ID = #{record.id,jdbcType=DECIMAL}");
        SET("TYPE = #{record.type,jdbcType=DECIMAL}");
        SET("MERCHANT_TYPE = #{record.merchantType,jdbcType=VARCHAR}");
        SET("MERCHANT_NO = #{record.merchantNo,jdbcType=VARCHAR}");
        SET("LIMIT = #{record.limit,jdbcType=DECIMAL}");
        SET("STATUS = #{record.status,jdbcType=DECIMAL}");
        SET("OPERATOR_ID = #{record.operatorId,jdbcType=VARCHAR}");
        SET("OPERATOR_NAME = #{record.operatorName,jdbcType=VARCHAR}");
        SET("CREATE_TIME = #{record.createTime,jdbcType=TIMESTAMP}");
        SET("UPDATE_TIME = #{record.updateTime,jdbcType=TIMESTAMP}");
        
        MerchantLimitRuleDOExample example = (MerchantLimitRuleDOExample) parameter.get("example");
        applyWhere(example, true);
        return SQL();
    }

    /**
     * 根据主键更新null【MerchantLimitRuleDO】对象信息，仅更新非空对象
     *
     * @mbggenerated Wed Jul 19 14:41:21 CST 2017
     */
    public String updateByPrimaryKeySelective(MerchantLimitRuleDO record) {
        BEGIN();
        UPDATE("FW_MERCHANT_LIMIT_RULE");
        
        if (record.getType() != null) {
            SET("TYPE = #{type,jdbcType=DECIMAL}");
        }
        
        if (record.getMerchantType() != null) {
            SET("MERCHANT_TYPE = #{merchantType,jdbcType=VARCHAR}");
        }
        
        if (record.getMerchantNo() != null) {
            SET("MERCHANT_NO = #{merchantNo,jdbcType=VARCHAR}");
        }
        
        if (record.getLimit() != null) {
            SET("LIMIT = #{limit,jdbcType=DECIMAL}");
        }
        
        if (record.getStatus() != null) {
            SET("STATUS = #{status,jdbcType=DECIMAL}");
        }
        
        if (record.getOperatorId() != null) {
            SET("OPERATOR_ID = #{operatorId,jdbcType=VARCHAR}");
        }
        
        if (record.getOperatorName() != null) {
            SET("OPERATOR_NAME = #{operatorName,jdbcType=VARCHAR}");
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
     * This method corresponds to the database table FW_MERCHANT_LIMIT_RULE
     *
     * @mbggenerated Wed Jul 19 14:41:21 CST 2017
     */
    protected void applyWhere(MerchantLimitRuleDOExample example, boolean includeExamplePhrase) {
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
        
        if (example.getType() != null) {
            sb.append(" and  TYPE = #{type,jdbcType=DECIMAL} ");
        }
        
        if (example.getMerchantType() != null && !example.getMerchantType().equals("") ) {
            sb.append(" and  MERCHANT_TYPE = #{merchantType,jdbcType=VARCHAR} ");
        }
        
        if (example.getMerchantNo() != null && !example.getMerchantNo().equals("") ) {
            sb.append(" and  MERCHANT_NO = #{merchantNo,jdbcType=VARCHAR} ");
        }
        
        if (example.getLimit() != null) {
            sb.append(" and  LIMIT = #{limit,jdbcType=DECIMAL} ");
        }
        
        if (example.getStatus() != null) {
            sb.append(" and  STATUS = #{status,jdbcType=DECIMAL} ");
        }
        
        if (example.getOperatorId() != null && !example.getOperatorId().equals("") ) {
            sb.append(" and  OPERATOR_ID = #{operatorId,jdbcType=VARCHAR} ");
        }
        
        if (example.getOperatorName() != null && !example.getOperatorName().equals("") ) {
            sb.append(" and  OPERATOR_NAME = #{operatorName,jdbcType=VARCHAR} ");
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