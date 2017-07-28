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

import com.sdp.withdraw.dao.WithdrawInfoDO;
import com.sdp.withdraw.dao.WithdrawInfoDOExample.Criteria;
import com.sdp.withdraw.dao.WithdrawInfoDOExample.Criterion;
import com.sdp.withdraw.dao.WithdrawInfoDOExample;
import java.util.List;
import java.util.Map;

public class WithdrawInfoSqlProvider {

    /**
     * 根据Example对象取得提现出款额度信息【WithdrawInfoDO】对象count信息
     *
     * @mbggenerated Mon Mar 14 10:34:42 CST 2016
     */
    public String countByExample(WithdrawInfoDOExample example) {
        BEGIN();
        SELECT("count(*)");
        FROM("FW_WITHDRAW_INFO");
        applyWhere(example, false);
        return SQL();
    }

    /**
     * 根据Example对象删除提现出款额度信息【WithdrawInfoDO】对象信息
     *
     * @mbggenerated Mon Mar 14 10:34:42 CST 2016
     */
    public String deleteByExample(WithdrawInfoDOExample example) {
        BEGIN();
        DELETE_FROM("FW_WITHDRAW_INFO");
        applyWhere(example, false);
        return SQL();
    }

    /**
     * 添加提现出款额度信息【WithdrawInfoDO】对象信息,空值字段不插入
     *
     * @mbggenerated Mon Mar 14 10:34:42 CST 2016
     */
    public String insertSelective(WithdrawInfoDO record) {
        BEGIN();
        INSERT_INTO("FW_WITHDRAW_INFO");
        
        VALUES("ID", "#{id,jdbcType=DECIMAL}");
        
        if (record.getLimitationType() != null) {
            VALUES("LIMITATION_TYPE", "#{limitationType,jdbcType=DECIMAL}");
        }
        
        if (record.getBizId() != null) {
            VALUES("BIZ_ID", "#{bizId,jdbcType=DECIMAL}");
        }
        
        if (record.getBizType() != null) {
            VALUES("BIZ_TYPE", "#{bizType,jdbcType=DECIMAL}");
        }
        
        if (record.getLimitation() != null) {
            VALUES("LIMITATION", "#{limitation,jdbcType=DECIMAL}");
        }
        
        if (record.getForzenLimitation() != null) {
            VALUES("FORZEN_LIMITATION", "#{forzenLimitation,jdbcType=DECIMAL}");
        }
        
        if (record.getUsedLimitation() != null) {
            VALUES("USED_LIMITATION", "#{usedLimitation,jdbcType=DECIMAL}");
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
     * 根据Example对象查询得到提现出款额度信息【WithdrawInfoDO】对象列表信息
     *
     * @mbggenerated Mon Mar 14 10:34:42 CST 2016
     */
    public String selectByExample(WithdrawInfoDOExample example) {
        BEGIN();
        if (example != null && example.isDistinct()) {
            SELECT_DISTINCT("ID");
        } else {
            SELECT("ID");
        }
        SELECT("LIMITATION_TYPE");
        SELECT("BIZ_ID");
        SELECT("BIZ_TYPE");
        SELECT("LIMITATION");
        SELECT("FORZEN_LIMITATION");
        SELECT("USED_LIMITATION");
        SELECT("CREATE_TIME");
        SELECT("UPDATE_TIME");
        FROM("FW_WITHDRAW_INFO");
        applyWhere(example, false);
        
        if (example != null && example.getOrderByClause() != null) {
            ORDER_BY(example.getOrderByClause());
        }
        
        return SQL();
    }

    /**
     * 根据Query对象分页查询提现出款额度信息【WithdrawInfoDO】对象列表信息
     *
     * @mbggenerated Mon Mar 14 10:34:42 CST 2016
     */
    public String selectByQuery(WithdrawInfoDOExample example) {
        BEGIN();
        if (example != null && example.isDistinct()) {
            SELECT_DISTINCT("ID");
        } else {
            SELECT("ID");
        }
        SELECT("LIMITATION_TYPE");
        SELECT("BIZ_ID");
        SELECT("BIZ_TYPE");
        SELECT("LIMITATION");
        SELECT("FORZEN_LIMITATION");
        SELECT("USED_LIMITATION");
        SELECT("CREATE_TIME");
        SELECT("UPDATE_TIME");
        FROM("FW_WITHDRAW_INFO");
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
     * 根据Example对象更新提现出款额度信息【WithdrawInfoDO】对象信息，仅更新非空字段
     *
     * @mbggenerated Mon Mar 14 10:34:42 CST 2016
     */
    public String updateByExampleSelective(Map<String, Object> parameter) {
        WithdrawInfoDO record = (WithdrawInfoDO) parameter.get("record");
        WithdrawInfoDOExample example = (WithdrawInfoDOExample) parameter.get("example");
        
        BEGIN();
        UPDATE("FW_WITHDRAW_INFO");
        
        if (record.getId() != null) {
            SET("ID = #{record.id,jdbcType=DECIMAL}");
        }
        
        if (record.getLimitationType() != null) {
            SET("LIMITATION_TYPE = #{record.limitationType,jdbcType=DECIMAL}");
        }
        
        if (record.getBizId() != null) {
            SET("BIZ_ID = #{record.bizId,jdbcType=DECIMAL}");
        }
        
        if (record.getBizType() != null) {
            SET("BIZ_TYPE = #{record.bizType,jdbcType=DECIMAL}");
        }
        
        if (record.getLimitation() != null) {
            SET("LIMITATION = #{record.limitation,jdbcType=DECIMAL}");
        }
        
        if (record.getForzenLimitation() != null) {
            SET("FORZEN_LIMITATION = #{record.forzenLimitation,jdbcType=DECIMAL}");
        }
        
        if (record.getUsedLimitation() != null) {
            SET("USED_LIMITATION = #{record.usedLimitation,jdbcType=DECIMAL}");
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
     * 根据Example对象更新提现出款额度信息【WithdrawInfoDO】对象信息
     *
     * @mbggenerated Mon Mar 14 10:34:42 CST 2016
     */
    public String updateByExample(Map<String, Object> parameter) {
        BEGIN();
        UPDATE("FW_WITHDRAW_INFO");
        
        SET("ID = #{record.id,jdbcType=DECIMAL}");
        SET("LIMITATION_TYPE = #{record.limitationType,jdbcType=DECIMAL}");
        SET("BIZ_ID = #{record.bizId,jdbcType=DECIMAL}");
        SET("BIZ_TYPE = #{record.bizType,jdbcType=DECIMAL}");
        SET("LIMITATION = #{record.limitation,jdbcType=DECIMAL}");
        SET("FORZEN_LIMITATION = #{record.forzenLimitation,jdbcType=DECIMAL}");
        SET("USED_LIMITATION = #{record.usedLimitation,jdbcType=DECIMAL}");
        SET("CREATE_TIME = #{record.createTime,jdbcType=TIMESTAMP}");
        SET("UPDATE_TIME = #{record.updateTime,jdbcType=TIMESTAMP}");
        
        WithdrawInfoDOExample example = (WithdrawInfoDOExample) parameter.get("example");
        applyWhere(example, true);
        return SQL();
    }

    /**
     * 根据主键更新提现出款额度信息【WithdrawInfoDO】对象信息，仅更新非空对象
     *
     * @mbggenerated Mon Mar 14 10:34:42 CST 2016
     */
    public String updateByPrimaryKeySelective(WithdrawInfoDO record) {
        BEGIN();
        UPDATE("FW_WITHDRAW_INFO");
        
        if (record.getLimitationType() != null) {
            SET("LIMITATION_TYPE = #{limitationType,jdbcType=DECIMAL}");
        }
        
        if (record.getBizId() != null) {
            SET("BIZ_ID = #{bizId,jdbcType=DECIMAL}");
        }
        
        if (record.getBizType() != null) {
            SET("BIZ_TYPE = #{bizType,jdbcType=DECIMAL}");
        }
        
        if (record.getLimitation() != null) {
            SET("LIMITATION = #{limitation,jdbcType=DECIMAL}");
        }
        
        if (record.getForzenLimitation() != null) {
            SET("FORZEN_LIMITATION = #{forzenLimitation,jdbcType=DECIMAL}");
        }
        
        if (record.getUsedLimitation() != null) {
            SET("USED_LIMITATION = #{usedLimitation,jdbcType=DECIMAL}");
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
     * This method corresponds to the database table FW_WITHDRAW_INFO
     *
     * @mbggenerated Mon Mar 14 10:34:42 CST 2016
     */
    protected void applyWhere(WithdrawInfoDOExample example, boolean includeExamplePhrase) {
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
        
        if (example.getLimitationType() != null) {
            sb.append(" and  LIMITATION_TYPE = #{limitationType,jdbcType=DECIMAL} ");
        }
        
        if (example.getBizId() != null) {
            sb.append(" and  BIZ_ID = #{bizId,jdbcType=DECIMAL} ");
        }
        
        if (example.getBizType() != null) {
            sb.append(" and  BIZ_TYPE = #{bizType,jdbcType=DECIMAL} ");
        }
        
        if (example.getLimitation() != null) {
            sb.append(" and  LIMITATION = #{limitation,jdbcType=DECIMAL} ");
        }
        
        if (example.getForzenLimitation() != null) {
            sb.append(" and  FORZEN_LIMITATION = #{forzenLimitation,jdbcType=DECIMAL} ");
        }
        
        if (example.getUsedLimitation() != null) {
            sb.append(" and  USED_LIMITATION = #{usedLimitation,jdbcType=DECIMAL} ");
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