package com.sdp.mc.dao.readonly.posmerchant;

import java.util.Map;

import com.sdp.mc.common.constant.MerchantContractCst;

/**
 * POS商户实体对象
 * 
 * @author wangyiyong@snda.com
 * @date: 13-2-2 上午10:18
 */
public class PosMerchantEO extends PosMerchantEOAbstract {
	/**
	 * 
	 */
	private static final long serialVersionUID = -5602253541576260023L;

	/**
	 * POS商户编号的长度
	 */
	public static int MERCHANT_NO_LENGTH = 15;

	/**
	 * POS商户等级最小值
	 */
	public static int MIN_MERCHANT_LEVEL = 1;

	/**
	 * POS商户等级最大值
	 */
	public static int MAX_MERCHANT_LEVEL = 9;

	/**
	 * <银行渠道-银行授权码>映射
	 */
	private Map<String, String> bankChannel2AuthNOMap;

	/**
	 * 终端数目
	 */
	private Integer terminalCount;

	/**
	 * 拓展商商户号
	 */
	protected String promoterMerchantNo;

	/**
	 * 拓展商名称(合同中)
	 */
	protected String mcPosmPromoterName;

	protected String fastSettleFlag;
	protected String fastSettleLimit;
	protected String pmtFastSettleLimit;
	protected String pmtFastSettleMargin;
	protected String pmtFastConfigureLimit;
	protected String pmtFastSettleRatio;

	/**
	 * 默认构造方法
	 */
	public PosMerchantEO() {
	}

	public String getPmtFastSettleLimit() {
		return pmtFastSettleLimit;
	}

	public void setPmtFastSettleLimit(String pmtFastSettleLimit) {
		this.pmtFastSettleLimit = pmtFastSettleLimit;
	}

	public String getPmtFastSettleMargin() {
		return pmtFastSettleMargin;
	}

	public void setPmtFastSettleMargin(String pmtFastSettleMargin) {
		this.pmtFastSettleMargin = pmtFastSettleMargin;
	}

	public String getPmtFastConfigureLimit() {
		return pmtFastConfigureLimit;
	}

	public void setPmtFastConfigureLimit(String pmtFastConfigureLimit) {
		this.pmtFastConfigureLimit = pmtFastConfigureLimit;
	}

	public String getPmtFastSettleRatio() {
		return pmtFastSettleRatio;
	}

	public void setPmtFastSettleRatio(String pmtFastSettleRatio) {
		this.pmtFastSettleRatio = pmtFastSettleRatio;
	}

	public String getFastSettleFlag() {
		return fastSettleFlag;
	}

	public void setFastSettleFlag(String fastSettleFlag) {
		this.fastSettleFlag = fastSettleFlag;
	}

	public String getFastSettleLimit() {
		return fastSettleLimit;
	}

	public void setFastSettleLimit(String fastSettleLimit) {
		this.fastSettleLimit = fastSettleLimit;
	}

	/**
	 * 获取<银行渠道-银行授权码>映射
	 */
	public Map<String, String> getBankChannel2AuthNOMap() {
		return bankChannel2AuthNOMap;
	}

	/**
	 * 设置<银行渠道-银行授权码>映射
	 */
	public void setBankChannel2AuthNOMap(Map<String, String> bankChannel2AuthNOMap) {
		this.bankChannel2AuthNOMap = bankChannel2AuthNOMap;
	}

	public Integer getTerminalCount() {
		return terminalCount;
	}

	public void setTerminalCount(Integer terminalCount) {
		this.terminalCount = terminalCount;
	}

	public String getPromoterMerchantNo() {
		return promoterMerchantNo;
	}

	public void setPromoterMerchantNo(String promoterMerchantNo) {
		this.promoterMerchantNo = promoterMerchantNo;
	}

	public String getMcPosmPromoterName() {
		return mcPosmPromoterName;
	}

	public void setMcPosmPromoterName(String mcPosmPromoterName) {
		this.mcPosmPromoterName = mcPosmPromoterName;
	}

	public boolean isPosMerchant() {
		return this.mcType.equals(MerchantContractCst.TYPE_POS_MERCHANT);
	}

}