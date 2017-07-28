package com.shengpay.service.fileManager;

import org.springframework.web.multipart.support.DefaultMultipartHttpServletRequest;

import com.shengpay.model.fileManager.DeleteFileResponse;
import com.shengpay.model.fileManager.DownloadFileResponse;
import com.shengpay.model.fileManager.UploadFileResponse;

/**
 * 文件上传下载处理器
 * @author heyi.alex
 *
 */
public interface FileManagerService {

	/**
	 * 文件上传
	 * @param request
	 * @return
	 */
	public UploadFileResponse uploadFile(DefaultMultipartHttpServletRequest request, String fileFiled);
	
	public UploadFileResponse uploadFile(DefaultMultipartHttpServletRequest request,String fileStoreUrl, String fileFiled);


	/**
	 * 文件下载
	 * @param key
	 * @return
	 */
	public DownloadFileResponse downLoadFile(String key);
	
	public DownloadFileResponse downLoadFile(String key, String fileStoreUrl);


	/**
	 * 文件删除
	 * @param key
	 * @return
	 */
	public DeleteFileResponse delteFile(String key);
	
	public DeleteFileResponse delteFile(String key, String fileStoreUrl);

	/**
	 * 管理者后台下载的url
	 * @param json
	 * @return
	 */
	public String getManagerDownloadUrl(String json);

}
