package com.sdp.mc.integration.crm.dto;

public class MerchantContactInfoDTO {

	// BLinkMan String(50)
	// Address String(200)
	// BLinkPhone String(20)
	// BLinkEmail String(50)

	private String bLinkMan;
	private String address;
	private String bLinkPhone;
	private String bLinkEmail;

	public MerchantContactInfoDTO() {

	}

	public MerchantContactInfoDTO(String bLinkMan, String address, String bLinkPhone, String bLinkEmail) {
		this.bLinkMan = bLinkMan;
		this.bLinkEmail = bLinkEmail;
		this.bLinkPhone = bLinkPhone;
		this.address = address;
	}

	public String getbLinkMan() {
		return bLinkMan;
	}

	public void setbLinkMan(String bLinkMan) {
		this.bLinkMan = bLinkMan;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getbLinkPhone() {
		return bLinkPhone;
	}

	public void setbLinkPhone(String bLinkPhone) {
		this.bLinkPhone = bLinkPhone;
	}

	public String getbLinkEmail() {
		return bLinkEmail;
	}

	public void setbLinkEmail(String bLinkEmail) {
		this.bLinkEmail = bLinkEmail;
	}

	@Override
	public String toString() {
		return "MerchantContactInfoDTO [" + (bLinkMan != null ? "bLinkMan=" + bLinkMan + ", " : "")
				+ (address != null ? "address=" + address + ", " : "") + (bLinkPhone != null ? "bLinkPhone=" + bLinkPhone + ", " : "")
				+ (bLinkEmail != null ? "bLinkEmail=" + bLinkEmail : "") + "]";
	}

}
