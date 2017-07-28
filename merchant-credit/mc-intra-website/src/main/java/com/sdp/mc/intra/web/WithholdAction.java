package com.sdp.mc.intra.web;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.commons.io.FileUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.TransactionCallbackWithoutResult;
import org.springframework.transaction.support.TransactionTemplate;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.support.DefaultMultipartHttpServletRequest;

import com.sdp.emall.intra.admin.security.util.SecurityUserHolder;
import com.sdp.mc.common.enums.WithholdCurrencyEnums;
import com.sdp.mc.common.enums.WithholdTypeEnums;
import com.sdp.mc.common.util.FileUtil;
import com.sdp.mc.common.vo.ErrorMessageVO;
import com.shengpay.autorepayment.service.WithholdFileService;
import com.shengpay.autorepayment.service.WithholdMoneyService;
import com.shengpay.debit.common.enums.AutoPaymentFileTypeEnum;
import com.shengpay.debit.common.enums.ConfigEnums;
import com.shengpay.debit.common.enums.WithholdBatchOpStatusEnum;
import com.shengpay.debit.common.enums.WithholdOrderOpStatusEnum;
import com.shengpay.debit.common.service.DebitConfigService;
import com.shengpay.debit.dal.dataobject.TbWithholdingBrechInfoExample;
import com.shengpay.debit.dal.dataobject.TbWithholdingBrechInfoPO;
import com.shengpay.debit.dal.dataobject.TbWithholdingFileInfoExample;
import com.shengpay.debit.dal.dataobject.TbWithholdingFileInfoPO;
import com.shengpay.debit.dal.dataobject.TbWithholdingOrderInfoExample;
import com.shengpay.debit.dal.dataobject.TbWithholdingOrderInfoExample.Criteria;
import com.shengpay.debit.dal.dataobject.TbWithholdingOrderInfoPO;
import com.shengpay.debit.dal.ext.dataobject.ExtTbWithholdingInfoExample;
import com.shengpay.debit.dal.ext.dataobject.TbWithholdingInfoDTO;
import com.shengpay.model.fileManager.DownloadFileResponse;
import com.shengpay.model.fileManager.UploadFileResponse;
import com.shengpay.service.fileManager.FileManagerService;

@Controller
@RequestMapping("/withhold")
public class WithholdAction {
	private static Logger log = LoggerFactory.getLogger(WithholdAction.class);
	/**
	 * 文件管理服务s
	 */
	@Autowired
	private FileManagerService fileManagerService;
	@Autowired
	private WithholdFileService fileService;
	@Autowired
	private WithholdMoneyService withholdMoneyService;

	@Resource(name = "mc_transactionTemplate")
	private TransactionTemplate transactionTemplate;
	@Autowired
	private DebitConfigService debitConfigService;

	@RequestMapping(value = "/index")
	public String index(HttpServletRequest request, HttpServletResponse response, ModelMap model) {
		String bankDesc = this.debitConfigService.getByKey(ConfigEnums.WITHHOLD_BANK_CODE);
		model.put("statusEnums", WithholdBatchOpStatusEnum.values());
		model.put("bankType", bankDesc);
		String[] bankTypes = bankDesc.split(",");
		Map<String, String> bankMap = new HashMap<String, String>();
		for (String bankType : bankTypes) {
			String[] bankes = bankType.split("-");
			bankMap.put(bankes[0], bankes[1]);
		}
		model.put("bankMap", bankMap);
		// ICBC-工商银行,BOC-中国银行,CCB-建设银行,CMB-招商银行,CEB-光大银行,CMBC-民生银行,SZPAB-平安银行,PSBC-中国邮储银行
		return "/withhold/index";
	}

	@RequestMapping(value = " /wallet/index")
	public String walletIndex(HttpServletRequest request, HttpServletResponse response, ModelMap model) {
		StringBuffer currencyMsg = new StringBuffer();
		for (WithholdCurrencyEnums currency : WithholdCurrencyEnums.values()) {
			currencyMsg.append(currency.desc + "-" + currency.code);
		}
		model.put("currencys", currencyMsg);
		model.put("statusEnums", WithholdBatchOpStatusEnum.values());
		return "/walletWithhold/index";
	}

	/**
	 *
	 * 批次查询ajaxPaging/brechList
	 *
	 * @param queryParam
	 * @param response
	 * @param model
	 * @return String
	 */
	@SuppressWarnings("finally")
	@RequestMapping(value = "/ajaxPaging/batchList")
	public String batchList(ExtTbWithholdingInfoExample queryParam, HttpServletRequest request, ModelMap model) {
		log.info("batchList:{}", ToStringBuilder.reflectionToString(queryParam));
		String bizType = request.getParameter("bizType");
		List<TbWithholdingBrechInfoPO> dataList = null;
		try {
			if (bizType.equals(WithholdTypeEnums.BANK_CARD_WITHDRAW.code)) {
				queryParam.setBizType(WithholdTypeEnums.BANK_CARD_WITHDRAW.code);
			} else {
				queryParam.setBizType(WithholdTypeEnums.WALLET_WITHDRAW.code);
			}
			dataList = withholdMoneyService.pageQueryBrechInfoList(queryParam);
			if (dataList != null && dataList.size() > 0) {
				// 根据批次号统计失败成功记录数
				for (TbWithholdingBrechInfoPO po : dataList) {
					po.setFailCount(withholdMoneyService.findFailOrderByBatchNo(po.getBatchNo()));
					po.setSucessCount(withholdMoneyService.findSuccessOrderByBatchNo(po.getBatchNo()));
				}
			}
			model.put("dataList", dataList);
		} catch (Exception e) {
			log.error("brechList.error", e);
			dataList = new ArrayList<TbWithholdingBrechInfoPO>();
			model.put("dataList", dataList);
		} finally {
			model.put("query", queryParam);
			if (queryParam.getBizType().equals(WithholdTypeEnums.BANK_CARD_WITHDRAW.code)) {
				return "/withhold/withholdBatchList";
			} else {
				return "/walletWithhold/withholdBatchList";
			}
		}

	}

	/**
	 *
	 * 批次查询ajaxPaging/orderList
	 *
	 * @param queryParam
	 * @param response
	 * @param model
	 * @return String
	 */
	@RequestMapping(value = "/ajaxPaging/orderList")
	public String orderList(TbWithholdingOrderInfoExample queryParam, HttpServletRequest request, ModelMap model) {
		log.info("orderList.start.queryParam" + ToStringBuilder.reflectionToString(queryParam.toString()));
		List<TbWithholdingOrderInfoPO> dataList = null;
		String bizType = request.getParameter("bizType");
		try {
			Criteria criteria = queryParam.createCriteria();
			criteria.andStatusNotEqualTo(WithholdOrderOpStatusEnum.ORDER_ABOLISH.code);
			criteria.andBatchNoEqualTo(request.getParameter("batchNo"));
			queryParam.setOrderByClause("create_time desc ");
			dataList = withholdMoneyService.selectOrderByExample(queryParam);
			// fileService.run();
			// for (TbWithholdingOrderInfoPO po : dataList) {
			// fileService.walletWithholdApply(po);
			// }
			model.put("dataList", dataList);
		} catch (Exception e) {
			// 用log替换
			log.error("orderList.error", e);
			dataList = new ArrayList<TbWithholdingOrderInfoPO>();
			model.put("dataList", dataList);
		}

		model.put("query", queryParam);
		if (bizType.equals(WithholdTypeEnums.BANK_CARD_WITHDRAW.code)) {
			return "/withhold/withholdOrderList";
		} else {
			return "/walletWithhold/withholdOrderList";
		}

	}

	/**
	 * 文件上传
	 *
	 * @param request
	 * @param response
	 * @param model
	 * @throws IOException
	 */
	@SuppressWarnings({ "rawtypes" })
	@RequestMapping(value = "/upload")
	public String init(@RequestParam(value = "file", required = false) MultipartFile mfile, DefaultMultipartHttpServletRequest request,
			HttpServletResponse response, ModelMap model) throws IOException {
		String bizTypeCode = request.getParameter("bizType");
		if (WithholdTypeEnums.WALLET_WITHDRAW.code.equals(bizTypeCode))
			walletIndex(request, response, model);
		else index(request, response, model);
		model.put("statusEnums", WithholdBatchOpStatusEnum.values());
		model.put("bankType", this.debitConfigService.getByKey(ConfigEnums.WITHHOLD_BANK_CODE));

		String pagePath = "/withhold/index";
		if (WithholdTypeEnums.WALLET_WITHDRAW.code.equals(bizTypeCode)) pagePath = "/walletWithhold/index";
		log.info("upload return pagePath:{}", pagePath);
		TbWithholdingFileInfoPO insertFilePO = new TbWithholdingFileInfoPO();
		ErrorMessageVO error = null;
		try {
			error = checkUpdateFile(mfile);
			if (!error.isSuccess()) {
				model.put("msg", error.getErrorMessage());
				return pagePath;
			}
			// 解析文件
			log.info("upload.readerFileData.start.fileName:{}", mfile.getOriginalFilename());
			File tmpFile = File.createTempFile(mfile.getOriginalFilename(), ".tmp");
			FileUtils.copyInputStreamToFile(mfile.getInputStream(), tmpFile);
			// 解析
			List<String[]> list = fileService.readerFileData(tmpFile);
			log.info("upload.readerFileData.end.fileName{}", new Object[] { mfile.getOriginalFilename() });
			// 验证文件
			TbWithholdingInfoDTO dataDTO = null;
			if (WithholdTypeEnums.BANK_CARD_WITHDRAW.code.equals(bizTypeCode)) {
				dataDTO = fileService.checkFile(list, AutoPaymentFileTypeEnum.REQUESTFILE.code);
			} else {
				dataDTO = fileService.checkWalletFile(list);
			}

			if (!dataDTO.getErrorMessageVO().isSuccess()) {
				log.info(
						"upload.checkFile.not sucess.fileName{},error:{}",
						new Object[] { mfile.getOriginalFilename(),
								ToStringBuilder.reflectionToString(dataDTO.getErrorMessageVO(), ToStringStyle.SHORT_PREFIX_STYLE) });
				model.put("msg", dataDTO.getErrorMessageVO().getErrorMessage());
				return pagePath;
			}
			error = checkWithHoldInfoIsExists(dataDTO.getBatchNo(), WithholdTypeEnums.BANK_CARD_WITHDRAW.code);
			if (!error.isSuccess()) {
				model.put("msg", error.getErrorMessage());
				return pagePath;
			}
			insertFilePO = addWithHoldInfo(bizTypeCode, mfile, dataDTO);
			uploadAndUpdateFileInfo(mfile, insertFilePO);
			model.put("msg", error.getErrorMessage());
		} catch (Exception e) {
			log.error("upload file is error:{},{}", new Object[] { e.getMessage(), e });
		}
		return pagePath;

	}

	/**
	 * 上传文件到小文件 更新文件表key
	 *
	 * @param mfile
	 */
	@SuppressWarnings("rawtypes")
	private ErrorMessageVO uploadAndUpdateFileInfo(MultipartFile mfile, TbWithholdingFileInfoPO insertFilePO) {
		File file = FileUtil.MultipartFileTOFile(mfile);
		UploadFileResponse uploadFileResponse = fileService.uploadFileTOStore(file);
		log.info("uploadAndUpdateFileInfo.uploadFileResponse:{}",
				ToStringBuilder.reflectionToString(uploadFileResponse, ToStringStyle.SHORT_PREFIX_STYLE));
		if (uploadFileResponse == null) { return new ErrorMessageVO(false, "1", "上传小文件失败,返回空信息"); }
		if (!uploadFileResponse.isUploadSuccess()) { return new ErrorMessageVO(false, "1", "上传小文件失败"); }
		// 更新key到file表
		if (insertFilePO != null) {
			insertFilePO.setFileKey(uploadFileResponse.getStoreKey());
		} else {
			log.info("upload.insertFilePO is null uploadFileResponse end");
		}
		withholdMoneyService.updateFileByExample(insertFilePO);
		return new ErrorMessageVO(true);
	}

	@SuppressWarnings("rawtypes")
	private ErrorMessageVO checkWithHoldInfoIsExists(String batchNo, String bizType) {
		try {
			// 查询批次
			TbWithholdingBrechInfoExample queryParam = new TbWithholdingBrechInfoExample();
			queryParam.createCriteria().andBatchNoEqualTo(batchNo);
			List<TbWithholdingBrechInfoPO> ListBrechPo = withholdMoneyService.selectBrechByExample(queryParam);
			// 查询订单
			TbWithholdingOrderInfoExample orderParam = new TbWithholdingOrderInfoExample();
			orderParam.createCriteria().andBatchNoEqualTo(batchNo);
			List<TbWithholdingOrderInfoPO> orderlist = withholdMoneyService.selectOrderByExample(orderParam);
			// 查询文件信息
			TbWithholdingFileInfoPO filepo = withholdMoneyService.selectFileByExample(batchNo);

			if (filepo != null && ListBrechPo.size() != 0 && orderlist.size() != 0) {
				return new ErrorMessageVO(false, "1", "已存在相同的批次信息，批次信息不能重复");
			} else {
				return new ErrorMessageVO(true);
			}
		} catch (Exception e) {
			log.error("checkInfoIsExists is error batchNo:{},bizType:{},e:{}", new Object[] { batchNo, bizType, e.getMessage(), e });
			return new ErrorMessageVO(false, "1", "验证订单是否重复异常");
		}
	}

	@SuppressWarnings("rawtypes")
	private ErrorMessageVO checkUpdateFile(MultipartFile mfile) {
		if (mfile == null) { return new ErrorMessageVO(false, "1", "上传文件不能为空!"); }
		String type = mfile.getOriginalFilename().substring(mfile.getOriginalFilename().lastIndexOf(".") + 1);
		if (StringUtils.isBlank(type)) { return new ErrorMessageVO(false, "1", "请选择文件!"); }
		if (!"csv".equals(type.toLowerCase())) { return new ErrorMessageVO(false, "1", "您上传文件格式不正确!"); }
		return new ErrorMessageVO(true);
	}

	/**
	 * 落地代扣信息 文件信息 批次信息 订单信息
	 *
	 * @param bizType
	 * @param mfile
	 * @param dataDTO
	 * @param insertFilePO
	 */
	private TbWithholdingFileInfoPO addWithHoldInfo(String bizType, MultipartFile mfile, TbWithholdingInfoDTO dataDTO) {
		try {
			// 插入如数据
			TbWithholdingFileInfoPO filePO = new TbWithholdingFileInfoPO();
			filePO.setFileName(mfile.getOriginalFilename());
			filePO.setFileType("0");
			filePO.setCreateTime(new Date());
			filePO.setUpdateTime(new Date());
			filePO.setBatchNo(dataDTO.getBatchNo());
			// 新增文件信息
			log.info("upload.addFileInfo.start.fileName=" + mfile.getOriginalFilename());
			// insertFilePO = filePO;
			withholdMoneyService.addFileInfo(filePO);
			log.info("upload.addFileInfo.end.fileName=" + mfile.getOriginalFilename());
			// 落地批次数据
			log.info("upload.addBrechInfo.start.fileName=" + mfile.getOriginalFilename());
			dataDTO.setOpernerid(SecurityUserHolder.getAuthUser().getUser().getUserName());
			dataDTO.setOpernername(SecurityUserHolder.getAuthUser().getUser().getRealName());
			dataDTO.setBiztype(bizType);
			withholdMoneyService.addBrechInfo(dataDTO);
			log.info("upload.addBrechInfo.end.fileName=" + mfile.getOriginalFilename());
			// 落地订单数据
			List<TbWithholdingOrderInfoPO> orderList = dataDTO.getTbWithholdingOrderInfoList();
			log.info("upload.addOrderInfo.start" + mfile.getOriginalFilename());
			withholdMoneyService.addOrderInfo(orderList);
			log.info("upload.addOrderInfo.end" + mfile.getOriginalFilename());
			return filePO;
		} catch (Exception e) {
			log.error("addWithHoldInfo file is error:{},{}", new Object[] { e.getMessage(), e });
			return null;
		}

	}

	@RequestMapping("/delete")
	@ResponseBody
	public String delete(HttpServletRequest request, HttpServletResponse response, ModelMap modelMap) {
		boolean isMultipart = ServletFileUpload.isMultipartContent(request);
		if (isMultipart) {
			response.setCharacterEncoding("utf-8");
			response.setContentType("application/x-download");
			response.setHeader("Accept-Ranges", "bytes");
		}
		String brechNo = request.getParameter("batchNo");
		/**
		 * 根据批次号拿到文件名称，上传小文件生成的key
		 */
		TbWithholdingFileInfoExample example = new TbWithholdingFileInfoExample();
		example.createCriteria().andBatchNoEqualTo(brechNo);
		TbWithholdingFileInfoPO filePO;
		try {
			filePO = withholdMoneyService.selectFileByExample(example);
			if (filePO != null) {
				fileManagerService.delteFile(filePO.getFileKey());
				/**
				 * 删除本地的附件记录
				 */
				withholdMoneyService.deleteFileInfo(brechNo, filePO.getFileKey());
			}
			withholdMoneyService.deleteBrechInfo(brechNo);
			withholdMoneyService.deleteOrderInfo(brechNo);
			return "0";

		} catch (Exception e) {
			log.error("delete Exception", e);
			return "9";
		}

	}

	@RequestMapping("/download")
	public void download(HttpServletRequest request, HttpServletResponse response, ModelMap modelMap) throws Exception {
		String batchNo = request.getParameter("batchNo");
		/**
		 * 根据批次号拿到文件名称，上传小文件生成的key
		 */
		TbWithholdingFileInfoPO filepo = withholdMoneyService.selectFileByExample(batchNo);
		String fileName = filepo.getFileName();
		OutputStream os = null;
		try {
			String contentType = request.getContentType();
			response.reset();
			response.setHeader("Expires", "0");
			response.setHeader("Pragma", "public");
			response.setHeader("Cache-Control", "must-revalidate, post-check=0, pre-check=0");
			response.setHeader("Cache-Control", "public");

			response.setContentType(contentType);
			if (StringUtils.isNotEmpty(contentType) && contentType.indexOf("image") >= 0) {
				response.addHeader("Content-Disposition", contentType + "; filename=" + URLEncoder.encode(fileName, "UTF8"));
			} else {
				response.addHeader("Content-Disposition", "attachment" + "; filename=" + URLEncoder.encode(fileName, "UTF8"));
			}
			response.setBufferSize(1024);

			DownloadFileResponse downloadFileResponse = fileManagerService.downLoadFile(filepo.getFileKey());
			byte[] fileByte = downloadFileResponse.getDownloadByte();
			os = new BufferedOutputStream(response.getOutputStream());
			os.write(fileByte);
		} catch (Exception e) {
			log.error("download.error", e);
		} finally {
			if (os != null) {
				os.flush();
				os.close();
				os = null;
			}
		}
	}

	@SuppressWarnings("rawtypes")
	@RequestMapping("/doWithhold")
	@ResponseBody
	public ErrorMessageVO doWithhold(HttpServletRequest request, ModelMap model) {
		ErrorMessageVO error = new ErrorMessageVO(true);
		String batchNo = request.getParameter("batchNo");
		String isReset = request.getParameter("isReset");
		String exStatus = WithholdBatchOpStatusEnum.BATCH_INIT.code;
		String status = WithholdBatchOpStatusEnum.BATCH_WITHHOLD.code;
		TbWithholdingInfoDTO dataDTO = new TbWithholdingInfoDTO();
		dataDTO.setOpernerid(SecurityUserHolder.getAuthUser().getUser().getUserName());
		dataDTO.setOpernername(SecurityUserHolder.getAuthUser().getUser().getRealName());
		try {
			dataDTO.setBatchNo(batchNo);
			// 更新成代扣中
			// 重试扣费操作
			if ("1".equals(isReset)) {
				resetWitholdOp(batchNo);
			} else {
				withholdMoneyService.updateBatchStatus(status, dataDTO, exStatus);
			}
			error.setErrorMessage("批次：" + batchNo + "操作完成，等待后续处理");
			model.put("error", error);
		} catch (Exception e) {
			log.error("doWithhold.error", e);
			error.setSuccess(false);
			error.setErrorMessage("扣款请求失败,请联系开发人员");
		}
		return error;

	}

	/**
	 * 重试扣费
	 *
	 * @param brechNo
	 */
	private void resetWitholdOp(final String batchNo) {
		transactionTemplate.execute(new TransactionCallbackWithoutResult() {
			@Override
			public void doInTransactionWithoutResult(TransactionStatus status) {
				// 0.查询所有扣费失败订单
				List<TbWithholdingOrderInfoPO> orderList = withholdMoneyService.findFailOrderListByBatchNo(batchNo);

				// 1.吧本批次的失败订单状态改为作废
				TbWithholdingOrderInfoPO orderDto = new TbWithholdingOrderInfoPO();
				orderDto.setBatchNo(batchNo);
				orderDto.setStatus(WithholdOrderOpStatusEnum.ORDER_FAILL.code);
				String upOrderStatus = WithholdOrderOpStatusEnum.ORDER_ABOLISH.code;
				withholdMoneyService.updateOrderOpStatus(orderDto, upOrderStatus);
				// 把调用接口失败的废弃重试
				orderDto.setStatus(WithholdOrderOpStatusEnum.ORDER_WAIT_FAILL.code);
				upOrderStatus = WithholdOrderOpStatusEnum.ORDER_ABOLISH.code;
				withholdMoneyService.updateOrderOpStatus(orderDto, upOrderStatus);

				// 2.吧批量状态改为待扣中
				TbWithholdingInfoDTO dataDTO = new TbWithholdingInfoDTO();
				dataDTO.setBatchNo(batchNo);
				String exStatus = WithholdBatchOpStatusEnum.BATCH_COMPLETE.code;
				String upDtatus = WithholdBatchOpStatusEnum.BATCH_WITHHOLD.code;

				dataDTO.setOpernerid(SecurityUserHolder.getAuthUser().getUser().getUserName());
				dataDTO.setOpernername(SecurityUserHolder.getAuthUser().getUser().getRealName());
				withholdMoneyService.updateBatchStatus(upDtatus, dataDTO, exStatus);
				for (TbWithholdingOrderInfoPO po : orderList) {
					po.setInitorderno(po.getMerchantOrderNo());
					po.setFailorderno(po.getMerchantOrderNo());
				}
				// 3.新增订单记录
				withholdMoneyService.addOrderInfo(orderList);
			}
		});
	}

	@RequestMapping(value = "/downloadTemplet")
	public void downloadTemplet(HttpServletRequest request, HttpServletResponse response, ModelMap model) throws IOException {
		String bizType = request.getParameter("bizType");
		File file = null;
		if (bizType.equals(WithholdTypeEnums.BANK_CARD_WITHDRAW.code)) {
			file = new File(request.getSession().getServletContext().getRealPath("/") + "/template/daikou_xxx_2016xxxxxxxx.csv"); // 根据文件路径获得File文件
			response.setContentType("application/msexcel;charset=utf-8");
			response.setHeader("Content-Disposition", "attachment;filename=" + URLEncoder.encode("daikou_xxx_2016xxxxxxxx.csv", "UTF-8"));
		} else {
			file = new File(request.getSession().getServletContext().getRealPath("/") + "/template/daikouWallet_xxx_2016xxxxxxxx.csv"); // 根据文件路径获得File文件
			response.setContentType("application/msexcel;charset=utf-8");
			response.setHeader("Content-Disposition", "attachment;filename=" + URLEncoder.encode("daikouWallet_xxx_2016xxxxxxxx.csv", "UTF-8"));
		}
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

}
