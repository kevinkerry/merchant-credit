package com.sdp.mc.web.action.applyDebit;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.Date;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sdp.debit.web.enums.CreditLineResponseEnum;
import com.sdp.mc.common.constant.MerchantCreditConstant;
import com.sdp.mc.common.enums.AccountType;
import com.sdp.mc.common.util.ConfigOptionHelper;
import com.sdp.mc.common.util.MaskUtil;
import com.sdp.mc.common.vo.ErrorMessageVO;
import com.sdp.mc.common.web.MCMerchantUser;
import com.sdp.mc.config.manager.ConfigOptionManager;
import com.sdp.mc.integration.ma.dto.PersionalInfoDTO;
import com.sdp.mc.ma.wrapper.MaOnlineWrapper;
import com.sdp.mc.web.action.BaseAction;
import com.sdp.mc.web.dto.ApplyDebitDTO;
import com.shengpay.debit.common.enums.ConfigEnums;
import com.shengpay.debit.common.enums.DebitOrganizationEnum;
import com.shengpay.debit.common.enums.MerchantDebitOrderStatusEnums;
import com.shengpay.debit.common.service.DebitConfigService;
import com.shengpay.debit.common.service.MerchantCreditLinesApplyService;
import com.shengpay.debit.common.service.MerchantDebitApplyService;
import com.shengpay.debit.common.service.OrgCreditSettingService;
import com.shengpay.debit.credit.lines.apply.enums.CreditLinesApplyStatusEnums;
import com.shengpay.debit.dal.dataobject.DbOrgCreditSettingPO;
import com.shengpay.debit.dal.dataobject.DmMerchantDebitInfoPO;
import com.shengpay.debit.dal.dataobject.DoMerchantCreditLinesApplyPO;
import com.shengpay.debit.dal.dataobject.DoMerchantDebitOrderPO;
import com.shengpay.debit.merchant.account.enums.DebitAccountEnums;

/**
 * 借款申请
 */
@Controller
@RequestMapping(value = { "/posMerchant", "/mposMerchant" })
public class ApplyDebitAction extends BaseAction {

	private static Logger log = LoggerFactory.getLogger(ApplyDebitAction.class);
	private static final String MESSAGE = "message";
	private static final String CODE = "code";
	@Autowired
	private MerchantDebitApplyService merchantDebitApplyService;

	@Autowired
	private MaOnlineWrapper maOnlineWrapper;

	@Autowired
	private DebitConfigService debitConfigService;

	@Autowired
	private OrgCreditSettingService orgCreditSettingService;

	@Autowired
	protected MerchantCreditLinesApplyService merchantCreditLinesApplyService;

	// @Autowired
	// private AccountQueryFacadeWrapper accountQueryFacadeWrapper;

	@Autowired
	private ConfigOptionManager configOptionManager;

	@RequestMapping("/debit/init")
	public String applyDebitIndex(ModelMap model, HttpServletRequest request, HttpServletResponse response) throws IOException {
		try {
			MCMerchantUser user = MCMerchantUser.getMCMerchantUser(request.getSession());
			if (user == null || user.getPromoterId() == null) {
				model.put(MESSAGE, "您尚未登录！");
				return "/main/debit/loan/index";
			}
			// 查询最近一次申购
			DoMerchantCreditLinesApplyPO applyPO = merchantCreditLinesApplyService.getLatestCreditLines(user.getMerchantNo());
			if (applyPO == null || (!CreditLinesApplyStatusEnums.APLY_SUCCESS.key.equals(applyPO.getApplyStatus()))) {
				model.put(MESSAGE, "对不起，天天贷还未对您的额度申请审核完毕，请耐心等待");
				return "/main/debit/loan/index";
			} else {
				setAgreementView(request, model, applyPO);
			}
			// 是否开通借款功能
			DmMerchantDebitInfoPO dmMerchantDebitInfoPO = merchantDebitApplyService.queryDebitMerchantDebitInfo(user.getMerchantNo());
			if (dmMerchantDebitInfoPO == null || !DebitAccountEnums.ACCOUNT_CAN_USE.getKey().equals(dmMerchantDebitInfoPO.getStatus())) {
				model.put(MESSAGE, "对不起，您还有逾期未还借款，请先还清逾期借款");
				model.put(CODE, "overdue");
				return "/main/debit/loan/index";
			}
			// 校验协议是否到期
			if (applyPO.getPolicyEndTime().before(new Date())) {
				model.put(MESSAGE, "对不起，协议已到期，请重新申请");
				return "/main/debit/loan/index";
			}
			// 日息费率
			String orgnizationCode = dmMerchantDebitInfoPO.getOrganizationCode();
			String riskLevel = dmMerchantDebitInfoPO.getRiskLevel();
			BigDecimal interestRateDay = BigDecimal.ZERO;
			if (null != riskLevel) {
				interestRateDay = merchantDebitApplyService.getInterestRateDay(orgnizationCode, riskLevel);
				model.put("interestRateDay", interestRateDay);
			} else {
				model.put("interestRateDay", BigDecimal.valueOf(0.00));

			}

			String serverRate = this.debitConfigService.getByKey(ConfigEnums.DEBIT_ORDER_SERVER_RATE);
			BigDecimal _serverRate = new BigDecimal(serverRate);
			BigDecimal fRate = interestRateDay.subtract(_serverRate);

			model.put("fRate", fRate.divide(BigDecimal.valueOf(100)));
			model.put("sRate", _serverRate.divide(BigDecimal.valueOf(100)));
			BigDecimal canUseAmount = dmMerchantDebitInfoPO.getCanUseAmount();// 当前可用总额度
			model.put("canUseAmount", canUseAmount);
			// 放款钱包账户登录名
			model.put("lendLoginName", MaskUtil.getLoginName(dmMerchantDebitInfoPO.getLendLoginName()));
			// 初始化密码
			payPwdInit(model);
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			model.put(MESSAGE, "网络繁忙，多次尝试后请联系客服");
			return "/main/debit/loan/index";
		}
		return "/main/debit/loan/index";
	}

	/**
	 * 获取协议额度内容
	 * 
	 * @return
	 * @throws Exception
	 */
	private void setAgreementView(HttpServletRequest request, ModelMap model, DoMerchantCreditLinesApplyPO applyPo) throws Exception {
		if (StringUtils.isNotBlank(applyPo.getRiskLevel())) {
			DbOrgCreditSettingPO dbOrgCreditSettingPO = orgCreditSettingService.selectByRiskLevel(applyPo.getRiskLevel());
			if (dbOrgCreditSettingPO != null) {
				model.put("amountLimit", dbOrgCreditSettingPO.getAmountLimit().toString());
				BigDecimal totalRate = dbOrgCreditSettingPO.getInterestRateDay();
				// 取出利息占比
				// String _rateOfInterestInTotal =
				// this.debitConfigService.getByKey(ConfigEnums.DEBIT_ORDER_INTEREST_IN_TOTAL);
				// BigDecimal rateOfInterestInTotal = new
				// BigDecimal(_rateOfInterestInTotal);
				// BigDecimal fRate =
				// totalRate.multiply(rateOfInterestInTotal).setScale(2,
				// RoundingMode.HALF_UP);

				// 取出利息占比
				String serverRate = this.debitConfigService.getByKey(ConfigEnums.DEBIT_ORDER_SERVER_RATE);
				BigDecimal _serverRate = new BigDecimal(serverRate);
				BigDecimal fRate = totalRate.subtract(_serverRate);

				model.put("fRate", fRate.divide(BigDecimal.valueOf(100)));
				model.put("sRate", _serverRate.divide(BigDecimal.valueOf(100)));
			}
		}
	}

	/**
	 * 暂时先不做任何操作
	 * 
	 * @param dto
	 * @param request
	 * @param response
	 * @return
	 * @throws IOException
	 */
	@RequestMapping("/debit/{id}/success")
	public String applyResutl(@PathVariable("id") Long id, ModelMap map, HttpServletRequest request, HttpServletResponse response) throws IOException {
		ErrorMessageVO errorMessage = merchantDebitApplyService.applyResutl(id, map);
		if (errorMessage.isSuccess()) {// 待扩展
			return "/main/debit/loan/success";
		} else {
			return "/main/debit/loan/success";
		}
	}

	private static final String DEBIT_ORDER_TOKEN = "debit_order_token";

	private void clearToken(HttpServletRequest request) {
		request.getSession().removeAttribute(DEBIT_ORDER_TOKEN);
	}

	/**
	 * 借款请求操作
	 * 
	 * @param dto
	 * @param request
	 * @param response
	 * @return
	 * @throws IOException
	 */
	@RequestMapping("/debit/apply")
	@ResponseBody
	public ErrorMessageVO applyDebit(ApplyDebitDTO dto, HttpServletRequest request, HttpServletResponse response) throws IOException {
		try {
			// 借款token
			String token = (String) request.getSession().getAttribute(DEBIT_ORDER_TOKEN);
			if (StringUtils.isBlank(token)) {
				token = UUID.randomUUID().toString();
				request.getSession().setAttribute(DEBIT_ORDER_TOKEN, token);
			} else {
				return new ErrorMessageVO(false, "-1", "重复请求");
			}
			// 判断天天贷服务是否关闭
			Boolean isSwitchOff = ConfigOptionHelper.getBooleanByKey(MerchantCreditConstant.TTD_SWITCH_OFF);
			if (isSwitchOff) {
				clearToken(request);
				return new ErrorMessageVO(false, "-1", CreditLineResponseEnum.TTD_SERVICE_SHUT_DOWN.name);
			}
			MCMerchantUser user = MCMerchantUser.getMCMerchantUser(request.getSession());
			if (user == null || user.getPromoterId() == null) {
				clearToken(request);
				return new ErrorMessageVO(false, "-1", "您尚未登录！");
			}
			// 是否通过额度申请
			DoMerchantCreditLinesApplyPO applyPO = merchantCreditLinesApplyService.getLatestCreditLines(user.getMerchantNo());
			if (applyPO == null || (!CreditLinesApplyStatusEnums.APLY_SUCCESS.key.equals(applyPO.getApplyStatus()))) {
				clearToken(request);
				return new ErrorMessageVO(false, "-1", "对不起，天天贷还未对您的额度申请审核完毕，请耐心等待");
			}
			// 校验协议是否到期
			if (applyPO.getPolicyEndTime().before(new Date())) {
				clearToken(request);
				return new ErrorMessageVO(false, "-1", "对不起，协议已到期，请重新申请");
			}
			DmMerchantDebitInfoPO dmMerchantDebitInfoPO = merchantDebitApplyService.queryDebitMerchantDebitInfo(user.getMerchantNo());
			// 是否出现借款逾期
			if (DebitAccountEnums.DEBIT_OVER_DUE.getKey().equals(dmMerchantDebitInfoPO.getStatus())) {
				clearToken(request);
				return new ErrorMessageVO(false, "-1", "对不起，您还有逾期未还借款，请先还清逾期借款");
			}
			// 参数校验
			BigDecimal canUseAmount = dmMerchantDebitInfoPO.getCanUseAmount();// 当前可用总额度
			BigDecimal debitAmount = dto.getDebitAmount(); // 借款金额
			if (debitAmount.compareTo(BigDecimal.ZERO) <= 0) {
				clearToken(request);
				return new ErrorMessageVO(false, "-1", "金额输入错误，请重新输入");
			}
			if (debitAmount.compareTo(canUseAmount) > 0) {
				clearToken(request);
				return new ErrorMessageVO(false, "-1", "借款金额不能超过可用总额度");
			}
			// 查询个人钱包账户状态
			// MerchantBaseBalanceDTO personalAccount =
			// this.accountQueryFacadeWrapper.queryAccountBalanceByAccountType(dmMerchantDebitInfoPO.getLendMemberId(),
			// AccountType.C_BASE_ACCOUNT);
			// if (personalAccount == null || personalAccount.getAccountStatus()
			// != AccountStatus.AccountStatusActive.getCode()) {
			// clearToken(request);
			// return new ErrorMessageVO(false, "-1", "放款钱包账户状态异常，请联系客服处理");
			// }
			// 查询钱包账户的operatorId
			PersionalInfoDTO persionalInfo = this.maOnlineWrapper.getPersionalMemberId(dmMerchantDebitInfoPO.getLendLoginName());
			// 验证支付密码
			ErrorMessageVO errorMessage = checkSecPwd(dmMerchantDebitInfoPO.getLendMemberId(), dmMerchantDebitInfoPO.getLendLoginName(), persionalInfo.getOperatorId(),
					dto.getPassword(), dto.getEncryptedKey(), dto.getCertSerialNo(), AccountType.C_BASE_ACCOUNT, request);
			if (!errorMessage.isSuccess()) {
				clearToken(request);
				return errorMessage;
			}
			boolean isAgentGuarantee = "1".equals(applyPO.getIsAgnetGuarantee());
			ErrorMessageVO error = merchantDebitApplyService.debitApply(toDoMerchantDebitOrderPO(dto, dmMerchantDebitInfoPO, user), isAgentGuarantee, user);
			clearToken(request);
			return error;
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			clearToken(request);
			return new ErrorMessageVO(false, "-1", "网络繁忙，多次尝试后请联系客服");
		}
	}

	private DoMerchantDebitOrderPO toDoMerchantDebitOrderPO(ApplyDebitDTO dto, DmMerchantDebitInfoPO dmMerchantDebitInfoPO, MCMerchantUser user) {
		DoMerchantDebitOrderPO po = new DoMerchantDebitOrderPO();
		po.setMerchantNo(dmMerchantDebitInfoPO.getMerchantNo());
		po.setMerchantName(dmMerchantDebitInfoPO.getMerchantName());
		po.setOrganizationCode(DebitOrganizationEnum.SFT.code);
		po.setStatus(MerchantDebitOrderStatusEnums.INIT.getKey());
		po.setDebitAmount(dto.getDebitAmount());
		po.setPurposer(dto.getPurposer());
		po.setPromoterNo(dmMerchantDebitInfoPO.getPromoterNo());
		po.setPromoterName(dmMerchantDebitInfoPO.getPromoterName());
		po.setApplyDate(new Date());
		// po.setTransferTime(new Date());
		// po.setStartTime(new Date());
		// Date endTime = DateUtil.addDays(po.getStartTime(),
		// dto.getBorrowDays().intValue());
		// po.setEndTime(endTime);
		// // 逾期时间是结束时间+1
		// Date overDueTime = DateUtil.addDays(po.getStartTime(),
		// dto.getBorrowDays().intValue() + 1);
		// po.setOverDueTime(overDueTime);
		po.setInterestAmount(dto.getInterestAmount());
		po.setBorrowDays(dto.getBorrowDays());
		po.setServiceAmount(dto.getServiceAmount());
		po.setInterestRateDay(dto.getInterestRateDay());
		// 实际放款金额=借款金额-利息-服务费
		BigDecimal realAmount = dto.getDebitAmount().subtract(dto.getInterestAmount()).subtract(dto.getServiceAmount());
		po.setRealAmount(realAmount);
		po.setCreateTime(new Date());
		po.setUpdateTime(new Date());
		return po;
	}

}
