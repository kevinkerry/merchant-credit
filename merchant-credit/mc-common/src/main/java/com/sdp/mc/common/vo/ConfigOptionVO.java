package com.sdp.mc.common.vo;

public class ConfigOptionVO {
	private Long optionId;
	private String optionKey;
	private String optionValue;
	private String optionDefValue;
	private String optionDesc;

	public Long getOptionId() {
		return optionId;
	}

	public void setOptionId(Long optionId) {
		this.optionId = optionId;
	}

	public String getOptionKey() {
		return optionKey;
	}

	public void setOptionKey(String optionKey) {
		this.optionKey = optionKey;
	}

	public String getOptionValue() {
		return optionValue;
	}

	public void setOptionValue(String optionValue) {
		this.optionValue = optionValue;
	}

	public String getOptionDefValue() {
		return optionDefValue;
	}

	public void setOptionDefValue(String optionDefValue) {
		this.optionDefValue = optionDefValue;
	}

	public String getOptionDesc() {
		return optionDesc;
	}

	public void setOptionDesc(String optionDesc) {
		this.optionDesc = optionDesc;
	}
}