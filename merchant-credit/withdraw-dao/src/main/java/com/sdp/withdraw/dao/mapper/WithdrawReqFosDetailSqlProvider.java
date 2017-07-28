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

import com.sdp.withdraw.dao.WithdrawReqFosDetailDO;
import com.sdp.withdraw.dao.WithdrawReqFosDetailDOExample.Criteria;
import com.sdp.withdraw.dao.WithdrawReqFosDetailDOExample.Criterion;
import com.sdp.withdraw.dao.WithdrawReqFosDetailDOExample;
import java.util.List;
import java.util.Map;

public class WithdrawReqFosDetailSqlProvider {

    /**
     * 根据Example对象取得出款业务调用FOS详细表【WithdrawReqFosDetailDO】对象count信息
     *
     * @mbggenerated Fri Mar 11 19:55:35 CST 2016
     */
    public String countByExample(WithdrawReqFosDetailDOExample example) {
        BEGIN();
        SELECT("count(*)");
        FROM("FW_WITHDRAW_REQ_FOS_DETAIL");
        applyWhere(example, false);
        return SQL();
    }

    /**
     * 根据Example对象删除出款业务调用FOS详细表【WithdrawReqFosDetailDO】对象信息
     *
     * @mbggenerated Fri Mar 11 19:55:35 CST 2016
     */
    public String deleteByExample(WithdrawReqFosDetailDOExample example) {
        BEGIN();
        DELETE_FROM("FW_WITHDRAW_REQ_FOS_DETAIL");
        applyWhere(example, false);
        return SQL();
    }

    /**
     * 添加出款业务调用FOS详细表【WithdrawReqFosDetailDO】对象信息,空值字段不插入
     *
     * @mbggenerated Fri Mar 11 19:55:35 CST 2016
     */
    public String insertSelective(WithdrawReqFosDetailDO record) {
        BEGIN();
        INSERT_INTO("FW_WITHDRAW_REQ_FOS_DETAIL");
        
        VALUES("DETAIL_ID", "#{detailId,jdbcType=DECIMAL}");
        
        if (record.getReqId() != null) {
            VALUES("REQ_ID", "#{reqId,jdbcType=DECIMAL}");
        }
        
        if (record.getProductCode() != null) {
            VALUES("PRODUCT_CODE", "#{productCode,jdbcType=VARCHAR}");
        }
        
        if (record.getPaymentCode() != null) {
            VALUES("PAYMENT_CODE", "#{paymentCode,jdbcType=VARCHAR}");
        }
        
        if (record.getRemitVoucherNo() != null) {
            VALUES("REMIT_VOUCHER_NO", "#{remitVoucherNo,jdbcType=VARCHAR}");
        }
        
        if (record.getPayerMemberId() != null) {
            VALUES("PAYER_MEMBER_ID", "#{payerMemberId,jdbcType=VARCHAR}");
        }
        
        if (record.getIsNeedCountFee() != null) {
            VALUES("IS_NEED_COUNT_FEE", "#{isNeedCountFee,jdbcType=DECIMAL}");
        }
        
        if (record.getPayerFee() != null) {
            VALUES("PAYER_FEE", "#{payerFee,jdbcType=DECIMAL}");
        }
        
        if (record.getPayeeFee() != null) {
            VALUES("PAYEE_FEE", "#{payeeFee,jdbcType=DECIMAL}");
        }
        
        if (record.getIsPermitPricingErr() != null) {
            VALUES("IS_PERMIT_PRICING_ERR", "#{isPermitPricingErr,jdbcType=DECIMAL}");
        }
        
        if (record.getPayerAccountNo() != null) {
            VALUES("PAYER_ACCOUNT_NO", "#{payerAccountNo,jdbcType=VARCHAR}");
        }
        
        if (record.getBankCode() != null) {
            VALUES("BANK_CODE", "#{bankCode,jdbcType=VARCHAR}");
        }
        
        if (record.getBankName() != null) {
            VALUES("BANK_NAME", "#{bankName,jdbcType=VARCHAR}");
        }
        
        if (record.getBankBranch() != null) {
            VALUES("BANK_BRANCH", "#{bankBranch,jdbcType=VARCHAR}");
        }
        
        if (record.getBankLineno() != null) {
            VALUES("BANK_LINENO", "#{bankLineno,jdbcType=VARCHAR}");
        }
        
        if (record.getBankProvince() != null) {
            VALUES("BANK_PROVINCE", "#{bankProvince,jdbcType=VARCHAR}");
        }
        
        if (record.getBankCity() != null) {
            VALUES("BANK_CITY", "#{bankCity,jdbcType=VARCHAR}");
        }
        
        if (record.getPayeeName() != null) {
            VALUES("PAYEE_NAME", "#{payeeName,jdbcType=VARCHAR}");
        }
        
        if (record.getPayeeCardNo() != null) {
            VALUES("PAYEE_CARD_NO", "#{payeeCardNo,jdbcType=VARCHAR}");
        }
        
        if (record.getPayeePurpose() != null) {
            VALUES("PAYEE_PURPOSE", "#{payeePurpose,jdbcType=VARCHAR}");
        }
        
        if (record.getCardType() != null) {
            VALUES("CARD_TYPE", "#{cardType,jdbcType=VARCHAR}");
        }
        
        if (record.getCompanyOrPersonal() != null) {
            VALUES("COMPANY_OR_PERSONAL", "#{companyOrPersonal,jdbcType=VARCHAR}");
        }
        
        if (record.getGmtBizInitiate() != null) {
            VALUES("GMT_BIZ_INITIATE", "#{gmtBizInitiate,jdbcType=TIMESTAMP}");
        }
        
        if (record.getGmtPaymentInitiate() != null) {
            VALUES("GMT_PAYMENT_INITIATE", "#{gmtPaymentInitiate,jdbcType=TIMESTAMP}");
        }
        
        if (record.getRemitAmount() != null) {
            VALUES("REMIT_AMOUNT", "#{remitAmount,jdbcType=DECIMAL}");
        }
        
        if (record.getCallbackAddress() != null) {
            VALUES("CALLBACK_ADDRESS", "#{callbackAddress,jdbcType=VARCHAR}");
        }
        
        if (record.getMemo() != null) {
            VALUES("MEMO", "#{memo,jdbcType=VARCHAR}");
        }
        
        if (record.getCurrency() != null) {
            VALUES("CURRENCY", "#{currency,jdbcType=VARCHAR}");
        }
        
        if (record.getReqExtention() != null) {
            VALUES("REQ_EXTENTION", "#{reqExtention,jdbcType=VARCHAR}");
        }
        
        if (record.getWithdrawStatus() != null) {
            VALUES("WITHDRAW_STATUS", "#{withdrawStatus,jdbcType=VARCHAR}");
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
        
        return SQL();
    }

    /**
     * 根据Example对象查询得到出款业务调用FOS详细表【WithdrawReqFosDetailDO】对象列表信息
     *
     * @mbggenerated Fri Mar 11 19:55:36 CST 2016
     */
    public String selectByExample(WithdrawReqFosDetailDOExample example) {
        BEGIN();
        if (example != null && example.isDistinct()) {
            SELECT_DISTINCT("DETAIL_ID");
        } else {
            SELECT("DETAIL_ID");
        }
        SELECT("REQ_ID");
        SELECT("PRODUCT_CODE");
        SELECT("PAYMENT_CODE");
        SELECT("REMIT_VOUCHER_NO");
        SELECT("PAYER_MEMBER_ID");
        SELECT("IS_NEED_COUNT_FEE");
        SELECT("PAYER_FEE");
        SELECT("PAYEE_FEE");
        SELECT("IS_PERMIT_PRICING_ERR");
        SELECT("PAYER_ACCOUNT_NO");
        SELECT("BANK_CODE");
        SELECT("BANK_NAME");
        SELECT("BANK_BRANCH");
        SELECT("BANK_LINENO");
        SELECT("BANK_PROVINCE");
        SELECT("BANK_CITY");
        SELECT("PAYEE_NAME");
        SELECT("PAYEE_CARD_NO");
        SELECT("PAYEE_PURPOSE");
        SELECT("CARD_TYPE");
        SELECT("COMPANY_OR_PERSONAL");
        SELECT("GMT_BIZ_INITIATE");
        SELECT("GMT_PAYMENT_INITIATE");
        SELECT("REMIT_AMOUNT");
        SELECT("CALLBACK_ADDRESS");
        SELECT("MEMO");
        SELECT("CURRENCY");
        SELECT("REQ_EXTENTION");
        SELECT("WITHDRAW_STATUS");
        SELECT("RETURN_CODE");
        SELECT("RETURN_MSG");
        SELECT("EXTENTION");
        SELECT("CREATE_TIME");
        SELECT("UPDATE_TIME");
        FROM("FW_WITHDRAW_REQ_FOS_DETAIL");
        applyWhere(example, false);
        
        if (example != null && example.getOrderByClause() != null) {
            ORDER_BY(example.getOrderByClause());
        }
        
        return SQL();
    }

    /**
     * 根据Query对象分页查询出款业务调用FOS详细表【WithdrawReqFosDetailDO】对象列表信息
     *
     * @mbggenerated Fri Mar 11 19:55:36 CST 2016
     */
    public String selectByQuery(WithdrawReqFosDetailDOExample example) {
        BEGIN();
        if (example != null && example.isDistinct()) {
            SELECT_DISTINCT("DETAIL_ID");
        } else {
            SELECT("DETAIL_ID");
        }
        SELECT("REQ_ID");
        SELECT("PRODUCT_CODE");
        SELECT("PAYMENT_CODE");
        SELECT("REMIT_VOUCHER_NO");
        SELECT("PAYER_MEMBER_ID");
        SELECT("IS_NEED_COUNT_FEE");
        SELECT("PAYER_FEE");
        SELECT("PAYEE_FEE");
        SELECT("IS_PERMIT_PRICING_ERR");
        SELECT("PAYER_ACCOUNT_NO");
        SELECT("BANK_CODE");
        SELECT("BANK_NAME");
        SELECT("BANK_BRANCH");
        SELECT("BANK_LINENO");
        SELECT("BANK_PROVINCE");
        SELECT("BANK_CITY");
        SELECT("PAYEE_NAME");
        SELECT("PAYEE_CARD_NO");
        SELECT("PAYEE_PURPOSE");
        SELECT("CARD_TYPE");
        SELECT("COMPANY_OR_PERSONAL");
        SELECT("GMT_BIZ_INITIATE");
        SELECT("GMT_PAYMENT_INITIATE");
        SELECT("REMIT_AMOUNT");
        SELECT("CALLBACK_ADDRESS");
        SELECT("MEMO");
        SELECT("CURRENCY");
        SELECT("REQ_EXTENTION");
        SELECT("WITHDRAW_STATUS");
        SELECT("RETURN_CODE");
        SELECT("RETURN_MSG");
        SELECT("EXTENTION");
        SELECT("CREATE_TIME");
        SELECT("UPDATE_TIME");
        FROM("FW_WITHDRAW_REQ_FOS_DETAIL");
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
     * 根据Example对象更新出款业务调用FOS详细表【WithdrawReqFosDetailDO】对象信息，仅更新非空字段
     *
     * @mbggenerated Fri Mar 11 19:55:36 CST 2016
     */
    public String updateByExampleSelective(Map<String, Object> parameter) {
        WithdrawReqFosDetailDO record = (WithdrawReqFosDetailDO) parameter.get("record");
        WithdrawReqFosDetailDOExample example = (WithdrawReqFosDetailDOExample) parameter.get("example");
        
        BEGIN();
        UPDATE("FW_WITHDRAW_REQ_FOS_DETAIL");
        
        if (record.getDetailId() != null) {
            SET("DETAIL_ID = #{record.detailId,jdbcType=DECIMAL}");
        }
        
        if (record.getReqId() != null) {
            SET("REQ_ID = #{record.reqId,jdbcType=DECIMAL}");
        }
        
        if (record.getProductCode() != null) {
            SET("PRODUCT_CODE = #{record.productCode,jdbcType=VARCHAR}");
        }
        
        if (record.getPaymentCode() != null) {
            SET("PAYMENT_CODE = #{record.paymentCode,jdbcType=VARCHAR}");
        }
        
        if (record.getRemitVoucherNo() != null) {
            SET("REMIT_VOUCHER_NO = #{record.remitVoucherNo,jdbcType=VARCHAR}");
        }
        
        if (record.getPayerMemberId() != null) {
            SET("PAYER_MEMBER_ID = #{record.payerMemberId,jdbcType=VARCHAR}");
        }
        
        if (record.getIsNeedCountFee() != null) {
            SET("IS_NEED_COUNT_FEE = #{record.isNeedCountFee,jdbcType=DECIMAL}");
        }
        
        if (record.getPayerFee() != null) {
            SET("PAYER_FEE = #{record.payerFee,jdbcType=DECIMAL}");
        }
        
        if (record.getPayeeFee() != null) {
            SET("PAYEE_FEE = #{record.payeeFee,jdbcType=DECIMAL}");
        }
        
        if (record.getIsPermitPricingErr() != null) {
            SET("IS_PERMIT_PRICING_ERR = #{record.isPermitPricingErr,jdbcType=DECIMAL}");
        }
        
        if (record.getPayerAccountNo() != null) {
            SET("PAYER_ACCOUNT_NO = #{record.payerAccountNo,jdbcType=VARCHAR}");
        }
        
        if (record.getBankCode() != null) {
            SET("BANK_CODE = #{record.bankCode,jdbcType=VARCHAR}");
        }
        
        if (record.getBankName() != null) {
            SET("BANK_NAME = #{record.bankName,jdbcType=VARCHAR}");
        }
        
        if (record.getBankBranch() != null) {
            SET("BANK_BRANCH = #{record.bankBranch,jdbcType=VARCHAR}");
        }
        
        if (record.getBankLineno() != null) {
            SET("BANK_LINENO = #{record.bankLineno,jdbcType=VARCHAR}");
        }
        
        if (record.getBankProvince() != null) {
            SET("BANK_PROVINCE = #{record.bankProvince,jdbcType=VARCHAR}");
        }
        
        if (record.getBankCity() != null) {
            SET("BANK_CITY = #{record.bankCity,jdbcType=VARCHAR}");
        }
        
        if (record.getPayeeName() != null) {
            SET("PAYEE_NAME = #{record.payeeName,jdbcType=VARCHAR}");
        }
        
        if (record.getPayeeCardNo() != null) {
            SET("PAYEE_CARD_NO = #{record.payeeCardNo,jdbcType=VARCHAR}");
        }
        
        if (record.getPayeePurpose() != null) {
            SET("PAYEE_PURPOSE = #{record.payeePurpose,jdbcType=VARCHAR}");
        }
        
        if (record.getCardType() != null) {
            SET("CARD_TYPE = #{record.cardType,jdbcType=VARCHAR}");
        }
        
        if (record.getCompanyOrPersonal() != null) {
            SET("COMPANY_OR_PERSONAL = #{record.companyOrPersonal,jdbcType=VARCHAR}");
        }
        
        if (record.getGmtBizInitiate() != null) {
            SET("GMT_BIZ_INITIATE = #{record.gmtBizInitiate,jdbcType=TIMESTAMP}");
        }
        
        if (record.getGmtPaymentInitiate() != null) {
            SET("GMT_PAYMENT_INITIATE = #{record.gmtPaymentInitiate,jdbcType=TIMESTAMP}");
        }
        
        if (record.getRemitAmount() != null) {
            SET("REMIT_AMOUNT = #{record.remitAmount,jdbcType=DECIMAL}");
        }
        
        if (record.getCallbackAddress() != null) {
            SET("CALLBACK_ADDRESS = #{record.callbackAddress,jdbcType=VARCHAR}");
        }
        
        if (record.getMemo() != null) {
            SET("MEMO = #{record.memo,jdbcType=VARCHAR}");
        }
        
        if (record.getCurrency() != null) {
            SET("CURRENCY = #{record.currency,jdbcType=VARCHAR}");
        }
        
        if (record.getReqExtention() != null) {
            SET("REQ_EXTENTION = #{record.reqExtention,jdbcType=VARCHAR}");
        }
        
        if (record.getWithdrawStatus() != null) {
            SET("WITHDRAW_STATUS = #{record.withdrawStatus,jdbcType=VARCHAR}");
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
        
        applyWhere(example, true);
        return SQL();
    }

    /**
     * 根据Example对象更新出款业务调用FOS详细表【WithdrawReqFosDetailDO】对象信息
     *
     * @mbggenerated Fri Mar 11 19:55:36 CST 2016
     */
    public String updateByExample(Map<String, Object> parameter) {
        BEGIN();
        UPDATE("FW_WITHDRAW_REQ_FOS_DETAIL");
        
        SET("DETAIL_ID = #{record.detailId,jdbcType=DECIMAL}");
        SET("REQ_ID = #{record.reqId,jdbcType=DECIMAL}");
        SET("PRODUCT_CODE = #{record.productCode,jdbcType=VARCHAR}");
        SET("PAYMENT_CODE = #{record.paymentCode,jdbcType=VARCHAR}");
        SET("REMIT_VOUCHER_NO = #{record.remitVoucherNo,jdbcType=VARCHAR}");
        SET("PAYER_MEMBER_ID = #{record.payerMemberId,jdbcType=VARCHAR}");
        SET("IS_NEED_COUNT_FEE = #{record.isNeedCountFee,jdbcType=DECIMAL}");
        SET("PAYER_FEE = #{record.payerFee,jdbcType=DECIMAL}");
        SET("PAYEE_FEE = #{record.payeeFee,jdbcType=DECIMAL}");
        SET("IS_PERMIT_PRICING_ERR = #{record.isPermitPricingErr,jdbcType=DECIMAL}");
        SET("PAYER_ACCOUNT_NO = #{record.payerAccountNo,jdbcType=VARCHAR}");
        SET("BANK_CODE = #{record.bankCode,jdbcType=VARCHAR}");
        SET("BANK_NAME = #{record.bankName,jdbcType=VARCHAR}");
        SET("BANK_BRANCH = #{record.bankBranch,jdbcType=VARCHAR}");
        SET("BANK_LINENO = #{record.bankLineno,jdbcType=VARCHAR}");
        SET("BANK_PROVINCE = #{record.bankProvince,jdbcType=VARCHAR}");
        SET("BANK_CITY = #{record.bankCity,jdbcType=VARCHAR}");
        SET("PAYEE_NAME = #{record.payeeName,jdbcType=VARCHAR}");
        SET("PAYEE_CARD_NO = #{record.payeeCardNo,jdbcType=VARCHAR}");
        SET("PAYEE_PURPOSE = #{record.payeePurpose,jdbcType=VARCHAR}");
        SET("CARD_TYPE = #{record.cardType,jdbcType=VARCHAR}");
        SET("COMPANY_OR_PERSONAL = #{record.companyOrPersonal,jdbcType=VARCHAR}");
        SET("GMT_BIZ_INITIATE = #{record.gmtBizInitiate,jdbcType=TIMESTAMP}");
        SET("GMT_PAYMENT_INITIATE = #{record.gmtPaymentInitiate,jdbcType=TIMESTAMP}");
        SET("REMIT_AMOUNT = #{record.remitAmount,jdbcType=DECIMAL}");
        SET("CALLBACK_ADDRESS = #{record.callbackAddress,jdbcType=VARCHAR}");
        SET("MEMO = #{record.memo,jdbcType=VARCHAR}");
        SET("CURRENCY = #{record.currency,jdbcType=VARCHAR}");
        SET("REQ_EXTENTION = #{record.reqExtention,jdbcType=VARCHAR}");
        SET("WITHDRAW_STATUS = #{record.withdrawStatus,jdbcType=VARCHAR}");
        SET("RETURN_CODE = #{record.returnCode,jdbcType=VARCHAR}");
        SET("RETURN_MSG = #{record.returnMsg,jdbcType=VARCHAR}");
        SET("EXTENTION = #{record.extention,jdbcType=VARCHAR}");
        SET("CREATE_TIME = #{record.createTime,jdbcType=TIMESTAMP}");
        SET("UPDATE_TIME = #{record.updateTime,jdbcType=TIMESTAMP}");
        
        WithdrawReqFosDetailDOExample example = (WithdrawReqFosDetailDOExample) parameter.get("example");
        applyWhere(example, true);
        return SQL();
    }

    /**
     * 根据主键更新出款业务调用FOS详细表【WithdrawReqFosDetailDO】对象信息，仅更新非空对象
     *
     * @mbggenerated Fri Mar 11 19:55:36 CST 2016
     */
    public String updateByPrimaryKeySelective(WithdrawReqFosDetailDO record) {
        BEGIN();
        UPDATE("FW_WITHDRAW_REQ_FOS_DETAIL");
        
        if (record.getReqId() != null) {
            SET("REQ_ID = #{reqId,jdbcType=DECIMAL}");
        }
        
        if (record.getProductCode() != null) {
            SET("PRODUCT_CODE = #{productCode,jdbcType=VARCHAR}");
        }
        
        if (record.getPaymentCode() != null) {
            SET("PAYMENT_CODE = #{paymentCode,jdbcType=VARCHAR}");
        }
        
        if (record.getRemitVoucherNo() != null) {
            SET("REMIT_VOUCHER_NO = #{remitVoucherNo,jdbcType=VARCHAR}");
        }
        
        if (record.getPayerMemberId() != null) {
            SET("PAYER_MEMBER_ID = #{payerMemberId,jdbcType=VARCHAR}");
        }
        
        if (record.getIsNeedCountFee() != null) {
            SET("IS_NEED_COUNT_FEE = #{isNeedCountFee,jdbcType=DECIMAL}");
        }
        
        if (record.getPayerFee() != null) {
            SET("PAYER_FEE = #{payerFee,jdbcType=DECIMAL}");
        }
        
        if (record.getPayeeFee() != null) {
            SET("PAYEE_FEE = #{payeeFee,jdbcType=DECIMAL}");
        }
        
        if (record.getIsPermitPricingErr() != null) {
            SET("IS_PERMIT_PRICING_ERR = #{isPermitPricingErr,jdbcType=DECIMAL}");
        }
        
        if (record.getPayerAccountNo() != null) {
            SET("PAYER_ACCOUNT_NO = #{payerAccountNo,jdbcType=VARCHAR}");
        }
        
        if (record.getBankCode() != null) {
            SET("BANK_CODE = #{bankCode,jdbcType=VARCHAR}");
        }
        
        if (record.getBankName() != null) {
            SET("BANK_NAME = #{bankName,jdbcType=VARCHAR}");
        }
        
        if (record.getBankBranch() != null) {
            SET("BANK_BRANCH = #{bankBranch,jdbcType=VARCHAR}");
        }
        
        if (record.getBankLineno() != null) {
            SET("BANK_LINENO = #{bankLineno,jdbcType=VARCHAR}");
        }
        
        if (record.getBankProvince() != null) {
            SET("BANK_PROVINCE = #{bankProvince,jdbcType=VARCHAR}");
        }
        
        if (record.getBankCity() != null) {
            SET("BANK_CITY = #{bankCity,jdbcType=VARCHAR}");
        }
        
        if (record.getPayeeName() != null) {
            SET("PAYEE_NAME = #{payeeName,jdbcType=VARCHAR}");
        }
        
        if (record.getPayeeCardNo() != null) {
            SET("PAYEE_CARD_NO = #{payeeCardNo,jdbcType=VARCHAR}");
        }
        
        if (record.getPayeePurpose() != null) {
            SET("PAYEE_PURPOSE = #{payeePurpose,jdbcType=VARCHAR}");
        }
        
        if (record.getCardType() != null) {
            SET("CARD_TYPE = #{cardType,jdbcType=VARCHAR}");
        }
        
        if (record.getCompanyOrPersonal() != null) {
            SET("COMPANY_OR_PERSONAL = #{companyOrPersonal,jdbcType=VARCHAR}");
        }
        
        if (record.getGmtBizInitiate() != null) {
            SET("GMT_BIZ_INITIATE = #{gmtBizInitiate,jdbcType=TIMESTAMP}");
        }
        
        if (record.getGmtPaymentInitiate() != null) {
            SET("GMT_PAYMENT_INITIATE = #{gmtPaymentInitiate,jdbcType=TIMESTAMP}");
        }
        
        if (record.getRemitAmount() != null) {
            SET("REMIT_AMOUNT = #{remitAmount,jdbcType=DECIMAL}");
        }
        
        if (record.getCallbackAddress() != null) {
            SET("CALLBACK_ADDRESS = #{callbackAddress,jdbcType=VARCHAR}");
        }
        
        if (record.getMemo() != null) {
            SET("MEMO = #{memo,jdbcType=VARCHAR}");
        }
        
        if (record.getCurrency() != null) {
            SET("CURRENCY = #{currency,jdbcType=VARCHAR}");
        }
        
        if (record.getReqExtention() != null) {
            SET("REQ_EXTENTION = #{reqExtention,jdbcType=VARCHAR}");
        }
        
        if (record.getWithdrawStatus() != null) {
            SET("WITHDRAW_STATUS = #{withdrawStatus,jdbcType=VARCHAR}");
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
        
        WHERE("DETAIL_ID = #{detailId,jdbcType=DECIMAL}");
        
        return SQL();
    }

    /**
     * This method corresponds to the database table FW_WITHDRAW_REQ_FOS_DETAIL
     *
     * @mbggenerated Fri Mar 11 19:55:36 CST 2016
     */
    protected void applyWhere(WithdrawReqFosDetailDOExample example, boolean includeExamplePhrase) {
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
        
        if (example.getDetailId() != null) {
            sb.append(" and  DETAIL_ID = #{detailId,jdbcType=DECIMAL} ");
        }
        
        if (example.getReqId() != null) {
            sb.append(" and  REQ_ID = #{reqId,jdbcType=DECIMAL} ");
        }
        
        if (example.getProductCode() != null && !example.getProductCode().equals("") ) {
            sb.append(" and  PRODUCT_CODE = #{productCode,jdbcType=VARCHAR} ");
        }
        
        if (example.getPaymentCode() != null && !example.getPaymentCode().equals("") ) {
            sb.append(" and  PAYMENT_CODE = #{paymentCode,jdbcType=VARCHAR} ");
        }
        
        if (example.getRemitVoucherNo() != null && !example.getRemitVoucherNo().equals("") ) {
            sb.append(" and  REMIT_VOUCHER_NO = #{remitVoucherNo,jdbcType=VARCHAR} ");
        }
        
        if (example.getPayerMemberId() != null && !example.getPayerMemberId().equals("") ) {
            sb.append(" and  PAYER_MEMBER_ID = #{payerMemberId,jdbcType=VARCHAR} ");
        }
        
        if (example.getIsNeedCountFee() != null) {
            sb.append(" and  IS_NEED_COUNT_FEE = #{isNeedCountFee,jdbcType=DECIMAL} ");
        }
        
        if (example.getPayerFee() != null) {
            sb.append(" and  PAYER_FEE = #{payerFee,jdbcType=DECIMAL} ");
        }
        
        if (example.getPayeeFee() != null) {
            sb.append(" and  PAYEE_FEE = #{payeeFee,jdbcType=DECIMAL} ");
        }
        
        if (example.getIsPermitPricingErr() != null) {
            sb.append(" and  IS_PERMIT_PRICING_ERR = #{isPermitPricingErr,jdbcType=DECIMAL} ");
        }
        
        if (example.getPayerAccountNo() != null && !example.getPayerAccountNo().equals("") ) {
            sb.append(" and  PAYER_ACCOUNT_NO = #{payerAccountNo,jdbcType=VARCHAR} ");
        }
        
        if (example.getBankCode() != null && !example.getBankCode().equals("") ) {
            sb.append(" and  BANK_CODE = #{bankCode,jdbcType=VARCHAR} ");
        }
        
        if (example.getBankName() != null && !example.getBankName().equals("") ) {
            sb.append(" and  BANK_NAME = #{bankName,jdbcType=VARCHAR} ");
        }
        
        if (example.getBankBranch() != null && !example.getBankBranch().equals("") ) {
            sb.append(" and  BANK_BRANCH = #{bankBranch,jdbcType=VARCHAR} ");
        }
        
        if (example.getBankLineno() != null && !example.getBankLineno().equals("") ) {
            sb.append(" and  BANK_LINENO = #{bankLineno,jdbcType=VARCHAR} ");
        }
        
        if (example.getBankProvince() != null && !example.getBankProvince().equals("") ) {
            sb.append(" and  BANK_PROVINCE = #{bankProvince,jdbcType=VARCHAR} ");
        }
        
        if (example.getBankCity() != null && !example.getBankCity().equals("") ) {
            sb.append(" and  BANK_CITY = #{bankCity,jdbcType=VARCHAR} ");
        }
        
        if (example.getPayeeName() != null && !example.getPayeeName().equals("") ) {
            sb.append(" and  PAYEE_NAME = #{payeeName,jdbcType=VARCHAR} ");
        }
        
        if (example.getPayeeCardNo() != null && !example.getPayeeCardNo().equals("") ) {
            sb.append(" and  PAYEE_CARD_NO = #{payeeCardNo,jdbcType=VARCHAR} ");
        }
        
        if (example.getPayeePurpose() != null && !example.getPayeePurpose().equals("") ) {
            sb.append(" and  PAYEE_PURPOSE = #{payeePurpose,jdbcType=VARCHAR} ");
        }
        
        if (example.getCardType() != null && !example.getCardType().equals("") ) {
            sb.append(" and  CARD_TYPE = #{cardType,jdbcType=VARCHAR} ");
        }
        
        if (example.getCompanyOrPersonal() != null && !example.getCompanyOrPersonal().equals("") ) {
            sb.append(" and  COMPANY_OR_PERSONAL = #{companyOrPersonal,jdbcType=VARCHAR} ");
        }
        
        if (example.getGmtBizInitiate() != null) {
            sb.append(" and  GMT_BIZ_INITIATE = #{gmtBizInitiate,jdbcType=TIMESTAMP} ");
        }
        
        if (example.getGmtPaymentInitiate() != null) {
            sb.append(" and  GMT_PAYMENT_INITIATE = #{gmtPaymentInitiate,jdbcType=TIMESTAMP} ");
        }
        
        if (example.getRemitAmount() != null) {
            sb.append(" and  REMIT_AMOUNT = #{remitAmount,jdbcType=DECIMAL} ");
        }
        
        if (example.getCallbackAddress() != null && !example.getCallbackAddress().equals("") ) {
            sb.append(" and  CALLBACK_ADDRESS = #{callbackAddress,jdbcType=VARCHAR} ");
        }
        
        if (example.getMemo() != null && !example.getMemo().equals("") ) {
            sb.append(" and  MEMO = #{memo,jdbcType=VARCHAR} ");
        }
        
        if (example.getCurrency() != null && !example.getCurrency().equals("") ) {
            sb.append(" and  CURRENCY = #{currency,jdbcType=VARCHAR} ");
        }
        
        if (example.getReqExtention() != null && !example.getReqExtention().equals("") ) {
            sb.append(" and  REQ_EXTENTION = #{reqExtention,jdbcType=VARCHAR} ");
        }
        
        if (example.getWithdrawStatus() != null && !example.getWithdrawStatus().equals("") ) {
            sb.append(" and  WITHDRAW_STATUS = #{withdrawStatus,jdbcType=VARCHAR} ");
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
        WHERE(sb.toString());
    }
}