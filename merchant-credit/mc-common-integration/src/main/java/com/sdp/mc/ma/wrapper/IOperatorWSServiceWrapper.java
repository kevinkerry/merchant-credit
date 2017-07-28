package com.sdp.mc.ma.wrapper;

import java.util.List;

import com.sdo.ma.ws.api.model.OperatorInfo;

public interface IOperatorWSServiceWrapper {
	/**
	 * 根据memberId查询下级代理商所有操作员信息
	 * **/
	public List<OperatorInfo> queryOperators(final String memberId);
}
