package com.sdp.mc.intra.web;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.support.DefaultMultipartHttpServletRequest;

import com.sdo.common.util.DateUtil;
import com.sdp.emall.intra.admin.security.util.SecurityUserHolder;
import com.sdp.mc.common.util.ParseCsvFileUtil;
import com.sdp.mc.common.vo.ErrorMessageVO;
import com.sdp.mc.intra.web.util.ParseXlsFileUtil;
import com.sdp.mc.intra.worker.limitrule.MerchantLimitBatchChangeHandler;
import com.sdp.mc.newt0.dao.Newt0McLimitChangeDtlDO;
import com.sdp.mc.newt0.dao.Newt0McLimitChangeReqDO;
import com.sdp.mc.newt0.dao.Newt0McLimitChangeReqDOExample;
import com.sdp.mc.service.limitchange.MerchantLimitChangeService;
import com.shengpay.commons.core.utils.NumberUtils;

/**
 * 商户额度变更Action
 *
 * @author liyantao01
 *
 */
@Controller
@RequestMapping("/limitchange")
public class MerchantLimitChangeAction {
	private static Logger log = LoggerFactory.getLogger(MerchantLimitChangeAction.class);

	@Autowired
	private MerchantLimitChangeService merchantLimitChangeService;

	@Autowired
	private MerchantLimitBatchChangeHandler merchantLimitBatchChangeHandler;

	//额度规则列表
	@RequestMapping(value = "/index")
	public String index(HttpServletRequest request,
			HttpServletResponse response, ModelMap model) {

		log.info("MerchantLimitChangeAction.index.start.queryParam");

		return "/limitchange/index";
	}
	//额度规则列表
	@RequestMapping(value = "/list")
	public String list(@ModelAttribute("query") Newt0McLimitChangeReqDOExample query,HttpServletRequest request,
			HttpServletResponse response, ModelMap model) {

		List<Newt0McLimitChangeReqDO> dataList = null;
		String startTimeStr=request.getParameter("startTimeStr");
		if(StringUtils.isNotBlank(startTimeStr)){
			query.setStartTime(DateUtil.parseDateNewFormat(startTimeStr+" 00:00:00"));
		}
		String endTimeStr=request.getParameter("endTimeStr");
		if(StringUtils.isNotBlank(endTimeStr)){
			query.setEndTime(DateUtil.parseDateNewFormat(endTimeStr+" 23:59:59"));
		}
		try {
			//查询列表数据
			dataList = merchantLimitChangeService.queryMarchatLimitChange(query);
			model.put("dataList", dataList);
		} catch (Exception e) {
			log.error("MerchantLimitChangeAction.list.error", e);
			dataList = new ArrayList<Newt0McLimitChangeReqDO>();
			model.put("dataList", dataList);
		}
		model.put("query", query);
		return "/limitchange/changeList";
	}
	//额度规则列表
	@RequestMapping(value = "/changeDetail")
	public String changeDetail(HttpServletRequest request,
			HttpServletResponse response, ModelMap model) {

		List<Newt0McLimitChangeDtlDO> dataList = null;
		try {
			String reqId = request.getParameter("reqId");
			if(StringUtils.isNotBlank(reqId)){
				//查询列表数据
				dataList = merchantLimitChangeService.queryMarchatLimitChangeDetailByReqId(Long.parseLong(reqId));
				model.put("dataList", dataList);
			}else{
				dataList = new ArrayList<Newt0McLimitChangeDtlDO>();
				model.put("dataList", dataList);
			}
		} catch (Exception e) {
			log.error("MerchantLimitChangeAction.list.error", e);
			dataList = new ArrayList<Newt0McLimitChangeDtlDO>();
			model.put("dataList", dataList);
		}

		return "/limitchange/changeDetail";
	}


	/**
	 * 文件上传
	 *
	 * @param request
	 * @param response
	 * @param model
	 * @throws IOException
	 */
	@RequestMapping(value = "/upload")
	public String upload(
			@RequestParam(value = "file", required = false) MultipartFile mfile,
		DefaultMultipartHttpServletRequest request,
		HttpServletResponse response, ModelMap model) throws IOException {
	ErrorMessageVO<Object> error = new ErrorMessageVO<Object>(false);
	error.setErrorCode("1");
	try {
		if (mfile == null) {
			error.setErrorMessage("上传文件不能为空!");
			model.put("msg", error);
			return "/limitchange/uploadResult";
		}
		String type = mfile.getOriginalFilename().substring(
				mfile.getOriginalFilename().lastIndexOf(".") + 1);
		if (StringUtils.isBlank(type)) {
			error.setErrorMessage("请选择文件!");
			model.put("msg", error);
			return "/limitchange/uploadResult";
		}

		if (!("csv".equals(type.toLowerCase())||"xls".equals(type.toLowerCase()))) {
			error.setErrorMessage("您上传文件格式不正确!请上传csv或者xls文件");
			model.put("msg", error);
			return "/limitchange/uploadResult";
		}
		// 解析文件
		log.info("MerchantLimitChangeAction.upload.readerFileData.start.fileName="
				+ mfile.getOriginalFilename());
		File tmpFile = File.createTempFile(mfile.getOriginalFilename(),
				".tmp");
		FileUtils.copyInputStreamToFile(mfile.getInputStream(), tmpFile);

		String fileName=mfile.getOriginalFilename();

		List<String[]> marchatInfoList=null;

		if("csv".equals(type.toLowerCase())){
			marchatInfoList=ParseCsvFileUtil.readCsvFile(tmpFile, "GBK");
		}else if("xls".equals(type.toLowerCase())){
			marchatInfoList=ParseXlsFileUtil.readXlsFile(tmpFile, "GBK");
		}
		Long reqId=merchantLimitChangeService.createMarchatLimitChangeReq(fileName,marchatInfoList);
		com.sdp.emall.intra.admin.administrator.dao.dataobject.ActAdminUserDO user = SecurityUserHolder.getAuthUser().getUser();
		String operatorId = user.getUserName();
		this.merchantLimitBatchChangeHandler.execute(reqId,operatorId);
		// 解析
		log.info("MerchantLimitChangeAction.upload.readerFileData.end.fileName="+ mfile.getOriginalFilename());
	} catch (Exception e) {
		log.error("MerchantLimitChangeAction.upload.uploadFileResponse.addFileInfo", e);
		error.setErrorMessage("上传文件发生异常！");
	}
	model.put("msg", error);
	return "/limitchange/uploadResult";

	}

	/**
	 * 更新状态
	 *
	 * @param request
	 * @param response
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/change")
	@ResponseBody
	public ErrorMessageVO<Object> change(HttpServletRequest request,
			HttpServletResponse response, ModelMap model) {
		ErrorMessageVO<Object> error = new ErrorMessageVO<Object>(false);
		log.info("MerchantLimitChangeAction.change.start.");
		String reqId = request.getParameter("reqId");
		com.sdp.emall.intra.admin.administrator.dao.dataobject.ActAdminUserDO user = SecurityUserHolder.getAuthUser().getUser();
		String operatorId = user.getUserName();
		try {
			if (StringUtils.isNotBlank(reqId)&&NumberUtils.isLong(reqId)) {
				this.merchantLimitBatchChangeHandler.execute(Long.parseLong(reqId),operatorId);
				error.setSuccess(true);
				error.setErrorCode("0");
				error.setErrorMessage("开启修改任务成功");
			}else{
				error.setSuccess(true);
				error.setErrorCode("-1");
				error.setErrorMessage("开启修改任务失败,任务号格式不正确！");
			}
		} catch (Exception e) {
			error.setSuccess(true);
			error.setErrorCode("-1");
			error.setErrorMessage("开启修改任务失败");
			log.error("MerchantLimitChangeAction.change.error", e);
		}
		return error;
	}



	/**
	 * 下载试算的模板
	 * @param request
	 * @param response
	 * @param model
	 * @throws IOException
	 */
	@RequestMapping(value = "/download")
	public void download(HttpServletRequest request,
			HttpServletResponse response, ModelMap model) throws IOException {
		File file = new File(request.getSession().getServletContext()
				.getRealPath("/")
				+ "/template/merchantlimitchangeTemplate.xls"); // 根据文件路径获得File文件
		response.setContentType("application/msexcel;charset=utf-8");
		response.setHeader("Content-Disposition", "attachment;filename="
				+ URLEncoder.encode("merchantlimitchangeTemplate.xls", "UTF-8"));
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
