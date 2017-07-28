package com.sdp.debit.task.common.service;

import java.math.BigDecimal;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import net.sf.json.JSONObject;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.slf4j.Logger;import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sdo.common.util.DateUtil;
import com.sdp.mc.common.constant.MerchantCreditConstant;
import com.sdp.mc.common.enums.AccountType;
import com.sdp.mc.common.enums.AlertMessageSendTypeEnum;
import com.sdp.mc.common.util.ConfigOptionHelper;
import com.sdp.mc.common.vo.ErrorMessageVO;
import com.sdp.mc.config.manager.ConfigOptionManager;
import com.sdp.mc.integration.fos.dto.response.RemitTransferResponseDTO;
import com.sdp.mc.ma.wrapper.MaOsrFullServiceWrapper;
import com.shengpay.debit.common.enums.ConfigEnums;
import com.shengpay.debit.common.enums.MerchantDebitOrderStatusEnums;
import com.shengpay.debit.common.enums.MerchantOverDueInfoLogStatusEnum;
import com.shengpay.debit.common.service.DebitConfigService;
import com.shengpay.debit.common.service.MerchantDebitInfoService;
import com.shengpay.debit.dal.dataobject.DmMerchantDebitInfoPO;
import com.shengpay.debit.dal.dataobject.DoMerchantDebitOrderExample;
import com.shengpay.debit.dal.dataobject.DoMerchantDebitOrderPO;
import com.shengpay.debit.dal.dataobject.DoMerchantOverDueInfoExample;
import com.shengpay.debit.dal.dataobject.DoMerchantOverDueInfoPO;
import com.shengpay.debit.ext.daointerface.ExtDmMerchantDebitInfoDAO;
import com.shengpay.debit.ext.daointerface.ExtDoMerchantDebitOrderDAO;
import com.shengpay.debit.ext.daointerface.ExtDoMerchantOverDueInfoDAO;
import com.shengpay.facade.fos.FOSFacade4Debit;
import com.shengpay.service.alert.factory.AlertMessageSenderFactory;
import com.shengpay.service.mail.AlertMessageSender;

@Service
public class OverDueService {

	private static Logger log = LoggerFactory.getLogger(OverDueService.class);

	@Autowired
	private ExtDoMerchantDebitOrderDAO doMerchantDebitOrderDAO;

	@Autowired
	private MaOsrFullServiceWrapper maOsrFullServiceWrapper;

	@Autowired
	private ExtDmMerchantDebitInfoDAO dmMerchantDebitInfoDAO;

	@Autowired
	private DebitConfigService debitConfigService;

	@Autowired
	private ExtDoMerchantOverDueInfoDAO doMerchantOverDueInfoDAO;

	@Autowired
	private FOSFacade4Debit FOSFacade4Debit;

	@Autowired
	private MerchantDebitInfoService merchantDebitInfoService;

	@Autowired
	private ConfigOptionManager configOptionManager;

	@Autowired
	private AlertMessageSenderFactory alertMessageSenderFactory;

	private static ExecutorService executorService = Executors.newFixedThreadPool(5);

	private void sendMail(final String title, final String content) {
		final String mailList = ConfigOptionHelper.getConfigByKey(MerchantCreditConstant.TTD_FOS_PROCESSING_MAIL_LIST);
		if (StringUtils.isBlank(mailList)) {
			log.error("FOSFacade4DebitImpl.sendMail.error,mail list is not configured");
			return;
		}
		Thread t = new Thread() {
			public void run() {
				try {
					AlertMessageSender sender = alertMessageSenderFactory.getAlertMessageSender(AlertMessageSendTypeEnum.MAIL_ALERT);
					sender.sendMessage(title, content, mailList);
				} catch (Exception e) {
					log.error("FOSFacade4DebitImpl.sendMail.error,content=" + content, e);
				}
			}
		};
		executorService.execute(t);
	}

	/**
	 * 检索出将要逾期的借款订单
	 */
	private List<DoMerchantDebitOrderPO> selectWillOverDueAccount() {
		DoMerchantDebitOrderExample example = new DoMerchantDebitOrderExample();
		DoMerchantDebitOrderExample.Criteria criteria = example.createCriteria();
		criteria.andOverDueTimeLessThanOrEqualTo(getEndTime());
		criteria.andStatusEqualTo(MerchantDebitOrderStatusEnums.PAYBACKING.getKey());
		return doMerchantDebitOrderDAO.selectByExample(example);
	}

	/**
	 * 检索出已经逾期的借款订单
	 * 
	 * @return
	 */
	private List<DoMerchantDebitOrderPO> selectHasOverDueAccount() {
		DoMerchantDebitOrderExample example = new DoMerchantDebitOrderExample();
		DoMerchantDebitOrderExample.Criteria criteria = example.createCriteria();
		criteria.andStatusEqualTo(MerchantDebitOrderStatusEnums.OVERDUEING.getKey());
		return doMerchantDebitOrderDAO.selectByExample(example);
	}

	/**
	 * 判断是否已经计算过
	 * 
	 * @param order
	 * @return
	 */
	public boolean hasCal(DoMerchantDebitOrderPO order) {
		DoMerchantOverDueInfoExample example = new DoMerchantOverDueInfoExample();
		DoMerchantOverDueInfoExample.Criteria criteria = example.createCriteria();
		criteria.andBorrowOrderIdEqualTo(order.getId());
		criteria.andCalDateBetween(getStartTime(), getEndTime());
		List<DoMerchantOverDueInfoPO> list = doMerchantOverDueInfoDAO.selectByExample(example);
		if (list != null && list.size() > 0) {
			return true;
		}
		return false;
	}

	public void run() {
		updateOverDueStatus();
		updateOverDueAmount();
	}

	private void sendMailProxy(DoMerchantDebitOrderPO orderPO, StringBuilder sb) {
		sb.append(orderPO.getId()).append(",");
		sb.append(orderPO.getMerchantNo()).append(",");
		sb.append(orderPO.getMerchantName()).append(",");
		sb.append(DateUtil.getWebDateString(orderPO.getOverDueTime()));
		sb.append("\n\r");

	}

	/**
	 * 更新账户状态
	 */
	public void updateOverDueStatus() {
		StringBuilder sb = new StringBuilder();
		sb.append("借款单号").append(",商户号").append(",商户名称").append(",逾期日期").append("\n\r");
		List<DoMerchantDebitOrderPO> list = selectWillOverDueAccount();
		if (list == null || list.isEmpty())
			return;

		for (int i = 0; i < list.size(); i++) {
			DoMerchantDebitOrderPO orderPO = list.get(i);
			// 发送邮件
			this.sendMailProxy(orderPO, sb);
			DoMerchantDebitOrderPO updateOrderPO = new DoMerchantDebitOrderPO();
			updateOrderPO.setStatus(MerchantDebitOrderStatusEnums.OVERDUEING.getKey());
			updateOrderPO.setId(orderPO.getId());
			this.doMerchantDebitOrderDAO.updateByPrimaryKeySelective(updateOrderPO);
			DmMerchantDebitInfoPO debitInfo = dmMerchantDebitInfoDAO.selectByMerchantId(orderPO.getMerchantNo());
			// 更新负债表状态到逾期
			this.merchantDebitInfoService.updateStatus2OverdueById(debitInfo.getId());
			// 调用止出商户[企业和个人商户]
			ErrorMessageVO errorMessage1 = maOsrFullServiceWrapper.checkOut(debitInfo.getMerchantMemberId(), debitInfo.getMerchantWallerAccount(), AccountType.B_BASE_ACCOUNT);
			log.info("OverDueService.updateOverDueStatus.bmerchant.checkOut,memberId=" + debitInfo.getLendMemberId() + ",errorMessage="
					+ ToStringBuilder.reflectionToString(errorMessage1));
			ErrorMessageVO errorMessage2 = maOsrFullServiceWrapper.checkOut(debitInfo.getMerchantMemberId(), debitInfo.getMerchantWallerAccount(), AccountType.C_BASE_ACCOUNT);
			log.info("OverDueService.updateOverDueStatus.cmerchant.checkOut,memberId=" + debitInfo.getLendMemberId() + ",errorMessage="
					+ ToStringBuilder.reflectionToString(errorMessage2));
			// 调用止出个人
			ErrorMessageVO errorMessage3 = maOsrFullServiceWrapper.checkOut(debitInfo.getLendMemberId(), debitInfo.getLendWalletAccount(), AccountType.C_BASE_ACCOUNT);
			log.info("OverDueService.updateOverDueStatus.personal.checkOut,memberId=" + debitInfo.getLendMemberId() + ",errorMessage="
					+ ToStringBuilder.reflectionToString(errorMessage3));
		}
		// 发送邮件
		// if (list != null && list.size() > 0) {
		this.sendMail("今日逾期借款订单", sb.toString());
		// }
	}

	/**
	 * 计算金额
	 */

	public void updateOverDueAmount() {
		List<DoMerchantDebitOrderPO> list = selectHasOverDueAccount();
		if (list != null && list.size() > 0) {
			for (int i = 0; i < list.size(); i++) {
				DoMerchantDebitOrderPO orderPO = list.get(i);
				// 没有计算过的情况
				if (!hasCal(orderPO)) {
					DmMerchantDebitInfoPO debitInfo = dmMerchantDebitInfoDAO.selectByMerchantId(orderPO.getMerchantNo());
					// 计算每天的逾期罚息
					final BigDecimal overDueAmount = calOverDueAmount(orderPO.getDebitAmount());
					long debitOverdueLogId = this.insertDebitOverdueLogInfoAndAddOverDueAmount(orderPO, overDueAmount);
					log.info("OverDueService.updateOverDueAmount.debitOverdueLogId=" + debitOverdueLogId + ",debitOrderId=" + orderPO.getId() + ",overDueAmount=" + overDueAmount);
					// 调fos逾期利息计提
					RemitTransferResponseDTO response = this.FOSFacade4Debit.interestAccrued(debitOverdueLogId, debitInfo.getLendMemberId(), debitInfo.getInterestAccount(),
							overDueAmount);
					boolean flag = this.doMerchantOverDueInfoDAO.update2TargetStatus(debitOverdueLogId, MerchantOverDueInfoLogStatusEnum.INIT.code, response.getPaymentState());
					log.info("OverDueService.updateOverDueAmount.debitOverdueLogId=" + debitOverdueLogId + ",debitOrderId=" + orderPO.getId() + ",flag=" + flag + ",fosresponse="
							+ JSONObject.fromObject(response).toString());
				}
			}
		}
	}

	/**
	 * @param overDueAmount
	 *            每日逾期罚息
	 * **/
	@Transactional("debitTransactionManager")
	private long insertDebitOverdueLogInfoAndAddOverDueAmount(DoMerchantDebitOrderPO orderPO, final BigDecimal overDueAmount) {
		// 逾期金额
		DoMerchantOverDueInfoPO record = new DoMerchantOverDueInfoPO();
		record.setBorrowOrderId(orderPO.getId());
		record.setOverDueAmount(overDueAmount);
		record.setCalDate(new Date());
		record.setCreateTime(new Date());
		record.setUpdateTime(new Date());
		record.setStatus(MerchantOverDueInfoLogStatusEnum.INIT.code);
		long id = doMerchantOverDueInfoDAO.insert(record);
		// 累加借款单上的逾期金额
		addOverDueAmount(orderPO, overDueAmount);
		// 累加负债表上的逾期金额
		boolean flag = this.merchantDebitInfoService.addOverdueInterest(orderPO.getMerchantNo(), overDueAmount);
		log.info("OverDueService.insertDebitOverdueLogInfoAndAddOverDueAmount.merchantNo=" + orderPO.getMerchantNo() + ",debitOrderId=" + orderPO.getId() + ",flag=" + flag);
		return id;
	}

	/**
	 * 将借款订单的逾期金额增加
	 * 
	 * @param orderPO
	 */
	private void addOverDueAmount(DoMerchantDebitOrderPO orderPO, BigDecimal overAmount) {
		DoMerchantDebitOrderPO updatePO = new DoMerchantDebitOrderPO();
		updatePO.setUpdateTime(new Date());
		updatePO.setId(orderPO.getId());
		if (orderPO.getOverDueAmount() == null || (orderPO.getOverDueAmount() != null && orderPO.getOverDueAmount().compareTo(BigDecimal.valueOf(0)) == 0)) {
			updatePO.setOverDueAmount(overAmount);
		} else {
			updatePO.setOverDueAmount(overAmount.add(orderPO.getOverDueAmount()));
		}
		log.info("OverDueService.addOverdueAmount.debitOrderId=" + orderPO.getId() + ",overdueAmountPerDay=" + overAmount + ",totalOverdueAmount=" + updatePO.getOverDueAmount());
		doMerchantDebitOrderDAO.updateByPrimaryKeySelective(updatePO);
	}

	/**
	 * 计算逾期利率
	 * 
	 * @return
	 */
	private BigDecimal calOverDueAmount(BigDecimal amount) {
		String rate = debitConfigService.getByKey(ConfigEnums.OVER_DUE_RATE);
		BigDecimal dueRate = new BigDecimal(20);// 默认逾期费率
		if (StringUtils.isNotBlank(rate)) {
			dueRate = new BigDecimal(rate);
		}
		return amount.multiply(dueRate).divide(BigDecimal.valueOf(10000)).setScale(2, BigDecimal.ROUND_UP);
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
