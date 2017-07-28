package com.sdp.mc.common.constant;

import com.shengpay.commom.config.GlobalConfig;

public class WithdrawConstant {
	/**
	 * 调用核心出款队列的目的
	 */
	public static final String CALL_WITHDRAW_CORE_SERVICE_QUEUE_DESTINATION = "withdraw.core.service.queue.destination";
	/**
	 * 调用核心出款队列的目的 配置文件中的KEY
	 */
	public static final String FW_MQ_WITHDRAW_CORE_SERVICE_ADDRESS_KEY = "fw.mq.withdraw.core.service.address";
	
	/**
	 * #禁止发起MposD1的时间
forbid.mpos.d1.initiate.withdraw.date=2017-01-13,2017-01-12
#禁止发起盛付通垫资MposT0的时间
forbid.shengpay.mpos.t0.initiate.withdraw.date=2017-01-13,2017-01-12
#禁止发起盛付通垫资posT0的时间
forbid.shengpay.pos.t0.initiate.withdraw.date=2017-01-13,2017-01-12
	 */
	public static final String FORBID_MPOS_D1_INITIATE_WITHDRAW_DATE = "forbid.mpos.d1.initiate.withdraw.date";
	/**
	 * #禁止发起盛付通垫资MposT0的时间
	 */
	public static final String FORBID_SHENGPAY_MPOS_T0_INITIATE_WITHDRAW_DATE = "forbid.shengpay.mpos.t0.initiate.withdraw.date";
	/**
	 * #禁止发起盛付通垫资posT0的时间
	 */
	public static final String FORBID_SHENGPAY_POS_T0_INITIATE_WITHDRAW_DATE = "forbid.shengpay.pos.t0.initiate.withdraw.date";
	/**
	 * #不禁止发起盛付通垫资mposT0出款的代理商商户号
	 */
	public static final String NOT_FORBID_SHENGPAY_MPOS_T0_INITIATE_WITHDRAW_PROMOTERNO = "not.forbid.shengpay.mpos.t0.initiate.withdraw.promoterno";
	

	/**
	 * 加密key
	 */
	public static final String MD5key = GlobalConfig.getString("withdraw.md5key", "T0PosWithdrawMd5key");
	/**
	 * 出款方式 1:pos发起出款 2 余额发起出款
	 */
	public static final Integer reqTypePOS = 1;
	public static final Integer reqTypeBalance = 2;
	/**
	 * 是否需要计费 1 不可空 1：计费；0：不计费
	 */
	public static final String isNeedCountFee = "1";
	public static final String notNeedCountFee = "0";

	/**
	 * 是否允许计费异常 1 不可空 如允许计费异常，在调用计费系统出现异常情况下，将继续支付 1：允许；0：不允许
	 */
	public static final String isPermitPricingErr = "1";
	public static final String notPermitPricingErr = "0";

	/**
	 * 出款类型 1：实时出款 2 普通出款
	 */
	public static final String withdrawTypeRealTime = "1";
	public static final String withdrawTypeOrdinary = "2";

	/**
	 * 批次处理状态 1 不可为空 1：申请成功；0：申请失败
	 */
	public static final String withdrawStatusFail = "0";
	public static final String withdrawStatusSucess = "1";
	/**
	 * crm加密串
	 */
	public static final String crmOpenMerchantMd5key = "crmOpenMerchantMd5key";
	/**
	 * crm接口申请方
	 */
	public static final String applyPosm = "applyPosm";

	/**
	 * FOS出款服务的应用ID(监控ＩＤ)
	 */
	public static final String FOS_WITHDRAW_SERVICE_APP_ID = "9460";

	/**
	 * FOS 回掉地址
	 */
	public static final String FOS_CALLBACK_URL = GlobalConfig.getString("fos.service.withdraw.callback.url", "");
	/**
	 * fos回调超时定义
	 */
	public static final String FOS_CALLBACK_TIMEOUT_MINTE = "fos.callback.timeout.minte";
	/**
	 * fos回调超时默认值
	 */
	public static final int FOS_CALLBACK_TIMEOUT_MINTE_DEFAULT = 10;

	/**
	 * 出款服务回掉地址
	 */
	public static final String WITHDRAW_CALLBACK_ADDRESS = GlobalConfig.getString("withdraw.callback.url", "");
	/**
	 * 出款重试规则的文件
	 */
	public static final String WITHDRAW_RETRY_RULE_FILE = GlobalConfig.getString("withdraw.retry.rule.file",
			"/opt/pay/config/merchant-credit/retryRules.xml");
	/**
	 * 商户信息同步页面的
	 */
	public static final String MERCHANT_INFO_SYNKEY = "merchantInfoZF946";
	/**
	 * 空费用
	 */
	public static final String FEE_EMPTY = "0";

	public static final String WITHDRAW_QUERY_ERROR_NOT_EXSIST = "查询商户号不存在";
	public static final String WITHDRAW_QUERY_ERROR_NOT_UNIQUE = "查询商户号不唯一";
	public static final String WITHDRAW_QUERY_ERROR_NOT_VALIDATE = "参数格式异常";
	public static final String RADIO_QUERY_ERROR_NOT_UNIQUE = "费率不唯一";

	public static final String WITHDRAW_ERROR_RATIO_TYPE_NOT_MATCH = "费率类型不匹配.";
	public static final String WITHDRAW_ERROR_RATIO_GREATER_THAN_ONE = "费率大于等于1.";
	public static final String WITHDRAW_ERROR_AVAILABLE_RATIO_EXIST = "与可用费率冲突.";

	public static final String WITHDRAW_ERROR_SIGN_NOT_NULL="签名不能为空";
	public static final String WITHDRAW_ERROR_SIGN_NOT_PASS="签名信息不正确";
	public static final String WITHDRAW_ERROR_MERCHANTNO_NOT_NULL="商户号不能为空";
	public static final String WITHDRAW_ERROR_MERCHANT_TYPE_NOT_NULL="商户类型不能为空";
	public static final String WITHDRAW_ERROR_APPID_NOT_NULL="应用编码不能为空";
	public static final String WITHDRAW_ERROR_ORDERNO_NOT_NULL="业务订单号不能为空";
	public static final String WITHDRAW_ERROR_ORDERNO_OVERLENGTH="业务订单号长度不能超过32位";
	public static final String WITHDRAW_ERROR_AMOUNT_NOT_NULL="发起出款金额不能为空";
	public static final String WITHDRAW_ERROR_AMOUNT_GREATER_THAN_ZERO="出款金额必须大于0";
	public static final String WITHDRAW_ERROR_AMOUNT_FORMAT_NOTPASS="出款金额最多支持小数点后两位";
	public static final String WITHDRAW_ERROR_MERCHANT_NOTOPEN_FASTSETTLE="此商户未开通快速结算功能";
	public static final String WITHDRAW_ERROR_PROMOTER_NOTOPEN_FASTSETTLE="此商户代理商未开通快速结算功能";
	public static final String WITHDRAW_ERROR_MCTYPE_NOT_PASS="商户类型不匹配,此接口只支持POS商户T0出款";
	public static final String WITHDRAW_ERROR_OAMOUNT_NOT_NULL="原始收单金额不能为空";
	public static final String WITHDRAW_ERROR_OAMOUNT_GREATER_THAN_ZERO="原始收单金额必须大于0";
	public static final String WITHDRAW_ERROR_OAMOUNT_FORMAT_NOTPASS="原始金额最多支持小数点后两位";
	public static final String WITHDRAW_ERROR_OAMOUNT_LESS_THAN_AMOUNT="原始收单金额必须大于等于出款金额";
	public static final String WITHDRAW_ERROR_TYPE_REAL_WITHDRAW="出款类型只能为指定值：1：实时出款";
	public static final String WITHDRAW_ERROR_MCTYPE_ISMPOS="商户类型不匹配,此接口只支持MPOS出款和云收银出款";
	public static final String WITHDRAW_ERROR_WITHDARWTYPE_NOT_NULL="出款类型不能为空";
	public static final String WITHDRAW_ERROR_MPOS_WITHDARWTYPE="出款类型只能为指定值：1：实时出款 2：普通出款";
	
	public static final String WITHDRAW_ERROR_EASYPAY_BANK_CART_INFO_IS_NULL="云收银出款银卡信息为空";
	
	/**
	 * FOS 回掉地址
	 */
	public static final String WALLET_WITHDRAW_CALLBACK_RECEIVE_URL = GlobalConfig.getString("wallet.withdraw.callback.receive.url", "");
	
	
	public static final String WITHDRAW_REQUEST_EXTENTS_KEY_BANK_CARD_INFO = "bankCardInfo";
	
	public static final String WITHDRAW_REQUEST_EXTENTS_KEY_HAS_OA_TXN = "hasOATxn";




}
