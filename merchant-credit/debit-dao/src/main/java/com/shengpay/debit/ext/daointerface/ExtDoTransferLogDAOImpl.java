package com.shengpay.debit.ext.daointerface;

import java.util.Date;
import java.util.List;

import com.sdp.mc.common.enums.FosPaymentStateEnums;
import com.shengpay.debit.dal.dataobject.DoTransferLogExample;
import com.shengpay.debit.dal.dataobject.DoTransferLogPO;
import com.shengpay.debit.daointerface.DoTransferLogDAOImpl;

public class ExtDoTransferLogDAOImpl extends DoTransferLogDAOImpl implements ExtDoTransferLogDAO {

	/**
	 * 更新响应log
	 * **/
	public boolean updateResponseLog(Long id, String responseLog) {
		DoTransferLogPO record = new DoTransferLogPO();
		record.setResponseLog(responseLog);
		record.setUpdateTime(new Date());
		DoTransferLogExample example = new DoTransferLogExample();
		example.createCriteria().andIdEqualTo(id).andStatusEqualTo("INIT");
		int rows = this.updateByExampleSelective(record, example);
		return rows == 1;
	}
	/**
	 * 更新状态和响应日志
	 * **/
	public boolean updateInit2ResponseLogAndStatus(Long id, String status, String responseLog) {
		DoTransferLogPO record = new DoTransferLogPO();
		record.setStatus(status);
		record.setResponseLog(responseLog);
		record.setUpdateTime(new Date());
		DoTransferLogExample example = new DoTransferLogExample();
		example.createCriteria().andIdEqualTo(id).andStatusEqualTo("INIT");
		int rows = this.updateByExampleSelective(record, example);
		return rows == 1;
	}

	/**
	 * 根据bizId、bizType查询一条唯一的转账日志用作判断是否有[转账中]的记录
	 * **/
	public boolean hasTransferingRecord(String bizId, String bizType) {
		DoTransferLogExample example = new DoTransferLogExample();
		example.createCriteria().andOrderIdEqualTo(bizId).andOrderTypeEqualTo(bizType).andStatusEqualTo(FosPaymentStateEnums.P.code);
		List<DoTransferLogPO> transferLogList = this.selectByExample(example);
		return transferLogList != null && transferLogList.size() > 0;
	}
	
	/**
	 * 根据bizId、bizType查询一条唯一的转账日志用作判断是否有[转账成功]的记录
	 * **/
	public boolean hasSucceedTransferedRecord(String bizId, String bizType) {
		DoTransferLogExample example = new DoTransferLogExample();
		example.createCriteria().andOrderIdEqualTo(bizId).andOrderTypeEqualTo(bizType).andStatusEqualTo(FosPaymentStateEnums.S.code);
		List<DoTransferLogPO> transferLogList = this.selectByExample(example);
		return transferLogList != null && transferLogList.size() > 0;
	}

}
