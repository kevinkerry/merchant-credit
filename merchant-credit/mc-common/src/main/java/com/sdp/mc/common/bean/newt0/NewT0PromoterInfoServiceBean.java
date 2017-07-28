package com.sdp.mc.common.bean.newt0;

import com.sdp.mc.integration.msp.PromoterInfoDTO;

public class NewT0PromoterInfoServiceBean {
	
	private PromoterInfoDTO promoterInfoDTO;
	private int fastSettleLimitFlag;
	private boolean auditFlag;

	public PromoterInfoDTO getPromoterInfoDTO() {
		return promoterInfoDTO;
	}

	public void setPromoterInfoDTO(PromoterInfoDTO promoterInfoDTO) {
		this.promoterInfoDTO = promoterInfoDTO;
	}

	public int getFastSettleLimitFlag() {
		return fastSettleLimitFlag;
	}

	public void setFastSettleLimitFlag(int fastSettleLimitFlag) {
		this.fastSettleLimitFlag = fastSettleLimitFlag;
	}

	public boolean isAuditFlag() {
		return auditFlag;
	}

	public void setAuditFlag(boolean auditFlag) {
		this.auditFlag = auditFlag;
	}
}
