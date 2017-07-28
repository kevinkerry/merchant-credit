package com.sdp.mc.easypay.vo;

import java.io.Serializable;
import java.util.List;

public class EnterpriseAccountQueryResponse implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Long totalCount;

	private Integer pageNo;

	private Integer pageSize;

	private List<EnterpriseAccountVo> list;

	public Long getTotalCount() {
		return totalCount;
	}

	public void setTotalCount(Long totalCount) {
		this.totalCount = totalCount;
	}

	public Integer getPageNo() {
		return pageNo;
	}

	public void setPageNo(Integer pageNo) {
		this.pageNo = pageNo;
	}

	public Integer getPageSize() {
		return pageSize;
	}

	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}

	public List<EnterpriseAccountVo> getList() {
		return list;
	}

	public void setList(List<EnterpriseAccountVo> list) {
		this.list = list;
	}

}
