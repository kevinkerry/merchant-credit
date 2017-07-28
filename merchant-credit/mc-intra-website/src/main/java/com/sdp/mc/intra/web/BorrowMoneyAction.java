package com.sdp.mc.intra.web;

import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.sdp.mc.common.util.DateUtil;
import com.sdp.mc.common.util.MCUtil;
import com.shengpay.debit.common.enums.MerchantDebitOrderStatusEnums;
import com.shengpay.debit.common.service.MerchantDebitOrderService;
import com.shengpay.debit.dal.dataobject.DoBorrowMoneyPO;
import com.shengpay.debit.dal.ext.dataobject.ExtDoMerchantDebitOrderExample;

/**
 * 借款查询 借款明细查询
 *
 * @author liutao
 *
 */
@Controller
@RequestMapping("/borrowMoney")
public class BorrowMoneyAction {
	private static final Logger logger = LoggerFactory.getLogger(BorrowMoneyAction.class);

	@Autowired
	private MerchantDebitOrderService merchantDebitOrderService;

	/**
	 * 操作系统分割符
	 */
	private static final String lineSepartor = "\n";

	// private static final String lineSepartor =
	// System.getProperty("line.separator");

	/**
	 * 初始化查询页面
	 * **/
	@RequestMapping(value = "/borrow/index")
	public String initBorrowMoneryIndex(HttpServletRequest request, ModelMap model) {
		model.put("statusEnums", MerchantDebitOrderStatusEnums.values());
		return "/debit/borrow/index";
	}

	/**
	 *
	 * 借款查询ajaxPaging/borrowList
	 *
	 * @param queryParam
	 * @param response
	 * @param model
	 * @return String
	 */
	@RequestMapping(value = "/ajaxPaging/borrowList")
	public String borrowMonery(ExtDoMerchantDebitOrderExample queryParam, HttpServletRequest request, ModelMap model) {
		logger.info("BorrowMoneyAction-->borrowMonery-->start queryParam=" + queryParam);
		List<DoBorrowMoneyPO> dataList = null;
		try {
			dataList = this.merchantDebitOrderService.pageQueryBorrowMonery(queryParam);
			logger.info("BorrowMoneyAction-->borrowMonery-->dataList=" + dataList);
			model.put("dataList", dataList);
		} catch (Exception e) {
			// 用log替换
			logger.error("BorrowMoneyAction-->/ajaxPaging/borrowList借款查询异常：" + e.getMessage());
			dataList = new ArrayList<DoBorrowMoneyPO>();
			model.put("dataList", dataList);
		}

		model.put("query", queryParam);
		return "/debit/borrow/borrowMoneryList";
	}

	@RequestMapping(value = "/borrow/downloadCsv")
	public void downloadCsvFile(ExtDoMerchantDebitOrderExample queryParam, HttpServletRequest request, HttpServletResponse response, ModelMap model) throws IOException {
		logger.info("BorrowMoneyAction-->borrowMonery-->start queryParam=" + queryParam);
		List<DoBorrowMoneyPO> dataList = null;
		try {
			queryParam.setPageSize(9999);
			dataList = this.merchantDebitOrderService.pageQueryBorrowMonery(queryParam);
			logger.info("BorrowMoneyAction-->borrowMonery-->dataList=" + dataList);
			model.put("dataList", dataList);
		} catch (Exception e) {
			// 用log替换
			logger.error("BorrowMoneyAction-->/ajaxPaging/borrowList借款查询异常：" + e.getMessage());
			dataList = new ArrayList<DoBorrowMoneyPO>();
			model.put("dataList", dataList);
		}
		OutputStream os = null;
		OutputStream out=null;
		try {

			String fileName = "CsvDebit" + DateUtil.datefosOrderFormat(new Date()) + ".csv";
			response.setContentType("application/csv;charset=gb18030");
			response.setHeader("Content-Disposition", "attachment; filename=" + fileName);
			StringBuilder sb = new StringBuilder();
			// head 头部
			sb.append("订单号, 商户名称, 商户号, 代理商名称, 代理商商户号, 状态, 逾期天数, 逾期利息, 借款日期, 还款日期, 借款本金, 借款利息, 手续费");
			sb.append(lineSepartor);
			SimpleDateFormat dateFormat4 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			for (int i = 0; i < dataList.size(); i++) {
				sb.append(dataList.get(i).getId() + ","); // 订单号
				sb.append(dataList.get(i).getMerchantName() + ","); // 商户名称
				sb.append(dataList.get(i).getMerchantNo() + ","); // 商户号
				sb.append(dataList.get(i).getPromoterName() + ","); // 代理商名称
				sb.append(dataList.get(i).getPromoterNo() + ","); // 代理商商户号
				int days = MCUtil.daysBetween(dataList.get(i).getEndTime(), dataList.get(i).getDueRepaymentTime());
				String status = dataList.get(i).getStatus();
				if (MerchantDebitOrderStatusEnums.INIT.getKey().equals(status)) {
					sb.append("初始(放款中),");
				} else if (MerchantDebitOrderStatusEnums.PAYBACKING.getKey().equals(status) && days < 0) {
					sb.append("还款中(未到期),");
				} else if (MerchantDebitOrderStatusEnums.PAYBACKING.getKey().equals(status) && days == 0) {
					sb.append("还款中(已到期),");
				} else if (MerchantDebitOrderStatusEnums.OVERDUEING.getKey().equals(status)) {
					sb.append("逾期中(已到期),");
				} else if (MerchantDebitOrderStatusEnums.OVERDUEING_PAYBACK_SUCCESS.getKey().equals(status)) {
					sb.append("逾期还款成功,");
				} else if (MerchantDebitOrderStatusEnums.NORMAL_PAYBACK_SUCCESS.getKey().equals(status)) {
					sb.append("正常还款成功,");
				} else {
					sb.append(MerchantDebitOrderStatusEnums.getDescByKey(status) + ",");
				}
				if (days < 0 || MerchantDebitOrderStatusEnums.NORMAL_PAYBACK_SUCCESS.getKey().equals(status)) {
					sb.append("0,");
				} else {
					sb.append(days + ",");
				}
				sb.append(dataList.get(i).getOverDueAmount() == null ? "," : dataList.get(i).getOverDueAmount() + ",");

				sb.append(dateFormat4.format(dataList.get(i).getTransferTime()) + ",");
				sb.append(dateFormat4.format(dataList.get(i).getEndTime()) + ",");
				sb.append(dataList.get(i).getDebitAmount() + ",");
				sb.append(dataList.get(i).getInterestAmount() + ",");
				sb.append(dataList.get(i).getServiceAmount());
				sb.append(lineSepartor);
			}
			// String x = new String(sb.toString().getBytes(), "gb18030");
			// out.write(ResponseEncodeingUtil.writeEncodingUtf8(x));
			byte[] infiByte = sb.toString().getBytes("gb18030"); // 将文件转换成字节数组
			out=response.getOutputStream();
			os = new BufferedOutputStream(out);
			os.write(infiByte);
			os.flush();
		} catch (Exception e) {
			logger.error("downloadCsvFile文件生成异常：", e);
		} finally {
			// 关闭输出流
			try {
				if (os != null) {
					os.close();
				}
				if(out!=null){
					out.close();
				}

			} catch (IOException e) {
				logger.error("downloadCsvFile OutputStream关闭异常", e);
			}
		}
	}

	/**
	 * 借款明细查询detail 所需数据来
	 *
	 * @return
	 */
	@RequestMapping(value = "/detail")
	public ModelAndView borrowMoneyDetail(String merchantNo, String id, HttpServletRequest request, ModelMap model) {
		logger.info("BorrowMoneyAction-->borrowMoneyDetail-->start merchantNo=" + merchantNo);
		DoBorrowMoneyPO borrowMonery = null;
		try {
			borrowMonery = this.merchantDebitOrderService.borrowMoneyDetail(merchantNo, id);
			logger.info("BorrowMoneyAction-->borrowMoneyDetail-->borrowMonery=" + borrowMonery);
			model.put("data", borrowMonery);
		} catch (Exception e) {
			logger.error("BorrowMoneyAction-->/detail借款详情查询异常：" + e.getMessage());
			model.put("data", borrowMonery);

		}

		return new ModelAndView("/debit/borrow/borrowDetail");
	}

}
