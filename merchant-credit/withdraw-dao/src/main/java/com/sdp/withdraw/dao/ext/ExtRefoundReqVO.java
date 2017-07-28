package com.sdp.withdraw.dao.ext;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
/**
 * 出款信息扩展
 * @author zhangyulong
 *
 */
public class ExtRefoundReqVO implements Serializable{

	/**
	 *
	 */
	private static final long serialVersionUID = -6053617149348129156L;

	/**
	 * 出款业务请求ID
	 */
	private Long reqId;
	/**
	 * 请求类型  1:POS发起出款  2 余额发起出款'
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
	 * 出款类型  1：实时出款 2 普通出款
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
	 * 出款状态  -1 初始  0 出款成功 1 处理中 9出款失败
	 */
	private String status;
	/**
	 * 退款状态
	 */
	private String remitStatus;

	/**
	 * 出款时间
	 */
	private Date withdrawTime;

	private Date createTime;

	private Date remitTime;
	/**
	 * 是否可以发起退款
	 */
	private boolean isCanRefound;
	/**
	 * 操作人
	 */
	private String  opertator;
	/**
	 * 提现费用
	 */
	private BigDecimal wdCost;
	/**
	 * 出款总费用
	 */
	private BigDecimal totalCost;

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

	public String getOpertator() {
		return opertator;
	}

	public void setOpertator(String opertator) {
		this.opertator = opertator;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getRemitStatus() {
		return remitStatus;
	}

	public void setRemitStatus(String remitStatus) {
		this.remitStatus = remitStatus;
	}

	public boolean isCanRefound() {
		return isCanRefound;
	}

	public void setCanRefound(boolean isCanRefound) {
		this.isCanRefound = isCanRefound;
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

	public Date getWithdrawTime() {
		return withdrawTime;
	}

	public void setWithdrawTime(Date withdrawTime) {
		this.withdrawTime = withdrawTime;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public Date getRemitTime() {
		return remitTime;
	}

	public void setRemitTime(Date remitTime) {
		this.remitTime = remitTime;
	}


}
