package com.sdp.mc.msp.api;

import javax.jws.WebService;

import com.sdp.mc.msp.api.vo.ApplyResult;
import com.sdp.mc.msp.api.vo.MCFastSettleCfg;
import com.sdp.mc.msp.api.vo.MposFastSettleInfo;
import com.sdp.mc.msp.api.vo.ValidOrderResult;
@WebService
public interface MposHessianApi {

	/**
	 * 3.1.	获取MPOS T0业务信息
	 *
	 * @param merchantNo
	 *            商户号(6位)
	 * @param posMerchantNo
	 *            Pos商户号
	 * @return
	 */
	public abstract MposFastSettleInfo getMposFastSettleInfo(String merchantNo, String posMerchantNo);

	/**
	 * 3.2.	MPOS T0交易申请
	 *
	 * @param merchantNo
	 *            商户编号
	 * @param posMerchantNo
	 *            POS商户编号
	 * @param txnIds
	 *            申请T0交易Id
	 *
	 * @return
	 */
	public abstract ApplyResult applyMposFastSettle(String merchantNo, String posMerchantNo,String[] txnIds);

	/**
	 * 3.2.查询可发起快速结算的订单编号
	 *
	 * @param merchantNo
	 *            商户编号
	 * @param posMerchantNo
	 *            POS商户编号
	 * @return 订单号结果信息
	 */
	public abstract ValidOrderResult queryValidOrderList(String merchantNo, String posMerchantNo);

	/**
	 * 3.4.	商户快速结算信息
	 * @param merchantNo 商户编号
	 * @param posMerchantNo POS商户编号
	 * @return
	 */
	public abstract MCFastSettleCfg getMerchantFastSettleCfg(String merchantNo, String posMerchantNo);



}