package com.sdp.withdraw.dao.ext;

import java.math.BigDecimal;

public class QuatoOpreationMsgVo {

	private int opType;//1:商户额度操作 2：代理商额度操作 3:盛付通额度操作
	private String pmtMerchantNo;//代理商商户号
	private String pmtMcType;//代理商类型
	private BigDecimal totalAmount;//总额度(商户、代理商)
	private BigDecimal forzenLimitation ;// 已冻结额度
	private BigDecimal usedLimitation ;//已使用额度
//	private BigDecimal canUseLimitation;//可使用额度
//	private BigDecimal frozenQuota; //冻结额度


	public QuatoOpreationMsgVo(String pmtMerchantNo, String pmtMcType,
			BigDecimal totalAmount, BigDecimal forzenLimitation,
			BigDecimal usedLimitation,int opType) {
		super();
		this.pmtMerchantNo = pmtMerchantNo;
		this.pmtMcType = pmtMcType;
		this.totalAmount = totalAmount;
		this.forzenLimitation = forzenLimitation;
		this.usedLimitation = usedLimitation;
		this.opType = opType;
	}
	public String getPmtMerchantNo() {
		return pmtMerchantNo;
	}
	public void setPmtMerchantNo(String pmtMerchantNo) {
		this.pmtMerchantNo = pmtMerchantNo;
	}
	public String getPmtMcType() {
		return pmtMcType;
	}
	public void setPmtMcType(String pmtMcType) {
		this.pmtMcType = pmtMcType;
	}
	public BigDecimal getForzenLimitation() {
		return forzenLimitation;
	}
	public void setForzenLimitation(BigDecimal forzenLimitation) {
		this.forzenLimitation = forzenLimitation;
	}
	public BigDecimal getUsedLimitation() {
		return usedLimitation;
	}
	public void setUsedLimitation(BigDecimal usedLimitation) {
		this.usedLimitation = usedLimitation;
	}
	public BigDecimal getTotalAmount() {
		return totalAmount;
	}
	public void setTotalAmount(BigDecimal totalAmount) {
		this.totalAmount = totalAmount;
	}
	public int getOpType() {
		return opType;
	}
	public void setOpType(int opType) {
		this.opType = opType;
	}
}
