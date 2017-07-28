package com.shengpay.service.hessian.merchant;

import java.lang.reflect.Method;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import net.sf.json.JSONArray;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;
import org.dozer.Mapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Service;

import com.ctc.wstx.util.DataUtil;
import com.mc.service.api.exception.TimedTaskException;
import com.sdo.common.util.DateUtil;
import com.sdp.mc.McBaseService;
import com.sdp.mc.common.constant.MerchantContractCst;
import com.sdp.mc.common.constant.MerchantCreditConstant;
import com.sdp.mc.common.enums.AlertMessageSendTypeEnum;
import com.sdp.mc.common.enums.PolicyTypeEnums;
import com.sdp.mc.common.enums.withdraw.PosMerchantStatusEnums;
import com.sdp.mc.common.exception.OpenFastSettleException;
import com.sdp.mc.common.util.ConfigOptionHelper;
import com.sdp.mc.config.manager.ConfigOptionManager;
import com.sdp.mc.crm.OpenMerchantWrapper;
import com.sdp.mc.dao.readonly.merchant.CmPosMerchantDAO;
import com.sdp.mc.integration.ma.dto.MerchantInfoMADTO;
import com.sdp.mc.ma.wrapper.MaOnlineWrapper;
import com.sdp.mc.view.dao.ViewMerchantInfoDTO;
import com.sdp.mc.view.dao.ViewMerchantInfoDTOExample;
import com.sdp.mc.view.dao.ViewPromoterInfoDTO;
import com.sdp.mc.view.dao.ViewPromoterInfoDTOExample;
import com.sdp.withdraw.api.merchant.SynMerchantInfoServiceAPI;
import com.sdp.withdraw.dao.PolicyConfigInfoDO;
import com.sdp.withdraw.dao.PosMerchantInfoDO;
import com.sdp.withdraw.dao.PosMerchantInfoDOExample;
import com.sdp.withdraw.enums.PosMerchantTypeEnums;
import com.sdp.withdraw.enums.ReturnCodeEnums;
import com.sdp.withdraw.enums.WithdrawRatioStatusEnums;
import com.sdp.withdraw.enums.WithdrawRatioTypeEnums;
import com.sdp.withdraw.vo.merchant.MerchantInfo;
import com.sdp.withdraw.vo.merchant.MerchantInfoRequest;
import com.sdp.withdraw.vo.merchant.PromoterInfo;
import com.sdp.withdraw.vo.merchant.QueryMerchantRequest;
import com.sdp.withdraw.vo.merchant.QueryMerchantResponse;
import com.sdp.withdraw.vo.merchant.QueryPromoterRequest;
import com.sdp.withdraw.vo.merchant.QueryPromoterResponse;
import com.sdp.withdraw.vo.merchant.SynMerchantRequest;
import com.sdp.withdraw.vo.merchant.SynPromoterRequest;
import com.sdp.withdraw.vo.merchant.SynResponse;
import com.sdp.withdraw.vo.ratio.WithdrawRatioRequest;
import com.sdp.withdraw.vo.ratio.WithdrawRatioResponse;
import com.shengpay.poss.merchant.crm.ws.openmerchant.service.bean.QueryPosMerchantInfoResponse;
import com.shengpay.service.alert.factory.AlertMessageSenderFactory;
import com.shengpay.service.hessian.merchant.bean.SynMerchantFailBean;
import com.shengpay.service.mail.AlertMessageSender;
import com.shengpay.service.view.MerchantInfoService;
import com.shengpay.service.view.PromoterInfoService;
import com.shengpay.service.withdraw.FwPosMerchantInfoService;
import com.shengpay.service.withdraw.PolicyConfigInfoService;
import com.shengpay.service.withdraw.T0WithdrawService;

@Service("synMerchantInfoService")
public class SynMerchantInfoServiceImpl implements SynMerchantInfoServiceAPI {
	private Logger logger = LoggerFactory.getLogger(SynMerchantInfoServiceImpl.class);

	@Autowired
	private MerchantInfoService merchantInfoService;

	@Autowired
	private PromoterInfoService promoterInfoService;

	@Autowired
	private FwPosMerchantInfoService fwPosMerchantInfoService;
	private static ExecutorService executorService = Executors.newFixedThreadPool(5);
	@Autowired
	protected Mapper beanMapper;
	@Autowired
	protected OpenMerchantWrapper openMerchantWrapper;
	@Autowired
	protected T0WithdrawService t0WithdrawService;
	@Autowired
	protected ConfigOptionManager configOptionManager;
	@Autowired
	protected AlertMessageSenderFactory alertMessageSenderFactory;
	@Autowired
	protected PosMerchantOpenFastSettleHandler posMerchantOpenFastSettleHandler;
	@Autowired
	protected MaOnlineWrapper maOnlineWrapper;
	@Autowired
	private PolicyConfigInfoService policyConfigInfoService;
	@Autowired
	private CmPosMerchantDAO cmPosMerchantDAO;
	@Autowired
	private McBaseService mcBaseService;

	@Override
	public SynResponse createOrUpdatePromoter(SynPromoterRequest promoterRequest) {
		logger.info("createOrUpdatePromoter init, Request:" + ToStringBuilder.reflectionToString(promoterRequest));
		if (promoterRequest == null) { return new SynResponse(MerchantCreditConstant.STRING_FALSE, MerchantCreditConstant.QUERY_PARAM_NOT_VALIDATA); }
		String message = vaildateSynPromoterRequest(promoterRequest);
		if (StringUtils.isNotBlank(message)) {
			logger.info("createOrUpdatePromoter vaildateSynPromoterRequest, message:" + message);
			// sendMailSyncFail(MerchantCreditConstant.SYNC_PROMOTER_FAIL_TITLE,
			// promoterRequest, message);
			return new SynResponse(MerchantCreditConstant.STRING_FALSE, message);
		}
		SynResponse response = null;
		try {
			Long parentPromoterId = null;
			if (StringUtils.isNotBlank(promoterRequest.getParentMerchantNo()) && StringUtils.isNotBlank(promoterRequest.getParentMerchantType())) {
				PosMerchantInfoDO parentinfo = fwPosMerchantInfoService.getPosMerchantInfoByMerchantInfo(promoterRequest.getParentMerchantNo(),
						promoterRequest.getParentMerchantType());
				if (parentinfo == null) {
					logger.info("createOrUpdatePromoter parentPromoter is null, promoterRequest:"
							+ ToStringBuilder.reflectionToString(promoterRequest));
					sendMailSyncFail(MerchantCreditConstant.SYNC_PROMOTER_FAIL_TITLE, promoterRequest,
							MerchantCreditConstant.SYNC_PROMOTER_FAIL_PARENT_PROMOTER_NOT_EXISTS);
					return new SynResponse(MerchantCreditConstant.STRING_FALSE, MerchantCreditConstant.SYNC_PROMOTER_FAIL_PARENT_PROMOTER_NOT_EXISTS);
				}
				parentPromoterId = parentinfo.getId();
			}
			Long mcId = promoterRequest.getMcId();
			PosMerchantInfoDO info = fwPosMerchantInfoService.getPosMerchantInfoByPosMerchantId(mcId);
			PosMerchantInfoDO data = beanMapper.map(promoterRequest, PosMerchantInfoDO.class);
			if (parentPromoterId != null) {
				data.setParentPromoterId(parentPromoterId);
			}
			if (info == null) {
				data.setCreateTime(new Date());
				Long id = fwPosMerchantInfoService.createInfo(data);
				logger.info("createOrUpdatePromoter create id:" + id);
			} else {
				PosMerchantInfoDOExample example = new PosMerchantInfoDOExample();
				example.createCriteria().andIdEqualTo(info.getId());
				data.setUpdateTime(new Date());
				int num = fwPosMerchantInfoService.updateByExample(data, example);
				logger.info("createOrUpdatePromoter update id:" + info.getId() + " 更新记录数：" + num);
			}
			response = new SynResponse(MerchantCreditConstant.STRING_TRUE, MerchantCreditConstant.SUCCESS_MESSAGE);
		} catch (Exception e) {
			logger.error("createOrUpdatePromoter is Exception", e);
			sendMailSyncFail(MerchantCreditConstant.SYNC_PROMOTER_FAIL_TITLE, promoterRequest,
					MerchantCreditConstant.ERROR_MESSAGE_EXCEPTION + e.getMessage());
			return new SynResponse(MerchantCreditConstant.STRING_FALSE, MerchantCreditConstant.ERROR_MESSAGE_EXCEPTION);
		}
		return response;
	}

	@Override
	public SynResponse createOrUpdateMerchant(SynMerchantRequest merchantRequest) {
		logger.info("createOrUpdateMerchant init, Request:" + ToStringBuilder.reflectionToString(merchantRequest));
		if (merchantRequest == null) { return new SynResponse(MerchantCreditConstant.STRING_FALSE, MerchantCreditConstant.QUERY_PARAM_NOT_VALIDATA); }
		boolean isExistsExtendInfo = isExistsExtendInfo(merchantRequest);
		String message = vaildateSynMerchantRequest(merchantRequest, isExistsExtendInfo);
		if (StringUtils.isNotBlank(message)) {
			logger.error("createOrUpdateMerchant vaildateSynMerchantRequest is Error:" + message);
			// sendMailSyncFail(MerchantCreditConstant.SYNC_MERCHANT_FAIL_TITLE,
			// merchantRequest, message);
			return new SynResponse(MerchantCreditConstant.STRING_FALSE, message);
		}
		SynResponse response = null;
		try {
			if (isExistsExtendInfo) {
				message = updateMerchantExtendInfo(merchantRequest, merchantRequest.getExtendInfo());
			} else {
				Long promoterId = merchantRequest.getPromoterId();
				PosMerchantInfoDO promoterInfo = fwPosMerchantInfoService.getPosMerchantInfoByPosMerchantId(promoterId);
				if (promoterInfo == null) {
					logger.info("createOrUpdateMerchant promoterInfo is null,promoterId:" + promoterId);
					sendMailSyncFail(MerchantCreditConstant.SYNC_MERCHANT_FAIL_TITLE, merchantRequest, ReturnCodeEnums.FW_PROMOTER_NOTFOUND.msg);
					return new SynResponse(MerchantCreditConstant.STRING_FALSE, ReturnCodeEnums.FW_PROMOTER_NOTFOUND.msg);
				}
				Long lastLevelPromoterId = null;
				if (StringUtils.isNotBlank(merchantRequest.getLastLevelPromoterNo())
						&& StringUtils.isNotBlank(merchantRequest.getLastLevelPromoterType())) {
					PosMerchantInfoDO lastLevelPromoterInfo = fwPosMerchantInfoService.getPosMerchantInfoByMerchantInfo(
							merchantRequest.getLastLevelPromoterNo(), merchantRequest.getLastLevelPromoterType());
					if (lastLevelPromoterInfo != null) {
						lastLevelPromoterId = lastLevelPromoterInfo.getId();
					} else {
						sendMailSyncFail(MerchantCreditConstant.SYNC_MERCHANT_FAIL_TITLE, merchantRequest,
								MerchantCreditConstant.SYNC_MERCHANT_FAIL_LAST_LEVEL_PROMOTER_NOT_EXISTS);
						return new SynResponse(MerchantCreditConstant.STRING_FALSE,
								MerchantCreditConstant.SYNC_MERCHANT_FAIL_LAST_LEVEL_PROMOTER_NOT_EXISTS);
					}

				}
				message = createOrUpdateMerchant(merchantRequest, promoterInfo.getId(), lastLevelPromoterId);
			}
			if (StringUtils.isBlank(message)) {
				response = new SynResponse(MerchantCreditConstant.STRING_TRUE, MerchantCreditConstant.SUCCESS_MESSAGE);
			} else {
				sendMailSyncFail(MerchantCreditConstant.SYNC_MERCHANT_FAIL_TITLE, merchantRequest, message);
				return new SynResponse(MerchantCreditConstant.STRING_FALSE, message);
			}
		} catch (Exception e) {
			logger.error("createOrUpdatePromoter is Exception", e);
			sendMailSyncFail(MerchantCreditConstant.SYNC_MERCHANT_FAIL_TITLE, merchantRequest,
					MerchantCreditConstant.ERROR_MESSAGE_EXCEPTION + e.getMessage());
			return new SynResponse(MerchantCreditConstant.STRING_FALSE, MerchantCreditConstant.ERROR_MESSAGE_EXCEPTION);
		}
		return response;
	}

	private String updateMerchantExtendInfo(SynMerchantRequest merchant, Map<String, Map<String, String>> extendInfo) {
		logger.info("updateMerchantExtendInfo init extendInfo:" + ToStringBuilder.reflectionToString(extendInfo));
		String message = null;
		String merchantNo = merchant.getMerchantNo();
		String merchantType = merchant.getMerchantType();
		try {
			if (PosMerchantTypeEnums.MPOS_MERCHANT.code.equals(merchantType) && extendInfo != null
					&& extendInfo.get(MerchantCreditConstant.SYNC_MERCHANT_EXTEND_KEY_CREDIT_AUTHENTICATION) != null) {
				// 信用认证推送
				try {
					int creditCTFCount = 0;
					if (extendInfo.get(MerchantCreditConstant.SYNC_MERCHANT_EXTEND_KEY_CREDIT_AUTHENTICATION).get("creditCTFCount") != null) {
						creditCTFCount = Integer.valueOf(extendInfo.get("creditAuthentication").get("creditCTFCount"));
					}
					logger.info("updateMerchantExtendInfo creditAuthentication ,creditCTFCount:" + creditCTFCount + " merchantNo:" + merchantNo
							+ ", merchantType:" + merchantType);
					boolean flag = ConfigOptionHelper.getBooleanByKey(MerchantContractCst.MOPS_AUTO_OPEN_FASTSETTTLE_CONFIG_FLAG);
					logger.info("buildRadioInfo MOPS_AUTO_OPEN_FASTSETTTLE_CONFIG_FLAG:{}", flag);
					if (flag) {
						this.fwPosMerchantInfoService.mposAutoOpenFastSettleAndUpdateLimit(merchantNo, merchantType, creditCTFCount);
					}
				} catch (OpenFastSettleException e) {
					message = "信用认证推送，自动开通快速结算：" + e.getMessage();
					logger.error("updateMerchantExtendInfo autoOpenFastSettleAndUpdateLimit is Exception，message：" + e.getMessage(), e);
				}
			} else if (extendInfo != null && extendInfo.get(MerchantCreditConstant.SYNC_MERCHANT_EXTEND_KEY_PMT_BIND_OPERATOR_INFO) != null) {
				// 商户操作员信息修改推送
				PosMerchantInfoDO info = fwPosMerchantInfoService.getPosMerchantInfoByMerchantInfo(merchantNo, merchantType);
				if (info != null) {
					PosMerchantInfoDO data = new PosMerchantInfoDO();
					data.setPmtBindOperatorId(extendInfo.get(MerchantCreditConstant.SYNC_MERCHANT_EXTEND_KEY_PMT_BIND_OPERATOR_INFO).get(
							"pmtBindOperatorId"));
					data.setPmtBindOperatorName(extendInfo.get(MerchantCreditConstant.SYNC_MERCHANT_EXTEND_KEY_PMT_BIND_OPERATOR_INFO).get(
							"pmtBindOperatorName"));
					PosMerchantInfoDOExample example = new PosMerchantInfoDOExample();
					example.createCriteria().andIdEqualTo(info.getId());
					data.setUpdateTime(new Date());
					logger.info("updateMerchantExtendInfo pmtBindOperatorInfo ,data:" + ToStringBuilder.reflectionToString(data) + " merchantNo:"
							+ merchantNo + ", merchantType:" + merchantType);
					fwPosMerchantInfoService.updateByExample(data, example);
				} else {
					message = "操作员信息推送，更新操作信息失败：商户信息不存在";
				}
			} else if (extendInfo != null && extendInfo.get(MerchantCreditConstant.SYNC_MERCHANT_EXTEND_KEY_CERT_INFO) != null) {
				// 商户实名信息，身份证修改推送
				message = updateCertInfo(merchant, extendInfo, merchantNo, merchantType);
			} else if (extendInfo != null && extendInfo.get(MerchantCreditConstant.SYNC_MERCHANT_EXTEND_KEY_UPDATE_MERCHANT_ATTR) != null) {
				// 更新商户属性信息
				message = updateMerchantAttr(extendInfo.get(MerchantCreditConstant.SYNC_MERCHANT_EXTEND_KEY_UPDATE_MERCHANT_ATTR), merchantNo,
						merchantType);
			}
		} catch (Exception e) {
			logger.error("updateMerchantExtendInfo is Exception，message：" + e.getMessage(), e);
		}
		if (StringUtils.isNotBlank(message)) {
			message = message + JSONArray.fromObject(extendInfo).toString();
		}
		return message;

	}

	private String updateMerchantAttr(Map<String, String> merchantAttr, String merchantNo, String merchantType) {
		logger.info("updateMerchantAttr,merchantAttr:{},merchantNo:{},merchantType:{}", new Object[] { merchantAttr, merchantNo, merchantType });
		String attrName = merchantAttr.get("attrName");
		if (StringUtils.isBlank(attrName)) { return "没有执行修改的属性信息"; }
		PosMerchantInfoDO info = fwPosMerchantInfoService.getPosMerchantInfoByMerchantInfo(merchantNo, merchantType);
		if (info == null) { return ReturnCodeEnums.FW_MERCHANT_NOTFOUND.msg; }
		String newValue = merchantAttr.get("attrValue");
		String effectiveTime = merchantAttr.get("effectiveTime");
		if ("mcc".equals(attrName)) {
			String currentValue = info.getMcc();
			return updateMerchantPolicyAttr(merchantNo, merchantType, attrName, currentValue, newValue, effectiveTime, PolicyTypeEnums.MCC.type,
					"mposMccUpdateTask", "修改MCC");
		} else if ("policyId".equals(attrName)) {// TODO 政策编码变更
			@SuppressWarnings("deprecation")
			String currentValue = cmPosMerchantDAO.queryPosMerchantPolicyIdByMcId(info.getPosMerchantId());
			return updateMerchantPolicyAttr(merchantNo, merchantType, attrName, currentValue, newValue, effectiveTime, PolicyTypeEnums.POLICY.type,
					"posPolicyUpdateTask", "修改政策");
		}

		return null;
	}

	private String updateMerchantPolicyAttr(String merchantNo, String merchantType, String attrName, String currentValue, String newValue,
			String effectiveTime, int policyType, String taskBeanName, String operationName) {
		if (currentValue != null && currentValue.equals(newValue)) { return "商户" + attrName.toUpperCase() + "没有发生变更"; }
		PolicyConfigInfoDO policyInfo = policyConfigInfoService.queryPolicyConfigInfo(policyType, newValue);
		if (policyInfo == null) { return "不存在对应的" + attrName.toUpperCase() + "配置信息"; }
		Date taskStartExecuteDate=new Date();
		if (StringUtils.isNotBlank(effectiveTime)) {
			Date effectiveDate = DateUtil.parseDateNewFormat(effectiveTime);
			if (effectiveDate == null) { return "生效日期" + effectiveTime + ",格式不正确信息"; }
			taskStartExecuteDate = DateUtil.addHours(effectiveDate, -1);
		}
		// TODO 调用形成任务的接口
		Map<String, String> executeParam = new HashMap<String, String>();
		executeParam.put("currentValue", currentValue);
		executeParam.put("newValue", newValue);
		executeParam.put("effectiveTime", effectiveTime);
		executeParam.put("merchantNo", merchantNo);
		executeParam.put("merchantType", merchantType);
		executeParam.put("operationName", operationName);
		try {
			Long taskId = mcBaseService.getTimedTaskService().createCustomizedTimedTask(taskBeanName, executeParam,
					DateUtil.getNewFormatDateString(taskStartExecuteDate), 5, 300, "", "");
			logger.info("updateMerchantAttr,createCustomizedTimedTask taskId:{}", taskId);
		} catch (TimedTaskException e) {
			logger.error("createCustomizedTimedTask  TimedTaskException:{},",
					ToStringBuilder.reflectionToString(e, ToStringStyle.SHORT_PREFIX_STYLE), e);
			return e.getErrorMessage();
		}
		return null;
	}

	private WithdrawRatioRequest getWithdrawRatioRequest(String merchantNo, String merchantType, BigDecimal holidayRatio, BigDecimal workdayRatio) {
		WithdrawRatioRequest request = new WithdrawRatioRequest(merchantNo, merchantType,
				PosMerchantTypeEnums.MPOS_MERCHANT.code.equals(merchantType) ? WithdrawRatioTypeEnums.MPOS_T0_SETTLE_RATIO.code
						: WithdrawRatioTypeEnums.POS_T0_SETTLE_RATIO.code, workdayRatio, holidayRatio);
		request.setWithDrawRatioStatus(WithdrawRatioStatusEnums.active.code);
		return request;
	}

	// 商户实名信息，身份证修改推送
	private String updateCertInfo(SynMerchantRequest merchant, Map<String, Map<String, String>> extendInfo, String merchantNo, String merchantType) {
		String message = null;
		// 商户实名信息，身份证修改推送
		PosMerchantInfoDO info = fwPosMerchantInfoService.getPosMerchantInfoByMerchantInfo(merchantNo, merchantType);
		PosMerchantInfoDO data = beanMapper.map(merchant, PosMerchantInfoDO.class);
		data.setCertType(extendInfo.get(MerchantCreditConstant.SYNC_MERCHANT_EXTEND_KEY_CERT_INFO).get("certType"));
		data.setCertNo(extendInfo.get(MerchantCreditConstant.SYNC_MERCHANT_EXTEND_KEY_CERT_INFO).get("certNo"));

		if (StringUtils.isEmpty(vaildateSynMerchantRequest(merchant, false))) {
			Long promoterId = merchant.getPromoterId();
			PosMerchantInfoDO promoterInfo = fwPosMerchantInfoService.getPosMerchantInfoByPosMerchantId(promoterId);
			if (promoterInfo == null) {
				logger.info("createOrUpdateMerchant promoterInfo is null,promoterId:" + promoterId);
				sendMailSyncFail(MerchantCreditConstant.SYNC_MERCHANT_FAIL_TITLE, merchant, ReturnCodeEnums.FW_PROMOTER_NOTFOUND.msg);
				return ReturnCodeEnums.FW_PROMOTER_NOTFOUND.msg;
			}
			Long lastLevelPromoterId = null;
			if (StringUtils.isNotBlank(merchant.getLastLevelPromoterNo()) && StringUtils.isNotBlank(merchant.getLastLevelPromoterType())) {
				PosMerchantInfoDO lastLevelPromoterInfo = fwPosMerchantInfoService.getPosMerchantInfoByMerchantInfo(
						merchant.getLastLevelPromoterNo(), merchant.getLastLevelPromoterType());
				if (lastLevelPromoterInfo != null) {
					lastLevelPromoterId = lastLevelPromoterInfo.getId();
				} else {
					sendMailSyncFail(MerchantCreditConstant.SYNC_MERCHANT_FAIL_TITLE, merchant,
							MerchantCreditConstant.SYNC_MERCHANT_FAIL_LAST_LEVEL_PROMOTER_NOT_EXISTS);
					return MerchantCreditConstant.SYNC_MERCHANT_FAIL_LAST_LEVEL_PROMOTER_NOT_EXISTS;
				}
			}
			data.setLastLevelPromoterId(lastLevelPromoterId);
			data.setParentPromoterId(promoterInfo.getId());
		}
		logger.info("updateCertInfo updateData:" + ToStringBuilder.reflectionToString(data));
		if (info != null) {
			return createOrUpdateMerchant(info, data);
		} else if (StringUtils.isEmpty(vaildateSynMerchantRequest(merchant, false))) {
			return createOrUpdateMerchant(info, data);
		} else {
			message = "证件信息推送，更新证件信息失败：商户信息不存在";
		}
		return message;
	}

	private boolean isExistsExtendInfo(SynMerchantRequest merchantRequest) {
		try {
			Map<String, Map<String, String>> extendInfo = merchantRequest.getExtendInfo();
			if (extendInfo != null) {
				logger.info("isExistsExtendInfo init extendInfo:" + ToStringBuilder.reflectionToString(extendInfo));
				// 信用认证扩展信息
				if (extendInfo.get(MerchantCreditConstant.SYNC_MERCHANT_EXTEND_KEY_CREDIT_AUTHENTICATION) != null
						|| extendInfo.get(MerchantCreditConstant.SYNC_MERCHANT_EXTEND_KEY_PMT_BIND_OPERATOR_INFO) != null
						|| extendInfo.get(MerchantCreditConstant.SYNC_MERCHANT_EXTEND_KEY_CERT_INFO) != null
						|| extendInfo.get(MerchantCreditConstant.SYNC_MERCHANT_EXTEND_KEY_UPDATE_MERCHANT_ATTR) != null) return true;
			}
		} catch (Exception e) {
			logger.error("isExistsExtendInfo Exception:", e);
		}
		return false;
	}

	private String createOrUpdateMerchant(SynMerchantRequest merchantRequest, Long parentPromoterId, Long lastLevelPromoterId) {
		logger.info("createOrUpdateMerchant init, Request:" + ToStringBuilder.reflectionToString(merchantRequest) + ",parentPromoterId:"
				+ parentPromoterId + ",lastLevelPromoterId:" + lastLevelPromoterId);

		PosMerchantInfoDO info = fwPosMerchantInfoService.getPosMerchantInfoByMerchantInfo(merchantRequest.getMerchantNo(),
				merchantRequest.getMerchantType());
		PosMerchantInfoDO data = beanMapper.map(merchantRequest, PosMerchantInfoDO.class);
		data.setLastLevelPromoterId(lastLevelPromoterId);
		data.setParentPromoterId(parentPromoterId);
		return createOrUpdateMerchant(info, data);
	}

	private String createOrUpdateMerchant(PosMerchantInfoDO info, PosMerchantInfoDO data) {
		logger.info("info:" + ToStringBuilder.reflectionToString(info) + " \n data:" + ToStringBuilder.reflectionToString(data));
		String message = null;
		if (info == null) {
			logger.info("create merchant info ");
			try {
				if (PosMerchantTypeEnums.POS_MERCHANT.code.equals(data.getMerchantType())) {// pos商户进件去查询相应的操作员信息
																							// mpos是后修改的
					QueryPosMerchantInfoResponse res = openMerchantWrapper.QueryPosMerchantInfo(data.getMerchantNo());
					if (res != null) {
						data.setPmtBindOperatorId(res.getOperator());
						data.setPmtBindOperatorName(res.getOperatorname());
					}
				}
			} catch (Exception e) {
				logger.error("createOrUpdateMerchant QueryPosMerchantInfo is Exception, MerchantNo:" + data.getMerchantNo(), e);
			}
			try {
				MerchantInfoMADTO merchantInfo = maOnlineWrapper.queryMAMerchantInfoByMerchantNo(data.getMerchantNo());
				if (merchantInfo != null) {
					String memberId = merchantInfo.getMemberId();
					data.setMerchantMemberId(memberId);
				}
			} catch (Exception e) {
				logger.error("createOrUpdateMerchant queryMemberIdByMerchantNo is Exception, MerchantNo:" + data.getMerchantNo(), e);
			}
			if (data.getStatus() == null) {
				data.setStatus(PosMerchantStatusEnums.MC_STATUS_ACTIVE.code);
			}
			if (data.getPosMerchantId() == null) {
				data.setPosMerchantId(Long.parseLong(data.getMerchantNo() + data.getMerchantType()));
			}
			data.setCreateTime(new Date());
			try {
				Long id = fwPosMerchantInfoService.createInfo(data);
				message = buildRadioInfo(data);
				logger.info("createOrUpdateMerchant create id:" + id);
			} catch (DuplicateKeyException e) {
				logger.error("createOrUpdateMerchant DuplicateKeyException, merchantInfo is not unique", e);
				return "商户信息已经存在，不能重复创建";
			}
		} else {
			logger.info("update merchant info ");
			PosMerchantInfoDOExample example = new PosMerchantInfoDOExample();
			example.createCriteria().andIdEqualTo(info.getId());
			data.setUpdateTime(new Date());
			int num = fwPosMerchantInfoService.updateByExample(data, example);
			if (PosMerchantTypeEnums.POS_MERCHANT.code.equals(info.getMerchantType()) && StringUtils.isNotBlank(data.getCertNo())) {
				// 政策ＩＤ暂时没有同步传输
				posMerchantOpenFastSettleHandler.execute(data.getPosMerchantId() == null ? info.getPosMerchantId() : data.getPosMerchantId(), null);
			}else if(PosMerchantTypeEnums.EASYPAY_MERCHANT.code.equals(info.getMerchantType()) && StringUtils.isNotBlank(data.getMcc())){
				message = buildRadioInfo(data);
			}
			logger.info("createOrUpdateMerchant update id:" + info.getId() + " 更新记录数：" + num);
		}
		return message;
	}

	private String buildRadioInfo(PosMerchantInfoDO info) {
		logger.info("buildRadioInfo info:" + ToStringBuilder.reflectionToString(info));
		if (info == null) { return "待处理商户信息不能为空"; }
		if (PosMerchantTypeEnums.MPOS_MERCHANT.code.equals(info.getMerchantType())) {// 暂时只处理mpos商户的状态信息
			WithdrawRatioResponse response = t0WithdrawService.getWithdrawRatioService().createT1andD1Ratio(info.getMerchantNo(),
					info.getMerchantType());
			logger.info("buildRadioInfo call createT1andD1Ratio,response:" + ToStringBuilder.reflectionToString(response));
			if (!ReturnCodeEnums.FW_SUCCESS.code.equals(response.getErrorCode())) { return response.getErrorMsg(); }
			try {
				boolean flag = ConfigOptionHelper.getBooleanByKey(MerchantContractCst.MOPS_AUTO_OPEN_FASTSETTTLE_CONFIG_FLAG);
				logger.info("buildRadioInfo MOPS_AUTO_OPEN_FASTSETTTLE_CONFIG_FLAG:{}", flag);
				if (flag) {
					this.fwPosMerchantInfoService.mposAutoOpenFastSettleAndUpdateLimit(info.getMerchantNo(), info.getMerchantType(), 0);
					logger.info("buildRadioInfo call autoOpenFastSettleAndUpdateLimit success");
				} else {
					logger.info("buildRadioInfo MOPS_AUTO_OPEN_FASTSETTTLE_CONFIG_FLAG is false");
				}
			} catch (OpenFastSettleException e) {
				logger.error("buildRadioInfo call autoOpenFastSettleAndUpdateLimit  OpenFastSettleException,response:" + e.getMessage());
				return "开通T0发生错误：" + e.getMessage();
			} catch (Exception e) {
				logger.error("buildRadioInfo call autoOpenFastSettleAndUpdateLimit  Exception,response:" + e.getMessage(), e);
				return "开通T0发生异常：" + e.getMessage();
			}
		} else if (PosMerchantTypeEnums.POS_MERCHANT.code.equals(info.getMerchantType())) {
			// 政策ＩＤ暂时没有同步传输
			posMerchantOpenFastSettleHandler.execute(info.getPosMerchantId(), null);
		} else if (PosMerchantTypeEnums.EASYPAY_MERCHANT.code.equals(info.getMerchantType())) {
			// 政策ＩＤ暂时没有同步传输
			if(StringUtils.isNotBlank(info.getMcc())){
				PolicyConfigInfoDO policyInfo=policyConfigInfoService.queryPolicyConfigInfo(PolicyTypeEnums.EASYPAY.type, info.getMcc());
				if(policyInfo!=null){
					try {
						this.fwPosMerchantInfoService.easypayAutoOpenFastSettleAndUpdateLimit(info.getMerchantNo(), info.getMerchantType(), policyInfo);
						logger.info("buildRadioInfo call autoOpenFastSettleAndUpdateLimit success");
					} catch (OpenFastSettleException e) {
						logger.error("buildRadioInfo call autoOpenFastSettleAndUpdateLimit  OpenFastSettleException,response:" + e.getMessage());
						return "开通T0发生错误：" + e.getMessage();
					} catch (Exception e) {
						logger.error("buildRadioInfo call autoOpenFastSettleAndUpdateLimit  Exception,response:" + e.getMessage(), e);
						return "开通T0发生异常：" + e.getMessage();
					}
				}else{
					logger.info("buildRadioInfo,policyInfo is null, not deal with,");
				}
			}else{
				logger.info("buildRadioInfo,mcc value is null, not deal with,");
			}
		} else {
			logger.info("buildRadioInfo not deal with,merchantType:{}", info.getMerchantType());
		}
		return null;
	}

	@Override
	public SynResponse batchUpdatePromoter(List<SynMerchantRequest> merchantRequests) {
		logger.info("batchUpdatePromoter init, Request:" + ToStringBuilder.reflectionToString(merchantRequests));
		if (merchantRequests == null || merchantRequests.isEmpty()) { return new SynResponse(MerchantCreditConstant.STRING_FALSE,
				MerchantCreditConstant.QUERY_PARAM_NOT_VALIDATA); }
		SynResponse response = null;
		try {
			int successNum = 0;
			int failNum = 0;
			int num = 0;
			StringBuffer buffer = new StringBuffer();
			Map<Long, Long> promoterIdMap = new HashMap<Long, Long>();
			Map<String, Long> lastLevelPromoterMap = new HashMap<String, Long>();
			List<SynMerchantFailBean> failList = new ArrayList<SynMerchantFailBean>();
			for (SynMerchantRequest merchant : merchantRequests) {
				logger.info("batchUpdatePromoter merchant:" + ToStringBuilder.reflectionToString(merchant));
				num++;
				String message = null;
				if (merchant != null) {
					boolean isExistsExtendInfo = isExistsExtendInfo(merchant);
					message = vaildateSynMerchantRequest(merchant, isExistsExtendInfo);
					if (StringUtils.isBlank(message)) {
						if (isExistsExtendInfo) {
							message = updateMerchantExtendInfo(merchant, merchant.getExtendInfo());
						} else {
							Long promoterId = merchant.getPromoterId();
							Long promoterBizId = promoterIdMap.get(promoterId);
							if (promoterBizId == null) {
								PosMerchantInfoDO promoterInfo = fwPosMerchantInfoService.getPosMerchantInfoByPosMerchantId(promoterId);
								if (promoterInfo == null) {
									message = MerchantCreditConstant.SYNC_MERCHANT_FAIL_PARENT_PROMOTER_NOT_EXISTS;
									logger.info("createOrUpdateMerchant promoterInfo is null,promoterId:" + promoterId);
								} else {
									promoterBizId = promoterInfo.getId();
									promoterIdMap.put(promoterId, promoterBizId);
								}
							}
							if (promoterBizId != null) {
								Long lastLevelPromoterId = lastLevelPromoterMap.get(merchant.getLastLevelPromoterNo()
										+ merchant.getLastLevelPromoterType());
								if (StringUtils.isNotBlank(merchant.getLastLevelPromoterNo())
										&& StringUtils.isNotBlank(merchant.getLastLevelPromoterType()) && lastLevelPromoterId == null) {
									PosMerchantInfoDO lastLevelPromoterInfo = fwPosMerchantInfoService.getPosMerchantInfoByMerchantInfo(
											merchant.getLastLevelPromoterNo(), merchant.getLastLevelPromoterType());
									if (lastLevelPromoterInfo != null) {
										lastLevelPromoterId = lastLevelPromoterInfo.getId();
										lastLevelPromoterMap.put(merchant.getLastLevelPromoterNo() + merchant.getLastLevelPromoterType(),
												lastLevelPromoterId);
									} else {
										message = MerchantCreditConstant.SYNC_MERCHANT_FAIL_LAST_LEVEL_PROMOTER_NOT_EXISTS;
									}
								}
								try {
									if (StringUtils.isBlank(message)) {
										message = createOrUpdateMerchant(merchant, promoterBizId, lastLevelPromoterId);
									}
								} catch (Exception e) {
									message = MerchantCreditConstant.ERROR_MESSAGE_EXCEPTION + e.getMessage();
									logger.error("batchUpdatePromoter createOrUpdateMerchant is Exception:" + e.getMessage(), e);
								}
							}
						}
					} else {
						logger.error("batchUpdatePromoter vaildateSynMerchantRequest is Error:" + message);
					}
				}
				if (StringUtils.isBlank(message)) {
					successNum++;
					continue;
				}
				if (message != null) {
					failList.add(new SynMerchantFailBean(message, merchant));
				}
				failNum++;
			}
			buffer.append("更新总数量：" + num + ",成功数量：" + successNum + ",失败数量：" + failNum);
			response = new SynResponse(MerchantCreditConstant.STRING_TRUE, buffer.toString());
			logger.info("batchUpdatePromoter end, result:" + buffer.toString() + ",failList size:" + failList.size());
			if (!failList.isEmpty()) {
				sendMailSyncFail(MerchantCreditConstant.BATCH_SYNC_MERCHANT_FAIL_TITLE, failList, null);
			}
		} catch (Exception e) {
			logger.error("createOrUpdatePromoter is Exception", e);
			sendMailSyncFail(MerchantCreditConstant.BATCH_SYNC_MERCHANT_FAIL_TITLE, null,
					MerchantCreditConstant.ERROR_MESSAGE_EXCEPTION + e.getMessage());
			return new SynResponse(MerchantCreditConstant.STRING_FALSE, MerchantCreditConstant.ERROR_MESSAGE_EXCEPTION);
		}
		return response;
	}

	@Override
	public QueryMerchantResponse queryMerchantInfo(QueryMerchantRequest request) {
		logger.info("queryMerchantInfo init, Request:" + ToStringBuilder.reflectionToString(request));
		QueryMerchantResponse response = null;
		try {
			List<MerchantInfo> merchantInfos = new ArrayList<MerchantInfo>();
			ViewMerchantInfoDTOExample example = new ViewMerchantInfoDTOExample();
			if (request != null && (request.getMcId() != null || StringUtils.isNotBlank(request.getMerchantNo()))) {
				if (StringUtils.isNotBlank(request.getMerchantNo())) {
					example.setMerchantNo(request.getMerchantNo());
				}
				if (StringUtils.isNotBlank(request.getMerchantName())) {
					example.setMerchantName(request.getMerchantName());
				}
				if (StringUtils.isNotBlank(request.getMerchantType())) {
					example.setMcType(request.getMerchantType());
				}
				if (request.getMcId() != null) {
					example.setMerchantId(request.getMcId());
				}
				if (request.getFastSettleFlag() != null) {
					example.setMerchantFsFlag(request.getFastSettleFlag());
				}
				if (request.getAutoFastSettleFlag() != null) {
					example.setAutoFastSettleFlag(request.getAutoFastSettleFlag());
				}
				List<ViewMerchantInfoDTO> list = this.merchantInfoService.selectByExample(example);
				if (list != null) {
					for (ViewMerchantInfoDTO dto : list) {
						merchantInfos.add(beanMapper.map(dto, MerchantInfo.class));
					}
				}
			} else {
				return new QueryMerchantResponse(MerchantCreditConstant.STRING_FALSE, MerchantCreditConstant.QUERY_PARAM_NOT_VALIDATA);
			}

			response = new QueryMerchantResponse(MerchantCreditConstant.STRING_TRUE, MerchantCreditConstant.SUCCESS_MESSAGE);
			response.setMerchantInfos(merchantInfos);
		} catch (Exception e) {
			logger.error("queryMerchantInfo is Exception", e);
			sendMailSyncFail(MerchantCreditConstant.BATCH_SYNC_MERCHANT_FAIL_TITLE, null,
					MerchantCreditConstant.ERROR_MESSAGE_EXCEPTION + e.getMessage());
			return new QueryMerchantResponse(MerchantCreditConstant.STRING_FALSE, MerchantCreditConstant.ERROR_MESSAGE_EXCEPTION);
		}
		return response;
	}

	@Override
	public QueryPromoterResponse queryPromoterInfo(QueryPromoterRequest request) {
		logger.info("queryPromoterInfo init, Request:" + ToStringBuilder.reflectionToString(request));
		QueryPromoterResponse response = null;
		try {
			List<PromoterInfo> promoterInfos = new ArrayList<PromoterInfo>();
			ViewPromoterInfoDTOExample example = new ViewPromoterInfoDTOExample();
			if (request != null && (request.getMcId() != null || StringUtils.isNotBlank(request.getMerchantNo()))) {
				if (StringUtils.isNotBlank(request.getMerchantNo())) {
					example.setPromoterMerchantNo(request.getMerchantNo());
				}
				if (StringUtils.isNotBlank(request.getMerchantName())) {
					example.setPromoterName(request.getMerchantName());
				}
				if (StringUtils.isNotBlank(request.getMerchantType())) {
					example.setPromoterType(request.getMerchantType());
				}
				if (request.getMcId() != null) {
					example.setPromoterId(request.getMcId());
				}
				List<ViewPromoterInfoDTO> list = this.promoterInfoService.selectByExample(example);
				if (list != null) {
					for (ViewPromoterInfoDTO dto : list) {
						promoterInfos.add(beanMapper.map(dto, PromoterInfo.class));
					}
				}
			} else {
				return new QueryPromoterResponse(MerchantCreditConstant.STRING_FALSE, MerchantCreditConstant.QUERY_PARAM_NOT_VALIDATA);
			}

			response = new QueryPromoterResponse(MerchantCreditConstant.STRING_TRUE, MerchantCreditConstant.SUCCESS_MESSAGE);
			response.setPromoterInfos(promoterInfos);
		} catch (Exception e) {
			logger.error("queryMerchantInfo is Exception", e);
			return new QueryPromoterResponse(MerchantCreditConstant.STRING_FALSE, MerchantCreditConstant.ERROR_MESSAGE_EXCEPTION);
		}
		return response;
	}

	private String vaildateSynMerchantRequest(SynMerchantRequest merchantRequest, boolean isExistsExtendInfo) {
		Map<String, String> vaildateRequiredMap = new HashMap<String, String>();
		// vaildateRequiredMap.put("mcId", "合同ID ");
		vaildateRequiredMap.put("merchantNo", "商户号");
		vaildateRequiredMap.put("merchantType", "商户类型");
		if (!isExistsExtendInfo) {
			vaildateRequiredMap.put("merchantName", "商户名称");
			vaildateRequiredMap.put("status", "状态");
			vaildateRequiredMap.put("mcc", "MCC");
			vaildateRequiredMap.put("promoterId", "代理商ID");
		}
		String message = vaildateServiceRequestRequired(merchantRequest, vaildateRequiredMap);
		if (message == null
				&& !(PosMerchantTypeEnums.MPOS_MERCHANT.code.equals(merchantRequest.getMerchantType()) || PosMerchantTypeEnums.POS_MERCHANT.code
						.equals(merchantRequest.getMerchantType()))) {
			message = ReturnCodeEnums.FW_DATA_FORMAT_VALIDATION_FAILS.msg + ":商户类型有误";
		}
		return message;
	}

	private String vaildateMerchantInfoRequest(MerchantInfoRequest merchantRequest) {
		Map<String, String> vaildateRequiredMap = new HashMap<String, String>();
		vaildateRequiredMap.put("merchantNo", "商户号");
		vaildateRequiredMap.put("merchantType", "商户类型");
		vaildateRequiredMap.put("merchantName", "商户名称");
		vaildateRequiredMap.put("promoterNo", "代理商号");
		vaildateRequiredMap.put("promoterType", "代理商类型");
		vaildateRequiredMap.put("certType", "证件类型");
		vaildateRequiredMap.put("certNo", "证件号码");

		String message = vaildateServiceRequestRequired(merchantRequest, vaildateRequiredMap);
		if (message == null
				&& !(PosMerchantTypeEnums.MPOS_MERCHANT.code.equals(merchantRequest.getMerchantType())
						|| PosMerchantTypeEnums.POS_MERCHANT.code.equals(merchantRequest.getMerchantType()) || PosMerchantTypeEnums.EASYPAY_MERCHANT.code
							.equals(merchantRequest.getMerchantType()))) {
			message = ReturnCodeEnums.FW_DATA_FORMAT_VALIDATION_FAILS.msg + ":商户类型有误";
		}
		return message;
	}

	private String vaildateSynPromoterRequest(SynPromoterRequest promoterRequest) {
		Map<String, String> vaildateRequiredMap = new HashMap<String, String>();
		vaildateRequiredMap.put("mcId", "合同ID ");
		vaildateRequiredMap.put("merchantNo", "代理商户号");
		vaildateRequiredMap.put("merchantType", "代理类型");
		vaildateRequiredMap.put("merchantName", "代理名称");
		vaildateRequiredMap.put("status", "状态");
		String message = vaildateServiceRequestRequired(promoterRequest, vaildateRequiredMap);
		if (message == null
				&& !(PosMerchantTypeEnums.MPOS_PROMOTER.code.equals(promoterRequest.getMerchantType())
						|| PosMerchantTypeEnums.POS_PROMOTER.code.equals(promoterRequest.getMerchantType()) || PosMerchantTypeEnums.MPOS_SECOND_LEVEL_PROMOTER.code
							.equals(promoterRequest.getMerchantType()))) {
			message = ReturnCodeEnums.FW_DATA_FORMAT_VALIDATION_FAILS.msg + ":代理类型有误";
		}
		return message;
	}

	private String vaildateServiceRequestRequired(Object request, Map<String, String> vaildateRequiredMap) {
		String message = null;
		if (request != null) {
			if (vaildateRequiredMap != null) {
				for (Iterator<String> it = vaildateRequiredMap.keySet().iterator(); it.hasNext();) {
					String key = it.next();
					Object obj = getObjectFieldName(request, key);
					if (obj == null || StringUtils.isBlank(obj.toString())) {
						message = ReturnCodeEnums.FW_DATA_FORMAT_VALIDATION_FAILS.msg + vaildateRequiredMap.get(key) + " is NULL";
						logger.info("WithdrawT0ServiceServiceImpl #vaildateWithdrawServiceRequestDTO:" + message);
						return message;
					}
				}
			}
		} else {
			message = ReturnCodeEnums.FW_DATA_FORMAT_VALIDATION_FAILS.msg + "请求数据NULL";
			logger.info("WithdrawT0ServiceServiceImpl #vaildateWithdrawServiceRequestDTO:" + message);
		}

		return message;
	}

	public Object getObjectFieldName(Object object, String fieldName) {
		// 获得对象类型
		try {
			Class classType = object.getClass();
			String firstLetter = fieldName.substring(0, 1).toUpperCase(); // 获得和属性对应的getXXX()方法的名字
			String getMethodName = "get" + firstLetter + fieldName.substring(1); // 获得和属性对应的getXXX()方法的名字
			Method getMethod = classType.getMethod(getMethodName, new Class[] {}); // 获得和属性对应的getXXX()方法
			if (getMethod != null) { return getMethod.invoke(object, new Object[] {});

			}
		} catch (Exception e) {

		}
		return null;
	}

	private void sendMailSyncFail(String title, Object request, String message) {
		try {
			if (request == null) {
				sendMail(title, message);
				return;
			}
			StringBuffer buff = new StringBuffer();
			buff.append("<table width='90%' style='border:solid 1px #a60007;' >");
			buff.append(getMailTableTh());
			if (request instanceof SynPromoterRequest) {
				SynPromoterRequest promoterRequest = (SynPromoterRequest) request;
				buff.append(getMailTableData(promoterRequest.getMcId(), promoterRequest.getMerchantNo(), promoterRequest.getMerchantName(),
						promoterRequest.getMerchantType(), message));
			} else if (request instanceof SynMerchantRequest) {
				SynMerchantRequest merchantRequest = (SynMerchantRequest) request;
				buff.append(getMailTableData(merchantRequest.getMcId(), merchantRequest.getMerchantNo(), merchantRequest.getMerchantName(),
						merchantRequest.getMerchantType(), message));
			} else if (request instanceof List) {
				List<SynMerchantFailBean> list = (List) request;
				if (!list.isEmpty()) {
					for (SynMerchantFailBean bean : list) {
						SynMerchantRequest merchantRequest = bean.getSynMerchantRequest();
						buff.append(getMailTableData(merchantRequest.getMcId(), merchantRequest.getMerchantNo(), merchantRequest.getMerchantName(),
								merchantRequest.getMerchantType(), bean.getMessage()));
					}
				}
			}
			buff.append("</table> ");
			sendMail(title, buff.toString());
		} catch (Exception e) {
			logger.error("sendMailSyncFail is Exception,request" + ToStringBuilder.reflectionToString(request), e);
		}

	}

	private String getMailTableTh() {
		StringBuffer sbContext = new StringBuffer();
		sbContext.append("<tr> ");
		sbContext.append("<th width='20%'>合同ID</th>");
		sbContext.append("<th width='20%'>商户号</th>");
		sbContext.append("<th width='20%'>商户名称</th>");
		sbContext.append("<th width='20%'>商户类型</th>");
		sbContext.append("<th width='20%'>失败原因</th>");
		sbContext.append("</tr>");
		return sbContext.toString();
	}

	private String getMailTableData(Long mcId, String mcerchantNo, String mcerchantName, String mcerchantType, String message) {
		StringBuffer sbContext = new StringBuffer();
		sbContext.append("<tr> ");
		sbContext.append("<td>" + mcId + "</th>");
		sbContext.append("<td>" + mcerchantNo + "</td>");
		sbContext.append("<td>" + mcerchantName + "</td>");
		sbContext.append("<td>"
				+ (PosMerchantTypeEnums.getMerchantTypeByCode(mcerchantType) == null ? mcerchantType : PosMerchantTypeEnums
						.getMerchantTypeByCode(mcerchantType).desc) + "</td>");
		sbContext.append("<td>" + message + "</td>");
		sbContext.append("</tr>");
		return sbContext.toString();
	}

	private void sendMail(final String title, final String content) {
		logger.info("MarginOpServiceImpl.addMargin.sendMail title=" + title + "content=" + content);
		final String mailList = ConfigOptionHelper.getConfigByKey(MerchantCreditConstant.T0_QUOTA_OP_ERROR_MAIL_LIST);
		if (StringUtils.isBlank(mailList)) {
			logger.error("MarginOpServiceImpl.addMargin.sendMail.error,mail list is not configured");
			return;
		}
		Thread t = new Thread() {
			public void run() {
				try {
					AlertMessageSender sender = alertMessageSenderFactory.getAlertMessageSender(AlertMessageSendTypeEnum.MAIL_ALERT);
					sender.sendHtmlMessage(title, content, mailList);
				} catch (Exception e) {
					logger.error("MarginOpServiceImpl.addMargin.sendMail.error,content=" + content, e);
				}
			}
		};
		executorService.execute(t);
	}

	@Override
	public SynResponse synchMerchantInfo(MerchantInfoRequest merchantInfoRequest) {

		logger.info("synchMerchantInfo init, Request:" + ToStringBuilder.reflectionToString(merchantInfoRequest));
		if (merchantInfoRequest == null) { return new SynResponse(MerchantCreditConstant.STRING_FALSE,
				MerchantCreditConstant.QUERY_PARAM_NOT_VALIDATA); }
		String message = vaildateMerchantInfoRequest(merchantInfoRequest);
		if (StringUtils.isNotBlank(message)) {
			logger.error("synchMerchantInfo vaildateMerchantInfoRequest is Error:" + message);
			// sendMailSyncFail(MerchantCreditConstant.SYNC_MERCHANT_FAIL_TITLE,
			// merchantInfoRequest, message);
			return new SynResponse(MerchantCreditConstant.STRING_FALSE, message);
		}
		SynResponse response = null;
		try {
			PosMerchantInfoDO promoterInfo = fwPosMerchantInfoService.getPosMerchantInfoByMerchantInfo(merchantInfoRequest.getPromoterNo(),
					merchantInfoRequest.getPromoterType());
			try {
				if (promoterInfo == null) {
					promoterInfo = buildPromoterInfoByMerchantInfoRequest(merchantInfoRequest);
					if (promoterInfo == null) { throw new RuntimeException(); }
					fwPosMerchantInfoService.createInfo(promoterInfo);
				}
			} catch (Exception e) {
				promoterInfo = fwPosMerchantInfoService.getPosMerchantInfoByMerchantInfo(merchantInfoRequest.getPromoterNo(),
						merchantInfoRequest.getPromoterType());
				if (promoterInfo == null) {
					logger.info("synchMerchantInfo promoterInfo is null, Request:" + ToStringBuilder.reflectionToString(merchantInfoRequest));
					sendMailSyncFail(MerchantCreditConstant.SYNC_MERCHANT_FAIL_TITLE, merchantInfoRequest, ReturnCodeEnums.FW_PROMOTER_NOTFOUND.msg);
					return new SynResponse(MerchantCreditConstant.STRING_FALSE, ReturnCodeEnums.FW_PROMOTER_NOTFOUND.msg);
				}
			}

			Long lastLevelPromoterId = null;
			if (StringUtils.isNotBlank(merchantInfoRequest.getLastLevelPromoterNo())
					&& StringUtils.isNotBlank(merchantInfoRequest.getLastLevelPromoterType())) {
				PosMerchantInfoDO lastLevelPromoterInfo = fwPosMerchantInfoService.getPosMerchantInfoByMerchantInfo(
						merchantInfoRequest.getLastLevelPromoterNo(), merchantInfoRequest.getLastLevelPromoterType());
				if (lastLevelPromoterInfo != null) {
					lastLevelPromoterId = lastLevelPromoterInfo.getId();
				} else {
					sendMailSyncFail(MerchantCreditConstant.SYNC_MERCHANT_FAIL_TITLE, merchantInfoRequest,
							MerchantCreditConstant.SYNC_MERCHANT_FAIL_LAST_LEVEL_PROMOTER_NOT_EXISTS);
					return new SynResponse(MerchantCreditConstant.STRING_FALSE,
							MerchantCreditConstant.SYNC_MERCHANT_FAIL_LAST_LEVEL_PROMOTER_NOT_EXISTS);
				}
			}

			PosMerchantInfoDO info = fwPosMerchantInfoService.getPosMerchantInfoByMerchantInfo(merchantInfoRequest.getMerchantNo(),
					merchantInfoRequest.getMerchantType());
			PosMerchantInfoDO data = beanMapper.map(merchantInfoRequest, PosMerchantInfoDO.class);
			data.setLastLevelPromoterId(lastLevelPromoterId);
			data.setParentPromoterId(promoterInfo.getId());

			message = createOrUpdateMerchant(info, data);
			if (StringUtils.isBlank(message)) {
				response = new SynResponse(MerchantCreditConstant.STRING_TRUE, MerchantCreditConstant.SUCCESS_MESSAGE);
			} else {
				sendMailSyncFail(MerchantCreditConstant.SYNC_MERCHANT_FAIL_TITLE, merchantInfoRequest, message);
				return new SynResponse(MerchantCreditConstant.STRING_FALSE, message);
			}
		} catch (Exception e) {
			logger.error("synchMerchantInfo is Exception", e);
			sendMailSyncFail(MerchantCreditConstant.SYNC_MERCHANT_FAIL_TITLE, merchantInfoRequest,
					MerchantCreditConstant.ERROR_MESSAGE_EXCEPTION + e.getMessage());
			return new SynResponse(MerchantCreditConstant.STRING_FALSE, MerchantCreditConstant.ERROR_MESSAGE_EXCEPTION);
		}
		return response;
	}

	private PosMerchantInfoDO buildPromoterInfoByMerchantInfoRequest(MerchantInfoRequest merchantInfoRequest) {
		PosMerchantInfoDO info = new PosMerchantInfoDO();
		info.setMerchantType(merchantInfoRequest.getPromoterType());
		info.setMerchantNo(merchantInfoRequest.getPromoterNo());
		info.setStatus(PosMerchantStatusEnums.MC_STATUS_ACTIVE.code);
		info.setCreateTime(new Date());
		info.setUpdateTime(new Date());
		MerchantInfoMADTO merchantInfo = maOnlineWrapper.queryMAMerchantInfoByMerchantNo(merchantInfoRequest.getPromoterNo());
		if (merchantInfo != null) {
			info.setPosMerchantId(Long.parseLong(merchantInfoRequest.getPromoterNo() + merchantInfoRequest.getPromoterType()));
			info.setMerchantMemberId(merchantInfo.getMemberId());
			info.setMerchantName(merchantInfo.getMerchantName());
			return info;
		}
		return null;
	}

}
