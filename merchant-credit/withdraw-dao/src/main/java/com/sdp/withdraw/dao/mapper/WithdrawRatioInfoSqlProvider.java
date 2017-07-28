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

import com.sdp.withdraw.dao.WithdrawRatioInfoDO;
import com.sdp.withdraw.dao.WithdrawRatioInfoDOExample.Criteria;
import com.sdp.withdraw.dao.WithdrawRatioInfoDOExample.Criterion;
import com.sdp.withdraw.dao.WithdrawRatioInfoDOExample;
import java.util.List;
import java.util.Map;

public class WithdrawRatioInfoSqlProvider {

    /**
     * 根据Example对象取得提现出款费率信息【WithdrawRatioInfoDO】对象count信息
     *
     * @mbggenerated Fri Mar 11 19:55:30 CST 2016
     */
    public String countByExample(WithdrawRatioInfoDOExample example) {
        BEGIN();
        SELECT("count(*)");
        FROM("FW_WITHDRAW_RATIO_INFO");
        applyWhere(example, false);
        return SQL();
    }

    /**
     * 根据Example对象删除提现出款费率信息【WithdrawRatioInfoDO】对象信息
     *
     * @mbggenerated Fri Mar 11 19:55:30 CST 2016
     */
    public String deleteByExample(WithdrawRatioInfoDOExample example) {
        BEGIN();
        DELETE_FROM("FW_WITHDRAW_RATIO_INFO");
        applyWhere(example, false);
        return SQL();
    }

    /**
     * 添加提现出款费率信息【WithdrawRatioInfoDO】对象信息,空值字段不插入
     *
     * @mbggenerated Fri Mar 11 19:55:30 CST 2016
     */
    public String insertSelective(WithdrawRatioInfoDO record) {
        BEGIN();
        INSERT_INTO("FW_WITHDRAW_RATIO_INFO");
        
        VALUES("ID", "#{id,jdbcType=DECIMAL}");
        
        if (record.getBizId() != null) {
            VALUES("BIZ_ID", "#{bizId,jdbcType=DECIMAL}");
        }
        
        if (record.getRatioType() != null) {
            VALUES("RATIO_TYPE", "#{ratioType,jdbcType=DECIMAL}");
        }
        
        if (record.getStatus() != null) {
            VALUES("STATUS", "#{status,jdbcType=DECIMAL}");
        }
        
        if (record.getWorkDayRatio() != null) {
            VALUES("WORK_DAY_RATIO", "#{workDayRatio,jdbcType=DECIMAL}");
        }
        
        if (record.getHolidayRatio() != null) {
            VALUES("HOLIDAY_RATIO", "#{holidayRatio,jdbcType=DECIMAL}");
        }
        
        if (record.getEffectiveTime() != null) {
            VALUES("EFFECTIVE_TIME", "#{effectiveTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getExpireTime() != null) {
            VALUES("EXPIRE_TIME", "#{expireTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getCreteTime() != null) {
            VALUES("CRETE_TIME", "#{creteTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getUpdateTime() != null) {
            VALUES("UPDATE_TIME", "#{updateTime,jdbcType=TIMESTAMP}");
        }
        
        return SQL();
    }

    /**
     * 根据Example对象查询得到提现出款费率信息【WithdrawRatioInfoDO】对象列表信息
     *
     * @mbggenerated Fri Mar 11 19:55:30 CST 2016
     */
    public String selectByExample(WithdrawRatioInfoDOExample example) {
        BEGIN();
        if (example != null && example.isDistinct()) {
            SELECT_DISTINCT("ID");
        } else {
            SELECT("ID");
        }
        SELECT("BIZ_ID");
        SELECT("RATIO_TYPE");
        SELECT("STATUS");
        SELECT("WORK_DAY_RATIO");
        SELECT("HOLIDAY_RATIO");
        SELECT("EFFECTIVE_TIME");
        SELECT("EXPIRE_TIME");
        SELECT("CRETE_TIME");
        SELECT("UPDATE_TIME");
        FROM("FW_WITHDRAW_RATIO_INFO");
        applyWhere(example, false);
        
        if (example != null && example.getOrderByClause() != null) {
            ORDER_BY(example.getOrderByClause());
        }
        
        return SQL();
    }

    /**
     * 根据Query对象分页查询提现出款费率信息【WithdrawRatioInfoDO】对象列表信息
     *
     * @mbggenerated Fri Mar 11 19:55:30 CST 2016
     */
    public String selectByQuery(WithdrawRatioInfoDOExample example) {
        BEGIN();
        if (example != null && example.isDistinct()) {
            SELECT_DISTINCT("ID");
        } else {
            SELECT("ID");
        }
        SELECT("BIZ_ID");
        SELECT("RATIO_TYPE");
        SELECT("STATUS");
        SELECT("WORK_DAY_RATIO");
        SELECT("HOLIDAY_RATIO");
        SELECT("EFFECTIVE_TIME");
        SELECT("EXPIRE_TIME");
        SELECT("CRETE_TIME");
        SELECT("UPDATE_TIME");
        FROM("FW_WITHDRAW_RATIO_INFO");
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
     * 根据Example对象更新提现出款费率信息【WithdrawRatioInfoDO】对象信息，仅更新非空字段
     *
     * @mbggenerated Fri Mar 11 19:55:30 CST 2016
     */
    public String updateByExampleSelective(Map<String, Object> parameter) {
        WithdrawRatioInfoDO record = (WithdrawRatioInfoDO) parameter.get("record");
        WithdrawRatioInfoDOExample example = (WithdrawRatioInfoDOExample) parameter.get("example");
        
        BEGIN();
        UPDATE("FW_WITHDRAW_RATIO_INFO");
        
        if (record.getId() != null) {
            SET("ID = #{record.id,jdbcType=DECIMAL}");
        }
        
        if (record.getBizId() != null) {
            SET("BIZ_ID = #{record.bizId,jdbcType=DECIMAL}");
        }
        
        if (record.getRatioType() != null) {
            SET("RATIO_TYPE = #{record.ratioType,jdbcType=DECIMAL}");
        }
        
        if (record.getStatus() != null) {
            SET("STATUS = #{record.status,jdbcType=DECIMAL}");
        }
        
        if (record.getWorkDayRatio() != null) {
            SET("WORK_DAY_RATIO = #{record.workDayRatio,jdbcType=DECIMAL}");
        }
        
        if (record.getHolidayRatio() != null) {
            SET("HOLIDAY_RATIO = #{record.holidayRatio,jdbcType=DECIMAL}");
        }
        
        if (record.getEffectiveTime() != null) {
            SET("EFFECTIVE_TIME = #{record.effectiveTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getExpireTime() != null) {
            SET("EXPIRE_TIME = #{record.expireTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getCreteTime() != null) {
            SET("CRETE_TIME = #{record.creteTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getUpdateTime() != null) {
            SET("UPDATE_TIME = #{record.updateTime,jdbcType=TIMESTAMP}");
        }
        
        applyWhere(example, true);
        return SQL();
    }

    /**
     * 根据Example对象更新提现出款费率信息【WithdrawRatioInfoDO】对象信息
     *
     * @mbggenerated Fri Mar 11 19:55:30 CST 2016
     */
    public String updateByExample(Map<String, Object> parameter) {
        BEGIN();
        UPDATE("FW_WITHDRAW_RATIO_INFO");
        
        SET("ID = #{record.id,jdbcType=DECIMAL}");
        SET("BIZ_ID = #{record.bizId,jdbcType=DECIMAL}");
        SET("RATIO_TYPE = #{record.ratioType,jdbcType=DECIMAL}");
        SET("STATUS = #{record.status,jdbcType=DECIMAL}");
        SET("WORK_DAY_RATIO = #{record.workDayRatio,jdbcType=DECIMAL}");
        SET("HOLIDAY_RATIO = #{record.holidayRatio,jdbcType=DECIMAL}");
        SET("EFFECTIVE_TIME = #{record.effectiveTime,jdbcType=TIMESTAMP}");
        SET("EXPIRE_TIME = #{record.expireTime,jdbcType=TIMESTAMP}");
        SET("CRETE_TIME = #{record.creteTime,jdbcType=TIMESTAMP}");
        SET("UPDATE_TIME = #{record.updateTime,jdbcType=TIMESTAMP}");
        
        WithdrawRatioInfoDOExample example = (WithdrawRatioInfoDOExample) parameter.get("example");
        applyWhere(example, true);
        return SQL();
    }

    /**
     * 根据主键更新提现出款费率信息【WithdrawRatioInfoDO】对象信息，仅更新非空对象
     *
     * @mbggenerated Fri Mar 11 19:55:30 CST 2016
     */
    public String updateByPrimaryKeySelective(WithdrawRatioInfoDO record) {
        BEGIN();
        UPDATE("FW_WITHDRAW_RATIO_INFO");
        
        if (record.getBizId() != null) {
            SET("BIZ_ID = #{bizId,jdbcType=DECIMAL}");
        }
        
        if (record.getRatioType() != null) {
            SET("RATIO_TYPE = #{ratioType,jdbcType=DECIMAL}");
        }
        
        if (record.getStatus() != null) {
            SET("STATUS = #{status,jdbcType=DECIMAL}");
        }
        
        if (record.getWorkDayRatio() != null) {
            SET("WORK_DAY_RATIO = #{workDayRatio,jdbcType=DECIMAL}");
        }
        
        if (record.getHolidayRatio() != null) {
            SET("HOLIDAY_RATIO = #{holidayRatio,jdbcType=DECIMAL}");
        }
        
        if (record.getEffectiveTime() != null) {
            SET("EFFECTIVE_TIME = #{effectiveTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getExpireTime() != null) {
            SET("EXPIRE_TIME = #{expireTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getCreteTime() != null) {
            SET("CRETE_TIME = #{creteTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getUpdateTime() != null) {
            SET("UPDATE_TIME = #{updateTime,jdbcType=TIMESTAMP}");
        }
        
        WHERE("ID = #{id,jdbcType=DECIMAL}");
        
        return SQL();
    }

    /**
     * This method corresponds to the database table FW_WITHDRAW_RATIO_INFO
     *
     * @mbggenerated Fri Mar 11 19:55:30 CST 2016
     */
    protected void applyWhere(WithdrawRatioInfoDOExample example, boolean includeExamplePhrase) {
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
        
        if (example.getBizId() != null) {
            sb.append(" and  BIZ_ID = #{bizId,jdbcType=DECIMAL} ");
        }
        
        if (example.getRatioType() != null) {
            sb.append(" and  RATIO_TYPE = #{ratioType,jdbcType=DECIMAL} ");
        }
        
        if (example.getStatus() != null) {
            sb.append(" and  STATUS = #{status,jdbcType=DECIMAL} ");
        }
        
        if (example.getWorkDayRatio() != null) {
            sb.append(" and  WORK_DAY_RATIO = #{workDayRatio,jdbcType=DECIMAL} ");
        }
        
        if (example.getHolidayRatio() != null) {
            sb.append(" and  HOLIDAY_RATIO = #{holidayRatio,jdbcType=DECIMAL} ");
        }
        
        if (example.getEffectiveTime() != null) {
            sb.append(" and  EFFECTIVE_TIME = #{effectiveTime,jdbcType=TIMESTAMP} ");
        }
        
        if (example.getExpireTime() != null) {
            sb.append(" and  EXPIRE_TIME = #{expireTime,jdbcType=TIMESTAMP} ");
        }
        
        if (example.getCreteTime() != null) {
            sb.append(" and  CRETE_TIME = #{creteTime,jdbcType=TIMESTAMP} ");
        }
        
        if (example.getUpdateTime() != null) {
            sb.append(" and  UPDATE_TIME = #{updateTime,jdbcType=TIMESTAMP} ");
        }
        WHERE(sb.toString());
    }
}