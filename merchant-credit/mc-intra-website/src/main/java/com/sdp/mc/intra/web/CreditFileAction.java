package com.sdp.mc.intra.web;

import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.Writer;
import java.net.URLEncoder;
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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.support.DefaultMultipartHttpServletRequest;

import com.alibaba.fastjson.JSON;
import com.shengpay.debit.common.service.MerchantCreditLinesApplyService;
import com.shengpay.debit.dal.dataobject.DoMeCreditLinesApplyInfoPO;
import com.shengpay.debit.dal.dataobject.DoMerchantCreditLinesApplyPO;
import com.shengpay.model.fileManager.DeleteFileResponse;
import com.shengpay.model.fileManager.DownloadFileResponse;
import com.shengpay.model.fileManager.UploadFileResponse;
import com.shengpay.service.fileManager.FileManagerService;

@Controller
public class CreditFileAction {

	private static Logger log = LoggerFactory.getLogger(CreditFileAction.class);

	/**
	 * 文件管理服务s
	 */
	@Autowired
	private FileManagerService fileManagerService;

	/**
	 * 商户信用额度申请
	 */
	@Autowired
	protected MerchantCreditLinesApplyService merchantCreditLinesApplyService;

	/**
	 * 文件上传
	 *
	 * @param request
	 * @param response
	 * @param model
	 * @throws IOException
	 */
	@RequestMapping(value = { "/common/file/uploadCreditFile" })
	public void init(DefaultMultipartHttpServletRequest request,
			HttpServletResponse response, ModelMap model) throws IOException {
		log.info("CreditFileAction-->upload-->init  request=" + request);
		UploadFileResponse uploadFileResponse = fileManagerService.uploadFile(
				request, "uploadfield");
		log.info("CreditFileAction-->upload-->init  uploadFileResponse="
				+ uploadFileResponse);
		String agent = request.getHeader("User-Agent").toLowerCase();
		String agentType = getBrowserName(agent);
		writeJson(response, uploadFileResponse, agentType);
	}

	/**
	 * 向response里面写入返回的json
	 *
	 * @param response
	 * @param obj
	 */
	public static void writeJson(final HttpServletResponse response,
			final Object obj, String... agentType) {
		try {
			response.setCharacterEncoding("UTF-8");
			if (agentType.length > 0) {
				if (agentType[0].equals("ie10")) {
					response.setContentType("application/htm");
				} else if (!agentType[0].equals("ie10")
						&& agentType[0].indexOf("ie") >= 0) {
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
			log.error("CreditFileAction.writeJson.error" + e.getMessage(), e);
		}
	}

	/**
	 * 判断浏览器版本
	 *
	 * @param agent
	 * @return
	 */
	public static String getBrowserName(String agent) {
		if (agent.indexOf("msie 7") > 0) {
			return "ie7";
		} else if (agent.indexOf("msie 8") > 0) {
			return "ie8";
		} else if (agent.indexOf("msie 9") > 0) {
			return "ie9";
		} else if (agent.indexOf("msie 10") > 0) {
			return "ie10";
		} else if (agent.indexOf("msie") > 0) {
			return "ie";
		} else if (agent.indexOf("opera") > 0) {
			return "opera";
		} else if (agent.indexOf("firefox") > 0) {
			return "firefox";
		} else if (agent.indexOf("webkit") > 0) {
			return "webkit";
		} else if (agent.indexOf("gecko") > 0 && agent.indexOf("rv:11") > 0) {
			return "ie11";
		} else {
			return "Others";
		}
	}

	@RequestMapping("/file/download.htm")
	public void download(HttpServletRequest request,
			HttpServletResponse response, ModelMap modelMap) throws Exception {
		String key = request.getParameter("key");
		if(StringUtils.isEmpty(key)){
			key=request.getParameter("storeKey");
		}
		String fileName = request.getParameter("fileName");
		if(StringUtils.isEmpty(fileName)){
			fileName=request.getParameter("oriFileName");
		}

		String contentType = request.getParameter("contentType");
		OutputStream os = null;
		try {
			response.reset();
			response.setHeader("Expires", "0");
			response.setHeader("Pragma", "public");
			response.setHeader("Cache-Control",
					"must-revalidate, post-check=0, pre-check=0");
			response.setHeader("Cache-Control", "public");
			response.setCharacterEncoding("UTF8");

			response.setContentType(contentType);
			if (StringUtils.isNotEmpty(contentType)
					&& contentType.indexOf("image") >= 0) {
				response.addHeader("Content-Disposition", contentType
						+ "; filename=" + new String( fileName.getBytes("gbk"), "ISO8859-1" ));
			} else {
				response.addHeader("Content-Disposition", "attachment"
						+ "; filename=" + new String( fileName.getBytes("gbk"), "ISO8859-1" ));
			}
			response.setBufferSize(1024);

			DownloadFileResponse downloadFileResponse = fileManagerService
					.downLoadFile(key);
			byte[] fileByte = downloadFileResponse.getDownloadByte();
			os = new BufferedOutputStream(response.getOutputStream());
			os.write(fileByte);
		} catch (Exception e) {
			log.error("CreditFileAction.download.error", e);
		} finally {
			if(os!=null){
			os.flush();
			os.close();
			}
			os = null;
		}
	}

	@RequestMapping("/file/delete.htm")
	public void delete(HttpServletRequest request,
			HttpServletResponse response, ModelMap modelMap) {
		String key = request.getParameter("key");
		if(StringUtils.isEmpty(key)){
			key=request.getParameter("storeKey");
		}
		String kind = request.getParameter("kind");
		String code = request.getParameter("code");
		DeleteFileResponse deleteFileResponse = fileManagerService
				.delteFile(key);
		String agent = request.getHeader("User-Agent").toLowerCase();
		String agentType = getBrowserName(agent);
		/**
		 * 删除本地的附件记录
		 */
//		deleteFileLog(request, kind, code);
		writeJson(response, deleteFileResponse, agentType);
	}

	/**
	 * 删除附件时同时删除本地记录 通过申请额度时生成的ID 商户号 inputKind inputCode
	 *
	 * @param request
	 */
	private void deleteFileLog(HttpServletRequest request, String kind,
			String code) {
		Long id = Long.valueOf(request.getParameter("id"));
		List<DoMeCreditLinesApplyInfoPO> list = null;
		// 查询最近一次申购
		DoMerchantCreditLinesApplyPO applyPO = merchantCreditLinesApplyService
				.selectById(id);
		// 查询出需要更新数据记录的ID
		if (null != applyPO) {
			Map<String, Object> mps = new HashMap<String, Object>();
			mps.put("lineApplyOrderId", String.valueOf(applyPO.getId()));
			if (null != kind && !"".equals(kind) && null != code
					&& !"".equals(code)) {
				mps.put("inputKind", kind.replaceAll("_", " "));
				mps.put("inputCode", code);
			}

			list = merchantCreditLinesApplyService.getCreditLinesApplyInfo(mps);
			if (null != list && list.size() != 0) {
				// 更新ID记录
				merchantCreditLinesApplyService
						.updateCreditLinesApplyInfoByID(list.get(0).getId());
			}
		}
	}

}
