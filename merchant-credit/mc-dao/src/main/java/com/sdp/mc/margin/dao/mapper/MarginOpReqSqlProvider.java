package com.sdp.mc.margin.dao.mapper;

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

import com.sdp.mc.margin.dao.MarginOpReqDO;
import com.sdp.mc.margin.dao.MarginOpReqDOExample.Criteria;
import com.sdp.mc.margin.dao.MarginOpReqDOExample.Criterion;
import com.sdp.mc.margin.dao.MarginOpReqDOExample;
import java.util.List;
import java.util.Map;

public class MarginOpReqSqlProvider {

    /**
     * 根据Example对象取得代理商保证金追加/退回记录【MarginOpReqDO】对象count信息
     *
     * @mbggenerated Mon Mar 30 13:57:53 CST 2015
     */
    public String countByExample(MarginOpReqDOExample example) {
        BEGIN();
        SELECT("count(*)");
        FROM("TB_MARGIN_OP_REQ");
        applyWhere(example, false);
        return SQL();
    }

    /**
     * 根据Example对象删除代理商保证金追加/退回记录【MarginOpReqDO】对象信息
     *
     * @mbggenerated Mon Mar 30 13:57:53 CST 2015
     */
    public String deleteByExample(MarginOpReqDOExample example) {
        BEGIN();
        DELETE_FROM("TB_MARGIN_OP_REQ");
        applyWhere(example, false);
        return SQL();
    }

    /**
     * 添加代理商保证金追加/退回记录【MarginOpReqDO】对象信息,空值字段不插入
     *
     * @mbggenerated Mon Mar 30 13:57:53 CST 2015
     */
    public String insertSelective(MarginOpReqDO record) {
        BEGIN();
        INSERT_INTO("TB_MARGIN_OP_REQ");
        
        VALUES("MOR_ID", "#{morId,jdbcType=DECIMAL}");
        
        if (record.getPromoterId() != null) {
            VALUES("PROMOTER_ID", "#{promoterId,jdbcType=DECIMAL}");
        }
        
        if (record.getOpType() != null) {
            VALUES("OP_TYPE", "#{opType,jdbcType=DECIMAL}");
        }
        
        if (record.getStatus() != null) {
            VALUES("STATUS", "#{status,jdbcType=DECIMAL}");
        }
        
        if (record.getAmount() != null) {
            VALUES("AMOUNT", "#{amount,jdbcType=DECIMAL}");
        }
        
        if (record.getRedeemedTime() != null) {
            VALUES("REDEEMED_TIME", "#{redeemedTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getMtId() != null) {
            VALUES("MT_ID", "#{mtId,jdbcType=DECIMAL}");
        }
        
        if (record.getMtIdHis() != null) {
            VALUES("MT_ID_HIS", "#{mtIdHis,jdbcType=VARCHAR}");
        }
        
        if (record.getFcmId() != null) {
            VALUES("FCM_ID", "#{fcmId,jdbcType=DECIMAL}");
        }
        
        if (record.getFcmIdHis() != null) {
            VALUES("FCM_ID_HIS", "#{fcmIdHis,jdbcType=VARCHAR}");
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
     * 根据Example对象查询得到代理商保证金追加/退回记录【MarginOpReqDO】对象列表信息
     *
     * @mbggenerated Mon Mar 30 13:57:53 CST 2015
     */
    public String selectByExample(MarginOpReqDOExample example) {
        BEGIN();
        if (example != null && example.isDistinct()) {
            SELECT_DISTINCT("MOR_ID");
        } else {
            SELECT("MOR_ID");
        }
        SELECT("PROMOTER_ID");
        SELECT("OP_TYPE");
        SELECT("STATUS");
        SELECT("AMOUNT");
        SELECT("REDEEMED_TIME");
        SELECT("MT_ID");
        SELECT("MT_ID_HIS");
        SELECT("FCM_ID");
        SELECT("FCM_ID_HIS");
        SELECT("CREATE_TIME");
        SELECT("UPDATE_TIME");
        FROM("TB_MARGIN_OP_REQ");
        applyWhere(example, false);
        
        if (example != null && example.getOrderByClause() != null) {
            ORDER_BY(example.getOrderByClause());
        }
        
        return SQL();
    }

    /**
     * 根据Query对象分页查询代理商保证金追加/退回记录【MarginOpReqDO】对象列表信息
     *
     * @mbggenerated Mon Mar 30 13:57:53 CST 2015
     */
    public String selectByQuery(MarginOpReqDOExample example) {
        BEGIN();
        if (example != null && example.isDistinct()) {
            SELECT_DISTINCT("MOR_ID");
        } else {
            SELECT("MOR_ID");
        }
        SELECT("PROMOTER_ID");
        SELECT("OP_TYPE");
        SELECT("STATUS");
        SELECT("AMOUNT");
        SELECT("REDEEMED_TIME");
        SELECT("MT_ID");
        SELECT("MT_ID_HIS");
        SELECT("FCM_ID");
        SELECT("FCM_ID_HIS");
        SELECT("CREATE_TIME");
        SELECT("UPDATE_TIME");
        FROM("TB_MARGIN_OP_REQ");
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
     * 根据Example对象更新代理商保证金追加/退回记录【MarginOpReqDO】对象信息，仅更新非空字段
     *
     * @mbggenerated Mon Mar 30 13:57:53 CST 2015
     */
    public String updateByExampleSelective(Map<String, Object> parameter) {
        MarginOpReqDO record = (MarginOpReqDO) parameter.get("record");
        MarginOpReqDOExample example = (MarginOpReqDOExample) parameter.get("example");
        
        BEGIN();
        UPDATE("TB_MARGIN_OP_REQ");
        
        if (record.getMorId() != null) {
            SET("MOR_ID = #{record.morId,jdbcType=DECIMAL}");
        }
        
        if (record.getPromoterId() != null) {
            SET("PROMOTER_ID = #{record.promoterId,jdbcType=DECIMAL}");
        }
        
        if (record.getOpType() != null) {
            SET("OP_TYPE = #{record.opType,jdbcType=DECIMAL}");
        }
        
        if (record.getStatus() != null) {
            SET("STATUS = #{record.status,jdbcType=DECIMAL}");
        }
        
        if (record.getAmount() != null) {
            SET("AMOUNT = #{record.amount,jdbcType=DECIMAL}");
        }
        
        if (record.getRedeemedTime() != null) {
            SET("REDEEMED_TIME = #{record.redeemedTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getMtId() != null) {
            SET("MT_ID = #{record.mtId,jdbcType=DECIMAL}");
        }
        
        if (record.getMtIdHis() != null) {
            SET("MT_ID_HIS = #{record.mtIdHis,jdbcType=VARCHAR}");
        }
        
        if (record.getFcmId() != null) {
            SET("FCM_ID = #{record.fcmId,jdbcType=DECIMAL}");
        }
        
        if (record.getFcmIdHis() != null) {
            SET("FCM_ID_HIS = #{record.fcmIdHis,jdbcType=VARCHAR}");
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
     * 根据Example对象更新代理商保证金追加/退回记录【MarginOpReqDO】对象信息
     *
     * @mbggenerated Mon Mar 30 13:57:53 CST 2015
     */
    public String updateByExample(Map<String, Object> parameter) {
        BEGIN();
        UPDATE("TB_MARGIN_OP_REQ");
        
        SET("MOR_ID = #{record.morId,jdbcType=DECIMAL}");
        SET("PROMOTER_ID = #{record.promoterId,jdbcType=DECIMAL}");
        SET("OP_TYPE = #{record.opType,jdbcType=DECIMAL}");
        SET("STATUS = #{record.status,jdbcType=DECIMAL}");
        SET("AMOUNT = #{record.amount,jdbcType=DECIMAL}");
        SET("REDEEMED_TIME = #{record.redeemedTime,jdbcType=TIMESTAMP}");
        SET("MT_ID = #{record.mtId,jdbcType=DECIMAL}");
        SET("MT_ID_HIS = #{record.mtIdHis,jdbcType=VARCHAR}");
        SET("FCM_ID = #{record.fcmId,jdbcType=DECIMAL}");
        SET("FCM_ID_HIS = #{record.fcmIdHis,jdbcType=VARCHAR}");
        SET("CREATE_TIME = #{record.createTime,jdbcType=TIMESTAMP}");
        SET("UPDATE_TIME = #{record.updateTime,jdbcType=TIMESTAMP}");
        
        MarginOpReqDOExample example = (MarginOpReqDOExample) parameter.get("example");
        applyWhere(example, true);
        return SQL();
    }

    /**
     * 根据主键更新代理商保证金追加/退回记录【MarginOpReqDO】对象信息，仅更新非空对象
     *
     * @mbggenerated Mon Mar 30 13:57:53 CST 2015
     */
    public String updateByPrimaryKeySelective(MarginOpReqDO record) {
        BEGIN();
        UPDATE("TB_MARGIN_OP_REQ");
        
        if (record.getPromoterId() != null) {
            SET("PROMOTER_ID = #{promoterId,jdbcType=DECIMAL}");
        }
        
        if (record.getOpType() != null) {
            SET("OP_TYPE = #{opType,jdbcType=DECIMAL}");
        }
        
        if (record.getStatus() != null) {
            SET("STATUS = #{status,jdbcType=DECIMAL}");
        }
        
        if (record.getAmount() != null) {
            SET("AMOUNT = #{amount,jdbcType=DECIMAL}");
        }
        
        if (record.getRedeemedTime() != null) {
            SET("REDEEMED_TIME = #{redeemedTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getMtId() != null) {
            SET("MT_ID = #{mtId,jdbcType=DECIMAL}");
        }
        
        if (record.getMtIdHis() != null) {
            SET("MT_ID_HIS = #{mtIdHis,jdbcType=VARCHAR}");
        }
        
        if (record.getFcmId() != null) {
            SET("FCM_ID = #{fcmId,jdbcType=DECIMAL}");
        }
        
        if (record.getFcmIdHis() != null) {
            SET("FCM_ID_HIS = #{fcmIdHis,jdbcType=VARCHAR}");
        }
        
        if (record.getCreateTime() != null) {
            SET("CREATE_TIME = #{createTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getUpdateTime() != null) {
            SET("UPDATE_TIME = #{updateTime,jdbcType=TIMESTAMP}");
        }
        
        WHERE("MOR_ID = #{morId,jdbcType=DECIMAL}");
        
        return SQL();
    }

    /**
     * This method corresponds to the database table TB_MARGIN_OP_REQ
     *
     * @mbggenerated Mon Mar 30 13:57:53 CST 2015
     */
    protected void applyWhere(MarginOpReqDOExample example, boolean includeExamplePhrase) {
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
        
        if (example.getMorId() != null) {
            sb.append(" and  MOR_ID = #{morId,jdbcType=DECIMAL} ");
        }
        
        if (example.getPromoterId() != null) {
            sb.append(" and  PROMOTER_ID = #{promoterId,jdbcType=DECIMAL} ");
        }
        
        if (example.getOpType() != null) {
            sb.append(" and  OP_TYPE = #{opType,jdbcType=DECIMAL} ");
        }
        
        if (example.getStatus() != null) {
            sb.append(" and  STATUS = #{status,jdbcType=DECIMAL} ");
        }
        
        if (example.getAmount() != null) {
            sb.append(" and  AMOUNT = #{amount,jdbcType=DECIMAL} ");
        }
        
        if (example.getRedeemedTime() != null) {
            sb.append(" and  REDEEMED_TIME = #{redeemedTime,jdbcType=TIMESTAMP} ");
        }
        
        if (example.getMtId() != null && !example.getMtId().equals("") ) {
            sb.append(" and  MT_ID = #{mtId,jdbcType=DECIMAL} ");
        }
        
        if (example.getMtIdHis() != null && !example.getMtIdHis().equals("") ) {
            sb.append(" and  MT_ID_HIS = #{mtIdHis,jdbcType=VARCHAR} ");
        }
        
        if (example.getFcmId() != null) {
            sb.append(" and  FCM_ID = #{fcmId,jdbcType=DECIMAL} ");
        }
        
        if (example.getFcmIdHis() != null && !example.getFcmIdHis().equals("") ) {
            sb.append(" and  FCM_ID_HIS = #{fcmIdHis,jdbcType=VARCHAR} ");
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