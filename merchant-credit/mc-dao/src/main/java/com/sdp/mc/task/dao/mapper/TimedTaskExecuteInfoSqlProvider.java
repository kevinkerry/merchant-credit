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

import com.sdp.mc.task.dao.TimedTaskExecuteInfoDO;
import com.sdp.mc.task.dao.TimedTaskExecuteInfoDOExample.Criteria;
import com.sdp.mc.task.dao.TimedTaskExecuteInfoDOExample.Criterion;
import com.sdp.mc.task.dao.TimedTaskExecuteInfoDOExample;
import java.util.List;
import java.util.Map;

public class TimedTaskExecuteInfoSqlProvider {

    /**
     * 根据Example对象取得任务执行情况【TimedTaskExecuteInfoDO】对象count信息
     *
     * @mbggenerated Thu Apr 27 09:31:21 CST 2017
     */
    public String countByExample(TimedTaskExecuteInfoDOExample example) {
        BEGIN();
        SELECT("count(*)");
        FROM("TB_TIMED_TASK_EXECUTE_INFO");
        applyWhere(example, false);
        return SQL();
    }

    /**
     * 根据Example对象删除任务执行情况【TimedTaskExecuteInfoDO】对象信息
     *
     * @mbggenerated Thu Apr 27 09:31:21 CST 2017
     */
    public String deleteByExample(TimedTaskExecuteInfoDOExample example) {
        BEGIN();
        DELETE_FROM("TB_TIMED_TASK_EXECUTE_INFO");
        applyWhere(example, false);
        return SQL();
    }

    /**
     * 添加任务执行情况【TimedTaskExecuteInfoDO】对象信息,空值字段不插入
     *
     * @mbggenerated Thu Apr 27 09:31:21 CST 2017
     */
    public String insertSelective(TimedTaskExecuteInfoDO record) {
        BEGIN();
        INSERT_INTO("TB_TIMED_TASK_EXECUTE_INFO");
        
        VALUES("ID", "#{id,jdbcType=DECIMAL}");
        
        if (record.getCreateTime() != null) {
            VALUES("CREATE_TIME", "#{createTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getUpdateTime() != null) {
            VALUES("UPDATE_TIME", "#{updateTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getTaskId() != null) {
            VALUES("TASK_ID", "#{taskId,jdbcType=DECIMAL}");
        }
        
        if (record.getUseTime() != null) {
            VALUES("USE_TIME", "#{useTime,jdbcType=DECIMAL}");
        }
        
        if (record.getResult() != null) {
            VALUES("RESULT", "#{result,jdbcType=VARCHAR}");
        }
        
        if (record.getRemark() != null) {
            VALUES("REMARK", "#{remark,jdbcType=VARCHAR}");
        }
        
        return SQL();
    }

    /**
     * 根据Example对象查询得到任务执行情况【TimedTaskExecuteInfoDO】对象列表信息
     *
     * @mbggenerated Thu Apr 27 09:31:21 CST 2017
     */
    public String selectByExample(TimedTaskExecuteInfoDOExample example) {
        BEGIN();
        if (example != null && example.isDistinct()) {
            SELECT_DISTINCT("ID");
        } else {
            SELECT("ID");
        }
        SELECT("CREATE_TIME");
        SELECT("UPDATE_TIME");
        SELECT("TASK_ID");
        SELECT("USE_TIME");
        SELECT("RESULT");
        SELECT("REMARK");
        FROM("TB_TIMED_TASK_EXECUTE_INFO");
        applyWhere(example, false);
        
        if (example != null && example.getOrderByClause() != null) {
            ORDER_BY(example.getOrderByClause());
        }
        
        return SQL();
    }

    /**
     * 根据Query对象分页查询任务执行情况【TimedTaskExecuteInfoDO】对象列表信息
     *
     * @mbggenerated Thu Apr 27 09:31:21 CST 2017
     */
    public String selectByQuery(TimedTaskExecuteInfoDOExample example) {
        BEGIN();
        if (example != null && example.isDistinct()) {
            SELECT_DISTINCT("ID");
        } else {
            SELECT("ID");
        }
        SELECT("CREATE_TIME");
        SELECT("UPDATE_TIME");
        SELECT("TASK_ID");
        SELECT("USE_TIME");
        SELECT("RESULT");
        SELECT("REMARK");
        FROM("TB_TIMED_TASK_EXECUTE_INFO");
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
     * 根据Example对象更新任务执行情况【TimedTaskExecuteInfoDO】对象信息，仅更新非空字段
     *
     * @mbggenerated Thu Apr 27 09:31:21 CST 2017
     */
    public String updateByExampleSelective(Map<String, Object> parameter) {
        TimedTaskExecuteInfoDO record = (TimedTaskExecuteInfoDO) parameter.get("record");
        TimedTaskExecuteInfoDOExample example = (TimedTaskExecuteInfoDOExample) parameter.get("example");
        
        BEGIN();
        UPDATE("TB_TIMED_TASK_EXECUTE_INFO");
        
        if (record.getId() != null) {
            SET("ID = #{record.id,jdbcType=DECIMAL}");
        }
        
        if (record.getCreateTime() != null) {
            SET("CREATE_TIME = #{record.createTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getUpdateTime() != null) {
            SET("UPDATE_TIME = #{record.updateTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getTaskId() != null) {
            SET("TASK_ID = #{record.taskId,jdbcType=DECIMAL}");
        }
        
        if (record.getUseTime() != null) {
            SET("USE_TIME = #{record.useTime,jdbcType=DECIMAL}");
        }
        
        if (record.getResult() != null) {
            SET("RESULT = #{record.result,jdbcType=VARCHAR}");
        }
        
        if (record.getRemark() != null) {
            SET("REMARK = #{record.remark,jdbcType=VARCHAR}");
        }
        
        applyWhere(example, true);
        return SQL();
    }

    /**
     * 根据Example对象更新任务执行情况【TimedTaskExecuteInfoDO】对象信息
     *
     * @mbggenerated Thu Apr 27 09:31:21 CST 2017
     */
    public String updateByExample(Map<String, Object> parameter) {
        BEGIN();
        UPDATE("TB_TIMED_TASK_EXECUTE_INFO");
        
        SET("ID = #{record.id,jdbcType=DECIMAL}");
        SET("CREATE_TIME = #{record.createTime,jdbcType=TIMESTAMP}");
        SET("UPDATE_TIME = #{record.updateTime,jdbcType=TIMESTAMP}");
        SET("TASK_ID = #{record.taskId,jdbcType=DECIMAL}");
        SET("USE_TIME = #{record.useTime,jdbcType=DECIMAL}");
        SET("RESULT = #{record.result,jdbcType=VARCHAR}");
        SET("REMARK = #{record.remark,jdbcType=VARCHAR}");
        
        TimedTaskExecuteInfoDOExample example = (TimedTaskExecuteInfoDOExample) parameter.get("example");
        applyWhere(example, true);
        return SQL();
    }

    /**
     * 根据主键更新任务执行情况【TimedTaskExecuteInfoDO】对象信息，仅更新非空对象
     *
     * @mbggenerated Thu Apr 27 09:31:21 CST 2017
     */
    public String updateByPrimaryKeySelective(TimedTaskExecuteInfoDO record) {
        BEGIN();
        UPDATE("TB_TIMED_TASK_EXECUTE_INFO");
        
        if (record.getCreateTime() != null) {
            SET("CREATE_TIME = #{createTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getUpdateTime() != null) {
            SET("UPDATE_TIME = #{updateTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getTaskId() != null) {
            SET("TASK_ID = #{taskId,jdbcType=DECIMAL}");
        }
        
        if (record.getUseTime() != null) {
            SET("USE_TIME = #{useTime,jdbcType=DECIMAL}");
        }
        
        if (record.getResult() != null) {
            SET("RESULT = #{result,jdbcType=VARCHAR}");
        }
        
        if (record.getRemark() != null) {
            SET("REMARK = #{remark,jdbcType=VARCHAR}");
        }
        
        WHERE("ID = #{id,jdbcType=DECIMAL}");
        
        return SQL();
    }

    /**
     * This method corresponds to the database table TB_TIMED_TASK_EXECUTE_INFO
     *
     * @mbggenerated Thu Apr 27 09:31:21 CST 2017
     */
    protected void applyWhere(TimedTaskExecuteInfoDOExample example, boolean includeExamplePhrase) {
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
        
        if (example.getTaskId() != null) {
            sb.append(" and  TASK_ID = #{taskId,jdbcType=DECIMAL} ");
        }
        
        if (example.getUseTime() != null) {
            sb.append(" and  USE_TIME = #{useTime,jdbcType=DECIMAL} ");
        }
        
        if (example.getResult() != null && !example.getResult().equals("") ) {
            sb.append(" and  RESULT = #{result,jdbcType=VARCHAR} ");
        }
        
        if (example.getRemark() != null && !example.getRemark().equals("") ) {
            sb.append(" and  REMARK = #{remark,jdbcType=VARCHAR} ");
        }
        WHERE(sb.toString());
    }
}