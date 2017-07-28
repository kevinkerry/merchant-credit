package com.sdp.mc.intra.web.settle;

import java.io.BufferedOutputStream;
import java.io.OutputStream;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import com.sdp.mc.settle.api.dto.DownloadsTaskDTO;
import com.sdp.mc.settle.api.dto.DownloadsTaskDplDTO;
import com.sdp.mc.settle.api.dto.inner.DownloadsTask;
import com.shengpay.model.fileManager.DownloadFileResponse;
import com.shengpay.service.fileManager.FileManagerService;
import com.snda.service.annotations.Param;

@Controller
@RequestMapping("/settle/downloads")
public class DownloadsInfoAction extends BaseAction {

	private static final String UTF8 = "UTF-8";
	private static final String CONTENT_TYPE = "application/octet-stream";

	private static final Logger logger = LoggerFactory.getLogger(DownloadsInfoAction.class);

	@Autowired
	private FileManagerService fileManagerService;

	@RequestMapping(value = "/index", method = RequestMethod.GET)
	public String index(HttpServletRequest request, HttpServletResponse response, ModelMap model) {
		DownloadsTaskDplDTO dplDTO = null;
		// 初始页面不触发查询
		// if (isAdminRole())
		// dplDTO =
		// settleBaseService.getDownloadsTaskAPI().fetchAllDownloadsTask(taskDTO);
		// else {
		// taskDTO.setOperatorId(getOperatorId());
		// taskDTO.setOperatorName(getOperatorName());
		// dplDTO =
		// settleBaseService.getDownloadsTaskAPI().fetchDownloadsTask(taskDTO);
		// }
		model.put("page", dplDTO);
		return "/settle/downloads/page";
	}

	/**
	 * 分页查询
	 * 
	 * @param query
	 * @param request
	 * @param response
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/ajaxPage/list.do")
	public String queryPage(@Param(name = "pageNum") String pageNum, @RequestParam(required = false) String pageSize, HttpServletRequest request,
			HttpServletResponse response, ModelMap model) {
		DownloadsTaskDTO taskDTO = new DownloadsTaskDTO();
		DownloadsTaskDplDTO dplDTO = null;

		taskDTO.setPageNum(Integer.parseInt(pageNum));
		if (StringUtils.isNotBlank(pageSize)) taskDTO.setPageSize(Integer.parseInt(pageSize));

		if (isAdminRole())
			dplDTO = settleBaseService.getDownloadsTaskAPI().fetchAllDownloadsTask(taskDTO);
		else {
			taskDTO.setOperatorId(getOperatorId());
			taskDTO.setOperatorName(getOperatorName());
			dplDTO = settleBaseService.getDownloadsTaskAPI().fetchDownloadsTask(taskDTO);
		}

		List<DownloadsTask> downloadsTasks = dplDTO.getDownloadsTaskDatas();
		for (DownloadsTask downloadsTask : downloadsTasks) {
			String descInfo = downloadsTask.getDescInfo();
			try {
				// descInfo = URLDecoder.decode(descInfo, UTF8);
				if (StringUtils.isNotBlank(descInfo)) {
					descInfo = URLEncoder.encode(descInfo, UTF8);
				}
			} catch (Exception e) {
				logger.error("queryPage,{}", e.getMessage(), e);
			}
			downloadsTask.setDescInfo(descInfo);
		}
		model.put("page", dplDTO);
		return "/settle/downloads/list";
	}

	@RequestMapping("/view.do")
	public void downloadView(HttpServletRequest request, HttpServletResponse response, ModelMap modelMap) throws Exception {
		String key = request.getParameter("key");
		String fileName = request.getParameter("fileName");
		String contentType = request.getParameter("contentType");
		contentType = StringUtils.isNotBlank(contentType) ? contentType : CONTENT_TYPE;

		fileName = URLDecoder.decode(fileName, UTF8);
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
			// response.getOutputStream().write(fileByte);
			os = new BufferedOutputStream(response.getOutputStream());
			os.write(fileByte);
		} catch (Exception e) {
			logger.error("downloadView,{}", e.getMessage(), e);
		} finally {
			if (os != null) {
				os.flush();
				os.close();
				os = null;
			}
		}

	}
}
