package com.sdp.withdraw.service;

import java.util.List;

/**
 * 出款银行RO
 * 
 */
public class FundoutBankRO {
	/**
	 * 键(key)
	 */
	protected String k;

	/**
	 * 值(value)
	 */
	protected String v;

	/**
	 * 子对象(subs)
	 */
	protected List<?> s;

	public FundoutBankRO() {

	}

	public FundoutBankRO(String key, String value) {
		this.k = key;
		this.v = value;
	}

	public FundoutBankRO(String key, String value, List<?> subs) {
		this.k = key;
		this.v = value;
		this.s = subs;
	}

	public String getK() {
		return k;
	}

	public void setK(String k) {
		this.k = k;
	}

	public String getV() {
		return v;
	}

	public void setV(String v) {
		this.v = v;
	}

	public List<?> getS() {
		return s;
	}

	public void setS(List<?> s) {
		this.s = s;
	}
}
