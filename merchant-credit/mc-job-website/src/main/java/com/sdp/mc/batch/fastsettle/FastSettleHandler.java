//package com.sdp.mc.batch.fastsettle;
//
//import java.math.BigDecimal;
//import java.util.ArrayList;
//import java.util.List;
//
//import org.apache.commons.lang.StringUtils;
//import org.apache.commons.lang.builder.ToStringBuilder;
//import org.slf4j.Logger;import org.slf4j.LoggerFactory;
//import org.springframework.stereotype.Service;
//import org.springframework.util.Assert;
//
//import com.sdp.mc.batch.BaseHandler;
//import com.sdp.mc.common.constant.MerchantCreditConstant;
//import com.sdp.mc.dao.readonly.msptxn.McSettFastTxnRO;
//import com.sdp.mc.ffconfig.dao.FastSettleConfigDO;
//import com.sdp.mc.ffconfig.dao.FastSettleConfigDOExample;
//import com.sdp.mc.fos.dao.MarginTransDO;
//import com.sdp.mc.integration.fos.dto.request.TransferQueryRequestDTO;
//import com.sdp.mc.integration.fos.enums.FOSPaymentCodeEnum;
//import com.sdp.mc.integration.fos.enums.FOSProductCodeEnum;
//import com.sdp.mc.integration.msp.MerchantInfoDTO;
//import com.sdp.mc.integration.msp.PromoterInfoDTO;
//import com.shengpay.pos.pcs.api.settle.StraightlyCfg;
//
////@Service("FastSettleHandler")
//public class FastSettleHandler extends BaseHandler {
//
//	private Logger logger = LoggerFactory.getLogger(FastSettleHandler.class);
//
//	protected List<FastSettleConfigDO> selectAutoFastSettle() {
//		FastSettleConfigDOExample example = new FastSettleConfigDOExample();
//		example.createCriteria().andAutoFastSettleEqualTo(MerchantCreditConstant.MERCHANT_AUTO_FASTSETTLE_ON_LOANING_PROMOTER);
//		List<FastSettleConfigDO> fastSettleConfigDOs = fastSettleConfigManager.selectByExample(example);
//		return fastSettleConfigDOs;
//	}
//
//	public void execute() {
//		logger.info("FastSettleHandler #execute.");
//		List<FastSettleConfigDO> fastSettleConfigDOs = selectAutoFastSettle();
//		for (FastSettleConfigDO fastSettleConfigDO : fastSettleConfigDOs) {
//			FastSettleTask transferIngTask = new FastSettleTask(fastSettleConfigDO);
//			pool.execute(transferIngTask);
//		}
//	}
//
//
//	class FastSettleTask implements Runnable {
//
//		private Logger logger = LoggerFactory.getLogger(FastSettleTask.class);
//
//		private FastSettleConfigDO fastSettleConfigDO;
//
//		public FastSettleTask(FastSettleConfigDO fastSettleConfigDO) {
//			this.fastSettleConfigDO = fastSettleConfigDO;
//		}
//
//		public void run() {
//			logger.info("FastSettleTask #run," + ((fastSettleConfigDO == null) ? null : fastSettleConfigDO.toString()));
//			Assert.notNull(fastSettleConfigDO);
//			MerchantInfoDTO merchantInfoDTO = mspFacade.findMerchantInfoByMerchantId(fastSettleConfigDO.getObjId());
//			logger.info("FastSettleTask #run,merchantInfoDTO:" + ToStringBuilder.reflectionToString(merchantInfoDTO));
//			// 验证商户快速结算配置
//			StraightlyCfg straightlyCfg = mspFacade.queryStraightlyCfg(Long.valueOf(merchantInfoDTO.getMerchantId()));
//			if (straightlyCfg==null||!straightlyCfg.isStraightFlag()) {
//				logger.info("FastSettleTask #run,merchantInfoDTO:" + ToStringBuilder.reflectionToString(straightlyCfg));
//				return;
//			}
//			String merchantNo = merchantInfoDTO.getMerchantNo();
//			String merchantId = merchantInfoDTO.getMerchantId();
//			BigDecimal floorAmt = straightlyCfg.getFloorAmt();
//			String mcType=merchantInfoDTO.getMcType();
//			List<McSettFastTxnRO> fastTxnROs = null;
//			fastTxnROs = mspFacade.queryMerchantValidFsOrdersForMpos(merchantNo,mcType);
//
//			// 没有可用交易
//			if (fastTxnROs == null || fastTxnROs.isEmpty()) {
//				logger.info("FastSettleTask #run,no valid txn recode.merchantNo:" + merchantNo + ",merchantId:" + merchantId + ";"
//						+ ToStringBuilder.reflectionToString(fastSettleConfigDO));
//				return;
//			}
//			// Collections.sort(fastTxnROs, new McSettFastTxnRoComparator());
//
//			List<Long> ids = new ArrayList<Long>();
//			// 商户可配置额度的剩余金额与该代理商名下剩余快速结算额度的最低值
//			BigDecimal validCredit = straightlyCfg.getValidCredit();
//			PromoterInfoDTO promoterInfoDTO = mspFacade.findPromoterInfoByPromoterId(merchantInfoDTO.getPromoterId());
//			BigDecimal remainConfigureLimit = StringUtils.isNotEmpty(promoterInfoDTO.getRemainConfigureLimit()) ? new BigDecimal(
//					promoterInfoDTO.getRemainConfigureLimit()) : new BigDecimal(0);
//			logger.info("FastSettleTask #run,merchant_validCredit:" + validCredit.toString() + ",promoter_remainConfigureLimit:"
//					+ remainConfigureLimit.toString() + ";merchantNo:" + merchantNo + ",merchantId:" + merchantId);
//			// validCredit = validCredit.compareTo(remainConfigureLimit) > 0 ?
//			// remainConfigureLimit : validCredit;
//			// 剩余可用余额为0
//			if (validCredit.intValue() == 0) {
//				logger.error("FastSettleTask #run,merchant validCredit is 0." + "," + ToStringBuilder.reflectionToString(promoterInfoDTO) + ";"
//						+ ToStringBuilder.reflectionToString(fastSettleConfigDO) + ";merchantNo:" + merchantNo + ",merchantId:" + merchantId);
//				return;
//			}
//			if (floorAmt.compareTo(validCredit) > 0) {
//				logger.error("FastSettleTask #run,merchant floorAmt greater than validCredit." + ","
//						+ ToStringBuilder.reflectionToString(promoterInfoDTO) + ";" + ToStringBuilder.reflectionToString(fastSettleConfigDO)
//						+ ";merchantNo:" + merchantNo + ",merchantId:" + merchantId);
//				return;
//			}
//			// 封装数据
//			BigDecimal total = new BigDecimal(0);
//			BigDecimal lastTotal = new BigDecimal(0);
//			StringBuffer txnLog = new StringBuffer();
//			for (McSettFastTxnRO mcSettFastTxnRO : fastTxnROs) {
//				lastTotal = total;
//				total = total.add(mcSettFastTxnRO.getAmt());
//				txnLog.append("txnOrderNo:" + mcSettFastTxnRO.getTxnOrderNo() + ",amount:" + mcSettFastTxnRO.getAmt() + ",Id" + mcSettFastTxnRO.getId()
//						+ ";\n");
//				// 1.大于floorAmt
//				// 2.小于validCredit
//				if (total.compareTo(floorAmt) > 0 && total.compareTo(validCredit) >= 0) {
//					logger.info("FastSettleTask #run,total:" + total.toString() + ",floorAmt:" + floorAmt + ",merchantNo:" + merchantNo + ",merchantId:" + merchantId);
//					total = total.subtract(mcSettFastTxnRO.getAmt());
//					continue;
//				}
//				ids.add(mcSettFastTxnRO.getTxnOrderNo());
//			}
//
//			if (!ids.isEmpty())
//				logger.info("FastSettleTask #run,txn total:" + total.toString() + ".merchantNo:" + merchantNo + ",merchantId:" + merchantId);
//			else if (ids.isEmpty()) {
//				logger.error("FastSettleTask #run,no valid txn record.merchantNo:" + merchantNo + ",merchantId:" + merchantId);
//				return;
//			}
//
//			if (total.compareTo(floorAmt) < 0) {
//				logger.error("FastSettleTask #run,txn total:" + total.toString() + ", less than floorAmt:" + floorAmt.toString()
//						+ ", Or total greater than validCredit:" + validCredit.toString() + ";merchantNo:" + merchantNo + ",merchantId:" + merchantId);
//				logger.error("FastSettleTask #run,txn record:" + txnLog.toString());
//				return;
//			} else if (total.compareTo(validCredit) >= 0 && (lastTotal.compareTo(floorAmt) < 0 || lastTotal.compareTo(validCredit) > 0)) {
//				logger.error("FastSettleTask #run,txn total:" + total.toString() + ",lastTotal:" + lastTotal.toString() + ", less than floorAmt:"
//						+ floorAmt.toString() + ", Or lastTotal greater than validCredit:" + validCredit.toString() + ";merchantNo:" + merchantNo
//						+ ",merchantId:" + merchantId);
//				logger.error("FastSettleTask #run,txn record:" + txnLog.toString());
//				return;
//			}
//
//			logger.info("FastSettleTask #run,avalid txn record:" + txnLog.toString() + ";merchantNo:" + merchantNo + ",merchantId:" + merchantId);
//			String errorMsg = mspFacade.straightlySettle(merchantNo, merchantInfoDTO.getPosMerchantNo(), merchantInfoDTO.getMerchantId(),
//					MerchantCreditConstant.MERCHANT_FASTSETTLE_TYPE_AUTO, ids, straightlyCfg.getFeeRate().toString(), fastTxnROs);
//			if (StringUtils.isNotEmpty(errorMsg))
//				logger.error("FastSettleTask #run,Auto FastSettle submit error,msg:" + errorMsg + ";merchantNo:" + merchantNo + ",merchantId:"
//						+ merchantId);
//			logger.info("FastSettleTask #run,Auto FastSettle success." + ";merchantNo:" + merchantNo + ",merchantId:" + merchantId);
//		}
//
//		protected TransferQueryRequestDTO marginTransDO2TransferQueryRequestDTO(MarginTransDO marginTransDO) {
//			FOSPaymentCodeEnum paymentCode = FOSPaymentCodeEnum.parse(FOSProductCodeEnum.MC_FOS_MARGIN_PRODUCT_CODE,marginTransDO.getPaymentCode());
//			TransferQueryRequestDTO queryRequestDTO = new TransferQueryRequestDTO();
//			queryRequestDTO.setPaymentCode(paymentCode);
//			queryRequestDTO.setRemitVoucherNo(marginTransDO.getRemitVoucherNo());
//			return queryRequestDTO;
//		}
//
//	}
//}
