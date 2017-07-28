package com.sdp.mc.web.action.easypay;

import java.io.IOException;
import java.io.OutputStream;
import java.lang.reflect.Field;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.lang.ClassUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;
import org.apache.commons.lang.reflect.FieldUtils;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.formula.functions.T;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.sdo.common.lang.StringUtil;
import com.sdo.ma.ws.api.model.OperatorInfo;
import com.sdp.mc.common.enums.LimitTypeEnums;
import com.sdp.mc.common.enums.YesNoEnum;
import com.sdp.mc.common.settle.SettleOrderEnums;
import com.sdp.mc.common.util.DateUtil;
import com.sdp.mc.common.vo.ErrorMessageVO;
import com.sdp.mc.common.web.MCMerchantUser;
import com.sdp.mc.easypay.EasypayFacadeService;
import com.sdp.mc.easypay.TradeFacadeService;
import com.sdp.mc.easypay.vo.BussinessTypeUtil;
import com.sdp.mc.easypay.vo.EnterpriseAccountQueryRequest;
import com.sdp.mc.easypay.vo.EnterpriseAccountQueryResponse;
import com.sdp.mc.easypay.vo.EnterpriseBankCardInfo;
import com.sdp.mc.easypay.vo.EnterpriseRegisterAuthInfo;
import com.sdp.mc.easypay.vo.EnterpriseRegisterBaseInfo;
import com.sdp.mc.easypay.vo.EnterpriseRegisterReq;
import com.sdp.mc.easypay.vo.MerchantDetailVO;
import com.sdp.mc.easypay.vo.MerchantItemVO;
import com.sdp.mc.easypay.vo.MerchantQueryRequest;
import com.sdp.mc.easypay.vo.MerchantQueryResponse;
import com.sdp.mc.easypay.vo.QrCodeAllot;
import com.sdp.mc.easypay.vo.QrCodeQueryRequest;
import com.sdp.mc.easypay.vo.QrCodeQueryResponse;
import com.sdp.mc.easypay.vo.QrCodeRateQueryRequest;
import com.sdp.mc.easypay.vo.QrCodeRateQueryResponse;
import com.sdp.mc.easypay.vo.TradeItemVO;
import com.sdp.mc.easypay.vo.TradeRequest;
import com.sdp.mc.easypay.vo.TradeResponse;
import com.sdp.mc.fos.fundout.FundoutBankHelper;
import com.sdp.mc.fos.fundout.FundoutBankRO;
import com.sdp.mc.ma.wrapper.IOperatorWSServiceWrapper;
import com.sdp.mc.settle.api.dto.PromoterEasypaySettleOrderDTO;
import com.sdp.mc.settle.api.dto.PromoterEasypaySettleOrderDplDTO;
import com.sdp.mc.settle.api.enums.ReturnCodeEnums;
import com.sdp.mc.web.action.BaseAction;
import com.sdp.mc.web.vo.EasyPayMerchantRequest;
import com.sdp.mc.web.vo.EasyPayQrCodeAllotRequest;
import com.sdp.mc.web.vo.EasyPayQrCodeQueryRequest;
import com.sdp.mc.web.vo.EasyPayQrCodeRateQueryRequest;
import com.sdp.mc.web.vo.EasyPayTradeRequest;
import com.sdp.mc.web.vo.EasypayEnterpriseAccountRequest;
import com.sdp.withdraw.enums.PosMerchantTypeEnums;


@Controller
@RequestMapping(value = { "/posPromoter/easypay", "/mposPromoter/easypay", "/mposPartnerPromoter/easypay" })
public class EasyPayAction extends BaseAction {
	private static final Logger log = LoggerFactory.getLogger(EasyPayAction.class);

	@Autowired
	private TradeFacadeService tradeFacadeService;
	
	@Autowired
	private EasypayFacadeService easypayFacadeService;

	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Autowired
	private IOperatorWSServiceWrapper iOperatorWSServiceWrapper;
	
	@Value("${easypay.rate}")
	private String rateString;
	
	/**
	 * 文件下载
	 */
	private <T> void doExcel(String[] headers, List<T> dataList, HttpServletResponse response) {
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
				row_a.setHeightInPoints(20);// 设置行高
				HSSFCell cellhead = (HSSFCell) row_a.createCell(hi);// 每一列单元格
				String title = headers[hi].split(":")[1];
				cellhead.setCellValue(title);
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

			for (T model : dataList) {
				Row rown = sheet1.createRow(rowindex++);
				rown.setHeightInPoints(20);// 设置行高
				// 创建单元格
				for (int i = 0; i < headers.length; i++) {
					HSSFCell cell = (HSSFCell) rown.createCell(i);
					cell.setCellStyle(columnHeadStyle);
					String fieldName = headers[i].split(":")[0];
					Field field = FieldUtils.getDeclaredField(model.getClass(), fieldName, true);
					Object val = field.get(model);
					cell.setCellValue(trimNull(val));
				}
			}

			// 写文件
			book.write(os);
			os.flush();
		} catch (Exception e) {
			log.error("文件生成异常：", e);
		} finally {
			// 关闭输出流
			try {
				if (os != null) {
					os.close();
				}
			} catch (IOException e) {
				log.error("OutputStream关闭异常：" + e.getMessage());
			}
		}

	}

	private String trimNull(Object val) {
		if (val == null) {
			return "";
		} else if (ClassUtils.isAssignable(val.getClass(), Date.class)) {
			return DateUtil.dateFormat4((Date) val);
		} else {
			return val.toString();
		}
	}

	@RequestMapping(value = "/trade/index")
	public String tradeIndex(HttpSession session, ModelMap model) {
		MCMerchantUser user = MCMerchantUser.getMCMerchantUser(session);
		String promoterType = user.getCurrentMcType();
		List<OperatorInfo> operatorInfoList = new ArrayList<OperatorInfo>();
		if (PosMerchantTypeEnums.POS_PROMOTER.code.equals(promoterType)) {
			operatorInfoList = iOperatorWSServiceWrapper.queryOperators(user.getMemberId());
			model.addAttribute("operatorInfoList", operatorInfoList);
		} else if (PosMerchantTypeEnums.MPOS_PROMOTER.code.equals(promoterType)) {
			queryChildMerchants(user.getMerchantNo(), model);
		}
		model.addAttribute("promoterType", promoterType);
		return "/main/easypay/tradeIndex";
	}

	/**
	 * 交易查询
	 */
	@RequestMapping(value = "/trade/list")
	public String tradeList(@ModelAttribute("query") EasyPayTradeRequest query, HttpSession session, ModelMap model) {
		MCMerchantUser user = MCMerchantUser.getMCMerchantUser(session);
		String promoterType = user.getCurrentMcType();
		if (PosMerchantTypeEnums.POS_PROMOTER.code.equals(user.getCurrentMcType()) && !user.getAdminFlag()) {
			query.setParentMerchantNo(user.getOperatorId());
		} else {
			query.setParentMerchantNo(user.getMerchantNo());
		}
		log.info("easypay trade query init");
		long time = System.currentTimeMillis();
		try {
			TradeRequest tRequest = new TradeRequest();
			BeanUtils.copyProperties(query, tRequest);
			tRequest.setPageNo(query.getCurrentPage());
			TradeResponse resp = tradeFacadeService.query(tRequest);
			query.setTotalItem(resp.getTotalCount().intValue());
			query.setCurrentPage(resp.getPageNo());
			model.addAttribute("query", query);
			model.addAttribute("dataList", resp.getList());
			model.addAttribute("promoterType", promoterType);
			log.info("easypay trade query end,use time:" + (System.currentTimeMillis() - time));
		} catch (Exception e) {
			log.error("查询云收银交易繁忙，请稍后再试：" + e.getMessage(), e);
		}
		return "/main/easypay/tradeList";
	}

	@RequestMapping(value = "/trade/DownLoad")
	@ResponseBody
	public void tradeDownLoad(@ModelAttribute("query") EasyPayTradeRequest query, HttpSession session,
			HttpServletResponse response) throws IOException {
		MCMerchantUser user = MCMerchantUser.getMCMerchantUser(session);
		if (PosMerchantTypeEnums.POS_PROMOTER.code.equals(user.getCurrentMcType()) && !user.getAdminFlag()) {
			query.setParentMerchantNo(user.getOperatorId());
		} else {
			query.setParentMerchantNo(user.getMerchantNo());
		}
		TradeRequest tRequest = new TradeRequest();
		BeanUtils.copyProperties(query, tRequest);
		tRequest.setPageSize(1000000);
		List<TradeItemVO> dataList = tradeFacadeService.query(tRequest).getList();

		String[] headers = { "orderNo:订单号", "merchantNo:商户号", "merchantName:商户名称", "payTime:支付时间", "payAmount:支付金额",
				"fee:手续费", "rate:手续费率", "payStatus:支付状态", "payType:支付类型", "payProduct:支付产品", "payMethod:支付方式",
				"operator:经手人", "secondProxy:二级代理商账号", "notes:备注" };
		if (dataList.size() > 0) {
			doExcel(headers, dataList, response);
		}

	}

	@RequestMapping(value = "/merchant/index")
	public String merchantIndex(HttpSession session, ModelMap model) {
		MCMerchantUser user = MCMerchantUser.getMCMerchantUser(session);
		String promoterType = user.getCurrentMcType();
		List<OperatorInfo> operatorInfoList = new ArrayList<OperatorInfo>();
		if (PosMerchantTypeEnums.POS_PROMOTER.code.equals(promoterType)) {
			operatorInfoList = iOperatorWSServiceWrapper.queryOperators(user.getMemberId());
			model.addAttribute("operatorInfoList", operatorInfoList);
		} else if (PosMerchantTypeEnums.MPOS_PROMOTER.code.equals(promoterType)) {
			queryChildMerchants(user.getMerchantNo(), model);
		}
		model.addAttribute("promoterType", promoterType);
		return "/main/easypay/merchantIndex";
	}

	@RequestMapping(value = "/merchant/list")
	public String merchantList(@ModelAttribute("query") EasyPayMerchantRequest query, HttpSession session,
			ModelMap model) {
		MCMerchantUser user = MCMerchantUser.getMCMerchantUser(session);
		String promoterType = user.getCurrentMcType();
		if (PosMerchantTypeEnums.POS_PROMOTER.code.equals(user.getCurrentMcType()) && !user.getAdminFlag()) {
			query.setParentMerchantNo(user.getOperatorId());
		} else {
			query.setParentMerchantNo(user.getMerchantNo());
		}
		log.info("easypay merchant query init");
		long time = System.currentTimeMillis();
		try {
			MerchantQueryRequest tRequest = new MerchantQueryRequest();
			BeanUtils.copyProperties(query, tRequest);
			tRequest.setPageNo(query.getCurrentPage());
			MerchantQueryResponse resp = tradeFacadeService.merchantQuery(tRequest);
			query.setTotalItem(resp.getTotalCount().intValue());
			query.setCurrentPage(resp.getPageNo());
			model.addAttribute("query", query);
			model.addAttribute("dataList", resp.getList());
			model.addAttribute("promoterType", promoterType);
			log.info("easypay merchant query end,use time:" + (System.currentTimeMillis() - time));
		} catch (Exception e) {
			log.error("查询云收银商户查询繁忙，请稍后再试：" + e.getMessage(), e);
		}
		return "/main/easypay/merchantList";
	}

	@RequestMapping(value = "/merchant/DownLoad")
	@ResponseBody
	public void merchantDownLoad(@ModelAttribute("query") EasyPayMerchantRequest query, HttpSession session,
			HttpServletResponse response) throws IOException {
		MCMerchantUser user = MCMerchantUser.getMCMerchantUser(session);
		if (PosMerchantTypeEnums.POS_PROMOTER.code.equals(user.getCurrentMcType()) && !user.getAdminFlag()) {
			query.setParentMerchantNo(user.getOperatorId());
		} else {
			query.setParentMerchantNo(user.getMerchantNo());
		}
		// query.setParentMerchantNo(user.getMerchantNo());
		MerchantQueryRequest tRequest = new MerchantQueryRequest();
		BeanUtils.copyProperties(query, tRequest);
		tRequest.setPageSize(1000000);
		List<MerchantItemVO> dataList = tradeFacadeService.merchantQuery(tRequest).getList();

		String[] headers = { "merchantNo:商户号", "merchantName:商户名称", "rate:签约费率", "registerStatus:开户状态",
				"realNameStatus:实名审核状态", "createDate:注册日期", "secondProxy:二级代理商账号", "operator:操作员" };
		if (dataList.size() > 0) {
			doExcel(headers, dataList, response);
		}
	}

	@RequestMapping(value = "/merchant/detail")
	public String merchantDetail(HttpServletRequest request, HttpServletResponse response, ModelMap model) {
		String merchantNo = request.getParameter("merchantNo");
		MerchantDetailVO vo = tradeFacadeService.merchantDetailQuery(merchantNo);
		String cardNo = vo.getSettleCardNo();
		String newCardNO = StringUtils.left(cardNo, 4) + "*****" + StringUtils.right(cardNo, 4);
		vo.setSettleCardNo(newCardNO);
		model.addAttribute("detail", vo);
		return "/main/easypay/merchantDetail";
	}

	/**
	 * 云收银二维码管理
	 * 
	 * @return
	 */
	@RequestMapping(value = "/qrcode/index")
	public String qrcodeIndex() {
		return "/main/easypay/qrcodeIndex";
	}

	/**
	 * 云收银二维码管理分页查询
	 * 
	 * @return
	 */
	@RequestMapping(value = "/qrcode/list")
	public String qrcodeList(@ModelAttribute("query") EasyPayQrCodeQueryRequest query, ModelMap model,
			HttpSession session) {
		MCMerchantUser user = MCMerchantUser.getMCMerchantUser(session);
		query.setParentMerchantNo(user.getMerchantNo());
		log.info("easypay qrcode query init");
		long time = System.currentTimeMillis();
		try {
			QrCodeQueryRequest request = new QrCodeQueryRequest();
			BeanUtils.copyProperties(query, request);
			request.setPageNo(query.getCurrentPage());
			QrCodeQueryResponse resp = tradeFacadeService.qrcodeAllotQuery(request);
			query.setTotalItem(resp.getTotalCount().intValue());
			query.setCurrentPage(resp.getPageNo());
			model.addAttribute("query", query);
			model.addAttribute("dataList", resp.getList());
			log.info("easypay qrcode query end,use time:" + (System.currentTimeMillis() - time));
		} catch (Exception e) {
			log.error("查询云收银二维码查询繁忙，请稍后再试：" + e.getMessage(), e);
		}

		return "/main/easypay/qrcodeList";
	}

	/**
	 * 二维码管理删除
	 * 
	 */
	@RequestMapping(value = "/qrcode/delete")
	@ResponseBody
	public ErrorMessageVO<T> deleteQrcode(String merchantNo, String id, ModelMap model, HttpSession session) {
		ErrorMessageVO<T> message = new ErrorMessageVO<T>(false);
		if (!StringUtils.isNotBlank(merchantNo) || !StringUtils.isNotBlank(id)) {
			message.setErrorMessage("商户信息有误！");
			return message;
		}
		String result = tradeFacadeService.deleteQrcode(merchantNo, id);
		JSONObject obj = JSON.parseObject(result);
		boolean success = obj.getBooleanValue("success");
		message.setSuccess(success);
		if (!success) {
			String errorMsg = obj.getString("resultMessage");
			message.setErrorMessage(errorMsg);
		}
		return message;
	}

	@RequestMapping(value = "/qrcode/detail", method = RequestMethod.GET)
	public String qrcodeDetail(ModelMap model, HttpSession session) {
		MCMerchantUser user = MCMerchantUser.getMCMerchantUser(session);
		String promoterType = user.getCurrentMcType();
		List<OperatorInfo> operatorInfoList = new ArrayList<OperatorInfo>();
		try {
			if (PosMerchantTypeEnums.POS_PROMOTER.code.equals(promoterType)) {
				operatorInfoList = iOperatorWSServiceWrapper.queryOperators(user.getMemberId());
				model.addAttribute("operatorInfoList", operatorInfoList);
				model.addAttribute("promoterType", promoterType);
			} else if (PosMerchantTypeEnums.MPOS_PROMOTER.code.equals(promoterType)) {
				queryChildMerchants(user.getMerchantNo(), model);
			}
		} catch (Exception e) {
			log.error("查询繁忙，请稍后再试：" + e.getMessage(), e);
		}
		return "/main/easypay/qrcodeDetail";
	}

	@RequestMapping(value = "/qrcode/detail", method = RequestMethod.POST)
	public String qrcodeAllot(EasyPayQrCodeAllotRequest request, ModelMap model, HttpSession session) {
		MCMerchantUser user = MCMerchantUser.getMCMerchantUser(session);
		QrCodeAllot allot = new QrCodeAllot();
		String promoterType = user.getCurrentMcType();
		List<OperatorInfo> operatorInfoList = new ArrayList<OperatorInfo>();
		allot.setQrStartCode(request.getQrStartCode());
		allot.setQrEndCode(request.getQrEndCode());
		String[] ChildMerchants = request.getChildMerchant().split("\\|");
		allot.setChildMerchantNo(ChildMerchants[0]);
		allot.setChildMerchantName(ChildMerchants[1]);
		allot.setOperatorId(user.getDisplayUserName());
		allot.setParentMerchantNo(user.getMerchantNo());
		String result = tradeFacadeService.qrcodeAllot(allot);
		JSONObject obj = JSON.parseObject(result);
		boolean success = obj.getBooleanValue("success");
		if (!success) {
			String errorMsg = obj.getString("resultMessage");
			model.addAttribute("errorMsg", errorMsg);
			model.addAttribute("allot", request);
			if (PosMerchantTypeEnums.POS_PROMOTER.code.equals(promoterType)) {
				operatorInfoList = iOperatorWSServiceWrapper.queryOperators(user.getMemberId());
				model.addAttribute("operatorInfoList", operatorInfoList);
				model.addAttribute("promoterType", promoterType);
			} else if (PosMerchantTypeEnums.MPOS_PROMOTER.code.equals(promoterType)) {
				queryChildMerchants(user.getMerchantNo(), model);
			}
			return "/main/easypay/qrcodeDetail";
		}
		return "/main/easypay/resultDetail";
	}

	private void queryChildMerchants(String merchantNo, ModelMap model) {
		List<Map<String, Object>> list;
		if (StringUtils.equalsIgnoreCase(merchantNo, "SFT")) {
			String sql = "select * from mcredit.fw_pos_merchant_info t where   t.merchant_type='0007' and t.pmt_level=1";
			list = jdbcTemplate.queryForList(sql);
		} else {
			String sql = "select  t1.merchant_no,t1.merchant_name "
					+ "from mcredit.fw_pos_merchant_info t1,mcredit.fw_pos_merchant_info t2 "
					+ "where   t1.merchant_type='9999' " + "and t1.parent_promoter_id=t2.id " + "and t2.merchant_no=? ";
			list = jdbcTemplate.queryForList(sql, merchantNo);
		}
		model.addAttribute("childMerchants", list);
	}

	@RequestMapping(value = "/merchant/channel")
	public String merchantChannelIndex() {
		return "/main/easypay/merchantChannelIndex";
	}

	@RequestMapping(value = "/merchant/channelList")
	public String merchantChannelList(@ModelAttribute("query") EasyPayMerchantRequest query, String channel,
			String channelAction, String merchantNoArray, HttpSession session, ModelMap model) {
		MCMerchantUser user = MCMerchantUser.getMCMerchantUser(session);
		if (PosMerchantTypeEnums.POS_PROMOTER.code.equals(user.getCurrentMcType()) && !user.getAdminFlag()) {
			query.setParentMerchantNo(user.getOperatorId());
		} else {
			query.setParentMerchantNo(user.getMerchantNo());
		}
		// query.setParentMerchantNo(user.getMerchantNo());
		log.info("easypay merchant query init");
		long time = System.currentTimeMillis();
		try {
			if (StringUtils.isNotBlank(merchantNoArray)) {
				tradeFacadeService.channelSwitch(channel, channelAction, merchantNoArray);
			}
			MerchantQueryRequest tRequest = new MerchantQueryRequest();
			BeanUtils.copyProperties(query, tRequest);
			tRequest.setPageNo(query.getCurrentPage());
			MerchantQueryResponse resp = tradeFacadeService.merchantQuery(tRequest);
			query.setTotalItem(resp.getTotalCount().intValue());
			query.setCurrentPage(resp.getPageNo());
			model.addAttribute("query", query);
			model.addAttribute("dataList", resp.getList());
			log.info("easypay merchant query end,use time:" + (System.currentTimeMillis() - time));
		} catch (Exception e) {
			log.error("查询云收银商户查询繁忙，请稍后再试：" + e.getMessage(), e);
		}
		return "/main/easypay/merchantChannelList";
	}

	/**
	 * 云收银费率管理
	 */
	@RequestMapping(value = "/qrcoderate/index")
	public String qrcoderateIndex(ModelMap model) {
		String[] rates = rateString.split(",");
		model.addAttribute("rates", rates);
		return "/main/easypay/qrcodeRateIndex";
	}

	/**
	 * 云收银费率管理分页查询
	 * 
	 */
	@RequestMapping(value = "/qrcoderate/list")
	public String qrcoderateList(@ModelAttribute("query") EasyPayQrCodeRateQueryRequest query, String qrcodes,
			BigDecimal rate, HttpSession session, ModelMap model) {
		MCMerchantUser user = MCMerchantUser.getMCMerchantUser(session);
		if (PosMerchantTypeEnums.POS_PROMOTER.code.equals(user.getCurrentMcType()) && !user.getAdminFlag()) {
			query.setMerchantNo(user.getOperatorId());
		} else {
			query.setMerchantNo(user.getMerchantNo());
		}
		// query.setMerchantNo(user.getMerchantNo());
		log.info("easypay qrcoderateList query init");
		long time = System.currentTimeMillis();
		try {
			if (StringUtils.isNotBlank(qrcodes) && rate != null) {
				tradeFacadeService.qrCodeRateUpdate(qrcodes, rate);
			}
			QrCodeRateQueryRequest tRequest = new QrCodeRateQueryRequest();
			BeanUtils.copyProperties(query, tRequest);
			tRequest.setPageNo(query.getCurrentPage());
			QrCodeRateQueryResponse resp = tradeFacadeService.qrCodeRateQuery(tRequest);
			query.setTotalItem(resp.getTotalCount().intValue());
			if (query.getPageFristItem() > query.getTotalItem()) {
				query.setCurrentPage(1);
			}
			query.setCurrentPage(resp.getPageNo());
			model.addAttribute("query", query);
			model.addAttribute("dataList", resp.getList());
			log.info("easypay qrcoderateList end,use time:" + (System.currentTimeMillis() - time));
		} catch (Exception e) {
			log.error("查询云收银商户查询繁忙，请稍后再试：" + e.getMessage(), e);
		}
		return "/main/easypay/qrcodeRateList";
	}

	/**
	 * 云收银费率开启关闭操作
	 */
	@RequestMapping(value = "/qrcoderate/allowStatus")
	@ResponseBody
	public ErrorMessageVO<T> allowStatus(String qrcodes, String allowStatus, ModelMap model, HttpSession session) {
		ErrorMessageVO<T> message = new ErrorMessageVO<T>(false);
		log.info("easypay allowStatus qrcodes,{} allowStatus,{} ", qrcodes, allowStatus);
		String result = tradeFacadeService.allowStatus(qrcodes, allowStatus);
		// String result = tradeFacadeService.deleteQrcode(merchantNo, id);
		JSONObject obj = JSON.parseObject(result);
		boolean success = obj.getBooleanValue("success");
		message.setSuccess(success);
		if (!success) {
			String errorMsg = obj.getString("resultMessage");
			message.setErrorMessage(errorMsg);
		}
		return message;
	}

	/**
	 * 云收银二维码采购
	 * 
	 * @param
	 * @return
	 */
	@RequestMapping(value = "/purchase/index")
	public String purchaseIndex(ModelMap model) {
		return "/main/easypay/purchaseIndex";
	}

	@RequestMapping(value = "/purchase/list")
	public String purchaseList(@ModelAttribute("query") EasyPayQrCodeQueryRequest query, ModelMap model,
			HttpSession session) {
		MCMerchantUser user = MCMerchantUser.getMCMerchantUser(session);
		query.setParentMerchantNo(user.getMerchantNo());
		log.info("easypay purchase query init");
		long time = System.currentTimeMillis();
		try {
			QrCodeQueryRequest request = new QrCodeQueryRequest();
			BeanUtils.copyProperties(query, request);
			request.setPageNo(query.getCurrentPage());
			QrCodeQueryResponse resp = tradeFacadeService.qrcodeAllotQuery(request);
			query.setTotalItem(resp.getTotalCount().intValue());
			query.setCurrentPage(resp.getPageNo());
			model.addAttribute("query", query);
			model.addAttribute("dataList", resp.getList());
			log.info("easypay purchase query end,use time:" + (System.currentTimeMillis() - time));
		} catch (Exception e) {
			log.error("云收银二维码查询繁忙，请稍后再试：" + e.getMessage(), e);
		}
		
		return "/main/easypay/purchaseList";
	}

	// 采购信息
	@RequestMapping(value = "/purchase/cashierPurchase")
	public String cashierPurchase(EasyPayMerchantRequest mo, ModelMap model, HttpSession session) {
		return "/main/easypay/purchaseList";
	}

	// 发货
	@RequestMapping(value = "/purchase/purchaseFreight", method = RequestMethod.GET)
	public String qrcodeDe(ModelMap model, HttpSession session) {
		MCMerchantUser user = MCMerchantUser.getMCMerchantUser(session);
		queryChildMerchants(user.getMerchantNo(), model);
		return "/main/easypay/purchaseFreight";
	}

	/**
	 * 云收银分润结算单查询
	 */
	@RequestMapping(value = "/easypayPfsOrderIndex")
	public String settleOrderIndex(HttpServletRequest request, HttpServletResponse response, ModelMap model) {
		Date tmp = DateUtil.getMothFirstDay(-1);
		model.put("settleQueryBeginTime", DateUtil.formatDate(tmp, DateUtil.monthFormat));
		return "/main/easypay/settle/order/easypayPfsOrderIndex";
	}
	/**
	 * 云收银分润结算单分页查询
	 */
	@RequestMapping(value = "/easypayPfsOrderList")
	public String settleOrderList(@ModelAttribute("info") PromoterEasypaySettleOrderDTO info, HttpServletRequest request, HttpServletResponse response,
			ModelMap model, HttpSession session){
		MCMerchantUser user = MCMerchantUser.getMCMerchantUser(session);
		try {
		if (StringUtil.isBlank(info.getSettleQueryBeginTime())) {
			String queryBeginTime = DateUtil.dateFormat4(DateUtil.getMothFirstDay(-1));// 上一个月第一天
			String queryEndTime = DateUtil.dateFormat4(DateUtil.getMothLastDay(-1));// 上一个月最后一天
			info.setSettleQueryBeginTime(queryBeginTime);
			info.setSettleQueryEndTime(queryEndTime);
		} else {
			Date beginDate = DateUtil.formartMoth2MothFirstDay(info.getSettleQueryBeginTime().trim());
			String queryBeginTime = DateUtil.dateFormat4(beginDate);
			info.setSettleQueryBeginTime(queryBeginTime);
			Date endDate = DateUtil.getLastDayFromMothFirstDay(beginDate);
			String queryEndTime = DateUtil.dateFormat4(endDate);
			info.setSettleQueryEndTime(queryEndTime);
		}
		info.setQueryPromoterNo(user.getMerchantNo());
		info.setQueryPromoterRole(PosMerchantTypeEnums.EASYPAY_PROMOTER.code);
		info.setQuerySettleStatus((SettleOrderEnums.REVIEWED.code));
		info.setPageSize(100);
		PromoterEasypaySettleOrderDplDTO responseDto = scSettleBaseService.getSettleOrderService().queryEasypaySettleOrdersByPage(info);
		log.info("settleOrderList#responseDto{}", responseDto);
		model.put("page", responseDto);
		model.put("dataList", responseDto.getPromoterEasypaySettleOrders());
		} catch (Exception e) {
			log.error("EasypayAction#settleOrderList error {},{}", new Object[] { e.getMessage(), e });
		}
		return "/main/easypay/settle/order/easypayPfsOrderList";
	}
	
	/**
	 * 云收银分润下载
	 */
	@RequestMapping(value = "/easypayPfsExportOrderData")
	public void simpleEasypayExportOrderData(String id, HttpServletRequest request, HttpServletResponse response, ModelMap model, HttpSession session) throws Exception {
		log.info("EasypaySettleOrderAction#simpleEasypayExportOrderData request {}", ToStringBuilder.reflectionToString(id));
//		ErrorMessageVO<T> message = new ErrorMessageVO<T>(false);
		MCMerchantUser user = MCMerchantUser.getMCMerchantUser(request.getSession());
		if (StringUtils.isBlank(user.getMerchantNo())) {
			model.put("msg", "代理商不存在!");
			throw new RuntimeException("代理商不存在!");
		}
		PromoterEasypaySettleOrderDTO easypaySettleOrderDTO = new PromoterEasypaySettleOrderDTO();
		easypaySettleOrderDTO.setOperatorId(user.getMerchantNo() + "");
		easypaySettleOrderDTO.setOperatorName(user.getMerchantNo() + "");
		easypaySettleOrderDTO.setSettleOrderId(id);
		log.info("toSummary,{}", ToStringBuilder.reflectionToString(easypaySettleOrderDTO, ToStringStyle.SHORT_PREFIX_STYLE));
		PromoterEasypaySettleOrderDTO responseDto = scSettleBaseService.getSettleOrderService().summary2EasypayExcelInfo4POSPromoter(easypaySettleOrderDTO);
		log.info("toSummary,{}", ToStringBuilder.reflectionToString(responseDto, ToStringStyle.SHORT_PREFIX_STYLE));
		if (!responseDto.getRespCode().equalsIgnoreCase(ReturnCodeEnums.SUCESS.code)) throw new RuntimeException(responseDto.getRespMsg());

		String fileKey = responseDto.getFileKey();
		String fileName = responseDto.getFileName();
		fileDownloadsView(fileKey, fileName, response, CONTENT_TYPE);
	}


	/**
	 * 企业云收银进件管理EnterpriseAccount
	 */
	@RequestMapping(value = "/enterpriseAccount/index")
	public String enterpriseAccountIndex() {
		return "/main/easypay/enterpriseAccount/index";
	}

	/**
	 * 企业云收银进件管理
	 */
	@RequestMapping(value = "/enterpriseAccount/list")
	public String enterpriseAccountQueryByPage(EasypayEnterpriseAccountRequest query, HttpSession session,
			ModelMap model) {
		MCMerchantUser user = MCMerchantUser.getMCMerchantUser(session);
		query.setMerchantNo(user.getMerchantNo());
		log.info("easypay purchase query init");
		long time = System.currentTimeMillis();
		try {
			
			EnterpriseAccountQueryRequest request = new EnterpriseAccountQueryRequest();
			query.setStartTime(DateUtil.parse2StringFormatString(query.getStartTime()));
			query.setEndTime(DateUtil.parse2StringFormatString(query.getEndTime()));
			BeanUtils.copyProperties(query, request);
			request.setPageNo(query.getCurrentPage());
			EnterpriseAccountQueryResponse response = easypayFacadeService.enterpriseAccountQuery(request);
			query.setTotalItem(response.getTotalCount().intValue());
			query.setCurrentPage(response.getPageNo());
			model.addAttribute("query", query);
			model.addAttribute("dataList", response.getList());
		} catch (Exception e) {
			log.error("enterpriseAccountQueryByPage e{}", e.getMessage(), e);
		}
		return "/main/easypay/enterpriseAccount/list";
	}

	/**
	 * 企业账户新增
	 */
	@RequestMapping(value = "/enterpriseAccount/add")
	public String enterpriseAccountAdd(String id, ModelMap model, HttpSession session, HttpServletRequest request, HttpServletResponse response) {
		log.info("easypay enterpriseAccountAdd  init id{},", id);
		long time = System.currentTimeMillis();
		String bussinessTypeList = "";
		try {
			//查询行业类型
			bussinessTypeList = easypayFacadeService.queryIndustryCategory();
			List<FundoutBankRO> bankROList = FundoutBankHelper.getAllCompanyBankList();
			String readonlyStatus = request.getParameter("status");
			if(StringUtils.isNotBlank(id)){
				EnterpriseRegisterReq registerReq= easypayFacadeService.queryRecord(id);
				BussinessTypeUtil bussinessTypeName = easypayFacadeService.getBussinessName(bussinessTypeList, registerReq.getBaseInfo().getBussinessType());
				String status = registerReq.getBaseInfo().getStatus();
				String realNameStatus = registerReq.getBaseInfo().getRealNameStatus();
				if("6".equals(status) && "4".equals(realNameStatus)){
					model.addAttribute("realNameStatus", "openAccount");
				}
				if(StringUtils.isNotBlank(request.getParameter("status"))){
					model.addAttribute("readonlyStatus", readonlyStatus);
					model.addAttribute("realNameStatus", "");
				}
				registerReq.getAuthInfo().setCertifyEndTime(DateUtil.getStringTime(registerReq.getAuthInfo().getCertifyEndTime()));
				registerReq.getAuthInfo().setCertifyStartTime(DateUtil.getStringTime(registerReq.getAuthInfo().getCertifyStartTime()));
				registerReq.getAuthInfo().setIdcardEndTime(DateUtil.getStringTime(registerReq.getAuthInfo().getIdcardEndTime()));
				registerReq.getAuthInfo().setIdcardStartTime(DateUtil.getStringTime(registerReq.getAuthInfo().getIdcardStartTime()));
				String idcar = registerReq.getAuthInfo().getIdcard();
				String bankCard = registerReq.getBankCardInfo().getBankCard();
				String identityId = registerReq.getBankCardInfo().getIdentityId();
				idcar = subStrIdCard(idcar);
				bankCard = subStrIdCard(bankCard);
				identityId = subStrIdCard(identityId);
				model.addAttribute("idcard_hidden", idcar);
				model.addAttribute("bankCard_hidden", bankCard);
				model.addAttribute("identityId_hidden", identityId);
				model.addAttribute("baseInfo", registerReq.getBaseInfo());
				model.addAttribute("authInfo", registerReq.getAuthInfo());
				model.addAttribute("bankCardInfo", registerReq.getBankCardInfo());
				model.addAttribute("bussinessTypeName", bussinessTypeName);
			}
			model.addAttribute("bussinessTypeList", bussinessTypeList);
			model.addAttribute("bankROList", bankROList);
			log.info("easypay enterpriseAccountAdd end,use time:" + (System.currentTimeMillis() - time));
		} catch (Exception e) {
			log.error("初始化保存页面异常：" + e.getMessage(), e);
		}
		return "/main/easypay/enterpriseAccount/add";
	}
	
	public String subStrIdCard(String str){
		String result = "";
		if(StringUtils.isNotBlank(str)){
			result = str.substring(0, 3)+"**** ****"+str.substring(str.length()-4, str.length());
		}
		return result;
	}
	
	/**
	 * 保存待提交
	 */
	@RequestMapping(value = "/enterpriseAccount/temporarySave")
	@ResponseBody
	public ErrorMessageVO<T> temporarySave(EnterpriseRegisterBaseInfo baseInfo, EnterpriseRegisterAuthInfo authInfo, EnterpriseBankCardInfo bankCardInfo, ModelMap model, HttpSession session, HttpServletRequest request, HttpServletResponse response){
		log.info("easypay temporarySave");
		long time = System.currentTimeMillis();
		ErrorMessageVO<T> message = new ErrorMessageVO<T>(false);
		//如果ID不为空，修改处理身份证卡号
		if(StringUtils.isNotBlank(request.getParameter("baseInfo_id"))){
			boolean flag = false;
			String idcard = request.getParameter("idcard_hidden");
			String bankCard = request.getParameter("bankCard_hidden");
			if(StringUtils.isNotBlank(idcard)){
				flag = containAsterisk(idcard);
				if(flag) authInfo.setIdcard(idcard);
			}
			if(StringUtils.isNotBlank(bankCard)){
				flag = containAsterisk(bankCard);
				if(flag) bankCardInfo.setBankCard(bankCard);
			}
			//修改时将ID赋值
			baseInfo.setId(request.getParameter("baseInfo_id"));
		}else{
			authInfo.setIdcard(request.getParameter("idcard_hidden"));
			bankCardInfo.setBankCard(request.getParameter("bankCard_hidden"));
		}
		//营业执照时间永久
		if(StringUtils.isNotBlank(request.getParameter("isPermanent"))){
			if(LimitTypeEnums.PERMANENT.code.equals(request.getParameter("isPermanent"))){
				authInfo.setCertifyEndTime("9999-12-31");
			}
		}
		String[] bank = bankCardInfo.getBankCode().split("\\|");
		bankCardInfo.setBankCode(bank[0]);
		bankCardInfo.setBankName(bank[1]);
		baseInfo.setProvinceCode(request.getParameter("provinceCode_baseInfo"));
		baseInfo.setCityCode(request.getParameter("cityCode_baseInfo"));
		bankCardInfo.setProvinceCode(request.getParameter("provinceCode_bankCardInfo"));
		bankCardInfo.setCityCode(request.getParameter("cityCode_bankCardInfo"));
		EnterpriseRegisterReq enterpriseRegisterReq = new EnterpriseRegisterReq();
		MCMerchantUser user = MCMerchantUser.getMCMerchantUser(session);
		String merchantNo = user.getMerchantNo();
		try {
			baseInfo.setProxyMerchantId(merchantNo);
			enterpriseRegisterReq.setMerchantStatus(YesNoEnum.NO.code);
			enterpriseRegisterReq.setBaseInfo(baseInfo);
			enterpriseRegisterReq.setAuthInfo(authInfo);
			enterpriseRegisterReq.setBankCardInfo(bankCardInfo);
			String result = easypayFacadeService.register(enterpriseRegisterReq);
			JSONObject obj = JSON.parseObject(result);
			boolean success = obj.getBooleanValue("success");
			message.setSuccess(success);
			if (!success) {
				String errorMsg = obj.getString("resultMessage");
				message.setErrorMessage(errorMsg);
			}
			log.info("easypay temporarySave end,use time:" + (System.currentTimeMillis() - time));
		} catch (Exception e) {
			log.error("临时保存失败：" + e.getMessage(), e);
		}
		return message;
	}
	/**
	 * 提交申请
	 */
	@RequestMapping(value = "/enterpriseAccount/saveSubmit")
	@ResponseBody
	public ErrorMessageVO<T> saveSubmit(EnterpriseRegisterBaseInfo baseInfo, EnterpriseRegisterAuthInfo authInfo, EnterpriseBankCardInfo bankCardInfo, ModelMap model, HttpSession session, HttpServletRequest request, HttpServletResponse response){
		log.info("easypay saveSubmit ");
		long time = System.currentTimeMillis();
		ErrorMessageVO<T> message = new ErrorMessageVO<T>(false);
		// 如果ID不为空，修改处理身份证卡号
		if (StringUtils.isNotBlank(request.getParameter("baseInfo_id"))) {
			boolean flag = false;
			String idcard = request.getParameter("idcard_hidden");
			String bankCard = request.getParameter("bankCard_hidden");
			if (StringUtils.isNotBlank(idcard)) {
				flag = containAsterisk(idcard);
				if (flag)
					authInfo.setIdcard(idcard);
			}
			if (StringUtils.isNotBlank(bankCard)) {
				flag = containAsterisk(bankCard);
				if (flag)
					bankCardInfo.setBankCard(bankCard);
			}
			// 修改时将ID赋值
			baseInfo.setId(request.getParameter("baseInfo_id"));
		} else {
			authInfo.setIdcard(request.getParameter("idcard_hidden"));
			bankCardInfo.setBankCard(request.getParameter("bankCard_hidden"));
		}
		// 营业执照时间永久
		if (StringUtils.isNotBlank(request.getParameter("isPermanent"))) {
			if (LimitTypeEnums.PERMANENT.code.equals(request.getParameter("isPermanent"))) {
				authInfo.setCertifyEndTime("9999-12-31");
			}
		}
		String[] bank = bankCardInfo.getBankCode().split("\\|");
		bankCardInfo.setBankCode(bank[0]);
		bankCardInfo.setBankName(bank[1]);
		baseInfo.setProvinceCode(request.getParameter("provinceCode_baseInfo"));
		baseInfo.setCityCode(request.getParameter("cityCode_baseInfo"));
		bankCardInfo.setProvinceCode(request.getParameter("provinceCode_bankCardInfo"));
		bankCardInfo.setCityCode(request.getParameter("cityCode_bankCardInfo"));
		MCMerchantUser user = MCMerchantUser.getMCMerchantUser(session);
		String merchantNo = user.getMerchantNo();
		try {
			baseInfo.setProxyMerchantId(merchantNo);
			EnterpriseRegisterReq enterpriseRegisterReq = new EnterpriseRegisterReq();
			enterpriseRegisterReq.setMerchantStatus(YesNoEnum.YES.code);
			enterpriseRegisterReq.setBaseInfo(baseInfo);
			enterpriseRegisterReq.setAuthInfo(authInfo);
			enterpriseRegisterReq.setBankCardInfo(bankCardInfo);
			String result = easypayFacadeService.register(enterpriseRegisterReq);
			JSONObject obj = JSON.parseObject(result);
			boolean success = obj.getBooleanValue("success");
			message.setSuccess(success);
			if (!success) {
				String errorMsg = obj.getString("resultMessage");
				message.setErrorMessage(errorMsg);
			}
			log.info("easypay saveSubmit end,use time:" + (System.currentTimeMillis() - time));
		} catch (Exception e) {
			log.error("保存提交失败：" + e.getMessage(), e);
		}
		return message;
	}
	
	public boolean containAsterisk(String str) {
		for (int i = 0; i < str.length(); i++) {
			char c = str.charAt(i);
			if ("*".equals(String.valueOf(c))) {
				return false;
			}
		}
		return true;
	}
	

}
