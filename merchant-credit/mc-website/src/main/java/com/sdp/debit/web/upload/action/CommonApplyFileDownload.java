package com.sdp.debit.web.upload.action;

import java.io.BufferedOutputStream;
import java.io.OutputStream;
import java.net.URLEncoder;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import com.shengpay.model.fileManager.DownloadFileResponse;
import com.shengpay.service.fileManager.FileManagerService;

@Controller
@RequestMapping(value = { "/common" })
public class CommonApplyFileDownload {

	private static Logger log = LoggerFactory.getLogger(CommonApplyFileDownload.class);

	/**
	 * 文件管理服务s
	 */
	@Autowired
	private FileManagerService fileManagerService;

	@RequestMapping("/manager/download")
	public void download(HttpServletRequest request, HttpServletResponse response, ModelMap modelMap) throws Exception {
		String key = request.getParameter("key");
		String fileName = request.getParameter("fileName");
		String contentType = request.getParameter("contentType");
		OutputStream os = null;
		try {
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

			DownloadFileResponse downloadFileResponse = fileManagerService.downLoadFile(key);
			byte[] fileByte = downloadFileResponse.getDownloadByte();
			os = new BufferedOutputStream(response.getOutputStream());
			os.write(fileByte);
		} catch (Exception e) {
			log.error("CommonApplyFileDownload.download.error", e);
		} finally {
			if (os != null) {
				os.flush();
				os.close();
				os = null;
			}
		}
	}

}
