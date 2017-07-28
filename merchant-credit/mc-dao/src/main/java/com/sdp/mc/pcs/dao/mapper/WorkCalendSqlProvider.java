package com.sdp.mc.pcs.dao.mapper;

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

import com.sdp.mc.pcs.dao.WorkCalendar;
import com.sdp.mc.pcs.dao.WorkCalendarExample.Criteria;
import com.sdp.mc.pcs.dao.WorkCalendarExample.Criterion;
import com.sdp.mc.pcs.dao.WorkCalendarExample;
import java.util.List;
import java.util.Map;

public class WorkCalendSqlProvider {

    /**
     * 根据Example对象取得工作日历【WorkCalendar】对象count信息
     *
     * @mbggenerated Tue Jun 02 17:18:25 CST 2015
     */
    public String countByExample(WorkCalendarExample example) {
        BEGIN();
        SELECT("count(*)");
        FROM("WORK_CALENDAR");
        applyWhere(example, false);
        return SQL();
    }

    /**
     * 根据Example对象删除工作日历【WorkCalendar】对象信息
     *
     * @mbggenerated Tue Jun 02 17:18:25 CST 2015
     */
    public String deleteByExample(WorkCalendarExample example) {
        BEGIN();
        DELETE_FROM("WORK_CALENDAR");
        applyWhere(example, false);
        return SQL();
    }

    /**
     * 添加工作日历【WorkCalendar】对象信息,空值字段不插入
     *
     * @mbggenerated Tue Jun 02 17:18:25 CST 2015
     */
    public String insertSelective(WorkCalendar record) {
        BEGIN();
        INSERT_INTO("WORK_CALENDAR");
        
        if (record.getId() != null) {
            VALUES("ID", "#{id,jdbcType=DECIMAL}");
        }
        
        if (record.getCreateTime() != null) {
            VALUES("CREATE_TIME", "#{createTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getUpdateTime() != null) {
            VALUES("UPDATE_TIME", "#{updateTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getVersion() != null) {
            VALUES("VERSION", "#{version,jdbcType=DECIMAL}");
        }
        
        if (record.getDateStr() != null) {
            VALUES("DATE_STR", "#{dateStr,jdbcType=CHAR}");
        }
        
        if (record.getIsWorkDay() != null) {
            VALUES("IS_WORK_DAY", "#{isWorkDay,jdbcType=DECIMAL}");
        }
        
        return SQL();
    }

    /**
     * 根据Example对象查询得到工作日历【WorkCalendar】对象列表信息
     *
     * @mbggenerated Tue Jun 02 17:18:25 CST 2015
     */
    public String selectByExample(WorkCalendarExample example) {
        BEGIN();
        if (example != null && example.isDistinct()) {
            SELECT_DISTINCT("ID");
        } else {
            SELECT("ID");
        }
        SELECT("CREATE_TIME");
        SELECT("UPDATE_TIME");
        SELECT("VERSION");
        SELECT("DATE_STR");
        SELECT("IS_WORK_DAY");
        FROM("WORK_CALENDAR");
        applyWhere(example, false);
        
        if (example != null && example.getOrderByClause() != null) {
            ORDER_BY(example.getOrderByClause());
        }
        
        return SQL();
    }

    /**
     * 根据Query对象分页查询工作日历【WorkCalendar】对象列表信息
     *
     * @mbggenerated Tue Jun 02 17:18:25 CST 2015
     */
    public String selectByQuery(WorkCalendarExample example) {
        BEGIN();
        if (example != null && example.isDistinct()) {
            SELECT_DISTINCT("ID");
        } else {
            SELECT("ID");
        }
        SELECT("CREATE_TIME");
        SELECT("UPDATE_TIME");
        SELECT("VERSION");
        SELECT("DATE_STR");
        SELECT("IS_WORK_DAY");
        FROM("WORK_CALENDAR");
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
     * 根据Example对象更新工作日历【WorkCalendar】对象信息，仅更新非空字段
     *
     * @mbggenerated Tue Jun 02 17:18:25 CST 2015
     */
    public String updateByExampleSelective(Map<String, Object> parameter) {
        WorkCalendar record = (WorkCalendar) parameter.get("record");
        WorkCalendarExample example = (WorkCalendarExample) parameter.get("example");
        
        BEGIN();
        UPDATE("WORK_CALENDAR");
        
        if (record.getId() != null) {
            SET("ID = #{record.id,jdbcType=DECIMAL}");
        }
        
        if (record.getCreateTime() != null) {
            SET("CREATE_TIME = #{record.createTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getUpdateTime() != null) {
            SET("UPDATE_TIME = #{record.updateTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getVersion() != null) {
            SET("VERSION = #{record.version,jdbcType=DECIMAL}");
        }
        
        if (record.getDateStr() != null) {
            SET("DATE_STR = #{record.dateStr,jdbcType=CHAR}");
        }
        
        if (record.getIsWorkDay() != null) {
            SET("IS_WORK_DAY = #{record.isWorkDay,jdbcType=DECIMAL}");
        }
        
        applyWhere(example, true);
        return SQL();
    }

    /**
     * 根据Example对象更新工作日历【WorkCalendar】对象信息
     *
     * @mbggenerated Tue Jun 02 17:18:25 CST 2015
     */
    public String updateByExample(Map<String, Object> parameter) {
        BEGIN();
        UPDATE("WORK_CALENDAR");
        
        SET("ID = #{record.id,jdbcType=DECIMAL}");
        SET("CREATE_TIME = #{record.createTime,jdbcType=TIMESTAMP}");
        SET("UPDATE_TIME = #{record.updateTime,jdbcType=TIMESTAMP}");
        SET("VERSION = #{record.version,jdbcType=DECIMAL}");
        SET("DATE_STR = #{record.dateStr,jdbcType=CHAR}");
        SET("IS_WORK_DAY = #{record.isWorkDay,jdbcType=DECIMAL}");
        
        WorkCalendarExample example = (WorkCalendarExample) parameter.get("example");
        applyWhere(example, true);
        return SQL();
    }

    /**
     * This method corresponds to the database table WORK_CALENDAR
     *
     * @mbggenerated Tue Jun 02 17:18:25 CST 2015
     */
    protected void applyWhere(WorkCalendarExample example, boolean includeExamplePhrase) {
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
        
        if (example.getCreateTime() != null) {
            sb.append(" and  CREATE_TIME = #{createTime,jdbcType=TIMESTAMP} ");
        }
        
        if (example.getUpdateTime() != null) {
            sb.append(" and  UPDATE_TIME = #{updateTime,jdbcType=TIMESTAMP} ");
        }
        
        if (example.getVersion() != null) {
            sb.append(" and  VERSION = #{version,jdbcType=DECIMAL} ");
        }
        
        if (example.getDateStr() != null && !example.getDateStr().equals("") ) {
            sb.append(" and  DATE_STR = #{dateStr,jdbcType=CHAR} ");
        }
        
        if (example.getIsWorkDay() != null && !example.getIsWorkDay().equals("") ) {
            sb.append(" and  IS_WORK_DAY = #{isWorkDay,jdbcType=DECIMAL} ");
        }
        WHERE(sb.toString());
    }
}