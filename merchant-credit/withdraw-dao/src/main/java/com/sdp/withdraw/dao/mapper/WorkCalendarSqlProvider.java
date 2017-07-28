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

import com.sdp.withdraw.dao.WorkCalendarDO;
import com.sdp.withdraw.dao.WorkCalendarDOExample.Criteria;
import com.sdp.withdraw.dao.WorkCalendarDOExample.Criterion;
import com.sdp.withdraw.dao.WorkCalendarDOExample;
import java.util.List;
import java.util.Map;

public class WorkCalendarSqlProvider {

    /**
     * 根据Example对象取得工作日历【WorkCalendarDO】对象count信息
     *
     * @mbggenerated Fri Mar 11 19:55:52 CST 2016
     */
    public String countByExample(WorkCalendarDOExample example) {
        BEGIN();
        SELECT("count(*)");
        FROM("FW_WORK_CALENDAR");
        applyWhere(example, false);
        return SQL();
    }

    /**
     * 根据Example对象删除工作日历【WorkCalendarDO】对象信息
     *
     * @mbggenerated Fri Mar 11 19:55:52 CST 2016
     */
    public String deleteByExample(WorkCalendarDOExample example) {
        BEGIN();
        DELETE_FROM("FW_WORK_CALENDAR");
        applyWhere(example, false);
        return SQL();
    }

    /**
     * 添加工作日历【WorkCalendarDO】对象信息,空值字段不插入
     *
     * @mbggenerated Fri Mar 11 19:55:52 CST 2016
     */
    public String insertSelective(WorkCalendarDO record) {
        BEGIN();
        INSERT_INTO("FW_WORK_CALENDAR");
        
        VALUES("ID", "#{id,jdbcType=DECIMAL}");
        
        if (record.getWordDate() != null) {
            VALUES("WORK_DATE", "#{wordDate,jdbcType=DATE}");
        }
        
        if (record.getWeekDay() != null) {
            VALUES("WEEK_DAY", "#{weekDay,jdbcType=DECIMAL}");
        }
        
        if (record.getIsHoliday() != null) {
            VALUES("IS_HOLIDAY", "#{isHoliday,jdbcType=DECIMAL}");
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
     * 根据Example对象查询得到工作日历【WorkCalendarDO】对象列表信息
     *
     * @mbggenerated Fri Mar 11 19:55:52 CST 2016
     */
    public String selectByExample(WorkCalendarDOExample example) {
        BEGIN();
        if (example != null && example.isDistinct()) {
            SELECT_DISTINCT("ID");
        } else {
            SELECT("ID");
        }
        SELECT("WORK_DATE");
        SELECT("WEEK_DAY");
        SELECT("IS_HOLIDAY");
        SELECT("CREATE_TIME");
        SELECT("UPDATE_TIME");
        FROM("FW_WORK_CALENDAR");
        applyWhere(example, false);
        
        if (example != null && example.getOrderByClause() != null) {
            ORDER_BY(example.getOrderByClause());
        }
        
        return SQL();
    }

    /**
     * 根据Query对象分页查询工作日历【WorkCalendarDO】对象列表信息
     *
     * @mbggenerated Fri Mar 11 19:55:52 CST 2016
     */
    public String selectByQuery(WorkCalendarDOExample example) {
        BEGIN();
        if (example != null && example.isDistinct()) {
            SELECT_DISTINCT("ID");
        } else {
            SELECT("ID");
        }
        SELECT("WORK_DATE");
        SELECT("WEEK_DAY");
        SELECT("IS_HOLIDAY");
        SELECT("CREATE_TIME");
        SELECT("UPDATE_TIME");
        FROM("FW_WORK_CALENDAR");
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
     * 根据Example对象更新工作日历【WorkCalendarDO】对象信息，仅更新非空字段
     *
     * @mbggenerated Fri Mar 11 19:55:52 CST 2016
     */
    public String updateByExampleSelective(Map<String, Object> parameter) {
        WorkCalendarDO record = (WorkCalendarDO) parameter.get("record");
        WorkCalendarDOExample example = (WorkCalendarDOExample) parameter.get("example");
        
        BEGIN();
        UPDATE("FW_WORK_CALENDAR");
        
        if (record.getId() != null) {
            SET("ID = #{record.id,jdbcType=DECIMAL}");
        }
        
        if (record.getWordDate() != null) {
            SET("WORK_DATE = #{record.wordDate,jdbcType=DATE}");
        }
        
        if (record.getWeekDay() != null) {
            SET("WEEK_DAY = #{record.weekDay,jdbcType=DECIMAL}");
        }
        
        if (record.getIsHoliday() != null) {
            SET("IS_HOLIDAY = #{record.isHoliday,jdbcType=DECIMAL}");
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
     * 根据Example对象更新工作日历【WorkCalendarDO】对象信息
     *
     * @mbggenerated Fri Mar 11 19:55:52 CST 2016
     */
    public String updateByExample(Map<String, Object> parameter) {
        BEGIN();
        UPDATE("FW_WORK_CALENDAR");
        
        SET("ID = #{record.id,jdbcType=DECIMAL}");
        SET("WORK_DATE = #{record.wordDate,jdbcType=DATE}");
        SET("WEEK_DAY = #{record.weekDay,jdbcType=DECIMAL}");
        SET("IS_HOLIDAY = #{record.isHoliday,jdbcType=DECIMAL}");
        SET("CREATE_TIME = #{record.createTime,jdbcType=TIMESTAMP}");
        SET("UPDATE_TIME = #{record.updateTime,jdbcType=TIMESTAMP}");
        
        WorkCalendarDOExample example = (WorkCalendarDOExample) parameter.get("example");
        applyWhere(example, true);
        return SQL();
    }

    /**
     * 根据主键更新工作日历【WorkCalendarDO】对象信息，仅更新非空对象
     *
     * @mbggenerated Fri Mar 11 19:55:52 CST 2016
     */
    public String updateByPrimaryKeySelective(WorkCalendarDO record) {
        BEGIN();
        UPDATE("FW_WORK_CALENDAR");
        
        if (record.getWordDate() != null) {
            SET("WORK_DATE = #{wordDate,jdbcType=DATE}");
        }
        
        if (record.getWeekDay() != null) {
            SET("WEEK_DAY = #{weekDay,jdbcType=DECIMAL}");
        }
        
        if (record.getIsHoliday() != null) {
            SET("IS_HOLIDAY = #{isHoliday,jdbcType=DECIMAL}");
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
     * This method corresponds to the database table FW_WORK_CALENDAR
     *
     * @mbggenerated Fri Mar 11 19:55:52 CST 2016
     */
    protected void applyWhere(WorkCalendarDOExample example, boolean includeExamplePhrase) {
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
        
        if (example.getWordDate() != null) {
            sb.append(" and  WORK_DATE = #{wordDate,jdbcType=DATE} ");
        }
        
        if (example.getWeekDay() != null) {
            sb.append(" and  WEEK_DAY = #{weekDay,jdbcType=DECIMAL} ");
        }
        
        if (example.getIsHoliday() != null) {
            sb.append(" and  IS_HOLIDAY = #{isHoliday,jdbcType=DECIMAL} ");
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