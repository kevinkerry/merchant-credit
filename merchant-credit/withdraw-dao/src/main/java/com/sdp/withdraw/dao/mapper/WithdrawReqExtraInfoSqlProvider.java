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

import com.sdp.withdraw.dao.WithdrawReqExtraInfoDO;
import com.sdp.withdraw.dao.WithdrawReqExtraInfoDOExample.Criteria;
import com.sdp.withdraw.dao.WithdrawReqExtraInfoDOExample.Criterion;
import com.sdp.withdraw.dao.WithdrawReqExtraInfoDOExample;
import java.util.List;
import java.util.Map;

public class WithdrawReqExtraInfoSqlProvider {

    /**
     * 根据Example对象取得出款扩展信息【WithdrawReqExtraInfoDO】对象count信息
     *
     * @mbggenerated Tue Aug 30 09:37:59 CST 2016
     */
    public String countByExample(WithdrawReqExtraInfoDOExample example) {
        BEGIN();
        SELECT("count(*)");
        FROM("FW_WITHDRAW_REQ_EXTRA_INFO");
        applyWhere(example, false);
        return SQL();
    }

    /**
     * 根据Example对象删除出款扩展信息【WithdrawReqExtraInfoDO】对象信息
     *
     * @mbggenerated Tue Aug 30 09:37:59 CST 2016
     */
    public String deleteByExample(WithdrawReqExtraInfoDOExample example) {
        BEGIN();
        DELETE_FROM("FW_WITHDRAW_REQ_EXTRA_INFO");
        applyWhere(example, false);
        return SQL();
    }

    /**
     * 添加出款扩展信息【WithdrawReqExtraInfoDO】对象信息,空值字段不插入
     *
     * @mbggenerated Tue Aug 30 09:37:59 CST 2016
     */
    public String insertSelective(WithdrawReqExtraInfoDO record) {
        BEGIN();
        INSERT_INTO("FW_WITHDRAW_REQ_EXTRA_INFO");
        
        VALUES("ID", "#{id,jdbcType=DECIMAL}");
        
        if (record.getReqId() != null) {
            VALUES("REQ_ID", "#{reqId,jdbcType=DECIMAL}");
        }
        
        if (record.getPostPaidFlag() != null) {
            VALUES("POST_PAID_FLAG", "#{postPaidFlag,jdbcType=DECIMAL}");
        }
        
        if (record.getInitWithdrawAmount() != null) {
            VALUES("INIT_WITHDRAW_AMOUNT", "#{initWithdrawAmount,jdbcType=DECIMAL}");
        }
        
        if (record.getExtraValue1() != null) {
            VALUES("EXTRA_VALUE1", "#{extraValue1,jdbcType=VARCHAR}");
        }
        
        if (record.getExtraValue2() != null) {
            VALUES("EXTRA_VALUE2", "#{extraValue2,jdbcType=VARCHAR}");
        }
        
        if (record.getExtraValue3() != null) {
            VALUES("EXTRA_VALUE3", "#{extraValue3,jdbcType=VARCHAR}");
        }
        
        return SQL();
    }

    /**
     * 根据Example对象查询得到出款扩展信息【WithdrawReqExtraInfoDO】对象列表信息
     *
     * @mbggenerated Tue Aug 30 09:37:59 CST 2016
     */
    public String selectByExample(WithdrawReqExtraInfoDOExample example) {
        BEGIN();
        if (example != null && example.isDistinct()) {
            SELECT_DISTINCT("ID");
        } else {
            SELECT("ID");
        }
        SELECT("REQ_ID");
        SELECT("POST_PAID_FLAG");
        SELECT("INIT_WITHDRAW_AMOUNT");
        SELECT("EXTRA_VALUE1");
        SELECT("EXTRA_VALUE2");
        SELECT("EXTRA_VALUE3");
        FROM("FW_WITHDRAW_REQ_EXTRA_INFO");
        applyWhere(example, false);
        
        if (example != null && example.getOrderByClause() != null) {
            ORDER_BY(example.getOrderByClause());
        }
        
        return SQL();
    }

    /**
     * 根据Query对象分页查询出款扩展信息【WithdrawReqExtraInfoDO】对象列表信息
     *
     * @mbggenerated Tue Aug 30 09:37:59 CST 2016
     */
    public String selectByQuery(WithdrawReqExtraInfoDOExample example) {
        BEGIN();
        if (example != null && example.isDistinct()) {
            SELECT_DISTINCT("ID");
        } else {
            SELECT("ID");
        }
        SELECT("REQ_ID");
        SELECT("POST_PAID_FLAG");
        SELECT("INIT_WITHDRAW_AMOUNT");
        SELECT("EXTRA_VALUE1");
        SELECT("EXTRA_VALUE2");
        SELECT("EXTRA_VALUE3");
        FROM("FW_WITHDRAW_REQ_EXTRA_INFO");
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
     * 根据Example对象更新出款扩展信息【WithdrawReqExtraInfoDO】对象信息，仅更新非空字段
     *
     * @mbggenerated Tue Aug 30 09:37:59 CST 2016
     */
    public String updateByExampleSelective(Map<String, Object> parameter) {
        WithdrawReqExtraInfoDO record = (WithdrawReqExtraInfoDO) parameter.get("record");
        WithdrawReqExtraInfoDOExample example = (WithdrawReqExtraInfoDOExample) parameter.get("example");
        
        BEGIN();
        UPDATE("FW_WITHDRAW_REQ_EXTRA_INFO");
        
        if (record.getId() != null) {
            SET("ID = #{record.id,jdbcType=DECIMAL}");
        }
        
        if (record.getReqId() != null) {
            SET("REQ_ID = #{record.reqId,jdbcType=DECIMAL}");
        }
        
        if (record.getPostPaidFlag() != null) {
            SET("POST_PAID_FLAG = #{record.postPaidFlag,jdbcType=DECIMAL}");
        }
        
        if (record.getInitWithdrawAmount() != null) {
            SET("INIT_WITHDRAW_AMOUNT = #{record.initWithdrawAmount,jdbcType=DECIMAL}");
        }
        
        if (record.getExtraValue1() != null) {
            SET("EXTRA_VALUE1 = #{record.extraValue1,jdbcType=VARCHAR}");
        }
        
        if (record.getExtraValue2() != null) {
            SET("EXTRA_VALUE2 = #{record.extraValue2,jdbcType=VARCHAR}");
        }
        
        if (record.getExtraValue3() != null) {
            SET("EXTRA_VALUE3 = #{record.extraValue3,jdbcType=VARCHAR}");
        }
        
        applyWhere(example, true);
        return SQL();
    }

    /**
     * 根据Example对象更新出款扩展信息【WithdrawReqExtraInfoDO】对象信息
     *
     * @mbggenerated Tue Aug 30 09:37:59 CST 2016
     */
    public String updateByExample(Map<String, Object> parameter) {
        BEGIN();
        UPDATE("FW_WITHDRAW_REQ_EXTRA_INFO");
        
        SET("ID = #{record.id,jdbcType=DECIMAL}");
        SET("REQ_ID = #{record.reqId,jdbcType=DECIMAL}");
        SET("POST_PAID_FLAG = #{record.postPaidFlag,jdbcType=DECIMAL}");
        SET("INIT_WITHDRAW_AMOUNT = #{record.initWithdrawAmount,jdbcType=DECIMAL}");
        SET("EXTRA_VALUE1 = #{record.extraValue1,jdbcType=VARCHAR}");
        SET("EXTRA_VALUE2 = #{record.extraValue2,jdbcType=VARCHAR}");
        SET("EXTRA_VALUE3 = #{record.extraValue3,jdbcType=VARCHAR}");
        
        WithdrawReqExtraInfoDOExample example = (WithdrawReqExtraInfoDOExample) parameter.get("example");
        applyWhere(example, true);
        return SQL();
    }

    /**
     * 根据主键更新出款扩展信息【WithdrawReqExtraInfoDO】对象信息，仅更新非空对象
     *
     * @mbggenerated Tue Aug 30 09:37:59 CST 2016
     */
    public String updateByPrimaryKeySelective(WithdrawReqExtraInfoDO record) {
        BEGIN();
        UPDATE("FW_WITHDRAW_REQ_EXTRA_INFO");
        
        if (record.getReqId() != null) {
            SET("REQ_ID = #{reqId,jdbcType=DECIMAL}");
        }
        
        if (record.getPostPaidFlag() != null) {
            SET("POST_PAID_FLAG = #{postPaidFlag,jdbcType=DECIMAL}");
        }
        
        if (record.getInitWithdrawAmount() != null) {
            SET("INIT_WITHDRAW_AMOUNT = #{initWithdrawAmount,jdbcType=DECIMAL}");
        }
        
        if (record.getExtraValue1() != null) {
            SET("EXTRA_VALUE1 = #{extraValue1,jdbcType=VARCHAR}");
        }
        
        if (record.getExtraValue2() != null) {
            SET("EXTRA_VALUE2 = #{extraValue2,jdbcType=VARCHAR}");
        }
        
        if (record.getExtraValue3() != null) {
            SET("EXTRA_VALUE3 = #{extraValue3,jdbcType=VARCHAR}");
        }
        
        WHERE("ID = #{id,jdbcType=DECIMAL}");
        
        return SQL();
    }

    /**
     * This method corresponds to the database table FW_WITHDRAW_REQ_EXTRA_INFO
     *
     * @mbggenerated Tue Aug 30 09:37:59 CST 2016
     */
    protected void applyWhere(WithdrawReqExtraInfoDOExample example, boolean includeExamplePhrase) {
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
        
        if (example.getReqId() != null) {
            sb.append(" and  REQ_ID = #{reqId,jdbcType=DECIMAL} ");
        }
        
        if (example.getPostPaidFlag() != null) {
            sb.append(" and  POST_PAID_FLAG = #{postPaidFlag,jdbcType=DECIMAL} ");
        }
        
        if (example.getInitWithdrawAmount() != null) {
            sb.append(" and  INIT_WITHDRAW_AMOUNT = #{initWithdrawAmount,jdbcType=DECIMAL} ");
        }
        
        if (example.getExtraValue1() != null && !example.getExtraValue1().equals("") ) {
            sb.append(" and  EXTRA_VALUE1 = #{extraValue1,jdbcType=VARCHAR} ");
        }
        
        if (example.getExtraValue2() != null && !example.getExtraValue2().equals("") ) {
            sb.append(" and  EXTRA_VALUE2 = #{extraValue2,jdbcType=VARCHAR} ");
        }
        
        if (example.getExtraValue3() != null && !example.getExtraValue3().equals("") ) {
            sb.append(" and  EXTRA_VALUE3 = #{extraValue3,jdbcType=VARCHAR} ");
        }
        WHERE(sb.toString());
    }
}