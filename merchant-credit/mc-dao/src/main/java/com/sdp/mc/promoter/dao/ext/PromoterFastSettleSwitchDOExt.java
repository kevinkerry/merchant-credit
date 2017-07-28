package com.sdp.mc.promoter.dao.ext;

import com.sdp.mc.promoter.dao.PromoterFastSettleSwitchDO;

public class PromoterFastSettleSwitchDOExt extends PromoterFastSettleSwitchDO {
	private static final long serialVersionUID = 1L;
	/**
	 * 商户ID
	 */
	private Long mcMerchantId;
	/**
	 * 商户号
	 */
	private String mcMerchantNo;
	/**
	 * 商户名称
	 */
	private String mcMerchantName;

	/**
	 * 代理商名称
	 * **/
	private String promoterName;
	/**
	 * msp系统快速结算状态(1:允许快速结算    0:不允许快速结算)
	 * **/
	private Integer mspFastSettleFlag;
	/**
	 * 合同状态
	 */
	private String mcStatus;

	/**
	 * 合同类型(0003:POS商户,0007:mPOS拓展商)
	 */
	private String mcType;

	/**
	 * 商户电话
	 */
	private String merchantPhone;
	/**
	 * 垫资方
	 */
	private Integer loaningType;
	/**
	 * 代理商号
	 */
	private String promoterNo;

	public String getMcMerchantNo() {
		return mcMerchantNo;
	}

	public void setMcMerchantNo(String mcMerchantNo) {
		this.mcMerchantNo = mcMerchantNo;
	}

	public String getMcStatus() {
		return mcStatus;
	}

	public void setMcStatus(String mcStatus) {
		this.mcStatus = mcStatus;
	}

	public String getMcType() {
		return mcType;
	}

	public void setMcType(String mcType) {
		this.mcType = mcType;
	}

	public String getMcMerchantName() {
		return mcMerchantName;
	}

	public void setMcMerchantName(String mcMerchantName) {
		this.mcMerchantName = mcMerchantName;
	}

	public String getPromoterName() {
		return promoterName;
	}

	public void setPromoterName(String promoterName) {
		this.promoterName = promoterName;
	}

	public Integer getMspFastSettleFlag() {
		return mspFastSettleFlag;
	}

	public void setMspFastSettleFlag(Integer mspFastSettleFlag) {
		this.mspFastSettleFlag = mspFastSettleFlag;
	}



	public String getMerchantPhone() {
		return merchantPhone;
	}

	public void setMerchantPhone(String merchantPhone) {
		this.merchantPhone = merchantPhone;
	}

	public Long getMcMerchantId() {
		return mcMerchantId;
	}

	public void setMcMerchantId(Long mcMerchantId) {
		this.mcMerchantId = mcMerchantId;
	}

	public Integer getLoaningType() {
		return loaningType;
	}

	public void setLoaningType(Integer loaningType) {
		this.loaningType = loaningType;
	}

	public String getPromoterNo() {
		return promoterNo;
	}

	public void setPromoterNo(String promoterNo) {
		this.promoterNo = promoterNo;
	}

	@Override
	public String toString() {
		return "PromoterFastSettleSwitchDOExt [mcMerchantId=" + mcMerchantId
				+ ", mcMerchantNo=" + mcMerchantNo + ", mcMerchantName="
				+ mcMerchantName + ", promoterName=" + promoterName
				+ ", mspFastSettleFlag=" + mspFastSettleFlag + ", mcStatus="
				+ mcStatus + ", mcType=" + mcType + ", merchantPhone="
				+ merchantPhone + ", loaningType=" + loaningType
				+ ", promoterNo=" + promoterNo + "]";
	}


}
