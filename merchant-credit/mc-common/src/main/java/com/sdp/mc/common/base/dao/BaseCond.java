package com.sdp.mc.common.base.dao;



/**
 * 基本查询条件，用于分页
 * @author liuxi.xiliu
 */
public class BaseCond{
	protected Integer pageSize = 10;
	
	protected Integer pageNo = 1;

	public Integer getPageSize() {
		return pageSize;
	}

	public void setPageSize(Integer pageSize) {
		if( pageSize > 100 ){
			this.pageSize = 100;
		}else if( pageSize < 1 ){
			this.pageSize = 10;
		}else{
			this.pageSize = pageSize;
		}
	}

	/**
	 * 按传入的值来设置页大小
	 * @param pageSize
	 */
	public void setPageSizeByValue(Integer pageSize ) {
		this.pageSize = pageSize;
	}
	
	public Integer getPageNo() {
		return pageNo;
	}

	public void setPageNo(Integer pageNo) {
		this.pageNo = pageNo < 1? 1 : pageNo;
	}
	
}
