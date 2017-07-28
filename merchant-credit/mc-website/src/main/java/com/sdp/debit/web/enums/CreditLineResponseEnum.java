package com.sdp.debit.web.enums;


/**
 * 额度申请，服务端响应
 * @author heyi.alex
 *
 */
public enum CreditLineResponseEnum {

	SAVE_SUCCESS("0", "保存成功"),
	USER_WALLET_LOGIN_NAME_NOT_NULL("2001", "盛付通个人钱账号不能为空"),
	ACCOUNT_NOT_EXISTS("2002", "钱包账户不存在"),
	PAY_PASSWORD_ERROR("2003", "支付密码出错"),
	PARAMETER_NOT_NULL("2004", "参数不能为空"),
	PERSONAL_WALLET_IS_ALREADY_BINDED("2005", "钱包账户已被占用"),
	EXISTS_APPLYING_RECORD("-92", "申请记录已存在"),
	EXISTS_UNPAYBACK_RECORD("-93", "很抱歉,您还有贷款未还完，请还完贷款后再次申请"),
	TTD_SERVICE_SHUT_DOWN("-94", "服务已关闭，若有疑问请致电021-20575188-807755"),
	CREDIT_PARAMETER_NOT_NULL("-95", "征信用户名,密码和征信报告至少输入一项"),
	SYSTEM_ERROR("9999", "系统错误"),
	APPLICANTNAME("2006","请填写姓名"),
	APPLICANTIDNO("2007","请填写身份证号"),
	POSITIVECARDFILEINFO("2008","请上传身份证正面照"),
	BACKCARDFILEINFO("2009","请上传身份证背面照"),
	QUANTITYOFCHILDREN("2010","请正确填写子女数量"),
	BUSINESSLICENSEFILEINFO("2011","请上传商户营业执照"),
	APPLICANTPHONE("2012","请正确填写申请人手机"),
	RESIDENTIAL("2013","请正确填写居住地址"),
	MANAGE("2014","请正确填写经营地址"),
	RELATIVE("2015","请正确填写其他联系人信息"),
	ACCOUNTBOOKFILEINFO("2016","请上传本人及子女户口本信息"),
	APPLICANTAMOUNT("2017","请选择申请额度"),
	RELATIVEREPEAT("2018","联系人填写重复"),
	;

	public final String code;
	public final String name;

	CreditLineResponseEnum(final String code, final String name) {
		this.code = code;
		this.name = name;
	}



}
