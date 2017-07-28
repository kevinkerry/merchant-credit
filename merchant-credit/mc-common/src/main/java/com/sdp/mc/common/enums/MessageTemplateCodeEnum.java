package com.sdp.mc.common.enums;

public enum MessageTemplateCodeEnum {

	AUDIT_ADDMARGIN_SUCCESS("audit.addMargin.success", "追加保证金后修改配置额度成功，提醒短信模板"),
	AUDIT_TEMP_LIMIT_SUCCESS("audit.temp.limit.success", "临时调额成功，提醒短信模板"),
	AUDIT_TEMP_LIMIT_FAIL("audit.temp.limit.fail", "临时调额拒绝，提醒短信模板"),
	AUDIT_TEMP_LIMIT_UNDO("audit.temp.limit.undo", "临时调额失效，提醒短信模板"),
	MARGIN_REDEEM_MESSAGE_MARG("margin.redeem.template.marg","全部保证金取回短信模板"),
	MARGIN_REDEEM_MESSAGE_FLOAT("margin.redeem.template.float","浮动保证金取回短信模板"),
	MARGIN_REDEEM_MESSAGE_MINIMARGINREDEEM("margin.redeem.template.mini","保底保证金取回短信模板"),
	REMIND_ALL_RUN_OUT("remind.all.run.out","总额度消耗完毕提醒短信"),
	PROMOTER_LIMIT_NO_ENOUGH_REMIND_MERCHANT("remind.promoter.run.out","代理商额度消耗完毕"),
	PROMOTER_LIMIT_NO_ENOUGH_REMIND_PROMOTER("promoter.limit.no.enough.remind.promoter","代理商额度不足提醒代理商"),
	TIMED_TASK_EXECUTE_FAIL("timed.task.execute.fail","任务执行失败，提醒短信模板"),
	MERCHANT_LIMIT_NO_ENOUGH_REMIND_MERCHANT("remind.merchant.run.out","商户额度消耗完毕");


	private String key;
	private String name;

	private MessageTemplateCodeEnum(String key, String name) {
		this.key = key;
		this.name = name;
	}

	public String getKey() {
		return key;
	}

//	public void setKey(String key) {
//		this.key = key;
//	}

	public String getName() {
		return name;
	}

//	public void setName(String name) {
//		this.name = name;
//	}
}
