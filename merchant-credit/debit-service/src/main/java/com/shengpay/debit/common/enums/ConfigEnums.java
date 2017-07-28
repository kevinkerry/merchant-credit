package com.shengpay.debit.common.enums;


public enum ConfigEnums {

	// 策略参数
    RISK_POLICY_NAME("risk.policy.name", "策略模型的参数名"),
    RISK_POLICY_VALUE("risk.policy.value","策略模型的参数值"),
    RISK_OWNER_NAME("risk.owner.name","策略模型评估项的参数名"),
    RISK_OWNER_VALUE("risk.owner.value","策略模型评估项的参数值"),

    // 申请多少天后可以重新申请
    APPLY_AFTER_DAYS("apply.after.days","申请多少天后可以重新申请"),
	// 风控通知评级结果地址
    CREDIT_RISK_NOTIFY_URL("credit.risk.notify.url","风控通知评级结果地址"),

    OVER_DUE_RATE("overdue.rate","罚息利率"),

    AGREE_TEMP_ADDRESS("agree.temp.address", "协议模板地址"),

    DEBIT_ORDER_INTEREST_IN_TOTAL("debit.order.interest.in.total", "借款订单利息占总费用的比例"),
    PROFIT_RATE("profit.rate", "分润比例"),
    OVER_DAYS("overdays", "代理商担保超时时间"),

    VERIFY_NO_TIP("verify.no.tip", "未实名认证提示"),
    VERIFY_DIFFERENCE_TIP("verify.difference.tip", "钱包户的实名信息和登录的商户号的结算户的2项信息不匹配"),
    VERIFY_SHOW_TIP("verify.show.tip", "实名信息提示"),
    DEBIT_LOAN_STEP1_TIP("debit.loan.step1.tip", "用款申请第一阶段提示"),
    DEBIT_LOAN_STEP2_TIP("debit.loan.step2.tip", "用款申请第二阶段提示"),
    DEBIT_LOAN_STEP3_SUCCESS_TIP("debit.loan.step3.success.tip", "用款申请第三阶段成功提示"),
    DEBIT_LOAN_STEP3_ERROR_TIP("debit.loan.step3.error.tip", "用款申请第三阶段失败提示"),
    DEBIT_LOAN_STEP3_REFUSE_TIP("debit.loan.step3.refuse.tip", "用款申请第三阶段拒绝提示"),

    TTD_IN_AGENT_PROMPT_MESSAGE("ttd.in.agent.prompt.message","订单在代理商环节提示信息"),
    TTD_IN_SFT_PROMPT_MESSAGE("ttd.in.sft.prompt.message","订单在盛付通环节提示信息"),
    TTD_PROMOTER_GUARANTEE_MESSAGE("ttd.promoter.guarantee.message","订单在盛付通环节提示信息"),
    DEBIT_ORDER_SERVER_RATE("dabit.order.server.rate", "服务费"),

    CREDIT_INIT_APPLY_SUCCESS("credit.apply.success", "额度申请通过"),
    CREDIT_PRODUCT_DETAIL_AUDIT("credit.product.detail.audit", "审核时间"),
    CREDIT_PRODUCT_DETAIL_FEE("credit.product.detail.fee", "贷款费用"),
    CREDIT_PRODUCT_DETAIL_CONDITION("credit.product.detail.condition", "申请条件"),
    CREDIT_PRODUCT_DETAIL_MATERIAL("credit.product.detail.material", "必须申请资料"),
    CREDIT_PRODUCT_DETAIL_DESC("credit.product.detail.desc", "说明"),
    VERIFY_REGISTERED_URL("verify.show.offical.website.url","官网URL"),
    WITHHOLD_BANK_CODE("withhold.bank.code","代扣银行列表"),

    ;

    ConfigEnums(String key, String desc) {
        this.key = key;
        this.desc = desc;
    }

    private String key;
    private String desc;

    public String getKey() {
		return key;
	}

//	public void setKey(String key) {
//		this.key = key;
//	}

	public String getDesc() {
        return desc;
    }

//    public void setDesc(String desc) {
//        this.desc = desc;
//    }

}
