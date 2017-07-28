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

import com.sdp.mc.newt0.dao.SendMessageLogDO;
import com.sdp.mc.newt0.dao.SendMessageLogDOExample.Criteria;
import com.sdp.mc.newt0.dao.SendMessageLogDOExample.Criterion;
import com.sdp.mc.newt0.dao.SendMessageLogDOExample;
import java.util.List;
import java.util.Map;

public class SendMessageLogSqlProvider {

    /**
     * 根据Example对象取得短信发送日志表【SendMessageLogDO】对象count信息
     *
     * @mbggenerated Mon Oct 12 13:53:07 CST 2015
     */
    public String countByExample(SendMessageLogDOExample example) {
        BEGIN();
        SELECT("count(*)");
        FROM("TB_SEND_MESSAGE_LOG");
        applyWhere(example, false);
        return SQL();
    }

    /**
     * 根据Example对象删除短信发送日志表【SendMessageLogDO】对象信息
     *
     * @mbggenerated Mon Oct 12 13:53:07 CST 2015
     */
    public String deleteByExample(SendMessageLogDOExample example) {
        BEGIN();
        DELETE_FROM("TB_SEND_MESSAGE_LOG");
        applyWhere(example, false);
        return SQL();
    }

    /**
     * 添加短信发送日志表【SendMessageLogDO】对象信息,空值字段不插入
     *
     * @mbggenerated Mon Oct 12 13:53:07 CST 2015
     */
    public String insertSelective(SendMessageLogDO record) {
        BEGIN();
        INSERT_INTO("TB_SEND_MESSAGE_LOG");
        
        VALUES("ID", "#{id,jdbcType=DECIMAL}");
        
        if (record.getPhone() != null) {
            VALUES("PHONE", "#{phone,jdbcType=VARCHAR}");
        }
        
        if (record.getTemplateCode() != null) {
            VALUES("TEMPLATE_CODE", "#{templateCode,jdbcType=VARCHAR}");
        }
        
        if (record.getMessageInfo() != null) {
            VALUES("MESSAGE_INFO", "#{messageInfo,jdbcType=VARCHAR}");
        }
        
        if (record.getSendState() != null) {
            VALUES("SEND_STATE", "#{sendState,jdbcType=VARCHAR}");
        }
        
        if (record.getSendResultInfo() != null) {
            VALUES("SEND_RESULT_INFO", "#{sendResultInfo,jdbcType=VARCHAR}");
        }
        
        if (record.getOperator() != null) {
            VALUES("OPERATOR", "#{operator,jdbcType=VARCHAR}");
        }
        
        if (record.getOperatorId() != null) {
            VALUES("OPERATOR_ID", "#{operatorId,jdbcType=VARCHAR}");
        }
        
        if (record.getCreatedAt() != null) {
            VALUES("CREATED_AT", "#{createdAt,jdbcType=TIMESTAMP}");
        }
        
        if (record.getUpdatedAt() != null) {
            VALUES("UPDATED_AT", "#{updatedAt,jdbcType=TIMESTAMP}");
        }
        
        if (record.getExt1() != null) {
            VALUES("EXT1", "#{ext1,jdbcType=VARCHAR}");
        }
        
        if (record.getExt2() != null) {
            VALUES("EXT2", "#{ext2,jdbcType=VARCHAR}");
        }
        
        return SQL();
    }

    /**
     * 根据Example对象查询得到短信发送日志表【SendMessageLogDO】对象列表信息
     *
     * @mbggenerated Mon Oct 12 13:53:07 CST 2015
     */
    public String selectByExample(SendMessageLogDOExample example) {
        BEGIN();
        if (example != null && example.isDistinct()) {
            SELECT_DISTINCT("ID");
        } else {
            SELECT("ID");
        }
        SELECT("PHONE");
        SELECT("TEMPLATE_CODE");
        SELECT("MESSAGE_INFO");
        SELECT("SEND_STATE");
        SELECT("SEND_RESULT_INFO");
        SELECT("OPERATOR");
        SELECT("OPERATOR_ID");
        SELECT("CREATED_AT");
        SELECT("UPDATED_AT");
        SELECT("EXT1");
        SELECT("EXT2");
        FROM("TB_SEND_MESSAGE_LOG");
        applyWhere(example, false);
        
        if (example != null && example.getOrderByClause() != null) {
            ORDER_BY(example.getOrderByClause());
        }
        
        return SQL();
    }

    /**
     * 根据Query对象分页查询短信发送日志表【SendMessageLogDO】对象列表信息
     *
     * @mbggenerated Mon Oct 12 13:53:07 CST 2015
     */
    public String selectByQuery(SendMessageLogDOExample example) {
        BEGIN();
        if (example != null && example.isDistinct()) {
            SELECT_DISTINCT("ID");
        } else {
            SELECT("ID");
        }
        SELECT("PHONE");
        SELECT("TEMPLATE_CODE");
        SELECT("MESSAGE_INFO");
        SELECT("SEND_STATE");
        SELECT("SEND_RESULT_INFO");
        SELECT("OPERATOR");
        SELECT("OPERATOR_ID");
        SELECT("CREATED_AT");
        SELECT("UPDATED_AT");
        SELECT("EXT1");
        SELECT("EXT2");
        FROM("TB_SEND_MESSAGE_LOG");
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
     * 根据Example对象更新短信发送日志表【SendMessageLogDO】对象信息，仅更新非空字段
     *
     * @mbggenerated Mon Oct 12 13:53:07 CST 2015
     */
    public String updateByExampleSelective(Map<String, Object> parameter) {
        SendMessageLogDO record = (SendMessageLogDO) parameter.get("record");
        SendMessageLogDOExample example = (SendMessageLogDOExample) parameter.get("example");
        
        BEGIN();
        UPDATE("TB_SEND_MESSAGE_LOG");
        
        if (record.getId() != null) {
            SET("ID = #{record.id,jdbcType=DECIMAL}");
        }
        
        if (record.getPhone() != null) {
            SET("PHONE = #{record.phone,jdbcType=VARCHAR}");
        }
        
        if (record.getTemplateCode() != null) {
            SET("TEMPLATE_CODE = #{record.templateCode,jdbcType=VARCHAR}");
        }
        
        if (record.getMessageInfo() != null) {
            SET("MESSAGE_INFO = #{record.messageInfo,jdbcType=VARCHAR}");
        }
        
        if (record.getSendState() != null) {
            SET("SEND_STATE = #{record.sendState,jdbcType=VARCHAR}");
        }
        
        if (record.getSendResultInfo() != null) {
            SET("SEND_RESULT_INFO = #{record.sendResultInfo,jdbcType=VARCHAR}");
        }
        
        if (record.getOperator() != null) {
            SET("OPERATOR = #{record.operator,jdbcType=VARCHAR}");
        }
        
        if (record.getOperatorId() != null) {
            SET("OPERATOR_ID = #{record.operatorId,jdbcType=VARCHAR}");
        }
        
        if (record.getCreatedAt() != null) {
            SET("CREATED_AT = #{record.createdAt,jdbcType=TIMESTAMP}");
        }
        
        if (record.getUpdatedAt() != null) {
            SET("UPDATED_AT = #{record.updatedAt,jdbcType=TIMESTAMP}");
        }
        
        if (record.getExt1() != null) {
            SET("EXT1 = #{record.ext1,jdbcType=VARCHAR}");
        }
        
        if (record.getExt2() != null) {
            SET("EXT2 = #{record.ext2,jdbcType=VARCHAR}");
        }
        
        applyWhere(example, true);
        return SQL();
    }

    /**
     * 根据Example对象更新短信发送日志表【SendMessageLogDO】对象信息
     *
     * @mbggenerated Mon Oct 12 13:53:07 CST 2015
     */
    public String updateByExample(Map<String, Object> parameter) {
        BEGIN();
        UPDATE("TB_SEND_MESSAGE_LOG");
        
        SET("ID = #{record.id,jdbcType=DECIMAL}");
        SET("PHONE = #{record.phone,jdbcType=VARCHAR}");
        SET("TEMPLATE_CODE = #{record.templateCode,jdbcType=VARCHAR}");
        SET("MESSAGE_INFO = #{record.messageInfo,jdbcType=VARCHAR}");
        SET("SEND_STATE = #{record.sendState,jdbcType=VARCHAR}");
        SET("SEND_RESULT_INFO = #{record.sendResultInfo,jdbcType=VARCHAR}");
        SET("OPERATOR = #{record.operator,jdbcType=VARCHAR}");
        SET("OPERATOR_ID = #{record.operatorId,jdbcType=VARCHAR}");
        SET("CREATED_AT = #{record.createdAt,jdbcType=TIMESTAMP}");
        SET("UPDATED_AT = #{record.updatedAt,jdbcType=TIMESTAMP}");
        SET("EXT1 = #{record.ext1,jdbcType=VARCHAR}");
        SET("EXT2 = #{record.ext2,jdbcType=VARCHAR}");
        
        SendMessageLogDOExample example = (SendMessageLogDOExample) parameter.get("example");
        applyWhere(example, true);
        return SQL();
    }

    /**
     * 根据主键更新短信发送日志表【SendMessageLogDO】对象信息，仅更新非空对象
     *
     * @mbggenerated Mon Oct 12 13:53:07 CST 2015
     */
    public String updateByPrimaryKeySelective(SendMessageLogDO record) {
        BEGIN();
        UPDATE("TB_SEND_MESSAGE_LOG");
        
        if (record.getPhone() != null) {
            SET("PHONE = #{phone,jdbcType=VARCHAR}");
        }
        
        if (record.getTemplateCode() != null) {
            SET("TEMPLATE_CODE = #{templateCode,jdbcType=VARCHAR}");
        }
        
        if (record.getMessageInfo() != null) {
            SET("MESSAGE_INFO = #{messageInfo,jdbcType=VARCHAR}");
        }
        
        if (record.getSendState() != null) {
            SET("SEND_STATE = #{sendState,jdbcType=VARCHAR}");
        }
        
        if (record.getSendResultInfo() != null) {
            SET("SEND_RESULT_INFO = #{sendResultInfo,jdbcType=VARCHAR}");
        }
        
        if (record.getOperator() != null) {
            SET("OPERATOR = #{operator,jdbcType=VARCHAR}");
        }
        
        if (record.getOperatorId() != null) {
            SET("OPERATOR_ID = #{operatorId,jdbcType=VARCHAR}");
        }
        
        if (record.getCreatedAt() != null) {
            SET("CREATED_AT = #{createdAt,jdbcType=TIMESTAMP}");
        }
        
        if (record.getUpdatedAt() != null) {
            SET("UPDATED_AT = #{updatedAt,jdbcType=TIMESTAMP}");
        }
        
        if (record.getExt1() != null) {
            SET("EXT1 = #{ext1,jdbcType=VARCHAR}");
        }
        
        if (record.getExt2() != null) {
            SET("EXT2 = #{ext2,jdbcType=VARCHAR}");
        }
        
        WHERE("ID = #{id,jdbcType=DECIMAL}");
        
        return SQL();
    }

    /**
     * This method corresponds to the database table TB_SEND_MESSAGE_LOG
     *
     * @mbggenerated Mon Oct 12 13:53:07 CST 2015
     */
    protected void applyWhere(SendMessageLogDOExample example, boolean includeExamplePhrase) {
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
        
        if (example.getPhone() != null && !example.getPhone().equals("") ) {
            sb.append(" and  PHONE = #{phone,jdbcType=VARCHAR} ");
        }
        
        if (example.getTemplateCode() != null && !example.getTemplateCode().equals("") ) {
            sb.append(" and  TEMPLATE_CODE = #{templateCode,jdbcType=VARCHAR} ");
        }
        
        if (example.getMessageInfo() != null && !example.getMessageInfo().equals("") ) {
            sb.append(" and  MESSAGE_INFO = #{messageInfo,jdbcType=VARCHAR} ");
        }
        
        if (example.getSendState() != null && !example.getSendState().equals("") ) {
            sb.append(" and  SEND_STATE = #{sendState,jdbcType=VARCHAR} ");
        }
        
        if (example.getSendResultInfo() != null && !example.getSendResultInfo().equals("") ) {
            sb.append(" and  SEND_RESULT_INFO = #{sendResultInfo,jdbcType=VARCHAR} ");
        }
        
        if (example.getOperator() != null && !example.getOperator().equals("") ) {
            sb.append(" and  OPERATOR = #{operator,jdbcType=VARCHAR} ");
        }
        
        if (example.getOperatorId() != null && !example.getOperatorId().equals("") ) {
            sb.append(" and  OPERATOR_ID = #{operatorId,jdbcType=VARCHAR} ");
        }
        
        if (example.getCreatedAt() != null) {
            sb.append(" and  CREATED_AT = #{createdAt,jdbcType=TIMESTAMP} ");
        }
        
        if (example.getUpdatedAt() != null) {
            sb.append(" and  UPDATED_AT = #{updatedAt,jdbcType=TIMESTAMP} ");
        }
        
        if (example.getExt1() != null && !example.getExt1().equals("") ) {
            sb.append(" and  EXT1 = #{ext1,jdbcType=VARCHAR} ");
        }
        
        if (example.getExt2() != null && !example.getExt2().equals("") ) {
            sb.append(" and  EXT2 = #{ext2,jdbcType=VARCHAR} ");
        }
        WHERE(sb.toString());
    }
}