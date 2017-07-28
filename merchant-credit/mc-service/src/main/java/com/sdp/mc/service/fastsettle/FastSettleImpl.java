package com.sdp.mc.service.fastsettle;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sdp.mc.common.constant.MerchantContractCst;
import com.sdp.mc.common.constant.MerchantCreditConstant;
import com.sdp.mc.common.constant.WithdrawConstant;
import com.sdp.mc.common.enums.FsConfigChangeStatusEnum;
import com.sdp.mc.common.enums.OpObjTypeEnums;
import com.sdp.mc.common.enums.OpTypeEnums;
import com.sdp.mc.common.hessian.RemotingCallUtil;
import com.sdp.mc.common.hessian.RemotingModuleEnum;
import com.sdp.mc.common.util.DateUtil;
import com.sdp.mc.common.vo.ErrorMessageVO;
import com.sdp.mc.common.vo.MerchantFastSettleVO;
import com.sdp.mc.facade.msp.MspFacade;
import com.sdp.mc.ffconfig.dao.FastSettleConfigDO;
import com.sdp.mc.ffconfig.dao.FastSettleConfigDOExample;
import com.sdp.mc.ffconfig.manager.FastSettleConfigManager;
import com.sdp.mc.integration.msp.MerchantInfoDTO;
import com.sdp.mc.integration.msp.request.MspModifyRequest;
import com.sdp.mc.service.McManagerService;
import com.sdp.mc.view.dao.ViewMerchantInfoDTO;
import com.sdp.withdraw.enums.PosMerchantTypeEnums;
import com.sdp.withdraw.enums.ReturnCodeEnums;
import com.sdp.withdraw.enums.WithdrawRatioTypeEnums;
import com.sdp.withdraw.vo.ratio.WithdrawRatioQueryResponse;
import com.sdp.withdraw.vo.ratio.WithdrawRatioResponse;
import com.sdp.withdraw.vo.ratio.WithdrawRatioResult;
import com.shengpay.pos.operating.api.pcs.settle.MerchantSettlePO;
import com.shengpay.pos.operating.api.pcs.settle.MerchantSettleRO;
import com.shengpay.pos.operating.api.pcs.settle.SettleInfoInterface;
import com.shengpay.service.view.MerchantInfoService;
import com.shengpay.service.withdraw.T0WithdrawService;

@Service("fastSettle")
public class FastSettleImpl implements FastSettle {
	private static Logger logger = LoggerFactory.getLogger(FastSettleImpl.class);
	@Autowired
	private MspFacade mspFacade;
	@Autowired
	private FastSettleConfigManager fastSettleConfigManager;
	@Autowired
	private McManagerService mcManagerService;
	// @Autowired
	// private MerchantWithdrawRatioAPI withdrawRatioService4Hessian;

	@Autowired
	private T0WithdrawService t0WithdrawService;

	private SettleInfoInterface settleInfoInterface;

	@Autowired
	private MerchantInfoService merchantInfoService;

	/*
	 * @Autowired private MspPosMerchantDAO mspPosMerchantDAO;
	 */

	@Transactional("mc_transactionManager")
	public ErrorMessageVO<Object> setMerchantFastSettleConfig(MerchantFastSettleVO fastSettleVO, String operatorId) {
		MspModifyRequest mspModifyRequest = new MspModifyRequest(OpObjTypeEnums.MERCHANT.code, Long.parseLong(fastSettleVO.getMerchantId()),
				OpTypeEnums.MERCHANT_FASTSETTLE_CONFIG_OP.code);
		mspModifyRequest.setFastSettleFlag(StringUtils.isEmpty(fastSettleVO.getFastSettleFlag()) ? 0 : Integer.parseInt(fastSettleVO
				.getFastSettleFlag()));
		if (fastSettleVO.getFastSettleFlag() != null
				&& !MerchantCreditConstant.FAST_SETTLE_FLAG_OPEN.equals(fastSettleVO.getFastSettleFlag().toString())) {
			mspModifyRequest.setFastSettleLimit(WithdrawConstant.FEE_EMPTY); // 关闭操作将
																				// 快速结算额度修改0
			mspModifyRequest.setFastSettleHolidayFee(WithdrawConstant.FEE_EMPTY);
			mspModifyRequest.setFastSettleWorkdayFee(WithdrawConstant.FEE_EMPTY);
			mspModifyRequest.setAutoFastSettle(Integer.parseInt(WithdrawConstant.FEE_EMPTY));
		} else {
			mspModifyRequest.setFastSettleLimit(fastSettleVO.getFastSettleLimit());
			if (StringUtils.isNotBlank(fastSettleVO.getHolidayFee())) {
				mspModifyRequest.setFastSettleHolidayFee(fastSettleVO.getHolidayFee());
			} else {
				return new ErrorMessageVO<Object>(false, "-1", "节假日费率为空");
			}
			if (StringUtils.isNotBlank(fastSettleVO.getWorkdayFee())) {
				mspModifyRequest.setFastSettleWorkdayFee(fastSettleVO.getWorkdayFee());
			} else {
				return new ErrorMessageVO<Object>(false, "-1", "工作日费率为空");
			}
			// 新增是否自动快速结算(0:否，1:是)、手机号字段
			if (StringUtils.isNotBlank(fastSettleVO.getAutoFastSettle())) {
				mspModifyRequest.setAutoFastSettle(Integer.parseInt(fastSettleVO.getAutoFastSettle()));
			} else {
				return new ErrorMessageVO<Object>(false, "-1", "请选择是否自动快速结算");
			}
			if (StringUtils.isNotBlank(fastSettleVO.getMerchantPhone())) {
				mspModifyRequest.setMerchantPhone(fastSettleVO.getMerchantPhone());
			}
			if (StringUtils.isNotBlank(fastSettleVO.getPromoterType())) {
				mspModifyRequest.setPromoterType(fastSettleVO.getPromoterType());
			}
			if (fastSettleVO.getLoaningType() != null) {
				mspModifyRequest.setLoaningType(fastSettleVO.getLoaningType());
			}
		}

		if (StringUtils.isNotBlank(fastSettleVO.getMerchantPhone())) {
			mspModifyRequest.setMerchantPhone(fastSettleVO.getMerchantPhone());
		}
		if (fastSettleVO.getPromoterId() != null) {
			mspModifyRequest.setPromoterId(Long.parseLong(fastSettleVO.getPromoterId()));
		}
		try {
			long fcmId = 0l;
			try {
				fcmId = mspFacade.createFsconfigChange(mspModifyRequest, operatorId);
			} catch (Exception e) {
				logger.error("FastSettleImpl #setMerchantFastSettleConfig call mspFacade.createFsconfigChange Exception:", e);
				return new ErrorMessageVO<Object>(false, "-1", e.getMessage());
			}
			ErrorMessageVO<Object> mspResponseDTO = mspFacade.modifyFastSettleConfig2Msp(mspModifyRequest, fcmId);
			logger.info("#setMerchantFastSettleConfig modifyFastSettleConfig2Msp Response:" + ToStringBuilder.reflectionToString(mspResponseDTO));
			if (mspResponseDTO.isSuccess()) {
				mspFacade.modifyFsConfigChangeStatus(fcmId, FsConfigChangeStatusEnum.SUCCESS.code);
				mspResponseDTO.setErrorMessage(MerchantCreditConstant.MC_PROMOTER_M_MERCHANT_SUCCESS);
			} else {
				mspFacade.modifyFsConfigChangeStatus(fcmId, FsConfigChangeStatusEnum.FAILUE.code);
				mspResponseDTO.setErrorMessage(MerchantCreditConstant.MC_PROMOTER_M_MERCHANT_FAILURE);
//				return mspResponseDTO;
			}
			// 先更新费率
			int ratioStatus = mspModifyRequest.getFastSettleFlag();
			int ratioType = 0;
			if (fastSettleVO.getMcType().equals(MerchantContractCst.TYPE_POS_MERCHANT)) {
				ratioType = WithdrawRatioTypeEnums.POS_T0_SETTLE_RATIO.code;
			} else if (fastSettleVO.getMcType().equals(MerchantContractCst.TYPE_MPOS_MERCHANT)) {
				ratioType = WithdrawRatioTypeEnums.MPOS_T0_SETTLE_RATIO.code;
			} else if (PosMerchantTypeEnums.EASYPAY_MERCHANT.code.equals(fastSettleVO.getMcType())) {
				ratioType = WithdrawRatioTypeEnums.EASYPAY_T0_SETTLE_RATIO.code;
			} else {
				return new ErrorMessageVO<Object>(false, "-1", "暂不支持的商户类型");
			}

			WithdrawRatioResponse res = t0WithdrawService.merchantT0Ratio(fastSettleVO.getMerchantNo(), fastSettleVO.getMcType(), ratioType,
					new BigDecimal(fastSettleVO.getWorkdayFee()), new BigDecimal(fastSettleVO.getHolidayFee()), ratioStatus);
			logger.info("#setMerchantFastSettleConfig merchantT0Ratio WithdrawRatioResponse:" + ToStringBuilder.reflectionToString(res));
			if (res == null || (StringUtils.isBlank(res.getErrorCode()))) {
				return new ErrorMessageVO<Object>(false, "-1", "系统忙，请稍后再试");
			} else if (!ReturnCodeEnums.FW_SUCCESS.code.equals(res.getErrorCode())) { return new ErrorMessageVO<Object>(false, "-1",
					res.getErrorMsg()); }
			logger.info("FastSettleImpl #setMerchantFastSettleConfig #merchantT0Ratio.WithdrawRatioRespons.errcode:" + res.getErrorCode()
					+ ",errorMsg:" + res.getErrorMsg());
			return new ErrorMessageVO<Object>(true);
		} catch (Exception e) {
			logger.error("FastSettleImpl #setMerchantFastSettleConfig error:", e);
			return new ErrorMessageVO<Object>(false, "-1", MerchantCreditConstant.MC_SYSTEM_EXCEPTION);
		}
	}

	public FastSettleConfigDO getFastSettleConfig(Long objId, Integer objType) {
		FastSettleConfigDOExample configDOExample = new FastSettleConfigDOExample();
		configDOExample.createCriteria().andObjIdEqualTo(objId).andObjTypeEqualTo(objType);
		List<FastSettleConfigDO> list = fastSettleConfigManager.selectByQuery(configDOExample);
		if (list == null || list.isEmpty()) {
			logger.info("FastSettleImpl #getFastSettleConfig, objId:" + objId + ",objType:" + objType + ",is null.");
			return null;
		}
		return list.get(0);
	}

	// 修改自动快速结算
	@Transactional("mc_transactionManager")
	public ErrorMessageVO<Object> setMerchantAutoSettle(MerchantFastSettleVO fastSettleVO, String operatorId) {

		MspModifyRequest mspModifyRequest = new MspModifyRequest(OpObjTypeEnums.MERCHANT.code, Long.parseLong(fastSettleVO.getMerchantId()),
				OpTypeEnums.MERCHANT_FASTSETTLE_CONFIG_OP.code);
		mspModifyRequest.setAutoFastSettle(Integer.parseInt(fastSettleVO.getAutoFastSettle()));
		try {
			long fcmId = 0l;
			fcmId = mspFacade.createFsconfigChange(mspModifyRequest, operatorId);
			logger.info("FastSettleImpl #setMerchantFastSettleConfig fcmId:" + fcmId);
			// 查询merchantSettle表
			MerchantInfoDTO merchantInfoDTO = mspFacade.findMerchantInfoByMerchantId(Long.parseLong(fastSettleVO.getMerchantId()));
			// MspPosMerchantEO mspPosMerchantEO =
			// mspPosMerchantDAO.selectPosMerchantInfoByMerchantNo(merchantInfoDTO.getMerchantNo().toString());
			ViewMerchantInfoDTO merchantInfo = merchantInfoService.queryMerchantInfoByMerchantId(Long.parseLong(fastSettleVO.getMerchantId()));
			MerchantSettlePO merchantSettlePO = new MerchantSettlePO();
			logger.info("FastSettleImpl #setMerchantAutoSettle :  mspPosMerchantEO:" + ToStringBuilder.reflectionToString(merchantInfo));
			if (merchantInfo != null) {
				merchantSettlePO.setAutoFastSettleFlg(merchantInfo.getAutoFastSettleFlag());
				merchantSettlePO.setFastSettleFlag(merchantInfo.getMerchantFsFlag());
				if (merchantInfo.getMerchantFsLimit() != null) {
					merchantSettlePO.setFastSettleLimit(merchantInfo.getMerchantFsLimit().toString());
				}
				merchantSettlePO.setFastSettleMinLimit(merchantInfo.getMerchantFsMinLimit());
				merchantSettlePO.setHandPhoneNo(merchantInfo.getMerchantPhoneNo());
				merchantSettlePO.setMerchantId(fastSettleVO.getMerchantId());
				merchantSettlePO.setMsiHolidayFee(WithdrawConstant.FEE_EMPTY);
				merchantSettlePO.setMsiWorkDayFee(WithdrawConstant.FEE_EMPTY);
				merchantSettlePO.setWithdrawHolidayFee(WithdrawConstant.FEE_EMPTY);
				merchantSettlePO.setWithdrawWorkDayFee(WithdrawConstant.FEE_EMPTY);
			}
			MerchantSettleRO merchantSettleRO = getSettleInfoInterface().saveMerchantSettleInfo(merchantSettlePO);

			String code = merchantSettleRO.getCode();
			String msg = merchantSettleRO.getErrorMsg();
			logger.info("FastSettleImpl #setMerchantAutoSettle : getSettleInfoInterface().saveMerchantSettleInfo Response: code:" + code + ",msg:"
					+ msg);
			if (MerchantCreditConstant.OPERATING_INTERFACE_RESPONSE_CODE_SUCCESS.equals(code.trim())) {
				mspFacade.modifyFsConfigChangeStatus(fcmId, FsConfigChangeStatusEnum.SUCCESS.code);
			} else {
				mspFacade.modifyFsConfigChangeStatus(fcmId, FsConfigChangeStatusEnum.FAILUE.code);
				return new ErrorMessageVO<Object>(false);
			}

		} catch (Exception e) {
			logger.error("FastSettleImpl #setMerchantAutoSettle error:", e);
			return new ErrorMessageVO<Object>(false);
		}
		return new ErrorMessageVO<Object>(true);

		// FastSettleConfigDOExample example = new FastSettleConfigDOExample();
		// example.createCriteria().andObjIdEqualTo(Long.parseLong(fastSettleVO.getMerchantId())).andObjTypeEqualTo(OpObjTypeEnums.MERCHANT.code);
		// List<FastSettleConfigDO> result =
		// fastSettleConfigManager.selectByExample(example);
		// if (result != null && result.size() > 1) {
		// logger.error("FastSettleImpl #setMerchantAutoSettle :" +
		// fastSettleVO.toString() + ",not unique record.");
		// return new ErrorMessageVO(false);
		// }
		//
		// FastSettleConfigDO settleConfigDO = new FastSettleConfigDO();
		// settleConfigDO.setObjId(Long.parseLong(fastSettleVO.getMerchantId()));
		// settleConfigDO.setObjType(OpObjTypeEnums.MERCHANT.code);
		// settleConfigDO.setAutoFastSettle(Integer.parseInt(fastSettleVO.getAutoFastSettle()));
		//
		// try {
		// if (result == null || result.isEmpty()) {
		// settleConfigDO.setCreateTime(new Date());
		// fastSettleConfigManager.insert(settleConfigDO);
		// } else {
		// settleConfigDO.setPfcId(result.get(0).getPfcId());
		// settleConfigDO.setUpdateTime(new Date());
		// fastSettleConfigManager.updateByPrimaryKeySelective(settleConfigDO);
		// }
		// } catch (Exception e) {
		// logger.error("FastSettleImpl #setMerchantAutoSettle :" + e);
		// return new ErrorMessageVO(false);
		// }
		// return new ErrorMessageVO(true);
	}

	private SettleInfoInterface getSettleInfoInterface() {
		if (settleInfoInterface == null) {
			settleInfoInterface = RemotingCallUtil.getHessianServiceByModuleWithoutCanonicalName(RemotingModuleEnum.OPERATING_SETTLE_MODULE,
					SettleInfoInterface.class);
		}
		return settleInfoInterface;
	}

	@Override
	public WithdrawRatioResult getTomorrowEffectiveRatio(String merchantNo, String mcType) {
		int ratioType = 0;
		if (PosMerchantTypeEnums.POS_MERCHANT.code.equals(mcType)) {
			ratioType = WithdrawRatioTypeEnums.POS_T0_SETTLE_RATIO.code;
		} else if (PosMerchantTypeEnums.MPOS_MERCHANT.code.equals(mcType)) {
			ratioType = WithdrawRatioTypeEnums.MPOS_T0_SETTLE_RATIO.code;
		} else if (PosMerchantTypeEnums.EASYPAY_MERCHANT.code.equals(mcType)) {
			ratioType = WithdrawRatioTypeEnums.EASYPAY_T0_SETTLE_RATIO.code;
		} else {
			return null;
		}
		WithdrawRatioQueryResponse response = t0WithdrawService.queryMerchantT0Ratio(merchantNo, mcType, ratioType,
				DateUtil.generateDawnTimeStamp(DateUtil.increaseDate(new Date(), 1)));
		if (response != null && response.getWithdrawRatioResults() != null && !response.getWithdrawRatioResults().isEmpty()) { return response
				.getWithdrawRatioResults().get(0); }
		return null;
	}
	@Override
	public WithdrawRatioResult getCurrentEffectiveRatio(String merchantNo, String mcType) {
		int ratioType = 0;
		if (PosMerchantTypeEnums.POS_MERCHANT.code.equals(mcType)) {
			ratioType = WithdrawRatioTypeEnums.POS_T0_SETTLE_RATIO.code;
		} else if (PosMerchantTypeEnums.MPOS_MERCHANT.code.equals(mcType)) {
			ratioType = WithdrawRatioTypeEnums.MPOS_T0_SETTLE_RATIO.code;
		} else if (PosMerchantTypeEnums.EASYPAY_MERCHANT.code.equals(mcType)) {
			ratioType = WithdrawRatioTypeEnums.EASYPAY_T0_SETTLE_RATIO.code;
		} else {
			return null;
		}
		WithdrawRatioQueryResponse response = t0WithdrawService.queryMerchantT0Ratio(merchantNo, mcType, ratioType,
				DateUtil.generateDawnTimeStamp(new Date()));
		if (response != null && response.getWithdrawRatioResults() != null && !response.getWithdrawRatioResults().isEmpty()) { return response
				.getWithdrawRatioResults().get(0); }
		return null;
	}
}
