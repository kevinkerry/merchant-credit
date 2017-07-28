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

import com.sdp.mc.newt0.dao.Newt0LimitRuleInfoDO;
import com.sdp.mc.newt0.dao.Newt0LimitRuleInfoDOExample.Criteria;
import com.sdp.mc.newt0.dao.Newt0LimitRuleInfoDOExample.Criterion;
import com.sdp.mc.newt0.dao.Newt0LimitRuleInfoDOExample;
import java.util.List;
import java.util.Map;

public class Newt0LimitRuleInfoSqlProvider {

    /**
     * 根据Example对象取得商户额度规则信息【Newt0LimitRuleInfoDO】对象count信息
     *
     * @mbggenerated Sun Dec 20 09:53:28 CST 2015
     */
    public String countByExample(Newt0LimitRuleInfoDOExample example) {
        BEGIN();
        SELECT("count(*)");
        FROM("NEWT0_LIMIT_RULE_INFO");
        applyWhere(example, false);
        return SQL();
    }

    /**
     * 根据Example对象删除商户额度规则信息【Newt0LimitRuleInfoDO】对象信息
     *
     * @mbggenerated Sun Dec 20 09:53:28 CST 2015
     */
    public String deleteByExample(Newt0LimitRuleInfoDOExample example) {
        BEGIN();
        DELETE_FROM("NEWT0_LIMIT_RULE_INFO");
        applyWhere(example, false);
        return SQL();
    }

    /**
     * 添加商户额度规则信息【Newt0LimitRuleInfoDO】对象信息,空值字段不插入
     *
     * @mbggenerated Sun Dec 20 09:53:28 CST 2015
     */
    public String insertSelective(Newt0LimitRuleInfoDO record) {
        BEGIN();
        INSERT_INTO("NEWT0_LIMIT_RULE_INFO");
        
        if (record.getRuleName() != null) {
            VALUES("RULE_NAME", "#{ruleName,jdbcType=VARCHAR}");
        }
        
        if (record.getRuleLambda() != null) {
            VALUES("RULE_LAMBDA", "#{ruleLambda,jdbcType=VARCHAR}");
        }
        
        if (record.getLambdaDesc() != null) {
            VALUES("LAMBDA_DESC", "#{lambdaDesc,jdbcType=VARCHAR}");
        }
        
        if (record.getStatus() != null) {
            VALUES("STATUS", "#{status,jdbcType=DECIMAL}");
        }
        
        if (record.getCreateDate() != null) {
            VALUES("CREATE_DATE", "#{createDate,jdbcType=TIMESTAMP}");
        }
        
        if (record.getUpdateDate() != null) {
            VALUES("UPDATE_DATE", "#{updateDate,jdbcType=TIMESTAMP}");
        }
        
        return SQL();
    }

    /**
     * 根据Example对象查询得到商户额度规则信息【Newt0LimitRuleInfoDO】对象列表信息
     *
     * @mbggenerated Sun Dec 20 09:53:28 CST 2015
     */
    public String selectByExample(Newt0LimitRuleInfoDOExample example) {
        BEGIN();
        if (example != null && example.isDistinct()) {
            SELECT_DISTINCT("ID");
        } else {
            SELECT("ID");
        }
        SELECT("RULE_NAME");
        SELECT("RULE_LAMBDA");
        SELECT("LAMBDA_DESC");
        SELECT("STATUS");
        SELECT("CREATE_DATE");
        SELECT("UPDATE_DATE");
        FROM("NEWT0_LIMIT_RULE_INFO");
        applyWhere(example, false);
        
        if (example != null && example.getOrderByClause() != null) {
            ORDER_BY(example.getOrderByClause());
        }
        
        return SQL();
    }

    /**
     * 根据Query对象分页查询商户额度规则信息【Newt0LimitRuleInfoDO】对象列表信息
     *
     * @mbggenerated Sun Dec 20 09:53:28 CST 2015
     */
    public String selectByQuery(Newt0LimitRuleInfoDOExample example) {
        BEGIN();
        if (example != null && example.isDistinct()) {
            SELECT_DISTINCT("ID");
        } else {
            SELECT("ID");
        }
        SELECT("RULE_NAME");
        SELECT("RULE_LAMBDA");
        SELECT("LAMBDA_DESC");
        SELECT("STATUS");
        SELECT("CREATE_DATE");
        SELECT("UPDATE_DATE");
        FROM("NEWT0_LIMIT_RULE_INFO");
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
     * 根据Example对象更新商户额度规则信息【Newt0LimitRuleInfoDO】对象信息，仅更新非空字段
     *
     * @mbggenerated Sun Dec 20 09:53:28 CST 2015
     */
    public String updateByExampleSelective(Map<String, Object> parameter) {
        Newt0LimitRuleInfoDO record = (Newt0LimitRuleInfoDO) parameter.get("record");
        Newt0LimitRuleInfoDOExample example = (Newt0LimitRuleInfoDOExample) parameter.get("example");
        
        BEGIN();
        UPDATE("NEWT0_LIMIT_RULE_INFO");
        
        if (record.getId() != null) {
            SET("ID = #{record.id,jdbcType=DECIMAL}");
        }
        
        if (record.getRuleName() != null) {
            SET("RULE_NAME = #{record.ruleName,jdbcType=VARCHAR}");
        }
        
        if (record.getRuleLambda() != null) {
            SET("RULE_LAMBDA = #{record.ruleLambda,jdbcType=VARCHAR}");
        }
        
        if (record.getLambdaDesc() != null) {
            SET("LAMBDA_DESC = #{record.lambdaDesc,jdbcType=VARCHAR}");
        }
        
        if (record.getStatus() != null) {
            SET("STATUS = #{record.status,jdbcType=DECIMAL}");
        }
        
        if (record.getCreateDate() != null) {
            SET("CREATE_DATE = #{record.createDate,jdbcType=TIMESTAMP}");
        }
        
        if (record.getUpdateDate() != null) {
            SET("UPDATE_DATE = #{record.updateDate,jdbcType=TIMESTAMP}");
        }
        
        applyWhere(example, true);
        return SQL();
    }

    /**
     * 根据Example对象更新商户额度规则信息【Newt0LimitRuleInfoDO】对象信息
     *
     * @mbggenerated Sun Dec 20 09:53:28 CST 2015
     */
    public String updateByExample(Map<String, Object> parameter) {
        BEGIN();
        UPDATE("NEWT0_LIMIT_RULE_INFO");
        
        SET("ID = #{record.id,jdbcType=DECIMAL}");
        SET("RULE_NAME = #{record.ruleName,jdbcType=VARCHAR}");
        SET("RULE_LAMBDA = #{record.ruleLambda,jdbcType=VARCHAR}");
        SET("LAMBDA_DESC = #{record.lambdaDesc,jdbcType=VARCHAR}");
        SET("STATUS = #{record.status,jdbcType=DECIMAL}");
        SET("CREATE_DATE = #{record.createDate,jdbcType=TIMESTAMP}");
        SET("UPDATE_DATE = #{record.updateDate,jdbcType=TIMESTAMP}");
        
        Newt0LimitRuleInfoDOExample example = (Newt0LimitRuleInfoDOExample) parameter.get("example");
        applyWhere(example, true);
        return SQL();
    }

    /**
     * 根据主键更新商户额度规则信息【Newt0LimitRuleInfoDO】对象信息，仅更新非空对象
     *
     * @mbggenerated Sun Dec 20 09:53:28 CST 2015
     */
    public String updateByPrimaryKeySelective(Newt0LimitRuleInfoDO record) {
        BEGIN();
        UPDATE("NEWT0_LIMIT_RULE_INFO");
        
        if (record.getRuleName() != null) {
            SET("RULE_NAME = #{ruleName,jdbcType=VARCHAR}");
        }
        
        if (record.getRuleLambda() != null) {
            SET("RULE_LAMBDA = #{ruleLambda,jdbcType=VARCHAR}");
        }
        
        if (record.getLambdaDesc() != null) {
            SET("LAMBDA_DESC = #{lambdaDesc,jdbcType=VARCHAR}");
        }
        
        if (record.getStatus() != null) {
            SET("STATUS = #{status,jdbcType=DECIMAL}");
        }
        
        if (record.getCreateDate() != null) {
            SET("CREATE_DATE = #{createDate,jdbcType=TIMESTAMP}");
        }
        
        if (record.getUpdateDate() != null) {
            SET("UPDATE_DATE = #{updateDate,jdbcType=TIMESTAMP}");
        }
        
        WHERE("ID = #{id,jdbcType=DECIMAL}");
        
        return SQL();
    }

    /**
     * This method corresponds to the database table NEWT0_LIMIT_RULE_INFO
     *
     * @mbggenerated Sun Dec 20 09:53:28 CST 2015
     */
    protected void applyWhere(Newt0LimitRuleInfoDOExample example, boolean includeExamplePhrase) {
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
        
        if (example.getRuleName() != null && !example.getRuleName().equals("") ) {
            sb.append(" and  RULE_NAME = #{ruleName,jdbcType=VARCHAR} ");
        }
        
        if (example.getRuleLambda() != null && !example.getRuleLambda().equals("") ) {
            sb.append(" and  RULE_LAMBDA = #{ruleLambda,jdbcType=VARCHAR} ");
        }
        
        if (example.getLambdaDesc() != null && !example.getLambdaDesc().equals("") ) {
            sb.append(" and  LAMBDA_DESC = #{lambdaDesc,jdbcType=VARCHAR} ");
        }
        
        if (example.getStatus() != null) {
            sb.append(" and  STATUS = #{status,jdbcType=DECIMAL} ");
        }
        
        if (example.getCreateDate() != null) {
            sb.append(" and  CREATE_DATE = #{createDate,jdbcType=TIMESTAMP} ");
        }
        
        if (example.getUpdateDate() != null) {
            sb.append(" and  UPDATE_DATE = #{updateDate,jdbcType=TIMESTAMP} ");
        }
        WHERE(sb.toString());
    }
}