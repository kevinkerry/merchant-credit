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

import com.sdp.withdraw.dao.WalletWithdrawReqDO;
import com.sdp.withdraw.dao.WalletWithdrawReqDOExample.Criteria;
import com.sdp.withdraw.dao.WalletWithdrawReqDOExample.Criterion;
import com.sdp.withdraw.dao.WalletWithdrawReqDOExample;
import java.util.List;
import java.util.Map;

public class WalletWithdrawReqSqlProvider {

    /**
     * 根据Example对象取得钱包出款请求表【WalletWithdrawReqDO】对象count信息
     *
     * @mbggenerated Wed Nov 23 10:26:15 CST 2016
     */
    public String countByExample(WalletWithdrawReqDOExample example) {
        BEGIN();
        SELECT("count(*)");
        FROM("FW_WALLET_WITHDRAW_REQ");
        applyWhere(example, false);
        return SQL();
    }

    /**
     * 根据Example对象删除钱包出款请求表【WalletWithdrawReqDO】对象信息
     *
     * @mbggenerated Wed Nov 23 10:26:15 CST 2016
     */
    public String deleteByExample(WalletWithdrawReqDOExample example) {
        BEGIN();
        DELETE_FROM("FW_WALLET_WITHDRAW_REQ");
        applyWhere(example, false);
        return SQL();
    }

    /**
     * 添加钱包出款请求表【WalletWithdrawReqDO】对象信息,空值字段不插入
     *
     * @mbggenerated Wed Nov 23 10:26:15 CST 2016
     */
    public String insertSelective(WalletWithdrawReqDO record) {
        BEGIN();
        INSERT_INTO("FW_WALLET_WITHDRAW_REQ");
        
        VALUES("REQ_ID", "#{reqId,jdbcType=DECIMAL}");
        
        if (record.getAppId() != null) {
            VALUES("APP_ID", "#{appId,jdbcType=VARCHAR}");
        }
        
        if (record.getOrderNo() != null) {
            VALUES("ORDER_NO", "#{orderNo,jdbcType=VARCHAR}");
        }
        
        if (record.getMemberId() != null) {
            VALUES("MEMBER_ID", "#{memberId,jdbcType=VARCHAR}");
        }
        
        if (record.getMemberNo() != null) {
            VALUES("MEMBER_NO", "#{memberNo,jdbcType=VARCHAR}");
        }
        
        if (record.getMemberType() != null) {
            VALUES("MEMBER_TYPE", "#{memberType,jdbcType=VARCHAR}");
        }
        
        if (record.getWithdrawAmount() != null) {
            VALUES("WITHDRAW_AMOUNT", "#{withdrawAmount,jdbcType=DECIMAL}");
        }
        
        if (record.getOriginalAmount() != null) {
            VALUES("ORIGINAL_AMOUNT", "#{originalAmount,jdbcType=DECIMAL}");
        }
        
        if (record.getTraceNo() != null) {
            VALUES("TRACE_NO", "#{traceNo,jdbcType=DECIMAL}");
        }
        
        if (record.getExtention() != null) {
            VALUES("EXTENTION", "#{extention,jdbcType=VARCHAR}");
        }
        
        if (record.getStatus() != null) {
            VALUES("STATUS", "#{status,jdbcType=DECIMAL}");
        }
        
        if (record.getCallbackAddress() != null) {
            VALUES("CALLBACK_ADDRESS", "#{callbackAddress,jdbcType=VARCHAR}");
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
     * 根据Example对象查询得到钱包出款请求表【WalletWithdrawReqDO】对象列表信息
     *
     * @mbggenerated Wed Nov 23 10:26:15 CST 2016
     */
    public String selectByExample(WalletWithdrawReqDOExample example) {
        BEGIN();
        if (example != null && example.isDistinct()) {
            SELECT_DISTINCT("REQ_ID");
        } else {
            SELECT("REQ_ID");
        }
        SELECT("APP_ID");
        SELECT("ORDER_NO");
        SELECT("MEMBER_ID");
        SELECT("MEMBER_NO");
        SELECT("MEMBER_TYPE");
        SELECT("WITHDRAW_AMOUNT");
        SELECT("ORIGINAL_AMOUNT");
        SELECT("TRACE_NO");
        SELECT("EXTENTION");
        SELECT("STATUS");
        SELECT("CALLBACK_ADDRESS");
        SELECT("CREATE_TIME");
        SELECT("UPDATE_TIME");
        FROM("FW_WALLET_WITHDRAW_REQ");
        applyWhere(example, false);
        
        if (example != null && example.getOrderByClause() != null) {
            ORDER_BY(example.getOrderByClause());
        }
        
        return SQL();
    }

    /**
     * 根据Query对象分页查询钱包出款请求表【WalletWithdrawReqDO】对象列表信息
     *
     * @mbggenerated Wed Nov 23 10:26:15 CST 2016
     */
    public String selectByQuery(WalletWithdrawReqDOExample example) {
        BEGIN();
        if (example != null && example.isDistinct()) {
            SELECT_DISTINCT("REQ_ID");
        } else {
            SELECT("REQ_ID");
        }
        SELECT("APP_ID");
        SELECT("ORDER_NO");
        SELECT("MEMBER_ID");
        SELECT("MEMBER_NO");
        SELECT("MEMBER_TYPE");
        SELECT("WITHDRAW_AMOUNT");
        SELECT("ORIGINAL_AMOUNT");
        SELECT("TRACE_NO");
        SELECT("EXTENTION");
        SELECT("STATUS");
        SELECT("CALLBACK_ADDRESS");
        SELECT("CREATE_TIME");
        SELECT("UPDATE_TIME");
        FROM("FW_WALLET_WITHDRAW_REQ");
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
     * 根据Example对象更新钱包出款请求表【WalletWithdrawReqDO】对象信息，仅更新非空字段
     *
     * @mbggenerated Wed Nov 23 10:26:15 CST 2016
     */
    public String updateByExampleSelective(Map<String, Object> parameter) {
        WalletWithdrawReqDO record = (WalletWithdrawReqDO) parameter.get("record");
        WalletWithdrawReqDOExample example = (WalletWithdrawReqDOExample) parameter.get("example");
        
        BEGIN();
        UPDATE("FW_WALLET_WITHDRAW_REQ");
        
        if (record.getReqId() != null) {
            SET("REQ_ID = #{record.reqId,jdbcType=DECIMAL}");
        }
        
        if (record.getAppId() != null) {
            SET("APP_ID = #{record.appId,jdbcType=VARCHAR}");
        }
        
        if (record.getOrderNo() != null) {
            SET("ORDER_NO = #{record.orderNo,jdbcType=VARCHAR}");
        }
        
        if (record.getMemberId() != null) {
            SET("MEMBER_ID = #{record.memberId,jdbcType=VARCHAR}");
        }
        
        if (record.getMemberNo() != null) {
            SET("MEMBER_NO = #{record.memberNo,jdbcType=VARCHAR}");
        }
        
        if (record.getMemberType() != null) {
            SET("MEMBER_TYPE = #{record.memberType,jdbcType=VARCHAR}");
        }
        
        if (record.getWithdrawAmount() != null) {
            SET("WITHDRAW_AMOUNT = #{record.withdrawAmount,jdbcType=DECIMAL}");
        }
        
        if (record.getOriginalAmount() != null) {
            SET("ORIGINAL_AMOUNT = #{record.originalAmount,jdbcType=DECIMAL}");
        }
        
        if (record.getTraceNo() != null) {
            SET("TRACE_NO = #{record.traceNo,jdbcType=DECIMAL}");
        }
        
        if (record.getExtention() != null) {
            SET("EXTENTION = #{record.extention,jdbcType=VARCHAR}");
        }
        
        if (record.getStatus() != null) {
            SET("STATUS = #{record.status,jdbcType=DECIMAL}");
        }
        
        if (record.getCallbackAddress() != null) {
            SET("CALLBACK_ADDRESS = #{record.callbackAddress,jdbcType=VARCHAR}");
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
     * 根据Example对象更新钱包出款请求表【WalletWithdrawReqDO】对象信息
     *
     * @mbggenerated Wed Nov 23 10:26:15 CST 2016
     */
    public String updateByExample(Map<String, Object> parameter) {
        BEGIN();
        UPDATE("FW_WALLET_WITHDRAW_REQ");
        
        SET("REQ_ID = #{record.reqId,jdbcType=DECIMAL}");
        SET("APP_ID = #{record.appId,jdbcType=VARCHAR}");
        SET("ORDER_NO = #{record.orderNo,jdbcType=VARCHAR}");
        SET("MEMBER_ID = #{record.memberId,jdbcType=VARCHAR}");
        SET("MEMBER_NO = #{record.memberNo,jdbcType=VARCHAR}");
        SET("MEMBER_TYPE = #{record.memberType,jdbcType=VARCHAR}");
        SET("WITHDRAW_AMOUNT = #{record.withdrawAmount,jdbcType=DECIMAL}");
        SET("ORIGINAL_AMOUNT = #{record.originalAmount,jdbcType=DECIMAL}");
        SET("TRACE_NO = #{record.traceNo,jdbcType=DECIMAL}");
        SET("EXTENTION = #{record.extention,jdbcType=VARCHAR}");
        SET("STATUS = #{record.status,jdbcType=DECIMAL}");
        SET("CALLBACK_ADDRESS = #{record.callbackAddress,jdbcType=VARCHAR}");
        SET("CREATE_TIME = #{record.createTime,jdbcType=TIMESTAMP}");
        SET("UPDATE_TIME = #{record.updateTime,jdbcType=TIMESTAMP}");
        
        WalletWithdrawReqDOExample example = (WalletWithdrawReqDOExample) parameter.get("example");
        applyWhere(example, true);
        return SQL();
    }

    /**
     * 根据主键更新钱包出款请求表【WalletWithdrawReqDO】对象信息，仅更新非空对象
     *
     * @mbggenerated Wed Nov 23 10:26:15 CST 2016
     */
    public String updateByPrimaryKeySelective(WalletWithdrawReqDO record) {
        BEGIN();
        UPDATE("FW_WALLET_WITHDRAW_REQ");
        
        if (record.getAppId() != null) {
            SET("APP_ID = #{appId,jdbcType=VARCHAR}");
        }
        
        if (record.getOrderNo() != null) {
            SET("ORDER_NO = #{orderNo,jdbcType=VARCHAR}");
        }
        
        if (record.getMemberId() != null) {
            SET("MEMBER_ID = #{memberId,jdbcType=VARCHAR}");
        }
        
        if (record.getMemberNo() != null) {
            SET("MEMBER_NO = #{memberNo,jdbcType=VARCHAR}");
        }
        
        if (record.getMemberType() != null) {
            SET("MEMBER_TYPE = #{memberType,jdbcType=VARCHAR}");
        }
        
        if (record.getWithdrawAmount() != null) {
            SET("WITHDRAW_AMOUNT = #{withdrawAmount,jdbcType=DECIMAL}");
        }
        
        if (record.getOriginalAmount() != null) {
            SET("ORIGINAL_AMOUNT = #{originalAmount,jdbcType=DECIMAL}");
        }
        
        if (record.getTraceNo() != null) {
            SET("TRACE_NO = #{traceNo,jdbcType=DECIMAL}");
        }
        
        if (record.getExtention() != null) {
            SET("EXTENTION = #{extention,jdbcType=VARCHAR}");
        }
        
        if (record.getStatus() != null) {
            SET("STATUS = #{status,jdbcType=DECIMAL}");
        }
        
        if (record.getCallbackAddress() != null) {
            SET("CALLBACK_ADDRESS = #{callbackAddress,jdbcType=VARCHAR}");
        }
        
        if (record.getCreateTime() != null) {
            SET("CREATE_TIME = #{createTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getUpdateTime() != null) {
            SET("UPDATE_TIME = #{updateTime,jdbcType=TIMESTAMP}");
        }
        
        WHERE("REQ_ID = #{reqId,jdbcType=DECIMAL}");
        
        return SQL();
    }

    /**
     * This method corresponds to the database table FW_WALLET_WITHDRAW_REQ
     *
     * @mbggenerated Wed Nov 23 10:26:15 CST 2016
     */
    protected void applyWhere(WalletWithdrawReqDOExample example, boolean includeExamplePhrase) {
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
        
        if (example.getReqId() != null) {
            sb.append(" and  REQ_ID = #{reqId,jdbcType=DECIMAL} ");
        }
        
        if (example.getAppId() != null && !example.getAppId().equals("") ) {
            sb.append(" and  APP_ID = #{appId,jdbcType=VARCHAR} ");
        }
        
        if (example.getOrderNo() != null && !example.getOrderNo().equals("") ) {
            sb.append(" and  ORDER_NO = #{orderNo,jdbcType=VARCHAR} ");
        }
        
        if (example.getMemberId() != null && !example.getMemberId().equals("") ) {
            sb.append(" and  MEMBER_ID = #{memberId,jdbcType=VARCHAR} ");
        }
        
        if (example.getMemberNo() != null && !example.getMemberNo().equals("") ) {
            sb.append(" and  MEMBER_NO = #{memberNo,jdbcType=VARCHAR} ");
        }
        
        if (example.getMemberType() != null && !example.getMemberType().equals("") ) {
            sb.append(" and  MEMBER_TYPE = #{memberType,jdbcType=VARCHAR} ");
        }
        
        if (example.getWithdrawAmount() != null) {
            sb.append(" and  WITHDRAW_AMOUNT = #{withdrawAmount,jdbcType=DECIMAL} ");
        }
        
        if (example.getOriginalAmount() != null) {
            sb.append(" and  ORIGINAL_AMOUNT = #{originalAmount,jdbcType=DECIMAL} ");
        }
        
        if (example.getTraceNo() != null) {
            sb.append(" and  TRACE_NO = #{traceNo,jdbcType=DECIMAL} ");
        }
        
        if (example.getExtention() != null && !example.getExtention().equals("") ) {
            sb.append(" and  EXTENTION = #{extention,jdbcType=VARCHAR} ");
        }
        
        if (example.getStatus() != null) {
            sb.append(" and  STATUS = #{status,jdbcType=DECIMAL} ");
        }
        
        if (example.getCallbackAddress() != null && !example.getCallbackAddress().equals("") ) {
            sb.append(" and  CALLBACK_ADDRESS = #{callbackAddress,jdbcType=VARCHAR} ");
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