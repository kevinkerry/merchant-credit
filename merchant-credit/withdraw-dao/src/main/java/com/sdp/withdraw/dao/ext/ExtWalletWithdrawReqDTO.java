package com.sdp.withdraw.dao.ext;

import java.math.BigDecimal;
import java.util.Date;

import com.sdp.withdraw.dao.WalletWithdrawReqDO;

public class ExtWalletWithdrawReqDTO extends WalletWithdrawReqDO {
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
	 * 出款费率
	 */
	private BigDecimal withdrawFee;
	/**
	 * 出款费用
	 */
	private BigDecimal withdrawCost;
	/**
	 * 出款费用
	 */
	private BigDecimal wdCost;
	/**
	 * 出款类型
	 */
	private String withdrawType;
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
    
    private Date startTime;
	/**
	 * 结束时间
	 */
	private Date endTime;
	/**
	 * 每頁默認10條
	 */
	private Integer pageSize;
	/**
	 * 每頁默認10條
	 */
	private Integer serviceType;
	/**
	 * 当前页
	 */
	private Integer pageNo;
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
	public String getWithdrawType() {
		return withdrawType;
	}
	public void setWithdrawType(String withdrawType) {
		this.withdrawType = withdrawType;
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
	public Date getApplyTime() {
		return applyTime;
	}
	public void setApplyTime(Date applyTime) {
		this.applyTime = applyTime;
	}
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
	public Date getStartTime() {
		return startTime;
	}
	public void setStartTime(Date startTime) {
		this.startTime = startTime;
	}
	public Date getEndTime() {
		return endTime;
	}
	public void setEndTime(Date endTime) {
		this.endTime = endTime;
	}
	public Integer getPageSize() {
		return pageSize;
	}
	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}
	public Integer getPageNo() {
		return pageNo;
	}
	public void setPageNo(Integer pageNo) {
		this.pageNo = pageNo;
	}
	public BigDecimal getWdCost() {
		return wdCost;
	}
	public void setWdCost(BigDecimal wdCost) {
		this.wdCost = wdCost;
	}
	public Integer getServiceType() {
		return serviceType;
	}
	public void setServiceType(Integer serviceType) {
		this.serviceType = serviceType;
	}
	
	
    
    
}
