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

import com.sdp.withdraw.dao.WithdrawReqDO;
import com.sdp.withdraw.dao.WithdrawReqDOExample.Criteria;
import com.sdp.withdraw.dao.WithdrawReqDOExample.Criterion;
import com.sdp.withdraw.dao.WithdrawReqDOExample;
import java.util.List;
import java.util.Map;

public class WithdrawReqSqlProvider {

    /**
     * 根据Example对象取得出款业务请求表【WithdrawReqDO】对象count信息
     *
     * @mbggenerated Wed Jul 05 10:53:07 CST 2017
     */
    public String countByExample(WithdrawReqDOExample example) {
        BEGIN();
        SELECT("count(*)");
        FROM("FW_WITHDRAW_REQ");
        applyWhere(example, false);
        return SQL();
    }

    /**
     * 根据Example对象删除出款业务请求表【WithdrawReqDO】对象信息
     *
     * @mbggenerated Wed Jul 05 10:53:07 CST 2017
     */
    public String deleteByExample(WithdrawReqDOExample example) {
        BEGIN();
        DELETE_FROM("FW_WITHDRAW_REQ");
        applyWhere(example, false);
        return SQL();
    }

    /**
     * 添加出款业务请求表【WithdrawReqDO】对象信息,空值字段不插入
     *
     * @mbggenerated Wed Jul 05 10:53:07 CST 2017
     */
    public String insertSelective(WithdrawReqDO record) {
        BEGIN();
        INSERT_INTO("FW_WITHDRAW_REQ");
        
        VALUES("REQ_ID", "#{reqId,jdbcType=DECIMAL}");
        
        if (record.getReqType() != null) {
            VALUES("REQ_TYPE", "#{reqType,jdbcType=DECIMAL}");
        }
        
        if (record.getAppId() != null) {
            VALUES("APP_ID", "#{appId,jdbcType=VARCHAR}");
        }
        
        if (record.getOrderNo() != null) {
            VALUES("ORDER_NO", "#{orderNo,jdbcType=VARCHAR}");
        }
        
        if (record.getMemberId() != null) {
            VALUES("MEMBER_ID", "#{memberId,jdbcType=VARCHAR}");
        }
        
        if (record.getMerchantNo() != null) {
            VALUES("MERCHANT_NO", "#{merchantNo,jdbcType=VARCHAR}");
        }
        
        if (record.getMcType() != null) {
            VALUES("MC_TYPE", "#{mcType,jdbcType=VARCHAR}");
        }
        
        if (record.getWithdrawType() != null) {
            VALUES("WITHDRAW_TYPE", "#{withdrawType,jdbcType=DECIMAL}");
        }
        
        if (record.getWithdrawAmount() != null) {
            VALUES("WITHDRAW_AMOUNT", "#{withdrawAmount,jdbcType=DECIMAL}");
        }
        
        if (record.getWithdrawFee() != null) {
            VALUES("WITHDRAW_FEE", "#{withdrawFee,jdbcType=DECIMAL}");
        }
        
        if (record.getWithdrawCost() != null) {
            VALUES("WITHDRAW_COST", "#{withdrawCost,jdbcType=DECIMAL}");
        }
        
        if (record.getOriginalAmount() != null) {
            VALUES("ORIGINAL_AMOUNT", "#{originalAmount,jdbcType=DECIMAL}");
        }
        
        if (record.getSplittingFee() != null) {
            VALUES("SPLITTING_FEE", "#{splittingFee,jdbcType=DECIMAL}");
        }
        
        if (record.getSplittingCost() != null) {
            VALUES("SPLITTING_COST", "#{splittingCost,jdbcType=DECIMAL}");
        }
        
        if (record.getPmtMemberId() != null) {
            VALUES("PMT_MEMBER_ID", "#{pmtMemberId,jdbcType=VARCHAR}");
        }
        
        if (record.getPmtMerchantNo() != null) {
            VALUES("PMT_MERCHANT_NO", "#{pmtMerchantNo,jdbcType=VARCHAR}");
        }
        
        if (record.getStatus() != null) {
            VALUES("STATUS", "#{status,jdbcType=DECIMAL}");
        }
        
        if (record.getRetryTimes() != null) {
            VALUES("RETRY_TIMES", "#{retryTimes,jdbcType=DECIMAL}");
        }
        
        if (record.getErrorCode() != null) {
            VALUES("ERROR_CODE", "#{errorCode,jdbcType=VARCHAR}");
        }
        
        if (record.getErrorMsg() != null) {
            VALUES("ERROR_MSG", "#{errorMsg,jdbcType=VARCHAR}");
        }
        
        if (record.getCallbackAddress() != null) {
            VALUES("CALLBACK_ADDRESS", "#{callbackAddress,jdbcType=VARCHAR}");
        }
        
        if (record.getApplyTime() != null) {
            VALUES("APPLY_TIME", "#{applyTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getCreateTime() != null) {
            VALUES("CREATE_TIME", "#{createTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getUpdateTime() != null) {
            VALUES("UPDATE_TIME", "#{updateTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getServiceType() != null) {
            VALUES("SERVICE_TYPE", "#{serviceType,jdbcType=DECIMAL}");
        }
        
        if (record.getProductCode() != null) {
            VALUES("PRODUCT_CODE", "#{productCode,jdbcType=VARCHAR}");
        }
        
        if (record.getPaymentCode() != null) {
            VALUES("PAYMENT_CODE", "#{paymentCode,jdbcType=VARCHAR}");
        }
        
        if (record.getWithdrawTime() != null) {
            VALUES("WITHDRAW_TIME", "#{withdrawTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getLoaningType() != null) {
            VALUES("LOANING_TYPE", "#{loaningType,jdbcType=DECIMAL}");
        }
        
        if (record.getWdCost() != null) {
            VALUES("WD_COST", "#{wdCost,jdbcType=DECIMAL}");
        }
        
        if (record.getMerchantBizId() != null) {
            VALUES("MERCHANT_BIZ_ID", "#{merchantBizId,jdbcType=DECIMAL}");
        }
        
        if (record.getMcc() != null) {
            VALUES("MCC", "#{mcc,jdbcType=VARCHAR}");
        }
        
        if (record.getLastLevelPromoterId() != null) {
            VALUES("LAST_LEVEL_PROMOTER_ID", "#{lastLevelPromoterId,jdbcType=DECIMAL}");
        }
        
        if (record.getLastDetailId() != null) {
            VALUES("LAST_DETAIL_ID", "#{lastDetailId,jdbcType=DECIMAL}");
        }
        
        if (record.getHasOaTxn() != null) {
            VALUES("HAS_OA_TXN", "#{hasOaTxn,jdbcType=VARCHAR}");
        }
        
        if (record.getReqExtention() != null) {
            VALUES("REQ_EXTENTION", "#{reqExtention,jdbcType=VARCHAR}");
        }
        
        return SQL();
    }

    /**
     * 根据Example对象查询得到出款业务请求表【WithdrawReqDO】对象列表信息
     *
     * @mbggenerated Wed Jul 05 10:53:07 CST 2017
     */
    public String selectByExample(WithdrawReqDOExample example) {
        BEGIN();
        if (example != null && example.isDistinct()) {
            SELECT_DISTINCT("REQ_ID");
        } else {
            SELECT("REQ_ID");
        }
        SELECT("REQ_TYPE");
        SELECT("APP_ID");
        SELECT("ORDER_NO");
        SELECT("MEMBER_ID");
        SELECT("MERCHANT_NO");
        SELECT("MC_TYPE");
        SELECT("WITHDRAW_TYPE");
        SELECT("WITHDRAW_AMOUNT");
        SELECT("WITHDRAW_FEE");
        SELECT("WITHDRAW_COST");
        SELECT("ORIGINAL_AMOUNT");
        SELECT("SPLITTING_FEE");
        SELECT("SPLITTING_COST");
        SELECT("PMT_MEMBER_ID");
        SELECT("PMT_MERCHANT_NO");
        SELECT("STATUS");
        SELECT("RETRY_TIMES");
        SELECT("ERROR_CODE");
        SELECT("ERROR_MSG");
        SELECT("CALLBACK_ADDRESS");
        SELECT("APPLY_TIME");
        SELECT("CREATE_TIME");
        SELECT("UPDATE_TIME");
        SELECT("SERVICE_TYPE");
        SELECT("PRODUCT_CODE");
        SELECT("PAYMENT_CODE");
        SELECT("WITHDRAW_TIME");
        SELECT("LOANING_TYPE");
        SELECT("WD_COST");
        SELECT("MERCHANT_BIZ_ID");
        SELECT("MCC");
        SELECT("LAST_LEVEL_PROMOTER_ID");
        SELECT("LAST_DETAIL_ID");
        SELECT("HAS_OA_TXN");
        SELECT("REQ_EXTENTION");
        FROM("FW_WITHDRAW_REQ");
        applyWhere(example, false);
        
        if (example != null && example.getOrderByClause() != null) {
            ORDER_BY(example.getOrderByClause());
        }
        
        return SQL();
    }

    /**
     * 根据Query对象分页查询出款业务请求表【WithdrawReqDO】对象列表信息
     *
     * @mbggenerated Wed Jul 05 10:53:07 CST 2017
     */
    public String selectByQuery(WithdrawReqDOExample example) {
        BEGIN();
        if (example != null && example.isDistinct()) {
            SELECT_DISTINCT("REQ_ID");
        } else {
            SELECT("REQ_ID");
        }
        SELECT("REQ_TYPE");
        SELECT("APP_ID");
        SELECT("ORDER_NO");
        SELECT("MEMBER_ID");
        SELECT("MERCHANT_NO");
        SELECT("MC_TYPE");
        SELECT("WITHDRAW_TYPE");
        SELECT("WITHDRAW_AMOUNT");
        SELECT("WITHDRAW_FEE");
        SELECT("WITHDRAW_COST");
        SELECT("ORIGINAL_AMOUNT");
        SELECT("SPLITTING_FEE");
        SELECT("SPLITTING_COST");
        SELECT("PMT_MEMBER_ID");
        SELECT("PMT_MERCHANT_NO");
        SELECT("STATUS");
        SELECT("RETRY_TIMES");
        SELECT("ERROR_CODE");
        SELECT("ERROR_MSG");
        SELECT("CALLBACK_ADDRESS");
        SELECT("APPLY_TIME");
        SELECT("CREATE_TIME");
        SELECT("UPDATE_TIME");
        SELECT("SERVICE_TYPE");
        SELECT("PRODUCT_CODE");
        SELECT("PAYMENT_CODE");
        SELECT("WITHDRAW_TIME");
        SELECT("LOANING_TYPE");
        SELECT("WD_COST");
        SELECT("MERCHANT_BIZ_ID");
        SELECT("MCC");
        SELECT("LAST_LEVEL_PROMOTER_ID");
        SELECT("LAST_DETAIL_ID");
        SELECT("HAS_OA_TXN");
        SELECT("REQ_EXTENTION");
        FROM("FW_WITHDRAW_REQ");
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
     * 根据Example对象更新出款业务请求表【WithdrawReqDO】对象信息，仅更新非空字段
     *
     * @mbggenerated Wed Jul 05 10:53:07 CST 2017
     */
    public String updateByExampleSelective(Map<String, Object> parameter) {
        WithdrawReqDO record = (WithdrawReqDO) parameter.get("record");
        WithdrawReqDOExample example = (WithdrawReqDOExample) parameter.get("example");
        
        BEGIN();
        UPDATE("FW_WITHDRAW_REQ");
        
        if (record.getReqId() != null) {
            SET("REQ_ID = #{record.reqId,jdbcType=DECIMAL}");
        }
        
        if (record.getReqType() != null) {
            SET("REQ_TYPE = #{record.reqType,jdbcType=DECIMAL}");
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
        
        if (record.getMerchantNo() != null) {
            SET("MERCHANT_NO = #{record.merchantNo,jdbcType=VARCHAR}");
        }
        
        if (record.getMcType() != null) {
            SET("MC_TYPE = #{record.mcType,jdbcType=VARCHAR}");
        }
        
        if (record.getWithdrawType() != null) {
            SET("WITHDRAW_TYPE = #{record.withdrawType,jdbcType=DECIMAL}");
        }
        
        if (record.getWithdrawAmount() != null) {
            SET("WITHDRAW_AMOUNT = #{record.withdrawAmount,jdbcType=DECIMAL}");
        }
        
        if (record.getWithdrawFee() != null) {
            SET("WITHDRAW_FEE = #{record.withdrawFee,jdbcType=DECIMAL}");
        }
        
        if (record.getWithdrawCost() != null) {
            SET("WITHDRAW_COST = #{record.withdrawCost,jdbcType=DECIMAL}");
        }
        
        if (record.getOriginalAmount() != null) {
            SET("ORIGINAL_AMOUNT = #{record.originalAmount,jdbcType=DECIMAL}");
        }
        
        if (record.getSplittingFee() != null) {
            SET("SPLITTING_FEE = #{record.splittingFee,jdbcType=DECIMAL}");
        }
        
        if (record.getSplittingCost() != null) {
            SET("SPLITTING_COST = #{record.splittingCost,jdbcType=DECIMAL}");
        }
        
        if (record.getPmtMemberId() != null) {
            SET("PMT_MEMBER_ID = #{record.pmtMemberId,jdbcType=VARCHAR}");
        }
        
        if (record.getPmtMerchantNo() != null) {
            SET("PMT_MERCHANT_NO = #{record.pmtMerchantNo,jdbcType=VARCHAR}");
        }
        
        if (record.getStatus() != null) {
            SET("STATUS = #{record.status,jdbcType=DECIMAL}");
        }
        
        if (record.getRetryTimes() != null) {
            SET("RETRY_TIMES = #{record.retryTimes,jdbcType=DECIMAL}");
        }
        
        if (record.getErrorCode() != null) {
            SET("ERROR_CODE = #{record.errorCode,jdbcType=VARCHAR}");
        }
        
        if (record.getErrorMsg() != null) {
            SET("ERROR_MSG = #{record.errorMsg,jdbcType=VARCHAR}");
        }
        
        if (record.getCallbackAddress() != null) {
            SET("CALLBACK_ADDRESS = #{record.callbackAddress,jdbcType=VARCHAR}");
        }
        
        if (record.getApplyTime() != null) {
            SET("APPLY_TIME = #{record.applyTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getCreateTime() != null) {
            SET("CREATE_TIME = #{record.createTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getUpdateTime() != null) {
            SET("UPDATE_TIME = #{record.updateTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getServiceType() != null) {
            SET("SERVICE_TYPE = #{record.serviceType,jdbcType=DECIMAL}");
        }
        
        if (record.getProductCode() != null) {
            SET("PRODUCT_CODE = #{record.productCode,jdbcType=VARCHAR}");
        }
        
        if (record.getPaymentCode() != null) {
            SET("PAYMENT_CODE = #{record.paymentCode,jdbcType=VARCHAR}");
        }
        
        if (record.getWithdrawTime() != null) {
            SET("WITHDRAW_TIME = #{record.withdrawTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getLoaningType() != null) {
            SET("LOANING_TYPE = #{record.loaningType,jdbcType=DECIMAL}");
        }
        
        if (record.getWdCost() != null) {
            SET("WD_COST = #{record.wdCost,jdbcType=DECIMAL}");
        }
        
        if (record.getMerchantBizId() != null) {
            SET("MERCHANT_BIZ_ID = #{record.merchantBizId,jdbcType=DECIMAL}");
        }
        
        if (record.getMcc() != null) {
            SET("MCC = #{record.mcc,jdbcType=VARCHAR}");
        }
        
        if (record.getLastLevelPromoterId() != null) {
            SET("LAST_LEVEL_PROMOTER_ID = #{record.lastLevelPromoterId,jdbcType=DECIMAL}");
        }
        
        if (record.getLastDetailId() != null) {
            SET("LAST_DETAIL_ID = #{record.lastDetailId,jdbcType=DECIMAL}");
        }
        
        if (record.getHasOaTxn() != null) {
            SET("HAS_OA_TXN = #{record.hasOaTxn,jdbcType=VARCHAR}");
        }
        
        if (record.getReqExtention() != null) {
            SET("REQ_EXTENTION = #{record.reqExtention,jdbcType=VARCHAR}");
        }
        
        applyWhere(example, true);
        return SQL();
    }

    /**
     * 根据Example对象更新出款业务请求表【WithdrawReqDO】对象信息
     *
     * @mbggenerated Wed Jul 05 10:53:07 CST 2017
     */
    public String updateByExample(Map<String, Object> parameter) {
        BEGIN();
        UPDATE("FW_WITHDRAW_REQ");
        
        SET("REQ_ID = #{record.reqId,jdbcType=DECIMAL}");
        SET("REQ_TYPE = #{record.reqType,jdbcType=DECIMAL}");
        SET("APP_ID = #{record.appId,jdbcType=VARCHAR}");
        SET("ORDER_NO = #{record.orderNo,jdbcType=VARCHAR}");
        SET("MEMBER_ID = #{record.memberId,jdbcType=VARCHAR}");
        SET("MERCHANT_NO = #{record.merchantNo,jdbcType=VARCHAR}");
        SET("MC_TYPE = #{record.mcType,jdbcType=VARCHAR}");
        SET("WITHDRAW_TYPE = #{record.withdrawType,jdbcType=DECIMAL}");
        SET("WITHDRAW_AMOUNT = #{record.withdrawAmount,jdbcType=DECIMAL}");
        SET("WITHDRAW_FEE = #{record.withdrawFee,jdbcType=DECIMAL}");
        SET("WITHDRAW_COST = #{record.withdrawCost,jdbcType=DECIMAL}");
        SET("ORIGINAL_AMOUNT = #{record.originalAmount,jdbcType=DECIMAL}");
        SET("SPLITTING_FEE = #{record.splittingFee,jdbcType=DECIMAL}");
        SET("SPLITTING_COST = #{record.splittingCost,jdbcType=DECIMAL}");
        SET("PMT_MEMBER_ID = #{record.pmtMemberId,jdbcType=VARCHAR}");
        SET("PMT_MERCHANT_NO = #{record.pmtMerchantNo,jdbcType=VARCHAR}");
        SET("STATUS = #{record.status,jdbcType=DECIMAL}");
        SET("RETRY_TIMES = #{record.retryTimes,jdbcType=DECIMAL}");
        SET("ERROR_CODE = #{record.errorCode,jdbcType=VARCHAR}");
        SET("ERROR_MSG = #{record.errorMsg,jdbcType=VARCHAR}");
        SET("CALLBACK_ADDRESS = #{record.callbackAddress,jdbcType=VARCHAR}");
        SET("APPLY_TIME = #{record.applyTime,jdbcType=TIMESTAMP}");
        SET("CREATE_TIME = #{record.createTime,jdbcType=TIMESTAMP}");
        SET("UPDATE_TIME = #{record.updateTime,jdbcType=TIMESTAMP}");
        SET("SERVICE_TYPE = #{record.serviceType,jdbcType=DECIMAL}");
        SET("PRODUCT_CODE = #{record.productCode,jdbcType=VARCHAR}");
        SET("PAYMENT_CODE = #{record.paymentCode,jdbcType=VARCHAR}");
        SET("WITHDRAW_TIME = #{record.withdrawTime,jdbcType=TIMESTAMP}");
        SET("LOANING_TYPE = #{record.loaningType,jdbcType=DECIMAL}");
        SET("WD_COST = #{record.wdCost,jdbcType=DECIMAL}");
        SET("MERCHANT_BIZ_ID = #{record.merchantBizId,jdbcType=DECIMAL}");
        SET("MCC = #{record.mcc,jdbcType=VARCHAR}");
        SET("LAST_LEVEL_PROMOTER_ID = #{record.lastLevelPromoterId,jdbcType=DECIMAL}");
        SET("LAST_DETAIL_ID = #{record.lastDetailId,jdbcType=DECIMAL}");
        SET("HAS_OA_TXN = #{record.hasOaTxn,jdbcType=VARCHAR}");
        SET("REQ_EXTENTION = #{record.reqExtention,jdbcType=VARCHAR}");
        
        WithdrawReqDOExample example = (WithdrawReqDOExample) parameter.get("example");
        applyWhere(example, true);
        return SQL();
    }

    /**
     * 根据主键更新出款业务请求表【WithdrawReqDO】对象信息，仅更新非空对象
     *
     * @mbggenerated Wed Jul 05 10:53:07 CST 2017
     */
    public String updateByPrimaryKeySelective(WithdrawReqDO record) {
        BEGIN();
        UPDATE("FW_WITHDRAW_REQ");
        
        if (record.getReqType() != null) {
            SET("REQ_TYPE = #{reqType,jdbcType=DECIMAL}");
        }
        
        if (record.getAppId() != null) {
            SET("APP_ID = #{appId,jdbcType=VARCHAR}");
        }
        
        if (record.getOrderNo() != null) {
            SET("ORDER_NO = #{orderNo,jdbcType=VARCHAR}");
        }
        
        if (record.getMemberId() != null) {
            SET("MEMBER_ID = #{memberId,jdbcType=VARCHAR}");
        }
        
        if (record.getMerchantNo() != null) {
            SET("MERCHANT_NO = #{merchantNo,jdbcType=VARCHAR}");
        }
        
        if (record.getMcType() != null) {
            SET("MC_TYPE = #{mcType,jdbcType=VARCHAR}");
        }
        
        if (record.getWithdrawType() != null) {
            SET("WITHDRAW_TYPE = #{withdrawType,jdbcType=DECIMAL}");
        }
        
        if (record.getWithdrawAmount() != null) {
            SET("WITHDRAW_AMOUNT = #{withdrawAmount,jdbcType=DECIMAL}");
        }
        
        if (record.getWithdrawFee() != null) {
            SET("WITHDRAW_FEE = #{withdrawFee,jdbcType=DECIMAL}");
        }
        
        if (record.getWithdrawCost() != null) {
            SET("WITHDRAW_COST = #{withdrawCost,jdbcType=DECIMAL}");
        }
        
        if (record.getOriginalAmount() != null) {
            SET("ORIGINAL_AMOUNT = #{originalAmount,jdbcType=DECIMAL}");
        }
        
        if (record.getSplittingFee() != null) {
            SET("SPLITTING_FEE = #{splittingFee,jdbcType=DECIMAL}");
        }
        
        if (record.getSplittingCost() != null) {
            SET("SPLITTING_COST = #{splittingCost,jdbcType=DECIMAL}");
        }
        
        if (record.getPmtMemberId() != null) {
            SET("PMT_MEMBER_ID = #{pmtMemberId,jdbcType=VARCHAR}");
        }
        
        if (record.getPmtMerchantNo() != null) {
            SET("PMT_MERCHANT_NO = #{pmtMerchantNo,jdbcType=VARCHAR}");
        }
        
        if (record.getStatus() != null) {
            SET("STATUS = #{status,jdbcType=DECIMAL}");
        }
        
        if (record.getRetryTimes() != null) {
            SET("RETRY_TIMES = #{retryTimes,jdbcType=DECIMAL}");
        }
        
        if (record.getErrorCode() != null) {
            SET("ERROR_CODE = #{errorCode,jdbcType=VARCHAR}");
        }
        
        if (record.getErrorMsg() != null) {
            SET("ERROR_MSG = #{errorMsg,jdbcType=VARCHAR}");
        }
        
        if (record.getCallbackAddress() != null) {
            SET("CALLBACK_ADDRESS = #{callbackAddress,jdbcType=VARCHAR}");
        }
        
        if (record.getApplyTime() != null) {
            SET("APPLY_TIME = #{applyTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getCreateTime() != null) {
            SET("CREATE_TIME = #{createTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getUpdateTime() != null) {
            SET("UPDATE_TIME = #{updateTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getServiceType() != null) {
            SET("SERVICE_TYPE = #{serviceType,jdbcType=DECIMAL}");
        }
        
        if (record.getProductCode() != null) {
            SET("PRODUCT_CODE = #{productCode,jdbcType=VARCHAR}");
        }
        
        if (record.getPaymentCode() != null) {
            SET("PAYMENT_CODE = #{paymentCode,jdbcType=VARCHAR}");
        }
        
        if (record.getWithdrawTime() != null) {
            SET("WITHDRAW_TIME = #{withdrawTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getLoaningType() != null) {
            SET("LOANING_TYPE = #{loaningType,jdbcType=DECIMAL}");
        }
        
        if (record.getWdCost() != null) {
            SET("WD_COST = #{wdCost,jdbcType=DECIMAL}");
        }
        
        if (record.getMerchantBizId() != null) {
            SET("MERCHANT_BIZ_ID = #{merchantBizId,jdbcType=DECIMAL}");
        }
        
        if (record.getMcc() != null) {
            SET("MCC = #{mcc,jdbcType=VARCHAR}");
        }
        
        if (record.getLastLevelPromoterId() != null) {
            SET("LAST_LEVEL_PROMOTER_ID = #{lastLevelPromoterId,jdbcType=DECIMAL}");
        }
        
        if (record.getLastDetailId() != null) {
            SET("LAST_DETAIL_ID = #{lastDetailId,jdbcType=DECIMAL}");
        }
        
        if (record.getHasOaTxn() != null) {
            SET("HAS_OA_TXN = #{hasOaTxn,jdbcType=VARCHAR}");
        }
        
        if (record.getReqExtention() != null) {
            SET("REQ_EXTENTION = #{reqExtention,jdbcType=VARCHAR}");
        }
        
        WHERE("REQ_ID = #{reqId,jdbcType=DECIMAL}");
        
        return SQL();
    }

    /**
     * This method corresponds to the database table FW_WITHDRAW_REQ
     *
     * @mbggenerated Wed Jul 05 10:53:07 CST 2017
     */
    protected void applyWhere(WithdrawReqDOExample example, boolean includeExamplePhrase) {
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
        
        if (example.getReqType() != null) {
            sb.append(" and  REQ_TYPE = #{reqType,jdbcType=DECIMAL} ");
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
        
        if (example.getMerchantNo() != null && !example.getMerchantNo().equals("") ) {
            sb.append(" and  MERCHANT_NO = #{merchantNo,jdbcType=VARCHAR} ");
        }
        
        if (example.getMcType() != null && !example.getMcType().equals("") ) {
            sb.append(" and  MC_TYPE = #{mcType,jdbcType=VARCHAR} ");
        }
        
        if (example.getWithdrawType() != null) {
            sb.append(" and  WITHDRAW_TYPE = #{withdrawType,jdbcType=DECIMAL} ");
        }
        
        if (example.getWithdrawAmount() != null) {
            sb.append(" and  WITHDRAW_AMOUNT = #{withdrawAmount,jdbcType=DECIMAL} ");
        }
        
        if (example.getWithdrawFee() != null) {
            sb.append(" and  WITHDRAW_FEE = #{withdrawFee,jdbcType=DECIMAL} ");
        }
        
        if (example.getWithdrawCost() != null) {
            sb.append(" and  WITHDRAW_COST = #{withdrawCost,jdbcType=DECIMAL} ");
        }
        
        if (example.getOriginalAmount() != null) {
            sb.append(" and  ORIGINAL_AMOUNT = #{originalAmount,jdbcType=DECIMAL} ");
        }
        
        if (example.getSplittingFee() != null) {
            sb.append(" and  SPLITTING_FEE = #{splittingFee,jdbcType=DECIMAL} ");
        }
        
        if (example.getSplittingCost() != null) {
            sb.append(" and  SPLITTING_COST = #{splittingCost,jdbcType=DECIMAL} ");
        }
        
        if (example.getPmtMemberId() != null && !example.getPmtMemberId().equals("") ) {
            sb.append(" and  PMT_MEMBER_ID = #{pmtMemberId,jdbcType=VARCHAR} ");
        }
        
        if (example.getPmtMerchantNo() != null && !example.getPmtMerchantNo().equals("") ) {
            sb.append(" and  PMT_MERCHANT_NO = #{pmtMerchantNo,jdbcType=VARCHAR} ");
        }
        
        if (example.getStatus() != null) {
            sb.append(" and  STATUS = #{status,jdbcType=DECIMAL} ");
        }
        
        if (example.getRetryTimes() != null) {
            sb.append(" and  RETRY_TIMES = #{retryTimes,jdbcType=DECIMAL} ");
        }
        
        if (example.getErrorCode() != null && !example.getErrorCode().equals("") ) {
            sb.append(" and  ERROR_CODE = #{errorCode,jdbcType=VARCHAR} ");
        }
        
        if (example.getErrorMsg() != null && !example.getErrorMsg().equals("") ) {
            sb.append(" and  ERROR_MSG = #{errorMsg,jdbcType=VARCHAR} ");
        }
        
        if (example.getCallbackAddress() != null && !example.getCallbackAddress().equals("") ) {
            sb.append(" and  CALLBACK_ADDRESS = #{callbackAddress,jdbcType=VARCHAR} ");
        }
        
        if (example.getApplyTime() != null) {
            sb.append(" and  APPLY_TIME = #{applyTime,jdbcType=TIMESTAMP} ");
        }
        
        if (example.getCreateTime() != null) {
            sb.append(" and  CREATE_TIME = #{createTime,jdbcType=TIMESTAMP} ");
        }
        
        if (example.getUpdateTime() != null) {
            sb.append(" and  UPDATE_TIME = #{updateTime,jdbcType=TIMESTAMP} ");
        }
        
        if (example.getServiceType() != null) {
            sb.append(" and  SERVICE_TYPE = #{serviceType,jdbcType=DECIMAL} ");
        }
        
        if (example.getProductCode() != null && !example.getProductCode().equals("") ) {
            sb.append(" and  PRODUCT_CODE = #{productCode,jdbcType=VARCHAR} ");
        }
        
        if (example.getPaymentCode() != null && !example.getPaymentCode().equals("") ) {
            sb.append(" and  PAYMENT_CODE = #{paymentCode,jdbcType=VARCHAR} ");
        }
        
        if (example.getWithdrawTime() != null) {
            sb.append(" and  WITHDRAW_TIME = #{withdrawTime,jdbcType=TIMESTAMP} ");
        }
        
        if (example.getLoaningType() != null) {
            sb.append(" and  LOANING_TYPE = #{loaningType,jdbcType=DECIMAL} ");
        }
        
        if (example.getWdCost() != null) {
            sb.append(" and  WD_COST = #{wdCost,jdbcType=DECIMAL} ");
        }
        
        if (example.getMerchantBizId() != null) {
            sb.append(" and  MERCHANT_BIZ_ID = #{merchantBizId,jdbcType=DECIMAL} ");
        }
        
        if (example.getMcc() != null && !example.getMcc().equals("") ) {
            sb.append(" and  MCC = #{mcc,jdbcType=VARCHAR} ");
        }
        
        if (example.getLastLevelPromoterId() != null) {
            sb.append(" and  LAST_LEVEL_PROMOTER_ID = #{lastLevelPromoterId,jdbcType=DECIMAL} ");
        }
        
        if (example.getLastDetailId() != null) {
            sb.append(" and  LAST_DETAIL_ID = #{lastDetailId,jdbcType=DECIMAL} ");
        }
        
        if (example.getHasOaTxn() != null && !example.getHasOaTxn().equals("") ) {
            sb.append(" and  HAS_OA_TXN = #{hasOaTxn,jdbcType=VARCHAR} ");
        }
        
        if (example.getReqExtention() != null && !example.getReqExtention().equals("") ) {
            sb.append(" and  REQ_EXTENTION = #{reqExtention,jdbcType=VARCHAR} ");
        }
        WHERE(sb.toString());
    }
}