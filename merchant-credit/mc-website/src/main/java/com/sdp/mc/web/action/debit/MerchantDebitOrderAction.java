package com.sdp.mc.web.action.debit;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sdo.common.util.DateUtil;
import com.sdp.mc.common.util.MaskUtil;
import com.sdp.mc.common.vo.ErrorMessageVO;
import com.sdp.mc.common.web.MCMerchantUser;
import com.sdp.mc.integration.ma.dto.PersionalInfoDTO;
import com.sdp.mc.ma.wrapper.MaOnlineWrapper;
import com.sdp.mc.web.action.BaseAction;
import com.shengpay.debit.common.enums.MerchantDebitOrderStatusEnums;
import com.shengpay.debit.common.service.MerchantCreditLinesApplyService;
import com.shengpay.debit.common.service.MerchantDebitApplyService;
import com.shengpay.debit.common.service.MerchantDebitOrderService;
import com.shengpay.debit.dal.dataobject.DmMerchantDebitInfoPO;
import com.shengpay.debit.dal.dataobject.DoMerchantCreditLinesApplyPO;
import com.shengpay.debit.dal.dataobject.DoMerchantDebitOrderPO;
import com.shengpay.debit.dal.ext.dataobject.ExtDoMerchantDebitOrderExample;

/**
 * 商户借款订单相关操作
 *
 * @author wangjingao.william
 * **/
@Controller
@RequestMapping(value = {"/posMerchant", "/mposMerchant"})
public class MerchantDebitOrderAction extends BaseAction {
	private static final Logger logger = LoggerFactory.getLogger(MerchantDebitOrderAction.class);

	@Autowired
	private MerchantDebitOrderService merchantDebitOrderService;

	@Autowired
	private MerchantCreditLinesApplyService merchantCreditLinesApplyService;

	@Autowired
	private MaOnlineWrapper maOnlineWrapper;

	@Autowired
	private MerchantDebitApplyService merchantDebitApplyService;
	/**
	 * 我的借款
	 * **/
	@RequestMapping(value = "/debit/myDebitOrders")
	public String myDebitOrders(HttpServletRequest request, HttpServletResponse response, ModelMap model) {
		MCMerchantUser user = MCMerchantUser.getMCMerchantUser(request.getSession());
		BigDecimal totalDebitAmount = this.merchantDebitOrderService.sumDebitAmount(user.getMerchantNo());
		BigDecimal debitAmount = this.merchantDebitOrderService.sumDebitAmountInLast5Days(user.getMerchantNo());
		Integer debitCount = this.merchantDebitOrderService.countDebitAmountInLast5Days(user.getMerchantNo());
		model.put("totalDebitAmount", totalDebitAmount);
		model.put("debitAmount", debitAmount);
		model.put("debitCount", debitCount);
		return "/main/debit/loan/myDebitOrdersIndex";
	}

	private void queryMerchantDebitOrder(ExtDoMerchantDebitOrderExample query, ModelMap model) {
		List<DoMerchantDebitOrderPO> dataList = this.merchantDebitOrderService.pageQueryMerchantDebitOrder(query);
		model.put("dataList", dataList);
		model.put("query", query);
	}

	/**
	 * 我的借款-ajax分页查询
	 * **/
	@RequestMapping(value = "/ajaxPaging/myDebitOrdersList")
	public String queryMyDebitOrders(String tab, ExtDoMerchantDebitOrderExample query, HttpServletRequest request, HttpServletResponse response, ModelMap model) {
		MCMerchantUser user = MCMerchantUser.getMCMerchantUser(request.getSession());
		if ("0".equals(tab)) {
			// 默认还款中借款
			//query.setStatus(MerchantDebitOrderStatusEnums.PAYBACKING.getKey());
			Date tomorrow = DateUtil.getDateNearCurrent(1);
			String repaymentStartTimeStr = DateUtil.getWebDateString(tomorrow);
			query.setRepaymentStartTimeStr(repaymentStartTimeStr);
		} else {
//			List<String> statusList = new ArrayList<String>();
//			statusList.add(MerchantDebitOrderStatusEnums.OVERDUEING.getKey());
//			statusList.add(MerchantDebitOrderStatusEnums.OVERDUEING_PAYBACK_SUCCESS.getKey());
//			statusList.add(MerchantDebitOrderStatusEnums.NORMAL_PAYBACK_SUCCESS.getKey());
//			query.setStatusList(statusList);
			query.setQueryExpiredFlag("Y");
		}
		query.setMerchantNo(user.getMerchantNo());
		this.queryMerchantDebitOrder(query, model);
		return "/main/debit/loan/myDebitOrdersList";
	}

	/**
	 * 借款申请记录
	 * **/
	@RequestMapping(value = "/debit/debitRecordIndex")
	public String debitRecordIndex(HttpServletRequest request, HttpServletResponse response, ModelMap model) {
		return "/main/debit/loan/debitRecordIndex";
	}

	/**
	 * 借款申请记录分页查询
	 * **/
	@RequestMapping(value = "/ajaxPaging/debitRecordList")
	public String queryDebitRecord(ExtDoMerchantDebitOrderExample query, HttpServletRequest request, HttpServletResponse response, ModelMap model) {
		MCMerchantUser user = MCMerchantUser.getMCMerchantUser(request.getSession());
		query.setMerchantNo(user.getMerchantNo());
		this.queryMerchantDebitOrder(query, model);
		model.put("query", query);
		return "/main/debit/loan/debitRecordList";
	}

	/**
	 * 逾期管理
	 * **/
	@RequestMapping(value = "/overdue/index")
	public String overdueIndex(HttpServletRequest request, HttpServletResponse response, ModelMap model) {
		try {
			payPwdInit(model);
			MCMerchantUser user = MCMerchantUser.getMCMerchantUser(request.getSession());
			DoMerchantCreditLinesApplyPO applyInfo = this.merchantCreditLinesApplyService.getLatestCreditLines(user.getMerchantNo());
			model.put("loginName", MaskUtil.getLoginName(applyInfo.getLendLoginName()));
		} catch (Exception e) {
			model.put("errorMessage", "系统繁忙，请刷新页面");
			logger.error("MerchantDebitOrderAction.overdueIndex.error,invoke ues getCert failed,retry again", e);
		}
		return "/main/debit/overdue/index";
	}

	/**
	 * 逾期管理-ajax分页查询
	 * **/
	@RequestMapping(value = "/ajaxPaging/queryMerchantDebitOrder")
	public String queryMerchantDebitOrder(ExtDoMerchantDebitOrderExample query, HttpServletRequest request, HttpServletResponse response, ModelMap model) {
		MCMerchantUser user = MCMerchantUser.getMCMerchantUser(request.getSession());
		query.setStatus(MerchantDebitOrderStatusEnums.OVERDUEING.getKey());
		query.setMerchantNo(user.getMerchantNo());
		this.queryMerchantDebitOrder(query, model);
		return "/main/debit/overdue/queryMerchantDebitOrderList";
	}

	private static final String OVERDUE_PAYBACK_TOKEN = "overdue_payback_token";
	private void clearToken(HttpServletRequest request){
		request.getSession().removeAttribute(OVERDUE_PAYBACK_TOKEN);
	}
	/**
	 * 逾期管理--立即还款
	 *
	 * @param id
	 *            商户借款订单表id
	 * @param pwd
	 *            支付密码
	 * @param encryptedKey
	 *            ues密钥
	 * @param certSerialNo
	 *            ues证书序列号
	 * @param amount
	 *            还款金额
	 * @return errorMessage
	 * **/
	@RequestMapping(value = "/overdue/overdueRepayment")
	@ResponseBody
	public ErrorMessageVO overdueRepayment(Long id, HttpServletRequest request, HttpServletResponse response, ModelMap model) {
		try {
			// token
			String token = (String) request.getSession().getAttribute(OVERDUE_PAYBACK_TOKEN);
			if (StringUtils.isBlank(token)) {
				token = UUID.randomUUID().toString();
				request.getSession().setAttribute(OVERDUE_PAYBACK_TOKEN, token);
			} else {
				return new ErrorMessageVO(false, "-1", "重复请求");
			}
			MCMerchantUser user = MCMerchantUser.getMCMerchantUser(request.getSession());
			// 查询负债信息表
			DmMerchantDebitInfoPO dmMerchantDebitInfoPO = merchantDebitApplyService.queryDebitMerchantDebitInfo(user.getMerchantNo());
			// 查询钱包账户的operatorId
			PersionalInfoDTO persionalInfo = this.maOnlineWrapper.getPersionalMemberId(dmMerchantDebitInfoPO.getLendLoginName());
			// 验支付密码
			ErrorMessageVO errorMessage = checkPassword(persionalInfo, request);
			if (!errorMessage.isSuccess()) {
				clearToken(request);
				return new ErrorMessageVO(false, "-1", errorMessage.getErrorMessage());
			}
			// 逾期还款逻辑
			errorMessage = this.merchantDebitOrderService.overdueRepayment(id);
			clearToken(request);
			return errorMessage;
		} catch (Exception e) {
			logger.error("MerchantDebitOrderAction.overdueRepayment.error,debitOrderId=" + id, e);
			clearToken(request);
			return new ErrorMessageVO(false, "-1", "系统繁忙，请稍后再试");
		}
	}
}
