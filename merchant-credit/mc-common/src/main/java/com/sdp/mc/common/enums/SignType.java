package com.sdp.mc.common.enums;


public enum SignType {
	RSA("RSA", "RSA"), MD5("MD5", "MD5"), CA("CA", "CA"),PKI("PKI","PKI");
	private final String code;
	private final String name;

	SignType(String code, String name) {
		this.name = name;
		this.code = code;
	}

	public String getCode() {
		return code;
	}

	public String getName() {
		return name;
	}

	public static SignType getByCode(String code) {
		for (SignType signType : SignType.values()) {
			if (signType.getCode().equals(code)) {
				return signType;
			}
		}
		return null;
	}
}
