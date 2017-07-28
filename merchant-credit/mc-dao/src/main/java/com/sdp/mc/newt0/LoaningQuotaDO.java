package com.sdp.mc.newt0;

import java.util.Date;

import com.sdp.emall.common.dao.QueryBase;

/**
 * 垫资额度
 * @author wangmindong
 *
 */
public class LoaningQuotaDO extends QueryBase {

	private static final long serialVersionUID = 1L;
	
	private Long id;
	private String fileDate;
	private Long quota;
	private Date createTime;
	private Date updateTime;
	
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getFileDate() {
		return fileDate;
	}
	public void setFileDate(String fileDate) {
		this.fileDate = fileDate;
	}
	
	public Long getQuota() {
		return quota;
	}
	public void setQuota(Long quota) {
		this.quota = quota;
	}
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	public Date getUpdateTime() {
		return updateTime;
	}
	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}
	
}
