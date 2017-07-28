package com.sdp.mc.facade.msp;

import java.util.List;

import com.sdp.mc.common.vo.ErrorMessageVO;
import com.shengpay.pos.pcs.api.settle.StraightlyCfg;
import com.shengpay.pos.pcs.api.settle.ValidOrders;
import com.shengpay.pos.pcs_t0.api.fastsettle.FastSettleFundOutInfo;

public interface FastSettleHessianInterface {

	/**
	 * 手动发起结算
	 * 
	 * @param merchantNo
	 *            商户编号
	 * @param posMerchantNo
	 *            POS商户编号
	 * @param ids
	 *            订单号集
	 * @return
	 */
	public abstract ErrorMessageVO straightlySettle(String merchantNo, String posMerchantNo, List<Long> ids, String bizId, Integer shareType);

	/**
	 * 查询可发起快速结算的订单编号
	 * 
	 * @param merchantNo
	 *            商户编号
	 * @param posMerchantNo
	 *            POS商户编号
	 * @return
	 */
	public abstract List<ValidOrders> queryValidOrderList(String merchantNo, String posMerchantNo);

	/**
	 * 获取快速结算配置
	 * 
	 * @param merchantNo
	 *            商户编号
	 * @param posMerchantNo
	 *            POS商户编号
	 * @return
	 */
	public abstract StraightlyCfg getStraightlyCfg(String merchantNo, String posMerchantNo);

	/**
	 * 获取代理商快速结算配置
	 * 
	 * @param promoterId
	 * @return
	 */
	public abstract StraightlyCfg getPromoterStraightlyCfg(Long promoterId);
	
	/**
	 * 新T0
	 * 查询快速结算及出账信息
	 * 
	 * @param list
	 * @return
	 */
	public List<FastSettleFundOutInfo> queryFastSettleFundOutInfo(List<String> list);

}