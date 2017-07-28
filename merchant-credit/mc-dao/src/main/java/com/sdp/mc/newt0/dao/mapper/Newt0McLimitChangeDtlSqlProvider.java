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

import com.sdp.mc.newt0.dao.Newt0McLimitChangeDtlDO;
import com.sdp.mc.newt0.dao.Newt0McLimitChangeDtlDOExample.Criteria;
import com.sdp.mc.newt0.dao.Newt0McLimitChangeDtlDOExample.Criterion;
import com.sdp.mc.newt0.dao.Newt0McLimitChangeDtlDOExample;
import java.util.List;
import java.util.Map;

public class Newt0McLimitChangeDtlSqlProvider {

    /**
     * 根据Example对象取得商户额度变更明细【Newt0McLimitChangeDtlDO】对象count信息
     *
     * @mbggenerated Mon Aug 08 14:06:22 CST 2016
     */
    public String countByExample(Newt0McLimitChangeDtlDOExample example) {
        BEGIN();
        SELECT("count(*)");
        FROM("NEWT0_MC_LIMIT_CHANGE_DTL");
        applyWhere(example, false);
        return SQL();
    }

    /**
     * 根据Example对象删除商户额度变更明细【Newt0McLimitChangeDtlDO】对象信息
     *
     * @mbggenerated Mon Aug 08 14:06:22 CST 2016
     */
    public String deleteByExample(Newt0McLimitChangeDtlDOExample example) {
        BEGIN();
        DELETE_FROM("NEWT0_MC_LIMIT_CHANGE_DTL");
        applyWhere(example, false);
        return SQL();
    }

    /**
     * 添加商户额度变更明细【Newt0McLimitChangeDtlDO】对象信息,空值字段不插入
     *
     * @mbggenerated Mon Aug 08 14:06:22 CST 2016
     */
    public String insertSelective(Newt0McLimitChangeDtlDO record) {
        BEGIN();
        INSERT_INTO("NEWT0_MC_LIMIT_CHANGE_DTL");

        VALUES("CHANGE_ID", "#{changeId,jdbcType=DECIMAL}");

        if (record.getReqId() != null) {
            VALUES("REQ_ID", "#{reqId,jdbcType=DECIMAL}");
        }

        if (record.getMcNo() != null) {
            VALUES("MC_NO", "#{mcNo,jdbcType=VARCHAR}");
        }

        if (record.getPosMcType() != null) {
            VALUES("POS_MC_TYPE", "#{posMcType,jdbcType=VARCHAR}");
        }

        if (record.getStatus() != null) {
            VALUES("STATUS", "#{status,jdbcType=DECIMAL}");
        }

        if (record.getCreateTime() != null) {
            VALUES("CREATE_TIME", "#{createTime,jdbcType=TIMESTAMP}");
        }

        if (record.getUpdateTime() != null) {
            VALUES("UPDATE_TIME", "#{updateTime,jdbcType=TIMESTAMP}");
        }

        if (record.getMaxLimit() != null) {
            VALUES("MAX_LIMIT", "#{maxLimit,jdbcType=DECIMAL}");
        }

        if (record.getMinLimit() != null) {
            VALUES("MIN_LIMIT", "#{minLimit,jdbcType=DECIMAL}");
        }

        if (record.getMessage() != null) {
            VALUES("MESSAGE", "#{message,jdbcType=VARCHAR}");
        }

        if (record.getCfmId() != null) {
            VALUES("CFM_ID", "#{cfmId,jdbcType=DECIMAL}");
        }

        if (record.getLimitType() != null) {
            VALUES("LIMIT_TYPE", "#{limitType,jdbcType=VARCHAR}");
        }

        return SQL();
    }

    /**
     * 根据Example对象查询得到商户额度变更明细【Newt0McLimitChangeDtlDO】对象列表信息
     *
     * @mbggenerated Mon Aug 08 14:06:22 CST 2016
     */
    public String selectByExample(Newt0McLimitChangeDtlDOExample example) {
        BEGIN();
        if (example != null && example.isDistinct()) {
            SELECT_DISTINCT("CHANGE_ID");
        } else {
            SELECT("CHANGE_ID");
        }
        SELECT("REQ_ID");
        SELECT("MC_NO");
        SELECT("POS_MC_TYPE");
        SELECT("STATUS");
        SELECT("CREATE_TIME");
        SELECT("UPDATE_TIME");
        SELECT("MAX_LIMIT");
        SELECT("MIN_LIMIT");
        SELECT("MESSAGE");
        SELECT("CFM_ID");
        SELECT("LIMIT_TYPE");
        FROM("NEWT0_MC_LIMIT_CHANGE_DTL");
        applyWhere(example, false);

        if (example != null && example.getOrderByClause() != null) {
            ORDER_BY(example.getOrderByClause());
        }

        return SQL();
    }

    /**
     * 根据Query对象分页查询商户额度变更明细【Newt0McLimitChangeDtlDO】对象列表信息
     *
     * @mbggenerated Mon Aug 08 14:06:22 CST 2016
     */
    public String selectByQuery(Newt0McLimitChangeDtlDOExample example) {
        BEGIN();
        if (example != null && example.isDistinct()) {
            SELECT_DISTINCT("CHANGE_ID");
        } else {
            SELECT("CHANGE_ID");
        }
        SELECT("REQ_ID");
        SELECT("MC_NO");
        SELECT("POS_MC_TYPE");
        SELECT("STATUS");
        SELECT("CREATE_TIME");
        SELECT("UPDATE_TIME");
        SELECT("MAX_LIMIT");
        SELECT("MIN_LIMIT");
        SELECT("MESSAGE");
        SELECT("CFM_ID");
        SELECT("LIMIT_TYPE");
        FROM("NEWT0_MC_LIMIT_CHANGE_DTL");
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
     * 根据Example对象更新商户额度变更明细【Newt0McLimitChangeDtlDO】对象信息，仅更新非空字段
     *
     * @mbggenerated Mon Aug 08 14:06:22 CST 2016
     */
    public String updateByExampleSelective(Map<String, Object> parameter) {
        Newt0McLimitChangeDtlDO record = (Newt0McLimitChangeDtlDO) parameter.get("record");
        Newt0McLimitChangeDtlDOExample example = (Newt0McLimitChangeDtlDOExample) parameter.get("example");

        BEGIN();
        UPDATE("NEWT0_MC_LIMIT_CHANGE_DTL");

        if (record.getChangeId() != null) {
            SET("CHANGE_ID = #{record.changeId,jdbcType=DECIMAL}");
        }

        if (record.getReqId() != null) {
            SET("REQ_ID = #{record.reqId,jdbcType=DECIMAL}");
        }

        if (record.getMcNo() != null) {
            SET("MC_NO = #{record.mcNo,jdbcType=VARCHAR}");
        }

        if (record.getPosMcType() != null) {
            SET("POS_MC_TYPE = #{record.posMcType,jdbcType=VARCHAR}");
        }

        if (record.getStatus() != null) {
            SET("STATUS = #{record.status,jdbcType=DECIMAL}");
        }

        if (record.getCreateTime() != null) {
            SET("CREATE_TIME = #{record.createTime,jdbcType=TIMESTAMP}");
        }

        if (record.getUpdateTime() != null) {
            SET("UPDATE_TIME = #{record.updateTime,jdbcType=TIMESTAMP}");
        }

        if (record.getMaxLimit() != null) {
            SET("MAX_LIMIT = #{record.maxLimit,jdbcType=DECIMAL}");
        }

        if (record.getMinLimit() != null) {
            SET("MIN_LIMIT = #{record.minLimit,jdbcType=DECIMAL}");
        }

        if (record.getMessage() != null) {
            SET("MESSAGE = #{record.message,jdbcType=VARCHAR}");
        }

        if (record.getCfmId() != null) {
            SET("CFM_ID = #{record.cfmId,jdbcType=DECIMAL}");
        }

        if (record.getLimitType() != null) {
            SET("LIMIT_TYPE = #{record.limitType,jdbcType=VARCHAR}");
        }

        applyWhere(example, true);
        return SQL();
    }

    /**
     * 根据Example对象更新商户额度变更明细【Newt0McLimitChangeDtlDO】对象信息
     *
     * @mbggenerated Mon Aug 08 14:06:22 CST 2016
     */
    public String updateByExample(Map<String, Object> parameter) {
        BEGIN();
        UPDATE("NEWT0_MC_LIMIT_CHANGE_DTL");

        SET("CHANGE_ID = #{record.changeId,jdbcType=DECIMAL}");
        SET("REQ_ID = #{record.reqId,jdbcType=DECIMAL}");
        SET("MC_NO = #{record.mcNo,jdbcType=VARCHAR}");
        SET("POS_MC_TYPE = #{record.posMcType,jdbcType=VARCHAR}");
        SET("STATUS = #{record.status,jdbcType=DECIMAL}");
        SET("CREATE_TIME = #{record.createTime,jdbcType=TIMESTAMP}");
        SET("UPDATE_TIME = #{record.updateTime,jdbcType=TIMESTAMP}");
        SET("MAX_LIMIT = #{record.maxLimit,jdbcType=DECIMAL}");
        SET("MIN_LIMIT = #{record.minLimit,jdbcType=DECIMAL}");
        SET("MESSAGE = #{record.message,jdbcType=VARCHAR}");
        SET("CFM_ID = #{record.cfmId,jdbcType=DECIMAL}");
        SET("LIMIT_TYPE = #{record.limitType,jdbcType=VARCHAR}");

        Newt0McLimitChangeDtlDOExample example = (Newt0McLimitChangeDtlDOExample) parameter.get("example");
        applyWhere(example, true);
        return SQL();
    }

    /**
     * 根据主键更新商户额度变更明细【Newt0McLimitChangeDtlDO】对象信息，仅更新非空对象
     *
     * @mbggenerated Mon Aug 08 14:06:22 CST 2016
     */
    public String updateByPrimaryKeySelective(Newt0McLimitChangeDtlDO record) {
        BEGIN();
        UPDATE("NEWT0_MC_LIMIT_CHANGE_DTL");

        if (record.getReqId() != null) {
            SET("REQ_ID = #{reqId,jdbcType=DECIMAL}");
        }

        if (record.getMcNo() != null) {
            SET("MC_NO = #{mcNo,jdbcType=VARCHAR}");
        }

        if (record.getPosMcType() != null) {
            SET("POS_MC_TYPE = #{posMcType,jdbcType=VARCHAR}");
        }

        if (record.getStatus() != null) {
            SET("STATUS = #{status,jdbcType=DECIMAL}");
        }

        if (record.getCreateTime() != null) {
            SET("CREATE_TIME = #{createTime,jdbcType=TIMESTAMP}");
        }

        if (record.getUpdateTime() != null) {
            SET("UPDATE_TIME = #{updateTime,jdbcType=TIMESTAMP}");
        }

        if (record.getMaxLimit() != null) {
            SET("MAX_LIMIT = #{maxLimit,jdbcType=DECIMAL}");
        }

        if (record.getMinLimit() != null) {
            SET("MIN_LIMIT = #{minLimit,jdbcType=DECIMAL}");
        }

        if (record.getMessage() != null) {
            SET("MESSAGE = #{message,jdbcType=VARCHAR}");
        }

        if (record.getCfmId() != null) {
            SET("CFM_ID = #{cfmId,jdbcType=DECIMAL}");
        }

        if (record.getLimitType() != null) {
            SET("LIMIT_TYPE = #{limitType,jdbcType=VARCHAR}");
        }

        WHERE("CHANGE_ID = #{changeId,jdbcType=DECIMAL}");

        return SQL();
    }

    /**
     * This method corresponds to the database table NEWT0_MC_LIMIT_CHANGE_DTL
     *
     * @mbggenerated Mon Aug 08 14:06:22 CST 2016
     */
    protected void applyWhere(Newt0McLimitChangeDtlDOExample example, boolean includeExamplePhrase) {
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

        if (example.getChangeId() != null) {
            sb.append(" and  CHANGE_ID = #{changeId,jdbcType=DECIMAL} ");
        }

        if (example.getReqId() != null) {
            sb.append(" and  REQ_ID = #{reqId,jdbcType=DECIMAL} ");
        }

        if (example.getMcNo() != null && !example.getMcNo().equals("") ) {
            sb.append(" and  MC_NO = #{mcNo,jdbcType=VARCHAR} ");
        }

        if (example.getPosMcType() != null && !example.getPosMcType().equals("") ) {
            sb.append(" and  POS_MC_TYPE = #{posMcType,jdbcType=VARCHAR} ");
        }

        if (example.getStatus() != null) {
            sb.append(" and  STATUS = #{status,jdbcType=DECIMAL} ");
        }

        if (example.getCreateTime() != null) {
            sb.append(" and  CREATE_TIME = #{createTime,jdbcType=TIMESTAMP} ");
        }

        if (example.getUpdateTime() != null) {
            sb.append(" and  UPDATE_TIME = #{updateTime,jdbcType=TIMESTAMP} ");
        }

        if (example.getMaxLimit() != null) {
            sb.append(" and  MAX_LIMIT = #{maxLimit,jdbcType=DECIMAL} ");
        }

        if (example.getMinLimit() != null) {
            sb.append(" and  MIN_LIMIT = #{minLimit,jdbcType=DECIMAL} ");
        }

        if (example.getMessage() != null && !example.getMessage().equals("") ) {
            sb.append(" and  MESSAGE = #{message,jdbcType=VARCHAR} ");
        }

        if (example.getCfmId() != null) {
            sb.append(" and  CFM_ID = #{cfmId,jdbcType=DECIMAL} ");
        }

        if (example.getLimitType() != null && !example.getLimitType().equals("") ) {
            sb.append(" and  LIMIT_TYPE = #{limitType,jdbcType=VARCHAR} ");
        }
        WHERE(sb.toString());
    }
}