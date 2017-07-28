package com.sdp.withdraw.service.impl;

import java.util.Date;
import java.util.Map;

import net.sf.json.JSONObject;

import org.springframework.stereotype.Service;

import com.sdp.mc.common.util.DateUtil;
import com.sdp.withdraw.dao.WithdrawInfoDO;
import com.sdp.withdraw.dao.ext.OpLogRecordVO;
import com.sdp.withdraw.service.BaseService;
import com.sdp.withdraw.service.OpLogRecordService;

@Service("opLogRecordService")
public class OpLogRecordServiceImpl extends BaseService implements OpLogRecordService{

//	@Autowired
//	private WorkCalendarService workCalendarService;


	@Override
	public OpLogRecordVO getOpLogRecordForLastDay(WithdrawInfoDO record,String mcType, int day) {
		// TODO Auto-generated method stub
//		if (!PosMerchantTypeEnums.POS_MERCHANT.code.equals(mcType)){
//			boolean isHoliday = workCalendarService.isHolidayTime(DateUtil.increaseDate(new Date(), day));
//			if (isHoliday) {
//				day--;
//				return getOpLogRecordForLastDay(record,mcType, day);
//			}
//		}
		Date createDay = DateUtil.increaseDate(new Date(), day);
		Date endDay = DateUtil.increaseDate(new Date(), -1);
		OpLogRecordVO log = beanMapper.map(record, OpLogRecordVO.class);
		log.setBeginTime(DateUtil.getCurrentDayStrFristTime(createDay));
		log.setEndTime(DateUtil.getCurrentDayStrEndTime(endDay));
		return log;
	}


	@Override
	public boolean createOpLogRecord(Map<String, Object> map, String recordType, String opType) {
		String json=JSONObject.fromObject(map).toString();
		return insertOpLogRecord(json, recordType, opType);
	}
}
