package com.sdp.debit.task.common.service;

import java.math.BigDecimal;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;
import org.slf4j.Logger;import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sdp.mc.common.enums.AccountStatus;
import com.sdp.mc.common.enums.AccountType;
import com.sdp.mc.common.enums.FosPaymentStateEnums;
import com.sdp.mc.integration.fos.dto.response.RemitTransferResponseDTO;
import com.sdp.mc.integration.ma.dto.MerchantBaseBalanceDTO;
import com.sdp.mc.ma.wrapper.AccountQueryFacadeWrapper;
import com.shengpay.debit.common.enums.MerchantDebitOrderStatusEnums;
import com.shengpay.debit.dal.dataobject.DmMerchantDebitInfoPO;
import com.shengpay.debit.dal.dataobject.DoMerchantDebitOrderPO;
import com.shengpay.debit.ext.daointerface.ExtDmMerchantDebitInfoDAO;
import com.shengpay.debit.ext.daointerface.ExtDmMerchantDebitLogInfoDAO;
import com.shengpay.debit.ext.daointerface.ExtDoMerchantDebitOrderDAO;
import com.shengpay.debit.merchant.account.enums.MerchantDebitLogOperateTypeEnum;
import com.shengpay.facade.fos.FOSFacade4Debit;

@Service
public class RepaymentService {

	private Logger log = LoggerFactory.getLogger(RepaymentService.class);

	@Autowired
	private FOSFacade4Debit fOSFacade4Debit;

	@Autowired
	private ExtDoMerchantDebitOrderDAO doMerchantDebitOrderDAO;

	@Autowired
	private ExtDmMerchantDebitInfoDAO dmMerchantDebitInfoDAO;

	@Autowired
	private ExtDmMerchantDebitLogInfoDAO dmMerchantDebitLogInfoDAO;

	@Autowired
	private AccountQueryFacadeWrapper accountQueryFacadeWrapper;

	/**
	 * 服务入口
	 */
	public void run() {
		// 查询到所有最后还款日的借款订单
		List<DoMerchantDebitOrderPO> list = doMerchantDebitOrderDAO
				.queryAllRepaymentOrdersByStatus(getStartTime(), getEndTime(), MerchantDebitOrderStatusEnums.PAYBACKING.getKey());

		if (list != null && list.size() > 0) {
			for (int i = 0; i < list.size(); i++) {
				DoMerchantDebitOrderPO order = list.get(i);
				DmMerchantDebitInfoPO debitInfo = dmMerchantDebitInfoDAO.selectByMerchantId(order.getMerchantNo());
				if (debitInfo == null) {
					// 数据不一致异常
					log.info("can't find debitInfo merchantNo is" + order.getMerchantNo());
					continue;
				}
				// 如果有逾期未还的则优先还逾期的借款
				if (debitInfo.getOverDueAmount() != null && debitInfo.getOverDueAmount().compareTo(BigDecimal.valueOf(0)) > 0) {
					// 数据不一致异常
					log.info("merchantNo=" + order.getMerchantNo() + ",debitOrderId=" + order.getId() + ",has overdue unpayback");
					continue;
				}
				// 钱包剩余钱款
				MerchantBaseBalanceDTO balanceDTO = accountQueryFacadeWrapper.queryAccountBalanceByAccountType(debitInfo.getLendMemberId(), AccountType.C_BASE_ACCOUNT);
				log.info("autoRepayment.debitOrderId=" + order.getId() + ",balance=" + ToStringBuilder.reflectionToString(balanceDTO));
				// 只有账户是正常的或者止入的可以转账成功
				if (balanceDTO != null
						&& (AccountStatus.AccountStatusActive.getCode() == balanceDTO.getAccountStatus() || AccountStatus.AccountStatusDeniedFundIn.getCode() == balanceDTO
								.getAccountStatus())) {
					BigDecimal balance = balanceDTO.getAccountBalance();
					if (balance.compareTo(order.getDebitAmount()) >= 0) {
						RemitTransferResponseDTO response = fOSFacade4Debit.principalPayBack(order.getId(), debitInfo.getLendMemberId(), debitInfo.getLendWalletAccount(),
								debitInfo.getCreditAccount(), order.getDebitAmount());
						if (response != null) {
							log.info("response content:" + response.toString());
							String paymentStatus = response.getPaymentState();
							if (FosPaymentStateEnums.S.code.equals(paymentStatus)) {
								upateDbInfo(debitInfo, order);
							} else if (FosPaymentStateEnums.P.code.equals(paymentStatus)) {
								// order is process
							} else if (FosPaymentStateEnums.E.code.equals(paymentStatus)) {
								// fos is exception
							} else {
								// fail
								log.info("response content fail, get next job to try order content is:"
										+ ToStringBuilder.reflectionToString(order, ToStringStyle.SHORT_PREFIX_STYLE));
							}
						} else {
							log.info("response content is null, order content is:" + ToStringBuilder.reflectionToString(order, ToStringStyle.SHORT_PREFIX_STYLE));
						}
					} else {
						// wallet not enough
						log.info("wallet not enough, order content is:" + ToStringBuilder.reflectionToString(order, ToStringStyle.SHORT_PREFIX_STYLE));
						log.info("wallet not enough, account content is:" + ToStringBuilder.reflectionToString(balanceDTO, ToStringStyle.SHORT_PREFIX_STYLE));
					}
				} else {
					// system error
					log.error("system error");
				}

			}
		}
	}

	@Transactional("debitTransactionManager")
	public void upateDbInfo(DmMerchantDebitInfoPO debitInfo, DoMerchantDebitOrderPO order) {
		BigDecimal beforeAmount = debitInfo.getCanUseAmount();
		// 正常还款订单更新
		order.setStatus(MerchantDebitOrderStatusEnums.NORMAL_PAYBACK_SUCCESS.getKey()); // 正常还款
		order.setUpdateTime(new Date());
		order.setRepaymentTime(new Date());
		doMerchantDebitOrderDAO.updateByPrimaryKeySelective(order); // 更新还款订单
		// 更新账户信息
		dmMerchantDebitInfoDAO.repaymentMoney(order.getMerchantNo(), debitInfo.getOrganizationCode(), order.getDebitAmount());
		DmMerchantDebitInfoPO afterPO = dmMerchantDebitInfoDAO.selectByMerchantId(debitInfo.getMerchantNo());
		BigDecimal afterAmount = afterPO.getCanUseAmount();
		// 插入流水
		dmMerchantDebitLogInfoDAO.insertLog(beforeAmount, afterAmount, MerchantDebitLogOperateTypeEnum.NORMAL_PAYBACK.code, order);
	}

	private Date getEndTime() {
		Calendar cal = Calendar.getInstance();
		cal.set(Calendar.HOUR_OF_DAY, 23);
		cal.set(Calendar.MINUTE, 59);
		cal.set(Calendar.SECOND, 59);
		cal.set(Calendar.MILLISECOND, 999);
		return cal.getTime();
	}

	private Date getStartTime() {
		Calendar cal = Calendar.getInstance();
		cal.set(Calendar.HOUR_OF_DAY, 0);
		cal.set(Calendar.MINUTE, 0);
		cal.set(Calendar.SECOND, 0);
		cal.set(Calendar.MILLISECOND, 0);
		return cal.getTime();
	}

}
