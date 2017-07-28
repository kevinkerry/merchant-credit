package com.sdp.withdraw.vo.merchant;

public class MerchantInfoRequest extends SynMerchantRequest {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String promoterNo;
	
	private String promoterType;
	
	private String certNo;
	
	private String certType;

	public String getPromoterNo() {
		return promoterNo;
	}

	public void setPromoterNo(String promoterNo) {
		this.promoterNo = promoterNo;
	}

	public String getPromoterType() {
		return promoterType;
	}

	public void setPromoterType(String promoterType) {
		this.promoterType = promoterType;
	}

	public String getCertNo() {
		return certNo;
	}

	public void setCertNo(String certNo) {
		this.certNo = certNo;
	}

	public String getCertType() {
		return certType;
	}

	public void setCertType(String certType) {
		this.certType = certType;
	}
	
	
	
	

}
