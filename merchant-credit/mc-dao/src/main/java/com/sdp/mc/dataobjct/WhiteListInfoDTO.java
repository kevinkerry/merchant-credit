package com.sdp.mc.dataobjct;

import java.util.List;

import com.sdp.emall.common.dao.QueryBase;
import com.sdp.mc.newt0.dao.WhiteListInfoDOExample;

public class WhiteListInfoDTO extends QueryBase {

	private static final long serialVersionUID = 1L;

	private WhiteListInfoPO po = new WhiteListInfoPO();
	private WhiteListInfoDOExample example = new WhiteListInfoDOExample();
	private List<WhiteListInfoPO> pageList;
	public WhiteListInfoPO getPo() {
		return po;
	}
	public void setPo(WhiteListInfoPO po) {
		this.po = po;
	}
	public WhiteListInfoDOExample getExample() {
		return example;
	}
	public void setExample(WhiteListInfoDOExample example) {
		this.example = example;
	}
	public List<WhiteListInfoPO> getPageList() {
		return pageList;
	}
	public void setPageList(List<WhiteListInfoPO> pageList) {
		this.pageList = pageList;
	}
	
	
	
	

	

}
