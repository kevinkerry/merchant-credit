package com.sdp.mc.integration.msp.request;

import java.math.BigDecimal;

import com.sdp.mc.integration.msp.MerchantInfoDTO;

public class MspModifyRequest extends MerchantInfoDTO {
	
	private BigDecimal promoterMinMargin;

	public MspModifyRequest() {
	}

	public MspModifyRequest(int objType, Long objId, int opType) {
		super.setOpType(opType);
		super.setObjId(objId);
		super.setObjType(objType);
	}

	@Override
	public String toString() {
		return "MspModifyRequest [" + (getFastSettleLimit() != null ? "getFastSettleLimit()=" + getFastSettleLimit() + ", " : "")
				+ (getPosMerchantNo() != null ? "getPosMerchantNo()=" + getPosMerchantNo() + ", " : "")
				+ (getBusinessManager() != null ? "getBusinessManager()=" + getBusinessManager() + ", " : "")
				+ (getMerchantNo() != null ? "getMerchantNo()=" + getMerchantNo() + ", " : "")
				+ (getMcTypeName() != null ? "getMcTypeName()=" + getMcTypeName() + ", " : "")
				+ (getMcType() != null ? "getMcType()=" + getMcType() + ", " : "")
				+ (getPosmMposSalesType() != null ? "getPosmMposSalesType()=" + getPosmMposSalesType() + ", " : "")
				+ (getPosmRelyElecSignFlag() != null ? "getPosmRelyElecSignFlag()=" + getPosmRelyElecSignFlag() + ", " : "")
				+ (getTerminalCount() != null ? "getTerminalCount()=" + getTerminalCount() + ", " : "")
				+ (getMerchantId() != null ? "getMerchantId()=" + getMerchantId() + ", " : "")
				+ (getFastSettleWorkdayFee() != null ? "getFastSettleWorkdayFee()=" + getFastSettleWorkdayFee() + ", " : "")
				+ (getFastSettleHolidayFee() != null ? "getFastSettleHolidayFee()=" + getFastSettleHolidayFee() + ", " : "")
				+ (getAutoFastSettle() != null ? "getAutoFastSettle()=" + getAutoFastSettle() + ", " : "")
				+ (getMerchantPhone() != null ? "getMerchantPhone()=" + getMerchantPhone() + ", " : "")
				+ (getMcc() != null ? "getMcc()=" + getMcc() + ", " : "")
				+ (getRemainConfigureLimit() != null ? "getRemainConfigureLimit()=" + getRemainConfigureLimit() + ", " : "")
				+ (getValidCredit() != null ? "getValidCredit()=" + getValidCredit() + ", " : "")
				+ (getPromoterType() != null ? "getPromoterType()=" + getPromoterType() + ", " : "") + "getPromoterNo()=" + getPromoterNo()
				+ ", getPromoterId()=" + getPromoterId() + ", "
				+ (getFastSettleMargin() != null ? "getFastSettleMargin()=" + getFastSettleMargin() + ", " : "")
				+ (getFastConfigureLimit() != null ? "getFastConfigureLimit()=" + getFastConfigureLimit() + ", " : "")
				+ (getFastSettleRatio() != null ? "getFastSettleRatio()=" + getFastSettleRatio() + ", " : "")
				+ (getBusinessManager() != null ? "getBusinessManager()=" + getBusinessManager() + ", " : "")
				+ (super.toString() != null ? "toString()=" + super.toString() + ", " : "") + "getObjId()=" + getObjId() + ", getOpType()="
				+ getOpType() + ", getObjType()=" + getObjType() + ", " + (getName() != null ? "getName()=" + getName() + ", " : "")
				+ (getStatus() != null ? "getStatus()=" + getStatus() + ", " : "") + "getFastSettleFlag()=" + getFastSettleFlag() + ", "
				+ (getCreateTime() != null ? "getCreateTime()=" + getCreateTime() + ", " : "")
				+ (getClass() != null ? "getClass()=" + getClass() + ", " : "") + "hashCode()=" + hashCode() + "]";
	}

	public BigDecimal getPromoterMinMargin() {
		return promoterMinMargin;
	}

	public void setPromoterMinMargin(BigDecimal promoterMinMargin) {
		this.promoterMinMargin = promoterMinMargin;
	}
	

}
