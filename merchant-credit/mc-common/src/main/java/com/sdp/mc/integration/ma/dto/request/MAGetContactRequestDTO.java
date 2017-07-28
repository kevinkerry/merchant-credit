package com.sdp.mc.integration.ma.dto.request;

import com.sdp.mc.common.enums.ContactType;
import com.sdp.mc.integration.ma.dto.MABaseDTO;

public class MAGetContactRequestDTO extends MABaseDTO {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1035910485152550647L;

	/**
	 * sdp会员号
	 * **/
	private String memberId;
	/**
	 * 账户类型
	 */
	private ContactType contactType;

	public MAGetContactRequestDTO() {
		// TODO Auto-generated constructor stub
	}

	public MAGetContactRequestDTO(String memberId, ContactType contactType) {
		this.memberId = memberId;
		this.contactType = contactType;
	}

	public String getMemberId() {
		return memberId;
	}

	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}

	public ContactType getContactType() {
		return contactType;
	}

	public void setContactType(ContactType contactType) {
		this.contactType = contactType;
	}

}
