package com.shengpay.credit.itf;

import javax.jws.WebService;

import com.shengpay.credit.exception.CreditException;
/**
 * 征信系统wsdl客户端代码
 * 
 * @author wangjingao.william
 * **/
@WebService
public interface CreditModelService {

	/**
	 * 征信模型接口
	 * **/
	public String getCreditModel(String content) throws CreditException;
}
