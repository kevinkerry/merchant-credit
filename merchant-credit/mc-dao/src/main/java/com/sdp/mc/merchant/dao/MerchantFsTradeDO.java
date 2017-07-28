package com.sdp.mc.merchant.dao;

import com.sdp.emall.common.dao.BaseDO;

import java.math.BigDecimal;
import java.util.Date;

public class MerchantFsTradeDO extends BaseDO {
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
}