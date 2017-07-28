package com.shengpay.service.workcalendar;

import java.util.Date;
import java.util.List;

import org.slf4j.Logger;import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sdp.mc.common.enums.withdraw.WorkDayTypeEnums;
import com.sdp.mc.common.util.DateUtil;
import com.sdp.withdraw.dao.WorkCalendarDO;
import com.sdp.withdraw.dao.WorkCalendarDOExample;
import com.sdp.withdraw.manager.WorkCalendarManager;


@Service("workCalendarService")
public class WorkCalendarServiceImpl implements WorkCalendarService{
	private static final Logger logger = LoggerFactory.getLogger(WorkCalendarServiceImpl.class);

	@Autowired
	private WorkCalendarManager workCalendarManager;

	@Override
	public boolean isHolidayTime(Date time) {
		// TODO Auto-generated method stub
		String wordDateStr = DateUtil.getCurrentDayStrFristTime(time);
		Date wordDate = DateUtil.parseDate(wordDateStr, DateUtil.default_pattern);
		WorkCalendarDOExample example = new WorkCalendarDOExample();
		WorkCalendarDOExample.Criteria criteria = example.createCriteria();
		criteria.andWordDateEqualTo(wordDate);
		List<WorkCalendarDO> list = workCalendarManager.selectByExample(example);
		if (list == null || list.isEmpty()) {
			logger.error("根据 ["+time+"] 查询是否是工作日为空");
			return false;
		}
		if(WorkDayTypeEnums.HOLIDAY.code == list.get(0).getIsHoliday()) {
			return true;
		}else if (WorkDayTypeEnums.UN_HOLIDAY.code == list.get(0).getIsHoliday()) {
			return false;
		}
		return false;
	}


	@Override
	public List<WorkCalendarDO> findWorkTimelist(Date beginDate,Date endDate) {
		// TODO Auto-generated method stub
		WorkCalendarDOExample workexample = new WorkCalendarDOExample();
		WorkCalendarDOExample.Criteria criteria = workexample.createCriteria();
		String beginDateStr = DateUtil.getCurrentDayStrFristTime(beginDate);
		Date begin = DateUtil.parseDate(beginDateStr, DateUtil.default_pattern);

		String endDateStr = DateUtil.getCurrentDayStrFristTime(endDate);
		Date end = DateUtil.parseDate(endDateStr, DateUtil.default_pattern);

		criteria.andWordDateBetween(begin, end);
		return workCalendarManager.selectByExample(workexample);
	}
}
