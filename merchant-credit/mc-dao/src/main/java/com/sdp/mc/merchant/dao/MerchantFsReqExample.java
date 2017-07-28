package com.sdp.mc.merchant.dao;

import com.sdp.emall.common.dao.QueryBase;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class MerchantFsReqExample extends QueryBase {
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
    
    private Long payEffectiveTimeMinRange;

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
     * This field corresponds to the database table TB_MERCHANT_FS_REQ
     * table comments 商户快速结算申请记录
     *
     * @mbggenerated Fri Dec 25 17:57:04 CST 2015
     */
    protected String orderByClause;

    /**
     * This field corresponds to the database table TB_MERCHANT_FS_REQ
     * table comments 商户快速结算申请记录
     *
     * @mbggenerated Fri Dec 25 17:57:04 CST 2015
     */
    protected boolean distinct;

    /**
     * This field corresponds to the database table TB_MERCHANT_FS_REQ
     * table comments 商户快速结算申请记录
     *
     * @mbggenerated Fri Dec 25 17:57:04 CST 2015
     */
    protected List<Criteria> oredCriteria;

    /**
     * This method corresponds to the database table TB_MERCHANT_FS_REQ
     *
     * @mbggenerated Fri Dec 25 17:57:04 CST 2015
     */
    public MerchantFsReqExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

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
    
    

    public Long getPayEffectiveTimeMinRange() {
		return payEffectiveTimeMinRange;
	}

	public void setPayEffectiveTimeMinRange(Long payEffectiveTimeMinRange) {
		this.payEffectiveTimeMinRange = payEffectiveTimeMinRange;
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

    /**
     * This method corresponds to the database table TB_MERCHANT_FS_REQ
     *
     * @mbggenerated Fri Dec 25 17:57:04 CST 2015
     */
    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    /**
     * This method corresponds to the database table TB_MERCHANT_FS_REQ
     *
     * @mbggenerated Fri Dec 25 17:57:04 CST 2015
     */
    public String getOrderByClause() {
        return orderByClause;
    }

    /**
     * This method corresponds to the database table TB_MERCHANT_FS_REQ
     *
     * @mbggenerated Fri Dec 25 17:57:04 CST 2015
     */
    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    /**
     * This method corresponds to the database table TB_MERCHANT_FS_REQ
     *
     * @mbggenerated Fri Dec 25 17:57:04 CST 2015
     */
    public boolean isDistinct() {
        return distinct;
    }

    /**
     * This method corresponds to the database table TB_MERCHANT_FS_REQ
     *
     * @mbggenerated Fri Dec 25 17:57:04 CST 2015
     */
    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    /**
     * This method corresponds to the database table TB_MERCHANT_FS_REQ
     *
     * @mbggenerated Fri Dec 25 17:57:04 CST 2015
     */
    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    /**
     * This method corresponds to the database table TB_MERCHANT_FS_REQ
     *
     * @mbggenerated Fri Dec 25 17:57:04 CST 2015
     */
    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    /**
     * This method corresponds to the database table TB_MERCHANT_FS_REQ
     *
     * @mbggenerated Fri Dec 25 17:57:04 CST 2015
     */
    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    /**
     * This method corresponds to the database table TB_MERCHANT_FS_REQ
     *
     * @mbggenerated Fri Dec 25 17:57:04 CST 2015
     */
    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    /**
     * This method corresponds to the database table TB_MERCHANT_FS_REQ
     *
     * @mbggenerated Fri Dec 25 17:57:04 CST 2015
     */
    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table TB_MERCHANT_FS_REQ
     * table comment :商户快速结算申请记录
     *
     * @mbggenerated Fri Dec 25 17:57:04 CST 2015
     */
    protected abstract static class GeneratedCriteria {
        protected List<Criterion> criteria;

        protected GeneratedCriteria() {
            super();
            criteria = new ArrayList<Criterion>();
        }

        public boolean isValid() {
            return criteria.size() > 0;
        }

        public List<Criterion> getAllCriteria() {
            return criteria;
        }

        public List<Criterion> getCriteria() {
            return criteria;
        }

        protected void addCriterion(String condition) {
            if (condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            }
            criteria.add(new Criterion(condition));
        }

        protected void addCriterion(String condition, Object value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value));
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value1, value2));
        }

        public Criteria andMfqIdIsNull() {
            addCriterion("MFQ_ID is null");
            return (Criteria) this;
        }

        public Criteria andMfqIdIsNotNull() {
            addCriterion("MFQ_ID is not null");
            return (Criteria) this;
        }

        public Criteria andMfqIdEqualTo(Long value) {
            addCriterion("MFQ_ID =", value, "mfqId");
            return (Criteria) this;
        }

        public Criteria andMfqIdNotEqualTo(Long value) {
            addCriterion("MFQ_ID <>", value, "mfqId");
            return (Criteria) this;
        }

        public Criteria andMfqIdGreaterThan(Long value) {
            addCriterion("MFQ_ID >", value, "mfqId");
            return (Criteria) this;
        }

        public Criteria andMfqIdGreaterThanOrEqualTo(Long value) {
            addCriterion("MFQ_ID >=", value, "mfqId");
            return (Criteria) this;
        }

        public Criteria andMfqIdLessThan(Long value) {
            addCriterion("MFQ_ID <", value, "mfqId");
            return (Criteria) this;
        }

        public Criteria andMfqIdLessThanOrEqualTo(Long value) {
            addCriterion("MFQ_ID <=", value, "mfqId");
            return (Criteria) this;
        }

        public Criteria andMfqIdIn(List<Long> values) {
            addCriterion("MFQ_ID in", values, "mfqId");
            return (Criteria) this;
        }

        public Criteria andMfqIdNotIn(List<Long> values) {
            addCriterion("MFQ_ID not in", values, "mfqId");
            return (Criteria) this;
        }

        public Criteria andMfqIdBetween(Long value1, Long value2) {
            addCriterion("MFQ_ID between", value1, value2, "mfqId");
            return (Criteria) this;
        }

        public Criteria andMfqIdNotBetween(Long value1, Long value2) {
            addCriterion("MFQ_ID not between", value1, value2, "mfqId");
            return (Criteria) this;
        }

        public Criteria andMerchantIdIsNull() {
            addCriterion("MERCHANT_ID is null");
            return (Criteria) this;
        }

        public Criteria andMerchantIdIsNotNull() {
            addCriterion("MERCHANT_ID is not null");
            return (Criteria) this;
        }

        public Criteria andMerchantIdEqualTo(Long value) {
            addCriterion("MERCHANT_ID =", value, "merchantId");
            return (Criteria) this;
        }

        public Criteria andMerchantIdNotEqualTo(Long value) {
            addCriterion("MERCHANT_ID <>", value, "merchantId");
            return (Criteria) this;
        }

        public Criteria andMerchantIdGreaterThan(Long value) {
            addCriterion("MERCHANT_ID >", value, "merchantId");
            return (Criteria) this;
        }

        public Criteria andMerchantIdGreaterThanOrEqualTo(Long value) {
            addCriterion("MERCHANT_ID >=", value, "merchantId");
            return (Criteria) this;
        }

        public Criteria andMerchantIdLessThan(Long value) {
            addCriterion("MERCHANT_ID <", value, "merchantId");
            return (Criteria) this;
        }

        public Criteria andMerchantIdLessThanOrEqualTo(Long value) {
            addCriterion("MERCHANT_ID <=", value, "merchantId");
            return (Criteria) this;
        }

        public Criteria andMerchantIdIn(List<Long> values) {
            addCriterion("MERCHANT_ID in", values, "merchantId");
            return (Criteria) this;
        }

        public Criteria andMerchantIdNotIn(List<Long> values) {
            addCriterion("MERCHANT_ID not in", values, "merchantId");
            return (Criteria) this;
        }

        public Criteria andMerchantIdBetween(Long value1, Long value2) {
            addCriterion("MERCHANT_ID between", value1, value2, "merchantId");
            return (Criteria) this;
        }

        public Criteria andMerchantIdNotBetween(Long value1, Long value2) {
            addCriterion("MERCHANT_ID not between", value1, value2, "merchantId");
            return (Criteria) this;
        }

        public Criteria andTypeIsNull() {
            addCriterion("TYPE is null");
            return (Criteria) this;
        }

        public Criteria andTypeIsNotNull() {
            addCriterion("TYPE is not null");
            return (Criteria) this;
        }

        public Criteria andTypeEqualTo(Integer value) {
            addCriterion("TYPE =", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeNotEqualTo(Integer value) {
            addCriterion("TYPE <>", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeGreaterThan(Integer value) {
            addCriterion("TYPE >", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeGreaterThanOrEqualTo(Integer value) {
            addCriterion("TYPE >=", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeLessThan(Integer value) {
            addCriterion("TYPE <", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeLessThanOrEqualTo(Integer value) {
            addCriterion("TYPE <=", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeIn(List<Integer> values) {
            addCriterion("TYPE in", values, "type");
            return (Criteria) this;
        }

        public Criteria andTypeNotIn(List<Integer> values) {
            addCriterion("TYPE not in", values, "type");
            return (Criteria) this;
        }

        public Criteria andTypeBetween(Integer value1, Integer value2) {
            addCriterion("TYPE between", value1, value2, "type");
            return (Criteria) this;
        }

        public Criteria andTypeNotBetween(Integer value1, Integer value2) {
            addCriterion("TYPE not between", value1, value2, "type");
            return (Criteria) this;
        }

        public Criteria andStatusIsNull() {
            addCriterion("STATUS is null");
            return (Criteria) this;
        }

        public Criteria andStatusIsNotNull() {
            addCriterion("STATUS is not null");
            return (Criteria) this;
        }

        public Criteria andStatusEqualTo(Integer value) {
            addCriterion("STATUS =", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotEqualTo(Integer value) {
            addCriterion("STATUS <>", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThan(Integer value) {
            addCriterion("STATUS >", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThanOrEqualTo(Integer value) {
            addCriterion("STATUS >=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThan(Integer value) {
            addCriterion("STATUS <", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThanOrEqualTo(Integer value) {
            addCriterion("STATUS <=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLike(Integer value) {
            addCriterion("STATUS like", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotLike(Integer value) {
            addCriterion("STATUS not like", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusIn(List<Integer> values) {
            addCriterion("STATUS in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotIn(List<Integer> values) {
            addCriterion("STATUS not in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusBetween(Integer value1, Integer value2) {
            addCriterion("STATUS between", value1, value2, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotBetween(Integer value1, Integer value2) {
            addCriterion("STATUS not between", value1, value2, "status");
            return (Criteria) this;
        }

        public Criteria andAmountIsNull() {
            addCriterion("AMOUNT is null");
            return (Criteria) this;
        }

        public Criteria andAmountIsNotNull() {
            addCriterion("AMOUNT is not null");
            return (Criteria) this;
        }

        public Criteria andAmountEqualTo(String value) {
            addCriterion("AMOUNT =", value, "amount");
            return (Criteria) this;
        }

        public Criteria andAmountNotEqualTo(String value) {
            addCriterion("AMOUNT <>", value, "amount");
            return (Criteria) this;
        }

        public Criteria andAmountGreaterThan(String value) {
            addCriterion("AMOUNT >", value, "amount");
            return (Criteria) this;
        }

        public Criteria andAmountGreaterThanOrEqualTo(String value) {
            addCriterion("AMOUNT >=", value, "amount");
            return (Criteria) this;
        }

        public Criteria andAmountLessThan(String value) {
            addCriterion("AMOUNT <", value, "amount");
            return (Criteria) this;
        }

        public Criteria andAmountLessThanOrEqualTo(String value) {
            addCriterion("AMOUNT <=", value, "amount");
            return (Criteria) this;
        }

        public Criteria andAmountIn(List<String> values) {
            addCriterion("AMOUNT in", values, "amount");
            return (Criteria) this;
        }

        public Criteria andAmountNotIn(List<String> values) {
            addCriterion("AMOUNT not in", values, "amount");
            return (Criteria) this;
        }

        public Criteria andAmountBetween(String value1, String value2) {
            addCriterion("AMOUNT between", value1, value2, "amount");
            return (Criteria) this;
        }

        public Criteria andAmountNotBetween(String value1, String value2) {
            addCriterion("AMOUNT not between", value1, value2, "amount");
            return (Criteria) this;
        }

        public Criteria andTradeCntIsNull() {
            addCriterion("TRADE_CNT is null");
            return (Criteria) this;
        }

        public Criteria andTradeCntIsNotNull() {
            addCriterion("TRADE_CNT is not null");
            return (Criteria) this;
        }

        public Criteria andTradeCntEqualTo(Long value) {
            addCriterion("TRADE_CNT =", value, "tradeCnt");
            return (Criteria) this;
        }

        public Criteria andTradeCntNotEqualTo(Long value) {
            addCriterion("TRADE_CNT <>", value, "tradeCnt");
            return (Criteria) this;
        }

        public Criteria andTradeCntGreaterThan(Long value) {
            addCriterion("TRADE_CNT >", value, "tradeCnt");
            return (Criteria) this;
        }

        public Criteria andTradeCntGreaterThanOrEqualTo(Long value) {
            addCriterion("TRADE_CNT >=", value, "tradeCnt");
            return (Criteria) this;
        }

        public Criteria andTradeCntLessThan(Long value) {
            addCriterion("TRADE_CNT <", value, "tradeCnt");
            return (Criteria) this;
        }

        public Criteria andTradeCntLessThanOrEqualTo(Long value) {
            addCriterion("TRADE_CNT <=", value, "tradeCnt");
            return (Criteria) this;
        }

        public Criteria andTradeCntIn(List<Long> values) {
            addCriterion("TRADE_CNT in", values, "tradeCnt");
            return (Criteria) this;
        }

        public Criteria andTradeCntNotIn(List<Long> values) {
            addCriterion("TRADE_CNT not in", values, "tradeCnt");
            return (Criteria) this;
        }

        public Criteria andTradeCntBetween(Long value1, Long value2) {
            addCriterion("TRADE_CNT between", value1, value2, "tradeCnt");
            return (Criteria) this;
        }

        public Criteria andTradeCntNotBetween(Long value1, Long value2) {
            addCriterion("TRADE_CNT not between", value1, value2, "tradeCnt");
            return (Criteria) this;
        }

        public Criteria andSettleFeeIsNull() {
            addCriterion("SETTLE_FEE is null");
            return (Criteria) this;
        }

        public Criteria andSettleFeeIsNotNull() {
            addCriterion("SETTLE_FEE is not null");
            return (Criteria) this;
        }

        public Criteria andSettleFeeEqualTo(BigDecimal value) {
            addCriterion("SETTLE_FEE =", value, "settleFee");
            return (Criteria) this;
        }

        public Criteria andSettleFeeNotEqualTo(BigDecimal value) {
            addCriterion("SETTLE_FEE <>", value, "settleFee");
            return (Criteria) this;
        }

        public Criteria andSettleFeeGreaterThan(BigDecimal value) {
            addCriterion("SETTLE_FEE >", value, "settleFee");
            return (Criteria) this;
        }

        public Criteria andSettleFeeGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("SETTLE_FEE >=", value, "settleFee");
            return (Criteria) this;
        }

        public Criteria andSettleFeeLessThan(BigDecimal value) {
            addCriterion("SETTLE_FEE <", value, "settleFee");
            return (Criteria) this;
        }

        public Criteria andSettleFeeLessThanOrEqualTo(BigDecimal value) {
            addCriterion("SETTLE_FEE <=", value, "settleFee");
            return (Criteria) this;
        }

        public Criteria andSettleFeeIn(List<BigDecimal> values) {
            addCriterion("SETTLE_FEE in", values, "settleFee");
            return (Criteria) this;
        }

        public Criteria andSettleFeeNotIn(List<BigDecimal> values) {
            addCriterion("SETTLE_FEE not in", values, "settleFee");
            return (Criteria) this;
        }

        public Criteria andSettleFeeBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("SETTLE_FEE between", value1, value2, "settleFee");
            return (Criteria) this;
        }

        public Criteria andSettleFeeNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("SETTLE_FEE not between", value1, value2, "settleFee");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIsNull() {
            addCriterion("CREATE_TIME is null");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIsNotNull() {
            addCriterion("CREATE_TIME is not null");
            return (Criteria) this;
        }

        public Criteria andCreateTimeEqualTo(Date value) {
            addCriterion("CREATE_TIME =", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotEqualTo(Date value) {
            addCriterion("CREATE_TIME <>", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThan(Date value) {
            addCriterion("CREATE_TIME >", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("CREATE_TIME >=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThan(Date value) {
            addCriterion("CREATE_TIME <", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThanOrEqualTo(Date value) {
            addCriterion("CREATE_TIME <=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIn(List<Date> values) {
            addCriterion("CREATE_TIME in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotIn(List<Date> values) {
            addCriterion("CREATE_TIME not in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeBetween(Date value1, Date value2) {
            addCriterion("CREATE_TIME between", value1, value2, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotBetween(Date value1, Date value2) {
            addCriterion("CREATE_TIME not between", value1, value2, "createTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeIsNull() {
            addCriterion("UPDATE_TIME is null");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeIsNotNull() {
            addCriterion("UPDATE_TIME is not null");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeEqualTo(Date value) {
            addCriterion("UPDATE_TIME =", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotEqualTo(Date value) {
            addCriterion("UPDATE_TIME <>", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeGreaterThan(Date value) {
            addCriterion("UPDATE_TIME >", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("UPDATE_TIME >=", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeLessThan(Date value) {
            addCriterion("UPDATE_TIME <", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeLessThanOrEqualTo(Date value) {
            addCriterion("UPDATE_TIME <=", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeIn(List<Date> values) {
            addCriterion("UPDATE_TIME in", values, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotIn(List<Date> values) {
            addCriterion("UPDATE_TIME not in", values, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeBetween(Date value1, Date value2) {
            addCriterion("UPDATE_TIME between", value1, value2, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotBetween(Date value1, Date value2) {
            addCriterion("UPDATE_TIME not between", value1, value2, "updateTime");
            return (Criteria) this;
        }

        public Criteria andMerchantNoIsNull() {
            addCriterion("MERCHANT_NO is null");
            return (Criteria) this;
        }

        public Criteria andMerchantNoIsNotNull() {
            addCriterion("MERCHANT_NO is not null");
            return (Criteria) this;
        }

        public Criteria andMerchantNoEqualTo(String value) {
            addCriterion("MERCHANT_NO =", value, "merchantNo");
            return (Criteria) this;
        }

        public Criteria andMerchantNoNotEqualTo(String value) {
            addCriterion("MERCHANT_NO <>", value, "merchantNo");
            return (Criteria) this;
        }

        public Criteria andMerchantNoGreaterThan(String value) {
            addCriterion("MERCHANT_NO >", value, "merchantNo");
            return (Criteria) this;
        }

        public Criteria andMerchantNoGreaterThanOrEqualTo(String value) {
            addCriterion("MERCHANT_NO >=", value, "merchantNo");
            return (Criteria) this;
        }

        public Criteria andMerchantNoLessThan(String value) {
            addCriterion("MERCHANT_NO <", value, "merchantNo");
            return (Criteria) this;
        }

        public Criteria andMerchantNoLessThanOrEqualTo(String value) {
            addCriterion("MERCHANT_NO <=", value, "merchantNo");
            return (Criteria) this;
        }

        public Criteria andMerchantNoLike(String value) {
            addCriterion("MERCHANT_NO like", value, "merchantNo");
            return (Criteria) this;
        }

        public Criteria andMerchantNoNotLike(String value) {
            addCriterion("MERCHANT_NO not like", value, "merchantNo");
            return (Criteria) this;
        }

        public Criteria andMerchantNoIn(List<String> values) {
            addCriterion("MERCHANT_NO in", values, "merchantNo");
            return (Criteria) this;
        }

        public Criteria andMerchantNoNotIn(List<String> values) {
            addCriterion("MERCHANT_NO not in", values, "merchantNo");
            return (Criteria) this;
        }

        public Criteria andMerchantNoBetween(String value1, String value2) {
            addCriterion("MERCHANT_NO between", value1, value2, "merchantNo");
            return (Criteria) this;
        }

        public Criteria andMerchantNoNotBetween(String value1, String value2) {
            addCriterion("MERCHANT_NO not between", value1, value2, "merchantNo");
            return (Criteria) this;
        }

        public Criteria andSettleBillNoIsNull() {
            addCriterion("SETTLE_BILL_NO is null");
            return (Criteria) this;
        }

        public Criteria andSettleBillNoIsNotNull() {
            addCriterion("SETTLE_BILL_NO is not null");
            return (Criteria) this;
        }

        public Criteria andSettleBillNoEqualTo(String value) {
            addCriterion("SETTLE_BILL_NO =", value, "settleBillNo");
            return (Criteria) this;
        }

        public Criteria andSettleBillNoNotEqualTo(String value) {
            addCriterion("SETTLE_BILL_NO <>", value, "settleBillNo");
            return (Criteria) this;
        }

        public Criteria andSettleBillNoGreaterThan(String value) {
            addCriterion("SETTLE_BILL_NO >", value, "settleBillNo");
            return (Criteria) this;
        }

        public Criteria andSettleBillNoGreaterThanOrEqualTo(String value) {
            addCriterion("SETTLE_BILL_NO >=", value, "settleBillNo");
            return (Criteria) this;
        }

        public Criteria andSettleBillNoLessThan(String value) {
            addCriterion("SETTLE_BILL_NO <", value, "settleBillNo");
            return (Criteria) this;
        }

        public Criteria andSettleBillNoLessThanOrEqualTo(String value) {
            addCriterion("SETTLE_BILL_NO <=", value, "settleBillNo");
            return (Criteria) this;
        }

        public Criteria andSettleBillNoLike(String value) {
            addCriterion("SETTLE_BILL_NO like", value, "settleBillNo");
            return (Criteria) this;
        }

        public Criteria andSettleBillNoNotLike(String value) {
            addCriterion("SETTLE_BILL_NO not like", value, "settleBillNo");
            return (Criteria) this;
        }

        public Criteria andSettleBillNoIn(List<String> values) {
            addCriterion("SETTLE_BILL_NO in", values, "settleBillNo");
            return (Criteria) this;
        }

        public Criteria andSettleBillNoNotIn(List<String> values) {
            addCriterion("SETTLE_BILL_NO not in", values, "settleBillNo");
            return (Criteria) this;
        }

        public Criteria andSettleBillNoBetween(String value1, String value2) {
            addCriterion("SETTLE_BILL_NO between", value1, value2, "settleBillNo");
            return (Criteria) this;
        }

        public Criteria andSettleBillNoNotBetween(String value1, String value2) {
            addCriterion("SETTLE_BILL_NO not between", value1, value2, "settleBillNo");
            return (Criteria) this;
        }

        public Criteria andFundOutTimeIsNull() {
            addCriterion("FUND_OUT_TIME is null");
            return (Criteria) this;
        }

        public Criteria andFundOutTimeIsNotNull() {
            addCriterion("FUND_OUT_TIME is not null");
            return (Criteria) this;
        }

        public Criteria andFundOutTimeEqualTo(Date value) {
            addCriterion("FUND_OUT_TIME =", value, "fundOutTime");
            return (Criteria) this;
        }

        public Criteria andFundOutTimeNotEqualTo(Date value) {
            addCriterion("FUND_OUT_TIME <>", value, "fundOutTime");
            return (Criteria) this;
        }

        public Criteria andFundOutTimeGreaterThan(Date value) {
            addCriterion("FUND_OUT_TIME >", value, "fundOutTime");
            return (Criteria) this;
        }

        public Criteria andFundOutTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("FUND_OUT_TIME >=", value, "fundOutTime");
            return (Criteria) this;
        }

        public Criteria andFundOutTimeLessThan(Date value) {
            addCriterion("FUND_OUT_TIME <", value, "fundOutTime");
            return (Criteria) this;
        }

        public Criteria andFundOutTimeLessThanOrEqualTo(Date value) {
            addCriterion("FUND_OUT_TIME <=", value, "fundOutTime");
            return (Criteria) this;
        }

        public Criteria andFundOutTimeIn(List<Date> values) {
            addCriterion("FUND_OUT_TIME in", values, "fundOutTime");
            return (Criteria) this;
        }

        public Criteria andFundOutTimeNotIn(List<Date> values) {
            addCriterion("FUND_OUT_TIME not in", values, "fundOutTime");
            return (Criteria) this;
        }

        public Criteria andFundOutTimeBetween(Date value1, Date value2) {
            addCriterion("FUND_OUT_TIME between", value1, value2, "fundOutTime");
            return (Criteria) this;
        }

        public Criteria andFundOutTimeNotBetween(Date value1, Date value2) {
            addCriterion("FUND_OUT_TIME not between", value1, value2, "fundOutTime");
            return (Criteria) this;
        }

        public Criteria andSettleStatusIsNull() {
            addCriterion("SETTLE_STATUS is null");
            return (Criteria) this;
        }

        public Criteria andSettleStatusIsNotNull() {
            addCriterion("SETTLE_STATUS is not null");
            return (Criteria) this;
        }

        public Criteria andSettleStatusEqualTo(String value) {
            addCriterion("SETTLE_STATUS =", value, "settleStatus");
            return (Criteria) this;
        }

        public Criteria andSettleStatusNotEqualTo(String value) {
            addCriterion("SETTLE_STATUS <>", value, "settleStatus");
            return (Criteria) this;
        }

        public Criteria andSettleStatusGreaterThan(String value) {
            addCriterion("SETTLE_STATUS >", value, "settleStatus");
            return (Criteria) this;
        }

        public Criteria andSettleStatusGreaterThanOrEqualTo(String value) {
            addCriterion("SETTLE_STATUS >=", value, "settleStatus");
            return (Criteria) this;
        }

        public Criteria andSettleStatusLessThan(String value) {
            addCriterion("SETTLE_STATUS <", value, "settleStatus");
            return (Criteria) this;
        }

        public Criteria andSettleStatusLessThanOrEqualTo(String value) {
            addCriterion("SETTLE_STATUS <=", value, "settleStatus");
            return (Criteria) this;
        }

        public Criteria andSettleStatusLike(String value) {
            addCriterion("SETTLE_STATUS like", value, "settleStatus");
            return (Criteria) this;
        }

        public Criteria andSettleStatusNotLike(String value) {
            addCriterion("SETTLE_STATUS not like", value, "settleStatus");
            return (Criteria) this;
        }

        public Criteria andSettleStatusIn(List<String> values) {
            addCriterion("SETTLE_STATUS in", values, "settleStatus");
            return (Criteria) this;
        }

        public Criteria andSettleStatusNotIn(List<String> values) {
            addCriterion("SETTLE_STATUS not in", values, "settleStatus");
            return (Criteria) this;
        }

        public Criteria andSettleStatusBetween(String value1, String value2) {
            addCriterion("SETTLE_STATUS between", value1, value2, "settleStatus");
            return (Criteria) this;
        }

        public Criteria andSettleStatusNotBetween(String value1, String value2) {
            addCriterion("SETTLE_STATUS not between", value1, value2, "settleStatus");
            return (Criteria) this;
        }

        public Criteria andPaymentOrderNoIsNull() {
            addCriterion("PAYMENT_ORDER_NO is null");
            return (Criteria) this;
        }

        public Criteria andPaymentOrderNoIsNotNull() {
            addCriterion("PAYMENT_ORDER_NO is not null");
            return (Criteria) this;
        }

        public Criteria andPaymentOrderNoEqualTo(String value) {
            addCriterion("PAYMENT_ORDER_NO =", value, "paymentOrderNo");
            return (Criteria) this;
        }

        public Criteria andPaymentOrderNoNotEqualTo(String value) {
            addCriterion("PAYMENT_ORDER_NO <>", value, "paymentOrderNo");
            return (Criteria) this;
        }

        public Criteria andPaymentOrderNoGreaterThan(String value) {
            addCriterion("PAYMENT_ORDER_NO >", value, "paymentOrderNo");
            return (Criteria) this;
        }

        public Criteria andPaymentOrderNoGreaterThanOrEqualTo(String value) {
            addCriterion("PAYMENT_ORDER_NO >=", value, "paymentOrderNo");
            return (Criteria) this;
        }

        public Criteria andPaymentOrderNoLessThan(String value) {
            addCriterion("PAYMENT_ORDER_NO <", value, "paymentOrderNo");
            return (Criteria) this;
        }

        public Criteria andPaymentOrderNoLessThanOrEqualTo(String value) {
            addCriterion("PAYMENT_ORDER_NO <=", value, "paymentOrderNo");
            return (Criteria) this;
        }

        public Criteria andPaymentOrderNoLike(String value) {
            addCriterion("PAYMENT_ORDER_NO like", value, "paymentOrderNo");
            return (Criteria) this;
        }

        public Criteria andPaymentOrderNoNotLike(String value) {
            addCriterion("PAYMENT_ORDER_NO not like", value, "paymentOrderNo");
            return (Criteria) this;
        }

        public Criteria andPaymentOrderNoIn(List<String> values) {
            addCriterion("PAYMENT_ORDER_NO in", values, "paymentOrderNo");
            return (Criteria) this;
        }

        public Criteria andPaymentOrderNoNotIn(List<String> values) {
            addCriterion("PAYMENT_ORDER_NO not in", values, "paymentOrderNo");
            return (Criteria) this;
        }

        public Criteria andPaymentOrderNoBetween(String value1, String value2) {
            addCriterion("PAYMENT_ORDER_NO between", value1, value2, "paymentOrderNo");
            return (Criteria) this;
        }

        public Criteria andPaymentOrderNoNotBetween(String value1, String value2) {
            addCriterion("PAYMENT_ORDER_NO not between", value1, value2, "paymentOrderNo");
            return (Criteria) this;
        }

        public Criteria andPaymentTimeIsNull() {
            addCriterion("PAYMENT_TIME is null");
            return (Criteria) this;
        }

        public Criteria andPaymentTimeIsNotNull() {
            addCriterion("PAYMENT_TIME is not null");
            return (Criteria) this;
        }

        public Criteria andPaymentTimeEqualTo(Date value) {
            addCriterion("PAYMENT_TIME =", value, "paymentTime");
            return (Criteria) this;
        }

        public Criteria andPaymentTimeNotEqualTo(Date value) {
            addCriterion("PAYMENT_TIME <>", value, "paymentTime");
            return (Criteria) this;
        }

        public Criteria andPaymentTimeGreaterThan(Date value) {
            addCriterion("PAYMENT_TIME >", value, "paymentTime");
            return (Criteria) this;
        }

        public Criteria andPaymentTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("PAYMENT_TIME >=", value, "paymentTime");
            return (Criteria) this;
        }

        public Criteria andPaymentTimeLessThan(Date value) {
            addCriterion("PAYMENT_TIME <", value, "paymentTime");
            return (Criteria) this;
        }

        public Criteria andPaymentTimeLessThanOrEqualTo(Date value) {
            addCriterion("PAYMENT_TIME <=", value, "paymentTime");
            return (Criteria) this;
        }

        public Criteria andPaymentTimeIn(List<Date> values) {
            addCriterion("PAYMENT_TIME in", values, "paymentTime");
            return (Criteria) this;
        }

        public Criteria andPaymentTimeNotIn(List<Date> values) {
            addCriterion("PAYMENT_TIME not in", values, "paymentTime");
            return (Criteria) this;
        }

        public Criteria andPaymentTimeBetween(Date value1, Date value2) {
            addCriterion("PAYMENT_TIME between", value1, value2, "paymentTime");
            return (Criteria) this;
        }

        public Criteria andPaymentTimeNotBetween(Date value1, Date value2) {
            addCriterion("PAYMENT_TIME not between", value1, value2, "paymentTime");
            return (Criteria) this;
        }

        public Criteria andPaymentStatusIsNull() {
            addCriterion("PAYMENT_STATUS is null");
            return (Criteria) this;
        }

        public Criteria andPaymentStatusIsNotNull() {
            addCriterion("PAYMENT_STATUS is not null");
            return (Criteria) this;
        }

        public Criteria andPaymentStatusEqualTo(String value) {
            addCriterion("PAYMENT_STATUS =", value, "paymentStatus");
            return (Criteria) this;
        }

        public Criteria andPaymentStatusNotEqualTo(String value) {
            addCriterion("PAYMENT_STATUS <>", value, "paymentStatus");
            return (Criteria) this;
        }

        public Criteria andPaymentStatusGreaterThan(String value) {
            addCriterion("PAYMENT_STATUS >", value, "paymentStatus");
            return (Criteria) this;
        }

        public Criteria andPaymentStatusGreaterThanOrEqualTo(String value) {
            addCriterion("PAYMENT_STATUS >=", value, "paymentStatus");
            return (Criteria) this;
        }

        public Criteria andPaymentStatusLessThan(String value) {
            addCriterion("PAYMENT_STATUS <", value, "paymentStatus");
            return (Criteria) this;
        }

        public Criteria andPaymentStatusLessThanOrEqualTo(String value) {
            addCriterion("PAYMENT_STATUS <=", value, "paymentStatus");
            return (Criteria) this;
        }

        public Criteria andPaymentStatusLike(String value) {
            addCriterion("PAYMENT_STATUS like", value, "paymentStatus");
            return (Criteria) this;
        }

        public Criteria andPaymentStatusNotLike(String value) {
            addCriterion("PAYMENT_STATUS not like", value, "paymentStatus");
            return (Criteria) this;
        }

        public Criteria andPaymentStatusIn(List<String> values) {
            addCriterion("PAYMENT_STATUS in", values, "paymentStatus");
            return (Criteria) this;
        }

        public Criteria andPaymentStatusNotIn(List<String> values) {
            addCriterion("PAYMENT_STATUS not in", values, "paymentStatus");
            return (Criteria) this;
        }

        public Criteria andPaymentStatusBetween(String value1, String value2) {
            addCriterion("PAYMENT_STATUS between", value1, value2, "paymentStatus");
            return (Criteria) this;
        }

        public Criteria andPaymentStatusNotBetween(String value1, String value2) {
            addCriterion("PAYMENT_STATUS not between", value1, value2, "paymentStatus");
            return (Criteria) this;
        }

        public Criteria andMerchantMemberIdIsNull() {
            addCriterion("MERCHANT_MEMBER_ID is null");
            return (Criteria) this;
        }

        public Criteria andMerchantMemberIdIsNotNull() {
            addCriterion("MERCHANT_MEMBER_ID is not null");
            return (Criteria) this;
        }

        public Criteria andMerchantMemberIdEqualTo(String value) {
            addCriterion("MERCHANT_MEMBER_ID =", value, "merchantMemberId");
            return (Criteria) this;
        }

        public Criteria andMerchantMemberIdNotEqualTo(String value) {
            addCriterion("MERCHANT_MEMBER_ID <>", value, "merchantMemberId");
            return (Criteria) this;
        }

        public Criteria andMerchantMemberIdGreaterThan(String value) {
            addCriterion("MERCHANT_MEMBER_ID >", value, "merchantMemberId");
            return (Criteria) this;
        }

        public Criteria andMerchantMemberIdGreaterThanOrEqualTo(String value) {
            addCriterion("MERCHANT_MEMBER_ID >=", value, "merchantMemberId");
            return (Criteria) this;
        }

        public Criteria andMerchantMemberIdLessThan(String value) {
            addCriterion("MERCHANT_MEMBER_ID <", value, "merchantMemberId");
            return (Criteria) this;
        }

        public Criteria andMerchantMemberIdLessThanOrEqualTo(String value) {
            addCriterion("MERCHANT_MEMBER_ID <=", value, "merchantMemberId");
            return (Criteria) this;
        }

        public Criteria andMerchantMemberIdLike(String value) {
            addCriterion("MERCHANT_MEMBER_ID like", value, "merchantMemberId");
            return (Criteria) this;
        }

        public Criteria andMerchantMemberIdNotLike(String value) {
            addCriterion("MERCHANT_MEMBER_ID not like", value, "merchantMemberId");
            return (Criteria) this;
        }

        public Criteria andMerchantMemberIdIn(List<String> values) {
            addCriterion("MERCHANT_MEMBER_ID in", values, "merchantMemberId");
            return (Criteria) this;
        }

        public Criteria andMerchantMemberIdNotIn(List<String> values) {
            addCriterion("MERCHANT_MEMBER_ID not in", values, "merchantMemberId");
            return (Criteria) this;
        }

        public Criteria andMerchantMemberIdBetween(String value1, String value2) {
            addCriterion("MERCHANT_MEMBER_ID between", value1, value2, "merchantMemberId");
            return (Criteria) this;
        }

        public Criteria andMerchantMemberIdNotBetween(String value1, String value2) {
            addCriterion("MERCHANT_MEMBER_ID not between", value1, value2, "merchantMemberId");
            return (Criteria) this;
        }

        public Criteria andMerchantAccountNoIsNull() {
            addCriterion("MERCHANT_ACCOUNT_NO is null");
            return (Criteria) this;
        }

        public Criteria andMerchantAccountNoIsNotNull() {
            addCriterion("MERCHANT_ACCOUNT_NO is not null");
            return (Criteria) this;
        }

        public Criteria andMerchantAccountNoEqualTo(String value) {
            addCriterion("MERCHANT_ACCOUNT_NO =", value, "merchantAccountNo");
            return (Criteria) this;
        }

        public Criteria andMerchantAccountNoNotEqualTo(String value) {
            addCriterion("MERCHANT_ACCOUNT_NO <>", value, "merchantAccountNo");
            return (Criteria) this;
        }

        public Criteria andMerchantAccountNoGreaterThan(String value) {
            addCriterion("MERCHANT_ACCOUNT_NO >", value, "merchantAccountNo");
            return (Criteria) this;
        }

        public Criteria andMerchantAccountNoGreaterThanOrEqualTo(String value) {
            addCriterion("MERCHANT_ACCOUNT_NO >=", value, "merchantAccountNo");
            return (Criteria) this;
        }

        public Criteria andMerchantAccountNoLessThan(String value) {
            addCriterion("MERCHANT_ACCOUNT_NO <", value, "merchantAccountNo");
            return (Criteria) this;
        }

        public Criteria andMerchantAccountNoLessThanOrEqualTo(String value) {
            addCriterion("MERCHANT_ACCOUNT_NO <=", value, "merchantAccountNo");
            return (Criteria) this;
        }

        public Criteria andMerchantAccountNoLike(String value) {
            addCriterion("MERCHANT_ACCOUNT_NO like", value, "merchantAccountNo");
            return (Criteria) this;
        }

        public Criteria andMerchantAccountNoNotLike(String value) {
            addCriterion("MERCHANT_ACCOUNT_NO not like", value, "merchantAccountNo");
            return (Criteria) this;
        }

        public Criteria andMerchantAccountNoIn(List<String> values) {
            addCriterion("MERCHANT_ACCOUNT_NO in", values, "merchantAccountNo");
            return (Criteria) this;
        }

        public Criteria andMerchantAccountNoNotIn(List<String> values) {
            addCriterion("MERCHANT_ACCOUNT_NO not in", values, "merchantAccountNo");
            return (Criteria) this;
        }

        public Criteria andMerchantAccountNoBetween(String value1, String value2) {
            addCriterion("MERCHANT_ACCOUNT_NO between", value1, value2, "merchantAccountNo");
            return (Criteria) this;
        }

        public Criteria andMerchantAccountNoNotBetween(String value1, String value2) {
            addCriterion("MERCHANT_ACCOUNT_NO not between", value1, value2, "merchantAccountNo");
            return (Criteria) this;
        }

        public Criteria andMerchantAccountTypeIsNull() {
            addCriterion("MERCHANT_ACCOUNT_TYPE is null");
            return (Criteria) this;
        }

        public Criteria andMerchantAccountTypeIsNotNull() {
            addCriterion("MERCHANT_ACCOUNT_TYPE is not null");
            return (Criteria) this;
        }

        public Criteria andMerchantAccountTypeEqualTo(String value) {
            addCriterion("MERCHANT_ACCOUNT_TYPE =", value, "merchantAccountType");
            return (Criteria) this;
        }

        public Criteria andMerchantAccountTypeNotEqualTo(String value) {
            addCriterion("MERCHANT_ACCOUNT_TYPE <>", value, "merchantAccountType");
            return (Criteria) this;
        }

        public Criteria andMerchantAccountTypeGreaterThan(String value) {
            addCriterion("MERCHANT_ACCOUNT_TYPE >", value, "merchantAccountType");
            return (Criteria) this;
        }

        public Criteria andMerchantAccountTypeGreaterThanOrEqualTo(String value) {
            addCriterion("MERCHANT_ACCOUNT_TYPE >=", value, "merchantAccountType");
            return (Criteria) this;
        }

        public Criteria andMerchantAccountTypeLessThan(String value) {
            addCriterion("MERCHANT_ACCOUNT_TYPE <", value, "merchantAccountType");
            return (Criteria) this;
        }

        public Criteria andMerchantAccountTypeLessThanOrEqualTo(String value) {
            addCriterion("MERCHANT_ACCOUNT_TYPE <=", value, "merchantAccountType");
            return (Criteria) this;
        }

        public Criteria andMerchantAccountTypeLike(String value) {
            addCriterion("MERCHANT_ACCOUNT_TYPE like", value, "merchantAccountType");
            return (Criteria) this;
        }

        public Criteria andMerchantAccountTypeNotLike(String value) {
            addCriterion("MERCHANT_ACCOUNT_TYPE not like", value, "merchantAccountType");
            return (Criteria) this;
        }

        public Criteria andMerchantAccountTypeIn(List<String> values) {
            addCriterion("MERCHANT_ACCOUNT_TYPE in", values, "merchantAccountType");
            return (Criteria) this;
        }

        public Criteria andMerchantAccountTypeNotIn(List<String> values) {
            addCriterion("MERCHANT_ACCOUNT_TYPE not in", values, "merchantAccountType");
            return (Criteria) this;
        }

        public Criteria andMerchantAccountTypeBetween(String value1, String value2) {
            addCriterion("MERCHANT_ACCOUNT_TYPE between", value1, value2, "merchantAccountType");
            return (Criteria) this;
        }

        public Criteria andMerchantAccountTypeNotBetween(String value1, String value2) {
            addCriterion("MERCHANT_ACCOUNT_TYPE not between", value1, value2, "merchantAccountType");
            return (Criteria) this;
        }

        public Criteria andSubStatusIsNull() {
            addCriterion("SUB_STATUS is null");
            return (Criteria) this;
        }

        public Criteria andSubStatusIsNotNull() {
            addCriterion("SUB_STATUS is not null");
            return (Criteria) this;
        }

        public Criteria andSubStatusEqualTo(String value) {
            addCriterion("SUB_STATUS =", value, "subStatus");
            return (Criteria) this;
        }

        public Criteria andSubStatusNotEqualTo(String value) {
            addCriterion("SUB_STATUS <>", value, "subStatus");
            return (Criteria) this;
        }

        public Criteria andSubStatusGreaterThan(String value) {
            addCriterion("SUB_STATUS >", value, "subStatus");
            return (Criteria) this;
        }

        public Criteria andSubStatusGreaterThanOrEqualTo(String value) {
            addCriterion("SUB_STATUS >=", value, "subStatus");
            return (Criteria) this;
        }

        public Criteria andSubStatusLessThan(String value) {
            addCriterion("SUB_STATUS <", value, "subStatus");
            return (Criteria) this;
        }

        public Criteria andSubStatusLessThanOrEqualTo(String value) {
            addCriterion("SUB_STATUS <=", value, "subStatus");
            return (Criteria) this;
        }

        public Criteria andSubStatusLike(String value) {
            addCriterion("SUB_STATUS like", value, "subStatus");
            return (Criteria) this;
        }

        public Criteria andSubStatusNotLike(String value) {
            addCriterion("SUB_STATUS not like", value, "subStatus");
            return (Criteria) this;
        }

        public Criteria andSubStatusIn(List<String> values) {
            addCriterion("SUB_STATUS in", values, "subStatus");
            return (Criteria) this;
        }

        public Criteria andSubStatusNotIn(List<String> values) {
            addCriterion("SUB_STATUS not in", values, "subStatus");
            return (Criteria) this;
        }

        public Criteria andSubStatusBetween(String value1, String value2) {
            addCriterion("SUB_STATUS between", value1, value2, "subStatus");
            return (Criteria) this;
        }

        public Criteria andSubStatusNotBetween(String value1, String value2) {
            addCriterion("SUB_STATUS not between", value1, value2, "subStatus");
            return (Criteria) this;
        }

        public Criteria andFastSettleFeeIsNull() {
            addCriterion("FAST_SETTLE_FEE is null");
            return (Criteria) this;
        }

        public Criteria andFastSettleFeeIsNotNull() {
            addCriterion("FAST_SETTLE_FEE is not null");
            return (Criteria) this;
        }

        public Criteria andFastSettleFeeEqualTo(BigDecimal value) {
            addCriterion("FAST_SETTLE_FEE =", value, "fastSettleFee");
            return (Criteria) this;
        }

        public Criteria andFastSettleFeeNotEqualTo(BigDecimal value) {
            addCriterion("FAST_SETTLE_FEE <>", value, "fastSettleFee");
            return (Criteria) this;
        }

        public Criteria andFastSettleFeeGreaterThan(BigDecimal value) {
            addCriterion("FAST_SETTLE_FEE >", value, "fastSettleFee");
            return (Criteria) this;
        }

        public Criteria andFastSettleFeeGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("FAST_SETTLE_FEE >=", value, "fastSettleFee");
            return (Criteria) this;
        }

        public Criteria andFastSettleFeeLessThan(BigDecimal value) {
            addCriterion("FAST_SETTLE_FEE <", value, "fastSettleFee");
            return (Criteria) this;
        }

        public Criteria andFastSettleFeeLessThanOrEqualTo(BigDecimal value) {
            addCriterion("FAST_SETTLE_FEE <=", value, "fastSettleFee");
            return (Criteria) this;
        }

        public Criteria andFastSettleFeeIn(List<BigDecimal> values) {
            addCriterion("FAST_SETTLE_FEE in", values, "fastSettleFee");
            return (Criteria) this;
        }

        public Criteria andFastSettleFeeNotIn(List<BigDecimal> values) {
            addCriterion("FAST_SETTLE_FEE not in", values, "fastSettleFee");
            return (Criteria) this;
        }

        public Criteria andFastSettleFeeBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("FAST_SETTLE_FEE between", value1, value2, "fastSettleFee");
            return (Criteria) this;
        }

        public Criteria andFastSettleFeeNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("FAST_SETTLE_FEE not between", value1, value2, "fastSettleFee");
            return (Criteria) this;
        }

        public Criteria andMcTypeIsNull() {
            addCriterion("MC_TYPE is null");
            return (Criteria) this;
        }

        public Criteria andMcTypeIsNotNull() {
            addCriterion("MC_TYPE is not null");
            return (Criteria) this;
        }

        public Criteria andMcTypeEqualTo(String value) {
            addCriterion("MC_TYPE =", value, "mcType");
            return (Criteria) this;
        }

        public Criteria andMcTypeNotEqualTo(String value) {
            addCriterion("MC_TYPE <>", value, "mcType");
            return (Criteria) this;
        }

        public Criteria andMcTypeGreaterThan(String value) {
            addCriterion("MC_TYPE >", value, "mcType");
            return (Criteria) this;
        }

        public Criteria andMcTypeGreaterThanOrEqualTo(String value) {
            addCriterion("MC_TYPE >=", value, "mcType");
            return (Criteria) this;
        }

        public Criteria andMcTypeLessThan(String value) {
            addCriterion("MC_TYPE <", value, "mcType");
            return (Criteria) this;
        }

        public Criteria andMcTypeLessThanOrEqualTo(String value) {
            addCriterion("MC_TYPE <=", value, "mcType");
            return (Criteria) this;
        }

        public Criteria andMcTypeLike(String value) {
            addCriterion("MC_TYPE like", value, "mcType");
            return (Criteria) this;
        }

        public Criteria andMcTypeNotLike(String value) {
            addCriterion("MC_TYPE not like", value, "mcType");
            return (Criteria) this;
        }

        public Criteria andMcTypeIn(List<String> values) {
            addCriterion("MC_TYPE in", values, "mcType");
            return (Criteria) this;
        }

        public Criteria andMcTypeNotIn(List<String> values) {
            addCriterion("MC_TYPE not in", values, "mcType");
            return (Criteria) this;
        }

        public Criteria andMcTypeBetween(String value1, String value2) {
            addCriterion("MC_TYPE between", value1, value2, "mcType");
            return (Criteria) this;
        }

        public Criteria andMcTypeNotBetween(String value1, String value2) {
            addCriterion("MC_TYPE not between", value1, value2, "mcType");
            return (Criteria) this;
        }

        public Criteria andMerchantNameIsNull() {
            addCriterion("MERCHANT_NAME is null");
            return (Criteria) this;
        }

        public Criteria andMerchantNameIsNotNull() {
            addCriterion("MERCHANT_NAME is not null");
            return (Criteria) this;
        }

        public Criteria andMerchantNameEqualTo(String value) {
            addCriterion("MERCHANT_NAME =", value, "merchantName");
            return (Criteria) this;
        }

        public Criteria andMerchantNameNotEqualTo(String value) {
            addCriterion("MERCHANT_NAME <>", value, "merchantName");
            return (Criteria) this;
        }

        public Criteria andMerchantNameGreaterThan(String value) {
            addCriterion("MERCHANT_NAME >", value, "merchantName");
            return (Criteria) this;
        }

        public Criteria andMerchantNameGreaterThanOrEqualTo(String value) {
            addCriterion("MERCHANT_NAME >=", value, "merchantName");
            return (Criteria) this;
        }

        public Criteria andMerchantNameLessThan(String value) {
            addCriterion("MERCHANT_NAME <", value, "merchantName");
            return (Criteria) this;
        }

        public Criteria andMerchantNameLessThanOrEqualTo(String value) {
            addCriterion("MERCHANT_NAME <=", value, "merchantName");
            return (Criteria) this;
        }

        public Criteria andMerchantNameLike(String value) {
            addCriterion("MERCHANT_NAME like", value, "merchantName");
            return (Criteria) this;
        }

        public Criteria andMerchantNameNotLike(String value) {
            addCriterion("MERCHANT_NAME not like", value, "merchantName");
            return (Criteria) this;
        }

        public Criteria andMerchantNameIn(List<String> values) {
            addCriterion("MERCHANT_NAME in", values, "merchantName");
            return (Criteria) this;
        }

        public Criteria andMerchantNameNotIn(List<String> values) {
            addCriterion("MERCHANT_NAME not in", values, "merchantName");
            return (Criteria) this;
        }

        public Criteria andMerchantNameBetween(String value1, String value2) {
            addCriterion("MERCHANT_NAME between", value1, value2, "merchantName");
            return (Criteria) this;
        }

        public Criteria andMerchantNameNotBetween(String value1, String value2) {
            addCriterion("MERCHANT_NAME not between", value1, value2, "merchantName");
            return (Criteria) this;
        }

        public Criteria andPromoterIdIsNull() {
            addCriterion("PROMOTER_ID is null");
            return (Criteria) this;
        }

        public Criteria andPromoterIdIsNotNull() {
            addCriterion("PROMOTER_ID is not null");
            return (Criteria) this;
        }

        public Criteria andPromoterIdEqualTo(Long value) {
            addCriterion("PROMOTER_ID =", value, "promoterId");
            return (Criteria) this;
        }

        public Criteria andPromoterIdNotEqualTo(Long value) {
            addCriterion("PROMOTER_ID <>", value, "promoterId");
            return (Criteria) this;
        }

        public Criteria andPromoterIdGreaterThan(Long value) {
            addCriterion("PROMOTER_ID >", value, "promoterId");
            return (Criteria) this;
        }

        public Criteria andPromoterIdGreaterThanOrEqualTo(Long value) {
            addCriterion("PROMOTER_ID >=", value, "promoterId");
            return (Criteria) this;
        }

        public Criteria andPromoterIdLessThan(Long value) {
            addCriterion("PROMOTER_ID <", value, "promoterId");
            return (Criteria) this;
        }

        public Criteria andPromoterIdLessThanOrEqualTo(Long value) {
            addCriterion("PROMOTER_ID <=", value, "promoterId");
            return (Criteria) this;
        }

        public Criteria andPromoterIdIn(List<Long> values) {
            addCriterion("PROMOTER_ID in", values, "promoterId");
            return (Criteria) this;
        }

        public Criteria andPromoterIdNotIn(List<Long> values) {
            addCriterion("PROMOTER_ID not in", values, "promoterId");
            return (Criteria) this;
        }

        public Criteria andPromoterIdBetween(Long value1, Long value2) {
            addCriterion("PROMOTER_ID between", value1, value2, "promoterId");
            return (Criteria) this;
        }

        public Criteria andPromoterIdNotBetween(Long value1, Long value2) {
            addCriterion("PROMOTER_ID not between", value1, value2, "promoterId");
            return (Criteria) this;
        }

        public Criteria andPromoterNameIsNull() {
            addCriterion("PROMOTER_NAME is null");
            return (Criteria) this;
        }

        public Criteria andPromoterNameIsNotNull() {
            addCriterion("PROMOTER_NAME is not null");
            return (Criteria) this;
        }

        public Criteria andPromoterNameEqualTo(String value) {
            addCriterion("PROMOTER_NAME =", value, "promoterName");
            return (Criteria) this;
        }

        public Criteria andPromoterNameNotEqualTo(String value) {
            addCriterion("PROMOTER_NAME <>", value, "promoterName");
            return (Criteria) this;
        }

        public Criteria andPromoterNameGreaterThan(String value) {
            addCriterion("PROMOTER_NAME >", value, "promoterName");
            return (Criteria) this;
        }

        public Criteria andPromoterNameGreaterThanOrEqualTo(String value) {
            addCriterion("PROMOTER_NAME >=", value, "promoterName");
            return (Criteria) this;
        }

        public Criteria andPromoterNameLessThan(String value) {
            addCriterion("PROMOTER_NAME <", value, "promoterName");
            return (Criteria) this;
        }

        public Criteria andPromoterNameLessThanOrEqualTo(String value) {
            addCriterion("PROMOTER_NAME <=", value, "promoterName");
            return (Criteria) this;
        }

        public Criteria andPromoterNameLike(String value) {
            addCriterion("PROMOTER_NAME like", value, "promoterName");
            return (Criteria) this;
        }

        public Criteria andPromoterNameNotLike(String value) {
            addCriterion("PROMOTER_NAME not like", value, "promoterName");
            return (Criteria) this;
        }

        public Criteria andPromoterNameIn(List<String> values) {
            addCriterion("PROMOTER_NAME in", values, "promoterName");
            return (Criteria) this;
        }

        public Criteria andPromoterNameNotIn(List<String> values) {
            addCriterion("PROMOTER_NAME not in", values, "promoterName");
            return (Criteria) this;
        }

        public Criteria andPromoterNameBetween(String value1, String value2) {
            addCriterion("PROMOTER_NAME between", value1, value2, "promoterName");
            return (Criteria) this;
        }

        public Criteria andPromoterNameNotBetween(String value1, String value2) {
            addCriterion("PROMOTER_NAME not between", value1, value2, "promoterName");
            return (Criteria) this;
        }

        public Criteria andPromoterNoIsNull() {
            addCriterion("PROMOTER_NO is null");
            return (Criteria) this;
        }

        public Criteria andPromoterNoIsNotNull() {
            addCriterion("PROMOTER_NO is not null");
            return (Criteria) this;
        }

        public Criteria andPromoterNoEqualTo(String value) {
            addCriterion("PROMOTER_NO =", value, "promoterNo");
            return (Criteria) this;
        }

        public Criteria andPromoterNoNotEqualTo(String value) {
            addCriterion("PROMOTER_NO <>", value, "promoterNo");
            return (Criteria) this;
        }

        public Criteria andPromoterNoGreaterThan(String value) {
            addCriterion("PROMOTER_NO >", value, "promoterNo");
            return (Criteria) this;
        }

        public Criteria andPromoterNoGreaterThanOrEqualTo(String value) {
            addCriterion("PROMOTER_NO >=", value, "promoterNo");
            return (Criteria) this;
        }

        public Criteria andPromoterNoLessThan(String value) {
            addCriterion("PROMOTER_NO <", value, "promoterNo");
            return (Criteria) this;
        }

        public Criteria andPromoterNoLessThanOrEqualTo(String value) {
            addCriterion("PROMOTER_NO <=", value, "promoterNo");
            return (Criteria) this;
        }

        public Criteria andPromoterNoLike(String value) {
            addCriterion("PROMOTER_NO like", value, "promoterNo");
            return (Criteria) this;
        }

        public Criteria andPromoterNoNotLike(String value) {
            addCriterion("PROMOTER_NO not like", value, "promoterNo");
            return (Criteria) this;
        }

        public Criteria andPromoterNoIn(List<String> values) {
            addCriterion("PROMOTER_NO in", values, "promoterNo");
            return (Criteria) this;
        }

        public Criteria andPromoterNoNotIn(List<String> values) {
            addCriterion("PROMOTER_NO not in", values, "promoterNo");
            return (Criteria) this;
        }

        public Criteria andPromoterNoBetween(String value1, String value2) {
            addCriterion("PROMOTER_NO between", value1, value2, "promoterNo");
            return (Criteria) this;
        }

        public Criteria andPromoterNoNotBetween(String value1, String value2) {
            addCriterion("PROMOTER_NO not between", value1, value2, "promoterNo");
            return (Criteria) this;
        }

        public Criteria andRemitFeeTransIdIsNull() {
            addCriterion("REMIT_FEE_TRANS_ID is null");
            return (Criteria) this;
        }

        public Criteria andRemitFeeTransIdIsNotNull() {
            addCriterion("REMIT_FEE_TRANS_ID is not null");
            return (Criteria) this;
        }

        public Criteria andRemitFeeTransIdEqualTo(Long value) {
            addCriterion("REMIT_FEE_TRANS_ID =", value, "remitFeeTransId");
            return (Criteria) this;
        }

        public Criteria andRemitFeeTransIdNotEqualTo(Long value) {
            addCriterion("REMIT_FEE_TRANS_ID <>", value, "remitFeeTransId");
            return (Criteria) this;
        }

        public Criteria andRemitFeeTransIdGreaterThan(Long value) {
            addCriterion("REMIT_FEE_TRANS_ID >", value, "remitFeeTransId");
            return (Criteria) this;
        }

        public Criteria andRemitFeeTransIdGreaterThanOrEqualTo(Long value) {
            addCriterion("REMIT_FEE_TRANS_ID >=", value, "remitFeeTransId");
            return (Criteria) this;
        }

        public Criteria andRemitFeeTransIdLessThan(Long value) {
            addCriterion("REMIT_FEE_TRANS_ID <", value, "remitFeeTransId");
            return (Criteria) this;
        }

        public Criteria andRemitFeeTransIdLessThanOrEqualTo(Long value) {
            addCriterion("REMIT_FEE_TRANS_ID <=", value, "remitFeeTransId");
            return (Criteria) this;
        }

        public Criteria andRemitFeeTransIdIn(List<Long> values) {
            addCriterion("REMIT_FEE_TRANS_ID in", values, "remitFeeTransId");
            return (Criteria) this;
        }

        public Criteria andRemitFeeTransIdNotIn(List<Long> values) {
            addCriterion("REMIT_FEE_TRANS_ID not in", values, "remitFeeTransId");
            return (Criteria) this;
        }

        public Criteria andRemitFeeTransIdBetween(Long value1, Long value2) {
            addCriterion("REMIT_FEE_TRANS_ID between", value1, value2, "remitFeeTransId");
            return (Criteria) this;
        }

        public Criteria andRemitFeeTransIdNotBetween(Long value1, Long value2) {
            addCriterion("REMIT_FEE_TRANS_ID not between", value1, value2, "remitFeeTransId");
            return (Criteria) this;
        }

        public Criteria andLoaningTypeIsNull() {
            addCriterion("LOANING_TYPE is null");
            return (Criteria) this;
        }

        public Criteria andLoaningTypeIsNotNull() {
            addCriterion("LOANING_TYPE is not null");
            return (Criteria) this;
        }

        public Criteria andLoaningTypeEqualTo(Integer value) {
            addCriterion("LOANING_TYPE =", value, "loaningType");
            return (Criteria) this;
        }

        public Criteria andLoaningTypeNotEqualTo(Integer value) {
            addCriterion("LOANING_TYPE <>", value, "loaningType");
            return (Criteria) this;
        }

        public Criteria andLoaningTypeGreaterThan(Integer value) {
            addCriterion("LOANING_TYPE >", value, "loaningType");
            return (Criteria) this;
        }

        public Criteria andLoaningTypeGreaterThanOrEqualTo(Integer value) {
            addCriterion("LOANING_TYPE >=", value, "loaningType");
            return (Criteria) this;
        }

        public Criteria andLoaningTypeLessThan(Integer value) {
            addCriterion("LOANING_TYPE <", value, "loaningType");
            return (Criteria) this;
        }

        public Criteria andLoaningTypeLessThanOrEqualTo(Integer value) {
            addCriterion("LOANING_TYPE <=", value, "loaningType");
            return (Criteria) this;
        }

        public Criteria andLoaningTypeIn(List<Integer> values) {
            addCriterion("LOANING_TYPE in", values, "loaningType");
            return (Criteria) this;
        }

        public Criteria andLoaningTypeNotIn(List<Integer> values) {
            addCriterion("LOANING_TYPE not in", values, "loaningType");
            return (Criteria) this;
        }

        public Criteria andLoaningTypeBetween(Integer value1, Integer value2) {
            addCriterion("LOANING_TYPE between", value1, value2, "loaningType");
            return (Criteria) this;
        }

        public Criteria andLoaningTypeNotBetween(Integer value1, Integer value2) {
            addCriterion("LOANING_TYPE not between", value1, value2, "loaningType");
            return (Criteria) this;
        }

        public Criteria andApplyTimeIsNull() {
            addCriterion("APPLY_TIME is null");
            return (Criteria) this;
        }

        public Criteria andApplyTimeIsNotNull() {
            addCriterion("APPLY_TIME is not null");
            return (Criteria) this;
        }

        public Criteria andApplyTimeEqualTo(Date value) {
            addCriterion("APPLY_TIME =", value, "applyTime");
            return (Criteria) this;
        }

        public Criteria andApplyTimeNotEqualTo(Date value) {
            addCriterion("APPLY_TIME <>", value, "applyTime");
            return (Criteria) this;
        }

        public Criteria andApplyTimeGreaterThan(Date value) {
            addCriterion("APPLY_TIME >", value, "applyTime");
            return (Criteria) this;
        }

        public Criteria andApplyTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("APPLY_TIME >=", value, "applyTime");
            return (Criteria) this;
        }

        public Criteria andApplyTimeLessThan(Date value) {
            addCriterion("APPLY_TIME <", value, "applyTime");
            return (Criteria) this;
        }

        public Criteria andApplyTimeLessThanOrEqualTo(Date value) {
            addCriterion("APPLY_TIME <=", value, "applyTime");
            return (Criteria) this;
        }

        public Criteria andApplyTimeIn(List<Date> values) {
            addCriterion("APPLY_TIME in", values, "applyTime");
            return (Criteria) this;
        }

        public Criteria andApplyTimeNotIn(List<Date> values) {
            addCriterion("APPLY_TIME not in", values, "applyTime");
            return (Criteria) this;
        }

        public Criteria andApplyTimeBetween(Date value1, Date value2) {
            addCriterion("APPLY_TIME between", value1, value2, "applyTime");
            return (Criteria) this;
        }

        public Criteria andApplyTimeNotBetween(Date value1, Date value2) {
            addCriterion("APPLY_TIME not between", value1, value2, "applyTime");
            return (Criteria) this;
        }

        public Criteria andWithdrawResponseCodeIsNull() {
            addCriterion("WITHDRAW_RESPONSE_CODE is null");
            return (Criteria) this;
        }

        public Criteria andWithdrawResponseCodeIsNotNull() {
            addCriterion("WITHDRAW_RESPONSE_CODE is not null");
            return (Criteria) this;
        }

        public Criteria andWithdrawResponseCodeEqualTo(String value) {
            addCriterion("WITHDRAW_RESPONSE_CODE =", value, "withdrawResponseCode");
            return (Criteria) this;
        }

        public Criteria andWithdrawResponseCodeNotEqualTo(String value) {
            addCriterion("WITHDRAW_RESPONSE_CODE <>", value, "withdrawResponseCode");
            return (Criteria) this;
        }

        public Criteria andWithdrawResponseCodeGreaterThan(String value) {
            addCriterion("WITHDRAW_RESPONSE_CODE >", value, "withdrawResponseCode");
            return (Criteria) this;
        }

        public Criteria andWithdrawResponseCodeGreaterThanOrEqualTo(String value) {
            addCriterion("WITHDRAW_RESPONSE_CODE >=", value, "withdrawResponseCode");
            return (Criteria) this;
        }

        public Criteria andWithdrawResponseCodeLessThan(String value) {
            addCriterion("WITHDRAW_RESPONSE_CODE <", value, "withdrawResponseCode");
            return (Criteria) this;
        }

        public Criteria andWithdrawResponseCodeLessThanOrEqualTo(String value) {
            addCriterion("WITHDRAW_RESPONSE_CODE <=", value, "withdrawResponseCode");
            return (Criteria) this;
        }

        public Criteria andWithdrawResponseCodeLike(String value) {
            addCriterion("WITHDRAW_RESPONSE_CODE like", value, "withdrawResponseCode");
            return (Criteria) this;
        }

        public Criteria andWithdrawResponseCodeNotLike(String value) {
            addCriterion("WITHDRAW_RESPONSE_CODE not like", value, "withdrawResponseCode");
            return (Criteria) this;
        }

        public Criteria andWithdrawResponseCodeIn(List<String> values) {
            addCriterion("WITHDRAW_RESPONSE_CODE in", values, "withdrawResponseCode");
            return (Criteria) this;
        }

        public Criteria andWithdrawResponseCodeNotIn(List<String> values) {
            addCriterion("WITHDRAW_RESPONSE_CODE not in", values, "withdrawResponseCode");
            return (Criteria) this;
        }

        public Criteria andWithdrawResponseCodeBetween(String value1, String value2) {
            addCriterion("WITHDRAW_RESPONSE_CODE between", value1, value2, "withdrawResponseCode");
            return (Criteria) this;
        }

        public Criteria andWithdrawResponseCodeNotBetween(String value1, String value2) {
            addCriterion("WITHDRAW_RESPONSE_CODE not between", value1, value2, "withdrawResponseCode");
            return (Criteria) this;
        }

        public Criteria andWithdrawResponseMsgIsNull() {
            addCriterion("WITHDRAW_RESPONSE_MSG is null");
            return (Criteria) this;
        }

        public Criteria andWithdrawResponseMsgIsNotNull() {
            addCriterion("WITHDRAW_RESPONSE_MSG is not null");
            return (Criteria) this;
        }

        public Criteria andWithdrawResponseMsgEqualTo(String value) {
            addCriterion("WITHDRAW_RESPONSE_MSG =", value, "withdrawResponseMsg");
            return (Criteria) this;
        }

        public Criteria andWithdrawResponseMsgNotEqualTo(String value) {
            addCriterion("WITHDRAW_RESPONSE_MSG <>", value, "withdrawResponseMsg");
            return (Criteria) this;
        }

        public Criteria andWithdrawResponseMsgGreaterThan(String value) {
            addCriterion("WITHDRAW_RESPONSE_MSG >", value, "withdrawResponseMsg");
            return (Criteria) this;
        }

        public Criteria andWithdrawResponseMsgGreaterThanOrEqualTo(String value) {
            addCriterion("WITHDRAW_RESPONSE_MSG >=", value, "withdrawResponseMsg");
            return (Criteria) this;
        }

        public Criteria andWithdrawResponseMsgLessThan(String value) {
            addCriterion("WITHDRAW_RESPONSE_MSG <", value, "withdrawResponseMsg");
            return (Criteria) this;
        }

        public Criteria andWithdrawResponseMsgLessThanOrEqualTo(String value) {
            addCriterion("WITHDRAW_RESPONSE_MSG <=", value, "withdrawResponseMsg");
            return (Criteria) this;
        }

        public Criteria andWithdrawResponseMsgLike(String value) {
            addCriterion("WITHDRAW_RESPONSE_MSG like", value, "withdrawResponseMsg");
            return (Criteria) this;
        }

        public Criteria andWithdrawResponseMsgNotLike(String value) {
            addCriterion("WITHDRAW_RESPONSE_MSG not like", value, "withdrawResponseMsg");
            return (Criteria) this;
        }

        public Criteria andWithdrawResponseMsgIn(List<String> values) {
            addCriterion("WITHDRAW_RESPONSE_MSG in", values, "withdrawResponseMsg");
            return (Criteria) this;
        }

        public Criteria andWithdrawResponseMsgNotIn(List<String> values) {
            addCriterion("WITHDRAW_RESPONSE_MSG not in", values, "withdrawResponseMsg");
            return (Criteria) this;
        }

        public Criteria andWithdrawResponseMsgBetween(String value1, String value2) {
            addCriterion("WITHDRAW_RESPONSE_MSG between", value1, value2, "withdrawResponseMsg");
            return (Criteria) this;
        }

        public Criteria andWithdrawResponseMsgNotBetween(String value1, String value2) {
            addCriterion("WITHDRAW_RESPONSE_MSG not between", value1, value2, "withdrawResponseMsg");
            return (Criteria) this;
        }

        public Criteria andWithdrawResponseTimeIsNull() {
            addCriterion("WITHDRAW_RESPONSE_TIME is null");
            return (Criteria) this;
        }

        public Criteria andWithdrawResponseTimeIsNotNull() {
            addCriterion("WITHDRAW_RESPONSE_TIME is not null");
            return (Criteria) this;
        }

        public Criteria andWithdrawResponseTimeEqualTo(Date value) {
            addCriterion("WITHDRAW_RESPONSE_TIME =", value, "withdrawResponseTime");
            return (Criteria) this;
        }

        public Criteria andWithdrawResponseTimeNotEqualTo(Date value) {
            addCriterion("WITHDRAW_RESPONSE_TIME <>", value, "withdrawResponseTime");
            return (Criteria) this;
        }

        public Criteria andWithdrawResponseTimeGreaterThan(Date value) {
            addCriterion("WITHDRAW_RESPONSE_TIME >", value, "withdrawResponseTime");
            return (Criteria) this;
        }

        public Criteria andWithdrawResponseTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("WITHDRAW_RESPONSE_TIME >=", value, "withdrawResponseTime");
            return (Criteria) this;
        }

        public Criteria andWithdrawResponseTimeLessThan(Date value) {
            addCriterion("WITHDRAW_RESPONSE_TIME <", value, "withdrawResponseTime");
            return (Criteria) this;
        }

        public Criteria andWithdrawResponseTimeLessThanOrEqualTo(Date value) {
            addCriterion("WITHDRAW_RESPONSE_TIME <=", value, "withdrawResponseTime");
            return (Criteria) this;
        }

        public Criteria andWithdrawResponseTimeIn(List<Date> values) {
            addCriterion("WITHDRAW_RESPONSE_TIME in", values, "withdrawResponseTime");
            return (Criteria) this;
        }

        public Criteria andWithdrawResponseTimeNotIn(List<Date> values) {
            addCriterion("WITHDRAW_RESPONSE_TIME not in", values, "withdrawResponseTime");
            return (Criteria) this;
        }

        public Criteria andWithdrawResponseTimeBetween(Date value1, Date value2) {
            addCriterion("WITHDRAW_RESPONSE_TIME between", value1, value2, "withdrawResponseTime");
            return (Criteria) this;
        }

        public Criteria andWithdrawResponseTimeNotBetween(Date value1, Date value2) {
            addCriterion("WITHDRAW_RESPONSE_TIME not between", value1, value2, "withdrawResponseTime");
            return (Criteria) this;
        }
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table TB_MERCHANT_FS_REQ
     *
     * @mbggenerated do_not_delete_during_merge Fri Dec 25 17:57:04 CST 2015
     */
    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table TB_MERCHANT_FS_REQ
     * table comment :商户快速结算申请记录
     *
     * @mbggenerated Fri Dec 25 17:57:04 CST 2015
     */
    public static class Criterion {
        private String condition;

        private Object value;

        private Object secondValue;

        private boolean noValue;

        private boolean singleValue;

        private boolean betweenValue;

        private boolean listValue;

        private String typeHandler;

        public String getCondition() {
            return condition;
        }

        public Object getValue() {
            return value;
        }

        public Object getSecondValue() {
            return secondValue;
        }

        public boolean isNoValue() {
            return noValue;
        }

        public boolean isSingleValue() {
            return singleValue;
        }

        public boolean isBetweenValue() {
            return betweenValue;
        }

        public boolean isListValue() {
            return listValue;
        }

        public String getTypeHandler() {
            return typeHandler;
        }

        protected Criterion(String condition) {
            super();
            this.condition = condition;
            this.typeHandler = null;
            this.noValue = true;
        }

        protected Criterion(String condition, Object value, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.typeHandler = typeHandler;
            if (value instanceof List<?>) {
                this.listValue = true;
            } else {
                this.singleValue = true;
            }
        }

        protected Criterion(String condition, Object value) {
            this(condition, value, null);
        }

        protected Criterion(String condition, Object value, Object secondValue, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.secondValue = secondValue;
            this.typeHandler = typeHandler;
            this.betweenValue = true;
        }

        protected Criterion(String condition, Object value, Object secondValue) {
            this(condition, value, secondValue, null);
        }
    }
}
