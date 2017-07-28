package com.sdp.withdraw.service;

import com.sdp.mc.common.dto.WithdrawCoreServiceDTO;
import com.sdp.mc.common.dto.WithdrawFailRetryRuleDTO;

/**

 */
public interface WithdrawFailService {
	

	/**
	 * 出款失败处理的方法
	 * @param serviceDTO  服务请求对象
	 * @param errorCode 返回的错误编码
	 */
	public void withdrawFailDealWith(WithdrawCoreServiceDTO serviceDTO, String errorCode);
	
	/**
	 * 出款失败处理的方法
	 * @param reqId 请求ID
	 * @param remitVoucherNo 支付单号
	 * @param errorCode 错误编码
	 * @return  请求数据的状态
	 */
	public Integer withdrawFailDealWith(Long reqId, String remitVoucherNo, String errorCode);
   /**
    * 创查询失败重试规则
    * @param errorCode 错误码
    * @param retryTimes 重试次数
    * @param merchantNo 商户号
    * @param mcType 商户类型
    * @return
    */
	WithdrawFailRetryRuleDTO queryWithdrawFailRetryRule(String errorCode, Integer retryTimes,String withdrawType, String merchantNo, String mcType);
	/**
	 * 出款失败处理的方法
	 * @param serviceDTO  服务请求对象
	 * @param errorCode 返回的错误编码
	 */
   public void withdrawFailDealWith(WithdrawCoreServiceDTO serviceDTO, String errorCode, String errorMessage);

	Integer withdrawFailDealWith(Long reqId, String remitVoucherNo, String errorCode, String errorMessage);


	
}
