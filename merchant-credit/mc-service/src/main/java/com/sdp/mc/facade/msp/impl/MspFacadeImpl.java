package com.sdp.mc.facade.msp.impl;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import net.sf.json.JSONObject;

import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import com.google.gson.Gson;
import com.sdp.mc.common.bean.newt0.LoaningConfigBean;
import com.sdp.mc.common.constant.MerchantContractCst;
import com.sdp.mc.common.constant.MerchantCreditConstant;
import com.sdp.mc.common.enums.AlertMessageSendTypeEnum;
import com.sdp.mc.common.enums.FsConfigChangeStatusEnum;
import com.sdp.mc.common.enums.LoaningTypeEnum;
import com.sdp.mc.common.enums.OpObjTypeEnums;
import com.sdp.mc.common.enums.OpTypeEnums;
import com.sdp.mc.common.exception.FastSettleLimitException;
import com.sdp.mc.common.hessian.RemotingCallUtil;
import com.sdp.mc.common.hessian.RemotingModuleEnum;
import com.sdp.mc.common.util.ConfigOptionHelper;
import com.sdp.mc.common.vo.ErrorMessageVO;
import com.sdp.mc.config.manager.ConfigOptionManager;
import com.sdp.mc.facade.msp.FastSettleHessianInterface;
import com.sdp.mc.facade.msp.MspFacade;
import com.sdp.mc.fos.fundout.FundoutBankHelper;
import com.sdp.mc.integration.ma.dto.Promoter4MADTO;
import com.sdp.mc.integration.msp.MerchantInfoDTO;
import com.sdp.mc.integration.msp.PromoterInfoDTO;
import com.sdp.mc.integration.msp.request.MspModifyRequest;
import com.sdp.mc.msp.dao.FsConfigChangeDO;
import com.sdp.mc.msp.manager.FsConfigChangeManager;
import com.sdp.mc.sars.SarsService;
import com.sdp.mc.sars.bean.SarsCP261Bean;
import com.sdp.mc.sars.bean.SarsCP281Bean;
import com.sdp.mc.sars.bean.SarsCP285Bean;
import com.sdp.mc.sars.bean.SarsParentBean;
import com.sdp.mc.service.msp.dictionary.DictionaryHelper;
import com.sdp.mc.service.newt0.Newt0PromoterService;
import com.sdp.mc.service.newt0.loaning.config.LoaningCongfigService;
import com.sdp.mc.view.dao.ViewMerchantInfoDTO;
import com.sdp.mc.view.dao.ViewPromoterInfoDTO;
import com.sdp.withdraw.dao.PosMerchantInfoDO;
import com.sdp.withdraw.enums.PosMerchantTypeEnums;
import com.sdp.withdraw.enums.WithdrawRatioTypeEnums;
import com.sdp.withdraw.vo.ratio.WithdrawRatioQueryResponse;
import com.shengpay.boss.service.crm.query.api.DelegationPay2CardQueryService;
import com.shengpay.boss.service.crm.query.api.model.DelegationPay2CardInfo;
import com.shengpay.boss.service.crm.query.api.model.DelegationPay2CardQueryRequest;
import com.shengpay.boss.service.crm.query.api.model.DelegationPay2CardQueryResponse;
import com.shengpay.facade.ma.MAFacade;
import com.shengpay.mpos.realname.MerchantRealNameMPOS;
import com.shengpay.pos.PosExternalService;
import com.shengpay.pos.operating.api.pcs.settle.MerchantSettlePO;
import com.shengpay.pos.operating.api.pcs.settle.MerchantSettleRO;
import com.shengpay.pos.operating.api.pcs.settle.PromoterSettlePO;
import com.shengpay.pos.operating.api.pcs.settle.PromoterSettleRO;
import com.shengpay.pos.operating.api.pcs.settle.SettleInfoInterface;
import com.shengpay.pos.pcs.api.settle.StraightlyCfg;
import com.shengpay.service.alert.factory.AlertMessageSenderFactory;
import com.shengpay.service.crm.CrmService;
import com.shengpay.service.mail.AlertMessageSender;
import com.shengpay.service.view.MerchantInfoService;
import com.shengpay.service.view.PromoterInfoService;
import com.shengpay.service.withdraw.FwPosMerchantInfoService;
import com.shengpay.service.withdraw.T0WithdrawService;

@Service("MspFacade")
public class MspFacadeImpl implements MspFacade {

	private static Logger logger = LoggerFactory.getLogger(MspFacadeImpl.class);

	@Autowired
	protected FsConfigChangeManager fsConfigChangeManager;
	@Autowired
	private ConfigOptionManager configOptionManager;
	@Autowired
	private AlertMessageSenderFactory alertMessageSenderFactory;
	@Autowired
	private FastSettleHessianInterface fastSettleHessianInterfaceProxy;
	@Autowired
	private LoaningCongfigService loaningCongfigService;

	@Autowired
	private DelegationPay2CardQueryService delegationPay2CardQueryService;

	@Autowired
	private MAFacade maFacade;
	@Autowired
	private CrmService crmService;
	@Autowired
	private Newt0PromoterService newt0PromoterService;
	@Autowired
	private SarsService sarsService;
	@Autowired
	private MerchantRealNameMPOS realNameMpos;
	@Autowired
	private PosExternalService posExternalService;

	// @Autowired
	// private MerchantWithdrawRatioAPI withdrawRatioService4Hessian;

	@Autowired
	private T0WithdrawService t0WithdrawService;

	@Autowired
	private MerchantInfoService merchantInfoService;
	@Autowired
	private PromoterInfoService promoterInfoService;

	@Autowired
	private FwPosMerchantInfoService fwPosMerchantInfoService;

	/**
	 *
	 * @param opType
	 *            操作类型 - 开通、关闭、追加、退回
	 * @param objType
	 *            对象类型 - 代理商、商户
	 * @param objId
	 *            对象ID
	 * @return
	 * @throws FastSettleLimitException
	 * @throws Exception
	 */
	public long createFsconfigChange(MspModifyRequest mspModifyRequest, String operatorId) throws FastSettleLimitException {
		FsConfigChangeDO fsConfigChangeDO = new FsConfigChangeDO();

		int objType = mspModifyRequest.getObjType();
		long objId = mspModifyRequest.getObjId();
		int opType = mspModifyRequest.getOpType();

		fsConfigChangeDO.setOpType(opType);
		fsConfigChangeDO.setType(objType);
		fsConfigChangeDO.setObjId(objId);
		fsConfigChangeDO.setOperator(operatorId);
		if (mspModifyRequest.getPromoterMinMargin() != null) {
			fsConfigChangeDO.setPromoterMinMargin(mspModifyRequest.getPromoterMinMargin());
		}

		if (OpObjTypeEnums.MERCHANT.getCode() == objType && OpTypeEnums.CLOSE.code != opType
				&& StringUtils.isBlank(mspModifyRequest.getFastSettleMinLimit())) {// 如果是操作额度信息是，需要赋值最小额度
			// 获取垫资方
			if (mspModifyRequest.getPromoterType() == null) {
				ViewPromoterInfoDTO promoterEO = promoterInfoService.queryPromoterById(mspModifyRequest.getPromoterId());
				if (promoterEO == null) { throw new FastSettleLimitException("查询不到商户的代理商信息"); }
				mspModifyRequest.setLoaningType(promoterEO.getLoaningType());
				mspModifyRequest.setPromoterType(promoterEO.getPromoterType());
			}
			// 获取最低限额
			LoaningConfigBean loaningConfigBean = this.loaningCongfigService.getLoaningConfigBean(mspModifyRequest.getLoaningType(),
					mspModifyRequest.getPromoterType());
			// TODO LOANING_CONG_BY_MC_TYPE
			BigDecimal floorAmount = new BigDecimal(0);
			if (loaningConfigBean != null) {
				floorAmount = loaningConfigBean.getFloorAmt();
			}
			// 最低限额
			mspModifyRequest.setFastSettleMinLimit(floorAmount.toString());
		}

		if (OpTypeEnums.CLOSE.code == opType) {
			mspModifyRequest.setFastSettleLimit("0"); // 关闭操作将 快速结算额度修改0
		}

		int maxVersion = fsConfigChangeManager.selectMaxVersion(objId, objType);
		fsConfigChangeDO.setFastSettleFlag(mspModifyRequest.getFastSettleFlag());
		if (StringUtils.isNotBlank(mspModifyRequest.getFastConfigureLimit()))
			fsConfigChangeDO.setFastConfigureLimit(new BigDecimal(mspModifyRequest.getFastConfigureLimit()));
		if (StringUtils.isNotBlank(mspModifyRequest.getFastSettleMargin()))
			fsConfigChangeDO.setFastSettleMargin(new BigDecimal(mspModifyRequest.getFastSettleMargin()));
		if (StringUtils.isNotBlank(mspModifyRequest.getFastSettleLimit())) {
			fsConfigChangeDO.setFastSettleLimit(new BigDecimal(mspModifyRequest.getFastSettleLimit()));
		}
		if (StringUtils.isNotBlank(mspModifyRequest.getFastSettleMinLimit())) // 最小额度
			fsConfigChangeDO.setFastSettleMinLimit(new BigDecimal(mspModifyRequest.getFastSettleMinLimit()));
		if (StringUtils.isNotBlank(mspModifyRequest.getFastSettleRatio()))
			fsConfigChangeDO.setFastSettleRatio(new BigDecimal(mspModifyRequest.getFastSettleRatio()));
		if (StringUtils.isNotBlank(mspModifyRequest.getFastSettleWorkdayFee()))
			fsConfigChangeDO.setFastSettleWorkdayFee(new BigDecimal(mspModifyRequest.getFastSettleWorkdayFee()));
		if (StringUtils.isNotBlank(mspModifyRequest.getFastSettleHolidayFee()))
			fsConfigChangeDO.setFastSettleHolidayFee(new BigDecimal(mspModifyRequest.getFastSettleHolidayFee()));
		// 新增是否自动快速结算字段
		if (mspModifyRequest.getAutoFastSettle() != null) {
			fsConfigChangeDO.setAutoFastSettle(mspModifyRequest.getAutoFastSettle());
		}

		if (OpObjTypeEnums.PROMOTER.code == objType) {
			PromoterInfoDTO promoterInfoDTO = findPromoterInfoByPromoterId(objId);
			fsConfigChangeDO.setBeforeFastSettleFlag(promoterInfoDTO.getFastSettleFlag());
			if (StringUtils.isNotBlank(promoterInfoDTO.getFastConfigureLimit())) {
				fsConfigChangeDO.setBeforeFastConfigureLimit(new BigDecimal(promoterInfoDTO.getFastConfigureLimit()));
			}
			if (StringUtils.isNotBlank(promoterInfoDTO.getFastSettleMargin())) {
				fsConfigChangeDO.setBeforeFastSettleMargin(new BigDecimal(promoterInfoDTO.getFastSettleMargin()));
			}
			if (StringUtils.isNotBlank(promoterInfoDTO.getFastSettleLimit())) {
				fsConfigChangeDO.setBeforeFastSettleLimit(new BigDecimal(promoterInfoDTO.getFastSettleLimit()));
			}
			if (StringUtils.isNotBlank(promoterInfoDTO.getFastSettleRatio())) {
				fsConfigChangeDO.setBeforeFastSettleRatio(new BigDecimal(promoterInfoDTO.getFastSettleRatio()));
			}
			fsConfigChangeDO.setLoaningType(promoterInfoDTO.getLoaningType());
		} else if (OpObjTypeEnums.MERCHANT.code == objType) {
			MerchantInfoDTO merchantInfoDTO = findMerchantInfoByMerchantId(objId);
			fsConfigChangeDO.setBeforeFastSettleFlag(merchantInfoDTO.getFastSettleFlag());
			if (StringUtils.isNotBlank(merchantInfoDTO.getFastSettleLimit())) {
				fsConfigChangeDO.setBeforeFastSettleLimit(new BigDecimal(merchantInfoDTO.getFastSettleLimit()));
			}
			if (StringUtils.isNotBlank(merchantInfoDTO.getFastSettleMinLimit())) {
				fsConfigChangeDO.setBeforeFastSettleMinLimit(new BigDecimal(merchantInfoDTO.getFastSettleMinLimit()));
			}
			if (StringUtils.isNotBlank(merchantInfoDTO.getFastSettleHolidayFee())) {
				fsConfigChangeDO.setBeforeFastSettleHolidayFee(new BigDecimal(merchantInfoDTO.getFastSettleHolidayFee()));
			}
			if (StringUtils.isNotBlank(merchantInfoDTO.getFastSettleWorkdayFee())) {
				fsConfigChangeDO.setBeforeFastSettleWorkdayFee(new BigDecimal(merchantInfoDTO.getFastSettleWorkdayFee()));
			}
			if (merchantInfoDTO.getAutoFastSettle() != null) {
				fsConfigChangeDO.setBeforeAutoFastSettle(merchantInfoDTO.getAutoFastSettle());
			}
		}

		fsConfigChangeDO.setVersion(maxVersion + 1);
		fsConfigChangeDO.setStatus(FsConfigChangeStatusEnum.INIT.code);
		fsConfigChangeDO.setCreateTime(new Date());
		long fcmId = fsConfigChangeManager.insertSelective(fsConfigChangeDO);
		return fcmId;
	}

	public int modifyFsConfigChangeStatus(Long fcmId, int status) {
		FsConfigChangeDO fsConfigChangeDO = fsConfigChangeManager.selectByPrimaryKey(fcmId);
		fsConfigChangeDO.setUpdateTime(new Date());
		fsConfigChangeDO.setStatus(status);
		int rows = fsConfigChangeManager.updateByPrimaryKeySelective(fsConfigChangeDO);
		return rows;
	}

	/**
	 * 查询代理商已使用的快速结算额度
	 *
	 * @param pmtMerchantNo
	 *            代理商商户号
	 * @param pmtMerchantType
	 *            代理商类型，POS代理商/MPOS代理商
	 * @param currMerchantNo
	 *            当前待配置的商户号
	 * @return
	 */
	@Override
	public BigDecimal queryPmtCanUseFastSettleLimit(String pmtMerchantNo, String pmtMerchantType) {
		return t0WithdrawService.getWithdrawT0ServiceAPI().findCanUseQuota(pmtMerchantNo, pmtMerchantType);
	}

	/**
	 * 根据代理商商户号查询代理商信息
	 */
	/*
	 * @Override public PromoterInfoDTO findPromoterInfoByPromoterNo(long
	 * promoterNo) { PromoterEO promoterEO =
	 * promoterDAO.queryPromoterInfoByMerchantNo(promoterNo + ""); return
	 * promoterEO2PromoterInfoDTO(promoterEO); }
	 */

	/**
	 * 根据POS代理商的商户号和MC_TYPE 查询唯一的 PromoterEO
	 *
	 * @param promoterNo
	 * @param mcType
	 * @return
	 */
	public PromoterInfoDTO findPromoterInfoByPromoterNoAndType(String promoterNo, String mcType) {
		// PromoterEO promoterEO =
		// promoterDAO.queryPromoterInfoByMerchantNoAndMcType(promoterNo,
		// mcType);
		// ViewPromoterInfoDTO promoterEO =
		// promoterInfoService.queryPromoterInfo(promoterNo + "", mcType);
		List<PosMerchantInfoDO> list = fwPosMerchantInfoService.getPosMerchantInfosByMerchantInfo(promoterNo, mcType);
		if (list != null && list.size() == 1) { return promoterEO2PromoterInfoDTO(list.get(0)); }
		return null;
	}

	/**
	 * 根据代理商编号查询代理商信息
	 */
	@Override
	public PromoterInfoDTO findPromoterInfoByPromoterId(long promoterId) {
		// PromoterEO promoterEO = promoterDAO.queryPromoterByMcId(promoterId);
		// ViewPromoterInfoDTO promoterEO =
		// promoterInfoService.queryPromoterById(promoterId);
		PosMerchantInfoDO promoterEO = fwPosMerchantInfoService.getPosMerchantInfoByPosMerchantId(promoterId);
		BigDecimal canUseFastSettle = null;
		if (null == promoterEO) { return null; }
		if (PosMerchantTypeEnums.POS_PROMOTER.code.equals(promoterEO.getMerchantType())
				|| PosMerchantTypeEnums.MPOS_PROMOTER.code.equals(promoterEO.getMerchantType())
				|| PosMerchantTypeEnums.EASYPAY_PROMOTER.code.equals(promoterEO.getMerchantType()))
			canUseFastSettle = queryPmtCanUseFastSettleLimit(promoterEO.getMerchantNo(), promoterEO.getMerchantType());
		return promoterEO2PromoterInfoDTO(promoterEO, canUseFastSettle == null ? new BigDecimal(0) : canUseFastSettle);
	}

	public MerchantInfoDTO findMerchantInfoByMerchantNo(String merchantNo, String posMerchantType) {
		return findMerchantInfoByMerchantNo(merchantNo, posMerchantType, null);
	}

	public MerchantInfoDTO findMerchantInfoByMerchantNoPosMerchantNo(String merchantNo, String posMerchantNo) {
		return findMerchantInfoByMerchantNo(merchantNo, null, posMerchantNo);
	}

	/**
	 * 根据商户号查询商户信息
	 *
	 * @param merchantId
	 *            商户编号
	 */
	@Override
	public MerchantInfoDTO findMerchantInfoByMerchantId(long merchantId) {
		// PosMerchantEO po = this.posMerchantDAO.select(merchantId);
		ViewMerchantInfoDTO merchantInfo = merchantInfoService.queryMerchantInfoByMerchantId(merchantId);
		if (merchantInfo == null) { return null; }
		String merchantNo = merchantInfo.getMerchantNo();
		// MerchantSettleEO merchantSettleEO =
		// merchantSettleDAO.selectEOByMerchantNo(merchantNo + "");
		// if (merchantSettleEO == null) {
		// return null;
		// }
		// MerchantSettleItemEO merchantSettleItemEO =
		// merchantSettleItemDAO.queryFastSettleItmeByMerchantNo(merchantNo +
		// "");
		// 查询费率
		logger.info("MspFacadeImpl.findMerchantInfoByMerchantId merchantNo:" + merchantNo + ",McType:" + merchantInfo.getMcType());
		WithdrawRatioQueryResponse res = null;
		if (PosMerchantTypeEnums.MPOS_MERCHANT.code.equals(merchantInfo.getMcType())) {
			res = t0WithdrawService.getMerchantCurrentAvaliableWithdrawRatio(merchantNo, merchantInfo.getMcType(),
					WithdrawRatioTypeEnums.MPOS_T0_SETTLE_RATIO.code);
		} else if (PosMerchantTypeEnums.POS_MERCHANT.code.equals(merchantInfo.getMcType())) {
			res = t0WithdrawService.getMerchantCurrentAvaliableWithdrawRatio(merchantNo, merchantInfo.getMcType(),
					WithdrawRatioTypeEnums.POS_T0_SETTLE_RATIO.code);
		}else if (PosMerchantTypeEnums.EASYPAY_MERCHANT.code.equals(merchantInfo.getMcType())) {
			res = t0WithdrawService.getMerchantCurrentAvaliableWithdrawRatio(merchantNo, merchantInfo.getMcType(),
					WithdrawRatioTypeEnums.EASYPAY_T0_SETTLE_RATIO.code);
		}
		return PosMerchantEO2MerchantInfoDTO(merchantInfo, res);
	}

	/**
	 * Operating接口修改快速结算配置
	 *
	 * @param promoterModifyRequest
	 *            修改快速结算请求 objId 不能为空 objType 不能为空
	 * @throws Exception
	 */
	public ErrorMessageVO<Object> modifyFastSettleConfig2Msp(MspModifyRequest mspModifyRequest, Long fcmId) {
		Long objId = mspModifyRequest.getObjId();
		Integer objType = mspModifyRequest.getObjType();

		Assert.notNull(objId);
		Assert.notNull(objType);

		logger.info("MspFacadeImpl #modifyFastSettleConfig2Msp : " + ToStringBuilder.reflectionToString(mspModifyRequest));
		try {
			String code = MerchantCreditConstant.OPERATING_INTERFACE_RESPONSE_CODE_SUCCESS;
			String msg = null;
			if (OpObjTypeEnums.PROMOTER.code == objType) {
				PromoterSettlePO promoterSettlePO = mspModifyRequest2PromoterSettlePO(mspModifyRequest, fcmId);
				logger.info("MspFacadeImpl #modifyFastSettleConfig2Msp :mspModifyRequest2PromoterSettlePO Response promoterSettlePO :"
						+ ToStringBuilder.reflectionToString(promoterSettlePO));
				ViewPromoterInfoDTO promoterInfo=promoterInfoService.queryPromoterById(objId);
				if (!PosMerchantTypeEnums.EASYPAY_PROMOTER.code.equals(promoterInfo.getPromoterType())) {
					PromoterSettleRO promoterSettleRO = getSettleInfoInterface().savePromoterSettleInfo(promoterSettlePO);
					code = promoterSettleRO.getCode();
					msg = promoterSettleRO.getErrorMsg();
					logger.info("MspFacadeImpl #modifyFastSettleConfig2Msp : getSettleInfoInterface().savePromoterSettleInfo Response: code:" + code
							+ ",msg:" + msg);
				}
				if (MerchantCreditConstant.OPERATING_INTERFACE_RESPONSE_CODE_SUCCESS.equals(code.trim())) {
					int row = fwPosMerchantInfoService.updatePromoterFastSettleInfo(promoterSettlePO.getPromoterId(),
							promoterSettlePO.getFastSettleFlag(), promoterSettlePO.getFastSettleMargin(), promoterSettlePO.getFastDepositMargin(),
							mspModifyRequest.getLoaningType());
					logger.info("#modifyFastSettleConfig2Msp  updatePromoterFastSettleInfo response row: " + row);
					if (row <= 0) { return new ErrorMessageVO<Object>(false, null, "资管更新代理商信息失败"); }
					return new ErrorMessageVO<Object>(true);
				} else {
					return new ErrorMessageVO<Object>(false, null, "POS更新代理商信息失败：" + msg);
				}
			} else if (OpObjTypeEnums.MERCHANT.code == objType) {

				MerchantInfoDTO merchantInfoDTO = this.findMerchantInfoByMerchantId(objId);
				// 开启
				if (mspModifyRequest.getFastSettleFlag() != null && mspModifyRequest.getFastSettleFlag() == 1
						&& (!mspModifyRequest.getFastSettleFlag().equals(merchantInfoDTO.getFastSettleFlag()))) {
					Date date = new Date();
					int num = posExternalService.queryCreditAuthentication(merchantInfoDTO.getMerchantNo());
					SarsCP261Bean bean = new SarsCP261Bean(merchantInfoDTO.getMerchantNo(), date,
							PosMerchantTypeEnums.getMerchantTypeByCode(merchantInfoDTO.getMcType()).type, num, MerchantCreditConstant.STRING_TRUE);
					String json = JSONObject.fromObject(bean).toString();
					logger.info("MspFacadeImpl #modifyFastSettleConfig2Msp : sarsService.sarsClientVerify SarsCP261Bean=" + json + " date=" + date
							+ " begin..");
					boolean verify = sarsService.sarsClientVerify(json);
					logger.info("MspFacadeImpl #modifyFastSettleConfig2Msp : sarsService.sarsClientVerify SarsCP261Bean=" + json + " date=" + date
							+ " result=" + verify + " end.");
					if (!verify) { return new ErrorMessageVO<Object>(false, null, "该商户存在风险，不予开通，如有疑问请联系盛付通BD"); }
				}

				MerchantSettlePO merchantSettlePO = mspModifyRequest2MerchantSettlePO(mspModifyRequest, fcmId);

				Integer loaningType = null;
				if (mspModifyRequest.getLoaningType() != null) {
					loaningType = mspModifyRequest.getLoaningType();
				}

				LoaningConfigBean loaningConfigBean = null;
				String promoterType = null;
				if (mspModifyRequest.getPromoterType() == null) {
					ViewPromoterInfoDTO promoterEO = promoterInfoService.queryPromoterById(mspModifyRequest.getPromoterId());
					if (promoterEO == null) { return new ErrorMessageVO<Object>(false, null, "查询不到商户的代理商信息"); }
					loaningType = promoterEO.getLoaningType();
					promoterType = promoterEO.getPromoterType();
				}
				if (promoterType == null && mspModifyRequest.getPromoterType() != null) {
					promoterType = mspModifyRequest.getPromoterType();
				}

				loaningConfigBean = loaningCongfigService.getLoaningConfigBean(loaningType, promoterType);

				// 最低限额
				if (mspModifyRequest.getFastSettleMinLimit() != null) {
					if (loaningConfigBean.getFloorAmt().compareTo(new BigDecimal(mspModifyRequest.getFastSettleMinLimit())) != 0) { return new ErrorMessageVO<Object>(
							false, null, "商户要修改的最小额度和代理商的限制最小额度不一致"); }
					merchantSettlePO.setFastSettleMinLimit(new BigDecimal(mspModifyRequest.getFastSettleMinLimit()));
				} else {
					merchantSettlePO.setFastSettleMinLimit(loaningConfigBean.getFloorAmt());
					mspModifyRequest.setFastSettleMinLimit(loaningConfigBean.getFloorAmt().toString());
				}
				int row = fwPosMerchantInfoService.updateMerchantFastSettleInfo(merchantInfoDTO.getMerchantNo(), merchantInfoDTO.getMcType(),
						merchantSettlePO.getFastSettleFlag(), merchantSettlePO.getAutoFastSettleFlg(), merchantSettlePO.getFastSettleLimit(),
						merchantSettlePO.getFastSettleMinLimit(), merchantSettlePO.getHandPhoneNo());
				logger.info("#modifyFastSettleConfig2Msp  updateMerchantFastSettleInfo response row: " + row);
				if (row <= 0) { return new ErrorMessageVO<Object>(false, null, "资管更新商户信息失败"); }
				logger.info("MspFacadeImpl #modifyFastSettleConfig2Msp  merchantSettlePO: " + ToStringBuilder.reflectionToString(merchantSettlePO));
				if (!PosMerchantTypeEnums.EASYPAY_MERCHANT.code.equals(merchantInfoDTO.getMcType())) {
					MerchantSettleRO merchantSettleRO = getSettleInfoInterface().saveMerchantSettleInfo(merchantSettlePO);
					code = merchantSettleRO.getCode();
					msg = merchantSettleRO.getErrorMsg();
					logger.info("MspFacadeImpl #modifyFastSettleConfig2Msp : getSettleInfoInterface().saveMerchantSettleInfo Response: code:" + code
							+ ",msg:" + msg);
				}
				try {
					if (mspModifyRequest.getFastSettleFlag() != null
							&& (mspModifyRequest.getFastSettleFlag() == 1 || mspModifyRequest.getFastSettleFlag() == 0)
							&& (!mspModifyRequest.getFastSettleFlag().equals(merchantInfoDTO.getFastSettleFlag()))) {
						Date date = new Date();
						SarsParentBean bean;
						if (mspModifyRequest.getFastSettleFlag() == 1) {// 开通快速结算
							bean = new SarsCP281Bean(merchantInfoDTO.getMerchantNo(), date);
						} else {// 关闭快速结算
							bean = new SarsCP285Bean(merchantInfoDTO.getMerchantNo(), date);
						}
						String json = JSONObject.fromObject(bean).toString();
						logger.info("MspFacadeImpl #modifyFastSettleConfig2Msp : sarsService.sarsClientVerify SarsCP281Bean=" + json + " date="
								+ date + " begin..");
						boolean verify = sarsService.sarsClientVerify(json);
						logger.info("MspFacadeImpl #modifyFastSettleConfig2Msp : sarsService.sarsClientVerify SarsCP281Bean=" + json + " date="
								+ date + " result=" + verify + " end.");
					}
				} catch (Exception e) {
					logger.error("MspFacadeImpl #modifyFastSettleConfig2Msp : sarsService.sarsClientVerify SarsCP281Bean " + e);
				}
				if (MerchantCreditConstant.OPERATING_INTERFACE_RESPONSE_CODE_SUCCESS.equals(code.trim())) {
					return new ErrorMessageVO<Object>(true);

				} else {
					return new ErrorMessageVO<Object>(false, null, "POS更新商户快速结算失败：" + msg);
				}
			} else {
				return new ErrorMessageVO<Object>(false, null, "不存在的操作类型！");
			}
		} catch (Exception e) {
			logger.error("MspFacadeImpl #modifyFastSettleConfig2Msp :" + e.getMessage(), e);
			return new ErrorMessageVO<Object>(false, null, MerchantCreditConstant.MC_SYSTEM_EXCEPTION);
		}

	}

	private PromoterSettlePO mspModifyRequest2PromoterSettlePO(MspModifyRequest mspModifyRequest, Long fcmId) {
		FsConfigChangeDO configChangeDO = fsConfigChangeManager.selectByPrimaryKey(fcmId);
		PromoterSettlePO promoterSettlePO = new PromoterSettlePO();
		promoterSettlePO.setPromoterId(mspModifyRequest.getObjId() + "");
		if (mspModifyRequest.getFastSettleFlag() != null)
			promoterSettlePO.setFastSettleFlag(mspModifyRequest.getFastSettleFlag());
		else promoterSettlePO.setFastSettleFlag((configChangeDO.getBeforeFastSettleFlag() == null) ? 0 : configChangeDO.getBeforeFastSettleFlag());

		if (StringUtils.isNotEmpty(mspModifyRequest.getFastSettleMargin()))
			promoterSettlePO.setFastDepositMargin(new BigDecimal(mspModifyRequest.getFastSettleMargin()).setScale(2, BigDecimal.ROUND_HALF_UP)
					.toString());// 保证金额度
		else promoterSettlePO.setFastDepositMargin((configChangeDO.getBeforeFastSettleMargin() == null) ? "0" : configChangeDO
				.getBeforeFastSettleMargin().setScale(2, BigDecimal.ROUND_HALF_UP).toString());

		if (StringUtils.isNotEmpty(mspModifyRequest.getFastSettleLimit()))
			promoterSettlePO.setFastSettleMargin(new BigDecimal(mspModifyRequest.getFastSettleLimit()).setScale(2, BigDecimal.ROUND_HALF_UP)
					.toString());// 快速结算可用额度
		else promoterSettlePO.setFastSettleMargin((configChangeDO.getBeforeFastSettleLimit() == null) ? "0" : configChangeDO
				.getBeforeFastSettleLimit().setScale(2, BigDecimal.ROUND_HALF_UP).toString());// 快速结算可用额度

		if (StringUtils.isNotEmpty(mspModifyRequest.getFastConfigureLimit()))
			promoterSettlePO.setFastConfigureLimit(new BigDecimal(mspModifyRequest.getFastConfigureLimit()).setScale(2, BigDecimal.ROUND_HALF_UP)
					.toString());
		else promoterSettlePO.setFastConfigureLimit((configChangeDO.getBeforeFastConfigureLimit() == null) ? "0" : configChangeDO
				.getBeforeFastConfigureLimit().setScale(2, BigDecimal.ROUND_HALF_UP).toString());

		if (StringUtils.isNotEmpty(mspModifyRequest.getFastSettleRatio()))
			promoterSettlePO.setFastSettleRatio(new BigDecimal(mspModifyRequest.getFastSettleRatio()).setScale(2, BigDecimal.ROUND_HALF_UP)
					.toString());
		else promoterSettlePO.setFastSettleRatio((configChangeDO.getBeforeFastSettleRatio() == null) ? "0" : configChangeDO
				.getBeforeFastSettleRatio().setScale(2, BigDecimal.ROUND_HALF_UP).toString());
		return promoterSettlePO;
	}

	public MerchantSettlePO mspModifyRequest2MerchantSettlePO(MspModifyRequest mspModifyRequest, Long fcmId) {
		FsConfigChangeDO configChangeDO = fsConfigChangeManager.selectByPrimaryKey(fcmId);
		MerchantSettlePO merchantSettlePO = new MerchantSettlePO();
		merchantSettlePO.setMerchantId(mspModifyRequest.getObjId() + "");

		if (mspModifyRequest.getFastSettleFlag() != null)
			merchantSettlePO.setFastSettleFlag(mspModifyRequest.getFastSettleFlag());
		else merchantSettlePO.setFastSettleFlag((configChangeDO.getBeforeFastSettleFlag() == null) ? 0 : configChangeDO.getBeforeFastSettleFlag());

		if (StringUtils.isNotEmpty(mspModifyRequest.getFastSettleLimit()))
			merchantSettlePO.setFastSettleLimit(new BigDecimal(mspModifyRequest.getFastSettleLimit()).setScale(2, BigDecimal.ROUND_HALF_UP)
					.toString());
		else merchantSettlePO.setFastSettleLimit((configChangeDO.getBeforeFastSettleLimit() == null) ? "0" : configChangeDO
				.getBeforeFastSettleLimit().setScale(2, BigDecimal.ROUND_HALF_UP).toString());
		if (StringUtils.isNotEmpty(mspModifyRequest.getFastSettleMinLimit())) {// 最小额度
			merchantSettlePO.setFastSettleMinLimit(new BigDecimal(mspModifyRequest.getFastSettleMinLimit()).setScale(2, BigDecimal.ROUND_HALF_UP));
		}
		// 更新接口新增withdrawWorkDayFee（工作日快速提现费率）
		// 、withdrawHolidayFee（非工作日快速提现费率）、autoFastSettleFlg（是否自动快速结算(0:否，1:是)）、handPhone_no，原有字段置为0
		/**
		 * if
		 * (StringUtils.isNotEmpty(mspModifyRequest.getFastSettleHolidayFee()))
		 * merchantSettlePO
		 * .setMsiHolidayFee(mspModifyRequest.getFastSettleHolidayFee());
		 *
		 * if
		 * (StringUtils.isNotEmpty(mspModifyRequest.getFastSettleWorkdayFee()))
		 * merchantSettlePO
		 * .setMsiWorkDayFee(mspModifyRequest.getFastSettleWorkdayFee());
		 **/
		if (StringUtils.isNotBlank(mspModifyRequest.getFastSettleHolidayFee())) {
			merchantSettlePO.setMsiHolidayFee("0");
			// 不传
			// merchantSettlePO.setWithdrawHolidayFee(mspModifyRequest.getFastSettleHolidayFee());
		}

		if (StringUtils.isNotBlank(mspModifyRequest.getFastSettleWorkdayFee())) {
			merchantSettlePO.setMsiWorkDayFee("0");
			// 不传
			// merchantSettlePO.setWithdrawWorkDayFee(mspModifyRequest.getFastSettleWorkdayFee());
		}
		if (mspModifyRequest.getAutoFastSettle() != null) {
			merchantSettlePO.setAutoFastSettleFlg(mspModifyRequest.getAutoFastSettle());
		}
		if (StringUtils.isNotBlank(mspModifyRequest.getMerchantPhone())) {
			merchantSettlePO.setHandPhoneNo(mspModifyRequest.getMerchantPhone());
		}
		return merchantSettlePO;
	}

	/**
	 * 验证商户快速结算配置
	 *
	 * @param merchantNo
	 * @return straightlyCfg.isStraightFlag() 今日可用额度
	 *         straightlyCfg.getValidCredit() 剩余额度 straightlyCfg.getFeeRate()
	 *         快速结算手续费率 straightlyCfg.getCredit() 今日总额度 straightFlag
	 */
	public StraightlyCfg queryStraightlyCfg(Long merchantId, boolean needMail) {
		// MspPosMerchantEO mspPosMerchantEO =
		// mspPosMerchantDAO.selectById(merchantId);
		ViewMerchantInfoDTO merchantInfo = merchantInfoService.queryMerchantInfoByMerchantId(merchantId);
		if (merchantInfo == null) { return null; }
		// MerchantInfoDTO merchantInfoDTO =
		// this.findMerchantInfoByMerchantId(merchantId);
		Long promoterId = merchantInfo.getPromoterId();

		// 垫资方
		LoaningTypeEnum loaningTypeEnum = LoaningTypeEnum.getLoaningTypeEnum(newt0PromoterService.getLoaningTypeByPromoterId(promoterId));
		// TODO 这里有问题，如果垫资方null,不应该往下走
		if (loaningTypeEnum == null) {
			logger.error("The loaningType is not the standard type ");
			return null;
		}
		// 查询垫资方基础信息
		// TODO LOANING_CONG_BY_MC_TYPE
		LoaningConfigBean loaningConfigBean = loaningCongfigService.getLoaningConfigBeanByLoaningType(loaningTypeEnum);
		loaningConfigBean = loaningCongfigService.getLoaningConfigBeanByLoaningTypeMcType(loaningConfigBean, merchantInfo.getPromoterType());
		// Long fastSettleMinLimit =
		// this.configOptionManager.getLongByKey(MerchantCreditConstant.MC_FASTSETTLE_MIN_LIMIT);
		// 设置fastSettleMinLimit
		BigDecimal fastSettleMinLimit = loaningConfigBean.getFloorAmt();
		StraightlyCfg straightlyCfg = new StraightlyCfg();
		if (straightlyCfg.getFloorAmt() != null && straightlyCfg.getFloorAmt().compareTo(fastSettleMinLimit) < 0) {
			straightlyCfg.setFloorAmt(fastSettleMinLimit);
		}
		if (straightlyCfg.getFeeRate() == null && needMail) {
			StringBuilder sb = new StringBuilder();
			sb.append("商户号：").append(merchantInfo.getMerchantNo());
			sb.append("商户名称：").append(merchantInfo.getMerchantName());
			sb.append("代理商商户号：").append(merchantInfo.getPromoterMerchantNo());
			sb.append("代理商名称：").append(merchantInfo.getPromoterName());
			this.sendMail("代理商未给商户配置费率", sb.toString());
		}
		straightlyCfg.setCredit(merchantInfo.getMerchantFsLimit());// 商户当日总额度
		logger.info("MspFacadeImpl #queryStraightlyCfg:" + ToStringBuilder.reflectionToString(straightlyCfg));
		return straightlyCfg;
	}

	/**
	 * 默认不发邮件
	 * **/
	public StraightlyCfg queryStraightlyCfg(Long merchantId) {
		return this.queryStraightlyCfg(merchantId, false);
	}

	private void sendMail(final String title, final String content) {
		try {
			final String mailList = ConfigOptionHelper.getConfigByKey(MerchantCreditConstant.CREDIT_FOS_PROCESSING_MAIL_LIST);
			if (StringUtils.isBlank(mailList)) {
				logger.error("MspFacadeImpl.sendMail.error,mail list is not configured");
				return;
			}
			Thread t = new Thread() {
				public void run() {
					try {
						AlertMessageSender sender = alertMessageSenderFactory.getAlertMessageSender(AlertMessageSendTypeEnum.MAIL_ALERT);
						sender.sendMessage(title, content, mailList);
					} catch (Exception e) {
						// fix 线程里的异常不会被外面的catch exception catch住
						logger.info("network sendMail.error,content=" + content, e);
					}
				}
			};
			t.start();
		} catch (Exception e) {
			logger.info("MspFacadeImpl.sendMail.error,content=" + content, e);
		}
	}

	/**
	 * 代理商获取代理商快速结算额度 straightlyCfg.getValidCredit()
	 *
	 * @param promoterId
	 *            代理商编号
	 * @return straightlyCfg.isStraightFlag() 今日可用额度
	 *         straightlyCfg.getValidCredit() 剩余额度 straightlyCfg.getFeeRate()
	 *         快速结算手续费率 straightlyCfg.getCredit() 今日总额度 straightFlag
	 */
	@Override
	public StraightlyCfg getPromoterCredit(Long promoterId) {
		try {
			logger.info("MspFacadeImpl #getPromoterCredit:promoterId:" + promoterId + ", start invoke fast_settle_limit .");
			StraightlyCfg cfg = fastSettleHessianInterfaceProxy.getPromoterStraightlyCfg(promoterId);
			logger.info("MspFacadeImpl #getPromoterCredit:promoterId:" + promoterId + ", invoke fast_settle result:" + new Gson().toJson(cfg) + "");
			return cfg;
		} catch (Exception e) {
			logger.error("remote.invoke.msp.system[StraightlySettle.getPromoterStraightlyCfg].error,promoterId=" + promoterId, e);
			// throw new RuntimeException("获取快速结算额度出现异常：" + e.getMessage());
		}
		return null;
	}

	protected MerchantInfoDTO PosMerchantEO2MerchantInfoDTO(ViewMerchantInfoDTO posMerchantEO, WithdrawRatioQueryResponse res) {
		MerchantInfoDTO merchantInfoDTO = new MerchantInfoDTO();
		merchantInfoDTO.setMerchantId(posMerchantEO.getMerchantId().toString());
		merchantInfoDTO.setMerchantNo(posMerchantEO.getMerchantNo());
		// merchantInfoDTO.setPosMerchantNo(posMerchantEO.getPosmPosMerchantNo());
		merchantInfoDTO.setName(posMerchantEO.getMerchantName());
		// merchantInfoDTO.setMcc(posMerchantEO.getPosmInternalMccId() == null ?
		// null : posMerchantEO.getPosmInternalMccId().toString());
		merchantInfoDTO.setMcType(posMerchantEO.getMcType());
		// posMerchantEO.getMcTypeName();
		// merchantInfoDTO.setPosmMposSalesType(posMerchantEO.getPosmMposSalesType()
		// == null ? null : posMerchantEO.getPosmMposSalesType().toString());
		merchantInfoDTO.setStatus("3");
		// merchantInfoDTO.setPosmRelyElecSignFlag(posMerchantEO.getPosmRelyElecSignFlag()
		// == null ? null : posMerchantEO.getPosmRelyElecSignFlag().toString());
		// merchantInfoDTO.setTerminalCount(posMerchantEO.getTerminalCount() ==
		// null ? null : posMerchantEO.getTerminalCount().toString());

		merchantInfoDTO.setFastSettleFlag(posMerchantEO.getMerchantFsFlag());
		merchantInfoDTO.setFastSettleLimit(posMerchantEO.getMerchantFsLimit() == null ? null : posMerchantEO.getMerchantFsLimit().toString());
		merchantInfoDTO.setFastSettleMinLimit(posMerchantEO.getMerchantFsLimit() == null ? null : posMerchantEO.getMerchantFsLimit().toString());
		// 新增四个字段
		// merchantInfoDTO.setFastSettleHolidayFee(merchantSettleEO.getMsHolidayWithdrawFee());
		// merchantInfoDTO.setFastSettleWorkdayFee(merchantSettleEO.getMsWorkdayWithdrawFee());
		merchantInfoDTO.setAutoFastSettle(posMerchantEO.getAutoFastSettleFlag());
		merchantInfoDTO.setMerchantPhone(posMerchantEO.getMerchantPhoneNo());
		// 费率及是否自动快速结算字段保存在新表
		if (res != null && res.getWithdrawRatioResults() != null && res.getWithdrawRatioResults().size() > 0) {
			merchantInfoDTO.setFastSettleHolidayFee(res.getWithdrawRatioResults().get(0).getHolidayWithDrawRatio().toString());
			merchantInfoDTO.setFastSettleWorkdayFee(res.getWithdrawRatioResults().get(0).getWorkDayWithDrawRatio().toString());
		} else {
			merchantInfoDTO.setFastSettleHolidayFee(null);
			merchantInfoDTO.setFastSettleWorkdayFee(null);
		}
		if (posMerchantEO.getPromoterId() != null) merchantInfoDTO.setPromoterId(posMerchantEO.getPromoterId());
		return merchantInfoDTO;
	}

	protected PromoterInfoDTO promoterEO2PromoterInfoDTO(PosMerchantInfoDO promoterEO) {
		return promoterEO2PromoterInfoDTO(promoterEO, null);
	}

	protected PromoterInfoDTO promoterEO2PromoterInfoDTO(PosMerchantInfoDO promoterEO, BigDecimal canUseFastSettle) {
		if (promoterEO == null) return null;
		PromoterInfoDTO promoterInfoDTO = new PromoterInfoDTO();
		promoterInfoDTO.setPromoterId(promoterEO.getPosMerchantId());
		promoterInfoDTO.setLoaningType(promoterEO.getLoaningType());
		if (promoterEO.getMerchantNo() != null && StringUtils.isNotBlank(promoterEO.getMerchantNo()))
			promoterInfoDTO.setPromoterNo(promoterEO.getMerchantNo());
		promoterInfoDTO.setName(promoterEO.getMerchantName());
		promoterInfoDTO.setPromoterType(promoterEO.getMerchantType());
		// promoterInfoDTO.setBusinessManager(promoterEO.getBusinessManager());
		promoterInfoDTO.setStatus("3");
		promoterInfoDTO.setCreateTime(promoterEO.getCreateTime());

		promoterInfoDTO.setFastSettleFlag(promoterEO.getFastSettleFlag());
		if (promoterEO.getFastSettleMargin() != null) promoterInfoDTO.setFastSettleMargin(promoterEO.getFastSettleMargin().toString());

		BigDecimal pmtFastSettleLimit = this.queryPmtFastSettleLimit(promoterEO.getMerchantNo(), promoterEO.getMerchantType());
		if (promoterEO.getFastSettleLimit() != null)
			promoterInfoDTO.setFastSettleLimit(pmtFastSettleLimit == null ? "0" : pmtFastSettleLimit.toString());
		/*
		 * if (promoterEO.getFastConfigureLimit() != null)
		 * promoterInfoDTO.setFastConfigureLimit
		 * (promoterEO.getFastConfigureLimit() + "");
		 */
		/*
		 * if (promoterEO.getPmtFastSettleRatio() != null)
		 * promoterInfoDTO.setFastSettleRatio(promoterEO.getPmtFastSettleRatio()
		 * + "");
		 */

		if (canUseFastSettle != null && promoterEO.getFastSettleLimit() != null) {
			promoterInfoDTO.setValidCredit(canUseFastSettle.compareTo(BigDecimal.ZERO) < 0 ? "0" : canUseFastSettle.toString());
		}
		promoterInfoDTO.setPmtLevel(promoterEO.getPmtLevel() == null ? 0 : promoterEO.getPmtLevel());
		return promoterInfoDTO;
	}

	private SettleInfoInterface settleInfoInterface;

	private SettleInfoInterface getSettleInfoInterface() {
		if (settleInfoInterface == null) {
			settleInfoInterface = RemotingCallUtil.getHessianServiceByModuleWithoutCanonicalName(RemotingModuleEnum.OPERATING_SETTLE_MODULE,
					SettleInfoInterface.class);
		}
		return settleInfoInterface;
	}

	/**
	 * 判断该商户是否支持直连银行
	 *
	 * @param merchantNo商户号
	 * **/
	@Deprecated
	public ErrorMessageVO<Object> isSupportDirect2Bank4Agent(String merchantNo) {
		DelegationPay2CardQueryRequest req = new DelegationPay2CardQueryRequest();
		req.setAppId("zf718");
		// req.setRequestId( String.valueOf(
		// seqService.selectSeqApplyPosmRequestId() ) );
		req.setRequestId(UUID.randomUUID().toString().replaceAll("-", ""));
		req.setRequestTime(com.sdo.common.util.DateUtil.getLongDateString(new Date()));
		req.setMerchantid(merchantNo);
		req.setMac(DigestUtils.md5Hex(req.getAppId() + req.getRequestId() + req.getRequestTime()
				+ DictionaryHelper.getValue(DictionaryHelper.LABEL_APPLY_POSM, DictionaryHelper.KEY_APPLY_POSM_CRM_OPEN_MERCHANT_MD5KEY)));// 签名串
		DelegationPay2CardQueryResponse resp = delegationPay2CardQueryService.queryByMerchantid(req);
		if (resp.getHeader().getRetCode() == 0) {
			DelegationPay2CardInfo delegationPay2CardInfo = resp.getDelegationPay2CardInfo();
			if (delegationPay2CardInfo != null) {
				String bankCode = delegationPay2CardInfo.getBankcode();
				// 结算信息，账户类型 2：对公
				if (delegationPay2CardInfo.getAccounttype() == 2) {
					if (FundoutBankHelper.isSupportDirectForCompany(bankCode)) { return new ErrorMessageVO<Object>(true, "1", "已配置直连银行"); }
				}
				// 结算信息，账户类型 1：对私
				if (delegationPay2CardInfo.getAccounttype() == 1) {
					if (FundoutBankHelper.isSupportDirectForPersonal(bankCode)) { return new ErrorMessageVO<Object>(true, "1", "已配置直连银行"); }
				}
				return new ErrorMessageVO<Object>(false, "0", "该商户出款账户非直连银行");
			}
		}
		return new ErrorMessageVO<Object>(false, "2", "该商户没有委托付款信息，快速结算资金将结算到商户钱包账户，请通知商户手动提现，谢谢！");
	}

	/**
	 * 判断该商户是否支持实时出款,盛付通全资
	 *
	 * @param merchantNo商户号
	 * **/
	public ErrorMessageVO<Object> isSupportDirect2Bank4ShengPay(String merchantNo) {
		DelegationPay2CardQueryRequest req = new DelegationPay2CardQueryRequest();
		req.setAppId("zf718");
		req.setRequestId(UUID.randomUUID().toString().replaceAll("-", ""));
		req.setRequestTime(com.sdo.common.util.DateUtil.getLongDateString(new Date()));
		req.setMerchantid(merchantNo);
		req.setMac(DigestUtils.md5Hex(req.getAppId() + req.getRequestId() + req.getRequestTime()
				+ DictionaryHelper.getValue(DictionaryHelper.LABEL_APPLY_POSM, DictionaryHelper.KEY_APPLY_POSM_CRM_OPEN_MERCHANT_MD5KEY)));// 签名串
		DelegationPay2CardQueryResponse resp = delegationPay2CardQueryService.queryByMerchantid(req);
		if (resp.getHeader().getRetCode() == 0) {
			DelegationPay2CardInfo delegationPay2CardInfo = resp.getDelegationPay2CardInfo();
			if (delegationPay2CardInfo != null) {
				String bankCode = delegationPay2CardInfo.getBankcode();
				if (!this.validateFastFundOutBank(bankCode)) {
					String fastFundOutBankListDesc = ConfigOptionHelper
							.getConfigByKey(MerchantCreditConstant.NEWT0_FAST_FUND_OUT_BANK_LIST_DESC);
					return new ErrorMessageVO<Object>(false, "-1", "请通知商户更换出款银行,该商户的出款银行是" + delegationPay2CardInfo.getBankname() + ",支持实时出款的银行包括："
							+ fastFundOutBankListDesc);
				}
				return new ErrorMessageVO<Object>(true, "1", "已配置直连银行");
			} else {
				return new ErrorMessageVO<Object>(false, "2", "该商户没有委托付款信息，快速结算资金将结算到商户钱包账户，请通知商户手动提现，谢谢！");
			}
		}
		return new ErrorMessageVO<Object>(false, "2", "网络繁忙，请稍后重试，谢谢！");
	}

	public boolean validateFastFundOutBank(final String bankCode) {
		// 取出配置的8家快速出款银行
		String fastFundOutBankList = ConfigOptionHelper.getConfigByKey(MerchantCreditConstant.NEWT0_FAST_FUND_OUT_BANK_LIST);
		if (fastFundOutBankList != null && !"".equals(fastFundOutBankList)) {
			String[] bankCodes = fastFundOutBankList.split(",");
			for (String string : bankCodes) {
				if (bankCode.equals(string)) { return true; }
			}
		}
		return false;
	}

	/**
	 * 根据 promoterId 查询联系电话,如无电话则返回 null
	 *
	 * @param promoterId
	 * @return
	 */
	@SuppressWarnings("deprecation")
	public String getPromoterMoileByPromoterId(long promoterId) {
		PromoterInfoDTO promoterInfoDTO = findPromoterInfoByPromoterId(promoterId);
		String promoterNo = promoterInfoDTO.getPromoterNo();
		if (crmService != null)
			return crmService.getCRMMobilebyMerchantNo(promoterNo + "");
		else {
			// mock crm 接口未提供时使用ma 后面crm提供后废弃
			Promoter4MADTO promoter4madto = maFacade.queryPromoterInfoByMerchantNo(String.valueOf(promoterNo));
			if (promoter4madto == null) return null;
			return maFacade.getMAMobileByMemberId(promoter4madto.getMemberId());
		}
	}

	/**
	 * 根据商户号查询商户信息
	 *
	 * @param merchantNo
	 *            商户号
	 */
	protected MerchantInfoDTO findMerchantInfoByMerchantNo(String merchantNo, String posMerchantType, String posMerchantNo) {

		ViewMerchantInfoDTO posMerchantEO = merchantInfoService.queryMerchantInfoByMerchantNo(merchantNo, posMerchantType);
		if (posMerchantEO == null) return null;
		WithdrawRatioQueryResponse res = null;
		// 此处由于Mpos调用时没有传入类型，故暂时不传默认为Mpos后续调整时请注意。
		if (StringUtils.isBlank(posMerchantType)) {
			res = t0WithdrawService.getMerchantCurrentAvaliableWithdrawRatio(merchantNo + "", MerchantContractCst.TYPE_MPOS_MERCHANT,
					WithdrawRatioTypeEnums.MPOS_T0_SETTLE_RATIO.code);
		} else if (posMerchantType.equals(MerchantContractCst.TYPE_MPOS_MERCHANT)) {
			res = t0WithdrawService.getMerchantCurrentAvaliableWithdrawRatio(merchantNo + "", MerchantContractCst.TYPE_MPOS_MERCHANT,
					WithdrawRatioTypeEnums.MPOS_T0_SETTLE_RATIO.code);
		} else if (posMerchantType.equals(MerchantContractCst.TYPE_POS_MERCHANT)) {
			res = t0WithdrawService.getMerchantCurrentAvaliableWithdrawRatio(merchantNo + "", MerchantContractCst.TYPE_POS_MERCHANT,
					WithdrawRatioTypeEnums.POS_T0_SETTLE_RATIO.code);
		}

		return PosMerchantEO2MerchantInfoDTO(posMerchantEO, res);
	}

	/**
	 * 验证mpos提现银行卡信息
	 */
	public ErrorMessageVO<Object> authQuery(String merchantNo, String zfCode) {
		ErrorMessageVO<Object> vo = realNameMpos.authQuery(merchantNo, zfCode);
		if (vo.isSuccess()) {
			String bankCode = "";
			String bankName = "";
			if (vo.getParams().containsKey("bankCode")) bankCode = vo.getParams().get("bankCode").toString();
			if (vo.getParams().containsKey("bankCode")) bankName = vo.getParams().get("bankName").toString();
			// 直连银行
			if (!this.validateFastFundOutBank(bankCode)) {
				String fastFundOutBankListDesc = ConfigOptionHelper.getConfigByKey(MerchantCreditConstant.NEWT0_FAST_FUND_OUT_BANK_LIST_DESC);
				return new ErrorMessageVO<Object>(false, "-1", "请通知商户更换出款银行,该商户的出款银行是" + bankName + ",支持实时出款的银行包括：" + fastFundOutBankListDesc);
			}
		}
		return vo;
	}

	/**
	 * 查询代理商总额度
	 *
	 * @param pmtMerchantNo
	 * @param pmtMerchantType
	 * @param isHoliday
	 * @return
	 */
	public BigDecimal queryPmtFastSettleLimit(String pmtMerchantNo, String pmtMerchantType, boolean isHoliday) {
		return t0WithdrawService.getWithdrawT0ServiceAPI().findTotalAmount(pmtMerchantNo, pmtMerchantType, isHoliday);
	}

	private BigDecimal queryPmtFastSettleLimit(String pmtMerchantNo, String pmtMerchantType) {
		return t0WithdrawService.getWithdrawT0ServiceAPI().findTotalAmount(pmtMerchantNo, pmtMerchantType);
	}
}
