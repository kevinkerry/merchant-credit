package com.sdp.mc.easypay.vo;

import java.io.Serializable;
import java.util.List;

public class BussinessChildrensListsVo implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -2440484786488602327L;
	private List<BussinessChildrensListVo> list;

	public List<BussinessChildrensListVo> getList() {
		return list;
	}

	public void setList(List<BussinessChildrensListVo> list) {
		this.list = list;
	}

}
