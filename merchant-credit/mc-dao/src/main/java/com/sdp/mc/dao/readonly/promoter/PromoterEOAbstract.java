package com.sdp.mc.dao.readonly.promoter;

import java.math.BigDecimal;
import java.util.Date;

import com.sdp.mc.dao.readonly.merchantcontract.CmMerchantContractEO;

/**
 * @author zhangguoliang.burt cm_promoter的实体属性
 */
public class PromoterEOAbstract extends CmMerchantContractEO {

	private static final long serialVersionUID = 9177357161374277857L;

	/**
	 * 拓展商Id
	 */
	public Long promoterId;

	/**
	 * 
	 */
	public String businessManager;

	/**
	 * 应收保证金
	 */
	public BigDecimal depositmarginReceivable;

	/**
	 * 创建时间
	 */
	public Date createAt;

	/**
	 * 更新时间
	 */
	public Date updateAt;

	/**
	 * version版本号
	 */
	public int pmtVersion;
	/**
	 * 快速结算保证金
	 */
	public BigDecimal fastSettleMargin;
	/**
	 * 快速结算可配置额度
	 */
	public BigDecimal fastConfigureLimit;
	/**
	 * 快速结算额度
	 */
	public BigDecimal fastSettleLimit;

	/**
	 * 是否开启快速结算
	 */
	public Integer pmtFastSettleFlag;

	/**
	 * 快速结算额度比例
	 */
	private BigDecimal pmtFastSettleRatio;

	/**
	 * GET 快速结算额度比例
	 */
	public BigDecimal getPmtFastSettleRatio() {
		return pmtFastSettleRatio;
	}

	/**
	 * SET 快速结算额度比例
	 */
	public void setPmtFastSettleRatio(BigDecimal pmtFastSettleRatio) {
		this.pmtFastSettleRatio = pmtFastSettleRatio;
	}

	public Integer getPmtFastSettleFlag() {
		return pmtFastSettleFlag;
	}

	public void setPmtFastSettleFlag(Integer pmtFastSettleFlag) {
		this.pmtFastSettleFlag = pmtFastSettleFlag;
	}

	public BigDecimal getFastSettleMargin() {
		return fastSettleMargin;
	}

	public void setFastSettleMargin(BigDecimal fastSettleMargin) {
		this.fastSettleMargin = fastSettleMargin;
	}

	public BigDecimal getFastConfigureLimit() {
		return fastConfigureLimit;
	}

	public void setFastConfigureLimit(BigDecimal fastConfigureLimit) {
		this.fastConfigureLimit = fastConfigureLimit;
	}

	public BigDecimal getFastSettleLimit() {
		return fastSettleLimit;
	}

	public void setFastSettleLimit(BigDecimal fastSettleLimit) {
		this.fastSettleLimit = fastSettleLimit;
	}

	public Long getPromoterId() {
		return promoterId;
	}

	public void setPromoterId(Long promoterId) {
		this.promoterId = promoterId;
	}

	public Date getCreateAt() {
		return createAt;
	}

	public void setCreateAt(Date createAt) {
		this.createAt = createAt;
	}

	public Date getUpdateAt() {
		return updateAt;
	}

	public void setUpdateAt(Date updateAt) {
		this.updateAt = updateAt;
	}

	public int getPmtVersion() {
		return pmtVersion;
	}

	public void setPmtVersion(int pmtVersion) {
		this.pmtVersion = pmtVersion;
	}

	public String getBusinessManager() {
		return businessManager;
	}

	public void setBusinessManager(String businessManager) {
		this.businessManager = businessManager;
	}

	public BigDecimal getDepositmarginReceivable() {
		return depositmarginReceivable;
	}

	public void setDepositmarginReceivable(BigDecimal depositmarginReceivable) {
		this.depositmarginReceivable = depositmarginReceivable;
	}

	public PromoterEOAbstract() {
	}
}
