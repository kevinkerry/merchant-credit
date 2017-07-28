package com.sdp.mc.batch.redeemed;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import org.slf4j.Logger;import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import com.sdp.mc.batch.BaseHandler;
import com.sdp.mc.common.constant.MerchantContractCst;
import com.sdp.mc.common.constant.MerchantCreditConstant;
import com.sdp.mc.common.enums.MarginOpRedeemEnums;
import com.sdp.mc.common.enums.OpTypeEnums;
import com.sdp.mc.common.util.DateUtil;
import com.sdp.mc.integration.fos.dto.request.RemitTransferRequestDTO;
import com.sdp.mc.integration.fos.enums.FOSPaymentCodeEnum;
import com.sdp.mc.integration.ma.dto.MerchantBalanceDTO;
import com.sdp.mc.ma.wrapper.AccountQueryFacadeWrapper;
import com.sdp.mc.margin.dao.MarginOpReqDO;
import com.sdp.mc.margin.dao.MarginOpReqDOExample;
import com.sdp.mc.promoter.dao.PromoterFastSettleSwitchDO;
import com.sdp.mc.promoter.dao.PromoterFastSettleSwitchDOExample;
import com.sdp.mc.promoter.manager.PromoterFastSettleSwitchManager;
import com.sdp.mc.service.op.OpService;
import com.sdp.mc.service.op.state.OpContext;
import com.sdp.mc.service.op.state.OpStateResponse;
import com.sdp.mc.view.dao.ViewPromoterInfoDTO;
import com.shengpay.service.BaseCommonService;
import com.shengpay.service.view.PromoterInfoService;

@Service("RedeemedHandler")
public class RedeemedHandler extends BaseHandler {

	private Logger log = LoggerFactory.getLogger(RedeemedHandler.class);

	@Autowired
	private PromoterFastSettleSwitchManager promoterFastSettleSwitchManager;
	@Autowired
	private AccountQueryFacadeWrapper accountQueryFacadeWrapper;
	@Autowired
	private OpService opService;
	@Autowired
	private PromoterInfoService promoterInfoService;
	
	protected List<MarginOpReqDO> selectRedeemedReq() {
		Date date = new Date();
		MarginOpReqDOExample example = new MarginOpReqDOExample();
		example.createCriteria().andOpTypeEqualTo(OpTypeEnums.REDEEMED.code).andStatusEqualTo(MarginOpRedeemEnums.AUDITING_SUCCESS.code)
				.andRedeemedTimeLessThanOrEqualTo(DateUtil.generateMidnightTimeStamp(date));
		example.setOrderByClause(" REDEEMED_TIME desc ");
		example.setPageSize(100);
		List<MarginOpReqDO> MarginOpReqDOs = marginOpReqManager.selectByQuery(example);
		return MarginOpReqDOs;
	}

	public void execute() {
		log.info("RedeemedHandler #execute.");
		List<MarginOpReqDO> marginOpReqDOs = selectRedeemedReq();
		for (MarginOpReqDO marginOpReqDO : marginOpReqDOs) {
			RedeemedTask redeemedTask = new RedeemedTask(marginOpReqDO);
			pool.execute(redeemedTask);
		}

	}
	
	class RedeemedTask implements Runnable{

		private Logger logger = LoggerFactory.getLogger(RedeemedTask.class);

		public RedeemedTask() {
		}

		public RedeemedTask(MarginOpReqDO marginOpReqDO) {
			this.marginOpReqDO = marginOpReqDO;
		}

		private MarginOpReqDO marginOpReqDO;

		@Override
		public void run() {
			logger.info("RedeemedTask #run," + ((marginOpReqDO == null) ? null : marginOpReqDO.toString()));
			Assert.notNull(marginOpReqDO);
            if(marginOpReqDO==null){
            	return;
            }
			Long promoterId = marginOpReqDO.getPromoterId();
			// 取保证金账号
			PromoterFastSettleSwitchDOExample example = new PromoterFastSettleSwitchDOExample();
			example.setPromoterId(promoterId);
			List<PromoterFastSettleSwitchDO> list = promoterFastSettleSwitchManager.selectByExample(example);
			if (!list.isEmpty() && list.size() > 1) {
				logger.error("RedeemedTask #run,promoterId:" + promoterId + ",select TB_PROMOTER_FS_RQ not unique.");
				// return OpStateResponse.genFailureResponse("",
				// MerchantCreditConstant.MC_MARGIN_ADD_EXCEPTION);
			}
			PromoterFastSettleSwitchDO promoterFastSettleSwitchDO = list.get(0);
			String memberId = promoterFastSettleSwitchDO.getMarginMemberId();
			String marginAccount = promoterFastSettleSwitchDO.getMarginAccount();
			ViewPromoterInfoDTO promoterInfo=promoterInfoService.queryPromoterById(promoterId);
			// 取基本户账号
			MerchantBalanceDTO balanceDTO = null;
			try {
				balanceDTO = accountQueryFacadeWrapper.queryMerchantBalance(memberId,promoterInfo.getPromoterType());
			} catch (Exception e) {
				logger.error("RedeemedTask #run," + e);
			}
			if(balanceDTO==null){
				return;
			}
			String marginAccountId = balanceDTO.getMarginAccountId();
			String publicAccountId = balanceDTO.getPublicAccountId();
			if (!marginAccount.equalsIgnoreCase(marginAccountId)) {
				logger.error("RedeemedTask #run, database Margin Account not equal MA Margin Account,DB Margin Account:" + marginAccount
						+ ",Ma Margin AccountId:" + marginAccountId);
			}

			RemitTransferRequestDTO transferRequest = new RemitTransferRequestDTO();
			transferRequest.setRemitVoucherNo(BaseCommonService.generatorSeq());
			transferRequest.setPaymentCode(FOSPaymentCodeEnum.SUB2BASE);
			transferRequest.setPayerAccountNo(marginAccount);
			transferRequest.setPayerAccountType(MerchantCreditConstant.ACCOUNT_TYPE_4_MARGIN);
			transferRequest.setPayeeAccountNo(publicAccountId);
			transferRequest.setPayeeAccountType(MerchantCreditConstant.ACCOUNT_TYPE_4_PUBLIC);
			transferRequest.setRemitAmount(marginOpReqDO.getAmount());
			transferRequest.setPayerMemberId(memberId);
			transferRequest.setPayeeMemberId(memberId);
			transferRequest.setAppId(MerchantCreditConstant.MC_WEBSITE_ZF_NO);

			// RemitTransferResponseDTO responseDTO =
			// fosFacade.addMargin(transferRequest);
			// logger.info("RedeemedTask run,responseDTO:" +
			// responseDTO.toString());

			OpContext context = new OpContext();
			context.setAmount(marginOpReqDO.getAmount().setScale(2, BigDecimal.ROUND_HALF_UP));
			context.setBizId(marginOpReqDO.getMorId());
			context.setOpType(marginOpReqDO.getOpType());
			context.setRemitTransferRequest(transferRequest);
			opService.handler(context, MarginOpRedeemEnums.AUDITING_SUCCESS.code,MerchantContractCst.SYSTEM_DEFAULT_USER);
			if (context.getOpStateResponse() != null) {
				OpStateResponse opStateResponse = context.getOpStateResponse();
				if (opStateResponse.isSuccess())
					logger.info("RedeemedTask #run,"+context.getOpStateResponse().toString());
				else logger.error("RedeemedTask #run,"+context.getOpStateResponse().toString());
			}

		}

		public MarginOpReqDO getMarginOpReqDO() {
			return marginOpReqDO;
		}

		public void setMarginOpReqDO(MarginOpReqDO marginOpReqDO) {
			this.marginOpReqDO = marginOpReqDO;
		}

	}
}
