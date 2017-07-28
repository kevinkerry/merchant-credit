package com.sdp.mc.common.enums.withdraw;

public enum WithdrawConfigEnums {

	/**
	 * POS商户T0可用额度：周五使用工作日额度，周六、周日每天的额度=1个工作日额度*50%
	 */
	T0_POS_LIMITATION_PERCENTAGE("WITHDRAW.T0.PERCENTAGE", "POS商户T0出款额度比例"),
	/**
	 * POS代理商 周五是工作日额度，周六、周日每天是工作日额度的50%（节假日同理）
	 */
	T0_POS_PMT_LIMITATION_PERCENTAGE("WITHDRAW.T0.POS.PMT.PERCENTAGE", "POS代理商T0出款额度比例"),
	/**
	 * MPOS代理商 周五是工作日额度，周六、周日每天是工作日额度的100%（节假日同理）
	 */
	T0_MPOS_PMT_LIMITATION_PERCENTAGE("WITHDRAW.T0.MPOS.PMT.PERCENTAGE", "MPOS代理商T0出款额度比例"),
	/**
	 * MPOS商户 周五是工作日额度，周六、周日每天是工作日额度的50%（节假日同理）
	 */
	T0_MPOS_MERCHANT_LIMITATION_PERCENTAGE("WITHDRAW.T0.MPOS.MERCHANT.PERCENTAGE", "MPOS商户T0出款额度比例"),
	
	T0_EASYPAY_MERCHANT_LIMITATION_PERCENTAGE("WITHDRAW.T0.EASYPAY.MERCHANT.PERCENTAGE", "云收银商户T0出款额度比例"),
	
	T0_EASYPAY_PMT_LIMITATION_PERCENTAGE("WITHDRAW.T0.EASYPAY.PMT.PERCENTAGE", "云收银代理商T0出款额度比例"),

	/**
	 * POS/MPOS商户费率数据同步
	 */
	T0_POS_RATIO_SYNC("WITHDRAW.T0.RATIO.SYNC", "POS商户T0费率数据同步"),

	/**
	 * POS商户T1费率数据同步
	 */
//	T1_POS_RATIO_SYNC("WITHDRAW.T1.RATIO.SYNC", "POS商户T1费率数据同步"),

	/**
	 * 1:需要同步费率
	 */
	NEED_SYNC_RATIO("1","需要同步费率"),
	/**
	 * 0:不需要同步费率
	 */
	NOT_NEED_SYNC_RATIO("0","不需要同步费率");

	public final String code;
	public final String desc;

	WithdrawConfigEnums(String code, String desc) {
		this.code = code;
		this.desc = desc;
	}
}
