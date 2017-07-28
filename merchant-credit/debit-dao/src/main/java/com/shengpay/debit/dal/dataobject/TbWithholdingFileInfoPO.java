package com.shengpay.debit.dal.dataobject;

import java.io.Serializable;
import java.util.Date;

public class TbWithholdingFileInfoPO implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * DECIMAL(18) 必填<br>
     * ID
     */
    private Long id;

    /**
     * VARCHAR(100)<br>
     * 批次号
     */
    private String batchNo;

    /**
     * VARCHAR(200)<br>
     * 文件名称
     */
    private String fileName;

    /**
     * VARCHAR(500)<br>
     * 文件路径
     */
    private String filePath;

    /**
     * VARCHAR(100)<br>
     * 文件类型（0请求文件 1 结果文件）
     */
    private String fileType;

    /**
     * VARCHAR(500)<br>
     * 小文件对应key
     */
    private String fileKey;

    /**
     * TIMESTAMP(11,6)<br>
     * 创建时间
     */
    private Date createTime;

    /**
     * TIMESTAMP(11,6)<br>
     * 更新时间
     */
    private Date updateTime;

    /**
     * DECIMAL(18) 必填<br>
     * 获得 ID
     */
    public Long getId() {
        return id;
    }

    /**
     * DECIMAL(18) 必填<br>
     * 设置 ID
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * VARCHAR(100)<br>
     * 获得 批次号
     */
    public String getBatchNo() {
        return batchNo;
    }

    /**
     * VARCHAR(100)<br>
     * 设置 批次号
     */
    public void setBatchNo(String batchNo) {
        this.batchNo = batchNo == null ? null : batchNo.trim();
    }

    /**
     * VARCHAR(200)<br>
     * 获得 文件名称
     */
    public String getFileName() {
        return fileName;
    }

    /**
     * VARCHAR(200)<br>
     * 设置 文件名称
     */
    public void setFileName(String fileName) {
        this.fileName = fileName == null ? null : fileName.trim();
    }

    /**
     * VARCHAR(500)<br>
     * 获得 文件路径
     */
    public String getFilePath() {
        return filePath;
    }

    /**
     * VARCHAR(500)<br>
     * 设置 文件路径
     */
    public void setFilePath(String filePath) {
        this.filePath = filePath == null ? null : filePath.trim();
    }

    /**
     * VARCHAR(100)<br>
     * 获得 文件类型（0请求文件 1 结果文件）
     */
    public String getFileType() {
        return fileType;
    }

    /**
     * VARCHAR(100)<br>
     * 设置 文件类型（0请求文件 1 结果文件）
     */
    public void setFileType(String fileType) {
        this.fileType = fileType == null ? null : fileType.trim();
    }

    /**
     * VARCHAR(500)<br>
     * 获得 小文件对应key
     */
    public String getFileKey() {
        return fileKey;
    }

    /**
     * VARCHAR(500)<br>
     * 设置 小文件对应key
     */
    public void setFileKey(String fileKey) {
        this.fileKey = fileKey == null ? null : fileKey.trim();
    }

    /**
     * TIMESTAMP(11,6)<br>
     * 获得 创建时间
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * TIMESTAMP(11,6)<br>
     * 设置 创建时间
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * TIMESTAMP(11,6)<br>
     * 获得 更新时间
     */
    public Date getUpdateTime() {
        return updateTime;
    }

    /**
     * TIMESTAMP(11,6)<br>
     * 设置 更新时间
     */
    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }
}