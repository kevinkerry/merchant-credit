package com.sdp.mc.merchant.dao;

import com.sdp.emall.common.dao.QueryBase;
import com.sdp.mc.merchant.dao.MerchantFsTradeDOExample.Criteria;
import com.sdp.mc.merchant.dao.MerchantFsTradeDOExample.Criterion;
import com.sdp.mc.merchant.dao.MerchantFsTradeDOExample.GeneratedCriteria;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class MerchantFsTradeDOExample extends QueryBase {
	 /**
     * This field corresponds to the database column TB_MARCHAT_FS_TRADE.MFT_ID
     * column comments null
     *
     * @mbggenerated Tue Dec 29 15:50:27 CST 2015
     */
    private Long mftId;

    /**
     * This field corresponds to the database column TB_MARCHAT_FS_TRADE.MFQ_ID
     * column comments null
     *
     * @mbggenerated Tue Dec 29 15:50:27 CST 2015
     */
    private Long mfqId;

    /**
     * This field corresponds to the database column TB_MARCHAT_FS_TRADE.ORDER_NO
     * column comments null
     *
     * @mbggenerated Tue Dec 29 15:50:27 CST 2015
     */
    private String orderNo;

    /**
     * This field corresponds to the database column TB_MARCHAT_FS_TRADE.TRADE_TIME
     * column comments 交易时间
     *
     * @mbggenerated Tue Dec 29 15:50:27 CST 2015
     */
    private Date tradeTime;

    /**
     * This field corresponds to the database column TB_MARCHAT_FS_TRADE.TXN_NO
     * column comments 参考号
     *
     * @mbggenerated Tue Dec 29 15:50:27 CST 2015
     */
    private String txnNo;

    /**
     * This field corresponds to the database column TB_MARCHAT_FS_TRADE.TRADE_TYPE
     * column comments 交易类型
     *
     * @mbggenerated Tue Dec 29 15:50:27 CST 2015
     */
    private String tradeType;

    /**
     * This field corresponds to the database column TB_MARCHAT_FS_TRADE.TRADE_STATUS
     * column comments 交易状态
     *
     * @mbggenerated Tue Dec 29 15:50:27 CST 2015
     */
    private String tradeStatus;

    /**
     * This field corresponds to the database column TB_MARCHAT_FS_TRADE.TRADE_AMOUNT
     * column comments null
     *
     * @mbggenerated Tue Dec 29 15:50:27 CST 2015
     */
    private BigDecimal tradeAmount;

    /**
     * This field corresponds to the database column TB_MARCHAT_FS_TRADE.TRADE_FEE
     * column comments null
     *
     * @mbggenerated Tue Dec 29 15:50:27 CST 2015
     */
    private BigDecimal tradeFee;

    /**
     * This field corresponds to the database column TB_MARCHAT_FS_TRADE.SETTLE_AMOUNT
     * column comments null
     *
     * @mbggenerated Tue Dec 29 15:50:27 CST 2015
     */
    private BigDecimal settleAmount;

    /**
     * This field corresponds to the database column TB_MARCHAT_FS_TRADE.CARD_TYPE
     * column comments null
     *
     * @mbggenerated Tue Dec 29 15:50:27 CST 2015
     */
    private String cardType;

    /**
     * This field corresponds to the database column TB_MARCHAT_FS_TRADE.SHORT_PAN
     * column comments null
     *
     * @mbggenerated Tue Dec 29 15:50:27 CST 2015
     */
    private String shortPan;

    /**
     * This field corresponds to the database column TB_MARCHAT_FS_TRADE.ISSUER_ID
     * column comments null
     *
     * @mbggenerated Tue Dec 29 15:50:27 CST 2015
     */
    private String issuerId;

    /**
     * This field corresponds to the database column TB_MARCHAT_FS_TRADE.TERMINAL_NO
     * column comments null
     *
     * @mbggenerated Tue Dec 29 15:50:27 CST 2015
     */
    private String terminalNo;

    /**
     * This field corresponds to the database column TB_MARCHAT_FS_TRADE.CREATE_TIME
     * column comments null
     *
     * @mbggenerated Tue Dec 29 15:50:27 CST 2015
     */
    private Date createTime;

    /**
     * This field corresponds to the database column TB_MARCHAT_FS_TRADE.UPDATE_TIME
     * column comments null
     *
     * @mbggenerated Tue Dec 29 15:50:27 CST 2015
     */
    private Date updateTime;

    /**
     * This field corresponds to the database column TB_MARCHAT_FS_TRADE.TXN_STATUS
     * column comments msp交易状态码
     *
     * @mbggenerated Tue Dec 29 15:50:27 CST 2015
     */
    private String txnStatus;

    /**
     * This field corresponds to the database column TB_MARCHAT_FS_TRADE.TXN_TYPE
     * column comments msp交易类型
     *
     * @mbggenerated Tue Dec 29 15:50:27 CST 2015
     */
    private String txnType;

    /**
     * This field corresponds to the database column TB_MARCHAT_FS_TRADE.TXN_CARD_TYPE
     * column comments msp卡的类型
     *
     * @mbggenerated Tue Dec 29 15:50:27 CST 2015
     */
    private String txnCardType;

    /**
     * This field corresponds to the database column TB_MARCHAT_FS_TRADE.TXN_ISSUER_ID
     * column comments msp银行名称的id
     *
     * @mbggenerated Tue Dec 29 15:50:27 CST 2015
     */
    private String txnIssuerId;

    /**
     * This field corresponds to the database column TB_MARCHAT_FS_TRADE.TXN_SHORT_PAN
     * column comments msp银行卡缩写
     *
     * @mbggenerated Tue Dec 29 15:50:27 CST 2015
     */
    private String txnShortPan;

    /**
     * This field corresponds to the database table TB_MARCHAT_FS_TRADE
     * table comments null
     *
     * @mbggenerated Tue Dec 29 15:50:27 CST 2015
     */
    protected String orderByClause;

    /**
     * This field corresponds to the database table TB_MARCHAT_FS_TRADE
     * table comments null
     *
     * @mbggenerated Tue Dec 29 15:50:27 CST 2015
     */
    protected boolean distinct;

    /**
     * This field corresponds to the database table TB_MARCHAT_FS_TRADE
     * table comments null
     *
     * @mbggenerated Tue Dec 29 15:50:27 CST 2015
     */
    protected List<Criteria> oredCriteria;

    /**
     * This method corresponds to the database table TB_MARCHAT_FS_TRADE
     *
     * @mbggenerated Tue Dec 29 15:50:27 CST 2015
     */
    public MerchantFsTradeDOExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    /**
     * This method returns the value of the database column TB_MARCHAT_FS_TRADE.MFT_ID
     *
     * @return the value of TB_MARCHAT_FS_TRADE.MFT_ID
     * column comments null
     *
     * @mbggenerated Tue Dec 29 15:50:27 CST 2015
     */
    public Long getMftId() {
        return mftId;
    }

    /**
     * This method sets the value of the database column TB_MARCHAT_FS_TRADE.MFT_ID
     *
     * @param mftId the value for TB_MARCHAT_FS_TRADE.MFT_ID
     * column comments null
     *
     * @mbggenerated Tue Dec 29 15:50:27 CST 2015
     */
    public void setMftId(Long mftId) {
        this.mftId = mftId;
    }

    /**
     * This method returns the value of the database column TB_MARCHAT_FS_TRADE.MFQ_ID
     *
     * @return the value of TB_MARCHAT_FS_TRADE.MFQ_ID
     * column comments null
     *
     * @mbggenerated Tue Dec 29 15:50:27 CST 2015
     */
    public Long getMfqId() {
        return mfqId;
    }

    /**
     * This method sets the value of the database column TB_MARCHAT_FS_TRADE.MFQ_ID
     *
     * @param mfqId the value for TB_MARCHAT_FS_TRADE.MFQ_ID
     * column comments null
     *
     * @mbggenerated Tue Dec 29 15:50:27 CST 2015
     */
    public void setMfqId(Long mfqId) {
        this.mfqId = mfqId;
    }

    /**
     * This method returns the value of the database column TB_MARCHAT_FS_TRADE.ORDER_NO
     *
     * @return the value of TB_MARCHAT_FS_TRADE.ORDER_NO
     * column comments null
     *
     * @mbggenerated Tue Dec 29 15:50:27 CST 2015
     */
    public String getOrderNo() {
        return orderNo;
    }

    /**
     * This method sets the value of the database column TB_MARCHAT_FS_TRADE.ORDER_NO
     *
     * @param orderNo the value for TB_MARCHAT_FS_TRADE.ORDER_NO
     * column comments null
     *
     * @mbggenerated Tue Dec 29 15:50:27 CST 2015
     */
    public void setOrderNo(String orderNo) {
        this.orderNo = orderNo == null ? null : orderNo.trim();
    }

    /**
     * This method returns the value of the database column TB_MARCHAT_FS_TRADE.TRADE_TIME
     *
     * @return the value of TB_MARCHAT_FS_TRADE.TRADE_TIME
     * column comments 交易时间
     *
     * @mbggenerated Tue Dec 29 15:50:27 CST 2015
     */
    public Date getTradeTime() {
        return tradeTime;
    }

    /**
     * This method sets the value of the database column TB_MARCHAT_FS_TRADE.TRADE_TIME
     *
     * @param tradeTime the value for TB_MARCHAT_FS_TRADE.TRADE_TIME
     * column comments 交易时间
     *
     * @mbggenerated Tue Dec 29 15:50:27 CST 2015
     */
    public void setTradeTime(Date tradeTime) {
        this.tradeTime = tradeTime;
    }

    /**
     * This method returns the value of the database column TB_MARCHAT_FS_TRADE.TXN_NO
     *
     * @return the value of TB_MARCHAT_FS_TRADE.TXN_NO
     * column comments 参考号
     *
     * @mbggenerated Tue Dec 29 15:50:27 CST 2015
     */
    public String getTxnNo() {
        return txnNo;
    }

    /**
     * This method sets the value of the database column TB_MARCHAT_FS_TRADE.TXN_NO
     *
     * @param txnNo the value for TB_MARCHAT_FS_TRADE.TXN_NO
     * column comments 参考号
     *
     * @mbggenerated Tue Dec 29 15:50:27 CST 2015
     */
    public void setTxnNo(String txnNo) {
        this.txnNo = txnNo == null ? null : txnNo.trim();
    }

    /**
     * This method returns the value of the database column TB_MARCHAT_FS_TRADE.TRADE_TYPE
     *
     * @return the value of TB_MARCHAT_FS_TRADE.TRADE_TYPE
     * column comments 交易类型
     *
     * @mbggenerated Tue Dec 29 15:50:27 CST 2015
     */
    public String getTradeType() {
        return tradeType;
    }

    /**
     * This method sets the value of the database column TB_MARCHAT_FS_TRADE.TRADE_TYPE
     *
     * @param tradeType the value for TB_MARCHAT_FS_TRADE.TRADE_TYPE
     * column comments 交易类型
     *
     * @mbggenerated Tue Dec 29 15:50:27 CST 2015
     */
    public void setTradeType(String tradeType) {
        this.tradeType = tradeType == null ? null : tradeType.trim();
    }

    /**
     * This method returns the value of the database column TB_MARCHAT_FS_TRADE.TRADE_STATUS
     *
     * @return the value of TB_MARCHAT_FS_TRADE.TRADE_STATUS
     * column comments 交易状态
     *
     * @mbggenerated Tue Dec 29 15:50:27 CST 2015
     */
    public String getTradeStatus() {
        return tradeStatus;
    }

    /**
     * This method sets the value of the database column TB_MARCHAT_FS_TRADE.TRADE_STATUS
     *
     * @param tradeStatus the value for TB_MARCHAT_FS_TRADE.TRADE_STATUS
     * column comments 交易状态
     *
     * @mbggenerated Tue Dec 29 15:50:27 CST 2015
     */
    public void setTradeStatus(String tradeStatus) {
        this.tradeStatus = tradeStatus == null ? null : tradeStatus.trim();
    }

    /**
     * This method returns the value of the database column TB_MARCHAT_FS_TRADE.TRADE_AMOUNT
     *
     * @return the value of TB_MARCHAT_FS_TRADE.TRADE_AMOUNT
     * column comments null
     *
     * @mbggenerated Tue Dec 29 15:50:27 CST 2015
     */
    public BigDecimal getTradeAmount() {
        return tradeAmount;
    }

    /**
     * This method sets the value of the database column TB_MARCHAT_FS_TRADE.TRADE_AMOUNT
     *
     * @param tradeAmount the value for TB_MARCHAT_FS_TRADE.TRADE_AMOUNT
     * column comments null
     *
     * @mbggenerated Tue Dec 29 15:50:27 CST 2015
     */
    public void setTradeAmount(BigDecimal tradeAmount) {
        this.tradeAmount = tradeAmount;
    }

    /**
     * This method returns the value of the database column TB_MARCHAT_FS_TRADE.TRADE_FEE
     *
     * @return the value of TB_MARCHAT_FS_TRADE.TRADE_FEE
     * column comments null
     *
     * @mbggenerated Tue Dec 29 15:50:27 CST 2015
     */
    public BigDecimal getTradeFee() {
        return tradeFee;
    }

    /**
     * This method sets the value of the database column TB_MARCHAT_FS_TRADE.TRADE_FEE
     *
     * @param tradeFee the value for TB_MARCHAT_FS_TRADE.TRADE_FEE
     * column comments null
     *
     * @mbggenerated Tue Dec 29 15:50:27 CST 2015
     */
    public void setTradeFee(BigDecimal tradeFee) {
        this.tradeFee = tradeFee;
    }

    /**
     * This method returns the value of the database column TB_MARCHAT_FS_TRADE.SETTLE_AMOUNT
     *
     * @return the value of TB_MARCHAT_FS_TRADE.SETTLE_AMOUNT
     * column comments null
     *
     * @mbggenerated Tue Dec 29 15:50:27 CST 2015
     */
    public BigDecimal getSettleAmount() {
        return settleAmount;
    }

    /**
     * This method sets the value of the database column TB_MARCHAT_FS_TRADE.SETTLE_AMOUNT
     *
     * @param settleAmount the value for TB_MARCHAT_FS_TRADE.SETTLE_AMOUNT
     * column comments null
     *
     * @mbggenerated Tue Dec 29 15:50:27 CST 2015
     */
    public void setSettleAmount(BigDecimal settleAmount) {
        this.settleAmount = settleAmount;
    }

    /**
     * This method returns the value of the database column TB_MARCHAT_FS_TRADE.CARD_TYPE
     *
     * @return the value of TB_MARCHAT_FS_TRADE.CARD_TYPE
     * column comments null
     *
     * @mbggenerated Tue Dec 29 15:50:27 CST 2015
     */
    public String getCardType() {
        return cardType;
    }

    /**
     * This method sets the value of the database column TB_MARCHAT_FS_TRADE.CARD_TYPE
     *
     * @param cardType the value for TB_MARCHAT_FS_TRADE.CARD_TYPE
     * column comments null
     *
     * @mbggenerated Tue Dec 29 15:50:27 CST 2015
     */
    public void setCardType(String cardType) {
        this.cardType = cardType == null ? null : cardType.trim();
    }

    /**
     * This method returns the value of the database column TB_MARCHAT_FS_TRADE.SHORT_PAN
     *
     * @return the value of TB_MARCHAT_FS_TRADE.SHORT_PAN
     * column comments null
     *
     * @mbggenerated Tue Dec 29 15:50:27 CST 2015
     */
    public String getShortPan() {
        return shortPan;
    }

    /**
     * This method sets the value of the database column TB_MARCHAT_FS_TRADE.SHORT_PAN
     *
     * @param shortPan the value for TB_MARCHAT_FS_TRADE.SHORT_PAN
     * column comments null
     *
     * @mbggenerated Tue Dec 29 15:50:27 CST 2015
     */
    public void setShortPan(String shortPan) {
        this.shortPan = shortPan == null ? null : shortPan.trim();
    }

    /**
     * This method returns the value of the database column TB_MARCHAT_FS_TRADE.ISSUER_ID
     *
     * @return the value of TB_MARCHAT_FS_TRADE.ISSUER_ID
     * column comments null
     *
     * @mbggenerated Tue Dec 29 15:50:27 CST 2015
     */
    public String getIssuerId() {
        return issuerId;
    }

    /**
     * This method sets the value of the database column TB_MARCHAT_FS_TRADE.ISSUER_ID
     *
     * @param issuerId the value for TB_MARCHAT_FS_TRADE.ISSUER_ID
     * column comments null
     *
     * @mbggenerated Tue Dec 29 15:50:27 CST 2015
     */
    public void setIssuerId(String issuerId) {
        this.issuerId = issuerId == null ? null : issuerId.trim();
    }

    /**
     * This method returns the value of the database column TB_MARCHAT_FS_TRADE.TERMINAL_NO
     *
     * @return the value of TB_MARCHAT_FS_TRADE.TERMINAL_NO
     * column comments null
     *
     * @mbggenerated Tue Dec 29 15:50:27 CST 2015
     */
    public String getTerminalNo() {
        return terminalNo;
    }

    /**
     * This method sets the value of the database column TB_MARCHAT_FS_TRADE.TERMINAL_NO
     *
     * @param terminalNo the value for TB_MARCHAT_FS_TRADE.TERMINAL_NO
     * column comments null
     *
     * @mbggenerated Tue Dec 29 15:50:27 CST 2015
     */
    public void setTerminalNo(String terminalNo) {
        this.terminalNo = terminalNo == null ? null : terminalNo.trim();
    }

    /**
     * This method returns the value of the database column TB_MARCHAT_FS_TRADE.CREATE_TIME
     *
     * @return the value of TB_MARCHAT_FS_TRADE.CREATE_TIME
     * column comments null
     *
     * @mbggenerated Tue Dec 29 15:50:27 CST 2015
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * This method sets the value of the database column TB_MARCHAT_FS_TRADE.CREATE_TIME
     *
     * @param createTime the value for TB_MARCHAT_FS_TRADE.CREATE_TIME
     * column comments null
     *
     * @mbggenerated Tue Dec 29 15:50:27 CST 2015
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * This method returns the value of the database column TB_MARCHAT_FS_TRADE.UPDATE_TIME
     *
     * @return the value of TB_MARCHAT_FS_TRADE.UPDATE_TIME
     * column comments null
     *
     * @mbggenerated Tue Dec 29 15:50:27 CST 2015
     */
    public Date getUpdateTime() {
        return updateTime;
    }

    /**
     * This method sets the value of the database column TB_MARCHAT_FS_TRADE.UPDATE_TIME
     *
     * @param updateTime the value for TB_MARCHAT_FS_TRADE.UPDATE_TIME
     * column comments null
     *
     * @mbggenerated Tue Dec 29 15:50:27 CST 2015
     */
    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    /**
     * This method returns the value of the database column TB_MARCHAT_FS_TRADE.TXN_STATUS
     *
     * @return the value of TB_MARCHAT_FS_TRADE.TXN_STATUS
     * column comments msp交易状态码
     *
     * @mbggenerated Tue Dec 29 15:50:27 CST 2015
     */
    public String getTxnStatus() {
        return txnStatus;
    }

    /**
     * This method sets the value of the database column TB_MARCHAT_FS_TRADE.TXN_STATUS
     *
     * @param txnStatus the value for TB_MARCHAT_FS_TRADE.TXN_STATUS
     * column comments msp交易状态码
     *
     * @mbggenerated Tue Dec 29 15:50:27 CST 2015
     */
    public void setTxnStatus(String txnStatus) {
        this.txnStatus = txnStatus == null ? null : txnStatus.trim();
    }

    /**
     * This method returns the value of the database column TB_MARCHAT_FS_TRADE.TXN_TYPE
     *
     * @return the value of TB_MARCHAT_FS_TRADE.TXN_TYPE
     * column comments msp交易类型
     *
     * @mbggenerated Tue Dec 29 15:50:27 CST 2015
     */
    public String getTxnType() {
        return txnType;
    }

    /**
     * This method sets the value of the database column TB_MARCHAT_FS_TRADE.TXN_TYPE
     *
     * @param txnType the value for TB_MARCHAT_FS_TRADE.TXN_TYPE
     * column comments msp交易类型
     *
     * @mbggenerated Tue Dec 29 15:50:27 CST 2015
     */
    public void setTxnType(String txnType) {
        this.txnType = txnType == null ? null : txnType.trim();
    }

    /**
     * This method returns the value of the database column TB_MARCHAT_FS_TRADE.TXN_CARD_TYPE
     *
     * @return the value of TB_MARCHAT_FS_TRADE.TXN_CARD_TYPE
     * column comments msp卡的类型
     *
     * @mbggenerated Tue Dec 29 15:50:27 CST 2015
     */
    public String getTxnCardType() {
        return txnCardType;
    }

    /**
     * This method sets the value of the database column TB_MARCHAT_FS_TRADE.TXN_CARD_TYPE
     *
     * @param txnCardType the value for TB_MARCHAT_FS_TRADE.TXN_CARD_TYPE
     * column comments msp卡的类型
     *
     * @mbggenerated Tue Dec 29 15:50:27 CST 2015
     */
    public void setTxnCardType(String txnCardType) {
        this.txnCardType = txnCardType == null ? null : txnCardType.trim();
    }

    /**
     * This method returns the value of the database column TB_MARCHAT_FS_TRADE.TXN_ISSUER_ID
     *
     * @return the value of TB_MARCHAT_FS_TRADE.TXN_ISSUER_ID
     * column comments msp银行名称的id
     *
     * @mbggenerated Tue Dec 29 15:50:27 CST 2015
     */
    public String getTxnIssuerId() {
        return txnIssuerId;
    }

    /**
     * This method sets the value of the database column TB_MARCHAT_FS_TRADE.TXN_ISSUER_ID
     *
     * @param txnIssuerId the value for TB_MARCHAT_FS_TRADE.TXN_ISSUER_ID
     * column comments msp银行名称的id
     *
     * @mbggenerated Tue Dec 29 15:50:27 CST 2015
     */
    public void setTxnIssuerId(String txnIssuerId) {
        this.txnIssuerId = txnIssuerId == null ? null : txnIssuerId.trim();
    }

    /**
     * This method returns the value of the database column TB_MARCHAT_FS_TRADE.TXN_SHORT_PAN
     *
     * @return the value of TB_MARCHAT_FS_TRADE.TXN_SHORT_PAN
     * column comments msp银行卡缩写
     *
     * @mbggenerated Tue Dec 29 15:50:27 CST 2015
     */
    public String getTxnShortPan() {
        return txnShortPan;
    }

    /**
     * This method sets the value of the database column TB_MARCHAT_FS_TRADE.TXN_SHORT_PAN
     *
     * @param txnShortPan the value for TB_MARCHAT_FS_TRADE.TXN_SHORT_PAN
     * column comments msp银行卡缩写
     *
     * @mbggenerated Tue Dec 29 15:50:27 CST 2015
     */
    public void setTxnShortPan(String txnShortPan) {
        this.txnShortPan = txnShortPan == null ? null : txnShortPan.trim();
    }

    /**
     * This method corresponds to the database table TB_MARCHAT_FS_TRADE
     *
     * @mbggenerated Tue Dec 29 15:50:27 CST 2015
     */
    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    /**
     * This method corresponds to the database table TB_MARCHAT_FS_TRADE
     *
     * @mbggenerated Tue Dec 29 15:50:27 CST 2015
     */
    public String getOrderByClause() {
        return orderByClause;
    }

    /**
     * This method corresponds to the database table TB_MARCHAT_FS_TRADE
     *
     * @mbggenerated Tue Dec 29 15:50:27 CST 2015
     */
    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    /**
     * This method corresponds to the database table TB_MARCHAT_FS_TRADE
     *
     * @mbggenerated Tue Dec 29 15:50:27 CST 2015
     */
    public boolean isDistinct() {
        return distinct;
    }

    /**
     * This method corresponds to the database table TB_MARCHAT_FS_TRADE
     *
     * @mbggenerated Tue Dec 29 15:50:27 CST 2015
     */
    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    /**
     * This method corresponds to the database table TB_MARCHAT_FS_TRADE
     *
     * @mbggenerated Tue Dec 29 15:50:27 CST 2015
     */
    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    /**
     * This method corresponds to the database table TB_MARCHAT_FS_TRADE
     *
     * @mbggenerated Tue Dec 29 15:50:27 CST 2015
     */
    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    /**
     * This method corresponds to the database table TB_MARCHAT_FS_TRADE
     *
     * @mbggenerated Tue Dec 29 15:50:27 CST 2015
     */
    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    /**
     * This method corresponds to the database table TB_MARCHAT_FS_TRADE
     *
     * @mbggenerated Tue Dec 29 15:50:27 CST 2015
     */
    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    /**
     * This method corresponds to the database table TB_MARCHAT_FS_TRADE
     *
     * @mbggenerated Tue Dec 29 15:50:27 CST 2015
     */
    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table TB_MARCHAT_FS_TRADE
     * table comment :null
     *
     * @mbggenerated Tue Dec 29 15:50:27 CST 2015
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

        public Criteria andMftIdIsNull() {
            addCriterion("MFT_ID is null");
            return (Criteria) this;
        }

        public Criteria andMftIdIsNotNull() {
            addCriterion("MFT_ID is not null");
            return (Criteria) this;
        }

        public Criteria andMftIdEqualTo(Long value) {
            addCriterion("MFT_ID =", value, "mftId");
            return (Criteria) this;
        }

        public Criteria andMftIdNotEqualTo(Long value) {
            addCriterion("MFT_ID <>", value, "mftId");
            return (Criteria) this;
        }

        public Criteria andMftIdGreaterThan(Long value) {
            addCriterion("MFT_ID >", value, "mftId");
            return (Criteria) this;
        }

        public Criteria andMftIdGreaterThanOrEqualTo(Long value) {
            addCriterion("MFT_ID >=", value, "mftId");
            return (Criteria) this;
        }

        public Criteria andMftIdLessThan(Long value) {
            addCriterion("MFT_ID <", value, "mftId");
            return (Criteria) this;
        }

        public Criteria andMftIdLessThanOrEqualTo(Long value) {
            addCriterion("MFT_ID <=", value, "mftId");
            return (Criteria) this;
        }

        public Criteria andMftIdIn(List<Long> values) {
            addCriterion("MFT_ID in", values, "mftId");
            return (Criteria) this;
        }

        public Criteria andMftIdNotIn(List<Long> values) {
            addCriterion("MFT_ID not in", values, "mftId");
            return (Criteria) this;
        }

        public Criteria andMftIdBetween(Long value1, Long value2) {
            addCriterion("MFT_ID between", value1, value2, "mftId");
            return (Criteria) this;
        }

        public Criteria andMftIdNotBetween(Long value1, Long value2) {
            addCriterion("MFT_ID not between", value1, value2, "mftId");
            return (Criteria) this;
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

        public Criteria andOrderNoIsNull() {
            addCriterion("ORDER_NO is null");
            return (Criteria) this;
        }

        public Criteria andOrderNoIsNotNull() {
            addCriterion("ORDER_NO is not null");
            return (Criteria) this;
        }

        public Criteria andOrderNoEqualTo(String value) {
            addCriterion("ORDER_NO =", value, "orderNo");
            return (Criteria) this;
        }

        public Criteria andOrderNoNotEqualTo(String value) {
            addCriterion("ORDER_NO <>", value, "orderNo");
            return (Criteria) this;
        }

        public Criteria andOrderNoGreaterThan(String value) {
            addCriterion("ORDER_NO >", value, "orderNo");
            return (Criteria) this;
        }

        public Criteria andOrderNoGreaterThanOrEqualTo(String value) {
            addCriterion("ORDER_NO >=", value, "orderNo");
            return (Criteria) this;
        }

        public Criteria andOrderNoLessThan(String value) {
            addCriterion("ORDER_NO <", value, "orderNo");
            return (Criteria) this;
        }

        public Criteria andOrderNoLessThanOrEqualTo(String value) {
            addCriterion("ORDER_NO <=", value, "orderNo");
            return (Criteria) this;
        }

        public Criteria andOrderNoLike(String value) {
            addCriterion("ORDER_NO like", value, "orderNo");
            return (Criteria) this;
        }

        public Criteria andOrderNoNotLike(String value) {
            addCriterion("ORDER_NO not like", value, "orderNo");
            return (Criteria) this;
        }

        public Criteria andOrderNoIn(List<String> values) {
            addCriterion("ORDER_NO in", values, "orderNo");
            return (Criteria) this;
        }

        public Criteria andOrderNoNotIn(List<String> values) {
            addCriterion("ORDER_NO not in", values, "orderNo");
            return (Criteria) this;
        }

        public Criteria andOrderNoBetween(String value1, String value2) {
            addCriterion("ORDER_NO between", value1, value2, "orderNo");
            return (Criteria) this;
        }

        public Criteria andOrderNoNotBetween(String value1, String value2) {
            addCriterion("ORDER_NO not between", value1, value2, "orderNo");
            return (Criteria) this;
        }

        public Criteria andTradeTimeIsNull() {
            addCriterion("TRADE_TIME is null");
            return (Criteria) this;
        }

        public Criteria andTradeTimeIsNotNull() {
            addCriterion("TRADE_TIME is not null");
            return (Criteria) this;
        }

        public Criteria andTradeTimeEqualTo(Date value) {
            addCriterion("TRADE_TIME =", value, "tradeTime");
            return (Criteria) this;
        }

        public Criteria andTradeTimeNotEqualTo(Date value) {
            addCriterion("TRADE_TIME <>", value, "tradeTime");
            return (Criteria) this;
        }

        public Criteria andTradeTimeGreaterThan(Date value) {
            addCriterion("TRADE_TIME >", value, "tradeTime");
            return (Criteria) this;
        }

        public Criteria andTradeTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("TRADE_TIME >=", value, "tradeTime");
            return (Criteria) this;
        }

        public Criteria andTradeTimeLessThan(Date value) {
            addCriterion("TRADE_TIME <", value, "tradeTime");
            return (Criteria) this;
        }

        public Criteria andTradeTimeLessThanOrEqualTo(Date value) {
            addCriterion("TRADE_TIME <=", value, "tradeTime");
            return (Criteria) this;
        }

        public Criteria andTradeTimeIn(List<Date> values) {
            addCriterion("TRADE_TIME in", values, "tradeTime");
            return (Criteria) this;
        }

        public Criteria andTradeTimeNotIn(List<Date> values) {
            addCriterion("TRADE_TIME not in", values, "tradeTime");
            return (Criteria) this;
        }

        public Criteria andTradeTimeBetween(Date value1, Date value2) {
            addCriterion("TRADE_TIME between", value1, value2, "tradeTime");
            return (Criteria) this;
        }

        public Criteria andTradeTimeNotBetween(Date value1, Date value2) {
            addCriterion("TRADE_TIME not between", value1, value2, "tradeTime");
            return (Criteria) this;
        }

        public Criteria andTxnNoIsNull() {
            addCriterion("TXN_NO is null");
            return (Criteria) this;
        }

        public Criteria andTxnNoIsNotNull() {
            addCriterion("TXN_NO is not null");
            return (Criteria) this;
        }

        public Criteria andTxnNoEqualTo(String value) {
            addCriterion("TXN_NO =", value, "txnNo");
            return (Criteria) this;
        }

        public Criteria andTxnNoNotEqualTo(String value) {
            addCriterion("TXN_NO <>", value, "txnNo");
            return (Criteria) this;
        }

        public Criteria andTxnNoGreaterThan(String value) {
            addCriterion("TXN_NO >", value, "txnNo");
            return (Criteria) this;
        }

        public Criteria andTxnNoGreaterThanOrEqualTo(String value) {
            addCriterion("TXN_NO >=", value, "txnNo");
            return (Criteria) this;
        }

        public Criteria andTxnNoLessThan(String value) {
            addCriterion("TXN_NO <", value, "txnNo");
            return (Criteria) this;
        }

        public Criteria andTxnNoLessThanOrEqualTo(String value) {
            addCriterion("TXN_NO <=", value, "txnNo");
            return (Criteria) this;
        }

        public Criteria andTxnNoLike(String value) {
            addCriterion("TXN_NO like", value, "txnNo");
            return (Criteria) this;
        }

        public Criteria andTxnNoNotLike(String value) {
            addCriterion("TXN_NO not like", value, "txnNo");
            return (Criteria) this;
        }

        public Criteria andTxnNoIn(List<String> values) {
            addCriterion("TXN_NO in", values, "txnNo");
            return (Criteria) this;
        }

        public Criteria andTxnNoNotIn(List<String> values) {
            addCriterion("TXN_NO not in", values, "txnNo");
            return (Criteria) this;
        }

        public Criteria andTxnNoBetween(String value1, String value2) {
            addCriterion("TXN_NO between", value1, value2, "txnNo");
            return (Criteria) this;
        }

        public Criteria andTxnNoNotBetween(String value1, String value2) {
            addCriterion("TXN_NO not between", value1, value2, "txnNo");
            return (Criteria) this;
        }

        public Criteria andTradeTypeIsNull() {
            addCriterion("TRADE_TYPE is null");
            return (Criteria) this;
        }

        public Criteria andTradeTypeIsNotNull() {
            addCriterion("TRADE_TYPE is not null");
            return (Criteria) this;
        }

        public Criteria andTradeTypeEqualTo(String value) {
            addCriterion("TRADE_TYPE =", value, "tradeType");
            return (Criteria) this;
        }

        public Criteria andTradeTypeNotEqualTo(String value) {
            addCriterion("TRADE_TYPE <>", value, "tradeType");
            return (Criteria) this;
        }

        public Criteria andTradeTypeGreaterThan(String value) {
            addCriterion("TRADE_TYPE >", value, "tradeType");
            return (Criteria) this;
        }

        public Criteria andTradeTypeGreaterThanOrEqualTo(String value) {
            addCriterion("TRADE_TYPE >=", value, "tradeType");
            return (Criteria) this;
        }

        public Criteria andTradeTypeLessThan(String value) {
            addCriterion("TRADE_TYPE <", value, "tradeType");
            return (Criteria) this;
        }

        public Criteria andTradeTypeLessThanOrEqualTo(String value) {
            addCriterion("TRADE_TYPE <=", value, "tradeType");
            return (Criteria) this;
        }

        public Criteria andTradeTypeLike(String value) {
            addCriterion("TRADE_TYPE like", value, "tradeType");
            return (Criteria) this;
        }

        public Criteria andTradeTypeNotLike(String value) {
            addCriterion("TRADE_TYPE not like", value, "tradeType");
            return (Criteria) this;
        }

        public Criteria andTradeTypeIn(List<String> values) {
            addCriterion("TRADE_TYPE in", values, "tradeType");
            return (Criteria) this;
        }

        public Criteria andTradeTypeNotIn(List<String> values) {
            addCriterion("TRADE_TYPE not in", values, "tradeType");
            return (Criteria) this;
        }

        public Criteria andTradeTypeBetween(String value1, String value2) {
            addCriterion("TRADE_TYPE between", value1, value2, "tradeType");
            return (Criteria) this;
        }

        public Criteria andTradeTypeNotBetween(String value1, String value2) {
            addCriterion("TRADE_TYPE not between", value1, value2, "tradeType");
            return (Criteria) this;
        }

        public Criteria andTradeStatusIsNull() {
            addCriterion("TRADE_STATUS is null");
            return (Criteria) this;
        }

        public Criteria andTradeStatusIsNotNull() {
            addCriterion("TRADE_STATUS is not null");
            return (Criteria) this;
        }

        public Criteria andTradeStatusEqualTo(String value) {
            addCriterion("TRADE_STATUS =", value, "tradeStatus");
            return (Criteria) this;
        }

        public Criteria andTradeStatusNotEqualTo(String value) {
            addCriterion("TRADE_STATUS <>", value, "tradeStatus");
            return (Criteria) this;
        }

        public Criteria andTradeStatusGreaterThan(String value) {
            addCriterion("TRADE_STATUS >", value, "tradeStatus");
            return (Criteria) this;
        }

        public Criteria andTradeStatusGreaterThanOrEqualTo(String value) {
            addCriterion("TRADE_STATUS >=", value, "tradeStatus");
            return (Criteria) this;
        }

        public Criteria andTradeStatusLessThan(String value) {
            addCriterion("TRADE_STATUS <", value, "tradeStatus");
            return (Criteria) this;
        }

        public Criteria andTradeStatusLessThanOrEqualTo(String value) {
            addCriterion("TRADE_STATUS <=", value, "tradeStatus");
            return (Criteria) this;
        }

        public Criteria andTradeStatusLike(String value) {
            addCriterion("TRADE_STATUS like", value, "tradeStatus");
            return (Criteria) this;
        }

        public Criteria andTradeStatusNotLike(String value) {
            addCriterion("TRADE_STATUS not like", value, "tradeStatus");
            return (Criteria) this;
        }

        public Criteria andTradeStatusIn(List<String> values) {
            addCriterion("TRADE_STATUS in", values, "tradeStatus");
            return (Criteria) this;
        }

        public Criteria andTradeStatusNotIn(List<String> values) {
            addCriterion("TRADE_STATUS not in", values, "tradeStatus");
            return (Criteria) this;
        }

        public Criteria andTradeStatusBetween(String value1, String value2) {
            addCriterion("TRADE_STATUS between", value1, value2, "tradeStatus");
            return (Criteria) this;
        }

        public Criteria andTradeStatusNotBetween(String value1, String value2) {
            addCriterion("TRADE_STATUS not between", value1, value2, "tradeStatus");
            return (Criteria) this;
        }

        public Criteria andTradeAmountIsNull() {
            addCriterion("TRADE_AMOUNT is null");
            return (Criteria) this;
        }

        public Criteria andTradeAmountIsNotNull() {
            addCriterion("TRADE_AMOUNT is not null");
            return (Criteria) this;
        }

        public Criteria andTradeAmountEqualTo(BigDecimal value) {
            addCriterion("TRADE_AMOUNT =", value, "tradeAmount");
            return (Criteria) this;
        }

        public Criteria andTradeAmountNotEqualTo(BigDecimal value) {
            addCriterion("TRADE_AMOUNT <>", value, "tradeAmount");
            return (Criteria) this;
        }

        public Criteria andTradeAmountGreaterThan(BigDecimal value) {
            addCriterion("TRADE_AMOUNT >", value, "tradeAmount");
            return (Criteria) this;
        }

        public Criteria andTradeAmountGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("TRADE_AMOUNT >=", value, "tradeAmount");
            return (Criteria) this;
        }

        public Criteria andTradeAmountLessThan(BigDecimal value) {
            addCriterion("TRADE_AMOUNT <", value, "tradeAmount");
            return (Criteria) this;
        }

        public Criteria andTradeAmountLessThanOrEqualTo(BigDecimal value) {
            addCriterion("TRADE_AMOUNT <=", value, "tradeAmount");
            return (Criteria) this;
        }

        public Criteria andTradeAmountIn(List<BigDecimal> values) {
            addCriterion("TRADE_AMOUNT in", values, "tradeAmount");
            return (Criteria) this;
        }

        public Criteria andTradeAmountNotIn(List<BigDecimal> values) {
            addCriterion("TRADE_AMOUNT not in", values, "tradeAmount");
            return (Criteria) this;
        }

        public Criteria andTradeAmountBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("TRADE_AMOUNT between", value1, value2, "tradeAmount");
            return (Criteria) this;
        }

        public Criteria andTradeAmountNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("TRADE_AMOUNT not between", value1, value2, "tradeAmount");
            return (Criteria) this;
        }

        public Criteria andTradeFeeIsNull() {
            addCriterion("TRADE_FEE is null");
            return (Criteria) this;
        }

        public Criteria andTradeFeeIsNotNull() {
            addCriterion("TRADE_FEE is not null");
            return (Criteria) this;
        }

        public Criteria andTradeFeeEqualTo(BigDecimal value) {
            addCriterion("TRADE_FEE =", value, "tradeFee");
            return (Criteria) this;
        }

        public Criteria andTradeFeeNotEqualTo(BigDecimal value) {
            addCriterion("TRADE_FEE <>", value, "tradeFee");
            return (Criteria) this;
        }

        public Criteria andTradeFeeGreaterThan(BigDecimal value) {
            addCriterion("TRADE_FEE >", value, "tradeFee");
            return (Criteria) this;
        }

        public Criteria andTradeFeeGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("TRADE_FEE >=", value, "tradeFee");
            return (Criteria) this;
        }

        public Criteria andTradeFeeLessThan(BigDecimal value) {
            addCriterion("TRADE_FEE <", value, "tradeFee");
            return (Criteria) this;
        }

        public Criteria andTradeFeeLessThanOrEqualTo(BigDecimal value) {
            addCriterion("TRADE_FEE <=", value, "tradeFee");
            return (Criteria) this;
        }

        public Criteria andTradeFeeIn(List<BigDecimal> values) {
            addCriterion("TRADE_FEE in", values, "tradeFee");
            return (Criteria) this;
        }

        public Criteria andTradeFeeNotIn(List<BigDecimal> values) {
            addCriterion("TRADE_FEE not in", values, "tradeFee");
            return (Criteria) this;
        }

        public Criteria andTradeFeeBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("TRADE_FEE between", value1, value2, "tradeFee");
            return (Criteria) this;
        }

        public Criteria andTradeFeeNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("TRADE_FEE not between", value1, value2, "tradeFee");
            return (Criteria) this;
        }

        public Criteria andSettleAmountIsNull() {
            addCriterion("SETTLE_AMOUNT is null");
            return (Criteria) this;
        }

        public Criteria andSettleAmountIsNotNull() {
            addCriterion("SETTLE_AMOUNT is not null");
            return (Criteria) this;
        }

        public Criteria andSettleAmountEqualTo(BigDecimal value) {
            addCriterion("SETTLE_AMOUNT =", value, "settleAmount");
            return (Criteria) this;
        }

        public Criteria andSettleAmountNotEqualTo(BigDecimal value) {
            addCriterion("SETTLE_AMOUNT <>", value, "settleAmount");
            return (Criteria) this;
        }

        public Criteria andSettleAmountGreaterThan(BigDecimal value) {
            addCriterion("SETTLE_AMOUNT >", value, "settleAmount");
            return (Criteria) this;
        }

        public Criteria andSettleAmountGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("SETTLE_AMOUNT >=", value, "settleAmount");
            return (Criteria) this;
        }

        public Criteria andSettleAmountLessThan(BigDecimal value) {
            addCriterion("SETTLE_AMOUNT <", value, "settleAmount");
            return (Criteria) this;
        }

        public Criteria andSettleAmountLessThanOrEqualTo(BigDecimal value) {
            addCriterion("SETTLE_AMOUNT <=", value, "settleAmount");
            return (Criteria) this;
        }

        public Criteria andSettleAmountIn(List<BigDecimal> values) {
            addCriterion("SETTLE_AMOUNT in", values, "settleAmount");
            return (Criteria) this;
        }

        public Criteria andSettleAmountNotIn(List<BigDecimal> values) {
            addCriterion("SETTLE_AMOUNT not in", values, "settleAmount");
            return (Criteria) this;
        }

        public Criteria andSettleAmountBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("SETTLE_AMOUNT between", value1, value2, "settleAmount");
            return (Criteria) this;
        }

        public Criteria andSettleAmountNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("SETTLE_AMOUNT not between", value1, value2, "settleAmount");
            return (Criteria) this;
        }

        public Criteria andCardTypeIsNull() {
            addCriterion("CARD_TYPE is null");
            return (Criteria) this;
        }

        public Criteria andCardTypeIsNotNull() {
            addCriterion("CARD_TYPE is not null");
            return (Criteria) this;
        }

        public Criteria andCardTypeEqualTo(String value) {
            addCriterion("CARD_TYPE =", value, "cardType");
            return (Criteria) this;
        }

        public Criteria andCardTypeNotEqualTo(String value) {
            addCriterion("CARD_TYPE <>", value, "cardType");
            return (Criteria) this;
        }

        public Criteria andCardTypeGreaterThan(String value) {
            addCriterion("CARD_TYPE >", value, "cardType");
            return (Criteria) this;
        }

        public Criteria andCardTypeGreaterThanOrEqualTo(String value) {
            addCriterion("CARD_TYPE >=", value, "cardType");
            return (Criteria) this;
        }

        public Criteria andCardTypeLessThan(String value) {
            addCriterion("CARD_TYPE <", value, "cardType");
            return (Criteria) this;
        }

        public Criteria andCardTypeLessThanOrEqualTo(String value) {
            addCriterion("CARD_TYPE <=", value, "cardType");
            return (Criteria) this;
        }

        public Criteria andCardTypeLike(String value) {
            addCriterion("CARD_TYPE like", value, "cardType");
            return (Criteria) this;
        }

        public Criteria andCardTypeNotLike(String value) {
            addCriterion("CARD_TYPE not like", value, "cardType");
            return (Criteria) this;
        }

        public Criteria andCardTypeIn(List<String> values) {
            addCriterion("CARD_TYPE in", values, "cardType");
            return (Criteria) this;
        }

        public Criteria andCardTypeNotIn(List<String> values) {
            addCriterion("CARD_TYPE not in", values, "cardType");
            return (Criteria) this;
        }

        public Criteria andCardTypeBetween(String value1, String value2) {
            addCriterion("CARD_TYPE between", value1, value2, "cardType");
            return (Criteria) this;
        }

        public Criteria andCardTypeNotBetween(String value1, String value2) {
            addCriterion("CARD_TYPE not between", value1, value2, "cardType");
            return (Criteria) this;
        }

        public Criteria andShortPanIsNull() {
            addCriterion("SHORT_PAN is null");
            return (Criteria) this;
        }

        public Criteria andShortPanIsNotNull() {
            addCriterion("SHORT_PAN is not null");
            return (Criteria) this;
        }

        public Criteria andShortPanEqualTo(String value) {
            addCriterion("SHORT_PAN =", value, "shortPan");
            return (Criteria) this;
        }

        public Criteria andShortPanNotEqualTo(String value) {
            addCriterion("SHORT_PAN <>", value, "shortPan");
            return (Criteria) this;
        }

        public Criteria andShortPanGreaterThan(String value) {
            addCriterion("SHORT_PAN >", value, "shortPan");
            return (Criteria) this;
        }

        public Criteria andShortPanGreaterThanOrEqualTo(String value) {
            addCriterion("SHORT_PAN >=", value, "shortPan");
            return (Criteria) this;
        }

        public Criteria andShortPanLessThan(String value) {
            addCriterion("SHORT_PAN <", value, "shortPan");
            return (Criteria) this;
        }

        public Criteria andShortPanLessThanOrEqualTo(String value) {
            addCriterion("SHORT_PAN <=", value, "shortPan");
            return (Criteria) this;
        }

        public Criteria andShortPanLike(String value) {
            addCriterion("SHORT_PAN like", value, "shortPan");
            return (Criteria) this;
        }

        public Criteria andShortPanNotLike(String value) {
            addCriterion("SHORT_PAN not like", value, "shortPan");
            return (Criteria) this;
        }

        public Criteria andShortPanIn(List<String> values) {
            addCriterion("SHORT_PAN in", values, "shortPan");
            return (Criteria) this;
        }

        public Criteria andShortPanNotIn(List<String> values) {
            addCriterion("SHORT_PAN not in", values, "shortPan");
            return (Criteria) this;
        }

        public Criteria andShortPanBetween(String value1, String value2) {
            addCriterion("SHORT_PAN between", value1, value2, "shortPan");
            return (Criteria) this;
        }

        public Criteria andShortPanNotBetween(String value1, String value2) {
            addCriterion("SHORT_PAN not between", value1, value2, "shortPan");
            return (Criteria) this;
        }

        public Criteria andIssuerIdIsNull() {
            addCriterion("ISSUER_ID is null");
            return (Criteria) this;
        }

        public Criteria andIssuerIdIsNotNull() {
            addCriterion("ISSUER_ID is not null");
            return (Criteria) this;
        }

        public Criteria andIssuerIdEqualTo(String value) {
            addCriterion("ISSUER_ID =", value, "issuerId");
            return (Criteria) this;
        }

        public Criteria andIssuerIdNotEqualTo(String value) {
            addCriterion("ISSUER_ID <>", value, "issuerId");
            return (Criteria) this;
        }

        public Criteria andIssuerIdGreaterThan(String value) {
            addCriterion("ISSUER_ID >", value, "issuerId");
            return (Criteria) this;
        }

        public Criteria andIssuerIdGreaterThanOrEqualTo(String value) {
            addCriterion("ISSUER_ID >=", value, "issuerId");
            return (Criteria) this;
        }

        public Criteria andIssuerIdLessThan(String value) {
            addCriterion("ISSUER_ID <", value, "issuerId");
            return (Criteria) this;
        }

        public Criteria andIssuerIdLessThanOrEqualTo(String value) {
            addCriterion("ISSUER_ID <=", value, "issuerId");
            return (Criteria) this;
        }

        public Criteria andIssuerIdLike(String value) {
            addCriterion("ISSUER_ID like", value, "issuerId");
            return (Criteria) this;
        }

        public Criteria andIssuerIdNotLike(String value) {
            addCriterion("ISSUER_ID not like", value, "issuerId");
            return (Criteria) this;
        }

        public Criteria andIssuerIdIn(List<String> values) {
            addCriterion("ISSUER_ID in", values, "issuerId");
            return (Criteria) this;
        }

        public Criteria andIssuerIdNotIn(List<String> values) {
            addCriterion("ISSUER_ID not in", values, "issuerId");
            return (Criteria) this;
        }

        public Criteria andIssuerIdBetween(String value1, String value2) {
            addCriterion("ISSUER_ID between", value1, value2, "issuerId");
            return (Criteria) this;
        }

        public Criteria andIssuerIdNotBetween(String value1, String value2) {
            addCriterion("ISSUER_ID not between", value1, value2, "issuerId");
            return (Criteria) this;
        }

        public Criteria andTerminalNoIsNull() {
            addCriterion("TERMINAL_NO is null");
            return (Criteria) this;
        }

        public Criteria andTerminalNoIsNotNull() {
            addCriterion("TERMINAL_NO is not null");
            return (Criteria) this;
        }

        public Criteria andTerminalNoEqualTo(String value) {
            addCriterion("TERMINAL_NO =", value, "terminalNo");
            return (Criteria) this;
        }

        public Criteria andTerminalNoNotEqualTo(String value) {
            addCriterion("TERMINAL_NO <>", value, "terminalNo");
            return (Criteria) this;
        }

        public Criteria andTerminalNoGreaterThan(String value) {
            addCriterion("TERMINAL_NO >", value, "terminalNo");
            return (Criteria) this;
        }

        public Criteria andTerminalNoGreaterThanOrEqualTo(String value) {
            addCriterion("TERMINAL_NO >=", value, "terminalNo");
            return (Criteria) this;
        }

        public Criteria andTerminalNoLessThan(String value) {
            addCriterion("TERMINAL_NO <", value, "terminalNo");
            return (Criteria) this;
        }

        public Criteria andTerminalNoLessThanOrEqualTo(String value) {
            addCriterion("TERMINAL_NO <=", value, "terminalNo");
            return (Criteria) this;
        }

        public Criteria andTerminalNoLike(String value) {
            addCriterion("TERMINAL_NO like", value, "terminalNo");
            return (Criteria) this;
        }

        public Criteria andTerminalNoNotLike(String value) {
            addCriterion("TERMINAL_NO not like", value, "terminalNo");
            return (Criteria) this;
        }

        public Criteria andTerminalNoIn(List<String> values) {
            addCriterion("TERMINAL_NO in", values, "terminalNo");
            return (Criteria) this;
        }

        public Criteria andTerminalNoNotIn(List<String> values) {
            addCriterion("TERMINAL_NO not in", values, "terminalNo");
            return (Criteria) this;
        }

        public Criteria andTerminalNoBetween(String value1, String value2) {
            addCriterion("TERMINAL_NO between", value1, value2, "terminalNo");
            return (Criteria) this;
        }

        public Criteria andTerminalNoNotBetween(String value1, String value2) {
            addCriterion("TERMINAL_NO not between", value1, value2, "terminalNo");
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

        public Criteria andTxnStatusIsNull() {
            addCriterion("TXN_STATUS is null");
            return (Criteria) this;
        }

        public Criteria andTxnStatusIsNotNull() {
            addCriterion("TXN_STATUS is not null");
            return (Criteria) this;
        }

        public Criteria andTxnStatusEqualTo(String value) {
            addCriterion("TXN_STATUS =", value, "txnStatus");
            return (Criteria) this;
        }

        public Criteria andTxnStatusNotEqualTo(String value) {
            addCriterion("TXN_STATUS <>", value, "txnStatus");
            return (Criteria) this;
        }

        public Criteria andTxnStatusGreaterThan(String value) {
            addCriterion("TXN_STATUS >", value, "txnStatus");
            return (Criteria) this;
        }

        public Criteria andTxnStatusGreaterThanOrEqualTo(String value) {
            addCriterion("TXN_STATUS >=", value, "txnStatus");
            return (Criteria) this;
        }

        public Criteria andTxnStatusLessThan(String value) {
            addCriterion("TXN_STATUS <", value, "txnStatus");
            return (Criteria) this;
        }

        public Criteria andTxnStatusLessThanOrEqualTo(String value) {
            addCriterion("TXN_STATUS <=", value, "txnStatus");
            return (Criteria) this;
        }

        public Criteria andTxnStatusLike(String value) {
            addCriterion("TXN_STATUS like", value, "txnStatus");
            return (Criteria) this;
        }

        public Criteria andTxnStatusNotLike(String value) {
            addCriterion("TXN_STATUS not like", value, "txnStatus");
            return (Criteria) this;
        }

        public Criteria andTxnStatusIn(List<String> values) {
            addCriterion("TXN_STATUS in", values, "txnStatus");
            return (Criteria) this;
        }

        public Criteria andTxnStatusNotIn(List<String> values) {
            addCriterion("TXN_STATUS not in", values, "txnStatus");
            return (Criteria) this;
        }

        public Criteria andTxnStatusBetween(String value1, String value2) {
            addCriterion("TXN_STATUS between", value1, value2, "txnStatus");
            return (Criteria) this;
        }

        public Criteria andTxnStatusNotBetween(String value1, String value2) {
            addCriterion("TXN_STATUS not between", value1, value2, "txnStatus");
            return (Criteria) this;
        }

        public Criteria andTxnTypeIsNull() {
            addCriterion("TXN_TYPE is null");
            return (Criteria) this;
        }

        public Criteria andTxnTypeIsNotNull() {
            addCriterion("TXN_TYPE is not null");
            return (Criteria) this;
        }

        public Criteria andTxnTypeEqualTo(String value) {
            addCriterion("TXN_TYPE =", value, "txnType");
            return (Criteria) this;
        }

        public Criteria andTxnTypeNotEqualTo(String value) {
            addCriterion("TXN_TYPE <>", value, "txnType");
            return (Criteria) this;
        }

        public Criteria andTxnTypeGreaterThan(String value) {
            addCriterion("TXN_TYPE >", value, "txnType");
            return (Criteria) this;
        }

        public Criteria andTxnTypeGreaterThanOrEqualTo(String value) {
            addCriterion("TXN_TYPE >=", value, "txnType");
            return (Criteria) this;
        }

        public Criteria andTxnTypeLessThan(String value) {
            addCriterion("TXN_TYPE <", value, "txnType");
            return (Criteria) this;
        }

        public Criteria andTxnTypeLessThanOrEqualTo(String value) {
            addCriterion("TXN_TYPE <=", value, "txnType");
            return (Criteria) this;
        }

        public Criteria andTxnTypeLike(String value) {
            addCriterion("TXN_TYPE like", value, "txnType");
            return (Criteria) this;
        }

        public Criteria andTxnTypeNotLike(String value) {
            addCriterion("TXN_TYPE not like", value, "txnType");
            return (Criteria) this;
        }

        public Criteria andTxnTypeIn(List<String> values) {
            addCriterion("TXN_TYPE in", values, "txnType");
            return (Criteria) this;
        }

        public Criteria andTxnTypeNotIn(List<String> values) {
            addCriterion("TXN_TYPE not in", values, "txnType");
            return (Criteria) this;
        }

        public Criteria andTxnTypeBetween(String value1, String value2) {
            addCriterion("TXN_TYPE between", value1, value2, "txnType");
            return (Criteria) this;
        }

        public Criteria andTxnTypeNotBetween(String value1, String value2) {
            addCriterion("TXN_TYPE not between", value1, value2, "txnType");
            return (Criteria) this;
        }

        public Criteria andTxnCardTypeIsNull() {
            addCriterion("TXN_CARD_TYPE is null");
            return (Criteria) this;
        }

        public Criteria andTxnCardTypeIsNotNull() {
            addCriterion("TXN_CARD_TYPE is not null");
            return (Criteria) this;
        }

        public Criteria andTxnCardTypeEqualTo(String value) {
            addCriterion("TXN_CARD_TYPE =", value, "txnCardType");
            return (Criteria) this;
        }

        public Criteria andTxnCardTypeNotEqualTo(String value) {
            addCriterion("TXN_CARD_TYPE <>", value, "txnCardType");
            return (Criteria) this;
        }

        public Criteria andTxnCardTypeGreaterThan(String value) {
            addCriterion("TXN_CARD_TYPE >", value, "txnCardType");
            return (Criteria) this;
        }

        public Criteria andTxnCardTypeGreaterThanOrEqualTo(String value) {
            addCriterion("TXN_CARD_TYPE >=", value, "txnCardType");
            return (Criteria) this;
        }

        public Criteria andTxnCardTypeLessThan(String value) {
            addCriterion("TXN_CARD_TYPE <", value, "txnCardType");
            return (Criteria) this;
        }

        public Criteria andTxnCardTypeLessThanOrEqualTo(String value) {
            addCriterion("TXN_CARD_TYPE <=", value, "txnCardType");
            return (Criteria) this;
        }

        public Criteria andTxnCardTypeLike(String value) {
            addCriterion("TXN_CARD_TYPE like", value, "txnCardType");
            return (Criteria) this;
        }

        public Criteria andTxnCardTypeNotLike(String value) {
            addCriterion("TXN_CARD_TYPE not like", value, "txnCardType");
            return (Criteria) this;
        }

        public Criteria andTxnCardTypeIn(List<String> values) {
            addCriterion("TXN_CARD_TYPE in", values, "txnCardType");
            return (Criteria) this;
        }

        public Criteria andTxnCardTypeNotIn(List<String> values) {
            addCriterion("TXN_CARD_TYPE not in", values, "txnCardType");
            return (Criteria) this;
        }

        public Criteria andTxnCardTypeBetween(String value1, String value2) {
            addCriterion("TXN_CARD_TYPE between", value1, value2, "txnCardType");
            return (Criteria) this;
        }

        public Criteria andTxnCardTypeNotBetween(String value1, String value2) {
            addCriterion("TXN_CARD_TYPE not between", value1, value2, "txnCardType");
            return (Criteria) this;
        }

        public Criteria andTxnIssuerIdIsNull() {
            addCriterion("TXN_ISSUER_ID is null");
            return (Criteria) this;
        }

        public Criteria andTxnIssuerIdIsNotNull() {
            addCriterion("TXN_ISSUER_ID is not null");
            return (Criteria) this;
        }

        public Criteria andTxnIssuerIdEqualTo(String value) {
            addCriterion("TXN_ISSUER_ID =", value, "txnIssuerId");
            return (Criteria) this;
        }

        public Criteria andTxnIssuerIdNotEqualTo(String value) {
            addCriterion("TXN_ISSUER_ID <>", value, "txnIssuerId");
            return (Criteria) this;
        }

        public Criteria andTxnIssuerIdGreaterThan(String value) {
            addCriterion("TXN_ISSUER_ID >", value, "txnIssuerId");
            return (Criteria) this;
        }

        public Criteria andTxnIssuerIdGreaterThanOrEqualTo(String value) {
            addCriterion("TXN_ISSUER_ID >=", value, "txnIssuerId");
            return (Criteria) this;
        }

        public Criteria andTxnIssuerIdLessThan(String value) {
            addCriterion("TXN_ISSUER_ID <", value, "txnIssuerId");
            return (Criteria) this;
        }

        public Criteria andTxnIssuerIdLessThanOrEqualTo(String value) {
            addCriterion("TXN_ISSUER_ID <=", value, "txnIssuerId");
            return (Criteria) this;
        }

        public Criteria andTxnIssuerIdLike(String value) {
            addCriterion("TXN_ISSUER_ID like", value, "txnIssuerId");
            return (Criteria) this;
        }

        public Criteria andTxnIssuerIdNotLike(String value) {
            addCriterion("TXN_ISSUER_ID not like", value, "txnIssuerId");
            return (Criteria) this;
        }

        public Criteria andTxnIssuerIdIn(List<String> values) {
            addCriterion("TXN_ISSUER_ID in", values, "txnIssuerId");
            return (Criteria) this;
        }

        public Criteria andTxnIssuerIdNotIn(List<String> values) {
            addCriterion("TXN_ISSUER_ID not in", values, "txnIssuerId");
            return (Criteria) this;
        }

        public Criteria andTxnIssuerIdBetween(String value1, String value2) {
            addCriterion("TXN_ISSUER_ID between", value1, value2, "txnIssuerId");
            return (Criteria) this;
        }

        public Criteria andTxnIssuerIdNotBetween(String value1, String value2) {
            addCriterion("TXN_ISSUER_ID not between", value1, value2, "txnIssuerId");
            return (Criteria) this;
        }

        public Criteria andTxnShortPanIsNull() {
            addCriterion("TXN_SHORT_PAN is null");
            return (Criteria) this;
        }

        public Criteria andTxnShortPanIsNotNull() {
            addCriterion("TXN_SHORT_PAN is not null");
            return (Criteria) this;
        }

        public Criteria andTxnShortPanEqualTo(String value) {
            addCriterion("TXN_SHORT_PAN =", value, "txnShortPan");
            return (Criteria) this;
        }

        public Criteria andTxnShortPanNotEqualTo(String value) {
            addCriterion("TXN_SHORT_PAN <>", value, "txnShortPan");
            return (Criteria) this;
        }

        public Criteria andTxnShortPanGreaterThan(String value) {
            addCriterion("TXN_SHORT_PAN >", value, "txnShortPan");
            return (Criteria) this;
        }

        public Criteria andTxnShortPanGreaterThanOrEqualTo(String value) {
            addCriterion("TXN_SHORT_PAN >=", value, "txnShortPan");
            return (Criteria) this;
        }

        public Criteria andTxnShortPanLessThan(String value) {
            addCriterion("TXN_SHORT_PAN <", value, "txnShortPan");
            return (Criteria) this;
        }

        public Criteria andTxnShortPanLessThanOrEqualTo(String value) {
            addCriterion("TXN_SHORT_PAN <=", value, "txnShortPan");
            return (Criteria) this;
        }

        public Criteria andTxnShortPanLike(String value) {
            addCriterion("TXN_SHORT_PAN like", value, "txnShortPan");
            return (Criteria) this;
        }

        public Criteria andTxnShortPanNotLike(String value) {
            addCriterion("TXN_SHORT_PAN not like", value, "txnShortPan");
            return (Criteria) this;
        }

        public Criteria andTxnShortPanIn(List<String> values) {
            addCriterion("TXN_SHORT_PAN in", values, "txnShortPan");
            return (Criteria) this;
        }

        public Criteria andTxnShortPanNotIn(List<String> values) {
            addCriterion("TXN_SHORT_PAN not in", values, "txnShortPan");
            return (Criteria) this;
        }

        public Criteria andTxnShortPanBetween(String value1, String value2) {
            addCriterion("TXN_SHORT_PAN between", value1, value2, "txnShortPan");
            return (Criteria) this;
        }

        public Criteria andTxnShortPanNotBetween(String value1, String value2) {
            addCriterion("TXN_SHORT_PAN not between", value1, value2, "txnShortPan");
            return (Criteria) this;
        }
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table TB_MARCHAT_FS_TRADE
     *
     * @mbggenerated do_not_delete_during_merge Tue Dec 29 15:50:27 CST 2015
     */
    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table TB_MARCHAT_FS_TRADE
     * table comment :null
     *
     * @mbggenerated Tue Dec 29 15:50:27 CST 2015
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