package com.sdp.mc.merchant.dao;

import com.sdp.emall.common.dao.BaseDO;
import java.math.BigDecimal;
import java.util.Date;

public class MerchantFsReq extends BaseDO {
    /**
     * This field corresponds to the database column TB_MERCHANT_FS_REQ.MFQ_ID
     * column comments null
     *
     * @mbggenerated Fri Dec 25 17:57:04 CST 2015
     */
    private Long mfqId;

    /**
     * This field corresponds to the database column TB_MERCHANT_FS_REQ.MERCHANT_ID
     * column comments null
     *
     * @mbggenerated Fri Dec 25 17:57:04 CST 2015
     */
    private Long merchantId;

    /**
     * This field corresponds to the database column TB_MERCHANT_FS_REQ.TYPE
     * column comments 0：手动，1：自动
     *
     * @mbggenerated Fri Dec 25 17:57:04 CST 2015
     */
    private Integer type;

    /**
     * This field corresponds to the database column TB_MERCHANT_FS_REQ.STATUS
     * column comments "-1"：初始
"00"： "成功"
"01"： "商户无权限，或额度配制错误"
"02"："代理商无权限，或额度配制错误"
"03"："商户额度不足"
"04"： "代理商额度不足"
"05"： "存在非法订单（存在被暂停、或者已生成结算单、或退货等不允许快速结算的订单）"
"06"："请求订单数太多（最多999）"
"07"："入账失败"
"08"："结算失败"
"09"："提交金额低于下限"
"10"："拒绝"
"11"："当前时段不允许发起快速结算"
"12"："商户快速结算规则未配置或已失效"
"13"："不支持的结算卡机构"
"14"："不支持的卡类型"
"15"："不支持的卡产品编号"
"16"："当前时间不在结算规则生效时间范围内"
"17"："提现失败"
"99"："未知错误"
     *
     * @mbggenerated Fri Dec 25 17:57:04 CST 2015
     */
    private Integer status;

    /**
     * This field corresponds to the database column TB_MERCHANT_FS_REQ.AMOUNT
     * column comments 待结算总额
     *
     * @mbggenerated Fri Dec 25 17:57:04 CST 2015
     */
    private String amount;

    /**
     * This field corresponds to the database column TB_MERCHANT_FS_REQ.TRADE_CNT
     * column comments 交易笔数
     *
     * @mbggenerated Fri Dec 25 17:57:04 CST 2015
     */
    private Long tradeCnt;

    /**
     * This field corresponds to the database column TB_MERCHANT_FS_REQ.SETTLE_FEE
     * column comments 快速结算费率
     *
     * @mbggenerated Fri Dec 25 17:57:04 CST 2015
     */
    private BigDecimal settleFee;

    /**
     * This field corresponds to the database column TB_MERCHANT_FS_REQ.CREATE_TIME
     * column comments null
     *
     * @mbggenerated Fri Dec 25 17:57:04 CST 2015
     */
    private Date createTime;

    /**
     * This field corresponds to the database column TB_MERCHANT_FS_REQ.UPDATE_TIME
     * column comments null
     *
     * @mbggenerated Fri Dec 25 17:57:04 CST 2015
     */
    private Date updateTime;

    /**
     * This field corresponds to the database column TB_MERCHANT_FS_REQ.MERCHANT_NO
     * column comments 商户号
     *
     * @mbggenerated Fri Dec 25 17:57:04 CST 2015
     */
    private String merchantNo;

    /**
     * This field corresponds to the database column TB_MERCHANT_FS_REQ.SETTLE_BILL_NO
     * column comments MSP结算单号
     *
     * @mbggenerated Fri Dec 25 17:57:04 CST 2015
     */
    private String settleBillNo;

    /**
     * This field corresponds to the database column TB_MERCHANT_FS_REQ.FUND_OUT_TIME
     * column comments 结算时间
     *
     * @mbggenerated Fri Dec 25 17:57:04 CST 2015
     */
    private Date fundOutTime;

    /**
     * This field corresponds to the database column TB_MERCHANT_FS_REQ.SETTLE_STATUS
     * column comments 0-待出款,1-已出款,2-转至下期
     *
     * @mbggenerated Fri Dec 25 17:57:04 CST 2015
     */
    private String settleStatus;

    /**
     * This field corresponds to the database column TB_MERCHANT_FS_REQ.PAYMENT_ORDER_NO
     * column comments fos转账订单号
     *
     * @mbggenerated Fri Dec 25 17:57:04 CST 2015
     */
    private String paymentOrderNo;

    /**
     * This field corresponds to the database column TB_MERCHANT_FS_REQ.PAYMENT_TIME
     * column comments fos转账时间
     *
     * @mbggenerated Fri Dec 25 17:57:04 CST 2015
     */
    private Date paymentTime;

    /**
     * This field corresponds to the database column TB_MERCHANT_FS_REQ.PAYMENT_STATUS
     * column comments 支付状态,S-成功,F-失败
     *
     * @mbggenerated Fri Dec 25 17:57:04 CST 2015
     */
    private String paymentStatus;

    /**
     * This field corresponds to the database column TB_MERCHANT_FS_REQ.MERCHANT_MEMBER_ID
     * column comments 商户会员号
     *
     * @mbggenerated Fri Dec 25 17:57:04 CST 2015
     */
    private String merchantMemberId;

    /**
     * This field corresponds to the database column TB_MERCHANT_FS_REQ.MERCHANT_ACCOUNT_NO
     * column comments 商户储值帐号
     *
     * @mbggenerated Fri Dec 25 17:57:04 CST 2015
     */
    private String merchantAccountNo;

    /**
     * This field corresponds to the database column TB_MERCHANT_FS_REQ.MERCHANT_ACCOUNT_TYPE
     * column comments 储值帐号类型
     *
     * @mbggenerated Fri Dec 25 17:57:04 CST 2015
     */
    private String merchantAccountType;

    /**
     * This field corresponds to the database column TB_MERCHANT_FS_REQ.SUB_STATUS
     * column comments 子状态
     *
     * @mbggenerated Fri Dec 25 17:57:04 CST 2015
     */
    private String subStatus;

    /**
     * This field corresponds to the database column TB_MERCHANT_FS_REQ.FAST_SETTLE_FEE
     * column comments 快速结算手续费
     *
     * @mbggenerated Fri Dec 25 17:57:04 CST 2015
     */
    private BigDecimal fastSettleFee;

    /**
     * This field corresponds to the database column TB_MERCHANT_FS_REQ.MC_TYPE
     * column comments 合同类型
     *
     * @mbggenerated Fri Dec 25 17:57:04 CST 2015
     */
    private String mcType;

    /**
     * This field corresponds to the database column TB_MERCHANT_FS_REQ.MERCHANT_NAME
     * column comments 商户名称
     *
     * @mbggenerated Fri Dec 25 17:57:04 CST 2015
     */
    private String merchantName;

    /**
     * This field corresponds to the database column TB_MERCHANT_FS_REQ.PROMOTER_ID
     * column comments 代理商id
     *
     * @mbggenerated Fri Dec 25 17:57:04 CST 2015
     */
    private Long promoterId;

    /**
     * This field corresponds to the database column TB_MERCHANT_FS_REQ.PROMOTER_NAME
     * column comments 代理商名称
     *
     * @mbggenerated Fri Dec 25 17:57:04 CST 2015
     */
    private String promoterName;

    /**
     * This field corresponds to the database column TB_MERCHANT_FS_REQ.PROMOTER_NO
     * column comments 代理商商户号
     *
     * @mbggenerated Fri Dec 25 17:57:04 CST 2015
     */
    private String promoterNo;

    /**
     * This field corresponds to the database column TB_MERCHANT_FS_REQ.REMIT_FEE_TRANS_ID
     * column comments 退费转账id
     *
     * @mbggenerated Fri Dec 25 17:57:04 CST 2015
     */
    private Long remitFeeTransId;

    /**
     * This field corresponds to the database column TB_MERCHANT_FS_REQ.LOANING_TYPE
     * column comments 垫资方
     *
     * @mbggenerated Fri Dec 25 17:57:04 CST 2015
     */
    private Integer loaningType;

    /**
     * This field corresponds to the database column TB_MERCHANT_FS_REQ.APPLY_TIME
     * column comments 申请时间
     *
     * @mbggenerated Fri Dec 25 17:57:04 CST 2015
     */
    private Date applyTime;

    /**
     * This field corresponds to the database column TB_MERCHANT_FS_REQ.WITHDRAW_RESPONSE_CODE
     * column comments 银行卡到账响应编码,0-已出款
     *
     * @mbggenerated Fri Dec 25 17:57:04 CST 2015
     */
    private String withdrawResponseCode;

    /**
     * This field corresponds to the database column TB_MERCHANT_FS_REQ.WITHDRAW_RESPONSE_MSG
     * column comments 银行卡到账响应信息
     *
     * @mbggenerated Fri Dec 25 17:57:04 CST 2015
     */
    private String withdrawResponseMsg;

    /**
     * This field corresponds to the database column TB_MERCHANT_FS_REQ.WITHDRAW_RESPONSE_TIME
     * column comments 银行卡到账时间
     *
     * @mbggenerated Fri Dec 25 17:57:04 CST 2015
     */
    private Date withdrawResponseTime;

    /**
     * This method returns the value of the database column TB_MERCHANT_FS_REQ.MFQ_ID
     *
     * @return the value of TB_MERCHANT_FS_REQ.MFQ_ID
     * column comments null
     *
     * @mbggenerated Fri Dec 25 17:57:04 CST 2015
     */
    public Long getMfqId() {
        return mfqId;
    }

    /**
     * This method sets the value of the database column TB_MERCHANT_FS_REQ.MFQ_ID
     *
     * @param mfqId the value for TB_MERCHANT_FS_REQ.MFQ_ID
     * column comments null
     *
     * @mbggenerated Fri Dec 25 17:57:04 CST 2015
     */
    public void setMfqId(Long mfqId) {
        this.mfqId = mfqId;
    }

    /**
     * This method returns the value of the database column TB_MERCHANT_FS_REQ.MERCHANT_ID
     *
     * @return the value of TB_MERCHANT_FS_REQ.MERCHANT_ID
     * column comments null
     *
     * @mbggenerated Fri Dec 25 17:57:04 CST 2015
     */
    public Long getMerchantId() {
        return merchantId;
    }

    /**
     * This method sets the value of the database column TB_MERCHANT_FS_REQ.MERCHANT_ID
     *
     * @param merchantId the value for TB_MERCHANT_FS_REQ.MERCHANT_ID
     * column comments null
     *
     * @mbggenerated Fri Dec 25 17:57:04 CST 2015
     */
    public void setMerchantId(Long merchantId) {
        this.merchantId = merchantId;
    }

    /**
     * This method returns the value of the database column TB_MERCHANT_FS_REQ.TYPE
     *
     * @return the value of TB_MERCHANT_FS_REQ.TYPE
     * column comments 0：手动，1：自动
     *
     * @mbggenerated Fri Dec 25 17:57:04 CST 2015
     */
    public Integer getType() {
        return type;
    }

    /**
     * This method sets the value of the database column TB_MERCHANT_FS_REQ.TYPE
     *
     * @param type the value for TB_MERCHANT_FS_REQ.TYPE
     * column comments 0：手动，1：自动
     *
     * @mbggenerated Fri Dec 25 17:57:04 CST 2015
     */
    public void setType(Integer type) {
        this.type = type;
    }

    /**
     * This method returns the value of the database column TB_MERCHANT_FS_REQ.STATUS
     *
     * @return the value of TB_MERCHANT_FS_REQ.STATUS
     * column comments "-1"：初始
"00"： "成功"
"01"： "商户无权限，或额度配制错误"
"02"："代理商无权限，或额度配制错误"
"03"："商户额度不足"
"04"： "代理商额度不足"
"05"： "存在非法订单（存在被暂停、或者已生成结算单、或退货等不允许快速结算的订单）"
"06"："请求订单数太多（最多999）"
"07"："入账失败"
"08"："结算失败"
"09"："提交金额低于下限"
"10"："拒绝"
"11"："当前时段不允许发起快速结算"
"12"："商户快速结算规则未配置或已失效"
"13"："不支持的结算卡机构"
"14"："不支持的卡类型"
"15"："不支持的卡产品编号"
"16"："当前时间不在结算规则生效时间范围内"
"17"："提现失败"
"99"："未知错误"
     *
     * @mbggenerated Fri Dec 25 17:57:04 CST 2015
     */
    public Integer getStatus() {
        return status;
    }

    /**
     * This method sets the value of the database column TB_MERCHANT_FS_REQ.STATUS
     *
     * @param status the value for TB_MERCHANT_FS_REQ.STATUS
     * column comments "-1"：初始
"00"： "成功"
"01"： "商户无权限，或额度配制错误"
"02"："代理商无权限，或额度配制错误"
"03"："商户额度不足"
"04"： "代理商额度不足"
"05"： "存在非法订单（存在被暂停、或者已生成结算单、或退货等不允许快速结算的订单）"
"06"："请求订单数太多（最多999）"
"07"："入账失败"
"08"："结算失败"
"09"："提交金额低于下限"
"10"："拒绝"
"11"："当前时段不允许发起快速结算"
"12"："商户快速结算规则未配置或已失效"
"13"："不支持的结算卡机构"
"14"："不支持的卡类型"
"15"："不支持的卡产品编号"
"16"："当前时间不在结算规则生效时间范围内"
"17"："提现失败"
"99"："未知错误"
     *
     * @mbggenerated Fri Dec 25 17:57:04 CST 2015
     */
    public void setStatus(Integer status) {
        this.status = status;
    }

    /**
     * This method returns the value of the database column TB_MERCHANT_FS_REQ.AMOUNT
     *
     * @return the value of TB_MERCHANT_FS_REQ.AMOUNT
     * column comments 待结算总额
     *
     * @mbggenerated Fri Dec 25 17:57:04 CST 2015
     */
    public String getAmount() {
        return amount;
    }

    /**
     * This method sets the value of the database column TB_MERCHANT_FS_REQ.AMOUNT
     *
     * @param amount the value for TB_MERCHANT_FS_REQ.AMOUNT
     * column comments 待结算总额
     *
     * @mbggenerated Fri Dec 25 17:57:04 CST 2015
     */
    public void setAmount(String amount) {
        this.amount = amount == null ? null : amount.trim();
    }

    /**
     * This method returns the value of the database column TB_MERCHANT_FS_REQ.TRADE_CNT
     *
     * @return the value of TB_MERCHANT_FS_REQ.TRADE_CNT
     * column comments 交易笔数
     *
     * @mbggenerated Fri Dec 25 17:57:04 CST 2015
     */
    public Long getTradeCnt() {
        return tradeCnt;
    }

    /**
     * This method sets the value of the database column TB_MERCHANT_FS_REQ.TRADE_CNT
     *
     * @param tradeCnt the value for TB_MERCHANT_FS_REQ.TRADE_CNT
     * column comments 交易笔数
     *
     * @mbggenerated Fri Dec 25 17:57:04 CST 2015
     */
    public void setTradeCnt(Long tradeCnt) {
        this.tradeCnt = tradeCnt;
    }

    /**
     * This method returns the value of the database column TB_MERCHANT_FS_REQ.SETTLE_FEE
     *
     * @return the value of TB_MERCHANT_FS_REQ.SETTLE_FEE
     * column comments 快速结算费率
     *
     * @mbggenerated Fri Dec 25 17:57:04 CST 2015
     */
    public BigDecimal getSettleFee() {
        return settleFee;
    }

    /**
     * This method sets the value of the database column TB_MERCHANT_FS_REQ.SETTLE_FEE
     *
     * @param settleFee the value for TB_MERCHANT_FS_REQ.SETTLE_FEE
     * column comments 快速结算费率
     *
     * @mbggenerated Fri Dec 25 17:57:04 CST 2015
     */
    public void setSettleFee(BigDecimal settleFee) {
        this.settleFee = settleFee;
    }

    /**
     * This method returns the value of the database column TB_MERCHANT_FS_REQ.CREATE_TIME
     *
     * @return the value of TB_MERCHANT_FS_REQ.CREATE_TIME
     * column comments null
     *
     * @mbggenerated Fri Dec 25 17:57:04 CST 2015
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * This method sets the value of the database column TB_MERCHANT_FS_REQ.CREATE_TIME
     *
     * @param createTime the value for TB_MERCHANT_FS_REQ.CREATE_TIME
     * column comments null
     *
     * @mbggenerated Fri Dec 25 17:57:04 CST 2015
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * This method returns the value of the database column TB_MERCHANT_FS_REQ.UPDATE_TIME
     *
     * @return the value of TB_MERCHANT_FS_REQ.UPDATE_TIME
     * column comments null
     *
     * @mbggenerated Fri Dec 25 17:57:04 CST 2015
     */
    public Date getUpdateTime() {
        return updateTime;
    }

    /**
     * This method sets the value of the database column TB_MERCHANT_FS_REQ.UPDATE_TIME
     *
     * @param updateTime the value for TB_MERCHANT_FS_REQ.UPDATE_TIME
     * column comments null
     *
     * @mbggenerated Fri Dec 25 17:57:04 CST 2015
     */
    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    /**
     * This method returns the value of the database column TB_MERCHANT_FS_REQ.MERCHANT_NO
     *
     * @return the value of TB_MERCHANT_FS_REQ.MERCHANT_NO
     * column comments 商户号
     *
     * @mbggenerated Fri Dec 25 17:57:04 CST 2015
     */
    public String getMerchantNo() {
        return merchantNo;
    }

    /**
     * This method sets the value of the database column TB_MERCHANT_FS_REQ.MERCHANT_NO
     *
     * @param merchantNo the value for TB_MERCHANT_FS_REQ.MERCHANT_NO
     * column comments 商户号
     *
     * @mbggenerated Fri Dec 25 17:57:04 CST 2015
     */
    public void setMerchantNo(String merchantNo) {
        this.merchantNo = merchantNo == null ? null : merchantNo.trim();
    }

    /**
     * This method returns the value of the database column TB_MERCHANT_FS_REQ.SETTLE_BILL_NO
     *
     * @return the value of TB_MERCHANT_FS_REQ.SETTLE_BILL_NO
     * column comments MSP结算单号
     *
     * @mbggenerated Fri Dec 25 17:57:04 CST 2015
     */
    public String getSettleBillNo() {
        return settleBillNo;
    }

    /**
     * This method sets the value of the database column TB_MERCHANT_FS_REQ.SETTLE_BILL_NO
     *
     * @param settleBillNo the value for TB_MERCHANT_FS_REQ.SETTLE_BILL_NO
     * column comments MSP结算单号
     *
     * @mbggenerated Fri Dec 25 17:57:04 CST 2015
     */
    public void setSettleBillNo(String settleBillNo) {
        this.settleBillNo = settleBillNo == null ? null : settleBillNo.trim();
    }

    /**
     * This method returns the value of the database column TB_MERCHANT_FS_REQ.FUND_OUT_TIME
     *
     * @return the value of TB_MERCHANT_FS_REQ.FUND_OUT_TIME
     * column comments 结算时间
     *
     * @mbggenerated Fri Dec 25 17:57:04 CST 2015
     */
    public Date getFundOutTime() {
        return fundOutTime;
    }

    /**
     * This method sets the value of the database column TB_MERCHANT_FS_REQ.FUND_OUT_TIME
     *
     * @param fundOutTime the value for TB_MERCHANT_FS_REQ.FUND_OUT_TIME
     * column comments 结算时间
     *
     * @mbggenerated Fri Dec 25 17:57:04 CST 2015
     */
    public void setFundOutTime(Date fundOutTime) {
        this.fundOutTime = fundOutTime;
    }

    /**
     * This method returns the value of the database column TB_MERCHANT_FS_REQ.SETTLE_STATUS
     *
     * @return the value of TB_MERCHANT_FS_REQ.SETTLE_STATUS
     * column comments 0-待出款,1-已出款,2-转至下期
     *
     * @mbggenerated Fri Dec 25 17:57:04 CST 2015
     */
    public String getSettleStatus() {
        return settleStatus;
    }

    /**
     * This method sets the value of the database column TB_MERCHANT_FS_REQ.SETTLE_STATUS
     *
     * @param settleStatus the value for TB_MERCHANT_FS_REQ.SETTLE_STATUS
     * column comments 0-待出款,1-已出款,2-转至下期
     *
     * @mbggenerated Fri Dec 25 17:57:04 CST 2015
     */
    public void setSettleStatus(String settleStatus) {
        this.settleStatus = settleStatus == null ? null : settleStatus.trim();
    }

    /**
     * This method returns the value of the database column TB_MERCHANT_FS_REQ.PAYMENT_ORDER_NO
     *
     * @return the value of TB_MERCHANT_FS_REQ.PAYMENT_ORDER_NO
     * column comments fos转账订单号
     *
     * @mbggenerated Fri Dec 25 17:57:04 CST 2015
     */
    public String getPaymentOrderNo() {
        return paymentOrderNo;
    }

    /**
     * This method sets the value of the database column TB_MERCHANT_FS_REQ.PAYMENT_ORDER_NO
     *
     * @param paymentOrderNo the value for TB_MERCHANT_FS_REQ.PAYMENT_ORDER_NO
     * column comments fos转账订单号
     *
     * @mbggenerated Fri Dec 25 17:57:04 CST 2015
     */
    public void setPaymentOrderNo(String paymentOrderNo) {
        this.paymentOrderNo = paymentOrderNo == null ? null : paymentOrderNo.trim();
    }

    /**
     * This method returns the value of the database column TB_MERCHANT_FS_REQ.PAYMENT_TIME
     *
     * @return the value of TB_MERCHANT_FS_REQ.PAYMENT_TIME
     * column comments fos转账时间
     *
     * @mbggenerated Fri Dec 25 17:57:04 CST 2015
     */
    public Date getPaymentTime() {
        return paymentTime;
    }

    /**
     * This method sets the value of the database column TB_MERCHANT_FS_REQ.PAYMENT_TIME
     *
     * @param paymentTime the value for TB_MERCHANT_FS_REQ.PAYMENT_TIME
     * column comments fos转账时间
     *
     * @mbggenerated Fri Dec 25 17:57:04 CST 2015
     */
    public void setPaymentTime(Date paymentTime) {
        this.paymentTime = paymentTime;
    }

    /**
     * This method returns the value of the database column TB_MERCHANT_FS_REQ.PAYMENT_STATUS
     *
     * @return the value of TB_MERCHANT_FS_REQ.PAYMENT_STATUS
     * column comments 支付状态,S-成功,F-失败
     *
     * @mbggenerated Fri Dec 25 17:57:04 CST 2015
     */
    public String getPaymentStatus() {
        return paymentStatus;
    }

    /**
     * This method sets the value of the database column TB_MERCHANT_FS_REQ.PAYMENT_STATUS
     *
     * @param paymentStatus the value for TB_MERCHANT_FS_REQ.PAYMENT_STATUS
     * column comments 支付状态,S-成功,F-失败
     *
     * @mbggenerated Fri Dec 25 17:57:04 CST 2015
     */
    public void setPaymentStatus(String paymentStatus) {
        this.paymentStatus = paymentStatus == null ? null : paymentStatus.trim();
    }

    /**
     * This method returns the value of the database column TB_MERCHANT_FS_REQ.MERCHANT_MEMBER_ID
     *
     * @return the value of TB_MERCHANT_FS_REQ.MERCHANT_MEMBER_ID
     * column comments 商户会员号
     *
     * @mbggenerated Fri Dec 25 17:57:04 CST 2015
     */
    public String getMerchantMemberId() {
        return merchantMemberId;
    }

    /**
     * This method sets the value of the database column TB_MERCHANT_FS_REQ.MERCHANT_MEMBER_ID
     *
     * @param merchantMemberId the value for TB_MERCHANT_FS_REQ.MERCHANT_MEMBER_ID
     * column comments 商户会员号
     *
     * @mbggenerated Fri Dec 25 17:57:04 CST 2015
     */
    public void setMerchantMemberId(String merchantMemberId) {
        this.merchantMemberId = merchantMemberId == null ? null : merchantMemberId.trim();
    }

    /**
     * This method returns the value of the database column TB_MERCHANT_FS_REQ.MERCHANT_ACCOUNT_NO
     *
     * @return the value of TB_MERCHANT_FS_REQ.MERCHANT_ACCOUNT_NO
     * column comments 商户储值帐号
     *
     * @mbggenerated Fri Dec 25 17:57:04 CST 2015
     */
    public String getMerchantAccountNo() {
        return merchantAccountNo;
    }

    /**
     * This method sets the value of the database column TB_MERCHANT_FS_REQ.MERCHANT_ACCOUNT_NO
     *
     * @param merchantAccountNo the value for TB_MERCHANT_FS_REQ.MERCHANT_ACCOUNT_NO
     * column comments 商户储值帐号
     *
     * @mbggenerated Fri Dec 25 17:57:04 CST 2015
     */
    public void setMerchantAccountNo(String merchantAccountNo) {
        this.merchantAccountNo = merchantAccountNo == null ? null : merchantAccountNo.trim();
    }

    /**
     * This method returns the value of the database column TB_MERCHANT_FS_REQ.MERCHANT_ACCOUNT_TYPE
     *
     * @return the value of TB_MERCHANT_FS_REQ.MERCHANT_ACCOUNT_TYPE
     * column comments 储值帐号类型
     *
     * @mbggenerated Fri Dec 25 17:57:04 CST 2015
     */
    public String getMerchantAccountType() {
        return merchantAccountType;
    }

    /**
     * This method sets the value of the database column TB_MERCHANT_FS_REQ.MERCHANT_ACCOUNT_TYPE
     *
     * @param merchantAccountType the value for TB_MERCHANT_FS_REQ.MERCHANT_ACCOUNT_TYPE
     * column comments 储值帐号类型
     *
     * @mbggenerated Fri Dec 25 17:57:04 CST 2015
     */
    public void setMerchantAccountType(String merchantAccountType) {
        this.merchantAccountType = merchantAccountType == null ? null : merchantAccountType.trim();
    }

    /**
     * This method returns the value of the database column TB_MERCHANT_FS_REQ.SUB_STATUS
     *
     * @return the value of TB_MERCHANT_FS_REQ.SUB_STATUS
     * column comments 子状态
     *
     * @mbggenerated Fri Dec 25 17:57:04 CST 2015
     */
    public String getSubStatus() {
        return subStatus;
    }

    /**
     * This method sets the value of the database column TB_MERCHANT_FS_REQ.SUB_STATUS
     *
     * @param subStatus the value for TB_MERCHANT_FS_REQ.SUB_STATUS
     * column comments 子状态
     *
     * @mbggenerated Fri Dec 25 17:57:04 CST 2015
     */
    public void setSubStatus(String subStatus) {
        this.subStatus = subStatus == null ? null : subStatus.trim();
    }

    /**
     * This method returns the value of the database column TB_MERCHANT_FS_REQ.FAST_SETTLE_FEE
     *
     * @return the value of TB_MERCHANT_FS_REQ.FAST_SETTLE_FEE
     * column comments 快速结算手续费
     *
     * @mbggenerated Fri Dec 25 17:57:04 CST 2015
     */
    public BigDecimal getFastSettleFee() {
        return fastSettleFee;
    }

    /**
     * This method sets the value of the database column TB_MERCHANT_FS_REQ.FAST_SETTLE_FEE
     *
     * @param fastSettleFee the value for TB_MERCHANT_FS_REQ.FAST_SETTLE_FEE
     * column comments 快速结算手续费
     *
     * @mbggenerated Fri Dec 25 17:57:04 CST 2015
     */
    public void setFastSettleFee(BigDecimal fastSettleFee) {
        this.fastSettleFee = fastSettleFee;
    }

    /**
     * This method returns the value of the database column TB_MERCHANT_FS_REQ.MC_TYPE
     *
     * @return the value of TB_MERCHANT_FS_REQ.MC_TYPE
     * column comments 合同类型
     *
     * @mbggenerated Fri Dec 25 17:57:04 CST 2015
     */
    public String getMcType() {
        return mcType;
    }

    /**
     * This method sets the value of the database column TB_MERCHANT_FS_REQ.MC_TYPE
     *
     * @param mcType the value for TB_MERCHANT_FS_REQ.MC_TYPE
     * column comments 合同类型
     *
     * @mbggenerated Fri Dec 25 17:57:04 CST 2015
     */
    public void setMcType(String mcType) {
        this.mcType = mcType == null ? null : mcType.trim();
    }

    /**
     * This method returns the value of the database column TB_MERCHANT_FS_REQ.MERCHANT_NAME
     *
     * @return the value of TB_MERCHANT_FS_REQ.MERCHANT_NAME
     * column comments 商户名称
     *
     * @mbggenerated Fri Dec 25 17:57:04 CST 2015
     */
    public String getMerchantName() {
        return merchantName;
    }

    /**
     * This method sets the value of the database column TB_MERCHANT_FS_REQ.MERCHANT_NAME
     *
     * @param merchantName the value for TB_MERCHANT_FS_REQ.MERCHANT_NAME
     * column comments 商户名称
     *
     * @mbggenerated Fri Dec 25 17:57:04 CST 2015
     */
    public void setMerchantName(String merchantName) {
        this.merchantName = merchantName == null ? null : merchantName.trim();
    }

    /**
     * This method returns the value of the database column TB_MERCHANT_FS_REQ.PROMOTER_ID
     *
     * @return the value of TB_MERCHANT_FS_REQ.PROMOTER_ID
     * column comments 代理商id
     *
     * @mbggenerated Fri Dec 25 17:57:04 CST 2015
     */
    public Long getPromoterId() {
        return promoterId;
    }

    /**
     * This method sets the value of the database column TB_MERCHANT_FS_REQ.PROMOTER_ID
     *
     * @param promoterId the value for TB_MERCHANT_FS_REQ.PROMOTER_ID
     * column comments 代理商id
     *
     * @mbggenerated Fri Dec 25 17:57:04 CST 2015
     */
    public void setPromoterId(Long promoterId) {
        this.promoterId = promoterId;
    }

    /**
     * This method returns the value of the database column TB_MERCHANT_FS_REQ.PROMOTER_NAME
     *
     * @return the value of TB_MERCHANT_FS_REQ.PROMOTER_NAME
     * column comments 代理商名称
     *
     * @mbggenerated Fri Dec 25 17:57:04 CST 2015
     */
    public String getPromoterName() {
        return promoterName;
    }

    /**
     * This method sets the value of the database column TB_MERCHANT_FS_REQ.PROMOTER_NAME
     *
     * @param promoterName the value for TB_MERCHANT_FS_REQ.PROMOTER_NAME
     * column comments 代理商名称
     *
     * @mbggenerated Fri Dec 25 17:57:04 CST 2015
     */
    public void setPromoterName(String promoterName) {
        this.promoterName = promoterName == null ? null : promoterName.trim();
    }

    /**
     * This method returns the value of the database column TB_MERCHANT_FS_REQ.PROMOTER_NO
     *
     * @return the value of TB_MERCHANT_FS_REQ.PROMOTER_NO
     * column comments 代理商商户号
     *
     * @mbggenerated Fri Dec 25 17:57:04 CST 2015
     */
    public String getPromoterNo() {
        return promoterNo;
    }

    /**
     * This method sets the value of the database column TB_MERCHANT_FS_REQ.PROMOTER_NO
     *
     * @param promoterNo the value for TB_MERCHANT_FS_REQ.PROMOTER_NO
     * column comments 代理商商户号
     *
     * @mbggenerated Fri Dec 25 17:57:04 CST 2015
     */
    public void setPromoterNo(String promoterNo) {
        this.promoterNo = promoterNo == null ? null : promoterNo.trim();
    }

    /**
     * This method returns the value of the database column TB_MERCHANT_FS_REQ.REMIT_FEE_TRANS_ID
     *
     * @return the value of TB_MERCHANT_FS_REQ.REMIT_FEE_TRANS_ID
     * column comments 退费转账id
     *
     * @mbggenerated Fri Dec 25 17:57:04 CST 2015
     */
    public Long getRemitFeeTransId() {
        return remitFeeTransId;
    }

    /**
     * This method sets the value of the database column TB_MERCHANT_FS_REQ.REMIT_FEE_TRANS_ID
     *
     * @param remitFeeTransId the value for TB_MERCHANT_FS_REQ.REMIT_FEE_TRANS_ID
     * column comments 退费转账id
     *
     * @mbggenerated Fri Dec 25 17:57:04 CST 2015
     */
    public void setRemitFeeTransId(Long remitFeeTransId) {
        this.remitFeeTransId = remitFeeTransId;
    }

    /**
     * This method returns the value of the database column TB_MERCHANT_FS_REQ.LOANING_TYPE
     *
     * @return the value of TB_MERCHANT_FS_REQ.LOANING_TYPE
     * column comments 垫资方
     *
     * @mbggenerated Fri Dec 25 17:57:04 CST 2015
     */
    public Integer getLoaningType() {
        return loaningType;
    }

    /**
     * This method sets the value of the database column TB_MERCHANT_FS_REQ.LOANING_TYPE
     *
     * @param loaningType the value for TB_MERCHANT_FS_REQ.LOANING_TYPE
     * column comments 垫资方
     *
     * @mbggenerated Fri Dec 25 17:57:04 CST 2015
     */
    public void setLoaningType(Integer loaningType) {
        this.loaningType = loaningType;
    }

    /**
     * This method returns the value of the database column TB_MERCHANT_FS_REQ.APPLY_TIME
     *
     * @return the value of TB_MERCHANT_FS_REQ.APPLY_TIME
     * column comments 申请时间
     *
     * @mbggenerated Fri Dec 25 17:57:04 CST 2015
     */
    public Date getApplyTime() {
        return applyTime;
    }

    /**
     * This method sets the value of the database column TB_MERCHANT_FS_REQ.APPLY_TIME
     *
     * @param applyTime the value for TB_MERCHANT_FS_REQ.APPLY_TIME
     * column comments 申请时间
     *
     * @mbggenerated Fri Dec 25 17:57:04 CST 2015
     */
    public void setApplyTime(Date applyTime) {
        this.applyTime = applyTime;
    }

    /**
     * This method returns the value of the database column TB_MERCHANT_FS_REQ.WITHDRAW_RESPONSE_CODE
     *
     * @return the value of TB_MERCHANT_FS_REQ.WITHDRAW_RESPONSE_CODE
     * column comments 银行卡到账响应编码,0-已出款
     *
     * @mbggenerated Fri Dec 25 17:57:04 CST 2015
     */
    public String getWithdrawResponseCode() {
        return withdrawResponseCode;
    }

    /**
     * This method sets the value of the database column TB_MERCHANT_FS_REQ.WITHDRAW_RESPONSE_CODE
     *
     * @param withdrawResponseCode the value for TB_MERCHANT_FS_REQ.WITHDRAW_RESPONSE_CODE
     * column comments 银行卡到账响应编码,0-已出款
     *
     * @mbggenerated Fri Dec 25 17:57:04 CST 2015
     */
    public void setWithdrawResponseCode(String withdrawResponseCode) {
        this.withdrawResponseCode = withdrawResponseCode == null ? null : withdrawResponseCode.trim();
    }

    /**
     * This method returns the value of the database column TB_MERCHANT_FS_REQ.WITHDRAW_RESPONSE_MSG
     *
     * @return the value of TB_MERCHANT_FS_REQ.WITHDRAW_RESPONSE_MSG
     * column comments 银行卡到账响应信息
     *
     * @mbggenerated Fri Dec 25 17:57:04 CST 2015
     */
    public String getWithdrawResponseMsg() {
        return withdrawResponseMsg;
    }

    /**
     * This method sets the value of the database column TB_MERCHANT_FS_REQ.WITHDRAW_RESPONSE_MSG
     *
     * @param withdrawResponseMsg the value for TB_MERCHANT_FS_REQ.WITHDRAW_RESPONSE_MSG
     * column comments 银行卡到账响应信息
     *
     * @mbggenerated Fri Dec 25 17:57:04 CST 2015
     */
    public void setWithdrawResponseMsg(String withdrawResponseMsg) {
        this.withdrawResponseMsg = withdrawResponseMsg == null ? null : withdrawResponseMsg.trim();
    }

    /**
     * This method returns the value of the database column TB_MERCHANT_FS_REQ.WITHDRAW_RESPONSE_TIME
     *
     * @return the value of TB_MERCHANT_FS_REQ.WITHDRAW_RESPONSE_TIME
     * column comments 银行卡到账时间
     *
     * @mbggenerated Fri Dec 25 17:57:04 CST 2015
     */
    public Date getWithdrawResponseTime() {
        return withdrawResponseTime;
    }

    /**
     * This method sets the value of the database column TB_MERCHANT_FS_REQ.WITHDRAW_RESPONSE_TIME
     *
     * @param withdrawResponseTime the value for TB_MERCHANT_FS_REQ.WITHDRAW_RESPONSE_TIME
     * column comments 银行卡到账时间
     *
     * @mbggenerated Fri Dec 25 17:57:04 CST 2015
     */
    public void setWithdrawResponseTime(Date withdrawResponseTime) {
        this.withdrawResponseTime = withdrawResponseTime;
    }
}
