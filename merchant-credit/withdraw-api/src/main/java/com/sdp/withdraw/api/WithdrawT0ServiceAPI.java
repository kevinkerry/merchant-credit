package com.sdp.withdraw.api;

import java.math.BigDecimal;

import javax.jws.WebService;

import com.sdp.withdraw.vo.WithdrawCheckRequest;
import com.sdp.withdraw.vo.WithdrawCheckResponse;
import com.sdp.withdraw.vo.WithdrawProductRequest;
import com.sdp.withdraw.vo.WithdrawProductResponse;
import com.sdp.withdraw.vo.WithdrawQueryRequest;
import com.sdp.withdraw.vo.WithdrawQueryResponse;
import com.sdp.withdraw.vo.WithdrawT0ServiceRequest;
import com.sdp.withdraw.vo.WithdrawT0ServiceResponse;
@WebService
public interface WithdrawT0ServiceAPI {
	/**
	 * t0WithdrawPos 该接口提供POS的T0出款服务(POS)
	 *
	 * @param request
	 * @return
	 */
	public WithdrawT0ServiceResponse t0WithdrawPos(WithdrawT0ServiceRequest request)throws Exception ;

	/**
	 * t0WithdrawBalance 服务于钱包余额发起的T0出款(MPOS)
	 *
	 * @param request
	 * @return
	 */
	public WithdrawT0ServiceResponse t0WithdrawBalance(WithdrawT0ServiceRequest request);
	/**
	 * queryT0Withdraw 提供T0出款查询服务
	 * @param request
	 * @return
	 */
	public WithdrawQueryResponse queryT0Withdraw(WithdrawQueryRequest  request);
	/**
	 * 检查是否可以发起T0出款
	 * @param request
	 * @return
	 * @throws Exception
	 */
	public WithdrawCheckResponse checkWithdraw(WithdrawCheckRequest request);
	/**
	 * 提供出款产品信息
	 * @param request
	 * @return
	 */
	public WithdrawProductResponse withdrawProduct(WithdrawProductRequest request);


	/**
	 * 根据商户号查询[商户/代理商]可用额度(T0)
	 * @param merchantNo 商户/代理商
	 * @param mcType 商户/代理商 类型
	 * @return 不存在返回 null
	 */
	public BigDecimal findCanUseQuota(String merchantNo,String mcType);

	/**
	 * 根据商户号查询[商户/代理商]出款总额度(T0)
	 * 根据类型查询商户 或者代理商的总额度
	 * POS商户额度节假日乘以50%（配置）
	 * @param merchantNo 商户/代理商
	 * @param mcType 商户/代理商 类型
	 * @return 不存在返回 0
	 */
	public BigDecimal findTotalAmount(String merchantNo,String mcType);
	/**
	 * 根据商户号查询[商户/代理商]出款总额度(T0)
	 * 根据类型查询商户 工作日节假日的总额度
	 * @param merchantNo
	 * @param mcType
	 * @param isHoliday
	 * @return
	 */
	public BigDecimal findTotalAmount(String merchantNo, String mcType, boolean isHoliday);
}