package com.sdp.mc.web.action.fastsettle;

import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sdp.mc.common.constant.MerchantCreditConstant;
import com.sdp.mc.common.constant.WithdrawConstant;
import com.sdp.mc.common.enums.OpObjTypeEnums;
import com.sdp.mc.common.enums.withdraw.WithdrawReqStatusEnums;
import com.sdp.mc.common.util.DateUtil;
import com.sdp.mc.common.vo.ErrorMessageVO;
import com.sdp.mc.common.vo.MerchantFastSettleVO;
import com.sdp.mc.common.web.MCMerchantUser;
import com.sdp.mc.facade.msp.MspFacade;
import com.sdp.mc.ffconfig.dao.FastSettleConfigDO;
import com.sdp.mc.service.fastsettle.FastSettle;
import com.sdp.mc.service.newt0.Newt0PromoterService;
import com.sdp.mc.service.newt0.loaning.config.LoaningCongfigService;
import com.sdp.mc.web.action.BaseAction;
import com.sdp.withdraw.dao.ext.ExtWithdrawReqDOExample;
import com.sdp.withdraw.dao.ext.ExtWithdrawReqVO;
import com.sdp.withdraw.manager.ext.ExtWithdrawReqManager;
import com.shengpay.pos.pcs.api.settle.StraightlyCfg;

@Controller
@RequestMapping(value = { "/posMerchant", "/mposMerchant" })
public class MerchantAction extends BaseAction {
	private static final Logger logger = LoggerFactory.getLogger(MerchantAction.class);
	@Autowired
	private FastSettle fastSettle;
	@Autowired
	private MspFacade mspFacade;
	@Autowired
	private Newt0PromoterService newt0PromoterService;
	@Autowired
	private LoaningCongfigService loaningCongfigService;
	@Autowired
	private ExtWithdrawReqManager extWithdrawReqManager;

	/**
	 * toSettFastConfirm
	 */
	// @RequestMapping(value = "/toSetFastConfirm")
	public String toSettFastConfirm(HttpServletRequest request, ModelMap model) {
		/*
		 * MCMerchantUser user =
		 * MCMerchantUser.getMCMerchantUser(request.getSession()); Long
		 * merchantId = user.getMerchantId(); // 代理商剩余额度 StraightlyCfg
		 * pStraightlyCfg = mspFacade.getPromoterCredit(user.getPromoterId());
		 * if (pStraightlyCfg == null) { model.put("msg",
		 * "代理商功能未开通或请在下一工作日重试，或联系客服"); return
		 * "/main/fastsettle/merchant/settFastConfirm"; } if
		 * (!pStraightlyCfg.isStraightFlag()) { model.put("msg",
		 * "对不起，你的代理商还未开通快速结算服务功能，请致电您的代理商开通快速结算服务。"); return
		 * "/main/fastsettle/merchant/settFastConfirm"; }
		 *
		 * // 验证商户快速结算配置 StraightlyCfg straightlyCfg =
		 * mspFacade.queryStraightlyCfg(merchantId, true); if (straightlyCfg ==
		 * null) { // 如果msp返回的费率为空是代理商未给商户配置费率,这种情况下提示商户 model.put("msg",
		 * "功能未开通或请在下一工作日重试，或联系客服"); return
		 * "/main/fastsettle/merchant/settFastConfirm"; } if
		 * (straightlyCfg.getFeeRate() == null) { //
		 * 如果msp返回的费率为空是代理商未给商户配置费率,这种情况下提示商户 model.put("msg",
		 * "功能未开通或请在下一工作日重试，或联系客服"); return
		 * "/main/fastsettle/merchant/settFastConfirm"; } else {
		 * model.put("feeRateStr", straightlyCfg.getFeeRate().multiply(new
		 * BigDecimal(100)).setScale(2)); } if (!straightlyCfg.isStraightFlag())
		 * { model.put("msg", "对不起，你还未开通快速结算服务功能，请致电您的代理商为您开通。"); return
		 * "/main/fastsettle/merchant/settFastConfirm"; }
		 *
		 * // 如果返回可用额度小于0 ，则返回0 BigDecimal validCredit = new BigDecimal(0); if
		 * (straightlyCfg.getValidCredit() != null) { validCredit =
		 * straightlyCfg.getValidCredit().compareTo(new BigDecimal(0)) == -1 ?
		 * new BigDecimal(0) : straightlyCfg.getValidCredit(); }
		 *
		 * model.put("straightFlag", straightlyCfg.isStraightFlag());
		 * model.put("validCredit", validCredit); model.put("feeRate",
		 * straightlyCfg.getFeeRate()); model.put("posMerchantNo",
		 * straightlyCfg.getPosMerchantId()); model.put("totalCredit",
		 * straightlyCfg.getCredit()); model.put("floorAmt",
		 * straightlyCfg.getFloorAmt()); BigDecimal useAmt =
		 * straightlyCfg.getCredit().subtract(straightlyCfg.getValidCredit());
		 * if (useAmt.compareTo(new BigDecimal(0)) < 0) { useAmt = new
		 * BigDecimal(0); } model.put("useAmt", useAmt);
		 *
		 * Integer loaningType =
		 * newt0PromoterService.getLoaningTypeByPromoterId(
		 * user.getPromoterId()); // 垫资方 model.put("loaningType", loaningType);
		 * FastSettleConfigDO fastSettleConfigDO =
		 * fastSettle.getFastSettleConfig(merchantId,
		 * OpObjTypeEnums.MERCHANT.code); boolean autoFlag = false; if
		 * (fastSettleConfigDO != null) { // 这里需要做判断 if
		 * (LoaningTypeEnum.SHENGPAY.getCode() == loaningType) autoFlag =
		 * fastSettleConfigDO.getAutoFastSettle() ==
		 * MerchantCreditConstant.MERCHANT_AUTO_FASTSETTLE_ON_LOANING_SHENGPAY;
		 * else if (LoaningTypeEnum.PROMOTER.getCode() == loaningType) autoFlag
		 * = fastSettleConfigDO.getAutoFastSettle() ==
		 * MerchantCreditConstant.MERCHANT_AUTO_FASTSETTLE_ON_LOANING_PROMOTER;
		 *
		 * if (autoFlag == true && loaningType ==
		 * LoaningTypeEnum.PROMOTER.getCode()) { // 代理商全资 并且自动快速结算已经开通
		 * model.put("autoFlag",
		 * AutoFastFlagEunms.PROMOTER_AUTOFLAG_TRUE.getCode()); } else if
		 * (autoFlag == true && loaningType ==
		 * LoaningTypeEnum.SHENGPAY.getCode()) { // 盛付通全资 并且自动快速结算已经开通
		 * model.put("autoFlag",
		 * AutoFastFlagEunms.SHENGPAY_AUTOFLAG_TRUE.getCode()); } else if
		 * (autoFlag == false && loaningType ==
		 * LoaningTypeEnum.PROMOTER.getCode()) { // 代理商全资 并且自动快速结算已经关闭
		 * model.put("autoFlag",
		 * AutoFastFlagEunms.PROMOTER_AUTOFLAG_FALSE.getCode()); } else if
		 * (autoFlag == false && loaningType ==
		 * LoaningTypeEnum.SHENGPAY.getCode()) { // 盛付通全资 并且自动快速结算已经关闭
		 * model.put("autoFlag",
		 * AutoFastFlagEunms.SHENGPAY_AUTOFLAG_FALSE.getCode()); } }else{
		 * //没有开通自动快速结算 if (loaningType == LoaningTypeEnum.PROMOTER.getCode()) {
		 * // 代理商全资 并且自动快速结算已经关闭
		 * model.put("autoFlag",AutoFastFlagEunms.PROMOTER_AUTOFLAG_FALSE
		 * .getCode()); } else if (loaningType ==
		 * LoaningTypeEnum.SHENGPAY.getCode()) { // 盛付通全资 并且自动快速结算已经关闭
		 * model.put("autoFlag",
		 * AutoFastFlagEunms.SHENGPAY_AUTOFLAG_FALSE.getCode()); } }
		 * List<McSettFastTxnRO> roList = new ArrayList<McSettFastTxnRO>();
		 *
		 * if (!(LoaningTypeEnum.SHENGPAY.getCode() == loaningType && autoFlag))
		 * { // 查询商户的快速结算交易列表 if (straightlyCfg.isStraightFlag()) { roList =
		 * mspFacade.queryMerchantValidFsOrders(user.getMerchantNo());
		 * request.getSession
		 * (true).setAttribute(MerchantCreditConstant.MERCHANT_VALID_FS_ORDERS,
		 * roList); } // model.put("autoFlag",3); // McSettFastTxnRO t1 = new
		 * McSettFastTxnRO(); // t1.setId(1l); // t1.setTxnTime(new Date()); //
		 * t1.setTxnNo(1234567890l); // t1.setTxnTypeName("typeName"); //
		 * t1.setTxnStatusName("statsName"); // t1.setTxnOrderNo(1234567890l);
		 * // t1.setAmt(new BigDecimal(5)); // t1.setFee(new BigDecimal(0.50));
		 * // t1.setStlAmt(new BigDecimal(123.5)); //
		 * t1.setCardTypeName("cardType"); //
		 * t1.setShortPanAsterisk("1111****345"); //
		 * t1.setIssuerName("issureName"); // t1.setTerminalNo("terminalNo"); //
		 * t1.setTxnStatus("1"); // roList.add(t1); // roList.add(t1); //
		 * roList.add(t1); // roList.add(t1); // roList.add(t1); //
		 * roList.add(t1); } model.put("roList", roList);
		 */

		return "/main/fastsettle/merchant/settFastConfirm";
	}

	/**
	 * saveSettFastConfirm
	 */
	@SuppressWarnings("unchecked")
	// @RequestMapping(value = "/saveSetFastConfirm")
	@ResponseBody
	public ErrorMessageVO saveSettFastConfirm(MerchantFastSettleVO fastSettleVO, HttpServletRequest request, ModelMap model) {
		/*
		 * MCMerchantUser user =
		 * MCMerchantUser.getMCMerchantUser(request.getSession()); Long
		 * merchantId = user.getMerchantId();
		 * logger.info("MerchantAction #saveSettFastConfirm:" +
		 * fastSettleVO.toString());
		 * Assert.notNull(fastSettleVO.getTxnOrderNos());
		 * Assert.notNull(fastSettleVO.getPosMerchantNo());
		 * Assert.notNull(fastSettleVO.getFeeRate());
		 *
		 * // 验证商户快速结算配置 StraightlyCfg straightlyCfg =
		 * mspFacade.queryStraightlyCfg(merchantId); model.put("straightFlag",
		 * straightlyCfg.isStraightFlag()); if (!straightlyCfg.isStraightFlag())
		 * { return new ErrorMessageVO(false, null,
		 * "对不起，你还未开通快速结算服务功能，请致电您的代理商为您开通。"); }
		 *//**
		 * 新T0增加时间判断
		 */
		/*
		 * // 垫资方 LoaningTypeEnum loaningTypeEnum =
		 * LoaningTypeEnum.getLoaningTypeEnum
		 * (newt0PromoterService.getLoaningTypeByPromoterId
		 * (user.getPromoterId())); if (loaningTypeEnum == null) {
		 * logger.error("The loaningType is not the standard type "); return new
		 * ErrorMessageVO(false, null, "对不起，你还未开通快速结算服务功能，请致电您的代理商为您开通。"); } //
		 * 查询垫资方基础信息 LoaningConfigBean loaningConfigBean =
		 * loaningCongfigService.
		 * getLoaningConfigBeanByLoaningType(loaningTypeEnum); Date currentDate
		 * = new Date(); if
		 * (currentDate.compareTo(loaningConfigBean.findFsBeginDate()) == -1 ||
		 * currentDate.compareTo(loaningConfigBean.findFsEndDate()) == 1) {
		 * return new ErrorMessageVO(false, null, "请在每天" +
		 * loaningConfigBean.getFsBeginTime() + "-" +
		 * loaningConfigBean.getFsEndTime() + "申请快速结算"); } MerchantInfoDTO
		 * merchantInfoDTO = mspFacade.findMerchantInfoByMerchantId(merchantId);
		 * // 盛付通全资校验商户是否是实时出款银行 if (LoaningTypeEnum.SHENGPAY == loaningTypeEnum
		 * && merchantInfoDTO.getFastSettleFlag() != null &&
		 * MerchantCreditConstant
		 * .FAST_SETTLE_FLAG_OPEN.equals(merchantInfoDTO.getFastSettleFlag
		 * ().toString())) {
		 * logger.info("MerchantAction#saveSettFastConfirm.205rows.mcType: "
		 * +merchantInfoDTO.getMcType());
		 * if(merchantInfoDTO.getMcType().equals(MerchantContractCst
		 * .TYPE_POS_MERCHANT)){ // 校验商户是否是直连银行，盛付通全资的情况下是不能让未绑定实时出款银行的商户做快速结算的
		 * ErrorMessageVO errorMessage =
		 * this.mspFacade.isSupportDirect2Bank4ShengPay
		 * (merchantInfoDTO.getMerchantNo()); if (!errorMessage.isSuccess()) {
		 * return errorMessage; } }else{ ErrorMessageVO eroVo
		 * =this.mspFacade.authQuery(merchantInfoDTO.getMerchantNo(),"ZF910");
		 * if (!eroVo.isSuccess()) { return eroVo; } } } try { List<Long> ids =
		 * new ArrayList<Long>(); String[] txnOrderNosArr =
		 * fastSettleVO.getTxnOrderNos().split(","); for (String txnOrderNoStr :
		 * txnOrderNosArr) { ids.add(Long.parseLong(txnOrderNoStr)); }
		 * List<McSettFastTxnRO> mcSettFastTxnROs = (List<McSettFastTxnRO>)
		 * request.getSession(true).getAttribute(MerchantCreditConstant.
		 * MERCHANT_VALID_FS_ORDERS); String msg =
		 * mspFacade.straightlySettle(user.getPromoterId(),
		 * user.getMerchantNo(), fastSettleVO.getPosMerchantNo(),
		 * user.getMerchantId() + "",
		 * MerchantCreditConstant.MERCHANT_FASTSETTLE_TYPE_MANUAL, ids,
		 * fastSettleVO.getFeeRate(), mcSettFastTxnROs); if
		 * (StringUtils.isNotEmpty(msg)) return new ErrorMessageVO(false, null,
		 * msg); } catch (Exception e) {
		 * logger.error("MerchantAction #saveSettFastConfirm ", e); return new
		 * ErrorMessageVO(false, null, "系统异常，请联系技术人员解决"); }
		 */
		return new ErrorMessageVO(true);
	}

	/**
	 * saveSettFastConfirm
	 */
	@RequestMapping(value = "/saveAutoSettle")
	@ResponseBody
	public ErrorMessageVO saveAutoSettleFast(MerchantFastSettleVO fastSettleVO, HttpServletRequest request, ModelMap model) {
		MCMerchantUser user = MCMerchantUser.getMCMerchantUser(request.getSession());
		Long merchantId = user.getMerchantId();
		// 验证商户快速结算配置
		StraightlyCfg straightlyCfg = mspFacade.queryStraightlyCfg(merchantId);
		model.put("straightFlag", straightlyCfg.isStraightFlag());
		if (!straightlyCfg.isStraightFlag()) { return new ErrorMessageVO(false, null, "对不起，你还未开通快速结算服务功能，请致电您的代理商为您开通。"); }

		int autoSettle = MerchantCreditConstant.MERCHANT_AUTO_FASTSETTLE_OFF;
		FastSettleConfigDO fastSettleConfigDO = fastSettle.getFastSettleConfig(merchantId, OpObjTypeEnums.MERCHANT.code);
		if (fastSettleConfigDO != null)
			autoSettle = fastSettleConfigDO.getAutoFastSettle() == MerchantCreditConstant.MERCHANT_AUTO_FASTSETTLE_ON_LOANING_PROMOTER ? MerchantCreditConstant.MERCHANT_AUTO_FASTSETTLE_OFF
					: MerchantCreditConstant.MERCHANT_AUTO_FASTSETTLE_ON_LOANING_PROMOTER;

		fastSettleVO.setAutoFastSettle(autoSettle + "");
		fastSettleVO.setMerchantId(user.getMerchantId() + "");

		ErrorMessageVO errorMessageVO = fastSettle.setMerchantAutoSettle(fastSettleVO, user.getAdminLoginName());
		if (!errorMessageVO.isSuccess()) {
			errorMessageVO.setErrorMessage("系统异常，请联系技术人员解决");
			logger.info("MerchantAction #saveAutoSettleFast:" + errorMessageVO.toString());
		} else {
			errorMessageVO.setErrorMessage(autoSettle == MerchantCreditConstant.MERCHANT_AUTO_FASTSETTLE_ON_LOANING_PROMOTER ? "开通自动快速结算成功"
					: "关闭自动快速结算成功");
		}
		return errorMessageVO;
	}

	/**
	 * T0出款管理菜单--首页
	 * **/
	@RequestMapping(value = "/withdrawIndex")
	public String transIndex(HttpServletRequest request, HttpServletResponse response, ModelMap model) {
		logger.info("withdrawIndex");
		MCMerchantUser user = MCMerchantUser.getMCMerchantUser(request.getSession());
		model.put("merchantNo", user.getMerchantNo());
		return "/main/fastsettle/withdrawIndex";
	}

	/**
	 * 提现对账单
	 * **/

	@RequestMapping(value = "/ajaxPaging/withdrawInfoList")
	public String withdrawInfoList(@ModelAttribute("query") ExtWithdrawReqDOExample query, HttpServletRequest request, HttpServletResponse response,
			ModelMap model) {
		try {
			if (query != null && StringUtils.isNotBlank(query.getMerchantNo())) {
				if (StringUtils.isNotBlank(query.getStartCreateTimeStr())) {
					query.setStartCreateTime(DateUtil.str2Date(query.getStartCreateTimeStr()));
				}

				if (StringUtils.isNotBlank(query.getEndCreateTimeStr())) {
					query.setEndCreateTime(DateUtil.str2Date(query.getEndCreateTimeStr()));
				}
			} else {
				return "/main/fastsettle/withdrawInfoList";
			}
			query.setWithdrawType(Integer.parseInt(WithdrawConstant.withdrawTypeRealTime));
			query.setStatus(WithdrawReqStatusEnums.SUCCESS.code);
			List<ExtWithdrawReqVO> dataList = extWithdrawReqManager.selectWithdrawReqByQuery(query);
			for (ExtWithdrawReqVO extw : dataList) {
				if (extw.getWithdrawAmount() == null || extw.getWithdrawCost() == null) {
					logger.error("NewT0IntraAction.withdrawInfoList.WithdrawAmount or WithdrawCost is null,WithdrawAmount:"
							+ extw.getWithdrawAmount() + ",WithdrawCost:" + extw.getWithdrawCost() + ",orderNo:" + extw.getOrderNo());
				} else {
					extw.setBankAccountAmount(extw.getWithdrawAmount().subtract(extw.getTotalCost()));
				}
			}
			model.put("dataList", dataList);
			model.put("query", query);

		} catch (Exception e) {
			logger.error("查询快速提现对账单繁忙，请稍后再试：" + e.getMessage(), e);
		}
		return "/main/fastsettle/withdrawInfoList";
	}

	@RequestMapping(value = "/withdrawDownload")
	@ResponseBody
	public void downloadExcel(@ModelAttribute("query") ExtWithdrawReqDOExample query, HttpServletRequest request, HttpServletResponse response,
			ModelMap model) {
		try {
			if (query != null) {
				if (StringUtils.isNotBlank(query.getMerchantNo())) {
					if (StringUtils.isNotBlank(query.getStartCreateTimeStr())) {
						query.setStartCreateTime(DateUtil.str2Date(query.getStartCreateTimeStr()));
					}

					if (StringUtils.isNotBlank(query.getEndCreateTimeStr())) {
						query.setEndCreateTime(DateUtil.str2Date(query.getEndCreateTimeStr()));
					}
				} else {
					doExcel(new ArrayList<ExtWithdrawReqVO>(), request, response);
				}
				query.setWithdrawType(Integer.parseInt(WithdrawConstant.withdrawTypeRealTime));
				query.setStatus(WithdrawReqStatusEnums.SUCCESS.code);
			}
			List<ExtWithdrawReqVO> dataList = extWithdrawReqManager.selectWithdrawReqByQuery(query);
			model.put("query", query);
			for (ExtWithdrawReqVO extw : dataList) {
				if (extw.getWithdrawAmount() == null || extw.getWithdrawCost() == null) {
					logger.error("NewT0IntraAction.withdrawInfoList.WithdrawAmount or WithdrawCost is null,WithdrawAmount:"
							+ extw.getWithdrawAmount() + ",WithdrawCost:" + extw.getWithdrawCost() + ",orderNo:" + extw.getOrderNo());
				} else {
					extw.setBankAccountAmount(extw.getWithdrawAmount().subtract(extw.getTotalCost()));
				}
			}
			doExcel(dataList, request, response);
		} catch (Exception e) {
			logger.error("POSAgentAction.downloadExcel error：" + e.getMessage(), e);
		}

	}

	/**
	 * 文件下载
	 */
	private void doExcel(List<ExtWithdrawReqVO> dataList, HttpServletRequest request, HttpServletResponse response) {
		// String fileName = DateUtil.datefosOrderFormat(new Date()) + ".csv";//
		// yyyyMMddHHmmss
		// OutputStream os = null;
		// try {
		// // 输出流
		// response.setContentType("application/csv;charset=gb18030");
		// response.setHeader("Content-Disposition", "attachment; filename=" +
		// fileName);
		//
		// String lineSeparator =
		// java.security.AccessController.doPrivileged(new
		// sun.security.action.GetPropertyAction("line.separator"));
		// String info = "提现时间,提现金额,提现手续费,银行卡到账金额,出款时间" + lineSeparator;
		// for (ExtWithdrawReqVO model : dataList) {
		// String createTime = model.getCreateTime() != null ?
		// DateUtil.dateFormat4(model.getCreateTime()) : "";
		// String withdrawAmount = model.getWithdrawAmount() != null ?
		// model.getWithdrawAmount().toString() : "";
		// String withdrawCost = model.getWithdrawCost() != null ?
		// model.getWithdrawCost().toString() : "";
		// String withdrawTime = model.getWithdrawTime() != null ?
		// DateUtil.dateFormat4(model.getWithdrawTime()) : "";
		// String bankAccountAmount = model.getBankAccountAmount() != null ?
		// model.getBankAccountAmount().toString() : "";
		// String dataInfo = createTime + "," + withdrawAmount + "," +
		// withdrawCost + "," + withdrawTime + "," + bankAccountAmount;
		// info = info + dataInfo + lineSeparator;
		// }
		// os = new BufferedOutputStream(response.getOutputStream());
		// byte[] infiByte = info.getBytes("gb18030"); // 将文件转换成字节数组
		// os.write(infiByte);
		// os.flush();
		// os.close();
		// } catch (Exception e) {
		// log.error("文件生成异常：" + e.getMessage());
		// return new ErrorMessageVO(false, "-1", "下载失败");
		// } finally {
		// // 关闭输出流
		// try {
		// if (os != null) {
		// os.close();
		// }
		// } catch (IOException e) {
		// log.error("OutputStream关闭异常", e);
		// }
		// }
		// return new ErrorMessageVO(true, "0", "下载成功");

		String fileName = DateUtil.datefosOrderFormat(new Date()) + ".xls";// yyyyMMddHHmmss
		OutputStream os = null;
		Workbook book = null;
		try {
			// 输出流
			response.setContentType("application/vnd.ms-excel");
			response.setHeader("Content-disposition", "attachment;filename=" + fileName);
			os = response.getOutputStream();
			// 创建工作区(97-2003)
			book = new HSSFWorkbook();
			// 创建第一个sheet页
			Sheet sheet1 = book.createSheet("sheet1");

			// 单元格宽度
			sheet1.setDefaultColumnWidth(18);

			// 列头的样式
			HSSFCellStyle sheetStyle = (HSSFCellStyle) book.createCellStyle();
			// 左右居中
			sheetStyle.setAlignment(HSSFCellStyle.ALIGN_CENTER);
			// 上下居中
			sheetStyle.setVerticalAlignment(HSSFCellStyle.VERTICAL_CENTER);
			int rowindex = 0;

			String headers[] = "结算时间,结算金额,结算手续费,结算成功时间,银行卡到账金额".split(",");
			
			// 设置字体
			HSSFFont columnHeadFont = (HSSFFont) book.createFont();
			columnHeadFont.setFontName("宋体");
			columnHeadFont.setFontHeightInPoints((short) 10);
			columnHeadFont.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);
			HSSFFont headfont = (HSSFFont) book.createFont();
			headfont.setFontName("黑体");
			headfont.setFontHeightInPoints((short) 22);// 字体大小
			headfont.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);// 加粗

			sheetStyle.setFont(columnHeadFont);

			Row row_a = sheet1.createRow(rowindex++);
			for (int hi = 0; hi < headers.length; hi++) {
				// 表头，hi：第几列
				row_a.setHeightInPoints(30);// 设置行高50
				HSSFCell cellhead = (HSSFCell) row_a.createCell(hi);// 每一列单元格
				cellhead.setCellValue(headers[hi]);
				cellhead.setCellStyle(sheetStyle);
			}

			// 单元行样式
			HSSFCellStyle columnHeadStyle = (HSSFCellStyle) book.createCellStyle();
			// 设置字体
			HSSFFont rowFont = (HSSFFont) book.createFont();
			columnHeadFont.setFontName("宋体");
			columnHeadFont.setFontHeightInPoints((short) 10);
			columnHeadFont.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);
			columnHeadStyle.setFont(rowFont);
			columnHeadStyle.setAlignment(HSSFCellStyle.ALIGN_CENTER);// 左右居中
			columnHeadStyle.setVerticalAlignment(HSSFCellStyle.VERTICAL_CENTER);// 上下居中

			for (ExtWithdrawReqVO model : dataList) {
				Row rown = sheet1.createRow(rowindex++);
				rown.setHeightInPoints(30);// 设置行高50
				// 创建每一列单元格样式
				HSSFCell cellhead0 = (HSSFCell) rown.createCell(0); // 每一列单元格
				HSSFCell cellhead1 = (HSSFCell) rown.createCell(1); // 每一列单元格
				HSSFCell cellhead2 = (HSSFCell) rown.createCell(2); // 每一列单元格
				HSSFCell cellhead3 = (HSSFCell) rown.createCell(3); // 每一列单元格
				HSSFCell cellhead4 = (HSSFCell) rown.createCell(4); // 每一列单元格

				/** 每一列单元格样式 **/
				cellhead0.setCellStyle(columnHeadStyle);
				cellhead1.setCellStyle(columnHeadStyle);
				cellhead2.setCellStyle(columnHeadStyle);
				cellhead3.setCellStyle(columnHeadStyle);
				cellhead4.setCellStyle(columnHeadStyle);
				/** 每一列单元格值 **/
				if (model.getCreateTime() != null) {
					cellhead0.setCellValue(DateUtil.dateFormat4(model.getCreateTime()));
				} else {
					cellhead0.setCellValue("");
				}
				cellhead1.setCellValue(model.getWithdrawAmount() + "");
				cellhead2.setCellValue(model.getWithdrawCost() + "");
				if (model.getWithdrawTime() != null) {
					cellhead3.setCellValue(DateUtil.dateFormat4(model.getWithdrawTime()));
				} else {
					cellhead3.setCellValue("");
				}
				cellhead4.setCellValue(model.getBankAccountAmount() + "");
			}

			// 写文件
			book.write(os);
			os.flush();
		} catch (Exception e) {
			logger.error("文件生成异常：" + e.getMessage());
		} finally {
			// 关闭输出流
			try {
				if (os != null) {
					os.close();
				}
			} catch (IOException e) {
				logger.error("OutputStream关闭异常：" + e.getMessage());
			}
		}

	}

}
