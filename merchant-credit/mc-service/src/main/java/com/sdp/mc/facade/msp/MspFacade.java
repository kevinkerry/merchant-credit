package com.sdp.mc.facade.msp;

import java.math.BigDecimal;

import com.sdp.mc.common.exception.FastSettleLimitException;
import com.sdp.mc.common.vo.ErrorMessageVO;
import com.sdp.mc.integration.msp.MerchantInfoDTO;
import com.sdp.mc.integration.msp.PromoterInfoDTO;
import com.sdp.mc.integration.msp.request.MspModifyRequest;
import com.shengpay.pos.operating.api.pcs.settle.MerchantSettlePO;
import com.shengpay.pos.pcs.api.settle.StraightlyCfg;

public interface MspFacade {

	/**
	 * 根据POS代理商的商户号和MC_TYPE 查询唯一的 PromoterEO
	 *
	 * @param promoterNo
	 * @param mcType
	 * @return
	 */
	public PromoterInfoDTO findPromoterInfoByPromoterNoAndType(String promoterNo, String mcType);

	/**
	 * 根据代理商编号查询代理商信息
	 */
	public abstract PromoterInfoDTO findPromoterInfoByPromoterId(long promoterId);

	/**
	 * 根据商户号查询商户信息
	 *
	 * @param merchantNo
	 *            商户号
	 */
	// public abstract MerchantInfoDTO findMerchantInfoByMerchantNo(long
	// merchantNo);
	public abstract MerchantInfoDTO findMerchantInfoByMerchantNo(String merchantNo, String posMerchantType);

	/**
	 * 根据商户号查询商户信息
	 *
	 * @param merchantId
	 *            商户编号
	 */
	public abstract MerchantInfoDTO findMerchantInfoByMerchantId(long merchantId);

	/**
	 * Operating接口修改快速结算配置
	 *
	 * @param promoterModifyRequest
	 *            修改快速结算请求
	 */
	public ErrorMessageVO<Object> modifyFastSettleConfig2Msp(MspModifyRequest mspModifyRequest, Long fcmId);

	/**
	 * 验证商户快速结算配置
	 *
	 * @param merchantNo
	 * @return straightlyCfg.isStraightFlag() 今日可用额度
	 *         straightlyCfg.getValidCredit() 快速结算手续费率
	 *         straightlyCfg.getFeeRate() 今日总额度 straightlyCfg.getCredit()
	 *         straightFlag
	 */
	public abstract StraightlyCfg queryStraightlyCfg(Long merchantId);
	/**
	 * 验证商户快速结算配置
	 *
	 * @param merchantNo
	 * @return straightlyCfg.isStraightFlag() 今日可用额度
	 *         straightlyCfg.getValidCredit() 快速结算手续费率
	 *         straightlyCfg.getFeeRate() 今日总额度 straightlyCfg.getCredit()
	 *         straightFlag
	 */
	public abstract StraightlyCfg queryStraightlyCfg(Long merchantId,boolean needMail);



	/**
	 * 代理商获取代理商快速结算额度 straightlyCfg.getValidCredit()
	 *
	 * @param promoterId
	 *            代理商编号
	 * @return straightlyCfg.isStraightFlag() 今日可用额度
	 *         straightlyCfg.getValidCredit() 剩余额度 straightlyCfg.getFeeRate()
	 *         快速结算手续费率 straightlyCfg.getCredit() 今日总额度 straightFlag
	 */
	public abstract StraightlyCfg getPromoterCredit(Long promoterId);

	/**
	 *
	 * @param operatorId  操作人ID
	 * @param opType
	 *            操作类型 - 开通、关闭、追加、退回
	 * @param objType
	 *            对象类型 - 代理商、商户
	 * @param objId
	 *            对象ID
	 * @return
	 * @throws FastSettleLimitException
	 */
	public long createFsconfigChange(MspModifyRequest mspModifyRequest, String operatorId) throws FastSettleLimitException;


	public int modifyFsConfigChangeStatus(Long fcmId, int status);

	/**
	 * 判断该商户是否支持直连银行,代理商全资
	 *
	 * @param merchantNo商户号
	 * **/
	public ErrorMessageVO<Object> isSupportDirect2Bank4Agent(String merchantNo);

	/**
	 * 判断该商户是否支持直连银行,盛付通全资
	 *
	 * @param merchantNo商户号
	 * **/
	public ErrorMessageVO<Object> isSupportDirect2Bank4ShengPay(String merchantNo);

	/**
	 * 根据 promoterId 查询联系电话,如无电话则返回 null
	 * @param promoterId
	 * @return
	 */
	public String getPromoterMoileByPromoterId(long promoterId);
	/**
	 * 根据商户号，pos商户号查询商户信息
	 * @param merchantNo
	 * @param posMerchantNo
	 * @return
	 */
	public MerchantInfoDTO findMerchantInfoByMerchantNoPosMerchantNo(String merchantNo, String posMerchantNo);

	/**
	 * 判断是否在9加银行内
	 * @param bankCode
	 * @return
	 */
	public boolean validateFastFundOutBank(final String bankCode);
	/**
	 * 直连银行接口
	 * @param merchantNo
	 * @param zfCode
	 * @return
	 */
	public ErrorMessageVO<Object> authQuery(String merchantNo,String zfCode);

	/**
	 * 调用operaing接口参数配置
	 * @param mspModifyRequest
	 * @param fcmId
	 * @return
	 */
	public MerchantSettlePO mspModifyRequest2MerchantSettlePO(MspModifyRequest mspModifyRequest, Long fcmId);

	BigDecimal queryPmtCanUseFastSettleLimit(String pmtMerchantNo, String pmtMerchantType);
	/**
	 * 查询代理商工作日 节假日总额度
	 * @param pmtMerchantNo
	 * @param pmtMerchantType
	 * @param isHoliday
	 * @return
	 */
	public BigDecimal queryPmtFastSettleLimit(String pmtMerchantNo, String pmtMerchantType,boolean isHoliday);


}