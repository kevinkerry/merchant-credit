package com.sdp.mc.dao.readonly.merchant;

import java.util.Date;

import com.sdp.mc.dao.readonly.merchantcontract.CmMerchantContractEO;

/**
 * (cm)POS商户
 * @author liuxi.xiliu
 */
public class CmPosMerchantEO extends CmMerchantContractEO{
	
	private Long posmId;
	
	private String posmPosMerchantNo;
	
	private Long posmMerchantType;
	
	private Long posmMerchantLevel;
	
	private String posmSalesManager;
	
	private Long posmDistrictId;
	
	private String posmAddress;
	
	private Long posmExternalMccId;
	
	private Long posmInternalMccId;
	
	private Long posmPromoterId;
	
	private Boolean posmAllopatryReturnGoods;
	
	private Boolean posmManualAuthComplete;
	
	private Boolean posmCascadeAuthCancel;
	
	private Boolean posmBankCardDeal;
	
	private Boolean posmPpcCardDeal;
	
	private String posmExpandBitmap;
	
	private Long posmVersion;
	
	private Date posmCreateTime;
	
	private Date posmLastUpdateTime;
	
	private String posmExternalMccName;
	
	private String posmInternalMccName;
	
	private String posmPromoterName;
	
	private String posmDistrictName;
	
	private Boolean posmCreditCardDeal;
	
	private String posmOriginalMerchantNo;

	public String getPosmOriginalMerchantNo() {
		return posmOriginalMerchantNo;
	}

	public void setPosmOriginalMerchantNo(String posmOriginalMerchantNo) {
		this.posmOriginalMerchantNo = posmOriginalMerchantNo;
	}

	public Long getPosmId() {
		return posmId;
	}

	public void setPosmId(Long posmId) {
		this.posmId = posmId;
	}

	public String getPosmPosMerchantNo() {
		return posmPosMerchantNo;
	}

	public void setPosmPosMerchantNo(String posmPosMerchantNo) {
		this.posmPosMerchantNo = posmPosMerchantNo;
	}

	public Long getPosmMerchantType() {
		return posmMerchantType;
	}

	public void setPosmMerchantType(Long posmMerchantType) {
		this.posmMerchantType = posmMerchantType;
	}

	public Long getPosmMerchantLevel() {
		return posmMerchantLevel;
	}

	public void setPosmMerchantLevel(Long posmMerchantLevel) {
		this.posmMerchantLevel = posmMerchantLevel;
	}

	public String getPosmSalesManager() {
		return posmSalesManager;
	}

	public void setPosmSalesManager(String posmSalesManager) {
		this.posmSalesManager = posmSalesManager;
	}

	public Long getPosmDistrictId() {
		return posmDistrictId;
	}

	public void setPosmDistrictId(Long posmDistrictId) {
		this.posmDistrictId = posmDistrictId;
	}

	public String getPosmAddress() {
		return posmAddress;
	}

	public void setPosmAddress(String posmAddress) {
		this.posmAddress = posmAddress;
	}

	public Long getPosmExternalMccId() {
		return posmExternalMccId;
	}

	public void setPosmExternalMccId(Long posmExternalMccId) {
		this.posmExternalMccId = posmExternalMccId;
	}

	public Long getPosmInternalMccId() {
		return posmInternalMccId;
	}

	public void setPosmInternalMccId(Long posmInternalMccId) {
		this.posmInternalMccId = posmInternalMccId;
	}

	public Long getPosmPromoterId() {
		return posmPromoterId;
	}

	public void setPosmPromoterId(Long posmPromoterId) {
		this.posmPromoterId = posmPromoterId;
	}

	public Boolean getPosmAllopatryReturnGoods() {
		return posmAllopatryReturnGoods;
	}

	public void setPosmAllopatryReturnGoods(Boolean posmAllopatryReturnGoods) {
		this.posmAllopatryReturnGoods = posmAllopatryReturnGoods;
	}

	public Boolean getPosmManualAuthComplete() {
		return posmManualAuthComplete;
	}

	public void setPosmManualAuthComplete(Boolean posmManualAuthComplete) {
		this.posmManualAuthComplete = posmManualAuthComplete;
	}

	public Boolean getPosmCascadeAuthCancel() {
		return posmCascadeAuthCancel;
	}

	public void setPosmCascadeAuthCancel(Boolean posmCascadeAuthCancel) {
		this.posmCascadeAuthCancel = posmCascadeAuthCancel;
	}

	public Boolean getPosmBankCardDeal() {
		return posmBankCardDeal;
	}

	public void setPosmBankCardDeal(Boolean posmBankCardDeal) {
		this.posmBankCardDeal = posmBankCardDeal;
	}

	public Boolean getPosmPpcCardDeal() {
		return posmPpcCardDeal;
	}

	public void setPosmPpcCardDeal(Boolean posmPpcCardDeal) {
		this.posmPpcCardDeal = posmPpcCardDeal;
	}

	public String getPosmExpandBitmap() {
		return posmExpandBitmap;
	}

	public void setPosmExpandBitmap(String posmExpandBitmap) {
		this.posmExpandBitmap = posmExpandBitmap;
	}

	public Long getPosmVersion() {
		return posmVersion;
	}

	public void setPosmVersion(Long posmVersion) {
		this.posmVersion = posmVersion;
	}

	public Date getPosmCreateTime() {
		return posmCreateTime;
	}

	public void setPosmCreateTime(Date posmCreateTime) {
		this.posmCreateTime = posmCreateTime;
	}

	public Date getPosmLastUpdateTime() {
		return posmLastUpdateTime;
	}

	public void setPosmLastUpdateTime(Date posmLastUpdateTime) {
		this.posmLastUpdateTime = posmLastUpdateTime;
	}

	public String getPosmExternalMccName() {
		return posmExternalMccName;
	}

	public void setPosmExternalMccName(String posmExternalMccName) {
		this.posmExternalMccName = posmExternalMccName;
	}

	public String getPosmInternalMccName() {
		return posmInternalMccName;
	}

	public void setPosmInternalMccName(String posmInternalMccName) {
		this.posmInternalMccName = posmInternalMccName;
	}

	public String getPosmPromoterName() {
		return posmPromoterName;
	}

	public void setPosmPromoterName(String posmPromoterName) {
		this.posmPromoterName = posmPromoterName;
	}

	public String getPosmDistrictName() {
		return posmDistrictName;
	}

	public void setPosmDistrictName(String posmDistrictName) {
		this.posmDistrictName = posmDistrictName;
	}

	public Boolean getPosmCreditCardDeal() {
		return posmCreditCardDeal;
	}

	public void setPosmCreditCardDeal(Boolean posmCreditCardDeal) {
		this.posmCreditCardDeal = posmCreditCardDeal;
	}

}
