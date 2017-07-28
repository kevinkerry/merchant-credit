package com.sdp.mc.ma.request.impl;

import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;

import org.hibernate.validator.constraints.NotBlank;

@XmlAccessorType(XmlAccessType.FIELD)
public class QueryOperatorMemberScopeRequest extends AbstractRequest {

	/*
	 * 操作员Id
	 */
	@NotBlank
    @Size(min=1,max=32)
    @XmlElement(required = true,nillable = false)
    private String operatorId;

	public String getOperatorId() {
		return operatorId;
	}

	public void setOperatorId(String operatorId) {
		this.operatorId = operatorId;
	}

}
