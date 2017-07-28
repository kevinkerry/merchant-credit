package com.sdp.mc.service.op.state.margin;

import java.math.BigDecimal;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.TransactionCallback;
import org.springframework.transaction.support.TransactionTemplate;

import com.sdo.common.util.DateUtil;
import com.sdp.mc.common.constant.MerchantCreditConstant;
import com.sdp.mc.common.enums.AuditInfoStateEnum;
import com.sdp.mc.common.enums.FsConfigChangeStatusEnum;
import com.sdp.mc.common.enums.LoaningTypeEnum;
import com.sdp.mc.common.enums.MarginOpAddEnums;
import com.sdp.mc.common.enums.MarginOpRedeemEnums;
import com.sdp.mc.common.enums.MessageTemplateCodeEnum;
import com.sdp.mc.common.enums.OpObjTypeEnums;
import com.sdp.mc.common.enums.OpTypeEnums;
import com.sdp.mc.common.exception.FastSettleLimitException;
import com.sdp.mc.common.model.AuditInfoRequestLog;
import com.sdp.mc.common.vo.ErrorMessageVO;
import com.sdp.mc.ffconfig.manager.FastSettleConfigManager;
import com.sdp.mc.integration.msp.PromoterInfoDTO;
import com.sdp.mc.integration.msp.request.MspModifyRequest;
import com.sdp.mc.margin.dao.MarginOpReqDO;
import com.sdp.mc.margin.dao.MarginOpReqDOExample;
import com.sdp.mc.msp.dao.FsConfigChangeDO;
import com.sdp.mc.newt0.dao.AuditInfoDTO;
import com.sdp.mc.newt0.dao.Newt0PromoterDO;
import com.sdp.mc.newt0.dao.Newt0PromoterDOExample;
import com.sdp.mc.service.AuditInfoService;
import com.sdp.mc.service.fastsettle.margin.MarginOpService;
import com.sdp.mc.service.newt0.Newt0PromoterService;
import com.sdp.mc.service.op.state.BaseOpState;
import com.sdp.mc.service.op.state.OpContext;
import com.sdp.mc.service.op.state.OpState;
import com.sdp.mc.service.op.state.OpStateResponse;

@Service("OpTransferSuccessState")
public class OpTransferSuccessState extends BaseOpState implements OpState {

	private static final Logger log = LoggerFactory.getLogger(OpTransferSuccessState.class);

	@Autowired
	private Newt0PromoterService newt0PromoterService;
	@Autowired
	private AuditInfoService auditInfoService;
	@Resource(name = "mc_transactionTemplate")
	private TransactionTemplate transactionTemplate;
	@Autowired
	private FastSettleConfigManager fastSettleConfigManager;
	@Autowired
	private MarginOpService marginOpService;

	@SuppressWarnings("unused")
	@Override
	public int handlerOpState(OpContext context, String operatorId) {
		long morId = context.getBizId();

		int opType = context.getOpType();
		if (opType == OpTypeEnums.ADD.getCode()) {
			// TODO:insert 更配置流水记录
			long fcmId = 0l;
			try {
				fcmId = mspFacade.createFsconfigChange(context.getMspModifyRequest(), operatorId);
			} catch (FastSettleLimitException e) {
				return OpState.failure;
			}
			modifyMarginOpReqFcmIdHis(morId, fcmId);
			// TODO:调用MSP更改配置接口
			ErrorMessageVO<Object> responseDTO = mspFacade.modifyFastSettleConfig2Msp(context.getMspModifyRequest(), fcmId);
			context.setOpStateResponse(new OpStateResponse(responseDTO.isSuccess(), responseDTO.getErrorCode(), responseDTO.getErrorMessage()));
			// TODO:返回更新配置流水记录,更新追加请求状态
			if (responseDTO.isSuccess()) {
				FsConfigChangeDO fsConfigChangeDO = fsConfigChangeManager.selectByPrimaryKey(fcmId);
				fsConfigChangeDO.setUpdateTime(new Date());
				fsConfigChangeDO.setStatus(FsConfigChangeStatusEnum.SUCCESS.code);
				int rows = fsConfigChangeManager.updateByPrimaryKeySelective(fsConfigChangeDO);
				modifyMarginOpReqStatus(morId, MarginOpAddEnums.CONFIGURE_SUCCESS.code, MarginOpAddEnums.TRANSFER_SUCCESS.code);
				// 发送短信
				Map<String, String> map = new HashMap<String, String>();
				map.put("fastSettleLimit", context.getMspModifyRequest().getFastSettleLimit());
				map.put("date", DateUtil.getWebDateString(new Date()));
				marginOpService.sendMessage(context.getPromoterId(), MessageTemplateCodeEnum.AUDIT_ADDMARGIN_SUCCESS.getKey(), map);
				return OpState.success;
			} else {
				FsConfigChangeDO fsConfigChangeDO = fsConfigChangeManager.selectByPrimaryKey(fcmId);
				fsConfigChangeDO.setUpdateTime(new Date());
				fsConfigChangeDO.setStatus(FsConfigChangeStatusEnum.FAILUE.code);
				int rows = fsConfigChangeManager.updateByPrimaryKeySelective(fsConfigChangeDO);
				modifyMarginOpReqStatus(morId, MarginOpAddEnums.CONFIGURE_FAILURE.code, MarginOpAddEnums.TRANSFER_SUCCESS.code);
				return OpState.failure;
			}
		} else if (opType == OpTypeEnums.REDEEMED.getCode()) {
			// long morId = context.getBizId();
			MarginOpReqDO marginOpReqDO = marginOpReqManager.selectByPrimaryKey(morId);
			marginOpReqDO.setStatus(MarginOpRedeemEnums.TRANSFER_SUCCESS.code);
			marginOpReqDO.setUpdateTime(new Date());
			MarginOpReqDOExample example = new MarginOpReqDOExample();
			example.createCriteria().andMorIdEqualTo(morId).andStatusEqualTo(MarginOpRedeemEnums.CONFIGURE_SUCCESS.code);
			marginOpReqManager.updateByExampleSelective(marginOpReqDO, example);
			context.setOpStateResponse(new OpStateResponse(true, null, "退款完成."));
			return OpState.success;

		}
		return OpState.failure;
	}

	@Override
	public int changeState(OpContext context, int handlerOpStatus) {
		int opType = context.getOpType();
		if (opType == OpTypeEnums.ADD.getCode() && OpState.success == handlerOpStatus)
			return MarginOpAddEnums.CONFIGURE_SUCCESS.getCode();
		else if (opType == OpTypeEnums.ADD.getCode() && OpState.failure == handlerOpStatus) return MarginOpAddEnums.CONFIGURE_FAILURE.getCode();
		return 0;
	}

	public ErrorMessageVO<Object> batchHandlerOpState(OpContext context, String operator, String operatorId) {

		// 查询所有转账成功的追加保证金的记录
		List<MarginOpReqDO> list = this.queryMarginOpReq(context.getPromoterId(), OpTypeEnums.ADD.code, MarginOpAddEnums.TRANSFER_SUCCESS.code);
		// if (list == null || list.size() == 0) {
		// return new ErrorMessageVO(false, null, "没有追加保证金成功记录");
		// }

		// 构建msp接口请求参数
		MspModifyRequest mspModifyRequest = this.buildMspModifyRequest(context, list);

		// insert配置流水记录,更新转账成功的追加保证金记录 的配置流水记录id
		Long fcmId = this.modifyMarginOpReqFcmIdHis(list, mspModifyRequest, operatorId);
		// TODO:调用MSP更改配置接口
		ErrorMessageVO<Object> responseDTO = mspFacade.modifyFastSettleConfig2Msp(mspModifyRequest, fcmId);

		// TODO:返回更新配置流水记录,更新追加请求状态,接口调用以后优先将状态改掉，防止多次审核同一追加金额造成的多次审核（审核金额被放大）
		this.modifyMarginOpReqStatus(context, list, fcmId, responseDTO.isSuccess());

		if (!responseDTO.isSuccess()) {
			log.error("OpTransferSuccessState.modifyMarginOpReqStatus need repair data->promoterId:" + context.getPromoterId());
			return responseDTO;
		}

		// TODO:更新垫资方，审核状态等
		this.modifyAuditInfoStatus(context, operator, operatorId);

		return responseDTO;
	}

	/**
	 * 构建msp接口请求参数
	 *
	 * @param promoterId
	 * @param fastSettleLimit
	 * @param list
	 * @return
	 */
	private MspModifyRequest buildMspModifyRequest(OpContext context, List<MarginOpReqDO> list) {
		MspModifyRequest mspModifyRequest = new MspModifyRequest();
		mspModifyRequest.setOpType(context.getOpType());
		PromoterInfoDTO promoterInfoDTO = mspFacade.findPromoterInfoByPromoterId(context.getPromoterId());
		String promoterNo = promoterInfoDTO.getPromoterNo();
		String promoterType = promoterInfoDTO.getPromoterType();
		context.setPromoterNo(promoterNo);// 获取商户号
		BigDecimal amount = new BigDecimal(0);
		for (MarginOpReqDO marginOpReqDO : list) {
			amount = amount.add(marginOpReqDO.getAmount());
		}
		if(context.getLoaningType()!=null){
			mspModifyRequest.setLoaningType(context.getLoaningType().getCode());
		}
		if(context.getPromoterMinMargin()!=null){
			mspModifyRequest.setPromoterMinMargin(context.getPromoterMinMargin());
		}
		// 保证金金额
		BigDecimal fastSettleMargin = (StringUtils.isEmpty(promoterInfoDTO.getFastSettleMargin()) ? new BigDecimal(0) : new BigDecimal(
				promoterInfoDTO.getFastSettleMargin().trim())).setScale(2, BigDecimal.ROUND_HALF_UP);
		BigDecimal newFastSettleMargin = fastSettleMargin.add(amount).setScale(2, BigDecimal.ROUND_HALF_UP);
		// 保证金额度
		mspModifyRequest.setFastSettleMargin(newFastSettleMargin.toString());
		if (LoaningTypeEnum.SHENGPAY == context.getLoaningType()) {// 盛付通全资
			mspModifyRequest.setFastSettleLimit(context.getFastSettleLimit().toString());
		} else if (LoaningTypeEnum.PROMOTER == context.getLoaningType()) {// 代理商全资
			mspModifyRequest.setFastSettleLimit(newFastSettleMargin.toString());
			context.setFastSettleLimit(newFastSettleMargin);
		}

		mspModifyRequest.setObjType(OpObjTypeEnums.PROMOTER.code);
		mspModifyRequest.setObjId(context.getPromoterId());
		mspModifyRequest.setPromoterId(context.getPromoterId());
		mspModifyRequest.setPromoterNo(promoterNo);
		mspModifyRequest.setPromoterType(promoterType);
		return mspModifyRequest;
	}

	/**
	 * insert配置流水记录,更新转账成功的追加保证金记录 的配置流水记录id
	 *
	 * @param list
	 * @param mspModifyRequest
	 * @param operatorId
	 * @return
	 */
	public long modifyMarginOpReqFcmIdHis(final List<MarginOpReqDO> list, final MspModifyRequest mspModifyRequest, final String operatorId) {
		return transactionTemplate.execute(new TransactionCallback<Long>() {
			@Override
			public Long doInTransaction(TransactionStatus status) {
				long fcmId = 0l;
				try {
					fcmId = mspFacade.createFsconfigChange(mspModifyRequest, operatorId);
				} catch (FastSettleLimitException e) {
				}
				modifyMarginOpReqFcmIdHis(list, fcmId);
				return fcmId;
			}
		});
	}

	// TODO:返回更新配置流水记录,更新追加请求状态
	public Integer modifyMarginOpReqStatus(final OpContext context, final List<MarginOpReqDO> list, final long fcmId, final boolean isSuccess) {
		return transactionTemplate.execute(new TransactionCallback<Integer>() {
			@Override
			public Integer doInTransaction(TransactionStatus status) {
				log.info("OpTransferSuccessState.modifyMarginOpReqStatus PromoterId:" + context.getPromoterId() + " begain..");
				FsConfigChangeDO fcc = new FsConfigChangeDO();
				fcc.setFcmId(fcmId);
				fcc.setUpdateTime(new Date());
				int fccStatus = (isSuccess ? FsConfigChangeStatusEnum.SUCCESS.code : FsConfigChangeStatusEnum.FAILUE.code);
				fcc.setStatus(fccStatus);
				if(context.getLoaningType()!=null){
				    fcc.setLoaningType(context.getLoaningType().getCode());// 增加垫资方修改
				}
				fsConfigChangeManager.updateByPrimaryKeySelective(fcc);
				int targetStatus = (isSuccess ? MarginOpAddEnums.CONFIGURE_SUCCESS.code : MarginOpAddEnums.CONFIGURE_FAILURE.code);
				int rows = modifyMarginOpReqStatus(list, targetStatus, MarginOpAddEnums.TRANSFER_SUCCESS.code);
				log.info("OpTransferSuccessState.modifyMarginOpReqStatus PromoterId:" + context.getPromoterId() + " end.");
				return rows;
			}
		});
	}

	// TODO:更新垫资方，审核状态等
	public Integer modifyAuditInfoStatus(final OpContext context, final String operator, final String operatorId) {
		return transactionTemplate.execute(new TransactionCallback<Integer>() {
			@Override
			public Integer doInTransaction(TransactionStatus status) {
				Newt0PromoterDO promoterDO = new Newt0PromoterDO();
				promoterDO.setPromoterId(context.getPromoterId());
				promoterDO.setPromoterMerchantNo(Long.parseLong(context.getPromoterNo()));
				if(context.getLoaningType()!=null){
				  promoterDO.setLoaningType(context.getLoaningType().getCode());
				}
				Newt0PromoterDO oldPromoterDO = newt0PromoterService.getPromoterByMerchantId(context.getPromoterId());
				if (oldPromoterDO == null) {
					promoterDO.setCreateTime(new Date());
					promoterDO.setUpdateTime(new Date());
					newt0PromoterService.insertSelective(promoterDO);
				} else {
					promoterDO.setUpdateTime(new Date());
					Newt0PromoterDOExample example = new Newt0PromoterDOExample();
					example.createCriteria().andPromoterIdEqualTo(promoterDO.getPromoterId());
					newt0PromoterService.updateByExampleSelective(promoterDO, example);
					if ((oldPromoterDO.getLoaningType()!=null&&!oldPromoterDO.getLoaningType().equals(promoterDO.getLoaningType()))||(oldPromoterDO.getLoaningType()==null&&promoterDO.getLoaningType()!=null)) {
						// 依赖newt0PromoterService.updateByExampleSelective(promoterDO,example)先更新
						fastSettleConfigManager.updateByPromoterId(context.getPromoterId());
					}
				}
				if (context.getBizId() != null) {//非申请审批，不更新审批表
					int auditStatus = AuditInfoStateEnum.AUDITED.getStatus();
					if (context.getAuditResult() != null && MerchantCreditConstant.STRING_FALSE.equalsIgnoreCase(context.getAuditResult())) {
						auditStatus = AuditInfoStateEnum.REJECT.getStatus();
					}
					AuditInfoDTO auditInfo = auditInfoService.selectAuditInfoById(context.getBizId());
					if (auditInfo == null || auditInfo.getMarginInfo() == null) { return 0; }
					AuditInfoRequestLog marginInfo = auditInfo.getMarginInfo();
					marginInfo.setAuditDesc(context.getAuditDesc());
					marginInfo.setAuditResult(context.getAuditResult());
					marginInfo.setAuditLimit(context.getAuditLimit());
					String requestLog = marginInfo.convertToJsonString();
					return auditInfoService.updateStatus(context.getBizId(), null, promoterDO.getPromoterId(),
							AuditInfoStateEnum.WAIT_AUDIT.getStatus(), auditStatus, operator, operatorId, requestLog);
				}
				return 1;
			}
		});
	}
}
