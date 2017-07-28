package com.shengpay.debit.ext.daointerface;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.shengpay.debit.dal.dataobject.DoAgentProfitExample;
import com.shengpay.debit.dal.dataobject.DoAgentProfitPO;
import com.shengpay.debit.dal.ext.dataobject.AgentProfitDTO;
import com.shengpay.debit.dal.ext.dataobject.ExtDoAgentProfitExample;
import com.shengpay.debit.daointerface.DoAgentProfitDAOImpl;

public class ExtDoAgentProfitDAOImpl extends DoAgentProfitDAOImpl implements ExtDoAgentProfitDAO {

	public List<AgentProfitDTO> pageQueryAgentProfit(ExtDoAgentProfitExample example) {
		Integer count = (Integer) getSqlMapClientTemplate().queryForObject("DO_AGENT_PROFIT.pageQueryAgentProfit_count", example);
		example.setTotalItem(count);
		if (example.isNeedQueryAll() && count > 0) {
			example.setPageSize(count);
		}
		List<AgentProfitDTO> agentProfitList = new ArrayList<AgentProfitDTO>();
		if (example.getPageFristItem() <= example.getTotalItem()) {
			@SuppressWarnings("unchecked")
			List<AgentProfitDTO> list = getSqlMapClientTemplate().queryForList("DO_AGENT_PROFIT.pageQueryAgentProfit", example);
			agentProfitList.addAll(list);
		}
		return agentProfitList;
	}

	public boolean update2TargetStatusByBorrowOrderId(long borrowOrderId, String originalStatus, String targetStatus) {
		DoAgentProfitPO record = new DoAgentProfitPO();
		record.setStatus(targetStatus);
		record.setUpdateTime(new Date());
		DoAgentProfitExample example = new DoAgentProfitExample();
		example.createCriteria().andBorrowOrderIdEqualTo(borrowOrderId+"").andStatusEqualTo(originalStatus);
		int rows = this.updateByExampleSelective(record, example);
		return rows == 1;
	}

}
