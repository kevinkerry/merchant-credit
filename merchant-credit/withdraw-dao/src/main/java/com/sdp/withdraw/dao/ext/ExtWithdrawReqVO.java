package com.sdp.withdraw.dao.ext;

import java.math.BigDecimal;
import java.util.Date;

import com.sdp.withdraw.dao.WithdrawReqFosDetailDO;

/**
 * 出款信息扩展
 *
 * @author zhangyulong
 *
 */
public class ExtWithdrawReqVO extends WithdrawReqFosDetailDO {

	/**
	 *
	 */
	private static final long serialVersionUID = 5872458159803310479L;
	/**
	 * 出款业务请求ID
	 */
	private Long reqId;
	/**
	 * 请求类型 1:POS发起出款 2 余额发起出款'
	 */
	private Integer reqType;
	/**
	 * 应用编码
	 */
	private String appId;
	/**
	 * 请求的业务订单号
	 */
	private String orderNo;
	/**
	 * 会员ID
	 */
	private String memberId;
	/**
	 * 商户号
	 */
	private String merchantNo;
	/**
	 * 商户类型
	 */
	private String mcType;
	/**
	 * 出款类型 1：实时出款 2 普通出款
	 */
	private Integer withdrawType;
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
	 * 原始额度
	 */
	private BigDecimal originalAmount;
	/**
	 * 分润费率
	 */
	private BigDecimal splittingFee;

	/**
	 * 分润费用
	 */
	private BigDecimal splittingCost;

	/**
	 * 代理商会员ID
	 */
	private String pmtMemberId;
	/**
	 * 代理商商户号
	 */
	private String pmtMerchantNo;
	/**
	 * 出款状态 -1 初始 0 出款成功 1 处理中 9出款失败
	 */
	private Integer status;

	/**
	 * 重试次数
	 */
	private Integer retryTimes;

	/**
	 * 请求失败的编码
	 */
	private String errorCode;

	/**
	 * 请求失败的原因
	 */
	private String errorMsg;

	/**
	 * 支付结果回调地址
	 */
	private String wrCallbackAddress;

	/**
	 * 申请时间
	 */
	private Date applyTime;
	/**
	 * 出款时间
	 */
	private Date withdrawTime;

	private Date wrCreateTime;

	private Date wrUpdateTime;

	private String statusMsg;

	private BigDecimal bankAccountAmount;

	private Integer serviceType;

	private String serviceTypeMsg;

	private String merchantName;

	private String withdrawTypeMsg;
	private String pmtBindOperatorName;
	/**
	 * 提现费用
	 */
	private BigDecimal wdCost;
	/**
	 * 出款总费用
	 */
	private BigDecimal totalCost;
	/**
	 * 商户的mcc
	 */
	private String mcc;
	
	private String hasOaTxn;

	public BigDecimal getTotalCost() {
		return totalCost;
	}

	public void setTotalCost(BigDecimal totalCost) {
		this.totalCost = totalCost;
	}

	public BigDecimal getWdCost() {
		return wdCost;
	}

	public void setWdCost(BigDecimal wdCost) {
		this.wdCost = wdCost;
	}

	public String getPmtBindOperatorName() {
		return pmtBindOperatorName;
	}

	public void setPmtBindOperatorName(String pmtBindOperatorName) {
		this.pmtBindOperatorName = pmtBindOperatorName;
	}

	public Long getReqId() {
		return reqId;
	}

	public void setReqId(Long reqId) {
		this.reqId = reqId;
	}

	public Integer getReqType() {
		return reqType;
	}

	public void setReqType(Integer reqType) {
		this.reqType = reqType;
	}

	public String getAppId() {
		return appId;
	}

	public void setAppId(String appId) {
		this.appId = appId;
	}

	public String getOrderNo() {
		return orderNo;
	}

	public void setOrderNo(String orderNo) {
		this.orderNo = orderNo;
	}

	public String getMemberId() {
		return memberId;
	}

	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}

	public String getMerchantNo() {
		return merchantNo;
	}

	public void setMerchantNo(String merchantNo) {
		this.merchantNo = merchantNo;
	}

	public String getMcType() {
		return mcType;
	}

	public void setMcType(String mcType) {
		this.mcType = mcType;
	}

	public Integer getWithdrawType() {
		return withdrawType;
	}

	public void setWithdrawType(Integer withdrawType) {
		this.withdrawType = withdrawType;
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

	public BigDecimal getOriginalAmount() {
		return originalAmount;
	}

	public void setOriginalAmount(BigDecimal originalAmount) {
		this.originalAmount = originalAmount;
	}

	public BigDecimal getSplittingFee() {
		return splittingFee;
	}

	public void setSplittingFee(BigDecimal splittingFee) {
		this.splittingFee = splittingFee;
	}

	public BigDecimal getSplittingCost() {
		return splittingCost;
	}

	public void setSplittingCost(BigDecimal splittingCost) {
		this.splittingCost = splittingCost;
	}

	public String getPmtMemberId() {
		return pmtMemberId;
	}

	public void setPmtMemberId(String pmtMemberId) {
		this.pmtMemberId = pmtMemberId;
	}

	public String getPmtMerchantNo() {
		return pmtMerchantNo;
	}

	public void setPmtMerchantNo(String pmtMerchantNo) {
		this.pmtMerchantNo = pmtMerchantNo;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public Integer getRetryTimes() {
		return retryTimes;
	}

	public void setRetryTimes(Integer retryTimes) {
		this.retryTimes = retryTimes;
	}

	public String getErrorCode() {
		return errorCode;
	}

	public void setErrorCode(String errorCode) {
		this.errorCode = errorCode;
	}

	public String getErrorMsg() {
		return errorMsg;
	}

	public void setErrorMsg(String errorMsg) {
		this.errorMsg = errorMsg;
	}

	public Date getApplyTime() {
		return applyTime;
	}

	public void setApplyTime(Date applyTime) {
		this.applyTime = applyTime;
	}

	public String getWrCallbackAddress() {
		return wrCallbackAddress;
	}

	public void setWrCallbackAddress(String wrCallbackAddress) {
		this.wrCallbackAddress = wrCallbackAddress;
	}

	public Date getWrCreateTime() {
		return wrCreateTime;
	}

	public void setWrCreateTime(Date wrCreateTime) {
		this.wrCreateTime = wrCreateTime;
	}

	public Date getWrUpdateTime() {
		return wrUpdateTime;
	}

	public void setWrUpdateTime(Date wrUpdateTime) {
		this.wrUpdateTime = wrUpdateTime;
	}

	public String getStatusMsg() {
		return statusMsg;
	}

	public void setStatusMsg(String statusMsg) {
		this.statusMsg = statusMsg;
	}

	public Date getWithdrawTime() {
		return withdrawTime;
	}

	public void setWithdrawTime(Date withdrawTime) {
		this.withdrawTime = withdrawTime;
	}

	public BigDecimal getBankAccountAmount() {
		return bankAccountAmount;
	}

	public void setBankAccountAmount(BigDecimal bankAccountAmount) {
		this.bankAccountAmount = bankAccountAmount;
	}

	public Integer getServiceType() {
		return serviceType;
	}

	public void setServiceType(Integer serviceType) {
		this.serviceType = serviceType;
	}

	public String getServiceTypeMsg() {
		return serviceTypeMsg;
	}

	public void setServiceTypeMsg(String serviceTypeMsg) {
		this.serviceTypeMsg = serviceTypeMsg;
	}

	public String getMerchantName() {
		return merchantName;
	}

	public void setMerchantName(String merchantName) {
		this.merchantName = merchantName;
	}

	public String getWithdrawTypeMsg() {
		return withdrawTypeMsg;
	}

	public void setWithdrawTypeMsg(String withdrawTypeMsg) {
		this.withdrawTypeMsg = withdrawTypeMsg;
	}

	public String getMcc() {
		return mcc;
	}

	public void setMcc(String mcc) {
		this.mcc = mcc;
	}

	public String getHasOaTxn() {
		return hasOaTxn;
	}

	public void setHasOaTxn(String hasOaTxn) {
		this.hasOaTxn = hasOaTxn;
	}
	

}
