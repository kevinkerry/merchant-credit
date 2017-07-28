package com.shengpay.service.fileManager.impl;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import org.springframework.web.multipart.support.DefaultMultipartHttpServletRequest;

import com.alibaba.fastjson.JSONObject;
import com.shengpay.model.fileManager.DeleteFileResponse;
import com.shengpay.model.fileManager.DownloadFileResponse;
import com.shengpay.model.fileManager.UploadFileResponse;
import com.shengpay.service.fileManager.FileManagerService;

/**
 * 小文件的，文件上传。下载处理器
 *
 * @author heyi.alex
 *
 */
@Service
public class FileManagerServiceImpl implements FileManagerService {

	@Value("${file.store.url}")
	private String fileStoreUrl;

	@Value("${easypay.file.store.url}")
	private String easypayFileStoreUrl;

	@Value("${download.manager.url}")
	private String downloadMangerurl;

	@Value("${maxUploadSize}")
	private String maxUploadSize;
	private static Logger log = LoggerFactory.getLogger(FileManagerServiceImpl.class);

	/**
	 * 文件上传
	 *
	 * @param request
	 * @return
	 */
	public UploadFileResponse uploadFile(DefaultMultipartHttpServletRequest request, String fileFiled) {
		return uploadFile(request, fileStoreUrl, fileFiled);
	}

	public UploadFileResponse uploadFile(DefaultMultipartHttpServletRequest request, String fileStoreUrl, String fileFiled) {
		log.info("FileManagerServiceImpl-->easypayUploadFile--> fileFiled=" + fileFiled + ",fileFiled=" + fileFiled);
		UploadFileResponse response = new UploadFileResponse();
		// 下载区域
		if (StringUtils.isEmpty(fileFiled)) {
			fileFiled = "uploadField";
		}
		CommonsMultipartFile firstfile = (CommonsMultipartFile) request.getFile(fileFiled);
		if (firstfile == null) { return null; }
		Long fileSize = firstfile.getSize();
		log.info("FileManagerServiceImpl-->easypayUploadFile--> fileSize=" + fileSize);
		if (fileSize > Integer.parseInt(maxUploadSize.trim())) {
			response.setMsg("文件大小超过限制");
			response.setUploadSuccess(false);
			return response;
		}

		// 文件类型获取
		// FileItem fileItem = firstfile.getFileItem();
		response.setOriFileName(firstfile.getOriginalFilename()); // 用户上传文件名
		response.setContentType(firstfile.getContentType()); // 文件类型
		response.setFileSize(firstfile.getSize()); // 文件长度
		try {
			log.info("FileManagerServiceImpl-->easypayUploadFile--> DFSUtils.postForLocation-->fileStoreUrl=" + fileStoreUrl);
			String furl = DFSUtils.postForLocation(fileStoreUrl, firstfile.getBytes());
			log.info("FileManagerServiceImpl-->easypayUploadFile--> DFSUtils.postForLocation-->furl=" + furl);
			response.setStoreKey(furl);
			response.setUploadSuccess(true);
		} catch (RuntimeException e) {
			log.error("file store error:" + firstfile.getOriginalFilename(), e);
			response.setUploadSuccess(false);
		}
		return response;
	}

	/**
	 * 文件下载
	 * 
	 * @param key
	 * @return
	 */
	public DownloadFileResponse downLoadFile(String key) {
		return downLoadFile(key, fileStoreUrl);
	}

	public DownloadFileResponse downLoadFile(String key, String fileStoreUrl) {
		DownloadFileResponse downloadResponse = new DownloadFileResponse();
		downloadResponse.setDownloadByte(DFSUtils.getForObject(fileStoreUrl, key));
		return downloadResponse;
	}

	/**
	 * 删除文件
	 * 
	 * @param key
	 * @return
	 */
	public DeleteFileResponse delteFile(String key) {
		return delteFile(key, fileStoreUrl);
	}

	public DeleteFileResponse delteFile(String key, String fileStoreUrl) {
		DeleteFileResponse response = new DeleteFileResponse();
		DFSUtils.delete(fileStoreUrl, key);
		return response;
	}

	/**
	 * 管理者后台下载的url
	 * 
	 * @param json
	 * @return
	 */
	public String getManagerDownloadUrl(String json) {
		JSONObject jsonObject = JSONObject.parseObject(json);
		StringBuilder sb = new StringBuilder();
		sb.append(downloadMangerurl);
		if (jsonObject.containsKey("key")) {
			sb.append("?key=" + jsonObject.getString("key"));
		} else if (jsonObject.containsKey("storeKey")) {
			sb.append("?storeKey=" + jsonObject.getString("storeKey"));
		} else {
			return null;
		}
		if (jsonObject.containsKey("fileName")) {
			sb.append("&fileName=" + jsonObject.getString("fileName"));
		} else if (jsonObject.containsKey("oriFileName")) {
			sb.append("&oriFileName=" + jsonObject.getString("oriFileName"));
		}

		if (jsonObject.containsKey("contentType")) {
			sb.append("&contentType=" + jsonObject.getString("contentType"));
		}
		return sb.toString();
	}


}
