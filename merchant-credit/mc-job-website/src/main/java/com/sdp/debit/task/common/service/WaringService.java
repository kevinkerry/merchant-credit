package com.sdp.debit.task.common.service;

import java.math.BigDecimal;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sdp.mc.common.constant.MerchantCreditConstant;
import com.sdp.mc.common.enums.AlertMessageSendTypeEnum;
import com.sdp.mc.common.util.ConfigOptionHelper;
import com.sdp.mc.config.manager.ConfigOptionManager;
import com.sdp.mc.dao.readonly.merchant.CmPosMerchantFastEOExt;
import com.sdp.mc.dao.readonly.merchant.CmPosMerchantNewDAO;
import com.sdp.mc.integration.ma.dto.MerchantBalanceDTO;
import com.sdp.mc.ma.wrapper.AccountQueryFacadeWrapper;
import com.sdp.withdraw.enums.PosMerchantTypeEnums;
import com.shengpay.service.alert.factory.AlertMessageSenderFactory;
import com.shengpay.service.mail.AlertMessageSender;

@Service
public class WaringService {

	private static Logger log = LoggerFactory.getLogger(WaringService.class);
	@Autowired
	private ConfigOptionManager configOptionManager;
	@Autowired
	private AccountQueryFacadeWrapper accountQueryFacadeWrapper;

	@Autowired
	private AlertMessageSenderFactory alertMessageSenderFactory;

	private static ExecutorService executorService = Executors.newFixedThreadPool(5);
	@Autowired
	private CmPosMerchantNewDAO cmPosMerchantNewDAO;

	/**
	 * 发送预警邮件
	 *
	 * @param title
	 * @param content
	 */
	private void sendMail(final String title, final String content) {
		log.info("WaringService.job.sendMail title=" + title + "content=" + content);
		final String mailList = ConfigOptionHelper.getConfigByKey(MerchantCreditConstant.NEWT0_WARING_MAIL_LIST);
		if (StringUtils.isBlank(mailList)) {
			log.error("FOSFacade4DebitImpl.sendMail.error,mail list is not configured");
			return;
		}
		Thread t = new Thread() {
			public void run() {
				try {
					AlertMessageSender sender = alertMessageSenderFactory.getAlertMessageSender(AlertMessageSendTypeEnum.MAIL_ALERT);
					sender.sendHtmlMessage(title, content, mailList);
				} catch (Exception e) {
					log.error("FOSFacade4DebitImpl.sendMail.error,content=" + content, e);
				}
			}
		};
		executorService.execute(t);
	}

	public void run() {
		log.info("WaringService.job.starting");
		checkAmount();
		log.info("WaringService.job.end");
	}

	/**
	 *
	 *
	 */
	public void checkAmount() {
		List<CmPosMerchantFastEOExt> extList = cmPosMerchantNewDAO.selectFastAmount();
		MerchantBalanceDTO merchantBalanceDto;
		try {
			StringBuffer mailContent=new StringBuffer();
			for (CmPosMerchantFastEOExt ext : extList) {
					try {
						// 保证金金额信息 
						merchantBalanceDto = accountQueryFacadeWrapper.queryMerchantBalance(ext.getMemberId(),ext.getMctype());
						// 保证金金额
						BigDecimal marginAccountBalance = BigDecimal.ZERO;
						marginAccountBalance = merchantBalanceDto.getMarginAccountBalance();
						log.info("WaringService#checkAmount memberId:"+ext.getMemberId()+"  marginAccountBalance:" + marginAccountBalance);
						// 保证金额度
						BigDecimal marginPpcpayBalance = ext.getPmtFastSettleMargin();
						log.info("WaringService#checkAmount memberId:"+ext.getMemberId()+"  marginPpcpayBalance:" + marginPpcpayBalance);
						// 未到账金额
						BigDecimal sumAmount = ext.getAmount();
						log.info("WaringService#checkAmount  memberId:"+ext.getMemberId()+"   sumAmount:" + sumAmount);
						// 保证金额度余额=配置失败+保证金额
						BigDecimal amount = marginPpcpayBalance.add(sumAmount);
						log.info("WaringService#checkAmount  memberId:"+ext.getMemberId()+"   amount:" + amount);
						if(marginAccountBalance!=null){
							if (marginAccountBalance.compareTo(amount) != 0) {
								/**
								 * 查询代理商信息
								 */
								mailContent.append(getContextRecord(ext.getPromoterIdStr(),ext.getPromoterName(),ext.getMerchantNo(),marginAccountBalance, marginPpcpayBalance, sumAmount,ext.getMctype()));
							}
						}
					} catch (Exception e) {
						log.error("checkAmount  error "+e.getMessage(),e);
					}
				}
			if(mailContent!=null&&mailContent.length()>0){
				sendMail("快速结算保证金额度与保证金账户余额不相等",
						subContext(mailContent.toString()));
			}

		} catch (Exception e) {
			log.error("WaringService#checkAmount  error "+e.getMessage(),e);
		}

	}



	/**
	 * 拼接邮件内容
	 *
	 * @param cmerchantEo
	 * @param marginAccountBalance
	 * @param marginPpcpayBalance
	 * @return
	 */
	public String subContext(String records) {
		
		StringBuffer sbContext = new StringBuffer();
		sbContext.append("<table border='1'>");
		sbContext.append("<caption align='top'>快速结算额度与保证金账户余额不相等</caption>");
		sbContext.append("<tr> ");
			sbContext.append("<th width='10%'>拓展方商户号</th>");
			sbContext.append("<th width='10%'>拓展方商户ID</th>");
			sbContext.append("<th width='10%'>拓展方名称</th>");
			sbContext.append("<th width='10%'>类型</th>");
			sbContext.append("<th width='10%'>保证金账户余额</th>");
			sbContext.append("<th width='10%'>快速结算保证金额度</th>");
			sbContext.append("<th width='10%'>快速结算未到账金额</th>");
		sbContext.append("</tr>");
		sbContext.append(records);
		sbContext.append("</table> ");
		return sbContext.toString();
	}
	public String getContextRecord(String promoterID,String promoterName,String merchantNo, BigDecimal marginAccountBalance, BigDecimal marginPpcpayBalance, BigDecimal sumAmount,String mcType) {
		log.info("WaringService.job.subContext promoterID=" + promoterID + ",  promoterName="+promoterName+",marginAccountBalance="
				+ marginAccountBalance + ",marginPpcpayBalance=" + marginPpcpayBalance);
		StringBuffer sbContext = new StringBuffer();
		sbContext.append("<tr> ");
		sbContext.append("<td width='10%'>"+merchantNo+"</th>");
		sbContext.append("<td width='10%'>"+promoterID+"</td>");
		sbContext.append("<td width='10%'>"+promoterName+"</td>");
		sbContext.append("<td width='10%'>"+PosMerchantTypeEnums.getMerchantTypeByCode(mcType).desc+"</td>");
		sbContext.append("<td width='10%'>"+marginAccountBalance+"</td>");
		sbContext.append("<td width='10%'>"+marginPpcpayBalance+"</td>");
		sbContext.append("<td width='10%'>"+sumAmount+"</td>");
		sbContext.append("</tr>");
		return sbContext.toString();
	}

}
