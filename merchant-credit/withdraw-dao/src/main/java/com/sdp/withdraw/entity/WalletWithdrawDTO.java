package com.sdp.withdraw.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class WalletWithdrawDTO implements Serializable{
	/**
	 *
	 */
	private static final long serialVersionUID = 1513019950083842107L;
	/**
	 * 响应编码
	 */
	private String returnCode;
	/**
	 * 响应编码描述
	 */
	private String returnMsg;
	/**
	 * 出款订单号
	 */
	private String remitVoucherNo;
	/**
	 * 初始额度
	 */
	private BigDecimal originalAmount;
	/**
	 * 出款金额
	 */
	private BigDecimal withdrawAmount;
	/**
	 * 出款费率
	 */
	private BigDecimal withdrawFee;
	/**
	 * 出款费用
	 */
	private BigDecimal withdrawCost;
	/**
	 * 扩展信息
	 */
	private String extention;
	/**
	 * 出款类型
	 */
	private String withdrawType;
	/**
	 * 业务订单号
	 */
	private String orderNo;
	/**
	 * 商户号
	 */
	private String memberNo;
	/**
	 * 出款请求id号
	 */
	private String traceNo;
	/**
	 * 银行名称
	 */
	private String bankName;
	/**
	 * 卡号
	 */
	private String cardNo;
	/**
	 * 持卡人姓名
	 */
	private String name;
	/**
	 * 状态
	 */
	private String status;
	/**
	 * 提现申请时间
	 */
	private Date applyTime;


	/**
     * 付款人储值账户ID
     */
    private String payerAccountNo;

    /**
     * 开户行
     */
    private String bankCode;
    /**
     *支行名称
     */
    private String bankBranch;
    /**
     *支行编码(联行号)
     */
    private String bankLineno;
    /**
     *  银行所属省份
     */
    private String bankProvince;
    /**
     * 银行所属城市
     */
    private String bankCity;


	

	public String getPayerAccountNo() {
		return payerAccountNo;
	}
	public void setPayerAccountNo(String payerAccountNo) {
		this.payerAccountNo = payerAccountNo;
	}
	public String getBankCode() {
		return bankCode;
	}
	public void setBankCode(String bankCode) {
		this.bankCode = bankCode;
	}
	public String getBankBranch() {
		return bankBranch;
	}
	public void setBankBranch(String bankBranch) {
		this.bankBranch = bankBranch;
	}
	public String getBankLineno() {
		return bankLineno;
	}
	public void setBankLineno(String bankLineno) {
		this.bankLineno = bankLineno;
	}
	public String getBankProvince() {
		return bankProvince;
	}
	public void setBankProvince(String bankProvince) {
		this.bankProvince = bankProvince;
	}
	public String getBankCity() {
		return bankCity;
	}
	public void setBankCity(String bankCity) {
		this.bankCity = bankCity;
	}
	
	public String getBankName() {
		return bankName;
	}
	public void setBankName(String bankName) {
		this.bankName = bankName;
	}
	public String getCardNo() {
		return cardNo;
	}
	public void setCardNo(String cardNo) {
		this.cardNo = cardNo;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public Date getApplyTime() {
		return applyTime;
	}
	public void setApplyTime(Date applyTime) {
		this.applyTime = applyTime;
	}
	public String getReturnCode() {
		return returnCode;
	}
	public void setReturnCode(String returnCode) {
		this.returnCode = returnCode;
	}
	public String getReturnMsg() {
		return returnMsg;
	}
	public void setReturnMsg(String returnMsg) {
		this.returnMsg = returnMsg;
	}
	public String getRemitVoucherNo() {
		return remitVoucherNo;
	}
	public void setRemitVoucherNo(String remitVoucherNo) {
		this.remitVoucherNo = remitVoucherNo;
	}
	public BigDecimal getOriginalAmount() {
		return originalAmount;
	}
	public void setOriginalAmount(BigDecimal originalAmount) {
		this.originalAmount = originalAmount;
	}
	public BigDecimal getWithdrawAmount() {
		return withdrawAmount;
	}
	public void setWithdrawAmount(BigDecimal withdrawAmount) {
		this.withdrawAmount = withdrawAmount;
	}
	public BigDecimal getWithdrawFee() {
		return withdrawFee;
	}
	public void setWithdrawFee(BigDecimal withdrawFee) {
		this.withdrawFee = withdrawFee;
	}
	public BigDecimal getWithdrawCost() {
		return withdrawCost;
	}
	public void setWithdrawCost(BigDecimal withdrawCost) {
		this.withdrawCost = withdrawCost;
	}
	public String getExtention() {
		return extention;
	}
	public void setExtention(String extention) {
		this.extention = extention;
	}
	public String getWithdrawType() {
		return withdrawType;
	}
	public void setWithdrawType(String withdrawType) {
		this.withdrawType = withdrawType;
	}
	public String getOrderNo() {
		return orderNo;
	}
	public void setOrderNo(String orderNo) {
		this.orderNo = orderNo;
	}
	public String getTraceNo() {
		return traceNo;
	}
	public void setTraceNo(String traceNo) {
		this.traceNo = traceNo;
	}

	public String getMemberNo() {
		return memberNo;
	}

	public void setMemberNo(String memberNo) {
		this.memberNo = memberNo;
	}
	
	

}
