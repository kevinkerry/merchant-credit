package com.sdp.mc.dao.readonly.posmerchant;

import com.sdp.mc.common.constant.MerchantContractCst;

/**
 * POS商户实体对象
 * 
 * @author wangyiyong@snda.com
 * @date: 13-2-2 上午10:18
 */
public class PosMerchantFastSettleEO extends PosMerchantEOAbstract {
	// select m.*,
	// p.*,mset.fast_settle_flag,mset.fast_settle_limit,prom.prom.mc_merchant_no_v
	// as promoter_merchant_no

	/**
	 * 
	 */
	private static final long serialVersionUID = -2036619924556948383L;

	protected String fastSettleFlag;
	protected String fastSettleLimit;
	
	/**
	 * 拓展商商户号
	 */
	protected String promoterMerchantNo;

	/**
	 * 拓展商名称(合同中)
	 */
	protected String mcPosmPromoterName;

	/**
	 * 默认构造方法
	 */
	public PosMerchantFastSettleEO() {
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

}