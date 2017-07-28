package com.sdp.withdraw.enums;



public enum ReturnCodeEnums {
	        INVALIDATE_PARAMETER("参数校验异常","01001","INVALIDATE_PARAMETER"),
			PAYER_MEMBER_STATUS_INACTIVE("付款人会员未激活","01002","PAYER_MEMBER_STATUS_INACTIVE"),
			PAYER_MEMBER_STATUS_SUSPEND("付款人会员休眠","01003","PAYER_MEMBER_STATUS_SUSPEND"),
			PAYER_MEMBER_STATUS_CANCELED("付款人会员销户","01004","PAYER_MEMBER_STATUS_CANCELED"),
			PAYEE_MEMBER_STATUS_INACTIVE("收款人会员未激活","01005","PAYEE_MEMBER_STATUS_INACTIVE"),
			PAYEE_MEMBER_STATUS_SUSPEND("收款人会员休眠","01006","PAYEE_MEMBER_STATUS_SUSPEND"),
			PAYEE_EMBER_STATUS_CANCELED("收款人会员销户","01007","PAYEE_EMBER_STATUS_CANCELED"),
			PAYER_ACCOUNT_INACTIVE("付款人账户未激活","01008","PAYER_ACCOUNT_INACTIVE"),
			PAYER_ACCOUNT_LOCKED("付款人账户锁定","01009","PAYER_ACCOUNT_LOCKED"),
			PAYER_ACCOUNT_OUT_FORBIDDEN("付款人账户止出","01010","PAYER_ACCOUNT_OUT_FORBIDDEN"),
			PAYER_ACCOUNT_IN_FORBIDDEN("付款人账户止入","01011","PAYER_ACCOUNT_IN_FORBIDDEN"),
			PAYER_ACCOUNT_CANCELED("付款人账户注销","01012","PAYER_ACCOUNT_CANCELED"),
			PAYEE_ACCOUNT_INACTIVE("收款人账户未激活","01013","PAYEE_ACCOUNT_INACTIVE"),
			PAYEE_ACCOUNT_LOCKED("收款人账户锁定","01014","PAYEE_ACCOUNT_LOCKED"),
			PAYEE_ACCOUNT_OUT_FORBIDDEN("收款人账户止出","01015","PAYEE_ACCOUNT_OUT_FORBIDDEN"),
			PAYEE_ACCOUNT_IN_FORBIDDEN("收款人账户止入","01016","PAYEE_ACCOUNT_IN_FORBIDDEN"),
			PAYEE_ACCOUNT_CANCELED("收款人账户注销","01017","PAYEE_ACCOUNT_CANCELED"),
			PAYER_BALANCE_LACK("付款人账户余额不足","01018","PAYER_BALANCE_LACK"),
			PAYMENT_EXCEED_SINGLE_LIMIT("付款人付款金额超过当次限额","01019","PAYMENT_EXCEED_SINGLE_LIMIT"),
			PAYER_EXCEED_DAY_TRAFFIC_LIMIT("付款人超过每日流量限制","01020","PAYER_EXCEED_DAY_TRAFFIC_LIMIT"),
			PAYER_EXCEED_MONTH_TRAFFIC_LIMIT("付款人超过每月流量限制","01021","PAYER_EXCEED_MONTH_TRAFFIC_LIMIT"),
			PAYEE_EXCEED_TRAFFIC_LIMIT("收款人超过流量限制","01022","PAYEE_EXCEED_TRAFFIC_LIMIT"),
			PAYER_IN_BLACKLIST("付款人被列入黑名单","01023","PAYER_IN_BLACKLIST"),
			PAYEE_IN_BLACKLIST("收款人被列入黑名单","01024","PAYEE_IN_BLACKLIST"),
			PAYER_NOT_MATCH_CARDNO_WITH_BANK("收款人卡号与所属银行不符","01025","PAYER_NOT_MATCH_CARDNO_WITH_BANK"),
			BATCH_REQUEST_KEY_INVALIDATE("批次请求才存储key不正确，找不到订单明细","01026","BATCH_REQUEST_KEY_INVALIDATE"),
			NOT_SUPPORT_BANK("银行不在支持的列表范围内","01027","NOT_SUPPORT_BANK"),
			NOT_FOUND_ACCOUNT_IN_STORE("在储值系统内未发现用户帐号","01028","NOT_FOUND_ACCOUNT_IN_STORE"),
			NOT_FOUND_MEMBER_IN_MA("在MA系统内未发现用户帐号","01029","NOT_FOUND_MEMBER_IN_MA"),
			A_REPEAT_ORDER_NO("出款订单号重复","01030","A_REPEAT_ORDER_NO"),
			PAYMENT_AMOUNT_IS_NULL("支付金额为空","01031","PAYMENT_AMOUNT_IS_NULL"),
			APYMENT_AMOUNT_PRECISION_INVALIDATE("支付金额精度不合法","01032","APYMENT_AMOUNT_PRECISION_INVALIDATE"),
			CARD_RULE_INVALIDATE("卡号规则不合法","01033","CARD_RULE_INVALIDATE"),
			BANK_SUPPORTED_INVALIDATE("不支持的银行","01034","BANK_SUPPORTED_INVALIDATE"),
			BANK_AND_CARD_INVALIDATE("卡号和银行号不一致","01035","BANK_AND_CARD_INVALIDATE"),
			UPDATE_BATCH_INFO_FAILED("更新批次信息失败","01036","UPDATE_BATCH_INFO_FAILED"),
			FOUNDOUT_FAILED("未找到批次号","01037","FOUNDOUT_FAILED"),
			BATCH_QUERY_PARAM_INVALIDATE("批次查询参数无效","01038","BATCH_QUERY_PARAM_INVALIDATE"),
			BATCH_IN_PROCESS("批次在队列中","01039","BATCH_IN_PROCESS"),
			BATCH_TRANSFER_FAILED_NOTIFY("批次出款失败通知","01040","BATCH_TRANSFER_FAILED_NOTIFY"),
			BANK_REQUIRED_FIELD_INVALID("银行要求的必填信息为空.","01041","BANK_REQUIRED_FIELD_INVALID"),
			CAN_NOT_ACCESS("不允许使用出款服务","01042","CAN_NOT_ACCESS"),
			INVALID_ORDER_NO("订单号无效","01043","INVALID_ORDER_NO"),
			ORDER_TRANSFER_FAILED_NOTIFY("订单转账失败通知","01044","ORDER_TRANSFER_FAILED_NOTIFY"),
			INVALID_ACCOUNT_NAME("户名中带有非法字符或长度不符","01045","INVALID_ACCOUNT_NAME"),
			INVALID_ACCOUNT_CURRENCY("账户币种类型与交易不符","01046","INVALID_ACCOUNT_CURRENCY"),
			INVALID_BANK_MATCH("收款方卡号与所选银行不匹配","01047","INVALID_BANK_MATCH"),
			INVALID_CARDBIN_MATCH("卡种不支持出款","01048","INVALID_CARDBIN_MATCH"),
			INVALID_BRANCH_NAME("分支行名称中带有非法字符或长度不符","01049","INVALID_BRANCH_NAME"),
			/***外部校验**/
			AUC_VALIDATE_FAILED("收款方卡号与户名不符,银行卡鉴权失败","01050","AUC_VALIDATE_FAILED"),
			RMS_VERIFY_WARN("交易有风险,风控返回有风险","01051","RMS_VERIFY_WARN"),
			RMS_VERIFY_REJECT("交易有风险,风控返回拒绝","01052","RMS_VERIFY_REJECT"),
			RMS_VERIFY_PAUSE("交易有风险,风控返回暂停","01053","RMS_VERIFY_PAUSE"),
			RMS_VERIFY_ADVANCE("交易有风险,风控返回继续","01054","RMS_VERIFY_ADVANCE"),
			/****CSV文件校验***/
			PARAM_CHECK_CSV_FORMAT("CSV格式校验异常","02000","PARAM_CHECK_CSV_FORMAT"),
			CSV_CHECK_ORDER_DUPLICATED("订单号重复","02001","CSV_CHECK_ORDER_DUPLICATED"),
			PARAM_CHECK_TOTAL_NUM("总笔数校验失败","02002","PARAM_CHECK_TOTAL_NUM"),
			PARAM_CHECK_TOTAL_AMOUNT("总金额校验失败","02003","PARAM_CHECK_TOTAL_AMOUNT"),
			PARAM_CHECK_TOTAL_FEE("总费用校验失败","02004","PARAM_CHECK_TOTAL_FEE"),
			PARAM_CHECK_OTHERS("明细校验全失败","02005","PARAM_CHECK_OTHERS"),
			BATCH_NO_DUPLICATED("批次号重复","02006","BATCH_NO_DUPLICATED"),
			CSV_FILE_INVALID("读取CSV文件错误","02007","CSV_FILE_INVALID"),
			CSV_CHECK_CODE_NOTEQUAL("存在不相同的产品编码或支付编码","02008","CSV_CHECK_CODE_NOTEQUAL"),
			/****批量服务错误码****/
			BATCH_PAYMENT_DB_EXCEPTION("批量支付时储值系统数据库异常","03001","BATCH_PAYMENT_DB_EXCEPTION"),
			 /*** CMF统一返回码*/
			CMF_05001("请求银行异常,请求渠道异常","05001","CMF_05001"),
			CMF_05002("银行系统异常,系统异常","05002","CMF_05002"),
			CMF_05003("银行签到异常,签到异常","05003","CMF_05003"),
			CMF_05004("银行签名异常,签名异常","05004","CMF_05004"),
			CMF_05005("银行未知异常,未知异常","05005","CMF_05005"),
			CMF_05006("银行校验失败,校验失败","05006","CMF_05006"),
			CMF_05007("银行验签失败,验签失败","05007","CMF_05007"),
			CMF_05008("收款方卡无效,卡无效","05008","CMF_05008"),
			CMF_05009("收款方卡无效,卡没收","05009","CMF_05009"),
			CMF_05010("收款方卡无效,卡过期","05010","CMF_05010"),
			CMF_05011("收款发卡号有误,卡号不符","05011","CMF_05011"),
			CMF_05012("收款方信息错误,提交信息错误","05012","CMF_05012"),
			CMF_05013("收款方卡类型不正确,卡类型不正确","05013","CMF_05013"),
			CMF_05014("收款方卡号不正确,卡号不正确","05014","CMF_05014"),
			CMF_05015("收款方卡号与户名不符,卡户名不正确","05015","CMF_05015"),
			CMF_05016("收款方卡已挂失,挂失卡","05016","CMF_05016"),
			CMF_05017("收款方卡号不存在,帐号不存在","05017","CMF_05017"),
			CMF_05018("出款失败,账户余额不足","05018","CMF_05018"),
			CMF_05019("收款方卡状态异常,账户异常","05019","CMF_05019"),
			CMF_05020("收款方卡状态异常,卡户未激活","05020","CMF_05020"),
			CMF_05021("出款信息错误,必填域缺失","05021","CMF_05021"),
			CMF_05022("出款信息错误,信息不匹配","05022","CMF_05022"),
			CMF_05023("出款失败,银行交易失败","05023","CMF_05023"),
			CMF_05024("银行渠道关闭,银行渠道关闭","05024","CMF_05024"),
			CMF_05025("收款方卡状态异常,银行卡已过期","05025","CMF_05025"),
			CMF_05026("收款方卡号不存在,银行卡信息有误","05026","CMF_05026"),
			CMF_05027("银行系统异常,银行系统异常","05027","CMF_05027"),
			CMF_05028("收款方分支行信息有误,分支行信息有误","05028","CMF_05028"),
			CMF_05029("出款失败,失败","05029","CMF_05029"),
			CMF_05030("交易处理中,处理中","05030","CMF_05030"),
			CMF_05031("处理成功,处理成功","05031","CMF_05031"),
			CMF_05032("提交成功,提交成功","05032","CMF_05032"),
			CMF_05033("银行系统异常,余额不足","05033","CMF_05033"),
			CMF_05034("收款方卡已销户,银行卡已销户","05034","CMF_05034"),
			CMF_05035("订单有风险，请重试或联系客服处理,风控拦截","05035","CMF_05035"),
			 /***系统错误代码*/
			PAYMENT_PRICE_SYSTEM_ERROR("算费系统故障","90000","PAYMENT_PRICE_SYSTEM_ERROR"),
			TRAFFIC_SYSTEM_ERROR("流量系统故障","90001","TRAFFIC_SYSTEM_ERROR"),
			STORE_SYSTEM_ERROR("储值系统故障","90002","STORE_SYSTEM_ERROR"),
			UNKNOWN_DB_ERROR("未知的数据库异常","90003","UNKNOWN_DB_ERROR"),
			MA_SYSTEM_ERROR("MA系统故障","90004","MA_SYSTEM_ERROR"),
			PE_SYSTEM_ERROR("支付系统故障","90005","PE_SYSTEM_ERROR"),
			UNKOWN_ERROR("未知系统异常","90006","UNKOWN_ERROR"),
			UNKOWN_INST_ERROR("未知的机构支付异常","90007","UNKOWN_INST_ERROR"),
			FW_MC_T0_ING("出款处理中","19000","MC_T0_ING"),
			FW_LOW_AMOUNT("发起金额低于最低金额","19001","LOW_AMOUNT"),
			FW_PROMOTER_LIMIT_INSUFFICIENT("代理商额度不足","19002","PROMOTER_LIMIT_INSUFFICIENT"),
			FW_MERCHANT_LIMIT_INSUFFICIENT("商户额度不足","19003","MERCHANT_LIMIT_INSUFFICIENT"),
			FW_SERVER_NOT_RANGE("发起不在服务时间范围内","19004","SERVER_NOT_RANGE"),
			FW_ORDERNO_IS_NOT_DEFOUND("业务订单号不存在","19005","ORDERNO_IS_NOT_DEFOUND"),
			FW_RISK_CONTROL_REFUSE("风控拒绝","19006","RISK_CONTROL_REFUSE"),
			FW_DATA_FORMAT_VALIDATION_FAILS("请求数据格式验证失败","19007","DATA_FORMAT_VALIDATION_FAILS"),
			FW_RECEIPT_REPOSITORY_FAIL("凭证复核失败","19008","RECEIPT_REPOSITORY_FAIL"),
			FW_CALL_CORE_WITHDRAW_EXCEPTION("调用核心出款服务发生异常","19009","CALL_CORE_WITHDRAW_EXCEPTION"),
			FW_NOT_BACK_CARD_INFO("没有设置出款所需银行卡信息","19010","NOT_BACK_CARD_INFO"),
			FW_DATA_GROUND_FAILS("出款收单失败","19011","DATA_GROUND_FAILS"),
			FW_MA_INTERFACE_EXCEPTION("调用MA接口异常","19012","MA_INTERFACE_FAILS"),
			FW_MA_DATA_FAILS("调用MA无数据","19013","MA_DATA_FAILS"),
			FW_CRM_INTERFACE_EXCEPTION("调用CRM系统异常","19014","CRM_INTERFACE_FAILS"),
			FW_CRM_DATA_FAILS("调用CRM无数据","19015","CRM_DATA_FAILS"),
			FW_FOS_DATA_FAILS("调用FOS无数据","19016","FW_FOS_DATA_FAILS"),
			FW_SYSTEM_ERROR("T0系统异常","19017","SYSTEM_ERROR"),
			FW_CORE_DATA_ERROR("拼装出款数据异常","19018","CORE_DATA_ERROR"),
			FW_TOTALAMOUNT_INSUFFICIENT("出款总额度不足","19019","TOTALAMOUNT_INSUFFICIENT"),
			FW_FROZENLIMITATION_FAIL("冻结额度失败","19020","FROZENLIMITATION_FAIL"),
			FW_LOANINGCONFIGBEAN_NOTFOUND("垫资方信息不存在","19021","LOANINGCONFIGBEAN_NOTFOUND"),
			FW_MERCHANT_NOTFOUND("商户信息不存在","19022","MERCHANT_NOTFOUND"),
			FW_PROMOTER_NOTFOUND("代理商信息不存在","19023","PROMOTER_NOTFOUND"),
			FW_GET_PROMOTER_AMOUNT_ISFAILL("获取代理商额度失败","19024","GET_PROMOTER_AMOUNT_ISFAILL"),
			FW_GET_MERCHANT_AMOUNT_ISFAILL("获取商户额度失败","19025","GET_MERCHANT_AMOUNT_ISFAILL"),
			FW_GET_TOTAL_AMOUNT_ISFAILL("获取出款总额失败","19026","GET_TOTAL_AMOUNT_ISFAILL"),
			FW_MERCHANT_NOT_OPEN_D1("未开通D1结算规则","19027","MERCHANT_NOT_OPEN_D1"),
			FW_MERCHANT_RATE_NOTFOUND("没有对应的商户费率","19028","MERCHANT_RATE_NOTFOUND"),
			FW_CARD_NOTIN_DESIGNATED("该商户出款银行卡不支持实时出款","19029","CARD_NOTIN_DESIGNATED"),
			FW_PRODUCT_CODE_IS_NULL("支付产品编码为空","19030","PRODUCT_CODE_IS_NULL"),
			FW_MERCHANT_FASTSFLAG_ISFALSE("商户未开通快速结算","19031","MERCHANT_FASTSFLAG_ISFALSE"),
			FW_MERCHANT_WALLETBALACE_ISENOUGH("商户钱包余额不足","19032","MERCHANT_WALLETBALACE_ISENOUGH"),
			FW_PAYER_ACCOUNT_INACTIVE("付款人账户未激活","19033","ZG_PAYER_ACCOUNT_INACTIVE"),
			FW_PAYER_ACCOUNT_LOCKED("付款人账户锁定","19034","ZG_PAYER_ACCOUNT_LOCKED"),
			FW_PAYER_ACCOUNT_OUT_FORBIDDEN("付款人账户止出","19035","ZG_PAYER_ACCOUNT_OUT_FORBIDDEN"),
			FW_PAYER_ACCOUNT_IN_FORBIDDEN("付款人账户止入","19036","ZG_PAYER_ACCOUNT_IN_FORBIDDEN"),
			FW_PAYER_ACCOUNT_CANCELED("付款人账户注销","19037","ZG_PAYER_ACCOUNT_CANCELED"),
			FW_PROMOTER_FASTSFLAG_ISFALSE("代理商未开通快速结算","19038","PROMOTER_FASTSFLAG_ISFALSE"),
			FW_MA_ACCOUNTTYPE_IS_NULL("没有对应的账户类型","19039","MA_ACCOUNTTYPE_IS_NULL"),
			FW_MA_ACCOUNTTYPE_NOT_CHECK("账户类型无法匹配","19040","MA_ACCOUNTTYPE_NOT_CHECK"),
			FW_BALANCE_IS_NULL("没有对应的余额信息","19041","BALANCE_IS_NULL"),
			FW_RADIO_IS_FAILL("费率操作失败","19042","RADIO_IS_FAILL"),
			FW_PARAM_CHECK_IS_FAILL("参数验证异常","19043","PARAM_CHECK_IS_FAILL"),
			FW_IDENTITY_INFO_IS_NULL("身份信息为空","19044","IDENTITY_INFO_IS_NULL"),
			FW_IDENTITY_LIMITE_NOT_ENOUGH("身份额度不足","19045","IDENTITY_LIMITE_NOT_ENOUGH"),
			FW_IDENTITY_LIMITE_QUERY_ERROR("身份额度查询异常","19046","FW_IDENTITY_LIMITE_QUERY_ERROR"),
			FW_REPEAT_REQUEST("重复请求","19046","FW_REPEAT_REQUEST"),
			FW_SYSTEM_PLATFORM_MAINTENANCE("平台维护中","19047","FW_SYSTEM_PLATFORM_MAINTENANCE"),
			FW_BACK_CARD_INFO_NAME_NOT_COINCIDENT("收款人姓名不匹配","19048","BACK_CARD_INFO_NAME_NOT_COINCIDENT"),
			FW_IDENTITY_LIMITE_MERCHANT_TOO_MUCH("身份额度对应的商户数量太多","19049","IDENTITY_LIMITE_MERCHANT_TOO_MUCH"),
			FW_UNKOWN_ERROR("未知系统异常","19999","FW_UNKOWN_ERROR"),
			FW_SUCCESS("出款成功","0","SUCCESS");
	public final String msg;
	public final String code;
	public final String desc;


	private ReturnCodeEnums(String msg,String code, String desc) {
		this.msg = msg;
		this.code = code;
		this.desc=desc;
	}

	public static ReturnCodeEnums getEnumsByCode(String code) {
		ReturnCodeEnums returnCodeEnums[] = ReturnCodeEnums.values();
		for (ReturnCodeEnums enums : returnCodeEnums) {
			if (enums.code.equalsIgnoreCase(code)) return enums;
		}
		return null;
	}

}