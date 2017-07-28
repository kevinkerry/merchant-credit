package com.shengpay.debit.ext.daointerface;

import com.shengpay.debit.daointerface.DoTransferLogDAO;

public interface ExtDoTransferLogDAO extends DoTransferLogDAO {
	/**
	 * 更新响应log
	 * **/
	public boolean updateResponseLog(Long id, String responseLog);
	/**
	 * 更新状态
	 * **/
	public boolean updateInit2ResponseLogAndStatus(Long id, String status, String responseLog);
	/**
	 * 根据bizId、bizType查询一条唯一的转账日志用作判断是否有[转账中]的记录
	 * **/
	public boolean hasTransferingRecord(String bizId, String bizType);
	/**
	 * 根据bizId、bizType查询一条唯一的转账日志用作判断是否有[转账成功]的记录
	 * **/
	public boolean hasSucceedTransferedRecord(String bizId, String bizType);
}
