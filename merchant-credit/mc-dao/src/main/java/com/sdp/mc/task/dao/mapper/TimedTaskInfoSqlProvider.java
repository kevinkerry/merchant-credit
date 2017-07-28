package com.sdp.mc.task.dao.mapper;

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

import com.sdp.mc.task.dao.TimedTaskInfoDO;
import com.sdp.mc.task.dao.TimedTaskInfoDOExample.Criteria;
import com.sdp.mc.task.dao.TimedTaskInfoDOExample.Criterion;
import com.sdp.mc.task.dao.TimedTaskInfoDOExample;
import java.util.List;
import java.util.Map;

public class TimedTaskInfoSqlProvider {

    /**
     * 根据Example对象取得定时任务信息表【TimedTaskInfoDO】对象count信息
     *
     * @mbggenerated Wed May 10 13:57:18 CST 2017
     */
    public String countByExample(TimedTaskInfoDOExample example) {
        BEGIN();
        SELECT("count(*)");
        FROM("TB_TIMED_TASK_INFO");
        applyWhere(example, false);
        return SQL();
    }

    /**
     * 根据Example对象删除定时任务信息表【TimedTaskInfoDO】对象信息
     *
     * @mbggenerated Wed May 10 13:57:18 CST 2017
     */
    public String deleteByExample(TimedTaskInfoDOExample example) {
        BEGIN();
        DELETE_FROM("TB_TIMED_TASK_INFO");
        applyWhere(example, false);
        return SQL();
    }

    /**
     * 添加定时任务信息表【TimedTaskInfoDO】对象信息,空值字段不插入
     *
     * @mbggenerated Wed May 10 13:57:18 CST 2017
     */
    public String insertSelective(TimedTaskInfoDO record) {
        BEGIN();
        INSERT_INTO("TB_TIMED_TASK_INFO");
        
        VALUES("ID", "#{id,jdbcType=DECIMAL}");
        
        if (record.getTaskType() != null) {
            VALUES("TASK_TYPE", "#{taskType,jdbcType=DECIMAL}");
        }
        
        if (record.getTaskContent() != null) {
            VALUES("TASK_CONTENT", "#{taskContent,jdbcType=VARCHAR}");
        }
        
        if (record.getTaskStatus() != null) {
            VALUES("TASK_STATUS", "#{taskStatus,jdbcType=DECIMAL}");
        }
        
        if (record.getEffectiveTime() != null) {
            VALUES("EFFECTIVE_TIME", "#{effectiveTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getRetryTimes() != null) {
            VALUES("RETRY_TIMES", "#{retryTimes,jdbcType=DECIMAL}");
        }
        
        if (record.getExecuteTimes() != null) {
            VALUES("EXECUTE_TIMES", "#{executeTimes,jdbcType=DECIMAL}");
        }
        
        if (record.getLastExecuteTime() != null) {
            VALUES("LAST_EXECUTE_TIME", "#{lastExecuteTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getCreateTime() != null) {
            VALUES("CREATE_TIME", "#{createTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getUpdateTime() != null) {
            VALUES("UPDATE_TIME", "#{updateTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getNotifyEmail() != null) {
            VALUES("NOTIFY_EMAIL", "#{notifyEmail,jdbcType=VARCHAR}");
        }
        
        if (record.getNotifyPhone() != null) {
            VALUES("NOTIFY_PHONE", "#{notifyPhone,jdbcType=VARCHAR}");
        }
        
        if (record.getLastExecuteId() != null) {
            VALUES("LAST_EXECUTE_ID", "#{lastExecuteId,jdbcType=DECIMAL}");
        }
        
        if (record.getRetryTimeInterval() != null) {
            VALUES("RETRY_TIME_INTERVAL", "#{retryTimeInterval,jdbcType=DECIMAL}");
        }
        
        return SQL();
    }

    /**
     * 根据Example对象查询得到定时任务信息表【TimedTaskInfoDO】对象列表信息
     *
     * @mbggenerated Wed May 10 13:57:18 CST 2017
     */
    public String selectByExample(TimedTaskInfoDOExample example) {
        BEGIN();
        if (example != null && example.isDistinct()) {
            SELECT_DISTINCT("ID");
        } else {
            SELECT("ID");
        }
        SELECT("TASK_TYPE");
        SELECT("TASK_CONTENT");
        SELECT("TASK_STATUS");
        SELECT("EFFECTIVE_TIME");
        SELECT("RETRY_TIMES");
        SELECT("EXECUTE_TIMES");
        SELECT("LAST_EXECUTE_TIME");
        SELECT("CREATE_TIME");
        SELECT("UPDATE_TIME");
        SELECT("NOTIFY_EMAIL");
        SELECT("NOTIFY_PHONE");
        SELECT("LAST_EXECUTE_ID");
        SELECT("RETRY_TIME_INTERVAL");
        FROM("TB_TIMED_TASK_INFO");
        applyWhere(example, false);
        
        if (example != null && example.getOrderByClause() != null) {
            ORDER_BY(example.getOrderByClause());
        }
        
        return SQL();
    }

    /**
     * 根据Query对象分页查询定时任务信息表【TimedTaskInfoDO】对象列表信息
     *
     * @mbggenerated Wed May 10 13:57:18 CST 2017
     */
    public String selectByQuery(TimedTaskInfoDOExample example) {
        BEGIN();
        if (example != null && example.isDistinct()) {
            SELECT_DISTINCT("ID");
        } else {
            SELECT("ID");
        }
        SELECT("TASK_TYPE");
        SELECT("TASK_CONTENT");
        SELECT("TASK_STATUS");
        SELECT("EFFECTIVE_TIME");
        SELECT("RETRY_TIMES");
        SELECT("EXECUTE_TIMES");
        SELECT("LAST_EXECUTE_TIME");
        SELECT("CREATE_TIME");
        SELECT("UPDATE_TIME");
        SELECT("NOTIFY_EMAIL");
        SELECT("NOTIFY_PHONE");
        SELECT("LAST_EXECUTE_ID");
        SELECT("RETRY_TIME_INTERVAL");
        FROM("TB_TIMED_TASK_INFO");
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
     * 根据Example对象更新定时任务信息表【TimedTaskInfoDO】对象信息，仅更新非空字段
     *
     * @mbggenerated Wed May 10 13:57:18 CST 2017
     */
    public String updateByExampleSelective(Map<String, Object> parameter) {
        TimedTaskInfoDO record = (TimedTaskInfoDO) parameter.get("record");
        TimedTaskInfoDOExample example = (TimedTaskInfoDOExample) parameter.get("example");
        
        BEGIN();
        UPDATE("TB_TIMED_TASK_INFO");
        
        if (record.getId() != null) {
            SET("ID = #{record.id,jdbcType=DECIMAL}");
        }
        
        if (record.getTaskType() != null) {
            SET("TASK_TYPE = #{record.taskType,jdbcType=DECIMAL}");
        }
        
        if (record.getTaskContent() != null) {
            SET("TASK_CONTENT = #{record.taskContent,jdbcType=VARCHAR}");
        }
        
        if (record.getTaskStatus() != null) {
            SET("TASK_STATUS = #{record.taskStatus,jdbcType=DECIMAL}");
        }
        
        if (record.getEffectiveTime() != null) {
            SET("EFFECTIVE_TIME = #{record.effectiveTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getRetryTimes() != null) {
            SET("RETRY_TIMES = #{record.retryTimes,jdbcType=DECIMAL}");
        }
        
        if (record.getExecuteTimes() != null) {
            SET("EXECUTE_TIMES = #{record.executeTimes,jdbcType=DECIMAL}");
        }
        
        if (record.getLastExecuteTime() != null) {
            SET("LAST_EXECUTE_TIME = #{record.lastExecuteTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getCreateTime() != null) {
            SET("CREATE_TIME = #{record.createTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getUpdateTime() != null) {
            SET("UPDATE_TIME = #{record.updateTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getNotifyEmail() != null) {
            SET("NOTIFY_EMAIL = #{record.notifyEmail,jdbcType=VARCHAR}");
        }
        
        if (record.getNotifyPhone() != null) {
            SET("NOTIFY_PHONE = #{record.notifyPhone,jdbcType=VARCHAR}");
        }
        
        if (record.getLastExecuteId() != null) {
            SET("LAST_EXECUTE_ID = #{record.lastExecuteId,jdbcType=DECIMAL}");
        }
        
        if (record.getRetryTimeInterval() != null) {
            SET("RETRY_TIME_INTERVAL = #{record.retryTimeInterval,jdbcType=DECIMAL}");
        }
        
        applyWhere(example, true);
        return SQL();
    }

    /**
     * 根据Example对象更新定时任务信息表【TimedTaskInfoDO】对象信息
     *
     * @mbggenerated Wed May 10 13:57:18 CST 2017
     */
    public String updateByExample(Map<String, Object> parameter) {
        BEGIN();
        UPDATE("TB_TIMED_TASK_INFO");
        
        SET("ID = #{record.id,jdbcType=DECIMAL}");
        SET("TASK_TYPE = #{record.taskType,jdbcType=DECIMAL}");
        SET("TASK_CONTENT = #{record.taskContent,jdbcType=VARCHAR}");
        SET("TASK_STATUS = #{record.taskStatus,jdbcType=DECIMAL}");
        SET("EFFECTIVE_TIME = #{record.effectiveTime,jdbcType=TIMESTAMP}");
        SET("RETRY_TIMES = #{record.retryTimes,jdbcType=DECIMAL}");
        SET("EXECUTE_TIMES = #{record.executeTimes,jdbcType=DECIMAL}");
        SET("LAST_EXECUTE_TIME = #{record.lastExecuteTime,jdbcType=TIMESTAMP}");
        SET("CREATE_TIME = #{record.createTime,jdbcType=TIMESTAMP}");
        SET("UPDATE_TIME = #{record.updateTime,jdbcType=TIMESTAMP}");
        SET("NOTIFY_EMAIL = #{record.notifyEmail,jdbcType=VARCHAR}");
        SET("NOTIFY_PHONE = #{record.notifyPhone,jdbcType=VARCHAR}");
        SET("LAST_EXECUTE_ID = #{record.lastExecuteId,jdbcType=DECIMAL}");
        SET("RETRY_TIME_INTERVAL = #{record.retryTimeInterval,jdbcType=DECIMAL}");
        
        TimedTaskInfoDOExample example = (TimedTaskInfoDOExample) parameter.get("example");
        applyWhere(example, true);
        return SQL();
    }

    /**
     * 根据主键更新定时任务信息表【TimedTaskInfoDO】对象信息，仅更新非空对象
     *
     * @mbggenerated Wed May 10 13:57:18 CST 2017
     */
    public String updateByPrimaryKeySelective(TimedTaskInfoDO record) {
        BEGIN();
        UPDATE("TB_TIMED_TASK_INFO");
        
        if (record.getTaskType() != null) {
            SET("TASK_TYPE = #{taskType,jdbcType=DECIMAL}");
        }
        
        if (record.getTaskContent() != null) {
            SET("TASK_CONTENT = #{taskContent,jdbcType=VARCHAR}");
        }
        
        if (record.getTaskStatus() != null) {
            SET("TASK_STATUS = #{taskStatus,jdbcType=DECIMAL}");
        }
        
        if (record.getEffectiveTime() != null) {
            SET("EFFECTIVE_TIME = #{effectiveTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getRetryTimes() != null) {
            SET("RETRY_TIMES = #{retryTimes,jdbcType=DECIMAL}");
        }
        
        if (record.getExecuteTimes() != null) {
            SET("EXECUTE_TIMES = #{executeTimes,jdbcType=DECIMAL}");
        }
        
        if (record.getLastExecuteTime() != null) {
            SET("LAST_EXECUTE_TIME = #{lastExecuteTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getCreateTime() != null) {
            SET("CREATE_TIME = #{createTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getUpdateTime() != null) {
            SET("UPDATE_TIME = #{updateTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getNotifyEmail() != null) {
            SET("NOTIFY_EMAIL = #{notifyEmail,jdbcType=VARCHAR}");
        }
        
        if (record.getNotifyPhone() != null) {
            SET("NOTIFY_PHONE = #{notifyPhone,jdbcType=VARCHAR}");
        }
        
        if (record.getLastExecuteId() != null) {
            SET("LAST_EXECUTE_ID = #{lastExecuteId,jdbcType=DECIMAL}");
        }
        
        if (record.getRetryTimeInterval() != null) {
            SET("RETRY_TIME_INTERVAL = #{retryTimeInterval,jdbcType=DECIMAL}");
        }
        
        WHERE("ID = #{id,jdbcType=DECIMAL}");
        
        return SQL();
    }

    /**
     * This method corresponds to the database table TB_TIMED_TASK_INFO
     *
     * @mbggenerated Wed May 10 13:57:18 CST 2017
     */
    protected void applyWhere(TimedTaskInfoDOExample example, boolean includeExamplePhrase) {
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
        
        if (example.getTaskType() != null) {
            sb.append(" and  TASK_TYPE = #{taskType,jdbcType=DECIMAL} ");
        }
        
        if (example.getTaskContent() != null && !example.getTaskContent().equals("") ) {
            sb.append(" and  TASK_CONTENT = #{taskContent,jdbcType=VARCHAR} ");
        }
        
        if (example.getTaskStatus() != null) {
            sb.append(" and  TASK_STATUS = #{taskStatus,jdbcType=DECIMAL} ");
        }
        
        if (example.getEffectiveTime() != null) {
            sb.append(" and  EFFECTIVE_TIME = #{effectiveTime,jdbcType=TIMESTAMP} ");
        }
        
        if (example.getRetryTimes() != null) {
            sb.append(" and  RETRY_TIMES = #{retryTimes,jdbcType=DECIMAL} ");
        }
        
        if (example.getExecuteTimes() != null) {
            sb.append(" and  EXECUTE_TIMES = #{executeTimes,jdbcType=DECIMAL} ");
        }
        
        if (example.getLastExecuteTime() != null) {
            sb.append(" and  LAST_EXECUTE_TIME = #{lastExecuteTime,jdbcType=TIMESTAMP} ");
        }
        
        if (example.getCreateTime() != null) {
            sb.append(" and  CREATE_TIME = #{createTime,jdbcType=TIMESTAMP} ");
        }
        
        if (example.getUpdateTime() != null) {
            sb.append(" and  UPDATE_TIME = #{updateTime,jdbcType=TIMESTAMP} ");
        }
        
        if (example.getNotifyEmail() != null && !example.getNotifyEmail().equals("") ) {
            sb.append(" and  NOTIFY_EMAIL = #{notifyEmail,jdbcType=VARCHAR} ");
        }
        
        if (example.getNotifyPhone() != null && !example.getNotifyPhone().equals("") ) {
            sb.append(" and  NOTIFY_PHONE = #{notifyPhone,jdbcType=VARCHAR} ");
        }
        
        if (example.getLastExecuteId() != null) {
            sb.append(" and  LAST_EXECUTE_ID = #{lastExecuteId,jdbcType=DECIMAL} ");
        }
        
        if (example.getRetryTimeInterval() != null) {
            sb.append(" and  RETRY_TIME_INTERVAL = #{retryTimeInterval,jdbcType=DECIMAL} ");
        }
        WHERE(sb.toString());
    }
}