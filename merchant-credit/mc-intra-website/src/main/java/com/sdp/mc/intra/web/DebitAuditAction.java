package com.sdp.mc.intra.web;

import java.io.Writer;
import java.math.BigDecimal;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.sdp.emall.intra.admin.security.util.SecurityUserHolder;
import com.sdp.mc.common.enums.UserOperaRecordEnum;
import com.sdp.mc.common.vo.ErrorMessageVO;
import com.shengpay.debit.common.enums.ConfigEnums;
import com.shengpay.debit.common.risk.model.CreditLineApplyRequest;
import com.shengpay.debit.common.risk.model.CreditRiskResult;
import com.shengpay.debit.common.risk.model.CreditRiskTypes;
import com.shengpay.debit.common.risk.model.CreditRiskTypesItems;
import com.shengpay.debit.common.risk.model.GetCreditRiskResponseModel;
import com.shengpay.debit.common.service.CreditLineManager;
import com.shengpay.debit.common.service.CreditLinesApplyService;
import com.shengpay.debit.common.service.CreditRiskService;
import com.shengpay.debit.common.service.DebitApplyService;
import com.shengpay.debit.common.service.DebitConfigService;
import com.shengpay.debit.common.service.MerchantAccountService;
import com.shengpay.debit.common.service.MerchantCreditLinesApplyService;
import com.shengpay.debit.common.service.MerchantDebitApplyService;
import com.shengpay.debit.common.service.MerchantDebitOrderService;
import com.shengpay.debit.common.service.OrgCreditSettingService;
import com.shengpay.debit.credit.lines.apply.enums.CreditLinesApplyStatusEnums;
import com.shengpay.debit.dal.dataobject.DbOrgCreditSettingPO;
import com.shengpay.debit.dal.dataobject.DmMerchantDebitInfoPO;
import com.shengpay.debit.dal.dataobject.DoMeCreditLinesApplyInfoPO;
import com.shengpay.debit.dal.dataobject.DoMerchantCreditLinesApplyPO;
import com.shengpay.debit.dal.dataobject.DoMerchantDebitOrderPO;
import com.shengpay.debit.dal.ext.dataobject.ExtDoMerchantCreditLinesApplyExample;
import com.shengpay.debit.dal.ext.dataobject.ExtDoMerchantDebitOrderExample;
import com.shengpay.debit.dal.ext.dataobject.LoanDebitOrderDTO;
import com.shengpay.debit.ext.daointerface.ExtDoMerchantCreditLinesApplyDAO;
import com.shengpay.debit.merchant.account.enums.DebitAccountEnums;
import com.shengpay.model.fileManager.UploadFileResponse;
import com.shengpay.service.fileManager.FileManagerService;
/**
 * 代理商承诺页面操作
 * **/
@Controller
@RequestMapping(value = { "/debitAudit" })
public class DebitAuditAction {
	private static final Logger logger = LoggerFactory.getLogger(DebitAuditAction.class);

	@Autowired
	private ExtDoMerchantCreditLinesApplyDAO extDoMerchantCreditLinesApplyDAO;

	@Autowired
	private OrgCreditSettingService orgCreditSettingService;

	@Autowired
	private CreditLinesApplyService creditLinesApplyService;

	@Autowired
	private MerchantAccountService merchantAccountService;

	@Autowired
	private MerchantCreditLinesApplyService merchantCreditLinesApplyService;

	@Autowired
	private CreditRiskService creditRiskService;

	@Autowired
	private CreditLineManager creditLineManager;

	@Autowired
	private FileManagerService fileService;

	@Autowired
	private MerchantDebitApplyService merchantDebitApplyService;
	@Autowired
	private MerchantDebitOrderService merchantDebitOrderService;

	@Autowired
	private DebitConfigService debitConfigService;
	@Autowired
	private DebitApplyService debitApplyService;

	/**
	 * 初始化查询页面
	 * **/
	@RequestMapping(value = "/initQueryDebitApplyMerchant")
	public String initTueryDebitApplyMerchant(HttpServletRequest request, ModelMap model) {
		List<DbOrgCreditSettingPO> riskLevels = this.orgCreditSettingService.getAllRiskLevelByOrgCode("SFT");
		model.put("riskLevels", riskLevels);
		return "/debit/apply/index";
	}

	/**
	 * 查询贷款申请记录
	 * **/
	@RequestMapping(value = "/ajaxPaging/queryDebitApplyMerchants")
	public String queryDebitApplyMerchants(ExtDoMerchantCreditLinesApplyExample query, HttpServletRequest request, ModelMap model) {
		List<DoMerchantCreditLinesApplyPO> dataList = this.extDoMerchantCreditLinesApplyDAO.pageQueryDebitApplyMerchants(query);
		model.put("dataList", dataList);
		model.put("query", query);
		return "/debit/apply/queryMerchantList";
	}

	/**
	 * 查看商户的详细资料
	 * **/
	@RequestMapping(value = "/showDetailInfo")
	public String applyDetailInfo(Long applyId, HttpServletRequest request, ModelMap model) {
		try {
			// 查询最近一次申购
			DoMerchantCreditLinesApplyPO applyPO = merchantCreditLinesApplyService.selectById(applyId);
			model.put("applyPo", applyPO);
			CreditLineApplyRequest creditLineApplyRequest= debitApplyService.getCreditLineApplyRequest(applyPO);
			model.put("creditLineApplyRequest", creditLineApplyRequest);
		} catch (Exception e) {
			logger.error("CreditLinesApplyAction.applyWindDetailInfo.error,applyId=" + applyId, e);
		}
		return "/debit/apply/positionApplyDetail";
	}

	/**
	 * 查看商户的详细资料
	 * **/
	@RequestMapping(value = "/updateFileInfo")
	public void updateFileInfo(UploadFileResponse creditReportFileInfo, HttpServletRequest request, ModelMap model, HttpServletResponse response) {
		Long id = Long.parseLong(request.getParameter("id"));
		try {
			merchantCreditLinesApplyService.updatereditUploadFile(creditReportFileInfo, id);
		} catch (Exception e) {
			logger.error("CreditLinesApplyAction.updateFileInfo.error,applyId=" + id, e);
		}
		writeJson(response, "0");
	}

	/**
	 * 将url参数转换成map
	 *
	 * @param param
	 *            aa=11&bb=22&cc=33
	 * @return
	 */
	private static Map<String, String> getUrlParams(String param) {
		Map<String, String> map = new HashMap<String, String>(0);
		if (StringUtils.isBlank(param)) {
			return map;
		}
		String[] params = param.split("&");
		for (int i = 0; i < params.length; i++) {
			String[] p = params[i].split("=");
			if (p.length == 2) {
				map.put(p[0], p[1]);
			}
		}
		return map;
	}

	/**
	 * 向response里面写入返回的json
	 *
	 * @param response
	 * @param obj
	 */
	public static void writeJson(final HttpServletResponse response, final Object obj, String... agentType) {
		try {
			response.setCharacterEncoding("UTF-8");
			if (agentType.length > 0) {
				if (agentType[0].equals("ie10")) {
					response.setContentType("application/htm");
				} else if (!agentType[0].equals("ie10") && agentType[0].indexOf("ie") >= 0) {
					response.setContentType("application/htm");
				} else {
					response.setContentType("application/json");
				}
			} else {
				response.setContentType("application/json");
			}
			Writer writer = response.getWriter();
			String json = JSON.toJSONString(obj);
			writer.write(json);
			writer.flush();
			writer.close();
		} catch (Exception e) {
			logger.error("CreditLinesApplyAction.writeJson.error" + e.getMessage(), e);
		}
	}

	/**
	 * 获取更新
	 *
	 * @return
	 * @throws Exception
	 */
	private void initDetailInfo(ModelMap model, DoMerchantCreditLinesApplyPO applyPo) throws Exception {
		// 风控项初始化
		GetCreditRiskResponseModel riskModel = creditRiskService.getCreditRiskModel();
		List<CreditRiskTypes> riskTypes = riskModel.getTypes();
		Map<String, DoMeCreditLinesApplyInfoPO> maps = creditLineManager.selectByDoApplyPO(applyPo);

		model.put("creditPassword", maps.get("otherInput_creditPassword").getInputValue());
		model.put("creditUserName", maps.get("otherInput_creditUserName").getInputValue());

		for (int i = 0; i < riskTypes.size(); i++) {
			CreditRiskTypes types = riskTypes.get(i);
			List<CreditRiskTypesItems> items = types.getItems();
			for (int j = 0; j < items.size(); j++) {
				CreditRiskTypesItems item = items.get(j);
				String inputType = item.getInputType();
				DoMeCreditLinesApplyInfoPO infoPo = maps.get(types.getCode() + "_" + item.getCode());
				if (infoPo != null) {
					if ("Attachment".equals(inputType)) {
						JSONObject json = JSON.parseObject(infoPo.getExtInfo());
						if (json != null && json.containsKey("key") && StringUtils.isNotBlank(json.getString("key"))) {
							String key = json.getString("key");
							String fileName = json.getString("fileName");
							String contentType = json.getString("contentType");
							item.setUserInputUrl("key=" + key + "&fileName=" + fileName + "&contentType=" + contentType);
							item.setUserInputFileName(fileName);
							item.setHasAttach("Yes");
						} else {
							item.setHasAttach("No");
						}
					} else if ("EnumAttachment".equals(inputType)) {
						JSONObject json = JSON.parseObject(infoPo.getExtInfo());
						if (json != null && json.containsKey("key") && StringUtils.isNotBlank(json.getString("key"))) {
							String key = json.getString("key");
							String fileName = json.getString("fileName");
							String contentType = json.getString("contentType");
							item.setUserInputUrl("key=" + key + "&fileName=" + fileName + "&contentType=" + contentType);
							item.setUserInputFileName(fileName);
							item.setHasAttach("Yes");
						} else {
							item.setHasAttach("No");
						}
						item.setUserInputVal(infoPo.getInputValue());
					} else if ("Enum".equals(inputType)) {
						String seletValue = infoPo.getInputValue();
						item.setUserInputVal(seletValue);
					} else if ("Text".equals(inputType)) {
						String seletValue = infoPo.getInputValue();
						item.setUserInputVal(seletValue);
					} else { // 默认
						String seletValue = infoPo.getInputValue();
						item.setUserInputVal(seletValue);
					}
				}
			}
		}
		logger.info("print risk content:" + riskModel);
		model.put("riskModel", riskModel);
	}

	/**
	 * 运营预审
	 *
	 * @param flag
	 *            是否审核通过
	 * **/
	@RequestMapping(value = "/preAudit")
	@ResponseBody
	public ErrorMessageVO preAudit(Long creditLineId, Boolean flag, String failReason, HttpServletRequest request, ModelMap model) {
		logger.info("DebitAuditAction.preAudit,creditLineId=" + creditLineId + ",flag=" + flag);
		if (flag) {
			return this.creditLinesApplyService.submitCredit(creditLineId, this.fileService);
		} else {
			return this.creditLinesApplyService.auditFail(creditLineId, failReason);
		}
	}

	/**
	 * 开通借款
	 * **/
	@RequestMapping(value = "/openAccount")
	@ResponseBody
	public ErrorMessageVO openAccount(Long creditLineId, HttpServletRequest request, ModelMap model) {
		logger.info("DebitAuditAction.openAccount,creditLineId=" + creditLineId);
		return this.merchantAccountService.openAccount(creditLineId);
	}

	/**
	 * 初始化查询页面
	 * **/
	@RequestMapping(value = "/initRedeemedLoan")
	public String initQueryRedeemedLoan(HttpServletRequest request, ModelMap model) {
		return "/debit/loan/index1";
	}

	/**
	 * 天天贷放款列表
	 *
	 * @param query
	 * @param startTime
	 * @param endTime
	 * @param request
	 * @param response
	 * @param model
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/ajaxPaging/redeemedLoanQuery")
	public String redeemedMarginQuery(@ModelAttribute("query") ExtDoMerchantDebitOrderExample query, HttpServletRequest request, HttpServletResponse response, ModelMap model)
			throws Exception {
		query.setBizType(UserOperaRecordEnum.LOAN.getCode());
		List<LoanDebitOrderDTO> dataList = this.merchantDebitOrderService.pageQueryLoanDebitOrder(query);
		model.put("query", query);
		// 当前页面申请取回合计金额
		BigDecimal currentAmount = new BigDecimal("0.00");
		for (LoanDebitOrderDTO redeemed : dataList) {
			currentAmount = currentAmount.add(redeemed.getRealAmount());
		}
		String operator = SecurityUserHolder.getAuthUser().getUser().getRealName();
		model.put("operator", operator);
		model.put("currentPageAmount", currentAmount);
		model.put("totalPageAmount", merchantDebitOrderService.totalAmount(query));
		model.put("dataList", dataList);
		model.put("query", query);

		return "/debit/loan/loanReviewList";
	}

	/**
	 * 放款操作 单笔操作
	 *
	 * @param marginOpReqDO
	 * @param request
	 * @param response
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/singleLoanOprea")
	@ResponseBody
	public ErrorMessageVO singleLoanOprea(Long id, String status, HttpServletRequest request, HttpServletResponse response, ModelMap model) {

		ErrorMessageVO error = new ErrorMessageVO(false);
		try {
			if (StringUtils.isBlank(status)) {
				error.setErrorCode("-1");
				error.setErrorMessage("参数异常");
				return error;
			}
			String operator = SecurityUserHolder.getAuthUser().getUser().getRealName();
			String operatorId = SecurityUserHolder.getAuthUser().getUser().getUserName();
			error = merchantDebitApplyService.loanOperation(id, status, operator, operatorId);
		} catch (Exception e) {
			error.setErrorCode("1");
			error.setErrorMessage("参数异常");
			logger.error("放款操作异常：", e);
		}

		return error;
	}

	/**
	 * 批量放款操作
	 *
	 * @param marginOpReqDO
	 * @param request
	 * @param response
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/batchLoanOprea")
	@ResponseBody
	public ErrorMessageVO batchLoanOpreation(String ids, String status, HttpServletRequest request, HttpServletResponse response) {
		ErrorMessageVO error = new ErrorMessageVO(false);
		try {
			if (StringUtils.isBlank(ids) || StringUtils.isBlank(status)) {
				error.setErrorCode("-1");
				error.setErrorMessage("参数异常");
				return error;
			}
			String operator = SecurityUserHolder.getAuthUser().getUser().getRealName();
			String operatorId = SecurityUserHolder.getAuthUser().getUser().getUserName();
			error = merchantDebitApplyService.batchLoanOperation(ids, status, operator, operatorId);

		} catch (Exception e) {
			error.setErrorCode("1");
			error.setErrorMessage("放款异常");
			logger.error("批量放款操作异常：", e);
		}

		return error;
	}

	/**
	 * 下载excel
	 *
	 * @param query
	 * @param request
	 * @param response
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/loanDownload")
	@ResponseBody
	public ErrorMessageVO downloadExcel(@ModelAttribute("query") ExtDoMerchantDebitOrderExample query, HttpServletRequest request, HttpServletResponse response, ModelMap model)
			throws Exception {
//		ErrorMessageVO error = new ErrorMessageVO(false);
		query.setBizType(UserOperaRecordEnum.LOAN.getCode());
		try {
			// 查询数据列表
			List<LoanDebitOrderDTO> dataList = this.merchantDebitOrderService.pageQueryLoanDebitOrder(query);
			merchantDebitApplyService.doExcel(dataList, request, response);
		} catch (Exception e) {
			logger.error("放款下载异常：" + e.getMessage());
		}
		return null;
	}

	/**
	 * 借款明细查询detail 所需数据来
	 *
	 * @return
	 */
	@RequestMapping(value = "/detail")
	public ModelAndView loanOrderDetail(Long id, HttpServletRequest request, ModelMap model) {
		logger.info("DebitAuditAction-->loanOrderDetail-->start id=" + id);
		DoMerchantDebitOrderPO doMerchantDebitOrderPO = null;
		try {
			doMerchantDebitOrderPO = this.merchantDebitOrderService.loanOrderDetail(id);
			if(doMerchantDebitOrderPO != null){
				//查询服务费
				String serverRate = this.debitConfigService.getByKey(ConfigEnums.DEBIT_ORDER_SERVER_RATE);
				BigDecimal _serverRate = new BigDecimal(serverRate);
				model.put("serverRate", _serverRate.divide(BigDecimal.valueOf(100)));
				if(doMerchantDebitOrderPO.getInterestRateDay() != null){
				BigDecimal fRate = doMerchantDebitOrderPO.getInterestRateDay().subtract(_serverRate);
				model.put("fRate", fRate.divide(BigDecimal.valueOf(100)));
				}
			}
			
			model.put("data", doMerchantDebitOrderPO);
		} catch (Exception e) {
			logger.error("DebitAuditAction-->/detail借款详情查询异常", e);
			model.put("data", doMerchantDebitOrderPO);

		}

		return new ModelAndView("/debit/loan/loanDetail");
	}

	//可以合并
	/**
	 * 初始化查询页面
	 * **/
	@RequestMapping(value = "/initWindControlOperation")
	public String initWindControlOperation(HttpServletRequest request, ModelMap model) {
		List<DbOrgCreditSettingPO> riskLevels = this.orgCreditSettingService.getAllRiskLevelByOrgCode("SFT");
		model.put("riskLevels", riskLevels);
		return "/debit/windControlOperations/index";
	}

	/**
	 * 查询贷款申请记录
	 * **/
	@RequestMapping(value = "/ajaxPaging/queryDebitWindMerchants")
	public String queryDebitWindMerchants(ExtDoMerchantCreditLinesApplyExample query, HttpServletRequest request, ModelMap model) {
		StringBuffer sb=new StringBuffer(CreditLinesApplyStatusEnums.RISK_SUBMIT.key);
		sb.append(",");
		sb.append(CreditLinesApplyStatusEnums.RISK_NOTIFY.key);
		sb.append(",");
		sb.append(CreditLinesApplyStatusEnums.APPLY_FAIL.key);
		query.setApplyStatus(sb.toString());
		List<DoMerchantCreditLinesApplyPO> dataList = this.extDoMerchantCreditLinesApplyDAO.pageQueryDebitApplyMerchants(query);
		model.put("dataList", dataList);
		model.put("query", query);
		return "/debit/windControlOperations/queryMerchantList";
	}

	/**
	 * 查看商户的详细资料
	 * **/
	@RequestMapping(value = "/showWindDetailInfo")
	public String applyWindDetailInfo(Long applyId, HttpServletRequest request, ModelMap model) {
		try {
			// 查询最近一次申购
			DoMerchantCreditLinesApplyPO applyPO = merchantCreditLinesApplyService.selectById(applyId);
			model.put("applyPo", applyPO);
			CreditLineApplyRequest creditLineApplyRequest= debitApplyService.getCreditLineApplyRequest(applyPO);
			model.put("creditLineApplyRequest", creditLineApplyRequest);
		} catch (Exception e) {
			logger.error("CreditLinesApplyAction.applyWindDetailInfo.error,applyId=" + applyId, e);
		}
		return "/common/positionApplyDetail";
	}

	/**
	 * 风控操作初始化
	 * @param applyId
	 * @param request
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/windControl")
	public String windControl(Long applyId, HttpServletRequest request, ModelMap model) {
		try {
			// 查询最近一次申购
 			DoMerchantCreditLinesApplyPO applyPO = merchantCreditLinesApplyService.selectById(applyId);
			//查询出所有的级别
			List<DbOrgCreditSettingPO> riskLevels = this.orgCreditSettingService.getAllRiskLevelByOrgCode("SFT");
			model.put("riskLevels", riskLevels);
			model.put("id", applyId);
			model.put("o", applyPO);
		} catch (Exception e) {
			logger.error("CreditLinesApplyAction.windControl.error,applyId=" + applyId, e);
		}
		return "/debit/windControlOperations/windOperation";
	}


	/**
	 * 风控操作
	 * @param applyId
	 * @param request
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/winOperation")
	@ResponseBody
	public ErrorMessageVO winOperation(HttpServletRequest request, ModelMap model) {
		ErrorMessageVO vo=new ErrorMessageVO(true);
		Long applyId=0L;
		try {
			String type=request.getParameter("type");
			String applyIdStr=request.getParameter("applyId");
			String riskLevel=request.getParameter("riskLevel");
			if(StringUtils.isNotBlank(applyIdStr)){
				applyId=Long.valueOf(applyIdStr);
			}
			// 查询最近一次申购
			DoMerchantCreditLinesApplyPO applyPO = merchantCreditLinesApplyService.selectById(applyId);
			if(!applyPO.getApplyStatus().equals(CreditLinesApplyStatusEnums.RISK_SUBMIT.key)){
				vo.setSuccess(false);
				vo.setErrorCode("-2");
				vo.setErrorMessage("额度申请当单不正确，无权限操作！");
				return vo;
			}
			CreditRiskResult crr=new CreditRiskResult();
			crr.setLevel(riskLevel);
			crr.setCode(applyPO.getMerchantNo());
			Date expireDate=com.sdp.mc.common.util.DateUtil.increaseYearDate(new Date(), 1);
			String expireStr= com.sdp.mc.common.util.DateUtil.dateFormat4.format(expireDate);
			crr.setExpireDate(expireStr);
			crr.setPolicy(debitConfigService.getByKey(ConfigEnums.RISK_POLICY_VALUE));
			applyPO.setRiskLevel(riskLevel);

			//修改级别
			DoMerchantCreditLinesApplyPO record=new DoMerchantCreditLinesApplyPO();
			record.setId(applyPO.getId());
			if(type.equals("1")){
				crr.setStatus("failed");
			}else{
				crr.setStatus("success");
			}

			creditLinesApplyService.syncCreditRiskResult(applyPO, crr);
			vo.setErrorCode("00");
			vo.setErrorMessage("操作成功");
		} catch (Exception e) {
			vo.setSuccess(false);
			vo.setErrorCode("-1");
			vo.setErrorMessage("操作异常，联系开发或者技术人员!");
			logger.error("CreditLinesApplyAction.winOperation.error,applyId=" + applyId, e);
		}
		return vo;
	}
	@RequestMapping(value = "/operationBack")
	public String operationBack(HttpServletRequest request, ModelMap model) {
		return "/debit/windControlOperations/index";
	}

}
