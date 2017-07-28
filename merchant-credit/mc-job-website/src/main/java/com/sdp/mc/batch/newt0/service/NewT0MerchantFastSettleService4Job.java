//package com.sdp.mc.batch.newt0.service;
//
//import java.math.BigDecimal;
//import java.util.ArrayList;
//import java.util.Date;
//import java.util.List;
//import java.util.concurrent.ExecutorService;
//import java.util.concurrent.Executors;
//
//import org.apache.commons.lang.StringUtils;
//import org.apache.commons.lang.builder.ToStringBuilder;
//import org.slf4j.Logger;import org.slf4j.LoggerFactory;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import com.sdo.common.lang.StringUtil;
//import com.sdo.common.util.DateUtil;
//import com.sdp.mc.common.constant.MerchantCreditConstant;
//import com.sdp.mc.common.enums.AlertMessageSendTypeEnum;
//import com.sdp.mc.common.enums.LoaningTypeEnum;
//import com.sdp.mc.common.enums.StraightlySettleResultEnums;
//import com.sdp.mc.config.manager.ConfigOptionManager;
//import com.sdp.mc.facade.msp.FastSettleHessianInterface;
//import com.sdp.mc.facade.msp.enums.MerchantFastSettleSubStatusEnum;
//import com.sdp.mc.fastsettle.thread.service.SdpFastSettleService;
//import com.sdp.mc.merchant.dao.MerchantFsReq;
//import com.sdp.mc.merchant.dao.MerchantFsReqExample;
//import com.sdp.mc.merchant.manager.MerchantFsRManager;
//import com.shengpay.pos.pcs_t0.api.fastsettle.FastSettleFundOutInfo;
//import com.shengpay.service.alert.factory.AlertMessageSenderFactory;
//import com.shengpay.service.mail.AlertMessageSender;
//
//@Service
//public class NewT0MerchantFastSettleService4Job {
//
//	private static Logger logger = LoggerFactory.getLogger(NewT0MerchantFastSettleService4Job.class);
//	@Autowired
//	private ConfigOptionManager configOptionManager;
//	@Autowired
//	private FastSettleHessianInterface fastSettleHessianInterfaceProxy;
//	@Autowired
//	private MerchantFsRManager merchantFsRManager;
//	@Autowired
//	private SdpFastSettleService sdpFastSettleService;
//	@Autowired
//	private AlertMessageSenderFactory alertMessageSenderFactory;
//	// 向BD、清算及业务负责人发邮件
//	private static ExecutorService executorService = Executors.newFixedThreadPool(5);
//
//	private void sendMail(final String title, final String content) {
//		try {
//			final String mailList = this.configOptionManager.getConfigByKey(MerchantCreditConstant.NEWT0_REMIND_RUN_OUT_MAIL_LIST);
//			if (StringUtils.isBlank(mailList)) {
//				logger.error("NewT0MerchantFastSettleService4Job.sendMail.error,mail list is not configured");
//				return;
//			}
//			final AlertMessageSender sender = alertMessageSenderFactory.getAlertMessageSender(AlertMessageSendTypeEnum.MAIL_ALERT);
//			Thread t = new Thread() {
//				public void run() {
//					try {
//						sender.sendMessage(title, content, mailList);
//					} catch (Exception e) {
//						logger.info("NewT0MerchantFastSettleService4Job.sendMail.error.inner", e);
//					}
//				}
//			};
//			executorService.execute(t);
//		} catch (Exception e) {
//			logger.info("NewT0MerchantFastSettleService4Job.sendMail.error", e);
//		}
//	}
//
//	/**
//	 * 同步申请交易失败的订单,还原额度
//	 * **/
//	private void syncT0ForApplyFailRecords() {
//		MerchantFsReqExample example = new MerchantFsReqExample();
//		MerchantFsReqExample.Criteria criteria = example.createCriteria();
//		List<Integer> statusList = new ArrayList<Integer>();
//		// statusList.add(Integer.parseInt(StraightlySettleResultEnums.INIT.code));
//		statusList.add(Integer.parseInt(StraightlySettleResultEnums.RESULT_00.code));
//		criteria.andStatusNotIn(statusList);
//		criteria.andSubStatusEqualTo(MerchantFastSettleSubStatusEnum.SUBMITTED.code);
//		criteria.andLoaningTypeEqualTo(LoaningTypeEnum.SHENGPAY.getCode());
//		Date day = com.sdp.mc.common.util.DateUtil.increaseDate(new Date(), -10);
//		criteria.andCreateTimeGreaterThan(day);
//		example.setOrderByClause(" UPDATE_TIME asc");
//		example.setPageSize(999);
//		example.setCurrentPage(1);
//		List<MerchantFsReq> list = this.merchantFsRManager.selectByQuery(example);
//		if (list != null && list.size() > 0) {
//			for (MerchantFsReq merchantFsReq : list) {
//				// 还原额度
//				BigDecimal amount = new BigDecimal(merchantFsReq.getAmount());
//				boolean flag = this.sdpFastSettleService.updateFrozenFail(merchantFsReq.getCreateTime(), amount);
//				logger.info("NewT0MerchantFastSettleService4Job.syncT0ForApplyFailRecords.updateFrozenFail,date="
//						+ DateUtil.getWebDateString(merchantFsReq.getCreateTime()) + ",amount" + amount + ",flag=" + flag);
//				// 更改状态到msp异常订单
//				updateMerchantFastSettle2Exception(merchantFsReq.getMfqId(), merchantFsReq.getStatus());
//			}
//		}
//	}
//
//	/**
//	 * 同步申请交易成功的订单
//	 * **/
//	private void syncT0ForApplySuccessRecords() {
//		// 每次只处理999条记录
//		long minutes = this.configOptionManager.getLongByKey(MerchantCreditConstant.NEW_T0_REMIT_FEE_MINUTE);
//		MerchantFsReqExample example = new MerchantFsReqExample();
//		MerchantFsReqExample.Criteria criteria = example.createCriteria();
//		criteria.andStatusEqualTo(Integer.parseInt(StraightlySettleResultEnums.RESULT_00.code));
//		criteria.andSubStatusEqualTo(MerchantFastSettleSubStatusEnum.SUBMITTED.code);
//		criteria.andLoaningTypeEqualTo(LoaningTypeEnum.SHENGPAY.getCode());
//		Date day = com.sdp.mc.common.util.DateUtil.increaseDate(new Date(), -10);
//		criteria.andCreateTimeGreaterThan(day);
//		example.setOrderByClause(" UPDATE_TIME asc");
//		example.setPageSize(999);
//		example.setCurrentPage(1);
//		List<MerchantFsReq> list = this.merchantFsRManager.selectByQuery(example);
//		if (list != null && list.size() > 0) {
//			List<String> idList = new ArrayList<String>();
//			logger.info("NewT0MerchantFastSettleService4Job.syncT0ForApplySuccessRecords,idList begin..");
//			for (MerchantFsReq merchantFsReq : list) {
//				idList.add(merchantFsReq.getMfqId().toString());
//				logger.info("NewT0MerchantFastSettleService4Job.syncT0ForApplySuccessRecords,mfqId(in idList)=" + merchantFsReq.getMfqId().toString());
//			}
//			logger.info("NewT0MerchantFastSettleService4Job.syncT0ForApplySuccessRecords,idList:" + ToStringBuilder.reflectionToString(idList)+" idList.siz=:"+idList.size());
//			List<FastSettleFundOutInfo> fundOutInfoList = this.fastSettleHessianInterfaceProxy.queryFastSettleFundOutInfo(idList);
//			logger.info("NewT0MerchantFastSettleService4Job#syncT0ForApplySuccessRecords fundOutInfoList ="+ToStringBuilder.reflectionToString(fundOutInfoList));
//			if (fundOutInfoList != null) {
//				StringBuilder body = new StringBuilder();
//				logger.info("NewT0MerchantFastSettleService4Job.syncT0ForApplySuccessRecords,fundOutInfoList begin..");
//				for (FastSettleFundOutInfo fastSettleFundOutInfo : fundOutInfoList) {
//					// 只有结算成功的才同步状态
//					logger.info("NewT0MerchantFastSettleService4Job.syncT0ForApplySuccessRecords,fastSettleFundOutInfo="
//							+ ToStringBuilder.reflectionToString(fastSettleFundOutInfo));
//					MerchantFsReq merchantFsReq = this.merchantFsRManager.selectByPrimaryKey(Long.valueOf(fastSettleFundOutInfo.getBizId()));
//					if(StringUtils.isBlank(merchantFsReq.getSettleStatus())){
//						// 更新结算单号跟结算状态
//						this.updateMerchantFastSettleStatus(fastSettleFundOutInfo,merchantFsReq);
//					}
//					if ("1".equals(fastSettleFundOutInfo.getSettleStatus())) {
//						if (StringUtils.isBlank(fastSettleFundOutInfo.getWithdrawResponseCode())) {
//							continue;
//						}
//						this.updateMerchantFastSettleFromMsp(fastSettleFundOutInfo, minutes, merchantFsReq);
//						// 把冻结额度减掉、已使用额度增加
//						BigDecimal amount = new BigDecimal(merchantFsReq.getAmount());
//						boolean flag = this.sdpFastSettleService.updateFrozenSuccess(merchantFsReq.getCreateTime(), amount);
//						logger.info("NewT0MerchantFastSettleService4Job.syncT0ForApplySuccessRecords.updateFrozenSuccess,date="
//								+ DateUtil.getWebDateString(merchantFsReq.getCreateTime()) + ",amount" + amount + ",flag=" + flag);
//					} else {
//						// 理论上没有结算失败的单子，暂时加邮件监控
//						body.append(merchantFsReq.getMfqId());
//						body.append(",").append(merchantFsReq.getMerchantNo());
//						body.append(",").append(fastSettleFundOutInfo.getSettleBillNo());
//						body.append(",").append(fastSettleFundOutInfo.getPaymentOrderNo());
//						body.append(",").append(fastSettleFundOutInfo.getSettleStatus());
//						body.append(",").append(fastSettleFundOutInfo.getPaymentStatus());
//						body.append("\n\r");
//					}
//				}
//				logger.info("NewT0MerchantFastSettleService4Job.syncT0ForApplySuccessRecords,fundOutInfoList end.");
//				if (StringUtil.isNotBlank(body.toString())) {
//					logger.info("NewT0MerchantFastSettleService4Job.syncT0ForApplySuccessRecords,sendMail begin..");
//					StringBuilder header = new StringBuilder();
//					header.append("申请单id,").append("商户号,").append("结算订单号,").append("支付订单号,").append("结算状态(0:待出款,1:已出款,2:转至下期),").append("支付状态\n\r");
//					header.append(body);
//					this.sendMail("结算失败订单报警", header.toString());
//					logger.info("NewT0MerchantFastSettleService4Job.syncT0ForApplySuccessRecords,sendMail end.");
//				}
//			}
//		}
//	}
//
//	/**
//	 * 同步T0交易订单状态
//	 * **/
//	public void syncT0Status() {
//		syncT0ForApplyFailRecords();
//		syncT0ForApplySuccessRecords();
//	}
//
//	private boolean updateMerchantFastSettle2Exception(Long id, Integer status) {
//		MerchantFsReqExample example = new MerchantFsReqExample();
//		MerchantFsReqExample.Criteria criteria = example.createCriteria();
//		criteria.andMfqIdEqualTo(id);
//		criteria.andSubStatusEqualTo(MerchantFastSettleSubStatusEnum.SUBMITTED.code);
//		criteria.andStatusEqualTo(status);
//		MerchantFsReq record = new MerchantFsReq();
//		record.setSubStatus(MerchantFastSettleSubStatusEnum.MSP_EXCEPTION.code);
//		int rows = this.merchantFsRManager.updateByExampleSelective(record, example);
//		logger.info("NewT0MerchantFastSettleService4Job.updateMerchantFastSettle2Exception.mfqId=" + id + ",rows=" + rows);
//		return rows == 1;
//	}
//
//	private boolean updateMerchantFastSettleFromMsp(FastSettleFundOutInfo fastSettleFundOutInfo, long minutes, MerchantFsReq merchantFsReq) {
//		MerchantFsReqExample example = new MerchantFsReqExample();
//		MerchantFsReqExample.Criteria criteria = example.createCriteria();
//		criteria.andMfqIdEqualTo(Long.valueOf(fastSettleFundOutInfo.getBizId()));
//		criteria.andSubStatusEqualTo(MerchantFastSettleSubStatusEnum.SUBMITTED.code);
//		MerchantFsReq record = new MerchantFsReq();
//		record.setSettleBillNo(fastSettleFundOutInfo.getSettleBillNo());
//		record.setFundOutTime(fastSettleFundOutInfo.getFundoutTime());
//		record.setSettleStatus(fastSettleFundOutInfo.getSettleStatus());
//		record.setPaymentOrderNo(fastSettleFundOutInfo.getPaymentOrderNo());
//		record.setMerchantAccountType(fastSettleFundOutInfo.getAccountType());
//		record.setPaymentStatus(fastSettleFundOutInfo.getPaymentStatus());
//		record.setMerchantMemberId(fastSettleFundOutInfo.getPayerMemberId());
//		record.setMerchantAccountNo(fastSettleFundOutInfo.getPayerAccountNo());
//		record.setFastSettleFee(fastSettleFundOutInfo.getSettleFee());
//		record.setWithdrawResponseCode(fastSettleFundOutInfo.getWithdrawResponseCode());
//		record.setWithdrawResponseMsg(fastSettleFundOutInfo.getWithdrawResponseMsg());
//		record.setWithdrawResponseTime(fastSettleFundOutInfo.getWithdrawResponseTime());
//		if (merchantFsReq.getLoaningType() != null && LoaningTypeEnum.SHENGPAY.getCode() == merchantFsReq.getLoaningType()) {
//			if ("0".equals(fastSettleFundOutInfo.getWithdrawResponseCode().trim())) {
//				// 目前是否退费的状态 由前台查询时实时计算
//				record.setSubStatus(MerchantFastSettleSubStatusEnum.SETTLED.code);
//			} else {
//				record.setSubStatus(MerchantFastSettleSubStatusEnum.SETTLED_FAIL.code);
//			}
//		}
//		// 由于pos接口有问题，无法给出结算手续费状态和支付时间故统一处理成已结算
//		record.setUpdateTime(new Date());
//		int rows = this.merchantFsRManager.updateByExampleSelective(record, example);
//		logger.info("NewT0MerchantFastSettleService4Job.updateMerchantFastSettleFromMsp.mfqId=" + fastSettleFundOutInfo.getBizId() + ",rows=" + rows);
//		return rows == 1;
//	}
//	/**
//	 * 有结算状态但是没有结算code的，仅仅更新结算状态
//	 * @param fastSettleFundOutInfo
//	 * @param merchantFsReq
//	 * @return
//	 */
//	private boolean updateMerchantFastSettleStatus(FastSettleFundOutInfo fastSettleFundOutInfo, MerchantFsReq merchantFsReq) {
//		MerchantFsReqExample example = new MerchantFsReqExample();
//		MerchantFsReqExample.Criteria criteria = example.createCriteria();
//		criteria.andMfqIdEqualTo(Long.valueOf(fastSettleFundOutInfo.getBizId()));
//		criteria.andSubStatusEqualTo(MerchantFastSettleSubStatusEnum.SUBMITTED.code);
//
//		MerchantFsReq record = new MerchantFsReq();
//		record.setSettleBillNo(fastSettleFundOutInfo.getSettleBillNo());
//		record.setSettleStatus(fastSettleFundOutInfo.getSettleStatus());
//		// 由于pos接口有问题，无法给出结算手续费状态和支付时间故统一处理成已结算
//		record.setUpdateTime(new Date());
//		int rows = this.merchantFsRManager.updateByExampleSelective(record, example);
//		logger.info("NewT0MerchantFastSettleService4Job.updateMerchantFastSettleFromMsp.mfqId=" + fastSettleFundOutInfo.getBizId() + ",rows=" + rows);
//		return rows == 1;
//	}
//}
