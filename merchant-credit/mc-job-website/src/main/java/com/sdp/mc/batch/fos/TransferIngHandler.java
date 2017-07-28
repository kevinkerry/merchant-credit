package com.sdp.mc.batch.fos;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import com.sdp.mc.batch.BaseHandler;
import com.sdp.mc.common.constant.MerchantContractCst;
import com.sdp.mc.common.constant.MerchantCreditConstant;
import com.sdp.mc.common.enums.FosPaymentStateEnums;
import com.sdp.mc.common.enums.LoaningTypeEnum;
import com.sdp.mc.common.enums.MarginOpAddEnums;
import com.sdp.mc.common.enums.MarginTransEnum;
import com.sdp.mc.common.enums.OpTypeEnums;
import com.sdp.mc.config.dao.ConfigOptionDO;
import com.sdp.mc.config.dao.ConfigOptionDOExample;
import com.sdp.mc.config.manager.ConfigOptionManager;
import com.sdp.mc.facade.msp.MspFacade;
import com.sdp.mc.fos.dao.MarginTransDO;
import com.sdp.mc.fos.dao.MarginTransDOExample;
import com.sdp.mc.fos.manager.MarginTransManager;
import com.sdp.mc.integration.fos.dto.request.TransferQueryRequestDTO;
import com.sdp.mc.integration.fos.dto.response.TransferQueryResponseDTO;
import com.sdp.mc.integration.fos.enums.FOSPaymentCodeEnum;
import com.sdp.mc.integration.fos.enums.FOSProductCodeEnum;
import com.sdp.mc.integration.msp.PromoterInfoDTO;
import com.sdp.mc.integration.msp.request.MspModifyRequest;
import com.sdp.mc.margin.dao.MarginOpReqDO;
import com.sdp.mc.margin.dao.MarginOpReqDOExample;
import com.sdp.mc.margin.manager.MarginOpReqManager;
import com.sdp.mc.service.fastsettle.margin.MarginOpService;
import com.sdp.mc.service.newt0.Newt0PromoterService;
import com.sdp.mc.service.op.OpService;
import com.sdp.mc.service.op.state.OpContext;
import com.sdp.mc.service.op.state.OpStateResponse;
import com.shengpay.facade.fos.FOSFacade;

@Service("TransferIngHandler")
public class TransferIngHandler extends BaseHandler {

	private Logger logger = LoggerFactory.getLogger(TransferIngHandler.class);

	@Autowired
	private OpService opService;
	@Autowired
	private FOSFacade fosFacade;
	@Autowired
	MarginTransManager marginTransManager;
	@Autowired
	MarginOpReqManager marginOpReqManager;
	@Autowired
	private MspFacade mspFacade;
	@Autowired
	private MarginOpService marginOpService;
	@Autowired
	private ConfigOptionManager configOptionManager;
	@Autowired
	private Newt0PromoterService newt0PromoterService;

	protected List<MarginTransDO> selectMarginTransIng() {
		MarginTransDOExample example = new MarginTransDOExample();
		example.createCriteria().andStatusEqualTo(MarginTransEnum.INIT.code);
		example.setOrderByClause(" CREATE_TIME ASC ");
		List<MarginTransDO> marginTransDOs = marginTransManager.selectByExample(example);
		return marginTransDOs;
	}

	public void execute() {
		logger.info("TransferIngHandler #execute.");
		List<MarginTransDO> marginTransDOs = selectMarginTransIng();
		for (MarginTransDO marginTransDO : marginTransDOs) {
			TransferIngTask transferIngTask = new TransferIngTask(marginTransDO);
			transferIngTask.setMarginTransDO(marginTransDO);
			pool.execute(transferIngTask);
		}
	}

	class TransferIngTask implements Runnable {

		private Logger logger = LoggerFactory.getLogger(TransferIngTask.class);

		private MarginTransDO marginTransDO;

		public TransferIngTask() {
		}

		public TransferIngTask(MarginTransDO marginTransDO) {
			this.marginTransDO = marginTransDO;
		}

		public void run() {
			logger.info("TransferIngTask #run," + ((marginTransDO == null) ? null : marginTransDO.toString()));
			Assert.notNull(marginTransDO);
			if(marginTransDO!=null){
			long mtId = marginTransDO.getMtId();
			// FOS 查询接口
			TransferQueryResponseDTO responseDTO = fosFacade.transferQuery(mtId, marginTransDO2TransferQueryRequestDTO(marginTransDO));
			if (responseDTO == null)
				return;

			String paymentState = responseDTO.getPaymentState();
			if (!FosPaymentStateEnums.S.code.equalsIgnoreCase(paymentState))
				return;

			MarginOpReqDOExample example = new MarginOpReqDOExample();
			MarginOpReqDOExample.Criteria cri = example.createCriteria();
			cri.andMtIdEqualTo(mtId + "");
			List<MarginOpReqDO> marginOpReqDOs = marginOpReqManager.selectByExample(example);
			if (marginOpReqDOs == null || marginOpReqDOs.isEmpty())
				return;

			MarginOpReqDO marginOpReqDO = marginOpReqDOs.get(0);
			int opType = marginOpReqDO.getOpType();
			marginOpReqDO.setUpdateTime(new Date());

			example.clear();
			if (OpTypeEnums.ADD.code == opType) {
				marginOpReqDO.setStatus(MarginOpAddEnums.TRANSFER_SUCCESS.code);
				MarginOpReqDOExample.Criteria criteria = example.createCriteria();
				criteria.andMorIdEqualTo(marginOpReqDO.getMorId());
				criteria.andStatusEqualTo(MarginOpAddEnums.INIT.code);
				int rows = marginOpReqManager.updateByExampleSelective(marginOpReqDO, example);
				if (rows <= 0)
					return;
				LoaningTypeEnum loaningType = LoaningTypeEnum.getLoaningTypeEnum(newt0PromoterService.getLoaningTypeByPromoterId(marginOpReqDO.getPromoterId()));
				if (loaningType == null || LoaningTypeEnum.SHENGPAY == loaningType) {// 盛付通全资或无
					PromoterInfoDTO promoterInfoDTO = mspFacade.findPromoterInfoByPromoterId(marginOpReqDO.getPromoterId());
					logger.info("MarginOpServiceImpl #addMargin,promoterIdInfo:" + promoterInfoDTO.toString());
					String promoterNo = promoterInfoDTO.getPromoterNo();
					OpContext opContext = new OpContext();
					opContext.setPromoterId(marginOpReqDO.getPromoterId());
					opContext.setPromoterNo(promoterNo);
					opContext.setOpType(opType);
					opContext.setAmount(marginOpReqDO.getAmount());
					opContext.setLoaningType(loaningType);
					OpStateResponse response = opService.handler(opContext, MarginOpAddEnums.NON_AUDITING.code,MerchantContractCst.SYSTEM_DEFAULT_USER);
					logger.info("TransferIngTask NON_AUDITING #run:" + response.toString());
				} else if (LoaningTypeEnum.PROMOTER == loaningType) {// 代理商全资
					OpContext opContext = new OpContext();
					opContext.setBizId(marginOpReqDO.getMorId());
					try {
						opContext.setMspModifyRequest(generateMspModifyRequest(marginOpReqDO.getPromoterId(), marginOpReqDO.getAmount()));
					} catch (Exception e) {
						logger.error("TransferIngTask #run,setMspModifyRequest is Exception",e);
						return;
					}
					OpStateResponse response = opService.handler(opContext, MarginOpAddEnums.TRANSFER_SUCCESS.code,MerchantContractCst.SYSTEM_DEFAULT_USER);
					logger.info("TransferIngTask TRANSFER_SUCCESS #run:" + response.toString());
				} else {
					logger.error("TransferIngTask no loaningType found promoterId=" + marginOpReqDO.getPromoterId());
				}
			}
			}/*
			 	手动操作
			else if (OpTypeEnums.REDEEMED.code == opType) {
				marginOpReqDO.setStatus(MarginOpRedeemEnums.TRANSFER_SUCCESS.code);
				MarginOpReqDOExample.Criteria criteria = example.createCriteria();
				criteria.andMorIdEqualTo(marginOpReqDO.getMorId());
				// criteria.andStatusEqualTo(MarginOpAddEnums.CONFIGURE_SUCCESS.code);//修改成审核成功
				criteria.andStatusEqualTo(MarginOpRedeemEnums.AUDITING_SUCCESS.code);
				marginOpReqManager.updateByExampleSelective(marginOpReqDO, example);
				return;
			}*/

		}

		protected TransferQueryRequestDTO marginTransDO2TransferQueryRequestDTO(MarginTransDO marginTransDO) {
			FOSPaymentCodeEnum paymentCode = FOSPaymentCodeEnum.parse(FOSProductCodeEnum.MC_FOS_MARGIN_PRODUCT_CODE, marginTransDO.getPaymentCode());
			TransferQueryRequestDTO queryRequestDTO = new TransferQueryRequestDTO();
			queryRequestDTO.setPaymentCode(paymentCode);
			queryRequestDTO.setRemitVoucherNo(marginTransDO.getRemitVoucherNo());
			return queryRequestDTO;
		}

		private MspModifyRequest generateMspModifyRequest(Long promoterId, BigDecimal amount) throws Exception {
			// 取扩大倍数
			ConfigOptionDOExample optionDOExample = new ConfigOptionDOExample();
			optionDOExample.createCriteria().andOptionKeyEqualTo(MerchantCreditConstant.MC_MARGIN_2_CONFIGURE_TIMES);
			List<ConfigOptionDO> configOptionDOs = configOptionManager.selectByExample(optionDOExample);
			if (configOptionDOs == null || configOptionDOs.isEmpty()) {
				logger.error("TransferIngTask #run,MerchantCreditConstant.MC_MARGIN_2_CONFIGURE_TIMES is not unique.");
				throw new Exception("TransferIngTask #run,MerchantCreditConstant.MC_MARGIN_2_CONFIGURE_TIMES is not unique.");
			}
			ConfigOptionDO configOptionDO = configOptionDOs.get(0);
			String margin2ConfigTimes = configOptionDO.getOptionValue();

			// 取代理商类型和商户号，保证金金额
			PromoterInfoDTO promoterInfoDTO = mspFacade.findPromoterInfoByPromoterId(promoterId);
			logger.info("MarginOpServiceImpl #addMargin,promoterIdInfo:" + promoterInfoDTO.toString());
			String promoterNo = promoterInfoDTO.getPromoterNo();
			String promoterType = promoterInfoDTO.getPromoterType();
			BigDecimal fastSettleMargin = (StringUtils.isEmpty(promoterInfoDTO.getFastSettleMargin()) ? new BigDecimal(0) : new BigDecimal(promoterInfoDTO.getFastSettleMargin().trim())).setScale(2,
					BigDecimal.ROUND_HALF_UP);

			MspModifyRequest mspModifyRequest = marginOpService.generatMarginMspModifyRequest(OpTypeEnums.ADD, amount, fastSettleMargin, margin2ConfigTimes, promoterId, promoterNo, promoterType);
			return mspModifyRequest;
		}

		public MarginTransDO getMarginTransDO() {
			return marginTransDO;
		}

		public void setMarginTransDO(MarginTransDO marginTransDO) {
			this.marginTransDO = marginTransDO;
		}
	}
}
