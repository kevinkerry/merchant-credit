package com.sdp.mc.fos.dao.mapper;

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

import com.sdp.mc.fos.dao.MarginTransDO;
import com.sdp.mc.fos.dao.MarginTransDOExample.Criteria;
import com.sdp.mc.fos.dao.MarginTransDOExample.Criterion;
import com.sdp.mc.fos.dao.MarginTransDOExample;
import java.util.List;
import java.util.Map;

public class MarginTransSqlProvider {

    /**
     * 根据Example对象取得保证金转账记录【MarginTransDO】对象count信息
     *
     * @mbggenerated Wed Jun 03 18:04:23 CST 2015
     */
    public String countByExample(MarginTransDOExample example) {
        BEGIN();
        SELECT("count(*)");
        FROM("TB_MARGIN_TRANS");
        applyWhere(example, false);
        return SQL();
    }

    /**
     * 根据Example对象删除保证金转账记录【MarginTransDO】对象信息
     *
     * @mbggenerated Wed Jun 03 18:04:23 CST 2015
     */
    public String deleteByExample(MarginTransDOExample example) {
        BEGIN();
        DELETE_FROM("TB_MARGIN_TRANS");
        applyWhere(example, false);
        return SQL();
    }

    /**
     * 添加保证金转账记录【MarginTransDO】对象信息,空值字段不插入
     *
     * @mbggenerated Wed Jun 03 18:04:23 CST 2015
     */
    public String insertSelective(MarginTransDO record) {
        BEGIN();
        INSERT_INTO("TB_MARGIN_TRANS");
        
        VALUES("MT_ID", "#{mtId,jdbcType=DECIMAL}");
        
        if (record.getStatus() != null) {
            VALUES("STATUS", "#{status,jdbcType=DECIMAL}");
        }
        
        if (record.getProductCode() != null) {
            VALUES("PRODUCT_CODE", "#{productCode,jdbcType=VARCHAR}");
        }
        
        if (record.getAppId() != null) {
            VALUES("APP_ID", "#{appId,jdbcType=VARCHAR}");
        }
        
        if (record.getPaymentCode() != null) {
            VALUES("PAYMENT_CODE", "#{paymentCode,jdbcType=VARCHAR}");
        }
        
        if (record.getRemitVoucherNo() != null) {
            VALUES("REMIT_VOUCHER_NO", "#{remitVoucherNo,jdbcType=VARCHAR}");
        }
        
        if (record.getPaymentState() != null) {
            VALUES("PAYMENT_STATE", "#{paymentState,jdbcType=VARCHAR}");
        }
        
        if (record.getPayerMemberId() != null) {
            VALUES("PAYER_MEMBER_ID", "#{payerMemberId,jdbcType=VARCHAR}");
        }
        
        if (record.getPayeeMemberId() != null) {
            VALUES("PAYEE_MEMBER_ID", "#{payeeMemberId,jdbcType=VARCHAR}");
        }
        
        if (record.getIsNeedCountFee() != null) {
            VALUES("IS_NEED_COUNT_FEE", "#{isNeedCountFee,jdbcType=VARCHAR}");
        }
        
        if (record.getPayerFee() != null) {
            VALUES("PAYER_FEE", "#{payerFee,jdbcType=VARCHAR}");
        }
        
        if (record.getPayeeFee() != null) {
            VALUES("PAYEE_FEE", "#{payeeFee,jdbcType=VARCHAR}");
        }
        
        if (record.getPayerAccountType() != null) {
            VALUES("PAYER_ACCOUNT_TYPE", "#{payerAccountType,jdbcType=VARCHAR}");
        }
        
        if (record.getPayerAccountNo() != null) {
            VALUES("PAYER_ACCOUNT_NO", "#{payerAccountNo,jdbcType=VARCHAR}");
        }
        
        if (record.getPayeeAccountNo() != null) {
            VALUES("PAYEE_ACCOUNT_NO", "#{payeeAccountNo,jdbcType=VARCHAR}");
        }
        
        if (record.getGmtBizInitiate() != null) {
            VALUES("GMT_BIZ_INITIATE", "#{gmtBizInitiate,jdbcType=VARCHAR}");
        }
        
        if (record.getGmtPaymentInitiate() != null) {
            VALUES("GMT_PAYMENT_INITIATE", "#{gmtPaymentInitiate,jdbcType=VARCHAR}");
        }
        
        if (record.getRemitAmount() != null) {
            VALUES("REMIT_AMOUNT", "#{remitAmount,jdbcType=VARCHAR}");
        }
        
        if (record.getCallbackAddress() != null) {
            VALUES("CALLBACK_ADDRESS", "#{callbackAddress,jdbcType=VARCHAR}");
        }
        
        if (record.getMemo() != null) {
            VALUES("MEMO", "#{memo,jdbcType=VARCHAR}");
        }
        
        if (record.getIsPemitPricingErr() != null) {
            VALUES("IS_PEMIT_PRICING_ERR", "#{isPemitPricingErr,jdbcType=VARCHAR}");
        }
        
        if (record.getCurrency() != null) {
            VALUES("CURRENCY", "#{currency,jdbcType=VARCHAR}");
        }
        
        if (record.getPaymentSeqNo() != null) {
            VALUES("PAYMENT_SEQ_NO", "#{paymentSeqNo,jdbcType=VARCHAR}");
        }
        
        if (record.getPocketAmount() != null) {
            VALUES("POCKET_AMOUNT", "#{pocketAmount,jdbcType=VARCHAR}");
        }
        
        if (record.getSettlementTime() != null) {
            VALUES("SETTLEMENT_TIME", "#{settlementTime,jdbcType=VARCHAR}");
        }
        
        if (record.getReturnCode() != null) {
            VALUES("RETURN_CODE", "#{returnCode,jdbcType=VARCHAR}");
        }
        
        if (record.getReturnMsg() != null) {
            VALUES("RETURN_MSG", "#{returnMsg,jdbcType=VARCHAR}");
        }
        
        if (record.getExtention() != null) {
            VALUES("EXTENTION", "#{extention,jdbcType=VARCHAR}");
        }
        
        if (record.getCreateTime() != null) {
            VALUES("CREATE_TIME", "#{createTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getUpdateTime() != null) {
            VALUES("UPDATE_TIME", "#{updateTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getBatchNo() != null) {
            VALUES("BATCH_NO", "#{batchNo,jdbcType=VARCHAR}");
        }
        
        if (record.getPayeeAccountType() != null) {
            VALUES("PAYEE_ACCOUNT_TYPE", "#{payeeAccountType,jdbcType=VARCHAR}");
        }
        
        return SQL();
    }

    /**
     * 根据Example对象查询得到保证金转账记录【MarginTransDO】对象列表信息
     *
     * @mbggenerated Wed Jun 03 18:04:23 CST 2015
     */
    public String selectByExample(MarginTransDOExample example) {
        BEGIN();
        if (example != null && example.isDistinct()) {
            SELECT_DISTINCT("MT_ID");
        } else {
            SELECT("MT_ID");
        }
        SELECT("STATUS");
        SELECT("PRODUCT_CODE");
        SELECT("APP_ID");
        SELECT("PAYMENT_CODE");
        SELECT("REMIT_VOUCHER_NO");
        SELECT("PAYMENT_STATE");
        SELECT("PAYER_MEMBER_ID");
        SELECT("PAYEE_MEMBER_ID");
        SELECT("IS_NEED_COUNT_FEE");
        SELECT("PAYER_FEE");
        SELECT("PAYEE_FEE");
        SELECT("PAYER_ACCOUNT_TYPE");
        SELECT("PAYER_ACCOUNT_NO");
        SELECT("PAYEE_ACCOUNT_NO");
        SELECT("GMT_BIZ_INITIATE");
        SELECT("GMT_PAYMENT_INITIATE");
        SELECT("REMIT_AMOUNT");
        SELECT("CALLBACK_ADDRESS");
        SELECT("MEMO");
        SELECT("IS_PEMIT_PRICING_ERR");
        SELECT("CURRENCY");
        SELECT("PAYMENT_SEQ_NO");
        SELECT("POCKET_AMOUNT");
        SELECT("SETTLEMENT_TIME");
        SELECT("RETURN_CODE");
        SELECT("RETURN_MSG");
        SELECT("EXTENTION");
        SELECT("CREATE_TIME");
        SELECT("UPDATE_TIME");
        SELECT("BATCH_NO");
        SELECT("PAYEE_ACCOUNT_TYPE");
        FROM("TB_MARGIN_TRANS");
        applyWhere(example, false);
        
        if (example != null && example.getOrderByClause() != null) {
            ORDER_BY(example.getOrderByClause());
        }
        
        return SQL();
    }

    /**
     * 根据Query对象分页查询保证金转账记录【MarginTransDO】对象列表信息
     *
     * @mbggenerated Wed Jun 03 18:04:23 CST 2015
     */
    public String selectByQuery(MarginTransDOExample example) {
        BEGIN();
        if (example != null && example.isDistinct()) {
            SELECT_DISTINCT("MT_ID");
        } else {
            SELECT("MT_ID");
        }
        SELECT("STATUS");
        SELECT("PRODUCT_CODE");
        SELECT("APP_ID");
        SELECT("PAYMENT_CODE");
        SELECT("REMIT_VOUCHER_NO");
        SELECT("PAYMENT_STATE");
        SELECT("PAYER_MEMBER_ID");
        SELECT("PAYEE_MEMBER_ID");
        SELECT("IS_NEED_COUNT_FEE");
        SELECT("PAYER_FEE");
        SELECT("PAYEE_FEE");
        SELECT("PAYER_ACCOUNT_TYPE");
        SELECT("PAYER_ACCOUNT_NO");
        SELECT("PAYEE_ACCOUNT_NO");
        SELECT("GMT_BIZ_INITIATE");
        SELECT("GMT_PAYMENT_INITIATE");
        SELECT("REMIT_AMOUNT");
        SELECT("CALLBACK_ADDRESS");
        SELECT("MEMO");
        SELECT("IS_PEMIT_PRICING_ERR");
        SELECT("CURRENCY");
        SELECT("PAYMENT_SEQ_NO");
        SELECT("POCKET_AMOUNT");
        SELECT("SETTLEMENT_TIME");
        SELECT("RETURN_CODE");
        SELECT("RETURN_MSG");
        SELECT("EXTENTION");
        SELECT("CREATE_TIME");
        SELECT("UPDATE_TIME");
        SELECT("BATCH_NO");
        SELECT("PAYEE_ACCOUNT_TYPE");
        FROM("TB_MARGIN_TRANS");
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
     * 根据Example对象更新保证金转账记录【MarginTransDO】对象信息，仅更新非空字段
     *
     * @mbggenerated Wed Jun 03 18:04:23 CST 2015
     */
    public String updateByExampleSelective(Map<String, Object> parameter) {
        MarginTransDO record = (MarginTransDO) parameter.get("record");
        MarginTransDOExample example = (MarginTransDOExample) parameter.get("example");
        
        BEGIN();
        UPDATE("TB_MARGIN_TRANS");
        
        if (record.getMtId() != null) {
            SET("MT_ID = #{record.mtId,jdbcType=DECIMAL}");
        }
        
        if (record.getStatus() != null) {
            SET("STATUS = #{record.status,jdbcType=DECIMAL}");
        }
        
        if (record.getProductCode() != null) {
            SET("PRODUCT_CODE = #{record.productCode,jdbcType=VARCHAR}");
        }
        
        if (record.getAppId() != null) {
            SET("APP_ID = #{record.appId,jdbcType=VARCHAR}");
        }
        
        if (record.getPaymentCode() != null) {
            SET("PAYMENT_CODE = #{record.paymentCode,jdbcType=VARCHAR}");
        }
        
        if (record.getRemitVoucherNo() != null) {
            SET("REMIT_VOUCHER_NO = #{record.remitVoucherNo,jdbcType=VARCHAR}");
        }
        
        if (record.getPaymentState() != null) {
            SET("PAYMENT_STATE = #{record.paymentState,jdbcType=VARCHAR}");
        }
        
        if (record.getPayerMemberId() != null) {
            SET("PAYER_MEMBER_ID = #{record.payerMemberId,jdbcType=VARCHAR}");
        }
        
        if (record.getPayeeMemberId() != null) {
            SET("PAYEE_MEMBER_ID = #{record.payeeMemberId,jdbcType=VARCHAR}");
        }
        
        if (record.getIsNeedCountFee() != null) {
            SET("IS_NEED_COUNT_FEE = #{record.isNeedCountFee,jdbcType=VARCHAR}");
        }
        
        if (record.getPayerFee() != null) {
            SET("PAYER_FEE = #{record.payerFee,jdbcType=VARCHAR}");
        }
        
        if (record.getPayeeFee() != null) {
            SET("PAYEE_FEE = #{record.payeeFee,jdbcType=VARCHAR}");
        }
        
        if (record.getPayerAccountType() != null) {
            SET("PAYER_ACCOUNT_TYPE = #{record.payerAccountType,jdbcType=VARCHAR}");
        }
        
        if (record.getPayerAccountNo() != null) {
            SET("PAYER_ACCOUNT_NO = #{record.payerAccountNo,jdbcType=VARCHAR}");
        }
        
        if (record.getPayeeAccountNo() != null) {
            SET("PAYEE_ACCOUNT_NO = #{record.payeeAccountNo,jdbcType=VARCHAR}");
        }
        
        if (record.getGmtBizInitiate() != null) {
            SET("GMT_BIZ_INITIATE = #{record.gmtBizInitiate,jdbcType=VARCHAR}");
        }
        
        if (record.getGmtPaymentInitiate() != null) {
            SET("GMT_PAYMENT_INITIATE = #{record.gmtPaymentInitiate,jdbcType=VARCHAR}");
        }
        
        if (record.getRemitAmount() != null) {
            SET("REMIT_AMOUNT = #{record.remitAmount,jdbcType=VARCHAR}");
        }
        
        if (record.getCallbackAddress() != null) {
            SET("CALLBACK_ADDRESS = #{record.callbackAddress,jdbcType=VARCHAR}");
        }
        
        if (record.getMemo() != null) {
            SET("MEMO = #{record.memo,jdbcType=VARCHAR}");
        }
        
        if (record.getIsPemitPricingErr() != null) {
            SET("IS_PEMIT_PRICING_ERR = #{record.isPemitPricingErr,jdbcType=VARCHAR}");
        }
        
        if (record.getCurrency() != null) {
            SET("CURRENCY = #{record.currency,jdbcType=VARCHAR}");
        }
        
        if (record.getPaymentSeqNo() != null) {
            SET("PAYMENT_SEQ_NO = #{record.paymentSeqNo,jdbcType=VARCHAR}");
        }
        
        if (record.getPocketAmount() != null) {
            SET("POCKET_AMOUNT = #{record.pocketAmount,jdbcType=VARCHAR}");
        }
        
        if (record.getSettlementTime() != null) {
            SET("SETTLEMENT_TIME = #{record.settlementTime,jdbcType=VARCHAR}");
        }
        
        if (record.getReturnCode() != null) {
            SET("RETURN_CODE = #{record.returnCode,jdbcType=VARCHAR}");
        }
        
        if (record.getReturnMsg() != null) {
            SET("RETURN_MSG = #{record.returnMsg,jdbcType=VARCHAR}");
        }
        
        if (record.getExtention() != null) {
            SET("EXTENTION = #{record.extention,jdbcType=VARCHAR}");
        }
        
        if (record.getCreateTime() != null) {
            SET("CREATE_TIME = #{record.createTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getUpdateTime() != null) {
            SET("UPDATE_TIME = #{record.updateTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getBatchNo() != null) {
            SET("BATCH_NO = #{record.batchNo,jdbcType=VARCHAR}");
        }
        
        if (record.getPayeeAccountType() != null) {
            SET("PAYEE_ACCOUNT_TYPE = #{record.payeeAccountType,jdbcType=VARCHAR}");
        }
        
        applyWhere(example, true);
        return SQL();
    }

    /**
     * 根据Example对象更新保证金转账记录【MarginTransDO】对象信息
     *
     * @mbggenerated Wed Jun 03 18:04:23 CST 2015
     */
    public String updateByExample(Map<String, Object> parameter) {
        BEGIN();
        UPDATE("TB_MARGIN_TRANS");
        
        SET("MT_ID = #{record.mtId,jdbcType=DECIMAL}");
        SET("STATUS = #{record.status,jdbcType=DECIMAL}");
        SET("PRODUCT_CODE = #{record.productCode,jdbcType=VARCHAR}");
        SET("APP_ID = #{record.appId,jdbcType=VARCHAR}");
        SET("PAYMENT_CODE = #{record.paymentCode,jdbcType=VARCHAR}");
        SET("REMIT_VOUCHER_NO = #{record.remitVoucherNo,jdbcType=VARCHAR}");
        SET("PAYMENT_STATE = #{record.paymentState,jdbcType=VARCHAR}");
        SET("PAYER_MEMBER_ID = #{record.payerMemberId,jdbcType=VARCHAR}");
        SET("PAYEE_MEMBER_ID = #{record.payeeMemberId,jdbcType=VARCHAR}");
        SET("IS_NEED_COUNT_FEE = #{record.isNeedCountFee,jdbcType=VARCHAR}");
        SET("PAYER_FEE = #{record.payerFee,jdbcType=VARCHAR}");
        SET("PAYEE_FEE = #{record.payeeFee,jdbcType=VARCHAR}");
        SET("PAYER_ACCOUNT_TYPE = #{record.payerAccountType,jdbcType=VARCHAR}");
        SET("PAYER_ACCOUNT_NO = #{record.payerAccountNo,jdbcType=VARCHAR}");
        SET("PAYEE_ACCOUNT_NO = #{record.payeeAccountNo,jdbcType=VARCHAR}");
        SET("GMT_BIZ_INITIATE = #{record.gmtBizInitiate,jdbcType=VARCHAR}");
        SET("GMT_PAYMENT_INITIATE = #{record.gmtPaymentInitiate,jdbcType=VARCHAR}");
        SET("REMIT_AMOUNT = #{record.remitAmount,jdbcType=VARCHAR}");
        SET("CALLBACK_ADDRESS = #{record.callbackAddress,jdbcType=VARCHAR}");
        SET("MEMO = #{record.memo,jdbcType=VARCHAR}");
        SET("IS_PEMIT_PRICING_ERR = #{record.isPemitPricingErr,jdbcType=VARCHAR}");
        SET("CURRENCY = #{record.currency,jdbcType=VARCHAR}");
        SET("PAYMENT_SEQ_NO = #{record.paymentSeqNo,jdbcType=VARCHAR}");
        SET("POCKET_AMOUNT = #{record.pocketAmount,jdbcType=VARCHAR}");
        SET("SETTLEMENT_TIME = #{record.settlementTime,jdbcType=VARCHAR}");
        SET("RETURN_CODE = #{record.returnCode,jdbcType=VARCHAR}");
        SET("RETURN_MSG = #{record.returnMsg,jdbcType=VARCHAR}");
        SET("EXTENTION = #{record.extention,jdbcType=VARCHAR}");
        SET("CREATE_TIME = #{record.createTime,jdbcType=TIMESTAMP}");
        SET("UPDATE_TIME = #{record.updateTime,jdbcType=TIMESTAMP}");
        SET("BATCH_NO = #{record.batchNo,jdbcType=VARCHAR}");
        SET("PAYEE_ACCOUNT_TYPE = #{record.payeeAccountType,jdbcType=VARCHAR}");
        
        MarginTransDOExample example = (MarginTransDOExample) parameter.get("example");
        applyWhere(example, true);
        return SQL();
    }

    /**
     * 根据主键更新保证金转账记录【MarginTransDO】对象信息，仅更新非空对象
     *
     * @mbggenerated Wed Jun 03 18:04:23 CST 2015
     */
    public String updateByPrimaryKeySelective(MarginTransDO record) {
        BEGIN();
        UPDATE("TB_MARGIN_TRANS");
        
        if (record.getStatus() != null) {
            SET("STATUS = #{status,jdbcType=DECIMAL}");
        }
        
        if (record.getProductCode() != null) {
            SET("PRODUCT_CODE = #{productCode,jdbcType=VARCHAR}");
        }
        
        if (record.getAppId() != null) {
            SET("APP_ID = #{appId,jdbcType=VARCHAR}");
        }
        
        if (record.getPaymentCode() != null) {
            SET("PAYMENT_CODE = #{paymentCode,jdbcType=VARCHAR}");
        }
        
        if (record.getRemitVoucherNo() != null) {
            SET("REMIT_VOUCHER_NO = #{remitVoucherNo,jdbcType=VARCHAR}");
        }
        
        if (record.getPaymentState() != null) {
            SET("PAYMENT_STATE = #{paymentState,jdbcType=VARCHAR}");
        }
        
        if (record.getPayerMemberId() != null) {
            SET("PAYER_MEMBER_ID = #{payerMemberId,jdbcType=VARCHAR}");
        }
        
        if (record.getPayeeMemberId() != null) {
            SET("PAYEE_MEMBER_ID = #{payeeMemberId,jdbcType=VARCHAR}");
        }
        
        if (record.getIsNeedCountFee() != null) {
            SET("IS_NEED_COUNT_FEE = #{isNeedCountFee,jdbcType=VARCHAR}");
        }
        
        if (record.getPayerFee() != null) {
            SET("PAYER_FEE = #{payerFee,jdbcType=VARCHAR}");
        }
        
        if (record.getPayeeFee() != null) {
            SET("PAYEE_FEE = #{payeeFee,jdbcType=VARCHAR}");
        }
        
        if (record.getPayerAccountType() != null) {
            SET("PAYER_ACCOUNT_TYPE = #{payerAccountType,jdbcType=VARCHAR}");
        }
        
        if (record.getPayerAccountNo() != null) {
            SET("PAYER_ACCOUNT_NO = #{payerAccountNo,jdbcType=VARCHAR}");
        }
        
        if (record.getPayeeAccountNo() != null) {
            SET("PAYEE_ACCOUNT_NO = #{payeeAccountNo,jdbcType=VARCHAR}");
        }
        
        if (record.getGmtBizInitiate() != null) {
            SET("GMT_BIZ_INITIATE = #{gmtBizInitiate,jdbcType=VARCHAR}");
        }
        
        if (record.getGmtPaymentInitiate() != null) {
            SET("GMT_PAYMENT_INITIATE = #{gmtPaymentInitiate,jdbcType=VARCHAR}");
        }
        
        if (record.getRemitAmount() != null) {
            SET("REMIT_AMOUNT = #{remitAmount,jdbcType=VARCHAR}");
        }
        
        if (record.getCallbackAddress() != null) {
            SET("CALLBACK_ADDRESS = #{callbackAddress,jdbcType=VARCHAR}");
        }
        
        if (record.getMemo() != null) {
            SET("MEMO = #{memo,jdbcType=VARCHAR}");
        }
        
        if (record.getIsPemitPricingErr() != null) {
            SET("IS_PEMIT_PRICING_ERR = #{isPemitPricingErr,jdbcType=VARCHAR}");
        }
        
        if (record.getCurrency() != null) {
            SET("CURRENCY = #{currency,jdbcType=VARCHAR}");
        }
        
        if (record.getPaymentSeqNo() != null) {
            SET("PAYMENT_SEQ_NO = #{paymentSeqNo,jdbcType=VARCHAR}");
        }
        
        if (record.getPocketAmount() != null) {
            SET("POCKET_AMOUNT = #{pocketAmount,jdbcType=VARCHAR}");
        }
        
        if (record.getSettlementTime() != null) {
            SET("SETTLEMENT_TIME = #{settlementTime,jdbcType=VARCHAR}");
        }
        
        if (record.getReturnCode() != null) {
            SET("RETURN_CODE = #{returnCode,jdbcType=VARCHAR}");
        }
        
        if (record.getReturnMsg() != null) {
            SET("RETURN_MSG = #{returnMsg,jdbcType=VARCHAR}");
        }
        
        if (record.getExtention() != null) {
            SET("EXTENTION = #{extention,jdbcType=VARCHAR}");
        }
        
        if (record.getCreateTime() != null) {
            SET("CREATE_TIME = #{createTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getUpdateTime() != null) {
            SET("UPDATE_TIME = #{updateTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getBatchNo() != null) {
            SET("BATCH_NO = #{batchNo,jdbcType=VARCHAR}");
        }
        
        if (record.getPayeeAccountType() != null) {
            SET("PAYEE_ACCOUNT_TYPE = #{payeeAccountType,jdbcType=VARCHAR}");
        }
        
        WHERE("MT_ID = #{mtId,jdbcType=DECIMAL}");
        
        return SQL();
    }

    /**
     * This method corresponds to the database table TB_MARGIN_TRANS
     *
     * @mbggenerated Wed Jun 03 18:04:23 CST 2015
     */
    protected void applyWhere(MarginTransDOExample example, boolean includeExamplePhrase) {
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
        
        if (example.getMtId() != null) {
            sb.append(" and  MT_ID = #{mtId,jdbcType=DECIMAL} ");
        }
        
        if (example.getStatus() != null) {
            sb.append(" and  STATUS = #{status,jdbcType=DECIMAL} ");
        }
        
        if (example.getProductCode() != null && !example.getProductCode().equals("") ) {
            sb.append(" and  PRODUCT_CODE = #{productCode,jdbcType=VARCHAR} ");
        }
        
        if (example.getAppId() != null && !example.getAppId().equals("") ) {
            sb.append(" and  APP_ID = #{appId,jdbcType=VARCHAR} ");
        }
        
        if (example.getPaymentCode() != null && !example.getPaymentCode().equals("") ) {
            sb.append(" and  PAYMENT_CODE = #{paymentCode,jdbcType=VARCHAR} ");
        }
        
        if (example.getRemitVoucherNo() != null && !example.getRemitVoucherNo().equals("") ) {
            sb.append(" and  REMIT_VOUCHER_NO = #{remitVoucherNo,jdbcType=VARCHAR} ");
        }
        
        if (example.getPaymentState() != null && !example.getPaymentState().equals("") ) {
            sb.append(" and  PAYMENT_STATE = #{paymentState,jdbcType=VARCHAR} ");
        }
        
        if (example.getPayerMemberId() != null && !example.getPayerMemberId().equals("") ) {
            sb.append(" and  PAYER_MEMBER_ID = #{payerMemberId,jdbcType=VARCHAR} ");
        }
        
        if (example.getPayeeMemberId() != null && !example.getPayeeMemberId().equals("") ) {
            sb.append(" and  PAYEE_MEMBER_ID = #{payeeMemberId,jdbcType=VARCHAR} ");
        }
        
        if (example.getIsNeedCountFee() != null && !example.getIsNeedCountFee().equals("") ) {
            sb.append(" and  IS_NEED_COUNT_FEE = #{isNeedCountFee,jdbcType=VARCHAR} ");
        }
        
        if (example.getPayerFee() != null && !example.getPayerFee().equals("") ) {
            sb.append(" and  PAYER_FEE = #{payerFee,jdbcType=VARCHAR} ");
        }
        
        if (example.getPayeeFee() != null && !example.getPayeeFee().equals("") ) {
            sb.append(" and  PAYEE_FEE = #{payeeFee,jdbcType=VARCHAR} ");
        }
        
        if (example.getPayerAccountType() != null && !example.getPayerAccountType().equals("") ) {
            sb.append(" and  PAYER_ACCOUNT_TYPE = #{payerAccountType,jdbcType=VARCHAR} ");
        }
        
        if (example.getPayerAccountNo() != null && !example.getPayerAccountNo().equals("") ) {
            sb.append(" and  PAYER_ACCOUNT_NO = #{payerAccountNo,jdbcType=VARCHAR} ");
        }
        
        if (example.getPayeeAccountNo() != null && !example.getPayeeAccountNo().equals("") ) {
            sb.append(" and  PAYEE_ACCOUNT_NO = #{payeeAccountNo,jdbcType=VARCHAR} ");
        }
        
        if (example.getGmtBizInitiate() != null && !example.getGmtBizInitiate().equals("") ) {
            sb.append(" and  GMT_BIZ_INITIATE = #{gmtBizInitiate,jdbcType=VARCHAR} ");
        }
        
        if (example.getGmtPaymentInitiate() != null && !example.getGmtPaymentInitiate().equals("") ) {
            sb.append(" and  GMT_PAYMENT_INITIATE = #{gmtPaymentInitiate,jdbcType=VARCHAR} ");
        }
        
        if (example.getRemitAmount() != null && !example.getRemitAmount().equals("") ) {
            sb.append(" and  REMIT_AMOUNT = #{remitAmount,jdbcType=VARCHAR} ");
        }
        
        if (example.getCallbackAddress() != null && !example.getCallbackAddress().equals("") ) {
            sb.append(" and  CALLBACK_ADDRESS = #{callbackAddress,jdbcType=VARCHAR} ");
        }
        
        if (example.getMemo() != null && !example.getMemo().equals("") ) {
            sb.append(" and  MEMO = #{memo,jdbcType=VARCHAR} ");
        }
        
        if (example.getIsPemitPricingErr() != null && !example.getIsPemitPricingErr().equals("") ) {
            sb.append(" and  IS_PEMIT_PRICING_ERR = #{isPemitPricingErr,jdbcType=VARCHAR} ");
        }
        
        if (example.getCurrency() != null && !example.getCurrency().equals("") ) {
            sb.append(" and  CURRENCY = #{currency,jdbcType=VARCHAR} ");
        }
        
        if (example.getPaymentSeqNo() != null && !example.getPaymentSeqNo().equals("") ) {
            sb.append(" and  PAYMENT_SEQ_NO = #{paymentSeqNo,jdbcType=VARCHAR} ");
        }
        
        if (example.getPocketAmount() != null && !example.getPocketAmount().equals("") ) {
            sb.append(" and  POCKET_AMOUNT = #{pocketAmount,jdbcType=VARCHAR} ");
        }
        
        if (example.getSettlementTime() != null && !example.getSettlementTime().equals("") ) {
            sb.append(" and  SETTLEMENT_TIME = #{settlementTime,jdbcType=VARCHAR} ");
        }
        
        if (example.getReturnCode() != null && !example.getReturnCode().equals("") ) {
            sb.append(" and  RETURN_CODE = #{returnCode,jdbcType=VARCHAR} ");
        }
        
        if (example.getReturnMsg() != null && !example.getReturnMsg().equals("") ) {
            sb.append(" and  RETURN_MSG = #{returnMsg,jdbcType=VARCHAR} ");
        }
        
        if (example.getExtention() != null && !example.getExtention().equals("") ) {
            sb.append(" and  EXTENTION = #{extention,jdbcType=VARCHAR} ");
        }
        
        if (example.getCreateTime() != null) {
            sb.append(" and  CREATE_TIME = #{createTime,jdbcType=TIMESTAMP} ");
        }
        
        if (example.getUpdateTime() != null) {
            sb.append(" and  UPDATE_TIME = #{updateTime,jdbcType=TIMESTAMP} ");
        }
        
        if (example.getBatchNo() != null && !example.getBatchNo().equals("") ) {
            sb.append(" and  BATCH_NO = #{batchNo,jdbcType=VARCHAR} ");
        }
        
        if (example.getPayeeAccountType() != null && !example.getPayeeAccountType().equals("") ) {
            sb.append(" and  PAYEE_ACCOUNT_TYPE = #{payeeAccountType,jdbcType=VARCHAR} ");
        }
        WHERE(sb.toString());
    }
}