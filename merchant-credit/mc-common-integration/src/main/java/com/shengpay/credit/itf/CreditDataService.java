package com.shengpay.credit.itf;

import javax.jws.WebService;

import com.shengpay.credit.exception.CreditException;
/**
 * 征信系统wsdl客户端代码
 * 
 * @author wangjingao.william
 * **/
@WebService
public interface CreditDataService {

	/**
	 * 信用评估数据提交接口
	 * **/
	public String submitCredit(String content) throws CreditException;
	/**
	 * 信用评估结果查询接口
	 * **/
	public String getCreditScore(String content) throws CreditException;
}
