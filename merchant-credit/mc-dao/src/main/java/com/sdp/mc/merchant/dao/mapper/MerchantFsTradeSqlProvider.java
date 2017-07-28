package com.sdp.mc.merchant.dao.mapper;

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

import com.sdp.mc.merchant.dao.MerchantFsTradeDO;
import com.sdp.mc.merchant.dao.MerchantFsTradeDOExample.Criteria;
import com.sdp.mc.merchant.dao.MerchantFsTradeDOExample.Criterion;
import com.sdp.mc.merchant.dao.MerchantFsTradeDOExample;
import java.util.List;
import java.util.Map;

public class MerchantFsTradeSqlProvider {

    /**
     * 根据Example对象取得null【MerchantFsTradeDO】对象count信息
     *
     * @mbggenerated Tue Dec 29 15:50:27 CST 2015
     */
    public String countByExample(MerchantFsTradeDOExample example) {
        BEGIN();
        SELECT("count(*)");
        FROM("TB_MARCHAT_FS_TRADE");
        applyWhere(example, false);
        return SQL();
    }

    /**
     * 根据Example对象删除null【MerchantFsTradeDO】对象信息
     *
     * @mbggenerated Tue Dec 29 15:50:27 CST 2015
     */
    public String deleteByExample(MerchantFsTradeDOExample example) {
        BEGIN();
        DELETE_FROM("TB_MARCHAT_FS_TRADE");
        applyWhere(example, false);
        return SQL();
    }

    /**
     * 添加null【MerchantFsTradeDO】对象信息,空值字段不插入
     *
     * @mbggenerated Tue Dec 29 15:50:27 CST 2015
     */
    public String insertSelective(MerchantFsTradeDO record) {
        BEGIN();
        INSERT_INTO("TB_MARCHAT_FS_TRADE");
        
        VALUES("MFT_ID", "#{mftId,jdbcType=DECIMAL}");
        
        if (record.getMfqId() != null) {
            VALUES("MFQ_ID", "#{mfqId,jdbcType=DECIMAL}");
        }
        
        if (record.getOrderNo() != null) {
            VALUES("ORDER_NO", "#{orderNo,jdbcType=VARCHAR}");
        }
        
        if (record.getTradeTime() != null) {
            VALUES("TRADE_TIME", "#{tradeTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getTxnNo() != null) {
            VALUES("TXN_NO", "#{txnNo,jdbcType=VARCHAR}");
        }
        
        if (record.getTradeType() != null) {
            VALUES("TRADE_TYPE", "#{tradeType,jdbcType=VARCHAR}");
        }
        
        if (record.getTradeStatus() != null) {
            VALUES("TRADE_STATUS", "#{tradeStatus,jdbcType=VARCHAR}");
        }
        
        if (record.getTradeAmount() != null) {
            VALUES("TRADE_AMOUNT", "#{tradeAmount,jdbcType=DECIMAL}");
        }
        
        if (record.getTradeFee() != null) {
            VALUES("TRADE_FEE", "#{tradeFee,jdbcType=DECIMAL}");
        }
        
        if (record.getSettleAmount() != null) {
            VALUES("SETTLE_AMOUNT", "#{settleAmount,jdbcType=DECIMAL}");
        }
        
        if (record.getCardType() != null) {
            VALUES("CARD_TYPE", "#{cardType,jdbcType=VARCHAR}");
        }
        
        if (record.getShortPan() != null) {
            VALUES("SHORT_PAN", "#{shortPan,jdbcType=VARCHAR}");
        }
        
        if (record.getIssuerId() != null) {
            VALUES("ISSUER_ID", "#{issuerId,jdbcType=VARCHAR}");
        }
        
        if (record.getTerminalNo() != null) {
            VALUES("TERMINAL_NO", "#{terminalNo,jdbcType=VARCHAR}");
        }
        
        if (record.getCreateTime() != null) {
            VALUES("CREATE_TIME", "#{createTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getUpdateTime() != null) {
            VALUES("UPDATE_TIME", "#{updateTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getTxnStatus() != null) {
            VALUES("TXN_STATUS", "#{txnStatus,jdbcType=VARCHAR}");
        }
        
        if (record.getTxnType() != null) {
            VALUES("TXN_TYPE", "#{txnType,jdbcType=VARCHAR}");
        }
        
        if (record.getTxnCardType() != null) {
            VALUES("TXN_CARD_TYPE", "#{txnCardType,jdbcType=VARCHAR}");
        }
        
        if (record.getTxnIssuerId() != null) {
            VALUES("TXN_ISSUER_ID", "#{txnIssuerId,jdbcType=VARCHAR}");
        }
        
        if (record.getTxnShortPan() != null) {
            VALUES("TXN_SHORT_PAN", "#{txnShortPan,jdbcType=VARCHAR}");
        }
        
        return SQL();
    }

    /**
     * 根据Example对象查询得到null【MerchantFsTradeDO】对象列表信息
     *
     * @mbggenerated Tue Dec 29 15:50:27 CST 2015
     */
    public String selectByExample(MerchantFsTradeDOExample example) {
        BEGIN();
        if (example != null && example.isDistinct()) {
            SELECT_DISTINCT("MFT_ID");
        } else {
            SELECT("MFT_ID");
        }
        SELECT("MFQ_ID");
        SELECT("ORDER_NO");
        SELECT("TRADE_TIME");
        SELECT("TXN_NO");
        SELECT("TRADE_TYPE");
        SELECT("TRADE_STATUS");
        SELECT("TRADE_AMOUNT");
        SELECT("TRADE_FEE");
        SELECT("SETTLE_AMOUNT");
        SELECT("CARD_TYPE");
        SELECT("SHORT_PAN");
        SELECT("ISSUER_ID");
        SELECT("TERMINAL_NO");
        SELECT("CREATE_TIME");
        SELECT("UPDATE_TIME");
        SELECT("TXN_STATUS");
        SELECT("TXN_TYPE");
        SELECT("TXN_CARD_TYPE");
        SELECT("TXN_ISSUER_ID");
        SELECT("TXN_SHORT_PAN");
        FROM("TB_MARCHAT_FS_TRADE");
        applyWhere(example, false);
        
        if (example != null && example.getOrderByClause() != null) {
            ORDER_BY(example.getOrderByClause());
        }
        
        return SQL();
    }

    /**
     * 根据Query对象分页查询null【MerchantFsTradeDO】对象列表信息
     *
     * @mbggenerated Tue Dec 29 15:50:27 CST 2015
     */
    public String selectByQuery(MerchantFsTradeDOExample example) {
        BEGIN();
        if (example != null && example.isDistinct()) {
            SELECT_DISTINCT("MFT_ID");
        } else {
            SELECT("MFT_ID");
        }
        SELECT("MFQ_ID");
        SELECT("ORDER_NO");
        SELECT("TRADE_TIME");
        SELECT("TXN_NO");
        SELECT("TRADE_TYPE");
        SELECT("TRADE_STATUS");
        SELECT("TRADE_AMOUNT");
        SELECT("TRADE_FEE");
        SELECT("SETTLE_AMOUNT");
        SELECT("CARD_TYPE");
        SELECT("SHORT_PAN");
        SELECT("ISSUER_ID");
        SELECT("TERMINAL_NO");
        SELECT("CREATE_TIME");
        SELECT("UPDATE_TIME");
        SELECT("TXN_STATUS");
        SELECT("TXN_TYPE");
        SELECT("TXN_CARD_TYPE");
        SELECT("TXN_ISSUER_ID");
        SELECT("TXN_SHORT_PAN");
        FROM("TB_MARCHAT_FS_TRADE");
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
     * 根据Example对象更新null【MerchantFsTradeDO】对象信息，仅更新非空字段
     *
     * @mbggenerated Tue Dec 29 15:50:27 CST 2015
     */
    public String updateByExampleSelective(Map<String, Object> parameter) {
        MerchantFsTradeDO record = (MerchantFsTradeDO) parameter.get("record");
        MerchantFsTradeDOExample example = (MerchantFsTradeDOExample) parameter.get("example");
        
        BEGIN();
        UPDATE("TB_MARCHAT_FS_TRADE");
        
        if (record.getMftId() != null) {
            SET("MFT_ID = #{record.mftId,jdbcType=DECIMAL}");
        }
        
        if (record.getMfqId() != null) {
            SET("MFQ_ID = #{record.mfqId,jdbcType=DECIMAL}");
        }
        
        if (record.getOrderNo() != null) {
            SET("ORDER_NO = #{record.orderNo,jdbcType=VARCHAR}");
        }
        
        if (record.getTradeTime() != null) {
            SET("TRADE_TIME = #{record.tradeTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getTxnNo() != null) {
            SET("TXN_NO = #{record.txnNo,jdbcType=VARCHAR}");
        }
        
        if (record.getTradeType() != null) {
            SET("TRADE_TYPE = #{record.tradeType,jdbcType=VARCHAR}");
        }
        
        if (record.getTradeStatus() != null) {
            SET("TRADE_STATUS = #{record.tradeStatus,jdbcType=VARCHAR}");
        }
        
        if (record.getTradeAmount() != null) {
            SET("TRADE_AMOUNT = #{record.tradeAmount,jdbcType=DECIMAL}");
        }
        
        if (record.getTradeFee() != null) {
            SET("TRADE_FEE = #{record.tradeFee,jdbcType=DECIMAL}");
        }
        
        if (record.getSettleAmount() != null) {
            SET("SETTLE_AMOUNT = #{record.settleAmount,jdbcType=DECIMAL}");
        }
        
        if (record.getCardType() != null) {
            SET("CARD_TYPE = #{record.cardType,jdbcType=VARCHAR}");
        }
        
        if (record.getShortPan() != null) {
            SET("SHORT_PAN = #{record.shortPan,jdbcType=VARCHAR}");
        }
        
        if (record.getIssuerId() != null) {
            SET("ISSUER_ID = #{record.issuerId,jdbcType=VARCHAR}");
        }
        
        if (record.getTerminalNo() != null) {
            SET("TERMINAL_NO = #{record.terminalNo,jdbcType=VARCHAR}");
        }
        
        if (record.getCreateTime() != null) {
            SET("CREATE_TIME = #{record.createTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getUpdateTime() != null) {
            SET("UPDATE_TIME = #{record.updateTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getTxnStatus() != null) {
            SET("TXN_STATUS = #{record.txnStatus,jdbcType=VARCHAR}");
        }
        
        if (record.getTxnType() != null) {
            SET("TXN_TYPE = #{record.txnType,jdbcType=VARCHAR}");
        }
        
        if (record.getTxnCardType() != null) {
            SET("TXN_CARD_TYPE = #{record.txnCardType,jdbcType=VARCHAR}");
        }
        
        if (record.getTxnIssuerId() != null) {
            SET("TXN_ISSUER_ID = #{record.txnIssuerId,jdbcType=VARCHAR}");
        }
        
        if (record.getTxnShortPan() != null) {
            SET("TXN_SHORT_PAN = #{record.txnShortPan,jdbcType=VARCHAR}");
        }
        
        applyWhere(example, true);
        return SQL();
    }

    /**
     * 根据Example对象更新null【MerchantFsTradeDO】对象信息
     *
     * @mbggenerated Tue Dec 29 15:50:27 CST 2015
     */
    public String updateByExample(Map<String, Object> parameter) {
        BEGIN();
        UPDATE("TB_MARCHAT_FS_TRADE");
        
        SET("MFT_ID = #{record.mftId,jdbcType=DECIMAL}");
        SET("MFQ_ID = #{record.mfqId,jdbcType=DECIMAL}");
        SET("ORDER_NO = #{record.orderNo,jdbcType=VARCHAR}");
        SET("TRADE_TIME = #{record.tradeTime,jdbcType=TIMESTAMP}");
        SET("TXN_NO = #{record.txnNo,jdbcType=VARCHAR}");
        SET("TRADE_TYPE = #{record.tradeType,jdbcType=VARCHAR}");
        SET("TRADE_STATUS = #{record.tradeStatus,jdbcType=VARCHAR}");
        SET("TRADE_AMOUNT = #{record.tradeAmount,jdbcType=DECIMAL}");
        SET("TRADE_FEE = #{record.tradeFee,jdbcType=DECIMAL}");
        SET("SETTLE_AMOUNT = #{record.settleAmount,jdbcType=DECIMAL}");
        SET("CARD_TYPE = #{record.cardType,jdbcType=VARCHAR}");
        SET("SHORT_PAN = #{record.shortPan,jdbcType=VARCHAR}");
        SET("ISSUER_ID = #{record.issuerId,jdbcType=VARCHAR}");
        SET("TERMINAL_NO = #{record.terminalNo,jdbcType=VARCHAR}");
        SET("CREATE_TIME = #{record.createTime,jdbcType=TIMESTAMP}");
        SET("UPDATE_TIME = #{record.updateTime,jdbcType=TIMESTAMP}");
        SET("TXN_STATUS = #{record.txnStatus,jdbcType=VARCHAR}");
        SET("TXN_TYPE = #{record.txnType,jdbcType=VARCHAR}");
        SET("TXN_CARD_TYPE = #{record.txnCardType,jdbcType=VARCHAR}");
        SET("TXN_ISSUER_ID = #{record.txnIssuerId,jdbcType=VARCHAR}");
        SET("TXN_SHORT_PAN = #{record.txnShortPan,jdbcType=VARCHAR}");
        
        MerchantFsTradeDOExample example = (MerchantFsTradeDOExample) parameter.get("example");
        applyWhere(example, true);
        return SQL();
    }

    /**
     * 根据主键更新null【MerchantFsTradeDO】对象信息，仅更新非空对象
     *
     * @mbggenerated Tue Dec 29 15:50:27 CST 2015
     */
    public String updateByPrimaryKeySelective(MerchantFsTradeDO record) {
        BEGIN();
        UPDATE("TB_MARCHAT_FS_TRADE");
        
        if (record.getMfqId() != null) {
            SET("MFQ_ID = #{mfqId,jdbcType=DECIMAL}");
        }
        
        if (record.getOrderNo() != null) {
            SET("ORDER_NO = #{orderNo,jdbcType=VARCHAR}");
        }
        
        if (record.getTradeTime() != null) {
            SET("TRADE_TIME = #{tradeTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getTxnNo() != null) {
            SET("TXN_NO = #{txnNo,jdbcType=VARCHAR}");
        }
        
        if (record.getTradeType() != null) {
            SET("TRADE_TYPE = #{tradeType,jdbcType=VARCHAR}");
        }
        
        if (record.getTradeStatus() != null) {
            SET("TRADE_STATUS = #{tradeStatus,jdbcType=VARCHAR}");
        }
        
        if (record.getTradeAmount() != null) {
            SET("TRADE_AMOUNT = #{tradeAmount,jdbcType=DECIMAL}");
        }
        
        if (record.getTradeFee() != null) {
            SET("TRADE_FEE = #{tradeFee,jdbcType=DECIMAL}");
        }
        
        if (record.getSettleAmount() != null) {
            SET("SETTLE_AMOUNT = #{settleAmount,jdbcType=DECIMAL}");
        }
        
        if (record.getCardType() != null) {
            SET("CARD_TYPE = #{cardType,jdbcType=VARCHAR}");
        }
        
        if (record.getShortPan() != null) {
            SET("SHORT_PAN = #{shortPan,jdbcType=VARCHAR}");
        }
        
        if (record.getIssuerId() != null) {
            SET("ISSUER_ID = #{issuerId,jdbcType=VARCHAR}");
        }
        
        if (record.getTerminalNo() != null) {
            SET("TERMINAL_NO = #{terminalNo,jdbcType=VARCHAR}");
        }
        
        if (record.getCreateTime() != null) {
            SET("CREATE_TIME = #{createTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getUpdateTime() != null) {
            SET("UPDATE_TIME = #{updateTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getTxnStatus() != null) {
            SET("TXN_STATUS = #{txnStatus,jdbcType=VARCHAR}");
        }
        
        if (record.getTxnType() != null) {
            SET("TXN_TYPE = #{txnType,jdbcType=VARCHAR}");
        }
        
        if (record.getTxnCardType() != null) {
            SET("TXN_CARD_TYPE = #{txnCardType,jdbcType=VARCHAR}");
        }
        
        if (record.getTxnIssuerId() != null) {
            SET("TXN_ISSUER_ID = #{txnIssuerId,jdbcType=VARCHAR}");
        }
        
        if (record.getTxnShortPan() != null) {
            SET("TXN_SHORT_PAN = #{txnShortPan,jdbcType=VARCHAR}");
        }
        
        WHERE("MFT_ID = #{mftId,jdbcType=DECIMAL}");
        
        return SQL();
    }

    /**
     * This method corresponds to the database table TB_MARCHAT_FS_TRADE
     *
     * @mbggenerated Tue Dec 29 15:50:27 CST 2015
     */
    protected void applyWhere(MerchantFsTradeDOExample example, boolean includeExamplePhrase) {
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
        
        if (example.getMftId() != null) {
            sb.append(" and  MFT_ID = #{mftId,jdbcType=DECIMAL} ");
        }
        
        if (example.getMfqId() != null) {
            sb.append(" and  MFQ_ID = #{mfqId,jdbcType=DECIMAL} ");
        }
        
        if (example.getOrderNo() != null && !example.getOrderNo().equals("") ) {
            sb.append(" and  ORDER_NO = #{orderNo,jdbcType=VARCHAR} ");
        }
        
        if (example.getTradeTime() != null) {
            sb.append(" and  TRADE_TIME = #{tradeTime,jdbcType=TIMESTAMP} ");
        }
        
        if (example.getTxnNo() != null && !example.getTxnNo().equals("") ) {
            sb.append(" and  TXN_NO = #{txnNo,jdbcType=VARCHAR} ");
        }
        
        if (example.getTradeType() != null && !example.getTradeType().equals("") ) {
            sb.append(" and  TRADE_TYPE = #{tradeType,jdbcType=VARCHAR} ");
        }
        
        if (example.getTradeStatus() != null && !example.getTradeStatus().equals("") ) {
            sb.append(" and  TRADE_STATUS = #{tradeStatus,jdbcType=VARCHAR} ");
        }
        
        if (example.getTradeAmount() != null) {
            sb.append(" and  TRADE_AMOUNT = #{tradeAmount,jdbcType=DECIMAL} ");
        }
        
        if (example.getTradeFee() != null) {
            sb.append(" and  TRADE_FEE = #{tradeFee,jdbcType=DECIMAL} ");
        }
        
        if (example.getSettleAmount() != null) {
            sb.append(" and  SETTLE_AMOUNT = #{settleAmount,jdbcType=DECIMAL} ");
        }
        
        if (example.getCardType() != null && !example.getCardType().equals("") ) {
            sb.append(" and  CARD_TYPE = #{cardType,jdbcType=VARCHAR} ");
        }
        
        if (example.getShortPan() != null && !example.getShortPan().equals("") ) {
            sb.append(" and  SHORT_PAN = #{shortPan,jdbcType=VARCHAR} ");
        }
        
        if (example.getIssuerId() != null && !example.getIssuerId().equals("") ) {
            sb.append(" and  ISSUER_ID = #{issuerId,jdbcType=VARCHAR} ");
        }
        
        if (example.getTerminalNo() != null && !example.getTerminalNo().equals("") ) {
            sb.append(" and  TERMINAL_NO = #{terminalNo,jdbcType=VARCHAR} ");
        }
        
        if (example.getCreateTime() != null) {
            sb.append(" and  CREATE_TIME = #{createTime,jdbcType=TIMESTAMP} ");
        }
        
        if (example.getUpdateTime() != null) {
            sb.append(" and  UPDATE_TIME = #{updateTime,jdbcType=TIMESTAMP} ");
        }
        
        if (example.getTxnStatus() != null && !example.getTxnStatus().equals("") ) {
            sb.append(" and  TXN_STATUS = #{txnStatus,jdbcType=VARCHAR} ");
        }
        
        if (example.getTxnType() != null && !example.getTxnType().equals("") ) {
            sb.append(" and  TXN_TYPE = #{txnType,jdbcType=VARCHAR} ");
        }
        
        if (example.getTxnCardType() != null && !example.getTxnCardType().equals("") ) {
            sb.append(" and  TXN_CARD_TYPE = #{txnCardType,jdbcType=VARCHAR} ");
        }
        
        if (example.getTxnIssuerId() != null && !example.getTxnIssuerId().equals("") ) {
            sb.append(" and  TXN_ISSUER_ID = #{txnIssuerId,jdbcType=VARCHAR} ");
        }
        
        if (example.getTxnShortPan() != null && !example.getTxnShortPan().equals("") ) {
            sb.append(" and  TXN_SHORT_PAN = #{txnShortPan,jdbcType=VARCHAR} ");
        }
        WHERE(sb.toString());
    }
}