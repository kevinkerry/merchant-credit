package com.shengpay.model.fileManager;

/**
 * 上传响应
 * @author heyi.alex
 *
 */
public class UploadFileResponse {

	/**
	 * 小文件系统存储的url
	 */
	private String storeKey = "";

	/**
	 * 是否上传成功
	 */
	private boolean isUploadSuccess;

	/**
	 * 文件长度
	 */
	private long fileSize= 0l;

	/**
	 * 文件类型
	 */
	private String contentType = "";

	/**
	 * 用户上传文件名称
	 */
	private String oriFileName = "";

	/**
	 * 上传信息验证
	 */
	private String msg = "";

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public boolean isUploadSuccess() {
		return isUploadSuccess;
	}

	public void setUploadSuccess(boolean isUploadSuccess) {
		this.isUploadSuccess = isUploadSuccess;
	}

	public long getFileSize() {
		return fileSize;
	}

	public void setFileSize(long fileSize) {
		this.fileSize = fileSize;
	}

	public String getContentType() {
		return contentType;
	}

	public void setContentType(String contentType) {
		this.contentType = contentType;
	}

	public String getOriFileName() {
		return oriFileName;
	}

	public void setOriFileName(String oriFileName) {
		this.oriFileName = oriFileName;
	}

	public String getStoreKey() {
		return storeKey;
	}

	public void setStoreKey(String storeKey) {
		this.storeKey = storeKey;
	}

	@Override
	public String toString() {
		return "UploadFileResponse [storeKey=" + storeKey
				+ ", isUploadSuccess=" + isUploadSuccess + ", fileSize="
				+ fileSize + ", contentType=" + contentType + ", oriFileName="
				+ oriFileName + "]";
	}
}
