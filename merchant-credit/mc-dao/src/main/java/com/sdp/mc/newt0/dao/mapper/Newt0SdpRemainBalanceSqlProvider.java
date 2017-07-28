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

import com.sdp.mc.newt0.dao.Newt0SdpRemainBalanceDO;
import com.sdp.mc.newt0.dao.Newt0SdpRemainBalanceDOExample.Criteria;
import com.sdp.mc.newt0.dao.Newt0SdpRemainBalanceDOExample.Criterion;
import com.sdp.mc.newt0.dao.Newt0SdpRemainBalanceDOExample;
import java.util.List;
import java.util.Map;

public class Newt0SdpRemainBalanceSqlProvider {

    /**
     * 根据Example对象取得盛付通全资日历【Newt0SdpRemainBalanceDO】对象count信息
     *
     * @mbggenerated Mon Sep 28 18:15:02 CST 2015
     */
    public String countByExample(Newt0SdpRemainBalanceDOExample example) {
        BEGIN();
        SELECT("count(*)");
        FROM("NEWT0_SDP_REMAIN_BALANCE");
        applyWhere(example, false);
        return SQL();
    }

    /**
     * 根据Example对象删除盛付通全资日历【Newt0SdpRemainBalanceDO】对象信息
     *
     * @mbggenerated Mon Sep 28 18:15:02 CST 2015
     */
    public String deleteByExample(Newt0SdpRemainBalanceDOExample example) {
        BEGIN();
        DELETE_FROM("NEWT0_SDP_REMAIN_BALANCE");
        applyWhere(example, false);
        return SQL();
    }

    /**
     * 添加盛付通全资日历【Newt0SdpRemainBalanceDO】对象信息,空值字段不插入
     *
     * @mbggenerated Mon Sep 28 18:15:02 CST 2015
     */
    public String insertSelective(Newt0SdpRemainBalanceDO record) {
        BEGIN();
        INSERT_INTO("NEWT0_SDP_REMAIN_BALANCE");
        
        VALUES("ID", "#{id,jdbcType=DECIMAL}");
        
        if (record.getStartTime() != null) {
            VALUES("START_TIME", "#{startTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getQuota() != null) {
            VALUES("QUOTA", "#{quota,jdbcType=DECIMAL}");
        }
        
        if (record.getCreateTime() != null) {
            VALUES("CREATE_TIME", "#{createTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getUpdateTime() != null) {
            VALUES("UPDATE_TIME", "#{updateTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getEndTime() != null) {
            VALUES("END_TIME", "#{endTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getCanUseQuota() != null) {
            VALUES("CAN_USE_QUOTA", "#{canUseQuota,jdbcType=DECIMAL}");
        }
        
        if (record.getFrozenQuota() != null) {
            VALUES("FROZEN_QUOTA", "#{frozenQuota,jdbcType=DECIMAL}");
        }
        
        if (record.getUsedQuota() != null) {
            VALUES("USED_QUOTA", "#{usedQuota,jdbcType=DECIMAL}");
        }
        
        return SQL();
    }

    /**
     * 根据Example对象查询得到盛付通全资日历【Newt0SdpRemainBalanceDO】对象列表信息
     *
     * @mbggenerated Mon Sep 28 18:15:02 CST 2015
     */
    public String selectByExample(Newt0SdpRemainBalanceDOExample example) {
        BEGIN();
        if (example != null && example.isDistinct()) {
            SELECT_DISTINCT("ID");
        } else {
            SELECT("ID");
        }
        SELECT("START_TIME");
        SELECT("QUOTA");
        SELECT("CREATE_TIME");
        SELECT("UPDATE_TIME");
        SELECT("END_TIME");
        SELECT("CAN_USE_QUOTA");
        SELECT("FROZEN_QUOTA");
        SELECT("USED_QUOTA");
        FROM("NEWT0_SDP_REMAIN_BALANCE");
        applyWhere(example, false);
        
        if (example != null && example.getOrderByClause() != null) {
            ORDER_BY(example.getOrderByClause());
        }
        
        return SQL();
    }

    /**
     * 根据Query对象分页查询盛付通全资日历【Newt0SdpRemainBalanceDO】对象列表信息
     *
     * @mbggenerated Mon Sep 28 18:15:02 CST 2015
     */
    public String selectByQuery(Newt0SdpRemainBalanceDOExample example) {
        BEGIN();
        if (example != null && example.isDistinct()) {
            SELECT_DISTINCT("ID");
        } else {
            SELECT("ID");
        }
        SELECT("START_TIME");
        SELECT("QUOTA");
        SELECT("CREATE_TIME");
        SELECT("UPDATE_TIME");
        SELECT("END_TIME");
        SELECT("CAN_USE_QUOTA");
        SELECT("FROZEN_QUOTA");
        SELECT("USED_QUOTA");
        FROM("NEWT0_SDP_REMAIN_BALANCE");
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
     * 根据Example对象更新盛付通全资日历【Newt0SdpRemainBalanceDO】对象信息，仅更新非空字段
     *
     * @mbggenerated Mon Sep 28 18:15:02 CST 2015
     */
    public String updateByExampleSelective(Map<String, Object> parameter) {
        Newt0SdpRemainBalanceDO record = (Newt0SdpRemainBalanceDO) parameter.get("record");
        Newt0SdpRemainBalanceDOExample example = (Newt0SdpRemainBalanceDOExample) parameter.get("example");
        
        BEGIN();
        UPDATE("NEWT0_SDP_REMAIN_BALANCE");
        
        if (record.getId() != null) {
            SET("ID = #{record.id,jdbcType=DECIMAL}");
        }
        
        if (record.getStartTime() != null) {
            SET("START_TIME = #{record.startTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getQuota() != null) {
            SET("QUOTA = #{record.quota,jdbcType=DECIMAL}");
        }
        
        if (record.getCreateTime() != null) {
            SET("CREATE_TIME = #{record.createTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getUpdateTime() != null) {
            SET("UPDATE_TIME = #{record.updateTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getEndTime() != null) {
            SET("END_TIME = #{record.endTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getCanUseQuota() != null) {
            SET("CAN_USE_QUOTA = #{record.canUseQuota,jdbcType=DECIMAL}");
        }
        
        if (record.getFrozenQuota() != null) {
            SET("FROZEN_QUOTA = #{record.frozenQuota,jdbcType=DECIMAL}");
        }
        
        if (record.getUsedQuota() != null) {
            SET("USED_QUOTA = #{record.usedQuota,jdbcType=DECIMAL}");
        }
        
        applyWhere(example, true);
        return SQL();
    }

    /**
     * 根据Example对象更新盛付通全资日历【Newt0SdpRemainBalanceDO】对象信息
     *
     * @mbggenerated Mon Sep 28 18:15:02 CST 2015
     */
    public String updateByExample(Map<String, Object> parameter) {
        BEGIN();
        UPDATE("NEWT0_SDP_REMAIN_BALANCE");
        
        SET("ID = #{record.id,jdbcType=DECIMAL}");
        SET("START_TIME = #{record.startTime,jdbcType=TIMESTAMP}");
        SET("QUOTA = #{record.quota,jdbcType=DECIMAL}");
        SET("CREATE_TIME = #{record.createTime,jdbcType=TIMESTAMP}");
        SET("UPDATE_TIME = #{record.updateTime,jdbcType=TIMESTAMP}");
        SET("END_TIME = #{record.endTime,jdbcType=TIMESTAMP}");
        SET("CAN_USE_QUOTA = #{record.canUseQuota,jdbcType=DECIMAL}");
        SET("FROZEN_QUOTA = #{record.frozenQuota,jdbcType=DECIMAL}");
        SET("USED_QUOTA = #{record.usedQuota,jdbcType=DECIMAL}");
        
        Newt0SdpRemainBalanceDOExample example = (Newt0SdpRemainBalanceDOExample) parameter.get("example");
        applyWhere(example, true);
        return SQL();
    }

    /**
     * 根据主键更新盛付通全资日历【Newt0SdpRemainBalanceDO】对象信息，仅更新非空对象
     *
     * @mbggenerated Mon Sep 28 18:15:02 CST 2015
     */
    public String updateByPrimaryKeySelective(Newt0SdpRemainBalanceDO record) {
        BEGIN();
        UPDATE("NEWT0_SDP_REMAIN_BALANCE");
        
        if (record.getStartTime() != null) {
            SET("START_TIME = #{startTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getQuota() != null) {
            SET("QUOTA = #{quota,jdbcType=DECIMAL}");
        }
        
        if (record.getCreateTime() != null) {
            SET("CREATE_TIME = #{createTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getUpdateTime() != null) {
            SET("UPDATE_TIME = #{updateTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getEndTime() != null) {
            SET("END_TIME = #{endTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getCanUseQuota() != null) {
            SET("CAN_USE_QUOTA = #{canUseQuota,jdbcType=DECIMAL}");
        }
        
        if (record.getFrozenQuota() != null) {
            SET("FROZEN_QUOTA = #{frozenQuota,jdbcType=DECIMAL}");
        }
        
        if (record.getUsedQuota() != null) {
            SET("USED_QUOTA = #{usedQuota,jdbcType=DECIMAL}");
        }
        
        WHERE("ID = #{id,jdbcType=DECIMAL}");
        
        return SQL();
    }

    /**
     * This method corresponds to the database table NEWT0_SDP_REMAIN_BALANCE
     *
     * @mbggenerated Mon Sep 28 18:15:02 CST 2015
     */
    protected void applyWhere(Newt0SdpRemainBalanceDOExample example, boolean includeExamplePhrase) {
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
        
        if (example.getStartTime() != null) {
            sb.append(" and  START_TIME = #{startTime,jdbcType=TIMESTAMP} ");
        }
        
        if (example.getQuota() != null) {
            sb.append(" and  QUOTA = #{quota,jdbcType=DECIMAL} ");
        }
        
        if (example.getCreateTime() != null) {
            sb.append(" and  CREATE_TIME = #{createTime,jdbcType=TIMESTAMP} ");
        }
        
        if (example.getUpdateTime() != null) {
            sb.append(" and  UPDATE_TIME = #{updateTime,jdbcType=TIMESTAMP} ");
        }
        
        if (example.getEndTime() != null) {
            sb.append(" and  END_TIME = #{endTime,jdbcType=TIMESTAMP} ");
        }
        
        if (example.getCanUseQuota() != null) {
            sb.append(" and  CAN_USE_QUOTA = #{canUseQuota,jdbcType=DECIMAL} ");
        }
        
        if (example.getFrozenQuota() != null) {
            sb.append(" and  FROZEN_QUOTA = #{frozenQuota,jdbcType=DECIMAL} ");
        }
        
        if (example.getUsedQuota() != null) {
            sb.append(" and  USED_QUOTA = #{usedQuota,jdbcType=DECIMAL} ");
        }
        WHERE(sb.toString());
    }
}