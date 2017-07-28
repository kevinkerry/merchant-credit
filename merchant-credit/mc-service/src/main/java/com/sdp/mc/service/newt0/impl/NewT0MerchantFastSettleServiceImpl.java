package com.sdp.mc.service.newt0.impl;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;
import org.springframework.web.context.ContextLoader;
import org.springframework.web.context.WebApplicationContext;

import com.mc.service.api.enums.WhiteTypeEnums;
import com.sdo.common.lang.StringUtil;
import com.sdo.ma.ws.api.model.AccountInfo;
import com.sdp.mc.common.constant.LimitRuleInfoConstant;
import com.sdp.mc.common.constant.MerchantContractCst;
import com.sdp.mc.common.constant.MerchantCreditConstant;
import com.sdp.mc.common.enums.AccountType;
import com.sdp.mc.common.enums.AlertMessageSendTypeEnum;
import com.sdp.mc.common.enums.FosPaymentStateEnums;
import com.sdp.mc.common.enums.FsConfigChangeStatusEnum;
import com.sdp.mc.common.enums.LimitTypeEnums;
import com.sdp.mc.common.enums.LoaningTypeEnum;
import com.sdp.mc.common.enums.MessageTemplateCodeEnum;
import com.sdp.mc.common.enums.OpObjTypeEnums;
import com.sdp.mc.common.enums.OpTypeEnums;
import com.sdp.mc.common.enums.withdraw.RemitWithdrawFeeStatusEnums;
import com.sdp.mc.common.enums.withdraw.WithdrawReqStatusEnums;
import com.sdp.mc.common.exception.FastSettleLimitException;
import com.sdp.mc.common.hessian.RemotingCallUtil;
import com.sdp.mc.common.hessian.RemotingModuleEnum;
import com.sdp.mc.common.util.ConfigOptionHelper;
import com.sdp.mc.common.util.IPUtils;
import com.sdp.mc.common.vo.ErrorMessageVO;
import com.sdp.mc.config.manager.ConfigOptionManager;
import com.sdp.mc.facade.msp.MspFacade;
import com.sdp.mc.facade.msp.enums.MerchantFastSettleSubStatusEnum;
import com.sdp.mc.integration.fos.dto.response.RemitTransferResponseDTO;
import com.sdp.mc.integration.msp.MerchantInfoDTO;
import com.sdp.mc.integration.msp.request.MspModifyRequest;
import com.sdp.mc.ma.wrapper.MaOnlineWrapper;
import com.sdp.mc.merchant.dao.MerchantFsReq;
import com.sdp.mc.merchant.dao.MerchantFsReqExample;
import com.sdp.mc.merchant.manager.MerchantFsRManager;
import com.sdp.mc.newt0.dao.Newt0McLimitChangeDtlDO;
import com.sdp.mc.newt0.dao.Newt0McLimitChangeReqDO;
import com.sdp.mc.newt0.dao.WhiteListInfoDO;
import com.sdp.mc.newt0.manager.ExtNewt0SdpRemainBalanceManager;
import com.sdp.mc.promoter.dao.ext.PromoterFastSettleSwitchDOExt;
import com.sdp.mc.promoter.manager.PromoterFastSettleSwitchManager;
import com.sdp.mc.service.McManagerService;
import com.sdp.mc.service.limitchange.MerchantLimitChangeService;
import com.sdp.mc.service.newt0.NewT0MerchantFastSettleService;
import com.sdp.mc.service.newt0.Newt0PromoterService;
import com.sdp.mc.view.dao.ViewMerchantInfoDTO;
import com.sdp.withdraw.api.WithdrawT0ServiceAPI;
import com.sdp.withdraw.dao.RemitFeeReqDo;
import com.sdp.withdraw.dao.RemitFeeReqDoExample;
import com.sdp.withdraw.dao.WithdrawReqDO;
import com.sdp.withdraw.enums.PosMerchantTypeEnums;
import com.sdp.withdraw.manager.RemitFeeReqManager;
import com.sdp.withdraw.manager.WithdrawReqManager;
import com.shengpay.commons.core.utils.NumberUtils;
import com.shengpay.facade.fos.FOSFacade;
import com.shengpay.service.alert.factory.AlertMessageSenderFactory;
import com.shengpay.service.mail.AlertMessageSender;
import com.shengpay.service.message.MessageService;
import com.shengpay.service.view.MerchantInfoService;
import com.shengpay.service.whitelist.WhiteListInfoService;

@Service("NewT0MerchantFastSettleServiceImpl")
public class NewT0MerchantFastSettleServiceImpl implements NewT0MerchantFastSettleService {
	private static Logger logger = LoggerFactory.getLogger(NewT0MerchantFastSettleServiceImpl.class);
	@Autowired
	private ConfigOptionManager configOptionManager;
	@Autowired
	private MerchantFsRManager merchantFsRManager;
	@Autowired
	private FOSFacade FOSFacade;
	@Autowired
	private PromoterFastSettleSwitchManager promoterFastSettleSwitchManager;
	@Autowired
	private MspFacade mspFacade;
	@Autowired
	private McManagerService mcManagerService;
	@Autowired
	private ExtNewt0SdpRemainBalanceManager extNewt0SdpRemainBalanceManager;
	@Autowired
	private MessageService messageService;
	@Autowired
	private AlertMessageSenderFactory alertMessageSenderFactory;
	@Autowired
	private MaOnlineWrapper maOnlineWrapper;
	@Autowired
	private MerchantLimitChangeService merchantLimitChangeService;
	private WithdrawT0ServiceAPI withdrawT0ServiceAPI;
	@Autowired
	private WithdrawReqManager withdrawReqManager;
	@Autowired
	private RemitFeeReqManager remitFeeReqManager;
	@Autowired
	private WhiteListInfoService whiteListInfoService;
	@Autowired
	private MerchantInfoService merchantInfoService;
	@Autowired
	private Newt0PromoterService newt0PromoterService;

	private WithdrawT0ServiceAPI getWithdrawT0ServiceAPI() {
		try {// 先从容器中获取对象
			if (withdrawT0ServiceAPI == null) {
				WebApplicationContext wac = ContextLoader.getCurrentWebApplicationContext();
				withdrawT0ServiceAPI = (WithdrawT0ServiceAPI) wac.getBean("withdrawServiceHessian");
			}
		} catch (Exception e) {
		}
		if (withdrawT0ServiceAPI == null) {
			withdrawT0ServiceAPI = RemotingCallUtil.getHessianServiceByModuleWithoutCanonicalName(RemotingModuleEnum.T0_WITHDRAW_SERVICE_URL,
					WithdrawT0ServiceAPI.class);
		}
		return withdrawT0ServiceAPI;
	}

	/**
	 * 商户申请退费
	 *
	 * @param merchantFastSettleReqId
	 *            商户快速结算申请记录id
	 * **/
	public ErrorMessageVO remitFastSettleFee(Long merchantFastSettleReqId) {
		MerchantFsReq record = this.merchantFsRManager.selectByPrimaryKey(merchantFastSettleReqId);
		if (record == null) { return new ErrorMessageVO(false, "-1", "订单不存在"); }
		if (!MerchantFastSettleSubStatusEnum.SETTLED.code.equals(record.getSubStatus())) {
			long minutes = ConfigOptionHelper.getLongByKey(MerchantCreditConstant.NEW_T0_REMIT_FEE_MINUTE);
			// 计算出实际花费时间--等pos接口修改后还是要放开
			long realCostTime = (record.getWithdrawResponseTime().getTime() - record.getApplyTime().getTime()) / 1000 / 60;
			if (realCostTime < minutes) { return new ErrorMessageVO(false, "-1", "该订单不能退费,未满足退费的条件"); }
			return new ErrorMessageVO(false, "-1", "该订单不能退费");
		}
		if (record.getSettleFee() == null) { return new ErrorMessageVO(false, "-1", "结算手续费为0"); }
		try {
			Long _accountType = this.maOnlineWrapper.queryAccountType(record.getMerchantMemberId(), record.getMerchantAccountNo(),
					IPUtils.getLocalIp());
			Assert.notNull(_accountType, "NewT0MerchantFastSettleServiceImpl.remitFastSettleFee.accountType is null");
			AccountType accountType = AccountType.getByCode(_accountType);
			// 更新到退费中 是否更新记录
			boolean isSuccess = this.update2TargetStatus(merchantFastSettleReqId, null, _accountType, MerchantFastSettleSubStatusEnum.SETTLED,
					MerchantFastSettleSubStatusEnum.REMIT_SETTLE_FEE_PROCESSING);
			if (!isSuccess) { return new ErrorMessageVO(false, "-1", "退费订单异常！"); }
			RemitTransferResponseDTO response = this.FOSFacade.remitSettleFee(merchantFastSettleReqId.toString(), record.getMerchantMemberId(),
					record.getMerchantAccountNo(), accountType, record.getFastSettleFee());
			logger.info("NewT0MerchantFastSettleServiceImpl.remitFastSettleFee.merchantFastSettleReqId=" + merchantFastSettleReqId + ",response="
					+ ToStringBuilder.reflectionToString(response));
			if (response != null) {
				if (FosPaymentStateEnums.S.code.equalsIgnoreCase(response.getPaymentState())) {
					this.update2TargetStatus(merchantFastSettleReqId, response.getMarginTransId(), _accountType,
							MerchantFastSettleSubStatusEnum.REMIT_SETTLE_FEE_PROCESSING, MerchantFastSettleSubStatusEnum.REMIT_SETTLE_FEE_SUCCESS);
					return new ErrorMessageVO(true, response.getPaymentState(), "该订单T+0退费成功");
				} else if (FosPaymentStateEnums.P.code.equalsIgnoreCase(response.getPaymentState())) {
					// 不做处理，需要用job同步状态
					return new ErrorMessageVO(false, response.getPaymentState(), "该订单退费处理中");
				} else if (FosPaymentStateEnums.F.code.equalsIgnoreCase(response.getPaymentState())) {
					this.update2TargetStatus(merchantFastSettleReqId, null, _accountType,
							MerchantFastSettleSubStatusEnum.REMIT_SETTLE_FEE_PROCESSING, MerchantFastSettleSubStatusEnum.REMIT_SETTLE_FEE_FAILURE);
					return new ErrorMessageVO(false, response.getPaymentState(), "该订单退费失败");
				}
			}
		} catch (Exception e) {
			logger.error("NewT0MerchantFastSettleServiceImpl.remitFastSettleFee.error.merchantFastSettleReqId=" + merchantFastSettleReqId);
		}
		return new ErrorMessageVO(false, "-1", "系统繁忙");
	}

	private boolean update2TargetStatus(Long merchantFastSettleReqId, Long transId, Long accountType, MerchantFastSettleSubStatusEnum original,
			MerchantFastSettleSubStatusEnum target) {
		MerchantFsReq record = new MerchantFsReq();
		record.setSubStatus(target.code);
		record.setUpdateTime(new Date());
		record.setRemitFeeTransId(transId);
		record.setMerchantAccountType(accountType.toString());
		MerchantFsReqExample example = new MerchantFsReqExample();
		MerchantFsReqExample.Criteria criteria = example.createCriteria();
		criteria.andMfqIdEqualTo(merchantFastSettleReqId);
		criteria.andSubStatusEqualTo(original.code);
		int rows = this.merchantFsRManager.updateByExampleSelective(record, example);
		logger.info("NewT0MerchantFastSettleServiceImpl.update2TargetStatus.merchantFastSettleReqId=" + merchantFastSettleReqId + ",rows=" + rows);
		return rows == 1;
	}

	/**
	 * 自动调整商户额度
	 */
	@Override
	public String changeMerchantLimit() {
		// 查询商户号码
		long time=System.currentTimeMillis();
		List<PromoterFastSettleSwitchDOExt> list = promoterFastSettleSwitchManager.getPosOpenFastSettleMerchantIds();
		Newt0McLimitChangeReqDO reqDo = this.merchantLimitChangeService.createAutoChangeMarchatLimitChangeReq(list);
		int successNum = 0;
		int failNum = 0;
		int whiteListNum = 0;
		if (list != null && list.size() > 0) {
			for (PromoterFastSettleSwitchDOExt promoterFastSettleSwitchDOExt : list) {
				Newt0McLimitChangeDtlDO detailDo = new Newt0McLimitChangeDtlDO();
				detailDo.setReqId(reqDo.getReqId());
				detailDo.setMcNo(promoterFastSettleSwitchDOExt.getMcMerchantNo());
				detailDo.setPosMcType(promoterFastSettleSwitchDOExt.getMcType());
				int status = 0;
				String message = null;
				WhiteListInfoDO whiteInfo = whiteListInfoService.queryWhiteListInfo(WhiteTypeEnums.AUTO_UPDATE_MERCHANT_LIMIT.code,
						promoterFastSettleSwitchDOExt.getMcMerchantNo(), promoterFastSettleSwitchDOExt.getMcType());
				if (whiteInfo != null) {
					status = 1;
					whiteListNum++;
					message = LimitRuleInfoConstant.AUTO_UPDATE_MERCHANT_LIMIT_MSG;
				} else {
					try {
						// 调用接口
						MspModifyRequest mspModifyRequest = new MspModifyRequest(OpObjTypeEnums.MERCHANT.code,
								promoterFastSettleSwitchDOExt.getMcMerchantId(), OpTypeEnums.MERCHANT_FASTSETTLE_AUTO_CHANGE.code);
						
						MerchantInfoDTO merchantInfoDTO = mspFacade.findMerchantInfoByMerchantId(promoterFastSettleSwitchDOExt.getMcMerchantId());
						if (merchantInfoDTO != null) {
							// 设置非工作日的费率
							mspModifyRequest.setFastSettleHolidayFee(merchantInfoDTO.getFastSettleHolidayFee());
							// 设置工作日的费率
							mspModifyRequest.setFastSettleWorkdayFee(merchantInfoDTO.getFastSettleWorkdayFee());
						}
						mspModifyRequest.setFastSettleFlag(1);
						mspModifyRequest.setMerchantNo(promoterFastSettleSwitchDOExt.getMcMerchantNo());
						mspModifyRequest.setPromoterId(promoterFastSettleSwitchDOExt.getPromoterId());
						// 查询商户日可用额度限额
						BigDecimal fastSettleLimit = mcManagerService.getAutoUpdateDayOfAmount(promoterFastSettleSwitchDOExt.getMcMerchantNo(),
								promoterFastSettleSwitchDOExt.getMcType());
						mspModifyRequest.setFastSettleLimit(fastSettleLimit.toString());
						detailDo.setMaxLimit(fastSettleLimit);
						long fcmId = mspFacade.createFsconfigChange(mspModifyRequest, MerchantContractCst.SYSTEM_DEFAULT_USER);
						detailDo.setCfmId(fcmId);
						ErrorMessageVO<Object> mspResponseDTO = mspFacade.modifyFastSettleConfig2Msp(mspModifyRequest, fcmId);
						detailDo.setMinLimit(new BigDecimal(mspModifyRequest.getFastSettleMinLimit()));
						if (mspResponseDTO.isSuccess()) {
							status = 1;
							mspFacade.modifyFsConfigChangeStatus(fcmId, FsConfigChangeStatusEnum.SUCCESS.code);
							mspResponseDTO.setErrorMessage(MerchantCreditConstant.MC_PROMOTER_M_MERCHANT_SUCCESS);
						} else {
							status = 2;
							mspFacade.modifyFsConfigChangeStatus(fcmId, FsConfigChangeStatusEnum.FAILUE.code);
							mspResponseDTO.setErrorMessage(MerchantCreditConstant.MC_PROMOTER_M_MERCHANT_FAILURE);
							message = mspResponseDTO.getErrorMessage();
						}
						logger.info("NewT0MerchantFastSettleServiceImpl.changMerchantLimit,response="
								+ ToStringBuilder.reflectionToString(mspResponseDTO));

					} catch (Exception e) {
						status = 2;
						logger.error(
								"NewT0MerchantFastSettleServiceImpl.changMerchantLimit,McMerchantNo:"
										+ promoterFastSettleSwitchDOExt.getMcMerchantNo() + "Exception:" + e.getMessage(), e);
						message = e.getMessage();
						// continue;
					}
				}
				if (status != 1) {
					failNum++;
				} else {
					successNum++;
				}
				detailDo.setStatus(status);
				if (message != null) {
					detailDo.setMessage(message);
				}
				detailDo.setCreateTime(new Date());
				detailDo.setUpdateTime(new Date());
				this.merchantLimitChangeService.createReqDetailDo(detailDo);
			}
		}
		reqDo.setStatus(2);
		reqDo.setSuccessNum(successNum);
		reqDo.setFailNum(failNum);
		reqDo.setUpdateTime(new Date());
		merchantLimitChangeService.updateReqDo(reqDo);
		long useTime=(System.currentTimeMillis()-time)/1000;
		logger.info("changMerchantLimit success,use time(s):"+useTime);
		return "成功："+successNum+",失败："+failNum+","+whiteListNum+";用时(s)："+useTime;
	}
	/**
	 * 自动调整商户额度
	 */
	@Deprecated
	public String changMerchantLimit() {
		// 查询商户号码
		long time=System.currentTimeMillis();
		List<PromoterFastSettleSwitchDOExt> list = promoterFastSettleSwitchManager.getPosOpenFastSettleMerchantIds();
		Newt0McLimitChangeReqDO reqDo = this.merchantLimitChangeService.createAutoChangeMarchatLimitChangeReq(list);
		int successNum = 0;
		int failNum = 0;
		int whiteListNum = 0;
		if (list != null && list.size() > 0) {
			for (PromoterFastSettleSwitchDOExt promoterFastSettleSwitchDOExt : list) {
				Newt0McLimitChangeDtlDO detailDo = new Newt0McLimitChangeDtlDO();
				detailDo.setReqId(reqDo.getReqId());
				detailDo.setMcNo(promoterFastSettleSwitchDOExt.getMcMerchantNo());
				detailDo.setPosMcType(promoterFastSettleSwitchDOExt.getMcType());
				int status = 0;
				String message = null;
				WhiteListInfoDO whiteInfo = whiteListInfoService.queryWhiteListInfo(WhiteTypeEnums.AUTO_UPDATE_MERCHANT_LIMIT.code,
						promoterFastSettleSwitchDOExt.getMcMerchantNo(), promoterFastSettleSwitchDOExt.getMcType());
				if (whiteInfo != null) {
					status = 1;
					whiteListNum++;
					message = LimitRuleInfoConstant.AUTO_UPDATE_MERCHANT_LIMIT_MSG;
				} else {
					try {
						// 调用接口
						MspModifyRequest mspModifyRequest = new MspModifyRequest(OpObjTypeEnums.MERCHANT.code,
								promoterFastSettleSwitchDOExt.getMcMerchantId(), OpTypeEnums.MERCHANT_FASTSETTLE_AUTO_CHANGE.code);
						// 据merchantNo查询商户费率
						// MspPosMerchantEO mspPosMerchantEO =
						// mspPosMerchantDAO.selectFeeByMerchantNo(promoterFastSettleSwitchDOExt.getMcMerchantNo());
						// if (mspPosMerchantEO != null) {
						// //设置非工作日的费率
						// mspModifyRequest.setFastSettleHolidayFee(mspPosMerchantEO.getHolidayFee().toString());
						// //设置工作日的费率
						// mspModifyRequest.setFastSettleWorkdayFee(mspPosMerchantEO.getWorkdayFee().toString());
						// }
						// 根据商户id查询商户费率
						MerchantInfoDTO merchantInfoDTO = mspFacade.findMerchantInfoByMerchantId(promoterFastSettleSwitchDOExt.getMcMerchantId());
						if (merchantInfoDTO != null) {
							// 设置非工作日的费率
							mspModifyRequest.setFastSettleHolidayFee(merchantInfoDTO.getFastSettleHolidayFee());
							// 设置工作日的费率
							mspModifyRequest.setFastSettleWorkdayFee(merchantInfoDTO.getFastSettleWorkdayFee());
						}
						mspModifyRequest.setFastSettleFlag(1);
						mspModifyRequest.setMerchantNo(promoterFastSettleSwitchDOExt.getMcMerchantNo());
						mspModifyRequest.setPromoterId(promoterFastSettleSwitchDOExt.getPromoterId());
						// 查询商户日可用额度限额
						BigDecimal fastSettleLimit = mcManagerService.getAutoUpdateDayOfAmount(promoterFastSettleSwitchDOExt.getMcMerchantNo(),
								promoterFastSettleSwitchDOExt.getMcType());
						mspModifyRequest.setFastSettleLimit(fastSettleLimit.toString());
						detailDo.setMaxLimit(fastSettleLimit);
						long fcmId = mspFacade.createFsconfigChange(mspModifyRequest, MerchantContractCst.SYSTEM_DEFAULT_USER);
						detailDo.setCfmId(fcmId);
						ErrorMessageVO<Object> mspResponseDTO = mspFacade.modifyFastSettleConfig2Msp(mspModifyRequest, fcmId);
						detailDo.setMinLimit(new BigDecimal(mspModifyRequest.getFastSettleMinLimit()));
						if (mspResponseDTO.isSuccess()) {
							status = 1;
							mspFacade.modifyFsConfigChangeStatus(fcmId, FsConfigChangeStatusEnum.SUCCESS.code);
							mspResponseDTO.setErrorMessage(MerchantCreditConstant.MC_PROMOTER_M_MERCHANT_SUCCESS);
						} else {
							status = 2;
							mspFacade.modifyFsConfigChangeStatus(fcmId, FsConfigChangeStatusEnum.FAILUE.code);
							mspResponseDTO.setErrorMessage(MerchantCreditConstant.MC_PROMOTER_M_MERCHANT_FAILURE);
							message = mspResponseDTO.getErrorMessage();
						}
						logger.info("NewT0MerchantFastSettleServiceImpl.changMerchantLimit,response="
								+ ToStringBuilder.reflectionToString(mspResponseDTO));
						
					} catch (Exception e) {
						status = 2;
						logger.error(
								"NewT0MerchantFastSettleServiceImpl.changMerchantLimit,McMerchantNo:"
										+ promoterFastSettleSwitchDOExt.getMcMerchantNo() + "Exception:" + e.getMessage(), e);
						message = e.getMessage();
						// continue;
					}
				}
				if (status != 1) {
					failNum++;
				} else {
					successNum++;
				}
				detailDo.setStatus(status);
				if (message != null) {
					detailDo.setMessage(message);
				}
				detailDo.setCreateTime(new Date());
				detailDo.setUpdateTime(new Date());
				this.merchantLimitChangeService.createReqDetailDo(detailDo);
			}
		}
		reqDo.setStatus(2);
		reqDo.setSuccessNum(successNum);
		reqDo.setFailNum(failNum);
		reqDo.setUpdateTime(new Date());
		merchantLimitChangeService.updateReqDo(reqDo);
		long useTime=(System.currentTimeMillis()-time)/1000;
		logger.info("changMerchantLimit success,use time(s):"+useTime);
		return "成功："+successNum+",失败："+failNum+","+whiteListNum+";用时(s)："+useTime;
	}

	/**
	 * 调整商户额度
	 * limitType 0 or null 临时额度  1: 永久额度
	 */
	public long changMerchantLimit(String merchantNo, String posMerchantType, BigDecimal maxLimit, BigDecimal minLimit, String operatorId,String limitType)
			throws Exception {
		long fcmId = 0;
		// 查询商户号码
		try {
			if (!NumberUtils.isLong(merchantNo)) { throw new FastSettleLimitException("商户号格式不正确"); }
			MerchantInfoDTO merchantInfoDTO = mspFacade.findMerchantInfoByMerchantNo(merchantNo, posMerchantType);
			if (merchantInfoDTO == null) { throw new FastSettleLimitException("修改的商户信息不存在"); }
			if (merchantInfoDTO.getFastSettleFlag() != null
					&& !MerchantCreditConstant.FAST_SETTLE_FLAG_OPEN.equals(merchantInfoDTO.getFastSettleFlag().toString())) { throw new FastSettleLimitException(
					"商户已关闭快速结算服务，不能修改额度"); }

			WhiteListInfoDO whiteInfo = whiteListInfoService.queryWhiteListInfo(WhiteTypeEnums.AUTO_UPDATE_MERCHANT_LIMIT.code,merchantNo, posMerchantType);
			if (LimitTypeEnums.PERMANENT.code.equals(limitType)) {
				if (whiteInfo == null) {// 没有白名单，创建白名单
					this.whiteListInfoService.createWhiteInfo(WhiteTypeEnums.AUTO_UPDATE_MERCHANT_LIMIT.code, merchantInfoDTO.getMerchantNo(),
							merchantInfoDTO.getMcType(), LimitRuleInfoConstant.AUTO_UPDATE_MERCHANT_LIMIT_MSG, operatorId);
				}
			} else if (LimitTypeEnums.TEMPORARY.code.equals(limitType) || StringUtil.isBlank(limitType)) {
				if (whiteInfo != null) {// 有白名单，关闭白名单
					this.whiteListInfoService.updateLoseEfficacy(whiteInfo.getId(), operatorId);
				}
			}

			// 调用接口
			MspModifyRequest mspModifyRequest = new MspModifyRequest(OpObjTypeEnums.MERCHANT.code, Long.parseLong(merchantInfoDTO.getMerchantId()),
					OpTypeEnums.MERCHANT_FASTSETTLE_BATCH_OP.code);
			// 据merchantNo查询商户费率
			// MspPosMerchantEO mspPosMerchantEO =
			// mspPosMerchantDAO.selectFeeByMerchantNo(merchantNo);
			// if (mspPosMerchantEO != null) {
			// //设置非工作日的费率
			// mspModifyRequest.setFastSettleHolidayFee(mspPosMerchantEO.getHolidayFee().toString());
			// //设置工作日的费率
			// mspModifyRequest.setFastSettleWorkdayFee(mspPosMerchantEO.getWorkdayFee().toString());
			// }
			// 根据商户id查询商户费率
			// 设置非工作日的费率
			mspModifyRequest.setFastSettleHolidayFee(merchantInfoDTO.getFastSettleHolidayFee());
			// 设置工作日的费率
			mspModifyRequest.setFastSettleWorkdayFee(merchantInfoDTO.getFastSettleWorkdayFee());

			mspModifyRequest.setFastSettleFlag(1);
			mspModifyRequest.setMerchantNo(merchantNo);
			mspModifyRequest.setPromoterId(merchantInfoDTO.getPromoterId());
			// 最大额度
			mspModifyRequest.setFastSettleLimit(maxLimit.toString());
			// 最小额度
			mspModifyRequest.setFastSettleMinLimit(minLimit.toString());

			try {
				fcmId = mspFacade.createFsconfigChange(mspModifyRequest, operatorId);
			} catch (Exception e) {
				logger.error("NewT0MerchantFastSettleServiceImpl.changMerchantLimit,McMerchantNo:" + merchantNo + "  ,posMerchantType:"
						+ posMerchantType + "Exception:" + e.getMessage(), e);
				throw new FastSettleLimitException("创建修改记录是发生异常", fcmId);
			}

			ErrorMessageVO<Object> mspResponseDTO = mspFacade.modifyFastSettleConfig2Msp(mspModifyRequest, fcmId);
			logger.info("NewT0MerchantFastSettleServiceImpl.changMerchantLimit,response=" + ToStringBuilder.reflectionToString(mspResponseDTO));
			if (mspResponseDTO.isSuccess()) {
				mspFacade.modifyFsConfigChangeStatus(fcmId, FsConfigChangeStatusEnum.SUCCESS.code);
				mspResponseDTO.setErrorMessage(MerchantCreditConstant.MC_PROMOTER_M_MERCHANT_SUCCESS);
			} else {
				mspFacade.modifyFsConfigChangeStatus(fcmId, FsConfigChangeStatusEnum.FAILUE.code);
				// mspResponseDTO.setErrorMessage(MerchantCreditConstant.MC_PROMOTER_M_MERCHANT_FAILURE);
				throw new FastSettleLimitException("修改商户额度失败，原因：" + mspResponseDTO.getErrorMessage(), fcmId);

			}

		} catch (FastSettleLimitException e) {
			throw e;
		} catch (Exception e) {
			logger.error("NewT0MerchantFastSettleServiceImpl.changMerchantLimit,McMerchantNo:" + merchantNo + "  ,posMerchantType:" + posMerchantType
					+ "Exception:" + e.getMessage(), e);
			throw e;
		}
		return fcmId;
	}

	/**
	 * 额度耗尽提醒
	 */
	public void remindRunOut() {
		// 查询所有开通快速结算代理商
		List<PromoterFastSettleSwitchDOExt> promoterList = promoterFastSettleSwitchManager.getPromoters(null);
		// 需要预警的代理商
		List<Long> promoWarnList = new ArrayList<Long>();

		// 查询比例
		// 代理商
		BigDecimal proportionPromotor = this.getProportion(MerchantCreditConstant.NEWT0_REMIND_RUN_OUT_PROMOTER_PROPORTION);
		// 商户
		BigDecimal proportionMerchant = this.getProportion(MerchantCreditConstant.NEWT0_REMIND_RUN_OUT_MERCHANT_PROPORTION);

		// 循环判断是否到比例
		StringBuffer content = getEmailHeader();
		boolean isMail = false;
		// 代理商预警 商户发短信手机号集合
		List<String> promoterPhones = new ArrayList<String>();

		if (promoterList != null && promoterList.size() > 0) {

			for (int i = 0; i < promoterList.size(); i++) {
				// StraightlyCfg straightlyCfg =
				// mspFacade.getPromoterCredit(promoterList.get(i).getPromoterId());
				PromoterFastSettleSwitchDOExt promoterDoExt = promoterList.get(i);
				BigDecimal validCredit = getWithdrawT0ServiceAPI().findCanUseQuota(promoterDoExt.getPromoterNo(), promoterDoExt.getMcType());
				BigDecimal credit = getWithdrawT0ServiceAPI().findTotalAmount(promoterDoExt.getPromoterNo(), promoterDoExt.getMcType());

				if (validCredit == null || credit == null) {
					logger.error("NewT0MerchantFastSettle.remindRunOut.mspFacade validCredit or credit return null,PromoterId:"
							+ promoterList.get(i).getPromoterId());
					continue;
				}
				if (credit.compareTo(new BigDecimal(0)) > 0 && validCredit.compareTo(credit.multiply(proportionPromotor)) <= 0) {
					isMail = true;
					logger.info("NewT0MerchantFastSettleServiceImpl.remindRunOut: PromoterId" + promoterDoExt.getPromoterId());
					content.append("<tr><td>"
							+ (LoaningTypeEnum.getLoaningTypeEnum(promoterDoExt.getLoaningType()) != null ? LoaningTypeEnum
									.getLoaningTypeEnum(promoterDoExt.getLoaningType()).desc : " ") + "</td>");
					content.append("<td>" + promoterDoExt.getPromoterNo() + "</td>");
					content.append("<td>" + promoterDoExt.getPromoterName() + "</td>");
					String bizType="";
					if (StringUtils.isNotBlank(promoterDoExt.getMcType()) && promoterDoExt.getMcType().equals(PosMerchantTypeEnums.MPOS_PROMOTER.code)) {
						bizType="手刷";
					} else if (StringUtils.isNotBlank(promoterDoExt.getMcType())
							&& promoterDoExt.getMcType().equals(PosMerchantTypeEnums.POS_PROMOTER.code)) {
						bizType="POS";
					} else if (StringUtils.isNotBlank(promoterDoExt.getMcType())
							&& promoterDoExt.getMcType().equals(PosMerchantTypeEnums.EASYPAY_PROMOTER.code)) {
						bizType="云收银";
					}
					content.append("<td>"+bizType+"</td>");
					content.append("<td>" + credit + "</td>");
					content.append("<td>" + credit.subtract(validCredit) + "</td>");
					content.append("<td>"
							+ ((credit.subtract(validCredit).divide(credit, 4, BigDecimal.ROUND_HALF_UP)).multiply(new BigDecimal(100))).setScale(2,
									java.math.BigDecimal.ROUND_HALF_UP).doubleValue() + "%</td></tr>");
					// 代理商额度不足不提醒商户
					WhiteListInfoDO info = whiteListInfoService.queryWhiteListInfo(WhiteTypeEnums.PROMOTER_LIMIT_NO_ENOUGH_REMIND_MERCHANT.code,
							promoterDoExt.getPromoterNo(), promoterDoExt.getMcType());
					if (info == null) {
						promoWarnList.add(promoterDoExt.getPromoterId());
					}
					// 代理商额度不足不提醒代理商
					info = whiteListInfoService.queryWhiteListInfo(WhiteTypeEnums.PROMOTER_LIMIT_NO_ENOUGH_REMIND_PROMOTER.code,
							promoterDoExt.getPromoterNo(), promoterDoExt.getMcType());
					if (info != null) {
						continue;
					}
					String phone = mspFacade.getPromoterMoileByPromoterId(promoterDoExt.getPromoterId());
					if (StringUtils.isNotBlank(phone)) {
						promoterPhones.add(phone);
						Map<String,String> param=new HashMap<String, String>();
						param.put("bizType", bizType);
						messageService.sendOneMessage(phone,MessageTemplateCodeEnum.PROMOTER_LIMIT_NO_ENOUGH_REMIND_PROMOTER.getKey(), param);
					}

				}

			}
			content.append("</table></body></html>");
			if (isMail) {
				String title = "代理商额度不足"
						+ proportionPromotor.multiply(new BigDecimal(100)).toString()
								.substring(0, proportionPromotor.multiply(new BigDecimal(100)).toString().lastIndexOf(".")) + "%";
				sendMail(title, content.toString(), MerchantCreditConstant.NEWT0_REMIND_RUN_OUT_PROMOTER_MAIL_LIST);
			}
		}
		// 查询所有商户,包括垫资方字段,手机号  
		//TODO 目前云收银额度不足只发送信息给代理商 不发送给商户
		List<PromoterFastSettleSwitchDOExt> merchantList = promoterFastSettleSwitchManager.getAllPosAndMposOpenFastSettleMerchants();
		// 代理商预警 商户发短信手机号集合
		List<String> phones1 = new ArrayList<String>();
		// 代理商未预警 商户预警发短信手机号集合
		List<String> phones2 = new ArrayList<String>();
		for (PromoterFastSettleSwitchDOExt promoterFastSettleSwitchDOExt : merchantList) {
			if (promoWarnList.contains(promoterFastSettleSwitchDOExt.getPromoterId())) {
				logger.info("NewT0MerchantFastSettleServiceImpl.remindRunOut:warn promoterinfo: " + promoterFastSettleSwitchDOExt.toString());
				if (StringUtils.isNotBlank(promoterFastSettleSwitchDOExt.getMerchantPhone())) {
					// 代理商额度不足不提醒商户
					WhiteListInfoDO info = whiteListInfoService.queryWhiteListInfo(WhiteTypeEnums.PROMOTER_LIMIT_NO_ENOUGH_REMIND_MERCHANT.code,
							promoterFastSettleSwitchDOExt.getMcMerchantNo(), promoterFastSettleSwitchDOExt.getMcType());
					if (info != null) {
						continue;
					}
					phones1.add(promoterFastSettleSwitchDOExt.getMerchantPhone());
				}
			} else {
				// StraightlyCfg straightlyCfg =
				// mspFacade.queryStraightlyCfg(promoterFastSettleSwitchDOExt.getMcMerchantId());
				BigDecimal merchantValidCredit = getWithdrawT0ServiceAPI().findCanUseQuota(promoterFastSettleSwitchDOExt.getMcMerchantNo(),
						promoterFastSettleSwitchDOExt.getMcType());
				BigDecimal merchantCredit = getWithdrawT0ServiceAPI().findTotalAmount(promoterFastSettleSwitchDOExt.getMcMerchantNo(),
						promoterFastSettleSwitchDOExt.getMcType());

				if (merchantValidCredit == null || merchantCredit == null) {
					logger.error("NewT0MerchantFastSettle.remindRunOut merchantValidCredit or merchantCredit return null,McMerchantId:"
							+ promoterFastSettleSwitchDOExt.getMcMerchantId());
					continue;
				}
				if (merchantCredit.compareTo(new BigDecimal(0)) > 0
						&& merchantValidCredit.compareTo(merchantCredit.multiply(proportionMerchant)) <= 0) {
					logger.info("NewT0MerchantFastSettleServiceImpl.remindRunOut:warn merchantinfo: " + promoterFastSettleSwitchDOExt.toString());
					if (StringUtils.isNotBlank(promoterFastSettleSwitchDOExt.getMerchantPhone())) {
						// 商户额度不足不提醒商户
						WhiteListInfoDO info = whiteListInfoService.queryWhiteListInfo(WhiteTypeEnums.MERCHANT_LIMIT_NO_ENOUGH_REMIND_MERCHANT.code,
								promoterFastSettleSwitchDOExt.getMcMerchantNo(), promoterFastSettleSwitchDOExt.getMcType());
						if (info != null) {
							continue;
						}
						ViewMerchantInfoDTO dto = merchantInfoService.queryMerchantInfoByMerchantId(promoterFastSettleSwitchDOExt.getMcMerchantId());
						if (dto != null) {
							if (whiteListInfoService.queryWhiteListInfo(WhiteTypeEnums.MERCHANT_LIMIT_NO_ENOUGH_REMIND_MERCHANT.code,
									dto.getPromoterMerchantNo(), dto.getPromoterType()) != null) {
								continue;
							}
						}
						phones2.add(promoterFastSettleSwitchDOExt.getMerchantPhone());
					}
				}
			}
		}
		if (phones1.size() > 0) {
			//暂时代理商额度不足不给商户发短信
			//messageService.sendMessage(phones1, MessageTemplateCodeEnum.PROMOTER_LIMIT_NO_ENOUGH_REMIND_MERCHANT.getKey(), null);
		}
		if (phones2.size() > 0) {
			messageService.sendMessage(phones2, MessageTemplateCodeEnum.MERCHANT_LIMIT_NO_ENOUGH_REMIND_MERCHANT.getKey(), null);
		}
		//查询出来就发送
//		if (promoterPhones.size() > 0) {
//			messageService.sendMessage(promoterPhones, MessageTemplateCodeEnum.PROMOTER_LIMIT_NO_ENOUGH_REMIND_PROMOTER.getKey(), null);
//		}

		// /******** 总额度耗尽，给盛付通全资的所有开通快速结算的商户发短信，给负责人发邮件 *********/
		// // 查询总额度
		// Date now = new Date();
		// //查询总额度剩余比例
		// BigDecimal proportion =
		// this.getProportion(MerchantCreditConstant.NEWT0_REMIND_RUN_OUT_PROPORTION);
		//
		// Newt0SdpRemainBalanceDOExample example = new
		// Newt0SdpRemainBalanceDOExample();
		// Newt0SdpRemainBalanceDOExample.Criteria criteria =
		// example.createCriteria();
		// criteria.andStartTimeLessThanOrEqualTo(now);
		// criteria.andEndTimeGreaterThan(now);
		// boolean isZero = false;
		// // 查询总额度
		// List<Newt0SdpRemainBalanceDO> list =
		// extNewt0SdpRemainBalanceManager.selectByExample(example);
		//
		// if (list != null && list.size() > 0) {
		// if (list.size() > 1) {
		// //待扩展 TODO
		// logger.error("NewT0MerchantFastSettleServiceImpl.remindRunOut has more than one Newt0SdpRemainBalanceDO now="
		// + now);
		// }
		// if(list.get(0).getQuota() !=null &&
		// list.get(0).getQuota().compareTo(new BigDecimal(0)) > 0
		// &&
		// list.get(0).getQuota().multiply(proportion).compareTo(list.get(0).getCanUseQuota())
		// >= 0){
		// isZero = true;
		// sendMessage(isZero, LoaningTypeEnum.PROMOTER.getCode());
		// String title = "快速结算总额度耗尽提醒";
		// SimpleDateFormat dateFormat = new
		// SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		// String content = "时间：" + dateFormat.format(new Date()).toString() +
		// ",当日快速结算垫资额度为"+list.get(0).getCanUseQuota()+"元,剩余可使用"+list.get(0).getCanUseQuota()
		// + "元";
		// // 发送邮件
		// sendMail(title, content,
		// MerchantCreditConstant.NEWT0_REMIND_RUN_OUT_MAIL_LIST);
		// }
		// } else {
		// sendMessage(isZero, null);
		// }

	}

	private StringBuffer getEmailHeader() {
		StringBuffer content = new StringBuffer();
		content.append("<!DOCTYPE html PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\" \"http://www.w3.org/TR/html4/loose.dtd\">");
		content.append("<html>");
		content.append("<head>");
		content.append("<meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">");
		content.append("<title>额度耗尽提醒邮件</title>");
		content.append("</head>");
		content.append("<body>");
		content.append("<table><tr><th>垫资类型</th><th>代理商商户号</th><th>代理商名称 </th><th>代理商类型</th><th>总额度    </th><th>已用额度   </th><th>使用率 </th></tr>");
		return content;
	}

	// 此方法已废弃
	// 发送短信
	// private void sendMessage(boolean isZero, Integer loaningType) {
	// /**
	// * 如果总额度耗尽，则开通快速结算的盛付通全资的商户已发短信，此处只需查代理商全资并且已消耗完额度的代理商下的已开通快速结算的商户进行发短信
	// *
	// **/
	// List<Long> promoZeroList = new ArrayList<Long>();
	// // 查询指定垫资方的所有代理商
	// List<PromoterFastSettleSwitchDOExt> promoterList =
	// promoterFastSettleSwitchManager.getPromoters(loaningType);
	// for (int i = 0; i < promoterList.size(); i++) {
	// StraightlyCfg straightlyCfg =
	// mspFacade.getPromoterCredit(promoterList.get(i).getPromoterId());
	//
	// if (straightlyCfg.getValidCredit().compareTo(BigDecimal.ZERO) <= 0) {
	// promoZeroList.add(promoterList.get(i).getPromoterId());
	// }
	// }
	// // 查询所有商户,包括垫资方字段,手机号
	// List<PromoterFastSettleSwitchDOExt> merchantList =
	// promoterFastSettleSwitchManager.getAllMerchants();
	// List<String> phones1 = new ArrayList<String>();
	// List<String> phones2 = new ArrayList<String>();
	// List<String> phones3 = new ArrayList<String>();
	// for (PromoterFastSettleSwitchDOExt promoterFastSettleSwitchDOExt :
	// merchantList) {
	// if (promoterFastSettleSwitchDOExt.getMcMerchantId() ==
	// 201510121000016773l) {
	// System.out.println(promoterFastSettleSwitchDOExt.getMcMerchantId());
	// }
	// if (isZero && LoaningTypeEnum.SHENGPAY.getCode() ==
	// promoterFastSettleSwitchDOExt.getLoaningType()) {
	// phones1.add(promoterFastSettleSwitchDOExt.getMerchantPhone());
	// continue;
	// }
	// if
	// (promoZeroList.contains(promoterFastSettleSwitchDOExt.getPromoterId())) {
	// phones2.add(promoterFastSettleSwitchDOExt.getMerchantPhone());
	// continue;
	// }
	// StraightlyCfg straightlyCfg =
	// mspFacade.queryStraightlyCfg(promoterFastSettleSwitchDOExt.getMcMerchantId());
	// // TODO:根据 checkResultCode判断是否继续流程
	// if (straightlyCfg.getValidCredit().compareTo(BigDecimal.ZERO) <= 0) {
	// phones3.add(promoterFastSettleSwitchDOExt.getMerchantPhone());
	// }
	// }
	// logger.info("NewT0MerchantFastSettleServiceImpl.sendMessage.phones1.size:"
	// + phones1.size() + ",phones2.size:" + phones2.size() + ",phones3.size:" +
	// phones3.size());
	// messageService.sendMessage(phones1,
	// MessageTemplateCodeEnum.REMIND_ALL_RUN_OUT.getKey(), null);
	// messageService.sendMessage(phones2,
	// MessageTemplateCodeEnum.REMIND_PROMOTER_RUN_OUT.getKey(), null);
	// messageService.sendMessage(phones3,
	// MessageTemplateCodeEnum.REMIND_MERCHANT_RUN_OUT.getKey(), null);
	// }

	// 向BD、清算及业务负责人发邮件
	private static ExecutorService executorService = Executors.newFixedThreadPool(5);

	private void sendMail() {
		try {
			final String mailList = ConfigOptionHelper.getConfigByKey(MerchantCreditConstant.NEWT0_REMIND_RUN_OUT_MAIL_LIST);
			if (StringUtils.isBlank(mailList)) {
				logger.error("NewT0MerchantFastSettle.sendMail.error,mail list is not configured");
				return;
			}
			final AlertMessageSender sender = alertMessageSenderFactory.getAlertMessageSender(AlertMessageSendTypeEnum.MAIL_ALERT);
			SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			final String content = dateFormat.format(new Date()).toString() + ",当日快速结算垫资额度已用尽";
			final String title = "快速结算额度耗尽";
			Thread t = new Thread() {
				public void run() {
					try {
						sender.sendMessage(title, content, mailList);
					} catch (Exception e) {
						logger.error("NewT0MerchantFastSettle.sendMail.error.inner", e);
					}
				}
			};
			executorService.execute(t);
		} catch (Exception e) {
			logger.info("NewT0MerchantFastSettle.sendMail.error", e);
		}
	}

	/**
	 * 取剩余额度比例
	 *
	 * @param config
	 * @return
	 */
	private BigDecimal getProportion(String config) {
		String proportionConfig = ConfigOptionHelper.getConfigByKey(config);
		BigDecimal proportion = new BigDecimal(0);
		if (StringUtils.isNotBlank(proportionConfig)) {
			proportion = new BigDecimal(proportionConfig);
		}
		return proportion;
	}

	/**
	 * 发送邮件
	 *
	 * @param title
	 * @param content
	 * @param configKey
	 */
	private void sendMail(String title, String content, String configKey) {
		try {
			final String mailList = ConfigOptionHelper.getConfigByKey(configKey);
			if (StringUtils.isBlank(mailList)) {
				logger.error("NewT0MerchantFastSettle.sendMail.error,mail list is not configured,key:" + configKey);
				return;
			}
			Thread thread = new MsgThread(alertMessageSenderFactory, title, content, mailList);
			executorService.execute(thread);
		} catch (Exception e) {
			logger.info("NewT0MerchantFastSettle.sendMail.error", e);
		}
	}

	/**
	 * 退手续费
	 *
	 * @param merchantFastSettleReqId
	 * @return
	 */
	@SuppressWarnings("rawtypes")
	public synchronized ErrorMessageVO refoundWithdrawFee(Long reqId, String operator) {
		// 查询出款记录
		WithdrawReqDO reqDo = withdrawReqManager.selectByPrimaryKey(reqId);
		if(reqDo.getWdCost()==null)reqDo.setWdCost(BigDecimal.ZERO);
		if (reqDo == null) return new ErrorMessageVO(false, "-1", "出款订单数据不存在");
		if (WithdrawReqStatusEnums.SUCCESS.code.intValue() != reqDo.getStatus() || reqDo.getWithdrawCost() == null
				|| reqDo.getWithdrawCost().compareTo(BigDecimal.ZERO) <= 0) { return new ErrorMessageVO(false, "-1", "该订单未扣手续费, 不能退费"); }
		// 验证订单数据
		if (WithdrawReqStatusEnums.SUCCESS.code.intValue() == reqDo.getStatus()) {
			long minutes = ConfigOptionHelper.getLongByKey(MerchantCreditConstant.NEW_T0_REMIT_FEE_MINUTE);
			// 计算出实际花费时间--等pos接口修改后还是要放开
			long realCostTime = (reqDo.getUpdateTime().getTime() - reqDo.getCreateTime().getTime()) / 1000 / 60;
			// 验证是否超时
			if (realCostTime < minutes) { return new ErrorMessageVO(false, "-1", "该订单不能退费,未满足退费的条件"); }
		}
		if (reqDo.getMemberId() == null) { return new ErrorMessageVO(false, "-1", "会员信息不存在"); }
		AccountInfo accountInfo = this.maOnlineWrapper.queryBaseAccountInfo(reqDo.getMemberId(), IPUtils.getLocalIp());
		if (accountInfo == null) return new ErrorMessageVO(false, "-1", "对应账户信息不存在");
		// 插入转账记录
		RemitFeeReqDo remitDO = bulidRemitFeeReqDo(reqDo, operator, null, RemitWithdrawFeeStatusEnums.INIT);
		remitDO.setCreateTime(new Date());
		remitDO.setMtId(0L);
		Long remitId = null;
		RemitFeeReqDoExample example = new RemitFeeReqDoExample();
		example.createCriteria().andReqIdEqualTo(reqId);
		List<RemitFeeReqDo> list = remitFeeReqManager.selectByExample(example);
		if (list == null || list.size() < 1) {
			remitId = remitFeeReqManager.insert(remitDO);
		} else {
			remitId = list.get(0).getRemitId();
			if (list.get(0).getStatus().equals(RemitWithdrawFeeStatusEnums.REMITING.code.toString())
					|| list.get(0).getStatus().equals(RemitWithdrawFeeStatusEnums.SUCCESS.code.toString())) { return new ErrorMessageVO(false, "-1",
					"此订单状态处理中或已经退费成功，请勿重新操作"); }
		}
		if (remitId == null) return new ErrorMessageVO(false, "-1", "退费操作数据库异常");
		// 更新状态
		RemitFeeReqDo record = null;
		AccountType accountType = AccountType.getByCode(accountInfo.getAccountType());
		ErrorMessageVO message = null;
		RemitTransferResponseDTO response = null;
		try {
			response = this.FOSFacade.remitSettleFee(remitId.toString(), reqDo.getMemberId(), accountInfo.getAccountId(), accountType,
					reqDo.getWithdrawCost().add(reqDo.getWdCost()));
			logger.info("NewT0MerchantFastSettleServiceImpl.refoundWithdrawFee.reqid=" + reqId + ",response="
					+ ToStringBuilder.reflectionToString(response));
			if (response != null) {
				if (FosPaymentStateEnums.S.code.equalsIgnoreCase(response.getPaymentState())) {
					// 更新退款记录表
					record = bulidRemitFeeReqDo(null, "", remitId, RemitWithdrawFeeStatusEnums.SUCCESS);
					message = new ErrorMessageVO(true, response.getPaymentState(), "该订单T+0退费成功");
				} else if (FosPaymentStateEnums.P.code.equalsIgnoreCase(response.getPaymentState())) {
					record = bulidRemitFeeReqDo(null, operator, remitId, RemitWithdrawFeeStatusEnums.REMITING);
					// 不做处理，需要用job同步状态
					message = new ErrorMessageVO(false, response.getPaymentState(), "该订单退费处理中");
				} else if (FosPaymentStateEnums.F.code.equalsIgnoreCase(response.getPaymentState())) {
					// 更新退款记录表
					record = bulidRemitFeeReqDo(null, "", remitId, RemitWithdrawFeeStatusEnums.FAIL);
					message = new ErrorMessageVO(false, response.getPaymentState(), "该订单退费失败");
				}
				if (record != null) {
					record.setMtId(response.getMarginTransId());
					record.setUpdateTime(new Date());
					remitFeeReqManager.updateByPrimaryKeySelective(record);
				}
				return message;
			}
		} catch (Exception e) {
			logger.error("NewT0MerchantFastSettleServiceImpl refoundWithdrawFee error:" + reqId + "" + e);
		}
		record = bulidRemitFeeReqDo(null, operator, remitId, RemitWithdrawFeeStatusEnums.REMITING);
		if (response != null) {
			record.setMtId(response.getMarginTransId());
		}
		record.setUpdateTime(new Date());
		remitFeeReqManager.updateByPrimaryKeySelective(record);
		return new ErrorMessageVO(false, "-1", "系统繁忙");
	}

	private RemitFeeReqDo bulidRemitFeeReqDo(WithdrawReqDO reqDo, String opertator, Long remitId, RemitWithdrawFeeStatusEnums eunms) {
		RemitFeeReqDo record = new RemitFeeReqDo();
		if (reqDo != null) {
			record.setRemitamount(reqDo.getWdCost().add(reqDo.getWithdrawCost()));
			record.setReqId(reqDo.getReqId());
		}
		if (StringUtils.isNotBlank(opertator)) {
			record.setOpertator(opertator);
		}
		record.setStatus(String.valueOf(eunms.code));
		if (remitId != null) record.setRemitId(remitId);
		return record;
	}
}
