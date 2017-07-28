package com.sdp.mc.service.newt0;

import java.math.BigDecimal;

import com.sdp.mc.common.vo.ErrorMessageVO;

public interface NewT0MerchantFastSettleService {

	/**
	 * 商户申请退费
	 * @param merchantFastSettleReqId 商户快速结算申请记录id
	 * **/
	public ErrorMessageVO remitFastSettleFee(Long merchantFastSettleReqId);
	public ErrorMessageVO refoundWithdrawFee(Long reqID,String operator);

	/**
	 * 自动变更商户额度
	 */
	@Deprecated
	public String changMerchantLimit();

	/**
	 * 额度耗尽提醒
	 */
	public void remindRunOut();

	public long changMerchantLimit(String merchantNo, String posMerchantType,
			BigDecimal maxLimit, BigDecimal minLimit, String operatorId,String limitType) throws Exception;
	
	String changeMerchantLimit();
}
