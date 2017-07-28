package com.shengpay.debit.credit.lines.apply.enums;


/**
 * 额度申请状态
 * @author heyi.alex
 *
 */
public enum CreditLinesApplyStatusEnums {

    USER_MODIFY("0", "用户信息修改中"),
    READY_AGENT_SUBMIT("1","准备代理商确认中"),
    USER_INFO_SUBMIT("2","资料提交完毕，待初审"),
    RISK_SUBMIT("3","提交风控完毕"),
    RISK_NOTIFY("4","用户资料寄送中"),
    APPLY_FAIL("99","风控通知失败-未达到评级要求"),
    APLY_SUCCESS("100","审批成功")
    ;

    CreditLinesApplyStatusEnums(String key, String desc) {
        this.key = key;
        this.desc = desc;
    }

    public final String key;
    public final  String desc;
    public String getKey() {
		return key;
	}

	public String getDesc() {
		return desc;
	}
	public static CreditLinesApplyStatusEnums parse(String code) {
		for (CreditLinesApplyStatusEnums temp : CreditLinesApplyStatusEnums.values()) {
			if (temp.getKey().equals(code)) {
				return temp;
			}
		}
		return null;
	}
}
