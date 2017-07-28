package com.sdp.mc.common.constant;

import java.math.BigDecimal;

import com.shengpay.commons.core.constants.ConstantTag;

public class MerchantCreditConstant {
	/** 个人对私基本户101 **/
	public static final Long ACCOUNT_TYPE_4_PRIVATE = 101L;
	/** 商户对公基本户201 **/
	public static final Long ACCOUNT_TYPE_4_PUBLIC = 201L;
	/** ma 为快速结算开通的储值账户类型 216L **/
	public static final Long ACCOUNT_TYPE_4_MARGIN = 216L;
	/** ma 为快速结算开通的储值账户类型 217L  mpos 保证证金**/
	public static final Long ACCOUNT_TYPE_4_MARGIN_MPOS = 217L;
	/** ma 为快速结算开通的储值账户类型 218L  云收银保证金**/
	public static final Long ACCOUNT_TYPE_4_MARGIN_EASYPAY = 218L;
	/** ma 为快速结算开通的储值账户类型281L(中转-快速结算配资) **/
	public static final Long ACCOUNT_TYPE_4_CREDIT = 281L;
	/** ma-website zf号 **/
	public static final String MC_WEBSITE_ZF_NO = "ZF910";

	/** mc-t0-service-website zf号 **/
	public static final String MC_T0_SERVICE_ZF_NO = "ZF946";
	/** FOS转账产品码 (基本户<-->保证金账户) **/
	public static final String MC_FOS_MARGIN_PRODUCT_CODE = "10020010";
	/** FOS转账产品码 (基本户<-->配资授信账户) **/
	public static final String MC_FOS_CREDIT_PRODUCT_CODE = "10020010";
	/** operating系统根路径key **/
	public static final String OPERATING_ROOT_URL = "operating.root.url";

	/**
	 * 快速结算开通: 1
	 */
	public static final String FAST_SETTLE_FLAG_OPEN = "1";

	public static final int FAST_SETTLE_FLAG_OPEN_INT = 1;
	/**
	 * 快速结算关闭: 0
	 */
	public static final String FAST_SETTLE_FLAG_CLOSE = "0";

	/**
	 * 保证金追加异常 追加快速结算保证金失败，请致电盛付通客服：021-38585566-807755或联系您的专属BD.
	 */
	public static final String MC_MARGIN_ADD_EXCEPTION = "追加快速结算保证金失败，请致电盛付通客服：021-38585566-807755 或联系您的专属BD.";
	public static final String MC_MARGIN_REDEEM_EXCEPTION = "退回快速结算保证金失败，请致电盛付通客服：021-38585566-807755 或联系您的专属BD.";
	public static final String MC_MARGIN_REDEEM_NEWT0_EXCEPTION = "退款申请失败，请稍后重新发起.";
	public static final String MC_MARGIN_ADD_QUART_ERROR = "输入金额错误，请重新输入追加金额。金额必须大于等于0.01元";
	/**
	 * 系统异常
	 */
	public static final String MC_SYSTEM_EXCEPTION = "很抱歉，系统繁忙，请稍后再试，或致电盛付通客服 021-38585566-807755.";
	public static final String MC_NOPERMISSION_EXCEPTION = "很抱歉，请确认此代理商有操作此功能的权限。";
	/**
	 * 商户信息修改成功，该商户的快速结算信息将在下一个自然日生效!
	 */
	public static final String MC_PROMOTER_M_MERCHANT_SUCCESS = "商户信息修改成功，该商户的快速结算信息将在下一个自然日生效!";
	/**
	 * 很抱歉，信息修改失败，请致电盛付通客服：021-38585566-807755.
	 */
	public static final String MC_PROMOTER_M_MERCHANT_FAILURE = "很抱歉，信息修改失败，请致电盛付通客服：021-38585566-807755 .";

	public static final BigDecimal MERCHANT_FAST_SETTLE_HOLIDAY_FEE = new BigDecimal("0.0025");
	public static final BigDecimal MERCHANT_FAST_SETTLE_WORKDAY_FEE = new BigDecimal("0.002");
	public static final BigDecimal MERCHANT_FAST_SETTLE_HOLIDAY_FEE_SHENGPAY = new BigDecimal("0.0015");
	public static final BigDecimal MERCHANT_FAST_SETTLE_WORKDAY_FEE_SHENGPAY = new BigDecimal("0.001");
	/**
	 * operating 接口返回 成功 0
	 */
	public static final String OPERATING_INTERFACE_RESPONSE_CODE_SUCCESS = "0";
	/**
	 * operating 接口返回失败 1
	 */
	public static final String OPERATING_INTERFACE_RESPONSE_CODE_FAILURE = "1";

	/**
	 * 商户自动快速结算 开启：1
	 */
	public static final int MERCHANT_AUTO_FASTSETTLE_ON_LOANING_PROMOTER = 1;
	/**
	 * 商户自动快速结算 关闭：0
	 */
	public static final int MERCHANT_AUTO_FASTSETTLE_OFF = 0;
	public static final int MERCHANT_AUTO_FASTSETTLE_ON_LOANING_SHENGPAY = 2;

	public static final String MERCHANT_VALID_FS_ORDERS = "merchantValidFsOrders";

	/**
	 * 商户提交快速结算类型 1：自动
	 */
	public static final int MERCHANT_FASTSETTLE_TYPE_AUTO = 1;
	/**
	 * 商户提交快速结算类型 0：手动
	 */
	public static final int MERCHANT_FASTSETTLE_TYPE_MANUAL = 0;

	/**
	 * 盛付通快速结算类型 2:自动
	 */
	public static final int SDP_MERCHANT_FASTSETTLE_TYPE_AUTO = 2;

	/**
	 * config,法定节假日
	 */
	public static final String MC_REDEEMED_EXCLUDES_DATE = "MC_REDEEMED_EXCLUDES_DATE";
	/**
	 * config,保证金出款 日，T+n
	 */
	public static final String MC_REDEEMED_ADD_CNT = "MC_REDEEMED_ADD_CNT";

	/**
	 * config,追加保证金后对可配置额度扩大倍数
	 */
	public static final String MC_MARGIN_2_CONFIGURE_TIMES = "MC_MARGIN_2_CONFIGURE_TIMES";

	/**
	 * config,快速结算交易最低额度
	 */
	public static final String MC_FASTSETTLE_MIN_LIMIT = "MC_FASTSETTLE_MIN_LIMIT";

	/**
	 * config,配资fos授信处理中邮件列表
	 */
	public static final String CREDIT_FOS_PROCESSING_MAIL_LIST = "CREDIT_FOS_PROCESSING_MAIL_LIST";

	/**
	 * config,天天贷fos授信处理中邮件列表
	 */
	public static final String TTD_FOS_PROCESSING_MAIL_LIST = "TTD_FOS_PROCESSING_MAIL_LIST";

	/**
	 * config,t0出款服务额度还原、冻结已使用异常 邮件列表
	 */
	public static final String T0_QUOTA_OP_ERROR_MAIL_LIST = "T0_QUOTA_OP_ERROR_MAIL_LIST";

	/**
	 * config,BD、清算及业务负责人总额度耗尽提醒邮件列表、额度提醒比例
	 */
	public static final String NEWT0_REMIND_RUN_OUT_MAIL_LIST = "NEWT0_REMIND_RUN_OUT_MAIL_LIST";
	public static final String NEWT0_REMIND_RUN_OUT_PROPORTION = "NEWT0_REMIND_RUN_OUT_PROPORTION";


	/**
	 * config,BD、清算及业务负责人代理商额度耗尽提醒邮件列表、额度提醒比例
	 */
	public static final String NEWT0_REMIND_RUN_OUT_PROMOTER_MAIL_LIST = "NEWT0_REMIND_RUN_OUT_PROMOTER_MAIL_LIST";
	public static final String NEWT0_REMIND_RUN_OUT_PROMOTER_PROPORTION = "NEWT0_REMIND_RUN_OUT_PROMOTER_PROPORTION";
	/**
	 * config,BD、清算及业务负责人商户额度耗尽提醒邮件列表、额度提醒比例
	 */
	public static final String NEWT0_REMIND_RUN_OUT_MERCHANT_MAIL_LIST = "NEWT0_REMIND_RUN_OUT_MERCHANT_MAIL_LIST";
	public static final String NEWT0_REMIND_RUN_OUT_MERCHANT_PROPORTION = "NEWT0_REMIND_RUN_OUT_MERCHANT_PROPORTION";


	/**
	 * pos商户前缀
	 */
	public static final String MERCHANT_PREFIX_POSMERCHANT = "posMerchant";
	/**
	 * mPos商户前缀
	 */
	public static final String MERCHANT_PREFIX_MPOSMERCHANT = "mposMerchant";
	/**
	 * pos代理商
	 */
	public static final String MERCHANT_PREFIX_POSPROMOTER = "posPromoter";

	/**
	 * MPOS合作方
	 */
	public static final String MERCHANT_PREFIX_MPOS_PARTNER_PROMOTER = "mposPartnerPromoter";

	/**
	 * mPos代理商
	 */
	public static final String MERCHANT_PREFIX_MPOSPROMOTER = "mposPromoter";

	/**
	 * // 是否需要计费,1：计费
	 */
	public static final String FOS_REQUEST_IS_NEED_COUNT_FEE_TRUE = "1";
	/**
	 * // 是否需要计费,0：不计费
	 */
	public static final String FOS_REQUEST_IS_NEED_COUNT_FEE_FALSE = "0";

	public static final String REMIT_TRANSFER_REQUEST_MEMO = "Merchant Credit fos request.";
	/**
	 * 很抱歉，支付密码错误（系统正忙），请重新输入。如需帮助请致电 021-20575188-807755。
	 */
	public static final String MC_SPDEDITALL_CHECK_ERROR_INPUT_ERROR = "很抱歉，支付密码错误，请重新输入。如需帮助请致电 021-20575188-807755。";
	/**
	 * 很抱歉，支付密码输错超过3次，您的支付权限已被锁定，如需帮助请致电 021-20575188-807755。
	 */
	public static final String MC_SPDEDITALL_CHECK_ERROR_LOCK = "很抱歉，支付密码输错超过3次，您的支付权限已被锁定，如需帮助请致电 021-20575188-807755。";

	/**
	 * 很抱歉，当前登录账户为个人商户，不能开通快速结算账户。如需帮助请致电 021-20575188-807755。
	 */
	public static final String MC_MA_216_ACCOUNT_ERROR_295 = "很抱歉，当前登录账户为个人商户，不能开通快速结算账户。如需帮助请致电 021-20575188-807755。";
	/**
	 * 很抱歉,您的钱包余额不足,请先充值.
	 */
	public static final String MC_PROMOTER_ADD_MARGIN_BALANCE_ERROR = "很抱歉,您的钱包余额不足,请先充值.";
	/**
	 * 很抱歉,您的保证金账户余额不足,请检查您的保证金账户余额.
	 */
	public static final String MC_PROMOTER_REDDEM_MARGIN_BALANCE_ERROR = "很抱歉,您的保证金账户余额不足,请检查您的保证金账户余额.";

	/**
	 * 很抱歉,您不能提取.
	 */
	public static final String MC_PROMOTER_REDDEM_MARGIN_BALANCE_T0_ERROR = "很抱歉,保底保证金必须一次性取完.";

	/**
	 * 很抱歉,无垫资方不能取回.
	 */
	public static final String MC_PROMOTER_REDDEM_LOANING_TYPE_T0_ERROR = "很抱歉,无垫资方不能取回.";

	/**
	 * 很抱歉,没有配置系统参数
	 */
	public static final String MC_PROMOTER_REDDEM_LOANING_CONFIG_T0_ERROR = "很抱歉,没有配置系统参数.";

	/**
	 * 配资手续费率
	 */
	public static final BigDecimal WITH_FUNDING_WORKDAY_FEE = BigDecimal.valueOf(0.1);
	public static final BigDecimal WITH_FUNDING_RESTDAY_FEE = BigDecimal.valueOf(0.15);

	/**
	 * 天天贷是否关闭
	 * **/
	public static final String TTD_SWITCH_OFF = "ttd_switch_off";


	/**
	 * 新t0新老接口切换开关
	 */
	public static final String NEWT0_INTERFACE_SWITCH_OFF = "NEWT0_INTERFACE_SWITCH_OFF";
	/**
	 * 新T0商户每月交易额配置
	 */
	public static final String NEW_T0_MONTHAMOUNT = "new_t0_monthAmount";

	/**
	 * 新T0退费超时分钟数
	 */
	public static final String NEW_T0_REMIT_FEE_MINUTE = "NEW_T0_REMIT_FEE_MINUTE";

	public static final String MC_GLOBAL_ENCODEING = "UTF-8";

	/**
	 * CRM 代理商联系方式查询 返回：0：成功
	 */
	public static final Integer MC_CRM_QUERYMERCHANTCONTACTINFO_RETURN_CODE_SUCCESS = 0;

	/**
	 * (盛付通全资)商户日限额
	 */
	public static final BigDecimal MERCHANT_LOANING_TYPE_SHENGPAY_MAX_LIMIT = new BigDecimal(50000);

	/**
	 * 新T+0快速出款银行列表
	 */
	public static final String NEWT0_FAST_FUND_OUT_BANK_LIST = "NEWT0_FAST_FUND_OUT_BANK_LIST";
	/**
	 * 新T+0快速出款银行列表描述
	 */
	public static final String NEWT0_FAST_FUND_OUT_BANK_LIST_DESC = "NEWT0_FAST_FUND_OUT_BANK_LIST_DESC";
	/**
	 * t0mock标识
	 */
	public static final String NEW_T0_MOCK = "newt0.mock";
	/**
	 * 保证金额度不一致邮件列表
	 */
	public static final String NEWT0_WARING_MAIL_LIST = "NEWT0_WARING_MAIL_LIST";
	/**
	 * MPOS商户创建时间
	 * **/
	public static final String T0_MPOS_MCREDIT_CREATETIME = "t0_mpos_mcredit_createtime";

	public static final String IS_OPEN_CREDIT_AUTHENTICATION = "IS_OPEN_CREDIT_AUTHENTICATION";
	/**
	 * MPOS T0产品编码
	 * **/
	public static final String T0_MPOS_PRODUCTS_CODE = "T0_MPOS_PRODUCTS_CODE";
	/**
	 * T0出款判断代理商是否有过开户记录（线上测试账户没有开户记录，验证时需要改为false）
	 */
	public static final String PROMOTER_CHECK_IS_OPEN_ACCOUNT="PROMOTER_CHECK_IS_OPEN_ACCOUNT";
	/**
	 * 追加保证金邮件提醒
	 */
	public static final String ADD_MARGIN_MAIL_LIST = "addMargin.senderMaillist";
	/**
	 * 调额次数
	 */
	public static final String SURPLUS_TEMPORARY_ADJUST_COUNT="surplus.temporary.adjust.count";
	/**
	 * 临时调额开始时间
	 */
	public static final String ADJUST_TIME_STARTTIME="adjust.time.startTime";
	/**
	 * 临时调额结束时间
	 */
	public static final String ADJUST_TIME_ENDTIME="adjust.time.endTime";
	/**
	 * 临时调额开始时间标识
	 */
	public static final String START="START";
	/**
	 * 临时调额结束时间标识
	 */
	public static final String END="END";
	/**
	 * 临时调额当日额度使用比例
	 */
	public static final String ADJUST_LIMIIT_USE_RATIO="adjust.limit.use.ratio";

	public static final String STRING_TRUE = "1";

	public static final String STRING_FALSE = "0";

	public static final String SUCCESS_MESSAGE = "成功";
	public static final String ERROR_MESSAGE_EXCEPTION = "执行异常，请联系维护人员";

	public static final String QUERY_PARAM_NOT_VALIDATA = "查询参数检验不通过";
	/**
	 * MPOS t1节假日出款默认费率
	 */
	public static final String MPOS_T1_HOLDAY_WITHDRAW_RATIO="mpos.t1.holday.withdraw.ratio";
	/**
	 * MPOS t1工作日出款默认费率
	 */
	public static final String MPOS_T1_WORKDAY_WITHDRAW_RATIO="mpos.t1.workDay.withdraw.ratio";
	/**
	 * MPOS d1节假日出款默认费率
	 */
	public static final String MPOS_D1_HOLDAY_WITHDRAW_RATIO="mpos.d1.holday.withdraw.ratio";
	/**
	 * MPOS d1工作日出款默认费率
	 */
	public static final String MPOS_D1_WORKDAY_WITHDRAW_RATIO="mpos.d1.workDay.withdraw.ratio";
	/**
	 * 0.11%+N开始时间
	 */
	public static final String T0_COST_DATE="t0.cost.date";

	public static final String SYNC_PROMOTER_FAIL_TITLE="同步代理商信息失败";
	public static final String SYNC_MERCHANT_FAIL_TITLE="同步商户信息失败";
	public static final String BATCH_SYNC_MERCHANT_FAIL_TITLE="批量同步商户信息失败";

	public static final String SYNC_PROMOTER_FAIL_PARENT_PROMOTER_NOT_EXISTS="代理商父代理商信息不存在";
	public static final String SYNC_MERCHANT_FAIL_LAST_LEVEL_PROMOTER_NOT_EXISTS="商户的二级代理信息不存在";
	public static final String SYNC_MERCHANT_FAIL_PARENT_PROMOTER_NOT_EXISTS="商户的代理商信息不存在";

	public static final String SYNC_MERCHANT_EXTEND_KEY_CREDIT_AUTHENTICATION="creditAuthentication";

	public static final Object SYNC_MERCHANT_EXTEND_KEY_PMT_BIND_OPERATOR_INFO = "pmtBindOperatorInfo";

	public static final Object SYNC_MERCHANT_EXTEND_KEY_CERT_INFO = "certInfo";

	public static final Object SYNC_MERCHANT_EXTEND_KEY_UPDATE_MERCHANT_ATTR = "updateMerchantAttr";
	
	public static final String MERCHANT_LOWER_LIMIT_CONFIG = "MERCHANT_LOWER_LIMIT_CONFIG";
}
