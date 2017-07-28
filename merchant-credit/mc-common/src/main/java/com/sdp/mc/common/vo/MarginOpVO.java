package com.sdp.mc.common.vo;



public class MarginOpVO {

	/**
	 * 快速结算保证金
	 */
	private String fastSettleMargin;
	/**
	 * 快速结算额度
	 */
	private String fastSettleLimit;
	/**
	 * 快速结算可配置额度
	 */
	private String fastConfigureLimit;
	/**
	 * 剩余可用额度
	 */
	private String validCredit;
	/**
	 * 剩余可配置额度
	 */
	private String remainConfigureLimit;

//	/**
//	 * 交易记录
//	 */
//	private List<MarginOpReqDTO> marginList;

	public String getFastSettleMargin() {
		return fastSettleMargin;
	}

	public void setFastSettleMargin(String fastSettleMargin) {
		this.fastSettleMargin = fastSettleMargin;
	}

	public String getFastSettleLimit() {
		return fastSettleLimit;
	}

	public void setFastSettleLimit(String fastSettleLimit) {
		this.fastSettleLimit = fastSettleLimit;
	}

	public String getFastConfigureLimit() {
		return fastConfigureLimit;
	}

	public void setFastConfigureLimit(String fastConfigureLimit) {
		this.fastConfigureLimit = fastConfigureLimit;
	}

	public String getValidCredit() {
		return validCredit;
	}

	public void setValidCredit(String validCredit) {
		this.validCredit = validCredit;
	}

	public String getRemainConfigureLimit() {
		return remainConfigureLimit;
	}

	public void setRemainConfigureLimit(String remainConfigureLimit) {
		this.remainConfigureLimit = remainConfigureLimit;
	}

//	public List<MarginOpReqDTO> getMarginList() {
//		return marginList;
//	}
//
//	public void setMarginList(List<MarginOpReqDTO> marginList) {
//		this.marginList = marginList;
//	}

}
