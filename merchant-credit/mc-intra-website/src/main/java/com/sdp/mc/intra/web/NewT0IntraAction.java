package com.sdp.mc.intra.web;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.math.BigDecimal;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.ServletRequestDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.sdp.emall.intra.admin.administrator.dao.dataobject.ActAdminUserDO;
import com.sdp.emall.intra.admin.security.util.SecurityUserHolder;
import com.sdp.mc.common.bean.newt0.LoaningConfigBean;
import com.sdp.mc.common.constant.MerchantCreditConstant;
import com.sdp.mc.common.enums.LoaningTypeEnum;
import com.sdp.mc.common.enums.withdraw.RemitWithdrawFeeStatusEnums;
import com.sdp.mc.common.enums.withdraw.WithdrawReqStatusEnums;
import com.sdp.mc.common.enums.withdraw.WithdrawServiceTypeEnums;
import com.sdp.mc.common.util.ConfigOptionHelper;
import com.sdp.mc.common.util.DateUtil;
import com.sdp.mc.common.vo.ErrorMessageVO;
import com.sdp.mc.common.vo.QuotaVO;
import com.sdp.mc.config.manager.ConfigOptionManager;
import com.sdp.mc.facade.msp.enums.MerchantFastSettleSubStatusEnum;
import com.sdp.mc.integration.ma.dto.MerchantBalanceDTO;
import com.sdp.mc.intra.spring.editor.DateEditor;
import com.sdp.mc.ma.wrapper.AccountQueryFacadeWrapper;
import com.sdp.mc.ma.wrapper.UesRemoteServiceClient;
import com.sdp.mc.margin.dao.MarginOpReqDO;
import com.sdp.mc.margin.dao.ext.RedeemedMarginApplyExampleExt;
import com.sdp.mc.margin.dao.ext.RedeemedMarginApplyExt;
import com.sdp.mc.margin.manager.MarginOpReqManager;
import com.sdp.mc.merchant.dao.MerchantFsReq;
import com.sdp.mc.merchant.dao.MerchantFsReqExample;
import com.sdp.mc.merchant.manager.MerchantFsRManager;
import com.sdp.mc.newt0.dao.Newt0SdpRemainBalanceDO;
import com.sdp.mc.newt0.dao.Newt0SdpRemainBalanceDOExample;
import com.sdp.mc.service.newt0.NewT0IntraService;
import com.sdp.mc.service.newt0.NewT0MerchantFastSettleService;
import com.sdp.mc.service.newt0.loaning.config.LoaningCongfigService;
import com.sdp.withdraw.dao.WithdrawReqDO;
import com.sdp.withdraw.dao.WithdrawReqFosDetailDO;
import com.sdp.withdraw.dao.ext.ExtRefoundReqVO;
import com.sdp.withdraw.dao.ext.ExtWithdrawReqDOExample;
import com.sdp.withdraw.dao.ext.ExtWithdrawReqVO;
import com.sdp.withdraw.enums.ReturnCodeEnums;
import com.sdp.withdraw.manager.ext.ExtWithdrawReqManager;
import com.sdp.withdraw.service.WithdrawReqFosDetailService;
import com.sdp.withdraw.service.WithdrawReqService;
import com.sdp.withdraw.service.WithdrawRetryService;
import com.shengpay.debit.dal.ext.dataobject.DbOrgCreditSettingDTO;

/**
 * 新T0新增后台功能
 * **/
@Controller
@RequestMapping("/newT0")
public class NewT0IntraAction {

	private static final Logger log = LoggerFactory.getLogger(NewT0IntraAction.class);

	@Autowired
	private LoaningCongfigService loaningCongfigService;

	@Autowired
	private NewT0IntraService newT0IntraService;

	@Autowired
	private MerchantFsRManager merchantFsRManager;

	@Autowired
	protected MarginOpReqManager marginOpReqManager;

	@Autowired
	private NewT0MerchantFastSettleService newT0MerchantFastSettleService;

	@Autowired
	private AccountQueryFacadeWrapper accountQueryFacadeWrapper;

	@Autowired
	private ConfigOptionManager configOptionManager;

	@Autowired
	private WithdrawReqService withdrawReqService;
	@Autowired
	private WithdrawReqFosDetailService withdrawReqFosDetailService;

	@Autowired
	private ExtWithdrawReqManager extWithdrawReqManager;
	@Autowired
	private WithdrawRetryService WithdrawRetryService;
	@Autowired
	private UesRemoteServiceClient uesRemoteServiceClient;

	// ///----------------------------管理垫资额度--------------begin------------------

	/**
	 * 管理垫资额度 文件上传
	 */
	@RequestMapping(value = "/loaningQuotaIndex")
	public String loaningQuotaIndex(HttpServletRequest request, HttpServletResponse response, ModelMap model) {
		return "/newt0/loaningQuota/index1";
	}

	/**
	 * 文件上传
	 *
	 * @param file
	 * @param request
	 * @param response
	 * @param model
	 * @return
	 * @throws IOException
	 */
	@RequestMapping(value = "/upload")
	public String init(@RequestParam(value = "file", required = false) MultipartFile file, HttpServletRequest request, HttpServletResponse response,
			ModelMap model) throws IOException {
		ErrorMessageVO error = new ErrorMessageVO(false);
		error.setErrorCode("1");
		InputStream stream = null;
		Workbook wb = null;
		try {
			if (file == null) {
				error.setErrorMessage("上传文件不能为空!");
				model.put("msg", error);
				return "/newt0/loaningQuota/index1";
			}
			String type = file.getOriginalFilename().substring(file.getOriginalFilename().lastIndexOf(".") + 1);
			if (StringUtils.isBlank(type)) {
				error.setErrorMessage("请选择文件!");
				model.put("msg", error);
				return "/newt0/loaningQuota/index1";
			}
			stream = file.getInputStream();
			// List<Map<String,Object>> listTemp =
			// com.sdp.mc.newt0.FileUtil.exportListFromExcel(stream,type, 0);
			if ("xls".equals(type)) { // 2003
				wb = new HSSFWorkbook(stream);
			} else if ("xlsx".equals(type)) {// 2007
				// wb = new XSSFWorkbook(stream);
				error.setErrorMessage("请您上传xls文件!");
				model.put("msg", error);
				return "/newt0/loaningQuota/index1";
			} else {
				error.setErrorMessage("您上传文件格式不正确!");
				model.put("msg", error);
				return "/newt0/loaningQuota/index1";
			}
			Sheet sheet1 = wb.getSheetAt(0);
			List<Newt0SdpRemainBalanceDO> list = new ArrayList<Newt0SdpRemainBalanceDO>();
			for (Row row : sheet1) {
				Iterator<Cell> cells = row.cellIterator(); // 获得第一行的迭代器
				Newt0SdpRemainBalanceDO po = new Newt0SdpRemainBalanceDO();
				QuotaVO quotaVO = new QuotaVO();
				while (cells.hasNext()) {
					Cell cell = cells.next();
					if (cell.getColumnIndex() == 0) {
						quotaVO.setQuotaDate(cell.getStringCellValue());
					} else if (cell.getColumnIndex() == 1) {
						quotaVO.setAmountStr(cell.getNumericCellValue() + "");
					}
					continue;
				}
				// 生效开始日
				LoaningConfigBean loaningConfigBean = loaningCongfigService.getLoaningConfigBeanByLoaningType(LoaningTypeEnum.SHENGPAY);
				// 生效开始日
				// po.setStartTime(DateUtil.parse2DateFormat5Date(quotaVO.getQuotaDate()
				// + " " + loaningConfigBean.getFsBeginTime()));
				po.setStartTime(DateUtil.parse2DateFormat7Date(quotaVO.getQuotaDate() + " 00:00:00.0"));
				// 配资额度
				po.setQuota(new BigDecimal(quotaVO.getAmountStr()));
				// 生效结束日
				// po.setEndTime(DateUtil.parse2DateFormat5Date(quotaVO.getQuotaDate()
				// + " " + loaningConfigBean.getFsEndTime()));
				// 修改生效结束时间为凌晨
				po.setEndTime(DateUtil.parse2DateFormat7Date(quotaVO.getQuotaDate() + " 23:59:59.999"));
				// 可使用额度
				po.setCanUseQuota(new BigDecimal(quotaVO.getAmountStr()));
				// 冻结额度
				po.setFrozenQuota(new BigDecimal("0.00"));
				// 已使用额度
				po.setUsedQuota(new BigDecimal("0.00"));
				po.setCreateTime(new Date());
				po.setUpdateTime(new Date());
				list.add(po);
			}
			if (list.isEmpty()) {
				error.setErrorMessage("您上传的excel格式不正确");
				model.put("msg", error);
				return "/newt0/loaningQuota/index1";
			}
			for (Newt0SdpRemainBalanceDO record : list) {
				if (!record.getStartTime().after(DateUtil.generateDawnTimeStamp(new Date()))) {// 只能修改今天之后的
					log.error("NewT0IntraAction.init date=" + new Date() + " can't update or insert Newt0SdpRemainBalanceDO="
							+ ToStringBuilder.reflectionToString(record) + ",it's outdate.");
					continue;
				}
				Newt0SdpRemainBalanceDOExample example = new Newt0SdpRemainBalanceDOExample();
				Newt0SdpRemainBalanceDOExample.Criteria criteria = example.createCriteria();
				criteria.andEndTimeLessThanOrEqualTo(record.getEndTime());
				criteria.andStartTimeGreaterThanOrEqualTo(record.getStartTime());
				List<Newt0SdpRemainBalanceDO> listDO = newT0IntraService.selectByExample(example);
				if (listDO == null || listDO.isEmpty()) {
					newT0IntraService.insert(record);
					error.setErrorCode("0");
					error.setErrorMessage("文件上传成功");
					model.put("msg", error);
				} else {
					BigDecimal canUseQuota = record.getQuota().subtract(listDO.get(0).getFrozenQuota()).subtract(listDO.get(0).getUsedQuota());
					record.setCanUseQuota(canUseQuota);// 暂不考虑并发问题
					record.setFrozenQuota(null);// 冻结额度不更新(可能别的程序在使用或者已更新)
					record.setUsedQuota(null);// 已使用额度不更新(可能别的程序在使用或者已更新)
					record.setCreateTime(null);// 创建时间不更新
					record.setUpdateTime(new Date());
					record.setId(listDO.get(0).getId());
					newT0IntraService.updateByPrimaryKeySelective(record);
					error.setErrorCode("0");
					error.setErrorMessage("文件上传成功");
					model.put("msg", error);
				}
			}
		} catch (Exception e) {
			log.error("文件上传异常,", e);
			error.setErrorMessage("文件读取异常！");
			model.put("msg", error);
		} finally {
			if (stream != null) {
				stream.close();
			}
		}
		return "/newt0/loaningQuota/index1";
	}

	/**
	 * 管理垫资额度--分页查询
	 * **/
	@RequestMapping(value = "/ajaxPaging/loaningQuotaQuery")
	public String loaningQuotaQuery(@ModelAttribute("query") Newt0SdpRemainBalanceDOExample query, HttpServletRequest request,
			HttpServletResponse response, ModelMap model) {
		Newt0SdpRemainBalanceDOExample example = new Newt0SdpRemainBalanceDOExample();
		if (query.getStartTime() != null) {
			example.createCriteria().andStartTimeBetween(DateUtil.generateDawnTimeStamp(query.getStartTime()),
					DateUtil.generateMidnightTimeStamp(query.getStartTime()));
		} else {
			example = query;
		}
		example.setOrderByClause(" START_TIME desc");
		List<Newt0SdpRemainBalanceDO> dataList = newT0IntraService.pageQueryWithCapital(example);
		model.put("dataList", dataList);
		model.put("query", query);
		return "/newt0/loaningQuota/loaningQuotaList";
	}

	@RequestMapping(value = "/download")
	public void download(HttpServletRequest request, HttpServletResponse response, ModelMap model) throws IOException {
		File file = new File(request.getSession().getServletContext().getRealPath("/") + "/template/loaningQuota.xls"); // 根据文件路径获得File文件
		response.setContentType("application/msexcel;charset=GBK");
		response.setHeader("Content-Disposition", "attachment;filename=" + URLEncoder.encode("template.xls", "UTF-8"));
		response.setContentLength((int) file.length());
		byte[] buffer = new byte[4096];// 缓冲区
		BufferedOutputStream output = null;
		BufferedInputStream input = null;
		try {
			output = new BufferedOutputStream(response.getOutputStream());
			input = new BufferedInputStream(new FileInputStream(file));
			int n;
			// 遍历，开始下载
			while ((n = input.read(buffer, 0, 4096)) > -1) {
				output.write(buffer, 0, n);
			}
			output.flush(); // 不可少
			response.flushBuffer();// 不可少
		} catch (Exception e) {
			log.error("NewT0IntraAction.download error", e);
		} finally {
			// 关闭流，不可少
			if (input != null) {
				input.close();
			}
			if (output != null) {
				output.close();
			}
		}
	}

	@RequestMapping(value = "/initEdit")
	public String initEdit(@ModelAttribute("query") DbOrgCreditSettingDTO query, HttpServletRequest request, HttpServletResponse response,
			ModelMap model) {
		log.info("CreditConfigAction.initEdit.query.po.id=" + query.getPo().getId());
		if (query.getPo().getId() != null) {
			Newt0SdpRemainBalanceDOExample example = new Newt0SdpRemainBalanceDOExample();
			example.setId(query.getPo().getId());
			List<Newt0SdpRemainBalanceDO> listDO = newT0IntraService.selectByExample(example);
			model.put("config", listDO.get(0));
		}
		return "/newt0/loaningQuota/edit";
	}

	@RequestMapping(value = "/saveEdit")
	@ResponseBody
	public ErrorMessageVO saveEdit(Newt0SdpRemainBalanceDO config, HttpServletRequest request, HttpServletResponse response, ModelMap model) {
		ErrorMessageVO error = new ErrorMessageVO(false);
		if (config.getQuota() == null) {
			error.setErrorCode("-1");
			error.setErrorMessage("额度不能为空");
			return error;
		}
		boolean value = newT0IntraService.modifyNewt0SdpRemainBalance(config);
		if (value) {
			error.setSuccess(true);
			error.setErrorCode("0");
			error.setErrorMessage("保存成功");
		} else {
			error.setSuccess(true);
			error.setErrorCode("-1");
			error.setErrorMessage("保存失败");
		}
		return error;
	}

	// ///----------------------------管理垫资额度--------------end------------------

	// ///--------------------------实时结算退手续费菜单--------------begin----------------
	@InitBinder
	protected void initBinder(HttpServletRequest request, ServletRequestDataBinder binder) throws Exception {
		// 对于需要转换为Date类型的属性，使用DateEditor进行处理
		binder.registerCustomEditor(Date.class, new DateEditor());
	}

	/**
	 * 快速结算申请单查询首页
	 * **/
	@RequestMapping(value = "/fastSettleApplyRecordIndex")
	public String fastSettleApplyRecordIndex(HttpServletRequest request, HttpServletResponse response, ModelMap model) {
		model.put("statusList", MerchantFastSettleSubStatusEnum.values());
		return "/newt0/fastSettleApplyRecord/index";
	}

	/**
	 * 快速结算申请单分页查询
	 * **/
	@RequestMapping(value = "/ajaxPaging/fastSettleApplyRecordQuery")
	public String fastSettleApplyRecordQuery(@ModelAttribute("query") MerchantFsReqExample query, Date startTime, Date endTime,
			HttpServletRequest request, HttpServletResponse response, ModelMap model) {
		long minutes = ConfigOptionHelper.getLongByKey(MerchantCreditConstant.NEW_T0_REMIT_FEE_MINUTE);
		// 只有盛付通垫资的情况才会退费处理
		MerchantFsReqExample.Criteria criteria = query.createCriteria();
		criteria.andLoaningTypeEqualTo(LoaningTypeEnum.SHENGPAY.getCode());
		if (startTime != null) {
			criteria.andCreateTimeGreaterThan(startTime);
		}
		if (endTime != null) {
			criteria.andCreateTimeLessThan(DateUtil.increaseDate(endTime, 1));
		}
		if (StringUtils.isNotBlank(query.getMerchantName())) {
			criteria.andMerchantNameLike("'%" + query.getMerchantName() + "%'");
		}
		if (StringUtils.isNotBlank(query.getPromoterName())) {
			criteria.andPromoterNameLike("'%" + query.getPromoterName() + "%'");
		}
		query.setOrderByClause(" CREATE_TIME desc");
		query.setPayEffectiveTimeMinRange(minutes);
		List<MerchantFsReq> dataList = this.merchantFsRManager.selectByQuery(query);
		if (dataList != null) {
			for (MerchantFsReq fsReq : dataList) {
				if (MerchantFastSettleSubStatusEnum.SETTLED.code.equals(fsReq.getSubStatus()) && fsReq.getWithdrawResponseTime() != null) {
					// 计算出实际花费时间--等pos接口修改后还是要放开
					long realCostTime = (fsReq.getWithdrawResponseTime().getTime() - fsReq.getApplyTime().getTime()) / 1000 / 60;

					if (realCostTime >= minutes) {
						fsReq.setSubStatus(MerchantFastSettleSubStatusEnum.CAN_REMIT_SETTLE_FEE.code);
					}
				}
			}
		}
		model.put("dataList", dataList);
		model.put("query", query);
		return "/newt0/fastSettleApplyRecord/fastSettleApplyRecordList";
	}

	/**
	 * 申请退结算手续费
	 * **/
	@RequestMapping(value = "/remitSettleFee")
	@ResponseBody
	public ErrorMessageVO remitSettleFee(Long id, HttpServletRequest request, HttpServletResponse response, ModelMap model) {
		return this.newT0MerchantFastSettleService.remitFastSettleFee(id);
	}

	// ///--------------------------实时结算退手续费--------------end-----------------

	// /--------------------------保证金退回审核--------------begin----------------

	/**
	 * 保证金放款页面
	 *
	 * @param id
	 * @param request
	 * @param response
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/redeemedMargin")
	public String redeemedMargin(Long id, HttpServletRequest request, HttpServletResponse response, ModelMap model) {
		// Date NextDay = DateUtil.increaseDate(new Date(), 1);
		// model.put("nextDay",
		// DateUtil.dateFormat4(DateUtil.generateMidnightTimeStamp(NextDay)));
		model.put("currentDay", new Date());
		return "/newt0/loaningQuotaApply/index1";
	}

	/**
	 * 保证金放款列表
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
	@RequestMapping(value = "/ajaxPaging/redeemedMarginQuery")
	public String redeemedMarginQuery(@ModelAttribute("query") RedeemedMarginApplyExampleExt query, HttpServletRequest request,
			HttpServletResponse response, ModelMap model) throws Exception {
		List<RedeemedMarginApplyExt> dataList = newT0IntraService.selectRedeemedReq(query);

		model.put("query", query);
		// Map<String, String> memberMap = new HashMap<String, String>();
		/*
		 * Map<String, MerchantBalanceDTO> merchantBalanceMap =
		 * accountQueryFacadeWrapper.queryBatchMerchantBalance(memberMap); if
		 * (merchantBalanceMap == null || merchantBalanceMap.isEmpty()) {
		 * model.put("dataList", dataList); return
		 * "/newt0/loaningQuotaApply/loaningApplyQuotaList"; } for
		 * (RedeemedMarginApplyExt ext : dataList) {
		 * ext.setApplyTime(ext.getCreateTime()); if
		 * (StringUtils.isBlank(ext.getMarginMemberId())) { log.info("代理商" +
		 * ext.getMcMerchantName() + "会员ID值为空!"); continue; } if
		 * (!memberMap.containsKey(ext.getMarginMemberId())) {
		 * memberMap.put(ext.getMarginMemberId(), ext.getMarginMemberId()); } }
		 */
		// 当前页面申请取回合计金额
		BigDecimal currentAmount = new BigDecimal("0.00");
		Map<String, BigDecimal> marginAccountBalanceMap = new HashMap<String, BigDecimal>();
		for (RedeemedMarginApplyExt redeemed : dataList) {
			if (StringUtils.isBlank(redeemed.getMarginMemberId())) {
				log.info("代理商" + redeemed.getMcMerchantName() + "会员ID值为空!");
				continue;
			}
			BigDecimal marginAccountBalance = marginAccountBalanceMap.get(redeemed.getMarginMemberId() + "_" + redeemed.getMcType());
			if (marginAccountBalance == null) {
				MerchantBalanceDTO balanceDTO = accountQueryFacadeWrapper.queryMerchantBalance(redeemed.getMarginMemberId(), redeemed.getMcType());
				marginAccountBalance = balanceDTO.getMarginAccountBalance();
				marginAccountBalanceMap.put(redeemed.getMarginMemberId() + "_" + redeemed.getMcType(), marginAccountBalance);
			}
			redeemed.setFastSettleMargin(marginAccountBalance);
			currentAmount = currentAmount.add(redeemed.getAmount());
		}
		String operator = SecurityUserHolder.getAuthUser().getUser().getRealName();
		model.put("operator", operator);
		model.put("currentPageAmount", currentAmount);
		model.put("totalPageAmount", newT0IntraService.totalAmount(query));
		model.put("dataList", dataList);
		model.put("query", query);

		return "/newt0/loaningQuotaApply/loaningApplyQuotaList";
	}

	/**
	 * 保证金申请放款页面
	 *
	 * @param marginOpReqDO
	 * @param request
	 * @param response
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/initLoanView")
	public String initLoanView(@ModelAttribute("query") MarginOpReqDO query, HttpServletRequest request, HttpServletResponse response, ModelMap model) {
		MarginOpReqDO marginDo = marginOpReqManager.selectByPrimaryKey(query.getMorId());
		model.put("marginOpReqDO", marginDo);
		return "/newt0/loaningQuotaApply/edit";
	}

	/**
	 * 保证金放款操作 单笔操作
	 *
	 * @param marginOpReqDO
	 * @param request
	 * @param response
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/singleLoanOprea")
	@ResponseBody
	public ErrorMessageVO singleLoanOprea(MarginOpReqDO marginOpReqDO, int status, HttpServletRequest request, HttpServletResponse response,
			ModelMap model) {

		ErrorMessageVO error = new ErrorMessageVO(false);
		try {
			if (marginOpReqDO == null || marginOpReqDO.getMorId() <= 0 || status < 0) {
				error.setErrorCode("-1");
				error.setErrorMessage("参数异常");
				return error;
			}
			String operator = SecurityUserHolder.getAuthUser().getUser().getRealName();
			String operatorId = SecurityUserHolder.getAuthUser().getUser().getUserName();
			error = newT0IntraService.loanOperation(marginOpReqDO.getMorId().toString(), status, operator, operatorId);
		} catch (Exception e) {
			error.setErrorCode("1");
			error.setErrorMessage("参数异常");
			log.error("放款操作异常：" + e.getMessage());
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
	public ErrorMessageVO batchLoanOpreation(String morIds, int status, HttpServletRequest request, HttpServletResponse response) {
		ErrorMessageVO error = new ErrorMessageVO(false);
		try {
			if (StringUtils.isEmpty(morIds) || status < 0) {
				error.setErrorCode("-1");
				error.setErrorMessage("参数异常");
				return error;
			}
			String operator = SecurityUserHolder.getAuthUser().getUser().getRealName();
			String operatorId = SecurityUserHolder.getAuthUser().getUser().getUserName();
			error = newT0IntraService.loanOperation(morIds, status, operator, operatorId);

		} catch (Exception e) {
			error.setErrorCode("1");
			error.setErrorMessage("放款异常");
			log.error("批量放款操作异常：" + e.getMessage());
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
	public void downloadExcel(@ModelAttribute("query") RedeemedMarginApplyExampleExt query, HttpServletRequest request, HttpServletResponse response,
			ModelMap model) throws Exception {
		try {
			List<RedeemedMarginApplyExt> dataList = newT0IntraService.selectRedeemedReq(query);
			Map<String, String> memberMap = new HashMap<String, String>();
			for (RedeemedMarginApplyExt ext : dataList) {
				ext.setApplyTime(ext.getCreateTime());
				if (StringUtils.isBlank(ext.getMarginMemberId())) {
					log.info("代理商" + ext.getMcMerchantName() + "会员ID值为空!");
					continue;
				}
				if (!memberMap.containsKey(ext.getMarginMemberId())) {
					memberMap.put(ext.getMarginMemberId(), ext.getMarginMemberId());
				}
			}
			model.put("query", query);
			Map<String, MerchantBalanceDTO> merchantBalanceMap = accountQueryFacadeWrapper.queryBatchMerchantBalance(memberMap);

			// 当前页面申请取回合计金额
			BigDecimal currentAmount = new BigDecimal("0.00");
			for (RedeemedMarginApplyExt redeemed : dataList) {
				BigDecimal marginAccountBalance = new BigDecimal("0.00");
				if (merchantBalanceMap != null) {
					marginAccountBalance = merchantBalanceMap.get(redeemed.getMarginMemberId()).getMarginAccountBalance();
				}
				redeemed.setFastSettleMargin(marginAccountBalance);
				currentAmount = currentAmount.add(redeemed.getAmount());
			}
			newT0IntraService.doExcel(dataList, request, response);
		} catch (Exception e) {
			log.error("放款下载异常：" + e.getMessage());
		}
	}

	// /--------------------------保证金退回审核--------------end----------------

	/**
	 * T0出款管理菜单--首页
	 * **/
	@RequestMapping(value = "/withdrawIndex")
	public String withdrawIndex(HttpServletRequest request, HttpServletResponse response, ModelMap model) {
		log.info("withdrawIndex");
		Map<String, String> serviceTypeName = new LinkedHashMap<String, String>();
		for (WithdrawServiceTypeEnums temp : WithdrawServiceTypeEnums.values()) {
			serviceTypeName.put(temp.code.toString(), temp.desc);
		}
		Map<String, String> reqStatusName = new LinkedHashMap<String, String>();
		for (WithdrawReqStatusEnums temp : WithdrawReqStatusEnums.values()) {
			reqStatusName.put(temp.code.toString(), temp.desc);
		}
		model.put("serviceTypeName", serviceTypeName);
		model.put("reqStatusName", reqStatusName);
		return "/newt0/withdraw/index";
	}

	@RequestMapping(value = "/ajaxPaging/withdrawInfoList")
	public String withdrawInfoList(@ModelAttribute("query") ExtWithdrawReqDOExample query, HttpServletRequest request, HttpServletResponse response,
			ModelMap model) throws Exception {
		try {
			List<ExtWithdrawReqVO> dataList = extWithdrawReqManager.queryWithdrawInfoByQuery(query);
			for (ExtWithdrawReqVO extw : dataList) {
				for (WithdrawReqStatusEnums withdrawReqStatusEnums : WithdrawReqStatusEnums.values()) {
					if (withdrawReqStatusEnums.code.equals(extw.getStatus())) extw.setStatusMsg(withdrawReqStatusEnums.desc);
				}

				for (WithdrawServiceTypeEnums withdrawServiceTypeEnums : WithdrawServiceTypeEnums.values()) {
					if (withdrawServiceTypeEnums.code.equals(extw.getServiceType())) extw.setServiceTypeMsg(withdrawServiceTypeEnums.desc);
				}
				extw.setBankAccountAmount(extw.getWithdrawAmount().subtract(extw.getTotalCost()));
			}

			model.put("dataList", dataList);
			model.put("query", query);

		} catch (Exception e) {
			log.error("查询出款列表系统繁忙，请稍后再试：" + e.getMessage(), e);
		}
		return "/newt0/withdraw/withdrawList";
	}

	@RequestMapping(value = "/showDetailInfo")
	public String showDetailInfo(Long reqId,Long DetailId, HttpServletRequest request, HttpServletResponse response,
			ModelMap model) throws Exception {
		try {
			
			WithdrawReqDO reqInfo=withdrawReqService.queryWithdrawReqByReqId(reqId);
			if(reqInfo==null){
				return "/newt0/withdraw/withdrawDetail";
			}
			List<WithdrawReqFosDetailDO> dataList = withdrawReqFosDetailService.queryDetailInfoByReqId(reqId);
			if (dataList != null && dataList.size() > 0) {
				for (WithdrawReqFosDetailDO extw : dataList) {
					String payeeCarddNo = extw.getPayeeCardNo();
					if (StringUtils.isNotBlank(payeeCarddNo)) {
						try {
							String cardNo = uesRemoteServiceClient.decryptData(payeeCarddNo);
							if (cardNo != null && cardNo.length() > 10) {
								extw.setPayeeCardNo(cardNo.substring(0, 6) + "****" + cardNo.substring(cardNo.length() - 4));
							}
						} catch (Exception e) {
							log.info("NewT0IntraAction.withdrawInfoList.status is error,payeeCarddNo:" + payeeCarddNo);
						}
					}
				}

				model.put("detailInfos", dataList);
				model.put("reqInfo", reqInfo);
			}
		} catch (Exception e) {
			log.error("查询出款详细信息系统繁忙，请稍后再试：" + e.getMessage(), e);
		}
		return "/newt0/withdraw/withdrawDetail";
	}

	@RequestMapping(value = "/retryWithdraw")
	@ResponseBody
	public ErrorMessageVO retryWithdraw(Long reqId, String remitVoucherNo, HttpServletRequest request, ModelMap model) {
		ErrorMessageVO error = null;
		try {
			ActAdminUserDO user = SecurityUserHolder.getAuthUser().getUser();
			String operator = user.getRealName();
			String operatorId = user.getUserName();
			log.info("retryWithdraw reqId:" + reqId + " ,remitVoucherNo:" + remitVoucherNo + ", opUser：" + ToStringBuilder.reflectionToString(user));
			error = WithdrawRetryService.retryWithdraw(reqId, remitVoucherNo, operator, operatorId);
			return error;
		} catch (Exception e) {
			log.error("重试操作异常：" + e.getMessage(), e);
			return new ErrorMessageVO<Object>(false, "-1", "系统繁忙，请稍后再试");
		}
	}

	@RequestMapping(value = "/updateWithdrawFail")
	@ResponseBody
	public ErrorMessageVO updateWithdrawFail(Long reqId, HttpServletRequest request, ModelMap model) {
		try {
			ActAdminUserDO user = SecurityUserHolder.getAuthUser().getUser();
			log.info("retryWithdraw reqId:" + reqId + ", opUser：" + ToStringBuilder.reflectionToString(user, ToStringStyle.SIMPLE_STYLE));
			int row = withdrawReqService.updateDataStatusFail(reqId, ReturnCodeEnums.FW_DATA_GROUND_FAILS.code,
					ReturnCodeEnums.FW_DATA_GROUND_FAILS.msg);
			if (row <= 0) { return new ErrorMessageVO<Object>(false, "-1", "系统繁忙，请稍后再试"); }
			return new ErrorMessageVO<Object>(true, "1", "设置成功");
		} catch (Exception e) {
			log.error("设置失败异常：" + e.getMessage(), e);
			return new ErrorMessageVO<Object>(false, "-1", "系统繁忙，请稍后再试");
		}
	}

	/**
	 * T0出款管理菜单--首页
	 * **/
	@RequestMapping(value = "/refoundIndex")
	public String refoundIndex(HttpServletRequest request, HttpServletResponse response, ModelMap model) {
		log.info("refoundIndex");
		Map<String, String> serviceTypeName = new LinkedHashMap<String, String>();
		for (WithdrawServiceTypeEnums temp : WithdrawServiceTypeEnums.values()) {
			serviceTypeName.put(temp.code.toString(), temp.desc);
		}
		Map<String, String> reqStatusName = new LinkedHashMap<String, String>();
		for (RemitWithdrawFeeStatusEnums temp : RemitWithdrawFeeStatusEnums.values()) {
			// if(!temp.code.toString().equals("0"))
			reqStatusName.put(temp.code.toString(), temp.desc);
		}
		model.put("serviceTypeName", serviceTypeName);
		model.put("reqStatusName", reqStatusName);
		return "/newt0/refound/index";
	}

	@RequestMapping(value = "/ajaxPaging/refoundList")
	public String refoundList(@ModelAttribute("query") ExtWithdrawReqDOExample query, HttpServletRequest request, HttpServletResponse response,
			ModelMap model) throws Exception {
		try {
			long minutes = ConfigOptionHelper.getLongByKey(MerchantCreditConstant.NEW_T0_REMIT_FEE_MINUTE);
			query.setMinutes(minutes);
			List<ExtRefoundReqVO> dataList = extWithdrawReqManager.queryRefoundReqInfo(query);
			model.put("dataList", dataList);
			model.put("query", query);

		} catch (Exception e) {
			log.error("查询出款列表系统繁忙，请稍后再试：" + e.getMessage(), e);
		}
		return "/newt0/refound/refoundList";
	}

	@SuppressWarnings("rawtypes")
	@RequestMapping(value = "/refoundWithdrawFee")
	@ResponseBody
	public ErrorMessageVO refoundWithdrawFee(HttpServletRequest request, HttpServletResponse response, ModelMap model) {
		ActAdminUserDO user = SecurityUserHolder.getAuthUser().getUser();
		String operator = user.getRealName();
		Long id = Long.valueOf(request.getParameter("reqId") == null ? "" : request.getParameter("reqId").toString());
		log.info("refoundWithdrawFee reqId:{} operator:{}", new Object[] { id, ToStringBuilder.reflectionToString(user) });
		return this.newT0MerchantFastSettleService.refoundWithdrawFee(id, operator);
	}
}
