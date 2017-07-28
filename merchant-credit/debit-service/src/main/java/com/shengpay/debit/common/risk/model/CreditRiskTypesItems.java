package com.shengpay.debit.common.risk.model;

import java.util.List;

/**
 * 评分项
 * @author heyi.alex
 *
 */
public class CreditRiskTypesItems {

	/**
	 * 评分项
	 */
	private String code;

	/**
	 * 评分项名称
	 */
	private String desc;

	/**
	 * 输入类型
	 */
	private String inputType;

	/**
	 * 谁负责输入
	 */
	private String inputOwner;

	/**
	 * 是否必须输入
	 */
	private String isNeed;

	/**
	 * 用户输入的值
	 */
	private String userInputVal;

	/**
	 * 用户文件的输入的url
	 */
	private String userInputUrl="";

	/**
	 * 用户的文件名
	 */
	private String userInputFileName="";

	/**
	 * 是否有附件
	 * Yes:有
	 * NO:没有
	 */
	private String hasAttach = "";



	public String getHasAttach() {
		return hasAttach;
	}

	public void setHasAttach(String hasAttach) {
		this.hasAttach = hasAttach;
	}

	/**
	 * 枚举型
	 */
	private List<CreditRiskTypesItemsEnums> enums;

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	public String getInputType() {
		return inputType;
	}

	public void setInputType(String inputType) {
		this.inputType = inputType;
	}

	public String getInputOwner() {
		return inputOwner;
	}

	public void setInputOwner(String inputOwner) {
		this.inputOwner = inputOwner;
	}

	public String getIsNeed() {
		return isNeed;
	}

	public void setIsNeed(String isNeed) {
		this.isNeed = isNeed;
	}

	public List<CreditRiskTypesItemsEnums> getEnums() {
		return enums;
	}

	public void setEnums(List<CreditRiskTypesItemsEnums> enums) {
		this.enums = enums;
	}



	public String getUserInputVal() {
		return userInputVal;
	}

	public void setUserInputVal(String userInputVal) {
		this.userInputVal = userInputVal;
	}

	public String getUserInputUrl() {
		return userInputUrl;
	}

	public void setUserInputUrl(String userInputUrl) {
		this.userInputUrl = userInputUrl;
	}

	public String getUserInputFileName() {
		return userInputFileName;
	}

	public void setUserInputFileName(String userInputFileName) {
		this.userInputFileName = userInputFileName;
	}

	@Override
	public String toString() {
		return "CreditRiskTypesItems [code=" + code + ", desc=" + desc
				+ ", inputType=" + inputType + ", inputOwner=" + inputOwner
				+ ", isNeed=" + isNeed + ", enums=" + enums + "]";
	}


}
