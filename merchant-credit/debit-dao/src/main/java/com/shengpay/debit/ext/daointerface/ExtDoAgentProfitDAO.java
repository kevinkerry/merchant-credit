package com.shengpay.debit.ext.daointerface;

import java.util.List;

import com.shengpay.debit.dal.ext.dataobject.AgentProfitDTO;
import com.shengpay.debit.dal.ext.dataobject.ExtDoAgentProfitExample;
import com.shengpay.debit.daointerface.DoAgentProfitDAO;

public interface ExtDoAgentProfitDAO extends DoAgentProfitDAO {

	public List<AgentProfitDTO> pageQueryAgentProfit(ExtDoAgentProfitExample example);
	/**
	 * **/
	public boolean update2TargetStatusByBorrowOrderId(long borrowOrderId,String originalStatus,String targetStatus);

}
