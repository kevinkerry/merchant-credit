package com.sdp.withdraw.vo;

import java.io.Serializable;
import java.math.BigDecimal;

public class WithdrawProductResult  implements Serializable{
	/**
	 *
	 */
	private static final long serialVersionUID = 4607178768451116286L;
	/**
	 * 产品类型 T0  T1 D1
	 */
	private String productType;
	/**
	 * 额度（目前只有T0才会有额度，其余类型为0，取商户额度，代理商额度，出款剩余总额度中最小值）
	 */
	private BigDecimal amount;
	/**
	 * 费率
	 */
	private BigDecimal withdrawFee;
	/**
	 * 最低额度
	 */
	private BigDecimal floorAmount;
	/**
	 * 提示信息
	 */
	private String promptMsg;
	/**
	 * 出款类型 1：实时出款 2 普通出款
	 */
	private String withdrawType;
	/**
	 * 商户当日总额度
	 */
	private BigDecimal merchantDayAmount;
	/**
	 * mpos 出款返回信息
	 */
//	private String withdrawCostInfo;
//	public String getWithdrawCostInfo() {
//		return withdrawCostInfo;
//	}
//	public void setWithdrawCostInfo(String withdrawCostInfo) {
//		this.withdrawCostInfo = withdrawCostInfo;
//	}
	public BigDecimal getMerchantDayAmount() {
		return merchantDayAmount;
	}
	public void setMerchantDayAmount(BigDecimal merchantDayAmount) {
		this.merchantDayAmount = merchantDayAmount;
	}
	public String getWithdrawType() {
		return withdrawType;
	}
	public void setWithdrawType(String withdrawType) {
		this.withdrawType = withdrawType;
	}
	public String getProductType() {
		return productType;
	}
	public void setProductType(String productType) {
		this.productType = productType;
	}
	public BigDecimal getAmount() {
		return amount;
	}
	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}
	public BigDecimal getWithdrawFee() {
		return withdrawFee;
	}
	public void setWithdrawFee(BigDecimal withdrawFee) {
		this.withdrawFee = withdrawFee;
	}
	public BigDecimal getFloorAmount() {
		return floorAmount;
	}
	public void setFloorAmount(BigDecimal floorAmount) {
		this.floorAmount = floorAmount;
	}
	public String getPromptMsg() {
		return promptMsg;
	}
	public void setPromptMsg(String promptMsg) {
		this.promptMsg = promptMsg;
	}
}
