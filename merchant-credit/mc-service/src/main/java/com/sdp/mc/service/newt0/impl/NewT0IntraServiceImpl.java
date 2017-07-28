package com.sdp.mc.service.newt0.impl;

import java.io.IOException;
import java.io.OutputStream;
import java.math.BigDecimal;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.hssf.usermodel.HSSFRichTextString;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.hssf.util.HSSFColor;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sdp.mc.common.constant.MerchantCreditConstant;
import com.sdp.mc.common.enums.LoanOpTypeEnums;
import com.sdp.mc.common.enums.LoanStatusEnums;
import com.sdp.mc.common.enums.MarginOpRedeemEnums;
import com.sdp.mc.common.enums.OpTypeEnums;
import com.sdp.mc.common.enums.UserOperaRecordEnum;
import com.sdp.mc.common.util.DateUtil;
import com.sdp.mc.common.vo.ErrorMessageVO;
import com.sdp.mc.integration.fos.dto.request.RemitTransferRequestDTO;
import com.sdp.mc.integration.fos.enums.FOSPaymentCodeEnum;
import com.sdp.mc.integration.ma.dto.MerchantBalanceDTO;
import com.sdp.mc.ma.wrapper.AccountQueryFacadeWrapper;
import com.sdp.mc.margin.dao.MarginOpReqDO;
import com.sdp.mc.margin.dao.ext.RedeemedMarginApplyExampleExt;
import com.sdp.mc.margin.dao.ext.RedeemedMarginApplyExt;
import com.sdp.mc.margin.manager.MarginOpReqManager;
import com.sdp.mc.newt0.dao.NewT0UserOperaRecordDO;
import com.sdp.mc.newt0.dao.NewT0UserOperaRecordDOExample;
import com.sdp.mc.newt0.dao.Newt0SdpRemainBalanceDO;
import com.sdp.mc.newt0.dao.Newt0SdpRemainBalanceDOExample;
import com.sdp.mc.newt0.dao.daointerface.NewT0UserOperaRecordDAO;
import com.sdp.mc.newt0.manager.ExtNewt0SdpRemainBalanceManager;
import com.sdp.mc.newt0.manager.Newt0SdpRemainBalanceManager;
import com.sdp.mc.promoter.dao.PromoterFastSettleSwitchDO;
import com.sdp.mc.promoter.dao.PromoterFastSettleSwitchDOExample;
import com.sdp.mc.promoter.manager.PromoterFastSettleSwitchManager;
import com.sdp.mc.service.newt0.NewT0IntraService;
import com.sdp.mc.service.op.OpService;
import com.sdp.mc.service.op.state.OpContext;
import com.sdp.mc.service.op.state.OpStateResponse;
import com.sdp.mc.view.dao.ViewPromoterInfoDTO;
import com.sdp.withdraw.enums.PosMerchantTypeEnums;
import com.sdp.withdraw.manager.WithdrawReqManager;
import com.shengpay.service.BaseCommonService;
import com.shengpay.service.view.PromoterInfoService;

/**
 * NEW T0 垫资管理
 *
 * @author wangmindong
 *
 */
@Service("newT0IntraService")
public class NewT0IntraServiceImpl implements NewT0IntraService {
	private static final Logger log = LoggerFactory.getLogger(NewT0IntraServiceImpl.class);

	@Autowired
	private Newt0SdpRemainBalanceManager newt0SdpRemainBalanceManager;

	@Autowired
	protected MarginOpReqManager marginOpReqManager;

	@Autowired
	private OpService opService;

	@Autowired
	private PromoterFastSettleSwitchManager promoterFastSettleSwitchManager;

	@Autowired
	private AccountQueryFacadeWrapper accountQueryFacadeWrapper;

	@Autowired
	private NewT0UserOperaRecordDAO newT0UserOperaRecordDAO;

	@Autowired
	private ExtNewt0SdpRemainBalanceManager extNewt0SdpRemainBalanceManager;

	@Autowired
	private WithdrawReqManager withdrawReqManager;
	
	@Autowired
	private PromoterInfoService promoterInfoService;
	

	@Override
	public Long insert(Newt0SdpRemainBalanceDO record) {
		// TODO Auto-generated method stub
		return newt0SdpRemainBalanceManager.insert(record);
	}

	@Override
	public List<Newt0SdpRemainBalanceDO> pageQueryWithCapital(Newt0SdpRemainBalanceDOExample example) {
		// TODO Auto-generated method stub
		return this.newt0SdpRemainBalanceManager.selectByQuery(example);
	}

	@Override
	public List<Newt0SdpRemainBalanceDO> selectByExample(Newt0SdpRemainBalanceDOExample example) {
		// TODO Auto-generated method stub
		return newt0SdpRemainBalanceManager.selectByExample(example);
	}

	@Override
	public int updateByPrimaryKey(Newt0SdpRemainBalanceDO record) {
		// TODO Auto-generated method stub
		return newt0SdpRemainBalanceManager.updateByPrimaryKey(record);
	}

	@Override
	public int updateByPrimaryKeySelective(Newt0SdpRemainBalanceDO record) {
		// TODO Auto-generated method stub
		return newt0SdpRemainBalanceManager.updateByPrimaryKeySelective(record);
	}

	public boolean modifyNewt0SdpRemainBalance(Newt0SdpRemainBalanceDO config) {

		Map<String, Object> updateMap = new HashMap<String, Object>();
		updateMap.put("id", config.getId());
		updateMap.put("quota", config.getQuota());
		return extNewt0SdpRemainBalanceManager.updateCanUseQuota(updateMap);

		// Newt0SdpRemainBalanceDO record = new Newt0SdpRemainBalanceDO();
		// record.setId(config.getId());
		// record.setQuota(config.getQuota());
		// record.setCanUseQuota(amountStr);
		// record.setUpdateTime(new Date());
		// return
		// newt0SdpRemainBalanceManager.updateByPrimaryKeySelective(record);
	}

	@Override
	public List<RedeemedMarginApplyExt> selectRedeemedReq(RedeemedMarginApplyExampleExt example) {
		// 查询到账日期是明天的数据
		// Date NextDay = DateUtil.increaseDate(new Date(), 1);
		// example.setRedeemedTimeStr(DateUtil.generateDawnTimeStamp(NextDay));
		// example.setRedeemedTimeEnd(DateUtil.generateMidnightTimeStamp(NextDay));
		// 默认时间区间为当前一天，以及当前时间的前181天
		example.setCreateTimeStart(example.getRedeemedTimeStr());
		example.setCreateTimeEnd(example.getRedeemedTimeEnd());
		// example.setRedeemedTimeStr(DateUtil.generateDawnTimeStamp(new
		// Date()));
		example.setRedeemedTimeEnd(DateUtil.generateMidnightTimeStamp(new Date()));
		example.setOpType(OpTypeEnums.REDEEMED.code);
		example.setStatus(example.getStatus());
		example.setOrderByClause(" REDEEMED_TIME desc ");
		example.setPageSize(100);
		List<RedeemedMarginApplyExt> MarginOpReqDOs = marginOpReqManager.selectByNewT0AuditingQuery4Intra(example);
		return MarginOpReqDOs;
	}

	/**
	 * 统计取回金额
	 */
	@Override
	public BigDecimal totalAmount(RedeemedMarginApplyExampleExt example) {
		// TODO Auto-generated method stub
		example.setCreateTimeStart(example.getRedeemedTimeStr());
		example.setCreateTimeEnd(example.getRedeemedTimeEnd());
		example.setRedeemedTimeStr(DateUtil.generateDawnTimeStamp(new Date()));
		example.setRedeemedTimeEnd(DateUtil.generateMidnightTimeStamp(new Date()));
		example.setOpType(OpTypeEnums.REDEEMED.code);
		example.setStatus(example.getStatus());
		return marginOpReqManager.totalAmount(example);
	}

	/**
	 * 文件下载
	 */
	@Override
	public void doExcel(List<RedeemedMarginApplyExt> dataList, HttpServletRequest request, HttpServletResponse response) {
		String fileName = DateUtil.datefosOrderFormat(new Date()) + ".xls";// yyyyMMddHHmmss
		// ErrorMessageVO messageModel = new ErrorMessageVO(false);
		OutputStream os = null;
		Workbook book = null;
		try {
			// 输出流
			// fileName = Util.encodeFilename(fileName, request);
			response.setContentType("application/vnd.ms-excel");
			response.setHeader("Content-disposition", "attachment;filename=" + fileName);
			os = response.getOutputStream();// new FileOutputStream(reportPath +
											// fileName);
			// 创建工作区(97-2003)
			book = new HSSFWorkbook();
			// 创建第一个sheet页
			Sheet sheet1 = book.createSheet("sheet1");

			// 单元格宽度
			sheet1.setDefaultColumnWidth(18);

			// 列头的样式
			HSSFCellStyle sheetStyle = (HSSFCellStyle) book.createCellStyle();
			// 背景色的设定
			sheetStyle.setFillBackgroundColor(HSSFColor.GREY_25_PERCENT.index);

			// 前景色的设定
			sheetStyle.setFillForegroundColor(HSSFColor.GREY_25_PERCENT.index);

			// 左右居中
			sheetStyle.setAlignment(HSSFCellStyle.ALIGN_CENTER);

			// 上下居中
			sheetStyle.setVerticalAlignment(HSSFCellStyle.VERTICAL_CENTER);

			int rowindex = 0;

			String headers[] = " 商户号,商户名称,请款时间,保证金金额 ,申请取回金额,放款人,放款状态,申请时间,放款时间".split(",");
			// 填充模式
			sheetStyle.setFillPattern(HSSFCellStyle.FINE_DOTS);

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

			for (RedeemedMarginApplyExt model : dataList) {
				Row rown = sheet1.createRow(rowindex++);
				rown.setHeightInPoints(30);// 设置行高50
				// 创建每一列单元格样式
				HSSFCell cellhead0 = (HSSFCell) rown.createCell(0); // 每一列单元格
				HSSFCell cellhead1 = (HSSFCell) rown.createCell(1); // 每一列单元格
				HSSFCell cellhead2 = (HSSFCell) rown.createCell(2); // 每一列单元格
				HSSFCell cellhead3 = (HSSFCell) rown.createCell(3); // 每一列单元格
				HSSFCell cellhead4 = (HSSFCell) rown.createCell(4); // 每一列单元格
				HSSFCell cellhead5 = (HSSFCell) rown.createCell(5); // 每一列单元格
				HSSFCell cellhead6 = (HSSFCell) rown.createCell(6); // 每一列单元格
				HSSFCell cellhead7 = (HSSFCell) rown.createCell(7); // 每一列单元格
				HSSFCell cellhead8 = (HSSFCell) rown.createCell(8); // 每一列单元格

				/** 每一列单元格样式 **/
				cellhead0.setCellStyle(columnHeadStyle);
				cellhead1.setCellStyle(columnHeadStyle);
				cellhead2.setCellStyle(columnHeadStyle);
				cellhead3.setCellStyle(columnHeadStyle);
				cellhead4.setCellStyle(columnHeadStyle);
				cellhead5.setCellStyle(columnHeadStyle);
				cellhead6.setCellStyle(columnHeadStyle);
				cellhead7.setCellStyle(columnHeadStyle);
				cellhead8.setCellStyle(columnHeadStyle);
				/** 每一列单元格值 **/
				cellhead0.setCellValue(new HSSFRichTextString(model.getPromoterId() + ""));
				cellhead1.setCellValue(model.getMcMerchantName());
				cellhead2.setCellValue(DateUtil.dateFormat4(model.getRedeemedTime()));
				cellhead3.setCellValue(model.getFastSettleMargin() + "");
				cellhead4.setCellValue(model.getAmount() + "");
				cellhead5.setCellValue(model.getRealName());
				if (model.getStatus() == LoanStatusEnums.LOAN_INIT.code) {
					cellhead6.setCellValue(new HSSFRichTextString(LoanStatusEnums.LOAN_INIT.desc));
				} else if (model.getStatus() == LoanStatusEnums.LOAN_SUCCESS.code) {
					cellhead6.setCellValue(new HSSFRichTextString(LoanStatusEnums.LOAN_SUCCESS.desc));
				} else if (model.getStatus() == LoanStatusEnums.LOAN_FAILURE.code) {
					cellhead6.setCellValue(new HSSFRichTextString(LoanStatusEnums.LOAN_FAILURE.desc));
				} else if (model.getStatus() == LoanStatusEnums.LOAN_REFUSE.code) {
					cellhead6.setCellValue(new HSSFRichTextString(LoanStatusEnums.LOAN_REFUSE.desc));
				}
				cellhead7.setCellValue(DateUtil.dateFormat4(model.getRedeemedTime()));
				cellhead8.setCellValue(model.getOperaTime() == null ? "" : DateUtil.dateFormat4(model.getOperaTime()));
			}

			// 写文件
			book.write(os);
			os.flush();
		} catch (Exception e) {
			log.error("文件生成异常：" + e.getMessage());
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
		// 下载
		/*
		 * try { FileUtil.download(reportPath, fileName, request, response);
		 * messageModel.setSuccess(true); messageModel.setErrorMessage("导出成功!");
		 * } catch (Exception e) { log.error("文件下载异常："+e.getMessage()); }
		 */
		// return messageModel;
	}

	/**
	 * 放款操作
	 */
	@Override
	public ErrorMessageVO loanOperation(String morIds, int status, String operator, String operatorId) {
		// TODO Auto-generated method stub
		ErrorMessageVO message = new ErrorMessageVO(false);
		int successCount = 0;
		int errorCount = 0;
		BigDecimal successBig = new BigDecimal("0.00");
		BigDecimal errorBig = new BigDecimal("0.00");
		StringBuffer msgBuffer = new StringBuffer();
		for (int i = 0; i < morIds.split(",").length; i++) {
			Long morId = Long.parseLong(morIds.split(",")[i]);
			MarginOpReqDO marginOpReqDo = marginOpReqManager.selectByPrimaryKey(morId);
			OpContext context = new OpContext();
			context.setAmount(marginOpReqDo.getAmount().setScale(2, BigDecimal.ROUND_HALF_UP));
			context.setBizId(morId);
			context.setOpType(OpTypeEnums.REDEEMED.code);

			Long promoterId = marginOpReqDo.getPromoterId();
			// 取保证金账号
			PromoterFastSettleSwitchDOExample example = new PromoterFastSettleSwitchDOExample();
			example.setPromoterId(promoterId);
			List<PromoterFastSettleSwitchDO> list = promoterFastSettleSwitchManager.selectByExample(example);
			if (!list.isEmpty() && list.size() > 1) {
				log.error("RedeemedTask #run,promoterId:" + promoterId + ",select TB_PROMOTER_FS_RQ not unique.");
			}
			PromoterFastSettleSwitchDO promoterFastSettleSwitchDO = list.get(0);
			String memberId = promoterFastSettleSwitchDO.getMarginMemberId();
			String marginAccount = promoterFastSettleSwitchDO.getMarginAccount();
			ViewPromoterInfoDTO promoterInfo=promoterInfoService.queryPromoterById(promoterId);
			context.setPromoterType(promoterInfo.getPromoterType());
			// 取基本户账号
			MerchantBalanceDTO balanceDTO = null;
			try {
				balanceDTO = accountQueryFacadeWrapper.queryMerchantBalance(memberId,promoterInfo.getPromoterType());
			} catch (Exception e) {
				log.error("RedeemedTask #run," + e);
			}
			OpStateResponse response = null;
			if (balanceDTO != null) {
				String marginAccountId = balanceDTO.getMarginAccountId();
				String publicAccountId = balanceDTO.getPublicAccountId();
				if (!marginAccount.equalsIgnoreCase(marginAccountId)) {
					log.error("RedeemedTask #run, database Margin Account not equal MA Margin Account,DB Margin Account:" + marginAccount
							+ ",Ma Margin AccountId:" + marginAccountId);
				}

				RemitTransferRequestDTO transferRequest = new RemitTransferRequestDTO();
				transferRequest.setRemitVoucherNo(BaseCommonService.generatorSeq());
				transferRequest.setPaymentCode(FOSPaymentCodeEnum.SUB2BASE);
				transferRequest.setPayerAccountNo(marginAccount);
				transferRequest.setPayerAccountType(PosMerchantTypeEnums.EASYPAY_PROMOTER.code.equals(context.getPromoterType())?
						MerchantCreditConstant.ACCOUNT_TYPE_4_MARGIN_EASYPAY:
						PosMerchantTypeEnums.MPOS_PROMOTER.code.equals(context.getPromoterType())?MerchantCreditConstant.ACCOUNT_TYPE_4_MARGIN_MPOS:MerchantCreditConstant.ACCOUNT_TYPE_4_MARGIN);
				transferRequest.setPayeeAccountNo(publicAccountId);
				transferRequest.setPayeeAccountType(MerchantCreditConstant.ACCOUNT_TYPE_4_PUBLIC);
				transferRequest.setRemitAmount(marginOpReqDo.getAmount());
				transferRequest.setPayerMemberId(memberId);
				transferRequest.setPayeeMemberId(memberId);
				transferRequest.setAppId(MerchantCreditConstant.MC_WEBSITE_ZF_NO);

				context.setRemitTransferRequest(transferRequest);
				if (LoanOpTypeEnums.LOAN_OP_STATUS.getCode() == status) {
					response = opService.handler(context, MarginOpRedeemEnums.CONFIGURE_SUCCESS.code, operatorId);
				} else if (LoanOpTypeEnums.LOAN_REFUSE_OP_STATUS.getCode() == status) {
					response = opService.handler(context, MarginOpRedeemEnums.LOAIN_REFUSE.code, operatorId);
				}
			}

			if (response == null || !response.isSuccess()) {
				errorCount++;
				errorBig = errorBig.add(marginOpReqDo.getAmount());
			} else {
				successCount++;
				successBig = successBig.add(marginOpReqDo.getAmount());
			}

			modfiyNewT0UserOpreaRecord(morId, operator, operatorId);
		}
		if (LoanOpTypeEnums.LOAN_OP_STATUS.getCode() == status) {
			msgBuffer.append("放款成功金额:" + successBig + ",成功笔数：" + successCount + "笔。放款失败金额：" + errorBig + ",失败笔数：" + errorCount + "笔。");
		} else if (LoanOpTypeEnums.LOAN_REFUSE_OP_STATUS.getCode() == status) {
			msgBuffer.append("拒绝放款成功金额:" + successBig + ",成功笔数：" + successCount + "笔。拒绝放款失败金额：" + errorBig + ",失败笔数：" + errorCount + "笔。");
		}
		message.setErrorMessage(msgBuffer.toString());
		message.setErrorCode("0");
		return message;
	}

	/**
	 * 修改放款操作用户记录信息
	 *
	 * @param morId
	 * @param operator
	 * @param operatorId
	 */
	private void modfiyNewT0UserOpreaRecord(Long morId, String operator, String operatorId) {
		// TODO Auto-generated method stub
		NewT0UserOperaRecordDOExample recordExample = new NewT0UserOperaRecordDOExample();
		recordExample.createCriteria().andBizIdEqualTo(morId);
		recordExample.createCriteria().andOperaTimeIsNull();
		recordExample.createCriteria().andBizTypeEqualTo(UserOperaRecordEnum.RTMARGIN.getCode());
		NewT0UserOperaRecordDO recordRecord = new NewT0UserOperaRecordDO();
		recordRecord.setRealname(operator);
		recordRecord.setUsername(operatorId);
		recordRecord.setOperaTime(new Date());
		recordRecord.setUpdateTime(new Date());
		newT0UserOperaRecordDAO.updateByExampleSelective(recordRecord, recordExample);
	}

}
