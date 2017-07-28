package com.sdp.withdraw.service;

import java.util.Map;

import com.sdp.withdraw.dao.WithdrawInfoDO;
import com.sdp.withdraw.dao.ext.OpLogRecordVO;


public interface OpLogRecordService {

	/**
	 * 查询节假日前的工作日记录
	 * @param record
	 * @param day
	 * @return
	 */
	OpLogRecordVO getOpLogRecordForLastDay(WithdrawInfoDO record,String mcType,int day);

	boolean createOpLogRecord(Map<String, Object> map, String recordType, String opType);
}
