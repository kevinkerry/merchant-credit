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

import com.sdp.mc.merchant.dao.MerchantFsReq;
import com.sdp.mc.merchant.dao.MerchantFsReqExample.Criteria;
import com.sdp.mc.merchant.dao.MerchantFsReqExample.Criterion;
import com.sdp.mc.merchant.dao.MerchantFsReqExample;
import java.util.List;
import java.util.Map;

public class MerchantFsRSqlProvider {

    /**
     * 根据Example对象取得商户快速结算申请记录【MerchantFsReq】对象count信息
     *
     * @mbggenerated Fri Dec 25 17:57:04 CST 2015
     */
    public String countByExample(MerchantFsReqExample example) {
        BEGIN();
        SELECT("count(*)");
        FROM("TB_MERCHANT_FS_REQ");
        applyWhere(example, false);
        return SQL();
    }

    /**
     * 根据Example对象删除商户快速结算申请记录【MerchantFsReq】对象信息
     *
     * @mbggenerated Fri Dec 25 17:57:04 CST 2015
     */
    public String deleteByExample(MerchantFsReqExample example) {
        BEGIN();
        DELETE_FROM("TB_MERCHANT_FS_REQ");
        applyWhere(example, false);
        return SQL();
    }

    /**
     * 添加商户快速结算申请记录【MerchantFsReq】对象信息,空值字段不插入
     *
     * @mbggenerated Fri Dec 25 17:57:04 CST 2015
     */
    public String insertSelective(MerchantFsReq record) {
        BEGIN();
        INSERT_INTO("TB_MERCHANT_FS_REQ");
        
        VALUES("MFQ_ID", "#{mfqId,jdbcType=DECIMAL}");
        
        if (record.getMerchantId() != null) {
            VALUES("MERCHANT_ID", "#{merchantId,jdbcType=DECIMAL}");
        }
        
        if (record.getType() != null) {
            VALUES("TYPE", "#{type,jdbcType=DECIMAL}");
        }
        
        if (record.getStatus() != null) {
            VALUES("STATUS", "#{status,jdbcType=VARCHAR}");
        }
        
        if (record.getAmount() != null) {
            VALUES("AMOUNT", "#{amount,jdbcType=DECIMAL}");
        }
        
        if (record.getTradeCnt() != null) {
            VALUES("TRADE_CNT", "#{tradeCnt,jdbcType=DECIMAL}");
        }
        
        if (record.getSettleFee() != null) {
            VALUES("SETTLE_FEE", "#{settleFee,jdbcType=DECIMAL}");
        }
        
        if (record.getCreateTime() != null) {
            VALUES("CREATE_TIME", "#{createTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getUpdateTime() != null) {
            VALUES("UPDATE_TIME", "#{updateTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getMerchantNo() != null) {
            VALUES("MERCHANT_NO", "#{merchantNo,jdbcType=VARCHAR}");
        }
        
        if (record.getSettleBillNo() != null) {
            VALUES("SETTLE_BILL_NO", "#{settleBillNo,jdbcType=VARCHAR}");
        }
        
        if (record.getFundOutTime() != null) {
            VALUES("FUND_OUT_TIME", "#{fundOutTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getSettleStatus() != null) {
            VALUES("SETTLE_STATUS", "#{settleStatus,jdbcType=VARCHAR}");
        }
        
        if (record.getPaymentOrderNo() != null) {
            VALUES("PAYMENT_ORDER_NO", "#{paymentOrderNo,jdbcType=VARCHAR}");
        }
        
        if (record.getPaymentTime() != null) {
            VALUES("PAYMENT_TIME", "#{paymentTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getPaymentStatus() != null) {
            VALUES("PAYMENT_STATUS", "#{paymentStatus,jdbcType=VARCHAR}");
        }
        
        if (record.getMerchantMemberId() != null) {
            VALUES("MERCHANT_MEMBER_ID", "#{merchantMemberId,jdbcType=VARCHAR}");
        }
        
        if (record.getMerchantAccountNo() != null) {
            VALUES("MERCHANT_ACCOUNT_NO", "#{merchantAccountNo,jdbcType=VARCHAR}");
        }
        
        if (record.getMerchantAccountType() != null) {
            VALUES("MERCHANT_ACCOUNT_TYPE", "#{merchantAccountType,jdbcType=VARCHAR}");
        }
        
        if (record.getSubStatus() != null) {
            VALUES("SUB_STATUS", "#{subStatus,jdbcType=VARCHAR}");
        }
        
        if (record.getFastSettleFee() != null) {
            VALUES("FAST_SETTLE_FEE", "#{fastSettleFee,jdbcType=DECIMAL}");
        }
        
        if (record.getMcType() != null) {
            VALUES("MC_TYPE", "#{mcType,jdbcType=VARCHAR}");
        }
        
        if (record.getMerchantName() != null) {
            VALUES("MERCHANT_NAME", "#{merchantName,jdbcType=VARCHAR}");
        }
        
        if (record.getPromoterId() != null) {
            VALUES("PROMOTER_ID", "#{promoterId,jdbcType=DECIMAL}");
        }
        
        if (record.getPromoterName() != null) {
            VALUES("PROMOTER_NAME", "#{promoterName,jdbcType=VARCHAR}");
        }
        
        if (record.getPromoterNo() != null) {
            VALUES("PROMOTER_NO", "#{promoterNo,jdbcType=VARCHAR}");
        }
        
        if (record.getRemitFeeTransId() != null) {
            VALUES("REMIT_FEE_TRANS_ID", "#{remitFeeTransId,jdbcType=DECIMAL}");
        }
        
        if (record.getLoaningType() != null) {
            VALUES("LOANING_TYPE", "#{loaningType,jdbcType=DECIMAL}");
        }
        
        if (record.getApplyTime() != null) {
            VALUES("APPLY_TIME", "#{applyTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getWithdrawResponseCode() != null) {
            VALUES("WITHDRAW_RESPONSE_CODE", "#{withdrawResponseCode,jdbcType=VARCHAR}");
        }
        
        if (record.getWithdrawResponseMsg() != null) {
            VALUES("WITHDRAW_RESPONSE_MSG", "#{withdrawResponseMsg,jdbcType=VARCHAR}");
        }
        
        if (record.getWithdrawResponseTime() != null) {
            VALUES("WITHDRAW_RESPONSE_TIME", "#{withdrawResponseTime,jdbcType=TIMESTAMP}");
        }
        
        return SQL();
    }

    /**
     * 根据Example对象查询得到商户快速结算申请记录【MerchantFsReq】对象列表信息
     *
     * @mbggenerated Fri Dec 25 17:57:04 CST 2015
     */
    public String selectByExample(MerchantFsReqExample example) {
        BEGIN();
        if (example != null && example.isDistinct()) {
            SELECT_DISTINCT("MFQ_ID");
        } else {
            SELECT("MFQ_ID");
        }
        SELECT("MERCHANT_ID");
        SELECT("TYPE");
        SELECT("STATUS");
        SELECT("AMOUNT");
        SELECT("TRADE_CNT");
        SELECT("SETTLE_FEE");
        SELECT("CREATE_TIME");
        SELECT("UPDATE_TIME");
        SELECT("MERCHANT_NO");
        SELECT("SETTLE_BILL_NO");
        SELECT("FUND_OUT_TIME");
        SELECT("SETTLE_STATUS");
        SELECT("PAYMENT_ORDER_NO");
        SELECT("PAYMENT_TIME");
        SELECT("PAYMENT_STATUS");
        SELECT("MERCHANT_MEMBER_ID");
        SELECT("MERCHANT_ACCOUNT_NO");
        SELECT("MERCHANT_ACCOUNT_TYPE");
        SELECT("SUB_STATUS");
        SELECT("FAST_SETTLE_FEE");
        SELECT("MC_TYPE");
        SELECT("MERCHANT_NAME");
        SELECT("PROMOTER_ID");
        SELECT("PROMOTER_NAME");
        SELECT("PROMOTER_NO");
        SELECT("REMIT_FEE_TRANS_ID");
        SELECT("LOANING_TYPE");
        SELECT("APPLY_TIME");
        SELECT("WITHDRAW_RESPONSE_CODE");
        SELECT("WITHDRAW_RESPONSE_MSG");
        SELECT("WITHDRAW_RESPONSE_TIME");
        FROM("TB_MERCHANT_FS_REQ");
        applyWhere(example, false);
        
        if (example != null && example.getOrderByClause() != null) {
            ORDER_BY(example.getOrderByClause());
        }
        
        return SQL();
    }

    /**
     * 根据Query对象分页查询商户快速结算申请记录【MerchantFsReq】对象列表信息
     *
     * @mbggenerated Fri Dec 25 17:57:04 CST 2015
     */
    public String selectByQuery(MerchantFsReqExample example) {
        BEGIN();
        if (example != null && example.isDistinct()) {
            SELECT_DISTINCT("MFQ_ID");
        } else {
            SELECT("MFQ_ID");
        }
        SELECT("MERCHANT_ID");
        SELECT("TYPE");
        SELECT("STATUS");
        SELECT("AMOUNT");
        SELECT("TRADE_CNT");
        SELECT("SETTLE_FEE");
        SELECT("CREATE_TIME");
        SELECT("UPDATE_TIME");
        SELECT("MERCHANT_NO");
        SELECT("SETTLE_BILL_NO");
        SELECT("FUND_OUT_TIME");
        SELECT("SETTLE_STATUS");
        SELECT("PAYMENT_ORDER_NO");
        SELECT("PAYMENT_TIME");
        SELECT("PAYMENT_STATUS");
        SELECT("MERCHANT_MEMBER_ID");
        SELECT("MERCHANT_ACCOUNT_NO");
        SELECT("MERCHANT_ACCOUNT_TYPE");
        SELECT("SUB_STATUS");
        SELECT("FAST_SETTLE_FEE");
        SELECT("MC_TYPE");
        SELECT("MERCHANT_NAME");
        SELECT("PROMOTER_ID");
        SELECT("PROMOTER_NAME");
        SELECT("PROMOTER_NO");
        SELECT("REMIT_FEE_TRANS_ID");
        SELECT("LOANING_TYPE");
        SELECT("APPLY_TIME");
        SELECT("WITHDRAW_RESPONSE_CODE");
        SELECT("WITHDRAW_RESPONSE_MSG");
        SELECT("WITHDRAW_RESPONSE_TIME");
        FROM("TB_MERCHANT_FS_REQ");
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
     * 根据Example对象更新商户快速结算申请记录【MerchantFsReq】对象信息，仅更新非空字段
     *
     * @mbggenerated Fri Dec 25 17:57:04 CST 2015
     */
    public String updateByExampleSelective(Map<String, Object> parameter) {
        MerchantFsReq record = (MerchantFsReq) parameter.get("record");
        MerchantFsReqExample example = (MerchantFsReqExample) parameter.get("example");
        
        BEGIN();
        UPDATE("TB_MERCHANT_FS_REQ");
        
        if (record.getMfqId() != null) {
            SET("MFQ_ID = #{record.mfqId,jdbcType=DECIMAL}");
        }
        
        if (record.getMerchantId() != null) {
            SET("MERCHANT_ID = #{record.merchantId,jdbcType=DECIMAL}");
        }
        
        if (record.getType() != null) {
            SET("TYPE = #{record.type,jdbcType=DECIMAL}");
        }
        
        if (record.getStatus() != null) {
            SET("STATUS = #{record.status,jdbcType=VARCHAR}");
        }
        
        if (record.getAmount() != null) {
            SET("AMOUNT = #{record.amount,jdbcType=DECIMAL}");
        }
        
        if (record.getTradeCnt() != null) {
            SET("TRADE_CNT = #{record.tradeCnt,jdbcType=DECIMAL}");
        }
        
        if (record.getSettleFee() != null) {
            SET("SETTLE_FEE = #{record.settleFee,jdbcType=DECIMAL}");
        }
        
        if (record.getCreateTime() != null) {
            SET("CREATE_TIME = #{record.createTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getUpdateTime() != null) {
            SET("UPDATE_TIME = #{record.updateTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getMerchantNo() != null) {
            SET("MERCHANT_NO = #{record.merchantNo,jdbcType=VARCHAR}");
        }
        
        if (record.getSettleBillNo() != null) {
            SET("SETTLE_BILL_NO = #{record.settleBillNo,jdbcType=VARCHAR}");
        }
        
        if (record.getFundOutTime() != null) {
            SET("FUND_OUT_TIME = #{record.fundOutTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getSettleStatus() != null) {
            SET("SETTLE_STATUS = #{record.settleStatus,jdbcType=VARCHAR}");
        }
        
        if (record.getPaymentOrderNo() != null) {
            SET("PAYMENT_ORDER_NO = #{record.paymentOrderNo,jdbcType=VARCHAR}");
        }
        
        if (record.getPaymentTime() != null) {
            SET("PAYMENT_TIME = #{record.paymentTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getPaymentStatus() != null) {
            SET("PAYMENT_STATUS = #{record.paymentStatus,jdbcType=VARCHAR}");
        }
        
        if (record.getMerchantMemberId() != null) {
            SET("MERCHANT_MEMBER_ID = #{record.merchantMemberId,jdbcType=VARCHAR}");
        }
        
        if (record.getMerchantAccountNo() != null) {
            SET("MERCHANT_ACCOUNT_NO = #{record.merchantAccountNo,jdbcType=VARCHAR}");
        }
        
        if (record.getMerchantAccountType() != null) {
            SET("MERCHANT_ACCOUNT_TYPE = #{record.merchantAccountType,jdbcType=VARCHAR}");
        }
        
        if (record.getSubStatus() != null) {
            SET("SUB_STATUS = #{record.subStatus,jdbcType=VARCHAR}");
        }
        
        if (record.getFastSettleFee() != null) {
            SET("FAST_SETTLE_FEE = #{record.fastSettleFee,jdbcType=DECIMAL}");
        }
        
        if (record.getMcType() != null) {
            SET("MC_TYPE = #{record.mcType,jdbcType=VARCHAR}");
        }
        
        if (record.getMerchantName() != null) {
            SET("MERCHANT_NAME = #{record.merchantName,jdbcType=VARCHAR}");
        }
        
        if (record.getPromoterId() != null) {
            SET("PROMOTER_ID = #{record.promoterId,jdbcType=DECIMAL}");
        }
        
        if (record.getPromoterName() != null) {
            SET("PROMOTER_NAME = #{record.promoterName,jdbcType=VARCHAR}");
        }
        
        if (record.getPromoterNo() != null) {
            SET("PROMOTER_NO = #{record.promoterNo,jdbcType=VARCHAR}");
        }
        
        if (record.getRemitFeeTransId() != null) {
            SET("REMIT_FEE_TRANS_ID = #{record.remitFeeTransId,jdbcType=DECIMAL}");
        }
        
        if (record.getLoaningType() != null) {
            SET("LOANING_TYPE = #{record.loaningType,jdbcType=DECIMAL}");
        }
        
        if (record.getApplyTime() != null) {
            SET("APPLY_TIME = #{record.applyTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getWithdrawResponseCode() != null) {
            SET("WITHDRAW_RESPONSE_CODE = #{record.withdrawResponseCode,jdbcType=VARCHAR}");
        }
        
        if (record.getWithdrawResponseMsg() != null) {
            SET("WITHDRAW_RESPONSE_MSG = #{record.withdrawResponseMsg,jdbcType=VARCHAR}");
        }
        
        if (record.getWithdrawResponseTime() != null) {
            SET("WITHDRAW_RESPONSE_TIME = #{record.withdrawResponseTime,jdbcType=TIMESTAMP}");
        }
        
        applyWhere(example, true);
        return SQL();
    }

    /**
     * 根据Example对象更新商户快速结算申请记录【MerchantFsReq】对象信息
     *
     * @mbggenerated Fri Dec 25 17:57:04 CST 2015
     */
    public String updateByExample(Map<String, Object> parameter) {
        BEGIN();
        UPDATE("TB_MERCHANT_FS_REQ");
        
        SET("MFQ_ID = #{record.mfqId,jdbcType=DECIMAL}");
        SET("MERCHANT_ID = #{record.merchantId,jdbcType=DECIMAL}");
        SET("TYPE = #{record.type,jdbcType=DECIMAL}");
        SET("STATUS = #{record.status,jdbcType=VARCHAR}");
        SET("AMOUNT = #{record.amount,jdbcType=DECIMAL}");
        SET("TRADE_CNT = #{record.tradeCnt,jdbcType=DECIMAL}");
        SET("SETTLE_FEE = #{record.settleFee,jdbcType=DECIMAL}");
        SET("CREATE_TIME = #{record.createTime,jdbcType=TIMESTAMP}");
        SET("UPDATE_TIME = #{record.updateTime,jdbcType=TIMESTAMP}");
        SET("MERCHANT_NO = #{record.merchantNo,jdbcType=VARCHAR}");
        SET("SETTLE_BILL_NO = #{record.settleBillNo,jdbcType=VARCHAR}");
        SET("FUND_OUT_TIME = #{record.fundOutTime,jdbcType=TIMESTAMP}");
        SET("SETTLE_STATUS = #{record.settleStatus,jdbcType=VARCHAR}");
        SET("PAYMENT_ORDER_NO = #{record.paymentOrderNo,jdbcType=VARCHAR}");
        SET("PAYMENT_TIME = #{record.paymentTime,jdbcType=TIMESTAMP}");
        SET("PAYMENT_STATUS = #{record.paymentStatus,jdbcType=VARCHAR}");
        SET("MERCHANT_MEMBER_ID = #{record.merchantMemberId,jdbcType=VARCHAR}");
        SET("MERCHANT_ACCOUNT_NO = #{record.merchantAccountNo,jdbcType=VARCHAR}");
        SET("MERCHANT_ACCOUNT_TYPE = #{record.merchantAccountType,jdbcType=VARCHAR}");
        SET("SUB_STATUS = #{record.subStatus,jdbcType=VARCHAR}");
        SET("FAST_SETTLE_FEE = #{record.fastSettleFee,jdbcType=DECIMAL}");
        SET("MC_TYPE = #{record.mcType,jdbcType=VARCHAR}");
        SET("MERCHANT_NAME = #{record.merchantName,jdbcType=VARCHAR}");
        SET("PROMOTER_ID = #{record.promoterId,jdbcType=DECIMAL}");
        SET("PROMOTER_NAME = #{record.promoterName,jdbcType=VARCHAR}");
        SET("PROMOTER_NO = #{record.promoterNo,jdbcType=VARCHAR}");
        SET("REMIT_FEE_TRANS_ID = #{record.remitFeeTransId,jdbcType=DECIMAL}");
        SET("LOANING_TYPE = #{record.loaningType,jdbcType=DECIMAL}");
        SET("APPLY_TIME = #{record.applyTime,jdbcType=TIMESTAMP}");
        SET("WITHDRAW_RESPONSE_CODE = #{record.withdrawResponseCode,jdbcType=VARCHAR}");
        SET("WITHDRAW_RESPONSE_MSG = #{record.withdrawResponseMsg,jdbcType=VARCHAR}");
        SET("WITHDRAW_RESPONSE_TIME = #{record.withdrawResponseTime,jdbcType=TIMESTAMP}");
        
        MerchantFsReqExample example = (MerchantFsReqExample) parameter.get("example");
        applyWhere(example, true);
        return SQL();
    }

    /**
     * 根据主键更新商户快速结算申请记录【MerchantFsReq】对象信息，仅更新非空对象
     *
     * @mbggenerated Fri Dec 25 17:57:04 CST 2015
     */
    public String updateByPrimaryKeySelective(MerchantFsReq record) {
        BEGIN();
        UPDATE("TB_MERCHANT_FS_REQ");
        
        if (record.getMerchantId() != null) {
            SET("MERCHANT_ID = #{merchantId,jdbcType=DECIMAL}");
        }
        
        if (record.getType() != null) {
            SET("TYPE = #{type,jdbcType=DECIMAL}");
        }
        
        if (record.getStatus() != null) {
            SET("STATUS = #{status,jdbcType=VARCHAR}");
        }
        
        if (record.getAmount() != null) {
            SET("AMOUNT = #{amount,jdbcType=DECIMAL}");
        }
        
        if (record.getTradeCnt() != null) {
            SET("TRADE_CNT = #{tradeCnt,jdbcType=DECIMAL}");
        }
        
        if (record.getSettleFee() != null) {
            SET("SETTLE_FEE = #{settleFee,jdbcType=DECIMAL}");
        }
        
        if (record.getCreateTime() != null) {
            SET("CREATE_TIME = #{createTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getUpdateTime() != null) {
            SET("UPDATE_TIME = #{updateTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getMerchantNo() != null) {
            SET("MERCHANT_NO = #{merchantNo,jdbcType=VARCHAR}");
        }
        
        if (record.getSettleBillNo() != null) {
            SET("SETTLE_BILL_NO = #{settleBillNo,jdbcType=VARCHAR}");
        }
        
        if (record.getFundOutTime() != null) {
            SET("FUND_OUT_TIME = #{fundOutTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getSettleStatus() != null) {
            SET("SETTLE_STATUS = #{settleStatus,jdbcType=VARCHAR}");
        }
        
        if (record.getPaymentOrderNo() != null) {
            SET("PAYMENT_ORDER_NO = #{paymentOrderNo,jdbcType=VARCHAR}");
        }
        
        if (record.getPaymentTime() != null) {
            SET("PAYMENT_TIME = #{paymentTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getPaymentStatus() != null) {
            SET("PAYMENT_STATUS = #{paymentStatus,jdbcType=VARCHAR}");
        }
        
        if (record.getMerchantMemberId() != null) {
            SET("MERCHANT_MEMBER_ID = #{merchantMemberId,jdbcType=VARCHAR}");
        }
        
        if (record.getMerchantAccountNo() != null) {
            SET("MERCHANT_ACCOUNT_NO = #{merchantAccountNo,jdbcType=VARCHAR}");
        }
        
        if (record.getMerchantAccountType() != null) {
            SET("MERCHANT_ACCOUNT_TYPE = #{merchantAccountType,jdbcType=VARCHAR}");
        }
        
        if (record.getSubStatus() != null) {
            SET("SUB_STATUS = #{subStatus,jdbcType=VARCHAR}");
        }
        
        if (record.getFastSettleFee() != null) {
            SET("FAST_SETTLE_FEE = #{fastSettleFee,jdbcType=DECIMAL}");
        }
        
        if (record.getMcType() != null) {
            SET("MC_TYPE = #{mcType,jdbcType=VARCHAR}");
        }
        
        if (record.getMerchantName() != null) {
            SET("MERCHANT_NAME = #{merchantName,jdbcType=VARCHAR}");
        }
        
        if (record.getPromoterId() != null) {
            SET("PROMOTER_ID = #{promoterId,jdbcType=DECIMAL}");
        }
        
        if (record.getPromoterName() != null) {
            SET("PROMOTER_NAME = #{promoterName,jdbcType=VARCHAR}");
        }
        
        if (record.getPromoterNo() != null) {
            SET("PROMOTER_NO = #{promoterNo,jdbcType=VARCHAR}");
        }
        
        if (record.getRemitFeeTransId() != null) {
            SET("REMIT_FEE_TRANS_ID = #{remitFeeTransId,jdbcType=DECIMAL}");
        }
        
        if (record.getLoaningType() != null) {
            SET("LOANING_TYPE = #{loaningType,jdbcType=DECIMAL}");
        }
        
        if (record.getApplyTime() != null) {
            SET("APPLY_TIME = #{applyTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getWithdrawResponseCode() != null) {
            SET("WITHDRAW_RESPONSE_CODE = #{withdrawResponseCode,jdbcType=VARCHAR}");
        }
        
        if (record.getWithdrawResponseMsg() != null) {
            SET("WITHDRAW_RESPONSE_MSG = #{withdrawResponseMsg,jdbcType=VARCHAR}");
        }
        
        if (record.getWithdrawResponseTime() != null) {
            SET("WITHDRAW_RESPONSE_TIME = #{withdrawResponseTime,jdbcType=TIMESTAMP}");
        }
        
        WHERE("MFQ_ID = #{mfqId,jdbcType=DECIMAL}");
        
        return SQL();
    }

    /**
     * This method corresponds to the database table TB_MERCHANT_FS_REQ
     *
     * @mbggenerated Fri Dec 25 17:57:04 CST 2015
     */
    protected void applyWhere(MerchantFsReqExample example, boolean includeExamplePhrase) {
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
        
        if (example.getMfqId() != null) {
            sb.append(" and  MFQ_ID = #{mfqId,jdbcType=DECIMAL} ");
        }
        
        if (example.getMerchantId() != null) {
            sb.append(" and  MERCHANT_ID = #{merchantId,jdbcType=DECIMAL} ");
        }
        
        if (example.getType() != null) {
            sb.append(" and  TYPE = #{type,jdbcType=DECIMAL} ");
        }
        
        if (example.getStatus() != null) {
            sb.append(" and  STATUS = #{status,jdbcType=VARCHAR} ");
        }
        
        if (example.getAmount() != null && !example.getAmount().equals("") ) {
            sb.append(" and  AMOUNT = #{amount,jdbcType=DECIMAL} ");
        }
        
        if (example.getTradeCnt() != null) {
            sb.append(" and  TRADE_CNT = #{tradeCnt,jdbcType=DECIMAL} ");
        }
        
        if (example.getSettleFee() != null) {
            sb.append(" and  SETTLE_FEE = #{settleFee,jdbcType=DECIMAL} ");
        }
        
        if (example.getCreateTime() != null) {
            sb.append(" and  CREATE_TIME = #{createTime,jdbcType=TIMESTAMP} ");
        }
        
        if (example.getUpdateTime() != null) {
            sb.append(" and  UPDATE_TIME = #{updateTime,jdbcType=TIMESTAMP} ");
        }
        
        if (example.getMerchantNo() != null && !example.getMerchantNo().equals("") ) {
            sb.append(" and  MERCHANT_NO = #{merchantNo,jdbcType=VARCHAR} ");
        }
        
        if (example.getSettleBillNo() != null && !example.getSettleBillNo().equals("") ) {
            sb.append(" and  SETTLE_BILL_NO = #{settleBillNo,jdbcType=VARCHAR} ");
        }
        
        if (example.getFundOutTime() != null) {
            sb.append(" and  FUND_OUT_TIME = #{fundOutTime,jdbcType=TIMESTAMP} ");
        }
        
        if (example.getSettleStatus() != null && !example.getSettleStatus().equals("") ) {
            sb.append(" and  SETTLE_STATUS = #{settleStatus,jdbcType=VARCHAR} ");
        }
        
        if (example.getPaymentOrderNo() != null && !example.getPaymentOrderNo().equals("") ) {
            sb.append(" and  PAYMENT_ORDER_NO = #{paymentOrderNo,jdbcType=VARCHAR} ");
        }
        
        if (example.getPaymentTime() != null) {
            sb.append(" and  PAYMENT_TIME = #{paymentTime,jdbcType=TIMESTAMP} ");
        }
        
        if (example.getPaymentStatus() != null && !example.getPaymentStatus().equals("") ) {
            sb.append(" and  PAYMENT_STATUS = #{paymentStatus,jdbcType=VARCHAR} ");
        }
        
        if (example.getMerchantMemberId() != null && !example.getMerchantMemberId().equals("") ) {
            sb.append(" and  MERCHANT_MEMBER_ID = #{merchantMemberId,jdbcType=VARCHAR} ");
        }
        
        if (example.getMerchantAccountNo() != null && !example.getMerchantAccountNo().equals("") ) {
            sb.append(" and  MERCHANT_ACCOUNT_NO = #{merchantAccountNo,jdbcType=VARCHAR} ");
        }
        
        if (example.getMerchantAccountType() != null && !example.getMerchantAccountType().equals("") ) {
            sb.append(" and  MERCHANT_ACCOUNT_TYPE = #{merchantAccountType,jdbcType=VARCHAR} ");
        }
        
        if (example.getSubStatus() != null && !example.getSubStatus().equals("") ) {
        	if("2".equals(example.getSubStatus())||"1".equals(example.getSubStatus())){
        		Long payEffectiveTimeMinRange=example.getPayEffectiveTimeMinRange();
        		if(payEffectiveTimeMinRange==null){
        			payEffectiveTimeMinRange=30l;
        			example.setPayEffectiveTimeMinRange(payEffectiveTimeMinRange);
        		}
        		if("2".equals(example.getSubStatus())){
        			sb.append(" and  (SUB_STATUS = '1' and WITHDRAW_RESPONSE_TIME is not null and (WITHDRAW_RESPONSE_TIME-APPLY_TIME)*24*60 > #{payEffectiveTimeMinRange,jdbcType=DECIMAL})");
        		}else{
        			sb.append(" and  (SUB_STATUS = '1' and WITHDRAW_RESPONSE_TIME is not null and (WITHDRAW_RESPONSE_TIME-APPLY_TIME)*24*60 <= #{payEffectiveTimeMinRange,jdbcType=DECIMAL})");
        		}
        	}else{
               sb.append(" and  SUB_STATUS = #{subStatus,jdbcType=VARCHAR} ");
        	}
        }
        
        if (example.getFastSettleFee() != null) {
            sb.append(" and  FAST_SETTLE_FEE = #{fastSettleFee,jdbcType=DECIMAL} ");
        }
        
        if (example.getMcType() != null && !example.getMcType().equals("") ) {
            sb.append(" and  MC_TYPE = #{mcType,jdbcType=VARCHAR} ");
        }
        
        if (example.getMerchantName() != null && !example.getMerchantName().equals("") ) {
            sb.append(" and  MERCHANT_NAME = #{merchantName,jdbcType=VARCHAR} ");
        }
        
        if (example.getPromoterId() != null) {
            sb.append(" and  PROMOTER_ID = #{promoterId,jdbcType=DECIMAL} ");
        }
        
        if (example.getPromoterName() != null && !example.getPromoterName().equals("") ) {
            sb.append(" and  PROMOTER_NAME = #{promoterName,jdbcType=VARCHAR} ");
        }
        
        if (example.getPromoterNo() != null && !example.getPromoterNo().equals("") ) {
            sb.append(" and  PROMOTER_NO = #{promoterNo,jdbcType=VARCHAR} ");
        }
        
        if (example.getRemitFeeTransId() != null) {
            sb.append(" and  REMIT_FEE_TRANS_ID = #{remitFeeTransId,jdbcType=DECIMAL} ");
        }
        
        if (example.getLoaningType() != null) {
            sb.append(" and  LOANING_TYPE = #{loaningType,jdbcType=DECIMAL} ");
        }
        
        if (example.getApplyTime() != null) {
            sb.append(" and  APPLY_TIME = #{applyTime,jdbcType=TIMESTAMP} ");
        }
        
        if (example.getWithdrawResponseCode() != null && !example.getWithdrawResponseCode().equals("") ) {
            sb.append(" and  WITHDRAW_RESPONSE_CODE = #{withdrawResponseCode,jdbcType=VARCHAR} ");
        }
        
        if (example.getWithdrawResponseMsg() != null && !example.getWithdrawResponseMsg().equals("") ) {
            sb.append(" and  WITHDRAW_RESPONSE_MSG = #{withdrawResponseMsg,jdbcType=VARCHAR} ");
        }
        
        if (example.getWithdrawResponseTime() != null) {
            sb.append(" and  WITHDRAW_RESPONSE_TIME = #{withdrawResponseTime,jdbcType=TIMESTAMP} ");
        }
        WHERE(sb.toString());
    }
}