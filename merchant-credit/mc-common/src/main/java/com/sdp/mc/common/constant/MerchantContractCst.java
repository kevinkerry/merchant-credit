package com.sdp.mc.common.constant;

import com.shengpay.commons.core.constants.ConstantTag;

/**
 * 商户合同常量
 *
 * @author liuxi.xiliu
 */
public class MerchantContractCst {
	/**
	 * 合同状态:待审核={@value}
	 */
	@ConstantTag(name = "待审核", type = "MC_STATUS")
	public static final String MC_STATUS_UNACTIVE = "0";

	/**
	 * 合同状态:已审核={@value}
	 */
	@ConstantTag(name = "已审核", type = "MC_STATUS")
	public static final String MC_STATUS_CONFIRM = "1";

	/**
	 * 合同状态:已激活={@value}
	 */
	@ConstantTag(name = "已激活", type = "MC_STATUS")
	public static final String MC_STATUS_ACTIVE = "3";

	/**
	 * 合同状态:预约终止={@value}
	 */
	@ConstantTag(name = "预约终止", type = "MC_STATUS")
	public static final String MC_STATUS_SIGNOFF = "2";

	/**
	 * 合同状态:已删除={@value}
	 */
	@ConstantTag(name = "已删除", type = "MC_STATUS")
	public static final String MC_STATUS_DELETE = "4";

	// //////////////////////////////////【合同类型】常量集////////////////////////////////////////////////
	/**
	 * 合同类型:POS商户={@value}
	 */
	@ConstantTag(name = "POS商户", type = "MC_TYPE")
	public static final String TYPE_POS_MERCHANT = "0001";

	/**
	 * 合同类型:机具方={@value}
	 */
	@ConstantTag(name = "机具方", type = "MC_TYPE")
	public static final String TYPE_TERMINAL_PROVIDER = "0002";

	/**
	 * 合同类型:拓展商={@value}
	 */
	@ConstantTag(name = "拓展商", type = "MC_TYPE")
	public static final String TYPE_PROMOTER = "0003";

	/**
	 * 合同类型:转接方={@value}
	 */
	@ConstantTag(name = "转接方", type = "MC_TYPE")
	public static final String TYPE_CONNECT = "0004";

	/**
	 * miniPOS商户
	 */
	@ConstantTag(name = "miniPOS商户", type = "MC_TYPE")
	public static final String TYPE_MINI_POS_MERCHANT = "0005";

	/**
	 * mPOS商户
	 */
	@ConstantTag(name = "mPOS商户", type = "MC_TYPE")
	public static final String TYPE_MPOS_MERCHANT = "0006";

	/**
	 * mPOS拓展商
	 */
	@ConstantTag(name = "mPOS拓展商", type = "MC_TYPE")
	public static final String TYPE_MPOS_PROMOTER = "0007";

	/**
	 * MPOS合作方
	 */
	@ConstantTag(name = "MPOS合作方", type = "MC_TYPE")
	public static final String TYPE_MPOS_PARTNER_PROMOTER = "9999";

	/**
	 * POS合作方
	 */
	@ConstantTag(name = "POS合作方", type = "MC_TYPE")
	public static final String TYPE_POS_PARTNER_PROMOTER = "8888";

	/**
	 * miniPOS拓展商
	 */
	@ConstantTag(name = "miniPOS拓展商", type = "MC_TYPE")
	public static final String TYPE_MINI_POS_PROMOTER = "0008";

	/**
	 * mPOS - SDK拓展商
	 */
	@ConstantTag(name = "SDK拓展商", type = "MC_TYPE")
	public static final String TYPE_MPOS_SDK_PROMOTER = "0009";
	/**
	 * 机具厂商
	 */
	@ConstantTag(name = "机具厂商", type = "MC_TYPE")
	public static final String TYPE_FACTORY = "0010";

	/**
	 * 被【干掉】的商户合同
	 */
	public static final String[] MC_STATUS_ARR_KILLED = new String[] { MerchantContractCst.MC_STATUS_DELETE, MerchantContractCst.MC_STATUS_SIGNOFF };

	// /////////////////////////////////【POS商户类型】///////////////////////////////////////////////
	/**
	 * POS商户类型：普通商户={@value}
	 */
	@ConstantTag(name = "普通商户", type = "POSM_MERCHANT_TYPE")
	public static final String POSM_MERCHANT_TYPE_NORMAL = "0000";

	/**
	 * POS商户类型：交易商户={@value}
	 */
	@ConstantTag(name = "交易商户", type = "POSM_MERCHANT_TYPE")
	public static final String POSM_MERCHANT_TYPE_TRADE = "0001";

	/**
	 * POS商户类型：结算商户={@value}
	 */
	@ConstantTag(name = "结算商户", type = "POSM_MERCHANT_TYPE")
	public static final String POSM_MERCHANT_TYPE_SETTLE = "0002";

	// //////////////////////////////////【合同状态】常量集////////////////////////////////////////////////
	/**
	 * 银行渠道状态:有效
	 */
	@ConstantTag(name = "有效", type = "BC_STATUS")
	public static final String BC_STATUS_ON = "1000";

	/**
	 * 银行渠道状态:无效
	 */
	@ConstantTag(name = "无效", type = "BC_STATUS")
	public static final String BC_STATUS_OFF = "2000";

	// //////////////////////////////////【MCC编号】常量集////////////////////////////////////////////////
	/**
	 * MCC编号:
	 */
	@ConstantTag(name = "", type = "MCC_CODE")
	public static final String MCC_CODE_ = "";

	// //////////////////////////////////【MCC状态】常量集////////////////////////////////////////////////
	/**
	 * MCC状态:有效
	 */
	@ConstantTag(name = "有效", type = "MCC_STATUS")
	public static final String MCC_STATUS_ON = "1000";

	/**
	 * MCC状态:无效
	 */
	@ConstantTag(name = "无效", type = "MCC_STATUS")
	public static final String MCC_STATUS_OFF = "2000";

	// //////////////////////////////////【MCC类型】常量集////////////////////////////////////////////////
	/**
	 * MCC类型:内部行业
	 */
	@ConstantTag(name = "内部行业", type = "MCC_TYPE")
	public static final String MCC_TYPE_INTERNAL = "1000";

	/**
	 * MCC类型:外部行业
	 */
	@ConstantTag(name = "外部行业", type = "MCC_TYPE")
	public static final String MCC_TYPE_EXTERNAL = "2000";

	/**
	 * Mpos快速结算协议html
	 */
	public static final String MPOS_FASTSETTLE_AGREEMENT_HTML = "mpos.fastsettle.agreement.html";

	/**
	 * pos快速结算协议html
	 */
	public static final String POS_FASTSETTLE_AGREEMENT_HTML = "pos.fastsettle.agreement.html";

	/**
	 * 云收银快速结算协议html
	 */
	public static final String EASYPAY_FASTSETTLE_AGREEMENT_HTML = "easypay.fastsettle.agreement.html";

	/**
	 * 系统默认用户
	 */
	public static final String SYSTEM_DEFAULT_USER = "system-default";
	/**
	 * 审核后台地址
	 */
	public static final String OPERNER_URL = "operner.url";
	/**
	 * 未实名认证的额度
	 */
	public static final String NON_CREDIT_AUTHENTICATION_LIMIT_KEY = "NON_CREDIT_AUTHENTICATION_LIMIT_KEY";

	public static final String CREDIT_AUTHENTICATION_LIMIT_KEY = "CREDIT_AUTHENTICATION_LIMIT_KEY";

	public static final String MOPS_AUTO_OPEN_FASTSETTTLE_CONFIG_FLAG = "MOPS_AUTO_OPEN_FASTSETTTLE_CONFIG_FLAG";

	public static final String WITHDRAW_CONFIG_TYPE_MCC = "1001";

	public static final String EASYPAY_MERCHANT_CREDIT_AUTHENTICATION_URL = "easypay.merchant.credit.authentication.url";
}
