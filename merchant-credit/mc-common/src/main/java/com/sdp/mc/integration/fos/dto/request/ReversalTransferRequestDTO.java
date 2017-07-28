package com.sdp.mc.integration.fos.dto.request;

import java.math.BigDecimal;

public class ReversalTransferRequestDTO {
	/**
	 * 代理商会员号-必传
	 * **/
	private String promoterMemberId;
	/**
	 * 代理商储值帐号-必传
	 * **/
	private String promoterAccountId;
	/** 冲正额度-必传 **/
	private BigDecimal reversalAmount;

	/** 冲正转账id--重试才传 */
	private Long reversalFosId;

	public String getPromoterMemberId() {
		return promoterMemberId;
	}

	public void setPromoterMemberId(String promoterMemberId) {
		this.promoterMemberId = promoterMemberId;
	}

	public String getPromoterAccountId() {
		return promoterAccountId;
	}

	public void setPromoterAccountId(String promoterAccountId) {
		this.promoterAccountId = promoterAccountId;
	}

	public BigDecimal getReversalAmount() {
		return reversalAmount;
	}

	public void setReversalAmount(BigDecimal reversalAmount) {
		this.reversalAmount = reversalAmount;
	}

	public Long getReversalFosId() {
		return reversalFosId;
	}

	public void setReversalFosId(Long reversalFosId) {
		this.reversalFosId = reversalFosId;
	}
}
