package com.sdp.mc.web.action.common;

import java.io.BufferedOutputStream;
import java.io.OutputStream;
import java.net.URLEncoder;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import org.springframework.web.servlet.mvc.multiaction.MultiActionController;

import com.shengpay.service.fileManager.impl.DFSUtils;


@Controller
@RequestMapping(value = { "/posPromoter", "/mposPromoter" })
public class DFSController extends MultiActionController {

	private static final String storeUrl = "http://storagewsproxy.sdptest.shengpay.com:8080/storage-ws/rest/table/storage";

	@RequestMapping("/dfs/init")
	public String initImport(ModelMap modelMap) {
		return "/main/withfunding/importtest";
	}

	@RequestMapping("/dfs/upload")
	public String upload(HttpServletRequest request, HttpServletResponse response, ModelMap modelMap) throws Exception {
		try {
			final MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest) request;
			final CommonsMultipartFile blankcardFile = (CommonsMultipartFile) multipartRequest.getFile("blankcardFile");
			String furl = DFSUtils.postForLocation(storeUrl, blankcardFile.getBytes());

			String fileName = blankcardFile.getOriginalFilename();
			modelMap.addAttribute("furl", furl);
			modelMap.addAttribute("fileName", fileName);
			download(request, response, modelMap);
			return "";
		} catch (Exception e) {
			logger.error("DFSController.upload.error", e);
		}
		return "";
	}

	@RequestMapping("/dfs/download")
	public void download(HttpServletRequest request, HttpServletResponse response, ModelMap modelMap) throws Exception {
		OutputStream os = null;
		String fileName = modelMap.get("fileName").toString();// request.getParameter("fileName");
		String furl = modelMap.get("furl").toString();// request.getParameter("furl");
		try {
			response.reset();
			response.setHeader("Expires", "0");
			response.setHeader("Pragma", "public");
			response.setHeader("Cache-Control", "must-revalidate, post-check=0, pre-check=0");
			response.setHeader("Cache-Control", "public");
			response.setContentType("application/octet-stream");
			response.addHeader("Content-Disposition", "attachment; filename=" + URLEncoder.encode(fileName, "UTF8"));
			response.setBufferSize(1024);

			byte[] fileByte = DFSUtils.getForObject(furl, furl);

			os = new BufferedOutputStream(response.getOutputStream());
			os.write(fileByte);
		} catch (Exception e) {
			logger.error("DFSController.download.error", e);
		} finally {
			if(os!=null){
				os.flush();
				os.close();
				os = null;
			}
		}
	}
}
