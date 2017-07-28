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
import java.util.List;

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

/**
 *
 * 钱包代扣
 *
 */
@Controller
@RequestMapping("/walleWithdraw")
public class WalletWithholdAction {
	private static Logger log = LoggerFactory.getLogger(WalletWithholdAction.class);
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
		model.put("currencys", WithholdCurrencyEnums.values());
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
	@RequestMapping(value = "/ajaxPaging/batchList")
	public String batchList(ExtTbWithholdingInfoExample queryParam, HttpServletRequest request, ModelMap model) {
		log.info("batchList:{}", ToStringBuilder.reflectionToString(queryParam));
		List<TbWithholdingBrechInfoPO> dataList = null;
		try {
			queryParam.setBizType(WithholdTypeEnums.WALLET_WITHDRAW.code);
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
			log.error("WithholdAction.brechList.error", e);
			dataList = new ArrayList<TbWithholdingBrechInfoPO>();
			model.put("dataList", dataList);
		}

		model.put("query", queryParam);
		return "/walletWithhold/withholdBatchList";
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
		try {
			Criteria criteria=queryParam.createCriteria();
			criteria.andStatusNotEqualTo(WithholdOrderOpStatusEnum.ORDER_ABOLISH.code);
			criteria.andBatchNoEqualTo(request.getParameter("batchNo"));
			queryParam.setOrderByClause("create_time desc ");
			dataList = withholdMoneyService.selectOrderByExample(queryParam);
			model.put("dataList", dataList);
		} catch (Exception e) {
			// 用log替换
			log.error("orderList.error", e);
			dataList = new ArrayList<TbWithholdingOrderInfoPO>();
			model.put("dataList", dataList);
		}

		model.put("query", queryParam);

		return "/walletWithhold/withholdOrderList";
	}

	/**
	 * 文件上传
	 *
	 * @param request
	 * @param response
	 * @param model
	 * @throws IOException
	 */
	@SuppressWarnings("rawtypes")
	@RequestMapping(value = "/upload")
	public String init(@RequestParam(value = "file", required = false) MultipartFile mfile, DefaultMultipartHttpServletRequest request,
			HttpServletResponse response, ModelMap model) throws IOException {
		index(request, response, model);
		model.put("statusEnums", WithholdBatchOpStatusEnum.values());
		model.put("bankType", this.debitConfigService.getByKey(ConfigEnums.WITHHOLD_BANK_CODE));
		TbWithholdingFileInfoPO insertFilePO = null;
		ErrorMessageVO error = new ErrorMessageVO(false);
		error.setErrorCode("1");
		try {
			if (mfile == null) {
				error.setErrorMessage("上传文件不能为空!");
				model.put("msg", error);
				return "/walletWithhold/index";
			}
			String type = mfile.getOriginalFilename().substring(mfile.getOriginalFilename().lastIndexOf(".") + 1);
			if (StringUtils.isBlank(type)) {
				error.setErrorMessage("请选择文件!");
				model.put("msg", error);
				return "/walletWithhold/index";
			}
			if (!"csv".equals(type.toLowerCase())) {
				error.setErrorMessage("您上传文件格式不正确!");
				model.put("msg", error);
				return "/walletWithhold/index";
			}
			// 解析文件
			log.info("upload.readerFileData.start.fileName=" + mfile.getOriginalFilename());
			File tmpFile = File.createTempFile(mfile.getOriginalFilename(), ".tmp");
			FileUtils.copyInputStreamToFile(mfile.getInputStream(), tmpFile);
			// 解析
			List<String[]> list = fileService.readerFileData(tmpFile);
			log.info("upload.readerFileData.end.fileName{}" ,new Object[]{ mfile.getOriginalFilename()});
			// 验证文件
			log.info("upload.checkFile.start");
			TbWithholdingInfoDTO dataDTO = fileService.checkWalletFile(list);
			log.info("upload.checkFile.end");
			if (!dataDTO.getErrorMessageVO().isSuccess()) {
				log.info("upload.checkFile.not sucess.fileName{},error:{}" ,new Object[]{mfile.getOriginalFilename(),ToStringBuilder.reflectionToString(dataDTO.getErrorMessageVO(),ToStringStyle.SHORT_PREFIX_STYLE)});
				model.put("msg", dataDTO.getErrorMessageVO());
				return "/walletWithhold/index";
			} else {
				// 检查是否重复
				TbWithholdingBrechInfoExample queryParam = new TbWithholdingBrechInfoExample();
				queryParam.createCriteria().andBatchNoEqualTo(dataDTO.getBatchNo());
				List<TbWithholdingBrechInfoPO> ListBrechPo = withholdMoneyService.selectBrechByExample(queryParam);

				TbWithholdingOrderInfoExample orderParam = new TbWithholdingOrderInfoExample();
				orderParam.createCriteria().andBatchNoEqualTo(dataDTO.getBatchNo());
				List<TbWithholdingOrderInfoPO> orderlist = withholdMoneyService.selectOrderByExample(orderParam);

				TbWithholdingFileInfoPO filepo = withholdMoneyService.selectFileByExample(dataDTO.getBatchNo());

				if (ListBrechPo.size() != 0) {
					error.setErrorMessage("已存在相同的批次信息，批次信息不能重复");
					model.put("msg", error);
					return "/walletWithhold/index";
				}
				if (orderlist.size() != 0) {
					error.setErrorMessage("已存在相同的批次信息，批次信息不能重复");
					model.put("msg", error);
					return "/walletWithhold/index";
				}
				if (filepo != null) {
					error.setErrorMessage("已存在相同的批次信息，批次信息不能重复");
					model.put("msg", error);
					return "/walletWithhold/index";
				}
				// 插入如数据
				TbWithholdingFileInfoPO filePO = new TbWithholdingFileInfoPO();
				filePO.setFileName(mfile.getOriginalFilename());
				filePO.setFileType("0");
				filePO.setCreateTime(new Date());
				filePO.setUpdateTime(new Date());
				filePO.setBatchNo(dataDTO.getBatchNo());
				// 新增文件信息
				log.info("upload.addFileInfo.start.fileName=" + mfile.getOriginalFilename());
				insertFilePO = filePO;
				withholdMoneyService.addFileInfo(filePO);
				log.info("upload.addFileInfo.end.fileName=" + mfile.getOriginalFilename());
				// 落地批次数据
				log.info("upload.addBrechInfo.start.fileName=" + mfile.getOriginalFilename());
				dataDTO.setOpernerid(SecurityUserHolder.getAuthUser().getUser().getUserName());
				dataDTO.setOpernername(SecurityUserHolder.getAuthUser().getUser().getRealName());
				dataDTO.setBiztype(WithholdTypeEnums.WALLET_WITHDRAW.code);
				withholdMoneyService.addBrechInfo(dataDTO);
				log.info("upload.addBrechInfo.end.fileName=" + mfile.getOriginalFilename());
				// 落地订单数据
				List<TbWithholdingOrderInfoPO> orderList = dataDTO.getTbWithholdingOrderInfoList();
				log.info("upload.addOrderInfo.start" + mfile.getOriginalFilename());
				withholdMoneyService.addOrderInfo(orderList);
				log.info("upload.addOrderInfo.end" + mfile.getOriginalFilename());
			}

		} catch (Exception e) {
			log.error("upload.uploadFileResponse.addFileInfo" + e.getMessage(), e);
		}
		log.info("upload.fileManagerService.uploadFile.request" + ToStringBuilder.reflectionToString(request));
		File file = FileUtil.MultipartFileTOFile(mfile);
		UploadFileResponse uploadFileResponse = fileService.uploadFileTOStore(file);
		log.info("upload.uploadFileResponse.end");
		if (uploadFileResponse != null && uploadFileResponse.isUploadSuccess()) {
			// 更新key到file表
			if (insertFilePO != null)
				insertFilePO.setFileKey(uploadFileResponse.getStoreKey());
			else log.info("upload.insertFilePO is null uploadFileResponse end");
			withholdMoneyService.updateFileByExample(insertFilePO);
		}
		model.put("msg", error);
		return "/walletWithhold/index";

	}

	@SuppressWarnings("rawtypes")
	@RequestMapping("/delete")
	@ResponseBody
	public ErrorMessageVO delete(HttpServletRequest request, HttpServletResponse response, ModelMap modelMap) {
		boolean isMultipart = ServletFileUpload.isMultipartContent(request);
		if (isMultipart) {
			response.setCharacterEncoding("utf-8");
			response.setContentType("application/x-download");
			response.setHeader("Accept-Ranges", "bytes");
		}
		ErrorMessageVO error = new ErrorMessageVO(true);
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
			error.setSuccess(true);
			error.setErrorMessage("删除成功,批次号:" + brechNo);

		} catch (Exception e) {
			log.error("delete Exception", e);
			error.setSuccess(false);
			error.setErrorMessage("删除失败,批次号:" + brechNo);
		}
		return error;

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
		File file = new File(request.getSession().getServletContext().getRealPath("/") + "/template/walletDaikou_xxx_2016xxxxxxxx.csv"); // 根据文件路径获得File文件
		response.setContentType("application/msexcel;charset=utf-8");
		response.setHeader("Content-Disposition", "attachment;filename=" + URLEncoder.encode("walletDaikou_xxx_2016xxxxxxxx.csv", "UTF-8"));
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
