package com.sdp.mc.ma.dao.mapper;

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

import com.sdp.mc.ma.dao.MarginAccountRequestDO;
import com.sdp.mc.ma.dao.MarginAccountRequestDOExample.Criteria;
import com.sdp.mc.ma.dao.MarginAccountRequestDOExample.Criterion;
import com.sdp.mc.ma.dao.MarginAccountRequestDOExample;
import java.util.List;
import java.util.Map;

public class MarginAccountRequestSqlProvider {

    /**
     * 根据Example对象取得保证金账户开户记录【MarginAccountRequestDO】对象count信息
     *
     * @mbggenerated Fri May 29 18:06:19 CST 2015
     */
    public String countByExample(MarginAccountRequestDOExample example) {
        BEGIN();
        SELECT("count(*)");
        FROM("TB_MARGIN_ACCOUNT_REQ");
        applyWhere(example, false);
        return SQL();
    }

    /**
     * 根据Example对象删除保证金账户开户记录【MarginAccountRequestDO】对象信息
     *
     * @mbggenerated Fri May 29 18:06:19 CST 2015
     */
    public String deleteByExample(MarginAccountRequestDOExample example) {
        BEGIN();
        DELETE_FROM("TB_MARGIN_ACCOUNT_REQ");
        applyWhere(example, false);
        return SQL();
    }

    /**
     * 添加保证金账户开户记录【MarginAccountRequestDO】对象信息,空值字段不插入
     *
     * @mbggenerated Fri May 29 18:06:19 CST 2015
     */
    public String insertSelective(MarginAccountRequestDO record) {
        BEGIN();
        INSERT_INTO("TB_MARGIN_ACCOUNT_REQ");
        
        VALUES("ID", "#{id,jdbcType=DECIMAL}");
        
        if (record.getStatus() != null) {
            VALUES("STATUS", "#{status,jdbcType=VARCHAR}");
        }
        
        if (record.getSourceId() != null) {
            VALUES("SOURCE_ID", "#{sourceId,jdbcType=VARCHAR}");
        }
        
        if (record.getMerchantNo() != null) {
            VALUES("MERCHANT_NO", "#{merchantNo,jdbcType=VARCHAR}");
        }
        
        if (record.getMemberId() != null) {
            VALUES("MEMBER_ID", "#{memberId,jdbcType=VARCHAR}");
        }
        
        if (record.getAccountId() != null) {
            VALUES("ACCOUNT_ID", "#{accountId,jdbcType=VARCHAR}");
        }
        
        if (record.getRequestNo() != null) {
            VALUES("REQUEST_NO", "#{requestNo,jdbcType=VARCHAR}");
        }
        
        if (record.getAppIp() != null) {
            VALUES("APP_IP", "#{appIp,jdbcType=VARCHAR}");
        }
        
        if (record.getRequestOperator() != null) {
            VALUES("REQUEST_OPERATOR", "#{requestOperator,jdbcType=VARCHAR}");
        }
        
        if (record.getUserIp() != null) {
            VALUES("USER_IP", "#{userIp,jdbcType=VARCHAR}");
        }
        
        if (record.getResponseCode() != null) {
            VALUES("RESPONSE_CODE", "#{responseCode,jdbcType=VARCHAR}");
        }
        
        if (record.getResponseMessage() != null) {
            VALUES("RESPONSE_MESSAGE", "#{responseMessage,jdbcType=VARCHAR}");
        }
        
        if (record.getRequestTime() != null) {
            VALUES("REQUEST_TIME", "#{requestTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getResponseTime() != null) {
            VALUES("RESPONSE_TIME", "#{responseTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getAccountType() != null) {
            VALUES("ACCOUNT_TYPE", "#{accountType,jdbcType=DECIMAL}");
        }
        
        return SQL();
    }

    /**
     * 根据Example对象查询得到保证金账户开户记录【MarginAccountRequestDO】对象列表信息
     *
     * @mbggenerated Fri May 29 18:06:19 CST 2015
     */
    public String selectByExample(MarginAccountRequestDOExample example) {
        BEGIN();
        if (example != null && example.isDistinct()) {
            SELECT_DISTINCT("ID");
        } else {
            SELECT("ID");
        }
        SELECT("STATUS");
        SELECT("SOURCE_ID");
        SELECT("MERCHANT_NO");
        SELECT("MEMBER_ID");
        SELECT("ACCOUNT_ID");
        SELECT("REQUEST_NO");
        SELECT("APP_IP");
        SELECT("REQUEST_OPERATOR");
        SELECT("USER_IP");
        SELECT("RESPONSE_CODE");
        SELECT("RESPONSE_MESSAGE");
        SELECT("REQUEST_TIME");
        SELECT("RESPONSE_TIME");
        SELECT("ACCOUNT_TYPE");
        FROM("TB_MARGIN_ACCOUNT_REQ");
        applyWhere(example, false);
        
        if (example != null && example.getOrderByClause() != null) {
            ORDER_BY(example.getOrderByClause());
        }
        
        return SQL();
    }

    /**
     * 根据Query对象分页查询保证金账户开户记录【MarginAccountRequestDO】对象列表信息
     *
     * @mbggenerated Fri May 29 18:06:19 CST 2015
     */
    public String selectByQuery(MarginAccountRequestDOExample example) {
        BEGIN();
        if (example != null && example.isDistinct()) {
            SELECT_DISTINCT("ID");
        } else {
            SELECT("ID");
        }
        SELECT("STATUS");
        SELECT("SOURCE_ID");
        SELECT("MERCHANT_NO");
        SELECT("MEMBER_ID");
        SELECT("ACCOUNT_ID");
        SELECT("REQUEST_NO");
        SELECT("APP_IP");
        SELECT("REQUEST_OPERATOR");
        SELECT("USER_IP");
        SELECT("RESPONSE_CODE");
        SELECT("RESPONSE_MESSAGE");
        SELECT("REQUEST_TIME");
        SELECT("RESPONSE_TIME");
        SELECT("ACCOUNT_TYPE");
        FROM("TB_MARGIN_ACCOUNT_REQ");
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
     * 根据Example对象更新保证金账户开户记录【MarginAccountRequestDO】对象信息，仅更新非空字段
     *
     * @mbggenerated Fri May 29 18:06:19 CST 2015
     */
    public String updateByExampleSelective(Map<String, Object> parameter) {
        MarginAccountRequestDO record = (MarginAccountRequestDO) parameter.get("record");
        MarginAccountRequestDOExample example = (MarginAccountRequestDOExample) parameter.get("example");
        
        BEGIN();
        UPDATE("TB_MARGIN_ACCOUNT_REQ");
        
        if (record.getId() != null) {
            SET("ID = #{record.id,jdbcType=DECIMAL}");
        }
        
        if (record.getStatus() != null) {
            SET("STATUS = #{record.status,jdbcType=VARCHAR}");
        }
        
        if (record.getSourceId() != null) {
            SET("SOURCE_ID = #{record.sourceId,jdbcType=VARCHAR}");
        }
        
        if (record.getMerchantNo() != null) {
            SET("MERCHANT_NO = #{record.merchantNo,jdbcType=VARCHAR}");
        }
        
        if (record.getMemberId() != null) {
            SET("MEMBER_ID = #{record.memberId,jdbcType=VARCHAR}");
        }
        
        if (record.getAccountId() != null) {
            SET("ACCOUNT_ID = #{record.accountId,jdbcType=VARCHAR}");
        }
        
        if (record.getRequestNo() != null) {
            SET("REQUEST_NO = #{record.requestNo,jdbcType=VARCHAR}");
        }
        
        if (record.getAppIp() != null) {
            SET("APP_IP = #{record.appIp,jdbcType=VARCHAR}");
        }
        
        if (record.getRequestOperator() != null) {
            SET("REQUEST_OPERATOR = #{record.requestOperator,jdbcType=VARCHAR}");
        }
        
        if (record.getUserIp() != null) {
            SET("USER_IP = #{record.userIp,jdbcType=VARCHAR}");
        }
        
        if (record.getResponseCode() != null) {
            SET("RESPONSE_CODE = #{record.responseCode,jdbcType=VARCHAR}");
        }
        
        if (record.getResponseMessage() != null) {
            SET("RESPONSE_MESSAGE = #{record.responseMessage,jdbcType=VARCHAR}");
        }
        
        if (record.getRequestTime() != null) {
            SET("REQUEST_TIME = #{record.requestTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getResponseTime() != null) {
            SET("RESPONSE_TIME = #{record.responseTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getAccountType() != null) {
            SET("ACCOUNT_TYPE = #{record.accountType,jdbcType=DECIMAL}");
        }
        
        applyWhere(example, true);
        return SQL();
    }

    /**
     * 根据Example对象更新保证金账户开户记录【MarginAccountRequestDO】对象信息
     *
     * @mbggenerated Fri May 29 18:06:19 CST 2015
     */
    public String updateByExample(Map<String, Object> parameter) {
        BEGIN();
        UPDATE("TB_MARGIN_ACCOUNT_REQ");
        
        SET("ID = #{record.id,jdbcType=DECIMAL}");
        SET("STATUS = #{record.status,jdbcType=VARCHAR}");
        SET("SOURCE_ID = #{record.sourceId,jdbcType=VARCHAR}");
        SET("MERCHANT_NO = #{record.merchantNo,jdbcType=VARCHAR}");
        SET("MEMBER_ID = #{record.memberId,jdbcType=VARCHAR}");
        SET("ACCOUNT_ID = #{record.accountId,jdbcType=VARCHAR}");
        SET("REQUEST_NO = #{record.requestNo,jdbcType=VARCHAR}");
        SET("APP_IP = #{record.appIp,jdbcType=VARCHAR}");
        SET("REQUEST_OPERATOR = #{record.requestOperator,jdbcType=VARCHAR}");
        SET("USER_IP = #{record.userIp,jdbcType=VARCHAR}");
        SET("RESPONSE_CODE = #{record.responseCode,jdbcType=VARCHAR}");
        SET("RESPONSE_MESSAGE = #{record.responseMessage,jdbcType=VARCHAR}");
        SET("REQUEST_TIME = #{record.requestTime,jdbcType=TIMESTAMP}");
        SET("RESPONSE_TIME = #{record.responseTime,jdbcType=TIMESTAMP}");
        SET("ACCOUNT_TYPE = #{record.accountType,jdbcType=DECIMAL}");
        
        MarginAccountRequestDOExample example = (MarginAccountRequestDOExample) parameter.get("example");
        applyWhere(example, true);
        return SQL();
    }

    /**
     * 根据主键更新保证金账户开户记录【MarginAccountRequestDO】对象信息，仅更新非空对象
     *
     * @mbggenerated Fri May 29 18:06:19 CST 2015
     */
    public String updateByPrimaryKeySelective(MarginAccountRequestDO record) {
        BEGIN();
        UPDATE("TB_MARGIN_ACCOUNT_REQ");
        
        if (record.getStatus() != null) {
            SET("STATUS = #{status,jdbcType=VARCHAR}");
        }
        
        if (record.getSourceId() != null) {
            SET("SOURCE_ID = #{sourceId,jdbcType=VARCHAR}");
        }
        
        if (record.getMerchantNo() != null) {
            SET("MERCHANT_NO = #{merchantNo,jdbcType=VARCHAR}");
        }
        
        if (record.getMemberId() != null) {
            SET("MEMBER_ID = #{memberId,jdbcType=VARCHAR}");
        }
        
        if (record.getAccountId() != null) {
            SET("ACCOUNT_ID = #{accountId,jdbcType=VARCHAR}");
        }
        
        if (record.getRequestNo() != null) {
            SET("REQUEST_NO = #{requestNo,jdbcType=VARCHAR}");
        }
        
        if (record.getAppIp() != null) {
            SET("APP_IP = #{appIp,jdbcType=VARCHAR}");
        }
        
        if (record.getRequestOperator() != null) {
            SET("REQUEST_OPERATOR = #{requestOperator,jdbcType=VARCHAR}");
        }
        
        if (record.getUserIp() != null) {
            SET("USER_IP = #{userIp,jdbcType=VARCHAR}");
        }
        
        if (record.getResponseCode() != null) {
            SET("RESPONSE_CODE = #{responseCode,jdbcType=VARCHAR}");
        }
        
        if (record.getResponseMessage() != null) {
            SET("RESPONSE_MESSAGE = #{responseMessage,jdbcType=VARCHAR}");
        }
        
        if (record.getRequestTime() != null) {
            SET("REQUEST_TIME = #{requestTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getResponseTime() != null) {
            SET("RESPONSE_TIME = #{responseTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getAccountType() != null) {
            SET("ACCOUNT_TYPE = #{accountType,jdbcType=DECIMAL}");
        }
        
        WHERE("ID = #{id,jdbcType=DECIMAL}");
        
        return SQL();
    }

    /**
     * This method corresponds to the database table TB_MARGIN_ACCOUNT_REQ
     *
     * @mbggenerated Fri May 29 18:06:19 CST 2015
     */
    protected void applyWhere(MarginAccountRequestDOExample example, boolean includeExamplePhrase) {
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
        
        if (example.getStatus() != null && !example.getStatus().equals("") ) {
            sb.append(" and  STATUS = #{status,jdbcType=VARCHAR} ");
        }
        
        if (example.getSourceId() != null && !example.getSourceId().equals("") ) {
            sb.append(" and  SOURCE_ID = #{sourceId,jdbcType=VARCHAR} ");
        }
        
        if (example.getMerchantNo() != null && !example.getMerchantNo().equals("") ) {
            sb.append(" and  MERCHANT_NO = #{merchantNo,jdbcType=VARCHAR} ");
        }
        
        if (example.getMemberId() != null && !example.getMemberId().equals("") ) {
            sb.append(" and  MEMBER_ID = #{memberId,jdbcType=VARCHAR} ");
        }
        
        if (example.getAccountId() != null && !example.getAccountId().equals("") ) {
            sb.append(" and  ACCOUNT_ID = #{accountId,jdbcType=VARCHAR} ");
        }
        
        if (example.getRequestNo() != null && !example.getRequestNo().equals("") ) {
            sb.append(" and  REQUEST_NO = #{requestNo,jdbcType=VARCHAR} ");
        }
        
        if (example.getAppIp() != null && !example.getAppIp().equals("") ) {
            sb.append(" and  APP_IP = #{appIp,jdbcType=VARCHAR} ");
        }
        
        if (example.getRequestOperator() != null && !example.getRequestOperator().equals("") ) {
            sb.append(" and  REQUEST_OPERATOR = #{requestOperator,jdbcType=VARCHAR} ");
        }
        
        if (example.getUserIp() != null && !example.getUserIp().equals("") ) {
            sb.append(" and  USER_IP = #{userIp,jdbcType=VARCHAR} ");
        }
        
        if (example.getResponseCode() != null && !example.getResponseCode().equals("") ) {
            sb.append(" and  RESPONSE_CODE = #{responseCode,jdbcType=VARCHAR} ");
        }
        
        if (example.getResponseMessage() != null && !example.getResponseMessage().equals("") ) {
            sb.append(" and  RESPONSE_MESSAGE = #{responseMessage,jdbcType=VARCHAR} ");
        }
        
        if (example.getRequestTime() != null) {
            sb.append(" and  REQUEST_TIME = #{requestTime,jdbcType=TIMESTAMP} ");
        }
        
        if (example.getResponseTime() != null) {
            sb.append(" and  RESPONSE_TIME = #{responseTime,jdbcType=TIMESTAMP} ");
        }
        
        if (example.getAccountType() != null) {
            sb.append(" and  ACCOUNT_TYPE = #{accountType,jdbcType=DECIMAL} ");
        }
        WHERE(sb.toString());
    }
}